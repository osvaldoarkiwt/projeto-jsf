package br.com.iwt.projeto.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.com.iwt.projeto.model.Cliente;
import br.com.iwt.projeto.model.Produto;

@ManagedBean(name="compraController")
@SessionScoped
public class CompraController implements Serializable{
	
	private static final long serialVersionUID = -2469650218123267040L;
	
	private String nome;
	
	private Cliente cliente = new Cliente();
	
	private Produto produto = new Produto();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return this.produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String cadastrarProduto() {
		
		Flash flashScope = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		
		flashScope.put("zero", produto);
		
		System.out.println("produto: "+produto.getNome()+" "+produto.getCategoria());
		return "produto?faces-redirect=true";
	}
	
	public String validarLogin() {
		
		Flash flashScope = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		
		flashScope.put("usuario", cliente);
		
		return cliente.getNome().equals("osvaldo")? "inicio?faces-redirect=true" : "404?faces-redirect=true";
	}
}
