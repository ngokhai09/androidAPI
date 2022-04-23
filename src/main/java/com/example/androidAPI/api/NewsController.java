package com.example.androidAPI.api;

import com.example.androidAPI.entity.News;
import com.example.androidAPI.entity.Product;
import com.example.androidAPI.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NewsController {
    @Autowired
    NewsRepository newsRepository;

    @GetMapping
    public ResponseEntity<?> getAllNews(){
        List<News> news = newsRepository.findAll();
        return ResponseEntity.ok(news);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsById(@PathVariable("id") String id){
        News news = newsRepository.findById(id).orElse(null);
        if (news == null){
            return ResponseEntity.ok("Không có tin tức có id = " + id);
        }
        return ResponseEntity.ok(news);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateNew(@PathVariable("id") String id, @RequestBody News newNews){
        News news = newsRepository.findById(id).orElse(null);
        if(news == null){
            return ResponseEntity.ok("Không tìm thấy tin tức có id = " + id);
        }
        news.setDescription(newNews.getDescription());
        news.setType(newNews.getType());
        news.setContent(newNews.getContent());
        news.setPhoto(newNews.getPhoto());
        News update = newsRepository.save(news);
        return ResponseEntity.ok(update);
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteNews(@PathVariable("id") String id){
//        News news = newsRepository.findById(id).orElse(null);
//        if(news == null){
//            return ResponseEntity.ok("Không tìm thấy sản phẩm");
//        }
//        newsRepository.delete(news);
//        return ResponseEntity.ok(news);
//    }
}
