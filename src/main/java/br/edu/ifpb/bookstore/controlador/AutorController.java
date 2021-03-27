package br.edu.ifpb.bookstore.controlador;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.edu.ifpb.bookstore.dto.RequisicaoNovoAutor;
import br.edu.ifpb.bookstore.modelo.Autor;
import br.edu.ifpb.bookstore.servico.AutorService;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("autores")
    public String autores(Model model) {
        List<Autor> autores = autorService.listarAutores();
        model.addAttribute("autores", autores);

        return "autores";
    }

    @GetMapping("cadastroAutor")
    public String formulario(RequisicaoNovoAutor requisicao) {
        return "cadastroAutor";
    }

    @PostMapping("cadastroAutor")
    public String salvarAutor(@Valid RequisicaoNovoAutor requisicao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cadastroAutor";
        }

        Autor autor = requisicao.toAutor();
        autorService.salvarAutor(autor);

        model.addAttribute("autores", autorService.listarAutores());

        return "redirect:/autores";
    }
    
}
