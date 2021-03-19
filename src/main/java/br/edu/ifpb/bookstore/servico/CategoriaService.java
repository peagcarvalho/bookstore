package br.edu.ifpb.bookstore.servico;

import java.util.List;
import org.springframework.stereotype.Component;

import br.edu.ifpb.bookstore.modelo.Categoria;

@Component
public interface CategoriaService {
    
    public List<Categoria> listarCategorias();
    public List<Categoria> listarCategoriasOrdemAlfabetica();
    public void salvarCategoria(Categoria categoria);
    public Categoria buscarPeloId(Integer categoriaId);

}
