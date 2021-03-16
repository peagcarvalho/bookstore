package br.edu.ifpb.bookstore.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.edu.ifpb.bookstore.modelo.Categoria;
import br.edu.ifpb.bookstore.servico.CategoriaService;

@Controller
public class HomeController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/index")
    public String home(Model model) {
        List<Categoria> categorias = categoriaService.listarCategoriasOrdemAlfabetica();
        model.addAttribute("categorias", categorias);

        return "index";
    }
    
}
