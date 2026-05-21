package com.samuca.insano_energy.business;

import com.samuca.insano_energy.infrastructure.entity.Product;
import com.samuca.insano_energy.infrastructure.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void salvarProduto(Product entity) {
        repository.save(entity);
    }

    public Product buscarProdutoPorId(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Produto não encontrado!"));
    }

    public void atualizarProdutoPorId(Long id) {
        Product productEntity = new Product();
        Product searchProduct = buscarProdutoPorId(id);
        Product updatedProduct = Product.builder().id(id)
                .marca(productEntity.getMarca() != null ? productEntity.getMarca() : searchProduct.getMarca())
                .sabor(productEntity.getSabor() != null ? productEntity.getSabor() : searchProduct.getSabor())
                .quantidade(productEntity.getQuantidade() != null ? productEntity.getQuantidade() : searchProduct.getQuantidade())
                .valor(productEntity.getValor() != null ? productEntity.getValor() : searchProduct.getValor())
                .build();
    }

    public void deletarProdutoPorId(Long id) {
        repository.deleteById(id);
    }

    public List<Product> listarProdutosBuscados() {
        return repository.findAll();
    }
}