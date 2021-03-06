package br.edu.ifpb.bookstore.dto;

import javax.validation.constraints.NotBlank;
import br.edu.ifpb.bookstore.modelo.Categoria;

public class RequisicaoNovaCategoria {

    @NotBlank
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
