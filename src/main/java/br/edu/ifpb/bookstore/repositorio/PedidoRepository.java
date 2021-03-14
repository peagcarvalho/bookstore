package br.edu.ifpb.bookstore.repositorio;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.bookstore.modelo.Pedido;

@Repository
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Integer> {

    List<Pedido> findByCliente(String cpf);
    List<Pedido> findByClienteOrderByDataCompraDesc(String cpf);
    
}
