package com.example.androidAPI.repository;

import com.example.androidAPI.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, String> {
}
