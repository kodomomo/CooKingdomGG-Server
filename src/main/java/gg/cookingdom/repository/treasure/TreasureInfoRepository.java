package gg.cookingdom.repository.treasure;

import gg.cookingdom.enums.Rank;
import gg.cookingdom.dto.treasure.Treasure;

import java.util.List;

public interface TreasureInfoRepository {
    List<Treasure> getTreasureByName(String name);
    List<Treasure> getTreasureByRank(Rank rank);
    List<Treasure> getTreasureByEffect(String effect);
}
