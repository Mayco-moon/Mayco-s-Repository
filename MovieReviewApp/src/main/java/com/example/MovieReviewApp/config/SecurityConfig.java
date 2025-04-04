package com.example.MovieReviewApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	/** DI対象が存在すれば、DIして使用する */
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http
		//==httpリクエストに対するセキュリティ設定==
		.authorizeHttpRequests(authz -> authz //ラムダ式。設計上必要な記述。やってることは左から右へ流してるだけ～
		//「/login」へのアクセスには認証不要
		.requestMatchers("/login").permitAll()
		// 【管理者権限設定】url:/movie/**は管理者(ADMIN)しかアクセスできない
		.requestMatchers("/movie/**").hasAuthority("ADMIN")
		//それ以外のリクエストは要認証
		.anyRequest().authenticated())
		
		//==カスタム版のログイン認証==
		.formLogin(form -> form
		// カスタム版のURL
		.loginPage("/login")
		
		//==ログイン==
		// ログイン処理のURLを指定
		.loginProcessingUrl("/authentication")
		// ユーザー名のname属性を指定
		.usernameParameter("usernameInput")
		// パスワードのname属性を指定
		.passwordParameter("passwordInput")
		// ログイン成功時のリダイレクト先を指定
		.defaultSuccessUrl("/")
		// ログイン失敗時のリダイレクト先を指定
		.failureUrl("/login?error"))
		
		//==ログアウト==
		.logout(logout -> logout
		// ログアウトを処理するURLを指定
		.logoutUrl("/logout")
		// ログアウト成功時のリダイレクト先を指定
		.logoutSuccessUrl("/login?logout")
		// ログアウト時にセッションを無効にする
		.invalidateHttpSession(true)
		// ログアウト時にCookieを削除する（＝ログアウトしたのに再認証無しで入れちゃう、を防止）
		.deleteCookies("JSESSIONID")
		);
		return http.build();
	}
}
