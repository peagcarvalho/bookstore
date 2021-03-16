package br.edu.ifpb.bookstore.repositorio;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.bookstore.modelo.Editora;

@Repository
public interface EditoraRepository extends PagingAndSortingRepository<Editora, Integer> {

    public List<Editora> findAllByOrderByNomeAsc();

}
