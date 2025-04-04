package com.example.MovieReviewApp.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	//ID
	private Integer id;
	//タイトル
	private String title;
	//ジャンル
	private String genre;
	//公開年
	private Integer releaseYear;
	//星評価 (1〜5)
	private Integer rating;
	//あらすじ
	private String summary;
	//感想
	private String review;
	//画像(URL)
	private String image;
	//登録日時
	private LocalDateTime createdAt;
	//変更日時
	private LocalDateTime updatedAt;
}
