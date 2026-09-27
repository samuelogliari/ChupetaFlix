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
}
