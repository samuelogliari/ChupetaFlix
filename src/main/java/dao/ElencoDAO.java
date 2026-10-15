/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entidades.Elenco;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAUDE
 */

public interface ElencoDAO {

    void salvar(Elenco elenco) throws SQLException;

    ArrayList<Elenco> recuperarTodos() throws SQLException;

    Elenco recuperarUm(int codigo) throws SQLException;

    ArrayList<Elenco> pesquisarPorNome(String nome) throws SQLException;

    void editar(Elenco elenco) throws SQLException;

    void excluir(int codigo) throws SQLException;
}