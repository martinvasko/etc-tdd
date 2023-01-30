package at.etc.coinanalyzer.repository;

import at.etc.coinanalyzer.config.AppProperties;
import org.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoinRepository extends BaseRepository {

    public static final String uri = "/cryptocurrency/listings/latest";
    public static final String mapUri = "/cryptocurrency/map";

    public CoinRepository(@Autowired AppProperties appProperties) {
        super(appProperties);
    }

    public JSONArray findAll() {
        return receiveJSON(uri);
    }

    public JSONArray mapAll() { return receiveJSON(mapUri);}
}
