package gg.cookingdom.controller;

import gg.cookingdom.dto.Cookie;
import gg.cookingdom.enums.CookieMajor;
import gg.cookingdom.enums.CookiePosition;
import gg.cookingdom.enums.Rank;
import gg.cookingdom.repository.cookie.CookieInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cookie")
@RequiredArgsConstructor
public class CookieController {

    private final CookieInfoRepository cookieRepository;

    @GetMapping("/name")
    public List<Cookie> getByName(@RequestParam String name) {
        return cookieRepository.getCookieByName(name);
    }

    @GetMapping("/rank")
    public List<Cookie> getByRank(@RequestParam(required = false) Rank rank) {
        return cookieRepository.getCookieByRank(rank);
    }

    @GetMapping("/tier")
    public List<Cookie> getByTier(@RequestParam(required = false) Integer tier) {
        return cookieRepository.getCookieByTier(tier);
    }

    @GetMapping("/major")
    public List<Cookie> getByMajor(@RequestParam(required = false) CookieMajor major) {
        return cookieRepository.getCookieByMajor(major);
    }

    @GetMapping("/position")
    public List<Cookie> getByPosition(@RequestParam(required = false) CookiePosition position) {
        return cookieRepository.getCookieByPosition(position);
    }
}
