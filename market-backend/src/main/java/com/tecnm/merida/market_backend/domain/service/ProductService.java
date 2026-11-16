package com.tecnm.merida.market_backend.domain.service;

import com.tecnm.merida.market_backend.domain.Product;
import com.tecnm.merida.market_backend.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarcedProduct(int quantity) {
        return productRepository.getScarcedProduct(quantity);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> update(Product product) {
        if (product.getProductID() != null && productRepository.getProduct(product.getProductID()).isPresent()) {
            return Optional.of(productRepository.save(product));
        }
        return Optional.empty();
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}