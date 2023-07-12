package com.bolsadeideas.springboot.backend.apirest.controllers;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Factura;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Producto;
import com.bolsadeideas.springboot.backend.apirest.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FacturaRestController {

    @Autowired
    private IClienteService clienteService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/facturas/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Factura factura;
        Map<String, Object> response = new HashMap<>();
        try {
            factura = clienteService.findFacturaById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Ha habido un error en el sevidor");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (factura == null) {
            response.put("mensaje", "La factura con id: " + id + " no existe.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(factura, HttpStatus.OK);
    }
    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/facturas/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Factura factura = null;
        Map<String, Object> response = new HashMap<>();
        try {
            factura = clienteService.findFacturaById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Ha habido un error en el sevidor");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (factura == null) {
            response.put("mensaje", "La factura con id: " + id + " no existe.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            clienteService.deleteFactura(id);
            response.put("mensaje", "Factura con id: " + factura.getId() + " eliminada con exito.");
            return new ResponseEntity<>(factura, HttpStatus.OK);
        }
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/facturas/filtrar-producto/{term}")
    public ResponseEntity<?> filtrarProductos(@PathVariable String term) {
        List<Producto> listaProductos = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        try {
            listaProductos = clienteService.findProductoByNombre(term);
        } catch (DataAccessException e) {
            response.put("mensaje", "Ha habido un error en el sevidor");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/facturas")
    public ResponseEntity<?> crearFactura(@RequestBody Factura factura) {
        Map<String, Object> response = new HashMap<>();
        try {
            clienteService.saveFactura(factura);
            response.put("mensaje", "Se ha guardado la factura con exito");
        } catch (DataAccessException e) {
            response.put("mensaje", "Ha habido un error en el sevidor");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
