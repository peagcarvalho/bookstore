package br.edu.ifpb.bookstore.repositorio;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.bookstore.modelo.Autor;

@Repository
public interface AutorRepository extends PagingAndSortingRepository<Autor, Integer> {
    
    List<Autor> findByNomeContaining(String nome);
    List<Autor> findAllByOrderByNome();

}
