package com.restaurant.services.admin;

import com.restaurant.dtos.CategoryDto;

import java.io.IOException;

public interface AdminService {
    CategoryDto addCategory(CategoryDto categoryDto) throws IOException;
}
