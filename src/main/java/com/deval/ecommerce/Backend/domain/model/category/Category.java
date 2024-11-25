package com.deval.ecommerce.Backend.domain.model.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data //Getter y Setter
@AllArgsConstructor //Definir constructor con todos atributos
@NoArgsConstructor //Constructor vacío
public class Category {
    private Integer id;
    private String name;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
