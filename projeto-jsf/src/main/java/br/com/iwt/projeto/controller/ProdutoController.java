package br.com.iwt.projeto.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.iwt.projeto.dao.DAO;
import br.com.iwt.projeto.model.Produto;

@ManagedBean(name="produtoController")
@SessionScoped
public class ProdutoController {
	
	Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String salvarProduto() {
		
		new DAO<Produto>(Produto.class).adiciona(produto);
		
		produto = new Produto();
		
		return "";
	}

}
