package com.example.MovieReviewApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MovieReviewApp.entity.Movie;
import com.example.MovieReviewApp.repository.MovieMapper;
import com.example.MovieReviewApp.service.MovieService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

	//DI
	private final MovieMapper movieMapper;
	
	@Override
	public List<Movie> findAllMovie() {
		return movieMapper.selectAll();
	}
	@Override
	public List<Movie> findAllSorted(String sortBy) {
	    return movieMapper.selectAllSorted(sortBy);
	}

	@Override
	public Movie findByIdMovie(Integer id) {
		return movieMapper.selectById(id);
	}

	@Override
	public void insertMovie(Movie movie) {
		movieMapper.insert(movie);
	}

	@Override
	public void updateMovie(Movie movie) {
		movieMapper.update(movie);
	}

	@Override
	public void deleteMovie(Integer id) {
		movieMapper.delete(id);
	}

}
