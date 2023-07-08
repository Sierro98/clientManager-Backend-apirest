package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.dto.UserDto;
import com.bolsadeideas.springboot.backend.apirest.models.dao.IRoleDao;
import com.bolsadeideas.springboot.backend.apirest.models.dao.IUsuarioDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ManagementServiceImpl implements IManagementService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final IUsuarioDao usuarioDao;
    private final IRoleDao roleDao;

    @Autowired
    public ManagementServiceImpl(BCryptPasswordEncoder passwordEncoder, IUsuarioDao usuarioDao, IRoleDao roleDao) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioDao = usuarioDao;
        this.roleDao = roleDao;
    }

    @Override
    public ResponseEntity<?> signUser(UserDto user) {
        Map<String, Object> response = new HashMap<>();
        Usuario usuario = new Usuario();
        if (usuarioDao.findByUsername(user.getUsername()) == null || usuarioDao.findByEmail(user.getEmail()) == null) {
            try {
                usuario.setNombre(user.getNombre());
                usuario.setApellido(user.getApellido());
                usuario.setUsername(user.getUsername());
                usuario.setEmail(user.getEmail());
                usuario.setEnabled(true);
                if (user.getRole().equals("ROLE_ADMIN")) {
                    usuario.setRoles(
                            Arrays.asList(roleDao.findByNombre("ROLE_ADMIN"), roleDao.findByNombre("ROLE_USER")));
                } else {
                    usuario.setRoles(Collections.singletonList(roleDao.findByNombre("ROLE_USER")));
                }
                if (user.getPassword() != null && user.getMatchingPassword() != null) {
                    if (user.getPassword().equals(user.getMatchingPassword())) {
                        usuario.setPassword(passwordEncoder.encode(user.getPassword()));
                    }
                }
                usuarioDao.save(usuario);
                response.put("mensaje", "Usuario registrado con exito");
            } catch (DataAccessException e) {
                response.put("mensaje", "Ha sucedido un error al registrar el usuario");
                response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else if (usuarioDao.findByUsername(user.getUsername()) != null) {
            response.put("mensaje", "Ha sucedido un error al registrar el usuario");
            response.put("error", "El usuario: " + user.getUsername() + " ya está registrado");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else if (usuarioDao.findByEmail(user.getEmail()) != null) {
            response.put("mensaje", "Ha sucedido un error al registrar el usuario");
            response.put("error", "El correo: " + user.getEmail() + " ya está en uso");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

