package gg.cookingdom.controller;

import gg.cookingdom.dto.combination.Combination;
import gg.cookingdom.enums.CombinationType;
import gg.cookingdom.repository.combination.CombinationInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/combination")
@RequiredArgsConstructor
public class CombinationController {

    private final CombinationInfoRepository combinationRepository;

    @GetMapping
    public List<Combination> getList() {
        return combinationRepository.getCombination();
    }

    @GetMapping("/type")
    public List<Combination> getByType(@RequestParam CombinationType type) {
        return combinationRepository.getByType(type);
    }
}
