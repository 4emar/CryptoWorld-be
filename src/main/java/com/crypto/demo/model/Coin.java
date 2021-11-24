package com.crypto.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Coin {

    @Id
    @Column(name = "coin_id")
    private String id;

    @Column(name = "coin_symbol")
    private String symbol;

    @Column(name = "coin_name")
    private String name;

    @Column(name = "coin_image")
    private String image;

    @Column(name = "coin_price")
    private String currentPrice;

    @Column(name = "coin_market_cap")
    private String marketCap;

    @Column(name = "coin_market_cap_rank")
    private Integer marketCapRank;

    @Column(name = "total_volume")
    private String totalVolume;

}
