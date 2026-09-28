/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import banco.Conexao;
import entidades.Elenco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAUDE
 */
public class ElencoDAO {

    private static final String SQL_SALVAR
            = "INSERT INTO elenco "
            + "(nome, nacionalidade, dt_nascimento) "
            + "VALUES (?, ?, ?)";

    private static final String SQL_RECUPERAR_TODOS
            = "SELECT id, nome, nacionalidade, dt_nascimento "
            + "FROM elenco";

    private static final String SQL_RECUPERAR_UM
            = "SELECT id, nome, nacionalidade, dt_nascimento "
            + "FROM elenco WHERE id=?";

    private static final String SQL_EDITAR
            = "UPDATE elenco SET "
            + "nome = ?, nacionalidade = ?, dt_nascimento = ? "
            + "WHERE id = ?";

    private static final String SQL_EXCLUIR
            = "DELETE FROM elenco WHERE id = ?";

    public void salvar(Elenco elenco) throws SQLException {
        String sql = SQL_SALVAR;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, elenco.getNome());
            comando.setString(2, elenco.getNacionalidade());
            comando.setDate(3, Date.valueOf(elenco.getDtNascimento()));

            comando.executeUpdate();
        }
    }

    public ArrayList<Elenco> recuperarTodos() throws SQLException {
        String sql = SQL_RECUPERAR_TODOS;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql); ResultSet resultado = comando.executeQuery()) {

            ArrayList<Elenco> elenco = new ArrayList<>();

            while (resultado.next()) {
                Elenco integrante = mapearElenco(resultado);
                elenco.add(integrante);
            }
            return elenco;
        }
    }

    public Elenco recuperarUm(int codigo) throws SQLException {
        String sql = SQL_RECUPERAR_UM;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, codigo);
            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    Elenco integrante = mapearElenco(resultado);
                    return integrante;
                }
            }
        }
        return null;
    }

    public void editar(Elenco elenco) throws SQLException {
        String sql = SQL_EDITAR;
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, elenco.getNome());
            comando.setString(2, elenco.getNacionalidade());
            comando.setDate(3, Date.valueOf(elenco.getDtNascimento()));
            comando.setInt(4, elenco.getCodigo());

            comando.executeUpdate();
        }
    }

    public void excluir(int codigo) throws SQLException {
        String sql = SQL_EXCLUIR;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, codigo);
            comando.executeUpdate();
        }
    }

    private Elenco mapearElenco(ResultSet resultado) throws SQLException {
        Elenco elenco = new Elenco(
                resultado.getString("nome"),
                resultado.getString("nacionalidade"),
                resultado.getDate("dt_nascimento").toLocalDate()
        );
        elenco.setCodigo(resultado.getInt("id"));
        return elenco;
    }
}
