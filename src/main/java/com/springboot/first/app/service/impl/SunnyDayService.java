package com.springboot.first.app.service.impl;

import com.springboot.first.app.service.WeatherService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"sunny","default"})
public class SunnyDayService implements WeatherService {
    @Override
    public String forecast() {
        return "Today is a sunny day!";
    }
}
