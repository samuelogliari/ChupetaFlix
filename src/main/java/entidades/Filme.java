/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author samuel.ogliari
 */
public class Filme extends Midia {

    private String diretor;
    private String duracao;
    private String classificacao;

    public Filme(String titulo, String genero, String diretor, String duracao, String classificacao, int anoLancamento) {
        super(titulo, genero, anoLancamento);
        this.diretor = diretor;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
    
    @Override
    public String getTipo() {
        return "Filme";
    }
}
