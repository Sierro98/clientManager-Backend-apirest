package com.bolsadeideas.springboot.backend.apirest.models.dao;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleDao extends CrudRepository<Role, Long> {

    public Role findByNombre(String nombre);
}
