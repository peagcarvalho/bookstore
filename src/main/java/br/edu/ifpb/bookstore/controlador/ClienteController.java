package br.edu.ifpb.bookstore.controlador;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.bookstore.dto.RequisicaoNovoCliente;
import br.edu.ifpb.bookstore.modelo.Cliente;
import br.edu.ifpb.bookstore.servico.ClienteService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/criarConta")
    public String cadastro(RequisicaoNovoCliente requisicao) {
        return "criarConta";    
    }
                                
    @PostMapping("/criarConta")
    public String cadastrarCliente(@Valid RequisicaoNovoCliente requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return "criarConta";                
        }

        Cliente cliente = requisicao.toCliente();
        clienteService.salvarCliente(cliente);

        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
}
