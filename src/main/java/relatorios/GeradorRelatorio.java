/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package relatorios;

import banco.Conexao;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperReport;

public class GeradorRelatorio {

    public static void gerar(String nomeRelatorio) throws Exception {

        InputStream arquivo = GeradorRelatorio.class
                .getResourceAsStream("/relatorios/" + nomeRelatorio + ".jrxml");

        if (arquivo == null) {
            throw new Exception(
                    "Relatório " + nomeRelatorio + " não encontrado!"
            );
        }

        try (Connection conexao = Conexao.conectar();
             InputStream jrxml = arquivo) {

            JasperReport relatorio = JasperCompileManager
                    .compileReport(jrxml);

            JasperPrint resultado = JasperFillManager.fillReport(
                    relatorio,
                    new HashMap<>(),
                    conexao
            );

            File pasta = new File("relatorios");
            pasta.mkdirs();

            File pdf = new File(
                    pasta,
                    nomeRelatorio + ".pdf"
            );

            JasperExportManager.exportReportToPdfFile(
                    resultado,
                    pdf.getAbsolutePath()
            );

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdf);
            }
        }
    }
}
