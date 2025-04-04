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
	
	/*//DI
	private final MovieService service;
	
	//exe
	public void exe() {
		//全件検索
		System.out.println("＝＝＝＝＝＝＝＝全件検索＝＝＝＝＝＝＝＝");
		for (Movie row : service.findAllMovie()) {
			System.out.println(row);
		}
		//1件検索
		System.out.println("＝＝＝＝＝＝＝＝1件検索＝＝＝＝＝＝＝＝");
		System.out.println(service.findByIdMovie(1));
		
		//登録
		Movie movie = new Movie();
		movie.setTitle("サービスのテスト");
		movie.setGenre("サービスのテスト");
		movie.setReleaseYear(2025);
		movie.setRating(3);
		movie.setSummary("てすとてすとてすと");
		movie.setReview("test/test/test/test/test/test/test/test/test");
		movie.setImage("http://www.test.jp/test.jpg");
		service.insertMovie(movie);
		System.out.println("＝＝＝＝＝＝＝＝登録確認＝＝＝＝＝＝＝＝");
		System.out.println(service.findByIdMovie(4));
		
		//更新
		Movie target = service.findByIdMovie(4);
		target.setTitle("登録のテスト：更新");
		target.setGenre("登録のテスト：更新");
		target.setReleaseYear(2025999);
		target.setRating(1);
		target.setSummary("てすとてすとてすと：更新");
		target.setReview("test/test/test/test/test/test/test/test/test：更新");
		target.setImage("http://www.test.jp/test.jpg：更新");
		service.updateMovie(target);
		System.out.println("＝＝＝＝＝＝＝＝更新確認＝＝＝＝＝＝＝＝");
		System.out.println(service.findByIdMovie(4));
		
		//削除
		service.deleteMovie(4);
		System.out.println("＝＝＝＝＝＝＝＝削除確認＝＝＝＝＝＝＝＝");
		//全件表示して、テスト追加した４件目が消えてるか確認
		for (Movie row : service.findAllMovie()) {
			System.out.println(row);
		}
	}*/

}
