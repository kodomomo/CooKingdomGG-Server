package gg.cookingdom.repository.combination;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.cookingdom.dto.Combination;
import gg.cookingdom.enums.CombinationType;
import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class JsonCombinationInfoRepository implements CombinationInfoRepository{

    private List<Combination> combination = new ArrayList<>();

    @SneakyThrows
    public JsonCombinationInfoRepository() {
        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();

        ClassPathResource classPathResource = new ClassPathResource("/static/combination.json");
        if (!classPathResource.exists()) {
            throw new IllegalArgumentException();
        }
        Object obj = parser.parse(new InputStreamReader(classPathResource.getInputStream(), StandardCharsets.UTF_8));
        JSONArray jsonObject = (JSONArray) obj;

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
