package com.samuca.insano_energy.controller;

import com.samuca.insano_energy.business.ProductService;
import com.samuca.insano_energy.infrastructure.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody Product entity) {
        service.salvarProduto(entity);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Product> buscarProdutoPorId(@RequestParam Long id) {
        return ResponseEntity.ok(service.buscarProdutoPorId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Product>> listarProdutosBuscados() {
        service.listarProdutosBuscados();
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarProdutoPorId(@RequestParam Long id) {
        service.atualizarProdutoPorId(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarProdutoPorId(@RequestParam Long id, @RequestBody Product entity) {
        service.deletarProdutoPorId(id);
        return ResponseEntity.ok().build();
    }
}
