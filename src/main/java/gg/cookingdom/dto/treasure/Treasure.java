package gg.cookingdom.dto.treasure;

import gg.cookingdom.enums.Rank;
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
