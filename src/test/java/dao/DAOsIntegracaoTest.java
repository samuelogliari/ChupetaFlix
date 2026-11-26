/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import banco.Conexao;
import entidades.Anime;
import entidades.Filme;
import entidades.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author samuel.ogliari
 */
public class DAOsIntegracaoTest {
      // TESTE 1 - Crud de anime
    //  verifica se todas as operações básicas de cadastro, consulta, edição e exclusão de animes estão funcionando
    @Test
    @DisplayName("Anime - Cadastro, consulta, edição e exclusão")
    public void testarAnimeCRUD() throws SQLException {

        AnimeDAO dao = new AnimeDAOjdbc();

        String titulo = "TESTE JUNIT " + UUID.randomUUID();
        String tituloEditado = titulo + " EDITADO";

        try {
            Anime anime = new Anime(
                    titulo, "Aventura", "Estudio Teste",
                    true, true, 2025
            );

            dao.salvar(anime);

            Anime cadastrado = dao.recuperarTodos()
                    .stream()
                    .filter(a -> a.getTitulo().equals(titulo))
                    .findFirst()
                    .orElse(null);

            assertNotNull(cadastrado);

            int codigo = cadastrado.getCodigo();

            Anime consultado = dao.recuperarUm(codigo);

            assertNotNull(consultado);
            assertEquals(titulo, consultado.getTitulo());

            cadastrado.setTitulo(tituloEditado);
            dao.editar(cadastrado);

            Anime editado = dao.recuperarUm(codigo);

            assertNotNull(editado);
            assertEquals(tituloEditado, editado.getTitulo());

            dao.excluir(codigo);

            assertNull(dao.recuperarUm(codigo));

        } finally {
            limparRegistro("animes", titulo);
            limparRegistro("animes", tituloEditado);
        }
    }

    // TESTE 2 - anime inexistente
    // tenta buscar um anime com o código -1, ou seja, verifica se o sistema trata corretamente uma consulta quando o registro não existe no banco
    @Test
    @DisplayName("Anime - Consulta de ID inexistente")
    public void testarAnimeInexistente() throws SQLException {

        AnimeDAO dao = new AnimeDAOjdbc();

        Anime anime = dao.recuperarUm(-1);

        assertNull(anime);
    }

    // TESTE 3 - Crud de filme
    // verifica se o FilmeDAO consegue executar corretamente todas as operações CRUD no banco de dados
    @Test
    @DisplayName("Filme - Cadastro, consulta, edição e exclusão")
    public void testarFilmeCRUD() throws SQLException {

        FilmeDAO dao = new FilmeDAOjdbc();

        String titulo = "TESTE JUNIT " + UUID.randomUUID();
        String tituloEditado = titulo + " EDITADO";

        try {
            Filme filme = new Filme(
                    titulo, "Ação", "Diretor Teste",
                    120, "14 anos", 2025
            );

            dao.salvar(filme);

            Filme cadastrado = dao.recuperarTodos()
                    .stream()
                    .filter(f -> f.getTitulo().equals(titulo))
                    .findFirst()
                    .orElse(null);

            assertNotNull(cadastrado);

            int codigo = cadastrado.getCodigo();

            Filme consultado = dao.recuperarUm(codigo);

            assertNotNull(consultado);
            assertEquals(titulo, consultado.getTitulo());

            cadastrado.setTitulo(tituloEditado);
            dao.editar(cadastrado);

            Filme editado = dao.recuperarUm(codigo);

            assertNotNull(editado);
            assertEquals(tituloEditado, editado.getTitulo());

            dao.excluir(codigo);

            assertNull(dao.recuperarUm(codigo));

        } finally {
            limparRegistro("filmes", titulo);
            limparRegistro("filmes", tituloEditado);
        }
    }

    // TESTE 4 - filme inexistente
    // verifica se uma consulta de filme inexistente retorna o resultado esperado, sem gerar um registro indevido
    @Test
    @DisplayName("Filme - Consulta de ID inexistente")
    public void testarFilmeInexistente() throws SQLException {

        FilmeDAO dao = new FilmeDAOjdbc();

        Filme filme = dao.recuperarUm(-1);

        assertNull(filme);
    }

    // TESTE 5 - Crud de Serie
    // verifica se o SerieDAO consegue realizar corretamente as operações de cadastro, consulta, edição e exclusão
    @Test
    @DisplayName("Série - Cadastro, consulta, edição e exclusão")
    public void testarSerieCRUD() throws SQLException {

        SerieDAO dao = new SerieDAOjdbc();

        String titulo = "TESTE JUNIT " + UUID.randomUUID();
        String tituloEditado = titulo + " EDITADO";

        try {
            Serie serie = new Serie(
                    titulo, "Drama", 2,
                    20, "Produtora Teste", 2025
            );

            dao.salvar(serie);

            Serie cadastrada = dao.recuperarTodos()
                    .stream()
                    .filter(s -> s.getTitulo().equals(titulo))
                    .findFirst()
                    .orElse(null);

            assertNotNull(cadastrada);

            int codigo = cadastrada.getCodigo();

            Serie consultada = dao.recuperarUm(codigo);

            assertNotNull(consultada);
            assertEquals(titulo, consultada.getTitulo());

            cadastrada.setTitulo(tituloEditado);
            dao.editar(cadastrada);

            Serie editada = dao.recuperarUm(codigo);

            assertNotNull(editada);
            assertEquals(tituloEditado, editada.getTitulo());

            dao.excluir(codigo);

            assertNull(dao.recuperarUm(codigo));

        } finally {
            limparRegistro("series", titulo);
            limparRegistro("series", tituloEditado);
        }
    }

    // TESTE 6 - Serie inexistente
    // verifica se o sistema retorna null quando tento consultar uma série que não está cadastrada
    @Test
    @DisplayName("Série - Consulta de ID inexistente")
    public void testarSerieInexistente() throws SQLException {

        SerieDAO dao = new SerieDAOjdbc();

        Serie serie = dao.recuperarUm(-1);

        assertNull(serie);
    }

    // MÉTODO AUXILIAR PARA LIMPAR OS REGISTROS DE TESTE
    private void limparRegistro(String tabela, String titulo)
            throws SQLException {

        String sql = "DELETE FROM " + tabela + " WHERE titulo = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, titulo);
            comando.executeUpdate();
        }
    }
}
