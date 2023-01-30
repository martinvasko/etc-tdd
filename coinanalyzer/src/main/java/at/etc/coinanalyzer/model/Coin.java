package at.etc.coinanalyzer.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Coin {
    private String name;
    private String symbol;
    private double price;
    private double percentage;

    public Coin(CoinBuilder coinBuilder) {
        this.name = coinBuilder.name;
        this.symbol = coinBuilder.symbol;
        this.price = coinBuilder.price;
        this.percentage = coinBuilder.percentage_24;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }


    public double getPrice() {
        return this.price;
    }


    public double getPercentage() {
        return this.percentage;
    }


    @Override
    public String toString() {
        return "" + this.name + " | " + this.symbol + ": " + String.format("%.2f", this.price) + " USD (" + String.format("%.2f", this.percentage) +" % since 24h)";
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.symbol.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == Coin.class) {
            if (this.name.equals(((Coin)obj).name) && this.symbol.equals(((Coin)obj).symbol) && this.price == ((Coin)obj).price && this.percentage == ((Coin)obj).percentage) {
                return true;
            }
        }
        return false;
    }

    public static List<Coin> convertJSONToCoin(JSONArray jsonArray) {
        List<Coin> coinList = new ArrayList<>();

        try {

            for (Object o : jsonArray) {
                String name = ((JSONObject) o).getString("name");
                String symbol = ((JSONObject) o).getString("symbol");
                double price = ((JSONObject) o).getJSONObject("quote").getJSONObject("USD").getDouble("price");
                double percentage = ((JSONObject) o).getJSONObject("quote").getJSONObject("USD").getDouble("percent_change_24h");

                //init & remember
                Coin c = new CoinBuilder(symbol, name)
                        .priceUSD(price)
                        .percentage(percentage)
                        .build();


                coinList.add(c);
            }

        } catch (JSONException | IllegalArgumentException jex) {
            System.out.println("Skip invalid object!");
        }

        return coinList;
    }


    // Builder for Coin class (static inner class)
    public static class CoinBuilder {

        private String name;
        private String symbol;
        private double price;
        private double percentage_24;


        public CoinBuilder(String symbol, String name) {

            if (name == null || name.isEmpty() || name.trim().isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            if (symbol == null || symbol.isEmpty() || symbol.trim().isEmpty()) {
                throw new IllegalArgumentException("symbol is empty");
            }

            this.symbol = symbol;
            this.name = name;
        }

        public CoinBuilder priceUSD(double price) {
            this.price = price;
            return this;
        }

        public CoinBuilder percentage(double percentage) {
            this.percentage_24 = percentage;
            return this;
        }

        public Coin build() {
            Coin coin = new Coin(this);
            validateCoin(coin);
            return coin;
        }

        private void validateCoin(Coin user) {
            if (price < 0) {
                throw new IllegalArgumentException("price_usd less than zero");
            }
        }



    }

}
