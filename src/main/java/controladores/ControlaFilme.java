/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import apoio.Mensagem;
import dao.FilmeDAO;
import entidades.Filme;
import java.sql.SQLException;
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
}
