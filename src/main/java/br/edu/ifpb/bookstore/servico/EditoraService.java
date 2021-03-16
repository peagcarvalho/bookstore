package br.edu.ifpb.bookstore.servico;

import java.util.List;
import org.springframework.stereotype.Component;
import br.edu.ifpb.bookstore.modelo.Editora;

@Component
public interface EditoraService {

    public List<Editora> listarEditoras();
    public List<Editora> listarEditorasOrdemAlfabetica();
    public void salvarEditora(Editora editora);
    
}
