package gg.cookingdom.repository.treasure;

import gg.cookingdom.dto.Treasure;
import gg.cookingdom.enums.Rank;
import gg.cookingdom.repository.JsonRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class JsonTreasureInfoRepository implements TreasureInfoRepository{

    @Autowired
    private final JsonRepository jsonRepository = new JsonRepository();
    private final List<Treasure> treasures = new ArrayList<>();

    @SneakyThrows
    public JsonTreasureInfoRepository() {
        String path = "treasureinfo.json";
        List<LinkedHashMap<String, ?>> list = jsonRepository.getJsonInfo(path);

        for (LinkedHashMap map : list) {
            treasures.add(
                    Treasure.builder()
                        .name((String) map.get("name"))
                        .rank(Rank.valueOf((String) map.get("rank")))
                        .effect((String) map.get("effect"))
                        .description((String) map.get("description"))
                        .imageUrl((String) map.get("image_url"))
                        .build()
            );
        }
        Collections.sort(treasures, Comparator.comparing(Treasure::getName));
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
