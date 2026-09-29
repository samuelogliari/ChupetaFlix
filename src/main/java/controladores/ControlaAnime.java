/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import apoio.Mensagem;
import dao.AnimeDAO;
import entidades.Anime;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuel.ogliari
 */
public class ControlaAnime {

    private final AnimeDAO animeDAO = new AnimeDAO();

    public void salvar(Anime anime) {
        try {
            animeDAO.salvar(anime);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao salvar anime.");
        }
    }

    public ArrayList<Anime> recuperarTodos() {
        try {
            return animeDAO.recuperarTodos();
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao listar animes.");
            return new ArrayList<>();
        }
    }

    public Anime recuperarUm(int codigo) {
        try {
            return animeDAO.recuperarUm(codigo);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao buscar anime.");
            return null;
        }
    }

    public void editar(Anime anime) {
        try {
            animeDAO.editar(anime);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao editar anime.");
        }
    }

    public void excluir(int codigo) {
        try {
            animeDAO.excluir(codigo);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao excluir anime.");
        }
    }

    //validações
    public String validar(Anime anime) {
        if (anime.getTitulo() == null || anime.getTitulo().trim().isEmpty()) {
            return "O título é obrigatório.";
        }
        if (anime.getGenero() == null || anime.getGenero().trim().isEmpty()) {
            return "O gênero é obrigatório.";
        }
        if (anime.getEstudio() == null || anime.getEstudio().trim().isEmpty()) {
            return "O estúdio é obrigatório.";
        }
        int anoAtual = java.time.Year.now().getValue();
        if (anime.getAnoLancamento() < 1888 || anime.getAnoLancamento() > anoAtual) {
            return "O ano de lançamento deve ser válido.";
        }

        return null;
    }
}
