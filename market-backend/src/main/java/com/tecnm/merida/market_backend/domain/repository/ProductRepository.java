package com.tecnm.merida.market_backend.domain.repository;

import com.tecnm.merida.market_backend.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    static List<Product> getAll() {
        return null;
    }

    Optional<List<Product>> getByCategory(int categoryId);
Optional<List<Product>>  getScarcedProduct(int quantity);
Optional<Product> getProduct(int productId);
Product save(Product product);
void delete(int productId);
}
