package br.edu.ifpb.bookstore.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.bookstore.modelo.ItemDeCompra;

@Repository
public interface ItemDeCompraRepository extends PagingAndSortingRepository<ItemDeCompra, Integer> {

    List<ItemDeCompra> findDistinctByLivroComprado(Integer livroId);
    List<ItemDeCompra> findByPedido(Integer pedidoId);

    /*@Query(value = "SELECT DISTINCT livro_id, sum(quantidade) FROM ItemDeCompra order by quantidade desc")
    List<ItemDeCompra> findTheBestSellers();*/

}
