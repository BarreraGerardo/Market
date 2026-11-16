package com.tecnm.merida.market_backend.persistence;

import com.tecnm.merida.market_backend.domain.Category;
import com.tecnm.merida.market_backend.domain.repository.CategoryRepository; // <-- ESTA LÍNEA ES CLAVE
import com.tecnm.merida.market_backend.persistence.crud.CategoriaCrudRepository;
import com.tecnm.merida.market_backend.persistence.entity.Categoria;
import com.tecnm.merida.market_backend.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) categoriaCrudRepository.findAll();
        return mapper.toCategories(categorias); // Asegúrate de tener este método en CategoryMapper
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoriaCrudRepository.findById(categoryId)
                .map(categoria -> mapper.toCategory(categoria));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return mapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public void delete(int categoryId) {
        categoriaCrudRepository.deleteById(categoryId);
    }
}