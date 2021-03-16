package br.edu.ifpb.bookstore.dto;

import javax.validation.constraints.NotBlank;
import br.edu.ifpb.bookstore.modelo.Autor;

public class RequisicaoNovoAutor {
    
    @NotBlank
    private String nome;
    @NotBlank
    private String resumo;
    @NotBlank
    private String linkFoto;

    public Autor toAutor() {
        Autor autor = new Autor();
        autor.setNome(nome);
        autor.setResumo(resumo);
        autor.setFoto(linkFoto);

        return autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

}
