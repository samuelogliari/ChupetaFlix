/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import banco.Conexao;
import entidades.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAUDE
 */
public class FilmeDAO {

    private static final String SQL_SALVAR
            = "INSERT INTO filmes "
            + "(titulo, genero, ano_lancamento, diretor, duracao, classificacao) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_RECUPERAR_TODOS
            = "SELECT id, titulo, genero, ano_lancamento, diretor, duracao, classificacao "
            + "FROM filmes";

    private static final String SQL_RECUPERAR_UM
            = "SELECT id, titulo, genero, ano_lancamento, diretor, duracao, classificacao "
            + "FROM filmes WHERE id=?";

    private static final String SQL_EDITAR
            = "UPDATE filmes SET "
            + "titulo = ?, genero = ?, ano_lancamento = ?, diretor = ?, "
            + "duracao = ?, classificacao = ? "
            + "WHERE id = ?";

    private static final String SQL_EXCLUIR
            = "DELETE FROM filmes WHERE id = ?";

    public void salvar(Filme filme) throws SQLException {

        String sql = SQL_SALVAR;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, filme.getTitulo());
            comando.setString(2, filme.getGenero());
            comando.setInt(3, filme.getAnoLancamento());
            comando.setString(4, filme.getDiretor());
            comando.setInt(5, filme.getDuracao());
            comando.setString(6, filme.getClassificacao());

            comando.executeUpdate();
        }
    }

    public ArrayList<Filme> recuperarTodos() throws SQLException {

        String sql = SQL_RECUPERAR_TODOS;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql); ResultSet resultado = comando.executeQuery()) {

            ArrayList<Filme> filmes = new ArrayList<>();
            while (resultado.next()) {

               Filme filme = mapearFilme(resultado);
               filmes.add(filme);
            }

            return filmes;
        }
    }

    public Filme recuperarUm(int codigo) throws SQLException {
        String sql = SQL_RECUPERAR_UM;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, codigo);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {
          Filme filme = mapearFilme(resultado);
          return filme;
                }
            }
        }
        return null;
    }

    public void editar(Filme filme) throws SQLException {

        String sql = SQL_EDITAR;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, filme.getTitulo());
            comando.setString(2, filme.getGenero());
            comando.setInt(3, filme.getAnoLancamento());
            comando.setString(4, filme.getDiretor());
            comando.setInt(5, filme.getDuracao());
            comando.setString(6, filme.getClassificacao());
            comando.setInt(7, filme.getCodigo());

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

    private Filme mapearFilme(ResultSet resultado) throws SQLException {
        Filme filme = new Filme(
                resultado.getString("titulo"),
                resultado.getString("genero"),
                resultado.getString("diretor"),
                resultado.getInt("duracao"),
                resultado.getString("classificacao"),
                resultado.getInt("ano_lancamento")
        );
        filme.setCodigo(resultado.getInt("id"));

        return filme;
    }
}
