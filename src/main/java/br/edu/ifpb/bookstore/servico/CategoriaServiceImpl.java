package br.edu.ifpb.bookstore.servico;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.bookstore.modelo.Categoria;
import br.edu.ifpb.bookstore.repositorio.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Transactional
    public List<Categoria> listarCategorias() {
        List<Categoria> response = (List<Categoria>) repository.findAll();

        return response;
    }

    @Transactional
    public List<Categoria> listarCategoriasOrdemAlfabetica() {
        List<Categoria> response = repository.findAllByOrderByNome();

        return response;
    }

    @Transactional
    public void salvarCategoria(Categoria categoria) {
        repository.save(categoria);
    }

    @Transactional
    public Categoria buscarPeloId(Integer categoriaId) {
        return repository.findById(categoriaId).get();
    }

    @Transactional
    public void excluirPeloId(Integer categoriaId) {
        repository.deleteById(categoriaId);
    }
    
}
