package br.edu.ifpb.bookstore.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.bookstore.modelo.Cliente;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, String> {
    
}
