package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crud.model.Produto;
import com.crud.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@RequestMapping("/cadastrar/produto")
	public String paginaProdutoCadastra(Model model){
		model.addAttribute("produto", new Produto());
		return "cadastrarProduto";
	}
	
	@PostMapping("/cadastrar/produto")
	public String cadastrarProduto(Produto produto) {
		this.produtoRepository.save(produto);
		return "redirect:/produto";	
	}
	
	@RequestMapping("/produto")
	public ModelAndView produtoListar() { 
		ModelAndView modelAndView = new ModelAndView("ListaProdutos");
		modelAndView.addObject("produtoRepository", produtoRepository.findAll());
		modelAndView.addObject("produto", new Produto());
		return modelAndView;
	}
	
	@RequestMapping("/produto/{idProduto}")
    public String mostrarProduto(@PathVariable Long idProduto, Model model){
        model.addAttribute("produto", produtoRepository.findOne(idProduto));
        return "mostrarProduto";
    }
	
	@RequestMapping("/produto/editar/{idProduto}")
    public String editarProduto(@PathVariable Long idProduto, Model model){
		model.addAttribute("produto", produtoRepository.findOne(idProduto)); 
        return "cadastrarProduto";
    }
        
    @RequestMapping("/produto/excluir/{idProduto}")
    public String excluir(@PathVariable Long idProduto){
        produtoRepository.delete(idProduto);
        return "redirect:/produto";
    }
		
}
