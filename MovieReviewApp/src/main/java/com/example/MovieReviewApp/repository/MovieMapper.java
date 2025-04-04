package com.example.MovieReviewApp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.MovieReviewApp.entity.Movie;

@Mapper
public interface MovieMapper {
	//全件取得
	//List<Movie> selectAll();
	//全件をid降順で取得するメソッド
    List<Movie> selectAllSortedByIdDesc();
	
	//1件詳細表示
	Movie selectById(@Param("id") Integer id);
	
	//登録
	void insert(Movie movie);
	
	//更新
	void update(Movie movie);
	
	//削除
	void delete(@Param("id") Integer id);
}
