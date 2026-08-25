/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Serie;
import java.util.ArrayList;

/**
 *
 * @author samuel.ogliari
 */
public class ControlaSerie {

    private static ArrayList<Serie> series = new ArrayList(); // Static para manter infos
    private static int codigo = 1;

    public void salvar(Serie s) {
        s.setCodigo(codigo);
        series.add(s);
        codigo++;
    }

    public void editar(Serie s) {
        for (int i = 0; i < series.size(); i++) {
            if (series.get(i).getCodigo() == s.getCodigo()) { // procura a série que possui o mesmo código
                series.set(i, s);
                break;
            }
        }
    }

    public void excluir(int codigo) {
        for (int i = 0; i < series.size(); i++) {
            if (series.get(i).getCodigo() == codigo) {
                series.remove(i);
                break;
            }
        }
    }

    public Serie recuperarUm(int codigo) {
        for (int i = 0; i < series.size(); i++) {
            if (series.get(i).getCodigo() == codigo) {
                return series.get(i);
            }
        }
        return null;
    }

    public ArrayList<Serie> recuperarTodos() {
        return series;
    }
}
