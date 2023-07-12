package com.bolsadeideas.springboot.backend.apirest.models.dao;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductoDao extends CrudRepository<Producto, Long> {
    public List<Producto> findByNombreContainingIgnoreCase(String name);

    public List<Producto> findByNombreStartingWithIgnoreCase(String name);

}
