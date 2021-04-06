package gg.cookingdom.repository.topping;

import gg.cookingdom.dto.Topping;
import gg.cookingdom.enums.Rank;
import gg.cookingdom.repository.JsonRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JsonToppingRepository implements ToppingRepository {

    private final List<Topping> toppings = new ArrayList<>();

    @SneakyThrows
    public JsonToppingRepository(JsonRepository jsonRepository) {
        String path = "topping";
        List<LinkedHashMap<String, ?>> list = jsonRepository.getJsonInfo(path);

        for (LinkedHashMap map : list) {
            toppings.add(
                    Topping.builder()
                            .name((String) map.get("name"))
                            .rank(Rank.valueOf((String) map.get("rank")))
                            .imageUrl((String) map.get("image_url"))
                            .build()
            );
        }
        toppings.sort(Comparator.comparing(Topping::getName));
    }


    @Override
    public List<Topping> getToppingByName(String name) {
        return toppings.stream()
                .filter(topping -> topping.getName().equals(name))
                .collect(Collectors.toList());
    }
}
