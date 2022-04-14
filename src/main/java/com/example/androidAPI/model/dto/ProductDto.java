package com.example.androidAPI.model.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private String description;
    private String type;
    private int number;
    private String time_create;
    private String time_update;
    private String create_person;
    private boolean is_active;
    private boolean is_delete;


}