package gg.cookingdom.cookie;

public class Cookie {
    private final String name;
    private final Rank rank;
    private final Integer tier;
    private final CookieMajor major;
    private final CookiePosition position;
    private final String topping;
    private final String description;

    public Cookie(String name, Rank rank, Integer tier, CookieMajor major, CookiePosition position, String topping, String description) {
        this.name = name;
        this.rank = rank;
        this.tier = tier;
        this.major = major;
        this.position = position;
        this.topping = topping;
        this.description = description;
    }
}
