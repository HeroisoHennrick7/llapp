package com.si.llapp.dto;

import java.io.Serializable;

import com.si.llapp.domain.Livro;

public class LivroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private Double preco;
	
	public LivroDTO() {
	}

	public LivroDTO(Livro obj) {
		id = obj.getId();
		titulo = obj.getTitulo();
		preco = obj.getPreco();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return titulo;
	}

	public void setNome(String titulo) {
		this.titulo = titulo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
