package br.edu.ifpb.bookstore.repositorio;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.bookstore.modelo.Funcionario;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {
    
    List<Funcionario> findByEmail(String email);
    List<Funcionario> findByEmailAndSenha(String email, String senha);
    List<Funcionario> findByAdminTrue();

}
