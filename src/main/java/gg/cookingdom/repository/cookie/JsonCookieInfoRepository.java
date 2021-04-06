package gg.cookingdom.repository.cookie;

import gg.cookingdom.dto.Cookie;
import gg.cookingdom.enums.CookieMajor;
import gg.cookingdom.enums.CookiePosition;
import gg.cookingdom.enums.Rank;
import gg.cookingdom.repository.JsonRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JsonCookieInfoRepository implements CookieInfoRepository {

    private final List<Cookie> cookies = new ArrayList<>();

    @SneakyThrows
    public JsonCookieInfoRepository(JsonRepository jsonRepository) {
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
                        .topping((List<String>) map.get("topping"))
                        .skillName((String) map.get("skill_name"))
                        .skillDescription((String) map.get("skill_description"))
                        .coolTime((Double) map.get("cool_time"))
                        .cookieImageUrl((String) map.get("cookie_image_url"))
                        .skillImageUrl((String) map.get("skill_image_url"))
                        .majorImageUrl((String) map.get("major_image_url"))
                        .build()
            );
        }
        cookies.sort(Comparator.comparing(Cookie::getName));
    }

    @Override
    public List<Cookie> getCookieByName(String name) {
        return cookies.stream()
                .filter(cookie -> cookie.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cookie> getCookieByRank(Rank rank) {
        if (rank == null) {
            return cookies.stream()
                    .sorted(Comparator.comparing(Cookie::getRank))
                    .collect(Collectors.toList());
        }
        return cookies.stream()
                .filter(cookie -> cookie.getRank() == rank)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cookie> getCookieByTier(Integer tier) {
        if (tier == null) {
            return cookies.stream()
                    .sorted(Comparator.comparing(Cookie::getTier))
                    .collect(Collectors.toList());
        }
        return cookies.stream()
                .filter(cookie -> cookie.getTier().equals(tier))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cookie> getCookieByMajor(CookieMajor major) {
        if (major == null || major.equals("")) {
            return cookies.stream()
                    .sorted(Comparator.comparing(Cookie::getRank))
                    .sorted(Comparator.comparing(Cookie::getMajor))
                    .collect(Collectors.toList());
        }
        return cookies.stream()
                .sorted(Comparator.comparing(Cookie::getRank))
                .filter(cookie -> cookie.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cookie> getCookieByPosition(CookiePosition position) {
        if (position == null || position.equals("")) {
            return cookies.stream()
                    .sorted(Comparator.comparing(Cookie::getRank))
                    .sorted(Comparator.comparing(Cookie::getPosition))
                    .collect(Collectors.toList());
        }
        return cookies.stream()
                .sorted(Comparator.comparing(Cookie::getRank))
                .filter(cookie -> cookie.getPosition().equals(position))
                .collect(Collectors.toList());
    }
}
