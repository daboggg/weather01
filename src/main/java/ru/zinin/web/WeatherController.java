package ru.zinin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zinin.model.Mod;
import ru.zinin.service.ApiClient;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    ApiClient apiClien;


    @RequestMapping
    public void getWeather(@RequestParam(value = "city",defaultValue = "London") String city,
                           Map<String, Object> model) {
//        return apiClien.findWeatherByCity(city);



        Mod mod = apiClien.findWeatherByCity(city);



        Map<String, String> weather = new LinkedHashMap<String, String>(){{
            put("temperature", mod.getData().getCurrent_condition()[0].getTemp_C());
            put("urlImg", mod.getData().getCurrent_condition()[0].getWeatherIconUrl()[0].get("value"));
            put("weatherDesc", mod.getData().getCurrent_condition()[0].getLang_ru()[0].get("value"));
            put("windspeedKmph", mod.getData().getCurrent_condition()[0].getWindspeedKmph());
            put("winddirDegree", mod.getData().getCurrent_condition()[0].getWinddirDegree());
            put("winddir16Point", mod.getData().getCurrent_condition()[0].getWinddir16Point());
            put("humidity", mod.getData().getCurrent_condition()[0].getHumidity());
            put("visibility", mod.getData().getCurrent_condition()[0].getVisibility());
            put("pressure", mod.getData().getCurrent_condition()[0].getPressure());
            put("cloudcover", mod.getData().getCurrent_condition()[0].getCloudcover());
        }};

        model.put("weather", weather);

        System.out.println(weather.get("urlImg"));





/*        String temperature = mod.getData().getCurrent_condition()[0].getTemp_C();
        String urlImg = mod.getData().getCurrent_condition()[0].getWeatherIconUrl()[0].get("value");
        String weatherDesc = mod.getData().getCurrent_condition()[0].getLang_ru()[0].get("value");
        String windspeedKmph = mod.getData().getCurrent_condition()[0].getWindspeedKmph();
        String winddirDegree = mod.getData().getCurrent_condition()[0].getWinddirDegree();
        String winddir16Point = mod.getData().getCurrent_condition()[0].getWinddir16Point();
        String humidity = mod.getData().getCurrent_condition()[0].getHumidity();
        String visibility = mod.getData().getCurrent_condition()[0].getVisibility();
        String pressure = mod.getData().getCurrent_condition()[0].getPressure();
        String cloudcover = mod.getData().getCurrent_condition()[0].getCloudcover();*/


//        model.put("weather", weather);
//        return "azza";
    }

}
