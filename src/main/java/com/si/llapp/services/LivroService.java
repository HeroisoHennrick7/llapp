package com.si.llapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.si.llapp.domain.Categoria;
import com.si.llapp.domain.Livro;
import com.si.llapp.repositories.CategoriaRepository;
import com.si.llapp.repositories.LivroRepository;
import com.si.llapp.services.exceptions.ObjectNotFoundException;
import com.si.llapp.domain.Livro;
import com.si.llapp.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Livro find(Integer id) {
		Optional<Livro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public Page<Livro> search(String titulo, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Livro> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByTituloContainingAndCategoriasIn(titulo, categorias, pageRequest);	
	}
}
