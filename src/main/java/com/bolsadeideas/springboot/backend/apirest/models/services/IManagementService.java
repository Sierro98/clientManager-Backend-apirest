package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface IManagementService {

    public ResponseEntity<?> signUser(UserDto user);
}
