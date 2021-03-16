package gg.cookingdom.repository.combination;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.cookingdom.dto.Combination;
import gg.cookingdom.enums.CombinationType;
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
public class JsonCombinationInfoRepository implements CombinationInfoRepository{

    private List<Combination> combination = new ArrayList<>();

    @SneakyThrows
    public JsonCombinationInfoRepository() {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(
                getClass().getResource("/static/combination.json").getPath()));

        JSONArray jsonObject = (JSONArray) obj;
        ObjectMapper mapper = new ObjectMapper();
        List<LinkedHashMap<String, ?>> list = mapper.readValue(jsonObject.toJSONString(), List.class);
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
