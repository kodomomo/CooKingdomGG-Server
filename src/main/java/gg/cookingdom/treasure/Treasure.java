package gg.cookingdom.treasure;

import gg.cookingdom.cookie.Rank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Treasure {
    private final String name;
    private final Rank rank;
    private final String effect;
    private final String description;
}
