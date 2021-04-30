package br.edu.ifpb.bookstore.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.bookstore.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
}
