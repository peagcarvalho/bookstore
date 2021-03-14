package br.edu.ifpb.bookstore;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifpb.bookstore.modelo.Autor;
import br.edu.ifpb.bookstore.repositorio.AutorRepository;

@SpringBootApplication
public class BookmarkApplication implements CommandLineRunner {

	private final AutorRepository repository;

	public BookmarkApplication(AutorRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookmarkApplication.class, args);
	}

	public void run(String... args) throws Exception {
		/*Livro livro = new Livro();
		livro.setTitulo("Heróis do Olimpo - O Filho de Netuno");
		livro.setIsbn10("1021523212");
		livro.setIsbn13("1234565899885");
		Dimensoes dimensoes = new Dimensoes(25.0f, 12.5f, 3.2f);
		livro.setDimensoes(dimensoes);
		livro.setPaginas(430);

		repository.save(livro);*/

		/*List<Livro> livrosBuscados = repository.findByTituloContaining("O filho de netuno");
		livrosBuscados.forEach(livro -> System.out.println(livro.getIsbn10()));*/

		/*Autor autor = new Autor();
		autor.setNome("Rick Riordan");
		autor.setResumo("Escreveu vários livros sobre deuses de mitologias de diversas civilizações.");

		repository.save(autor);*/

		/*List<Autor> autorBuscado = repository.findByNomeContaining("Rior");
		autorBuscado.forEach(a -> System.out.println(a.getNome()));*/
	}

}
