package com.crypto.demo;

import com.crypto.demo.model.Coin;
import com.crypto.demo.service.CoinService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

@SpringBootApplication
public class CryptoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoWebApplication.class, args);
    }

    /*
    @Bean
    CommandLineRunner runner(CoinService coinService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Coin>> typeReference = new TypeReference<List<Coin>>() {
            };
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

            String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false";
            URL obj = new URL(url);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");

            int rC = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            InputStream inputStream1 = con.getInputStream();
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/coins.json");
            try {
                List<Coin> coins = mapper.readValue(inputStream1, typeReference);
                coinService.save(coins);
                System.out.println("Coins Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save coins: " + e.getMessage());
            }


        };
    }*/


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder.setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000)).build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


}
