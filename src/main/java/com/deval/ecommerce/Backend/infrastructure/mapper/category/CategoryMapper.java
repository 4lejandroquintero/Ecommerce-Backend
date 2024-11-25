package com.deval.ecommerce.Backend.infrastructure.mapper.category;

import com.deval.ecommerce.Backend.domain.model.category.Category;
import com.deval.ecommerce.Backend.infrastructure.entity.category.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "dateUpdated", target = "dateUpdated")
            }
    )

    Category toCategory(CategoryEntity categoryEntity); //() es la fuente
    Iterable<Category> toCategoryList( Iterable<CategoryEntity> categoryEntities);

    @InheritInverseConfiguration
        //configuracion inversa
    CategoryEntity toCategoryEntity(Category category);
}