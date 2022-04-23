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
    @Query(value = "select san_pham.MaSP, TenSP, GTSP, Gia, nguoi_tao, is_active, is_delete, sl, ma_loai, time_create, time_update, giasp.ma_gia from san_pham inner join giasp on san_pham.MaSP = giasp.masp where is_active =1", nativeQuery = true)
    List<Product> findByActive();
    @Query(value = "select san_pham.MaSP, TenSP, GTSP, Gia, nguoi_tao, is_active, is_delete, sl, ma_loai, time_create, time_update, giasp.ma_gia, url from san_pham inner join giasp on san_pham.MaSP = giasp.masp inner join AnhSP on san_pham.MaSP = AnhSP.MaSP where Day(Time_Create) = :day and Month(Time_Create) = :month and Year(Time_Create) = :year", nativeQuery = true)
    List<Product> findByDay(@Param("day") String day, @Param("month") String month, @Param("year") String year);
    @Query(value = "select san_pham.MaSP, TenSP, GTSP, Gia, nguoi_tao, is_active, is_delete, sl, ma_loai, time_create, time_update, giasp.ma_gia, url from san_pham inner join giasp on san_pham.MaSP = giasp.masp inner join AnhSP on san_pham.MaSP = AnhSP.MaSP where MaLoai = :MaLoai", nativeQuery = true)
    List<Product> findByCatagory(@Param("MaLoai") String MaLoai);
    @Query(value = "select san_pham.MaSP, TenSP, GTSP, Gia, nguoi_tao, is_active, is_delete, sl, ma_loai, time_create, time_update, giasp.ma_gia, url from san_pham inner join giasp on san_pham.MaSP = giasp.masp inner join AnhSP on san_pham.MaSP = AnhSP.MaSP where TenSP = :Name", nativeQuery = true)
    List<Product> findByName(@Param("Name") String Name);
}
