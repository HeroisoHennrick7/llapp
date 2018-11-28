package com.si.llapp;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.si.llapp.domain.Categoria;
import com.si.llapp.domain.Livro;
import com.si.llapp.repositories.CategoriaRepository;
import com.si.llapp.repositories.LivroRepository;

@SpringBootApplication
public class LlappApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	public static void main(String[] args) {
		SpringApplication.run(LlappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Arquitetura");
		
		Livro l = new Livro(null,"Software para arquitetos", null, null, null, null, null, null, null, "10");
		Livro l2 = new Livro(null,"Java 8", null, null, null, null, null, null, null, "60");
		Livro l3 = new Livro(null,"Design for Houses", null, null, null, null, null, null, null, "55");
		
		cat1.getLivros().addAll(Arrays.asList(l, l3, l2));
		cat1.getLivros().addAll(Arrays.asList(l3));
		
		l.getCategorias().addAll(Arrays.asList(cat1, cat2));
		l3.getCategorias().addAll(Arrays.asList(cat1, cat2));
		l2.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		livroRepository.saveAll(Arrays.asList(l, l2, l3));
	}
}
