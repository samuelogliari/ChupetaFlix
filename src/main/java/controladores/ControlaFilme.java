/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import apoio.Mensagem;
import dao.FilmeDAO;
import entidades.Filme;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author samuel.ogliari
 */
public class ControlaFilme {

    private final FilmeDAO filmeDAO = new FilmeDAO();

    public void salvar(Filme filme) {
        try {
            filmeDAO.salvar(filme);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao salvar filme.");
        }
    }

    public ArrayList<Filme> recuperarTodos() {
        try {
            return filmeDAO.recuperarTodos();
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao listar filmes.");
            return new ArrayList<>();
        }
    }

    public Filme recuperarUm(int codigo) {
        try {
            return filmeDAO.recuperarUm(codigo);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao buscar filme.");
            return null;

        }
    }

    public void editar(Filme filme) {
        try {
            filmeDAO.editar(filme);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao editar filme");
        }
    }

    public void excluir(int codigo) {
        try {
            filmeDAO.excluir(codigo);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao excluir filme");
        }
    }

    //validações
    public String validar(Filme filme) {
        if (filme.getTitulo() == null || filme.getTitulo().trim().isEmpty()) {
            return "O título é obrigatório.";
        }
        if (filme.getGenero() == null || filme.getGenero().trim().isEmpty()) {
            return "O gênero é obrigatório.";
        }
        if (filme.getDiretor() == null || filme.getDiretor().trim().isEmpty()) {
            return "O diretor é obrigatório.";
        }
        if (filme.getDuracao() <= 0) {
            return "A duração deve ser um número maior que zero.";
        }
        if (filme.getClassificacao() == null || filme.getClassificacao().trim().isEmpty()) {
            return "A classificação é obrigatória.";
        }
        int anoAtual = Year.now().getValue();
        if (filme.getAnoLancamento() < 1888 || filme.getAnoLancamento() > anoAtual) {
            return "O ano de lançamento deve ser válido!";
        }
        
        return null;
    }
}
