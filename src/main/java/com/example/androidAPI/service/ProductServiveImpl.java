package com.example.androidAPI.service;

import com.example.androidAPI.entity.Product;
import com.example.androidAPI.model.dto.ProductDto;
import com.example.androidAPI.model.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ProductServiveImpl implements ProductService{
    private static ArrayList<Product> products = new ArrayList<>();

    @Override
    public List<ProductDto> getListProduct() {
        List<ProductDto> result = new ArrayList<>();
        for(Product product:products){
            result.add(ProductMapper.toProductDto(product));
        }
        return result;
    }

    @Override
    public ProductDto getProductById(String id) {
        for(Product product: products){
            if(Objects.equals(product.getId(), id)){
                return ProductMapper.toProductDto(product);
            }
        }
        return null;
    }
}
