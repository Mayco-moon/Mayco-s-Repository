--テーブルが存在したら削除する
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS authentications;
DROP TYPE IF EXISTS role;

--moviesテーブルの作成
CREATE TABLE movies (
	--主キーID、自動インクリメント
    id serial PRIMARY KEY,
    --タイトル　NULLダメ設定
    title VARCHAR(255) NOT NULL,
    --ジャンル
	genre VARCHAR(100),
	--公開年
	release_year INTEGER,
	--評価（1～5）
    rating INTEGER CHECK (rating BETWEEN 1 AND 5),
    --あらすじ
	summary TEXT,
	--感想
    review TEXT,
    --画像(URL？パス?を文字列で受け取る)
    image VARCHAR(255),
    --登録日
    created_at TIMESTAMP without time zone,
    --更新日
    updated_at TIMESTAMP without time zone
);

-- 権限用のENUM型
CREATE TYPE role AS ENUM ('ADMIN', 'USER');
--「authority」に「role」で定義された「ADMIN」と「USER」のみが設定可能である

-- 認証情報を格納するテーブル作成
CREATE TABLE authentications (
	-- ユーザー名：主キー
	username VARCHAR(50) PRIMARY KEY,
	-- パスワード（nullダメ設定）
	password VARCHAR(255) NOT NULL,
	-- 権限
	authority role NOT NULL,
	-- 表示名
	displayname VARCHAR(50) NOT NULL
);