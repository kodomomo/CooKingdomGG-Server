package gg.cookingdom.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class JsonRepository {

    @Value("${aws.s3.static.url}")
    private String requestUrl;

    @SneakyThrows
    public List<LinkedHashMap<String, ?>> getJsonInfo(String name) {
        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();

        String url = URLEncoder.encode(requestUrl + name + ".json", "UTF-8");

        Request request = new Request.Builder()
                .url(url)
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
