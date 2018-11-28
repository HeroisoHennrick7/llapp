package com.si.llapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.llapp.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
