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
 * @author samuc
 */
public interface FilmeElencoDAO {

    void adicionar(int filmeId, int elencoId) throws SQLException;

    void remover(int filmeId, int elencoId) throws SQLException;

    ArrayList<Elenco> listarPorFilme(int filmeId) throws SQLException;
}
