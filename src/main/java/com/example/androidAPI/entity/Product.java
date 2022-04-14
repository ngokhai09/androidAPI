package com.example.androidAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SanPham")
public class Product {
    @Id
    @Column(name = "MaSP")
    private String id;
    @Column(name = "TenSP")
    private String name;
    @Column(name = "GTSP")
    private String description;
    @Column(name = "MaLoai")
    private String type;
    @Column(name = "SL")
    private int number;
    @Column(name = "Time_Create")
    private String time_create;
    @Column(name = "Time_Update")
    private String time_update;
    @Column(name = "Nguoi_Tao")
    private String create_person;
    @Column(name = "isActive")
    private boolean is_active;
    @Column(name = "isDelete")
    private boolean is_delete;
}
