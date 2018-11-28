package com.si.llapp.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.si.llapp.domain.Categoria;
import com.si.llapp.domain.Livro;

@Repository
public interface CategoriaRepository extends JpaRepository<Livro, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Livro obj INNER JOIN obj.categorias cat WHERE obj.titulo LIKE %:nome% AND cat IN :categorias")
	Page<Livro> findDistinctByTituloContainingAndCategoriasIn(@Param("titulo") String titulo,
			@Param("categorias") List<Categoria> categorias, Pageable pageRequest);
}
