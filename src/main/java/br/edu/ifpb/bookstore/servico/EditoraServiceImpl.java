package br.edu.ifpb.bookstore.servico;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.bookstore.modelo.Editora;
import br.edu.ifpb.bookstore.repositorio.EditoraRepository;

@Service
public class EditoraServiceImpl implements EditoraService {

    @Autowired
    private EditoraRepository repository;

    @Transactional
    public List<Editora> listarEditoras() {
        List<Editora> response = (List<Editora>) repository.findAll();

        return response;
    }

    public void salvarEditora() {
        
    }
    
}
