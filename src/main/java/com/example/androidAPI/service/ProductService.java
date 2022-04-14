package com.example.androidAPI.service;

import com.example.androidAPI.entity.Product;
import com.example.androidAPI.model.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<ProductDto> getListProduct();
    public ProductDto getProductById(String id);
}
