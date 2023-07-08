package br.com.iwt.projeto.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="items_compra")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_compra_id", updatable = false, unique = true, nullable = false)
	@EqualsAndHashCode.Include
	private UUID id;
	
	@OneToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	private Integer quantidade;
}