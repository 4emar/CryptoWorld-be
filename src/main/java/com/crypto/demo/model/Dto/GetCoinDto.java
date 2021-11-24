package com.crypto.demo.model.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCoinDto implements Serializable {

    private String id;

    private String symbol;

    private String name;

    private String image;

    private String current_price;

    private String market_cap;

    private String market_cap_rank;

    private String total_volume;
}
