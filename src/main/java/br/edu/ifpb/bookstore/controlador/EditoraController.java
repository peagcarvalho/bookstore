package br.edu.ifpb.bookstore.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifpb.bookstore.dto.RequisicaoNovaEditora;
import br.edu.ifpb.bookstore.modelo.Editora;
import br.edu.ifpb.bookstore.servico.EditoraService;

@Controller
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping("/editoras")
    public String editoras(RequisicaoNovaEditora requisicao, Model model) {
        List<Editora> editoras = editoraService.listarEditoras();
        model.addAttribute("editoras", editoras);

        return "editoras";
    }

    @PostMapping("/editoras")
    public String salvarEditora(@Valid RequisicaoNovaEditora requisicao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("editoras", editoraService.listarEditoras());

            return "editoras";
        }

        Editora editora = requisicao.toEditora();
        editoraService.salvarEditora(editora);

        model.addAttribute("editoras", editoraService.listarEditoras());

        return "redirect:/editoras";
    }
    
}
