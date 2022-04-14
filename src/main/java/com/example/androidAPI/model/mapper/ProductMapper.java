package com.example.androidAPI.model.mapper;

import com.example.androidAPI.entity.Product;
import com.example.androidAPI.model.dto.ProductDto;

public class ProductMapper {
    public static ProductDto toProductDto(Product product){
        ProductDto tmp = new ProductDto();
        tmp.setId(product.getId());
        tmp.setName(product.getName());
        tmp.setDescription(product.getDescription());
        tmp.setType(product.getType());
        tmp.setNumber(product.getNumber());
        tmp.setTime_create(product.getTime_create());
        tmp.setTime_update(product.getTime_update());
        tmp.setCreate_person(product.getCreate_person());
        tmp.set_active(product.is_active());
        tmp.set_delete(product.is_delete());
        return tmp;
    }
}
