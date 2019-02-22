package ru.zinin.service;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.zinin.model.Mod;

@Component
public class ApiClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.urlTemplate}")
    private String url;



    public Mod findWeatherByCity(@NonNull String city) {
        ResponseEntity<Mod> response = restTemplate.getForEntity(url, Mod.class, ImmutableMap.of("city", city));
        return response.getBody();
    }
}























