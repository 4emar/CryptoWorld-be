package com.crypto.demo.web;

import com.crypto.demo.model.Coin;
import com.crypto.demo.service.CoinService;
import com.crypto.demo.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/coins", produces = MediaType.APPLICATION_JSON_VALUE)
public class CoinController {
    private final CoinService coinService;
    private final UserService userService;

    public CoinController(CoinService coinService, UserService userService) {
        this.coinService = coinService;
        this.userService = userService;
    }


    @GetMapping
    public Iterable<Coin> list() {
        return coinService.list();
    }

/*
    @PostMapping("/addCoin/{coinId}/user/{username}")
    public HttpStatus addCoinToFavorites(@PathVariable String coinId, @PathVariable String username){
        this.userService.addToFavorites(coinId, username);
        return HttpStatus.OK;
    }
*/

}
