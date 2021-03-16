package gg.cookingdom.repository.treasure;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.cookingdom.dto.treasure.Treasure;
import gg.cookingdom.enums.Rank;
import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JsonTreasureInfoRepository implements TreasureInfoRepository{

    private List<Treasure> treasures = new ArrayList<>();

    @SneakyThrows
    public JsonTreasureInfoRepository() {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(
                getClass().getResource("/static/treasureinfo.json").getPath()));

        JSONArray jsonObject = (JSONArray) obj;
        ObjectMapper mapper = new ObjectMapper();
        List<LinkedHashMap<String, ?>> list = mapper.readValue(jsonObject.toJSONString(), List.class);

        for (LinkedHashMap map : list) {
            treasures.add(
                    Treasure.builder()
                        .name((String) map.get("name"))
                        .rank(Rank.valueOf((String) map.get("rank")))
                        .effect((String) map.get("effect"))
                        .description((String) map.get("description"))
                        .build()
            );
        }
    }

    @Override
    public List<Treasure> getTreasures() {
        return treasures;
    }

    @Override
    public List<Treasure> getTreasureByName(String name) {
        return treasures.stream()
                .filter(treasure -> treasure.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Treasure> getTreasureByRank(Rank rank) {
        return treasures.stream()
                .filter(treasure -> treasure.getRank().equals(rank))
                .collect(Collectors.toList());
    }

    @Override
    public List<Treasure> getTreasureByEffect(String effect) {
        return treasures.stream()
                .filter(treasure -> treasure.getEffect().contains(effect))
                .collect(Collectors.toList());
    }
}
