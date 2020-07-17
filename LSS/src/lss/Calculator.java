/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

import java.awt.Color;
import java.text.DecimalFormat;
import static lss.Common.R;

/**
 *
 * @author user
 */
public class Calculator implements Common {

    private final int BASE = 0;
    private final int REM = 1;
    private final int LEVEL = 2;
    private final int ENCHANT = 3;
    private final int ELIXIR = 4;
    private final int[][] _ST = new int[5][ST_LIST.length];
    private final int[][][] _C = new int[5][ST_LIST.length][CLASS_LIST.length];

    private final int D_SHORT = 0;
    private final int H_SHORT = 1;
    private final int C_SHORT = 2;

    private final int D_LONG = 0;
    private final int H_LONG = 1;
    private final int C_LONG = 2;
    private final int AC = 3;
//    private final int DG = 0;
    private final int ER = 4;
//    private final int ME = 0;

    private final int HP = 0;
    private final int HPR = 1;
    private final int HP_POT = 2;

    private final int D_MAGIC = 0;
    private final int H_MAGIC = 1;
    private final int C_MAGIC = 2;
    private final int MB = 3;
    private final int RED_MP = 4;

    private int red_mp;
    private int red_mp2 = 0;

    private final int MP = 0;
    private final int MPR = 1;
    private final int MP_POT = 2;

    private final int MR = 3;

    int level = 1;
    private int _rem = 0;
    private final int[][][] st_data = new int[CLASS_LIST.length][2][6];
    private final int[] rem_data = new int[CLASS_LIST.length];
    private int base_dmg_short;
    private int base_dmg_long;
    private int base_dmg_magic;
    private int base_hit_short;
    private int base_hit_long;
    private int base_hit_magic;
    int hit_short;
    int hit_long;
    int hit_magic;
    private final int[] dmg_buki_ele1 = new int[ELEM_LIST.length];
    private final int[] dmg_buki_ele2 = new int[ELEM_LIST.length];

    private int mb;
    private int sp;
    private int ml;
    private int spr;
    private int int_beta;

    int dmg_element1;
    int dmg_element2;

    private int cri_short;
    private int cri_long;
    private int cri_magic;

    private int dmg_short;
    private int dmg_long;
    private int dmg_magic;

    private double dmg_small;
    private double dmg_big;
    private double dmg_cursed;
    private double dmg_undead;

    final Buki buki = new Buki();
    final Buki buki2 = new Buki();

    final Bougu bougu[] = new Bougu[EQ_LIST.length - 2];
    private int base_ac;
    private int equip_ac;
    private int base_dg;   
    private int base_er;
    private int base_me;    
//    private int base_pvp_dr;

    Buff buff;
    boolean md_dmg = false;
    int equip_pattern = 0;
    int ac;
    int dg;                                                 //近距離回避力
    int er;                                                 //遠距離回避力
    int me;                                                 //確率魔法回避力
    int mhp;                                                //最大HP+X%
    int mmp;                                                //最大MP+X%
    int mexp;                                               //獲得経験値+X%
    double enemy_hit_rate;
    int cbdmg;
    double hp;
    double mp;
    int mr;
    int cls = P;

    int res_ele[] = new int[ELEM_LIST.length];
    int res_ail[] = new int[AILMENT_LIST.length];

    double cons_mp;
    
    int dr;
    int dri;
    int pvp_dg;
    int pvp_dgr;

    DecimalFormat format_dmg = new DecimalFormat("#0.0");
    DecimalFormat format_rate = new DecimalFormat("#0.0%");
    DecimalFormat format_rate_2 = new DecimalFormat("#0.00");
    DecimalFormat format_speed = new DecimalFormat("##0.0");

    {
        for (int i = 0; i < bougu.length; i++) {
            bougu[i] = new Bougu();
        }
    }

    {
        //君主の初期ステータスと割り振り可能ステータス数
        st_data[P][BASE][STR] = 13;
        st_data[P][BASE][DEX] = 9;
        st_data[P][BASE][CON] = 11;
        st_data[P][BASE][INT] = 9;
        st_data[P][BASE][WIS] = 11;
        st_data[P][BASE][CHA] = 13;
        st_data[P][REM][STR] = 7;
        st_data[P][REM][DEX] = 9;
        st_data[P][REM][CON] = 9;
        st_data[P][REM][INT] = 9;
        st_data[P][REM][WIS] = 9;
        st_data[P][REM][CHA] = 7;
        rem_data[P] = 9;

        //ナイトの初期ステータスと割り振り可能ステータス数
        st_data[K][BASE][STR] = 16;
        st_data[K][BASE][DEX] = 12;
        st_data[K][BASE][CON] = 16;
        st_data[K][BASE][INT] = 8;
        st_data[K][BASE][WIS] = 9;
        st_data[K][BASE][CHA] = 10;
        st_data[K][REM][STR] = 4;
        st_data[K][REM][DEX] = 4;
        st_data[K][REM][CON] = 4;
        st_data[K][REM][INT] = 4;
        st_data[K][REM][WIS] = 4;
        st_data[K][REM][CHA] = 4;
        rem_data[K] = 4;

        //エルフの初期ステータスと割り振り可能ステータス数
        st_data[E][BASE][STR] = 10;
        st_data[E][BASE][DEX] = 12;
        st_data[E][BASE][CON] = 12;
        st_data[E][BASE][INT] = 12;
        st_data[E][BASE][WIS] = 12;
        st_data[E][BASE][CHA] = 9;
        st_data[E][REM][STR] = 8;
        st_data[E][REM][DEX] = 8;
        st_data[E][REM][CON] = 8;
        st_data[E][REM][INT] = 8;
        st_data[E][REM][WIS] = 8;
        st_data[E][REM][CHA] = 8;
        rem_data[E] = 8;

        //ウィザードの初期ステータスと割り振り可能ステータス数
        st_data[W][BASE][STR] = 8;
        st_data[W][BASE][DEX] = 7;
        st_data[W][BASE][CON] = 12;
        st_data[W][BASE][INT] = 14;
        st_data[W][BASE][WIS] = 14;
        st_data[W][BASE][CHA] = 8;
        st_data[W][REM][STR] = 12;
        st_data[W][REM][DEX] = 12;
        st_data[W][REM][CON] = 8;
        st_data[W][REM][INT] = 6;
        st_data[W][REM][WIS] = 6;
        st_data[W][REM][CHA] = 12;
        rem_data[W] = 12;

        //ダークエルフの初期ステータスと割り振り可能ステータス数
        st_data[D][BASE][STR] = 15;
        st_data[D][BASE][DEX] = 12;
        st_data[D][BASE][CON] = 12;
        st_data[D][BASE][INT] = 11;
        st_data[D][BASE][WIS] = 10;
        st_data[D][BASE][CHA] = 8;
        st_data[D][REM][STR] = 5;
        st_data[D][REM][DEX] = 7;
        st_data[D][REM][CON] = 7;
        st_data[D][REM][INT] = 7;
        st_data[D][REM][WIS] = 7;
        st_data[D][REM][CHA] = 7;
        rem_data[D] = 7;

        //ドラゴンナイトの初期ステータスと割り振り可能ステータス数
        st_data[R][BASE][STR] = 13;
        st_data[R][BASE][DEX] = 11;
        st_data[R][BASE][CON] = 14;
        st_data[R][BASE][INT] = 10;
        st_data[R][BASE][WIS] = 10;
        st_data[R][BASE][CHA] = 8;
        st_data[R][REM][STR] = 7;
        st_data[R][REM][DEX] = 9;
        st_data[R][REM][CON] = 6;
        st_data[R][REM][INT] = 9;
        st_data[R][REM][WIS] = 9;
        st_data[R][REM][CHA] = 9;
        rem_data[R] = 9;

        //イリュージョニストの初期ステータスと割り振り可能ステータス数
        st_data[I][BASE][STR] = 9;
        st_data[I][BASE][DEX] = 10;
        st_data[I][BASE][CON] = 12;
        st_data[I][BASE][INT] = 12;
        st_data[I][BASE][WIS] = 14;
        st_data[I][BASE][CHA] = 8;
        st_data[I][REM][STR] = 10;
        st_data[I][REM][DEX] = 10;
        st_data[I][REM][CON] = 8;
        st_data[I][REM][INT] = 8;
        st_data[I][REM][WIS] = 6;
        st_data[I][REM][CHA] = 10;
        rem_data[I] = 10;

        //ウォリアーの初期ステータスと割り振り可能ステータス数
        st_data[S][BASE][STR] = 16;
        st_data[S][BASE][DEX] = 13;
        st_data[S][BASE][CON] = 16;
        st_data[S][BASE][INT] = 10;
        st_data[S][BASE][WIS] = 7;
        st_data[S][BASE][CHA] = 9;
        st_data[S][REM][STR] = 4;
        st_data[S][REM][DEX] = 4;
        st_data[S][REM][CON] = 4;
        st_data[S][REM][INT] = 4;
        st_data[S][REM][WIS] = 4;
        st_data[S][REM][CHA] = 4;
        rem_data[S] = 4;

        //フェンサーの初期ステータスと割り振り可能ステータス数
        st_data[F][BASE][STR] = 16;
        st_data[F][BASE][DEX] = 13;
        st_data[F][BASE][CON] = 15;
        st_data[F][BASE][INT] = 11;
        st_data[F][BASE][WIS] = 11;
        st_data[F][BASE][CHA] = 5;
        st_data[F][REM][STR] = 4;
        st_data[F][REM][DEX] = 4;
        st_data[F][REM][CON] = 4;
        st_data[F][REM][INT] = 4;
        st_data[F][REM][WIS] = 4;
        st_data[F][REM][CHA] = 4;
        rem_data[F] = 4;

        //ステータスボーナス
        _C[D_SHORT][STR][P] = 30;
        _C[D_SHORT][STR][K] = 10;
        _C[D_SHORT][STR][E] = 30;
        _C[D_SHORT][STR][W] = 40;
        _C[D_SHORT][STR][D] = 10;
        _C[D_SHORT][STR][R] = 10;
        _C[D_SHORT][STR][I] = 10;
        _C[D_SHORT][STR][S] = 10;
        _C[D_SHORT][STR][F] = 10;

        _C[H_SHORT][STR][P] = 4;
        _C[H_SHORT][STR][K] = 3;
        _C[H_SHORT][STR][E] = 5;
        _C[H_SHORT][STR][W] = 6;
        _C[H_SHORT][STR][D] = 3;
        _C[H_SHORT][STR][R] = 4;
        _C[H_SHORT][STR][I] = 5;
        _C[H_SHORT][STR][S] = 3;
        _C[H_SHORT][STR][F] = 3;

        _C[C_SHORT][STR][P] = 20;
        _C[C_SHORT][STR][K] = 20;
        _C[C_SHORT][STR][E] = 24;
        _C[C_SHORT][STR][W] = 30;
        _C[C_SHORT][STR][D] = 10;
        _C[C_SHORT][STR][R] = 20;
        _C[C_SHORT][STR][I] = 30;
        _C[C_SHORT][STR][S] = 20;
        _C[C_SHORT][STR][F] = 20;

        _C[D_LONG][DEX][P] = 40;
        _C[D_LONG][DEX][K] = 40;
        _C[D_LONG][DEX][E] = 10;
        _C[D_LONG][DEX][W] = 80;
        _C[D_LONG][DEX][D] = 20;
        _C[D_LONG][DEX][R] = 40;
        _C[D_LONG][DEX][I] = 80;
        _C[D_LONG][DEX][S] = 40;
        _C[D_LONG][DEX][F] = 40;

        _C[H_LONG][DEX][P] = 6;
        _C[H_LONG][DEX][K] = 6;
        _C[H_LONG][DEX][E] = 3;
        _C[H_LONG][DEX][W] = 8;
        _C[H_LONG][DEX][D] = 4;
        _C[H_LONG][DEX][R] = 7;
        _C[H_LONG][DEX][I] = 8;
        _C[H_LONG][DEX][S] = 6;
        _C[H_LONG][DEX][F] = 6;

        _C[C_LONG][DEX][P] = 30;
        _C[C_LONG][DEX][K] = 40;
        _C[C_LONG][DEX][E] = 16;
        _C[C_LONG][DEX][W] = 50;
        _C[C_LONG][DEX][D] = 20;
        _C[C_LONG][DEX][R] = 40;
        _C[C_LONG][DEX][I] = 50;
        _C[C_LONG][DEX][S] = 40;
        _C[C_LONG][DEX][F] = 40;

        _C[ER][DEX][P] = 6;
        _C[ER][DEX][K] = 4;
        _C[ER][DEX][E] = 6;
        _C[ER][DEX][W] = 10;
        _C[ER][DEX][D] = 4;
        _C[ER][DEX][R] = 5;
        _C[ER][DEX][I] = 9;
        _C[ER][DEX][S] = 4;
        _C[ER][DEX][F] = 4;

        _C[D_MAGIC][INT][P] = 40;
        _C[D_MAGIC][INT][K] = 40;
        _C[D_MAGIC][INT][E] = 30;
        _C[D_MAGIC][INT][W] = 10;
        _C[D_MAGIC][INT][D] = 40;
        _C[D_MAGIC][INT][R] = 40;
        _C[D_MAGIC][INT][I] = 25;
        _C[D_MAGIC][INT][S] = 40;
        _C[D_MAGIC][INT][F] = 40;

        _C[H_MAGIC][INT][P] = 20;
        _C[H_MAGIC][INT][K] = 100;
        _C[H_MAGIC][INT][E] = 16;
        _C[H_MAGIC][INT][W] = 8;
        _C[H_MAGIC][INT][D] = 24;
        _C[H_MAGIC][INT][R] = 18;
        _C[H_MAGIC][INT][I] = 12;
        _C[H_MAGIC][INT][S] = 100;
        _C[H_MAGIC][INT][F] = 100;

        _C[C_MAGIC][INT][P] = 80;
        _C[C_MAGIC][INT][K] = 100;
        _C[C_MAGIC][INT][E] = 30;
        _C[C_MAGIC][INT][W] = 2;
        _C[C_MAGIC][INT][D] = 30;
        _C[C_MAGIC][INT][R] = 70;
        _C[C_MAGIC][INT][I] = 20;
        _C[C_MAGIC][INT][S] = 100;
        _C[C_MAGIC][INT][F] = 100;

        _C[MB][INT][P] = 0;
        _C[MB][INT][K] = 0;
        _C[MB][INT][E] = 0;
        _C[MB][INT][W] = 1;
        _C[MB][INT][D] = 0;
        _C[MB][INT][R] = 0;
        _C[MB][INT][I] = 1;
        _C[MB][INT][S] = 0;
        _C[MB][INT][F] = 0;

        _C[HP][CON][P] = 11;
        _C[HP][CON][K] = 16;
        _C[HP][CON][E] = 9;
        _C[HP][CON][W] = 6;
        _C[HP][CON][D] = 10;
        _C[HP][CON][R] = 12;
        _C[HP][CON][I] = 8;
        _C[HP][CON][S] = 16;
        _C[HP][CON][F] = 16;

        _C[MR][WIS][P] = 10;
        _C[MR][WIS][K] = 0;
        _C[MR][WIS][E] = 25;
        _C[MR][WIS][W] = 15;
        _C[MR][WIS][D] = 10;
        _C[MR][WIS][R] = 18;
        _C[MR][WIS][I] = 20;
        _C[MR][WIS][S] = 0;
        _C[MR][WIS][F] = 0;
    }

    private final UI ui;
    Morph polymorph = new Morph();
    private double acc = 1.0;
    // 一段加速(GP GGP ワイン ウイスキー)
    double acc_1 = 1.3333;
    // 二段加速(BP イビルブラッド ブラッドラスト 名誉のコイン ダンシングブレイズ フォーカスウェーブ ハリケーン サンドストーム)
    double acc_2 = 1.3333;
    // 二段加速(EW 濃縮集中ポーション)
    double acc_ew = 1.1547;
    // 二段加速(ダークホース)
    double acc_df = 1.0800;
    // 三段加速(ドラゴンブラッド 蔵出し秘蔵酒)
    double acc_3 = 1.125;
    // キー入力ディレイ
    double key_delay = 0.1815;

    double ce_rate = 0.0500;    //サイクロンの確率5%
    double bk_rate = 0.0500;    //ブローアタックの確率5%
    double bs_rate = 0.3333;    //バーニングスピッツの確率33%
    double db_rate = 0.3333;    //ダブルブレイクの確率33%
    double ef_rate = 0.4000;    //エレメンタルファイアーの確率40%
    double qe_rate = 0.4000;    //クエイクの確率40%
    double pb_rate = 0.4000;    //ブレイブメンタルの確率40% 

    public Calculator(UI ui) {
        this.ui = ui;
        rem_reset();
    }

    void update() {

        if (cls != ui.cb_cls.getSelectedIndex()) {
            cls = ui.cb_cls.getSelectedIndex();
            rem_reset();

            ui.cb_magic.removeAllItems();
            ui.cb_magic.addItem("");
            ui.cb_magic.setSelectedIndex(0);

            if (cls == E) {
                ui.cb_magic.addItem("トリプルアロー");
                ui.cb_magic.addItem("サンバースト");
                ui.cb_magic.addItem("コーンオブコールド");
                ui.cb_magic.addItem("イラプション");
                ui.cb_magic.addItem("コールライトニング");
            }
            if (cls == R) {
                ui.cb_magic.addItem("フォースレイヤー");
            }
            if (cls == W) {
                ui.cb_magic.addItem("サンバースト");
                ui.cb_magic.addItem("コーンオブコールド");
                ui.cb_magic.addItem("イラプション");
                ui.cb_magic.addItem("コールライトニング");
            }
        }

        level = ui.cb_lev.getSelectedIndex() + 1;
        ui.lev.level = level;

        for (int i = 0; i < 6; i++) {
            _ST[LEVEL][i] = 0;
            _ST[ELIXIR][i] = 0;
        }
        for (int i = 0; i < 10; i++) {
            int st = ui.cb_elixir[i].getSelectedIndex() - 1;
            if (st >= 0) {
                if (ui.cb_elixir_level[i].getSelectedIndex() + 1 <= level) {
                    _ST[ELIXIR][st]++;
                }
            }
        }
        for (int i = 0; i < ui.lev.size; i++) {
            int st = ui.lev.field[i];
            if (st >= 0) {
                ///LV90以上の最大ステータス50/LV90未満の最大ステータス45の処理
                if (level >= 90) {
                    if(_ST[BASE][st] + _ST[REM][st] + _ST[LEVEL][st] + _ST[ELIXIR][st] < 50) {
                        if (i + 51 <= level) {
                            _ST[LEVEL][st]++;
                        }
                        ui.lev.isOverflow[i] = false;
                    } else if (i + 51 <= level) {
                    ui.lev.isOverflow[i] = true;
                    }              
                }                        
                else{
                    if (_ST[BASE][st] + _ST[REM][st] + _ST[LEVEL][st] + _ST[ELIXIR][st] < 45) {
                        if (i + 51 <= level) {
                            _ST[LEVEL][st]++;
                        }
                        ui.lev.isOverflow[i] = false;
                    } else if (i + 51 <= level) {
                    ui.lev.isOverflow[i] = true;
                    }
                }
            }

//            for (int j = 0; j < 5; j++) {
//                int e_st = ui.cb_elixir[j].getSelectedIndex() - 1;
//                if (e_st < 0) {
//                    continue;
//                }
//                if (ui.cb_elixir_level[j].getSelectedIndex() + 1 == i + 51
//                        && i + 51 <= level) {
//                    if (_ST[BASE][e_st] + _ST[REM][e_st] + _ST[LEVEL][e_st]
//                            + _ST[ELIXIR][e_st] < 45) {
//                        _ST[ELIXIR][e_st]++;
//                    } else {
//                        ui.cb_elixir[j].setSelectedIndex(0);
//                    }
//                }
//            }
        }
        ui.lev.repaint();

        for (int i = 0; i < ELEM_LIST.length; i++) {
            dmg_buki_ele1[i] = 0;
        }
        if (ui.cb_elem_1.getSelectedIndex() > 0) {

            int x = (ui.cb_elem_1.getSelectedIndex() - 1) % 5;
            int e = (ui.cb_elem_1.getSelectedIndex() - 1) / 5;
            int d[] = {1, 3, 5, 7, 9};
            dmg_buki_ele1[e] = d[x];
        }
        if (ui.cb_elem_2.getSelectedIndex() > 0) {
            for (int i = 0; i < ELEM_LIST.length; i++) {
                dmg_buki_ele2[i] = 0;
            }

            int x = (ui.cb_elem_2.getSelectedIndex() - 1) % 5;
            int e = (ui.cb_elem_2.getSelectedIndex() - 1) / 5;
            int d[] = {1, 3, 5, 7, 9};
            dmg_buki_ele2[e] = d[x];
        }

        buff = new Buff();

        for (Bougu b : bougu) {
            buff.effect += b.op.effect;
            buff.effect += b.op2.effect;
            buff.PVP += b.op.PVP + b.op2.PVP;
            buff.PVP_DR += b.op.PVP_DR + b.op2.PVP_DR;
            buff.DG += b.op.DG + b.op2.DG;
            buff.ER += b.op.ER + b.op2.ER;
            buff.ME += b.op.ME + b.op2.ME;
        }

        if (bougu[0].name.equals("エルヴンシールド")) {
            if (cls == E) {
                buff.MR += 5;
            }
        }

        // セット効果
        int set1 = 0, set2 = 0, set3 = 0;// 王家セット
        int set4 = 0, set5 = 0, set6 = 0;// 浄化セット
        int set7 = 0, set8 = 0;// 極寒、アイスクイーンセット
        int set9 = 0;// 修練者セット
        int set10 = 0, set11 = 0, set12 = 0;//釣りセット
        int set13 = 0;//軍王セット
        int set14 = 0;//DKセット
        int set15 = 0;//セマオリムセット セマのリング+オリムのアミュレット

        for (Bougu bougu1 : bougu) {
            if (bougu1.name.equals("セマのリング")
                    || bougu1.name.equals("オリムのアミュレット")) {
                set15++;
            }

            if (bougu1.name.equals("デスナイトヘルム")
                    || bougu1.name.equals("デスナイトグローブ")
                    || bougu1.name.equals("デスナイトアーマー")
                    || bougu1.name.equals("デスナイトブーツ")) {
                set14++;
            }

            if (bougu1.name.equals("魔霊軍王のローブ")
                    || bougu1.name.equals("冥法軍王のマント")
                    || bougu1.name.equals("暗殺軍王のグローブ")
                    || bougu1.name.equals("魔獣軍王のブーツ")) {
                set13++;
            }

            if (bougu1.name.equals("シャイニングイアリング")) {
                set10++;
                set11++;
                set12++;
            }
            if (bougu1.name.equals("レッドムーンネックレス")) {
                set10 += 2;
            }
            if (bougu1.name.equals("ホワイトムーンネックレス")) {
                set11 += 2;
            }
            if (bougu1.name.equals("ブラックムーンネックレス")) {
                set12 += 2;
            }

            if (bougu1.name.equals("王家のイアリング")) {
                set1++;
                set2++;
                set3++;
            }
            if (bougu1.name.equals("浄化のイアリング")) {
                set4++;
                set5++;
                set6++;
            }
            if (bougu1.name.equals("王家の猛きアミュレット")) {
                set1 += 2;
            }
            if (bougu1.name.equals("王家の賢きアミュレット")) {
                set2 += 2;
            }
            if (bougu1.name.equals("王家の強きアミュレット")) {
                set3 += 2;
            }
            if (bougu1.name.equals("青呪のアミュレット")) {
                set4 += 2;
            }
            if (bougu1.name.equals("赤呪のアミュレット")) {
                set5 += 2;
            }
            if (bougu1.name.equals("緑呪のアミュレット")) {
                set6 += 2;
            }
            if (bougu1.name.contains("極寒")) {
                set7++;
            }
            if (bougu1.name.contains("アイスクイーン")) {
                set8++;
            }
            if (bougu1.name.contains("修練者")) {
                set9++;
            }
        }

        if (set10 >= 3) {
            buff.DMG_SHORT += 2;
            buff.DMG_LONG += 2;
            buff.HIT_SHORT += 2;
            buff.HIT_LONG += 2;
        }
        if (set11 >= 3) {
            buff.MP += 33;
            buff.MPR += 2;
            buff.SP++;
        }
        if (set12 >= 3) {
            buff.HP += 55;
            buff.HPR += 5;
        }

        if (set1 >= 3) {
            buff.DMG_SHORT += 2;
            buff.DMG_LONG += 2;
            buff.HIT_SHORT += 2;
            buff.HIT_LONG += 2;
        }
        if (set2 >= 3) {
            buff.MP += 33;
            buff.MPR += 2;
            buff.SP++;
        }
        if (set3 >= 3) {
            buff.HP += 55;
            buff.MR += 4;
            buff.HPR += 5;
        }
        if (set4 >= 3) {
            buff.ST[INT] += 2;
            buff.ST[WIS] -= 2;
        }
        if (set5 >= 3) {
            buff.ST[STR] += 2;
            buff.ST[CON] -= 2;
        }
        if (set6 >= 3) {
            buff.ST[DEX] += 2;
            buff.ST[CHA] -= 2;
        }
        if (set7 == 3) {
            buff.AC -= 5;
            buff.ST[CON] += 3;
            buff.HP += 100;
            buff.HPR += 8;
            buff.MPR += 4;
            buff.MR += 15;
            buff.element_resist[WATER] += 20;
        }
        if (set8 == 3) {
            buff.AC -= 5;
            buff.ST[STR] += 2;
            buff.ST[CHA] += 2;
            buff.HP += 100;
            buff.MPR += 4;
            buff.element_resist[WATER] += 20;
        }
        if (set9 == 3) {
            buff.HPR += 4;
            buff.MPR += 1;
        }

        if (set13 == 4) {
            buff.HP += 30;
            buff.HPR += 10;
            buff.MP += 30;
            buff.MPR += 10;
            buff.ST[CHA] += 3;
        }

        if (set14 == 4) {
            buff.AC -= 10;
            buff.ST[STR] += 2;
            buff.DMG_SHORT += 2;
            //  下記メソッド実行のたびに追加ボーナスが累積される模様（本来+2個で追加ボーナスが3倍になる）
            //ui.cb_morph_level.setSelectedItem("80");
            //ui.cb_morph_type.setSelectedItem("近/遠特化");
        }
        //セマ・オリムセット AC-5 STR+1 DEX+1 CON+1 INT+1 WIS+1 CHA+1 最大HP+50
        if (set15 >= 2) {
            buff.AC -= 5;
            buff.ST[STR] += 1;
            buff.ST[DEX] += 1;
            buff.ST[CON] += 1;
            buff.ST[INT] += 1;
            buff.ST[WIS] += 1;
            buff.ST[CHA] += 1;
            buff.HP += 50;
        }
        //ウィズダムポーション
        ui.cb_buff[ITEM_WIZP].setToolTipText("SP+2 MPR+2");
        if (ui.cb_buff[ITEM_WIZP].isSelected()) {
            if (cls == W || cls == I) {
                buff.SP += 2;
                buff.MPR += 2;
            } else {
                ui.cb_buff[ITEM_WIZP].setSelected(false);
            }
        }

        // マジックドール
        if (ui.cb_buff[ITEM_MD].isSelected()) {
            switch (ui.cb_buff_group[ITEM_MD].getSelectedIndex()) {
        //LV1 MD
                case 0:                             //カカシ
                    buff.HP += 50;
                    ui.cb_buff[ITEM_MD].setToolTipText("最大HP+50");
                    break;
                case 1:                             //ウェアウルフ
                    buff.effect += "特殊攻撃(クラスタシアン/ウェアウルフ),";
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離攻撃時に3%の確率で追加ダメージ+15");
                    break;
                case 2:                             //クラスタシアン
                    buff.effect += "特殊攻撃(クラスタシアン/ウェアウルフ),";
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離攻撃時に3%の確率で追加ダメージ+15");
                    break;
                case 3:                             //ストーンゴーレム
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("ダメージ低下+1")
                    ;break;
                case 4:                             //イエティ
                    buff.AC -= 3;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-3");
                    break;
                case 5:                             //バグベアー
                    buff.r_weight += 0.20;
                    ui.cb_buff[ITEM_MD].setToolTipText("所持重量増加+500");
                    break;
        //LV2 MD
                case 6:                             //ラヴァゴーレム
                    buff.DMG_SHORT += 1;
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+1 ダメージ低下+1");
                    break;
                case 7:                             //スノーマン
                    buff.DMG_SHORT += 1;
                    buff.HIT_SHORT += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+1 近距離命中+1");
                    break;
                case 8:                             //コカトリス
                    buff.DMG_LONG++;
                    buff.HIT_LONG++;
                    ui.cb_buff[ITEM_MD].setToolTipText("遠距離ダメージ+1 遠距離命中+1");
                    break;
                case 9:                             //サキュバス
                    buff.effect += "MP回復 +15,";
                    ui.cb_buff[ITEM_MD].setToolTipText("MP絶対回復+15(64秒)");
                    break;
                case 10:                            //エルダー
                    buff.effect += "MP回復 +15,";
                    ui.cb_buff[ITEM_MD].setToolTipText("MP絶対回復+15(64秒)");
                    break;
                case 11:                            //マーメイド
                    ui.cb_buff[ITEM_MD].setToolTipText("経験値増加+3%");
                    break;
        //LV3 MD
                case 12:                            //ダイアゴーレム
                    buff.DR += 2;
                    ui.cb_buff[ITEM_MD].setToolTipText("ダメージ低下+2");
                    break;
                case 13:                            //祝福されたダイアゴーレム
                    buff.AC -= 2;
                    buff.DR += 2;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 ダメージ低下+2");
                    break;
                case 14:                            //ドレイク
                    buff.DMG_LONG += 2;
                    buff.effect += "MP回復 +6,";
                    ui.cb_buff[ITEM_MD].setToolTipText("遠距離ダメージ+2 64秒毎にMPが6回復");
                    break;
                case 15:                            //祝福されたドレイク
                    buff.AC -= 2;
                    buff.DMG_LONG += 2;
                    buff.effect += "MP回復 +6,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 遠距離ダメージ+2 64秒毎にMPが6回復");
                    break;
                case 16:                            //キングバグベアー
                    buff.ailment[STUN] += 8;
                    buff.effect += "MP回復 +10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("スタン耐性+8 64秒毎にMPが10回復");
                    break;
                case 17:                            //祝福されたキングバグベアー
                    buff.AC -= 2;
                    buff.ailment[STUN] += 8;
                    buff.effect += "MP回復 +10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 スタン耐性+8 64秒毎にMPが10回復");
                    break;
                case 18:                            //サキュバスクイーン
                    buff.effect += "MP回復 +15,";
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("SP+1 64秒毎にMPが15回復");
                    break;
                case 19:                            //祝福されたサキュバスクイーン
                    buff.AC -= 2;
                    buff.effect += "MP回復 +15,";
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 SP+1 64秒毎にMPが15回復");
                    break;
                case 20:                            //ブラックエルダー
                    buff.effect += "MP回復 +15,";
                    buff.effect += "コールライトニング,";
                    ui.cb_buff[ITEM_MD].setToolTipText("64秒毎にMPが15回復 魔法発動(コールライトニング)");
                    break;
                case 21:                            //祝福されたブラックエルダー
                    buff.AC -= 2;
                    buff.effect += "MP回復 +15,";
                    buff.effect += "コールライトニング,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 64秒毎にMPが15回復 魔法発動(コールライトニング)");
                    break;
                case 22:                            //アースジャイアント
                    buff.MEXP += 10;                //獲得経験値+10%
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("獲得経験値+10% ダメージ低下+1");
                    break;
                case 23:                            //祝福されたアースジャイアント
                    buff.AC -= 2;
                    buff.MEXP += 10;                //獲得経験値+10%
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 獲得経験値+10% ダメージ低下+1");
                    break;
        //LV4 MD
                case 24:                            //サイクロプス
                    buff.AC -= 1;
                    buff.DMG_SHORT += 6;
                    buff.DMG_LONG += 6;
                    buff.SP += 4;
                    buff.effect += "アースジェイル,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-1 近距離ダメージ+6 遠距離ダメージ+6 SP+4 魔法発動(アースジェイル)");
                    break;
                case 25:                            //祝福されたサイクロプス
                    buff.AC -= 3;
                    buff.PVP += 2;
                    buff.DMG_SHORT += 6;
                    buff.DMG_LONG += 6;
                    buff.SP += 4;
                    buff.effect += "アースジェイル,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-3 PVP追加ダメージ+2 近距離ダメージ+6 遠距離ダメージ+6 SP+4 魔法発動(アースジェイル)");
                    break;
                case 26:                            //ナイトバルド
                    buff.AC -= 2;
                    buff.DMG_SHORT += 4;
                    buff.HIT_SHORT += 2;
                    buff.DR += 2;
                    buff.HP += 120;
                    buff.effect += "MP回復 +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 最大HP+120 近距離ダメージ+4 近距離命中+2 ダメージ低下+2 64秒毎にMPが8回復");
                    break;
                case 27:                            //祝福されたナイトバルド
                    buff.AC -= 4;
                    buff.PVP += 2;
                    buff.DMG_SHORT += 4;
                    buff.HIT_SHORT += 2;
                    buff.DR += 2;
                    buff.HP += 120;
                    buff.effect += "MP回復 +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP追加ダメージ+2 最大HP+120 近距離ダメージ+4 近距離命中+2 ダメージ低下+2 64秒毎にMPが8回復");
                    break;
                case 28:                            //アイリス
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    buff.DR += 3;
                    buff.effect += "フォースレイヤーダメージ+10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+2 近距離命中+2 ダメージ低下+3 フォースレイヤー追加ダメージ+10");
                    break;
                case 29:                            //祝福されたアイリス
                    buff.AC -= 2;
                    buff.PVP += 2;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    buff.DR += 3;
                    buff.effect += "フォースレイヤーダメージ+10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 PVP追加ダメージ+2 近距離ダメージ+2 近距離命中+2 ダメージ低下+3 フォースレイヤー追加ダメージ+10");
                    break;
                case 30:                            //バンパイア
                    buff.AC -= 2;
                    buff.HP += 80;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    buff.DR += 2;
                    buff.ailment[HIT_TERROR] += 3;
                    buff.ailment[STUN] += 5;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 最大HP+80 近距離ダメージ+2 近距離命中+2 ダメージ低下+2 恐怖命中+3 技術耐性+5");
                    break;
                case 31:                            //祝福されたバンパイア
                    buff.AC -= 4;
                    buff.PVP += 2;
                    buff.HP += 80;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    buff.DR += 2;
                    buff.ailment[HIT_TERROR] += 3;
                    buff.ailment[STUN] += 5;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP追加ダメージ+2  最大HP+80 近距離ダメージ+2 近距離命中+2 ダメージ低下+2 恐怖命中+3 技術耐性+5");
                    break;
                case 32:                            //シアー
                    buff.AC -= 2;
                    buff.HP += 80;
                    buff.DMG_LONG += 4;
                    buff.HIT_LONG += 2;
                    buff.DR += 2;
                    buff.effect += "MP回復 +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 最大HP+80 遠距離ダメージ+4 遠距離命中+2 ダメージ低下+2 64秒毎にMPが12回復");
                    break;
                case 33:                            //祝福されたシアー
                    buff.AC -= 4;
                    buff.PVP += 2;
                    buff.HP += 80;
                    buff.DMG_LONG += 4;
                    buff.HIT_LONG += 2;
                    buff.DR += 2;
                    buff.effect += "MP回復 +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP追加ダメージ+2  最大HP+80 遠距離ダメージ+4 遠距離命中+2 ダメージ低下+2 64秒毎にMPが12回復");
                    break;
                case 34:                            //リッチ
                    buff.AC -= 2;
                    buff.HP += 40;
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.effect += "MP回復 +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 最大HP+40 SP+2 ダメージ低下+2 MP絶対回復+16(64秒)");
                    break;
                case 35:                            //祝福されたリッチ
                    buff.AC -= 4;
                    buff.PVP += 2;
                    buff.HP += 40;
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.effect += "MP回復 +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP追加ダメージ+2 最大HP+40 SP+2 ダメージ低下+2 MP絶対回復+16(64秒)");
                    break;
        //LV5 MD
                case 36:                            //デスナイト
                    buff.AC -= 2;
                    buff.DMG_SHORT += 8;
                    buff.DMG_LONG += 8;
                    buff.SP += 5;
                    buff.effect += "ヘルファイアー,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 近距離ダメージ+8 遠距離ダメージ+8 SP+5 魔法発動(ヘルファイア)");
                    break;
                case 37:                            //祝福されたデスナイト
                    buff.AC -= 4;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.DMG_SHORT += 8;
                    buff.DMG_LONG += 8;
                    buff.SP += 5;
                    buff.effect += "ヘルファイアー,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP追加ダメージ+2 PVPダメージ低下+4 近距離ダメージ+8 遠距離ダメージ+8 SP+5 魔法発動(ヘルファイア)");
                    break;
                case 38:                            //デーモン
                    buff.AC -= 4;
                    buff.DMG_SHORT += 6;
                    buff.HIT_SHORT += 4;
                    buff.DR += 4;
                    buff.HP += 120;
                    buff.effect += "MP回復 +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 最大HP+120 近距離ダメージ+6 近距離命中+4 ダメージ低下+4 64秒毎にMPが8回復");
                    break;
                case 39:                            //祝福されたデーモン
                    buff.AC -= 6;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.DMG_SHORT += 6;
                    buff.HIT_SHORT += 4;
                    buff.DR += 4;
                    buff.HP += 120;
                    buff.effect += "MP回復 +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-6 PVP追加ダメージ+2 PVPダメージ低下+4  最大HP+120 近距離ダメージ+6 近距離命中+4 ダメージ低下+4 64秒毎にMPが8回復");
                    break;
                case 40:                            //バランカ
                    buff.HP += 120;
                    buff.DMG_SHORT += 6;
                    buff.HIT_SHORT += 6;
                    buff.DR += 2;
                    buff.ailment[HIT_SPIRIT] += 10;
                    buff.effect += "MP回復 +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("最大HP+120 近距離ダメージ+6 近距離命中+6 ダメージ低下+2 精霊命中+10 64秒毎にMPが12回復");
                    break;
                case 41:                            //祝福されたバランカ
                    buff.AC -= 2;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.HP += 120;
                    buff.DMG_SHORT += 6;
                    buff.HIT_SHORT += 6;
                    buff.DR += 2;
                    buff.ailment[HIT_SPIRIT] += 10;
                    buff.effect += "MP回復 +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 PVP追加ダメージ+2 PVPダメージ低下+4 最大HP+120 近距離ダメージ+6 近距離命中+6 ダメージ低下+2 精霊命中+10 64秒毎にMPが12回復");
                    break;
                case 42:                            //カーツ
                    buff.AC -= 3;
                    buff.DMG_SHORT += 4;
                    buff.HIT_SHORT += 4;
                    buff.HP += 120;
                    buff.DR += 3;
                    buff.effect += "フォースレイヤーダメージ+10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-3 近距離ダメージ+4 近距離命中+4 最大HP+120 ダメージ低下+3 フォースレイヤー追加ダメージ+10");
                    break;
                case 43:                            //祝福されたカーツ
                    buff.AC -= 5;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.DMG_SHORT += 4;
                    buff.HIT_SHORT += 4;
                    buff.HP += 120;
                    buff.DR += 3;
                    buff.effect += "フォースレイヤーダメージ+10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-5 PVP追加ダメージ+2 PVPダメージ低下+4 近距離ダメージ+4 近距離命中+4 最大HP+120 AC-3 ダメージ低下+3 フォースレイヤー追加ダメージ+10");
                    break;
                case 44:                            //バフォメット
                    buff.AC -= 4;
                    buff.HP += 120;
                    buff.DMG_SHORT += 3;
                    buff.HIT_SHORT += 3;
                    buff.DR += 4;
                    buff.ailment[HIT_TERROR] += 5;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 近距離ダメージ+3 近距離命中+3 最大HP+120 ダメージ低下+4 恐怖命中+5");
                    break;
                case 45:                            //祝福されたバフォメット
                    buff.AC -= 6;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.HP += 120;
                    buff.DMG_SHORT += 3;
                    buff.HIT_SHORT += 3;
                    buff.DR += 4;
                    buff.ailment[HIT_TERROR] += 5;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-6 PVP追加ダメージ+2 PVPダメージ低下+4 近距離ダメージ+3 近距離命中+3 最大HP+120 ダメージ低下+4 恐怖命中+5");
                    break;
                case 46:                            //マミーロード
                    buff.AC -= 4;
                    buff.DMG_LONG += 6;
                    buff.HIT_LONG += 4;
                    buff.DR += 4;
                    buff.HP += 80;
                    buff.effect += "MP回復 +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 最大HP+80 遠距離ダメージ+6 遠距離命中+4 ダメージ低下+4 64秒毎にMPが12回復");
                    break;
                case 47:                            //祝福されたマミーロード
                    buff.AC -= 6;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.DMG_LONG += 6;
                    buff.HIT_LONG += 4;
                    buff.DR += 4;
                    buff.HP += 80;
                    buff.effect += "MP回復 +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-6 PVP追加ダメージ+2 PVPダメージ低下+4  最大HP+80 遠距離ダメージ+6 遠距離命中+4 ダメージ低下+4 64秒毎にMPが12回復");
                    break;
                case 48:                            //アイスクイーン
                    buff.HP += 80;
                    buff.SP += 1;
                    buff.DMG_LONG += 4;
                    buff.HIT_LONG += 8;
                    buff.DR += 2;
                    buff.effect += "攻撃時一定確率で魔法発動,";
                    ui.cb_buff[ITEM_MD].setToolTipText("最大HP+80 遠距離ダメージ+4 遠距離命中+8 ダメージ低下+2 魔法発動");
                    break;
                case 49:                            //祝福されたアイスクイーン
                    buff.AC -= 2;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.HP += 80;
                    buff.SP += 1;
                    buff.DMG_LONG += 4;
                    buff.HIT_LONG += 8;
                    buff.DR += 2;
                    buff.effect += "攻撃時一定確率で魔法発動,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 PVP追加ダメージ+2 PVPダメージ低下+4 最大HP+80 遠距離ダメージ+4 遠距離命中+8 ダメージ低下+2 魔法発動");
                    break;
                case 50:                            //堕落
                    buff.SP += 5;
                    buff.HIT_MAGIC += 5;                    
                    buff.effect += "MP回復 +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("SP+5 魔法命中+5 64秒毎にMPが16回復");
                    break;
                case 51:                            //祝福された堕落
                    buff.AC -= 2;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.SP += 5;
                    buff.HIT_MAGIC += 5;                    
                    buff.effect += "MP回復 +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 PVP追加ダメージ+2 PVPダメージ低下+4 SP+5 魔法命中+5 64秒毎にMPが16回復");
                    break;
                case 52:                            //覚醒パオ
                    buff.AC -= 4;
                    buff.SP += 3;
                    buff.DR += 4;
                    buff.HP += 40;
                    buff.effect += "MP回復 +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 最大HP+40 SP+3ダメージ低下+4 64秒毎にMPが16回復");
                    break;
                case 53:                            //祝福された覚醒パオ
                    buff.AC -= 6;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.SP += 3;
                    buff.DR += 4;
                    buff.HP += 40;
                    buff.effect += "MP回復 +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-6 PVP追加ダメージ+2 PVPダメージ低下+4 最大HP+40 SP+3ダメージ低下+4 64秒毎にMPが16回復");
                    break;                                        
        //LV5 ドラゴンMD
                case 54:                            //アンタラス
                    buff.AC -= 9;
                    buff.PVP += 4;
                    buff.PVP_DR += 2;
                    buff.HP += 120;
                    buff.DR += 7;
                    buff.effect += "MP回復 +15,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-9 PVP追加ダメージ+4 PVPダメージ低下+2 最大HP+120 ダメージ低下+7 64秒毎にMPが15回復 祝福消耗効率+7%");
                    break;
                case 55:                            //パプリオン
                    buff.AC -= 3;
                    buff.PVP += 4;
                    buff.PVP_DR += 2;
                    buff.DR += 1;
                    buff.SP += 7;
                    buff.HIT_MAGIC += 7;                    
                    buff.effect += "MP回復 +10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-3 PVP追加ダメージ+4 PVPダメージ低下+2 ダメージ低下+1 SP+7 魔法命中+7 64秒毎にMPが10回復 祝福消耗効率+7%");
                    break;
                case 56:                            //リンドビオル
                    buff.AC -= 4;
                    buff.PVP += 4;
                    buff.PVP_DR += 2;
                    buff.DR += 2;
                    buff.DMG_LONG += 7;
                    buff.HIT_LONG += 7;
                    buff.effect += "MP回復 +5,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP追加ダメージ+4 PVPダメージ低下+2 ダメージ低下+2 遠距離ダメージ+7 遠距離命中+7 64秒毎にMPが5回復 祝福消耗効率+7%");
                    break;
                case 57:                            //ヴァラカス
                    buff.AC -= 5;
                    buff.PVP += 4;
                    buff.PVP_DR += 2;
                    buff.DR += 3;
                    buff.DMG_SHORT += 7;
                    buff.HIT_SHORT += 7;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-5 PVP追加ダメージ+4 PVPダメージ低下+2 ダメージ低下+3 近距離ダメージ+7 近距離命中+7 祝福消耗効率+7%");
                    break;
        //課金MD
                case 62:                            //シーダンサー
                    buff.effect += "HP回復 +40,";
                    ui.cb_buff[ITEM_MD].setToolTipText("HP絶対回復+40(32秒)");
                    break;
                case 63:                            //スパルトイ
                    ui.cb_buff[ITEM_MD].setToolTipText("一定確率(4%)でダメージを無効化");
                    buff.effect += "回避,";
                    break;
                case 64:                            //ラミア
                    buff.MPR += 4;
                    ui.cb_buff[ITEM_MD].setToolTipText("MP自然回復+4 近距離攻撃の時だけ魔法発動:カーズポイズン");
                    break;
                case 65:                            //スノーマン(課金)
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.MPR += 2;
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+2 遠距離ダメージ+2 MP自然回復+2");
                    break;
                case 66:                            //グレムリン
                    buff.HP += 30;
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("HP+30 近距離ダメージ+2 遠距離ダメージ+2 SP+1");
                    break;
                case 67:                            //ブルート
                    buff.r_weight += 0.10;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+250");
                    break;
                case 68:                            //ブルート(努力する)
                    buff.r_weight += 0.12;
                    buff.effect += "HP回復 +15,";
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+300 HP絶対回復+15(64秒)");
                    break;
                case 69:                            //ブルート(賢い)
                    buff.r_weight += 0.14;
                    buff.effect += "HP回復 +15,";
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+350 HP絶対回復+15(64秒)");
                    break;
                case 70:                            //ブルート(聡明な)
                    buff.r_weight += 0.16;
                    buff.effect += "HP回復 +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+400 HP絶対回復+15(64秒) 近距離ダメージ+1");
                    break;
                case 71:                            //ブルート(光る)
                    buff.r_weight += 0.18;
                    buff.effect += "HP回復 +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+450 HP絶対回復+15(64秒) 近距離ダメージ+1");
                    break;
                case 72:                            //ブルート(眩しい)
                    buff.r_weight += 0.20;
                    buff.effect += "HP回復 +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+500 HP絶対回復+15(64秒) 近距離ダメージ+1");
                    break;
                case 73:                            //ジャイアント
                    buff.r_weight += 0.10;
                    buff.effect += "ダメージ低下 +5,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+5 所持重量増加+250");
                    break;
                case 74:                            //ジャイアント(努力する)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.effect += "ダメージ低下 +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+8 所持重量増加+250 AC-1");
                    break;
                case 75:                            //ジャイアント(賢い)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.effect += "ダメージ低下 +11,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+11 所持重量増加+250 AC-1");
                    break;
                case 76:                            //ジャイアント(聡明な)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ低下 +14,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+14 所持重量増加+250 AC-1 MR+5%");
                    break;
                case 77:                            //ジャイアント(光る)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ低下 +17,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+17 所持重量増加+250 AC-1 MR+5%");
                    break;
                case 78:                            //ジャイアント(眩しい)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ低下 +20,ヴァンパイアリックタッチ,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+20 所持重量増加+250 AC-1 MR+5% 近距離攻撃時に一定確率で魔法発動:バンパイアリックタッチ");
                    break;
                case 79:                            //パック/パオ(0段階)
                    buff.DMG_SHORT += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+1");
                case 80:                            //パック/パオ(1段階)
                    buff.DMG_SHORT += 1;
                    buff.DMG_LONG += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+1 遠距離ダメージ+1");
                    break;
                case 81:                            //パック/パオ(2段階)
                    buff.DMG_SHORT += 1;
                    buff.DMG_LONG += 1;
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+1 遠距離ダメージ+1 SP+1");
                    break;
                case 82:                            //パック/パオ(3段階)
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.SP += 1;
                    buff.effect += "特殊攻撃(パック/パオ),";
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+2 遠距離ダメージ+2 SP+1 魔法発動:特殊爆発魔法");
                    break;
                default:
                    break;
            }
        }
//マジックドール パック/パオのオプション
        if (ui.cb_buff[ITEM_MD_OP].isSelected()) {
            switch (ui.cb_buff_group[ITEM_MD_OP].getSelectedIndex()) {
                case 0:                                 //AC-2
                    buff.AC -= 2;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("AC-2");
                    break;
                case 1:                                 //AC-4
                    buff.AC -= 4;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("AC-4");
                    break;
                case 2:                                 //AC-5 ダメージ低下+2
                    buff.AC -= 5;
                    buff.DR += 2;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("AC-5 ダメージ低下+2");
                    break;
                case 3:                                 //AC-1 MR+1%
                    buff.AC -= 1;
                    buff.MR += 1;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("AC-1 MR+1%");
                    break;
                case 4:                                 //AC-3 MR+5%
                    buff.AC -= 3;
                    buff.MR += 5;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("AC-3 MR+5%");
                    break;
                case 5:                                 //AC-5 MR+10%
                    buff.AC -= 5;
                    buff.MR += 10;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("AC-5 MR+10%");
                    break;
                case 6:                                 //MPR+1
                    buff.MPR += 1;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("MPR+1");
                    break;
                case 7:                                 //MPR+3
                    buff.MPR += 3;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("MPR+3");
                    break;
                case 8:                                 //MPR+7
                    buff.MPR += 7;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("MPR+7");
                    break;
                case 9:                                 //MP絶対回復+1(64秒)
                    buff.effect += "MP回復 +1,";
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("MP絶対回復+1(64秒)AC-2");
                    break;
                case 10:                                //MP絶対回復+3(64秒)
                    buff.effect += "MP回復 +3,";
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("MP絶対回復+3(64秒)");
                    break;
                case 11:                                //MP絶対回復+7(64秒)
                    buff.effect += "MP回復 +7,";
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("MP絶対回復+7(64秒)");
                    break;
                case 12:                                //HP+10 MP+10
                    buff.HP += 10;
                    buff.MP += 10;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("HP+10 MP+10");
                    break;
                case 13:                                //HP+35 MP+35
                    buff.HP += 35;
                    buff.MP += 35;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("HP+35 MP+35");
                    break;
                case 14:                                //HP+60 MP+60
                    buff.HP += 60;
                    buff.MP += 60;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("HP+60 MP+60");
                    break;
                case 15:                                //近距離命中+1 遠距離命中+1
                    buff.HIT_SHORT += 1;
                    buff.HIT_LONG += 1;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("近距離命中+1 遠距離命中+1");
                    break;
                case 16:                                //近距離命中+2 遠距離命中+2
                    buff.HIT_SHORT += 2;
                    buff.HIT_LONG += 2;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("近距離命中+2 遠距離命中+2");
                    break;
                case 17:                                //近距離命中+4 遠距離命中+4
                    buff.HIT_SHORT += 4;
                    buff.HIT_LONG += 4;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("近距離命中+4 遠距離命中+4");
                    break;
                default:
                    break;
            }
        }

        //深海の力
        if (ui.cb_buff[ITEM_SEA].isSelected()) {
            switch (ui.cb_buff_group[ITEM_SEA].getSelectedIndex()) {
                case 0:                                 //ドラゴンの石
                    buff.DMG_SHORT += 3;
                    buff.DMG_LONG += 3;
                    buff.HIT_SHORT += 3;
                    buff.HIT_LONG += 3;
                    buff.SP += 3;
                    ui.cb_buff[ITEM_SEA].setToolTipText("近距離ダメージ+3 遠距離ダメージ+3 近距離命中+3 遠距離命中+3 SP+3");
                    break;                    
                case 1:                                 //憤怒のポーション
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.HIT_SHORT += 2;
                    buff.HIT_LONG += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("近距離ダメージ+2 遠距離ダメージ+2 近距離命中+2 遠距離命中+2");
                    break;
                case 2:                                 //集中のポーション
                    buff.SP += 3;
                    ui.cb_buff[ITEM_SEA].setToolTipText("SP+3");
                    break;
                case 3:                                 //腕力のポーション
                    buff.ST[STR] += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("STR+2");
                    break;
                case 4:                                 //機敏のポーション
                    buff.ST[DEX] += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("DEX+2");
                    break;
                case 5:                                 //体力のポーション
                    buff.ST[CON] += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("CON+2");
                    break;
                case 6:                                 //知力のポーション
                    buff.ST[INT] += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("INT+2");
                    break;
                case 7:                                 //精神のポーション
                    buff.ST[WIS] += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("WIS+2");
                    break;
                case 8:                                 //闘士の戦闘強化スクロール
                    buff.DMG_SHORT += 3;
                    buff.HIT_SHORT += 5;
                    buff.PVP_DR += 3;
                    ui.cb_buff[ITEM_SEA].setToolTipText("近距離ダメージ+3 近距離命中+5 PVPダメージ低下+3");
                    break;
                case 9:                                 //射手の戦闘強化スクロール
                    buff.DMG_LONG += 3;
                    buff.HIT_LONG += 5;
                    buff.PVP_DR += 3;
                    ui.cb_buff[ITEM_SEA].setToolTipText("遠距離ダメージ+3 遠距離命中+5 PVPダメージ低下+3");
                    break;
                case 10:                                //賢者の戦闘強化スクロール
                    buff.SP += 3;
                    buff.HIT_MAGIC += 5;
                    buff.PVP_DR += 3;
                    ui.cb_buff[ITEM_SEA].setToolTipText("SP+3 魔法命中+5 PVPダメージ低下+3");
                    break;
                default:
                    break;
            }
        }
        //潮風の力
        if (ui.cb_buff[ITEM_BREEZE].isSelected()) {     
            switch (ui.cb_buff_group[ITEM_BREEZE].getSelectedIndex()) {
                case 0:                                 //治癒のポーション
                    buff.HPR += 10;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("HPR+10");
                    break;
                case 1:                                 //瞑想のポーション
                    buff.MPR += 10;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("MPR+10");
                    break;
                case 2:                                 //生命のポーション
                    buff.HP += 120;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("HP+120");
                    break;
                case 3:                                 //魔法のポーション
                    buff.MP += 80;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("MP+80");
                    break;
                case 4:                                 //魔法抵抗のポーション
                    buff.MR += 10;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("MR+10");
                    break;
                case 5:                                 //術士のポーション
                    buff.MP += 60;
                    buff.MPR += 4;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("MP+60 MPR+4");
                    break;
                case 6:                                 //剣士のポーション
                    buff.HP += 100;
                    buff.HPR += 8;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("HP+100 HPR+8");
                    break;
                default:
                    break;
            }
        }

        // 料理
        if (ui.cb_buff[ITEM_COOKING].isSelected()) {
            switch (ui.cb_buff_group[ITEM_COOKING].getSelectedIndex()) {
                case 10:                                 //パタラシの七面鳥焼き
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.HPR += 2;
                    buff.MPR += 3;
                    buff.MR += 10;
                    buff.MEXP += 10;                                       //獲得経験値+10%
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.element_resist[WATER] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 SP+2 獲得経験値+10% ダメージ低下+2 15分"+"</html>");
                    break;
                case 9:                                 //パタラシのサーモンカナッペ
                    buff.DR += 2;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.DMG_LONG += 2;
                    buff.HIT_LONG += 1;
                    buff.MEXP += 10;                                       //獲得経験値+10%
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.element_resist[WATER] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+2 遠距離ダメージ+2 遠距離命中+1 獲得経験値+10% ダメージ低下+2 15分"+"</html>");
                    break;
                case 8:                                 //パタラシの和牛ステーキ
                    buff.DR += 2;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 1;
                    buff.MEXP += 10;                                       //獲得経験値+10%
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.element_resist[WATER] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+2 近距離ダメージ+2 近距離命中+1 獲得経験値+10% ダメージ低下+2 15分"+"</html>");
                    break;
                case 7:                                 //真心がこもった料理
                    buff.DR += 5;
                    buff.SP += 2;
                    buff.HPR += 3;
                    buff.MPR += 4;
                    buff.MR += 15;
                    buff.DMG_LONG += 2;
                    buff.HIT_LONG += 2;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.element_resist[WATER] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "近距離ダメージ+2 近距離命中+2 遠距離ダメージ+2 遠距離命中+2"
                                                            + "<br>"+ "MR+15 HPR+3 MPR+4 SP+2 ダメージ低下+5 15分20秒"+"</html>");
                    break;
                case 6:                                 //小粋な麺料理
                    buff.DR += 5;
                    buff.SP += 2;
                    buff.HPR += 3;
                    buff.MPR += 4;
                    buff.MR += 15;
                    buff.DMG_LONG += 2;
                    buff.HIT_LONG += 2;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.element_resist[WATER] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "近距離ダメージ+2 近距離命中+2 遠距離ダメージ+2 遠距離命中+2"
                                                            + "<br>"+ "MR+15 HPR+3 MPR+4 SP+2 ダメージ低下+5 15分20秒"+"</html>");
                    break;
                case 5:                                 //祝福された賢い七面鳥焼き
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.HPR += 2;
                    buff.MPR += 3;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WATER] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.ailment[HIT_STUN] += 3;            //技術命中+3
        	    buff.ailment[HIT_SPIRIT] += 3;          //精霊命中+3
        	    buff.ailment[HIT_SECRET] += 3;          //秘技命中+3
        	    buff.ailment[HIT_TERROR] += 3;          //恐怖命中+3
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 SP+2 ダメージ低下+2 全クラススキル命中+3 30分"+"</html>");
                    break;
                case 4:                                 //賢い七面鳥焼き
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.HPR += 2;
                    buff.MPR += 3;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WATER] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 SP+2 ダメージ低下+2 30分"+"</html>");
                    break;
                case 3:                                 //祝福された素早い鮭の煮付
                    buff.DR += 2;
                    buff.DMG_LONG += 2;
                    buff.HIT_LONG += 1;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WATER] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.ailment[HIT_STUN] += 3;            //技術命中+3
        	    buff.ailment[HIT_SPIRIT] += 3;          //精霊命中+3
        	    buff.ailment[HIT_SECRET] += 3;          //秘技命中+3
        	    buff.ailment[HIT_TERROR] += 3;          //恐怖命中+3
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 遠距離ダメージ+2 遠距離命中+1 ダメージ低下+2 全クラススキル命中+3 30分"+"</html>");
                    break;
                case 2:                                 //素早い鮭の煮付
                    buff.DR += 2;
                    buff.DMG_LONG += 2;
                    buff.HIT_LONG += 1;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WATER] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 遠距離ダメージ+2 遠距離命中+1 ダメージ低下+2 30分"+"</html>");
                    break;
                case 1:                                 //祝福された力強い和牛ステーキ
                    buff.DR += 2;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 1;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WATER] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.ailment[HIT_STUN] += 3;            //技術命中+3
        	    buff.ailment[HIT_SPIRIT] += 3;          //精霊命中+3
        	    buff.ailment[HIT_SECRET] += 3;          //秘技命中+3
        	    buff.ailment[HIT_TERROR] += 3;          //恐怖命中+3
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 近距離ダメージ+2 近距離命中+1 ダメージ低下+2 全クラススキル命中+3 30分"+"</html>");
                    break;
                case 0:                                 //力強い和牛ステーキ
                    buff.DR += 2;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 1;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WATER] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 近距離ダメージ+2 近距離命中+1 ダメージ低下+2 30分"+"</html>");
                    break;
                default:
                    break;

            }
        }
        // デザート
        if (ui.cb_buff[ITEM_DESSERT].isSelected()) {
            switch (ui.cb_buff_group[ITEM_DESSERT].getSelectedIndex()) {
                case 0:                                 //修練の鶏スープ
                    buff.MEXP += 4;                     //獲得経験値+4%
                    buff.DR += 2;
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+2 獲得経験値+4% 30分");
                    break;
                case 1:                                 //祝福された修練の鶏スープ
                    buff.DR += 2;
        	    buff.ailment[STUN] += 2;            //技術耐性+2
        	    buff.ailment[SPIRIT] += 2;          //精霊耐性+2
        	    buff.ailment[SECRET] += 2;          //秘技耐性+2
        	    buff.ailment[TERROR] += 2;          //恐怖耐性+2
                    buff.PVP_DR += 2;                   //PvPDR+2
                    buff.MEXP += 4;                     //獲得経験値+4%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+2 全クラススキル耐性+2 PvPDR+2 獲得経験値+4% 30分");
                    break;
                case 2:                                 //幻想のバシリスクの卵スープ
                    buff.DR += 5;
                    buff.MEXP += 3;                     //獲得経験値+3%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+5 獲得経験値+3% 15分20秒");
                    break;
                case 3:                                 //幻想のショートケーキ
                    buff.DR += 3;
                    buff.MEXP += 5;                     //獲得経験値+5%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+3 獲得経験値+5% 15分20秒");
                    break;
                case 4:                                 //幻想のショートケーキ(KR版)
                    buff.DR += 5;
                    buff.MEXP += 10;                    //獲得経験値+10%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+5 獲得経験値+10% 15分20秒");
                    break;
                case 5:                                 //小粋な携帯飲料
                    buff.DR += 5;
                    buff.MEXP += 5;                     //獲得経験値+5%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+5 獲得経験値+5% 15分20秒");
                    break;
                case 6:                                 //真心がこもったスープ
                    buff.DR += 5;
                    buff.MEXP += 5;                     //獲得経験値+5%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+5 獲得経験値+5% 15分20秒");
                    break;
                case 7:                                 //パタラシのキノコスープ
                    buff.DR += 2;
                    buff.MEXP += 10;                    //獲得経験値+10%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+2 獲得経験値+10% 15分");
                    break;
                default:
                    break;
            }
        }
            //コマエンチャ
            if (ui.cb_buff[KOMA].isSelected()) {
            switch (ui.cb_buff_group[KOMA].getSelectedIndex()) {
                case 0:
                    buff.ST[STR] += 5;
                    buff.ST[DEX] += 5;
                    buff.ST[CON] += 1;
                    buff.HIT_SHORT += 3;
                    buff.AC -= 3;
                    ui.cb_buff[KOMA].setToolTipText("STR+5 DEX+5 CON+1 近距離命中+3 AC-3");
                    break;
                case 1:
                    buff.ST[STR] += 5;
                    buff.ST[DEX] += 5;
                    buff.ST[CON] += 3;
                    buff.HIT_SHORT += 5;
                    buff.AC -= 8;
                    buff.SP += 1;
                    ui.cb_buff[KOMA].setToolTipText("STR+5 DEX+5 CON+3 近距離命中+5 AC-8 SP+1");
                    break;
                default:
                    break;
            }
        }

        cons_mp = 0;
        //リダクションアーマー 消費MP7/5mins 
        ui.cb_buff[K_RAR].setToolTipText("<html>"+ "[消費MP:7][消費HP:50]"
                                         + "<br>"+ "ダメージ低下+1"
                                         + "<br>"+ "レベル50からレベル5毎にダメージ軽減+1増加"
                                         + "<br>"+ "[習得レベル:50][持続時間:5分][対象:術者]"+"</html>");
        if (ui.cb_buff[K_RAR].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.DR += (level - 50) / 5 + 1;
                if (ui.cb_buff[K_RAR].getForeground().equals(Color.BLUE)) {
                    cons_mp += (7.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }

            } else {
                ui.cb_buff[K_RAR].setSelected(false);
            }
        }
        //リダクションアーマー:ベテラン 
        ui.cb_buff[K_RAV].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "リダクションアーマーに恐怖耐性+3を追加"
                                         + "<br>"+ "リダクションアーマーを覚えていないと習得する事が出来ない"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[K_RAV].isSelected()) {
            if (level >= 80 && cls == K) {
                ui.cb_buff[K_RAR].setSelected(true);
                buff.ailment[TERROR] += 3;                                      //恐怖耐性+3
            } else {
                ui.cb_buff[K_RAV].setSelected(false);
            }
        }
        //レイジングフォース
        ui.cb_buff[K_RFE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "レベル80からレベル3毎に技術命中が+1ずつ増加"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[K_RFE].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.ailment[HIT_STUN] += (level - 80) / 3 + 1;                 //技術命中(level - 80) / 3 + 1

            } else {
                ui.cb_buff[K_RFE].setSelected(false);
            }
        }
        //ソリッドキャリッジ 消費MP10/3mins
        ui.cb_buff[K_SCE].setToolTipText("<html>"+ "[消費MP:10][消費HP:100]"
                                         + "<br>"+ "盾装備時 ER+15"
                                         + "<br>"+ "[習得レベル:55][持続時間:3分12秒][対象:術者]"+"</html>");
        if (ui.cb_buff[K_SCE].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.ER += 15;
                if (ui.cb_buff[K_SCE].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 3;
                }
            } else {
                ui.cb_buff[K_SCE].setSelected(false);
            }
        }
        //カウンターバリア 消費MP15/2mins
        ui.cb_buff[K_CBR].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "両手剣装備時 一定確率(20%)で近距離攻撃回避+反撃" 
                                         + "<br>"+ "カウンターダメージは武器の([BIG打撃値]+[追加ダメージ]+[強化数])x[2]"                
                                         + "<br>"+ "[習得レベル:80][持続時間:2分8秒][対象:術者][触媒:結晶体(100)]"+"</html>");
        if (ui.cb_buff[K_CBR].isSelected()) {
            if (level >= 80 && cls == K
                    && buki.type.equals("両手剣")) {
                if (ui.cb_buff[K_CBR].getForeground().equals(Color.BLUE)) {
                    cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
                }
                // CB効果未実装
            } else {
                ui.cb_buff[K_CBR].setSelected(false);
                ui.cb_buff[K_CBV].setSelected(false);
            }
        }
        //カウンターバリア:ベテラン
        ui.cb_buff[K_CBV].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "カウンターバリアの発動率を上げる" 
                                         + "<br>"+ "85レベルから1レベル毎に発動確率1%増加"                
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[K_CBV].isSelected()) {
            if (level >= 85 && cls == K
                    && buki.type.equals("両手剣")) {
                if (ui.cb_buff[K_CBV].getForeground().equals(Color.BLUE)) {
                }
                // CB効果未実装
                ui.cb_buff[K_CBR].setSelected(true);
            } else {
                ui.cb_buff[K_CBR].setSelected(false);
                ui.cb_buff[K_CBV].setSelected(false);
            }
        }
        //バウンスアタック 消費MP10/1mins
        ui.cb_buff[K_BOK].setToolTipText("<html>"+ "[消費MP:10][消費HP:60]"
                                         + "<br>"+ "近距離命中+6"
                                         + "<br>"+ "[習得レベル:65][持続時間:1分4秒][対象:術者]"+"</html>");
        if (ui.cb_buff[K_BOK].isSelected()) {
            if (level >= 60 && cls == K) {
                buff.HIT_SHORT += 6;
                if (ui.cb_buff[K_BOK].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 1;
                }
            } else {
                ui.cb_buff[K_BOK].setSelected(false);
            }
        }
        //レジストマジック 消費MP5/20mins
        ui.cb_buff[E_RMC].setToolTipText("<html>"+ "[消費MP:5][消費HP:--]"
                                         + "<br>"+ "MR+10"
                                         + "<br>"+ "[習得レベル:15][持続時間:20分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_RMC].isSelected()) {
            if (cls == E) {
                buff.MR += 10;
                if (ui.cb_buff[E_RMC].getForeground().equals(Color.BLUE)) {
                    cons_mp += (5.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                }
            } else {
                ui.cb_buff[E_RMC].setSelected(false);
            }
        }
        //エレメンタルプロテクション
        ui.cb_buff[E_EPN].setToolTipText("<html>"+ "[消費MP:6][消費HP:--]"
                                         + "<br>"+ "選択している系列の属性抵抗50"
                                         + "<br>"+ "グローリーアース取得時の2属性は不明"
                                         + "<br>"+ "[習得レベル:45][持続時間:1分4秒][対象:術者]"+"</html>");

        if (ui.cb_buff[E_EPN].isSelected()) {
            if (cls == E) {
                switch ((String) ui.cb_buff_group[E_EPN].getSelectedItem()) {
                case "火エルフ":
                    ui.cb_buff[E_EPN].setToolTipText("火属性抵抗50");
		    buff.element_resist[FIRE] += 50;
                    break;
                case "水エルフ":
                    ui.cb_buff[E_EPN].setToolTipText("水属性抵抗50");
                    buff.element_resist[WATER] += 50;
                    break;
                case "風エルフ":
                    ui.cb_buff[E_EPN].setToolTipText("風属性抵抗50");
                    buff.element_resist[WIND] += 50;
                    break;
                case "地エルフ":
                    ui.cb_buff[E_EPN].setToolTipText("地属性抵抗50");
                    buff.element_resist[EARTH] += 50;
                    break;
                case "火*水エルフ":
                    ui.cb_buff[E_EPN].setToolTipText("火属性抵抗50 水属性抵抗50");
		    buff.element_resist[FIRE] += 50;
                    buff.element_resist[WATER] += 50;
                    break;
                case "火*風エルフ":
                    ui.cb_buff[E_EPN].setToolTipText("火属性抵抗50 風属性抵抗50");
                    buff.element_resist[FIRE] += 50;
                    buff.element_resist[WIND] += 50;
                    break;
                case "火*地エルフ":
                    ui.cb_buff[E_EPN].setToolTipText("火属性抵抗50 地属性抵抗50");
                    buff.element_resist[FIRE] += 50;
                    buff.element_resist[EARTH] += 50;
                    break;
                case "水*風エルフ":
                    ui.cb_buff[E_EPN].setToolTipText("水属性抵抗50 風属性抵抗50");
                    buff.element_resist[WATER] += 50;
                    buff.element_resist[WIND] += 50;
                    break;
                case "水*地エルフ":
                    ui.cb_buff[E_EPN].setToolTipText("水属性抵抗50 地属性抵抗50");
                    buff.element_resist[WATER] += 50;
                    buff.element_resist[EARTH] += 50;
                    break;
                case "風*地エルフ":
                    ui.cb_buff[E_EPN].setToolTipText("風属性抵抗50 地属性抵抗50");
                    buff.element_resist[WIND] += 50;
                    buff.element_resist[EARTH] += 50;
                    break;
                default:
                    break;
                }
            } else {
                ui.cb_buff[E_EPN].setSelected(false);
            }
        }
        //レジストエレメント 常時
        ui.cb_buff[E_RET].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "MR+5 全属性抵抗+5%"
                                         + "<br>"+ "[習得レベル:30][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[E_RET].isSelected()) {
            if (cls == E) {
                buff.MR += 5;
                buff.element_resist[FIRE] += 5;
                buff.element_resist[WATER] += 5;
                buff.element_resist[WIND] += 5;
                buff.element_resist[EARTH] += 5;
            } else {
                ui.cb_buff[E_RET].setSelected(false);
            }
        }
        //クリアーマインド 消費MP10/20mins
        ui.cb_buff[E_CMD].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "STR+1 DEX+1 INT+1"
                                         + "<br>"+ "[習得レベル:30][持続時間:20分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_CMD].isSelected()) {
            if (cls == E) {
                buff.ST[STR] += 1;
                buff.ST[DEX] += 1;
                buff.ST[INT] += 1;
                if (ui.cb_buff[E_CMD].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                }
            } else {
                ui.cb_buff[E_CMD].setSelected(false);
            }
        }
        //バーニングウエポン 消費MP30/16mins
        ui.cb_buff[E_BWN].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "火属性の近距離ダメージ+6 近距離命中+6"
                                         + "<br>"+ "[習得レベル:75][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_BWN].isSelected()) {
            if (cls == E) {
                buff.ELEM_DMG_SHORT[FIRE] += 6;
                buff.HIT_SHORT += 6;
                if (ui.cb_buff[E_BWN].getForeground().equals(Color.BLUE)) {
                    cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            } else {
                ui.cb_buff[E_BWN].setSelected(false);
            }
        }
        //インフェルノ 消費MP50 HP70/2mins
        ui.cb_buff[E_INO].setToolTipText("<html>"+ "[消費MP:50][消費HP:70]"
                                         + "<br>"+ "一定確率(不明)で近距離ダメージを50%軽減しカウンター攻撃"
                                         + "<br>"+ "カウンターダメージは武器の[SMALL打撃値]+[追加ダメージ]+[強化数]x[1~4(ランダム)]"
                                         + "<br>"+ "[習得レベル:80][持続時間:2分8秒][対象:術者][触媒:精霊の玉(5)]"+"</html>");



        if (ui.cb_buff[E_INO].isSelected()) {
            if (level >= 80 && cls == E
                    && buki.type.equals("片手剣")) {
                if (ui.cb_buff[E_INO].getForeground().equals(Color.BLUE)) {
                    cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
                }
                // インフェルノ効果未実装
            } else {
                ui.cb_buff[E_INO].setSelected(false);
            }
        }
        //アースウェポン 消費MP15/16mins
        ui.cb_buff[E_EWN].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "地属性の近距離ダメージ+2 近距離命中+4"
                                         + "<br>"+ "[習得レベル:45][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_EWN].isSelected()) {
            if (cls == E) {
                buff.ELEM_DMG_SHORT[EARTH] += 2;
                buff.HIT_SHORT += 4;
                if (ui.cb_buff[E_EWN].getForeground().equals(Color.BLUE)) {
                    cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            } else {
                ui.cb_buff[E_EWN].setSelected(false);
            }
        }
        //アクアショット 消費MP15/16mins
        ui.cb_buff[E_AST].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "遠距離命中+4"
                                         + "<br>"+ "[習得レベル:45][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_AST].isSelected()) {
            if (cls == E) {
                buff.HIT_LONG += 4;
                if (ui.cb_buff[E_AST].getForeground().equals(Color.BLUE)) {
                    cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            } else {
                ui.cb_buff[E_AST].setSelected(false);
            }
        }  
        //ネイチャーズタッチ 消費MP20/5mins
        ui.cb_buff[E_NTH].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "HPR+15"
                                         + "<br>"+ "[習得レベル:60][持続時間:5分20秒][対象:術者/PC]"+"</html>");
        if (ui.cb_buff[E_NTH].isSelected()) {
            if (level > 9) {
                if (level < 24) {
                    buff.HPR += level - 9;
                } else {
                    buff.HPR += 15;
                }
            }
            if (ui.cb_buff[E_NTH].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //ドレスイベイジョン 消費MP15/3mins
        ui.cb_buff[D_DEN].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "遠距離回避(ER)+18"
                                         + "<br>"+ "[習得レベル:60][持続時間:3分][対象:術者]"+"</html>");
//リニューアル後
//        ui.cb_buff[D_DEN].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
//                                         + "<br>"+ "遠距離回避(ER)+18"
//                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[D_DEN].isSelected()) {
            if (cls == D) {
                buff.ER += 18;

                if (ui.cb_buff[D_DEN].getForeground().equals(Color.BLUE)) {
                    cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 3;
                }
            } else {
                ui.cb_buff[D_DEN].setSelected(false);
            }
        }
        //シャドウアーマー 消費MP12/16mins
        ui.cb_buff[D_SAR].setToolTipText("<html>"+ "[消費MP:12][消費HP:--]"
                                         + "<br>"+ "MR+5"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:20][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[D_SAR].isSelected()) {
            if (cls == D) {
                buff.MR += 5;
                if (ui.cb_buff[D_SAR].getForeground().equals(Color.BLUE)) {
                    cons_mp += (12.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            } else {
                ui.cb_buff[D_SAR].setSelected(false);
            }
        }
        //ファイナルバーン 消費MP20 HP50/5mins
        ui.cb_buff[D_FBN].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "HPが70％以下になると近距離クリティカルが+5%増加"
                                         + "<br>"+ "レベル80から2つレベルが上がる毎に+1%"
                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:術者/PC]"+"</html>");
        if (ui.cb_buff[D_FBN].isSelected()) {
            //HPが70%以下の時、近距離クリティカル+5%(レベル80から2つレベルが上がる毎に+1%)
            if (level < 80) {
                buff.CRI_SHORT += 5;
            } else if (level >= 80) {
                buff.CRI_SHORT += 5 + ((level - 80) / 2 + 1);
            }
        }
        //アクアプロテクター 消費MP30/16mins
        ui.cb_buff[E_APR].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "遠距離回避(ER)+5"
                                         + "<br>"+ "[習得レベル:60][持続時間:16分][対象:術者/PC]"+"</html>");
        if (ui.cb_buff[E_APR].isSelected()) {
            if (ui.cb_buff[D_DEN].isSelected()) {
                ui.cb_buff[E_APR].setSelected(false);
            } else {
                buff.ER += 5;
                if (ui.cb_buff[E_APR].getForeground().equals(Color.BLUE)) {
                    cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            }
        }
        //ストームショット 消費MP30/16mins
        ui.cb_buff[E_SST].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "風属性の遠距離ダメージ+6 遠距離命中+3"
                                         + "<br>"+ "[習得レベル:75][持続時間:16分][対象:術者]"+"</html>");
            if (ui.cb_buff[E_SST].isSelected()) {
                ui.cb_buff[E_SEE].setSelected(false);
            buff.ELEM_DMG_LONG[WIND] += 6;
            buff.HIT_LONG += 3;
                if (ui.cb_buff[E_SST].getForeground().equals(Color.BLUE)) {
                    cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
        }
        //ストームアイ 消費MP40/16mins
        ui.cb_buff[E_SEE].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーに風属性の遠距離ダメージ+3 遠距離命中+2"
                                         + "<br>"+ "[習得レベル:60][持続時間:16分][対象:術者/PTメンバー]"+"</html>");
            if (ui.cb_buff[E_SEE].isSelected()) {
                buff.ELEM_DMG_LONG[WIND] += 3;
                buff.HIT_LONG += 2;
                if (ui.cb_buff[E_SEE].getForeground().equals(Color.BLUE)) {
                    cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            }

        //アースガーディアン 消費MP30/10mins
        ui.cb_buff[E_EGN].setToolTipText("<html>"+ "[消費MP:30][消費HP:10]"
                                         + "<br>"+ "DR+2"
                                         + "<br>"+ "レベル80からレベル4毎にダメージ低下が+1ずつ増加"
                                         + "<br>"+ "[習得レベル:60][持続時間:10分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_EGN].isSelected()) {
            buff.DR += 2;

            if (level >= 80 ) {
                buff.DR += (level - 80) / 4 + 1;                 //DR(level - 80) / 4 + 1
            }
                    if (ui.cb_buff[E_EGN].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //バーサーカー 消費MP40/5mins
        ui.cb_buff[W_BER].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "近距離ダメージ+2 近距離命中+8 AC+10 HP自然回復不可"
                                         + "<br>"+ "[習得レベル:56][持続時間:5分20秒][対象:術者/PTメンバー(15セル)]"+"</html>");
        if (ui.cb_buff[W_BER].isSelected()) {
            buff.DMG_SHORT += 2;
            buff.HIT_SHORT += 8;
            buff.HPR -= 255;
            buff.AC += 10;
            if (ui.cb_buff[W_BER].getForeground().equals(Color.BLUE)) {
                cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //ブレスドアーマー 消費MP20/30mins
        ui.cb_buff[W_BAR].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "選択した鎧のAC-3"
                                         + "<br>"+ "ダブルクリックで装備している鎧に自動詠唱する"
                                         + "<br>"+ "[習得レベル:24][持続時間:30分][対象:術者/PTメンバー]"+"</html>");
        if (ui.cb_buff[W_BAR].isSelected()) {
            buff.AC -= 3;
            if (ui.cb_buff[W_BAR].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
            }
        }
        //エンチャントアキュラシー 消費MP10/5mins
        ui.cb_buff[W_EAY].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "近距離命中+5"
                                         + "<br>"+ "[習得レベル:56][持続時間:5分][対象:術者][触媒:魔力の石(1)]"+"</html>");
        if (ui.cb_buff[W_EAY].isSelected()) {
            buff.HIT_SHORT += 5;
            if (ui.cb_buff[W_EAY].getForeground().equals(Color.BLUE)) {
                cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //フリージングアーマー 消費MP20/5mins
        ui.cb_buff[W_FAR].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "ER+5"
                                         + "<br>"+ "[習得レベル:56][持続時間:5分][対象:術者][触媒:魔力の石(1)]"+"</html>");
        if (ui.cb_buff[W_FAR].isSelected()) {
            buff.ER += 5;
            if (ui.cb_buff[W_FAR].getForeground().equals(Color.BLUE)) {
                cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //ドラゴンスキン 消費MP0/30mins
        ui.cb_buff[R_DSN].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "ダメージ低下[DR]+5"
                                         + "<br>"+ "レベル80からレベル2毎に効果が+1ずつ増加(LV80でDR6)"
                                         + "<br>"+ "[習得レベル:20][持続時間:30分][対象:術者]"+"</html>");
        if (ui.cb_buff[R_DSN].isSelected()) {
            buff.DR += 5;
            if (level >= 80) {
                buff.DR += (int) ((level - 80) / 2) + 1;
            }
        }
        //覚醒[アンタラス] 消費MP20/10mins
        ui.cb_buff[R_ANTHARAS].setToolTipText("<html>"+ "[消費MP:20][消費HP:10]"
                                              + "<br>"+ "AC-3"
                                              + "<br>"+ "キャンセレーションで解除されない"
                                              + "<br>"+ "[習得レベル:20][持続時間:10分][対象:術者][触媒:刻印のボーンピース(1)]"+"</html>");
        if (ui.cb_buff[R_ANTHARAS].isSelected()) {
            buff.AC -= 3;
            if (ui.cb_buff[R_ANTHARAS].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //覚醒[パプリオン] 消費MP30/10mins
        //if (ui.cb_buff[R_FAFURION].isSelected()) {
        //    if (ui.cb_buff[R_ANTHARAS].isSelected()
        //            || ui.cb_buff[R_VALAKAS].isSelected()
        //            || ui.cb_buff[R_LINDVIOL].isSelected()) {
        //        ui.cb_buff[R_FAFURION].setSelected(false);
        //    } else {
        //        if (ui.cb_buff[R_FAFURION].getForeground().equals(Color.BLUE)) {
        //            cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
        //        }
        //    }
        //}

        //覚醒[ヴァラカス] 消費MP50/10mins
        ui.cb_buff[R_VALAKAS].setToolTipText("<html>"+ "[消費MP:50][消費HP:30]"
                                             + "<br>"+ "近距離命中+5 技術耐性+10"
                                             + "<br>"+ "キャンセレーションで解除されない"
                                             + "<br>"+ "[習得レベル:60][持続時間:10分][対象:術者][触媒:刻印のボーンピース(1)]"+"</html>");
        if (ui.cb_buff[R_VALAKAS].isSelected()) {
            buff.HIT_SHORT += 5;
            buff.ailment[STUN] += 10;
            if (ui.cb_buff[R_VALAKAS].getForeground().equals(Color.BLUE)) {
                cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //コンセントレーション 消費MP30/10mins
        ui.cb_buff[I_CON].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "MPR+4"
                                         + "<br>"+ "[習得レベル:30][持続時間:10分][対象:術者/PC]"+"</html>");
        if (ui.cb_buff[I_CON].isSelected()) {
            buff.MPR += 2;
            if (ui.cb_buff[I_CON].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //ペイシェンス 消費MP25/10mins
        ui.cb_buff[I_PAE].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "DR+2"
                                         + "<br>"+ "[習得レベル:45][持続時間:10分][対象:術者/PC]"+"</html>");
        if (ui.cb_buff[I_PAE].isSelected()) {
            buff.DR += 2;
            if (ui.cb_buff[I_PAE].getForeground().equals(Color.BLUE)) {
                cons_mp += (25.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //インサイト 消費MP60/10mins
        ui.cb_buff[I_INS].setToolTipText("<html>"+ "[消費MP:60][消費HP:--]"
                                         + "<br>"+ "STR+1 DEX+1 INT+1 CON+1 WIS+1"
                                         + "<br>"+ "[習得レベル:60][持続時間:10分40秒][対象:術者]"+"</html>");
        if (ui.cb_buff[I_INS].isSelected()) {
            buff.ST[STR]++;
            buff.ST[DEX]++;
            buff.ST[CON]++;
            buff.ST[INT]++;
            buff.ST[WIS]++;
            if (ui.cb_buff[I_INS].getForeground().equals(Color.BLUE)) {
                cons_mp += (60.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //幻術/キューブ[オーガ] 消費MP20/2mins
        ui.cb_buff[I_IOE].setToolTipText("<html>"+ "[消費MP:20/30][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーに近距離ダメージ+4 近距離命中+4 遠距離ダメージ+4 遠距離命中+4"
                                         + "<br>"+ "キャンセレーションで解除されない(術者のみ)"
                                         + "<br>"+ "[習得レベル:15/15][持続時間:2分8秒][対象:術者/PT][触媒:属性石(0/3)]"+"</html>");
        if (ui.cb_buff[I_IOE].isSelected()) {
            buff.DMG_SHORT += 4;
            buff.HIT_SHORT += 4;
            buff.DMG_LONG += 4;
            buff.HIT_LONG += 4;
            if (ui.cb_buff[I_IOE].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
            }
        }
        //幻術/キューブ[リッチ] 消費MP20/2mins
        ui.cb_buff[I_IRH].setToolTipText("<html>"+ "[消費MP:--/20][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーにSP+2"
                                         + "<br>"+ "[習得レベル:30/45][持続時間:常時/2分8秒][対象:術者/PT][触媒:属性石(0/3)]"+"</html>");
        if (ui.cb_buff[I_IRH].isSelected()) {
            buff.SP += 2;
            if (ui.cb_buff[I_IRH].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
            }
        }
        //幻術/キューブ[ゴーレム] 消費MP40/2mins
        ui.cb_buff[I_IGM].setToolTipText("<html>"+ "[消費MP:--/40][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーにAC-8"
                                         + "<br>"+ "キャンセレーションで解除されない(術者のみ)"
                                         + "<br>"+ "[習得レベル:45/30][持続時間:常時/2分8秒][対象:術者/PT][触媒:属性石(0/5)]"+"</html>");
        if (ui.cb_buff[I_IGM].isSelected()) {
            buff.AC -= 8;
            if (ui.cb_buff[I_IGM].getForeground().equals(Color.BLUE)) {
                cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
            }
        }
        //フォーカススピリッツ 消費MP30/5mins
        ui.cb_buff[I_FSZ].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "魔法クリティカル+5%"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:75][持続時間:5分][対象:術者][触媒:属性石(1)]"+"</html>");
        if (ui.cb_buff[I_FSZ].isSelected()) {
            buff.CRI_MAGIC += 5;
            if (ui.cb_buff[I_FSZ].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //インパクト 消費MP25/0.25mins
        ui.cb_buff[I_IMT].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーに"
                                         + "<br>"+ "技術命中+5 精霊命中+5 竜語命中+5 恐怖命中+5"
                                         + "<br>"+ "レベル80からレベル1毎に効果が+1ずつ増加[最大+10]"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:80][持続時間:15秒][対象:PT][触媒:属性石(5)]"+"</html>");
        if (ui.cb_buff[I_IMT].isSelected()) {
            if (level >= 80 && cls == I) {
                if (ui.cb_buff[I_IMT].getForeground().equals(Color.BLUE)) {
                    cons_mp += (25.0 * (1.0 - red_mp * 0.01) - red_mp2) / 0.25;
                }
            	if (level >= 85) {
        	    buff.ailment[HIT_STUN] += 10;                       //技術命中+10
        	    buff.ailment[HIT_SPIRIT] += 10;                     //精霊命中+10
        	    buff.ailment[HIT_SECRET] += 10;                     //秘技命中+10
        	    buff.ailment[HIT_TERROR] += 10;                     //恐怖命中+10      
        	} else if (level >= 80) {
        	    buff.ailment[HIT_STUN] += 5 + (level - 80);         //技術命中+(level - 75)
        	    buff.ailment[HIT_SPIRIT] += 5 + (level - 80);       //精霊命中+(level - 75)
        	    buff.ailment[HIT_SECRET] += 5 + (level - 80);       //秘技命中+(level - 75)
                    buff.ailment[HIT_TERROR] += 5 + (level - 80);       //恐怖命中+(level - 75)
        	}
            } else {
                ui.cb_buff[I_IMT].setSelected(false);
            }
        }
        //インフィニティ:アーマー
        ui.cb_buff[F_PIR].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                                 + "<br>"+ "レベル45からレベル4毎にダメージ低下が+1ずつ増加[最大+15]"
                                                 + "<br>"+ "[習得レベル:45][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PIR].isSelected()) {
            if (cls == F) {            	
		if (level >= 101) {
		    buff.DR += 15;          				//最大DR+15(LV101)
        	} else if (level >= 45) {
		    buff.DR += (level - 45) / 4 + 1;                    //DR+((level - 45) / 4 + 1)
        	}
            } else {
                ui.cb_buff[F_PIR].setSelected(false);
            }
        }
        //インフィニティ:ブリッツ
        ui.cb_buff[F_PIZ].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "レベル75からレベル1毎にERが+1ずつ増加[最大+15]"
                                         + "<br>"+ "[習得レベル:75][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PIZ].isSelected()) {
            if (cls == F) {            	
		if (level >= 89) {
		    buff.ER += 15;          				//最大ER+15(LV89)
        	} else if (level >= 75) {
		    buff.ER += (level - 75) / 1 + 1;                    //ER+((level - 75) / 1 + 1)
        	}
            } else {
                ui.cb_buff[F_PIZ].setSelected(false);
            }
        }
        //ドラゴンの祝福1と加護1(所持重量増加+500は別で処理)2か所の判定で実装している:6165行目参照
        ui.cb_buff[DRAGON_BLESS].setToolTipText("<html>"+ "ドラゴンの祝福:"
                                                + "<br>"+ "ダメージ減少+4"
                                                + "<br>"+ "全ての耐性+5"
                                                + "<br>"+ "PVPダメージ低下+5"
                                                + "<br>"+ "所持重量増加+500"
                                                + "<br>"
                                                + "<br>"+ "ドラゴンの加護:"
                                                + "<br>"+ "<ダメージ減少+2"
                                                + "<br>"+ "所持重量増加+100"+"</html>");

        if (ui.cb_buff[DRAGON_BLESS].isSelected()) {
            switch ((String) ui.cb_buff_group[DRAGON_BLESS].getSelectedItem()) {
                case "祝福":
                    ui.cb_buff[DRAGON_BLESS].setToolTipText("<html>"+ "ドラゴンの祝福:"
                                                            + "<br>"+ "ダメージ減少+4"
                                                            + "<br>"+ "全ての耐性+5"
                                                            + "<br>"+ "PVPダメージ低下+5"
                                                            + "<br>"+ "所持重量増加+500"+"</html>");
                    buff.DR += 4;                               //ダメージ減少+4
                    buff.ailment[STUN] += 5;                    //技術耐性+5
                    buff.ailment[SPIRIT] += 5;                  //精霊耐性+5
                    buff.ailment[SECRET] += 5;                  //秘技耐性+5
                    buff.ailment[TERROR] += 5;                  //恐怖耐性+5
                    buff.PVP_DR += 5;                           //PVPダメージ低下+5
                    break;
                case "加護":
                    ui.cb_buff[DRAGON_BLESS].setToolTipText("<html>"+ "ドラゴンの加護:"
                                                            + "<br>"+ "ダメージ減少+2"
                                                            + "<br>"+ "所持重量増加+100"+"</html>");
                    buff.DR += 2;                               //ダメージ減少+2
                    break;
                default:
                    break;
            }
        }

        //クレイ
        ui.cb_buff[CLAY].setToolTipText("<html>"+ "HP+100 MP+50 HPR+3 MPR+3"
                                        + "<br>"+ "近距離ダメージ+1 遠距離ダメージ+1 近距離命中+5"
                                        + "<br>"+ "地属性抵抗+30 ディクリースウェイト"+"</html>");
        if (ui.cb_buff[CLAY].isSelected()) {
            buff.HP += 100;
            buff.MP += 50;
            buff.HPR += 3;
            buff.MPR += 3;
            buff.DMG_SHORT += 1;
            buff.DMG_LONG += 1;
            buff.HIT_SHORT += 5;
            buff.element_resist[EARTH] += 30;
            ui.cb_buff[W_DWT].setSelected(true);
        }
        //もみじリング
        ui.cb_buff[MOMIJI].setToolTipText("HP+200 全ステータス+1");
        if (ui.cb_buff[MOMIJI].isSelected()) {
            buff.HP += 200;
            buff.ST[STR]++;
            buff.ST[DEX]++;
            buff.ST[CON]++;
            buff.ST[INT]++;
            buff.ST[WIS]++;
            buff.ST[CHA]++;
        }

        switch (ui.cb_pattern_l.getSelectedIndex()) {
            case 1:
                buff.ST[STR]++;
                break;
            case 2:
                buff.ST[DEX]++;
                break;
            case 3:
                buff.ST[CON]++;
                break;
            case 4:
                buff.ST[INT]++;
                break;
            case 5:
                buff.ST[WIS]++;
                break;
            case 6:
                buff.ST[CHA]++;
                break;
            case 7:
                buff.ST[STR] += 2;
                break;
            case 8:
                buff.ST[DEX] += 2;
                break;
            case 9:
                buff.ST[INT] += 2;
                break;
            case 10:
                buff.ST[STR]++;
                buff.HP += 80;
                buff.HPR += 5;
                break;
            case 11:
                buff.ST[INT]++;
                buff.MP += 50;
                buff.MPR += 3;
                break;
            case 12:
                buff.ST[STR]++;
                buff.HP += 100;
                buff.DMG_SHORT++;
                buff.HPR += 8;
                break;
            case 13:
                buff.ST[INT]++;
                buff.MP += 70;
                buff.SP++;
                buff.MPR += 5;
                break;
            case 14:
                buff.ST[DEX]++;
                buff.HP += 80;
                buff.MP += 50;
                buff.DMG_LONG++;
                buff.HPR += 5;
                buff.MPR += 3;
                break;
            default:
                break;
        }
        switch (ui.cb_pattern_r.getSelectedIndex()) {
            case 1:
                buff.HP += 120;
                break;
            case 2:
                buff.MP += 80;
                break;
            case 3:
                buff.AC -= 5;
                break;
            case 4:
                buff.AC -= 9;
                break;
            case 5:
                buff.element_resist[FIRE] += 30;
                break;
            case 6:
                buff.element_resist[WATER] += 30;
                break;
            case 7:
                buff.element_resist[WIND] += 30;
                break;
            case 8:
                buff.element_resist[EARTH] += 30;
                break;
            case 9:
                buff.element_resist[FIRE] += 30;
                buff.element_resist[WATER] += 30;
                buff.element_resist[WIND] += 30;
                buff.element_resist[EARTH] += 30;
                break;
            case 10:
                buff.AC -= 9;
                buff.HP += 120;
                break;
            case 11:
                buff.AC -= 9;
                buff.MP += 80;
                break;
            case 12:
                buff.AC -= 9;
                buff.HP += 80;
                buff.MP += 50;
                break;
            case 13:
                buff.AC -= 3;
                buff.DMG_SHORT += 3;
                buff.DMG_LONG += 3;
                buff.SP += 3;
                buff.MR += 10;
                break;
            default:
                break;
        }

        //エリクサールーン(LV70/80/85/90)
        int e = ui.elixir_rune.getSelectedIndex();
        int q = ui.elixir_rune_en.getSelectedIndex();
        if (e > 0 && e<6) {
            buff.ST[e - 1]++;
            switch (cls) {
                case P:
                    buff.DR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "ダメージ低下: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1:
                            buff.HIT_SHORT += 2;            //近距離命中+2
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2:
                            buff.HIT_SHORT += 2;            //近距離命中+2
                                                            //祝福消耗効率+5%
                                                            //PVP魔法ダメージ減少+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +1%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 3:
                            buff.HIT_SHORT += 2;            //近距離命中+2
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 5;    //技術命中+5
                                                            //PVP魔法ダメージ減少+2%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4:
                            buff.HIT_SHORT += 2;            //近距離命中+2
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 10;   //技術命中+10
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +10"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            
                            break;
                    }
                    break;
                case K:
                    buff.HP += 50;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "HP: +50"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1:
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2:
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                                                            //祝福消耗効率+5%
                                                            //PVP魔法ダメージ減少+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +1%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 3:
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 5;    //技術命中+5
                                                            //PVP魔法ダメージ減少+2%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4:
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 10;   //技術命中+10
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +10"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case E:
                    buff.MP += 50;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "MP: +50"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1:
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2:
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                                                            //祝福消耗効率+5%
                                                            //PVP魔法ダメージ減少+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +1%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 3:
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 5;  //精霊命中+5
                                                            //PVP魔法ダメージ減少+2%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4:
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 10; //精霊命中+10
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +10"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case W:
                    buff.MPR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "MPR: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1:
                            buff.SP += 1;                   //SP+1
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2:
                            buff.SP += 1;                   //SP+1
                                                            //祝福消耗効率+5%
                                                            //PVP魔法ダメージ減少+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +1%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 3:
                            buff.SP += 1;                   //SP+1
                                                            //祝福消耗効率+5%
                            buff.HIT_MAGIC += 5;            //魔法命中+5
                                                            //PVP魔法ダメージ減少+2%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "魔法命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4:
                            buff.SP += 1;                   //SP+1
                                                            //祝福消耗効率+5%
                            buff.HIT_MAGIC += 10;           //魔法命中+10
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "魔法命中: +10"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case D:
                    buff.AC -= 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "AC: -3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1:
                            buff.MP += 30;                  //最大MP+30
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2:
                            buff.MP += 30;                  //最大MP+30
                                                            //祝福消耗効率+5%
                                                            //PVP魔法ダメージ減少+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +1%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 3:
                            buff.MP += 30;                  //最大MP+30
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 5;  //精霊命中+5
                                                            //PVP魔法ダメージ減少+2%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4:
                            buff.MP += 30;                  //最大MP+30
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 10; //精霊命中+10
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +10"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case R:
                    buff.HIT_SHORT += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "近距離命中: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1:
                            buff.DR += 1;                   //ダメージ低下+1
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2:
                            buff.DR += 1;                   //ダメージ低下+1
                                                            //祝福消耗効率+5%
                                                            //PVP魔法ダメージ減少+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +1%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 3:
                            buff.DR += 1;                   //ダメージ低下+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 5;  //秘技命中+5
                                                            //PVP魔法ダメージ減少+2%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4:
                            buff.DR += 1;                   //ダメージ低下+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 10; //秘技命中+10
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +10"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case I:
                    buff.r_weight += 0.12;
//                    buff.c_weight += 300;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "所持重量増加: +300"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1:
                            buff.HP += 50;                  //最大HP+50
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2:
                            buff.HP += 50;                  //最大HP+50
                                                            //祝福消耗効率+5%
                                                            //PVP魔法ダメージ減少+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +1%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 3:
                            buff.HP += 50;                  //最大HP+50
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 5;  //秘技命中+5
                                                            //PVP魔法ダメージ減少+2%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4:
                            buff.HP += 50;                  //最大HP+50
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 10; //秘技命中+10
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +10"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case S:
                    buff.HP += 50;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "最大HP: +50"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1:
                            buff.MR += 5;                   //MR+5%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2:
                            buff.MR += 5;                   //MR+5%
                                                            //祝福消耗効率+5%
                                                            //PVP魔法ダメージ減少+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +1%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 3:
                            buff.MR += 5;                   //MR+5%
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 5;  //恐怖命中+5
                                                            //PVP魔法ダメージ減少+2%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4:
                            buff.MR += 5;                   //MR+5%
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 10; //恐怖命中+10
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +10"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case F:
                    buff.DR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "DR: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1:
                            buff.HIT_SHORT += 3;            //近距離命中+3
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2:
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                                                            //PVP魔法ダメージ減少+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +1%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 3:
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 5;  //恐怖命中+5
                                                            //PVP魔法ダメージ減少+2%
                            ui.elixir_rune.setToolTipText("<html>"+  "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4:
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 10; //恐怖命中+10
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +10"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

        }else if (e == 0){                              //未使用
                    ui.elixir_rune.setToolTipText("");
        }else if (e == 6){                              //アルカの遺物
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //近距離ダメージ+2
                    buff.HIT_SHORT += 2;                //近距離命中+2
                    buff.DMG_LONG += 2;                 //遠距離ダメージ+2
                    buff.HIT_LONG += 2;                 //遠距離命中+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_MAGIC += 2;                //魔法命中+2
                    buff.MR += 5;                       //MR+5%
                    buff.MEXP += 2;                     //獲得経験値+2%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -3"
                                                  + "<br>"+ "近距離ダメージ: +2"
                                                  + "<br>"+ "近距離命中: +2"
                                                  + "<br>"+ "遠距離ダメージ: +2"
                                                  + "<br>"+ "遠距離命中: +2"                            
                                                  + "<br>"+ "SP: +2"
                                                  + "<br>"+ "魔法命中: +2"
                                                  + "<br>"+ "MR: +5%"
                                                  + "<br>"+ "獲得経験値: +2%"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 7){                              //強化されたアルカの遺物
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //近距離ダメージ+2
                    buff.HIT_SHORT += 2;                //近距離命中+2
                    buff.DMG_LONG += 2;                 //遠距離ダメージ+2
                    buff.HIT_LONG += 2;                 //遠距離命中+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_MAGIC += 2;                //魔法命中+2
                    buff.MR += 5;                       //MR+5%
                    buff.ailment[TERROR] += 5;          //恐怖耐性+5
                    buff.MEXP += 5;                     //獲得経験値+5%                    
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -3"
                                                  + "<br>"+ "近距離ダメージ: +2"
                                                  + "<br>"+ "近距離命中: +2"
                                                  + "<br>"+ "遠距離ダメージ: +2"
                                                  + "<br>"+ "遠距離命中: +2"                            
                                                  + "<br>"+ "SP: +2"
                                                  + "<br>"+ "魔法命中: +2"
                                                  + "<br>"+ "MR: +5%"
                                                  + "<br>"+ "恐怖耐性: +5"
                                                  + "<br>"+ "獲得経験値: +5%"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 8){                              //ドラゴンの遺物
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //近距離ダメージ+2
                    buff.HIT_SHORT += 2;                //近距離命中+2
                    buff.DMG_LONG += 2;                 //遠距離ダメージ+2
                    buff.HIT_LONG += 2;                 //遠距離命中+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_MAGIC += 2;                //魔法命中+2
                    buff.MEXP += 2;                     //獲得経験値+2%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -3"
                                                  + "<br>"+ "近距離ダメージ: +2"
                                                  + "<br>"+ "近距離命中: +2"
                                                  + "<br>"+ "遠距離ダメージ: +2"
                                                  + "<br>"+ "遠距離命中: +2"                            
                                                  + "<br>"+ "SP: +2"
                                                  + "<br>"+ "魔法命中: +2"
                                                  + "<br>"+ "獲得経験値: +2%"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 9){                              //強化されたドラゴンの遺物(腕力)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[STR] += 1;                  //STR+1
                    buff.DMG_SHORT += 4;                //近距離ダメージ+4
                    buff.HIT_SHORT += 6;                //近距離命中+6
                    buff.MEXP += 10;                    //獲得経験値+10%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "STR: +1"
                                                  + "<br>"+ "近距離ダメージ: +4"
                                                  + "<br>"+ "近距離命中: +6"
                                                  + "<br>"+ "獲得経験値: +10%"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 10){                             //強化されたドラゴンの遺物(知力)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[INT] += 1;                  //INT+1
                    buff.SP += 4;                       //SP+4
                    buff.HIT_MAGIC += 6;                //魔法命中+6
                    buff.MEXP += 10;                    //獲得経験値+10%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "INT: +1"
                                                  + "<br>"+ "SP: +4"
                                                  + "<br>"+ "魔法命中: +6"
                                                  + "<br>"+ "獲得経験値: +10%"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 11){                             //強化されたドラゴンの遺物(機敏)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[DEX] += 1;                  //DEX+1
                    buff.DMG_LONG += 4;                 //遠距離ダメージ+4
                    buff.HIT_LONG += 6;                 //遠距離命中+6
                    buff.MEXP += 10;                    //獲得経験値+10%          
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "DEX: +1"
                                                  + "<br>"+ "遠距離ダメージ: +4"
                                                  + "<br>"+ "遠距離命中: +6"
                                                  + "<br>"+ "獲得経験値: +10%"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 12){                             //真デスナイトの遺物
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //近距離ダメージ+2
                    buff.HIT_SHORT += 2;                //近距離命中+2
                    buff.DMG_LONG += 2;                 //遠距離ダメージ+2
                    buff.HIT_LONG += 2;                 //遠距離命中+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_MAGIC += 2;                //魔法命中+2
                    buff.MEXP += 2;                     //獲得経験値+2%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -3"
                                                  + "<br>"+ "近距離ダメージ: +2"
                                                  + "<br>"+ "近距離命中: +2"
                                                  + "<br>"+ "遠距離ダメージ: +2"
                                                  + "<br>"+ "遠距離命中: +2"                            
                                                  + "<br>"+ "SP: +2"
                                                  + "<br>"+ "魔法命中: +2"
                                                  + "<br>"+ "獲得経験値: +2%"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 13){                             //強化された真デスナイトの遺物(腕力)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[STR] += 1;                  //STR+1
                    buff.DMG_SHORT += 4;                //近距離ダメージ+4
                    buff.HIT_SHORT += 6;                //近距離命中+6
                    buff.MEXP += 10;                    //獲得経験値+10%
                                                        //祝福消耗効率+5%
                                                        //全耐性+3
                    buff.ailment[STUN] += 3;            //技術耐性+3
                    buff.ailment[SPIRIT] += 3;          //精霊耐性+3
                    buff.ailment[SECRET] += 3;          //秘技耐性+3
                    buff.ailment[TERROR] += 3;          //恐怖耐性+3
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "STR: +1"
                                                  + "<br>"+ "近距離ダメージ: +4"
                                                  + "<br>"+ "近距離命中: +6"
                                                  + "<br>"+ "獲得経験値: +10%"
                                                  + "<br>"+ "祝福消耗効率: +5%"                            
                                                  + "<br>"+ "技術耐性: +3"
                                                  + "<br>"+ "精霊耐性: +3"
                                                  + "<br>"+ "秘技耐性: +3"
                                                  + "<br>"+ "恐怖耐性: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 14){                             //強化された真デスナイトの遺物(知力)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[INT] += 1;                  //INT+1
                    buff.SP += 4;                       //SP+4
                    buff.HIT_MAGIC += 6;                //魔法命中+6
                    buff.MEXP += 10;                    //獲得経験値+10%
                                                        //祝福消耗効率+5%
                                                        //全耐性+3
                    buff.ailment[STUN] += 3;            //技術耐性+3
                    buff.ailment[SPIRIT] += 3;          //精霊耐性+3
                    buff.ailment[SECRET] += 3;          //秘技耐性+3
                    buff.ailment[TERROR] += 3;          //恐怖耐性+3
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "INT: +1"
                                                  + "<br>"+ "SP: +4"
                                                  + "<br>"+ "魔法命中: +6"
                                                  + "<br>"+ "獲得経験値: +10%"
                                                  + "<br>"+ "祝福消耗効率: +5%"                            
                                                  + "<br>"+ "技術耐性: +3"
                                                  + "<br>"+ "精霊耐性: +3"
                                                  + "<br>"+ "秘技耐性: +3"
                                                  + "<br>"+ "恐怖耐性: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 15){                             //強化された真デスナイトの遺物(機敏)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[DEX] += 1;                  //DEX+1
                    buff.DMG_LONG += 4;                 //遠距離ダメージ+4
                    buff.HIT_LONG += 6;                 //遠距離命中+6
                    buff.MEXP += 10;                    //獲得経験値+10%          
                                                        //祝福消耗効率+5%
                                                        //全耐性+3
                    buff.ailment[STUN] += 3;            //技術耐性+3
                    buff.ailment[SPIRIT] += 3;          //精霊耐性+3
                    buff.ailment[SECRET] += 3;          //秘儀耐性+3
                    buff.ailment[TERROR] += 3;          //恐怖耐性+3
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "DEX: +1"
                                                  + "<br>"+ "遠距離ダメージ: +4"
                                                  + "<br>"+ "遠距離命中: +6"
                                                  + "<br>"+ "獲得経験値: +10%"
                                                  + "<br>"+ "祝福消耗効率: +5%"                            
                                                  + "<br>"+ "技術耐性: +3"
                                                  + "<br>"+ "精霊耐性: +3"
                                                  + "<br>"+ "秘技耐性: +3"
                                                  + "<br>"+ "恐怖耐性: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }
        //タリスマン
            switch (ui.cb_pattern_l2.getSelectedIndex()) {
                case 0:
                    break;
                case 1:                                 //四つ星(近距離)
                    buff.DMG_SHORT += 1;    //近距離ダメージ+1
                    buff.HIT_SHORT += 1;    //近距離命中+1
                    buff.SP += 1;           //SP+1
                    buff.MR += 5;           //MR+5
                    break;
                case 2:                                 //四つ星(遠距離)
                    buff.DMG_LONG += 1;     //遠距離ダメージ+1
                    buff.HIT_LONG += 1;     //遠距離命中+1
                    buff.SP += 1;           //SP+1
                    buff.MR += 5;           //MR+5
                    break;
                case 3:                                 //六つ星(近距離/遠距離)
                    buff.DMG_SHORT += 1;    //近距離ダメージ+1
                    buff.HIT_SHORT += 1;    //近距離命中+1
                    buff.DMG_LONG += 1;     //遠距離ダメージ+1
                    buff.HIT_LONG += 1;     //遠距離命中+1
                    buff.SP += 1;           //SP+1
                    buff.MR += 5;           //MR+5
                    break;
                case 4:                                 //象牙の塔のタリスマン
                    break;
                default:
                    break;
            }
        //オルターストーン
        if (ui.cb_pattern_r2.getSelectedIndex() >= 6 && ui.cb_pattern_r2.getSelectedIndex() <= 8) {

            ui.cb_alterstone_en.setEnabled(true);
            if (ui.cb_alterstone_en.getSelectedIndex() >= 3) {
                ui.cb_alterstone_op[0].setEnabled(true);
                switch (ui.cb_alterstone_op[0].getSelectedIndex()) {
                    case 1:
                        buff.DMG_SHORT += 1;        //近距離ダメージ +1
                        break;
                    case 2:
                        buff.DMG_LONG += 1;         //遠距離ダメージ +1
                        break;
                    case 3:
                        buff.HIT_SHORT += 2;        //近距離命中 +2
                        break;
                    case 4:
                        buff.HIT_LONG += 2;         //遠距離命中 +2
                        break;
                    case 5:
                        buff.SP += 1;               //SP +1
                        break;
                    case 6:
                        buff.CRI_MAGIC += 1;        //魔法クリティカル +1
                        break;
                    case 7:
                                                    //魔法消耗減少+2
                        break;
                    case 8:
                                                    //一撃必殺(1%確率で追加ダメージ50) 3216行で追加処理
                        break;
                    default:
                        break;
                }
            } else {
                ui.cb_alterstone_op[0].setEnabled(false);
            }
            if (ui.cb_alterstone_en.getSelectedIndex() >= 4) {
                ui.cb_alterstone_op[1].setEnabled(true);
                switch (ui.cb_alterstone_op[1].getSelectedIndex()) {
                    case 1:
                        buff.DMG_SHORT += 1;        //近距離ダメージ +1
                        break;
                    case 2:
                        buff.DMG_LONG += 1;         //遠距離ダメージ +1
                        break;
                    case 3:
                        buff.HIT_SHORT += 2;        //近距離命中 +2
                        break;
                    case 4:
                        buff.HIT_LONG += 2;         //遠距離命中 +2
                        break;
                    case 5:
                        buff.SP += 1;               //SP +1
                        break;
                    case 6:
                        buff.CRI_MAGIC += 1;        //魔法クリティカル +1
                        break;
                    case 7:
                                                    //魔法消耗減少+2
                        break;
                    case 8:
                                                    //一撃必殺(1%確率で追加ダメージ50) 3216行で追加処理
                        break;
                    default:
                        break;
                }
            } else {
                ui.cb_alterstone_op[1].setEnabled(false);
            }
            if (ui.cb_alterstone_en.getSelectedIndex() >= 5) {
                ui.cb_alterstone_op[2].setEnabled(true);
                switch (ui.cb_alterstone_op[2].getSelectedIndex()) {
                    case 1:
                        buff.DMG_SHORT += 1;        //近距離ダメージ +1
                        break;
                    case 2:
                        buff.DMG_LONG += 1;         //遠距離ダメージ +1
                        break;
                    case 3:
                        buff.HIT_SHORT += 2;        //近距離命中 +2
                        break;
                    case 4:
                        buff.HIT_LONG += 2;         //遠距離命中 +2
                        break;
                    case 5:
                        buff.SP += 1;               //SP +1
                        break;
                    case 6:
                        buff.CRI_MAGIC += 1;        //魔法クリティカル +1
                        break;
                    case 7:
                                                    //魔法消耗減少+2
                        break;
                    case 8:
                                                    //一撃必殺(1%確率で追加ダメージ50) 3216行で追加処理
                        break;
                    default:
                        break;
                }
            } else {
                ui.cb_alterstone_op[2].setEnabled(false);
            }
        } else {
            ui.cb_alterstone_en.setEnabled(false);
            ui.cb_alterstone_op[0].setEnabled(false);
            ui.cb_alterstone_op[1].setEnabled(false);
            ui.cb_alterstone_op[2].setEnabled(false);
        }

        switch (ui.cb_pattern_r2.getSelectedIndex()) {
            case 1:
                buff.HPR += 2;
                break;
            case 2:
                buff.MPR++;
                break;
            case 3:
                buff.DMG_SHORT++;
                buff.HIT_SHORT += 2;
                buff.MR += 5;
                break;
            case 4:
                buff.DMG_LONG++;
                buff.HIT_LONG += 2;
                buff.MR += 5;
                break;
            case 5:
                buff.SP++;
                buff.MR += 5;
                break;
            case 6:
                //オルターストーン 勇猛
                switch (ui.cb_alterstone_en.getSelectedIndex()) {
                    case 1:
                        buff.HP += 20;
                        break;
                    case 2:
                        buff.HP += 25;
                        buff.MP += 5;
                        break;
                    case 3:
                        buff.HP += 30;
                        buff.MP += 10;
                        buff.ST[STR] += 1;
                        break;
                    case 4:
                        buff.HP += 40;
                        buff.MP += 20;
                        buff.ST[STR] += 1;
                        buff.HIT_SHORT += 1;
                        break;
                    case 5:
                        buff.HP += 50;
                        buff.MP += 30;
                        buff.ST[STR] += 1;
                        buff.HIT_SHORT += 1;
                        buff.DMG_SHORT += 1;
                        break;
                    //オルターストーン6段階
                    case 6:
                        buff.HP += 60;
                        buff.MP += 40;
                        buff.ST[STR] += 1;
                        buff.HIT_SHORT += 1;
                        buff.DMG_SHORT += 1;
                        buff.MR += 5;
                        buff.DR += 1;
                        break;     
                    //オルターストーン7段階
                    case 7:
                        buff.AC -= 1;
                        buff.ST[STR] += 1;
                        buff.DMG_SHORT += 1;
                        buff.HIT_SHORT += 2;
                        buff.DR += 1;
                        buff.MR += 6;
                        buff.HP += 70;
                        buff.MP += 50;
                        break;
                    default:
                        break;
                }
                break;
            case 7:
                //オルターストーン 魔弾
                switch (ui.cb_alterstone_en.getSelectedIndex()) {
                    case 1:
                        buff.HP += 10;
                        buff.MP += 10;
                        break;
                    case 2:
                        buff.HP += 15;
                        buff.MP += 15;
                        break;
                    case 3:
                        buff.HP += 20;
                        buff.MP += 20;
                        buff.ST[DEX] += 1;
                        break;
                    case 4:
                        buff.HP += 30;
                        buff.MP += 30;
                        buff.ST[DEX] += 1;
                        buff.HIT_LONG += 1;
                        break;
                    case 5:
                        buff.HP += 40;
                        buff.MP += 40;
                        buff.ST[DEX] += 1;
                        buff.HIT_LONG += 1;
                        buff.DMG_LONG += 1;
                        break;
                    //オルターストーン6段階   
                    case 6:   
                        buff.HP += 50;
                        buff.MP += 50;
                        buff.ST[DEX] += 1;
                        buff.HIT_LONG += 1;
                        buff.DMG_LONG += 1;
                        buff.MR += 5;
                        buff.DR += 1;
                        break;
                    //オルターストーン7段階
                    case 7:
                        buff.AC -= 1;
                        buff.ST[DEX] += 1;
                        buff.DMG_LONG += 1;
                        buff.HIT_LONG += 2;
                        buff.DR += 1;
                        buff.MR += 6;
                        buff.HP += 60;
                        buff.MP += 60;
                        break;
                    default:
                        break;
                }
                break;
            case 8:
                //オルターストーン 叡智
                switch (ui.cb_alterstone_en.getSelectedIndex()) {
                    case 1:
                        buff.MP += 20;
                        break;
                    case 2:
                        buff.HP += 5;
                        buff.MP += 25;
                        break;
                    case 3:
                        buff.HP += 10;
                        buff.MP += 30;
                        buff.ST[INT] += 1;
                        break;
                    case 4:
                        buff.HP += 20;
                        buff.MP += 40;
                        buff.ST[INT] += 1;
                        buff.MPR += 1;
                        break;
                    case 5:
                        buff.HP += 30;
                        buff.MP += 50;
                        buff.ST[INT] += 1;
                        buff.MPR += 1;
                        buff.SP += 1;
                        break;
                    //オルターストーン6段階
                    case 6:
                        buff.HP += 40;
                        buff.MP += 60;
                        buff.ST[INT] += 1;
                        buff.MPR += 1;
                        buff.SP += 1;
                        buff.MR += 5;
                        buff.DR += 1;
                        break;
                    //オルターストーン7段階
                    case 7:
                        buff.AC -= 1;
                        buff.ST[INT] += 1;
                        buff.SP += 1;
                        buff.DR += 1;
                        buff.MR += 6;
                        buff.HP += 50;
                        buff.MP += 70;
                        buff.MPR += 2;
                        break;
                    default:
                        break;
                }
                break;
        }

        //STR
        ui.cb_buff[B_STR].setToolTipText("<html>"+ "STR+3 ドレスマイティ"
                                         + "<br>"+ "STR+5 フィジカルエンチャント"
                                         + "<br>"+ "STR+6 激励のポーション"
                                         + "<br>"+ "STR+6(DEX+6) フローラのポーション"
                                         + "<br>"+ "STR+6(DEX+6 AC-5) 四季のポーション"
                                         + "<br>"+ "STR+7 偉大な勇者のスクロール"
                                         + "<br>"+ "STR+7(DEX+7) クリスマスキャンディー"+"</html>");
        if (ui.cb_buff[B_STR].isSelected()) {
            switch (ui.cb_buff_group[B_STR].getSelectedIndex()) {
                case 0:
                    ui.cb_buff[B_STR].setToolTipText("STR+3 ドレスマイティ");
                    buff.ST[STR] += 3;
                    if (ui.cb_buff[B_STR].getForeground().equals(Color.BLUE)) {
                        cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                    }
                    break;
                case 1:
                    ui.cb_buff[B_STR].setToolTipText("STR+5 フィジカルエンチャント");
                    buff.ST[STR] += 5;
                    if (ui.cb_buff[B_STR].getForeground().equals(Color.BLUE)) {
                        cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 2:
                    ui.cb_buff[B_STR].setToolTipText("<html>"+ "STR+6 激励のポーション"
                                                     + "<br>"+ "STR+6(DEX+6) フローラのポーション"
                                                     + "<br>"+ "STR+6(DEX+6 AC-5) 四季のポーション"+"</html>");
                    buff.ST[STR] += 6;
                    break;
                case 3:
                    ui.cb_buff[B_STR].setToolTipText("<html>"+ "STR+7 偉大な勇者のスクロール"
                                                     + "<br>"+ "STR+7(DEX+7) クリスマスキャンディー"+"</html>");
                    buff.ST[STR] += 7;
                    break;
                default:
                    break;
            }
        }
        //DEX
        ui.cb_buff[B_DEX].setToolTipText("<html>"+ "DEX+3 ドレスデクスタリティー"
                                         + "<br>"+ "DEX+5 フィジカルエンチャント"
                                         + "<br>"+ "DEX+6 才能のポーション"
                                         + "<br>"+ "DEX+6(STR+6) フローラのポーション"
                                         + "<br>"+ "DEX+6(STR+6 AC-5) 四季のポーション"
                                         + "<br>"+ "DEX+7 偉大な名弓のスクロール"
                                         + "<br>"+ "DEX+7(STR+7) クリスマスキャンディー"+"</html>");
        if (ui.cb_buff[B_DEX].isSelected()) {
            switch (ui.cb_buff_group[B_DEX].getSelectedIndex()) {
                case 0:
                    ui.cb_buff[B_DEX].setToolTipText("DEX+3 ドレスデクスタリティー");
                    buff.ST[DEX] += 3;
                    if (ui.cb_buff[B_DEX].getForeground().equals(Color.BLUE)) {
                        cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                    }
                    break;
                case 1:
                    ui.cb_buff[B_DEX].setToolTipText("DEX+5 フィジカルエンチャント");
                    buff.ST[DEX] += 5;
                    if (ui.cb_buff[B_DEX].getForeground().equals(Color.BLUE)) {
                        cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 2:
                    ui.cb_buff[B_DEX].setToolTipText("<html>"+ "DEX+6 才能のポーション"
                                                     + "<br>"+ "DEX+6(STR+6) フローラのポーション"
                                                     + "<br>"+ "DEX+6(STR+6 AC-5) 四季のポーション"+"</html>");
                    buff.ST[DEX] += 6;
                    break;
                case 3:
                    ui.cb_buff[B_DEX].setToolTipText("<html>"+ "DEX+7 偉大な名弓のスクロール"
                                                     + "<br>"+ "DEX+7(STR+7) クリスマスキャンディー"+"</html>");
                    buff.ST[DEX] += 7;
                    break;
                default:
                    break;
            }
        }

        acc = 1.0;

        //装備による強制ヘイスト効果
        if (buki.op.effect.contains("ヘイスト")) {
            ui.cb_buff[ACC1].setSelected(true);
        }
        for (Bougu bougu1 : bougu) {
            if (bougu1.op.effect.contains("ヘイスト")) {
                ui.cb_buff[ACC1].setSelected(true);
                break;
            }
        }
        //POTによるヘイスト効果
        ui.cb_buff[ACC1].setToolTipText("x1.3333:GP GGP ワイン ウイスキー");
        if (ui.cb_buff[ACC1].isSelected()) {
            if (ui.cb_buff[ACC1].getForeground().equals(Color.BLUE)) {
                cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
            }
            acc *= acc_1;
        }
        ui.cb_buff[ACC2].setToolTipText("<html>"+ "x1.3333:BP イビルブラッド ブラッドラスト 名誉のコイン ダンシングブレイズ フォーカスウェーブ ハリケーン サンドストーム"
                                        + "<br>"+ "x1.1547:EW 濃縮集中ポーション"
                                        + "<br>"+ "x1.0800:ダークホース"+"</html>");
        if (ui.cb_buff[ACC2].isSelected()) {
            switch (ui.cb_buff_group[ACC2].getSelectedIndex()) {
                case 0:
                    ui.cb_buff[ACC2].setToolTipText("x1.3333:BP イビルブラッド ブラッドラスト 名誉のコイン ダンシングブレイズ フォーカスウェーブ ハリケーン サンドストーム");
                    acc *= acc_2;
                    if (ui.cb_buff[ACC2].getForeground().equals(Color.BLUE)) {
                        if (cls == E) {
                            cons_mp = (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 8;
                        }
                    }
                    break;
                case 1:
                    ui.cb_buff[ACC2].setToolTipText("x1.1547:EW 濃縮集中ポーション");
                    acc *= acc_ew;
                    break;
                case 2:
                    ui.cb_buff[ACC2].setToolTipText("x1.0800:ダークホース");
                    acc *= acc_df;
                    break;
                default:
                    break;
            }
        }
        ui.cb_buff[ACC3].setToolTipText("x1.1250:ドラゴンブラッド 蔵出し秘蔵酒");
        if (ui.cb_buff[ACC3].isSelected()) {
            acc *= acc_3;
        }
        
//2019/11/20Update HW/EW/BW/SFの仕様変更
//今までは武器にエンチャント効果があったが今後はキャラに効果が発生
//2019/12/25に旧計算方法でのダメージ計算もできるように項目追加
        buki.magic_enchant = 0;
        buki2.magic_enchant = 0;
        ui.cb_buff[BUKI].setToolTipText("<html>"+ "近距離ダメージ+1 近距離命中+1 ホーリーウェポン"
                                        + "<br>"+ "近距離ダメージ+2 エンチャントウェポン"
                                        + "<br>"+ "近距離ダメージ+2 近距離命中+2 ブレスウェポン"
                                        + "<br>"+ "近距離ダメージ+5 シャドウファング"+"</html>");
        if (ui.cb_buff[BUKI].isSelected()) {
            switch (ui.cb_buff_group[BUKI].getSelectedIndex()) {
                case 0://ホーリーウェポン 近距離ダメージ+1 近距離命中+1(キャラに対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+1 近距離命中+1 ホーリーウェポン(キャラに対して)");
                    buff.DMG_SHORT += 1;
                    buff.HIT_SHORT += 1;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 1://エンチャントウェポン 近距離ダメージ+2(キャラに対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+2 エンチャントウェポン(キャラに対して)");
                    buff.DMG_SHORT += 2;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
                    }
                    break;
                case 2://ブレスウェポン 近距離ダメージ+2 近距離命中+2(キャラに対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+2 近距離命中+2 ブレスウェポン(キャラに対して)");
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 3://シャドウファング 近距離ダメージ+5(キャラに対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+5 シャドウファング(キャラに対して)");
                    buff.DMG_SHORT += 5;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 3;
                    }
                    break;
                case 4://ホーリーウェポン 近距離ダメージ+1 近距離命中+1(武器に対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+1 近距離命中+1 ホーリーウェポン(武器に対して)");
                    buki.magic_enchant = 1;
                    buki2.magic_enchant = 1;
                    buff.HIT_SHORT += 1;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 5://エンチャントウェポン 近距離ダメージ+2(武器に対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+2 エンチャントウェポン(武器に対して)");
                    buki.magic_enchant = 2;
                    buki2.magic_enchant = 2;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
                    }
                    break;
                case 6://ブレスウェポン 近距離ダメージ+2 近距離命中+2(武器に対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+2 近距離命中+2 ブレスウェポン(武器に対して)");
                    buki.magic_enchant = 2;
                    buki2.magic_enchant = 2;
                    buff.HIT_SHORT += 2;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 7://シャドウファング 近距離ダメージ+5(武器に対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+5 シャドウファング(武器に対して)");
                    buki.magic_enchant = 5;
                    buki2.magic_enchant = 5;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 3;
                    }
                    break;
                default:
                    break;
            }
        }
//君主魔法（プリンス・プリンセス)
        //グローイングウェポン 消費MP25/10mins
        ui.cb_buff[P_GWN].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "近距離ダメージ+5 近距離命中+5"
                                         + "<br>"+ "[習得レベル:60][持続時間:10分40秒][対象:術者]"+"</html>");
            if (ui.cb_buff[P_GWN].isSelected()) {
            buff.HIT_SHORT += 5;
            buff.DMG_SHORT += 5;
            if (ui.cb_buff[P_GWN].getForeground().equals(Color.BLUE)) {
                cons_mp += (25.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //シャイニングシールド
        ui.cb_buff[P_SSD].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "術者にAC-8/PTメンバーにはAC-4"
                                         + "<br>"+ "[習得レベル:75][持続時間:10分40秒][対象:術者/PTメンバー]"+"</html>");
            if (ui.cb_buff[P_SSD].isSelected()) {
            switch ((String) ui.cb_buff_group[P_SSD].getSelectedItem()) {
                case "術者":
                    ui.cb_buff[P_SSD].setToolTipText("AC-8");
                    buff.AC -= 8;
                    break;
                case "PTメンバー":
                    ui.cb_buff[P_SSD].setToolTipText("AC-4");
                    buff.AC -= 4;
                    break;
                default:
                    break;
            }
        }
        //シャイニングアーマー 消費MP25 HP50/5mins
        ui.cb_buff[P_SAR].setToolTipText("<html>"+ "[消費MP:25][消費HP:50]"
                                         + "<br>"+ "ER+10"
                                         + "<br>"+ "[習得レベル:80][持続時間:5分][対象:術者]"+"</html>");
        if (ui.cb_buff[P_SAR].isSelected()) {
            buff.ER += 10;
            if (ui.cb_buff[P_SAR].getForeground().equals(Color.BLUE)) {
                cons_mp += (25.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //マジェスティ 消費MP20 HP50/5mins
        ui.cb_buff[P_MAY].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "DR+2(レベル80から2つレベルが上がる毎に+1)"
                                         + "<br>"+ "[習得レベル:80][持続時間:5分][対象:術者]"+"</html>");
        if (ui.cb_buff[P_MAY].isSelected()) {
        //DR+2(レベル80から2つレベルが上がる毎に+1)
            if (level <= 80) {
                buff.DR += 2;
            } else if (level > 80) {
                buff.DR += 2+(level/2-40);
            }
            if (ui.cb_buff[P_MAY].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //オーラ(旧名:ブレイブアバター) 消費MP0/常時 STR+1 DEX+1 INT+1 MR+10% 技術耐性+2 精霊耐性+2 秘技耐性+2 恐怖耐性+2
        ui.cb_buff[P_AUA].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "術者と18セル内のPTメンバーに常時効果が持続する"
                                         + "<br>"+ "STR+1 DEX+1 INT+1 MR+10 技術耐性+2 精霊耐性+2 竜語耐性+2 恐怖耐性+2"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者/PTメンバー]"+"</html>");
        if (ui.cb_buff[P_AUA].isSelected()) {
            buff.MR += 10;
            buff.ailment[STUN] += 2;
            buff.ailment[SPIRIT] += 2;
            buff.ailment[SECRET] += 2;
            buff.ailment[TERROR] += 2;
            buff.ST[STR] += 1;
            buff.ST[DEX] += 1;
            buff.ST[INT] += 1;
        }
        //グレース(旧名:グレースアバター) 消費MP15/15秒 技術耐性+5 精霊耐性+5 秘技耐性+5 恐怖耐性+5 レベル80から+1ずつ増加(最大+15)
        ui.cb_buff[P_GRE].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "18セル内のPTメンバーに全スキル耐性+5"
                                         + "<br>"+ "レベル80からレベル1毎に効果が+1ずつ増加[最大+10]"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "レベル80 技術耐性+5 精霊耐性+5 秘技耐性+5 恐怖耐性+5"
                                         + "<br>"+ "レベル85 技術耐性+10 精霊耐性+10 秘技耐性+10 恐怖耐性+10"
                                         + "<br>"+ "レベル90 技術耐性+15 精霊耐性+15 秘技耐性+15 恐怖耐性+15"
                                         + "<br>"+ "[習得レベル:80][持続時間:1分][対象:PTメンバー]"+"</html>");
        if (ui.cb_buff[P_GRE].isSelected()) {
            switch ((String) ui.cb_buff_group[P_GRE].getSelectedItem()) {
                case "君主L80":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+5 精霊耐性+5 秘技耐性+5 恐怖耐性+5");
                    buff.ailment[STUN] += 5;
                    buff.ailment[SPIRIT] += 5;
                    buff.ailment[SECRET] += 5;
                    buff.ailment[TERROR] += 5;
                    break;
                case "君主L81":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+6 精霊耐性+6 秘技耐性+6 恐怖耐性+6");
                    buff.ailment[STUN] += 6;
                    buff.ailment[SPIRIT] += 6;
                    buff.ailment[SECRET] += 6;
                    buff.ailment[TERROR] += 6;
                    break;
                case "君主L82":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+7 精霊耐性+7 秘技耐性+7 恐怖耐性+7");
                    buff.ailment[STUN] += 7;
                    buff.ailment[SPIRIT] += 7;
                    buff.ailment[SECRET] += 7;
                    buff.ailment[TERROR] += 7;
                    break;
                case "君主L83":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+8 精霊耐性+8 秘技耐性+8 恐怖耐性+8");
                    buff.ailment[STUN] += 8;
                    buff.ailment[SPIRIT] += 8;
                    buff.ailment[SECRET] += 8;
                    buff.ailment[TERROR] += 8;
                    break;
                case "君主L84":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+9 精霊耐性+9 秘技耐性+9 恐怖耐性+9");
                    buff.ailment[STUN] += 9;
                    buff.ailment[SPIRIT] += 9;
                    buff.ailment[SECRET] += 9;
                    buff.ailment[TERROR] += 9;
                    break;
                case "君主L85":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+10 精霊耐性+10 秘技耐性+10 恐怖耐性+10");
                    buff.ailment[STUN] += 10;
                    buff.ailment[SPIRIT] += 10;
                    buff.ailment[SECRET] += 10;
                    buff.ailment[TERROR] += 10;
                    break;
                case "君主L86":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+11 精霊耐性+11 秘技耐性+11 恐怖耐性+11");
                    buff.ailment[STUN] += 11;
                    buff.ailment[SPIRIT] += 11;
                    buff.ailment[SECRET] += 11;
                    buff.ailment[TERROR] += 11;
                    break;
                case "君主L87":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+12 精霊耐性+12 秘技耐性+12 恐怖耐性+12");
                    buff.ailment[STUN] += 12;
                    buff.ailment[SPIRIT] += 12;
                    buff.ailment[SECRET] += 12;
                    buff.ailment[TERROR] += 12;
                    break;
                case "君主L88":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+13 精霊耐性+13 秘技耐性+13 恐怖耐性+13");
                    buff.ailment[STUN] += 13;
                    buff.ailment[SPIRIT] += 13;
                    buff.ailment[SECRET] += 13;
                    buff.ailment[TERROR] += 13;
                    break;
                case "君主L89":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+14 精霊耐性+14 秘技耐性+14 恐怖耐性+14");
                    buff.ailment[STUN] += 14;
                    buff.ailment[SPIRIT] += 14;
                    buff.ailment[SECRET] += 14;
                    buff.ailment[TERROR] += 14;
                    break;
                case "君主L90+":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+15 精霊耐性+15 秘技耐性+15 恐怖耐性+15");
                    buff.ailment[STUN] += 10;
                    buff.ailment[SPIRIT] += 10;
                    buff.ailment[SECRET] += 10;
                    buff.ailment[TERROR] += 10;
                    break;
                default:
                    break;
            }
        }
//プライム [消費MP:25][消費HP:--][習得レベル:85][持続時間:20分][対象:血盟員][触媒:結晶体(200)] 技術命中+5（術者のみ）近距離ダメージ+3 近距離命中+3 遠距離ダメージ+3 遠距離命中+3 SP+2 魔法命中+2
        ui.cb_buff[P_PRE].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "画面内の血盟員に強力なバフを付与 技術命中+5(術者のみ)"
                                         + "<br>"+ "近距離ダメージ+3 近距離命中+3 遠距離ダメージ+3 遠距離命中+3 SP+2 魔法命中+2"
                                         + "<br>"+ "攻城戦ではバフの効果が3倍になり最大HP+500が追加される"
                                         + "<br>"+ "[習得レベル:85][持続時間:1分][対象:血盟員]"+"</html>");
        if (ui.cb_buff[P_PRE].isSelected()) {
            switch ((String) ui.cb_buff_group[P_PRE].getSelectedItem()) {
                case "術者":
                    ui.cb_buff[P_PRE].setToolTipText("近距離ダメージ+3 近距離命中+3 遠距離ダメージ+3 遠距離命中+3 SP+2 魔法命中+2 技術命中+5");
                    buff.ailment[STUN] += 5;
                    buff.DMG_SHORT += 3;
                    buff.HIT_SHORT += 3;
                    buff.DMG_LONG += 3;
                    buff.HIT_LONG += 3;
                    buff.SP += 2;
                    buff.HIT_MAGIC += 2;
                    break;
                case "血盟員":
                    ui.cb_buff[P_PRE].setToolTipText("近距離ダメージ+3 近距離命中+3 遠距離ダメージ+3 遠距離命中+3 SP+2 魔法命中+2");
                    buff.DMG_SHORT += 3;
                    buff.HIT_SHORT += 3;
                    buff.DMG_LONG += 3;
                    buff.HIT_LONG += 3;
                    buff.SP += 2;
                    buff.HIT_MAGIC += 2;
                    break;
                case "術者(攻城戦)":
                    ui.cb_buff[P_PRE].setToolTipText("近距離ダメージ+9 近距離命中+9 遠距離ダメージ+9 遠距離命中+9 SP+6 魔法命中+6 HP+500 技術命中+15");
                    buff.ailment[STUN] += 15;
                    buff.DMG_SHORT += 9;
                    buff.HIT_SHORT += 9;
                    buff.DMG_LONG += 9;
                    buff.HIT_LONG += 9;
                    buff.SP += 6;
                    buff.HIT_MAGIC += 6;
                    buff.HP += 500;
                    break;
                case "血盟員(攻城戦)":
                    ui.cb_buff[P_PRE].setToolTipText("近距離ダメージ+9 近距離命中+9 遠距離ダメージ+9 遠距離命中+9 SP+6 魔法命中+6 HP+500");
                    buff.DMG_SHORT += 9;
                    buff.HIT_SHORT += 9;
                    buff.DMG_LONG += 9;
                    buff.HIT_LONG += 9;
                    buff.SP += 6;
                    buff.HIT_MAGIC += 6;
                    buff.HP += 500;
                    break;
                default:
                    break;
            }
        }
        //ACスキル
        ui.cb_buff[B_AC].setToolTipText("<html>"+ "AC-2 シールド"
                                        + "<br>"+ "AC-4 ファイヤーシールド"
                                        + "<br>"+ "AC-5 四季のポーション"
                                        + "<br>"+ "AC-10 アイアンスキン"+"</html>");
        if (ui.cb_buff[B_AC].isSelected()) {
            switch (ui.cb_buff_group[B_AC].getSelectedIndex()) {
                case 0://シールド		AC-2	消費MP8  魔法レベル1 継続時間1800秒
                    ui.cb_buff[B_AC].setToolTipText("AC-2 シールド");
                    buff.AC += -2;
                    if (ui.cb_buff[B_AC].getForeground().equals(Color.BLUE)) {
                        cons_mp += (8.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
                    }
                    break;
                case 1://ファイヤーシールド 	AC-4	消費MP15 魔法レベル3 継続時間960秒
                    ui.cb_buff[B_AC].setToolTipText("AC-4 ファイヤーシールド");
                    buff.AC += -4;
                    if (ui.cb_buff[B_AC].getForeground().equals(Color.BLUE)) {
                        cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                    }
                    break;
                case 2://四季のポーション 	AC-5      
                    ui.cb_buff[B_AC].setToolTipText("AC-5 四季のポーション");
                    buff.AC += -5;
                    break;
                case 3://アイアンスキン          AC-10	消費MP30 魔法レベル5 継続時間960秒
                    ui.cb_buff[B_AC].setToolTipText("AC-10 アイアンスキン");
                    buff.AC += -10;
                    if (ui.cb_buff[B_AC].getForeground().equals(Color.BLUE)) {
                        cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                    }
                    break;
                default:
                    break;
            }
        }

//        if (ui.cb_buff[WAR].isSelected()) {
//            if (ui.cb_buff_group[WAR].getSelectedIndex() == 0) {
//                buff.d_long += 30;
//                buff.d_short += 30;
//            }
//
//            if (ui.cb_buff_group[WAR].getSelectedIndex() == 1) {
//                if (level >= 80) {
//                    buff.HIT_CLOSE += 5;
//                    buff.d_short += 5;
//                    buff.d_long += 5;
//                } else if (level >= 70) {
//                    buff.HIT_CLOSE += 10;
//                    buff.d_short += 8;
//                    buff.d_long += 8;
//                    buff.MR += 3;
//                    buff.AC -= 2;
//                } else if (level >= 60) {
//                    buff.HIT_CLOSE += 25;
//                    buff.d_short += 12;
//                    buff.d_long += 12;
//                    buff.SP += 5;
//                    buff.MR += 5;
//                    buff.AC -= 5;
//                } else if (level >= 52) {
//                    buff.HIT_CLOSE += 40;
//                    buff.d_short += 15;
//                    buff.d_long += 15;
//                    buff.SP += 10;
//                    buff.MR += 10;
//                    buff.AC -= 10;
//                }
//            }
//        }
        //VIP
        ui.cb_buff[VIP].setToolTipText("<html>"+ "HP+120 MP+120 MR+10 AC-5 Red"
                                       + "<br>"+ "HP+150 MP+120 MR+10 AC-5 Gold"
                                       + "<br>"+ "HP+150 MP+150 MR+12 AC-5 Platinum");
        if (ui.cb_buff[VIP].isSelected()) {
            switch ((String) ui.cb_buff_group[VIP].getSelectedItem()) {
                case "Red":         //HP+120 MP+120 MR+10 AC-5
                    ui.cb_buff[VIP].setToolTipText("HP+120 MP+120 MR+10 AC-5");
                    buff.HP += 120;
                    buff.MP += 120;
                    buff.MR += 10;
                    buff.AC -= 5;
                    break;
                case "Gold":        //HP+150 MP+120 MR+10 AC-5
                    ui.cb_buff[VIP].setToolTipText("HP+150 MP+120 MR+10 AC-5");
                    buff.HP += 150;
                    buff.MP += 120;
                    buff.MR += 10;
                    buff.AC -= 5;
                    break;
                case "Platinum":    //HP+150 MP+150 MR+12 AC-5
                    ui.cb_buff[VIP].setToolTipText("HP+150 MP+150 MR+12 AC-5");
                    buff.HP += 150;
                    buff.MP += 150;
                    buff.MR += 12;
                    buff.AC -= 5;
                    break;
                default:
                    break;
            }
        }
        //セキュリティ
        ui.cb_buff[SEC].setToolTipText("AC-1 MR+2% ダメージ低下+1");
            if (ui.cb_buff[SEC].isSelected()) {
            buff.AC -= 1;
            buff.MR += 2;
            buff.DR += 1;
        }
        //真心のこもった祝福スクロール
        ui.cb_buff[MBSC].setToolTipText("<html>"+ "ダメージ低下+3 近距離ダメージ+2 遠距離ダメージ+2 近距離命中+2 遠距離命中+2"
                                        + "<br>"+ "魔法命中+2 SP+2 最大HP+50 HP回復+3 最大MP+30 MP回復+3 獲得経験値+5% 30分"+"</html>");
            if (ui.cb_buff[MBSC].isSelected()) {
            buff.DR += 1;
            buff.DMG_SHORT += 2;
            buff.DMG_LONG += 2;
            buff.HIT_SHORT += 2;
            buff.HIT_LONG += 2;
            buff.HIT_MAGIC += 2;
            buff.SP += 2;
            buff.HP += 50;
            buff.HPR += 3;
            buff.MP += 30;
            buff.MPR += 3;
            buff.MEXP += 5;                     //獲得経験値+5%
        }
        //バフコイン 
        ui.cb_buff[BUFF_COIN].setToolTipText("近距離ダメージ+1 遠距離ダメージ+1 SP+1");
            if (ui.cb_buff[BUFF_COIN].isSelected()) {
            buff.DMG_SHORT += 1;
            buff.DMG_LONG += 1;
            buff.SP += 1;
        }
        //黒蛇のコイン 
        ui.cb_buff[BS_COIN].setToolTipText("HP+20 MP+13 AC-2 ダメージ低下+3");
            if (ui.cb_buff[BS_COIN].isSelected()) {
            buff.HP += 20;
            buff.MP += 13;
            buff.AC -= 2;
            buff.DR += 3;
        }
        //魔眼
        ui.cb_buff[ITEM_MAGAN].setToolTipText("<html>"+ "地竜の魔眼 秘技耐性+5"
                                              + "<br>"+ "水竜の魔眼 精霊耐性+5"
                                              + "<br>"+ "風竜の魔眼 恐怖耐性+5"
                                              + "<br>"+ "火竜の魔眼 技術耐性+5"
                                              + "<br>"+ "誕生の魔眼 精霊耐性+5 秘技耐性+5"
                                              + "<br>"+ "形状の魔眼 精霊耐性+5 秘技耐性+5 恐怖耐性+5"
                                              + "<br>"+ "生命の魔眼 技術耐性+5 精霊耐性+5 秘技耐性+5 恐怖耐性+5 技術命中+3 精霊命中+3 秘技命中+3 恐怖命中+3"
                                              + "<br>"+ "グレムリンの魔眼 近距離ダメージ+2 遠距離ダメージ+2 SP+1");
        if (ui.cb_buff[ITEM_MAGAN].isSelected()) {
            switch (ui.cb_buff_group[ITEM_MAGAN].getSelectedIndex()) {
                case 0://地竜の魔眼
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("秘技耐性+5");
                    buff.ailment[SECRET] += 5;
                    break;
                case 1://水竜の魔眼
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("精霊耐性+5");
                    buff.ailment[SPIRIT] += 5;
                    break;
                case 2://風竜の魔眼 
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("恐怖耐性+5"); 
                    buff.ailment[TERROR] += 5;
                    break;
                case 3://火竜の魔眼
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("技術耐性+5");
                    buff.ailment[STUN] += 5;
                    break;
                case 4://誕生の魔眼
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("精霊耐性+5 秘技耐性+5");
                    buff.ailment[SPIRIT] += 5;
                    buff.ailment[SECRET] += 5;
                    break;
                case 5://形状の魔眼
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("精霊耐性+5 秘技耐性+5 恐怖耐性+5");
                    buff.ailment[SPIRIT] += 5;
                    buff.ailment[SECRET] += 5;
                    buff.ailment[TERROR] += 5;
                    break;
                case 6://生命の魔眼
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("技術耐性+5 精霊耐性+5 秘技耐性+5 恐怖耐性+5 技術命中+3 精霊命中+3 秘技命中+3 恐怖命中+3");
                    buff.ailment[STUN] += 5;
                    buff.ailment[SPIRIT] += 5;
                    buff.ailment[SECRET] += 5;
                    buff.ailment[TERROR] += 5;
                    buff.ailment[HIT_STUN] += 3;
                    buff.ailment[HIT_SPIRIT] += 3;
                    buff.ailment[HIT_SECRET] += 3;
                    buff.ailment[HIT_TERROR] += 3;
                    break;
                case 7://グレムリンの魔眼
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("近距離ダメージ+2 遠距離ダメージ+2 SP+1");
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.SP += 1;
                    break;
                default:
                    break;
            }
        }
        //成長の果実 y_ikedaさんによる修正を参考に
        ui.cb_buff[L_HST].setToolTipText("<html>"+ "1個 獲得経験値+20% AC-1"
                                         + "<br>"+ "2個 獲得経験値+30% AC-2 DR+1"
                                         + "<br>"+ "3個 獲得経験値+40% AC-3 DR+2"
                                         + "<br>"+ "4個 獲得経験値+40% AC-4 DR+2"
                                         + "<br>"+ "5個 獲得経験値+40% AC-5 DR+2"+"</html>");
        if (ui.cb_buff[L_HST].isSelected()) {
            switch ((String) ui.cb_buff_group[L_HST].getSelectedItem()) {
                case "1個":
                    ui.cb_buff[L_HST].setToolTipText("獲得経験値+20% AC-1");
                    buff.MEXP += 20;                                       //獲得経験値+20%
                    buff.AC -= 1;
                    break;
                case "2個":
                    ui.cb_buff[L_HST].setToolTipText("獲得経験値+30% AC-2 DR+1");
                    buff.MEXP += 30;                                       //獲得経験値+30%
                    buff.AC -= 2;
                    buff.DR += 1;
                    break;
                case "3個":
                    ui.cb_buff[L_HST].setToolTipText("獲得経験値+40% AC-3 DR+2");
                    buff.MEXP += 40;                                       //獲得経験値+40%
                    buff.AC -= 3;
                    buff.DR += 2;
                    break;
                case "4個":
                    ui.cb_buff[L_HST].setToolTipText("獲得経験値+40% AC-4 DR+2");
                    buff.MEXP += 40;                                       //獲得経験値+40%
                    buff.AC -= 4;
                    buff.DR += 2;
                    break;
                case "5個":
                    ui.cb_buff[L_HST].setToolTipText("獲得経験値+40% AC-5 DR+2");
                    buff.MEXP += 40;                                       //獲得経験値+40%
                    buff.AC -= 5;
                    buff.DR += 2;
                    break;
                default:
                    break;
            }
        }
        //生命のボーナス
        ui.cb_buff[H_HP].setToolTipText("<html>"+ "HP+50"
                                        + "<br>"+ "HP+100"
                                        + "<br>"+ "HP+200"+"</html>");
        if (ui.cb_buff[H_HP].isSelected()) {
            switch ((String) ui.cb_buff_group[H_HP].getSelectedItem()) {
                case "HP+50":
                    ui.cb_buff[H_HP].setToolTipText("HP+50");
                    buff.HP += 50;
                    break;
                case "HP+100":
                    ui.cb_buff[H_HP].setToolTipText("HP+100");
                    buff.HP += 100;
                    break;
                case "HP+200":
                    ui.cb_buff[H_HP].setToolTipText("HP+200");
                    buff.HP += 200;
                    break;
                default:
                    break;
            }
        }
        //鉄甲のボーナス
        ui.cb_buff[H_AC].setToolTipText("<html>"+ "AC-1"
                                        + "<br>"+ "AC-2"
                                        + "<br>"+ "AC-3"+"</html>");
        if (ui.cb_buff[H_AC].isSelected()) {
            switch ((String) ui.cb_buff_group[H_AC].getSelectedItem()) {
                case "AC-1":
                    ui.cb_buff[H_AC].setToolTipText("AC-1");
                    buff.AC -= 1;
                    break;
                case "AC-2":
                    ui.cb_buff[H_AC].setToolTipText("AC-2");
                    buff.AC -= 2;
                    break;
                case "AC-3":
                    ui.cb_buff[H_AC].setToolTipText("AC-3");
                    buff.AC -= 3;
                    break;
                default:
                    break;
            }
        }
        //生存のボーナス
        ui.cb_buff[H_PVPDR].setToolTipText("<html>"+ "PVPダメージ低下+1"
                                           + "<br>"+ "PVPダメージ低下+2"+"</html>");
        if (ui.cb_buff[H_PVPDR].isSelected()) {
            switch ((String) ui.cb_buff_group[H_PVPDR].getSelectedItem()) {
                case "PVP DR+1":
                    ui.cb_buff[H_PVPDR].setToolTipText("PVPダメージ低下+1");
                    buff.PVP_DR += 1;
                    break;
                case "PVP DR+2":
                    ui.cb_buff[H_PVPDR].setToolTipText("PVPダメージ低下+2");
                    buff.PVP_DR += 2;
                    break;
                default:
                    break;
            }
        }
        //暗殺のボーナス
        ui.cb_buff[H_PVP].setToolTipText("<html>"+ "PVPダメージ+1"
                                         + "<br>"+ "PVPダメージ+2"+"</html>");
        if (ui.cb_buff[H_PVP].isSelected()) {
            switch ((String) ui.cb_buff_group[H_PVP].getSelectedItem()) {
                case "PVP ダメ+1":
                    ui.cb_buff[H_PVP].setToolTipText("PVPダメージ+1");
                    buff.PVP += 1;
                    break;
                case "PVP ダメ+2":
                    ui.cb_buff[H_PVP].setToolTipText("PVPダメージ+2");
                    buff.PVP += 2;
                    break;
                default:
                    break;
            }
        }
        //ランカーボーナス
        //STR+1[君主][ナイト][ダークエルフ][ドラゴンナイト][ウォリアー][フェンサー]
        //DEX+1[エルフ]
        //INT+1[ウィザード][イリュージョニスト]
        ui.cb_buff[H_RK].setToolTipText("<html>"+ "STR+1[君主][ナイト][ダークエルフ][ドラゴンナイト][ウォリアー][フェンサー]"
                                        + "<br>"+ "DEX+1[エルフ]"
                                        + "<br>"+ "INT+1[ウィザード][イリュージョニスト]"+"</html>");
        if (ui.cb_buff[H_RK].isSelected()) {
            switch (cls) {
                case P:
                    ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;
                case K:
                    ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;
                case E:
                    ui.cb_buff[H_RK].setToolTipText("DEX+1");
                    buff.ST[DEX] += 1;
                    break;
                case W:
                    ui.cb_buff[H_RK].setToolTipText("INT+1");
                    buff.ST[INT] += 1;
                    break;                   
                case D:
                    ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;                    
                case R:
                    ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;
                case I:
                    ui.cb_buff[H_RK].setToolTipText("INT+1");
                    buff.ST[INT] += 1;
                    break;
                case S:
                    ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;
                case F:
                    ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;
                default:
                    break;
            }
        }
        //重量ペナルティ
        switch (ui.cb_weight.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                buff.HIT_SHORT -= 1;
                buff.HIT_LONG -= 1;
                break;
            case 2:
                buff.HIT_SHORT -= 3;
                buff.HIT_LONG -= 3;
                break;
            case 3:
                buff.HIT_SHORT -= 5;
                buff.HIT_LONG -= 5;
        }

        for (int i = 0; i < 6; i++) {
            buff.ST[i] += buki.op.ST[i] + buki2.op.ST[i];
            for (Bougu bougu1 : bougu) {
                buff.ST[i] += bougu1.op.ST[i] + bougu1.op2.ST[i];
            }
            _ST[ENCHANT][i] = buff.ST[i];
        }

        int str = _ST[BASE][STR] + _ST[REM][STR] + _ST[LEVEL][STR]
                + _ST[ENCHANT][STR] + _ST[ELIXIR][STR];
        int pure_str = _ST[BASE][STR] + _ST[REM][STR]
                + _ST[LEVEL][STR] + _ST[ELIXIR][STR];

        int dex = _ST[BASE][DEX] + _ST[REM][DEX] + _ST[LEVEL][DEX]
                + _ST[ENCHANT][DEX] + _ST[ELIXIR][DEX];
        int pure_dex = _ST[BASE][DEX] + _ST[REM][DEX]
                + _ST[LEVEL][DEX] + _ST[ELIXIR][DEX];

        int _int = _ST[BASE][INT] + _ST[REM][INT] + _ST[LEVEL][INT]
                + _ST[ENCHANT][INT] + _ST[ELIXIR][INT];
        int pure_int = _ST[BASE][INT] + _ST[REM][INT]
                + _ST[LEVEL][INT] + _ST[ELIXIR][INT];

        //追加ダメージ
        base_dmg_short = (int) (str / 2 - 2) + (int) (level / _C[D_SHORT][STR][cls]);
        base_dmg_long = (int) (dex / 3) + (int) (level / _C[D_LONG][DEX][cls]);
        base_dmg_magic = (int) (_int / 5 - 2) + (int) (level / _C[D_MAGIC][INT][cls]);

        base_hit_short = (int) (str * 2 / 3) + level + (int) (level / _C[H_SHORT][STR][cls]);
        base_hit_long = (int) (dex - 10) + level + (int) (level / _C[H_LONG][DEX][cls]);
        base_hit_magic = (int) ((_int - 20) / 3) + (int) (level / _C[H_MAGIC][INT][cls]);

        cri_short = (int) (minasToZero(str - 30) / 10) + (int) (minasToZero(level - 50) / _C[C_SHORT][STR][cls]);
        cri_long = (int) (minasToZero(dex - 30) / 10) + (int) (minasToZero(level - 50) / _C[C_LONG][DEX][cls]);
        cri_magic = (int) (minasToZero(_int - 30) / 10) + (int) (minasToZero(level - 50) / _C[C_MAGIC][INT][cls]);

        red_mp = Math.min(30, (int) (_int * 2 / 3));

        if (pure_str >= 25) {
            base_dmg_short += 1;                //近距離ダメージ+1
            base_hit_short += 1;                //近距離命中+1
        }
        if (pure_str >= 35) {
            base_dmg_short += 1;                //近距離ダメージ+1
            base_hit_short += 1;                //近距離命中+1
        }
        if (pure_str >= 45) {
            base_dmg_short += 3;                //近距離ダメージ+3
            base_hit_short += 3;                //近距離命中+3
            cri_short += 1;                     //近距離クリティカル+1%
        }
//        if (pure_str >= 55) {
//            base_dmg_short += 5;                //近距離ダメージ+5
//            base_hit_short += 5;                //近距離命中+5
//            cri_short += 2;                     //近距離クリティカル+2%
//        }
        if (pure_dex >= 25) {
            base_dmg_long += 1;                 //遠距離ダメージ+1
            base_hit_long += 1;                 //遠距離命中+1
        }
        if (pure_dex >= 35) {
            base_dmg_long += 1;                 //遠距離ダメージ+1
            base_hit_long += 1;                 //遠距離命中+1
        }
        if (pure_dex >= 45) {
            base_dmg_long += 3;                 //遠距離ダメージ+3
            base_hit_long += 3;                 //遠距離命中+3
            cri_long += 1;                      //遠距離クリティカル+1%
        }
//        if (pure_dex >= 55) {
//            base_dmg_long += 5;                 //遠距離ダメージ+5
//            base_hit_long += 5;                 //遠距離命中+5
//            cri_long += 2;                      //遠距離クリティカル+2%
//        }
        if (pure_int >= 25) {
            base_dmg_magic += 1;                //魔法ダメージ+1
            base_hit_magic += 1;                //魔法命中+1
        }
        if (pure_int >= 35) {
            base_dmg_magic += 1;                //魔法ダメージ+1
            base_hit_magic += 1;                //魔法命中+1
        }
        if (pure_int >= 45) {
            base_dmg_magic += 3;                //魔法ダメージ+3
            base_hit_magic += 3;                //魔法命中+3
            cri_magic += 1;                     //魔法クリティカル+1%
        }
//        if (pure_int >= 55) {
//            base_dmg_magic += 5;                //魔法ダメージ+5
//            base_hit_magic += 5;                //魔法命中+5
//            cri_magic += 2;                     //魔法クリティカル+2%
//        }
        dmg_short = base_dmg_short + buff.DMG_SHORT;
        dmg_long = base_dmg_long + buff.DMG_LONG;
        dmg_magic = base_dmg_magic + buff.DMG_MAGIC;
        //sp = buff.SP + buki.op.SP + buki2.op.SP;
        sp = buff.SP + buki.op.SP + buki.op2.SP;
        pvp_dg = buff.PVP + buki.op.PVP + buki.op2.PVP;
        pvp_dgr = buff.PVP_DR + buki.op.PVP_DR + buki.op2.PVP_DR;        
        hit_magic = base_hit_magic;

        for (Bougu bougu1 : bougu) {
            dmg_short += bougu1.op.DMG_SHORT + bougu1.op2.DMG_SHORT;
            dmg_long += bougu1.op.DMG_LONG + bougu1.op2.DMG_LONG;
            dmg_magic += bougu1.op.DMG_MAGIC + bougu1.op2.DMG_MAGIC;
            sp += bougu1.op.SP + bougu1.op2.SP;
            hit_magic += bougu1.op.HIT_MAGIC + bougu1.op2.HIT_MAGIC;
            cri_short += bougu1.op.CRI_SHORT + bougu1.op2.CRI_SHORT;
            cri_long += bougu1.op.CRI_LONG + bougu1.op2.CRI_LONG;
            cri_magic += bougu1.op.CRI_MAGIC + bougu1.op2.CRI_MAGIC;
        }
//        cri_short += buki.op.CRI_SHORT + buki.op2.CRI_SHORT;
        cri_short += buki.op.CRI_SHORT + buki.op2.CRI_SHORT + buff.CRI_SHORT;
//        cri_long += buki.op.CRI_LONG + buki.op2.CRI_LONG;
        cri_long += buki.op.CRI_LONG + buki.op2.CRI_LONG + buff.CRI_LONG;
//        cri_magic += buki.op.CRI_MAGIC + buki.op2.CRI_MAGIC;
        cri_magic += buki.op.CRI_MAGIC + buki.op2.CRI_MAGIC+ buff.CRI_MAGIC;
        
        int st_int = _ST[BASE][INT] + _ST[REM][INT] + _ST[LEVEL][INT]
                + _ST[ENCHANT][INT] + _ST[ELIXIR][INT];

        //スペルパワー更新
        int_beta = sp + st_int;
        
        spr = sp + ml + mb;
        
        //マジックレベル更新
        switch (cls) {
            case P:
                ml = level / 10;
                if (ml > 2) {
                    ml = 2;
                }
                break;
            case K:
                ml = level / 50;
                if (ml > 1) {
                    ml = 1;
                }
                break;
            case E:                     //エルフ:マジックレベル最大6から7へ変更
                ml = level / 8;
                if (ml > 7) {
                    ml = 7;
                }
                break;
            case W:                     //ウィザード:マジックレベル最大13から15へ変更
                ml = level / 6;
                if (ml > 15) {
                    ml = 15;
                }
                break;
            case D:
                ml = level / 12;
                if (ml > 2) {
                    ml = 2;
                }
                break;
            case R:
                ml = level / 9;
                if (ml > 4) {
                    ml = 4;
                }
                break;
            case I:
                ml = level / 6;
                if (ml > 10) {
                    ml = 10;
                }
                break;
            case S:
                ml = level / 50;
                if (ml > 1) {
                    ml = 1;
                }
                break;
            case F:
                ml = level / 15;
                if (ml > 2) {
                    ml = 2;
                }
                break;
            default:
                break;
        }

        mb = (int) (st_int / 4) + _C[MB][INT][cls];

        if (buki.type.equals("キーリンク")) {
            dmg_short = 0;
            for (int i = 0; i < 4; i++) {
                buff.ELEM_DMG_SHORT[i] = 0;
            }
        }

        //命中計算
        // STR,DEX,クラス,ベースステータス,レベル
        hit_short = base_hit_short;
        hit_long = base_hit_long;

        double cr = buki.critical_rate;
        double wh = buki.double_hit_rate;
        double we = buki.week_point_exposure;

        if (ui.cb_mag_auto.isSelected()) {
            ui.tf_buki_sp_rate.setEnabled(false);
        } else {
            ui.tf_buki_sp_rate.setEnabled(true);
            switch (buki.type) {
                case "クロウ":
                    cr = Double.parseDouble(ui.tf_buki_sp_rate.getText());
                    break;
                case "デュアルブレード":
                    wh = Double.parseDouble(ui.tf_buki_sp_rate.getText());
                    break;
                case "チェーンソード":
                    we = Double.parseDouble(ui.tf_buki_sp_rate.getText());
                    break;
                default:
                    break;
            }
        }

        // 武器オプション,武器強化数,エンチャント
        hit_short += buki.op.HIT_SHORT + buki.enchant / 2 + buff.HIT_SHORT;
        //hit_long += buki.op.HIT_LONG + buki.enchant / 2 + buff.HIT_LONG + buff.HIT_SHORT;
        hit_long += buki.arrow_hit + buki.op.HIT_LONG + buki.enchant / 2 + buff.HIT_LONG;
        
//System.out.print(" 遠距離命中 合計:");
//System.out.print(hit_long);
//System.out.print(" 遠距離命中(矢分):");
//System.out.print(buki.arrow_hit);
//System.out.print(" 遠距離命中(武器分):");
//System.out.print(buki.op.HIT_LONG);
//System.out.print(" 遠距離命中(武器強化分)/2:");
//System.out.print(buki.enchant / 2);
//System.out.print(" 遠距離命中(魔法スキル分):");
//System.out.println(buff.HIT_LONG);

buki.arrow_hit=0;

        //属性矢
//        if (buki.type.equals("ボウ")) {
//            if (buki.arrow_name.contains("霊")) {
//                switch (buki.arrow_name) {
//                   case "火霊のブラックミスリルアロー":
//                        buff.ELEM_DMG_LONG[FIRE] += 3;
//                       break;
//                   case "水霊のブラックミスリルアロー":
//                       buff.ELEM_DMG_LONG[WATER] += 3;
//                       break;
//                   case "風霊のブラックミスリルアロー":
//                       buff.ELEM_DMG_LONG[WIND] += 3;
//                       break;
//                   case "地霊のブラックミスリルアロー":
//                       buff.ELEM_DMG_LONG[EARTH] += 3;
//                       break;
//               }
//            }
//       }
        //エレメンタル バトル アロー
        if (buki.type.equals("ボウ")) {
            if (buki.arrow_name.contains("火属性の")) {
                buff.ELEM_DMG_LONG[FIRE] += buki.arrow_elementdmg;
            }else if(buki.arrow_name.contains("水属性の")) {
                buff.ELEM_DMG_LONG[WATER] += buki.arrow_elementdmg;
            }else if(buki.arrow_name.contains("風属性の")) {
                buff.ELEM_DMG_LONG[WIND] += buki.arrow_elementdmg;
            }else if(buki.arrow_name.contains("地属性の")) {
                buff.ELEM_DMG_LONG[EARTH] += buki.arrow_elementdmg;
            }
        }
        
//System.out.print(" 火属性ダメージ:");
//System.out.print(buff.ELEM_DMG_LONG[FIRE]);
//System.out.print(" 水属性ダメージ:");
//System.out.print(buff.ELEM_DMG_LONG[WATER]);
//System.out.print(" 風属性ダメージ:");
//System.out.print(buff.ELEM_DMG_LONG[WIND]);
//System.out.print(" 地属性ダメージ:");
//System.out.println(buff.ELEM_DMG_LONG[EARTH]);

buki.arrow_elementdmg=0;

        for (Bougu bougu1 : bougu) {
            hit_short += bougu1.op.HIT_SHORT + bougu1.op2.HIT_SHORT;
            //hit_long += bougu1.op.HIT_LONG + bougu1.op.HIT_SHORT + bougu1.op2.HIT_LONG + bougu1.op2.HIT_SHORT;
            hit_long += bougu1.op.HIT_LONG + bougu1.op2.HIT_LONG;
        }

        //属性ダメージ
        dmg_short += (int) ((buff.ELEM_DMG_SHORT[FIRE]) * (32.0 - ui.s_target_res[FIRE].getValue() * 32 / 100) / 32.0);
        dmg_short += (int) ((buff.ELEM_DMG_SHORT[WATER]) * (32.0 - ui.s_target_res[FIRE].getValue() * 32 / 100) / 32.0);
        dmg_short += (int) ((buff.ELEM_DMG_SHORT[WIND]) * (32.0 - ui.s_target_res[FIRE].getValue() * 32 / 100) / 32.0);
        dmg_short += (int) ((buff.ELEM_DMG_SHORT[EARTH]) * (32.0 - ui.s_target_res[FIRE].getValue() * 32 / 100) / 32.0);
        
        dmg_long += (int) ((buff.ELEM_DMG_LONG[FIRE]) * (32.0 - ui.s_target_res[FIRE].getValue() * 32 / 100) / 32.0);
        dmg_long += (int) ((buff.ELEM_DMG_LONG[WATER]) * (32.0 - ui.s_target_res[WATER].getValue() * 32 / 100) / 32.0);
        dmg_long += (int) ((buff.ELEM_DMG_LONG[WIND]) * (32.0 - ui.s_target_res[WIND].getValue() * 32 / 100) / 32.0);
        dmg_long += (int) ((buff.ELEM_DMG_LONG[EARTH]) * (32.0 - ui.s_target_res[EARTH].getValue() * 32 / 100) / 32.0);

        dmg_element1 = 0;
        dmg_element2 = 0;

        for (int i = 0; i < ELEM_LIST.length; i++) {
            dmg_element1 += (int) (dmg_buki_ele1[i] * (32.0 - ui.s_target_res[i].getValue() * 32 / 100) / 32.0);
            dmg_element2 += (int) (dmg_buki_ele2[i] * (32.0 - ui.s_target_res[i].getValue() * 32 / 100) / 32.0);
        }

        boolean d_axe = false;
        double speed = 0;
        int buki_id = 0;
        double magic_main = 0;
        double magic_sub = 0;
        //レベルによる自動攻撃速度とHero変身速度の変更
        if (ui.cb_speed_auto.isSelected()) {

            if (ui.cb_eq[1].getSelectedIndex() > 0) {
                switch (ui.cb_morph_level.getSelectedIndex()) {
                    case 0:
                        speed = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), W_DA);
                        break;
                    case 15:
                        speed = polymorph.getSpeed(99, ui.cb_morph_type.getSelectedIndex(), W_DA);
                        break;
                    default:
                        int l = Integer.parseInt((String) ui.cb_morph_level.getSelectedItem());
                        speed = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), W_DA);
                        break;
                }
                buki_id = W_DA;
                d_axe = true;
            } else {
                for (int i = 0; i < BUKI_TYPE_LIST.length; i++) {
                    if (buki.type.equals(BUKI_TYPE_LIST[i])) {
                        switch (ui.cb_morph_level.getSelectedIndex()) {
                            case 0:
                                speed = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), i);
                                magic_main = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), MAIN);
                                magic_sub = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), SUB);
                                break;
                            case 15:
                                speed = polymorph.getSpeed(99, ui.cb_morph_type.getSelectedIndex(), i);
                                magic_main = polymorph.getSpeed(99, ui.cb_morph_type.getSelectedIndex(), MAIN);
                                magic_sub = polymorph.getSpeed(99, ui.cb_morph_type.getSelectedIndex(), SUB);
                                break;
                            default:
                                int l = Integer.parseInt((String) ui.cb_morph_level.getSelectedItem());
                                speed = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), i);
                                magic_main = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), MAIN);
                                magic_sub = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), SUB);
                                break;
                        }
                        buki_id = i;
                        break;
                    }
                }
            }
            ui.tf_speed.setText(format_speed.format(speed));
            ui.tf_magic_speed_main.setText(format_speed.format(magic_main));
            ui.tf_magic_speed_sub.setText(format_speed.format(magic_sub));

            ui.tf_speed.setEnabled(false);
            ui.tf_magic_speed_main.setEnabled(false);
            ui.tf_magic_speed_sub.setEnabled(false);
            ui.tf_acc.setEnabled(false);
        } else {
            speed = Double.parseDouble(ui.tf_speed.getText());
            magic_main = Double.parseDouble(ui.tf_magic_speed_main.getText());
            magic_sub = Double.parseDouble(ui.tf_magic_speed_sub.getText());
            ui.tf_speed.setEnabled(true);
            ui.tf_magic_speed_main.setEnabled(true);
            ui.tf_magic_speed_sub.setEnabled(true);
            ui.tf_acc.setEnabled(true);
        }

        double dmg_small_ave;
        double dmg_big_ave;
        double dmg_small_max = 0;
        double dmg_big_max = 0;

        double dmg_small_ave2;
        double dmg_big_ave2;
        double dmg_small_max2;
        double dmg_big_max2;

        dmg_cursed = 0.0;
        dmg_undead = 0.0;

//        ui.sp_sub.setText("");
        if (cls == S
                && ui.cb_eq[1].getSelectedIndex() != 0) {

            dmg_big_ave = (1.0 + buki.big) / 2 + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;
            dmg_small_ave = (1.0 + buki.small) / 2 + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;

            dmg_big_max = buki.big + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;
            dmg_small_max = buki.small + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;

//System.out.print(" dmg_  big_ave:");
//System.out.print(dmg_big_ave);
//System.out.print(" buki1.  big_ave:");
//System.out.print((1.0 + buki.big) / 2 );
//System.out.print(" buki1.op.DMG_SHORT:");
//System.out.print(buki.op.DMG_SHORT);
//System.out.print(" buki1.op2.DMG_SHORT:");
//System.out.print(buki.op2.DMG_SHORT);
//System.out.print(" buki1.enchant:");
//System.out.print(buki.enchant);
//System.out.print(" buki1.magic_enchant:");
//System.out.println(buki.magic_enchant);

//System.out.print(" dmg_small_ave:");
//System.out.print(dmg_small_ave);
//System.out.print(" buki1.small_ave:");
//System.out.print((1.0 + buki.small) / 2 );
//System.out.print(" buki1.op.DMG_SHORT:");
//System.out.print(buki.op.DMG_SHORT);
//System.out.print(" buki1.op2.DMG_SHORT:");
//System.out.print(buki.op2.DMG_SHORT);
//System.out.print(" buki1.enchant:");
//System.out.print(buki.enchant);
//System.out.print(" buki1.magic_enchant:");
//System.out.println(buki.magic_enchant);

            if (buki.material.equals("シルバー")
                    || buki.material.equals("ミスリル")
                    || buki.material.equals("オリハルコン")) {
//アンデッド追加ダメージ(武器2分)
//旧仕様　1から20ダメージ 平均10.5/2
//          dmg_undead += (1.0 + 20.0) / 2.0 / 2.0;
//新仕様　1から40ダメージ 平均20.5/2
            dmg_undead += (1.0 + 40.0) / 2.0 / 2.0;
            }
            if (ui.tb_blessed1.isSelected()) {
                dmg_cursed += ((1.0 + 3.0) / 2.0 + 3.0) / 2.0;
            }

            dmg_big_ave2 = (1.0 + buki2.big) / 2 + buki2.op.DMG_SHORT + buki2.op2.DMG_SHORT + buki2.enchant + buki2.magic_enchant;
            dmg_small_ave2 = (1.0 + buki2.small) / 2 + buki2.op.DMG_SHORT + buki2.op2.DMG_SHORT + buki2.enchant + buki2.magic_enchant;

            dmg_big_max2 = buki2.big + buki2.op.DMG_SHORT + buki2.op2.DMG_SHORT + buki2.enchant + buki2.magic_enchant;
            dmg_small_max2 = buki2.small + buki2.op.DMG_SHORT + buki2.op2.DMG_SHORT + buki2.enchant + buki2.magic_enchant;

//System.out.print(" dmg_  big_ave:");
//System.out.print(dmg_big_ave2);
//System.out.print(" buki2.  big_ave:");
//System.out.print((1.0 + buki2.big) / 2 );
//System.out.print(" buki2.op.DMG_SHORT:");
//System.out.print(buki2.op.DMG_SHORT);
//System.out.print(" buki2.op2.DMG_SHORT:");
//System.out.print(buki2.op2.DMG_SHORT);
//System.out.print(" buki2.enchant:");
//System.out.print(buki2.enchant);
//System.out.print(" buki2.magic_enchant:");
//System.out.println(buki2.magic_enchant);

//System.out.print(" dmg_small_ave:");
//System.out.print(dmg_small_ave2);
//System.out.print(" buki2.small_ave:");
//System.out.print((1.0 + buki2.small) / 2 );
//System.out.print(" buki2.op.DMG_SHORT:");
//System.out.print(buki2.op.DMG_SHORT);
//System.out.print(" buki2.op2.DMG_SHORT:");
//System.out.print(buki2.op2.DMG_SHORT);
//System.out.print(" buki2.enchant:");
//System.out.print(buki2.enchant);
//System.out.print(" buki2.magic_enchant:");
//System.out.println(buki2.magic_enchant);

            if (buki2.material.equals("シルバー")
                    || buki2.material.equals("ミスリル")
                    || buki2.material.equals("オリハルコン")) {
//アンデッド追加ダメージ(武器1分)
//旧仕様　1から20ダメージ 平均10.5/2
//          dmg_undead += (1.0 + 20.0) / 2.0 / 2.0;
//新仕様　1から40ダメージ 平均20.5/2
            dmg_undead += (1.0 + 40.0) / 2.0 / 2.0;
            }
            if (ui.tb_blessed2.isSelected()) {
                dmg_cursed += ((1.0 + 3.0) / 2.0 + 3.0) / 2.0;
            }

            dmg_big_ave = (dmg_big_ave + dmg_big_ave2) / 2.0;
            dmg_small_ave = (dmg_small_ave + dmg_small_ave2) / 2.0;

            dmg_big_max = (dmg_big_max + dmg_big_max2) / 2.0;
            dmg_small_max = (dmg_small_max + dmg_small_max2) / 2.0;

        } else {
            switch (buki.type) {
                case "ボウ":
                case "ガントレット":

//                    if (ui.cb_sonsyou.isSelected() && !(buki.arrow_name.equals("幸運のアロー") || buki.op.effect.contains("貫通効果"))) {
//                        dmg_big_ave = (1.0 + buki.arrow_big) / 4 + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
//                        dmg_small_ave = (1.0 + buki.arrow_small) / 4 + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
//
//                        dmg_big_max = buki.arrow_big / 2 + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
//                        dmg_small_max = buki.arrow_small / 2 + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
//
//                    } else {
                        //dmg_big_ave = (1.0 + buki.arrow_big) / 2 + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
                        //dmg_small_ave = (1.0 + buki.arrow_small) / 2 + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
                        dmg_big_ave = (1.0 + buki.big) / 2 + buki.arrow_dmg + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
                        dmg_small_ave = (1.0 + buki.small) / 2 + buki.arrow_dmg + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;

//System.out.print(" dmg_  big_ave:");
//System.out.print(dmg_big_ave);
//System.out.print(" buki.  big平均:");
//System.out.print((1.0 + buki.big) / 2 );
//System.out.print(" buki.arrow_dmg:");
//System.out.print(buki.arrow_dmg);
//System.out.print(" buki.op.DMG_LONG:");
//System.out.print(buki.op.DMG_LONG);
//System.out.print(" buki.op2.DMG_LONG:");
//System.out.print(buki.op2.DMG_LONG);
//System.out.print(" buki.enchant:");
//System.out.print(buki.enchant);
//System.out.print(" buki.magic_enchant:");
//System.out.println(buki.magic_enchant);

//System.out.print(" dmg_small_ave:");
//System.out.print(dmg_small_ave);
//System.out.print(" buki.small平均:");
//System.out.print((1.0 + buki.small) / 2 );
//System.out.print(" buki.arrow_dmg:");
//System.out.print(buki.arrow_dmg);
//System.out.print(" buki.op.DMG_LONG:");
//System.out.print(buki.op.DMG_LONG);
//System.out.print(" buki.op2.DMG_LONG:");
//System.out.print(buki.op2.DMG_LONG);
//System.out.print(" buki.enchant:");
//System.out.print(buki.enchant);
//System.out.print(" buki.magic_enchant:");
//System.out.println(buki.magic_enchant);

                        //dmg_big_max = buki.arrow_big + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
                        //dmg_small_max = buki.arrow_small + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
                        dmg_big_max = buki.arrow_dmg + buki.big + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
                        dmg_small_max = buki.arrow_dmg + buki.small + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;                        
                        
//                    }
                    if (buki.arrow_material.equals("シルバー")
                            || buki.arrow_material.equals("ミスリル")
                            || buki.arrow_material.equals("オリハルコン")) {
//アンデッド追加ダメージ
//旧仕様　1から20ダメージ 平均10.5
//                      dmg_undead = (1.0 + 20.0) / 2.0;
//新仕様　1から40ダメージ 平均20.5
                        dmg_undead = (1.0 + 40.0) / 2.0;
                    }
                    break;
                case "キーリンク":
                    dmg_big_ave = buki.x * (1.0 + buki.y) / 2 + buki.z;
                    dmg_small_ave = buki.x * (1.0 + buki.y) / 2 + buki.z;
                    break;
                default:
                    dmg_big_ave = (1.0 + buki.big) / 2 + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;
                    dmg_small_ave = (1.0 + buki.small) / 2 + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;

                    dmg_big_max = buki.big + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;
                    dmg_small_max = buki.small + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;

//System.out.print(" dmg_  big_ave:");
//System.out.print(dmg_big_ave);
//System.out.print(" buki1.  big_ave:");
//System.out.print((1.0 + buki.big) / 2 );
//System.out.print(" buki1.op.DMG_SHORT:");
//System.out.print(buki.op.DMG_SHORT);
//System.out.print(" buki1.op2.DMG_SHORT:");
//System.out.print(buki.op2.DMG_SHORT);
//System.out.print(" buki1.enchant:");
//System.out.print(buki.enchant);
//System.out.print(" buki1.magic_enchant:");
//System.out.println(buki.magic_enchant);

//System.out.print(" dmg_small_ave:");
//System.out.print(dmg_small_ave);
//System.out.print(" buki1.small_ave:");
//System.out.print((1.0 + buki.small) / 2 );
//System.out.print(" buki1.op.DMG_SHORT:");
//System.out.print(buki.op.DMG_SHORT);
//System.out.print(" buki1.op2.DMG_SHORT:");
//System.out.print(buki.op2.DMG_SHORT);
//System.out.print(" buki1.enchant:");
//System.out.print(buki.enchant);
//System.out.print(" buki1.magic_enchant:");
//System.out.println(buki.magic_enchant);

                    if (buki.material.equals("シルバー")
                            || buki.material.equals("ミスリル")
                            || buki.material.equals("オリハルコン")) {
//アンデッド追加ダメージ
//1から20ダメージ 平均10.5
//                      dmg_undead = (1.0 + 20.0) / 2.0;
//1から40ダメージ 平均20.5
                        dmg_undead = (1.0 + 40.0) / 2.0;
                    } else {
                        dmg_undead = 0;
                    }
                    if (ui.tb_blessed1.isSelected()) {
                        dmg_cursed = (1.0 + 3) / 2 + 3;
                    } else {
                        dmg_cursed = 0;
                    }
                    break;
            }
        }

        //クリティカル処理
        ui.cb_buff[E_EEE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "遠距離クリティカル+2%"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:45][持続時間:2分8秒][対象:術者][触媒:精霊の玉(1)]"+"</html>");
        switch (buki.type) {
            case "キーリンク":
                double a = 1 + 3.0 / 32.0 * (int_beta - 12);
                double b;
                if (ui.s_target_mr.getValue() - hit_magic <= 100) {
                    b = 1.0 - 0.01 * ((ui.s_target_mr.getValue() - hit_magic) / 2);
                } else {
                    b = 0.6 - 0.01 * ((ui.s_target_mr.getValue() - hit_magic) / 10);
                }
                dmg_big_ave *= a;
                dmg_big_ave += buki.enchant + base_dmg_magic + buki.op.DMG_MAGIC + buki.op2.DMG_MAGIC;
                dmg_big_ave *= b;
                dmg_big_ave *= cri_magic * 0.01 * 1.5 + (1 - cri_magic * 0.01) * 1.0;                
                dmg_big_ave -= 0.5;
                dmg_small_ave *= a;
                dmg_small_ave += buki.enchant + base_dmg_magic + buki.op.DMG_MAGIC + buki.op2.DMG_MAGIC;
                dmg_small_ave *= b;
                dmg_small_ave *= cri_magic * 0.01 * 1.5 + (1 - cri_magic * 0.01) * 1.0;
                dmg_small_ave -= 0.5;
                break;
            case "ボウ":
                //エルフ イーグルアイ 2% 消費MP20/2mins
//                cri_long += cr * 100;
                if (ui.cb_buff[E_EEE].isSelected()) {
                    cri_long += 2;
                    if (ui.cb_buff[E_EEE].getForeground().equals(Color.BLUE)) {
                            cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
                    }
                }
                dmg_big_ave = (cri_long * 0.01) * dmg_big_max
                        + (1.0 - cri_long * 0.01) * dmg_big_ave;
                dmg_small_ave = (cri_long * 0.01) * dmg_small_max
                        + (1.0 - cri_long * 0.01) * dmg_small_ave;
                break;
            default:
                //エルフ ソウルオブフレイム 100% 消費MP40/5mins
                cri_short += cr * 100;
                ui.cb_buff[E_SOF].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                                 + "<br>"+ "装備している武器の最大ダメージで攻撃する"
                                                 + "<br>"+ "武器が損傷しなくなる"
                                                 + "<br>"+ "[習得レベル:80][持続時間:5分20秒][対象:術者][触媒:精霊の玉(5)]"+"</html>");
                if (ui.cb_buff[E_SOF].isSelected()) {
                    cri_short = 100;
                    if (ui.cb_buff[E_SOF].isSelected()) {
                        if (ui.cb_buff[E_SOF].getForeground().equals(Color.BLUE)) {
                            cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                        }
                    }
                }
                dmg_big_ave = (cri_short * 0.01) * dmg_big_max
                        + (1.0 - cri_short * 0.01) * dmg_big_ave;
                dmg_small_ave = (cri_short * 0.01) * dmg_small_max
                        + (1.0 - cri_short * 0.01) * dmg_small_ave;
                break;
        }

        if (buki.type.equals("デュアルブレード")) {
            if (buki.name.contains("咆哮") && ui.cb_mag_auto.isSelected()) {
                ui.tf_buki_sp_rate.setText(Double.toString(((int) ((wh + buki.enchant * 0.01) * 100)) / 100.0));
                dmg_big_ave *= 2.0 * (wh + buki.enchant * 0.01)
                        + (1.0 - (wh + buki.enchant * 0.01));
                dmg_small_ave *= 2.0 * (wh + buki.enchant * 0.01)
                        + (1.0 - (wh + buki.enchant * 0.01));

                //ダブルヒットに銀特効+悪魔特効を乗せる
                dmg_undead *= 2.0 * (wh + buki.enchant * 0.01)
                        + (1.0 - (wh + buki.enchant * 0.01));
                dmg_cursed *= 2.0 * (wh + buki.enchant * 0.01)
                        + (1.0 - (wh + buki.enchant * 0.01));

            } else {
                dmg_big_ave *= 2.0 * wh
                        + (1.0 - wh);
//                dmg_small_ave *= 2.0 * wh
//                        + (1.0 - buki.double_hit_rate);
                dmg_small_ave *= 2.0 * wh
                        + (1.0 - wh);

                //ダブルヒットに銀特効+悪魔特効を乗せる
                dmg_undead *= 2.0 * wh
                        + (1.0 - wh);
                dmg_cursed *= 2.0 * wh
                        + (1.0 - wh);
            }
        }

        double fs_rate = 1.0;
        double delay;
        double power;

        double magic;
        double drain_small = 0;
        double drain_big = 0;

        double rate;
        double hit;

        if (ui.cb_mag_auto.isSelected()) {
            rate = buki.magic_rate + buki.magic_rate_plus * buki.enchant;

            delay = buki.magic_delay;
            power = buki.magic_power;

            ui.tf_mag_power.setText(format_dmg.format(power));
            ui.tf_mag_delay.setText(format_dmg.format(delay));
            ui.tf_mag_rate.setText(format_rate_2.format(rate));

            ui.tf_mag_power.setEnabled(false);
            ui.tf_mag_delay.setEnabled(false);
            ui.tf_mag_rate.setEnabled(false);

        } else {
            rate = Double.parseDouble(ui.tf_mag_rate.getText());
            delay = Double.parseDouble(ui.tf_mag_delay.getText());
            power = Double.parseDouble(ui.tf_mag_power.getText());

            ui.tf_mag_power.setEnabled(true);
            ui.tf_mag_delay.setEnabled(true);
            ui.tf_mag_rate.setEnabled(true);
        }

        magic = getMagicDamage(buki.magic_name, buki.magic_element, power);

        switch (buki.type) {
            case "ボウ":
            case "ガントレット":
                hit = HitRateCalculator.calc(ui.cb_mode_pc.getSelectedIndex() == 0, hit_long, 10 - ui.cb_target_ac.getSelectedIndex(), ui.cb_target_dg.getSelectedIndex() == 0, ui.cb_target_dg.getSelectedIndex() == 2);
                break;
            case "キーリンク":
                hit = 1.0;
                break;
            default:
                hit = HitRateCalculator.calc(ui.cb_mode_pc.getSelectedIndex() == 0, hit_short, 10 - ui.cb_target_ac.getSelectedIndex(), ui.cb_target_dg.getSelectedIndex() == 0, ui.cb_target_dg.getSelectedIndex() == 2);
                break;
        }

        if (ui.cb_hittyuu.isSelected()) {
            hit = 1.0;
        }

        double mag_dmg_min = 0.0;
        double hit_rate = hit;

//        ui.mp_syouhi.setText("0 /min");
        if (ui.cb_magic.getSelectedItem() != null) {
            double mag_dmg;
            double mag_delay;
            double motion_delay;
            double ta_rate;

            switch ((String) ui.cb_magic.getSelectedItem()) {
                case "サンバースト":
                    double base_delay = 0.5;
                    motion_delay = 60.0 / (magic_sub * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("サンバースト", "火", 88.0);
                    mag_dmg_min = mag_dmg * 60.0 / mag_delay;
                    if (st_int >= 17) {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 15 + " /min");
//                        syouhi_mp = 15;
                    } else {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * (int) (20 * (1.0 - red_mp / 100.0)) + " /min");
                    }
//                    ui.bc.mag = true;
//                    ui.bc2.mag = true;
                    break;
                case "コーンオブコールド":
                    base_delay = 0.1;
                    motion_delay = 60.0 / (magic_main * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("コーンオブコールド", "水", 62.0);
                    mag_dmg_min = mag_dmg * 60.0 / mag_delay;
                    if (st_int >= 16) {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 14 + " /min");
//                        syouhi_mp = 14;
                    } else {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * (int) (18 * (1.0 - red_mp / 100.0)) + " /min");
                    }
//                    ui.bc.mag = true;
//                    ui.bc2.mag = true;
                    break;
                case "イラプション":
                    base_delay = 0.1;
                    motion_delay = 60.0 / (magic_main * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("イラプション", "地", 79.0);
                    mag_dmg_min = mag_dmg * 60.0 / mag_delay;
                    if (st_int >= 17) {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 15 + " /min");
//                        syouhi_mp = 15;
                    } else {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * (int) (20 * (1.0 - red_mp / 100.0)) + " /min");
                    }
                    break;
                case "コールライトニング":
                    base_delay = 0.0;
                    motion_delay = 60.0 / (magic_sub * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("コールライトニング", "風", 62.5);
                    mag_dmg_min = mag_dmg * 60.0 / mag_delay;
                    if (st_int >= 16) {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 14 + " /min");
//                        syouhi_mp = 14;
                    } else {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * (int) (18 * (1.0 - red_mp / 100.0)) + " /min");
                    }
                    break;
                case "トリプルアロー":
                    if (buki.type.equals("ボウ")) {
                        base_delay = 0.1;
                        motion_delay = 60.0 / (magic_main * acc);
                        mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                        ta_rate = (mag_delay - motion_delay) / mag_delay + motion_delay / mag_delay * 3;
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 15 + " /min");
//                        syouhi_mp = 15;
                        hit *= ta_rate;
                    }
                    break;
                default:
                    break;
            }
        }

        if (d_axe) {
            double T = 60.0 / (acc * speed) * 2;
            delay = (int) (delay / T) * T;
            rate = rate / (1 + delay * hit * rate / T) / 2;

        } else {
            double T = 60.0 / (acc * speed);
            delay = (int) (delay / T) * T;
            rate = rate / (1 + delay * hit * rate / T);
        }

        if (buki.magic_name.equals("HP吸収")) {
            drain_small = ((dmg_small_ave + dmg_element1) / 8 + 1) - 0.5;
            drain_big = ((dmg_big_ave + dmg_element1) / 8 + 1) - 0.5;
            ui.lab_mag_info2
                    .setText("魔法ダメージ "
                            + format_dmg.format(drain_small)
                            + "/"
                            + format_dmg.format(drain_big)
                            + "  "
                            + format_rate.format(rate));
            drain_small *= rate;
            drain_big *= rate;
        } else {
            magic *= rate;
        }

//        if (buki.magic_motion) {
//            dmg_small_ave *= (1.0 - rate);
//            dmg_big_ave *= (1.0 - rate);
//        }
        //ヴァンパイアリックタッチ
        if (buff.effect.contains("ヴァンパイアリックタッチ")) {
            double vt_rate = 0.04;
            double vt_motion = 60.0 / (polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), buki_id));
            double atk_motion = 60.0 / (speed);

            //VTモーションによる攻撃速度の低下
            speed *= (atk_motion) / (atk_motion + vt_motion * vt_rate);
        }
        //ダブルブレイク
        ui.cb_buff[D_DBK].setToolTipText("<html>"+ "[消費MP:12][消費HP:--]"
                                         + "<br>"+ "一定確率(33%)でデュアルブレードとクロウのダメージを2倍にする"
                                         + "<br>"+ "レベル45からレベル5毎に発動率が1%増加"
                                         + "<br>"+ "[習得レベル:60][持続時間:3分12秒][対象:術者][触媒:ダークストーン(1)]"+"</html>");
        if (ui.cb_buff[D_DBK].isSelected()) {
            if (buki_id == W_DB || buki_id == W_C) {
                double db_lv_bonus = ((level - 45) / 5) * 0.01;

                dmg_big_ave *= 2.0 * (db_rate + db_lv_bonus)
                        + (1.0 - (db_rate + db_lv_bonus));
                dmg_small_ave *= 2.0 * (db_rate + db_lv_bonus)
                        + (1.0 - (db_rate + db_lv_bonus));

                dmg_undead *= 2.0 * (db_rate + db_lv_bonus)
                        + (1.0 - (db_rate + db_lv_bonus));
                dmg_cursed *= 2.0 * (db_rate + db_lv_bonus)
                        + (1.0 - (db_rate + db_lv_bonus));
            } else {
                ui.cb_buff[D_DBK].setSelected(false);
                ui.cb_buff[D_DBD].setSelected(false);
            }
        }
        //ダブルブレイク:デスティニー
        ui.cb_buff[D_DBD].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "ダブルブレイクの発動率上昇"
                                         + "<br>"+ "80レベルから1レベル毎に発動確率1%増加"
                                         + "<br>"+ "[習得レベル:80][持続時間:3分12秒][対象:術者]"+"</html>");
        if (ui.cb_buff[D_DBD].isSelected()) {
            if (level >= 80 && cls == D
                    && buki_id == W_DB || buki_id == W_C) {
                double db2_lv_bonus =(((level - 45) / 5) * 0.01)+((level - 79) * 0.01);

                dmg_big_ave *= 2.0 * (db_rate + db2_lv_bonus)
                        + (1.0 - (db_rate + db2_lv_bonus));
                dmg_small_ave *= 2.0 * (db_rate + db2_lv_bonus)
                        + (1.0 - (db_rate + db2_lv_bonus));

                dmg_undead *= 2.0 * (db_rate + db2_lv_bonus)
                        + (1.0 - (db_rate + db2_lv_bonus));
                dmg_cursed *= 2.0 * (db_rate + db2_lv_bonus)
                        + (1.0 - (db_rate + db2_lv_bonus));
                ui.cb_buff[D_DBK].setSelected(false);
            } else {
                ui.cb_buff[D_DBK].setSelected(false);
                ui.cb_buff[D_DBD].setSelected(false);
            }
        }
        //武器属性
        if (buki_id == W_DA) {
            dmg_big_ave += (dmg_element1 + dmg_element2) / 2;
            dmg_small_ave += (dmg_element1 + dmg_element2) / 2;

        } else {
            dmg_big_ave += dmg_element1;
            dmg_small_ave += dmg_element1;
        }
        //幻術/キューブ[アバター]
        ui.cb_buff[I_IAR].setToolTipText("<html>"+ "[消費MP:50/40][消費HP:--]"
                                         + "<br>"+ "近距離ダメージ+10 遠距離ダメージ+10 魔法ダメージ+10 被ダメージ+5%"
                                         + "<br>"+ "キャンセレーションで解除されない(術者のみ)"
                                         + "<br>"+ "[習得レベル:60][持続時間:2分8秒][対象:術者/PT][触媒:属性石(0/5]"+"</html>");
        if (ui.cb_buff[I_IAR].isSelected()) {
            dmg_big_ave += 10;
            dmg_small_ave += 10;
            if (ui.cb_buff[I_IAR].getForeground().equals(Color.BLUE)) {
                cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
            }
        }

        //PVP
        if (ui.cb_mode_pc.getSelectedIndex() == 1) {
            dmg_small_ave += buff.PVP;
        }

        //バフ効果
        switch (buki.type) {
            case "ガントレット":
            case "ボウ":
                dmg_big_ave += dmg_long;
                dmg_small_ave += dmg_long;
                break;
            case "キーリンク":
                break;
            default:
                dmg_big_ave += dmg_short;
                dmg_small_ave += dmg_short;
                break;

        }

        //ダメリダ
        dmg_big_ave -= Integer.parseInt((String) ui.cb_target_dr.getSelectedItem());
        dmg_small_ave -= Integer.parseInt((String) ui.cb_target_dr.getSelectedItem());

        //クラッシュ
        double ex = 0.0;
        ui.cb_buff[S_CRH].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "近距離攻撃時に一定確率(15%)で追加ダメージ"
                                         + "<br>"+ "[レベル]/[2]を与える"
                                         + "<br>"+ "[習得レベル:45][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[S_CRH].isSelected()) {
            ex = level / 2.0;
        }
        //フューリー
        ui.cb_buff[S_FUY].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "クラッシュ発動時に一定確率(10%)でダメージ2倍を与える"
                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[S_FUY].isSelected()) {
            dmg_big_ave = 0.15 * 0.1 * 2.0 * (dmg_big_ave + ex)
                    + (0.15 - (0.15 * 0.1)) * (dmg_big_ave + ex)
                    + (1.0 - 0.15) * dmg_big_ave;

            dmg_small_ave = 0.15 * 0.1 * 2.0 * (dmg_small_ave + ex)
                    + (0.15 - (0.15 * 0.1)) * (dmg_small_ave + ex)
                    + (1.0 - 0.15) * dmg_small_ave;
            ex = 0.0;

            dmg_undead *= (1 - 0.15 * 0.1) + 0.15 * 0.1 * 2.0;
            dmg_cursed *= (1 - 0.15 * 0.1) + 0.15 * 0.1 * 2.0;
        }
        dmg_big_ave += ex * 0.15;
        dmg_small_ave += ex * 0.15;

        if (buff.effect.contains("特殊攻撃(クラスタシアン/ウェアウルフ)")) {
            if (!(buki.type.equals("ボウ") || buki.type.equals("ガントレット") || buki.type
                    .equals(("キーリンク")))) {
                dmg_big_ave += 0.03 * 15;
                dmg_small_ave += 0.03 * 15;
            }
        }

        //オルターストーン 一撃必殺(1%確率で追加ダメージ50)追加分
        if (ui.cb_pattern_r2.getSelectedIndex() >= 6 && ui.cb_pattern_r2.getSelectedIndex() <= 8) {
            if (ui.cb_alterstone_op[0].getSelectedIndex() == 8
                    || ui.cb_alterstone_op[1].getSelectedIndex() == 8
                    || ui.cb_alterstone_op[2].getSelectedIndex() == 8) {
                dmg_big_ave += 0.01 * 50;
                dmg_small_ave += 0.01 * 50;
            }
        }
        //バーニングスピリッツ 消費MP20/5mins
       ui.cb_buff[D_BSS].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                        + "<br>"+ "一定確率(33%)で近距離ダメージ1.5倍"
                                        + "<br>"+ "[習得レベル:40][持続時間:常時][対象:術者]"+"</html>");
       if (ui.cb_buff[D_BSS].isSelected()) {
            if (!(buki.type.equals("ボウ") || buki.type.equals("ガントレット"))) {
                dmg_big_ave *= 1.5 * bs_rate
                        + 1.0 * (1.0 - bs_rate);
                dmg_small_ave *= 1.5 * bs_rate
                        + 1.0 * (1.0 - bs_rate);
                dmg_big_ave -= 0.25 * bs_rate;
                dmg_small_ave -= 0.25 * bs_rate;

                dmg_undead *= 1.5 * bs_rate
                        + 1.0 * (1.0 - bs_rate);
                dmg_cursed *= 1.5 * bs_rate
                        + 1.0 * (1.0 - bs_rate);

                if (dmg_undead != 0) {
                    dmg_undead -= 0.25 * bs_rate;
                }
                if (dmg_cursed != 0) {
                    dmg_cursed -= 0.25 * bs_rate;
                }

                if (ui.cb_buff[D_BSS].getForeground().equals(Color.BLUE)) {
                    cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            }
        }
        //エレメンタルファイアー 消費MP20/5mins
        ui.cb_buff[E_EFE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "一定確率(40%)で近距離ダメージ1.5倍にする"
                                         + "<br>"+ "[習得レベル:75][持続時間:5分20秒][対象:術者][触媒:精霊の玉(1)]"+"</html>");
        if (ui.cb_buff[E_EFE].isSelected()) {
            if (!(buki.type.equals("ボウ") || buki.type.equals("ガントレット"))) {
                dmg_big_ave *= 1.5 * ef_rate
                        + 1.0 * (1.0 - ef_rate);
                dmg_small_ave *= 1.5 * ef_rate
                        + 1.0 * (1.0 - ef_rate);

                dmg_big_ave -= 0.25 * ef_rate;
                dmg_small_ave -= 0.25 * ef_rate;

                dmg_undead *= 1.5 * ef_rate
                        + 1.0 * (1.0 - ef_rate);
                dmg_cursed *= 1.5 * ef_rate
                        + 1.0 * (1.0 - ef_rate);

                if (dmg_undead != 0) {
                    dmg_undead -= 0.25 * ef_rate;
                }
                if (dmg_cursed != 0) {
                    dmg_cursed -= 0.25 * ef_rate;
                }
                if (ui.cb_buff[E_EFE].getForeground().equals(Color.BLUE)) {
                    cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            }
        }
        //クエイク 消費MP20/5mins
        ui.cb_buff[E_QUE].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "一定確率(40%)で近距離ダメージ1.5倍にする"
                                         + "<br>"+ "[習得レベル:45][持続時間:5分20秒][対象:術者][触媒:精霊の玉(1)]"+"</html>");
        if (ui.cb_buff[E_QUE].isSelected()) {
            if (!(buki.type.equals("ボウ") || buki.type.equals("ガントレット"))) {
                dmg_big_ave *= 1.5 * qe_rate
                        + 1.0 * (1.0 - qe_rate);
                dmg_small_ave *= 1.5 * qe_rate
                        + 1.0 * (1.0 - qe_rate);

                dmg_big_ave -= 0.25 * qe_rate;
                dmg_small_ave -= 0.25 * qe_rate;

                dmg_undead *= 1.5 * qe_rate
                        + 1.0 * (1.0 - qe_rate);
                dmg_cursed *= 1.5 * qe_rate
                        + 1.0 * (1.0 - qe_rate);

                if (dmg_undead != 0) {
                    dmg_undead -= 0.25 * qe_rate;
                }
                if (dmg_cursed != 0) {
                    dmg_cursed -= 0.25 * qe_rate;
                }
                if (ui.cb_buff[E_QUE].getForeground().equals(Color.BLUE)) {
                    cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            }
        }
        //サイクロン 消費MP30/16mins LV75取得可能 一定確率で遠距離ダメージ1.5倍 LV85からLV1毎に発動率1%増加
        ui.cb_buff[E_CYE].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "一定確率(5%)で遠距離ダメージ1.5倍にする"
                                         + "<br>"+ "LV85からLV1毎に発動率1%増加"
                                         + "<br>"+ "[習得レベル:75][持続時間:16分][対象:術者][触媒:精霊の玉(2)]"+"</html>");
        if (ui.cb_buff[E_CYE].isSelected()) {
            if (level >= 75 && cls == E ) {
                double ce_lv_bonus =0;

                //LV85からのボーナス処理
		if (level >= 85) {
			ce_lv_bonus +=((level - 84) * 0.01);
		}

                dmg_big_ave *= 1.5 * (ce_rate + ce_lv_bonus)
                        + 1.0 * (1.0 - (ce_rate + ce_lv_bonus));
                dmg_small_ave *= 1.5 * (ce_rate + ce_lv_bonus)
                        + 1.0 * (1.0 - (ce_rate + ce_lv_bonus));

                dmg_big_ave -= 0.25 * (ce_rate + ce_lv_bonus);
                dmg_small_ave -= 0.25 * (ce_rate + ce_lv_bonus);

                dmg_undead *= 1.5 * (ce_rate + ce_lv_bonus)
                        + 1.0 * (1.0 - (ce_rate + ce_lv_bonus));
                dmg_cursed *= 1.5 * (ce_rate + ce_lv_bonus)
                        + 1.0 * (1.0 - (ce_rate + ce_lv_bonus));

                if (dmg_undead != 0) {
                    dmg_undead -= 0.25 * (ce_rate + ce_lv_bonus);
                }
                if (dmg_cursed != 0) {
                    dmg_cursed -= 0.25 * (ce_rate + ce_lv_bonus);
                }
                if (ui.cb_buff[E_CYE].getForeground().equals(Color.BLUE)) {
                    cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            } else {
                ui.cb_buff[E_CYE].setSelected(false);
            }
        }
         
        //ブレイブメンタル 消費MP25/10mins
        ui.cb_buff[P_BML].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "一定確率(40%)で近距離ダメージ1.5倍"
                                         + "<br>"+ "[習得レベル:70][持続時間:10分40秒][対象:術者]"+"</html>");
        if (ui.cb_buff[P_BML].isSelected()) {
            if (!(buki.type.equals("ボウ") || buki.type.equals("ガントレット"))) {
                dmg_big_ave *= 1.5 * pb_rate
                        + 1.0 * (1.0 - pb_rate);
                dmg_small_ave *= 1.5 * pb_rate
                        + 1.0 * (1.0 - pb_rate);

                dmg_big_ave -= 0.25 * pb_rate;
                dmg_small_ave -= 0.25 * pb_rate;

                dmg_undead *= 1.5 * pb_rate
                        + 1.0 * (1.0 - pb_rate);
                dmg_cursed *= 1.5 * pb_rate
                        + 1.0 * (1.0 - pb_rate);

                if (dmg_undead != 0) {
                    dmg_undead -= 0.25 * pb_rate;
                }
                if (dmg_cursed != 0) {
                    dmg_cursed -= 0.25 * pb_rate;
                }

                if (ui.cb_buff[P_BML].getForeground().equals(Color.BLUE)) {
                    cons_mp += 25.0 / 10;
                }
            } else {
                ui.cb_buff[P_BML].setSelected(false);
            }
        }
        //ブローアタック 消費MP10/5mins 武器対応:ダガー/片手剣/両手剣/鈍器/槍
        ui.cb_buff[K_BLK].setToolTipText("<html>"+ "[消費MP:10][消費HP:50]"
                                         + "<br>"+ "一定確率(5%)で近距離ダメージを1.5倍"
                                         + "<br>"+ "LV75からLV1毎に発動率1%増加"
                                         + "<br>"+ "[習得レベル:75][持続時間:5分][対象:術者]"+"</html>");
        if (ui.cb_buff[K_BLK].isSelected()) {
            if (level >= 75 && cls == K && buki_id == W_D || buki_id == W_LS || buki_id == W_TS || buki_id == W_A|| buki_id == W_L) {
                double bk_lv_bonus =((level - 74) * 0.01);
            
                dmg_big_ave *= 1.5 * (bk_rate + bk_lv_bonus)
                        + 1.0 * (1.0 - (bk_rate + bk_lv_bonus));
                dmg_small_ave *= 1.5 * (bk_rate + bk_lv_bonus)
                        + 1.0 * (1.0 - (bk_rate + bk_lv_bonus));

                dmg_big_ave -= 0.25 * (bk_rate + bk_lv_bonus);
                dmg_small_ave -= 0.25 * (bk_rate + bk_lv_bonus);

                dmg_undead *= 1.5 * (bk_rate + bk_lv_bonus)
                        + 1.0 * (1.0 - (bk_rate + bk_lv_bonus));
                dmg_cursed *= 1.5 * (bk_rate + bk_lv_bonus)
                        + 1.0 * (1.0 - (bk_rate + bk_lv_bonus));

                if (dmg_undead != 0) {
                    dmg_undead -= 0.25 * (bk_rate + bk_lv_bonus);
                }
                if (dmg_cursed != 0) {
                    dmg_cursed -= 0.25 * (bk_rate + bk_lv_bonus);
                }
                if (ui.cb_buff[K_BLK].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            } else {
                ui.cb_buff[K_BLK].setSelected(false);
            }
        }
        if (buff.effect.contains("特殊攻撃(パック/パオ)")) {
            dmg_big_ave += (75 - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * 0.05;
            dmg_small_ave += (75 - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * 0.05;
        }
        int dmg_rate = 0;
        int dmg = 0;
        for (String split : buff.effect.split(",")) {
            if (split.contains("追加ダメージ")) {
                String[] a = split.split(" ");
                if (a[1].contains("+")) {
                    dmg += Integer.parseInt(a[1]);
                }
                if (a.length >= 2) {
                    if (a[2].contains("%")) {
                        dmg_rate += Integer.parseInt(a[2].split("%")[0]);
                    }
                }
//                System.out.println(dmg + " " + dmg_rate);
//                System.out.println((dmg - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * (dmg_rate / 100.0));
                dmg_small_ave += (dmg - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * (dmg_rate / 100.0);
                dmg_big_ave += (dmg - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * (dmg_rate / 100.0);
            }
        }
//        if (ui.i2h.isSelected()) {
//            dmg_big_ave *= 0.5;
//            dmg_small_ave *= 0.5;
//        }
//
//        switch (ui.kago.getSelectedIndex()) {
//            case 1:
//                dmg_big_ave -= 0.05 * 80;
//                dmg_small_ave -= 0.05 * 80;
//                break;
//            case 2:
//                dmg_big_ave -= 0.05 * 31;
//                dmg_small_ave -= 0.05 * 31;
//                break;
//        }
        if (ui.cb_speed_auto.isSelected()) {
            ui.tf_acc.setText(format_rate_2.format(acc));
        } else {
            acc = Double.parseDouble(ui.tf_acc.getText());
        }
        // 弱点露出
        double week = 0;
        double fsdmg = 0;
        if (cls == R
                && ui.cb_magic.getSelectedItem()
                != null) {
            if (ui.cb_magic.getSelectedItem().equals("フォースレイヤー")) {
                double week_rate = we;
                double t = 60.0 / (polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), MAIN) * acc) + 2.0;
                t = key_delay * ((int) (t / key_delay) + 1.0);
                if (speed != 0.0) {
                    speed = FSCalclator.calc(t, speed * acc);
                }

                double n = speed * t / 60;

                if (buff.effect.contains("フォースレイヤーダメージ+10")) {
                    fsdmg = n * 10;
                }

                double w0 = Math.pow((1 - week_rate * hit), n);
                double w1 = (week_rate * hit) * Math.pow((1 - week_rate * hit), n - 1)
                        * n;
                double w2 = Math.pow((week_rate * hit), 2)
                        * Math.pow((1 - week_rate * hit), n - 2) * n * (n - 1) / 2;
                double w3 = 1 - w0 - w1 - w2;
                week = (20 * w1 + 40 * w2 + 60 * w3) * 3 * hit;
                week *= 60 / t;

            } else {
                if (ui.cb_speed_auto.isSelected()) {
                    ui.tf_acc.setText(format_rate_2.format(acc));
                } else {
                    acc = Double.parseDouble(ui.tf_acc.getText());
                }
                speed *= acc;
            }
        } else {
            speed *= acc;
        }

        dmg_small_ave += magic + drain_small;
        dmg_big_ave += magic + drain_big;

        ui.lab_dmg_normal.setText(Integer.toString((int) (dmg_small_ave * hit * speed + mag_dmg_min + week + fsdmg))
                + " / " + Integer.toString(
                        (int) (dmg_big_ave * hit * speed + mag_dmg_min + week + fsdmg)));
        ui.lab_dmg_cursed.setText(Integer.toString((int) ((dmg_small_ave + dmg_cursed) * hit * speed + mag_dmg_min + week + fsdmg))
                + " / " + Integer.toString(
                        (int) ((dmg_big_ave + dmg_cursed) * hit * speed + mag_dmg_min + week + fsdmg)));
        ui.lab_dmg_undead.setText(Integer.toString((int) ((dmg_small_ave + dmg_cursed + dmg_undead) * hit * speed + mag_dmg_min + week + fsdmg))
                + " / " + Integer.toString(
                        (int) ((dmg_big_ave + dmg_cursed + dmg_undead) * hit * speed + mag_dmg_min + week + fsdmg)));

        switch ((String) ui.cb_e_size.getSelectedItem()) {
            case "小":
                double ATK = 0;
                switch ((String) ui.cb_e_type.getSelectedItem()) {
                    case "通常":
                        ATK = dmg_small_ave * hit * speed + mag_dmg_min + week;
                        break;
                    case "悪魔":
                        ATK = (dmg_small_ave + dmg_cursed) * hit * speed + mag_dmg_min + week;
                        break;
                    case "不死":
                        ATK = (dmg_small_ave + dmg_cursed + dmg_undead) * hit * speed + mag_dmg_min + week;
                        break;
                    default:
                        break;
                }

                double E_HP = Integer.parseInt(ui.tf_e_hp.getText());
                double E_HPR = Integer.parseInt(ui.tf_e_hpr.getText());

                ATK /= 60;
                ATK *= 5;

                double TIME = E_HP / (ATK - E_HPR);
                TIME *= 5;

                if (TIME < 0) {
                    ui.lab_time.setText("INF");
                } else {

                    int MIN = (int) (TIME / 60);
                    int S = (int) (TIME % 60);

                    ui.lab_time.setText(Integer.toString((MIN)) + "分 " + Integer.toString((S)) + "秒");
                }
                break;
            case "大":
                ATK = 0;
                switch ((String) ui.cb_e_type.getSelectedItem()) {
                    case "通常":
                        ATK = dmg_big_ave * hit * speed + mag_dmg_min + week;
                        break;
                    case "悪魔":
                        ATK = (dmg_big_ave + dmg_cursed) * hit * speed + mag_dmg_min + week;
                        break;
                    case "不死":
                        ATK = (dmg_big_ave + dmg_cursed + dmg_undead) * hit * speed + mag_dmg_min + week;
                        break;
                    default:
                        break;
                }

                E_HP = Integer.parseInt(ui.tf_e_hp.getText());
                E_HPR = Integer.parseInt(ui.tf_e_hpr.getText());

                ATK /= 60;
                ATK *= 5;

                TIME = E_HP / (ATK - E_HPR);
                TIME *= 5;

                if (TIME < 0) {
                    ui.lab_time.setText("INF");
                } else {

                    int MIN = (int) (TIME / 60);
                    int S = (int) (TIME % 60);

                    ui.lab_time.setText(Integer.toString((MIN)) + "分 " + Integer.toString((S)) + "秒");
                }
                break;
        }

        switch (buki.magic_name) {
            case "":
                ui.lab_mag_info1.setText("魔法:なし");
                ui.lab_mag_info2.setText("");
                ui.tf_mag_rate.setEnabled(false);
                ui.tf_mag_delay.setEnabled(false);
                ui.tf_mag_power.setEnabled(false);

                ui.tf_mag_rate.setText("0.00");
                ui.tf_mag_delay.setText("0.0");
                ui.tf_mag_power.setText("0.0");
                break;
            case "HP吸収":
                ui.lab_mag_rate.setEnabled(true);
                ui.lab_mag_info1.setText("魔法:" + buki.magic_name);
                break;
            default:
                ui.lab_mag_info1.setText("魔法:"
                        + buki.magic_name);
                if (rate != 0) {
                    ui.lab_mag_info2.setText(
                            "魔法ダメージ " + format_dmg.format(magic / rate) + "  " + format_rate.format(rate));
                } else {
                    ui.lab_mag_info2.setText("");
                }
                break;
        }
        ui.lab_hit_rate.setText("命中率:" + format_rate.format(hit_rate));

        for (int i = 0;
                i < ST_LIST.length;
                i++) {
            ui.lab_st_sum[i].setText(Integer.toString(_ST[BASE][i] + _ST[REM][i]
                    + _ST[LEVEL][i] + _ST[ENCHANT][i] + _ST[ELIXIR][i]));

            ui.lab_st_base[i].setText(Integer.toString(_ST[BASE][i] + _ST[REM][i]));
            ui.lab_st_lev[i].setText(Integer.toString(_ST[LEVEL][i] + _ST[ELIXIR][i]));
            ui.lab_st_add[i].setText(Integer.toString(_ST[ENCHANT][i]));

        }

        ui.lab_dmg_short.setText(
                "基本ダメージ(近) : " + base_dmg_short);
        ui.lab_dmg_long.setText(
                "基本ダメージ(遠) : " + base_dmg_long);
        ui.lab_dmg_mag.setText(
                "基本ダメージ(魔) : " + base_dmg_magic);

        //仮
        ui.lab_hit_short.setText("命中(近) : " + hit_short);
        ui.lab_hit_long.setText("命中(遠) : " + hit_long);

//        ui.lab_hit_short.setText("命中(近) : " + hit_short);
//        ui.lab_ac_short.setText("(最大命中AC : " + Integer.toString(19 - hit_short) + ")");
//        ui.lab_hit_long.setText("命中(遠) : " + hit_long);
//        ui.lab_ac_long.setText("(最大命中AC : " + Integer.toString(19 - hit_long) + ")");
        ui.lab_hit_mag.setText("命中(魔) : " + hit_magic);

        ui.lab_cri_short.setText("クリティカル(近) : " + cri_short);
        ui.lab_cri_long.setText("クリティカル(遠) : " + cri_long);
        ui.lab_cri_mag.setText("クリティカル(魔) : " + cri_magic);
        ui.lab_pvp_dg.setText("PVP追加ダメージ : " + pvp_dg);
        ui.lab_pvp_dgr.setText("PVPダメージ低下 : " + pvp_dgr);
        
//        ui.lab_sp.setText("SP " + sp);
//        ui.lab_ml.setText("ML " + ml);
//        ui.lab_mb.setText("MB " + mb);
//        ui.lab_mag_dmg.setText("魔法ダメージ " + base_dmg_magic);
        ui.pure_status_bonus[1][0].setText(Integer.toString(base_dmg_short));   //近距離ダメージ
        ui.pure_status_bonus[1][1].setText(Integer.toString(base_hit_short));   //近距離命中
        ui.pure_status_bonus[1][2].setText(Integer.toString(cri_short));        //近距離クリティカル

        ui.pure_status_bonus[1][5].setText(Integer.toString(base_dmg_long));    //遠距離ダメージ
        ui.pure_status_bonus[1][6].setText(Integer.toString(base_hit_long));    //遠距離命中
        ui.pure_status_bonus[1][7].setText(Integer.toString(cri_long));         //遠距離クリティカル

        ui.pure_status_bonus[1][10].setText(Integer.toString(base_dmg_magic));  //魔法ダメージ
        ui.pure_status_bonus[1][11].setText(Integer.toString(base_hit_magic));  //魔法命中
        ui.pure_status_bonus[1][12].setText(Integer.toString(cri_magic));       //魔法クリティカル
        ui.pure_status_bonus[1][13].setText(Integer.toString(mb));              //MB
        ui.pure_status_bonus[1][14].setText((Integer.toString(red_mp)));        //MP消費減少

        equip_ac = 0;

        for (Bougu bougu1 : bougu) {
            equip_ac += bougu1.op.AC + bougu1.op2.AC;
        }
        if (ui.tb_ts_sp.isSelected()) {
            equip_ac += -1;
        }

        int c = 6;
//        int d = 4;
        switch (cls) {
            case P:
                c = 6;
//                d = 4;
                break;
            case K:
                c = 6;
//                d = 2;
                break;
            case E:
                c = 7;
//                d = 4;
                break;
            case W:
                c = 8;
//                d = 4;
                break;
            case D:
                c = 6;
//                d = 3;
                break;
            case R:
                c = 6;
//                d = 3;
                break;
            case I:
                c = 8;
//                d = 3;
                break;
            case S:
                c = 6;
//                d = 3;
                break;
            case F:
                c = 6;
//                d = 3;
                break;
            default:
                break;
        }
        base_ac = 10 - (int) (dex / 3) - (int) (level / c);
//        LV60からPVPダメージ低下
//        if (level >= 60){
//        base_pvp_dr = (int) ((level-60) / d);
//        System.out.println(base_pvp_dr);    //初期値確認用
//        }

//ERの計算式
        base_er = (int) (dex / 2) + (int) (level / _C[ER][DEX][cls]);

        ui.pure_status_bonus[1][8].setText(Integer.toString(base_ac));          //AC
        ui.pure_status_bonus[1][9].setText(Integer.toString(base_er));          //ER

        ac = base_ac + buff.AC + equip_ac;
        dg = base_dg + buff.DG;
        er = base_er + buff.ER;
        me = base_me + buff.ME;
//        int dr = buff.DR;
//        int dri= buff.DR_IGNORED;
        //AC-100以上からAC-10ごとにERが+1
        if (ac <= -100){
                er += -ac / 10-10;
        }
        dr = buff.DR;
        dri= buff.DR_IGNORED;    
        pvp_dg = buff.PVP;
        pvp_dgr = buff.PVP_DR;
        mhp = buff.MHP;                                                         //最大HP+X%(BUFF分)
        mmp = buff.MMP;                                                         //最大MP+X%(BUFF分)
        mexp = buff.MEXP;                                                       //獲得経験値+X%(BUFF分)
        
//        pvp_dgr= base_pvp_dr + buff.PVP_DR;
//        System.out.println(pvp_dgr);    //初期値確認用

        //アーマーガード
        ui.cb_buff[S_AGD].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "ダメージ低下+[AC]/[10]"
                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[S_AGD].isSelected()) {
            dr += -ac / 10;
        }

        for (Bougu bougu1 : bougu) {
            dr += bougu1.op.DR;
            dr += bougu1.op2.DR;
            dri += bougu1.op.DR_IGNORED;
            dri += bougu1.op2.DR_IGNORED;
            pvp_dg += bougu1.op.PVP;
            pvp_dg += bougu1.op2.PVP;
            pvp_dgr += bougu1.op.PVP_DR;
            pvp_dgr += bougu1.op2.PVP_DR;
            mhp += bougu1.op.MHP;                                               //最大HP+X%(防具分)
            mhp += bougu1.op2.MHP;                                              //最大HP+X%(防具分)
            mmp += bougu1.op.MMP;                                               //最大MP+X%(防具分)
            mmp += bougu1.op2.MMP;                                              //最大MP+X%(防具分)
            mexp += bougu1.op.MEXP;                                             //獲得経験値+X%(防具分)
            mexp += bougu1.op2.MEXP;                                            //獲得経験値+X%(防具分)
        }
//        dg = 0;
        //AC-100以上からAC-10ごとにDGが+1
        if (ac <= -100){
        dg += -ac / 10-10;
        }
        dr += buki.op.DR + buki.op2.DR;
        dri += buki.op.DR_IGNORED + buki.op2.DR_IGNORED; 
        pvp_dg += buki.op.PVP + buki.op2.PVP;
        pvp_dgr += buki.op.PVP_DR + buki.op2.PVP_DR; 
        mhp += buki.op.MHP + buki.op2.MHP;                                      //最大HP+X%(武器分)
        mmp += buki.op.MMP + buki.op2.MMP;                                      //最大MP+X%(武器分)
        mexp += buki.op.MEXP + buki.op2.MEXP;                                   //獲得経験値+X%(武器分)

        //アンキャニードッジ 消費MP40/16mins
        ui.cb_buff[D_UDE].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                         + "<br>"+ "近距離回避[DG]+30 AC-100以上だとエフェクトが黄金に変化"
                                         + "<br>"+ "キャンセレーションで解除されない"                
                                         + "<br>"+ "[習得レベル:60][持続時間:16分][対象:術者][触媒:ダークストーン(1)]"+"</html>");
        if (ui.cb_buff[D_UDE].isSelected()) {
            dg += 30;
            if (ui.cb_buff[D_UDE].getForeground().equals(Color.BLUE)) {
                cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
            }
        }
        //ミラーイメージ 消費MP20/20mins
        ui.cb_buff[I_MIE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "近距離回避[DG]+30"
                                         + "<br>"+ "キャンセレーションで解除されない"                
                                         + "<br>"+ "[習得レベル:15][持続時間:20分][対象:術者]"+"</html>");
        if (ui.cb_buff[I_MIE].isSelected()) {
            dg += 30;
            if (ui.cb_buff[I_MIE].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
            }
        }
        //覚醒[リンドビオル] 消費MP40/10mins
        ui.cb_buff[R_LINDVIOL].setToolTipText("<html>"+ "[消費MP:40][消費HP:40]"
                                              + "<br>"+ "近距離回避[DG]+7"
                                              + "<br>"+ "キャンセレーションで解除されない"                
                                              + "<br>"+ "[習得レベル:80][持続時間:10分][対象:術者][触媒:刻印のボーンピース(1)]"+"</html>");
        if (ui.cb_buff[R_LINDVIOL].isSelected()) {
            dg += 7;
            if (ui.cb_buff[R_LINDVIOL].getForeground().equals(Color.BLUE)) {
                    cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //インフィニティ:ドッジ
        ui.cb_buff[F_PIE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "DG+5"
                                         + "<br>"+ "レベル70からレベル2毎にDGが+1ずつ増加[最大+20]"
                                         + "<br>"+ "[習得レベル:70][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PIE].isSelected()) {
            if (cls == F) {            	
		if (level >= 89) {
                    dg += 20;                                                   //最大DG+20(LV89)
        	} else if (level >= 70) {
                    dg += 5 + ((level - 70) / 2 + 1);                           //基本DG+5 + ((level - 70) / 2 + 1)
        	}
            } else {
                ui.cb_buff[F_PIE].setSelected(false);
            }
        }
        ui.lab_ac.setText(Integer.toString(ac));
        ui.lab_dg.setText(Integer.toString(dg));
        ui.lab_er.setText(Integer.toString(er));
        ui.lab_me.setText(Integer.toString(me));
        ui.lab_dr.setText(Integer.toString(dr));
        ui.lab_dri.setText(Integer.toString(dri));
        ui.lab_sp.setText(Integer.toString(sp));
        ui.lab_ml.setText(Integer.toString(ml)); 
        ui.lab_mb.setText(Integer.toString(mb));
        ui.lab_spr.setText(Integer.toString(spr));

        int con = _ST[BASE][CON] + _ST[REM][CON] + _ST[LEVEL][CON]
                + _ST[ELIXIR][CON] + _ST[ENCHANT][CON];
        double r_eq = 0;

        for (Bougu bougu1 : bougu) {
            r_eq += bougu1.op.r_weight;
            r_eq += bougu1.op2.r_weight;
        }
        r_eq += buff.r_weight;

        int weight = (int) ((str + con) / 2) * 100 + 1000;

        ui.pure_status_bonus[1][3].setText(Integer.toString(weight));           //最大所持重量
        ui.pure_status_bonus[1][23].setText(Integer.toString(weight));          //最大所持重量

        weight *= 1 + r_eq;

        int c_eq = 0;

        for (Bougu bougu1 : bougu) {
            c_eq += bougu1.op.c_weight;
            c_eq += bougu1.op2.c_weight;
        }

        weight += c_eq;
        //エルヴングラヴィティー    消費MP:30/30mins 所持重量増加+300
        ui.cb_buff[E_ELY].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "所持重量増加+300"
                                         + "<br>"+ "ディクリースウェイトの上位魔法"
                                         + "<br>"+ "[習得レベル:75][持続時間:30分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_ELY].isSelected()) {
            ui.cb_buff[W_DWT].setSelected(false);
            weight += 300;
            if (ui.cb_buff[E_ELY].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
            }
        }
        //リデュースウェイト        消費MP:50/30mins 所持重量増加+480 
        ui.cb_buff[I_RWT].setToolTipText("<html>"+ "[消費MP:50][消費HP:--]"
                                         + "<br>"+ "所持重量増加+480"
                                         + "<br>"+ "ディクリースウェイトの上位版なので重複不可能"
                                         + "<br>"+ "[習得レベル:60][持続時間:30分][対象:術者]"+"</html>");
        if (ui.cb_buff[I_RWT].isSelected()) {
            ui.cb_buff[W_DWT].setSelected(false);
            weight += 480;
            if (ui.cb_buff[I_RWT].getForeground().equals(Color.BLUE)) {
                cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
            }
        }
        //ディクリースウェイト      消費MP:10/30mins 所持重量増加+180
        ui.cb_buff[W_DWT].setToolTipText("<html>"+ "[消費MP:10][消費HP:50]"
                                         + "<br>"+ "所持重量増加+180"
                                         + "<br>"+ "[習得レベル:80][持続時間:30分][対象:術者]"+"</html>");
        if (ui.cb_buff[W_DWT].isSelected()) {
            weight += 180;
            if (ui.cb_buff[W_DWT].getForeground().equals(Color.BLUE)) {
                cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
            }
        }
        //ドラゴンの祝福2と加護2(重量のみの処理)2か所の判定で実装している
        if (ui.cb_buff[DRAGON_BLESS].isSelected()) {
            switch ((String) ui.cb_buff_group[DRAGON_BLESS].getSelectedItem()) {
                case "祝福":
                    weight += 500;                              //所持重量増加+500
                    break;
                case "加護":
                    weight += 100;                              //所持重量増加+100
                    break;
                default:
                    break;
            }
        }
        
        //所持可能な重量の上限を5400から無制限に変更
        //if (weight > 5400) {
        //    weight = 5400;
        //}

        ui.tf_weight2.setText(Integer.toString(weight));
        //重量表示
        switch (ui.cb_weight.getSelectedIndex()) {
            case 0:
                ui.tf_weight.setText(Integer.toString(weight * 2 / 6));
                break;
            case 1:
                ui.tf_weight.setText(Integer.toString(weight * 3 / 6));
                break;
            case 2:
                ui.tf_weight.setText(Integer.toString(weight * 4 / 6));
                break;
            case 3:
                ui.tf_weight.setText(Integer.toString(weight * 5 / 6));
                break;
            default:
                break;
        }
        int wis = _ST[BASE][WIS] + _ST[REM][WIS] + _ST[LEVEL][WIS]
                + _ST[ELIXIR][WIS] + _ST[ENCHANT][WIS];

        mr = minasToZero(wis - 10) * 4 + (int) (level / 2) + _C[MR][WIS][cls];
        ui.pure_status_bonus[1][18].setText(Integer.toString(mr));              //MR
        mr += buff.MR;
        mr += buki.op.MR + buki2.op.MR;
        for (Bougu bougu1 : bougu) {
            mr += bougu1.op.MR;
            mr += bougu1.op2.MR;
        }
        ui.lab_mr.setText(Integer.toString(mr));

        calcHPMP();

        System.arraycopy(buff.element_resist, 0, res_ele, 0, ELEM_LIST.length);
        System.arraycopy(buff.ailment, 0, res_ail, 0, AILMENT_LIST.length);

        for (Bougu bougu1 : bougu) {

            for (int i = 0; i < ELEM_LIST.length; i++) {
                res_ele[i] += bougu1.op.element_resist[i] + bougu1.op2.element_resist[i];
            }
            for (int i = 0; i < AILMENT_LIST.length; i++) {
                res_ail[i] += bougu1.op.ailment[i] + bougu1.op2.ailment[i];
            }
        }

        for (int i = 0; i < ELEM_LIST.length; i++) {
            if (res_ele[i] > 100) {
                res_ele[i] = 100;
            }
            ui.lab_elem[i].setText(ELEM_LIST[i] + " " + res_ele[i]);
        }
        for (int i = 0; i < AILMENT_LIST.length; i++) {
            ui.lab_ailment[i].setText(AILMENT_LIST[i] + " " + (res_ail[i] + buki.op.ailment[i] + buki.op2.ailment[i]));
        }

        int hpr = 0;
        int mpr = 0;
        int pure_con = _ST[BASE][CON] + _ST[REM][CON] + _ST[LEVEL][CON]
                + _ST[ELIXIR][CON];
        int pure_wis = _ST[BASE][WIS] + _ST[REM][WIS] + _ST[LEVEL][WIS]
                + _ST[ELIXIR][WIS];

        int hp_pot;

        //魔力回復ポーション(魔力回復ポーション/古代の魔力回復ポーション/神秘の濃縮マナポーション)
        ui.cb_buff[ITEM_BLUE].setToolTipText("<html>"+ "魔力回復ポーション"
                                             + "<br>"+ "古代の魔力回復ポーション"
                                             + "<br>"+ "神秘の濃縮マナポーション"+"</html>");
        if (ui.cb_buff[ITEM_BLUE].isSelected()) {
            if (wis >= 10) {
                //mpr += (wis - 10) / 2;
                //ui.pure_status_bonus[1][22].setText(Integer.toString((wis - 10) / 2));
                mpr += (wis - 8) / 2;
                ui.pure_status_bonus[1][17].setText(Integer.toString((wis - 8) / 2));   //MPR
            } else {
                mpr++;
            }
        }

        int tmp = (int) (wis / 5) + (int) (level / 40);
        mpr += tmp;
        if (pure_wis >= 25) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(1));               //
                mpr++;
            }
            mpr++;                          //MP回復+1
            tmp++;                          //MPポーション回復増加+1
                                            //最大MP+50は5563行目以降で処理
        }
        if (pure_wis >= 35) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(2));
                mpr++;
            }
            mpr++;                          //MP回復+1
            tmp++;                          //MPポーション回復増加+1
                                            //最大MP+100は5563行目以降で処理
        }
        if (pure_wis >= 45) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(5));
                mpr += 3;
            }
            mpr += 3;                       //MP回復+3
            tmp += 3;                       //MPポーション回復増加+3
                                            //最大MP+150は5563行目以降で処理
        }
        if (pure_wis >= 55) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(10));
                mpr += 5;
            }
            mpr += 5;                       //MP回復+5
            tmp += 5;                       //MPポーション回復増加+5
                                            //最大MP+200は5563行目以降で処理
        }
        
        ui.pure_status_bonus[1][16].setText(Integer.toString(tmp));             //MP増加

        hpr += (con / 2 + level / 20);
        hp_pot = (int) (minasToZero(con - 10) / 10);

        if (pure_con >= 25) {
            hpr++;                          //HP回復+1
                                            //最大HP+50は5549行目以降で処理
        }
        if (pure_con >= 35) {
            hpr++;                          //HP回復+1
            hp_pot++;                       //HPポーション回復増加+1%
                                            //最大HP+100は5549行目以降で処理
        }
        if (pure_con >= 45) {
            hpr += 3;                       //HP回復+3
            hp_pot += 2;                    //HPポーション回復増加+2%
                                            //最大HP+150は5549行目以降で処理
        }
        if (pure_con >= 55) {
            hpr += 5;                       //HP回復+5
            hp_pot += 4;                    //HPポーション回復増加+4%
                                            //最大HP+200は5549行目以降で処理
        }

        ui.pure_status_bonus[1][21].setText(Integer.toString(hpr));             //HP増加
        ui.pure_status_bonus[1][22].setText(Integer.toString(hp_pot));          //HPポーション

        hpr += buff.HPR;
        mpr += buff.MPR;

        hpr += buki.op.HPR + buki.op2.HPR + buki2.op.HPR + buki2.op2.HPR;
        mpr += buki.op.MPR + buki.op2.MPR + buki2.op.MPR + buki2.op2.MPR;
        for (Bougu bougu1 : bougu) {
            hpr += bougu1.op.HPR + bougu1.op2.HPR;
            mpr += bougu1.op.MPR + bougu1.op2.MPR;
        }

        if (hpr < 0) {
            hpr = 0;
        }

        int hpr2 = 0;
        int mpr2 = 0;

       for (String split : buff.effect.split(",")) {
            if (split.contains("HP回復")) {
                hpr2 += Integer.parseInt(split.split(" ")[1]);
            }
            if (split.contains("MP回復")) {
                mpr2 += Integer.parseInt(split.split(" ")[1]);
            }
        }

        if (hpr2 > 0) {
            ui.lab_hpr.setText(hpr + "  (64秒毎 " + hpr2 + ")");
        } else {
            ui.lab_hpr.setText(Integer.toString(hpr));
        }
        if (mpr2 > 0) {
            ui.lab_mpr.setText(mpr + "  (64秒毎 " + mpr2 + ")");
        } else {
            ui.lab_mpr.setText(Integer.toString(mpr));
        }

        int pot_rate = hp_pot;
        int pot = 0;
        for (String split : buff.effect.split(",")) {
            if (split.contains("ポーション回復量")) {
                String[] a = split.split(" ");
                if (a[1].contains("%")) {
                    pot_rate += Integer.parseInt(a[1].split("%")[0]);
                }
                if (a.length >= 2) {
                    if (a[2].contains("+")) {
                        pot += Integer.parseInt(a[2]);
                    }
                }

            }
        }
        ui.lab_pot1.setText("+" + pot_rate + "%");
        ui.lab_pot2.setText("+" + pot);

        createToolTip();
    }

    private void calcHPMP() {
        hp = 0;
        mp = 0;
        int con = _ST[BASE][CON] + _ST[REM][CON];
        int wis = _ST[BASE][WIS] + _ST[REM][WIS];

        switch (cls) {
            case P:
                hp = 14;
                mp = 3;
                break;
            case K:
                hp = 16;
                mp = 2;
                break;
            case E:
                hp = 15;
                mp = 4;
                break;
            case W:
                hp = 12;
                mp = 6;
                break;
            case D:
                hp = 12;
                mp = 4;
                break;
            case R:
                hp = 16;
                mp = 2;
                break;
            case I:
                hp = 14;
                mp = 5;
                break;
            case S:
                hp = 16;
                mp = 2;
                break;
            case F:
                hp = 16;
                mp = 2;
                break;
            default:
                break;
        }

//種族が増えた場合配列を1つ増やす必要あり c1とc2の値が不明　mpの量を決定する為の値と思われる
//        double[] c1 = {1.0, 2.0 / 3.0, 1.5, 2.0, 1.5, 0.7, 1.7, 2.0 / 3.0};
//        int[] c2 = {1, 0, 1, 2, 1, 1, 1, 0};
        double[] c1 = {1.0, 2.0 / 3.0, 1.5, 2.0, 1.5, 0.7, 1.7, 2.0 / 3.0, 2.0 / 3.0};
        int[] c2 = {1, 0, 1, 2, 1, 1, 1, 0, 0};
        
        for (int i = 2; i <= level; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == ui.cb_elixir_level[j].getSelectedIndex() + 1) {
                    if (ui.cb_elixir[j].getSelectedIndex() - 1 == CON) {
                        con++;
                    }
                    if (ui.cb_elixir[j].getSelectedIndex() - 1 == WIS) {
                        wis++;
                    }
                }
            }
            if (i >= 51) {
                if (ui.lev.getField(i) == CON
                        && !ui.lev.isOverflow(i)) {
                    con++;
                }
                if (ui.lev.getField(i) == WIS
                        && !ui.lev.isOverflow(i)) {
                    wis++;
                }
            }

            if (con <= 25) {
                hp += 1.5 + minasToZero(con - 12) + _C[HP][CON][cls];
            } else {
                hp += 1.5 + (int) ((con + 1) / 2) + _C[HP][CON][cls];
            }

            mp += 0.5 * ((int) ((int) wis / 5) * c1[cls] + c2[cls])
                    + 0.5 * ((int) ((int) wis / 3 * c1[cls]) + c2[cls]);

        }

        if (con <= 25) {
            int min = 1 + minasToZero(con - 12) + _C[HP][CON][cls];
            int max = 2 + minasToZero(con - 12) + _C[HP][CON][cls];

            ui.pure_status_bonus[1][20].setText(min + " - " + max);             //HP増加
        } else {
            int min = 1 + (int) ((con + 1) / 2) + _C[HP][CON][cls];
            int max = 2 + (int) ((con + 1) / 2) + _C[HP][CON][cls];

            ui.pure_status_bonus[1][20].setText(min + " - " + max);             //HP増加
        }

        {
            int min = (int) ((int) (wis / 5) * c1[cls]) + c2[cls];
            int max = (int) ((int) (wis / 3) * c1[cls]) + c2[cls];

            ui.pure_status_bonus[1][15].setText(min + " - " + max);             //MP増加
        }

//CONステータスによるHP増加処理
        if (con >= 25) {
            hp += 50;
        }
        if (con >= 35) {
            hp += 100;
        }
        if (con >= 45) {
            hp += 150;
        }
        if (con >= 55) {
            hp += 200;
        }

//WISステータスによるMP増加処理
        if (wis >= 25) {
            mp += 50;
        }
        if (wis >= 35) {
            mp += 100;
        }
        if (wis >= 45) {
            mp += 150;
        }
        if (wis >= 55) {
            mp += 200;
        }

        int eq_hp = buff.HP;
        int eq_mp = buff.MP;
        eq_hp += buki.op.HP + buki2.op.HP;
        eq_mp += buki.op.MP + buki2.op.HP;
        for (Bougu bougu1 : bougu) {
            eq_hp += bougu1.op.HP + bougu1.op2.HP;
            eq_mp += bougu1.op.MP + bougu1.op2.MP;
        }
        switch (cls) {
            case P:
                eq_hp += _ST[ENCHANT][CON] * 10;
                break;
            case K:
                eq_hp += _ST[ENCHANT][CON] * 16;
                break;
            case E:
                eq_hp += _ST[ENCHANT][CON] * 9;
                break;
            case W:
                eq_hp += _ST[ENCHANT][CON] * 6;
                break;
            case D:
                eq_hp += _ST[ENCHANT][CON] * 9;
                break;
            case R:
                eq_hp += _ST[ENCHANT][CON] * 12;
                break;
            case I:
                eq_hp += _ST[ENCHANT][CON] * 8;
                break;
            case S:
                eq_hp += _ST[ENCHANT][CON] * 16;
                break;
            case F:
                eq_hp += _ST[ENCHANT][CON] * 16;
                break;
            default:
                break;
        }

        int hpp = 0;
        int mpp = 0;

//        if (ui.cb_buff[WAR].isSelected() && ui.cb_buff_group[WAR].getSelectedIndex() == 1) {
//            if (level >= 80) {
//            } else if (level >= 70) {
//                hpp += 0.1 * hp;
//                mpp += 0.1 * mp;
//            } else if (level >= 60) {
//                hpp += 0.3 * hp;
//                mpp += 0.3 * mp;
//            } else if (level >= 52) {
//                hpp += 0.5 * hp;
//                mpp += 0.5 * mp;
//            }
//        }

        //ペンダント等の装備による最大HP+X%/最大MP+X%の処理
            	hpp += mhp *0.01 * hp;
            	mpp += mmp *0.01 * mp;

        //アドバンスドスピリッツ 消費MP20/20mins
        ui.cb_buff[W_ADS].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "最大HP/MP+20%"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "リスタートすると効果が消える"
                                         + "<br>"+ "[習得レベル:80][持続時間:20分][対象:術者]"+"</html>");
        if (ui.cb_buff[W_ADS].isSelected()) {
            if (ui.cb_buff[S_GIC].isSelected()
                    || ui.cb_buff[K_PRE].isSelected()) {
                ui.cb_buff[W_ADS].setSelected(false);
            } else {
            	hpp += 0.2 * hp;
            	mpp += 0.2 * mp;
                if (ui.cb_buff[W_ADS].getForeground().equals(Color.BLUE)) {
                    cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                }
            }
        }
        //プライド 消費MP10/5mins
        ui.cb_buff[K_PRE].setToolTipText("<html>"+ "[消費MP:10][消費HP:100]"
                                         + "<br>"+ "最大HP LV/4% 増加"
                                         + "<br>"+ "[習得レベル:60][持続時間:5分][対象:術者]"+"</html>");
        if (ui.cb_buff[K_PRE].isSelected()) {
            if (ui.cb_buff[S_GIC].isSelected()
                    || ui.cb_buff[W_ADS].isSelected()) {
                ui.cb_buff[K_PRE].setSelected(false);
            } else {
           	hpp += (level/4)*0.01 * hp;
                if (ui.cb_buff[K_PRE].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            }
        }
        //ギガンテック 消費MP10/5mins
        ui.cb_buff[S_GIC].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "最大HPを増加する"
                                         + "<br>"+ "[レベル]/[2]%"
                                         + "<br>"+ "[習得レベル:60][持続時間:5分][対象:術者][触媒:結晶体(100)]"+"</html>");
        if (ui.cb_buff[S_GIC].isSelected()) {
            if (ui.cb_buff[W_ADS].isSelected()
                    || ui.cb_buff[K_PRE].isSelected()) {
                ui.cb_buff[S_GIC].setSelected(false);
            } else {
            	hpp += (level/2)*0.01 * hp;
                if (ui.cb_buff[S_GIC].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            }
        }
        //インフィニティ:ブラッド
        ui.cb_buff[F_PID].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "レベル60からレベル3毎に最大HPが+50ずつ増加[最大+650]"
                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PID].isSelected()) {
            if (cls == F) {            	
		if (level >= 89) {
		    hpp += 650;                                                 //最大HP+15(LV89)
        	} else if (level >= 60) {
		    hpp += 50 * ((level - 60) / 3 + 1);                         //HP+50*((level - 60) / 3 + 1)
        	}
            } else {
                ui.cb_buff[F_PID].setSelected(false);
            }
        }

        hp = (int) (hp + eq_hp + hpp);
        mp = (int) (mp + eq_mp + mpp);

        ui.lab_hp.setText(Integer.toString((int) hp));
        ui.lab_mp.setText(Integer.toString((int) mp));

        //獲得経験値
        ui.lab_mexp.setText(Integer.toString((int) mexp));

        //エキゾチックバイタライズ 消費MP30/16mins
        ui.cb_buff[E_EVE].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "重量ゲージが50%を超えてもHPとMPが自然回復する"
                                         + "<br>"+ "[習得レベル:75][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_EVE].isSelected()) {
            if (ui.cb_buff[E_EVE].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
            }
        }
        //アディショナルファイアー 消費MP30/16mins
        ui.cb_buff[E_AFE].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "重量ゲージが50%を超えてもHPとMPが自然回復する"
                                         + "<br>"+ "[習得レベル:75][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_AFE].isSelected()) {
            if (ui.cb_buff[E_AFE].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
            }
        }
        //2018/09/05 Updateでウインドウォークは削除
        //if (ui.cb_buff[E_WW].isSelected()) {
        //    if (ui.cb_buff[E_WW].getForeground().equals(Color.BLUE)) {
        //        cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
        //    }
        //}

        ui.lab_cons_mp.setText(Double.toString((int) (cons_mp * 100) / 100.0));
//        ui.lab_cons_mp.setText(Double.toString((int) (cons_mp * (1.0 - red_mp * 0.01) * 100) / 100.0));
    }

    private int minasToZero(int x) {
        if (x >= 0) {
            return x;
        } else {
            return 0;
        }
    }

    void addRem(int st) {
        if (_rem > 0) {
            if (_ST[REM][st] < st_data[cls][REM][st]) {
                _ST[REM][st]++;
                _rem--;
            }
        }
        ui.lab_rem.setText(Integer.toString(_rem));
    }

    void removeRem(int st) {
        if (_ST[REM][st] > 0) {
            _ST[REM][st]--;
            _rem++;
        }
        ui.lab_rem.setText(Integer.toString(_rem));
    }

    void rem_reset() {
        _rem = rem_data[cls];
        if (ui.lab_rem != null) {
            ui.lab_rem.setText(Integer.toString(_rem));
        }
        for (int i = 0; i < ST_LIST.length; i++) {
            _ST[REM][i] = 0;
            _ST[BASE][i] = st_data[cls][BASE][i];
        }
    }

    double getMagicDamage(String magic_name, String magic_element, double dmg_magic) {
        double cri;
        if (magic_name.equals("マインドブレイク")) {
            return (sp + ml + mb) * 3.8;
        }
        if (magic_name.equals("HP吸収")) {
            // 別途計算
            return 0;
        }
        if (magic_name.equals("ムーンライトイラプション")) {
            return 7;
        }
        if (magic_name.equals("サンバースト") || magic_name.equals("コールライトニング")
                || magic_name.equals("イラプション")
                || magic_name.equals("コーンオブコールド")
                || magic_name.equals("チルタッチ")
                || magic_name.equals("ヴァンパイアリックタッチ")
                || magic_name.equals("ファイアーアロー") || magic_name.equals("アイスダガー")
                || magic_name.equals("ウインドカッター") || magic_name.equals("スラタック")
                || magic_name.equals("エネルギーボルト")) {
            cri = (double) cri_magic / 100;
        } else {
            cri = 0;
        }

        double r_element = 0;
        if (magic_element.equals("火")) {
            r_element = ui.s_target_res[FIRE].getValue();
        }
        if (magic_element.equals("水")) {
            r_element = ui.s_target_res[WATER].getValue();
        }
        if (magic_element.equals("風")) {
            r_element = ui.s_target_res[WIND].getValue();
        }
        if (magic_element.equals("地")) {
            r_element = ui.s_target_res[EARTH].getValue();
        }

        double a = 1 + 3.0 / 32.0 * (int_beta - 12) - r_element / 100.0;
        double b;
        if (magic_name.equals("エルブンアロー")) {
            b = 1.0;
        } else if (ui.s_target_mr.getValue() - hit_magic <= 100) {
            b = 1.0 - 0.01 * ((ui.s_target_mr.getValue() - hit_magic) / 2);
        } else {
            b = 0.6 - 0.01 * ((ui.s_target_mr.getValue() - hit_magic) / 10);
        }
        if (ui.cb_buff[I_IAR].isSelected()) {
            return (dmg_magic * a + base_dmg_magic) * b * (1 - cri)
                    + (dmg_magic * a + base_dmg_magic) * b * cri * 1.5 + 10;
        } else {
            return (dmg_magic * a + base_dmg_magic) * b * (1 - cri)
                    + (dmg_magic * a + base_dmg_magic) * b * cri * 1.5;
        }
    }

    int getST_REM(int ST) {
        return _ST[REM][ST];
    }

    void createToolTip() {

        String buki_text = "";
        if ((buki.enchant + buki.op2.DMG_SHORT + buki.op2.DMG_LONG) == 0) {
            buki_text += "ダメージ" + buki.small + "/" + buki.big;
        }
        if ((buki.enchant + buki.op2.DMG_SHORT + buki.op2.DMG_LONG) > 0) {
            if (buki.op2.DMG_LONG > buki.op2.DMG_SHORT) {  
                buki_text += "ダメージ" + buki.small + "+" + (buki.enchant + buki.op2.DMG_LONG) + "/" + buki.big + "+" + (buki.enchant + buki.op2.DMG_LONG);      
            } else {
                buki_text += "ダメージ" + buki.small + "+" + (buki.enchant + buki.op2.DMG_SHORT) + "/" + buki.big + "+" + (buki.enchant + buki.op2.DMG_SHORT);
        }
        }
        if (buki.two_hands) {
            buki_text += " 両手武器";
        }
        if (buki.op.DMG_SHORT > 0) {
//            buki_text += " 近距離追加ダメージ+" + buki.op.DMG_SHORT;
            buki_text += " 近距離ダメージ+" + buki.op.DMG_SHORT;
            }
        if (buki.op.DMG_LONG < 0) {
//            buki_text += " 近距離追加ダメージ" + buki.op.DMG_LONG;
            buki_text += " 近距離ダメージ" + buki.op.DMG_LONG;
        }
        if (buki.op.HIT_SHORT > 0) {
            buki_text += " 近距離命中+" + (buki.op.HIT_SHORT + buki.op2.HIT_SHORT);
        }
            if (buki.op.HIT_SHORT < 0) {
            buki_text += " 近距離命中" + (buki.op.HIT_SHORT + buki.op2.HIT_SHORT);
        }
        if (buki.op.DMG_LONG > 0) {
//            buki_text += " 遠距離追加ダメージ+" + buki.op.DMG_LONG;
            buki_text += " 遠距離ダメージ+" + buki.op.DMG_LONG;
        }
        if (buki.op.DMG_LONG < 0) {
//            buki_text += " 遠距離追加ダメージ" + buki.op.DMG_LONG;
            buki_text += " 遠距離ダメージ" + buki.op.DMG_LONG;
        }
        if (buki.op.HIT_LONG > 0) {
            buki_text += " 遠距離命中+" + (buki.op.HIT_LONG + buki.op2.HIT_LONG);
        }
        if (buki.op.HIT_LONG < 0) {
            buki_text += " 遠距離命中" + (buki.op.HIT_LONG + buki.op2.HIT_LONG);
        }
        if (buki.op.HIT_MAGIC > 0) {
            buki_text += " 魔法命中+" + (buki.op.HIT_MAGIC + buki.op2.HIT_MAGIC);
        }
        if (buki.op.HIT_MAGIC < 0) {
            buki_text += " 魔法命中" + (buki.op.HIT_MAGIC + buki.op2.HIT_MAGIC);
        }
        if (buki.op.CRI_SHORT + buki.op2.CRI_SHORT > 0) {
            buki_text += " 近距離クリティカル+" + (buki.op.CRI_SHORT + buki.op2.CRI_SHORT);
        }
        if (buki.op.CRI_LONG + buki.op2.CRI_LONG > 0) {
            buki_text += " 遠距離クリティカル+" + (buki.op.CRI_LONG + buki.op2.CRI_LONG);
        }
        if (buki.op.CRI_MAGIC + buki.op2.CRI_MAGIC > 0) {
            buki_text += " 魔法クリティカル+" + (buki.op.CRI_MAGIC + buki.op2.CRI_MAGIC);
        }
        if (buki.op.ailment[HIT_STUN] + buki.op2.ailment[HIT_STUN] > 0) {
            buki_text += " 技術命中+" + (buki.op.ailment[HIT_STUN] + buki.op2.ailment[HIT_STUN]);
        }
        if (buki.op.ailment[HIT_SPIRIT] + buki.op2.ailment[HIT_SPIRIT] > 0) {
            buki_text += " 精霊命中+" + (buki.op.ailment[HIT_SPIRIT] + buki.op2.ailment[HIT_SPIRIT]);
        }
        if (buki.op.ailment[HIT_SECRET] + buki.op2.ailment[HIT_SECRET] > 0) {
            buki_text += " 秘技命中+" + (buki.op.ailment[HIT_SECRET] + buki.op2.ailment[HIT_SECRET]);
        }
        if (buki.op.ailment[HIT_TERROR] + buki.op2.ailment[HIT_TERROR] > 0) {
            buki_text += " 恐怖命中+" + (buki.op.ailment[HIT_TERROR] + buki.op2.ailment[HIT_TERROR]);
        }
        if (buki.op.HP > 0) {
            buki_text += " HP+" + buki.op.HP;
        }
        if (buki.op.HPR > 0) {
            buki_text += " HP自然回復+" + buki.op.HPR;
        }
        if (buki.op.MP > 0) {
            buki_text += " MP+" + buki.op.MP;
        }
        if (buki.op.MPR > 0) {
            buki_text += " MP自然回復+" + buki.op.MPR;
        }
        if (buki.op.ST[STR] > 0) {
            buki_text += " STR+" + buki.op.ST[STR];
        }
        if (buki.op.ST[DEX] > 0) {
            buki_text += " DEX+" + buki.op.ST[DEX];
        }
        if (buki.op.ST[CON] > 0) {
            buki_text += " CON+" + buki.op.ST[CON];
        }
        if (buki.op.ST[INT] > 0) {
            buki_text += " INT+" + buki.op.ST[INT];
        }
        if (buki.op.ST[WIS] > 0) {
            buki_text += " WIS+" + buki.op.ST[WIS];
        }
        if (buki.op.ST[CHA] > 0) {
            buki_text += " CHA+" + buki.op.ST[CHA];
        }
        if (buki.op.MR > 0) {
            buki_text += " MR+" + buki.op.MR;
        }
        if (buki.op.SP > 0) {
            buki_text += " SP+" + (buki.op.SP + buki.op2.SP);
        }
        if (!buki.material.equals("")) {
            buki_text += " 材質:" + buki.material;
        }
        if (buki.op.PVP > 0) {
            buki_text += " PVP追加ダメージ " + (buki.op.PVP + buki.op2.PVP);
        }
        if (buki.op.PVP_DR > 0) {
            buki_text += " PVPダメージ低下 " + (buki.op.PVP_DR + buki.op2.PVP_DR);
        }
        if (buki.op.DR > 0) {
            buki_text += " ダメージ低下 " + (buki.op.DR + buki.op2.DR);
        }
        if (buki.op.DR_IGNORED > 0) {
            buki_text += " ダメージ低下無視 " + (buki.op.DR_IGNORED + buki.op2.DR_IGNORED);
        }
        if (buki.op.WEIGHT > 0) {
            buki_text += " 重さ " + buki.op.WEIGHT;
        }
        if (!buki.op.effect.equals("")) {
            buki_text += " " + buki.op.effect;
        }
        ui.cb_eq[0].setToolTipText(buki_text);

        for (int i = 0; i < bougu.length; i++) {
            ui.cb_eq[i + 2].setToolTipText(bougu[i].getText());
        }

    }

}
