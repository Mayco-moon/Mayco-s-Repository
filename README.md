# アプリ名「My Movie Review」
作成：２０２５年４月<br>
制作期間：約２週間

<hr>

![メイン画像](https://github.com/Mayco-moon/movie_review_app/blob/661ea7cc093a0b3ac0cfcfb3fe5364c17ad48342/image/main.jpg)
 
<hr>

## 制作の経緯

このアプリは、職業訓練校での学習の一環として制作しました。<br> 
JavaやSpring Boot、PostgreSQLといった技術を実践的に使いながら、<br>
日々観た映画を記録・管理するためのシンプルなレビューアプリを目指しています。<br> 
内部機能は学習時にテスト制作したものを土台に、html、css、javascriptを充実させてアップデートした仕様です。<br> 
<br>
このアプリの計画の発端は「おすすめの映画ある？」にすぐ答えたい自らの希望でした。<br>
何観たっけ？どういう感想だったっけ？など、自身の記憶を留めておける備忘録として計画しました。<br>
あわよくば、このアプリを開いて見せながら会話が弾むような場面が生まれると嬉しいです。<br>
<br>
<hr>

## 機能説明

- 映画のタイトル、ジャンル、公開年、評価、あらすじ、レビューを登録可能
- 映画ごとに画像（ポスターなど）をアップロード
- 一覧表示、詳細表示、編集、削除の基本機能を搭載
- Thymeleafを用いた画面構成とデータバインディング
- 登録日時・更新日時の自動記録

<hr>

## レスポンシブデザイン

想定する閲覧者のデバイス傾向を考慮し、レスポンシブデザイン対応させています。
スマホでの操作感をより快適に、見やすくするためのUI設計を心掛けました。

![一覧ページスクリーンショット](https://github.com/Mayco-moon/movie_review_app/blob/661ea7cc093a0b3ac0cfcfb3fe5364c17ad48342/image/readme_list.jpg)


![詳細ページスクリーンショット](https://github.com/Mayco-moon/movie_review_app/blob/9e4cec63a82b6eb2ac2b67eb4fb3cedc35bbc3d6/image/readme_detail.jpg)


![ログインページスクリーンショット](https://github.com/Mayco-moon/movie_review_app/blob/661ea7cc093a0b3ac0cfcfb3fe5364c17ad48342/image/readme_login.jpg)

<hr>

## 今後追加したい機能

- ソート機能の充実（ジャンル別、洋画or邦画、公開年を絞るなど）
- 映画観賞日時の登録（不明な場合の処理など未検討のため）
- 複数の管理者ごとにDBを構築できるようにする（現在は登録・編集権限を持つadminと、閲覧のみの権限を持つuser）
