/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import banco.Conexao;
import entidades.Elenco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuc
 */
public interface SerieElencoDAO {

    void adicionar(int serieId, int elencoId) throws SQLException;

    void remover(int serieId, int elencoId) throws SQLException;

    ArrayList<Elenco> listarPorSerie(int serieId) throws SQLException;
}
