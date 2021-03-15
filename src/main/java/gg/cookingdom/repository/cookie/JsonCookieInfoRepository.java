package gg.cookingdom.repository.cookie;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.cookingdom.dto.cookie.Cookie;
import gg.cookingdom.enums.CookieMajor;
import gg.cookingdom.enums.CookiePosition;
import gg.cookingdom.enums.Rank;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JsonCookieInfoRepository implements CookieInfoRepository {

    private final List<Cookie> cookies;

    @SneakyThrows
    public JsonCookieInfoRepository() {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(
                getClass().getResource("static/cookieinfo.json").getPath()));

        JSONObject jsonObject = (JSONObject) obj;
        ObjectMapper mapper = new ObjectMapper();
        this.cookies = mapper.readValue(jsonObject.toJSONString(), List.class);
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
