package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SubjectController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/subjects")
	public String getSubjects(@RequestParam(name = "exception", defaultValue = "false") boolean exception) {
		String subject = restTemplate.getForObject("http://localhost:8090/v1/subjects?exception=" + exception, String.class);

		return "App2 returned " + subject;

	}

	@ExceptionHandler(Exception.class)
	public String handleError() {
		return "got exception";
	}

}
