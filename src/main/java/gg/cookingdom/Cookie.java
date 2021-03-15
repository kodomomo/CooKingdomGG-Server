package gg.cookingdom;

public class Cookie {
    private final String name;
    private final CookieRank rank;
    private final Integer tier;
    private final CookieMajor major;
    private final CookiePosition position;
    private final String topping;
    private final String description;

    public Cookie(String name, CookieRank rank, Integer tier, CookieMajor major, CookiePosition position, String topping, String description) {
        this.name = name;
        this.rank = rank;
        this.tier = tier;
        this.major = major;
        this.position = position;
        this.topping = topping;
        this.description = description;
    }
}
