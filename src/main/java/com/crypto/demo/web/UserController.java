package com.crypto.demo.web;

import com.crypto.demo.model.Coin;
import com.crypto.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addCoin/{coinId}/user/{username}")
    public HttpStatus addCoinToFavorites(@PathVariable String coinId, @PathVariable String username){
        this.userService.addToFavorites(coinId, username);
        return HttpStatus.OK;
    }

    @DeleteMapping("/deleteCoin/{coinId}/user/{username}")
    public HttpStatus deleteCoinFromFavorites(@PathVariable String coinId, @PathVariable String username){
        this.userService.deleteCoinFromFavorites(coinId, username);
        return HttpStatus.OK;
    }

    @GetMapping("/favorites/{username}")
    public Set<Coin> getFavorites(@PathVariable String username){
        return this.userService.getFavorites(username);
    }
}
