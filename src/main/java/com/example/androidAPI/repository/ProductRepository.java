package com.example.androidAPI.repository;

import com.example.androidAPI.entity.Product;
import com.example.androidAPI.model.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "select * from san_pham where is_active = 1", nativeQuery = true)
    List<Product> findByActive();
    @Query(value = "select * from san_pham where Day(Time_Create) = :day and Month(Time_Create) = :month and Year(Time_Create) = :year", nativeQuery = true)
    List<Product> findByDay(@Param("day") String day, @Param("month") String month, @Param("year") String year);
    @Query(value = "select * from san_pham where MaLoai = :MaLoai", nativeQuery = true)
    List<Product> findByCatagory(@Param("MaLoai") String MaLoai);
}
