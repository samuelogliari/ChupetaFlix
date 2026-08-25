/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author samuel.ogliari
 */
public class Anime extends Midia {

    private String estudio;
    private boolean temManga;
    private boolean dublado;

    public Anime(String titulo, String genero, String estudio, int anoLancamento, boolean temManga, boolean dublado) {
        super(titulo, genero, anoLancamento);
        this.estudio = estudio;
        this.temManga = temManga;
        this.dublado = dublado;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public boolean isTemManga() {
        return temManga;
    }

    public void setTemManga(boolean temManga) {
        this.temManga = temManga;
    }

    public boolean isDublado() {
        return dublado;
    }

    public void setDublado(boolean dublado) {
        this.dublado = dublado;
    }

    @Override //Sobrescreve no Midia
    public String getTipo() {
        return "Anime";
    }

}
