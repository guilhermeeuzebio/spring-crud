package com.crud.service;

import com.crud.model.Produto;

public interface ProdutoService {
	
	Produto cadastrarProduto(Produto produto);
	
    Iterable<Produto> produtoListar();

    Produto editarProduto(Long idProduto);
    
    void excluirProduto(Long idProduto); 

}
