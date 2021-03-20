package gg.cookingdom;

import gg.cookingdom.repository.treasure.JsonTreasureInfoRepository;
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
public class TreasureApiTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    private JsonTreasureInfoRepository treasureRepository;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void treasureListTest() throws Exception {
        mvc.perform(get("/treasure"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByNameTest() throws Exception {
        mvc.perform(get("/treasure/name?name=화르"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByRankTest() throws Exception {
        mvc.perform(get("/treasure/rank?rank=EPIC"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByEffectTest() throws Exception {
        mvc.perform(get("/treasure/effect?effect=부활"))
                .andExpect(status().isOk());
    }

}
