package br.edu.ifpb.bookstore.repositorio;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.bookstore.modelo.Autor;
import br.edu.ifpb.bookstore.modelo.Categoria;
import br.edu.ifpb.bookstore.modelo.Livro;

@Repository
public interface LivroRepository extends PagingAndSortingRepository<Livro, Integer> {
	
	List<Livro> findByTituloContaining(String titulo);
	List<Livro> findByPrecoLessThanEqual(float preco);
	List<Livro> findByCategoria(Categoria categoria);
	List<Livro> findByIdiomaEquals(String idioma);
	List<Livro> findByCategoriaAndIdioma(Categoria categoria, String idioma);
	List<Livro> findByAutor(Autor autor);

}
