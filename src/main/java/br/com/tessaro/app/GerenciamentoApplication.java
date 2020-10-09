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
		
	}

}
