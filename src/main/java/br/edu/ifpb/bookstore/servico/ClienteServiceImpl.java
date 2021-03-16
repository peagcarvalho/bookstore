package br.edu.ifpb.bookstore.servico;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.bookstore.modelo.Cliente;
import br.edu.ifpb.bookstore.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public void salvarCliente(Cliente cliente) {
        repository.save(cliente);
    }
    
}
