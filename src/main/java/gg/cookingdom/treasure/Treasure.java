package gg.cookingdom.treasure;

import gg.cookingdom.cookie.Rank;

public class Treasure {
    private final String name;
    private final Rank rank;
    private final String effect;
    private final String description;

    public Treasure(String name, Rank rank, String effect, String description) {
        this.name = name;
        this.rank = rank;
        this.effect = effect;
        this.description = description;
    }
}
