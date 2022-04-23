package com.example.androidAPI.entity;

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
@Table(name = "KhachHang")
public class User {
    @Id
    @Column(name = "MaKh")
    private String id;
    @Column(name = "HoTen")
    private String name;
    @Column(name = "GioiTinh")
    private String sex;
    @Column(name = "Tuoi")
    private String age;
    @Column(name = "Email")
    private String email;
    @Column(name = "SDT")
    private String phoneNumber;
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
    @Column(name="TaiKhoan")
    private String userName;
    @Column(name="MatKhau")
    private String password;
    @Column(name="DiaChi")
    private String address;
}
