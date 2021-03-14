package br.edu.ifpb.bookstore.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Dimensoes implements Serializable {

    private static final long serialVersionUID = 208617478270254235L;
    
    private float comprimento;
    private float largura;
    private float altura;

    public Dimensoes() {

    }

    public Dimensoes(float comprimento, float largura, float altura) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

}
