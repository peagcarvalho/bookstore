package br.edu.ifpb.bookstore.modelo;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Cliente")
public class Cliente extends Usuario {
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 14)
	private String cpf;
	@Column(name = "data_nasc")
	private LocalDate dataNasc;
	private String telefone;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Pedido> pedidosRealizados;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Pedido> getPedidosRealizados() {
		return pedidosRealizados;
	}

	public void setPedidosRealizados(List<Pedido> pedidosRealizados) {
		this.pedidosRealizados = pedidosRealizados;
	}

}
