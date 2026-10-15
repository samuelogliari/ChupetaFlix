/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import banco.Conexao;
import entidades.Serie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuel.ogliari
 */
public class SerieDAOjdbc implements SerieDAO {

    private static final String SQL_SALVAR
            = "INSERT INTO series "
            + "(titulo, genero, ano_lancamento, temporadas, episodios, produtora) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_RECUPERAR_TODOS
            = "SELECT id, titulo, genero, ano_lancamento, temporadas, episodios, produtora "
            + "FROM series";

    private static final String SQL_RECUPERAR_UM
            = "SELECT id, titulo, genero, ano_lancamento, temporadas, episodios, produtora "
            + "FROM series WHERE id = ?";

    private static final String SQL_EDITAR
            = "UPDATE series SET "
            + "titulo = ?, genero = ?, ano_lancamento = ?, temporadas = ?, "
            + "episodios = ?, produtora = ? "
            + "WHERE id = ?";

    private static final String SQL_EXCLUIR
            = "DELETE FROM series WHERE id = ?";

    @Override
    public void salvar(Serie serie) throws SQLException {
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(SQL_SALVAR)) {

            comando.setString(1, serie.getTitulo());
            comando.setString(2, serie.getGenero());
            comando.setInt(3, serie.getAnoLancamento());
            comando.setInt(4, serie.getTemporadas());
            comando.setInt(5, serie.getEpisodios());
            comando.setString(6, serie.getProdutora());

            comando.executeUpdate();
        }
    }

    @Override
    public ArrayList<Serie> recuperarTodos() throws SQLException {
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(SQL_RECUPERAR_TODOS); ResultSet resultado = comando.executeQuery()) {

            ArrayList<Serie> series = new ArrayList<>();

            while (resultado.next()) {
                series.add(mapearSerie(resultado));
            }

            return series;
        }
    }

    @Override
    public Serie recuperarUm(int codigo) throws SQLException {
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(SQL_RECUPERAR_UM)) {

            comando.setInt(1, codigo);

            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    return mapearSerie(resultado);
                }
            }
        }

        return null;
    }

    @Override
    public void editar(Serie serie) throws SQLException {
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(SQL_EDITAR)) {

            comando.setString(1, serie.getTitulo());
            comando.setString(2, serie.getGenero());
            comando.setInt(3, serie.getAnoLancamento());
            comando.setInt(4, serie.getTemporadas());
            comando.setInt(5, serie.getEpisodios());
            comando.setString(6, serie.getProdutora());
            comando.setInt(7, serie.getCodigo());

            comando.executeUpdate();
        }
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(SQL_EXCLUIR)) {

            comando.setInt(1, codigo);
            comando.executeUpdate();
        }
    }

    private Serie mapearSerie(ResultSet resultado) throws SQLException {
        Serie serie = new Serie(
                resultado.getString("titulo"),
                resultado.getString("genero"),
                resultado.getInt("temporadas"),
                resultado.getInt("episodios"),
                resultado.getString("produtora"),
                resultado.getInt("ano_lancamento")
        );

        serie.setCodigo(resultado.getInt("id"));
        return serie;
    }
}
