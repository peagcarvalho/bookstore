package br.edu.ifpb.bookstore.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.bookstore.modelo.Editora;

@Repository
public interface EditoraRepository extends CrudRepository<Editora, Integer> {

}
