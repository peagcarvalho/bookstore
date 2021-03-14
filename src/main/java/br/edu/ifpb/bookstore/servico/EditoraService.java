package br.edu.ifpb.bookstore.servico;

import java.util.List;
import org.springframework.stereotype.Component;

import br.edu.ifpb.bookstore.modelo.Editora;

@Component
public interface EditoraService {

    public List<Editora> listarEditoras();
    public void salvarEditora();
    
}
