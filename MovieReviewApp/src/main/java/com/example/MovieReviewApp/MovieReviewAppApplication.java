package com.example.MovieReviewApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MovieReviewAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewAppApplication.class, args);
	}

}
