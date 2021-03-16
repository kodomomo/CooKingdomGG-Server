package gg.cookingdom.repository.combination;

import gg.cookingdom.dto.combination.Combination;
import gg.cookingdom.enums.CombinationType;

import java.util.List;

public interface CombinationInfoRepository {
    List<Combination> getCombination();
    List<Combination> getByType(CombinationType type);
}
