package gg.cookingdom.repository.cookie;

import gg.cookingdom.dto.Cookie;
import gg.cookingdom.enums.CookieMajor;
import gg.cookingdom.enums.CookiePosition;
import gg.cookingdom.enums.Rank;

import java.util.List;

public interface CookieInfoRepository {
    List<Cookie> getCookieByName(String name);
    List<Cookie> getCookieByRank(Rank rank);
    List<Cookie> getCookieByTier(Integer tier);
    List<Cookie> getCookieByMajor(CookieMajor major);
    List<Cookie> getCookieByPosition(CookiePosition position);
}
