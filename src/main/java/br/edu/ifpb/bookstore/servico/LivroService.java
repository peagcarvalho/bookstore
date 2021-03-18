package br.edu.ifpb.bookstore.servico;

import java.util.List;
import org.springframework.stereotype.Component;
import br.edu.ifpb.bookstore.modelo.Livro;

@Component
public interface LivroService {

    public List<Livro> listarLivros();
    public void salvarLivro(Livro livro);
    public List<Livro> buscarPelaCategoria(Integer categoriaId);
    
}
