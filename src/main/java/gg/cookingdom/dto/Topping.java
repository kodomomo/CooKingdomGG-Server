package gg.cookingdom.dto;

import gg.cookingdom.enums.Rank;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topping {
    private Rank rank;
    private String name;
    private String imageUrl;
}
