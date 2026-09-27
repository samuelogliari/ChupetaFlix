/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import banco.Conexao;
import entidades.Anime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author samuc
 */
public class AnimeDAO {
    private static final String SQL_SALVAR
            = "INSERT INTO animes "
            + "(titulo, genero, ano_lancamento, estudio, tem_manga, dublado) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_RECUPERAR_TODOS
            = "SELECT id, titulo, genero, ano_lancamento, estudio, tem_manga, dublado "
            + "FROM animes";

    private static final String SQL_RECUPERAR_UM
            = "SELECT id, titulo, genero, ano_lancamento, estudio, tem_manga, dublado "
            + "FROM animes WHERE id=?";

    private static final String SQL_EDITAR
            = "UPDATE animes SET "
            + "titulo = ?, genero = ?, ano_lancamento = ?, estudio = ?, "
            + "tem_manga = ?, dublado = ? "
            + "WHERE id = ?";

    private static final String SQL_EXCLUIR
            = "DELETE FROM animes WHERE id = ?";

    public void salvar(Anime anime) throws SQLException {
        String sql = SQL_SALVAR;

        try (Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, anime.getTitulo());
            comando.setString(2, anime.getGenero());
            comando.setInt(3, anime.getAnoLancamento());
            comando.setString(4, anime.getEstudio());
            comando.setBoolean(5, anime.isTemManga());
            comando.setBoolean(6, anime.isDublado());

            comando.executeUpdate();
        }
    }

    public ArrayList<Anime> recuperarTodos() throws SQLException {
        String sql = SQL_RECUPERAR_TODOS;

        try (Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql);
                ResultSet resultado = comando.executeQuery()) {

            ArrayList<Anime> animes = new ArrayList<>();

            while (resultado.next()) {
                Anime anime = mapearAnime(resultado);
                animes.add(anime);
            }

            return animes;
        }
    }

    public Anime recuperarUm(int codigo) throws SQLException {
        String sql = SQL_RECUPERAR_UM;

        try (Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, codigo);

            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    Anime anime = mapearAnime(resultado);
                    return anime;
                }
            }
        }

        return null;
    }

    public void editar(Anime anime) throws SQLException {
        String sql = SQL_EDITAR;

        try (Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, anime.getTitulo());
            comando.setString(2, anime.getGenero());
            comando.setInt(3, anime.getAnoLancamento());
            comando.setString(4, anime.getEstudio());
            comando.setBoolean(5, anime.isTemManga());
            comando.setBoolean(6, anime.isDublado());
            comando.setInt(7, anime.getCodigo());

            comando.executeUpdate();
        }
    }

    public void excluir(int codigo) throws SQLException {
        String sql = SQL_EXCLUIR;

        try (Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, codigo);
            comando.executeUpdate();
        }
    }

    private Anime mapearAnime(ResultSet resultado) throws SQLException {
        Anime anime = new Anime(
                resultado.getString("titulo"),
                resultado.getString("genero"),
                resultado.getString("estudio"),
                resultado.getBoolean("tem_manga"),
                resultado.getBoolean("dublado"),
                resultado.getInt("ano_lancamento")
        );

        anime.setCodigo(resultado.getInt("id"));

        return anime;
    }
}

