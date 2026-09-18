/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.FilmeDAO;
import entidades.Filme;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuel.ogliari
 */
public class ControlaFilme {

    private FilmeDAO filmeDAO = new FilmeDAO();

    public void salvar(Filme filme) throws SQLException {
        filmeDAO.salvar(filme);
    }

    public ArrayList<Filme> recuperarTodos() throws SQLException {
        return filmeDAO.recuperarTodos();
    }

    public Filme recuperarUm(int codigo) throws SQLException {
        return filmeDAO.recuperarUm(codigo);
    }

    public void editar(Filme filme) throws SQLException {
        filmeDAO.editar(filme);
    }
}
