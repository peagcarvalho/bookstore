package br.edu.ifpb.bookstore.servico;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.bookstore.modelo.Categoria;
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
        Categoria categoria = new Categoria();
        categoria.setId(categoriaId);

        List<Livro> result = (List<Livro>) repository.findByCategoria(categoria);

        return result;
    }

    @Transactional
    public List<Livro> buscarLivrosAleatorios(int numeroDeLivros) { // quantidade de itens (livros) a serem retornados como resultado
        List<Livro> livros = (List<Livro>) repository.findAll();
        List<Livro> result = new ArrayList<Livro>();

        if (livros.size() < numeroDeLivros) {
            numeroDeLivros = livros.size();
        }

        for (int contador = 0; contador < numeroDeLivros; contador++) {
            int numeroAleatorio = (int) Math.floor(Math.random() * livros.size());

            result.add(livros.get(numeroAleatorio));
            livros.remove(numeroAleatorio);
        }

        // List<Livro> result = (List<Livro>) repository.findTop8By();

        return result;
    }
    
}
