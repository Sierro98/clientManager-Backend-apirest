package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.dto.UserDto;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.http.ResponseEntity;

public interface IUsuarioService {

	public Usuario findByUsername(String username);

}
