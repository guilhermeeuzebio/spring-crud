package com.crud.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.model.Usuario;
import com.crud.repository.UsuarioRepository;
import com.crud.model.Role;
import com.crud.repository.RoleRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
    private RoleRepository roleRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    public Usuario findUserByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
    
	public Usuario salvarUsuario(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuario.setEnabled(true);
        Role usuarioRole = roleRepository.findByRole("ADMIN");
		usuario.setRoles(new HashSet<Role>(Arrays.asList(usuarioRole)));
		return usuarioRepository.save(usuario);
	}
}
