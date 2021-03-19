package br.edu.ifpb.bookstore.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.edu.ifpb.bookstore.servico.CategoriaService;
import br.edu.ifpb.bookstore.servico.LivroService;

@Controller
public class HomeController {

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private LivroService LivroService;

    @GetMapping("/index")
    public String home(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategoriasOrdemAlfabetica());
        model.addAttribute("livros", LivroService.buscarNumeroDeLivros(8));

        return "index";
    }
    
}
