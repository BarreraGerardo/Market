package com.tecnm.merida.market_backend.domain.service;

import com.tecnm.merida.market_backend.domain.Category;
import com.tecnm.merida.market_backend.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return categoryRepository.getCategory(categoryId);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> update(Category category) {
        if (categoryRepository.getCategory(category.getId()).isPresent()) {
            return Optional.of(categoryRepository.save(category));
        }
        return Optional.empty();
    }

    public boolean delete(int categoryId) {
        if (getCategory(categoryId).isPresent()) {
            categoryRepository.delete(categoryId);
            return true;
        }
        return false;
    }
}