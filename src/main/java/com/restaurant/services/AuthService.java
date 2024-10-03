package com.restaurant.services;

import com.restaurant.dtos.SignupRequest;
import com.restaurant.dtos.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
}
