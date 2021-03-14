package br.edu.ifpb.bookstore.repositorio;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.bookstore.modelo.Cliente;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, String> {
    
    List<Cliente> findByEmailEquals(String email);
    List<Cliente> findByEmailAndSenha(String email, String senha);

}
