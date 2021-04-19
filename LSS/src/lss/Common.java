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
    final int P = 0;
    final int K = 1;
    final int E = 2;
    final int W = 3;
    final int D = 4;
    final int R = 5;
    final int I = 6;
    final int S = 7;
    final int F = 8;
    final int L = 9;

    //4種の属性
    final String[] ELEM_LIST = {"地", "火", "水", "風"};
    final int EARTH = 0;
    final int FIRE = 1;
    final int WATER = 2;
    final int WIND = 3;

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
    final int L99 = 15;             //Hero用

    //パネル1のアミュレット/イアリング/リング/インシグニア/スポールダー/紋章/ペンダント等の順と位置
    final String[] EQ_LIST = {"武器", "武器", "シールド", "ヘルム", "グローブ", "シャツ",
        "アーマー", "クローク", "ブーツ", "ゲートル", "ベルト", "アミュレット", "イアリング", "イアリング", "リング", "リング",
        "リング", "リング", "インシグニア", "スポールダー", "紋章", "ペンダント"};

    final int RING1 = 14;
    final int RING2 = 15;
    final int RING3 = 16;
    final int RING4 = 17;

    final int EARRING1 = 11;
    final int EARRING2 = 12;

//エンチャント(0から161までの合計162個分)　UI.javaの223行目も合わせて変更必須
//基本エンチャント
    final int ACC1 = 0;             //1段加速
    final int ACC2 = 1;             //2段加速
    final int ACC3 = 2;             //3段加速
    final int B_STR = 3;            //STR
    final int B_DEX = 4;            //DEX
    final int B_AC = 5;             //AC
    final int BUKI = 6;             //武器エンチャ魔法
    final int SEC = 75;             //セキュリティ
    final int VIP = 72;             //VIPエンチャント

//君主魔法          合計11種類
    final int P_CCA = 142;          //LV85  Call Clan Advance             [UP待ち]コールクランアドバンス
    final int P_PRE = 110;          //LV85  PRimE                         プライム
    final int P_EME = 143;          //LV80  EMpirE                        エンパイア(未実装)
    final int P_GRE = 87;           //LV80  GRacE                         グレース
    final int P_AUA = 59;           //LV80  AUrA                          オーラ
    final int P_MAY = 100;          //LV80  MAjestY                       マジェスティ
    final int P_SAR = 99;           //LV80  Shining ArmoR                 シャイニングアーマー
    final int P_SSD = 9;            //LV75  Shining ShielD                シャイニングシールド
    final int P_BML = 8;            //LV70  Brave MentaL                  ブレイブメンタル
    final int P_GWN = 7;            //LV60  Glowing WeapoN                グローイングウェポン
    final int P_TTT = 144;          //LV50  True TargeT                   トゥルーターゲット(未実装)

//騎士の技術        合計12種類
    //アクティブスキル
    final int K_FSN = 145;          //LV85  Force StaN                    フォーススタン(未実装)
    final int K_ABE = 146;          //LV85  Absolute BladE                アブソルートブレイド(未実装)
    final int K_CBR = 36;           //LV80  Counter BarrieR               カウンターバリア(未実装)
    final int K_BLK = 89;           //LV75  BLow attacK                   ブローアタック
    final int K_BOK = 65;           //LV65  BOunce attacK                 バウンスアタック
    final int K_SSN = 147;          //LV60  Shock StaN                    ショックスタン(未実装)
    final int K_PRE = 88;           //LV60  PRidE                         プライド
    final int K_SCE = 35;           //LV55  Solid CarriagE                ソリッドキャリッジ
    final int K_RAR = 34;           //LV50  Reduction ArmoR               リダクションアーマー
    //パッシブスキル
    final int K_CBV = 73;           //LV85  Counter Barrier:Veteran       カウンターバリア:ベテラン(未実装)
    final int K_RFE = 111;          //LV80  Raging ForcE                  [UP待ち]レイジングフォース
    final int K_RAV = 112;          //LV80  Reduction Armor:Veteran       [UP待ち]リダクションアーマー:ベテラン

//エルフの精霊魔法  20+7+7+6+7=47  合計47種類
    //共通      合計20種類
    final int E_GEH = 113;          //LV85  Glory EartH                   グローリーアース(未実装)
    final int E_ESE = 148;          //LV85  Elven StrikE                  [UP待ち]エルブンストライク
    final int E_REN = 149;          //LV85  REvalatioN                    [UP待ち]リバレーション
    final int E_MSD = 150;          //LV85  Magic ShielD                  [UP待ち]マジックシールド
    final int E_SBR = 151;          //LV80  Seoul BarrieR                 ソウルバリア(未実装)
    final int E_ASE = 152;          //LV75  Area SilencE                  エリアサイレンス(未実装)
    final int E_ELY = 57;           //LV75  ELvengravitY                  エルヴングラヴィティー
    final int E_GEL = 153;          //LV75  Greater ElementaL             グレーターエレメンタル(未実装)
    final int E_EMC = 154;          //LV60  Erase MagiC                   イレースマジック(未実装)
    final int E_EFN = 155;          //LV60  Elemental FalldowN            エレメンタルフォールダウン(未実装)
    final int E_SLE = 156;          //LV60  Summon Lesser Elemental       サモンレッサーエレメンタル(未実装)
    final int E_TAW = 157;          //LV45  Triple ArroW                  トリプルアロー(未実装)
    final int E_BSL = 158;          //LV45  Bloody SouL                   ブラッディソウル(未実装)
    final int E_EPN = 114;          //LV45  Elemental ProtectioN          エレメンタルプロテクション
    final int E_RET = 19;           //LV30  Resist ElemenT                レジストエレメント
    final int E_CMD = 12;           //LV30  Clear MinD                    クリアマインド
    final int E_TTM = 159;          //LV15  Teleport To Mother            テレポートトゥマザー(未実装)
    final int E_BTM = 160;          //LV15  Body To Mind                  ボディトゥマインド(未実装)
    final int E_RMC = 20;           //LV15  Resist MagiC                  レジストマジック
    final int E_RTN = 161;          //LV45  Return To Nature              リターントゥネイチャー(未実装) 

    //火系列    合計7種類
    final int E_INO = 86;           //LV80  INfernO                       インフェルノ(未実装)
    final int E_SOF = 15;           //LV80  Soul Of Flame                 ソウルオブフレイム
    final int E_AFE = 23;           //LV75  Additional FirE               アディショナルファイヤー
    final int E_EFE = 11;           //LV75  Elemental FirE                エレメンタルファイアー
    final int E_BWN = 17;           //LV75  Burning WeapoN                バーニングウェポン
    final int E_DBE = 162;          //LV60  Dancing BlazE                 ダンシングブレイズ(基本エンチャントの2段加速で実装)
    final int E_FSD = 163;          //LV45  Fire ShielD                   ファイアーシールド(基本エンチャントのACで実装)

    //水系列    合計7種類
    final int E_PWR = 164;          //LV80  Pollute WateR                 ポルートウォーター(未実装)
    final int E_NBG = 165;          //LV75  Natures BlessinG              ネイチャーズブレッシング(未実装)
    final int E_FWE = 166;          //LV60  Focus WavE                    フォーカスウェーブ(基本エンチャントの2段加速で実装)
    final int E_APR = 21;           //LV60  Aqua ProtectoR                アクアプロテクター
    final int E_NTH = 16;           //LV60  Natures ToucH                 ネイチャーズタッチ
    final int E_WLE = 167;          //LV45  Water LifE                    ウォーターライフ(未実装)
    final int E_AST = 10;           //LV45  Aqua ShoT                     アクアショット

    //風系列    合計6種類
    final int E_SGL = 168;          //LV80  Striker GaiL                  ストライカーゲイル(未実装)
    final int E_HUE = 169;          //LV75  HUrricanE                     ハリケーン(基本エンチャントの2段加速で実装)
    final int E_CYE = 85;           //LV75  CYclonE                       サイクロン
    final int E_SST = 14;           //LV75  Storm ShoT                    ストームショット
    final int E_SEE = 13;           //LV60  Storm EyE                     ストームアイ
    final int E_EEE = 84;           //LV45  Eagle EyE                     イーグルアイ

    //地系列    合計7種類
    final int E_EBD = 170;          //LV80  Earth BinD                    アースバインド(未実装)
    final int E_EVE = 22;           //LV75  Exotic VitalizE               エキゾチックバイタライズ
    final int E_ISN = 171;          //LV75  Iron SkiN                     アイアンスキン(基本エンチャントのACで実装)
    final int E_SSM = 172;          //LV60  Sand StorM                    サンドストーム(基本エンチャントの2段加速で実装)
    final int E_EGN = 61;           //LV60  Earth GuardiaN                アースガーディアン
    final int E_QUE = 81;           //LV45  QUakE                         クエイク
    final int E_EWN = 18;           //LV45  Earth WeapoN                  アースウェポン

//ウィザードの魔法  8+2+3=84    合計84種類
    //パッシブ    合計3種類
//    final int W_XX = X;           //LV85  Meister Accuracy              マイスターアキュラシー(未実装)
//    final int W_XX = X;           //LV85  Meditation: BeyonD            メディテーション:ビヨンド(未実装)
//    final int W_XX = X;           //LV80  Immun To Harm: Saint          イミューントゥハーム:セイント(未実装)

    //LV11魔法    合計2種類
//    final int W_XX = X;           //LV85  ETernity                      エタニティ(未実装)
//    final int W_XX = X;           //LV85  Mas Immun To                  マスイミューントゥ(未実装)    

    //LV10魔法    合計8種類
//    final int W_XX = X;           //LV80  Death Heel                    デスヒール(未実装)
//    final int W_XX = X;           //LV80  Meteor Strike                 メテオストライク(未実装)
//    final int W_XX = X;           //LV80  Greater Resurrection          グレーターリザレクション(未実装)
//    final int W_XX = X;           //LV80  Ice Meteor                    アイスメテオ(未実装)
//    final int W_XX = X;           //LV80  Disintegrate                  ディスインテグレート(未実装)
//    final int W_XX = X;           //LV80  Absolute barrier              アブソルートバリア(未実装)
    final int W_ADS = 24;           //LV80  Advanced spirits              アドバンスドスピリッツ
//    final int W_XX = X;           //LV80  Ice spike                     アイススパイク(未実装)

    //LV9魔法    合計8種類
//    final int W_XX = X;           //LV72  Lightning storm               ライトニングストーム(未実装)
//    final int W_XX = X;           //LV72  Fog of sleeping               フォグオブスリーピング(未実装)
//    final int W_XX = X;           //LV72  Shape change                  シェイプチェンジ(未実装)
//    final int W_XX = X;           //LV72  Immun To Harm                 イミューントゥハーム(未実装)
//    final int W_XX = X;           //LV72  Massteleport                  マステレポート(未実装)
//    final int W_XX = X;           //LV72  Fire storm                    ファイアーストーム(未実装)
//    final int W_XX = X;           //LV72  Decay potion                  ディケイポーション(未実装)
//    final int W_XX = X;           //LV72  Counter detection             カウンターディテクション(未実装)

    //LV8魔法    合計8種類
//    final int W_FHL = X;          //LV64  Full HeeL                     フルヒール(未実装)
//    final int W_FWL = X;          //LV64  Fire WalL                     ファイアーウォール(未実装)
//    final int W_BLD = X;          //LV64  BLizzarD                      ブリザード(未実装)
//    final int W_INY = X;          //LV64  INvisibilitY                  インビジビリティー(未実装)
//    final int W_REN = X;          //LV64  REsurrectioN                  リザレクション(未実装)
//    final int W_EAE = X;          //LV64  EArthquakE                    アースクエイク(未実装)
//    final int W_LSM = X;          //LV64  Life StreaM                   ライフストリーム(未実装)
//    final int W_SIE = X;          //LV64  SIlencE                       サイレンス(未実装)

    //LV7魔法    合計8種類
//    final int W_HAL = X;          //LV56  Heel AlL                      ヒールオール(未実装)
    final int W_FAR = 102;          //LV56  Freezing ArmoR                フリージングアーマー
//    final int W_SMR = X;          //LV56  Summon MonsteR                サモンモンスター(未実装)
//    final int W_HWK = X;          //LV56  Holy WalK                     ホーリーウォーク(未実装)
//    final int W_TOO = X;          //LV56  TOrnadO                       トルネード(未実装)
//    final int W_GHT = X;          //LV56  Greater HeisT                 グレーターヘイスト(未実装)
    final int W_BER = 25;           //LV56  BErserkeR                     バーサーカー
    final int W_EAY = 101;          //LV56  Enchant Accuracy              エンチャントアキュラシー

    //LV6魔法    合計8種類
//    final int W_CZE = X;          //LV48  Create ZombiE                 クリエイトゾンビ(未実装)
//    final int W_PES = X;          //LV48  Physical Enchant:STR          フィジカルエンチャント:STR(未実装)
//    final int W_HET = X;          //LV48  HEisT                         ヘイスト(未実装)
//    final int W_CAN = X;          //LV48  CAncellatioN                  キャンセレーション(未実装)
//    final int W_IRN = X;          //LV48  IRaptioN                      イラプション(未実装)
//    final int W_SUT = X;          //LV48  SUnbursT                      サンバースト(未実装)
//    final int W_WES = X;          //LV48  WEaknesS                      ウィークネス(未実装)
//    final int W_BWN = X;          //LV48  Breath WeapoN                 ブレスウェポン(未実装)

    //LV5魔法    合計8種類
//    final int W_CPE = X;          //LV40  Curse ParalyzE                カーズパラライズ(未実装)
//    final int W_CLG = X;          //LV40  Call LightninG                コールライトニング(未実装)
//    final int W_GHL = X;          //LV40  Greater HeeL                  グレーターヒール(未実装)
//    final int W_TMR = X;          //LV40  Taming MonsteR                テイミングモンスター(未実装)
//    final int W_RCE = X;          //LV40  Remove CursE                  リムーブカーズ(未実装)
//    final int W_COC = X;          //LV40  Corn Of Cold                  コーンオブコールド(未実装)
//    final int W_MDN = X;          //LV40  Mana DraiN                    マナドレイン(未実装)
//    final int W_DAS = X;          //LV40  DArknesS                      ダークネス(未実装)

    //LV4魔法    合計8種類
//    final int W_FIL = X;          //LV32  FIrebalL                      ファイアーボール(未実装)
//    final int W_PED = X;          //LV32  Physical Enchant:DEX          フィジカルエンチャント:DEX(未実装)
//    final int W_WBK = X;          //LV32  Weapon BreaK                  ウェポンブレイク(未実装)
//    final int W_VTH = X;          //LV32  Vampiric ToucH                バンパイアリックタッチ(未実装)
//    final int W_THW = X;          //LV32  THroW                         スロー(未実装)
//    final int W_EJL = X;          //LV32  Earth JaiL                    アースジェイル(未実装)
//    final int W_CMC = X;          //LV32  Counter MagiC                 カウンターマジック(未実装)
//    final int W_MEN = X;          //LV32  MEditatioN                    メディテーション(未実装)

    //LV3魔法    合計7種類
//    final int W_LIG = X;          //LV24  LIghtninG                     ライトニング(未実装)
//    final int W_TUD = X;          //LV24  Turn UndeaD                   ターンアンデッド(未実装)
//    final int W_EHL = X;          //LV24  Extra HeeL                    エキストラヒール(未実装)
//    final int W_CBD = X;          //LV24  Curse BlinD                   カーズブラインド(未実装)
    final int W_BAR = 27;           //LV24  Blessed ArmoR                 ブレスドアーマー
//    final int W_FCD = X;          //LV24  Frozen ClouD                  フローズンクラウド(未実装)
//    final int W_WEL = X;          //LV24  Week ElementaL                ウィークエレメンタル(未実装)

    //LV2魔法    合計8種類
//    final int W_CPN = X;          //LV16  Cure PoisoN                   キュアポイズン(未実装)
//    final int W_CRH = X;          //LV16  Chill ToucH                   チルタッチ(未実装)
//    final int W_CPN = X;          //LV16  Cars PoisoN                   カーズポイズン(未実装)
//    final int W_EWN = X;          //LV16  Enchant WeapoN                エンチャントウェポン(未実装)
//    final int W_DEN = X;          //LV16  DEtectioN                     ディテクション(未実装)
    final int W_DWT = 26;           //LV16  Decrease WeighT               ディクリースウェイト
//    final int W_FAW = X;          //LV16  Fire ArroW                    ファイアーアロー(未実装)
//    final int W_STK = X;          //LV16  STarracK                      スタラック(未実装)

    //LV1魔法    合計8種類
//    final int W_HEL = X;          //LV8   HEaL                          ヒール(未実装)
//    final int W_LIT = X;          //LV8   LIghT                         ライト(未実装)
//    final int W_SHD = X;          //LV8   SHielD                        シールド(未実装)
//    final int W_EBT = X;          //LV8   Energy BolT                   エネルギーボルト(未実装)
//    final int W_TET = X;          //LV8   TEleporT                      テレポート(未実装)
//    final int W_IDR = X;          //LV8   Ice DaggeR                    アイスダガー(未実装)
//    final int W_WCR = X;          //LV8   Wind CutteR                   ウィンドカッター(未実装)
//    final int W_HWS = X;          //LV8   Holy WeaponS                  ホーリーウェポン(未実装)

//闇の精霊魔法  9+5+5+5=24  合計24種類
    //LV4魔法    合計9種類
    final int D_AVR = 119;          //LV85  AVengeR                       アベンジャー(未実装)
    final int D_SHS = 120;          //LV80  SHadow Step                   [UP待ち]シャドウステップ(未実装)
    final int D_ABK = 121;          //LV80  Armor BreaK                   アーマーブレイク(未実装)
    final int D_LUR = 122;          //LV80  LUcifeR                       ルシファー(未実装)
    final int D_MAM = 173;          //LV85  Moving Acceleration:Maximum   [UP待ち]ムービングアクセレーション:マキシマム
    final int D_SAD = 174;          //LV85  Shadow Armor:Destiny          シャドウアーマー:デスティニー
    final int D_LUD = 123;          //LV85  LUcifer:Destiny               ルシファー:デスティニー(未実装)
    final int D_ABD = 124;          //LV85  Armor Break:Destiny           アーマーブレイク:デスティニー(未実装)
    final int D_DBD = 28;           //LV80  Double Break:Destiny          ダブルブレイク:デスティニー

    //LV3魔法    合計5種類
    final int D_DBK = 29;           //LV60  Double BreaK                  ダブルブレイク
    final int D_UDE = 32;           //LV60  Uncanny DodgE                 アンキャニードッジ
    final int D_SFG = 175;          //LV60  Shadow FanG                   シャドウファング(基本エンチャントのキャラ/武器で実装)
    final int D_FBN = 103;          //LV60  Final BurN                    ファイナルバーン
    final int D_DEN = 31;           //LV60  Dress EvasioN                 ドレスイベイジョン

    //LV2魔法    合計5種類
    final int D_MAN = 79;           //LV40  Moving AcceleratioN           ムービングアクセレーション(未実装)
    final int D_BSS = 30;           //LV40  Burning SpiritS               バーニングスピリッツ
    final int D_SSP = 176;          //LV40  Shadow SleeP                  シャドウスリープ(未実装)
    final int D_VRT = 80;           //LV40  Venom ResisT                  ベノムレジスト(未実装)
    final int D_DDY = 177;          //LV40  Dress Dexterity               ドレスデクスタリティー

    //LV1魔法    合計5種類
    final int D_BHG = 178;          //LV20  Blind HidinG                  ブラインドハイディング(未実装)
    final int D_EVM = 179;          //LV20  Enchantment VenoM             エンチャントベノム(未実装)
    final int D_BRE = 180;          //LV20  BRingstonE                    ブリングストーン(未実装)
    final int D_SAR = 33;           //LV20  Shadow ArmoR                  シャドウアーマー
    final int D_DMY = 181;          //LV20  Dress MightY                  ドレスマイティー

//竜騎士の秘技    合計22種類
    //LV4魔法
    final int R_HAS = 116;          //LV85  HAlpaS                        ハルパス
    final int R_SNE = 181;          //LV80  Solid NotE                    [UP待ち]ソリッドノート
    final int R_RAE = 182;          //LV80  RAmpagE                       [UP待ち]ランペイジ
    final int R_AUA = 117;          //LV80  AUrakiA                       アウラキア
    final int R_TGB = 183;          //LV80  Thunder Grap:Brave            サンダーグラップ:ブレイブ
    final int R_FSB = 60;           //LV85  Four Slayer:Brave             フォースレイヤー:ブレイブ(未実装)
    final int R_LINDVIOL = 90;      //LV80  Arousal[LINDVIOL]             覚醒[リンドビオル]

    //LV3魔法
    final int R_MBY = 38;           //LV60  Mortal BodY                   モータルボディー
    final int R_TGP = 184;          //LV60  Thunder GraP                  サンダーグラップ
    final int R_DHR = 185;          //LV60  Destroy:HorroR                デストロイ:ホラー
    final int R_EOD = 186;          //LV60  Eye Of Dragon                 アイオブドラゴン
    final int R_VALAKAS = 41;       //LV60  Arousal[VALAKAS]              覚醒[ヴァラカス]

    //LV2魔法
    final int R_BLT = 187;          //LV40  Blood LasT                    ブラッドラスト(基本エンチャントの2段加速で実装)
    final int R_FSR = 188;          //LV40  Four SlayeR                   フォースレイヤー
    final int R_DFR = 189;          //LV40  Destroy:FeaR                  デストロイ:フィアー
    final int R_MAW = 190;          //LV40  Magma ArroW                   マグマアロー
    final int R_FAFURION = 40;      //LV40  Arousal[FAFURION]             覚醒[パプリオン](未実装)

    //LV1魔法
    final int R_DSN = 37;           //LV20  Dragon SkiN                   ドラゴンスキン
    final int R_BSH = 191;          //LV20  Burning SlasH                 バーニングスラッシュ
    final int R_DEY = 192;          //LV20  DEstroY                       デストロイ
    final int R_MBH = 193;          //LV20  Magma BreatH                  マグマブレス
    final int R_ANTHARAS = 39;      //LV20  Arousal[ANTHARAS]             覚醒[アンタラス]

//イリュージョニストの幻術魔法    合計26種類
    //LV5魔法
    final int I_POL = 118;          //LV85  POtentiaL                     ポテンシャル
    final int I_BBR = 194;          //LV85  Bone BreaK:Raster             ボーンブレイク:ラスタ
    final int I_MES = 195;          //LV85  MEviuS                        メビウス
    final int I_IMT = 92;           //LV80  IMpacT                        インパクト
    final int I_DHE = 196;          //LV80  Dark HorsE                    ダークホース(基本エンチャントの2段加速で実装)
    final int I_FSZ = 91;           //LV75  Focus SpitZ                   フォーカススピッツ

    //LV4魔法             
    final int I_INS = 46;           //LV60  INsighT                       インサイト
    final int I_PAC = 197;          //LV60  PAniC                         パニック
    final int I_RWT = 62;           //LV60  Reduce WeighT                 リデュースウェイト
    final int I_IAR = 45;           //LV60  Illusion[AvataR]              イリュージョン[アバター]
    final int I_CAR = 198;          //LV60  Cube[AvataR]                  キューブ[アバター]

    //LV3魔法     
    final int I_PAE = 47;           //LV45  PAtiencE                      ペイシェンス
    final int I_PHM = 199;          //LV45  PHantasM                      ファンタズム
    final int I_IBR = 200;          //LV45  Ices BreakeR                  アイズブレイカー
    final int I_IGM = 44;           //LV45  Illusion[GoleM]               イリュージョン[ゴーレム]
    final int I_CRH = 201;          //LV45  Cube[RicH]                    キューブ[リッチ]

    //LV2魔法 
    final int I_CON = 48;           //LV30  COncentratioN                 コンセントレーション
    final int I_MBK = 202;          //LV30  Mind BreaK                    マインドブレイク
    final int I_BBK = 203;          //LV30  Bone BreaK                    ボーンブレイク
    final int I_IRH = 43;           //LV30  Illusion[RicH]                イリュージョン[リッチ]
    final int I_CGM = 204;          //LV30  Cube[GoleM]                   キューブ[ゴーレム]

    //LV1魔法 
    final int I_MIE = 49;           //LV15  Mirror ImagE                  ミラーイメージ
    final int I_CFN = 205;          //LV15  ConFusioN                     コンフュージョン
    final int I_SEY = 206;          //LV15  Smash EnergY                  スマッシュエネルギー
    final int I_IOE = 42;           //LV15  Illusion[OgrE]                イリュージョン[オーガ]
    final int I_COE = 207;          //LV15  Cube[OgrE]                    キューブ[オーガ]

//ウォリアーの技術    合計16種類
    //アクティブスキル
    final int S_DEN = 208;          //LV85  DEmolitioN                    デモリッション
    final int S_BEK = 209;          //LV85  BErserK                       バーサーク
    final int S_DEO = 210;          //LV80  DEsperadO                     デスペラード
    final int S_TRG = 115;          //LV80  Titan RisinG                  タイタンライジング
    final int S_PGP = 211;          //LV75  Power GriP                    パワーグリップ
    final int S_GIC = 76;           //LV60  GIgantiC                      ギガンティック
    final int S_TOK = 212;          //LV45  TOmahawK                      トマホーク
    final int S_HOL = 213;          //LV30  HOwL                          ハウル

    //パッシブスキル
    final int S_TLK = 69;           //LV75  Titan Lock                    タイタンロック
    final int S_TMC = 70;           //LV75  Titan MagiC                   タイタンマジック
    final int S_TBZ = 71;           //LV80  Titan BlitZ                   タイタンブリッツ
    final int S_SLR = 214;          //LV15  SLayeR                        スレイヤー
    final int S_CRH = 67;           //LV45  CRasH                         クラッシュ
    final int S_AGD = 66;           //LV60  Armor GuarD                   アーマーガード
    final int S_FUY = 68;           //LV60  FUrY                          フューリー
    final int S_DAE = 215;          //LV85  Desperado:AbsolutE            デスペラード:アブソリュート

//フェンサーの技術    合計19種類
    //  アクティブスキル
    final int F_PPH = 216;          //LV80  Phantom:DeatH                 ファントム:デス
    final int F_AAA = 217;          //LV85  AshurA                        アシュラ
    final int F_ABE = 218;          //LV60  BladE                         ブレード
    final int F_APA = 219;          //LV75  Pantera                       パンテラ
    final int F_AJT = 220;          //LV80  JudgmenT                      ジャッジメント
    final int F_AHE = 221;          //LV70  HellfirE                      ヘルファイア
    final int F_APM = 222;          //LV70  PhantoM                       ファントム

    //  パッシブスキル
    final int F_PPR = 223;          //LV80  Phantom:ReapeR                ファントム:リーパー
    final int F_PPK = 224;          //LV80  Pantera:ShocK                 パンテラ:ショック
    final int F_PSE = 225;          //LV70  SurvivE                       サヴァイヴ
    final int F_PIZ = 104;          //LV75  Infinity:BlitZ                インフィニティ:ブリッツ
    final int F_PPX = 226;          //LV75  ParadoX                       パラドックス
    final int F_PIE = 105;          //LV70  Infinity:DodgE                インフィニティ:ドッジ
    final int F_PGE = 227;          //LV60  GrousE                        グロース
    final int F_PID = 106;          //LV60  Infinity:BlooD                インフィニティ:ブラッド
    final int F_PRE = 107;          //LV60  RagE                          レイジ
    final int F_PIR = 108;          //LV45  Infinity:ArmoR                インフィニティ:アーマー
    final int F_PFE = 109;          //LV45  FramE                         フレイム
    final int F_PDS = 125;          //LV45  DamascuS                      ダマスカス

//ランサーの槍術    合計14種類
    //  アクティブスキル
    final int L_PDR = 140;          //LV85  Pressure:Death Recall         プレッシャー:デスリコール
    final int L_REY = 130;          //LV75  REcoverY                      リカバリー
    final int L_KUU = 132;          //LV80  KUruorU                       クルオル
    final int L_PRE = 131;          //LV75  PRessurE                      プレッシャー
    final int L_VAD = 129;          //LV70  VAnguarD                      ヴァンガード
    final int L_FWE = 128;          //LV60  Force WavE                    フォースウェーブ
    final int L_ALE = 127;          //LV50  ALternatE                     オルタネート

    //  パッシブスキル
    final int L_KCN = 139;          //LV80  Kuruoru:CombinatioN           クルオル:コンビクション
    final int L_IRE = 138;          //LV80  Increase RangE                インクリーズレンジ
    final int L_MAM = 137;          //LV75  MAelstroM                     マエルストローム
    final int L_DBE = 136;          //LV75  Dodge BrakE                   ドッジブレーキ
    final int L_VEE = 134;          //LV70  VEngeancE                     ベンジェンス
    final int L_TAE = 135;          //LV70  Tactical AdvancE              タクティカルアドバンス
    final int L_DSE = 133;          //LV65  Deadly StrikE                 デッドリーストライク

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

    final String[] AILMENT_LIST = {"技術命中", "技術耐性", "精霊命中", "精霊耐性", "秘技命中","秘技耐性", "恐怖命中", "恐怖耐性"};
//    final String[] AILMENT_LIST = {"技術", "技術", "精霊", "精霊", "秘技","秘技", "恐怖", "恐怖"};
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
    String[] EQ_EN_LIST = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
        "9", "10", "11", "12", "13", "14", "15"};

//属性強化
    String[] EQ_ELEM_LIST = {"無属性", "地霊:1段", "地霊:2段", "地霊:3段", "地霊:4段",
        "地霊:5段", "火霊:1段", "火霊:2段", "火霊:3段", "火霊:4段", "火霊:5段", "水霊:1段",
        "水霊:2段", "水霊:3段", "水霊:4段", "水霊:5段", "風霊:1段", "風霊:2段", "風霊:3段",
        "風霊:4段", "風霊:5段"};

//Tシャツの強化値
    String[] EQ_TS_LIST = {"0段階", "1段階", "2段階", "3段階", "4段階", "5段階"};
}
