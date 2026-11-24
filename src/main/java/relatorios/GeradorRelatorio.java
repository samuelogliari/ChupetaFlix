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

    public static void gerar() throws Exception {

        InputStream arquivo = GeradorRelatorio.class
                .getResourceAsStream("/relatorios/RelatorioFilmes.jrxml");

        if (arquivo == null) {
            throw new Exception(
                    "Relatório RelatorioFilmes.jrxml não encontrado!"
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

            // Cria a pasta onde o PDF será salvo
            File pasta = new File("relatorios");
            pasta.mkdirs();

            // Define o arquivo PDF
            File pdf = new File(pasta, "RelatorioFilmes.pdf");

            // Exporta o relatório
            JasperExportManager.exportReportToPdfFile(
                    resultado,
                    pdf.getAbsolutePath()
            );

            // Abre o PDF automaticamente
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdf);
            }
        }
    }
}
