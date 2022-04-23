package com.example.androidAPI.repository;

import com.example.androidAPI.entity.Product;
import com.example.androidAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select * from khach_hang where Tai_Khoan = :username", nativeQuery = true)
    User findByUserName(String username);
}
