package gg.cookingdom.cookie;

import java.util.List;

public interface CookieInfoRepository {
    List<Cookie> getCookieByName(String name);
    List<Cookie> getCookieByRank(Rank rank);
    List<Cookie> getCookieByTier(Integer tier);
    List<Cookie> getCookieByMajor(CookieMajor major);
    List<Cookie> getCookieByPosition(CookiePosition position);
}
