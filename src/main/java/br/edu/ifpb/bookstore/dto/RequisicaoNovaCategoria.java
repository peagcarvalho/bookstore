package br.edu.ifpb.bookstore.dto;

import br.edu.ifpb.bookstore.modelo.Categoria;

public class RequisicaoNovaCategoria {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNome(nome);

        return categoria;
    }
    
}
