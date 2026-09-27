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
}
