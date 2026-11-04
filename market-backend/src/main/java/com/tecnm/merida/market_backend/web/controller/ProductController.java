package com.tecnm.merida.market_backend.web.controller;


import com.tecnm.merida.market_backend.domain.Product;
import com.tecnm.merida.market_backend.domain.service.ProductService;
import com.tecnm.merida.market_backend.persistence.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.nio.file.Files.delete;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ProductoRepository productoRepository;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId) {
        return productService.getProduct(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("//category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable int productId) {
        return productService.getByCategory(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());


}
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable int productId) {
        if (productService.delete(productId)) {
            return ResponseEntity.ok().build();
        } {
            return ResponseEntity.notFound().build();
        }
    }

}