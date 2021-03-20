package br.edu.ifpb.bookstore.repositorio;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.bookstore.modelo.ItemDeCompra;
import br.edu.ifpb.bookstore.modelo.Livro;
import br.edu.ifpb.bookstore.modelo.Pedido;

@Repository
public interface ItemDeCompraRepository extends PagingAndSortingRepository<ItemDeCompra, Integer> {

    List<ItemDeCompra> findDistinctByLivroComprado(Livro livro);
    List<ItemDeCompra> findByPedido(Pedido pedido);

    /*@Query(value = "SELECT DISTINCT livro_id, sum(quantidade) FROM ItemDeCompra order by quantidade desc")
    List<ItemDeCompra> findTheBestSellers();*/

}
