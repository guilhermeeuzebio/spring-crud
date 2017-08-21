package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crud.model.Produto;
import com.crud.repository.ProdutoRepository;

@Controller
public class IndexController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@RequestMapping("/")
	public ModelAndView pindex() { 
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("produtoRepository", produtoRepository.findAll());
		modelAndView.addObject("produto", new Produto());
		return modelAndView;
	}	
	
}
