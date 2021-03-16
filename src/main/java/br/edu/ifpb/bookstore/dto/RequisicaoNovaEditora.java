package br.edu.ifpb.bookstore.dto;

import javax.validation.constraints.NotBlank;
import br.edu.ifpb.bookstore.modelo.Editora;

public class RequisicaoNovaEditora {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Editora toEditora() {
        Editora editora = new Editora();
        editora.setNome(nome);

        return editora;
    }
    
}
