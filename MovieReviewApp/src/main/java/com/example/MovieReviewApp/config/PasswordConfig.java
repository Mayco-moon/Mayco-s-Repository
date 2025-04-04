package com.example.MovieReviewApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		// パスワードを安全に保管するために
		// パスワードをエンコード（ハッシュ化）するための仕組み
		
		// エンコードの設定
		return new BCryptPasswordEncoder();
		
		//return NoOpPasswordEncoder.getInstance();
		// NoOperation（何もしない）のパスワードエンコーダーを使用する場合
		// これによりパスワードは変換されずにそのままの形で保存されます。
		// NoOpPasswordEncoderは、実際のアプリケーションでの使用は推奨されていません。
		}
}
