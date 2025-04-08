package com.example.MovieReviewApp.service;

import java.util.List;

import com.example.MovieReviewApp.entity.Movie;

public interface MovieService {
	//全Movie検索
	List<Movie>findAllMovie();
	
	// ソート付き検索
    List<Movie> findAllSorted(String sortBy);
	
	//該当するidのデータのみ検索
	Movie findByIdMovie(Integer id);
	
	//新規データ登録
	void insertMovie(Movie movie);
	
	//既存データの更新
	void updateMovie(Movie movie);
	
	//該当するidのデータのみ削除
	void deleteMovie(Integer id);
}
