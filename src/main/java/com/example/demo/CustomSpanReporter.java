package com.example.demo;

import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanReporter;
import org.springframework.stereotype.Component;

@Component
public class CustomSpanReporter implements SpanReporter {

	private static final Logger logger = LoggerFactory.getLogger(CustomSpanReporter.class);
	
	@Override
	public void report(Span span) {
		
		if (span == null || !span.isExportable()) {
			return;
		}
		
		printSpanTags(span);
	}

	private void printSpanTags(Span span) {
		String spanTags = span.tags()
				.entrySet()
				.stream()
				.map(Map.Entry::toString)
				.collect(Collectors.joining(" ] [ ", "[ ", " ]"));
		
		logger.info("Span tags: {} ", spanTags);
		
	}	

}
