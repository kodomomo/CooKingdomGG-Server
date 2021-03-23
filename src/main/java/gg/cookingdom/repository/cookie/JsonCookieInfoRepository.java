package gg.cookingdom.repository.cookie;

import gg.cookingdom.dto.Cookie;
import gg.cookingdom.enums.CookieMajor;
import gg.cookingdom.enums.CookiePosition;
import gg.cookingdom.enums.Rank;
import gg.cookingdom.repository.JsonRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class JsonCookieInfoRepository implements CookieInfoRepository {

    @Autowired
    private final JsonRepository jsonRepository = new JsonRepository();
    private final List<Cookie> cookies = new ArrayList<>();

    @SneakyThrows
    public JsonCookieInfoRepository() {
        String path = "cookieinfo";
        List<LinkedHashMap<String, ?>> list = jsonRepository.getJsonInfo(path);

        for (LinkedHashMap map : list) {
            cookies.add(
                    Cookie.builder()
                        .name((String) map.get("name"))
                        .rank(Rank.valueOf((String) map.get("rank")))
                        .tier((Integer) map.get("tier"))
                        .major(CookieMajor.valueOf((String) map.get("major")))
                        .position(CookiePosition.valueOf((String) map.get("position")))
                        .topping((String) map.get("topping"))
                        .skillName((String) map.get("skill_name"))
                        .skillDescription((String) map.get("skill_description"))
                        .coolTime((Double) map.get("cool_time"))
                        .cookieImageUrl((String) map.get("cookie_image_url"))
                        .skillImageUrl((String) map.get("skill_image_url"))
                        .majorImageUrl((String) map.get("major_image_url"))
                        .build()
            );
        }
        Collections.sort(cookies, Comparator.comparing(Cookie::getName));
    }

    @Override
    public List<Cookie> getCookies() {
        return cookies;
    }

    @Override
    public List<Cookie> getCookieByName(String name) {
        return cookies.stream()
                .filter(cookie -> cookie.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cookie> getCookieByRank(Rank rank) {
        return cookies.stream()
                .filter(cookie -> cookie.getRank() == rank)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cookie> getCookieByTier(Integer tier) {
        return cookies.stream()
                .filter(cookie -> cookie.getTier().equals(tier))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cookie> getCookieByMajor(CookieMajor major) {
        return cookies.stream()
                .filter(cookie -> cookie.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cookie> getCookieByPosition(CookiePosition position) {
        return cookies.stream()
                .filter(cookie -> cookie.getPosition().equals(position))
                .collect(Collectors.toList());
    }
}
