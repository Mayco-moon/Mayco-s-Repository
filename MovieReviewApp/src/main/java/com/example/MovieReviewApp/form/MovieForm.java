package com.example.MovieReviewApp.form;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieForm {
	private Integer id;
	
	//タイトルは空白ダメ
	@NotBlank(message = "タイトルは必須です。") //これだけで入力チェックできる！べんり！
	private String title;
	
	//別に入力チェックせんでもええやつ
	private String genre;
	private Integer releaseYear;
	private Integer rating;
	private String summary;
	private String review;
	private String image;
	
	//↓新規項目かどうか判定させる変数
	private Boolean isNew;
}
