package br.edu.ifpb.bookstore.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("Funcionario")
public class Funcionario extends Usuario {

    private boolean admin;
    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
}
