package gg.cookingdom.repository.topping;

import gg.cookingdom.dto.Topping;

import java.util.List;

public interface ToppingRepository {
    List<Topping> getToppingByName(String name);
}
