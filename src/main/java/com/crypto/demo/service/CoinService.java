package com.crypto.demo.service;
import com.crypto.demo.model.Coin;
import com.crypto.demo.repository.CoinRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    private final CoinRepository coinRepository;

    public CoinService(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    public Iterable<Coin> list(){
        return this.coinRepository.findAll(Sort.by("marketCapRank").ascending());

    }

    public Coin save(Coin coin){
        return coinRepository.save(coin);
    }

    public Iterable<Coin> save(List<Coin> coins){
        return coinRepository.saveAll(coins);
    }


}
