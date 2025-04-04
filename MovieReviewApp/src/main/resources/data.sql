--最初から入れとくデータ３件分（画像パスがまだ正しくない！！）
INSERT INTO movies (title, genre, release_year, rating, summary, review, image, created_at, updated_at)
VALUES 
('関心領域', '戦争', 2024, 2, '戦争をテーマにした社会派映画。', '見る側の、知識や考え方、立場、想像力、環境、精神状態によって全く違う見え方の作品だろうと思う。予備知識なしにいきなり見ると、ただの退屈な薄暗い映画にしか感じられないかもしれない。', '/uploadImages/kanshinryouiki.jpg', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('ウィキッド ふたりの魔女', 'ミュージカル', 2024, 5, 'オズの魔法使いの前日譚を描いた作品。', '舞台版の良さ・見どころを持ち合わせつつ、映画ならではの演出や映像表現がワクワクする。全シーンの全衣装が好きすぎる。エルファバ役のシンシア・エリヴォの歌唱力が素晴らしく、もっとこの人の歌が聞きたいと思った。', '/uploadImages/wicked.jpg', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('ラストマイル', 'サスペンス', 2024, 5, 'テレビドラマ「アンナチュラル」と「MIU404」と交差する世界線。最後の一歩が運命を左右するミステリーサスペンス。', 'この映画を見て、自分の日常を顧みない人はほぼいないと思う。届けるのも受け取るのも人間。', '/uploadImages/lastmile.jpg', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 認証テーブルへのダミーデータの追加
-- password：adminpass
INSERT INTO authentications (username, password, authority, displayname) 
VALUES('admin', '$2a$10$1pN0F.ETCVHUBa2hzWB5iOxogvWS2b/D5GbIuXZv.gQ8H01Ybq4zC', 'ADMIN', 'Admin name');
-- password：userpass
INSERT INTO authentications (username, password, authority, displayname) 
VALUES('user', '$2a$10$/jar9xXQ6lrnVjLvLGv5BepFkLnGIO49RrGx42p2i.1hQt1BZ/7E2', 'USER', 'User name');