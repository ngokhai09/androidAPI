package com.example.androidAPI.api;

import com.example.androidAPI.entity.Product;
import com.example.androidAPI.model.dto.ProductDto;
import com.example.androidAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findByActive();
        return ResponseEntity.ok(products);
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") String id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return ResponseEntity.ok("Không tìm thấy sản phẩm");
        }
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id,@RequestBody Product newProduct) {
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return ResponseEntity.ok("Không tìm thấy sản phẩm");
        }
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setType(newProduct.getType());
        product.setNumber(newProduct.getNumber());
        product.setTime_create(newProduct.getTime_create());
        product.setTime_update(newProduct.getTime_update());
        product.setCreate_person(newProduct.getCreate_person());
        product.set_active(newProduct.is_active());
        product.set_delete(newProduct.is_delete());
        Product update = productRepository.save(product);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return ResponseEntity.ok("Không tìm thấy sản phẩm");
        }
        if(product.is_delete()){
            return ResponseEntity.ok("Sản phẩm đã xóa");
        }
        product.set_delete(true);
        product.set_active(false);
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/filter/new")
    public ResponseEntity<?> newProduct(){
        Date date = Calendar.getInstance().getTime();
        List<Product> products = productRepository.findByDay(new SimpleDateFormat("dd").format(date), new SimpleDateFormat("MM").format(date), new SimpleDateFormat("yyyy").format(date));
        if(products.size() == 0){
            return ResponseEntity.ok("Không có sản phẩm trong ngày");
        }
        return ResponseEntity.ok(products);
    }
    @GetMapping("/filter/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") String id){
        List<Product> products = productRepository.findByCatagory(id);
        if(products.size() == 0){
            return ResponseEntity.ok("Không có sản phẩm loại này");
        }
        return ResponseEntity.ok(products);
    }
}
