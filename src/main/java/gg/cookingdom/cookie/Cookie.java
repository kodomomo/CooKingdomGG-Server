package gg.cookingdom.cookie;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cookie {
    private final String name;
    private final Rank rank;
    private final Integer tier;
    private final CookieMajor major;
    private final CookiePosition position;
    private final String topping;
    private final String description;
}
