/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import apoio.Mensagem;
import dao.SerieDAO;
import entidades.Serie;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuel.ogliari
 */
public class ControlaSerie {

    private final SerieDAO serieDAO = new SerieDAO();

    public void salvar(Serie serie) {
        try {
            serieDAO.salvar(serie);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao salvar série.");
        }
    }

    public ArrayList<Serie> recuperarTodos() {
        try {
            return serieDAO.recuperarTodos();
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao listar séries.");
            return new ArrayList<>();
        }
    }

    public Serie recuperarUm(int codigo) {
        try {
            return serieDAO.recuperarUm(codigo);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao buscar série.");
            return null;
        }
    }

    public void editar(Serie serie) {
        try {
            serieDAO.editar(serie);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao editar série.");
        }
    }

    public void excluir(int codigo) {
        try {
            serieDAO.excluir(codigo);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao excluir série.");
        }
    }

    public String validar(Serie serie) {
        if (serie.getTitulo() == null || serie.getTitulo().trim().isEmpty()) {
            return "O título é obrigatório.";
        }
        if (serie.getGenero() == null || serie.getGenero().trim().isEmpty()) {
            return "O gênero é obrigatório.";
        }
        if (serie.getTemporadas() <= 0) {
            return "A quantidade de temporadas deve ser um número maior que zero.";
        }
        if (serie.getEpisodios() <= 0) {
            return "A quantidade de episódios deve ser um número maior que zero.";
        }
        if (serie.getProdutora() == null || serie.getProdutora().trim().isEmpty()) {
            return "A produtora é obrigatória.";
        }
        int anoAtual = java.time.Year.now().getValue();
        if (serie.getAnoLancamento() < 1888 || serie.getAnoLancamento() > anoAtual) {
            return "O ano de lançamento deve ser válido.";
        }
        return null;
    }
}
