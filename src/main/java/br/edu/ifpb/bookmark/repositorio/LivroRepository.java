package br.edu.ifpb.bookmark.repositorio;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.bookmark.modelo.Livro;

@Repository
public interface LivroRepository extends PagingAndSortingRepository<Livro, Integer> {
	
	List<Livro> findByTitulo(String titulo);

}
