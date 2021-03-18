package gg.cookingdom.dto;

import gg.cookingdom.enums.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Treasure {
    private String name;
    private Rank rank;
    private String effect;
    private String description;
    private String imageUrl;
}
