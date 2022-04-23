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
@Table(name = "GiaSP")
public class Price {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "MaGia")
    private String id;
    @Column(name = "MaSP")
    private String name;
    @Column(name = "Gia")
    private String price;
    @Column(name = "Time_Begin")
    private String time_begin;
    @Column(name = "Time_End")
    private String time_end;
    @OneToOne(fetch=FetchType.EAGER, mappedBy="price")
    private Product product;
}
