package br.edu.ifpb.bookstore.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import br.edu.ifpb.bookstore.modelo.Cliente;

public class RequisicaoNovoCliente {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 6, max = 20)
    private String senha;
    @NotBlank
    @Pattern(regexp = "[0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}", message = "O CPF não está no formato correto")
    private String cpfCliente;
    @NotBlank
    private String telefone;
    @NotBlank @Size(min = 10, max = 10)
    private String dataNascimento;

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setCpf(cpfCliente);
        cliente.setTelefone(telefone);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            cliente.setDataNasc(sdf.parse(dataNascimento));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cliente;
    }

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
    
    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}
