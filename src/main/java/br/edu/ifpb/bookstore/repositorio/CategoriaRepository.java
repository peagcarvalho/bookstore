package br.edu.ifpb.bookstore.repositorio;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.bookstore.modelo.Categoria;

@Repository
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Integer> {

    public List<Categoria> findAllByOrderByNome();
    
}
