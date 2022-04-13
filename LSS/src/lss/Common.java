/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

/**
 *
 *
 */
public interface Common {

    //6種のステータス
    final String[] ST_LIST = {"STR", "DEX", "INT", "WIS", "CON", "CHA"};
    final int STR = 0;
    final int DEX = 1;
    final int INT = 2;
    final int WIS = 3;
    final int CON = 4;
    final int CHA = 5;

    //10種の職業
    final String[] CLASS_LIST = {"P", "K", "E", "W", "D", "R", "I", "S", "F", "L"};
    final String[] CLASS_LIST2 = {"君主", "ナイト", "エルフ", "ウィザード", "ダークエルフ", "ドラゴンナイト", "イリュージョニスト", "ウォリアー", "フェンサー", "ランサー"};
    final int P = 0;        //君主
    final int K = 1;        //ナイト
    final int E = 2;        //エルフ
    final int W = 3;        //ウィザード
    final int D = 4;        //ダークエルフ
    final int R = 5;        //ドラゴンナイト
    final int I = 6;        //イリュージョニスト
    final int S = 7;        //ウォリアー
    final int F = 8;        //フェンサー
    final int L = 9;        //ランサー

    //4種の属性
    final String[] ELEM_LIST = {"地", "火", "水", "風"};
    final int EARTH = 0;    //地属性
    final int FIRE = 1;     //火属性
    final int WATER = 2;    //水属性
    final int WIND = 3;     //風属性

    //13種の武器
    final String[] BUKI_TYPE_LIST = {"ダガー", "片手剣", "両手剣", "スタッフ", "鈍器",
        "デュアルブレード", "クロウ", "槍", "ボウ", "ガントレット", "キーリンク", "チェーンソード", "双斧"};
    final int W_D = 0;      //ダガー
    final int W_LS = 1;     //片手剣
    final int W_TS = 2;     //両手剣
    final int W_S = 3;      //スタッフ
    final int W_A = 4;      //鈍器
    final int W_DB = 5;     //デュアルブレード
    final int W_C = 6;      //クロウ
    final int W_L = 7;      //槍
    final int W_B = 8;      //ボウ
    final int W_G = 9;      //ガントレット
    final int W_K = 10;     //キーリンク
    final int W_CS = 11;    //チェーンソード
    final int W_DA = 12;    //双斧

    final int MAIN = 13;
    final int SUB = 14;

    final int PHI = 0;
    final int MAG = 1;

    final int L1 = 0;
    final int L15 = 1;
    final int L30 = 2;
    final int L45 = 3;
    final int L50 = 4;
    final int L52 = 5;
    final int L55 = 6;
    final int L60 = 7;
    final int L65 = 8;
    final int L70 = 9;
    final int L75 = 10;
    final int L80 = 11;
    final int L82 = 12;
    final int L84 = 13;
    final int L90 = 14;
    final int L100 = 15;             //Hero用

    //パネル1のアミュレット/イアリング/リング/インシグニア/スポールダー/紋章/ペンダント等の順と位置
    final String[] EQ_LIST = {"武器", "武器", "シールド", "ヘルム", "グローブ", "シャツ",
        "アーマー", "クローク", "ブーツ", "ゲートル", "ベルト", "アミュレット", "イアリング", "イアリング", "リング", "リング",
        "リング", "リング", "リング", "リング", "インシグニア", "スポールダー", "紋章", "ペンダント"};

    final int EARRING1 = 12;
    final int EARRING2 = 13;

    final int RING1 = 14;
    final int RING2 = 15;
    final int RING3 = 16;
    final int RING4 = 17;
    final int RING5 = 18;
    final int RING6 = 19;

//エンチャント(0から320までの合計321個分)　UI.javaの223行目も合わせて変更必須
//基本エンチャント
    final int ACC1 = 0;             //1段加速
    final int ACC2 = 1;             //2段加速
    final int ACC3 = 2;             //3段加速
    final int ACC4 = 312;           //4段加速               //マジックドールの潜在力
    final int ACC5 = 313;           //5段加速               //騎士技術(レイジング ウェポン)
    final int B_STR = 3;            //STR
    final int B_DEX = 4;            //DEX
    final int B_AC = 5;             //AC
    final int BUKI = 6;             //武器エンチャ魔法
    final int SEC = 75;             //セキュリティ
    final int VIP = 72;             //VIPエンチャント

//その他
    final int DRAGON_BLESS = 126;   //ドラゴンの祝福
    final int ITEM_BLUE = 50;       //魔力回復ポーション
    final int ITEM_WIZP = 51;       //ウィズダムポーション
    final int ITEM_COOKING = 54;    //料理
    final int ITEM_DESSERT = 55;    //デザート
    final int ITEM_BREEZE = 52;     //潮風の力
    final int ITEM_SEA = 53;        //深海の力
    final int ITEM_MD = 56;         //マジックドール
    final int ITEM_MD_OP = 64;      //パック/パオ OP
    final int ITEM_MD_OP2 = 314;    //マジックドールの潜在力
    final int KOMA = 58;            //コマのエンチャ
    final int ITEM_MAGAN = 98;      //魔眼
    final int CLAY = 77;            //クレイ
    final int MOMIJI = 78;          //もみじリング
    final int BUFF_COIN = 63;       //バフコイン
    final int BS_COIN = 82;         //黒蛇のコイン
    final int MBSC = 74;            //真心のこもった祝福スクロール
    final int L_HST = 83;           //成長の果実
    final int H_HP = 93;            //生命のボーナス
    final int H_AC = 94;            //鉄甲のボーナス
    final int H_PVPDR = 95;         //生存のボーナス
    final int H_PVP = 96;           //暗殺のボーナス
    final int H_RK = 97;            //ランカーボーナス
    final int H_RKT = 141;          //各クラス別1位

//君主魔法          合計11種類
    //アクティブスキル
    final int P_TTT = 144;          //LV50  True TargeT                   トゥルーターゲット
    final int P_GWN = 7;            //LV60  Glowing WeapoN                グローイング ウェポン
    final int P_SSD = 9;            //LV75  Shining ShielD                シャイニング シールド
    final int P_BML = 8;            //LV70  Brave MentaL                  ブレイブ メンタル
    final int P_GRE = 87;           //LV80  GRacE                         グレース
    final int P_EME = 143;          //LV80  EMpirE                        エンパイア
    final int P_PRE = 110;          //LV85  PRimE                         プライム
    final int P_CCA = 142;          //LV85  Call Clan Advance             コールクラン アドバンス
    //パッシブスキル
    final int P_AUA = 59;           //LV80  AUrA                          オーラ
    final int P_EOD = 320;          //LV80  Empire:OverlorD               エンパイア:オーバーロード
    final int P_SAR = 99;           //LV80  Shining ArmoR                 シャイニング アーマー
    final int P_MAY = 100;          //LV80  MAjestY                       マジェスティ
    
//騎士の技術        12+3+3=18             合計18種類
    //アクティブスキル
    final int K_SSN = 147;          //LV60  Shock StaN                    ショックスタン
    final int K_RAR = 34;           //LV50  Reduction ArmoR               リダクションアーマー
    final int K_BOK = 65;           //LV65  BOunce attacK                 バウンスアタック
    final int K_BLK = 89;           //LV75  BLow attacK                   ブロー アタック
    final int K_CBR = 36;           //LV80  Counter BarrieR               カウンターバリア
    final int K_ABE = 146;          //LV85  Absolute BladE                アブソルート ブレイド
    final int K_FSN = 145;          //LV85  Force StaN                    フォース スタン
    //パッシブスキル
    final int K_CBV = 73;           //LV85  Counter Barrier:Veteran       カウンター バリア:ベテラン
    final int K_RAV = 112;          //LV80  Reduction Armor:Veteran       リダクション アーマー:ベテラン
    final int K_RFE = 111;          //LV80  Raging ForcE                  レイジング フォース
    final int K_SCE = 35;           //LV55  Solid CarriagE                ソリッドキャリッジ
    final int K_PRE = 88;           //LV60  PRidE                         プライド
    //[UP待ち]
    final int K_SAK = 306;          //LV85  Shock AttacK                  ショックアタック
    final int K_RWN = 307;          //LV88  Raging WeapoN                 レイジングウェポン
    final int K_CBM = 308;          //LV86  Counter Barrier:Master        カウンターバリア:マスター

//エルフの精霊魔法  4+1+8+11+20+3+3=50  合計50種類
    //アクティブスキル
    //LV1魔法    合計4種類
    final int E_RMC = 20;           //LV15  Resist MagiC                  レジスト マジック
    final int E_BTM = 160;          //LV15  Body To Mind                  ボディ トゥ マインド
    final int E_TTM = 159;          //LV15  Teleport To Mother            テレポート トゥ マザー
    final int E_TAW = 157;          //LV45  Triple ArroW                  トリプル アロー
    //LV2魔法    合計1種類
    final int E_CMD = 12;           //LV30  Clear MinD                    クリアー マインド
    //LV3魔法    合計8種類
    final int E_RTN = 161;          //LV45  Return To Nature              リターン トゥ ネイチャー
    final int E_EPN = 114;          //LV45  Elemental ProtectioN          エレメンタル プロテクション
    final int E_EWN = 18;           //LV45  Earth WeapoN                  アース ウェポン
    final int E_AST = 10;           //LV45  Aqua ShoT                     アクア ショット
    final int E_EEE = 84;           //LV45  Eagle EyE                     イーグル アイ
    final int E_FSD = 163;          //LV45  Fire ShielD                   ファイアー シールド(基本エンチャントのACで実装)
    final int E_QUE = 81;           //LV45  QUakE                         クエイク
    final int E_WLE = 167;          //LV45  Water LifE                    ウォーター ライフ
    //LV4魔法    合計11種類
    final int E_EFN = 155;          //LV60  Elemental FalldowN            エレメンタル フォールダウン
    final int E_EMC = 154;          //LV60  Erase MagiC                   イレース マジック
    final int E_SLE = 156;          //LV60  Summon Lesser Elemental       サモン レッサー エレメンタル
    final int E_DBE = 162;          //LV60  Dancing BlazE                 ダンシング ブレイズ(基本エンチャントの2段加速で実装)
    final int E_SEE = 13;           //LV60  Storm EyE                     ストーム アイ
    final int E_EBD = 170;          //LV80  Earth BinD                    アース バインド
    final int E_NTH = 16;           //LV60  Natures ToucH                 ネイチャーズ タッチ
    final int E_EGN = 61;           //LV60  Earth GuardiaN                アース ガーディアン
    final int E_APR = 21;           //LV60  Aqua ProtectoR                アクア プロテクター
    final int E_FWE = 166;          //LV60  Focus WavE                    フォーカス ウェーブ(基本エンチャントの2段加速で実装)
    final int E_SSM = 172;          //LV60  Sand StorM                    サンド ストーム(基本エンチャントの2段加速で実装)
    //LV5魔法    合計20種類
    final int E_ELY = 57;           //LV75  ELvengravitY                  エルヴン グラヴィティー
    final int E_ASE = 152;          //LV75  Area SilencE                  エリア サイレンス
    final int E_GEL = 153;          //LV75  Greater ElementaL             グレーター エレメンタル
    final int E_SBR = 151;          //LV80  Seoul BarrieR                 ソウル バリア
    final int E_BWN = 17;           //LV75  Burning WeapoN                バーニング ウェポン
    final int E_NBG = 165;          //LV75  Natures BlessinG              ネイチャーズ ブレッシング
    final int E_SST = 14;           //LV75  Storm ShoT                    ストーム ショット
    final int E_CYE = 85;           //LV75  CYclonE                       サイクロン
    final int E_ISN = 171;          //LV75  Iron SkiN                     アイアン スキン(基本エンチャントのACで実装)
    final int E_EVE = 22;           //LV75  Exotic VitalizE               エキゾチック バイタライズ
    final int E_EFE = 11;           //LV75  Elemental FirE                エレメンタル ファイアー
    final int E_PWR = 164;          //LV80  Pollute WateR                 ポルート ウォーター
    final int E_SGL = 168;          //LV80  Striker GaiL                  ストライカー ゲイル
    final int E_SOF = 15;           //LV80  Soul Of Flame                 ソウル オブ フレイム
    final int E_AFE = 23;           //LV75  Additional FirE               アディショナル ファイヤー
    final int E_HUE = 169;          //LV75  HUrricanE                     ハリケーン(基本エンチャントの2段加速で実装)
    final int E_INO = 86;           //LV80  INfernO                       インフェルノ
    final int E_MSD = 150;          //LV85  Magic ShielD                  マジック シールド
    final int E_LIN = 149;          //LV85  LIberatioN                    リベレーション
    final int E_ESE = 148;          //LV85  Elven StrikE                  エルブンストライク
    //パッシブ    合計3種類
    final int E_RET = 19;           //LV30  Resist ElemenT                レジスト エレメント
    final int E_GEH = 113;          //LV85  Glory EartH                   グローリーアース
    final int E_BSL = 158;          //LV45  Bloody SouL                   ブラッディ ソウル
    //[UP待ち]    合計3種類
    final int E_BST = 309;          //LV90  Burning ShoT                  [UP待ち]バーニングショット
    final int E_SBA = 310;          //LV85  Seoul Barrier Armor           [UP待ち]ソウルバリア:アーマー
    final int E_SGS = 311;          //LV85  Striker Gail:Shot             [UP待ち]ストライカーゲイル:ショット

//ウィザードの魔法  8+8+7+8+8+8+8+8+8+8+3+7=89    合計89種類
    //アクティブスキル
    //LV1魔法    合計8種類
    final int W_HEL = 228;          //LV8   HEaL                          ヒール
    final int W_LIT = 229;          //LV8   LIghT                         ライト
    final int W_SHD = 230;          //LV8   SHielD                        シールド(基本エンチャントのACで実装)
    final int W_EBT = 231;          //LV8   Energy BolT                   エネルギー ボルト
    final int W_TET = 232;          //LV8   TEleporT                      テレポート
    final int W_IDR = 233;          //LV8   Ice DaggeR                    アイス ダガー
    final int W_WCR = 234;          //LV8   Wind CutteR                   ウィンド カッター
    final int W_HWS = 235;          //LV8   Holy WeaponS                  ホーリー ウェポン(基本エンチャントのキャラ/武器で実装)
    //LV2魔法    合計8種類
    final int W_CUP = 236;          //LV16  CUre Poison                   キュア ポイズン
    final int W_CRH = 237;          //LV16  Chill ToucH                   チル タッチ
    final int W_CAP = 238;          //LV16  CArs Poison                   カーズ ポイズン
    final int W_EWN = 239;          //LV16  Enchant WeapoN                エンチャント ウェポン(基本エンチャントのキャラ/武器で実装)
    final int W_DEN = 240;          //LV16  DEtectioN                     ディテクション
    final int W_DWT = 26;           //LV16  Decrease WeighT               ディクリース ウェイト
    final int W_FAW = 241;          //LV16  Fire ArroW                    ファイアー アロー
    final int W_STK = 242;          //LV16  STarracK                      スタラック
    //LV3魔法    合計7種類
    final int W_LIG = 243;          //LV24  LIghtninG                     ライトニング
    final int W_TUD = 244;          //LV24  Turn UndeaD                   ターン アンデッド
    final int W_EHL = 245;          //LV24  Extra HeeL                    エキストラ ヒール
    final int W_CBD = 246;          //LV24  Curse BlinD                   カーズ ブラインド
    final int W_BAR = 27;           //LV24  Blessed ArmoR                 ブレスド アーマー
    final int W_FCD = 247;          //LV24  Frozen ClouD                  フローズン クラウド
    final int W_WEL = 248;          //LV24  Week ElementaL                ウィーク エレメンタル
    //LV4魔法    合計8種類
    final int W_FIL = 249;          //LV32  FIrebalL                      ファイアー ボール
    final int W_PED = 250;          //LV32  Physical Enchant:DEX          フィジカル エンチャント:DEX
    final int W_WBK = 251;          //LV32  Weapon BreaK                  ウェポン ブレイク
    final int W_VTH = 252;          //LV32  Vampiric ToucH                バンパイアリック タッチ
    final int W_THW = 253;          //LV32  THroW                         スロー
    final int W_EJL = 254;          //LV32  Earth JaiL                    アース ジェイル
    final int W_CMC = 255;          //LV32  Counter MagiC                 カウンター マジック
    final int W_MEN = 256;          //LV32  MEditatioN                    メディテーション
    //LV5魔法    合計8種類
    final int W_CPE = 257;          //LV40  Curse ParalyzE                カーズ パラライズ
    final int W_CLG = 258;          //LV40  Call LightninG                コール ライトニング
    final int W_GHL = 259;          //LV40  Greater HeeL                  グレーター ヒール
    final int W_TMR = 260;          //LV40  Taming MonsteR                テイミング モンスター
    final int W_RCE = 261;          //LV40  Remove CursE                  リムーブ カーズ
    final int W_COC = 262;          //LV40  Corn Of Cold                  コーン オブ コールド
    final int W_MDN = 263;          //LV40  Mana DraiN                    マナ ドレイン
    final int W_DAS = 264;          //LV40  DArknesS                      ダークネス
    //LV6魔法    合計8種類
    final int W_CZE = 265;          //LV48  Create ZombiE                 クリエイト ゾンビ
    final int W_PES = 266;          //LV48  Physical Enchant:STR          フィジカル エンチャント:STR
    final int W_HET = 267;          //LV48  HEisT                         ヘイスト(基本エンチャントの2段加速で実装)
    final int W_CAN = 268;          //LV48  CAncellatioN                  キャンセレーション
    final int W_IRN = 269;          //LV48  IRaptioN                      イラプション
    final int W_SUT = 270;          //LV48  SUnbursT                      サン バースト
    final int W_WES = 271;          //LV48  WEaknesS                      ウィークネス
    final int W_BWN = 272;          //LV48  Breath WeapoN                 ブレス ウェポン
    //LV7魔法    合計8種類
    final int W_HAL = 273;          //LV56  Heel AlL                      ヒール オール
    final int W_FAR = 102;          //LV56  Freezing ArmoR                フリージング アーマー
    final int W_SMR = 274;          //LV56  Summon MonsteR                サモン モンスター
    final int W_HWK = 275;          //LV56  Holy WalK                     ホーリー ウォーク
    final int W_TOO = 276;          //LV56  TOrnadO                       トルネード
    final int W_GHT = 277;          //LV56  Greater HeisT                 グレーター ヘイスト(基本エンチャントの2段加速で実装)
    final int W_BER = 25;           //LV56  BErserkeR                     バーサーカー
    final int W_EAY = 101;          //LV56  Enchant Accuracy              エンチャント アキュラシー
    //LV8魔法    合計8種類
    final int W_FHL = 278;          //LV64  Full HeeL                     フル ヒール
    final int W_FWL = 279;          //LV64  Fire WalL                     ファイアー ウォール
    final int W_BLD = 280;          //LV64  BLizzarD                      ブリザード
    final int W_INY = 281;          //LV64  INvisibilitY                  インビジビリティー
    final int W_REN = 282;          //LV64  REsurrectioN                  リザレクション
    final int W_EAE = 283;          //LV64  EArthquakE                    アース クエイク
    final int W_LSM = 284;          //LV64  Life StreaM                   ライフ ストリーム
    final int W_SIE = 285;          //LV64  SIlencE                       サイレンス
    //LV9魔法    合計8種類
    final int W_LIM = 286;          //LV72  LIghtning storM               ライトニング ストーム
    final int W_FOS = 287;          //LV72  Fog Of Sleeping               フォグ オブ スリーピング
    final int W_SCE = 288;          //LV72  Shape ChangE                  シェイプ チェンジ
    final int W_ITH = 289;          //LV72  Immun To Harm                 イミューン トゥ ハーム
    final int W_MTT = 290;          //LV72  Mass TeleporT                 マス テレポート
    final int W_FSM = 291;          //LV72  Fire StorM                    ファイアー ストーム
    final int W_DPN = 292;          //LV72  Decay potion                  ディケイポーション
    final int W_CDN = 293;          //LV72  Counter DetectioN             カウンター ディテクション
    //LV10魔法    合計8種類
    final int W_DHL = 294;          //LV80  Death Heel                    デス ヒール
    final int W_MSE = 295;          //LV80  Meteor StrikE                 メテオ ストライク
    final int W_GRN = 296;          //LV80  Greater ResurrectioN          グレーター リザレクション
    final int W_IMR = 297;          //LV80  Ice MeteoR                    アイス メテオ
    final int W_DIE = 298;          //LV80  DisIntegratE                  ディスインテグレート
    final int W_ABR = 299;          //LV80  Absolute BarrieR              アブソルート バリア
    final int W_ADS = 24;           //LV80  ADvanced Spirits              アドバンスド スピリッツ
    final int W_ISE = 300;          //LV80  Ice SpikE                     アイス スパイク
    //LV11魔法    合計3種類
    final int W_ETY = 301;          //LV85  ETernitY                      エタニティ
    final int W_MIT = 304;          //LV85  Mas Immun To Harm             マス イミューン トゥ ハーム
    final int W_DPR = 315;          //LVXX  Divine PRotection             ディバインプロテクション
    //パッシブ    合計7種類
    final int W_IHS = 302;          //LV80  Immun to Harm: Saint          イミューン トゥ ハーム:セイント
    final int W_MAY = 303;          //LV85  Meister AccuracY              マイスター アキュラシー
    final int W_MBD = 305;          //LV85  Meditation:BeyonD             メディテーション:ビヨンド
    final int W_DNS = 316;          //LVXX  Disintegrate:NemesiS          ディスインテグレート:ネメシス
    final int W_HWE = 317;          //LVXX  Holy Walk:Evolution           ホーリーウォーク:エボリューション(EW速度)
    final int W_ERC = 318;          //LVXX  Ether Real Circle             エーテリアルサークル
    final int W_GSM = 319;          //LV90  Greater Summon Monster        グレーターサモンモンスター

//闇の精霊魔法  4+4+3+4+8=23  合計23種類
    //アクティブスキル
    //LV1魔法    合計4種類
    final int D_BHG = 178;          //LV20  Blind HidinG                  ブラインド ハイディング
    final int D_EVM = 179;          //LV20  Enchantment VenoM             エンチャント ベノム
    final int D_SAR = 33;           //LV20  Shadow ArmoR                  シャドウ アーマー
    final int D_DMY = 181;          //LV20  Dress MightY                  ドレス マイティー
    //LV2魔法    合計4種類
    final int D_MAN = 79;           //LV40  Moving AcceleratioN           ムービング アクセレーション
    final int D_SSP = 176;          //LV40  Shadow SleeP                  シャドウ スリープ
    final int D_VRT = 80;           //LV40  Venom ResisT                  ベノム レジスト
    final int D_DDY = 177;          //LV40  Dress Dexterity               ドレス デクスタリティー
    //LV3魔法    合計3種類
    final int D_DBK = 29;           //LV60  Double BreaK                  ダブル ブレイク
    final int D_UDE = 32;           //LV60  Uncanny DodgE                 アンキャニー ドッジ
    final int D_SFG = 175;          //LV60  Shadow FanG                   シャドウ ファング(基本エンチャントのキャラ/武器で実装)
    //LV4魔法    合計4種類
    final int D_ABK = 121;          //LV80  Armor BreaK                   アーマー ブレイク
    final int D_LUR = 122;          //LV80  LUcifeR                       ルシファー
    final int D_AVR = 119;          //LV85  AVengeR                       アベンジャー
    final int D_SHS = 120;          //LV80  SHadow Step                   シャドウ ステップ
    //パッシブ    合計8種類
    final int D_ABD = 124;          //LV85  Armor Break:Destiny           アーマーブレイク:デスティニー
    final int D_DBD = 28;           //LV80  Double Break:Destiny          ダブル ブレイク:デスティニー
    final int D_FBN = 103;          //LV60  Final BurN                    ファイナル バーン
    final int D_BSS = 30;           //LV40  Burning SpiritS               バーニング スピリッツ
    final int D_DEN = 31;           //LV60  Dress EvasioN                 ドレス イベイジョン
    final int D_LUD = 123;          //LV85  LUcifer:Destiny               ルシファー:デスティニー
    final int D_SAD = 174;          //LV85  Shadow Armor:Destiny          シャドウ アーマー:デスティニー
    final int D_MAM = 173;          //LV85  Moving Acceleration:Maximum   ムービング アクセレーション:マキシマム

//竜騎士の秘技    4+4+4+2+8=合計22種類
    //アクティブスキル
    //LV1魔法          合計4種類
    final int R_BSH = 191;          //LV20  Burning SlasH                 バーニング スラッシュ
    final int R_DEY = 192;          //LV20  DEstroY                       デストロイ
    final int R_MBH = 193;          //LV20  Magma BreatH                  マグマ ブレス
    final int R_ANTHARAS = 39;      //LV20  Arousal[ANTHARAS]             覚醒[アンタラス]
    //LV2魔法          合計4種類
    final int R_BLT = 187;          //LV40  Blood LasT                    ブラッドラスト(基本エンチャントの2段加速で実装)
    final int R_FSR = 188;          //LV40  Four SlayeR                   フォー スレイヤー
    final int R_MAW = 190;          //LV40  Magma ArroW                   マグマ アロー
    final int R_FAFURION = 40;      //LV40  Arousal[FAFURION]             覚醒[パプリオン]
    //LV3魔法          合計4種類
    final int R_MBY = 38;           //LV60  Mortal BodY                   モータル ボディー
    final int R_TGP = 184;          //LV60  Thunder GraP                  サンダー グラップ
    final int R_EOD = 186;          //LV60  Eye Of Dragon                 アイ オブ ドラゴン
    final int R_VALAKAS = 41;       //LV60  Arousal[VALAKAS]              覚醒[ヴァラカス]
    //LV4魔法          合計2種類
    final int R_LINDVIOL = 90;      //LV80  Arousal[LINDVIOL]             覚醒[リンドビオル]
    final int R_HAS = 116;          //LV85  HAlpaS                        ハルパス
    //パッシブスキル    合計8種類
    final int R_TGB = 183;          //LV80  Thunder Grap:Brave            サンダー グラップ:ブレイブ
    final int R_FSB = 60;           //LV85  Four Slayer:Brave             フォー スレイヤー:ブレイブ
    final int R_AUA = 117;          //LV80  AUrakiA                       アウラキア
    final int R_DFR = 189;          //LV40  Destroy:FeaR                  デストロイ:フィアー
    final int R_DHR = 185;          //LV60  Destroy:HorroR                デストロイ:ホラー
    final int R_DSN = 37;           //LV20  Dragon SkiN                   ドラゴン スキン
    final int R_SNT = 181;          //LV80  Solid NoT                     ソリッド ノット
    final int R_RAE = 182;          //LV80  RAmpagE                       ランページ

//イリュージョニストの幻術魔法    5+4+4+5+4+4=26　合計26種類
    //アクティブスキル  合計22種類
    //LV1魔法 
    final int I_MIE = 49;           //LV15  Mirror ImagE                  ミラー イメージ
    final int I_CFN = 205;          //LV15  ConFusioN                     コンフュージョン
    final int I_SEY = 206;          //LV15  Smash EnergY                  スマッシュ エネルギー
    final int I_IOE = 42;           //LV15  Illusion[OgrE]                イリュージョン[オーガ]
    final int I_COE = 207;          //LV15  Cube[OgrE]                    キューブ[オーガ]
    //LV2魔法 
    final int I_CON = 48;           //LV30  COncentratioN                 コンセントレーション
    final int I_MBK = 202;          //LV30  Mind BreaK                    マインド ブレイク
    final int I_BBK = 203;          //LV30  Bone BreaK                    ボーン ブレイク
    final int I_CGM = 204;          //LV30  Cube[GoleM]                   キューブ[ゴーレム]
    //LV3魔法
    final int I_PAE = 47;           //LV45  PAtiencE                      ペイシェンス
    final int I_PHM = 199;          //LV45  PHantasM                      ファンタズム
    final int I_IBR = 200;          //LV45  Ices BreakeR                  アイズ ブレイカー
    final int I_CRH = 201;          //LV45  Cube[RicH]                    キューブ[リッチ]
    //LV4魔法
    final int I_INS = 46;           //LV60  INsighT                       インサイト
    final int I_PAC = 197;          //LV60  PAniC                         パニック
    final int I_RWT = 62;           //LV60  Reduce WeighT                 リデュース ウェイト
    final int I_IAR = 45;           //LV60  Illusion[AvataR]              イリュージョン[アバター]
    final int I_CAR = 198;          //LV60  Cube[AvataR]                  キューブ[アバター]
    //LV5魔法
    final int I_IMT = 92;           //LV80  IMpacT                        インパクト
    final int I_FSZ = 91;           //LV75  Focus SpitZ                   フォーカス スピリッツ
    final int I_MES = 195;          //LV85  MEviuS                        メビウス
    final int I_POL = 118;          //LV85  POtentiaL                     ポテンシャル
    //パッシブスキル    合計4種類
    final int I_DHE = 196;          //LV80  Dark HorsE                    ダークホース(基本エンチャントの2段加速で実装)
    final int I_IRH = 43;           //LV30  Illusion[RicH]                イリュージョン[リッチ]
    final int I_IGM = 44;           //LV45  Illusion[GoleM]               イリュージョン[ゴーレム]
    final int I_BBL = 194;          //LV85  Bone Break:Last               ボーン ブレイク:ラスト

//ウォリアーの技術      8+8+=16　合計16種類
    //アクティブスキル  合計8種類
    final int S_HOL = 213;          //LV30  HOwL                          ハウル
    final int S_GIC = 76;           //LV60  GIgantiC                      ギガンティック
    final int S_PGP = 211;          //LV75  Power GriP                    パワー グリップ
    final int S_TOK = 212;          //LV45  TOmahawK                      トマホーク
    final int S_DEO = 210;          //LV80  DEsperadO                     デスペラード
    final int S_TRG = 115;          //LV80  Titan RisinG                  タイタン ライジング
    final int S_DEN = 208;          //LV85  DEmolitioN                    デモリッション
    final int S_BER = 209;          //LV85  BErserkeR                     バーサーカー
    //パッシブスキル    合計8種類
    final int S_FUY = 68;           //LV60  FUrY                          フューリー
    final int S_SLR = 214;          //LV15  SLayeR                        スレイヤー
    final int S_CRH = 67;           //LV45  CRasH                         クラッシュ
    final int S_AGD = 66;           //LV60  Armor GuarD                   アーマー ガード
    final int S_TLK = 69;           //LV75  Titan Lock                    タイタンロック
    final int S_TMC = 70;           //LV75  Titan MagiC                   タイタンマジック
    final int S_TBZ = 71;           //LV80  Titan BlitZ                   タイタンブリッツ
    final int S_DAE = 215;          //LV85  Desperado:AbsolutE            デスペラード:アブソリュート

//フェンサーの技術    合計19種類
    //  アクティブスキル
    final int F_ABE = 218;          //LV60  BladE                         ブレード
    final int F_APM = 222;          //LV70  PhantoM                       ファントム
    final int F_AJT = 220;          //LV80  JudgmenT                      ジャッジメント
    final int F_AHE = 221;          //LV70  HellfirE                      ヘルファイア
    final int F_APA = 219;          //LV75  Pantera                       パンテラ
    final int F_AAA = 217;          //LV85  AshurA                        アシュラ
    //  パッシブスキル
    final int F_PDS = 125;          //LV45  DamascuS                      ダマスカス
    final int F_PFE = 109;          //LV45  FramE                         フレイム
    final int F_PRE = 107;          //LV60  RagE                          レイジ
    final int F_PSE = 225;          //LV70  SurvivE                       サヴァイヴ
    final int F_PIR = 108;          //LV45  Infinity:ArmoR                インフィニティ:アーマー
    final int F_PIE = 105;          //LV70  Infinity:DodgE                インフィニティ:ドッジ
    final int F_PID = 106;          //LV60  Infinity:BlooD                インフィニティ:ブラッド
    final int F_PIZ = 104;          //LV75  Infinity:BlitZ                インフィニティ:ブリッツ
    final int F_PPX = 226;          //LV75  ParadoX                       パラドックス
    final int F_PPR = 223;          //LV80  Phantom:ReapeR                ファントム:リーパー
    final int F_PPH = 216;          //LV80  Phantom:DeatH                 ファントム:デス
    final int F_PPK = 224;          //LV80  Pantera:ShocK                 パンテラ:ショック
    final int F_PGE = 227;          //LV60  GrousE                        グロース

//ランサーの槍術    合計14種類
    //  アクティブスキル
    final int L_ALE = 127;          //LV50  ALternatE                     オルティネート
    final int L_FWE = 128;          //LV60  Force WavE                    フォース ウェーブ
    final int L_VAD = 129;          //LV70  VAnguarD                      ヴァンガード
    final int L_REY = 130;          //LV75  REcoverY                      リカバリー
    final int L_PRE = 131;          //LV75  PRessurE                      プレッシャー
    final int L_KRL = 132;          //LV80  KRueL                         クルーエル
    //  パッシブスキル
    final int L_KCN = 139;          //LV80  Kruel:CombinatioN             クルーエル:コンビクション
    final int L_PDR = 140;          //LV85  Pressure:Death Recall         プレッシャー:デス リコール
    final int L_DBK = 136;          //LV75  Dodge BreaK                   ドッジ ブレイク
    final int L_MAM = 137;          //LV75  MAelstroM                     メイルストロム
    final int L_DSE = 133;          //LV65  Deadly StrikE                 デッドリー ストライク
    final int L_VEE = 134;          //LV70  VEngeancE                     ヴェンジェンス
    final int L_TAE = 135;          //LV70  Tactical AdvancE              タクティカル アドバンス
    final int L_IRE = 138;          //LV80  Increase RangE                インクリーズ レンジ

    final String[] AILMENT_LIST = {"技術命中", "技術耐性", "精霊命中", "精霊耐性", "秘技命中","秘技耐性", "恐怖命中", "恐怖耐性"};
    final int HIT_STUN = 0;
    final int STUN = 1;
    final int HIT_SPIRIT = 2;
    final int SPIRIT = 3;
    final int HIT_SECRET = 4;
    final int SECRET = 5;
    final int HIT_TERROR = 6;
    final int TERROR = 7; 

    final String[] ENEMY_TYPE_LIST = {"通常", "悪魔", "不死"};
    final int NORMAL = 0;
    final int CURSED = 1;
    final int UNDEAD = 2;

//強化値
    String[] EQ_EN_LIST = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};

//属性強化
    String[] EQ_ELEM_LIST = {"無属性", "地霊:1段", "地霊:2段", "地霊:3段", "地霊:4段", "地霊:5段",
                             "火霊:1段", "火霊:2段", "火霊:3段", "火霊:4段", "火霊:5段",
                             "水霊:1段", "水霊:2段", "水霊:3段", "水霊:4段", "水霊:5段",
                             "風霊:1段", "風霊:2段", "風霊:3段", "風霊:4段", "風霊:5段"};

//Tシャツの強化値
    String[] EQ_TS_LIST = {"0段階", "1段階", "2段階", "3段階", "4段階", "5段階"};
}
