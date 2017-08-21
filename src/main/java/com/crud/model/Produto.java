package com.crud.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue
	@Column(name = "produto_id")
	private Long idProduto;
	
	@Column(name = "produto_nome")
	private String produtoNome;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco")
	private BigDecimal preco;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produto) {
		this.produtoNome = produto;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	} 
	
}
