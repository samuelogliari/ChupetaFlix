/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Filme;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAUDE
 */
public interface FilmeDAO {

    void salvar(Filme filme) throws SQLException;

    ArrayList<Filme> recuperarTodos() throws SQLException;

    Filme recuperarUm(int codigo) throws SQLException;

    void editar(Filme filme) throws SQLException;

    void excluir(int codigo) throws SQLException;
}
