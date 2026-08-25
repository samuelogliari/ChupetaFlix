/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author samuel.ogliari
 */
public class Serie extends Midia {

    private int temporadas;
    private int episodios;
    private String produtora;

    public Serie(String titulo, String genero, String produtora, int temporadas, int episodios, int anoLancamento) {
        super(titulo, genero, anoLancamento);
        this.temporadas = temporadas;
        this.episodios = episodios;
        this.produtora = produtora;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
    
    
    
    
    @Override
    public String getTipo() {
        return "Serie";
    }
}
