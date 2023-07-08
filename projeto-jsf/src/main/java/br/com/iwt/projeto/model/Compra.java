package br.com.iwt.projeto.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="compras")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "compra_id", updatable = false, unique = true, nullable = false)
	@EqualsAndHashCode.Include
	private UUID id;
	
	@ManyToMany
	private List<ItemCompra> items;
	
	@ManyToOne
	private Cliente cliente;
	
	private BigDecimal total;
	
	public void calculaTotal() {
		
			this.total = this.items.stream()
				.map(item -> item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())))
				.reduce(BigDecimal.ZERO,BigDecimal::add);
				//.reduce(BigDecimal.ZERO, (soma, item)-> soma.add(item));
	}
	
}