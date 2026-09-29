/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import apoio.Mensagem;
import dao.AnimeElencoDAO;
import entidades.Elenco;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuc
 */
public class ControlaAnimeElenco {

    private final AnimeElencoDAO animeElencoDAO = new AnimeElencoDAO();

    public void adicionar(int animeId, int elencoId) {
        try {
            animeElencoDAO.adicionar(animeId, elencoId);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao adicionar integrante ao anime.");
        }
    }

    public void remover(int animeId, int elencoId) {
        try {
            animeElencoDAO.remover(animeId, elencoId);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao remover integrante do anime.");
        }
    }
    
    public ArrayList<Elenco> listarPorAnime(int animeId) {
        try {
            return animeElencoDAO.listarPorAnime(animeId);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao listar elenco do anime.");
            return new ArrayList<>();
        }
    }
}
