package gg.cookingdom.repository.combination;

import gg.cookingdom.dto.Combination;
import gg.cookingdom.enums.CombinationType;
import gg.cookingdom.repository.JsonRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class JsonCombinationInfoRepository implements CombinationInfoRepository {

    @Autowired
    private final JsonRepository jsonRepository = new JsonRepository();
    private final List<Combination> combination = new ArrayList<>();

    @SneakyThrows
    public JsonCombinationInfoRepository() {
        String path = "combination";
        List<LinkedHashMap<String, ?>> list = jsonRepository.getJsonInfo(path);

        for (LinkedHashMap map : list) {
            combination.add(
                    Combination.builder()
                        .type(CombinationType.valueOf((String) map.get("type")))
                        .cookie((List<String>) map.get("cookie"))
                        .treasure((List<String>) map.get("treasure"))
                        .substitution((List<String>) map.get("substitution"))
                        .build()
            );
        }
    }

    @Override
    public List<Combination> getCombination() {
        return combination;
    }

    @Override
    public List<Combination> getByType(CombinationType type) {
        return combination.stream()
                    .filter(combinations -> combinations.getType() == type)
                    .collect(Collectors.toList());
    }
}
