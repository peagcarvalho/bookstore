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
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.ifpb.bookstore.dto.RequisicaoNovaCategoria;
import br.edu.ifpb.bookstore.modelo.Categoria;
import br.edu.ifpb.bookstore.servico.CategoriaService;

@Controller
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String categorias(RequisicaoNovaCategoria requisicao, Model model) {
        List<Categoria> categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);

        return "categorias";
    }
    
    @PostMapping
    public String cadastrar(@Valid RequisicaoNovaCategoria requisicao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Categoria> categorias = categoriaService.listarCategorias();
            model.addAttribute("categorias", categorias);

            return "categorias";
        }
        
        Categoria categoria = requisicao.toCategoria();
        categoriaService.salvarCategoria(categoria);

        model.addAttribute("categorias", categoriaService.listarCategorias());

        return "redirect:/categorias";
    }

    @GetMapping("/excluir/{categoriaId}")
    public String excluir(@PathVariable(value = "categoriaId") Integer categoriaId) {
        categoriaService.excluirPeloId(categoriaId);

        return "redirect:/categorias";
    }
}
