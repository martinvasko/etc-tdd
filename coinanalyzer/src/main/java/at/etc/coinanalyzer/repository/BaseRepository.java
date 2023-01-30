package at.etc.coinanalyzer.repository;

import at.etc.coinanalyzer.config.AppProperties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BaseRepository {

    private AppProperties properties;
    private static final String apiBaseURL = "https://pro-api.coinmarketcap.com/v1";


    BaseRepository(@Autowired AppProperties properties) {
        this.properties = properties;
    }

    protected JSONArray receiveJSON(String uri) {
        String apiUri = apiBaseURL + uri;
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUri)).header("X-CMC_PRO_API_KEY", properties.getApiKey()).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonObject = new JSONObject(response.body());
            JSONArray jsonArray = jsonObject.getJSONArray("data");

            return jsonArray;

        } catch (IOException | InterruptedException e) {
            System.err.println("Failed to retrive data from " + apiUri + ": " + e.getMessage());
            return new JSONArray();
        }
    }
}
