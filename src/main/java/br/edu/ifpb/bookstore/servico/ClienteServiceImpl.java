package br.edu.ifpb.bookstore.servico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifpb.bookstore.modelo.Autoridade;
import br.edu.ifpb.bookstore.modelo.Cliente;
import br.edu.ifpb.bookstore.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public void salvarCliente(Cliente cliente) {
        List<Autoridade> autoridades = new ArrayList<Autoridade>();

        Autoridade autoridade = new Autoridade();
        autoridade.setId(1); // Autoridade 1 = CLIENTE
        autoridades.add(autoridade);

        cliente.setAutoridades(autoridades);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        cliente.setSenha(encoder.encode(cliente.getSenha()));

        repository.save(cliente);
    }
    
}
