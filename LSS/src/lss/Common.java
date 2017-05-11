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

    final String[] ELEM_LIST = {"火", "水", "風", "地"};
    final int FIRE = 0;
    final int WATER = 1;
    final int WIND = 2;
    final int EARTH = 3;

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
    final int L85 = 13;

    final String[] EQ_LIST = {"武器", "武器", "シールド", "ヘルム", "グローブ", "シャツ",
        "アーマー", "クローク", "ブーツ", "ゲートル", "ベルト", "イアリング", "イアリング", "アミュレット", "リング", "リング",
        "リング", "リング", "ルーン", "ルーン","ドロン","エンブレム"};

    final int RING1 = 14;
    final int RING2 = 15;
    final int RING3 = 16;
    final int RING4 = 17;

    final int EARRING1 = 11;
    final int EARRING2 = 12;

    // エンチャントのID
    final int ACC1 = 0;
    final int ACC2 = 1;
    final int ACC3 = 2;
    final int B_STR = 3;
    final int B_DEX = 4;
    final int B_AC = 5;
    final int BUKI = 6;
    final int P_G = 7;
    final int P_B = 8;
    final int P_S = 9;
    final int E_WS = 10;
    final int E_EF = 11;
    final int E_CM = 12;
    final int E_SE = 13;
    final int E_SS = 14;
    final int E_SF = 15;
    final int E_NT = 16;
    final int E_BW = 17;
    final int E_FW = 18;
    final int E_RE = 19;
    final int E_RM = 20;
    final int E_AP = 21;
    final int E_EV = 22;
    final int E_AF = 23;
    final int W_ADS = 24;
    final int W_BSK = 25;
    final int W_DW = 26;
    final int W_BA = 27;
    final int W_I2H = 28;
    final int D_DB = 29;
    final int D_BS = 30;
    final int D_DE = 31;
    final int D_UD = 32;
    final int D_SA = 33;
    final int K_RA = 34;
    final int K_SC = 35;
    final int K_CB = 36;
    final int R_DS = 37;
    final int R_MB = 38;
    final int R_ANTHARAS = 39;
    final int R_FAFURION = 40;
    final int R_VALAKAS = 41;
    final int I_IO = 42;
    final int I_IR = 43;
    final int I_ID = 44;
    final int I_IA = 45;
    final int I_INS = 46;
    final int I_PAT = 47;
    final int I_CON = 48;
    final int I_MI = 49;
    final int ITEM_BLUE = 50;
    final int ITEM_WIZP = 51;
    final int ITEM_BREEZE = 52;
    final int ITEM_SEA = 53;
    final int ITEM_COOKING = 54;
    final int ITEM_DESSERT = 55;
    final int ITEM_MD = 56;
    final int DRAGON = 57;
    final int KOMA = 58;
    final int P_BA = 59;
    final int E_DB = 60;
    final int E_EG = 61;
    final int I_RW = 62;
    final int WAR = 63;
    final int ITEM_MD_OP = 64;
    final int K_BA = 65;
    final int F_AG = 66;
    final int F_CR = 67;
    final int F_FU = 68;
    final int F_TL = 69;
    final int F_TM = 70;
    final int F_TB = 71;
    final int VIP = 72;
    final int COIN = 73;
    final int BS = 74;
    final int SEC = 75;
    final int F_G = 76;
    final int CLAY = 77;
    final int ITEM_MD2 = 78;

    final int D_MA = 79;
    final int D_VR = 80;

    final int E_WW = 81;

    final int BS_COIN = 82;
    final int L_HST = 83;

    final String[] AILMENT_LIST = {"石化", "睡眠", "凍結", "暗闇", "気絶", "拘束", "恐怖"};
    final int STONE = 0;
    final int SLEEP = 1;
    final int FREEZE = 2;
    final int DARKNESS = 3;
    final int STUN = 4;
    final int HOLD = 5;
    final int TERROR = 6;

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
