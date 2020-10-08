package br.com.tessaro.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tessaro.app.repository.AutorRepository;
import br.com.tessaro.app.repository.ObraRepository;

@SpringBootApplication
public class GerenciamentoApplication implements CommandLineRunner{

	@Autowired AutorRepository repo;
	@Autowired ObraRepository obraRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Autor autor1 = new Autor("Cassio", "Masculino", "cassio8888ate@gmail.com", LocalDate.now(), new Pais(1, "Brasil"), "527.873.972-04");
//		Autor autor2 = new Autor("Claudio", "Masculino", "cass77777ioate@gmail.com", LocalDate.now(), new Pais(1, "Brasil"), "527.873.972-04");
//		Autor autor3 = new Autor("Maria", "Masculino", "4566@gmail.com", LocalDate.now(), new Pais(1, "França"), "527.873.972-04");
//		CadastrarAutorDTO autor4 = new CadastrarAutorDTO("Jose", "Masculino", "123@gmail.com", LocalDate.now(), "Argentina", "527.873.972-04");
//		Autor autor5 = new Autor("Francisco", "Masculino", "cass888875534ioate@gmail.com", LocalDate.now(), new Pais(1, "Brasil"), "527.873.972-04");
//		
//		Obra obra1 = new Obra("Obra 1", "Obra legal", LocalDate.now(), LocalDate.now());
//		Obra obra2 = new Obra("Obra 2", "Obra legal", LocalDate.now(), LocalDate.now());
//		Obra obra3 = new Obra("Obra 3", "Obra legal", LocalDate.now(), LocalDate.now());
//		Obra obra4 = new Obra("Obra 4", "Obra legal", LocalDate.now(), LocalDate.now());
//		Obra obra5 = new Obra("Obra 5", "Obra legal", LocalDate.now(), LocalDate.now());
//		
//		autor1.setObras(Arrays.asList(obra1,obra2));
//		autor2.setObras(Arrays.asList(obra3,obra2));
//		autor3.setObras(Arrays.asList(obra5,obra1));
//		autor4.setObras(Arrays.asList(obra4));
//		
//		obra1.setAutores(Arrays.asList(autor1, autor3));
//		obra2.setAutores(Arrays.asList(autor1, autor2));
//		obra3.setAutores(Arrays.asList(autor2));
//		obra4.setAutores(Arrays.asList(autor4));
//		obra5.setAutores(Arrays.asList(autor3));
//		
//		obraRepo.saveAll(Arrays.asList(obra1,obra2,obra3,obra4,obra5));
//		repo.saveAll(Arrays.asList(autor1,autor2,autor3,autor4,autor5));
//		
//		
	}

}
