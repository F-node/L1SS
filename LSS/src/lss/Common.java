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
    
    final String[] ST_LIST = {"STR", "DEX", "CON", "INT", "WIS", "CHA"};
    final int STR = 0;
    final int DEX = 1;
    final int CON = 2;
    final int INT = 3;
    final int WIS = 4;
    final int CHA = 5;

    final String[] CLASS_LIST = {"P", "K", "E", "W", "D", "R", "I", "F"};
    final String[] CLASS_LIST2 = {"君主", "ナイト", "エルフ", "ウィザード", "ダークエルフ", "ドラゴンナイト", "イリュージョニスト", "ウォリアー"};
    final int P = 0;
    final int K = 1;
    final int E = 2;
    final int W = 3;
    final int D = 4;
    final int R = 5;
    final int I = 6;
    final int F = 7;

    //final String[] ELEM_LIST = {"火", "水", "風", "地"};
    final String[] ELEM_LIST = {"地", "火", "水", "風"};
    final int EARTH = 0;
    final int FIRE = 1;
    final int WATER = 2;
    final int WIND = 3;

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

    //final String[] EQ_LIST = {"武器", "武器", "シールド", "ヘルム", "グローブ", "シャツ",
    //    "アーマー", "クローク", "ブーツ", "ゲートル", "ベルト", "イアリング", "イアリング", "アミュレット", "リング", "リング",
    //    "リング", "リング", "ルーン", "ルーン","ドロン","エンブレム"};
    //パネル1のアミュレット、イアリングの入力位置の変更及びルーン、ドロン、エンブレムの順を変更
    final String[] EQ_LIST = {"武器", "武器", "シールド", "ヘルム", "グローブ", "シャツ",
        "アーマー", "クローク", "ブーツ", "ゲートル", "ベルト", "アミュレット", "イアリング", "イアリング", "リング", "リング",
        "リング", "リング", "インシグニア", "スポールダー","紋章"};
    
    final int RING1 = 14;
    final int RING2 = 15;
    final int RING3 = 16;
    final int RING4 = 17;

    final int EARRING1 = 11;
    final int EARRING2 = 12;

    // エンチャントのID
    final int ACC1 = 0;         //1段加速
    final int ACC2 = 1;         //2段加速
    final int ACC3 = 2;         //3段加速
    final int B_STR = 3;        //STR
    final int B_DEX = 4;        //DEX
    final int B_AC = 5;         //AC
    final int BUKI = 6;         //武器エンチャ魔法
    final int P_G = 7;          //グローイングウエポン
    final int P_B = 8;          //ブレイブメンタル
    final int P_S = 9;          //シャイニングシールド 
    final int E_AS = 10;        //アクアショット
    final int E_EF = 11;        //エレメンタルファイアー
    final int E_CM = 12;        //クリアマインド
    final int E_SE = 13;        //ストームアイ
    final int E_SS = 14;        //ストームショット
    final int E_SF = 15;        //ソウルオブフレイム
    final int E_NT = 16;        //ネイチャーズタッチ
    final int E_BW = 17;        //バーニングウェポン
    final int E_EW = 18;        //アースウェポン
    final int E_RE = 19;        //レジストエレメント
    final int E_RM = 20;        //レジストマジック
    final int E_AP = 21;        //アクアプロテクター
    final int E_EV = 22;        //エキゾチックバイタライズ
    final int E_AF = 23;        //アディショナルファイヤー
    final int W_ADS = 24;       //アドバンスドスピリッツ
    final int W_BSK = 25;       //バーサーカー
    final int W_DW = 26;        //ディクリースウェイト
    final int W_BA = 27;        //ブレスドアーマー
    final int D_DB2 = 28;       //ダブルブレイク:デスティニー
    final int D_DB = 29;        //ダブルブレイク
    final int D_BS = 30;        //バーニングスピリッツ
    final int D_DE = 31;        //ドレスイベイジョン
    final int D_UD = 32;        //アンキャニードッジ
    final int D_SA = 33;        //シャドウアーマー
    final int K_RA = 34;        //リダクションアーマー
    final int K_SC = 35;        //ソリッドキャリッジ
    final int K_CB = 36;        //カウンターバリア
    final int R_DS = 37;        //ドラゴンスキン
    final int R_MB = 38;        //モータルボディー
    final int R_ANTHARAS = 39;  //覚醒[アンタラス]
    final int R_FAFURION = 40;  //覚醒[パプリオン]******************未実装(予約分)
    final int R_VALAKAS = 41;   //覚醒[ヴァラカス]
    final int I_IO = 42;        //幻術[オーガ]
    final int I_IR = 43;        //幻術[リッチ]
    final int I_ID = 44;        //幻術[ダイアゴーレム]
    final int I_IA = 45;        //幻術[アバター]
    final int I_INS = 46;       //インサイト
    final int I_PAT = 47;       //ペイシェンス
    final int I_CON = 48;       //コンセントレーション
    final int I_MI = 49;        //ミラーイメージ
    final int ITEM_BLUE = 50;   //魔力回復ポーション
    final int ITEM_WIZP = 51;   //ウィズダムポーション
    final int ITEM_BREEZE = 52; //潮風の力
    final int ITEM_SEA = 53;    //深海の力
    final int ITEM_COOKING = 54;//料理
    final int ITEM_DESSERT = 55;//デザート
    final int ITEM_MD = 56;     //マジックドール
    final int E_EGR = 57;       //エルヴングラヴィティー
    final int KOMA = 58;        //コマのエンチャ
    final int P_BA = 59;        //ブレイブアバター
    final int R_FS2 = 60;       //フォースレイヤー:ブレイブ
    final int E_EG = 61;        //アースガーディアン
    final int I_RW = 62;        //リデュースウェイト
    final int BUFF_COIN = 63;   //バフコイン
    final int ITEM_MD_OP = 64;  //パック/パオ OP
    final int K_BA = 65;        //バウンスアタック
    final int F_AG = 66;        //アーマーガード
    final int F_CR = 67;        //クラッシュ
    final int F_FU = 68;        //フューリー
    final int F_TL = 69;        //タイタンロック
    final int F_TM = 70;        //タイタンマジック
    final int F_TB = 71;        //タイタンブリッツ
    final int VIP = 72;         //VIPエンチャント
    final int K_CB2 = 73;       //カウンターバリア:ベテラン
    final int MBSC = 74;        //真心のこもった祝福スクロール
    final int SEC = 75;         //セキュリティ
    final int F_G = 76;         //ギガンティック
    final int CLAY = 77;        //クレイ
//    final int ITEM_MD2 = 78;    //新マジックドール
    final int D_MA = 79;        //ムービングアクセレーション
    final int D_VR = 80;        //ベノムレジスト
    final int E_QE = 81;        //クエイク
    final int BS_COIN = 82;     //黒蛇のコイン
    final int L_HST = 83;       //成長の果実
    final int E_EE = 84;        //イーグルアイ
    final int E_CE = 85;        //サイクロン(未実装)
    final int E_IO = 86;        //インフェルノ(未実装)
    final int P_GA = 87;        //グレースアバター
    final int K_PD = 88;        //プライド
    final int K_BK = 89;        //ブローアタック
    final int R_LINDVIOL = 90;  //覚醒[リンドビオル]
    final int I_FS = 91;        //フォーカススピッツ
    final int I_IT = 92;        //インパクト
    final int H_HP = 93;        //生命のボーナス
    final int H_AC = 94;        //鉄甲のボーナス
    final int H_PVPDR = 95;     //生存のボーナス
    final int H_PVP = 96;       //暗殺のボーナス
    final int H_RK = 97;        //ランカーボーナス
    final int ITEM_MAGAN = 98;  //魔眼

//    final String[] AILMENT_LIST = {"石化耐性", "睡眠耐性", "凍結耐性", "暗闇耐性", "気絶耐性", "拘束耐性", "恐怖耐性","破壊耐性","石化命中", "睡眠命中", "凍結命中", "暗闇命中", "気絶命中", "拘束命中", "恐怖命中","破壊命中"};
//    final int STONE = 0;
//    final int SLEEP = 1;
//    final int FREEZE = 2;
//    final int DARKNESS = 3;
//    final int STUN = 4;
//    final int HOLD = 5;
//    final int TERROR = 6;
//    final int DESTRUCTION = 7;
//    final int HIT_STONE = 8;
//    final int HIT_SLEEP = 9;
//    final int HIT_FREEZE = 10;
//    final int HIT_DARKNESS = 11;
//    final int HIT_STUN = 12;
//    final int HIT_HOLD = 13;
//    final int HIT_TERROR = 14;
//    final int HIT_DESTRUCTION = 15;
//    final int DRAGON = 16;
//    final int HIT_DRAGON = 17;
//    final int SPIRIT = 18;
//    final int HIT_SPIRIT = 19;
    
//    final String[] AILMENT_LIST = {"技術命中", "技術耐性", "精霊命中", "精霊耐性", "秘技命中","秘技耐性", "恐怖命中", "恐怖耐性"};
    final String[] AILMENT_LIST = {"技術", "技術", "精霊", "精霊", "秘技","秘技", "恐怖", "恐怖"};
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

    String[] EQ_EN_LIST = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
        "9", "10", "11", "12", "13", "14", "15"};
    String[] EQ_ELEM_LIST = {"無属性", "火霊:1段", "火霊:2段", "火霊:3段", "火霊:4段",
        "火霊:5段", "水霊:1段", "水霊:2段", "水霊:3段", "水霊:4段", "水霊:5段", "風霊:1段",
        "風霊:2段", "風霊:3段", "風霊:4段", "風霊:5段", "地霊:1段", "地霊:2段", "地霊:3段",
        "地霊:4段", "地霊:5段"};

    String[] EQ_TS_LIST = {"0段階", "1段階", "2段階", "3段階", "4段階", "5段階"};
}
