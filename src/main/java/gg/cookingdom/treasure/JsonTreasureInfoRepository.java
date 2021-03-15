package gg.cookingdom.treasure;

import gg.cookingdom.cookie.Rank;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JsonTreasureInfoRepository implements TreasureInfoRepository{
    @Override
    public Treasure getTreasureByName(String name) {
        return null;
    }

    @Override
    public List<Treasure> getTreasureByRank(Rank rank) {
        return null;
    }

    @Override
    public List<Treasure> getTreasureBy(String effect) {
        return null;
    }
}
