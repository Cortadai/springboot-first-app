package com.springboot.first.app;

import com.springboot.first.app.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//Unit test a service class. Set an active profile via @ActiveProfiles
@SpringBootTest
@ActiveProfiles("raining")
class TestWeatherService {

	@Autowired
	WeatherService weatherService;

	@Test
	public void testRainingProfile() {
		String output = weatherService.forecast();
		assertThat(output).contains("Today is a raining day!");
	}

}
