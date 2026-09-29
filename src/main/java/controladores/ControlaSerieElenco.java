/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import apoio.Mensagem;
import dao.SerieElencoDAO;
import entidades.Elenco;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuc
 */
public class ControlaSerieElenco {
     private final SerieElencoDAO serieElencoDAO = new SerieElencoDAO();

    public void adicionar(int serieId, int elencoId) {
        try {
            serieElencoDAO.adicionar(serieId, elencoId);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao adicionar integrante à série.");
        }
    }

    public void remover(int serieId, int elencoId) {
        try {
            serieElencoDAO.remover(serieId, elencoId);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao remover integrante da série.");
        }
    }

    public ArrayList<Elenco> listarPorSerie(int serieId) {
        try {
            return serieElencoDAO.listarPorSerie(serieId);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao listar elenco da série.");
            return new ArrayList<>();
        }
    }
}
