package com.crypto.demo.service;

import com.crypto.demo.model.Coin;
import com.crypto.demo.model.Dto.GetCoinDto;
import com.crypto.demo.repository.CoinRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class UpdateClass implements ApplicationRunner {

    private final CoinRepository coinRepository;

    public UpdateClass(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(() -> {
            try {
                updateCoins();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.DAYS);
    }

    private void updateCoins() throws IOException {
        URL url = new URL("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false");
        URLConnection connection = url.openConnection();
        connection.connect();
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonResponse = jsonParser.parse(new InputStreamReader(connection.getInputStream())).getAsJsonArray();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<GetCoinDto> getCoinDtoList = objectMapper.readValue(jsonResponse.toString(),
                new TypeReference<List<GetCoinDto>>() {});
        mapGetCoinDtoToCoinEntity(getCoinDtoList);
    }

    private void mapGetCoinDtoToCoinEntity(List<GetCoinDto> getCoinDtoList) {
        getCoinDtoList.forEach(coinDto -> {
            Coin coin = new Coin();
            coin.setId(coinDto.getId());
            coin.setName(coinDto.getName());
            coin.setCurrentPrice(coinDto.getCurrent_price());
            coin.setMarketCapRank(Integer.parseInt(coinDto.getMarket_cap_rank()));
            coin.setMarketCap(coinDto.getMarket_cap());
            coin.setImage(coinDto.getImage());
            coin.setSymbol(coinDto.getSymbol());
            this.coinRepository.save(coin);
        });

    }
}
