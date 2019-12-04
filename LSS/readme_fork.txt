LineageStatusSimulator_fork2018

変更点
2019/12/04
Update 3.6.4
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
料理追加
	パタラシの和牛ステーキ
		継続時間:900秒/近距離ダメージ:+2/近距離命中:+1/ダメージ低下:+2/MR:+10/HP自然回復:+2/MP自然回復:+2/EXP:+5%/属性抵抗:ALL+10
		栄養:10/種類:食べ物[料理]/材質:植物性/重さ:1
	パタラシのサーモンカナッペ
		継続時間:900秒/遠距離ダメージ:+2/遠距離命中:+1/ダメージ低下:+2/MR:+10/HP自然回復:+2/MP自然回復:+2/EXP:+5%/属性抵抗:ALL+10
		栄養:10/種類:食べ物[料理]/材質:植物性/重さ:1
	パタラシの七面鳥焼き
		継続時間:900秒/SP:+2/ダメージ低下:+2/MR:+10/HP自然回復:+2/MP自然回復:+3/EXP:+5%/属性抵抗:ALL+10
		栄養:10/種類:食べ物[料理]/材質:植物性/重さ:1
	パタラシのキノコスープ
		継続時間:900秒/ダメージ低下:+2/EXP:+10%/栄養:10/種類:食べ物[スープ]/材質:植物性/重さ:1

2019/12/04
Update 3.6.3
LSS/data/E.zip
LSS/src/lss/Bougu.java
仕様変更
	2019/12/04 Update
	https://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=2350

	特性:根性のアミュレット部位装備の特性が誓いに変更され、+5以上に強化時のオプションが上方修正
	特性:情熱のリング部位装備の強化により、獲得できるPvP追加ダメージオプションが上方修正
	特性:意地のベルト部位装備の強化により、獲得できるPvPダメージ低下オプションが上方修正
	参考資料:http://www.lineagenews.info/article/462263821.html

装備修正
	アミュレットの特性:根性を誓いへ
	対象:最果てのアミュレット/ゼラチンキューブのアミュレット(剣士)/ゼラチンキューブのアミュレット(術士)以外すべて

	ゼラチンの体力のアミュレット/ゼラチンの精神のアミュレット
	材質:骨をゴールドへ

2019/11/20
Update 3.6.2
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
仕様変更
	HW/EW/BW/SFの武器からキャラにかかるエンチャント効果の変更

2019/11/20
Update 3.6.1
LSS/data/E.zip
LSS/src/lss/Bougu.java
LSS/src/lss/Buki.java
LSS/src/lss/Calculator.java
LSS/src/lss/Common.java
LSS/src/lss/UI.java
修正及び追加

	2019/11/20 Update
	https://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=2338

君主
魔法の名称変更
	ブレイブアバター >>> オーラ
	グレイスアバター >>> グレイス

魔法追加
	シャイニングアーマー
	持続時間:300秒 
	消耗:MP25 HP50
	効果:術者のER+10

	マジェスティ
	持続時間:300秒 
	消耗:MP20
	効果:術者のダメージ低下+2(レベル80から2つレベルが上がる毎に+1)

イリュージョニスト
魔法追加
	ダークホース
	持続時間:自動 常時
	効果:ユグドラの実使用時 攻撃速度増加(BPと同じ攻撃速度で仮設定)

ウィザード
魔法追加
	エンチャントアキュラシー
	持続時間:300秒
	消耗:MP10
	効果:術者の近距離命中+5

	フリージングアーマー
	持続時間:300秒
	消耗:MP20
	効果:術者のER＋5

ダークエルフ
魔法効果変更
	ファイナルバーン
	持続時間:自動、常時
	効果:HPが70%以下の時、近距離クリティカル+5%(レベル80から2つレベルが上がる毎に+1%)

	アンキャニー ドッジ
	持続時間:960秒
	消耗:MP40

エンチャント欄から削除
	ムービングアクセレーション
	ベノムレジスト

装備オプション変更
	震怒のクロウ
	+8から+10まで+1強化あたり精霊命中+1

ドラゴンナイト
装備オプション変更
	殲滅者のチェーンソード
	非損傷に変更

エルフ
魔法効果変更
	レジスト エレメント
	持続時間:自動 常時
	効果:MR+5 全属性抵抗+5%

	クリアー マインド
	持続時間:1,200秒
	消耗:MP10
	効果:術者のSTR+1 DEX+1 INT+1

	ソウル オブ フレイム
	持続時間:320秒
	消耗:MP40

	インフェルノ
	持続時間:128秒
	消耗:MP50 HP70

ナイト
技術効果変更
	カウンター バリア
	持続時間:128秒
	消耗:MP15

	リダクション アーマー
	持続時間:300秒

ウォリアー
装備オプション変更
	ディヴァイン マジック ヘルム
	装備=PKEWDRIをALLへ

	鍛冶屋のアックス
	small=15を16へ
	big=15を16へ
	重さ=50を40へ

	ジャイアントアックス(新規追加)
	small=23
	big=25
	安全強化+6
	STR+1
	近距離ダメージ+4
	近距離命中+5
	非損傷
	重さ=100
	材質:メタル

	ラフィアンアックス
	small=23を24へ
	big=26を27へ

	テンペストアックス
	small=28を29へ
	big=30を31へ
	重さ=110を100へ

オプション変更
	マジックドール:バンパイア
　	タイタン系列発動区間オプションの削除
　	恐怖命中+3 技術耐性+5を追加

オプション追加
	エリクサールーン(コメントのみ追加､効果未実装)
	80レベルエリクサールーン:PVP魔法ダメージ減少+1%
	85レベルエリクサールーン:PVP魔法ダメージ減少+2%
	90レベルエリクサールーン:PVP魔法ダメージ減少+3%

装備オプション変更
	もみじリング
	使用した変身に全ステータス+1/最大HP+200

	アントクイーン シルバーウィング
　	+5から+9までER+1ずつ追加(最大+5)

修正
	フォーカススピリットの効果
	イーグルアイの効果

2019/10/16
Update 3.6.0
LSS/data/E.zip
追加
	LV93達成記念品
	https://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=2323
	+9 マエストロ: Broly(シャツ)
	AC:3(+9)、STR+1、DEX+1、INT+1、全耐性+5、ダメージ低下+5、技術耐性+11、MR+16、PvPダメージ低下+4
	不可:移動、倉庫、削除、強化、追加倉庫

2019/09/18
Update 3.5.9
LSS/src/lss/Bougu.java
修正
	強化+9時のPVP追加ダメージが未反映(最大+2)(Ora2さんによって指摘)
	対象防具
		星の腕力イアリング
		星の機敏イアリング
		星の知力イアリング
		月光の腕力ネックレス
		月光の機敏ネックレス
		月光の知力ネックレス

LSS/data/E.zip
修正
	ブレイズショック
	魔法ディレイ1から0へ		基本ダメージ20から40へ
	基本魔法発動率=0.01から0.02へ	魔法発動率強化=0.01から0.02へ
	対象武器
		ハロウィンソード.txt
		ハロウィンツーハンドソード.txt
		ハロウィンアックス.txt
		ハロウィンスタッフ.txt
		ハロウィンデュアルブレード.txt
		ハロウィンチェーンソード.txt
		ハロウィンキーリンク.txt
		ハロウィンボウ.txt
		幸運のランス.txt
		幸運のキーリンク(2019_09_旧仕様).txt
		幸運のキーリンク.txt

LSS/src/lss/Calculator.java
修正
	強化+10武器時のツールチップの表示(暫定処理)

2019/09/17
Update 3.5.8
LSS/data/E.zip
LSS/src/lss/Bougu.java
修正
	裂空のTシャツの仕様	強化0時 技術耐性+11,全耐性+1(Ora2さんによって指摘)
	技術耐性=11>>>技術耐性=12(11+1)
	精霊耐性=1
	秘技耐性=1
	恐怖耐性=1
	*+6以降はDR,MR,全耐性+1

	カーツの闘志の守護インシグニア>>>闘志の守護インシグニア(Ora2さんによって指摘)
	カーツの射手の守護インシグニア>>>射手の守護インシグニア
	カーツの賢者の守護インシグニア>>>賢者の守護インシグニア

2019/09/11
Update 3.5.7
LSS/data/E.zip
修正及び追加
	2019/09/11 Update
	https://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=2303
	幸運装備リニューアル(8種類)
	旧仕様の武器は残しました｡
	幸運のランスのブレイズショックは仕様不明な為､幸運のキーリンクと同仕様設定

2019/08/14
Update 3.5.6
LSS/src/lss/Bougu.java
修正
	2019/08/14 Update
	https://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=2296
	合成インシグニアに[PvPダメージ低下][祝福消耗効率向上]のオプションを追加

2019/08/01
Update 3.5.5
LSS/data/E.zip
修正
	射手の紋章(猫3匹と住んでる人さんによって指摘)

2019/07/30
Update 3.5.4
LSS/src/lss/Bougu.java
修正
	強化+5のオプション値(フラビさんによって指摘)
	カーツの闘士の守護インシグニア
	カーツの射手の守護インシグニア
	カーツの賢者の守護インシグニア

2019/07/26
Update 3.5.3
LSS/src/lss/Buff.java
修正
	前回対象外の登録した装備品と読み込む処理の部分
	コメントアウト部分を解除
	startsWithは指定した文字列の始まりの文字列を判定する為
	ダメージ低下=とPVPダメージ低下=の区別が可能

LSS/data/E.zip
用語統一
	ダメージ軽減　　　　　　   >>> ダメージ低下　　   ベルト等
	ダメージリダクション　　   >>> ダメージ低下　　   ガイアの憤怒等
	ダメージリダクション無視   >>> ダメージ低下無視   ガイアの憤怒等
	PVPダメージ減少　　　　　　>>> PVPダメージ低下　　古代岩石装備等

新規
	クロノスのベルト

2019/07/25
Update 3.5.2
LSS/src/lss/Buki.java
修正
	強化によるオプションが適用されていない不具合を修正
	テンペストアックス(奈落発動)(yuusyuuwarさんによって指摘)
	死神の剣(REMASTERED)(ウェポンアタック発動)

2019/07/24
Update 3.5.1
LSS/src/lss/Bougu.java
LSS/src/lss/Buki.java
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
新規及び修正
	2019/07/24 Update
	https://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=2291

	祝福されたマジックドールに追加される効果
	祝福されたランク3マジックドール:AC-2
	祝福されたランク4マジックドール:AC-2 PVP追加ダメージ+2
	祝福されたランク5マジックドール:AC-2 PVP追加ダメージ+2 PVPダメージ低下+4

	ヴァラカス/リンドビオル/アンタラス/パプリオンの各マジックドールに追加される効果
	AC-2 PVP追加ダメージ+4 PVPダメージ低下+2

用語統一
	ダメージ軽減			>>>	ダメージ低下
	ダメージリダクション		>>>	ダメージ低下
	ダメージリダクション無視	>>>	ダメージ低下無視
	PVPダメージ減少			>>>	PVPダメージ低下

LSS/src/lss/Buff.java
	*ただし登録した装備品と読み込む処理の部分は今回は対象外
	108行から一応コメントアウトして次回修正

LSS/src/lss/Common.java
変数削除
	//final int ITEM_MD2 = 78;    //新マジックドール

2019/07/19
Update 3.5.0
LSS/data/E.zip
新規
	死神の剣(REMASTERED)
	素材		ブラックミスリル
	魔法発動確率	1%
	上昇率		1%
	魔法威力	火属性ダメージ/ライトニングストライク級(暫定)

LSS/src/lss/Buki.java
新規
	死神の剣(REMASTERED)
	+1強化毎に[近距離追加ダメージ+2][近距離クリティカル+1%][技術命中+1][精霊命中+1][恐怖命中+1]増加

修正
	ガイアの激怒
	強化+1時の追加ダメージが近距離追加ダメージだった為、遠距離追加ダメージに修正

	各種武器のコメント修正

LSS/src/lss/Calculator.java
アンデッド特攻のダメージ修正
	修正前ダメージ1～20
	修正後ダメージ1～40

2019/06/19
Update 3.4.9
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
VIPエンチャントのツールチップ追加
	Platinum        HP+150 MP+150 MR+12 AC-5
	Gold            HP+150 MP+120 MR+10 AC-5
	Red             HP+120 MP+120 MR+10 AC-5

新料理追加
	祝福された力強い和牛ステーキ
	祝福された素早い鮭の煮付け
	祝福された賢い七面鳥焼き
	祝福された修練の鶏スープ
		メインが素の効果に全クラススキル命中+3を追加
		スープが素の効果に全クラススキル耐性+2 PvPDR+2を追加

2019/05/24
Update 3.4.8
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
修正
	ブレイブメンタル
		基礎値33%から40%へ変更
		処理部分を同様スキルと統一して修正
	サイクロン
		エンチャントタブのサイクロンにチェックしキャラを保存、再度キャラを呼び出すと
		キャラのサイクロンのチェックが外れる
		原因はサイクロンの武器の種別判定に不具合があったのでその部分を削除
		(弓以外でもチェックすることが可能になってしまう)

ツールチップ修正
	ブレイブメンタル
		一定確率(40%)で近接ダメージ1.5倍
	カウンターバリア(未実装)
		両手剣装備時 一定確率(20%)で近距離攻撃回避+反撃
		カウンターダメージは武器の[BIG打撃値]+[追加ダメージ]+[強化数]x[2]
	インフェルノ(未実装)
		一定確率(不明)で近距離ダメージを50%軽減しカウンター攻撃
		カウンターダメージは武器の[SMALL打撃値]+[追加ダメージ]+[強化数]x[1~4(ランダム)]
	モータルボディー(未実装)
		一定確率(25%)でAC/2(最低40)ダメージの反撃
	クラッシュ
		一定確率(15%)でダメージ増加 Lv/2
	フューリー
		クラッシュ発動時、一定確率(10%)でダメージ2倍
	タイタンロック(未実装)
		HP40%以下時一定確率(35%)で近距離攻撃回避+反撃
		カウンターダメージは武器の[BIG打撃値]+[追加ダメージ]+[強化数]x[2]
	タイタンマジック(未実装)
		HP40%以下時一定確率(35%)で魔法攻撃回避+反撃
		カウンターダメージは武器の[BIG打撃値]+[追加ダメージ]+[強化数]x[2]
	タイタンブリッツ(未実装)
		HP40%以下時一定確率(35%)で遠距離攻撃回避+反撃
		カウンターダメージは武器の[BIG打撃値]+[追加ダメージ]+[強化数]x[2]

2019/05/23
Update 3.4.7
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
修正
	2019/05/22 Update
	https://event2.ncsoft.jp/1.0/lineage/1905update
	サイクロン
		LV75取得可能 一定確率で遠距離ダメージ1.5倍 LV85からLV1毎に発動率1%増加
		基礎値40%から基礎値5%+LVUP分へ変更

2019/05/22
Update 3.4.6
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
修正
	ミラーイメージ
		物理回避DG+60からDG+30へ変更、ツールチップ表示も修正
	アンキャニードッジ
		物理回避DG+60からDG+30へ変更、ツールチップ表示も修正
	ディクリースウェイト/エルブングラヴィティ/リデュースウェイト
		コメント修正

Update 3.4.5
LSS/src/lss/Calculator.java
修正
	2019/02/20 Update
	https://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=2185
	AC-100以上からAC-10ごとにDG,ERが+1
	効果:AC110時:DG+1/ER+1 AC120時:DG+2/ER+2･･･

2019/05/21
Update 3.4.4
LSS/src/lss/Calculator.java
LSS/src/lss/Common.java
LSS/src/lss/UI.java
追加
	バフコイン
		近距離ダメージ+1 遠距離ダメージ+1 SP+1
		final int WAR = 63; 		>>> final int BUFF_COIN = 63;	//バフコイン

	エルブングラヴィティ
		所持重量増加+300
		final int DRAGONRAID = 57; 	>>> final int E_EGR = 57;	//エルブングラヴィティ

修正
	ディクリースウェイト
		ツールチップの表示
		重量-150		 	>>> 所持重量増加+180

Update 3.4.3
LSS/data/E.zip
修正
	神聖な一撃のリング
		AC=0 >>> AC=-1
	カーツの闘士の守護インシグニア
		+0の性能が+5の性能になっていたため修正
	カーツの賢者の守護インシグニア
		+0の性能が+5の性能になっていたため修正
	カーツの射手の守護インシグニア
		+0の性能が+5の性能になっていたため修正
	マミーロードクラウン
		精霊耐性=3 >>> 精霊耐性=4

LSS/src/lss/Bougu.java
修正
	闘士の竜Tシャツ
	射手の竜Tシャツ
	賢者の竜Tシャツ
		+8の性能の精霊耐性+1/秘技耐性+1/恐怖耐性+1 >>> 精霊耐性+2/秘技耐性+2/恐怖耐性+2

2019/05/20
Update 3.4.2
LSS/data/E.zip
新規
	ポルセの剣(REMASTERED)
	シバインのシールド
	オリムのアミュレット
	セマのリング

LSS/src/lss/Calculator.java
追加
	セマオリムセットの処理

2019/05/18
Update 3.4.1
LSS/data/E.zip
修正
	月光の知力ネックレス
		月光の知識ネックレス >>> 月光の知力ネックレス

2019/05/12
Update 3.4.0
LSS/data/E.zip
修正
	神聖な腕力のリング
		AC=0 >>> AC=-2

2019/05/10
Update 3.3.9
LSS/data/E.zip
新規
	デスブレード

2019/04/23
Update 3.3.8
LSS/src/lss/UI.java
修正
	初期DRを30から0へ

Update 3.3.7
LSS/data/E.zip
	2016/08/03 Update
	https://www.ncsoft.jp/lineage/launcher/popup/view?bbsNo=3101&articleNo=1734
新規
	隠された魔族のソード　　　　　　*ホステリティーソードと同等
	隠された魔族のボウ　　　　　　　*ホステリティーボウと同等(KR仕様)
	隠された魔族のスタッフ　　　　　*ホステリティースタッフと同等
	隠された魔族のクロウ　　　　　　*ホステリティークロウと同等
	隠された魔族のチェーンソード　　*ホステリティーチェーンソードと同等
	隠された魔族のキーリンク　　　　*ホステリティーキーリンクと同等
	隠された魔族のアックス

修正
	ホステリティースタッフ
		近距離命中=3 >>> 近距離命中=4
	ホステリティーキーリンク
		近距離命中=3 >>> 近距離命中=0

LSS/src/lss/Calculator.java
修正
	ブローアタック
		基礎値40%+LVUP分から基礎値5%+LVUP分へ変更

2019/04/17
Update 3.3.6
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
	2019/04/17 Update
	https://event2.ncsoft.jp/1.0/lineage/1904deathknight/
新規
	真デスナイトの遺物/強化された真デスナイトの遺物(腕力)/(知力)/(機敏)

Update 3.3.5
LSS/data/E.zip
新規
	レッドナイトソード
	レッドナイトソード(REMASTERED)
	刀
	刀(REMASTERED)	*片手剣からダガーに変更
	ツルギ
	ツルギ(REMASTERED)

LSS/src/lss/Calculator.java
修正
	ブローアタック
		ON/OFFを繰り返すと((level - 74) * 0.01)%分ダメージが追加されていく
	ダブルブレイク:デスティニー
		ダメージ計算式の修正
	ダブルブレイク
		ダメージ計算式の修正

2019/03/09
Update 3.3.4
LSS/src/lss/Calculator.java
修正
	新マジックドールの種類と効果が一部違う(アイスクイーン以降のMD)

2019/03/07
Update 3.3.3
LSS/data/E.zip
	2019/03/06 Update
	https://event2.ncsoft.jp/1.0/lineage/1903Arrogance/
新規
	アラガンスゲートル 重さ:80

2019/03/03
Update 3.3.2
LSS/src/lss/Calculator.java
修正
	黒蛇のコインのツールチップ

LSS/src/lss/UI.java
	ダメージリダクションの範囲(-30から30)を(0から60)へ

2019/03/02
Update 3.3.1
LSS/src/lss/Bougu.java
LSS/src/lss/Buff.java
LSS/src/lss/Calculator.java
LSS/src/lss/Common.java
LSS/src/lss/UI.java
削除
	不必要なコメント

LSS/src/lss/Calculator.java
修正
	黒蛇のコイン
		[Update前]HP+20 MP+13 AC-2 ダメージ軽減+3 暗闇耐性+10
		[Update後]HP+20 MP+13 AC-2 ダメージ軽減+4(*表記はAC-1でも実際の効果はAC-2)
	黒蛇の加護に関する不具合
	https://www.ncsoft.jp/lineage/news/trouble/view?bbsNo=3111&articleNo=47
		[Update後]HP+20 MP+13 AC-2 ダメージ軽減+3

2019/02/25
Update 3.3.0
LSS/src/lss/Calculator.java
LSS/src/lss/Common.java
LSS/src/lss/UI.java
修正
	カウンターバリア  　　　必要LV50からLV80へ
	覚醒[リンドビオル]　　　DG10からDG7へ
	ミラーイメージ　　　　　コメント:DG50からDG60へ
	覚醒[アンタラス]　　　　単体スキルとして使用できるように変更
	覚醒[ヴァラカス]　　　　単体スキルとして使用できるように変更

新規
	カウンターバリア:ベテラン
	final int COIN = 73;        //*********************************未実装(予約分)
    	final int K_CB2 = 73;       //カウンターバリア:ベテラン
	カウンターバリア発動確率上昇 85レベルから1レベル毎に発動確率1%増加

	ダブルブレイク:デスティニー
	final int W_I2H = 28;       //*********************************未実装(予約分)
	final int D_DB2 = 28;       //ダブルブレイク:デスティニー
	ダブルブレイク発動確率上昇 80レベルから1レベル毎に発動確率1%増加

	フォースレイヤー:ブレイブ
	final int E_DB = 60;        //*********************************未実装(予約分)
	final int R_FS2 = 60;       //フォースレイヤー:ブレイブ

削除
	覚醒[パプリオン]　　　　火力には反映されない為

2019/02/24
Update 3.2.9
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
修正
	エリクサールーンのツールチップの表示
	スキルのコメント
削除
	古代の加護

2019/02/23
Update 3.2.8
LSS/src/lss/Calculator.java
修正
	新マジックドールのツールチップの表示と処理を旧マジックドールと同一にした

	マジックレベル(ML)の仕様
	[2009年頃の仕様]
	君主最大ML=2
	ナイト　　　　　　最大ML=1
	エルフ　　　　　　最大ML=6
	ウィザード　　　　最大ML=10
	ダークエルフ　　　最大ML=2
	ドラゴンナイト　　最大ML=3
	イリュージョニスト最大ML=4
	[2014年02月頃の仕様]
	君主　　　　　　　最大ML=2
	ナイト　　　　　　最大ML=1
	エルフ　　　　　　最大ML=6
	ウィザード　　　　最大ML=13
	ダークエルフ　　　最大ML=2
	ドラゴンナイト　　最大ML=4
	イリュージョニスト最大ML=10
	[Update後]
	君主　　　　　　　最大ML=2
	ナイト　　　　　　最大ML=1
	エルフ　　　　　　最大ML=7 (変更)
	ウィザード　　　　最大ML=14(変更)
	ダークエルフ　　　最大ML=2
	ドラゴンナイト　　最大ML=4
	イリュージョニスト最大ML=10
	ウォーリア　　　　最大ML=1
	*尚､ML1に対する必要LVは不明の為､未反映

LSS/src/lss/UI.java
修正
	エリクサールーンLV55の表示

2019/02/22
Update 3.2.7
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
追加
	真心がこもった料理(料理)
	15分間 ダメージリダクション+5 近距離ダメージ+2 遠距離ダメージ+2 近距離命中+2 遠距離命中+2
	SP+2 HP回復+3 MP回復+4 MR+15 すべての属性抵抗+10の効果が得られます｡

	真心がこもったスープ(デザート)
	15分間 ダメージリダクション+5 経験値ボーナス+5%の効果が得られます。

	真心のこもった祝福スクロール(自己エンチャント)
	30分間 ダメージリダクション+3 近距離ダメージ+2 遠距離ダメージ+2 近距離命中+2 遠距離命中+2
	魔法命中+2 SP+2 最大HP+50 HP回復+3 最大MP+30 MP回復+3 経験値ボーナス+5%の効果が得られます。
修正
	用語[属性防御]を[属性抵抗]へ変更
	VIPエンチャントを基本(前半)部分へ移動

LSS/src/lss/Common.java
変更
	final int BS = 74;  	//*********************************未実装(予約分)
	final int MBSC = 74;	//真心のこもった祝福スクロール
修正
	(未実装)コメントを削除

Update 3.2.6
LSS/src/lss/Common.java
LSS/src/lss/UI.java
修正
	火属性耐性/水属性耐性/風属性耐性/地属性耐性の表示位置

	属性抵抗
	地属性抵抗/火属性抵抗
	水属性抵抗/風属性抵抗

	技術耐性/精霊耐性/秘技耐性/恐怖耐性/技術命中/精霊命中/秘技命中/恐怖命中の表示位置

	命中/耐性
	技術命中/技術耐性
	精霊命中/精霊耐性
	秘技命中/秘技耐性
	恐怖耐性/恐怖命中

Update 3.2.5
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
修正
	覚醒[アンタラス]
		[Update前]AC-3 ホールド耐性+10
		[Update後]AC-3
	覚醒[パプリオン]
		[Update前]重さが50~82%でも､HPとMPが自然回復する 凍結耐性+10
		[Update後]重さが50~82%でも､HPとMPが自然回復する
	黒蛇のコイン
		[Update前]HP+20 MP+13 AC-2 ダメージ軽減+3 暗闇耐性+10
		[Update後]HP+20 MP+13 AC-2 ダメージ軽減+4(*表記はAC-1でも実際の効果はAC-2)
	術士たちの護符>>術師たちの護符
	
Update 3.2.4
LSS/data/E.zip
新規
	エルモアローブ
	エルモアレザーアーマー
	エルモアプレートメイル
	光るエルモアレザーアーマー
	光るエルモアプレートメイル
	光るエルモアローブ
修正
	裂空のTシャツ
	フィアバンパイアマント
	アントクイーンゴールデンウィング
	アントクイーンシルバーウィング
	火霊/風霊/水霊のガーダー(前回修正済)
	体力のガーダー(前回修正済)
	反逆者の盾>>反逆者のシールド
	シアーの心眼
	エヴァのシールド
	アンタラスグランドプレートメイル
	アンタラスグランドスケイルメイル
	アンタラスグランドレザーアーマー
	アンタラスグランドローブ
	パプリオンハイドロプレートメイル
	パプリオンハイドロスケイルメイル
	パプリオンハイドロレザーアーマー
	パプリオンハイドロローブ
	リンドビオルストームプレートメイル
	リンドビオルストームスケイルメイル
	リンドビオルストームレザーアーマー
	リンドビオルストームローブ
	ヴァラカスフレイムプレートメイル
	ヴァラカスフレイムスケイルメイル
	ヴァラカスフレイムレザーアーマー
	ヴァラカスフレイムローブ
	ディヴァインエルブンプレートメイル
	スタン耐性のTシャツ>>技術耐性のTシャツ(前回修正済)
	スタン耐性の特性Tシャツ(DR)>>技術耐性の特性Tシャツ(DR)(前回修正済)
	スタン耐性の特性Tシャツ(自然回復)>>技術耐性の特性Tシャツ(自然回復)(前回修正済)
	スタン耐性の特性Tシャツ(追加打撃)>>技術耐性の特性Tシャツ(追加打撃)(前回修正済)
	ホールド耐性のTシャツ>>精霊耐性のTシャツ(前回修正済)
	ホールド耐性の特性Tシャツ(DR)>>精霊耐性の特性Tシャツ(DR)(前回修正済)
	ホールド耐性の特性Tシャツ(自然回復)>>精霊耐性の特性Tシャツ(自然回復)(前回修正済)
	ホールド耐性の特性Tシャツ(追加打撃)>>精霊耐性の特性Tシャツ(追加打撃)(前回修正済)
	腕力のスタン耐性Tシャツ>>腕力の技術耐性Tシャツ(前回修正済)
	腕力のホールド耐性Tシャツ>>腕力の精霊耐性Tシャツ(前回修正済)
	機敏のスタン耐性Tシャツ>>機敏の技術耐性Tシャツ(前回修正済)
	機敏のホールド耐性Tシャツ>>機敏の精霊耐性Tシャツ(前回修正済)
	知力のスタン耐性Tシャツ>>知力の技術耐性Tシャツ(前回修正済)
	知力のホールド耐性Tシャツ>>知力の精霊耐性Tシャツ(前回修正済)
	ライアリング
	ドッペルゲンガーアミュレット
	神聖な永生のアミュレット
	火霊のイアリング
	水霊のイアリング
	風霊のイアリング
	地霊のイアリング
	オーガキングベルト
	エンシェントジャイアントリング
	苦痛のアミュレット(前回修正済)
	気迫のリング(前回修正済)
	神聖な気迫のリング(前回修正済)
	神聖な魔王のリング(前回修正済)
	射手のリング>>一撃のリング
	神聖な射手のリング>>神聖な一撃のリング
	ドッペルゲンガーライトリング(前回修正済)
	ドッペルゲンガーレフトリング(前回修正済)
	+7～9イアリング/アミュレット(前回修正済)
	スナッパーのリング(前回修正済)

LSS/src/lss/Bougu.java
LSS/src/lss/Buki.java
LSS/src/lss/Calculator.java
修正
	大魔術師の帽子
	フィアバンパイアマント
	アントクイーンゴールデンウィング
	アントクイーンシルバーウィング
	シアーの心眼
	エヴァのシールド
	アンタラスグランドプレートメイル
	アンタラスグランドスケイルメイル
	アンタラスグランドレザーアーマー
	アンタラスグランドローブ
	パプリオンハイドロプレートメイル
	パプリオンハイドロスケイルメイル
	パプリオンハイドロレザーアーマー
	パプリオンハイドロローブ
	リンドビオルストームプレートメイル
	リンドビオルストームスケイルメイル
	リンドビオルストームレザーアーマー
	リンドビオルストームローブ
	ヴァラカスフレイムプレートメイル
	ヴァラカスフレイムスケイルメイル
	ヴァラカスフレイムレザーアーマー
	ヴァラカスフレイムローブ
	マジックドール:イエティ
	マジックドール:キングバグベアー(処理上変更無)
	マジックドール:バランカ
	地竜の魔眼
	水竜の魔眼
	風竜の魔眼
	火竜の魔眼
	誕生の魔眼
	形状の魔眼
	生命の魔眼
	漆黒の水晶球(防具のカテゴリーから武器のカテゴリーへ移動)

2019/02/21
Update 3.2.3
	2019/02/20 Update
	https://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=2185

LSS/src/lss/Bougu.java
LSS/src/lss/Buff.java
LSS/src/lss/Buki.java
LSS/src/lss/Calculator.java
命中/耐性の修正(竜語から秘技へ名称変更)
	ailment[DRAGON]		竜語耐性>>ailment[SECRET]	秘技耐性
	ailment[HIT_DRAGON]	竜語命中>>ailment[HIT_SECRET]	秘技命中

LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
修正
	グレースアバター
		全耐性+5(80レベルから1レベルにつき耐性+1 最大+10)から
		全耐性+5(80レベルから1レベルにつき耐性+1 最大+15)へ
	幻術[オーガ]
		近距離ダメージ+4 近距離命中+4 遠距離ダメージ+4から
		近距離ダメージ+4 近距離命中+4へ
	エリクサールーン(LV70/80/85/90)各職

LSS/data/E.zip
新規
	混沌のヘルム
変更
	大魔法使いの帽子>>大魔術師の帽子
修正
	ガイアの激怒
	レッドシャドウデュアルブレード
	クロノスの恐怖
	ヒュペリオンの絶望
	指揮官のヘルム
	マミーロードクラウン
	ディヴァインブレスオブエルム
	大魔術師の帽子
	裂空のTシャツ

LSS/src/lss/Buki.java
処理の修正
	ガイアの激怒
	クロノスの恐怖
	ヒュペリオンの絶望
	殲滅者のチェーンソード
	殲滅者のチェーンソード(殲滅発動)
	殺意のキーリンク

LSS/src/lss/Bougu.java
処理の修正
	大魔術師の帽子
	裂空のTシャツ

LSS/src/lss/Bougu.java
LSS/data/E.zip
新規
	新たな竜のTシャツ
	https://event2.ncsoft.jp/1.0/lineage/1902dragonTshirts/
	闘士の竜Tシャツ/射手の竜Tシャツ/賢者の竜Tシャツ/守護の竜Tシャツ

2019/02/20
Update 3.2.2
	2019/02/20 Updateに暫定対応

LSS/data/E.zip
名称変更
	グリムリーパーリング	>>死神のリング
	リッチリング		>>リッチのリング
	
命中/耐性の変更
	スタン耐性	>>技術耐性
	ホールド耐性	>>精霊耐性
	スタン命中	>>技術命中
	ホールド命中	>>精霊命中
	破壊命中	>>精霊命中

	02_ドッペルゲンガーアミュレット.txt
	02_神聖な永生のアミュレット.txt
	12_苦悩のアミュレット.txt
	12_苦痛のアミュレット.txt
	e_月光の敏捷ネックレス.txt
	e_月光の知識ネックレス.txt
	e_月光の腕力ネックレス.txt
	e_ハロウィンパンプキンアーマー.txt
	e_ハロウィンパンプキンアーマー2012.txt
	10004_裂空のTシャツ.txt
	20601_スタン耐性のTシャツ.txt"
	20602_スタン耐性の特性Tシャツ(DR).txt"
	20603_スタン耐性の特性Tシャツ(自然回復).txt"
	20604_スタン耐性の特性Tシャツ(追加打撃).txt"
	20701_ホールド耐性のTシャツ.txt
	20702_ホールド耐性の特性Tシャツ(DR).txt
	20703_ホールド耐性の特性Tシャツ(自然回復).txt
	20704_ホールド耐性の特性Tシャツ(追加打撃).txt
	60102_腕力のスタン耐性Tシャツ.txt"
	60103_腕力のホールド耐性Tシャツ.txt
	60202_機敏のスタン耐性Tシャツ.txt"
	60203_機敏のホールド耐性Tシャツ.txt
	60302_知力のスタン耐性Tシャツ.txt"
	60303_知力のホールド耐性Tシャツ.txt
	01_ククルカンシールド.txt
	x10_体力のガーダー.txt
	x10_地霊のガーダー.txt
	x10_水霊のガーダー.txt
	x10_火霊のガーダー.txt
	x10_風霊のガーダー.txt
	02_マミーロードクラウン.txt
	02_指揮官のヘルム.txt
	10006_ライアリング.txt
	10013_ドッペルゲンガーレフトリング.txt
	10014_ドッペルゲンガーライトリング.txt
	10101_気迫のリング.txt
	10101_神聖な気迫のリング.txt
	10102_神聖な魔王のリング.txt
	10103_リッチのリング
	10104_死神のリング.txt
	e_ラオンの最高級リング(スタン).txt
	e_ラオンの最高級リング(ホールド).txt
	n_地の精霊のリング.txt
	n_風の精霊のリング.txt
	0310004_ナイトバルドのツーハンドソード.txt
	0310005_真冥王の執行剣.txt
	1010007_ヒュペリオンの絶望.txt
	0710007_レッドシャドウデュアルブレード.txt

LSS/src/lss/Bougu.java
LSS/src/lss/Buff.java
LSS/src/lss/Common.java
変更前:耐性
	ailment[STUN]		スタン耐性
	ailment[HOLD] 		ホールド耐性
	ailment[SLEEP]		睡眠耐性
	ailment[FREEZE]		凍結耐性
	ailment[STONE]		石化耐性
	ailment[DARKNESS]	暗闇耐性
	ailment[TERROR]		恐怖耐性
	ailment[DESTRUCTION]	破壊耐性

変更後:耐性
	ailment[STUN]		技術耐性
	ailment[SPIRIT]		精霊耐性
	ailment[DRAGON]		竜語耐性
	ailment[TERROR]		恐怖耐性

変更前:命中
	ailment[HIT_STUN]	スタン命中
	ailment[HIT_HOLD]	ホールド命中
	ailment[HIT_SLEEP]	睡眠命中
	ailment[HIT_FREEZE]	凍結命中
	ailment[HIT_STONE]	石化命中
	ailment[HIT_DARKNESS]	暗闇命中
	ailment[HIT_TERROR]	恐怖命中
	ailment[HIT_DESTRUCTION]破壊命中

変更後:命中
	ailment[HIT_STUN]	技術命中
	ailment[HIT_SPIRIT]	精霊命中
	ailment[HIT_DRAGON]	竜語命中
	ailment[HIT_TERROR]	恐怖命中

LSS/src/lss/Bougu.java
処理の修正
	クーガーのガーダー
	ウグヌスのガーダー
	アイリスのブーツ
	地竜のTシャツ/火竜のTシャツ/風竜のTシャツ/水竜のTシャツ

コメント修正
	スナッパーリング

LSS/src/lss/UI.java
	ツールチップの修正/コメント追加
	ブレイブアバター
	グレースアバター
	プライド
	ブローアタック
	覚醒[ヴァラカス]
	覚醒[リンドビオル]
	幻術[オーガ]
	幻術[アバター]
	フォーカススピリッツ
	インパクト
	注意:Tシャツの処理の"のスタン耐性"/"のホールド耐性"については変更しない(名称不明な為)

LSS/src/lss/Calculator.java
処理の修正
	インパクト
	ブレイブアバタ
	グレースアバター

不明(後日確認)
	覚醒[アンタラス]
	覚醒[パプリオン]
	イエティ
	魔眼
	黒蛇の気

LSS/src/lss/Buki.java
処理の修正
	レッドシャドウデュアルブレード
	修正前:op2.ailment[HIT_DESTRUCTION] += enchant;	破壊命中から
	修正後:op2.ailment[HIT_SPIRIT] += enchant;	精霊命中へ

コメント修正/追加
	スタン命中を技術命中へ
	破壊命中を精霊命中へ

2018/12/30
Update 3.2.1
LSS/src/lss/UI.java
	コメントの修正
	設定したエリクサールーンレベルとエリクサルーンの保存と読込に対応

LSS/src/lss/Calculator.java
	デバッグ用のコードのコメントアウト

LSS/src/lss/Common.java
	変数にコメント追加(使用/未使用の把握の為)

LSS/src/lss/Morph.java
	コメントの削除

2018/12/28
Update 3.2.0
LSS/src/lss/LEV.java
	LV96までの対応(エリクサー最大仕様数10個に対応する為)

LSS/src/lss/UI.java
LSS/src/lss/Calculator.java
	LV96までの対応(LV92から変更)
	パネル2(レベル/エリクサー)のエリクサー最大使用数10個(LV95時)に対応
	パネル3(エンチャント)のSTR部分のツールチップ修正
	パネル4(耐性設定)のMRを標準100に設定

2018/12/27
Update 3.1.9
LSS/src/lss/UI.java
LSS/src/lss/Calculator.java
位置移動
	UIのセキュリティの位置移動

ツールチップ表記追加
	3種類の魔力回復ポーション(魔力回復ポーション/古代の魔力回復ポーション/神秘の濃縮マナポーション)の効果が同一
	WIS10未満	MPR+1
	WIS10以上	MPR(WIS-8)/2の数値
	
効果修正
	修正前:if (wis >= 10) {
        修正前:mpr += (wis - 10) / 2;
        修正前:ui.pure_status_bonus[1][22].setText(Integer.toString((wis - 10) / 2));

	修正後:if (wis >= 10) {
        修正後:mpr += (wis - 8) / 2;
        修正後:ui.pure_status_bonus[1][22].setText(Integer.toString((wis - 8) / 2));

魔眼の暫定追加(耐性関連はリニューアル後対応)
	地竜の魔眼	 物理攻撃回避+10%(未実装) 竜語耐性+5(未実装)

	水竜の魔眼	 10%の確率で魔法ダメージ半減(未実装) 精霊耐性+5(未実装)

	風竜の魔眼	 一定確率で魔法クリティカル+2%(未実装) ER+10 恐怖耐性+5

	火竜の魔眼	 一定確率で近距離ダメージ+2 遠距離ダメージ+2(未実装) 技術耐性+5

	誕生の魔眼	 一定確率で[物理攻撃回避][魔法ダメージ半減](未実装) 精霊耐性+5(未実装) 竜語耐性+5(未実装)

	形状の魔眼	 一定確率で[物理攻撃回避][魔法ダメージ半減][魔法クリティカル+1%](未実装) 精霊耐性+5(未実装) 竜語耐性+5(未実装) 恐怖耐性+5

	生命の魔眼	 一定確率で[物理攻撃回避][魔法ダメージ半減][魔法クリティカル+1%][近距離ダメージ+2 遠距離ダメージ+2](未実装)
			 技術耐性+5 精霊耐性+5(未実装) 竜語耐性+5(未実装) 恐怖耐性+5

	グレムリンの魔眼 近距離ダメージ+2 遠距離ダメージ+2 SP+1

LSS/src/lss/Common.java
変数追加
	ITEM_MAGAN = 98;(魔眼)で計99個分(0から98)

2018/12/26
Update 3.1.8
LSS/src/lss/Calculator.java
	轟音のデュアルブレードは存在しないので処理の削除
	咆哮のデュアルブレードのダメージ処理式の修正

遠距離命中の計算式の修正(現在は遠距離命中には近距離命中分は含まない仕様)
	訂正前:hit_long += bougu1.op.HIT_LONG + bougu1.op.HIT_SHORT + bougu1.op2.HIT_LONG + bougu1.op2.HIT_SHORT;
	訂正後:hit_long += bougu1.op.HIT_LONG +                       bougu1.op2.HIT_LONG;

"追加ダメージ +XX X%"の表記されているアイテムのsmallダメージに追加ダメージが反映されていない為､処理を修正
	例.強化+5以上のルームティスブラックイアリング/強化+4以上の祝福されたルームティスブラックイアリング

2018/12/24
Update 3.1.7
LSS/src/lss/Common.java
	変数DRAGONをDRAGONRAIDへ予約変更(2018/12/21 Update 3.1.4)の修正

LSS/src/lss/Calculator.java
	マジックドールの効果の修正
	ツールチップの追加及び修正
	闘士の戦闘強化スクロール/射手の戦闘強化スクロール/賢者の戦闘強化スクロールを追加
	キーリンクのbigダメージにクリティカルダメージが反映されてない為、処理を修正

LSS/src/lss/UI.java
	パネル3(エンチャント)のUI修正

2018/12/22
Update 3.1.6
LSS/data/E.zip
名称修正
	アースガーダー		>>>	地霊のガーダー
	ウォーターガーダー	>>>	水霊のガーダー
	ウィンドガーダー	>>>	風霊のガーダー
	ファイアーガーダー	>>>	火霊のガーダー
	クーガーのガーダー 	>>>	クーガーのガーダー(名前の後ろに半角スペースがあり削除)

LSS/src/lss/Bougu.java
処理部分の名称修正
	アースガーダー		>>>	地霊のガーダー
	ウォーターガーダー	>>>	水霊のガーダー
	ウィンドガーダー	>>>	風霊のガーダー
	ファイアーガーダー	>>>	火霊のガーダー
	ウズヌスのガーダー	>>>	ウグヌスのガーダー

処理の修正
	[技術耐性][精霊耐性][竜語耐性][恐怖耐性]+6から+1ずつ増加(最大+5)ただし支配者の塔のUPDATE後になる為、コメントアウト
	尚、地霊のガーダーには上記効果は付かない

	テイパーガーダーが+10になると+9の追加オプションがすべて消える為、修正

Update 3.1.5
LSS/data/E.zip
装備追加
	修練者のアロー
	修練者のシルバーアロー
	スティング
	ガントレット

	英雄のキーリンク(ダメージダイス=2d5+25)
	片手武器  35/35 材質:オリハルコン 重さ:30
	SP+3　INT+1 魔法命中+5
	魔法発動:審判[無属性] 発動率+1 強化毎に1%増加(基本ダメージ20で設定)
	装備可能クラス:イリュージョニスト
	*補足:[魔法属性=XXX]の行を記述しなければ[無属性]を表現できるためそれを利用
	*注意:ダメージダイスと魔法ダメージは最低設定

装備修正
	ククルカンガントレット
	真のガントレット

2018/12/21
Update 3.1.4
LSS/data/E.zip
装備追加
	殺意のキーリンク(ダメージダイス=2d5+25)
	片手武器  35/35 材質:ジュエリー 重さ:35
	SP+2　INT+1 魔法クリティカル+1%
	魔法発動:ソウルカッター 発動率+1 強化毎に1%増加(基本ダメージ20で設定)
	魔法クリティカル+7から+1増加(最大+5)
	装備可能クラス:イリュージョニスト
	*注意:ダメージダイスと魔法ダメージは最低設定

装備修正
	光るエルモアキーリンク
	[SP=1]と設定するところ[SP+1]としていた為､修正

LSS/src/lss/Calculator.java
ツールチップの修正
	石化命中/睡眠命中/凍結命中/暗闇命中/スタン命中/ホールド命中/恐怖命中/破壊命中の表記を
	石化命中+/睡眠命中+/凍結命中+/暗闇命中+/スタン命中+/ホールド命中+/恐怖命中+/破壊命中+へ変更

LSS/src/lss/Buki.java
LSS/src/lss/Common.java
	殺意のキーリンクの強化時の追加オプションの反映
	*注意:竜語命中+7から+1増加(最大+4)は準備のみで未実装
	//final int DRAGON = 16;
	//final int HIT_DRAGON = 17;
	//final int SPIRIT = 18;
	//final int HIT_SPIRIT = 19; 
	*MD関連でfinal int DRAGON = 57;(ドラゴンレイド?)で事前に予約しているみたいなので実装時に変更予定

Update 3.1.3
LSS/data/E.zip
装備追加
エルモア武器(強化不可)
	エルモアダガー
	片手武器 5/6 材質:ミスリル 重さ:30
	STR+1 追加ダメージ+8 近距離命中+3 HP自然回復+1
	装備可能クラス:君主 ナイト エルフ ウィザード ダークエルフ

	エルモアボウガン
	片手武器  7/8 材質:木 重さ:30
	追加ダメージ+8 遠距離命中+4
	装備可能クラス:エルフ ダークエルフ イリュージョニスト

	エルモアクロウ
	両手武器 17/16 材質:メタル 重さ:60
	追加ダメージ+7 近距離命中+4
	装備可能クラス:ダークエルフ

	エルモアスタッフ
	両手武器 7/4 材質:ブラックミスリル 重さ:60
	追加ダメージ+7 SP+3 近距離命中+5 MP自然回復+5
	装備可能クラス:ウィザード イリュージョニスト

	エルモアチェーンソード
	両手武器 18/15 材質:メタル 重さ:60
	DEX+1 追加ダメージ+9 近距離命中+5 HP自然回復+2
	装備可能クラス:ドラゴンナイト

	エルモアキーリンク
	片手武器  33/33 材質:ブラックミスリル 重さ:20
	最大MP+35 MP自然回復+3
	装備可能クラス:イリュージョニスト

	エルモアソード
	片手武器 13/15 材質:メタル 重さ:40
	STR+1 追加ダメージ+6 近距離命中+5
	装備可能クラス:君主 ナイト エルフ ドラゴンナイト

	エルモアツーハンドソード
	両手武器 17/20 材質:メタル 重さ:60
	追加ダメージ+10
	装備可能クラス:君主 ナイト ドラゴンナイト

光るエルモア武器(SHOP武器/利用30日制限/強化不可)
	光るエルモアダガー
	http://www.ncsoft.jp/shop/1894/28686/detail
	片手武器 7/8 材質:ミスリル 重さ:30
	STR+1 追加ダメージ+9 近距離命中+3 HP自然回復+1
	装備可能クラス:君主 ナイト エルフ ウィザード ダークエルフ

	光るエルモアボウ
	http://www.ncsoft.jp/shop/1894/28687/detail
	片手武器  12/10 材質:木 重さ:30
	DEX+1､追加ダメージ+9 遠距離命中+4
	装備可能クラス:エルフ ダークエルフ イリュージョニスト

	光るエルモアクロウ
	http://www.ncsoft.jp/shop/1894/28688/detail
	両手武器 17/16 材質:メタル 重さ:60
	STR+1 追加ダメージ+8 近距離命中+4
	装備可能クラス:ダークエルフ

	光るエルモアスタッフ
	http://www.ncsoft.jp/shop/1894/28689/detail
	両手武器 11/11 材質:ブラックミスリル 重さ:75
	追加ダメージ+7 SP+3 近距離命中+5 MP自然回復+5
	装備可能クラス:ウィザード イリュージョニスト

	光るエルモアチェーンソード
	http://www.ncsoft.jp/shop/1894/28690/detail
	両手武器 18/15 材質:メタル 重さ:60
	STR+1 追加ダメージ+9 近距離命中+5 HP自然回復+2
	装備可能クラス:ドラゴンナイト

	光るエルモアキーリンク
	http://www.ncsoft.jp/shop/1894/28691/detail
	片手武器  33/33 材質:ブラックミスリル 重さ:20
	SP+1 最大MP+35 MP自然回復+3
	装備可能クラス:イリュージョニスト

	光るエルモアアックス
	http://www.ncsoft.jp/shop/1894/28692/detail
	片手武器  17/17 材質:メタル 重さ:100
	追加ダメージ+8 近距離命中+2
	装備可能クラス:ウォリアー

LSS/src/lss/Buki.java
	+10以上のレジェンド武器のエンチャントによる追加打撃を修正

2018/10/30
Update 3.1.2
LSS/data/E.zip
LSS/src/lss/Buki.java
装備追加
	http://event2.ncsoft.jp/1.0/lineage/1810halloween/
	ハロウィンソード
	ハロウィンツーハンドソード
	ハロウィンアックス
	ハロウィンスタッフ
	ハロウィンデュアルブレード
	ハロウィンチェーンソード
	ハロウィンキーリンク
	ハロウィンボウ
	魔法発動:ブレイズショック[火属性] 発動率+1強化毎に1%増加

	幸運のキーリンク
	魔法発動:ブレイズショック[火属性] 発動率+1強化毎に2%増加

2018/10/15
Update 3.1.1
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
	2017/07/19 Update
	エリクサー最大使用数6個(LV75時)に対応

Update 3.1.0
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
	ドラゴンの遺物/強化されたドラゴンの遺物(腕力/知力/機敏)を実装
	2018/04/25 Update
	http://event2.ncsoft.jp/1.0/lineage/1804dragonItem/

LSS/src/lss/Bougu.java
LSS/src/lss/Buki.java
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
LSS/src/lss/WideComboBox.java
	全体的なソースコードの修正
	NetBeans IDEでFindBugs Integration[バグパターンに合致する箇所を検出するツール]という
	便利なプラグインがあり、使用しわかる範囲で修正

日本語Javadocの設定
	デフォルトでは、Java SE APIおよびJavaFX APIのJavadocへの参照設定は英語版
	[ツール] > [Javaプラットフォーム] > [Javaプラットフォームマネージャ] > [Javadoc]タブを選択
	デフォルトで登録されているJDKのJavadocおよびJavaFXのjavadocを、次のURLに差し替える。
	[URLの追加]ボタンで追加
	http://docs.oracle.com/javase/jp/8/docs/api/
	http://docs.oracle.com/javase/jp/8/javafx/api/
	*コード補完でポップアップされる表示は、JDKのソースコードから直接生成されているので日本語にはならない。

2018/10/11
Update 3.0.9
LSS/data/E.zip
	幸運のアロー追加

LSS/src/lss/Bougu.java
LSS/src/lss/Buki.java
LSS/src/lss/Calculator.java
LSS/src/lss/FSCalclator.java
LSS/src/lss/UI.java
	全体的なソースコードの修正
	NetBeans IDEでFindBugs Integration[バグパターンに合致する箇所を検出するツール]という
	便利なプラグインがあり、使用しわかる範囲で修正

2018/10/10
Update 3.0.8
LSS/data/E.zip
追加
	登録上の[重さ=]のない装備に[重さ=]を登録

削除
	02_シアーの心眼(KR).txt	
	x10_マナのガーダー.txt(守護のガーダーに変更になった為)
	02_ブラックエルダーサンダル(KR).txt

変更
	n_地精霊の指輪.txtを
		n_地の精霊のリング.txtへ変更

	n_風精霊の指輪.txtを
		n_風の精霊のリング.txtへ変更
新規追加
	g_反逆者のヘルム.txt
	x10_クーガーのガーダー.txt
	x10_ウグヌスのガーダー.txt
	x10_ファイアーガーダー.txt
	x10_ウィンドガーダー.txt
	x10_ウォーターガーダー.txt
	x10_アースガーダー.txt
	02_アイリスのブーツ.txt

LSS/src/lss/Bougu.java
処理の修正
	[知識のブーツ]の処理してたところの名前を[知力のブーツ]に修正

処理の追加
	01_ナイトバルドのゲートル.txt
	+5から[近距離命中]+1増加(最大+5)

	01_アイリスのゲートル.txt
	+5から[遠距離命中]+1増加(最大+5)

	01_バンパイアのゲートル.txt
	+5から[魔法命中]+1増加(最大+5)

	x10_クーガーのガーダー.txt
	+5から[近距離命中]+1増加(最大+8) +5から[技術耐性][精霊耐性][竜語耐性][恐怖耐性]+1増加(最大+5)

	x10_ウグヌスのガーダー.txt
	+5から[遠距離命中]+1増加(最大+8) +5から[技術耐性][精霊耐性][竜語耐性][恐怖耐性]+1増加(最大+5)

	x10_ファイアーガーダー.txt
	+5から[近距離命中]+1増加 +7から[近距離ダメージ]+1増加

	x10_ウィンドガーダー.txt
	+5から[遠距離命中]+1増加 +7から[遠距離ダメージ]+1増加

	x10_ウォーターガーダー.txt
	+5から[魔法命中]+1増加 +7から[SP]+1増加

	x10_アースガーダー.txt
	+5から[MR]１%増加 +7から[ダメージ軽減]+1増加

	02_アイリスのブーツ.txt
	+5から[技術耐性][精霊耐性][竜語耐性][恐怖耐性]+1増加(最大+5)

	*[精霊耐性]の変数はailment[SPIRIT]を予定
	*[竜語耐性]の変数はailment[DRAGON]を予定

2018/10/09
Update 3.0.7
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
	古代の加護/アルカの遺物/強化されたアルカの遺物を実装
	今後のLV80/LV85/LV90のエリクサールーンも暫定で実装
	2017/01/25 Update
	http://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=1790

	今後Updateの技術命中/精霊命中/竜語命中/恐怖命中/技術耐性/精霊耐性/竜語耐性/恐怖耐性(計4+4=8)の表示修正
	グレースアバターの[君主LV80][君主LV81][君主LV82][君主LV83][君主LV84][君主LV85]表示を
	[君主L80][君主L81][君主L82][君主L83][君主L84][君主L85+]へ変更

Update 3.0.6
LSS/data/E.zip
	[重量=]を[重さ=]へ変更

削除
	02_リッチローブ(KR).txt
修正
	02_マミーロードのグローブ.txt
	[特殊=+7から[SP]+1増加(最大+3)]を削除

LSS/src/lss/Buff.java
	防具のツールチップに重さを表示する為に変数を武器の変数と統一[WEIGHT]へ
	[重さ=]を読み取り[WEIGHT]へ入力処理

LSS/src/lss/Buki.java
	武器のツールチップだけで使用してた[weight]を削除

LSS/src/lss/Calculator.java
	統一した[WEIGHT]を使用し[重さ]を表示

LSS/src/lss/Bougu.java
	マミーロードのグローブの特殊=+7から[SP]+1増加(最大+3)の処理追加
	防具のツールチップに[WEIGHT]を使用し[重さ]を表示
	[重さ=]の登録がない装備は重さ表示はされない

2018/10/08
Update 3.0.5
LSS/data/E.zip
2017/07/19 Update
http://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=1877

新規装備
01_ブラックナイトヘルム.txt
	ブラックナイトヘルム
	ヘルム 重さ:40 材質:メタル AC-5 ダメージ減少+1 +5以上1強化毎にMR+4
	装備クラス:ナイト

02_オーガキングベルト.txt(修正)
	オーガキングベルト
	ベルト 重さ:50 材質:皮 AC-2 最大HP+20 ダメージ減少+1 所持重量増加+1500
	装備クラス:全クラス

01_漆黒のマント.txt
	漆黒のマント
	マント 重さ:10 材質:布 AC-1 MP回復+2 CHA+1 +7強化以降+1強化毎にCHA+1(+9強化まで)
	装備クラス:ウィザード

02_神聖な腕力のアミュレット.txt(修正)
	神聖な腕力のアミュレット
	アミュレット 重さ:20 材質:ジュエリー AC-1 STR+1 近距離命中+2 MR+5
	装備クラス:全クラス

02_神聖な機敏のアミュレット.txt(修正)
	神聖な機敏のアミュレット
	アミュレット 重さ:20 材質:ジュエリー AC-1 DEX+1 遠距離命中+2 MR+5
	装備クラス:全クラス

02_神聖な知力のアミュレット.txt(修正)
	神聖な知力のアミュレット
	アミュレット 重さ:20 材質:ジュエリー AC-1 INT+1 魔法命中+2 MR+5
	装備クラス:全クラス

02_神聖な永生のアミュレット.txt
	神聖な永生のアミュレット
	アミュレット 重さ:20 材質:ジュエリー AC-2 スタン耐性+7
	装備クラス:全クラス

01_ディヴァインブレスオブエルム.txt
	ディヴァインブレスオブエルム
	ヘルム 重さ:13 材質:皮 AC-2 DEX+1 遠距離ダメージ+1 +5以上1強化毎にMR+4
	装備クラス:エルフ

01_ディヴァインエルブンプレートメイル.txt
	ディヴァインエルブンプレートメイル
	アーマー 重さ:150 材質:オリハルコン AC-6 ダメージ減少+1 MR+5 HP回復+6 MP回復+6 発動:フェアリーの加護
	装備クラス:ナイト エルフ ダークエルフ ウォリアー

01_ディヴァインエルヴンシールド.txt(修正)
	ディヴァインエルブンシールド
	シールド 重さ:50 材質:シルバー AC-3 ダメージ減少+2 確率ダメージリダクション+10(1強化毎に1%上昇)
	装備クラス:君主 ナイト エルフ

02_守護騎士のパワーグローブ.txt(修正)
	守護騎士のパワーグローブ
	グローブ 重さ:18 材質:皮 AC-1 STR+2 +5以上1強化毎に近距離命中+1(+9強化まで)
	装備クラス:君主 ナイト エルフ ダークエルフ ドラゴンナイト ウォリアー

02_守護騎士のブレイサー.txt(修正)
	守護騎士のブレイサー
	グローブ 重さ:10 材質:皮 AC-0 DEX+2 +5以上1強化毎に遠距離命中+1(+9強化まで)
	装備クラス:エルフ

0210014_真レイピア .txt(未修正)
	真レイピア
	片手剣 重さ:60 材質:オリハルコン 16/14 追加ダメージ+3 近距離命中+4
	装備クラス:君主 ナイト エルフ

0310011_真武者の太刀.txt
	真武者の太刀
	両手剣 重さ:150 材質:金属 24/27 追加ダメージ+5 近距離命中+7 発動:闘魂(+10強化時追加)
	装備クラス:ナイト

0310011_真武者の太刀(闘魂発動).txt
	選択した時に+10になるように[安全=6][安全=9]に変更

10017_テレポート支配リング.txt
	変身支配リング
	リング 重さ:3 材質:ゴールド 着用時変身ワンドを用いた変身で特殊な効果が発生
	装備クラス:全クラス

0610008_アイスクイーンスタッフ.txt
	[small=2 big=3]を[small=3 big=4 追加ダメージ+1]へ変更

0610010_バフォメットスタッフ.txt
	[small=2 big=3]を[small=7 big=6]へ変更

02_反逆者の盾.txt
	[AC-3]を[AC-4]

0510004_テンペストアックス(奈落発動).txt
0910008_殲滅者のチェーンソード(殲滅発動).txt
1110013_悪夢のロングボウ(悪夢発動).txt
	選択した時に+10になるように[安全=6]を[安全=9]へ変更

0710008_ロンドゥデュアルブレード.txt
	[魔法=イラプション]を[魔法=リベンジ]へ変更

LSS/src/lss/Bougu.java
	[ブラックナイトヘルム]
	+5以上1強化毎にMR+4の処理追加

	[漆黒のマント]
	+7強化以降+1強化毎にCHA+1(+9強化まで)の処理追加

	[腕力のブーツ]
	+7強化以降1強化毎に最大HP+20(+9強化まで) +9強化でダメージ減少+1の処理追加

	[機敏のブーツ]
	+7強化以降1強化毎に最大HP+20(+9強化まで) +9強化でダメージ減少+1の処理追加

	[知識のブーツ]
	7強化以降1強化毎に最大HP+20(+9強化まで) +9強化でダメージ減少+1の処理追加

	[知恵のブーツ]
	+7強化以降1強化毎に最大HP+20(+9強化まで) +9強化でダメージ減少+1の処理追加

	[マンボハット]
	+7強化でCHA+1の処理追加

	[マンボコート]
	+7強化でCHA+1の処理追加

	[漆黒の水晶球]
	+9強化でCHA+1の処理追加

LSS/src/lss/Buki.java
	[バフォメットスタッフ]
	+7以降強化1毎にSP+1(+9まで適用)の処理追加

	[テンペストアックス]
	+8以降強化1毎に恐怖的中+1(+10強化まで適用)

	[タイタンの憤怒]
	基本恐怖的中+5 +1以降強化1毎に恐怖的中+1(+5強化まで適用)

	[形状の魔眼][生命の魔眼]
	ER+10追加
	*魔眼が未実装なので後日対応

Update 3.0.4
LSS/data/E.zip
	02_シルバーマント.txtを
		02_ディヴァインプロテクションクローク.txtへ変更
	[name=シルバーマント]を[name=ディヴァインプロテクションクローク]へ変更
	[AC=-2]を[AC=-3]へ変更
	[MR=6]を[MR=2]へ変更
	[MR強化=2]を[MR強化=3]へ変更

	02_アントクイーンゴールドウィング.txtを
		02_アントクイーンゴールデンウィング.txtへ変更
	[name=アントクイーンゴールドウィング]を[name=アントクイーンゴールデンウィング]へ変更
	[MR=5]を[MR=6]へ変更
	[MR強化=2]を[MR強化=3]へ変更

	02_アントクイーンシルバーウィング.txt
	[材質=シルバー]を[材質=布]へ変更
	[MP=50]を[MP=70]へ変更
	[MPR=3]を[MPR=5]へ変更
	[MR強化=2]を[MR強化=3]へ変更

	g_幸運のサークレット.txt
	[SP=0]を[SP=1]へ変更

LSS/src/lss/Bougu.java
	幸運のサークレットのSP+1の処理がBougu.javaで行われていたので修正
	不要なコメント削除

LSS/src/lss/Buki.java
	不要なコメント削除

2018/10/07
Update 3.0.3
LSS/data/E.zip
	裂空のTシャツのTが全角になっていた為修正

LSS/src/lss/Bougu.java
	裂空のTシャツの+1強化毎にスタン耐性+1増加に対応

Update 3.0.2
LSS/src/lss/Calculator.java
	オルターストーン7段階に[AC+1] 処理を[AC-1]へ修正

LSS/src/lss/Bougu.java
	マミーロードクラウン
	+7から[遠距離ダメージ]+1増加(最大+3)

	闘士の守護紋章
	射手の守護紋章
	賢者の守護紋章
	+5強化時[AC=0]を[AC=-2]へ
	
LSS/data/E.zip
	カーツの闘士の守護インシグニア
	カーツの射手の守護インシグニア
	カーツの賢者の守護インシグニア
	[AC=3]を[AC=-3]へ

	02_激昂のグローブ.txt
	[STR=0]を[STR=2]へ

2018/10/06
Update 3.0.1
LSS/data/E.zip
	チェーンソードの露出確率の訂正
	殲滅者のチェーンソード
	[弱点露出=0.125]を[弱点露出=0.1875]

	幸運のチェーンソード
	[弱点露出=0.25]を[弱点露出=0.3333]

	*露出4段の場合のFSのダメージ計算はよくわからないので保留
	http://line-zatta.seesaa.net/article/361203254.html(露出3段)

2018/10/05
Update 3.0.0
LSS_launcher/Updater.java
	インストールが面倒orわかりにくいとのことでオリジナルと同じようなLSS_launcher.exeが必要と判断
	GitHubのサイトに合わせてソースコードを変更、app_ver3.0.0、data_ver3.0.0とした。
	[LSS_launcher.jar]を作成し[LSS_launcher_2018.jar]とリネームしてlaunch4j Ver 3.12を使用し
	[LSS_launcher_2018.exe]を作成する

	launch4jの設定項目は3か所のみ
	[BASIC]
	Output files:C:\Users\ユーザー名\Desktop\LSS_2018\LSS_launcher_2018.exe
	         Jar:C:\Users\ユーザー名\Desktop\LSS_2018\LSS_launcher_2018.jar
	[JRE]
	Min JRE version:1.8.0

Update
LSS/src/lss/Bougu.java
LSS/src/lss/Buff.java
LSS/src/lss/Buki.java
LSS/src/lss/Calculator.java
LSS/src/lss/Common.java
LSS/src/lss/FSCalclator.java
LSS/src/lss/HitRateCalculator.java
LSS/src/lss/LEV.java
LSS/src/lss/LSS.java
LSS/src/lss/Morph.java
LSS/src/lss/MyToggleButton.java
LSS/src/lss/UI.java
LSS/src/lss/WideComboBox.java
LSS/data/E.zip
	開発環境では動作するが、他PCでは起動しないことが判明した。
	原因は文字コードみたいだが解決方法が見つからない為、元に戻すことに決定する。
	(2018/10/01に行った作業の逆"SHIFT-JISのCR+LFへ変更"を行う)

LSS/nbproject/project.properties
	NetBeansIDE 8.2のプロジェクト用の初期設定をUTF-8からShift-JISへ変更
	1.システム環境変数の[JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8]を削除
	2.C:\Program Files\NetBeans 8.2\etc\netbeans.conf
		[netbeans_default_optionsの -J-Dfile.encoding=UTF-8]を削除

ビルド時にでる6個の警告の修正作業(4個は改善)
	jdepend-2.9.1
	https://github.com/clarkware/jdepend#download
	から[jdepend-2.9.1.zip]を展開して[/lib/jdepend-2.9.1.jar]を
	C:\Program Files\Java\jdk1.8.0_181\libの中へ追加しNetBeans IDE 8.2の[ツール]の[オプション]の[Ant]の
	クラスパスに[C:\Program Files\Java\jdk1.8.0_181\lib\jdepend-2.9.1.jar]を追加
[処理前]
	Could not load class (org.apache.tools.ant.taskdefs.repository.MavenRepository) for type mavenrepository
	Could not load a dependent class (jdepend/xmlui/JDepend) for type jdepend
	Could not load a dependent class (javax/media/jai/PlanarImage) for type image
	Could not load class (org.apache.tools.ant.taskdefs.repository.MavenRepository) for type mavenrepository
	Could not load a dependent class (jdepend/xmlui/JDepend) for type jdepend
	Could not load a dependent class (javax/media/jai/PlanarImage) for type image
[処理後]
	Could not load class (org.apache.tools.ant.taskdefs.repository.MavenRepository) for type mavenrepository
	Could not load a dependent class (javax/media/jai/PlanarImage) for type image
	Could not load class (org.apache.tools.ant.taskdefs.repository.MavenRepository) for type mavenrepository
	Could not load a dependent class (javax/media/jai/PlanarImage) for type image

	Java Advanced Imaging API 1.1.2_01
	https://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-java-client-419417.html
 	Windows CLASSPATH Installから[jai-1_1_2_01-lib-windows-i586.exe]をダウンロードして実行し
	インストール後の[C:\jai-1_1_2_01\lib\jai_core.jar]を
	C:\Program Files\Java\jdk1.8.0_181\libの中へ追加しNetBeans IDE 8.2の[ツール]の[オプション]の[Ant]の
	クラスパスに[C:\Program Files\Java\jdk1.8.0_181\lib\jai_core.jar]を追加
[処理後]
	Could not load class (org.apache.tools.ant.taskdefs.repository.MavenRepository) for type mavenrepository
	Could not load a dependent class (com/sun/media/jai/codec/FileSeekableStream) for type image
	Could not load class (org.apache.tools.ant.taskdefs.repository.MavenRepository) for type mavenrepository
	Could not load a dependent class (com/sun/media/jai/codec/FileSeekableStream) for type image
	
	インストール後の[C:\jai-1_1_2_01\lib\jai_codec.jar]を
	C:\Program Files\Java\jdk1.8.0_181\libの中へ追加しNetBeans IDE 8.2の[ツール]の[オプション]の[Ant]の
	クラスパスに[C:\Program Files\Java\jdk1.8.0_181\lib\jai_codec.jar]を追加
[処理後]
	Could not load class (org.apache.tools.ant.taskdefs.repository.MavenRepository) for type mavenrepository
	Could not load class (org.apache.tools.ant.taskdefs.repository.MavenRepository) for type mavenrepository

2018/10/03
Update
LSS/dist/LSS.jar	
	NetBeans IDE 8.2上では動くのにビルドしてLSS_launcher.exe経由だと立ち上がらない
	原因はSHIFT-JISからUTF-8に文字コードを変えた以外考えられない為、2つのことを行いビルドする
	1.システム環境変数に[JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8]を追加
	2.C:\Program Files\NetBeans 8.2\etc\netbeans.confの
		[netbeans_default_optionsに -J-Dfile.encoding=UTF-8]を追加

Update
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
	オルタストーンの+7強化を実装
	2017/11/22 Update
	http://event2.ncsoft.jp/1.0/lineage/1711alterstone/

Update
LSS/data/E.zip
        /E/クローク
	フィアバンパイアマント修正(AC-4)

LSS/data/E.zip
        /E/インシグニア
	新規インシグニアの追加
	05_カーツの闘士の守護インシグニア.txt
	06_カーツの射手の守護インシグニア.txt
	07_カーツの賢者の守護インシグニア.txt

LSS/src/lss/Bougu.java
	新規インシグニアの追加
	2018/08/15 Update
	https://event2.ncsoft.jp/1.0/lineage/1808insigniaofKurtz/
	カーツの闘士の守護インシグニア
	カーツの射手の守護インシグニア
	カーツの賢者の守護インシグニア

Update
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
	新規マジックドールの追加(カーツ/バフォメット/堕落)
	2017/09/27 Update
	http://event2.ncsoft.jp/1.0/lineage/1709magicdoll/
	カーツ        最大HP+120 追加防御力+3 ダメージ低下+3 近距離ダメージ+4 近距離命中+4 フォースレイヤーダメージ+10
	バフォメット  最大HP+120 追加防御力+4 ダメージ低下+4 近距離ダメージ+3 近距離命中+3 恐怖的中+5
	堕落          SP+5 魔法命中+5 MP絶対回復+16(64秒)

Update
LSS/src/lss/Calculator.java
	[pvp_dg]と[pvp_dgr]を追加しPVP追加ダメージとPVPダメージリダクションを計算

LSS/src/lss/UI.java
	表示用に[lab_pvp_dg]と[lab_pvp_dgr]を追加しPVP追加ダメージとPVPダメージリダクションを表示

Update
LSS/data/E.zip
	ダメージリダクション無視=3を設定
	ヴァラカスフレイムプレートメイル
	ヴァラカスフレイムスケイルメイル
	ヴァラカスフレイムレザーアーマー
	ヴァラカスフレイムローブ

LSS/src/lss/Buff.java
LSS/src/lss/Buki.java
LSS/src/lss/Calculator.java
	変数の統一
	[dr_ignored]を[DR_IGNORED]へ
	[PVPDR]を[PVP_DR]へ

LSS/src/lss/Bougu.java
	防具のダメージリダクション無視を実装

LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
	パネル1に武器と防具のダメージリダクション無視を合計したものを表示
	近距離/遠距離/魔法クリティカルもすぐに確認できるようにパネル1でも表示

Update
LSS/src/lss/Bougu.java
	強化値で[近距離クリティカル][遠距離クリティカル][魔法クリティカル]が反映されるように修正
	[ダメージリダクション無視]は未実装
	ヴァラカスフレイムプレートメイル
	ヴァラカスフレイムスケイルメイル
	ヴァラカスフレイムレザーアーマー
	ヴァラカスフレイムローブ

2018/10/01
Update
LSS/src/lss/Bougu.java
LSS/src/lss/Buff.java
LSS/src/lss/Buki.java
LSS/src/lss/Calculator.java
LSS/src/lss/Common.java
LSS/src/lss/FSCalclator.java
LSS/src/lss/HitRateCalculator.java
LSS/src/lss/LEV.java
LSS/src/lss/LSS.java
LSS/src/lss/Morph.java
LSS/src/lss/MyToggleButton.java
LSS/src/lss/UI.java
LSS/src/lss/WideComboBox.java
	ソースコードが文字コードANSI(Shift-JIS)の為、GitHub Desktopで文字化けを起こす
	ので文字化けを起こさないUTF-8にする。またBOM無しにして今後メモ帳を使わずに
	TeraPadかNetBeans IDEで修正する。
	合わせて改行コードもCR+LFからLFに変更

LSS/data/E.zip
	E.zipのすべてのファイルもUTF-8NのLFへ変更

LSS/nbproject/project.properties
	NetBeansIDE 8.2のプロジェクト用の初期設定をShift-JISからUTF-8へ変更

Update
LSS/src/lss/UI.java
	現在のエリクサルーンの位置にタリスマンを実装
	スポールダーと紋章の間にエリクサルーンの位置を移動

LSS/src/lss/Calculator.java
	タリスマンの効果を実装

2018/09/30
Update
LSS/src/lss/UI.java
	ToolTipManagerを使用して実装
	ツールチップの表示時間を4秒(4000)から6秒(6000)へ

LSS/src/lss/Buff.java
	防具のツールチップにPVP追加ダメージとPVPダメージ減少を実装

Update
LSS/data/E.zip
	/E/
	[DR=]を[ダメージリダクション=]へ変更(対象:すべてのファイル)

LSS/src/lss/Buki.java
	コメントの削除と修正

LSS/src/lss/Buff.java
	武器のダメージリダクションを実装
	DRの表示に武器分のダメージリダクションも反映するように修正

LSS/src/lss/Calculator.java
	武器のチップセットにダメージリダクションを追加

Update
LSS/data/E.zip
	/E/武器/
	修正
	1110006_マリスエレメントボウ.txt	

LSS/src/lss/UI.java
	[黒蛇の気]を[黒蛇の加護]へ修正

LSS/src/lss/Buff.java
	ダメージリダクション無視を実装

LSS/src/lss/Buki.java
	不要な変数と不要なコメントを削除

	ガイアの激怒
	+1強化毎に[ダメージリダクション無視]+1増加を実装

LSS/src/lss/Calculator.java
	武器のチップセットにダメージリダクション無視を追加しレジェンド武器の強化時に+1増加され表示される様に変更
	
2018/09/29
Update
LSS/data/E.zip
	/E/
	[スタン成功=]を[スタン命中=]:1アイテム変更
	10104_グリムリーパーリング.txt
	[スタン=]を[スタン耐性=]:24アイテム変更
	02_ドッペルゲンガーアミュレット.txt
	12_苦痛のアミュレット.txt
	e_月光の敏捷ネックレス.txt
	e_月光の知識ネックレス.txt
	e_月光の腕力ネックレス.txt
	e_ハロウィンパンプキンアーマー2012.txt
	10004_裂空のＴシャツ.txt
	20601_スタン耐性のTシャツ.txt
	20602_スタン耐性の特性Tシャツ(DR).txt
	20603_スタン耐性の特性Tシャツ(自然回復).txt
	20604_スタン耐性の特性Tシャツ(追加打撃).txt
	60102_腕力のスタン耐性Tシャツ.txt
	60202_機敏のスタン耐性Tシャツ.txt
	60302_知力のスタン耐性Tシャツ.txt
	02_指揮官のヘルム.txt
	10006_ライアリング.txt
	10013_ドッペルゲンガーレフトリング.txt
	10014_ドッペルゲンガーライトリング.txt
	10101_気迫のリング.txt
	10101_神聖な気迫のリング.txt
	10102_神聖な魔王のリング.txt
	10103_リッチリング.txt
	e_ラオンの最高級リング(スタン).txt
	n_風精霊の指輪.txt

	[暗闇成功=]を[暗闇命中=]:0アイテム変更
	[暗闇=]を[暗闇耐性=]:1アイテム変更
	e_ハロウィンパンプキンアーマー2011.txt

	[ホールド成功=]を[ホールド命中=]:0アイテム変更
	[ホールド=]を[ホールド耐性=]:16アイテム変更
	12_苦悩のアミュレット.txt
	e_ハロウィンパンプキンアーマー.txt
	20701_ホールド耐性のTシャツ.txt
	20702_ホールド耐性の特性Tシャツ(DR).txt
	20703_ホールド耐性の特性Tシャツ(自然回復).txt
	20704_ホールド耐性の特性Tシャツ(追加打撃).txt
	60103_腕力のホールド耐性Tシャツ.txt
	60203_機敏のホールド耐性Tシャツ.txt
	60303_知力のホールド耐性Tシャツ.txt
	01_ククルカンシールド.txt
	x10_マナのガーダー.txt
	x10_体力のガーダー.txt
	02_マミーロードクラウン.txt
	10103_リッチリング.txt
	e_ラオンの最高級リング(ホールド).txt
	n_地精霊の指輪.txt

	[凍結成功=]を[凍結命中=]:0アイテム変更
	[凍結=]を[凍結耐性=]:4アイテム変更
	02_マンボコート.txt
	e_月光のグローブ.txt
	e_月光のブーツ.txt
	02_マンボハット.txt

	[石化成功=]を[石化命中=]:0アイテム変更
	[石化=]を[石化耐性=]:0アイテム変更

	[睡眠成功=]を[睡眠命中=]:0アイテム変更
	[睡眠=]を[睡眠耐性=]:1アイテム変更
	10003_アビスリング.txt

	[恐怖成功=]を[恐怖命中=]:0アイテム変更
	[恐怖=]を[恐怖耐性=]:6アイテム変更
	02_光るサイハのアミュレット.txt
	02_賢者のアミュレット.txt
	02_闘士のアミュレット.txt
	x10_守護のガーダー.txt
	10006_ライアリング.txt
	10103_リッチリング.txt

	[破壊成功=]を[破壊命中=]:0アイテム変更
	[破壊=]を[破壊耐性]:0アイテム変更

LSS/src/lss/Calculator.java
	コメント追加/修正
	スキルのインパクトを実装
	武器のチップセットにスタン命中/恐怖命中/破壊命中等を追加しレジェンド武器の強化時に+1増加され表示される様に変更
	パネル1で命中ステータスが武器の命中と防具の命中が合計され表示されるように修正

LSS/src/lss/Common.java
	ELEM_LIST = {"火", "水", "風", "地"};を
	ELEM_LIST = {"火属性", "水属性", "風属性", "地属性"};へ変更

	変更
	AILMENT_LIST = {"石化", "睡眠", "凍結", "暗闇", "気絶", "拘束", "恐怖"};を
	AILMENT_LIST = {"石化耐性", "睡眠耐性", "凍結耐性", "暗闇耐性", "気絶耐性", "拘束耐性", "恐怖耐性","破壊耐性"
		       ,"石化命中", "睡眠命中", "凍結命中", "暗闇命中", "気絶命中", "拘束命中", "恐怖命中","破壊命中"};へ変更
	
	追加
	DESTRUCTION = 7; HIT_STONE = 8; HIT_SLEEP = 9; HIT_FREEZE = 10; HIT_DARKNESS = 11;
	HIT_STUN = 12; HIT_HOLD = 13; HIT_TERROR = 14; HIT_DESTRUCTION = 15;

LSS/src/lss/Buki.java
	真冥王の執行剣
	+1強化毎に[スタン命中]+1増加を実装

	レッドシャドウデュアルブレード
	+1強化毎に[破壊命中]+1増加を実装

	ヒュペリオンの絶望
	+1強化毎に[スタン命中]+1増加を実装

	タイタンの憤怒 
	+1強化毎に[恐怖命中]+1増加を実装

LSS/src/lss/Bougu.java
	防具のツールチップに	
	破壊耐性/スタン命中/暗闇命中/ホールド命中/凍結命中/石化命中/睡眠命中/恐怖命中/破壊命中を追加

LSS/src/lss/Buff.java
	スタン耐性/暗闇耐性/ホールド耐性/凍結耐性/石化耐性/睡眠耐性/恐怖耐性に変更し
	破壊耐性/スタン命中/暗闇命中/ホールド命中/凍結命中/石化命中/睡眠命中/恐怖命中/破壊命中を追加

LSS/src/lss/UI.java
	パネル1に命中を追加

2018/09/28
Update
LSS/src/lss/Calculator.java
	武器のツールチップが反映する様に修正

LSS/src/lss/Buki.java
	レジェンド武器のエンチャントによる追加打撃+2を実装
	真冥王の執行剣
	+1強化毎に[スタン命中]+1増加は未実装

	ウィンドブレードソード
	
	レッドシャドウデュアルブレード
	+1強化毎に[破壊命中]+1増加は未実装

	ホーリーヘドロンスタッフ
	
	クロノスの恐怖  
	
	ヒュペリオンの絶望
	+1強化毎に[スタン命中]+1増加は未実装

	タイタンの憤怒 
	+1強化毎に[恐怖命中]+1増加は未実装

	ガイアの激怒
	+1強化毎に[ダメージ軽減無視]+1増加は未実装

Update
LSS/data/E.zip
	/E/武器/
	新ステータス追加(ダメージリダクション無視=)し修正
	1110017_ガイアの激怒.txt
	
	追加魔法の調整
	1110013_悪夢のロングボウ(悪夢発動).txt
	1120002_英雄のボウ.txt			*1120002_英雄のボウ(嵐発動).txtは削除
	[魔法ダメージ=50]を[魔法ダメージ=55]へ		

	TextSS.net.exeというアプリを用いてテキストファイルのテキスト置換
	[重量]を[重さ]
	[DR]を[ダメージリダクション]

	[重さ]の登録の無い武器を修正
	0510003_デーモンアックス.txt
	0710002_シルバーデュアルブレード.txt
	0710003_ダークネスデュアルブレード.txt
	0710004_テーベオシリスデュアルブレード.txt
	0710005_ブラインドデュアルブレード.txt
	0710006_破壊のデュアルブレード.txt
	0710007_レッドシャドウデュアルブレード.txt
	0710008_ロンドゥデュアルブレード.txt
	0710009_咆哮のデュアルブレード.txt
	0750001_幸運のデュアルブレード.txt
	0810001_イビルクロウ.txt
	0810002_シルバークロウ.txt
	0810002_ビーストキングクロウ.txt
	0810002_ヘイトリッドクロウ.txt
	0810003_ダークネスクロウ.txt
	0810004_ブラインドクロウ.txt
	0810005_ホステリティークロウ.txt
	0810006_マリスエレメントクロウ.txt
	0810007_破壊のクロウ.txt
	0810009_サクリファイスクロウ.txt
	0820001_月光のクロウ.txt
	0910001_ホステリティーチェーンソード.txt
	0910002_ブラットサッカー.txt
	0910003_消滅者のチェーンソード.txt
	0910004_破滅者のチェーンソード.txt
	0910005_マリスエレメントチェーンソード.txt
	0910006_極寒のチェーンソード.txt
	0910007_幻影のチェーンソード.txt
	0910008_殲滅者のチェーンソード.txt
	0910009_サクリファイスチェーンソード.txt
	0920001_月光のチェーンソード.txt
	0920101_パンプキンチェーンソード.txt
	0950001_幸運のチェーンソード.txt
	1010001_ダークストーンキーリンク.txt
	1010002_ホステリティーキーリンク.txt
	1010003_マリスエレメントキーリンク.txt
	1010004_共鳴のキーリンク.txt
	1010005_サクリファイスキーリンク.txt
	1010005_冷寒のキーリンク.txt
	1010006_エルモアキーリンク.txt
	1020001_月光のキーリンク.txt
	1020101_パンプキンキーリンク.txt
	1110006_マリスエレメントボウ.txt

LSS/src/lss/Calculator.java
LSS/src/lss/Buki.java
	コメントの修正と削除
	武器のツールチップに重さが表示されるように変更(変数:weight)
	武器のツールチップに武器強化分の表示されるように変更(0の時は表示しない/10以上の時は+2されていく)
Update
LSS/data/E.zip
	/E/アーマー/
	選択するとアプリケーションが落ちる為、特殊=のコメントをすべて削除

	13_ヴァラカスフレイムスケイルメイル.txt
	13_ヴァラカスフレイムプレートメイル.txt
	13_ヴァラカスフレイムレザーアーマー.txt
	13_ヴァラカスフレイムローブ.txt

2018/09/27
Update
LSS/src/lss/Calculator.java
	レベル90以上のステータスの割振り上限を50個に対応(レベル89までは45個)

Update
LSS/data/E.zip
	/E/アロー/
既存矢をすべて削除し新規矢追加(ただしダミーファイルのa01.txtは残す)
	a12.txt ハンター アロー
	a13.txt ハンター シルバー アロー
	a14.txt 火属性のエレメンタル バトル アロー
	a15.txt 水属性のエレメンタル バトル アロー
	a16.txt 風属性のエレメンタル バトル アロー
	a17.txt 地属性のエレメンタル バトル アロー
	a18.txt 無形の矢
	s04.txt ヘビー スティング
	s05.txt シルバー スティング

矢のステータス修正
	name          arrow_name =
	small         arrow_small =     //削除(コメントアウト)
	big           arrow_big =       //削除(コメントアウト)
	追加ダメージ  arrow_dmg =
	属性ダメージ  arrow_elementdmg =
	遠距離命中    arrow_hit =
	材質          arrow_material =
	*name=に[火属性][水属性][風属性][地属性]が付くとその該当属性が属性ダメージに付属
	
LSS/data/E.zip
	/E/武器/
既存弓の修正(1110006_マリスエレメントボウ.txtは詳細不明の為、除外)
	1110001_エンシェントボーガン.txt
	1110002_エンジェルスレイヤー.txt
	1110003_ダークネスクロスボウ.txt
	1110004_テーベオシリスボウ.txt
	1110005_ホステリティーボウ.txt
	1110006_マリスエレメントボウ.txt
	1110007_ロングボウ.txt
	1110008_サイハの弓.txt
	1110009_ルナロングボウ.txt
	1110010_破壊のロングボウ.txt
	1110011_サクリファイスボウ.txt
	1110012_悪魔王の弓.txt
	1110013_悪夢のロングボウ(悪夢発動).txt
	1110013_悪夢のロングボウ.txt
	1110014_クロスボウ.txt
	1110015_ハンターボウ.txt
	1110016_暗禍津蛇.txt
	1110017_ガイアの激怒.txt
	1120001_月光のロングボウ.txt
	1120002_英雄のボウ(嵐発動).txt
	1120002_英雄のボウ.txt
	1120101_ハロウィンパンプキンロングボウ2011.txt
	1120102_ハロウィンパンプキンロングボウ2012.txt
	1210001_ククルカンガントレット.txt
	1210002_真のガントレット.txt

LSS/src/lss/Buki.java
LSS/src/lss/Calculator.java
弓の命中計算式の変更
	1.矢に遠距離命中(buki.arrow_hit)が追加され計算される
	2.魔法スキルの近距離命中(buff.HIT_SHORT)が遠距離命中に計算されない
	
	旧仕様:hit_long +=                  buki.op.HIT_LONG + buki.enchant / 2 + buff.HIT_LONG + buff.HIT_SHORT;
	新仕様:hit_long += buki.arrow_hit + buki.op.HIT_LONG + buki.enchant / 2 + buff.HIT_LONG;

弓のダメージ計算式の変更	
	矢のダメージ半減処理がなくなった。(処理はコメントアウト)
	矢の属性ブラックミスリルアローがなくなった。(処理はコメントアウト)
	矢の基本値small(buki.arrow_small)/big(buki.arrow_big)が消え計算から除外される
	矢に追加ダメージ(buki.arrow_dmg)が追加され計算される
	矢に属性ダメージ(buki.arrow_elementdmg)が追加され計算される
	*武器の属性で決定されるが無属性の場合の処理が不明の為、属性ごとに矢を追加

	弓の基本値small(buki.small)/big(buki.big)がダメージ計算に含まれる様になった
	近距離武器と違うのは武器に対して使う追加ダメージ魔法(buki.magic_enchant)がないので計算されない
	(ホーリーウェポン/エンチャントウェポン/ブレスウェポン)
	武器の祝福効果が計算されているのか？は不明、現時点では計算してません。
	*デバッグ用に弓/矢関連の数値がコンソールに表示される様に変更

	旧仕様:dmg_big_ave = (1.0 + buki.arrow_big) / 2            + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
	新仕様:dmg_big_ave = (1.0 + buki.big) / 2 + buki.arrow_dmg + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;

	旧仕様:dmg_small_ave = (1.0 + buki.arrow_small) / 2            + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
	新仕様:dmg_small_ave = (1.0 + buki.small) / 2 + buki.arrow_dmg + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;

	旧仕様:dmg_big_max = buki.arrow_big            + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
	新仕様:dmg_big_max = buki.arrow_dmg + buki.big + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;

	旧仕様:dmg_small_max = buki.arrow_small            + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
	新仕様:dmg_small_max = buki.arrow_dmg + buki.small + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;  

2018/09/26
Update
LSS/src/lss/Buki.java
	E.zipの変更に伴い、データを読み込むキーワードの変更
	[スタン成功]を[スタン命中]

LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
	シャイニングオーラをシャイニングシールドへ	
	コメントの修正と削除

LSS/data/E.zip
	/E/武器/
	[スタン成功]を[スタン命中]
	0310004_ナイトバルドのツーハンドソード.txt
	0310005_真冥王の執行剣.txt
	1010007_ヒュペリオンの絶望.txt

2018/09/25
Update
LSS/data/E.zip
	/E/ベルト/
	削除
	02_タイタンベルト(KR).txt

LSS/src/lss/Bougu.java
	血戦のグリーヴの名称変更時にBougu.javaの変更を忘れていた為、修正

Update
LSS/src/lss/Bougu.java
	コメントの修正と削除

LSS/src/lss/Calculator.java
	コメントの修正と削除
	武器のツールチップに材質が表示されるように変更(変数:material)

LSS/src/lss/buff.java
	E.zipの変更に伴い、データを読み込むキーワードの変更
	[弓命中率]を[遠距離命中]
	[弓打撃値]を[遠距離追加ダメージ]
	[攻撃成功]を[近距離命中]
	[追加打撃]を[近距離追加ダメージ]

LSS/data/E.zip
	/E/武器/
	新規
	0520001_英雄のアックス.txt
	修正
	0220002_英雄のソード.txt
	0120001_英雄のダガー.txt
	0320001_英雄のツーハンドソード.txt
	0720001_英雄のデュアルブレード.txt
	0620002_英雄のスタッフ.txt
	0920002_英雄のチェーンソード.txt

	名称変更と修正
	0810008_怒りのクロウ.txt
		0810008_震怒のクロウ.txt

	削除
	0710003_ダークネスデュアルブレード(KR).txt
	0810003_ダークネスクロウ(KR).txt
	0910008_殲滅者のチェーンソード(KR).txt

	TextSS.net.exeというアプリを用いてテキストファイルのテキスト置換
	[弓命中率]を[遠距離命中]
	[弓打撃値]を[遠距離追加ダメージ]
	1110001_エンシェントボーガン.txt
	1110002_エンジェルスレイヤー.txt
	1110003_ダークネスクロスボウ.txt
	1110004_テーベオシリスボウ.txt
	1110005_ホステリティーボウ.txt
	1110006_マリスエレメントボウ.txt
	1110007_ロングボウ.txt
	1110008_サイハの弓.txt
	1110009_ルナロングボウ.txt
	1110010_破壊のロングボウ.txt
	1110011_サクリファイスボウ.txt
	1110012_悪魔王の弓.txt
	1110013_悪夢のロングボウ(悪夢発動).txt
	1110013_悪夢のロングボウ.txt
	1110014_クロスボウ.txt
	1110015_ハンターボウ.txt
	1110016_暗禍津蛇.txt
	1110017_ガイアの激怒.txt
	1120001_月光のロングボウ.txt
	1120002_英雄のボウ(嵐発動).txt
	1120002_英雄のボウ.txt
	1120101_ハロウィンパンプキンロングボウ2011.txt
	1120102_ハロウィンパンプキンロングボウ2012.txt
	1210001_ククルカンガントレット.txt
	1210002_真のガントレット.txt

	[攻撃成功]を[近距離命中]
	[追加打撃]を[近距離追加ダメージ]
	0110002_オリハルコンダガー.txt
	0110003_クリスタルショートソード.txt
	0110004_マナバゼラート.txt
	0110005_ウィンドブレードソード.txt
	0110006_生命のダガー.txt
	0120001_英雄のダガー.txt
	0150001_幸運のダガー.txt
	0210001_エンシェントソード.txt
	0210003_ジェネラルソード.txt
	0210004_ホステリティーソード.txt
	0210006_メイルブレーカー.txt
	0210007_ライトニングエッジ.txt
	0210009_古代のダークエルフソード.txt
	0210010_デスナイトフレイムブレード.txt
	0210011_カーツソード.txt
	0210012_サクリファイスソード.txt
	0210013_ポルセの剣.txt
	0210014_真レイピア .txt
	0220001_月光のロングソード.txt
	0220002_英雄のソード.txt
	0220101_ハロウィンパンプキンロングソード.txt
	0220102_ハロウィンパンプキンロングソード2012.txt
	0310001_ジェネラルグレートソード.txt
	0310002_テーベオシリスツーハンドソード.txt
	0310003_ディストラクション.txt
	0310004_ナイトバルドのツーハンドソード.txt
	0310005_真冥王の執行剣.txt
	0310006_幸運のグレートソード.txt
	0310007_レッドナイトグレートソード.txt
	0310008_ギルタスのソード.txt
	0310009_ドラゴンスレイヤー.txt
	0310010_アリス.txt
	0320001_英雄のツーハンドソード.txt
	0320101_ハロウィンパンプキンツーハンドソード2011.txt
	0320102_ハロウィンパンプキンツーハンドソード2012.txt
	0410002_クリムゾンランス.txt
	0410003_ククルカンスピアー.txt
	0410004_フリージングランサー.txt
	0410005_シバインのスピアー.txt
	0410006_海神のトライデント.txt
	0410007_幸運のスピアー.txt
	0410008_古代神のスピアー.txt
	0410009_幸運のランス.txt
	0510002_レイジングウィンド.txt
	0510003_デーモンアックス.txt
	0510004_アイアンアックス.txt
	0510004_ゲイルアックス.txt
	0510004_テンペストアックス.txt
	0510004_ラフィアンアックス.txt
	0510004_鍛冶屋のアックス.txt
	0510004_魔物のアックス.txt
	0510005_サクリファイスアックス.txt
	0510006_古代神のアックス.txt
	0510007_タイタンの憤怒.txt
	0610002_テーベオシリススタッフ.txt
	0610004_ホステリティースタッフ.txt
	0610005_マナスタッフ.txt
	0610008_アイスクイーンスタッフ.txt
	0610010_バフォメットスタッフ.txt
	0610011_ホーリーヘドロンスタッフ.txt
	0610012_陰陽緋毛扇.txt
	0610013_ゼロスの杖.txt
	0610015_サクリファイススタッフ.txt
	0610016_アイアンマナスタッフ.txt
	0620002_英雄のスタッフ.txt
	0650001_幸運のマナスタッフ.txt
	0710001_イビルデュアルブレード.txt
	0710002_シルバーデュアルブレード.txt
	0710003_ダークネスデュアルブレード.txt
	0710004_テーベオシリスデュアルブレード.txt
	0710005_ブラインドデュアルブレード.txt
	0710006_破壊のデュアルブレード.txt
	0710007_レッドシャドウデュアルブレード.txt
	0710008_ロンドゥデュアルブレード.txt
	0710009_咆哮のデュアルブレード.txt
	0720001_英雄のデュアルブレード.txt
	0750001_幸運のデュアルブレード.txt
	0810001_イビルクロウ.txt
	0810002_シルバークロウ.txt
	0810002_ヘイトリッドクロウ.txt
	0810003_ダークネスクロウ.txt
	0810004_ブラインドクロウ.txt
	0810005_ホステリティークロウ.txt
	0810007_破壊のクロウ.txt
	0810008_震怒のクロウ.txt
	0810009_サクリファイスクロウ.txt
	0820001_月光のクロウ.txt
	0910001_ホステリティーチェーンソード.txt
	0910002_ブラットサッカー.txt
	0910003_消滅者のチェーンソード.txt
	0910004_破滅者のチェーンソード.txt
	0910005_マリスエレメントチェーンソード.txt
	0910006_極寒のチェーンソード.txt
	0910007_幻影のチェーンソード.txt
	0910008_殲滅者のチェーンソード.txt
	0910009_サクリファイスチェーンソード.txt
	0910010_クロノスの恐怖.txt
	0920001_月光のチェーンソード.txt
	0920002_英雄のチェーンソード.txt
	0920101_パンプキンチェーンソード.txt
	0950001_幸運のチェーンソード.txt
	1010002_ホステリティーキーリンク.txt
	1020001_月光のキーリンク.txt

Update
装備名称変更
	e_血戦のグリーブ.txt
		e_血戦のグリーヴ.txt
	name=血戦のグリーブ
		name=血戦のグリーヴ

LSS/src/lss/UI.java
LSS/src/lss/Calculator.java
	全角文字を半角文字へ訂正

2018/09/24
Update
LSS/src/lss/UI.java
	オルターストーンの表示順の修正
	1.なし               1.なし
	2.近距離命中+2       2.近距離ダメージ+1
	3.遠距離命中+2       3.遠距離ダメージ+1
	4.魔法致命打         4.近距離命中+2
	5.遠距離ダメージ+1   5.遠距離命中+2
	6.SP+1               6.SP+1
	7.魔法消耗減少       7.魔法致命打
	8.一撃必殺           8.魔法消耗減少
	9.近距離ダメージ+1   9.一撃必殺

LSS/src/lss/Calculator.java
	オルターストーンの表示順の修正による処理の修正
	
	一撃必殺(1%確率で追加ダメージ50)の別処理に注意
	行2649で近距離命中が+2されると遠距離命中も加算されるのでそれを修正
	
	補足資料:https://recordgame.blogspot.com/2015/07/blog-post_13.html
	(遠距離命中にSTR値は無関係に変更)

	自動処理置換
	Switchによるifの連鎖の置換1
	Switchによるifの連鎖の置換2
	*レベルによる自動攻撃速度とHero変身速度の変更

Update
LSS/data/E.zip
	/E/エンブレム/
		/E/インシグニア/へフォルダ名を変更
	00000_dummy.txtの[name=エンブレム]を[name=インシグニア]へ変更
	インシグニアフォルダ内ファイルの[type=エンブレム]を[type=インシグニア]へ変更

	/E/ドロン/
		/E/スポールダー/へフォルダ名を変更
	00_dummy.txtの[name=ドロン]を[name=スポールダー]へ変更
	スポールダーフォルダ内ファイル[type=ドロン]を[type=スポールダー]へ変更

	/E/ルーン/
		/E/紋章/へフォルダ名を変更
	00_dummy.txtファイルの[name=ルーン]を[name=紋章]へ変更
	紋章フォルダ内ファイル[type=ルーン]を[type=紋章]へ変更
	重要:この変更を行うことにより[E.zip]とVer2.4.8との互換性がなくなる。

LSS/src/lss/Common.java
	読み込む順序の部分の
	"エンブレム","ドロン","ルーン"を
	"インシグニア", "スポールダー","紋章"へ変更

LSS/src/lss/Bougu.java
	防具を選択すると効果をつける部分の
	"ルーン"を"紋章"
	"エンブレム"を"インシグニア"と変更

LSS/src/lss/UI.java
	コメント変更
	リスト19個から21個へ拡張(ドロン、エンブレム分)2個追加
	>>>リスト19個から21個へ拡張(スポールダー、インシグニア分)2個追加

	パネル1の文様(5か所)の位置を一段下げる(サイズ:20)

Update
LSS/src/lss/Bougu.java
	特性の意地のPVPダメージ軽減の修正

LSS/src/lss/UI.java
LSS/src/lss/Calculator.java
	コメントの追加

	グレースアバター修正
	発動条件がPT内の君主レベルに影響するスキルだったので修正

	ブローアタック実装
	一定確率で近接ダメージを1.5倍 LV75からLV1毎に発動率1%増加

	プライド実装
	最大HP LV/4% 増加(LV*0.25%)
	
	ギガンテック修正
	最大HP (LV*0.5%) 増加 最大MP (LV*0.5%) 増加
	を最大HP LV/2%(LV*0.5%:意味は同一) 増加に変更、MPの増加は無し
	*アドバンスドスピッツ/プライド/ギガンテックのボタン優先順位を修正

	覚醒[リンドビオル]実装
	DG+7

	フォーカススピリッツ実装
	魔法クリティカル+5%

	インパクト未実装
	スタン命中+5 破壊命中+5 恐怖命中+5 LV80からレベル1毎に命中+1増加[最大+10]

	生命のボーナス実装
	鉄甲のボーナス実装
	生存のボーナス実装
	暗殺のボーナス実装
	ランカーボーナス実装

	インパクトの条件が合わない場合にチェックができない様に修正
	インフェルノの条件が合わない場合にチェックができない様に修正

2018/09/23
Update
LSS/src/lss/Calculator.java
	グレースアバター実装
	スタン耐性+10 ホールド耐性+10 恐怖耐性+10 LV80からLV1毎に耐性+1増加[最大+15]

LSS/src/lss/Common.java
LSS/src/lss/UI.java
	新規スキルの追加で表示範囲を広げる。サイズ(800, 600)を(800, 640)へ

	パネル3のエンチャントに新規スキルを追加、実装は未定
    	P_GA = 87;        //グレースアバター(未実装)消費MP15 技術耐性+5 精霊耐性+5 竜語耐性+5 恐怖耐性+5
    	K_PD = 88;        //プライド(未実装)
    	K_BK = 89;        //ブローアタック(未実装)
    	R_LINDVIOL = 90;  //覚醒[リンドビオル](未実装)
    	I_FS = 91;        //フォーカススピッツ(未実装)
    	I_IT = 92;        //インパクト(未実装)
    	H_HP = 93;        //生命のボーナス
    	H_AC = 94;        //鉄甲のボーナス
    	H_PVPDR = 95;     //生存のボーナス
    	H_PVP = 96;       //暗殺のボーナス
    	H_RK = 97;        //ランカーボーナス

	JCheckBox[] cb_buff = new JCheckBox[98];
	JComboBox[] cb_buff_group = new JComboBox[98]; 	
	*87個から98個へ変更

Update
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
	Hero変身の選択メニューを[LV99]から[Hero]へ

LSS/src/lss/Calculator.java
	エルフ魔法イーグルアイの遠距離クリティカルを100%から2%追加へ変更

Update
LSS/src/lss/UI.java
	パネル3での未実装スキル(インフェルノ/サイクロン)に未実装と表記

LSS/src/lss/Calculator.java
LSS/src/lss/Common.java
LSS/src/lss/UI.java
	コメントの整理
	パネル1でのSP(スペルパワー) MB(マジックボーナス) ML(マジックレベル) β(装備分SP)の表示
　	*SP=MB+ML+β
	SP>>>>spr
	MB>>>>mb
	ML>>>>ml
	β>>>>sp

LSS/src/lss/LEV.java
	LV94対応の拡張案のコメントを表記

LSS/data/E.zip
	/E/ドロン/
	00_dummy.txt
	type=ドロン
	name=ドロン
		name=ドロン	
		type=ドロン
	順を入れ替えた

LSS/src/lss/Calculator.java
	ルームティスのブラックイアリングを選択するとコンソールに数値が表示される
	Bougu.javaの追加ダメージ +20 X%に反応している。
	出力している行をコメントアウト

2018/09/22
Update
LSS/src/lss/Bougu.java
LSS/data/E.zip
	/E/グローブ/
	激昂のグローブ
	+7[近距離命中+4] +8[近距離命中+5] +9[近距離命中+6]

	守護騎士のパワーグローブ
		+5から[近距離命中]+1増加(最大+5)

	守護騎士のブレイサー
		+5から[遠距離命中]+1増加(最大+5)
	Bougu.javaの判定式も修正

Update
LSS/src/lss/Calculator.java
	武器ツールチップの表示名MR追加

LSS/src/lss/UI.java
	新規マジックドールの追加
	2017/12/20 Update
	http://event2.ncsoft.jp/1.0/lineage/1712dragondoll/
	アンタラス	追加防御力+7 最大HP+120 MP絶対回復+15(64秒) ダメージ低下+7
	パプリオン	追加防御力+1 MP絶対回復+10(64秒) ダメージ低下+1 SP+7 魔法命中+7
	リンドビオル	追加防御力+2 MP絶対回復+5 (64秒) ダメージ低下+2 遠距離ダメージ+7 遠距離命中+7
	ヴァラカス	追加防御力+3 ダメージ低下+3 近接ダメージ+7 近距離命中+7

Update
LSS/README.md
	README.mdの削除(配置箇所の指定ミス)

Update
LSS/src/lss/Common.java
	パネル1のルーン、ドロン、エンブレムの順をエンブレム、ドロン、ルーンに変更

Update
LSS/src/lss/UI.java
	祈りの紋様III、祈りの紋様IV、祈りの紋様Vを追加

LSS/src/lss/Bougu.java
LSS/data/E.zip
	/E/エンブレム/
ファイルの修正と名称の修正、Bougu.javaの判定名称も修正
	01_カーツの闘士のインシグニア.txt
		01_闘士のインシグニア.txt
	02_カーツの射手のインシグニア.txt	
		02_射手のインシグニア.txt
	03_カーツの賢者のインシグニア.txt
		03_賢者のインシグニア.txt
	04_カーツの守護のインシグニア.txt
		04_守護のインシグニア.txt
LSS/data/E.zip
	/E/イアリング/
	e_星の知識イアリング.txt
		e_星の知力イアリング.txt

LSS/data/E.zip
	/E/ベルト/
	02_オーガキングベルト.txt
	AC=0をAC=-2

	02_エンシェントジャイアントリング(KR).txtを削除
	02_タイタンベルト(KR).txtを削除

LSS/data/E.zip
	/E/グローブ/
	02_憤怒のグローブ(KR).txtを削除

2018/09/21
Update
LSS/data/E.zip
	/E/エンブレム/
ファイルの修正と名称の修正
	01_闘士のインシグニア.txt
		01_カーツの闘士のインシグニア.txt
	02_射手のインシグニア.txt	
		02_カーツの射手のインシグニア.txt
	03_賢者のインシグニア.txt
		03_カーツの賢者のインシグニア.txt
	04_守護のインシグニア.txt
		04_カーツの守護のインシグニア.txt

LSS/src/lss/Bougu.java
	カーツの闘士のインシグニアの効果が未実装の為、修正
	2017/08/16 Update
	http://event2.ncsoft.jp/1.0/lineage/1708insigniaofKurtz/

Update
LSS/src/lss/Bougu.java
	成長の紋章の効果が未実装の為、修正
	2017/10/11 Update
	http://event2.ncsoft.jp/1.0/lineage/1801fivecrests/

LSS/data/E.zip
	/E/ルーン/
LSS/src/lss/Bougu.java
ファイルの修正と名称の修正、Bougu.javaの判定名称も修正
	e_守護賢者の紋章.txt	
		e_賢者の守護紋章.txt
	e_守護闘士の紋章.txt
		e_闘士の守護紋章.txt
	e_守護名弓の紋章.txt
		e_射手の守護紋章.txt
	e_名弓の紋章.txt
		e_射手の紋章.txt
	2018/06/13 Update
	http://event2.ncsoft.jp/1.0/lineage/1806newCrestsSeries/

Update
LSS/data/E.zip
	/E/ルーン/	
修正	安全=0を安全=4にして選択した時に+5が表示される様に変更
	守護闘士の紋章
	守護名弓の紋章
	守護賢者の紋章

Update
LSS/src/lss/Bougu.java
	スナッパーの勇士リング
	祝福されたスナッパーの勇士リング

	スナッパーの知恵リング
	祝福されたスナッパーの知恵リング

	スナッパーの魔法抵抗リング
	祝福されたスナッパーの魔法抵抗リング

	スナッパーの体力リング
	祝福されたスナッパーの体力リング
	*確率ダメージ低下については未実装

	スナッパーのマナリング
	祝福されたスナッパーのマナリング

	スナッパーの回復リング
	祝福されたスナッパーの回復リング

	スナッパーの集中リング 
	祝福されたスナッパーの集中リング

	2017/10/11 Update
	ルームティスのレッド/パープルイアリング及びスナッパーの体力/魔法抵抗/知恵リング　アップグレード
	http://www.ncsoft.jp/lineage/news/notice/view?bbsNo=3101&articleNo=1936
	それ以外
	http://event2.ncsoft.jp/1.0/lineage/1610ring/
	http://event2.ncsoft.jp/1.0/lineage/1801enchant/
	https://www34.atwiki.jp/line1library/pages/259.html

修正
	ルームティスパープル イアリング[+7][+8]と祝福されたルームティスパープル イアリング[+6][+7][+8]の違いを修正
	魔法命中+1/魔法命中+2	魔法命中+1/魔法命中+3/魔法命中+5

2018/09/20
Update
LSS/src/lss/Bougu.java
	ルームティスレッド イアリング[+7][+8]
	祝福されたルームティスレッド イアリング[+6][+7][+8]
	近距離命中/遠距離命中/AC追加

	ルームティスパープル イアリング[+7][+8]
	祝福されたルームティスパープル イアリング[+6][+7][+8]
	AC追加/魔法命中追加

	ルームティス ブルー イアリング[+0][+1][+2][+3][+4][+5][+6]][+7][+8]
	祝福されたルームティス ブルー イアリング[+3][+4][+5][+6]][+7][+8]
	回復悪化防御 +X% (恐怖)を追加

	ルームティス ブラック イアリング 
	祝福されたルームティス ブラック イアリング 
	訂正箇所無し

LSS/src/lss/Bougu.java
LSS/src/lss/Buff.java
	PVPダメージ軽減追加

Update
LSS/src/lss/Common.java
LSS/src/lss/Morph.java
LSS/src/lss/UI.java
	Hero変身用にLV99で変身リスト(速度設定1.1倍[切り捨て])を追加しLV99のドロップリストを追加
	(ドロップリストをHeroとするとエラーを起こすので暫定でLV99にしています。)

LSS/src/lss/Bougu.java
	防具のツールチップの表示の変更
	[火の属性][水の属性][風の属性][地の属性][魔法防御][所持重量]を
	[火属性MR][水属性MR][風属性MR][地属性MR][MR][所持重量増加]に変更
	[恐怖耐性][PVPダメージ減少]追加

Update
LSS/data/E.zip
	/E/ブーツ/
新規追加
	02_古代の魔物のブーツ.txt
	02_古代岩石のブーツ.txt

LSS/data/E.zip
	/E/クローク/
新規追加
	02_古代の魔物のマント.txt
	02_古代岩石のマント.txt

LSS/data/E.zip
	/E/グローブ/
修正
	01_古代の魔物のグローブ.txt
	AC=0をAC=-4へ変更
	01_古代岩石のグローブ.txt
	AC=0をAC=-4へ変更

LSS/data/E.zip
	/E/ゲートル/
修正
	01_古代の魔物のゲートル.txt
	PVP追加ダメージ=2を追加
	01_古代岩石のゲートル.txt
	PVPダメージ減少=2を追加

LSS/data/E.zip
	/E/イアリング/
グレード=上級を削除
	01_象牙の塔のイアリング.txt
	02_警備隊長のイアリング.txt
	23_友好のイアリング.txt
	24_極知のイアリング.txt
	25_暴走のイアリング.txt
	26_従魔のイアリング.txt
	27_血族のイアリング.txt
	28_奴隷のイアリング.txt
	39_アイスクイーンのイアリング8(STR).txt
	40_アイスクイーンのイアリング8(DEX).txt
	41_アイスクイーンのイアリング8(WIS).txt
	n_火精霊のイヤリング.txt
	n_最果てのイアリング.txt
	p_シャイニングイアリング.txt
	p_王家のイアリング.txt

グレード=中級を削除
	22_双子のイアリング.txt
	35_アイスクイーンのイアリング4.txt
	36_アイスクイーンのイアリング5.txt
	37_アイスクイーンのイアリング6.txt
	38_アイスクイーンのイアリング7.txt
	p_ヘリオチャーム.txt
	p_親睦のイアリング(ACHP).txt

グレード=下級を削除
	02_浄化のイアリング.txt
	02_赤いオークのイアリング.txt
	21_踊躍のイアリング.txt
	31_アイスクイーンのイアリング0.txt
	32_アイスクイーンのイアリング1.txt
	33_アイスクイーンのイアリング2.txt
	34_アイスクイーンのイアリング3.txt

強化限界=9を強化限界=8
	e_ルームティスパープルイアリング.txt
	e_ルームティスブラックイアリング.txt
	e_ルームティスブルーイアリング.txt
	e_ルームティスレッドイアリング.txt
	e_祝福されたルームティスパープルイアリング.txt
	e_祝福されたルームティスブラックイアリング.txt
	e_祝福されたルームティスブルーイアリング.txt
	e_祝福されたルームティスレッドイアリング.txt

LSS/data/E.zip
	/E/アミュレット/
グレード=上級を削除
	01_シャイニングソウルベルト.txt
	01_シャイニングボディベルト.txt
	01_シャイニングマインドベルト.txt
	01_修練者のベルト.txt
	02_エンシェントジャイアントリング(KR).txt
	02_エンシェントジャイアントリング.txt
	n_火精霊のベルト.txt
	n_水精霊のベルト.txt
	n_地精霊のベルト.txt
	n_風精霊のベルト.txt
	p_修験の力帯.txt
	p_修練の力帯.txt

グレード=中級を削除
	p_新生のベルト(地).txt
	p_新生のベルト(風).txt

グレード=下級を削除
	00_dummy.txt

Update
LSS/data/E.zip
	/E/アミュレット/
グレード=上級を削除
	n_最果てのアミュレット.txt
	01_修練者のアミュレット.txt
	02_アイリスのアミュレット.txt
	02_輝く古代のアミュレット.txt
	02_魔霊軍王のアミュレット.txt
	12_苦痛のアミュレット.txt
	12_苦悩のアミュレット.txt
	22_約束のアミュレット.txt
	23_解放のアミュレット.txt
	24_猟犬のアミュレット.txt
	25_魔族のアミュレット.txt
	26_勇士のアミュレット.txt
	27_将軍のアミュレット.txt
	30_ブラックムーンネックレス.txt
	30_ホワイトムーンネックレス.txt
	30_レッドムーンネックレス.txt
	g_幸運の弓士のアミュレット.txt
	g_幸運の術士のアミュレット.txt
	g_幸運の戦士のアミュレット.txt
	p_王家の強きアミュレット.txt
	p_王家の賢きアミュレット.txt
	p_王家の猛きアミュレット.txt

グレード=中級を削除
	01_ボーンアミュレット.txt
	02_ゼブレクイの牙.txt
	02_ゼブレクイの魔眼.txt
	02_ブラックウィザードアミュレット.txt
	10_機敏のアミュレット.txt
	10_精神のアミュレット.txt
	10_体力のアミュレット.txt
	10_知力のアミュレット.txt
	10_魅力のアミュレット.txt
	10_腕力のアミュレット.txt
	21_奴隷のアミュレット.txt
	e_ゼラチンの精神のアミュレット.txt
	e_ゼラチンの体力のアミュレット.txt
	p_ゼラチンキューブのアミュレット(剣士).txt
	p_ゼラチンキューブのアミュレット(術士).txt

グレード=下級を削除
	00_dummy.txt
	11_青呪のアミュレット.txt
	11_赤呪のアミュレット.txt
	11_緑呪のアミュレット.txt
	p_新生のアミュレット(剣士).txt

強化限界=0を強化限界=9
	02_ドッペルゲンガーアミュレット.txt

削除
	e_不思議なマナリング.txt
	e_不思議な回復リング.txt
	e_不思議な集中リング.txt
	e_不思議な体力リング.txt
	e_不思議な魔法抵抗リング.txt
	2015/12/24 Update
	不思議な回復/集中/マナ/体力/魔法抵抗リングがスナッパーの回復/集中/マナ/体力/魔法抵抗リングに変更になる。

LSS/src/lss/Bougu.java
	リング強化オプション[特級]の強化項目確認と対象リングをコメントに追加
	//各種[10周年記念リング]>>>強化5まで

Update
LSS/src/lss/Common.java
	パネル1のルーン、ルーン、ドロン、エンブレムの順の2番目のルーンを削除

LSS/src/lss/Bougu.java
強化9の時のオプションの修正
	アミュレット/イアリング強化オプション[根性]
	リング強化オプション[情熱]
	ベルト強化オプション[意地]
	*//PVPダメージ軽減についてはまだ未実装

LSS/data/E.zip
	/E/リング/
グレード=下級を削除
	00000_dummy.txt
	10104_グリムリーパーリング.txt
	10005_マジックレジストリング.txt
	10007_機敏のリング.txt
	10007_知識のリング.txt
	10007_腕力のリング.txt
	10008_テレポートコントロールリング.txt
	10009_変身コントロールリング.txt
	10010_サモンコントロールリング.txt

グレード=上級を削除
	10002_修練者のリング.txt
	10006_ライアリング.txt
	10101_気迫のリング.txt
	10102_魔王のリング.txt
	e_ラオンの最高級リング(スタン).txt
	e_ラオンの最高級リング(ホールド).txt
	n_地精霊の指輪.txt
	n_風精霊の指輪.txt

グレード=中級を削除
	10004_マジックプロテクションリング.txt
	10201_アースリング.txt
	10202_ウィンドリング.txt
	10203_ウォーターリング.txt
	10204_ファイアーリング.txt
	p_ラビットリング.txt
	p_新生のリング.txt
	p_竜牙のリング(AC).txt
	p_竜牙のリング(AC・火).txt
	p_竜牙のリング(AC・水).txt
	p_竜牙のリング(AC・地).txt
	p_竜牙のリング(AC・風).txt

グレード=特級を削除
	e_イエロークリスタルリング.txt

強化限界=9から強化限界=8
	e_スナッパーのマナリング.txt
	e_スナッパーの回復リング.txt
	e_スナッパーの集中リング.txt
	e_スナッパーの体力リング.txt
	e_スナッパーの知恵リング.txt
	e_スナッパーの魔法抵抗リング.txt
	e_スナッパーの勇士リング.txt
	e_祝福されたスナッパーのマナリング.txt
	e_祝福されたスナッパーの回復リング.txt
	e_祝福されたスナッパーの集中リング.txt
	e_祝福されたスナッパーの体力リング.txt
	e_祝福されたスナッパーの知恵リング.txt
	e_祝福されたスナッパーの魔法抵抗リング.txt
	e_祝福されたスナッパーの勇士リング.txt

削除
	10006_ライアリング(KR).txt

ツールチップ表示変更
	"ダメージ低下"を" DR"へ変更

LSS/data/E.zip
	/E/エンブレム/
ファイル名の変更とname=の変更
01_カーツの闘士記章.txt
02_カーツの名弓記章.txt
03_カーツの賢者記章.txt
04_カーツの守護記章.txt
	01_闘士のインシグニア.txt
	02_射手のインシグニア.txt
	03_賢者のインシグニア.txt
	04_守護のインシグニア.txt

2018/09/19
Update
LSS/src/lss/Calculator.java
	コメント修正
	二段加速(BP イビルブラッド ブラッドラスト 名誉のコイン 
	ダンシングブレイズ フォーカスウェーブ ハリケーン サンドストーム)を追加

LSS/src/lss/Common.java
	パネル1のルーン、ドロン、エンブレムの順を変更

LSS/src/lss/UI.java
	ソースコードの不明なとこにコメント追加
	パネルリスト19個から21個へ有効化 (ドロン、エンブレム)2個追加

Update
LSS/src/lss/Bougu.java
	闘士の紋章
	名弓の紋章
	賢者の紋章
	守護闘士の紋章
	守護名弓の紋章
	守護賢者の紋章の実装

Update
LSS/src/lss/Bougu.java
	守護の紋章の実装

LSS/data/E.zip
	/E/ドロン/
	00_dummy.txt
	type=ドロンをname=ドロンへ
	2018/09/05の修正ミスを修正(LSSでルーンのドロップリストが動作不良を起こし無反応状態だった)

	/E/ルーン/
	強化限界=10を強化限界=8へ、各種オプション修正
	e_守護の紋章.txt
	e_闘士の紋章.txt
	e_名弓の紋章.txt
	e_賢者の紋章.txt
	e_守護闘士の紋章.txt
	e_守護名弓の紋章.txt
	e_守護闘士の紋章.txt

2018/09/18
Bug fix
	日本語フォントのフォルダーをGitHub DesktopでCommitしたら日本語フォントのフォルダーすべて文字化け
	更に文字化けした複数のファイルが作成された為、Eフォルダーごと削除
Update
LSS/E/ルーン
	L1SS-masterの初期E.zipを展開した物にルーンの新規分を追加

2018/09/17
Update
LSS/data/E.zip
新規装備
	ディヴァインエルヴンシールド
	マミーロードのグローブ
	守護騎士のパワーグローブ
	守護騎士のブレイサー
	古代岩石のグローブ
	古代の魔物のグローブ

修正
	ヴァラカスフレイムプレートメイル
	近距離クリティカル=3を追加
	特殊=ダメージ軽減無視+3 +7から[ダメージ軽減無視+1](最大+6)[近距離クリティカル1%]増加(最大5%)に変更

	ヴァラカスフレイムスケイルメイル
	近距離クリティカル=2を追加
	特殊=ダメージ軽減無視+3 +7から[ダメージ軽減無視+1](最大+6)[近距離クリティカル1%]増加(最大5%)に変更

	ヴァラカスフレイムレザーアーマー
	遠距離クリティカル=2を追加
	特殊=ダメージ軽減無視+3 +7から[ダメージ軽減無視+1](最大+6)[遠距離クリティカル1%]増加(最大5%)に変更

	ヴァラカスフレイムローブ
	魔法クリティカル=2を追加
	特殊=ダメージ軽減無視+3 +7から[ダメージ軽減無視+1](最大+6)[魔法クリティカル1%]増加(最大5%)に変更
	*特殊=はツールチップだけに反映、実際には未実装

	闘士のアミュレット
	材質=骨から材質=ジュエリー、重量=5から重量=20、恐怖=5を追加、グレード=中級の削除

	光るサイハのアミュレット
	賢者のアミュレット
	材質=骨から材質=ジュエリー、恐怖=5を追加、グレード=中級の削除

	神聖な機敏のリング
	神聖な知識のリング
	神聖な腕力のリング
	wis=1からwis=0、グレード=下級の削除

	神聖な気迫のリング
	神聖な魔王のリング
	グレード=下級の削除

	パンプキンベルト
	name=修正、特性=意地を追加
	強化限界=0から強化限界=9
	
	ラプチャーベルト
	強化限界=15から強化限界=0
	グレード=上級の削除

ファイル名修正(無駄な半角スペースの削除)
	02_ 神聖な知力のアミュレット.txt
	02_ 神聖な腕力のアミュレット.txt
	02_ 神聖な機敏のアミュレット.txt
		02_神聖な機敏のアミュレット.txt
		02_神聖な知力のアミュレット.txt
		02_神聖な腕力のアミュレット.txt

Update
LSS/src/lss/E
L1SS-masterの初期E.zipを展開

Update
README.mdを初期実装

2018/09/16
Update
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
パネル3
1段加速のツールチップの修正
(x1.3333:GP GGP ワイン ウイスキー)

2段加速のツールチップの修正
(x1.3333:BP イビルブラッド ブラッドラスト 名誉のコイン
 ダンシングブレイズ フォーカスウェーブ ハリケーン サンドストーム
 x1.1547:EW 濃縮集中ポーション)

3段加速のツールチップの修正
(x1.1250:ドラゴンブラッド 蔵出し秘蔵酒)

ACの項目修正
シールド           AC-2  消費MP8  魔法レベル1 継続時間1800秒
ファイアーシールド AC-4  消費MP15 魔法レベル3 継続時間 960秒 新規
四季のポーション   AC-5
アーススキン       AC-6  消費MP15 魔法レベル3 継続時間 960秒 削除 
アースブレス       AC-7  消費MP40 魔法レベル4 継続時間 960秒 削除 
アイアンスキン     AC-10 消費MP30 魔法レベル5 継続時間 960秒
     (2014/08/26Updateでアースブレス→アースガーディアンに変更済)

ACのツールチップの修正
シールド           AC-2
ファイアーシールド AC-4
四季のポーション   AC-5
アイアンスキン     AC-10

Update
LSS/src/lss/Calculator.java
新魔法の効果を実装
E_EW=18	アースウェポン     地属性近距離ダメージ+2　近距離命中+4
	消費MP15 魔法レベル3 継続時間960秒
E_AS=10	アクアショット     遠距離命中+4
	消費MP15 魔法レベル3 継続時間960秒
E_QE=81	クエイク           一定の確率で近距離ダメージ1.5倍
	消費MP20 魔法レベル3 継続時間320秒
	エレメンタルファイアー同じ確率40%で設定
E_EE=84	イーグルアイ       遠距離クリティカル+2%
	消費MP20 魔法レベル3 継続時間128秒	
E_CE=85	サイクロン         一定の確率で遠距離ダメージ1.5倍
	消費MP30 魔法レベル5 継続時間480秒
	エレメンタルファイアー同じ確率40%で設定
E_IO=86	インフェルノ       一定確率で近距離ダメージを50%軽減しカウンター攻撃
	消費MP40 LV80スキル  継続時間64秒
カウンターダメージは武器の[小さい打撃値+近距離ダメージ+強化数]×[1~4]
インフェルノは未実装
属性ダメージbuff.ELEM_DMG_SHORT[FIRE]以外のbuff.ELEM_DMG_SHORT[WATER][WIND][EARTH]も追加

LSS/src/lss/UI.java
エルフ魔法のツールチップ修正
E_EW=18 アースウェポン   近距離ダメージ+2 近距離命中+4を
                         地属性近距離ダメージ+2　近距離命中+4に修正
E_SE=13 ストームアイ     風属性追加打撃+3 遠距離命中+2を
                         風属性遠距離ダメージ+3　遠距離命中+2に修正
E_SS=14 ストームショット 風属性追加打撃+6 遠距離命中+3を
                         風属性遠距離ダメージ+6　遠距離命中+3に修正

Update
LSS/src/lss/Calculator.java
LSS/src/lss/Common.java
LSS/src/lss/UI.java
2018/09/05Updateでエルフ魔法のリニューアルに合わせてパネル3の再構築
エルフ魔法削除
E_FW=18	ファイアーウェポン 火属性追加打撃+4
E_WS=10	ウィンドショット   遠距離命中+6
E_WW=81	ウィンドウォーク   移動速度上昇

エルフ魔法追加
E_EW=18	アースウェポン     近距離ダメージ+2　近距離命中+4
E_AS=10	アクアショット     遠距離命中+4
E_QE=81	クエイク           一定の確率で近距離ダメージ1.5倍
E_EE=84	イーグルアイ       遠距離クリティカル+2%	
E_CE=85	サイクロン         一定の確率で遠距離ダメージ1.5倍	
E_IO=86	インフェルノ       一定確率で近距離ダメージを50%軽減しカウンター攻撃
IDは0から86の合計87個分

Update
LSS/src/lss/Common.java
パネル1のアミュレットとイアリングの入力位置の入替
LSS/data/E.zip
削除
	02_フォノスファイターアミュレット.txt
変更
	02_闘士のアミュレット.txt
	name=フォノスファイターアミュレットを闘士のアミュレットへ変更

Update
LSS/data/E.zip
武器の新規追加	
	真レイピア

Update
LSS/src/lss/Calculator.java
武器ツールチップの表示名、順序の修正
打撃値   >>> ダメージ
追加打撃 >>> 近距離ダメージ
攻撃成功 >>> 近距離命中
攻撃成功 >>> 遠距離ダメージ
攻撃成功 >>> 遠距離命中
魔法命中 >>> 魔法命中
近距離クリティカル >>> 近距離クリティカル
遠距離クリティカル >>> 遠距離クリティカル
魔法クリティカル   >>> 魔法クリティカル
スタン成功 >>> スタン命中
魔力     >>> SP

Update
LSS/src/lss/Calculator.java
LSS/src/lss/UI.java
オルターストーン6段階追加
DKセット装備時に追加ボーナスが3倍になる不具合
80変身時と近/遠特化変身時にボーナスが累積
DKセット装備時のボーナスよりその所在をコメントアウト
DKセット装備時に80変身には自動的にはならない
参考:2017/05/11 hasu0703/L1SSでy_ikedaさんのコミット

LSS/src/lss/Morph.java
UIのパネル1の変身レベル(LV85をLV84)の問題の修正
(LV84では速度が変更にならず、LV85で変更された問題)

2018/09/15
Update
LSS/src/lss/Calculator.java
LSS/src/lss/Common.java
LSS/src/lss/UI.java
成長の果実の実装(2018/08/15 Update対応)
参考:2017/05/11 hasu0703/L1SSでy_ikedaさんのコミット

成長の果実
個数		EXP	AC	オプション
1個		20%	-1	なし
2個		30%	-2	DR+1
3個		40%	-3	DR+2
4個		40%	-4	DR+2
4個		40%	-5	DR+2

Update
LSS/src/lss/Common.java
LSS/src/lss/Morph.java
LSS/src/lss/UI.java
UIのパネル1の変身レベル(LV85をLV84)の修正

Update
LSS/src/lss/Bougu.java
血戦ブーツ3種の強化10のオプション修正
防具ツールチップの表示名、順序の修正
防具ツールチップの表示項目(所持重量)追加

Update
LSS/src/lss/Bougu.java
ユニコーンの腕力のゲートル
ユニコーンの機敏のゲートル
ユニコーンの知力のゲートル
の強化9のオプション追加

ユニコーンの守護のゲートル
の強化時のオプション追加

ユニコーンの抵抗のゲートル
は装備パラメーター(MR強化)で実装済

Update
LSS/src/lss/Bougu.java
血戦シリーズの強化10のオプション追加
ルームティスレッドイアリングの強化6以降のACオプションの追加

Update
LSS/src/lss/Calculator.java
所持可能な重量の上限を5400から無制限に変更

LSS/data/E.zip
武器防具の新規追加及び修正

防具新規追加
	ユニコーンのゲートル(5種類)
	古代岩石のゲートルを新規追加
	古代の魔物のゲートルを新規追加
	ナイトバルドのゲートル
	アイリスのゲートル
	裂空のＴシャツ
	オーガキングベルト
	精神のベルト
	神聖な腕力のベルト
	神聖な機敏のベルト
	神聖な知力のベルト
	神聖な精神のベルト
	神聖な腕力のアミュレット
	神聖な機敏のアミュレット
	神聖な知力のアミュレット
	火霊のイアリング
	風霊のイアリング
	水霊のイアリング
	地霊のイアリング
	射手のリング
	神聖な気迫のリング
	神聖な魔王のリング
	神聖な知識のリング
	神聖な腕力のリング
	神聖な機敏のリング
	リッチリング
	グリムリーパーリング
	守護の紋章
	闘士の紋章
	名弓の紋章
	賢者の紋章
	守護闘士の紋章
	守護名弓の紋章
	守護賢者の紋章
	曙光のスポールダー
	ヴァラカスフレイムスケイルメイル
	ヴァラカスフレイムプレートメイル
	ヴァラカスフレイムレザーアーマー
	ヴァラカスフレイムローブ

武器新規追加
	ガイアの激怒
	英雄のボウ
	幸運のランス
	幸運のバトルアックス
	アリス
	タイタンの憤怒
	ヒュペリオンの絶望
	クロノスの恐怖

変更
	血戦装備(9種類)の強化限界を10へ変更
	アミュレットの強化限界を9へ変更
	イアリングの強化限界を9へ変更
	リングの強化限界を9へ変更
	マジックゲートルを魔法防御ゲートルへ名前を変更
	カボチャベルトをパンプキンベルトへ名前を変更
	フォノスファイターアミュレットを闘士のアミュレットへ名前を変更
	光るサイハのリングを神聖な射手のリングへ名前を変更
	テーベアヌビスリングを気迫のリングへ名前を変更
	テーベホルスリングを魔王のリングへ名前を変更
	悪魔王のボウの悪魔王の弓へ名前を変更
	悪夢のロングボウのオプションを変更
	シルバーナイトのドロンをシルバーナイトスポールダーへ名前を変更
	ハンターのドロンを狩人のスポールダーへ名前を変更
	預言者のドロンを予言者のスポールダーへ名前を変更
	アンタラスグランドスケイルメイルの装備クラスを変更
	パプリオンハイドロスケイルメイルの装備クラスを変更
	リンドビオルストームスケイルメイルの装備クラスを変更
	すべてのイアリングを[所持重量=XXX]へ統一
	すべてのイアリングに[魔法命中=XXX]を追加
	すべてのリングを[所持重量=XXX]へ統一
	すべてのリングに[魔法命中=XXX]を追加
	すべてのアミュレットを[所持重量=XXX]へ統一
	すべてのアミュレットに[魔法命中=XXX]を追加
	すべてのベルトを[所持重量=XXX]へ統一
	すべてのベルトに[魔法命中=XXX]を追加
	生命のダガーの装備クラスを変更
	ウィンドブレードソードの武器性能を変更
	真冥王の執行剣の武器性能を変更
	レッドシャドウデュアルブレードの武器性能を変更
	ホーリーヘドロンスタッフの武器性能を変更

2018/09/14
	https://github.com/F-node/L1SSからフォーク

GitHub Desktopでこのテキストファイルが文字化けを起こす為、文字コードはUTF-8(BOM付)
原因は文字コードがANSI(SHIFT JIS)の為、メモ帳でUTF-8(BOM付)で上書き保存
