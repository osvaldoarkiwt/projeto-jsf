package br.com.iwt.projeto.dao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import javax.persistence.EntityManager;

import br.com.iwt.projeto.model.Cliente;
import br.com.iwt.projeto.model.Compra;
import br.com.iwt.projeto.model.ItemCompra;
import br.com.iwt.projeto.model.Produto;

public class TestaBanco {

	public static void main(String[] args) {
					
		Produto produto = new Produto();
		
		produto.setNome("café");
		produto.setPreco(new BigDecimal(8.30));
		produto.setCategoria("bebida");
		
		new DAO<Produto>(Produto.class).adiciona(produto);
	}
}