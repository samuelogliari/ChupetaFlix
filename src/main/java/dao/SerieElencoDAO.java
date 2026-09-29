/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import banco.Conexao;
import entidades.Elenco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuc
 */
public class SerieElencoDAO {
    public void adicionar(int serieId, int elencoId) throws SQLException {
        String sql = "INSERT INTO serie_elenco (serie_id, elenco_id) VALUES (?, ?)";

        try (Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, serieId);
            comando.setInt(2, elencoId);

            comando.executeUpdate();
        }
    }

    public void remover(int serieId, int elencoId) throws SQLException {
        String sql = "DELETE FROM serie_elenco "
                + "WHERE serie_id = ? AND elenco_id = ?";

        try (Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, serieId);
            comando.setInt(2, elencoId);

            comando.executeUpdate();
        }
    }

    public ArrayList<Elenco> listarPorSerie(int serieId) throws SQLException {
        String sql = "SELECT e.id, e.nome, e.nacionalidade, e.dt_nascimento "
                + "FROM elenco e "
                + "INNER JOIN serie_elenco se ON e.id = se.elenco_id "
                + "WHERE se.serie_id = ?";

        try (Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, serieId);

            try (ResultSet resultado = comando.executeQuery()) {
                ArrayList<Elenco> integrantes = new ArrayList<>();

                while (resultado.next()) {
                    Elenco elenco = new Elenco(
                            resultado.getString("nome"),
                            resultado.getString("nacionalidade"),
                            resultado.getDate("dt_nascimento").toLocalDate()
                    );

                    elenco.setCodigo(resultado.getInt("id"));
                    integrantes.add(elenco);
                }

                return integrantes;
            }
        }
    }
}
