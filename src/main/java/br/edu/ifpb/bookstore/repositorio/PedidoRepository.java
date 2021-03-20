package br.edu.ifpb.bookstore.repositorio;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.bookstore.modelo.Cliente;
import br.edu.ifpb.bookstore.modelo.Pedido;

@Repository
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
    List<Pedido> findByClienteOrderByDataCompraDesc(Cliente cliente);
    
}
