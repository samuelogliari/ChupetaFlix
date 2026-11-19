/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.File;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SAUDE
 */
public class Conexao {

    private static Dotenv carregarEnv() {
        try {
            File local = new File(
                    Conexao.class.getProtectionDomain()
                            .getCodeSource()
                            .getLocation().toURI()
            );
            if (local.isFile()) {
                return Dotenv.configure()
                        .directory(local.getParent())
                        .filename("chupetaflix.env")
                        .load();
            }
            File pastaProjeto = new File(".").getAbsoluteFile();

            return Dotenv.configure()
                    .directory(pastaProjeto.getPath())
                    .filename("chupetaflix.env")
                    .load();

        } catch (URISyntaxException e) {
            throw new RuntimeException("Erro ao localizar o arquivo .env", e);
        }
    }

    private static final Dotenv dotenv = carregarEnv();

    private static final String URL
            = "jdbc:postgresql://localhost:5432/chupetaflix";

    private static final String USUARIO = dotenv.get("POSTGRES_USER");
    private static final String SENHA = dotenv.get("POSTGRES_PASSWORD");

    public static Connection conectar() throws SQLException {

        if (USUARIO == null || SENHA == null) {
            throw new IllegalStateException(
                    "POSTGRES_USER ou POSTGRES_PASSWORD não encontrados no arquivo chupetaflix.env"
            );
        }

        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
