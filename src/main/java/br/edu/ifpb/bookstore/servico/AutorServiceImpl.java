package br.edu.ifpb.bookstore.servico;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.bookstore.modelo.Autor;
import br.edu.ifpb.bookstore.repositorio.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository repository;

    @Transactional
    public List<Autor> listarAutores() {
        List<Autor> autores = (List<Autor>) repository.findAll();

        return autores;
    }

    @Transactional
    public List<Autor> listarAutoresOrdemAlfabetica() {
        List<Autor> autores = (List<Autor>) repository.findAllByOrderByNome();

        return autores;
    }

    @Transactional
    public List<Autor> buscarAutoresPeloNome(String nome) {
        List<Autor> autores = repository.findByNomeContaining(nome);

        return autores;
    }

    @Transactional
    public void salvarAutor(Autor autor) {
        repository.save(autor);
    }

    @Transactional
    public void excluirPeloId(Integer autorId) {
        repository.deleteById(autorId);
    }

    @Transactional
    public Autor buscarPeloId(Integer autorId) {
        return repository.findById(autorId).get();
    }

    @Transactional
    public void atualizar(Autor autor) {
        repository.save(autor);
    }

}
