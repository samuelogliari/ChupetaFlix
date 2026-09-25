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

        Connection conexao = Conexao.conectar();

        PreparedStatement comando = conexao.prepareStatement(sql);

        comando.setString(1, filme.getTitulo());
        comando.setString(2, filme.getGenero());
        comando.setInt(3, filme.getAnoLancamento());
        comando.setString(4, filme.getDiretor());
        comando.setInt(5, filme.getDuracao());
        comando.setString(6, filme.getClassificacao());

        comando.executeUpdate();

        comando.close();
        conexao.close();

    }

    public ArrayList<Filme> recuperarTodos() throws SQLException {

        String sql = SQL_RECUPERAR_TODOS;

        Connection conexao = Conexao.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql);
        ResultSet resultado = comando.executeQuery();

        ArrayList<Filme> filmes = new ArrayList<>();
        while (resultado.next()) {

            Filme filme = new Filme(
                    resultado.getString("titulo"),
                    resultado.getString("genero"),
                    resultado.getString("diretor"),
                    resultado.getInt("duracao"),
                    resultado.getString("classificacao"),
                    resultado.getInt("ano_lancamento")
            );
            filme.setCodigo(resultado.getInt("id"));
            filmes.add(filme);
        }

        resultado.close();
        comando.close();
        conexao.close();

        return filmes;
    }

    public Filme recuperarUm(int codigo) throws SQLException {
        String sql = SQL_RECUPERAR_UM;

        Connection conexao = Conexao.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql);

        comando.setInt(1, codigo);

        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
            Filme filme = new Filme(
                    resultado.getString("titulo"),
                    resultado.getString("genero"),
                    resultado.getString("diretor"),
                    resultado.getInt("duracao"),
                    resultado.getString("classificacao"),
                    resultado.getInt("ano_lancamento")
            );

            filme.setCodigo(resultado.getInt("id"));

            resultado.close();
            comando.close();
            conexao.close();

            return filme;
        }
        resultado.close();
        comando.close();
        conexao.close();

        return null;
    }

    public void editar(Filme filme) throws SQLException {

        String sql = SQL_EDITAR;

        Connection conexao = Conexao.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql);

        comando.setString(1, filme.getTitulo());
        comando.setString(2, filme.getGenero());
        comando.setInt(3, filme.getAnoLancamento());
        comando.setString(4, filme.getDiretor());
        comando.setInt(5, filme.getDuracao());
        comando.setString(6, filme.getClassificacao());
        comando.setInt(7, filme.getCodigo());

        comando.executeUpdate();

        comando.close();
        conexao.close();
    }

    public void excluir(int codigo) throws SQLException {
        String sql = SQL_EXCLUIR;

        Connection conexao = Conexao.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setInt(1, codigo);
        comando.executeUpdate();
        comando.close();
        conexao.close();
    }
}
