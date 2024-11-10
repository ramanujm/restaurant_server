package com.restaurant.controllers;

import com.restaurant.dtos.CategoryDto;
import com.restaurant.dtos.ProductDto;
import com.restaurant.dtos.ReservationDto;
import com.restaurant.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*" , exposedHeaders = "**")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryDtoList = customerService.getAllCategories();
        if (categoryDtoList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryDtoList);
    }

    @GetMapping("/categories/{title}")
    public ResponseEntity<List<CategoryDto>> getCategoriesByTitle(@PathVariable String title) {
        List<CategoryDto> categoryDtoList = customerService.getAllCategoriesByTitle(title);
        if (categoryDtoList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryDtoList);
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable Long categoryId) {
        List<ProductDto> productDtoList = customerService.getProductsByCategory(categoryId);
        if (productDtoList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDtoList);
    }

    @GetMapping("/{categoryId}/product/{title}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryAndTitle(@PathVariable Long categoryId, @PathVariable String title) {
        List<ProductDto> productDtoList = customerService.getProductsByCategoryAndTitle(categoryId, title);
        if (productDtoList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDtoList);
    }

    @PostMapping("/reservation")
    public ResponseEntity<?> postReservation(@RequestBody ReservationDto reservationDto) throws IOException {
        ReservationDto postReservationDto = customerService.postReservation(reservationDto);
        if(postReservationDto == null) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
        return  ResponseEntity.status(HttpStatus.CREATED).body(postReservationDto);
    }

    @GetMapping("/reservations/{customerId}")
    public ResponseEntity<List<ReservationDto>> getReservationByUser(@PathVariable Long customerId) {
        List<ReservationDto> reservationDtoList = customerService.getReservationByUser(customerId);
        if (reservationDtoList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservationDtoList);
    }


}
