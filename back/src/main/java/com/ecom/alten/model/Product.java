package com.ecom.alten.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private String image;
    private String category;
    private Double price;
    private Integer quantity;
    private String internalReference;


    @Enumerated(EnumType.STRING)
    private InventoryStatus inventoryStatus;
    private Double rating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum InventoryStatus {
        INSTOCK, LOWSTOCK, OUTOFSTOCK
    }

}
