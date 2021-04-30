package br.edu.ifpb.bookstore.servico;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.edu.ifpb.bookstore.modelo.Usuario;
import br.edu.ifpb.bookstore.repositorio.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optional = usuarioRepository.findById(username);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new UsernameNotFoundException("Usuário não encontrado");
    }
    
}
