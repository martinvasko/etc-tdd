package at.etc.coinanalyzer.controller;

import at.etc.coinanalyzer.model.Coin;
import at.etc.coinanalyzer.repository.BlockchainRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlockchainController {
    private final BlockchainRepository repository;

    BlockchainController(@Autowired BlockchainRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/statistics")
    List<Coin> all() {
        JSONArray jsonAll = repository.getAllStatistics();

        return Coin.convertJSONToCoin(jsonAll);
    }
}
