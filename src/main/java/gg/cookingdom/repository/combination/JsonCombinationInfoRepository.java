package gg.cookingdom.repository.combination;

import gg.cookingdom.dto.Combination;
import gg.cookingdom.enums.CombinationType;
import gg.cookingdom.repository.JsonRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JsonCombinationInfoRepository implements CombinationInfoRepository{

    private List<Combination> combination = new ArrayList<>();

    @SneakyThrows
    public JsonCombinationInfoRepository(JsonRepository jsonRepository) throws IOException, ParseException {
        String paht = "combination.json";
        List<LinkedHashMap<String, ?>> list = jsonRepository.getJsonInfo(paht);

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
