package br.edu.ifpb.bookstore.dto;

import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import br.edu.ifpb.bookstore.modelo.Autor;
import br.edu.ifpb.bookstore.modelo.Categoria;
import br.edu.ifpb.bookstore.modelo.Dimensoes;
import br.edu.ifpb.bookstore.modelo.Editora;
import br.edu.ifpb.bookstore.modelo.Livro;

public class RequisicaoNovoLivro {

    @NotBlank
    private String titulo;
    @NotBlank
    private String sinopse;
    @Pattern(regexp = "[0-9]{2}/?[0-9]{2}/?[0-9]{4}", message = "A data não está no formato correto")
    @NotBlank @Size(min = 10, max = 10, message = "tamanho deve ser 10 caracteres")
    private String dataPublicacao;
    @NotBlank @Length(min = 10, max = 10, message = "tamanho deve ser 10")
    private String isbn10;
    @NotBlank @Length(min = 13, max = 13, message = "tamanho deve ser 13")
    private String isbn13;
    @NotNull @Min(0)
    private int paginas;
    @NotNull
    private int categoriaId;
    @NotNull
    private int editoraId;
    @NotNull
    private int autorId;
    @NotBlank
    private String idioma;
    @NotBlank
    private String linkCapa;
    private boolean capaDura;
    @NotNull
    private float comprimento;
    @NotNull
    private float largura;
    @NotNull
    private float altura;
    @NotNull @Min(0)
    private int estoque;
    @NotNull @Min(0)
    private float preco;

    public Livro toLivro() {
        Livro livro = new Livro();

        livro.setTitulo(titulo);
        livro.setSinopse(sinopse);
        livro.setIsbn10(isbn10);
        livro.setIsbn13(isbn13);
        livro.setPaginas(paginas);
        livro.setIdioma(idioma);
        livro.setCapa(linkCapa);
        livro.setCapaDura(capaDura);
        livro.setEstoque(estoque);
        livro.setPreco(preco);

        String[] dataSplit = this.dataPublicacao.split("/");
        int dia = Integer.parseInt(dataSplit[0]);
        int mes = Integer.parseInt(dataSplit[1]);
        int ano = Integer.parseInt(dataSplit[2]);

        LocalDate dataPublicacao = LocalDate.of(ano, mes, dia);
        livro.setDataPublicacao(dataPublicacao);
        
        Categoria categoria = new Categoria();
        categoria.setId(categoriaId);
        livro.setCategoria(categoria);

        Editora editora = new Editora();
        editora.setId(editoraId);
        livro.setEditora(editora);

        Autor autor = new Autor();
        autor.setId(autorId);
        livro.setAutor(autor);

        Dimensoes dimensoes = new Dimensoes(comprimento, largura, altura);
        livro.setDimensoes(dimensoes);

        return livro;
    }

    public int getEditoraId() {
        return editoraId;
    }

    public void setEditoraId(int editoraId) {
        this.editoraId = editoraId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getLinkCapa() {
        return linkCapa;
    }

    public void setLinkCapa(String linkCapa) {
        this.linkCapa = linkCapa;
    }

    public boolean isCapaDura() {
        return capaDura;
    }

    public void setCapaDura(boolean capaDura) {
        this.capaDura = capaDura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }
    
}
