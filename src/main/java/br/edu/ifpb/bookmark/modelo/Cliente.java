package br.edu.ifpb.bookmark.modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente extends Usuario {
	
	@Id @Column(length = 14)
	private String cpf;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nasc")
	private Date dataNasc;
	private String telefone;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Pedido> pedidosRealizados;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(Date dataNasc) {
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
