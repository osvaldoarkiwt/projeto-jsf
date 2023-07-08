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
				
		EntityManager em = new JPAUtil().getEntityManager();
	/*	
		Cliente cliente = new Cliente();
		
		cliente.setNome("Carlos");
		
		cliente.setEndereco("Bezerra de Menezes 1442");
			
		Produto p01 = new Produto();
		
		p01.setNome("Nescau");
		p01.setCategoria("Bebida Lactea");
		p01.setPreco(new BigDecimal(12.50));
		
		Produto p02 = new Produto();
		
		p02.setNome("Frango");
		p02.setCategoria("Carne branca");
		p02.setPreco(new BigDecimal(14.00));
		
		Produto p03 = new Produto();
		
		p03.setNome("Maminha");
		p03.setCategoria("Carne vermelha");
		p03.setPreco(new BigDecimal(31.20));
		
		Produto p04 = new Produto();
		
		p04.setNome("Arroz");
		p04.setCategoria("Cereal");
		p04.setPreco(new BigDecimal(4.80));
		
		Produto p01 = em.find(Produto.class,UUID.fromString("8478b5b0-0080-4764-844f-302346c85cbc"));
		
		Produto p02 = em.find(Produto.class,UUID.fromString("80c2102a-1830-40db-86ef-8fd353198d9a"));
		
		Produto p03 = em.find(Produto.class,UUID.fromString("e5969958-83aa-4e76-9748-bdd101c281b0"));
		
		Produto p04 = em.find(Produto.class,UUID.fromString("9f20a702-d319-46c1-90e4-e6d042368a5d"));

		ic01.setProduto(p01);
		
		ic01.setQuantidade(2);
		
		ic02.setProduto(p02);
		
		ic02.setQuantidade(4);
		
		ic03.setProduto(p03);
		
		ic03.setQuantidade(4);
		
		ic04.setProduto(p04);
		
		ic04.setQuantidade(10);
		
	*/	
//		Compra compra = em.find(Compra.class,UUID.fromString("03da1737-1875-4a7f-8e30-5494df605d38"));
		Cliente cliente = em.find(Cliente.class,UUID.fromString("b8fdbe64-1f93-4fb0-9dfb-7a667b547a03"));	
		
		ItemCompra ic01 = em.find(ItemCompra.class,UUID.fromString("6b06d308-e6dd-4fbe-a1be-5f6f48aa4cd0"));
		ItemCompra ic02 = em.find(ItemCompra.class,UUID.fromString("e06446cf-aedb-469f-8d07-565139ce25c9"));
		ItemCompra ic03 = em.find(ItemCompra.class,UUID.fromString("a7e5de9c-b95a-4d82-a0d5-7f94907b3bf5"));
		ItemCompra ic04 = em.find(ItemCompra.class,UUID.fromString("7182e332-4ba1-44af-80ec-3e43fff909d0"));
		
		Compra compra = new Compra();
		
		compra.setCliente(cliente);
		compra.setItems(Arrays.asList(ic01,ic02,ic03,ic04));
		compra.calculaTotal();
		
		em.getTransaction().begin();

/*		em.persist(cliente);	
		em.persist(p01);
		em.persist(p02);
		em.persist(p03);
		em.persist(p04);			
		em.persist(ic01);
		em.persist(ic02);
		em.persist(ic03);
		em.persist(ic04);
*/
		//em.persist(compra);
		
		em.getTransaction().commit();
		
		compra.getItems().forEach(item -> System.out.println(item.getProduto().getNome()));
		/*
		BigDecimal total = compra.getItems().stream()
							.map(item -> item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())))
							.reduce(BigDecimal.ZERO, (soma, item)-> soma.add(item));
							//.reduce(BigDecimal.ZERO,BigDecimal::add);
		
		//System.out.println(cliente.getNome()+" "+cliente.getEndereco());
		
		System.out.println("total: "+total);
		*/
		em.close();
		
		//util.close(em);
	}
}