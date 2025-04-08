package com.example.MovieReviewApp.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MovieReviewApp.entity.Movie;
import com.example.MovieReviewApp.form.MovieForm;
import com.example.MovieReviewApp.helper.MovieHelper;
import com.example.MovieReviewApp.service.MovieService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
	
	//DI
	private final MovieService service;
	
	//全件表示（デフォ）
	//@GetMapping
	//public String list(Model model) {
	//	model.addAttribute("movies", service.findAllMovie());
	//	return "movie/list";
	//}
	
	//一覧表示
	@GetMapping
	public String list(@RequestParam(value = "sort", defaultValue = "id_desc") String sort, Model model) {
	    // ソートを実行
	    model.addAttribute("movies", service.findAllSorted(sort));
	    return "movie/list";
	}
	
	//詳細表示
	@GetMapping("/{id}")
	public String detail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		//各情報の詳細を取得する
		Movie movie = service.findByIdMovie(id);
		if (movie != null) {
			model.addAttribute("movie", service.findByIdMovie(id));
			return "movie/detail";
		}else {
			//対象が無いときは一覧ページにリダイレクト
			return "redirect:/movie";
		}
	}
	
	//登録・追加処理
	
		//新規登録画面
		@GetMapping("/form")
		public String newMovie(@ModelAttribute MovieForm form) {
			//新規判定をtrueにする(しないとfalseのままform画面に移行しない)
			form.setIsNew(true);
			//表示させるview↓
			return "movie/form";
		}
		
		//新規要素の登録、実行！
		@PostMapping("/save")
		public String create(@Validated MovieForm form, BindingResult bindingResult, @RequestParam("imageFile") MultipartFile imageFile, RedirectAttributes attributes) {
			//＝＝＝バリデチェック入ります＝＝＝
			if(bindingResult.hasErrors()) {
				form.setIsNew(true);
				return "movie/form";
			}
			
			 // 画像アップロード処理
		    String imagePath = null;
		    if (!imageFile.isEmpty()) {
		        try {
		            // 保存先ディレクトリ
		            String uploadDir = "src/main/resources/static/uploadImages/";
		            Path uploadPath = Paths.get(uploadDir);

		            // ディレクトリが存在しない場合は作成
		            if (!Files.exists(uploadPath)) {
		                Files.createDirectories(uploadPath);
		            }

		            // ファイルを保存
		            String fileName = imageFile.getOriginalFilename();
		            Path filePath = uploadPath.resolve(fileName);
		            Files.copy(imageFile.getInputStream(), filePath);

		            // データベースに保存するパス
		            imagePath = "/uploadImages/" + fileName;
		        } catch (IOException e) {
		            e.printStackTrace();
		            attributes.addFlashAttribute("message", "画像のアップロードに失敗しました！");
		            return "redirect:/movie/form";
		        }
		    }
			
			//entityに変換
			Movie movie = MovieHelper.convertMovie(form, imagePath);
			
			
			
			//登録実行
			service.insertMovie(movie);
			//成功したよ、のテキスト表示
			attributes.addFlashAttribute("message","新しいデータが作成されました");
			//PRGパターン
			return "redirect:/movie";
		}
		
		//修正する画面
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable Integer id,Model model,RedirectAttributes attributes) {
			//該当するidのデータのみ取得
			Movie target = service.findByIdMovie(id);
			
			if(target != null) {
				//該当するidが見つかったら(nullじゃなかったら)Formへ変換
				MovieForm form = MovieHelper.convertMovieForm(target);
				//modelに格納
				model.addAttribute("movieForm",form);
				return "movie/form";
			}else {
				//該当するidがないよ(もしくはnull)のテキスト表示
				attributes.addFlashAttribute("errorMessage","対象データがありません");
				//一覧画面にリダイレクト
				return "redirect:/movie";
			}
			
		}
		
		//更新する画面
		@PostMapping("/update")
		public String update(@Validated MovieForm form, BindingResult bindingResult, @RequestParam("imageFile") MultipartFile imageFile, RedirectAttributes attributes){
			//＝＝＝バリデチェック入ります＝＝＝
			if(bindingResult.hasErrors()) {
				form.setIsNew(false);
				return "movie/form";
			}
			
			 // 画像アップロード処理
		    String imagePath = null;
		    if (!imageFile.isEmpty()) {
		        try {
		            // 保存先ディレクトリ
		            String uploadDir = "src/main/resources/static/uploadImages/";
		            Path uploadPath = Paths.get(uploadDir);

		            // ディレクトリが存在しない場合は作成
		            if (!Files.exists(uploadPath)) {
		                Files.createDirectories(uploadPath);
		            }

		            // ファイルを保存
		            String fileName = imageFile.getOriginalFilename();
		            Path filePath = uploadPath.resolve(fileName);
		            Files.copy(imageFile.getInputStream(), filePath);

		            // データベースに保存するパス
		            imagePath = "/uploadImages/" + fileName;
		        } catch (IOException e) {
		            e.printStackTrace();
		            attributes.addFlashAttribute("message", "画像のアップロードに失敗しました！");
		            return "redirect:/movie/form";
		        }
		    }
			
			//entityに変換
			Movie movie = MovieHelper.convertMovie(form, imagePath);
			//更新実行
			service.updateMovie(movie);
			//成功したよ、のテキスト表示
			attributes.addFlashAttribute("message","データが更新されました");
			//PRGパターン
			return "redirect:/movie";
		}
		
		//削除
		@PostMapping("/delete/{id}")
		public String delete(@PathVariable Integer id,RedirectAttributes attributes){
			//削除実行
			service.deleteMovie(id);
			//削除したよ、のテキスト表示
			attributes.addFlashAttribute("message","データが削除されました");
			//PRGパターン
			return "redirect:/movie";
		}
}
