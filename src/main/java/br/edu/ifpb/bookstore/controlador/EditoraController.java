package br.edu.ifpb.bookstore.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifpb.bookstore.modelo.Editora;
import br.edu.ifpb.bookstore.servico.EditoraService;

@Controller
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping("/editoras")
    public String listarEditoras(Model model) {
        /*Editora editora1 = new Editora();
        editora1.setId(1);
        editora1.setNome("Disney World Publishing");

        Editora editora2 = new Editora();
        editora2.setId(2);
        editora2.setNome("Rocco");

        List<Editora> editoras = Arrays.asList(editora1, editora2);*/

        List<Editora> editoras = editoraService.listarEditoras();
        model.addAttribute("editoras", editoras);

        return "editoras";
    }
    
}
