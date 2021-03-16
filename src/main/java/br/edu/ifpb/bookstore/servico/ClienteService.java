package br.edu.ifpb.bookstore.servico;

import org.springframework.stereotype.Component;
import br.edu.ifpb.bookstore.modelo.Cliente;

@Component
public interface ClienteService {

    public void salvarCliente(Cliente cliente);
    
}
