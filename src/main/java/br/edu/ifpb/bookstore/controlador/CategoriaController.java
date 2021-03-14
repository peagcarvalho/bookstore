package br.edu.ifpb.bookstore.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.edu.ifpb.bookstore.dto.RequisicaoNovaCategoria;
import br.edu.ifpb.bookstore.modelo.Categoria;
import br.edu.ifpb.bookstore.servico.CategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaService.listarCategorias();

        model.addAttribute("categorias", categorias);

        return "categorias";
    }
    
    @PostMapping("/categorias")
    public String salvarCategoria(RequisicaoNovaCategoria requisicao) {
        Categoria categoria = requisicao.toCategoria();

        categoriaService.salvarCategoria(categoria);

        return "categorias";
    }
}
