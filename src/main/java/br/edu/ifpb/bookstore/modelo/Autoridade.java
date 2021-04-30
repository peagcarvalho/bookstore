package br.edu.ifpb.bookstore.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Autoridade implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    public Autoridade() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
