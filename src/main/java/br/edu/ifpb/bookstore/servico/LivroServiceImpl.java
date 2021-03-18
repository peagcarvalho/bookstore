package br.edu.ifpb.bookstore.servico;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.bookstore.modelo.Livro;
import br.edu.ifpb.bookstore.repositorio.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository repository;

    @Transactional
    public List<Livro> listarLivros() {
        List<Livro> livros = (List<Livro>) repository.findAll();
        
        return livros;
    }

    @Transactional
    public void salvarLivro(Livro livro) {
        repository.save(livro);
    }

    @Transactional
    public List<Livro> buscarPelaCategoria(Integer categoriaId) {
        List<Livro> livrosBuscados = (List<Livro>) repository.findAll();

        for(int contador = 0; contador < livrosBuscados.size(); contador++) {
            Livro livro = livrosBuscados.get(contador);

            if (livro.getCategoria().getId() != categoriaId) {
                livrosBuscados.remove(contador);
            }
        }

        return livrosBuscados;
    }
    
}
