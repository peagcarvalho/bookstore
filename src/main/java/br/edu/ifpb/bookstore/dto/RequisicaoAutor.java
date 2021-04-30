package br.edu.ifpb.bookstore.dto;

import javax.validation.constraints.NotBlank;
import br.edu.ifpb.bookstore.modelo.Autor;

public class RequisicaoAutor {
    
    private Integer autorId;
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

    public void overrideAttributes(Autor autor) {
        this.setAutorId(autor.getId());
        this.setNome(autor.getNome());
        this.setResumo(autor.getResumo());
        this.setLinkFoto(autor.getFoto());
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

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

}
