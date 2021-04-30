package br.edu.ifpb.bookstore.modelo;

import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
@DiscriminatorColumn(name = "tipo")
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length = 80, nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false)
	private String nome;
	private String sobrenome;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Autoridade> autoridades;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Autoridade> getAutoridades() {
		return autoridades;
	}

	public void setAutoridades(List<Autoridade> autoridades) {
		this.autoridades = autoridades;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getAutoridades();
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
