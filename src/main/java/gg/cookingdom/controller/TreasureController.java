package gg.cookingdom.controller;

import gg.cookingdom.dto.Treasure;
import gg.cookingdom.enums.Rank;
import gg.cookingdom.repository.treasure.TreasureInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treasure")
@RequiredArgsConstructor
public class TreasureController {

    private final TreasureInfoRepository treasureRepository;

    @GetMapping
    public List<Treasure> getTreasures() {
        return treasureRepository.getTreasures();
    }
    
    @GetMapping("/name")
    public List<Treasure> getByName(@RequestParam String name) {
        return treasureRepository.getTreasureByName(name);
    }

    @GetMapping("/rank")
    public List<Treasure> getByRank(@RequestParam(required = false) Rank rank) {
        return treasureRepository.getTreasureByRank(rank);
    }

    @GetMapping("/effect")
    public List<Treasure> getByEffect(@RequestParam String effect) {
        return treasureRepository.getTreasureByEffect(effect);
    }
}
