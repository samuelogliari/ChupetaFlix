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
public class AnimeElencoDAO {
    public void adicionar(int animeId, int elencoId) throws SQLException {
        String sql = "INSERT INTO anime_elenco (anime_id, elenco_id) VALUES (?, ?)";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, animeId);
            comando.setInt(2, elencoId);

            comando.executeUpdate();
        }
    }

    public void remover(int animeId, int elencoId) throws SQLException {
        String sql = "DELETE FROM anime_elenco "
                + "WHERE anime_id = ? AND elenco_id = ?";
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, animeId);
            comando.setInt(2, elencoId);

            comando.executeUpdate();
        }
    }
    
    public ArrayList<Elenco> listarPorAnime(int animeId) throws SQLException {
        String sql = "SELECT e.id, e.nome, e.nacionalidade, e.dt_nascimento "
                + "FROM elenco e "
                + "INNER JOIN anime_elenco ae ON e.id = ae.elenco_id "
                + "WHERE ae.anime_id = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, animeId);
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
