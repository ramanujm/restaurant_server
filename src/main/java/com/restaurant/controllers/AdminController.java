package com.restaurant.controllers;

import com.restaurant.dtos.CategoryDto;
import com.restaurant.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> AddCategory(@ModelAttribute CategoryDto categoryDto) throws IOException {
        CategoryDto createdCategoryDto = adminService.addCategory(categoryDto);
        if(createdCategoryDto == null) {
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(createdCategoryDto);

    }
}
