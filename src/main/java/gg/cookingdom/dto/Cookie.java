package gg.cookingdom.dto;

import gg.cookingdom.enums.CookieMajor;
import gg.cookingdom.enums.CookiePosition;
import gg.cookingdom.enums.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<String> topping;
    private String skillName;
    private String skillDescription;
    private Double coolTime;
    private String cookieImageUrl;
    private String skillImageUrl;
    private String majorImageUrl;
}
