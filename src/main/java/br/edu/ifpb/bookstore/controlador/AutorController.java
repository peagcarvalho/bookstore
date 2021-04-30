package br.edu.ifpb.bookstore.controlador;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.edu.ifpb.bookstore.dto.RequisicaoAutor;
import br.edu.ifpb.bookstore.modelo.Autor;
import br.edu.ifpb.bookstore.servico.AutorService;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/autores")
    public String autores(Model model) {
        List<Autor> autores = autorService.listarAutores();
        model.addAttribute("autores", autores);

        return "autores";
    }

    @GetMapping("/cadastroAutor")
    public String formulario(RequisicaoAutor requisicao) {
        return "cadastroAutor";
    }

    @PostMapping("/cadastroAutor")
    public String cadastrar(@Valid RequisicaoAutor requisicao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cadastroAutor";
        }

        Autor autor = requisicao.toAutor();
        autorService.salvarAutor(autor);

        model.addAttribute("autores", autorService.listarAutores());

        return "redirect:/autores";
    }

    @GetMapping("/autores/excluir/{autorId}")
    public String excluir(@PathVariable(value = "autorId") Integer autorId) {
        autorService.excluirPeloId(autorId);
        
        return "redirect:/autores";
    }

    @GetMapping("/edicaoAutor/{autorId}")
    public String edicao(@PathVariable(value = "autorId") Integer autorId, RequisicaoAutor requisicao, Model model) {
        Autor autor = autorService.buscarPeloId(autorId);
        model.addAttribute("autor", autor);

        requisicao.overrideAttributes(autor);

        return "edicaoAutor";
    }

    @PostMapping("/edicaoAutor")
    public String editar(@Valid RequisicaoAutor requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return "autores";
        }

        Autor autor = requisicao.toAutor();
        autor.setId(requisicao.getAutorId());

        autorService.atualizar(autor);

        return "redirect:/autores";
    }
    
}
