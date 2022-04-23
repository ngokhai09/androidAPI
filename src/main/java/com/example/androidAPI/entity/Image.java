package com.example.androidAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AnhSP")
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "MaAnh")
    private String id;
    @Column(name = "MaSP")
    private String idSP;
    @Column(name = "TenAnh")
    private String imgName;
    @Column(name = "URL")
    private String url;
    @OneToOne(fetch=FetchType.EAGER)
    private Product product;
}
