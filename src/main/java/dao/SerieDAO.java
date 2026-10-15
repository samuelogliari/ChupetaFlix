/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Serie;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuc
 */
public interface SerieDAO {

    void salvar(Serie serie) throws SQLException;

    ArrayList<Serie> recuperarTodos() throws SQLException;

    Serie recuperarUm(int codigo) throws SQLException;

    void editar(Serie serie) throws SQLException;

    void excluir(int codigo) throws SQLException;
}
