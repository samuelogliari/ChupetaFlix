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
public class FilmeElencoDAO {

    public void adicionar(int filmeId, int elencoId) throws SQLException {
        String sql = "INSERT INTO filme_elenco (filme_id, elenco_id) VALUES (?, ?)";
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, filmeId);
            comando.setInt(2, elencoId);

            comando.executeUpdate();
        }
    }

    public void remover(int filmeId, int elencoId) throws SQLException {
        String sql = "DELETE FROM filme_elenco "
                + "WHERE filme_id = ? AND elenco_id = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, filmeId);
            comando.setInt(2, elencoId);

            comando.executeUpdate();
        }
    }

    public ArrayList<Elenco> listarPorFilme(int filmeId) throws SQLException {
        String sql = "SELECT e.id, e.nome, e.nacionalidade, e.dt_nascimento "
                + "FROM elenco e "
                + "INNER JOIN filme_elenco fe on e.id = fe.elenco_id "
                + "WHERE fe.filme_id = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, filmeId);

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
