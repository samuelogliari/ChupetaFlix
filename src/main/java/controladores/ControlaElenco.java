/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import apoio.Mensagem;
import dao.ElencoDAO;
import entidades.Elenco;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAUDE
 */
public class ControlaElenco {

    private final ElencoDAO elencoDAO = new ElencoDAO();

    public void salvar(Elenco elenco) {
        try {
            elencoDAO.salvar(elenco);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao salvar integrante do elenco.");
        }
    }

    public ArrayList<Elenco> recuperarTodos() {
        try {
            return elencoDAO.recuperarTodos();
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao listar elenco.");
            return new ArrayList<>();
        }
    }

    public Elenco recuperarUm(int codigo) {
        try {
            return elencoDAO.recuperarUm(codigo);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao buscar integrante do elenco.");
            return null;
        }
    }

    public ArrayList<Elenco> pesquisarPorNome(String nome) {
        try {
            return elencoDAO.pesquisarPorNome(nome);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao pesquisar integrante do elenco.");
            return new ArrayList<>();
        }
    }

    public void editar(Elenco elenco) {
        try {
            elencoDAO.editar(elenco);

        } catch (SQLException ex) {
            Mensagem.erro("Erro ao editar integrante do elenco.");
        }
    }

    public void excluir(int codigo) {
        try {
            elencoDAO.excluir(codigo);
        } catch (SQLException ex) {
            Mensagem.erro("Erro ao excluir integrante do elenco.");
        }
    }
}
