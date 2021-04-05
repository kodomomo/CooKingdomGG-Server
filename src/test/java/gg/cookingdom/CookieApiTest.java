package gg.cookingdom;

import gg.cookingdom.repository.cookie.JsonCookieInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test", "local"})
public class CookieApiTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    private JsonCookieInfoRepository cookieRepository;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders
                    .webAppContextSetup(context)
                    .build();
    }

    @Test
    public void getByCookiesByTier() throws Exception {
        mvc.perform(get("/cookie/tier"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByCookiesByRank() throws Exception {
        mvc.perform(get("/cookie/rank"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByCookiesByMajor() throws Exception {
        mvc.perform(get("/cookie/major"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByCookiesByPosition() throws Exception {
        mvc.perform(get("/cookie/position"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByNameTest() throws Exception {
        mvc.perform(get("/cookie/name?name=라떼"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByRankTest() throws Exception {
        mvc.perform(get("/cookie/rank?rank=EPIC"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByTierTest() throws Exception {
        mvc.perform(get("/cookie/tier?tier=1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByMajorTest() throws Exception {
        mvc.perform(get("/cookie/major?major=WIZARD"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByPositionTest() throws Exception {
        mvc.perform(get("/cookie/position?position=CENTER"))
                .andExpect(status().isOk());
    }
}