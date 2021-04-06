package gg.cookingdom.controller;

import gg.cookingdom.dto.Topping;
import gg.cookingdom.repository.topping.ToppingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topping")
@RequiredArgsConstructor
public class ToppingController {

    private final ToppingRepository toppingRepository;

    @GetMapping("/name")
    public List<Topping> getToppingByName(@RequestParam String name) {
        return toppingRepository.getToppingByName(name);
    }
}
