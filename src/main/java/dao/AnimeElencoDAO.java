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
public interface AnimeElencoDAO {
   
    void adicionar(int animeId, int elencoId) throws SQLException;

    void remover(int animeId, int elencoId) throws SQLException;

    ArrayList<Elenco> listarPorAnime(int animeId) throws SQLException;
}
