package com.example.MovieReviewApp.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
//↑Spring Securityが提供する"UserDetails"インターフェースを実装すると
//オーバーライドする項目が多いので
//簡易版の"User"を今回は実装して使います。

//なのでextendsするのも"User"↓
public class LoginUser extends User{
	
	// 【追加部分】追加のフィールド
	private String displayname;
	
	public LoginUser(String username,String password,
			Collection<? extends GrantedAuthority>authorities, String displayname) { // 【追加部分】displaynameを追加) {
		super(username,password,authorities);
		this.displayname = displayname;
		}
	
	// 【追加部分】displaynameのgetter
	public String getDisplayname() {
	return displayname;
	}
}
