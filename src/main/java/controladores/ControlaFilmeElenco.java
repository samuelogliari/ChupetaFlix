/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import apoio.Mensagem;
import dao.FilmeElencoDAO;
import entidades.Elenco;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuc
 */
public class ControlaFilmeElenco {

    private final FilmeElencoDAO filmeElencoDAO = new FilmeElencoDAO();

    public void adicionar(int filmeId, int elencoId) {
        try {
            filmeElencoDAO.adicionar(filmeId, elencoId);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao adicionar integrante ao filme.");
        }
    }

    public void remover(int filmeId, int elencoId) {
        try {
            filmeElencoDAO.remover(filmeId, elencoId);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao remover integrante do filme.");
        }
    }

    public ArrayList<Elenco> listarPorFilme(int filmeId) {
        try {
            return filmeElencoDAO.listarPorFilme(filmeId);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao listar elenco do filme.");
            return new ArrayList<>();
        }
    }
}
