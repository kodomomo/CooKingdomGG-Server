package gg.cookingdom.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topping {
    private String rank;
    private String name;
    private String imageUrl;
}
