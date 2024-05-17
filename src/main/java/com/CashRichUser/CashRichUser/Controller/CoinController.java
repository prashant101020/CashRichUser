package com.CashRichUser.CashRichUser.Controller;

import com.CashRichUser.CashRichUser.Entity.CoinDataResponse;
import com.CashRichUser.CashRichUser.Service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/coin")
public class CoinController {

    @Autowired
    CoinService coinService;

    @GetMapping("/{userid}")
    public ResponseEntity<CoinDataResponse> getCoinData(@PathVariable("userid") int userId){

        CoinDataResponse coinDataResponse= coinService.getCoinData(userId);
        return ResponseEntity.ok().body(coinDataResponse);
    }
}
