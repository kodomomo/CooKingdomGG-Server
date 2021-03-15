package gg.cookingdom.dto.cookie;

import gg.cookingdom.enums.CookieMajor;
import gg.cookingdom.enums.CookiePosition;
import gg.cookingdom.enums.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cookie {
    private String name;
    private Rank rank;
    private Integer tier;
    private CookieMajor major;
    private CookiePosition position;
    private String topping;
    private String description;
}
