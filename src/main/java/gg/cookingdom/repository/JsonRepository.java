package gg.cookingdom.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class JsonRepository {

    @SneakyThrows
    public List getJsonInfo(String path) {
        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();

        ClassPathResource classPathResource = new ClassPathResource("/static/" + path);
        if (!classPathResource.exists()) {
            throw new IllegalArgumentException();
        }
        Object obj = parser.parse(new InputStreamReader(classPathResource.getInputStream(), StandardCharsets.UTF_8));
        JSONArray jsonObject = (JSONArray) obj;

        return mapper.readValue(jsonObject.toJSONString(), List.class);
    }
}
