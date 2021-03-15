package gg.cookingdom.treasure;

import gg.cookingdom.cookie.Rank;

import java.util.List;

public interface TreasureInfoRepository {
    Treasure getTreasureByName(String name);
    List<Treasure> getTreasureByRank(Rank rank);
    List<Treasure> getTreasureBy(String effect);
}
