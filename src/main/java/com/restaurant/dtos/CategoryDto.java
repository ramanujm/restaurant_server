package com.restaurant.dtos;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CategoryDto {
    private Long Id;
    private String name;
    private String description;
    private MultipartFile img;
    private byte[] returnedImg;
}
