/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Anime;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuc
 */
public interface AnimeDAO {

    void salvar(Anime anime) throws SQLException;

    ArrayList<Anime> recuperarTodos() throws SQLException;

    Anime recuperarUm(int codigo) throws SQLException;

    void editar(Anime anime) throws SQLException;

    void excluir(int codigo) throws SQLException;
}

