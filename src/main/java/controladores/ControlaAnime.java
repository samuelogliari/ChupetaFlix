/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Anime;
import java.util.ArrayList;

/**
 *
 * @author samuel.ogliari
 */
public class ControlaAnime {

    private static ArrayList<Anime> animes = new ArrayList(); //static para manter as infos anteriores 
    private static int codigo = 1;

    public void salvar(Anime a) {
        a.setCodigo(codigo);
        animes.add(a);
        codigo++;
    }

    public void editar(Anime a) {
        for (int i = 0; i < animes.size(); i++) {
            if (animes.get(i).getCodigo() == a.getCodigo()) {
                animes.set(i, a);
                break;
            }
        }
    }

    public void excluir(int codigo) {
        for (int i = 0; i < animes.size(); i++) {
            if (animes.get(i).getCodigo() == codigo) {
                animes.remove(i);
                break;
            }
        }
    }

    public Anime recuperarUm(int codigo) {
        for (int i = 0; i < animes.size(); i++) {
            if (animes.get(i).getCodigo() == codigo) {
                return animes.get(i);
            }
        }
        return null;
    }

    public ArrayList<Anime> recuperarTodos() {
        return animes;
    }
}
