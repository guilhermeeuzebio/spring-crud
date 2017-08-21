package com.crud.service;

import com.crud.model.Usuario;

public interface UsuarioService {
	
	public Usuario findUserByEmail(String email);
	Usuario salvarUsuario(Usuario usuario);
	
}
