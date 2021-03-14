package br.edu.ifpb.bookstore.modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_compra")
    private Date dataCompra;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_prevista_entrega")
    private Date dataPrevistaEntrega;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_entrega")
    private Date dataEntrega;
    private Endereco endereco;
    private String destinatario;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @Column(name = "quant_itens")
    private int quantidadeItens;
    @Column(name = "valor_total")
    private float valorTotal;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<ItemDeCompra> itensComprados;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf", insertable = false, updatable = false)
    private Cliente cliente;

    public int calcularQuantItens() {
        int somaItens = 0;

        for (ItemDeCompra item : itensComprados) {
            somaItens += item.getQuantidade();
        }

        return somaItens;
    }

    public float calcularValorTotal() {
        float somaValorTotal = 0;

        for (ItemDeCompra item : itensComprados) {
            float valorItem = item.getLivroComprado().getPreco() * item.getQuantidade();

            somaValorTotal += valorItem;
        }

        return somaValorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemDeCompra> getItensComprados() {
        return itensComprados;
    }

    public void setItensComprados(List<ItemDeCompra> itensComprados) {
        this.itensComprados = itensComprados;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(Date dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
}
