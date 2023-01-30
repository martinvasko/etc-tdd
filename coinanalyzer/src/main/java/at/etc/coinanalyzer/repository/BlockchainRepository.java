package at.etc.coinanalyzer.repository;

import at.etc.coinanalyzer.config.AppProperties;
import at.etc.coinanalyzer.repository.BaseRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlockchainRepository extends BaseRepository {

    public static final String latestStatisticsUri = "/blockchain/statistics/latest";

    public BlockchainRepository(@Autowired AppProperties appProperties) {
        super(appProperties);
    }

    public JSONArray getAllStatistics() {
        return receiveJSON(latestStatisticsUri);
    }
}
