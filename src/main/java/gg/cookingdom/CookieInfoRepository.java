package gg.cookingdom;

import java.util.List;

public interface CookieInfoRepository {
    Cookie getCookieByName(String name);
    List<Cookie> getCookieByRank(CookieRank rank);
    List<Cookie> getCookieByTier(Integer tier);
    List<Cookie> getCookieByMajor(CookieMajor major);
    List<Cookie> getCookieByPosition(CookiePosition position);
}
