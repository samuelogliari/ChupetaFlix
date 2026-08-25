/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Filme;
import java.util.ArrayList;

/**
 *
 * @author samuel.ogliari
 */
public class ControlaFilme {
     private static ArrayList<Filme> filmes = new ArrayList(); //static para manter as infos anteriores 
    private static int codigo = 1;

    public void salvar(Filme f) {
        f.setCodigo(codigo);
        filmes.add(f);
        codigo++;
    }

    public void editar(Filme f) {
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getCodigo() == f.getCodigo()) {
                filmes.set(i, f);
                break;
            }
        }
    }

    public void excluir(int codigo) {
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getCodigo() == codigo) {
                filmes.remove(i);
                break;
            }
        }
    }

    public Filme recuperarUm(int codigo) {
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getCodigo() == codigo) {
                return filmes.get(i);
            }
        }
        return null;
    }

    public ArrayList<Filme> recuperarTodos() {
        return filmes;
    }
}
