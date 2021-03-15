package gg.cookingdom;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JsonCookieInfoRepository implements CookieInfoRepository {
    @Override
    public Cookie getCookieByName(String name) {
        return null;
    }

    @Override
    public List<Cookie> getCookieByRank(CookieRank rank) {
        return null;
    }

    @Override
    public List<Cookie> getCookieByTier(Integer tier) {
        return null;
    }

    @Override
    public List<Cookie> getCookieByMajor(CookieMajor major) {
        return null;
    }

    @Override
    public List<Cookie> getCookieByPosition(CookiePosition position) {
        return null;
    }
}
