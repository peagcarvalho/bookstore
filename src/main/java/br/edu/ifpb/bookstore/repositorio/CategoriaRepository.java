package br.edu.ifpb.bookstore.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.bookstore.modelo.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    
}
