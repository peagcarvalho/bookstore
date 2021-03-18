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
import br.edu.ifpb.bookstore.dto.RequisicaoNovoLivro;
import br.edu.ifpb.bookstore.modelo.Autor;
import br.edu.ifpb.bookstore.modelo.Categoria;
import br.edu.ifpb.bookstore.modelo.Editora;
import br.edu.ifpb.bookstore.modelo.Livro;
import br.edu.ifpb.bookstore.servico.AutorService;
import br.edu.ifpb.bookstore.servico.CategoriaService;
import br.edu.ifpb.bookstore.servico.EditoraService;
import br.edu.ifpb.bookstore.servico.LivroService;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private EditoraService editoraService;
    @Autowired
    private AutorService autorService;

    @GetMapping("livros")
    public String livros(Model model) {
        List<Livro> livros = livroService.listarLivros();
        model.addAttribute("livros", livros);
        
        return "livros";
    }

    @GetMapping("cadastroLivro")
    public String formulario(RequisicaoNovoLivro requisicao, Model model) {
        model.addAttribute("categorias", categoriaService.listarCategoriasOrdemAlfabetica());
        model.addAttribute("editoras", editoraService.listarEditorasOrdemAlfabetica());
        model.addAttribute("autores", autorService.listarAutoresOrdemAlfabetica());

        return "cadastroLivro";
    }

    // @GetMapping("index/buscaLivro?categoriaId={categoriaId}")
    @GetMapping("/buscaLivro")
    public String buscarPelaCategoria(/*@PathVariable(value = "categoriaId")*/ Integer categoriaId, Model model) {
        model.addAttribute("categorias", categoriaService.listarCategoriasOrdemAlfabetica());
        model.addAttribute("livrosBuscados", livroService   .buscarPelaCategoria(categoriaId));
        System.out.println("Id: " + categoriaId);

        return "buscaLivro";
    }

    @PostMapping("cadastroLivro")
    public String salvarLivro(@Valid RequisicaoNovoLivro requisicao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaService.listarCategoriasOrdemAlfabetica());
            model.addAttribute("editoras", editoraService.listarEditorasOrdemAlfabetica());
            model.addAttribute("autores", autorService.listarAutoresOrdemAlfabetica());

            return "cadastroLivro";
        }

        Livro livro = requisicao.toLivro();
        livroService.salvarLivro(livro);

        // model.addAttribute("livros", livroService.listarLivros());

        return "redirect:/livros";
    }
    
}
