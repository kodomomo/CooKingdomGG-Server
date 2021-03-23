package gg.cookingdom.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class JsonRepository {
    @SneakyThrows
    public List<LinkedHashMap<String, ?>> getJsonInfo(String path) {
        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();

        String requestUrl = System.getenv("AWS_S3_URL");

        Request request = new Request.Builder()
                .url(requestUrl + path + ".json")
                .get()
                .build();
        ResponseBody response = client.newCall(request).execute().body();

        JSONArray jsonObject = (JSONArray) parser.parse(
                new InputStreamReader(
                        response.source().inputStream(), 
                        StandardCharsets.UTF_8));

        return mapper.readValue(jsonObject.toJSONString(), List.class);
    }
}
