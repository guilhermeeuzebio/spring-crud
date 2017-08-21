package com.crud.service;

import org.springframework.stereotype.Service;

import com.crud.model.Produto;
import com.crud.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	private ProdutoRepository produtoRepository;
	
	public Produto cadastrarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
    public Iterable<Produto> produtoListar() {
        return produtoRepository.findAll();
    }

    public Produto editarProduto(Long idProduto) {
        return produtoRepository.findOne(idProduto);
    }
    
    public void excluirProduto(Long idProduto) {
    	produtoRepository.delete(idProduto);
    }
	

}
