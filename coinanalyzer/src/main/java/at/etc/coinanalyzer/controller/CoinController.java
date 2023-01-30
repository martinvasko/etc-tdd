package at.etc.coinanalyzer.controller;

import at.etc.coinanalyzer.model.Coin;
import at.etc.coinanalyzer.model.Map;
import at.etc.coinanalyzer.repository.CoinRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoinController {
    private final CoinRepository repository;

    CoinController(@Autowired CoinRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/coins")
    List<Coin> all() {
        JSONArray jsonAll = repository.findAll();
        return Coin.convertJSONToCoin(jsonAll);
    }

    @GetMapping("/map")
    List<Map> mapAll() {
        JSONArray jsonAll = repository.mapAll();
        return Map.convertJSONToMap(jsonAll);
    }
}
