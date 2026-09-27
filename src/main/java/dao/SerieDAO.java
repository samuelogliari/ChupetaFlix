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
 * @author samuc
 */
public class SerieDAO {

    private static final String SQL_SALVAR
            = "INSERT INTO series "
            + "(titulo, genero, ano_lancamento, temporadas, episodios, produtora) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_RECUPERAR_TODOS
            = "SELECT id, titulo, genero, ano_lancamento, temporadas, episodios, produtora "
            + "FROM series";

    private static final String SQL_RECUPERAR_UM
            = "SELECT id, titulo, genero, ano_lancamento, temporadas, episodios, produtora "
            + "FROM series WHERE id=?";

    private static final String SQL_EDITAR
            = "UPDATE series SET "
            + "titulo = ?, genero = ?, ano_lancamento = ?, temporadas = ?, "
            + "episodios = ?, produtora = ? "
            + "WHERE id = ?";

    private static final String SQL_EXCLUIR
            = "DELETE FROM series WHERE id = ?";

    public void salvar(Serie serie) throws SQLException {
        String sql = SQL_SALVAR;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, serie.getTitulo());
            comando.setString(2, serie.getGenero());
            comando.setInt(3, serie.getAnoLancamento());
            comando.setInt(4, serie.getTemporadas());
            comando.setInt(5, serie.getEpisodios());
            comando.setString(6, serie.getProdutora());

            comando.executeUpdate();
        }
    }

    public ArrayList<Serie> recuperarTodos() throws SQLException {
        String sql = SQL_RECUPERAR_TODOS;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql); ResultSet resultado = comando.executeQuery()) {

            ArrayList<Serie> series = new ArrayList<>();

            while (resultado.next()) {
                Serie serie = mapearSerie(resultado);
                series.add(serie);
            }

            return series;
        }
    }

    public Serie recuperarUm(int codigo) throws SQLException {
        String sql = SQL_RECUPERAR_UM;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, codigo);

            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    Serie serie = mapearSerie(resultado);
                    return serie;
                }
            }
        }

        return null;
    }

    public void editar(Serie serie) throws SQLException {
        String sql = SQL_EDITAR;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

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

    public void excluir(int codigo) throws SQLException {
        String sql = SQL_EXCLUIR;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

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
