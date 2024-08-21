package com.doctorhoai.product_service.service.impl;

import com.doctorhoai.product_service.dto.ProductDto;
import com.doctorhoai.product_service.entity.Product;
import com.doctorhoai.product_service.exception.ProductNotFound;
import com.doctorhoai.product_service.hepler.CategoryMapper;
import com.doctorhoai.product_service.hepler.ProductMapper;
import com.doctorhoai.product_service.repository.ProductRepository;
import com.doctorhoai.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<ProductDto> findAll() {
        return repository.findAll().stream().map(
                product ->
                    ProductMapper.mapToProductDto(product)
        ).distinct().collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long productId) {

        return ProductMapper.mapToProductDto(
                Optional.of(repository.findById(productId).get())
                        .orElseThrow( () -> new ProductNotFound("Product with productId : " + productId.toString() + " not found"))
        );
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        log.info(" **saveing {}", productDto);
        return ProductMapper.mapToProductDto(repository.save(ProductMapper.mapToProduct(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return ProductMapper.mapToProductDto(repository.save(ProductMapper.mapToProduct(productDto)));

    }

    @Override
    public ProductDto update(Long productId, ProductDto product) {
        Optional<Product> productOld = repository.findById(productId);
        if( productOld.isEmpty() ) throw new ProductNotFound("Product with product Id " + productId + " not found");
        if( product.getProductTitle() != null){
            productOld.get().setProductTitle(product.getProductTitle());
        }
        if( product.getImageUrl() != null){
            productOld.get().setImageUrl(product.getImageUrl());
        }
        if( product.getPriceUnit() != null){
            productOld.get().setPriceUnit(product.getPriceUnit());
        }
        if( product.getQuantity() != null){
            productOld.get().setQuantity(product.getQuantity());
        }
        if( product.getSku() != null){
            productOld.get().setSku(product.getSku());
        }
        if( product.getCategoryDto() != null){
            productOld.get().setCategory(CategoryMapper.mapToCategory(product.getCategoryDto()));
        }

        return ProductMapper.mapToProductDto(repository.save(productOld.get()));
    }

    @Override
    public void deleteById(Long productId) {
        repository.findById(productId) .orElseThrow( () -> new ProductNotFound("Product with productId : " + productId.toString() + " not found"));
        repository.deleteById(productId);
    }
}
