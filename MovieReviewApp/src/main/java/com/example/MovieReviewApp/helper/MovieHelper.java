package com.example.MovieReviewApp.helper;

import com.example.MovieReviewApp.entity.Movie;
import com.example.MovieReviewApp.form.MovieForm;

public class MovieHelper {
	//Movieへの変換
	public static Movie convertMovie(MovieForm form, String imagePath) {
		Movie movie = new Movie();
		movie.setId(form.getId());
		movie.setTitle(form.getTitle());
		movie.setGenre(form.getGenre());
		movie.setReleaseYear(form.getReleaseYear());
		movie.setRating(form.getRating());
		movie.setSummary(form.getSummary());
		movie.setReview(form.getReview());
		if (imagePath != null && !imagePath.isEmpty()) {
	            movie.setImage(imagePath);
	        }
		return movie;
	}
	
	//MovieFormへの変換
	public static MovieForm convertMovieForm(Movie movie) {
		MovieForm form = new MovieForm();
		form.setId(movie.getId());
		form.setTitle(movie.getTitle());
		form.setGenre(movie.getGenre());
		form.setReleaseYear(movie.getReleaseYear());
		form.setRating(movie.getRating());
		form.setSummary(movie.getSummary());
		form.setReview(movie.getReview());
		form.setImage(movie.getImage());
		//更新画面設定
		form.setIsNew(false);
		return form;
	}
}
