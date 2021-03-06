package com.example.androidAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SanPham")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "MaSP")
    private String id;
    @Column(name = "TenSP")
    private String name;
    @Column(name = "GTSP")
    private String description;
    @Column(name = "MaLoai")
    private String type;
    @Column(name = "SL")
    private Integer number;
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
    @OneToOne()
    @JoinColumn(name="MaGia")
    private Price price;
    @OneToOne()
    @JoinColumn(name="MaSP")
    private Image image;
}
