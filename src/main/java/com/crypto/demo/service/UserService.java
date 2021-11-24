package com.crypto.demo.service;



import com.crypto.demo.model.Coin;
import com.crypto.demo.model.Dto.JwtResponseDto;
import com.crypto.demo.model.Dto.LoginDto;
import com.crypto.demo.model.Dto.RegisterDto;
import com.crypto.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User findById(String username);

    List<User> findAll();

    JwtResponseDto signInUser(LoginDto loginDto);

    void signUpUser(RegisterDto registerDto);

    void addToFavorites(String coinId, String username);

    void deleteCoinFromFavorites(String coinId, String username);

    Set<Coin> getFavorites(String username);
}
