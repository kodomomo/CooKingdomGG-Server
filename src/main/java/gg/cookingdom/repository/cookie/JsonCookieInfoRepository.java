package gg.cookingdom.repository.cookie;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.cookingdom.dto.Cookie;
import gg.cookingdom.enums.CookieMajor;
import gg.cookingdom.enums.CookiePosition;
import gg.cookingdom.enums.Rank;
import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JsonCookieInfoRepository implements CookieInfoRepository {

    private List<Cookie> cookies = new ArrayList<>();

    @SneakyThrows
    public JsonCookieInfoRepository() {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(
                getClass().getResource("/static/cookieinfo.json").getPath()));

        JSONArray jsonObject = (JSONArray) obj;
        ObjectMapper mapper = new ObjectMapper();
        List<LinkedHashMap<String, ?>> list = mapper.readValue(jsonObject.toJSONString(), List.class);
        for (LinkedHashMap map : list) {
            cookies.add(
                    Cookie.builder()
                        .name((String) map.get("name"))
                        .rank(Rank.valueOf((String) map.get("rank")))
                        .tier((Integer) map.get("tier"))
                        .major(CookieMajor.valueOf((String) map.get("major")))
                        .position(CookiePosition.valueOf((String) map.get("position")))
                        .topping((String) map.get("topping"))
                        .description((String) map.get("description"))
                        .build()
            );
        }
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
