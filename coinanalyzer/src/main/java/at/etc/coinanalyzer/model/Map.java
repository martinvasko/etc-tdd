package at.etc.coinanalyzer.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Map {
    private Integer id;
    private Integer rank;
    private String name;
    private String symbol;
    private String slug;

    public Map(MapBuilder builder) {
        this.id = builder.id;
        this.rank = builder.rank;
        this.name = builder.name;
        this.symbol = builder.symbol;
        this.slug = builder.slug;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSlug() {
        return slug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map = (Map) o;
        return id.equals(map.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static List<Map> convertJSONToMap(JSONArray jsonArray) {
        List<Map> mapList = new ArrayList<>();

        try {

            for (Object o : jsonArray) {
                Integer id = ((JSONObject) o).getInt("id");
                Integer rank = ((JSONObject) o).getInt("rank");
                String name = ((JSONObject) o).getString("name");
                String symbol = ((JSONObject) o).getString("symbol");
                String slug = ((JSONObject) o).getString("slug");

                //init & remember
                Map m = new MapBuilder()
                        .id(id)
                        .rank(rank)
                        .name(name)
                        .symbol(symbol)
                        .slug(slug)
                        .build();

                mapList.add(m);
            }

        } catch (JSONException | IllegalArgumentException jex) {
            System.out.println("Skip invalid object!");
        }

        return mapList;
    }

    public static class MapBuilder {
        private Integer id;
        private Integer rank;
        private String name;
        private String symbol;
        private String slug;

        public MapBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public MapBuilder rank(Integer rank) {
            this.rank = rank;
            return this;
        }

        public MapBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MapBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public MapBuilder slug(String slug) {
            this.slug = slug;
            return this;
        }

        public Map build() {
            Map map = new Map(this);
            return map;
        }
    }
}
