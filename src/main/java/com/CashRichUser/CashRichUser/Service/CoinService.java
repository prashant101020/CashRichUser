package com.CashRichUser.CashRichUser.Service;

import com.CashRichUser.CashRichUser.Entity.CoinDataResponse;
import com.CashRichUser.CashRichUser.Repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;

import java.util.Optional;

@Service
public class CoinService {
    private static final String API_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
    private static final String API_KEY = "27ab17d1-215f-49e5-9ca4-afd48810c149";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    CoinRepository coinRepository;
    public void saveCoin(int user_id){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", API_KEY);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_URL);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<CoinDataResponse> response = restTemplate.exchange(
                builder.toUriString(), HttpMethod.GET, entity, CoinDataResponse.class);
        response.getBody().setUser(user_id);
        coinRepository.save(response.getBody());
    }
    public CoinDataResponse getCoinData(int user_id) {

         Optional<CoinDataResponse> coinDataResponse=coinRepository.findById(user_id);
        return  coinDataResponse.get();
    }
}


