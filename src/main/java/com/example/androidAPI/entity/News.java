package com.example.androidAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TinTuc")
public class News {
    @Id
    @Column(name = "MaTT")
    private String id;
    @Column(name = "MoTa")
    private String description;
    @Column(name = "Anh")
    private String photo;
    @Column(name = "MaLoai")
    private String type;
    @Column(name = "ND")
    private String content;
}
