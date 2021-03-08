package br.edu.ifpb.bookmark.modelo;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 5885124606680676205L;

	public Endereco() {
		
	}
	
	public Endereco(String logradouro, String numero, String bairro, String cidade, String estado, String referencia) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.referencia = referencia;
	}
	
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	private String numero;
	private String referencia;
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getReferencia() {
		return referencia;
	}
	
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
}
