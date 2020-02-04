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

    //9種の職業
    final String[] CLASS_LIST = {"P", "K", "E", "W", "D", "R", "I", "S", "F"};
    final String[] CLASS_LIST2 = {"君主", "ナイト", "エルフ", "ウィザード", "ダークエルフ", "ドラゴンナイト", "イリュージョニスト", "ウォリアー", "フェンサー"};
    final int P = 0;
    final int K = 1;
    final int E = 2;
    final int W = 3;
    final int D = 4;
    final int R = 5;
    final int I = 6;
    final int S = 7;
    final int F = 8;

    //4種の属性
    final String[] ELEM_LIST = {"地", "火", "水", "風"};
    final int EARTH = 0;
    final int FIRE = 1;
    final int WATER = 2;
    final int WIND = 3;

    //13種の武器
    final String[] BUKI_TYPE_LIST = {"ダガー", "片手剣", "両手剣", "スタッフ", "鈍器",
        "デュアルブレード", "クロウ", "槍", "ボウ", "ガントレット", "キーリンク", "チェーンソード", "双斧"};
    final int W_D = 0;
    final int W_LS = 1;
    final int W_TS = 2;
    final int W_S = 3;
    final int W_A = 4;
    final int W_DB = 5;
    final int W_C = 6;
    final int W_L = 7;
    final int W_B = 8;
    final int W_G = 9;
    final int W_K = 10;
    final int W_CS = 11;
    final int W_DA = 12;
    
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
    final int L99 = 14;         //Hero用

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

//エンチャント(0から103までの合計104個分)　UI.javaの217行目も合わせて変更必須
//仮設定で119までの120個で処理
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

//君主の魔法 合計10種類
    final int P_PRE = 110;          //PRimE                         プライム
//    final int P_EME = X;          //EMpirE                        エンパイア(未実装)
    final int P_GRE = 87;           //GRacE                         グレース(グレースアバター)
    final int P_AUA = 59;           //AUrA                          オーラ(ブレイブアバター)
    final int P_MAY = 100;          //MAjestY                       マジェスティ
    final int P_SAR = 99;           //Shining ArmoR                 シャイニングアーマー
    final int P_SSD = 9;            //Shining ShielD                シャイニングシールド
    final int P_BML = 8;            //Brave MentaL                  ブレイブメンタル
    final int P_GWN = 7;            //Glowing WeapoN                グローイングウェポン
//    final int P_TTT = X;          //True TargeT                   トゥルーターゲット(未実装)

//ナイトの技術
    //アクティブスキル
//    final int K_FSN = X;          //Force StaN                    フォーススタン(未実装)
//    final int K_ABE = X;          //Absolute BladE                アブソルートブレイド(未実装)
    final int K_CBR = 36;           //Counter BarrieR               カウンターバリア(未実装)
    final int K_BLK = 89;           //BLow attacK                   ブローアタック
    final int K_BOK = 65;           //BOunce attacK                 バウンスアタック
//    final int K_SSN = X;          //Shock StaN                    ショックスタン(未実装)
    final int K_PRE = 88;           //PRidE                         プライド
    final int K_SCE = 35;           //Solid CarriagE                ソリッドキャリッジ
    final int K_RAR = 34;           //Reduction ArmoR               リダクションアーマー
    //パッシブスキル
    final int K_CBV = 73;           //Counter Barrier:Veteran       カウンターバリア:ベテラン
    final int K_RFE = 111;          //Raging ForcE                  レイジングフォース
    final int K_RAV = 112;          //Reduction Armor:Veteran       リダクションアーマー:ベテラン

//エルフの精霊魔法
    //共通
//    final int E_MAE = X;          //MArblE                        マーブル(未実装)
//    final int E_GEH = X;          //Glory EartH                   グローリーアース(未実装)
//    final int E_SBR = X;          //Seoul BarrieR                 ソウルバリア(未実装)
//    final int E_ASE = X;          //Area SilencE                  エリアサイレンス(未実装)
    final int E_ELY = 57;           //ELvengravitY                  エルヴングラヴィティー
//    final int E_GEL = X;          //Greater ElementaL             グレーターエレメンタル(未実装)
//    final int E_EMC = X;          //Erase MagiC                   イレースマジック(未実装)
//    final int E_EFN = X;          //Elemental FalldowN            エレメンタルフォールダウン(未実装)
//    final int E_SLE = X;          //Summon Lesser Elemental       サモンレッサーエレメンタル(未実装)
//    final int E_TAW = X;          //Triple ArroW                  トリプルアロー(未実装)
//    final int E_BSL = X;          //Bloody SouL                   ブラッディソウル(未実装)
//    final int E_EPN = X;          //Elemental ProtectioN          エレメンタルプロテクション(未実装)
    final int E_RET = 19;           //Resist ElemenT                レジストエレメント
    final int E_CMD = 12;           //Clear MinD                    クリアマインド
//    final int E_TTM = X;          //Teleport To Mother            テレポートトゥマザー(未実装)
//    final int E_BTM = X;          //Body To Mind                  ボディトゥマインド(未実装)
    final int E_RMC = 20;           //Resist MagiC                  レジストマジック

    //火系列
    final int E_INO = 86;           //INfernO                       インフェルノ(未実装)
    final int E_SOF = 15;           //Soul Of Flame                 ソウルオブフレイム
    final int E_AFE = 23;           //Additional FirE               アディショナルファイヤー
    final int E_EFE = 11;           //Elemental FirE                エレメンタルファイアー
    final int E_BWN = 17;           //Burning WeapoN                バーニングウェポン
//    final int E_DBE = X;          //Dancing BlazE                 ダンシングブレイズ(基本エンチャントの2段加速で実装)
//    final int E_FSD = X;          //Fire ShielD                   ファイアーシールド(基本エンチャントのACで実装)

    //水系列
//    final int E_PWR = X;          //Pollute WateR                 ポルートウォーター(未実装)
//    final int E_NBG = X;          //Natures BlessinG              ネイチャーズブレッシング(未実装)
//    final int E_FWE = X;          //Focus WavE                    フォーカスウェーブ(基本エンチャントの2段加速で実装)
    final int E_APR = 21;           //Aqua ProtectoR                アクアプロテクター
    final int E_NTH = 16;           //Natures ToucH                 ネイチャーズタッチ
//    final int E_WLE = X;          //Water LifE                    ウォーターライフ(未実装)
    final int E_AST = 10;           //Aqua ShoT                     アクアショット

    //風系列
//    final int E_SGL = X;          //Striker GaiL                  ストライカーゲイル(未実装)
//    final int E_HUE = X;          //HUrricanE                     ハリケーン(基本エンチャントの2段加速で実装)
    final int E_CYE = 85;           //CYclonE                       サイクロン
    final int E_SST = 14;           //Storm ShoT                    ストームショット
    final int E_SEE = 13;           //Storm EyE                     ストームアイ
    final int E_EEE = 84;           //Eagle EyE                     イーグルアイ

    //地系列
//    final int E_XX = X;           //Earth BinD                    アースバインド(未実装)
    final int E_EVE = 22;           //Exotic VitalizE               エキゾチックバイタライズ
//    final int E_XX = X;           //Iron SkiN                     アイアンスキン(未実装)
//    final int E_XX = X;           //Sand StorM                    サンドストーム(基本エンチャントの2段加速で実装)
    final int E_EGN = 61;           //Earth GuardiaN                アースガーディアン
    final int E_QUE = 81;           //QUakE                         クエイク
    final int E_EWN = 18;           //Earth WeapoN                  アースウェポン

//ウィザードの魔法
    //LV10魔法
    final int W_ADS = 24;           //アドバンスドスピリッツ

    //LV9魔法

    //LV8魔法
    
    //LV7魔法
    final int W_FA = 102;           //フリージングアーマー
    final int W_BSK = 25;           //バーサーカー
    final int W_EA = 101;           //エンチャントアキュラシー

    //LV6魔法

    //LV5魔法

    //LV4魔法

    //LV3魔法
    final int W_BA = 27;            //ブレスドアーマー

    //LV2魔法
    final int W_DW = 26;            //ディクリースウェイト

    //LV1魔法

//ダークエルフの闇の精霊魔法
    //LV4魔法
    final int D_DB2 = 28;       //ダブルブレイク:デスティニー

    //LV3魔法
    final int D_DB = 29;        //ダブルブレイク
    final int D_UD = 32;        //アンキャニードッジ
    final int D_FB = 103;       //ファイナルバーン
    final int D_DE = 31;        //ドレスイベイジョン
    
    //LV2魔法
    final int D_MA = 79;        //ムービングアクセレーション(未実装)
    final int D_BS = 30;        //バーニングスピリッツ
    final int D_VR = 80;        //ベノムレジスト(未実装)

    //LV1魔法
    final int D_SA = 33;        //シャドウアーマー

//ドラゴンナイトの秘技
    //LV4魔法
    final int R_LINDVIOL = 90;  //覚醒[リンドビオル]
    final int R_FS2 = 60;       //フォースレイヤー:ブレイブ(未実装)

    //LV3魔法
    final int R_MB = 38;        //モータルボディー
    final int R_VALAKAS = 41;   //覚醒[ヴァラカス]

    //LV2魔法
    final int R_FAFURION = 40;  //覚醒[パプリオン](未実装)

    //LV1魔法
    final int R_DS = 37;        //ドラゴンスキン
    final int R_ANTHARAS = 39;  //覚醒[アンタラス]

//イリュージョニストの幻術魔法
    //LV5魔法
    final int I_IT = 92;        //インパクト
    final int I_FS = 91;        //フォーカススピッツ

    //LV4魔法             
    final int I_INS = 46;       //インサイト
    final int I_RW = 62;        //リデュースウェイト
    final int I_IA = 45;        //幻術[アバター]

    //LV3魔法     
    final int I_PAT = 47;       //ペイシェンス
    final int I_ID = 44;        //幻術[ダイアゴーレム]

    //LV2魔法 
    final int I_CON = 48;       //コンセントレーション
    final int I_IR = 43;        //幻術[リッチ]

    //LV1魔法 
    final int I_MI = 49;        //ミラーイメージ
    final int I_IO = 42;        //幻術[オーガ]

//ウォリアーの技術
    //アクティブスキル
    final int S_G = 76;         //ギガンティック

    //パッシブスキル
    final int S_TL = 69;        //タイタンロック
    final int S_TM = 70;        //タイタンマジック
    final int S_TB = 71;        //タイタンブリッツ     
    final int S_CR = 67;        //クラッシュ
    final int S_AG = 66;        //アーマーガード
    final int S_FU = 68;        //フューリー

//フェンサーの技術
//  アクティブスキル
//    final int F_AAA = XXX;      //AshurA            アシュラ
//    final int F_ABE = XXX;      //BladE             ブレード
//    final int F_APA = XXX;      //Pantera           パンテラ
//    final int F_AJT = XXX;      //JudgmenT          ジャッジメント
//    final int F_AHE = XXX;      //HellfirE          ヘルファイア
//    final int F_APM = XXX;      //PhantoM           ファントム
//  パッシブスキル
//    final int F_PPH = XXX;      //Phantom:DeatH     ファントム:デス
//    final int F_PPR = XXX;      //Phantom:ReapeR    ファントム:リーパー
//    final int F_PPK = XXX;      //Panther:ShocK     パンサー:ショック
//    final int F_PSE = XXX;      //SurvivE           サヴァイヴ
    final int F_PIZ = 104;      //Infinity:BlitZ    インフィニティ:ブリッツ
//    final int F_PPX = XXX;      //ParadoX           パラドックス
    final int F_PIE = 105;      //Infinity:DodgE    インフィニティ:ドッジ
//    final int F_PGH = XXX;      //GrowtH            グロース
    final int F_PID = 106;      //Infinity:BlooD    インフィニティ:ブラッド
    final int F_PRE = 107;      //RagE              レイジ
    final int F_PIR = 108;      //Infinity:ArmoR    インフィニティ:アーマー
    final int F_PFE = 109;      //FramE             フレイム
//    final int F_PDS = XXX;      //DamascuS          ダマスカス

//その他
    final int ITEM_BLUE = 50;   //魔力回復ポーション
    final int ITEM_WIZP = 51;   //ウィズダムポーション
    final int ITEM_COOKING = 54;//料理
    final int ITEM_DESSERT = 55;//デザート
    final int ITEM_BREEZE = 52; //潮風の力
    final int ITEM_SEA = 53;    //深海の力
    final int ITEM_MD = 56;     //マジックドール
    final int ITEM_MD_OP = 64;  //パック/パオ OP
    final int KOMA = 58;        //コマのエンチャ
    final int ITEM_MAGAN = 98;  //魔眼
    final int CLAY = 77;        //クレイ
    final int MOMIJI = 78;      //もみじリング
    final int BUFF_COIN = 63;   //バフコイン
    final int BS_COIN = 82;     //黒蛇のコイン
    final int MBSC = 74;        //真心のこもった祝福スクロール
    final int L_HST = 83;       //成長の果実
    final int H_HP = 93;        //生命のボーナス
    final int H_AC = 94;        //鉄甲のボーナス
    final int H_PVPDR = 95;     //生存のボーナス
    final int H_PVP = 96;       //暗殺のボーナス
    final int H_RK = 97;        //ランカーボーナス
    
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
    String[] EQ_ELEM_LIST = {"無属性", "火霊:1段", "火霊:2段", "火霊:3段", "火霊:4段",
        "火霊:5段", "水霊:1段", "水霊:2段", "水霊:3段", "水霊:4段", "水霊:5段", "風霊:1段",
        "風霊:2段", "風霊:3段", "風霊:4段", "風霊:5段", "地霊:1段", "地霊:2段", "地霊:3段",
        "地霊:4段", "地霊:5段"};

//Tシャツの強化値
    String[] EQ_TS_LIST = {"0段階", "1段階", "2段階", "3段階", "4段階", "5段階"};
}
