package br.edu.ifpb.bookstore.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifpb.bookstore.servico.CategoriaService;
import br.edu.ifpb.bookstore.servico.LivroService;

@Controller
public class HomeController {

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private LivroService LivroService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategoriasOrdemAlfabetica());
        model.addAttribute("livros", LivroService.buscarLivrosAleatorios(8));

        return "index";
    }
    
}
