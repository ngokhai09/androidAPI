package com.example.androidAPI.api;

import com.example.androidAPI.entity.Product;
import com.example.androidAPI.entity.User;
import com.example.androidAPI.model.dto.ProductDto;
import com.example.androidAPI.model.dto.UserDto;
import com.example.androidAPI.repository.ProductRepository;
import com.example.androidAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String userName) {
        User user = userRepository.findByUserName(userName);
        if(user == null){
            return ResponseEntity.ok("Sai tên tài khoản hoặc mật khẩu");
        }
        return ResponseEntity.ok().body(user);
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto newUser){
        User user = new User();
        user.setId(newUser.getUserName());
        user.set_active(true);
        user.set_delete(false);
        user.setAddress(newUser.getAddress());
        user.setCreate_person("");
        user.setAge(newUser.getAge());
        user.setUserName(newUser.getUserName());
        user.setEmail(newUser.getUserName());
        user.setName(newUser.getName());
        user.setPassword(newUser.getPassword());
        user.setTime_create(Calendar.getInstance().getTime().toString());
        user.setTime_update("");
        user.setSex("");
        user.setPhoneNumber(newUser.getPhoneNumber());
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }




}
