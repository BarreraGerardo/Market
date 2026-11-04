package com.tecnm.merida.market_backend.persistence.mapper;

import com.tecnm.merida.market_backend.domain.Category;
import com.tecnm.merida.market_backend.persistence.entity.Categoria;
import com.tecnm.merida.market_backend.persistence.entity.Producto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings(value = {
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    default Category toCategory(Categoria categoria) {
        return null;
    }

    @InheritInverseConfiguration
    @Mapping(target = "estado", ignore = true)
    Categoria toCategoria(Category category);
}