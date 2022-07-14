package com.springboot.first.app;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//Unit test a Spring Boot application. You can set an active profile via property spring.profiles.active
@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class ApplicationTests {

	@Test
	void testDefaultProfile(CapturedOutput capturedOutput) {
		Application.main(new String[0]);
		String output = capturedOutput.toString();
		assertThat(output).contains("Today is a sunny day!");
	}

	@Test
	public void testRainingProfile(CapturedOutput capturedOutput) {
		System.setProperty("spring.profiles.active", "raining");
		Application.main(new String[0]);
		String output = capturedOutput.toString();
		assertThat(output).contains("Today is a raining day!");
	}

	@Test
	public void testRainingProfile_withDoption(CapturedOutput capturedOutput) {
		Application.main(new String[]{"--spring.profiles.active=raining"});
		String output = capturedOutput.toString();
		assertThat(output).contains("Today is a raining day!");
	}

	@After
	public void after() {
		System.clearProperty("spring.profiles.active");
	}

}
