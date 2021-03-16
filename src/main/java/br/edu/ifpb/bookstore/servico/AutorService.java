package br.edu.ifpb.bookstore.servico;

import java.util.List;
import org.springframework.stereotype.Component;
import br.edu.ifpb.bookstore.modelo.Autor;

@Component
public interface AutorService {

    public List<Autor> listarAutores();
    public List<Autor> listarAutoresOrdemAlfabetica();
    public List<Autor> buscarAutoresPeloNome(String nome);
    public void salvarAutor(Autor autor);
    
}
