package com.doctorhoai.product_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude( JsonInclude.Include.NON_DEFAULT)
public class Category extends AbtractMapped implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "category_id", updatable = false)
    private Long categoryId;
    private String categoryTitle;
    private String imageUrl;
    @JsonIgnore
    @OneToMany( mappedBy = "parentCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Category> subCategories = new HashSet<>();

    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @JsonIgnore
    @OneToMany( mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

}
