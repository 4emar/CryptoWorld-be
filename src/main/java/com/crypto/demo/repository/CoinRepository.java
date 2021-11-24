package com.crypto.demo.repository;

import com.crypto.demo.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoinRepository extends JpaRepository<Coin, String> {
}
