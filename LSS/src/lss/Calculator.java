/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

import java.awt.Color;
import java.text.DecimalFormat;
import static lss.Common.E_SGL;
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
    int dg;                                                                     //近距離回避力
    int er;                                                                     //遠距離回避力
    int me;                                                                     //確率魔法回避力
    int mhp;                                                                    //最大HP+X%
    int mmp;                                                                    //最大MP+X%
    int mexp;                                                                   //獲得経験値+X%
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
        //ランサーの初期ステータスと割り振り可能ステータス数
        st_data[L][BASE][STR] = 14;
        st_data[L][BASE][DEX] = 12;
        st_data[L][BASE][CON] = 16;
        st_data[L][BASE][INT] = 9;
        st_data[L][BASE][WIS] = 12;
        st_data[L][BASE][CHA] = 6;
        st_data[L][REM][STR] = 4;
        st_data[L][REM][DEX] = 4;
        st_data[L][REM][CON] = 4;
        st_data[L][REM][INT] = 4;
        st_data[L][REM][WIS] = 4;
        st_data[L][REM][CHA] = 4;
        rem_data[L] = 6;

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
        _C[D_SHORT][STR][L] = 10;

        _C[H_SHORT][STR][P] = 4;
        _C[H_SHORT][STR][K] = 3;
        _C[H_SHORT][STR][E] = 5;
        _C[H_SHORT][STR][W] = 6;
        _C[H_SHORT][STR][D] = 3;
        _C[H_SHORT][STR][R] = 4;
        _C[H_SHORT][STR][I] = 5;
        _C[H_SHORT][STR][S] = 3;
        _C[H_SHORT][STR][F] = 3;
        _C[H_SHORT][STR][L] = 3;

        _C[C_SHORT][STR][P] = 20;
        _C[C_SHORT][STR][K] = 20;
        _C[C_SHORT][STR][E] = 24;
        _C[C_SHORT][STR][W] = 30;
        _C[C_SHORT][STR][D] = 10;
        _C[C_SHORT][STR][R] = 20;
        _C[C_SHORT][STR][I] = 30;
        _C[C_SHORT][STR][S] = 20;
        _C[C_SHORT][STR][F] = 20;
        _C[C_SHORT][STR][L] = 20;

        _C[D_LONG][DEX][P] = 40;
        _C[D_LONG][DEX][K] = 40;
        _C[D_LONG][DEX][E] = 10;
        _C[D_LONG][DEX][W] = 80;
        _C[D_LONG][DEX][D] = 20;
        _C[D_LONG][DEX][R] = 40;
        _C[D_LONG][DEX][I] = 80;
        _C[D_LONG][DEX][S] = 40;
        _C[D_LONG][DEX][F] = 40;
        _C[D_LONG][DEX][L] = 40;

        _C[H_LONG][DEX][P] = 6;
        _C[H_LONG][DEX][K] = 6;
        _C[H_LONG][DEX][E] = 3;
        _C[H_LONG][DEX][W] = 8;
        _C[H_LONG][DEX][D] = 4;
        _C[H_LONG][DEX][R] = 7;
        _C[H_LONG][DEX][I] = 8;
        _C[H_LONG][DEX][S] = 6;
        _C[H_LONG][DEX][F] = 6;
        _C[H_LONG][DEX][L] = 6;

        _C[C_LONG][DEX][P] = 30;
        _C[C_LONG][DEX][K] = 40;
        _C[C_LONG][DEX][E] = 16;
        _C[C_LONG][DEX][W] = 50;
        _C[C_LONG][DEX][D] = 20;
        _C[C_LONG][DEX][R] = 40;
        _C[C_LONG][DEX][I] = 50;
        _C[C_LONG][DEX][S] = 40;
        _C[C_LONG][DEX][F] = 40;
        _C[C_LONG][DEX][L] = 40;

        _C[ER][DEX][P] = 6;
        _C[ER][DEX][K] = 4;
        _C[ER][DEX][E] = 6;
        _C[ER][DEX][W] = 10;
        _C[ER][DEX][D] = 4;
        _C[ER][DEX][R] = 5;
        _C[ER][DEX][I] = 9;
        _C[ER][DEX][S] = 4;
        _C[ER][DEX][F] = 4;
        _C[ER][DEX][L] = 4;

        _C[D_MAGIC][INT][P] = 40;
        _C[D_MAGIC][INT][K] = 40;
        _C[D_MAGIC][INT][E] = 30;
        _C[D_MAGIC][INT][W] = 10;
        _C[D_MAGIC][INT][D] = 40;
        _C[D_MAGIC][INT][R] = 40;
        _C[D_MAGIC][INT][I] = 25;
        _C[D_MAGIC][INT][S] = 40;
        _C[D_MAGIC][INT][F] = 40;
        _C[D_MAGIC][INT][L] = 40;

        _C[H_MAGIC][INT][P] = 20;
        _C[H_MAGIC][INT][K] = 100;
        _C[H_MAGIC][INT][E] = 16;
        _C[H_MAGIC][INT][W] = 8;
        _C[H_MAGIC][INT][D] = 24;
        _C[H_MAGIC][INT][R] = 18;
        _C[H_MAGIC][INT][I] = 12;
        _C[H_MAGIC][INT][S] = 100;
        _C[H_MAGIC][INT][F] = 100;
        _C[H_MAGIC][INT][L] = 100;

        _C[C_MAGIC][INT][P] = 80;
        _C[C_MAGIC][INT][K] = 100;
        _C[C_MAGIC][INT][E] = 30;
        _C[C_MAGIC][INT][W] = 2;
        _C[C_MAGIC][INT][D] = 30;
        _C[C_MAGIC][INT][R] = 70;
        _C[C_MAGIC][INT][I] = 20;
        _C[C_MAGIC][INT][S] = 100;
        _C[C_MAGIC][INT][F] = 100;
        _C[C_MAGIC][INT][L] = 100;

        _C[MB][INT][P] = 0;
        _C[MB][INT][K] = 0;
        _C[MB][INT][E] = 0;
        _C[MB][INT][W] = 1;
        _C[MB][INT][D] = 0;
        _C[MB][INT][R] = 0;
        _C[MB][INT][I] = 1;
        _C[MB][INT][S] = 0;
        _C[MB][INT][F] = 0;
        _C[MB][INT][L] = 0;

        _C[HP][CON][P] = 11;
        _C[HP][CON][K] = 16;
        _C[HP][CON][E] = 9;
        _C[HP][CON][W] = 6;
        _C[HP][CON][D] = 10;
        _C[HP][CON][R] = 12;
        _C[HP][CON][I] = 8;
        _C[HP][CON][S] = 16;
        _C[HP][CON][F] = 16;
        _C[HP][CON][L] = 16;

        //各職の初期MR修正用
        _C[MR][WIS][P] = 10;
        _C[MR][WIS][K] = 0;
        _C[MR][WIS][E] = 25;
        _C[MR][WIS][W] = 15;
        _C[MR][WIS][D] = 10;
        _C[MR][WIS][R] = 18;
        _C[MR][WIS][I] = 20;
        _C[MR][WIS][S] = 0;
        _C[MR][WIS][F] = 10;
        _C[MR][WIS][L] = 0;
    }

    private final UI ui;
    Morph polymorph = new Morph();
    private double acc = 1.0;
    //1段加速(GP GGP ワイン ウイスキー)
    double acc_1 = 1.3333;
    //2段加速(BP イビルブラッド ブラッドラスト 名誉のコイン ダンシングブレイズ フォーカスウェーブ ハリケーン サンドストーム)
    double acc_2 = 1.3333;
    //2段加速(EW 濃縮集中ポーション ムービングアクセレーション:マキシマム)
    double acc_ew = 1.1547;
    //2段加速(ダークホース)
    double acc_df = 1.0800;
    //3段加速(ドラゴンブラッド 蔵出し秘蔵酒)
    double acc_3 = 1.125;
    //4段加速(マジックドールの潜在力)
    double acc_4 = 1.100;                                                       //暫定速度
    //5段加速(騎士技術(レイジング ウェポン))
    double acc_5 = 1.100;                                                       //暫定速度
    //キー入力ディレイ
    double key_delay = 0.1815;

    double ce_rate = 0.0500;                                                    //サイクロンの確率5%
    double bk_rate = 0.0000;                                                    //ブローアタックの基本確率0%
    double bk_lv_bonus = 0.0000;                                                //ブローアタックのレベルアップボーナス0%
    double bs_rate = 0.3333;                                                    //バーニング スピッツの確率33%
    double db_rate = 0.3333;                                                    //ダブル ブレイクの確率33%
    double db_lv_bonus = 0.0000;                                                //ダブル ブレイクのレベルアップボーナス0%
    double db2_lv_bonus = 0.0000;                                               //ダブル ブレイク:デスティニーのレベルアップボーナス0%
    double ef_rate = 0.4000;                                                    //エレメンタル ファイアーの確率40%
    double qe_rate = 0.4000;                                                    //クエイクの確率40%
    double pb_rate = 0.4000;                                                    //ブレイブ メンタルの確率40%
    double re_rate = 0.1800;                                                    //レイジの確率18%

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

//エリクサーの最大使用数(20個へ)
        for (int i = 0; i < 20; i++) {
            int st = ui.cb_elixir[i].getSelectedIndex() - 1;
            if (st >= 0) {
                if (ui.cb_elixir_level[i].getSelectedIndex() + 1 <= level) {
                    _ST[ELIXIR][st]++;
                }
            }
        }

        //純粋ステータス最大値増加
        for (int i = 0; i < ui.lev.size; i++) {
            int st = ui.lev.field[i];
            if (st >= 0) {
                //LV100以上の最大ステータス60/LV90以上の最大ステータス55/LV90未満の最大ステータス50の処理
                if (level >= 100) {
                    if(_ST[BASE][st] + _ST[REM][st] + _ST[LEVEL][st] + _ST[ELIXIR][st] < 60) {
                        if (i + 51 <= level) {
                            _ST[LEVEL][st]++;
                        }
                        ui.lev.isOverflow[i] = false;
                    } else if (i + 51 <= level) {
                    ui.lev.isOverflow[i] = true;
                    }
                }
                else if (level >= 90) {
                    if(_ST[BASE][st] + _ST[REM][st] + _ST[LEVEL][st] + _ST[ELIXIR][st] < 55) {
                        if (i + 51 <= level) {
                            _ST[LEVEL][st]++;
                        }
                        ui.lev.isOverflow[i] = false;
                    } else if (i + 51 <= level) {
                    ui.lev.isOverflow[i] = true;
                    }
                }
                else{
                    if (_ST[BASE][st] + _ST[REM][st] + _ST[LEVEL][st] + _ST[ELIXIR][st] < 50) {
                        if (i + 51 <= level) {
                            _ST[LEVEL][st]++;
                        }
                        ui.lev.isOverflow[i] = false;
                    } else if (i + 51 <= level) {
                    ui.lev.isOverflow[i] = true;
                    }
                }
            }
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
        int set1 = 0, set2 = 0, set3 = 0;                                       //王家セット
        int set4 = 0, set5 = 0, set6 = 0;                                       //浄化セット
        int set7 = 0, set8 = 0;                                                 //極寒、アイスクイーンセット
        int set9 = 0;                                                           //修練者セット
        int set10 = 0, set11 = 0, set12 = 0;                                    //釣りセット
        int set13 = 0;                                                          //軍王セット
        int set14 = 0;                                                          //DKセット
        int set15 = 0;                                                          //セマオリムセット セマのリング+オリムのアミュレット
        int set16 = 0;                                                          //ボーンセット ボーンヘルム+ボーンアーマー+ボーンシールド
        int set17 = 0;                                                          //アイアンセット アイアンヘルム+アイアンプレートメイル+アイアングローブ+アイアンブーツ+アイアンシールド
        int set18 = 0;                                                          //ウィザードセット ウィザードの帽子+ウィザードの服

        for (Bougu bougu1 : bougu) {
            if (bougu1.name.equals("ウィザードの帽子")
                    || bougu1.name.equals("ウィザードの服")) {
                set18++;
            }

            if (bougu1.name.equals("アイアンヘルム")
                    || bougu1.name.equals("アイアンプレートメイル")
                    || bougu1.name.equals("アイアングローブ")
                    || bougu1.name.equals("アイアンブーツ")
                    || bougu1.name.equals("アイアンシールド")) {
                set17++;
            }

            if (bougu1.name.equals("ボーンヘルム")
                    || bougu1.name.equals("ボーンアーマー")
                    || bougu1.name.equals("ボーンシールド")) {
                set16++;
            }

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
            //下記メソッド実行のたびに追加ボーナスが累積される模様(本来+2個で追加ボーナスが3倍になる)
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

        //ボーンセット AC-5 MR+5 最大HP+50
        if (set16 == 3) {
            buff.AC -= 5;
            buff.MR += 5;
            buff.HP += 50;
        }

        //アイアンセット AC-5 STR+1 MR+10 最大HP+50
        if (set17 == 5) {
            buff.AC -= 5;
            buff.ST[STR] += 1;
            buff.MR += 10;
            buff.HP += 50;
        }

        //ウィザードセット AC-3 MR+8 MPR+8 最大MP+50
        if (set18 == 2) {
            buff.AC -= 3;
            buff.MP += 8;
            buff.MPR += 8;
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
        //LV6 MD
                case 58:                            //ハルパス
                    buff.DMG_SHORT += 10;
                    buff.HIT_SHORT += 10;
                    buff.DR += 8;
                    buff.ailment[HIT_STUN] += 10;
                    buff.ailment[HIT_SPIRIT] += 10;
                    buff.ailment[HIT_SECRET] += 10;
                    buff.ailment[HIT_TERROR] += 10;
                    buff.ailment[STUN] += 10;
                    buff.ailment[SPIRIT] += 10;
                    buff.ailment[HIT_SECRET] += 10;
                    buff.ailment[TERROR] += 10;
                                                    //MP絶対回復+10
                    buff.AC -= 5;
                                                    //EXP+25%
                                                    //祝福消耗効率+10%
                                                    //4段加速
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+10 近距離命中+10 ダメージ減少+8 スキル命中：全体+10 スキル耐性：全体+10 MP絶対回復+10 追加防御力+5 EXP+25% 祝福消耗効率+10% 4段加速");
                    break;
                case 59:                            //アウラキア
                    buff.SP += 7;
                    buff.HIT_MAGIC += 10;
                    buff.DR += 8;
                    buff.ailment[HIT_STUN] += 10;
                    buff.ailment[HIT_SPIRIT] += 10;
                    buff.ailment[HIT_SECRET] += 10;
                    buff.ailment[HIT_TERROR] += 10;
                    buff.ailment[STUN] += 10;
                    buff.ailment[SPIRIT] += 10;
                    buff.ailment[HIT_SECRET] += 10;
                    buff.ailment[TERROR] += 10;
                                                    //MP絶対回復+20
                    buff.HP += 300;
                    buff.AC -= 5;
                                                    //EXP+25%
                                                    //祝福消耗効率+10%
                                                    //4段加速
                    ui.cb_buff[ITEM_MD].setToolTipText("SP+7 魔法命中+10 ダメージ減少+8 スキル命中：全体+10 スキル耐性：全体+10 MP絶対回復+20 最大HP+300 追加防御力+5 EXP+25% 祝福消耗効率+10% 4段加速");
                    break;
                case 60:                            //ベヒモス
                    buff.DMG_LONG += 10;
                    buff.HIT_LONG += 10;
                    buff.DR += 8;
                    buff.ailment[HIT_STUN] += 10;
                    buff.ailment[HIT_SPIRIT] += 10;
                    buff.ailment[HIT_SECRET] += 10;
                    buff.ailment[HIT_TERROR] += 10;
                    buff.ailment[STUN] += 10;
                    buff.ailment[SPIRIT] += 10;
                    buff.ailment[HIT_SECRET] += 10;
                    buff.ailment[TERROR] += 10;
                                                    //MP絶対回復+15
                    buff.HP += 200;
                    buff.MP += 100;
                    buff.AC -= 5;
                                                    //EXP+25%
                                                    //祝福消耗効率+10%
                                                    //4段加速
                    ui.cb_buff[ITEM_MD].setToolTipText("遠距離ダメージ+10 遠距離命中+10 ダメージ減少+8 スキル命中：全体+10 スキル耐性：全体+10 MP絶対回復+15 最大HP+200 最大MP+100 追加防御力+5 EXP+25% 祝福消耗効率+10% 4段加速");
                    break;
//課金MD
                case 61:                            //シーダンサー
                    buff.effect += "HP回復 +40,";
                    ui.cb_buff[ITEM_MD].setToolTipText("HP絶対回復+40(32秒)");
                    break;
                case 62:                            //スパルトイ
                    ui.cb_buff[ITEM_MD].setToolTipText("一定確率(4%)でダメージを無効化");
                    buff.effect += "回避,";
                    break;
                case 63:                            //ラミア
                    buff.MPR += 4;
                    ui.cb_buff[ITEM_MD].setToolTipText("MP自然回復+4 近距離攻撃の時だけ魔法発動:カーズポイズン");
                    break;
                case 64:                            //スノーマン(課金)
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.MPR += 2;
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+2 遠距離ダメージ+2 MP自然回復+2");
                    break;
                case 65:                            //グレムリン
                    buff.HP += 30;
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("HP+30 近距離ダメージ+2 遠距離ダメージ+2 SP+1");
                    break;
                case 66:                            //ブルート
                    buff.r_weight += 0.10;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+250");
                    break;
                case 67:                            //ブルート(努力する)
                    buff.r_weight += 0.12;
                    buff.effect += "HP回復 +15,";
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+300 HP絶対回復+15(64秒)");
                    break;
                case 68:                            //ブルート(賢い)
                    buff.r_weight += 0.14;
                    buff.effect += "HP回復 +15,";
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+350 HP絶対回復+15(64秒)");
                    break;
                case 69:                            //ブルート(聡明な)
                    buff.r_weight += 0.16;
                    buff.effect += "HP回復 +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+400 HP絶対回復+15(64秒) 近距離ダメージ+1");
                    break;
                case 70:                            //ブルート(光る)
                    buff.r_weight += 0.18;
                    buff.effect += "HP回復 +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+450 HP絶対回復+15(64秒) 近距離ダメージ+1");
                    break;
                case 71:                            //ブルート(眩しい)
                    buff.r_weight += 0.20;
                    buff.effect += "HP回復 +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("常時ヘイスト 所持重量増加+500 HP絶対回復+15(64秒) 近距離ダメージ+1");
                    break;
                case 72:                            //ジャイアント
                    buff.r_weight += 0.10;
                    buff.effect += "ダメージ低下 +5,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+5 所持重量増加+250");
                    break;
                case 73:                            //ジャイアント(努力する)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.effect += "ダメージ低下 +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+8 所持重量増加+250 AC-1");
                    break;
                case 74:                            //ジャイアント(賢い)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.effect += "ダメージ低下 +11,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+11 所持重量増加+250 AC-1");
                    break;
                case 75:                            //ジャイアント(聡明な)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ低下 +14,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+14 所持重量増加+250 AC-1 MR+5%");
                    break;
                case 76:                            //ジャイアント(光る)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ低下 +17,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+17 所持重量増加+250 AC-1 MR+5%");
                    break;
                case 77:                            //ジャイアント(眩しい)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ低下 +20,ヴァンパイアリックタッチ,";
                    ui.cb_buff[ITEM_MD].setToolTipText("確率ダメージ低下+20 所持重量増加+250 AC-1 MR+5% 近距離攻撃時に一定確率で魔法発動:バンパイアリックタッチ");
                    break;
                case 78:                            //パック/パオ(0段階)
                    buff.DMG_SHORT += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+1");
                case 79:                            //パック/パオ(1段階)
                    buff.DMG_SHORT += 1;
                    buff.DMG_LONG += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+1 遠距離ダメージ+1");
                    break;
                case 80:                            //パック/パオ(2段階)
                    buff.DMG_SHORT += 1;
                    buff.DMG_LONG += 1;
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("近距離ダメージ+1 遠距離ダメージ+1 SP+1");
                    break;
                case 81:                            //パック/パオ(3段階)
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

//マジックドールの潜在力
        if (ui.cb_buff[ITEM_MD_OP2].isSelected()) {
            switch (ui.cb_buff_group[ITEM_MD_OP2].getSelectedIndex()) {
//一般
                case 0:                                 //近距離クリティカル+1%
                    buff.CRI_SHORT += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離クリティカル+1%");
                    break;
                case 1:                                 //遠距離クリティカル+1%
                    buff.CRI_LONG += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離クリティカル+1%");
                    break;
                case 2:                                 //魔法クリティカル+1%
                    buff.CRI_MAGIC += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("魔法クリティカル+1%");
                    break;
                case 3:                                 //近距離ダメージ+1
                    buff.DMG_SHORT += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離ダメージ+1");
                    break;
                case 4:                                 //遠距離ダメージ+1
                    buff.DMG_LONG += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離ダメージ+1");
                    break;
                case 5:                                 //近距離命中+1
                    buff.HIT_SHORT += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離命中+1");
                    break;
                case 6:                                 //遠距離命中+1
                    buff.HIT_LONG += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離命中+1");
                    break;
                case 7:                                 //ダメージ減少+1
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("ダメージ減少+1");
                    break;
                case 8:                                 //AC-1
                    buff.AC -= 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("AC-1");
                    break;
                case 9:                                 //MR+3%
                    buff.MR += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MR+3%");
                    break;
                case 10:                                //最大HP+30
                    buff.HP += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("最大HP+30");
                    break;
                case 11:                                //最大MP+20
                    buff.MP += 20;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("最大MP+20");
                    break;
                case 12:                                //PVP追加ダメージ+1
                    buff.PVP += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP追加ダメージ+1");
                    break;
                case 13:                                //PVPダメージ減少+1
                    buff.PVP_DR += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVPダメージ減少+1");
                    break;
                case 14:                                //火の属性抵抗+10
                    buff.element_resist[FIRE] += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("火の属性抵抗+10");
                    break;
                case 15:                                //地の属性抵抗+10
                    buff.element_resist[EARTH] += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("地の属性抵抗+10");
                    break;
                case 16:                                //水の属性抵抗+10
                    buff.element_resist[WATER] += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("水の属性抵抗+10");
                    break;
                case 17:                                //風の属性抵抗+10
                    buff.element_resist[WIND] += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("風の属性抵抗+10");
                    break;
                case 18:                                //所持重量増加+100(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("所持重量増加+100(未実装)");
                    break;
//高級
                case 19:                                 //近距離クリティカル+3%
                    buff.CRI_SHORT += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離クリティカル+3%");
                    break;
                case 20:                                //遠距離クリティカル+3%
                    buff.CRI_LONG += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離クリティカル+3%");
                    break;
                case 21:                                //魔法クリティカル+3%
                    buff.CRI_MAGIC += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("魔法クリティカル+3%");
                    break;
                case 22:                                //近距離ダメージ+2
                    buff.DMG_SHORT += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離ダメージ+2");
                    break;
                case 23:                                //遠距離ダメージ+2
                    buff.DMG_LONG += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離ダメージ+2");
                    break;
                case 24:                                //近距離命中+2
                    buff.HIT_SHORT += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離命中+2");
                    break;
                case 25:                                //遠距離命中+2
                    buff.HIT_LONG += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離命中+2");
                    break;
                case 26:                                 //ダメージ減少+2
                    buff.DR += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("ダメージ減少+2");
                    break;
                case 27:                                 //AC-2
                    buff.AC -= 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("AC-2");
                    break;
                case 28:                                 //MR+6%
                    buff.MR += 6;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MR+6%");
                    break;
                case 29:                                //最大HP+60
                    buff.HP += 60;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("最大HP+60");
                    break;
                case 30:                                //最大MP+40
                    buff.MP += 40;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("最大MP+40");
                    break;
                case 31:                                //近距離回避(DG)+3
                    buff.DG += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離回避(DG)+3");
                    break;
                case 32:                                //HP絶対回復+30(32秒)(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("HP絶対回復+30(32秒)(未実装)");
                    break;
                case 33:                                //MP絶対回復+10(64秒)(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MP絶対回復+10(64秒)(未実装)");
                    break;
                case 34:                                //遠距離回避(ER)+3
                    buff.ER += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離回避(ER)+3");
                    break;
                case 35:                                //PVP追加ダメージ+2
                    buff.PVP += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP追加ダメージ+2");
                    break;
                case 36:                                //PVPダメージ減少+2
                    buff.PVP_DR += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVPダメージ減少+2");
                    break;
                case 37:                                //PVP魔法ダメージ減少+2(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP魔法ダメージ減少+2(未実装)");
                    break;
                case 38:                                //技術耐性+3
                    buff.ailment[STUN] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("技術耐性+3");
                    break;
                case 39:                                //精霊耐性+3
                    buff.ailment[SPIRIT] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("精霊耐性+3");
                    break;
                case 40:                                //秘技耐性+3
                    buff.ailment[SECRET] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("秘技耐性+3");
                    break;
                case 41:                                //恐怖耐性+3
                    buff.ailment[TERROR] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("恐怖耐性+3");
                    break;
                case 42:                                //火の属性抵抗+20
                    buff.element_resist[FIRE] += 20;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("火の属性抵抗+20");
                    break;
                case 43:                                //地の属性抵抗+20
                    buff.element_resist[EARTH] += 20;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("地の属性抵抗+20");
                    break;
                case 44:                                //水の属性抵抗+20
                    buff.element_resist[WATER] += 20;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("水の属性抵抗+20");
                    break;
                case 45:                                //風の属性抵抗+20
                    buff.element_resist[WIND] += 20;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("風の属性抵抗+20");
                    break;
                case 46:                                 //STR+1
                    buff.ST[STR] += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("STR+1");
                    break;
                case 47:                                 //DEX+1
                    buff.ST[DEX] += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("DEX+1");
                    break;
                case 48:                                 //CON+1
                    buff.ST[CON] += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("CON+1");
                    break;
                case 49:                                 //WIS+1
                    buff.ST[WIS] += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("WIS+1");
                    break;
                case 50:                                 //INT+1
                    buff.ST[INT] += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("INT+1");
                    break;
                case 51:                                //所持重量増加+200(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("所持重量増加+200(未実装)");
                    break;
//希少
                case 52:                                 //近距離クリティカル+5%
                    buff.CRI_SHORT += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離クリティカル+5%");
                    break;
                case 53:                                //遠距離クリティカル+5%
                    buff.CRI_LONG += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離クリティカル+5%");
                    break;
                case 54:                                //魔法クリティカル+5%
                    buff.CRI_MAGIC += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("魔法クリティカル+5%");
                    break;
                case 55:                                //近距離ダメージ+3
                    buff.DMG_SHORT += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離ダメージ+3");
                    break;
                case 56:                                //遠距離ダメージ+3
                    buff.DMG_LONG += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離ダメージ+3");
                    break;
                case 57:                                //近距離命中+3
                    buff.HIT_SHORT += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離命中+3");
                    break;
                case 58:                                //遠距離命中+3
                    buff.HIT_LONG += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離命中+3");
                    break;
                case 59:                                 //SP+3
                    buff.SP += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("SP+3");
                    break;
                case 60:                                 //魔法命中+3
                    buff.HIT_MAGIC += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("魔法命中+3");
                    break;
                case 61:                                 //ダメージ減少+3
                    buff.DR += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("ダメージ減少+3");
                    break;
                case 62:                                 //AC-3
                    buff.AC -= 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("AC-3");
                    break;
                case 63:                                 //MR+10%
                    buff.MR += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MR+10%");
                    break;
                case 64:                                //最大HP+150
                    buff.HP += 150;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("最大HP+150");
                    break;
                case 65:                                //最大MP+100
                    buff.MP += 100;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("最大MP+100");
                    break;
                case 66:                                //近距離回避(DG)+5
                    buff.DG += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離回避(DG)+5");
                    break;
                case 67:                                //HP絶対回復+50(32秒)(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("HP絶対回復+50(32秒)(未実装)");
                    break;
                case 68:                                //MP絶対回復+12(64秒)(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MP絶対回復+12(64秒)(未実装)");
                    break;
                case 69:                                //遠距離回避(ER)+5
                    buff.ER += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離回避(ER)+5");
                    break;
                case 70:                                //PVP追加ダメージ+3
                    buff.PVP += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP追加ダメージ+3");
                    break;
                case 71:                                //PVPダメージ減少+3
                    buff.PVP_DR += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVPダメージ減少+3");
                    break;
                case 72:                                //PVP魔法ダメージ減少+5(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP魔法ダメージ減少+5(未実装)");
                    break;
                case 73:                                //技術耐性+5
                    buff.ailment[STUN] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("技術耐性+5");
                    break;
                case 74:                                //精霊耐性+5
                    buff.ailment[SPIRIT] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("精霊耐性+5");
                    break;
                case 75:                                //秘技耐性+5
                    buff.ailment[SECRET] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("秘技耐性+5");
                    break;
                case 76:                                //恐怖耐性+5
                    buff.ailment[TERROR] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("恐怖耐性+5");
                    break;
                case 77:                                //技術命中+3
                    buff.ailment[HIT_STUN] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("技術命中+3");
                    break;
                case 78:                                //精霊命中+3
                    buff.ailment[HIT_SPIRIT] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("精霊命中+3");
                    break;
                case 79:                                //秘技命中+3
                    buff.ailment[HIT_SECRET] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("秘技命中+3");
                    break;
                case 80:                                //恐怖命中+3
                    buff.ailment[HIT_TERROR] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("恐怖命中+3");
                    break;
                case 81:                                //火の属性抵抗+30
                    buff.element_resist[FIRE] += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("火の属性抵抗+30");
                    break;
                case 82:                                //地の属性抵抗+30
                    buff.element_resist[EARTH] += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("地の属性抵抗+30");
                    break;
                case 83:                                //水の属性抵抗+30
                    buff.element_resist[WATER] += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("水の属性抵抗+30");
                    break;
                case 84:                                //風の属性抵抗+30
                    buff.element_resist[WIND] += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("風の属性抵抗+30");
                    break;
                case 85:                                 //STR+2
                    buff.ST[STR] += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("STR+2");
                    break;
                case 86:                                 //DEX+2
                    buff.ST[DEX] += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("DEX+2");
                    break;
                case 87:                                 //CON+2
                    buff.ST[CON] += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("CON+2");
                    break;
                case 88:                                 //WIS+2
                    buff.ST[WIS] += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("WIS+2");
                    break;
                case 89:                                 //INT+2
                    buff.ST[INT] += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("INT+2");
                    break;
                case 90:                                //所持重量増加+300(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("所持重量増加+300(未実装)");
                    break;
                case 91:                                //1段加速(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("1段加速(未実装)");
                    break;
//英雄
                case 92:                                //近距離ダメージ+5
                    buff.DMG_SHORT += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離ダメージ+5");
                    break;
                case 93:                                //遠距離ダメージ+5
                    buff.DMG_LONG += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離ダメージ+5");
                    break;
                case 94:                                //近距離命中+5
                    buff.HIT_SHORT += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離命中+5");
                    break;
                case 95:                                //遠距離命中+5
                    buff.HIT_LONG += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離命中+5");
                    break;
                case 96:                                 //SP+5
                    buff.SP += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("SP+5");
                    break;
                case 97:                                 //魔法命中+5
                    buff.HIT_MAGIC += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("魔法命中+5");
                    break;
                case 98:                                 //ダメージ減少+5
                    buff.DR += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("ダメージ減少+5");
                    break;
                case 99:                                 //AC-5
                    buff.AC -= 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("AC-5");
                    break;
                case 100:                                 //MR+15%
                    buff.MR += 15;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MR+15%");
                    break;
                case 101:                                //最大HP+300
                    buff.HP += 300;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("最大HP+300");
                    break;
                case 102:                                //最大MP+200
                    buff.MP += 200;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("最大MP+200");
                    break;
                case 103:                                //近距離回避(DG)+10
                    buff.DG += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("近距離回避(DG)+10");
                    break;
                case 104:                                //HP絶対回復+150(32秒)(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("HP絶対回復+150(32秒)(未実装)");
                    break;
                case 105:                                //MP絶対回復+30(64秒)(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MP絶対回復+30(64秒)(未実装)");
                    break;
                case 106:                                //遠距離回避(ER)+12
                    buff.ER += 12;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("遠距離回避(ER)+12");
                    break;
                case 107:                                //PVP追加ダメージ+7
                    buff.PVP += 7;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP追加ダメージ+7");
                    break;
                case 108:                                //PVPダメージ減少+7
                    buff.PVP_DR += 7;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVPダメージ減少+7");
                    break;
                case 109:                                //PVP魔法ダメージ減少+10(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP魔法ダメージ減少+10(未実装)");
                    break;
                case 110:                                //PVPダメージ減少無視+10(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVPダメージ減少無視+10(未実装)");
                    break;
                case 111:                                //技術耐性+8
                    buff.ailment[STUN] += 8;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("技術耐性+8");
                    break;
                case 112:                                //精霊耐性+8
                    buff.ailment[SPIRIT] += 8;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("精霊耐性+8");
                    break;
                case 113:                                //秘技耐性+8
                    buff.ailment[SECRET] += 8;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("秘技耐性+8");
                    break;
                case 114:                                //恐怖耐性+8
                    buff.ailment[TERROR] += 8;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("恐怖耐性+8");
                    break;
                case 115:                                //全ての耐性+3
                    buff.ailment[STUN] += 3;
                    buff.ailment[SPIRIT] += 3;
                    buff.ailment[SECRET] += 3;
                    buff.ailment[TERROR] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("全ての耐性+3");
                    break;
                case 116:                                //技術命中+5
                    buff.ailment[HIT_STUN] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("技術命中+5");
                    break;
                case 117:                                //精霊命中+5
                    buff.ailment[HIT_SPIRIT] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("精霊命中+5");
                    break;
                case 118:                                //秘技命中+5
                    buff.ailment[HIT_SECRET] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("秘技命中+5");
                    break;
                case 119:                                //恐怖命中+5
                    buff.ailment[HIT_TERROR] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("恐怖命中+5");
                    break;
                case 120:                                //すべてのスキル命中+3
                    buff.ailment[HIT_STUN] += 3;
                    buff.ailment[HIT_SPIRIT] += 3;
                    buff.ailment[HIT_SECRET] += 3;
                    buff.ailment[HIT_TERROR] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("すべてのスキル命中+3");
                    break;
                case 121:                                //すべての属性抵抗+30
                    buff.element_resist[FIRE] += 30;
                    buff.element_resist[EARTH] += 30;
                    buff.element_resist[WATER] += 30;
                    buff.element_resist[WIND] += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("すべての属性抵抗+30");
                    break;
                case 122:                                 //STR+3
                    buff.ST[STR] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("STR+3");
                    break;
                case 123:                                 //DEX+3
                    buff.ST[DEX] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("DEX+3");
                    break;
                case 124:                                 //CON+3
                    buff.ST[CON] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("CON+3");
                    break;
                case 125:                                 //WIS+3
                    buff.ST[WIS] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("WIS+3");
                    break;
                case 126:                                 //INT+3
                    buff.ST[INT] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("INT+3");
                    break;
                case 127:                                 //すべてのステータス+1(CHA以外)
                    buff.ST[STR] += 1;
                    buff.ST[DEX] += 1;
                    buff.ST[CON] += 1;
                    buff.ST[WIS] += 1;
                    buff.ST[INT] += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("すべてのステータス+1(CHA以外)");
                    break;
                case 128:                                 //MP吸収(少量)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MP吸収(少量)");
                    break;
                case 129:                                //所持重量増加+500(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("所持重量増加+500(未実装)");
                    break;
//伝説
                case 130:                                //PVPダメージ減少無視+40(未実装)
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVPダメージ減少無視+40(未実装)");
                    break;
                case 131:                                //イミューン効果減少-30%(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("イミューン効果減少-30%(未実装)");
                    break;
                case 132:                                 //すべてのステータス+3(CHA以外)
                    buff.ST[STR] += 3;
                    buff.ST[DEX] += 3;
                    buff.ST[CON] += 3;
                    buff.ST[WIS] += 3;
                    buff.ST[INT] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("すべてのステータス+3(CHA以外)");
                    break;
                case 133:                                //HP吸収(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("HP吸収(未実装)");
                    break;
                case 134:                                //MP吸収(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MP吸収(未実装)");
                    break;
                case 135:                                //ソウル オブ フレイム(マジックドール)発動(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("ソウル オブ フレイム(マジックドール)発動(未実装)");
                    break;
                case 136:                                //ジャッジメント(マジックドール)発動(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("ジャッジメント(マジックドール)発動(未実装)");
                    break;
                case 137:                                //ディケイポーション(マジックドール)発動(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("ディケイポーション(マジックドール)発動(未実装)");
                    break;
                case 138:                                //4段階加速(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("4段階加速(未実装)");
                    break;
                case 139:                                //1段階/3段階加速(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("1段階/3段階加速(未実装)");
                    break;
                case 140:                                //所持重量増加+500(未実装)
                    //未実装
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("所持重量増加+500(未実装)");
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "水属性抵抗+10 地属性抵抗+10 風属性抵抗+10 火属性抵抗+10"
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
                    buff.DR += 5;
                    buff.MEXP += 10;                    //獲得経験値+10%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+5 獲得経験値+10% 15分20秒");
                    break;
                case 4:                                 //小粋な携帯飲料
                    buff.DR += 5;
                    buff.MEXP += 5;                     //獲得経験値+5%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+5 獲得経験値+5% 15分20秒");
                    break;
                case 5:                                 //真心がこもったスープ
                    buff.DR += 5;
                    buff.MEXP += 5;                     //獲得経験値+5%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("ダメージ低下+5 獲得経験値+5% 15分20秒");
                    break;
                case 6:                                 //パタラシのキノコスープ
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

//ウィザードの魔法
        //インビジビリティ
        ui.cb_buff[W_INY].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "術者に透明効果が適用される"
                                         + "<br>"+ "移動と補助魔法以外の行動をすると、効果が切れる"
                                         + "<br>"+ "クールタイム:4秒"
                                         + "<br>"+ "帰還不可能の状態では詠唱不可能"
                                         + "<br>"+ "[習得レベル:64][持続時間:解除されるまで][対象:術者][触媒:魔力の石(1]"+"</html>");
        if (ui.cb_buff[W_INY].isSelected()) {
        //スキル効果未実装
        }
        
        //イミューントゥハーム:セイント
        ui.cb_buff[W_IHS].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "自分に使用した時、イミューントゥハームの持続時間を60秒にする"
                                         + "<br>"+ "レベル82から、レベル2毎にPvPダメージ低下+1%増加"
                                         + "<br>"+ "レベル91から、レベル1毎にPvPダメージ低下+1%増加(最大+10%)"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[W_IHS].isSelected()) {
        //スキル効果未実装
        }

        //エタニティ
        ui.cb_buff[W_ETY].setToolTipText("<html>"+ "[消費MP:80][消費HP:--]"
                                         + "<br>"+ "10セル内の対象に、強力なダメージと追加魔法ダメージ"
                                         + "<br>"+ "更に一定確率で[帰還不可能]にする"
                                         + "<br>"+ "最初のダメージは、カウンターマジックで防ぐことが出来ない"
                                         + "<br>"+ "7セルから、帰還不可能の効果は距離が離れるほど成功確率が低下する)"
                                         + "<br>"+ "[習得レベル:85][持続時間:最大4秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[W_ETY].isSelected()) {
        //スキル効果未実装
        }

        //メディテーション:ビヨンド
        ui.cb_buff[W_MBD].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "メディテーションの効果が移動と戦闘時でも持続する"
                                         + "<br>"+ "*WIZリブート MP回復ポーション使用時には最大MPの2%追加回復"
                                         + "<br>"+ "[習得レベル:85][持続時間:--][対象:術者]"+"</html>");
        if (ui.cb_buff[W_MBD].isSelected()) {
        //スキル効果未実装
        }

        //マス イミューン トゥ ハーム
        ui.cb_buff[W_MIT].setToolTipText("<html>"+ "[消費MP:120][消費HP:--]"
                                         + "<br>"+ "8セル内に居るPTの血盟員に、イミューントゥハームの効果"
                                         + "<br>"+ "術者と血盟員の間に障害物があると効果が無い"
                                         + "<br>"+ "イミューントゥハーム：セイントを習得していると術者はセイント、血盟員は通常の効果"
                                         + "<br>"+ "*弱体化 15セルから8セルに"
                                         + "<br>"+ "[習得レベル:85][持続時間:最大32秒][対象:血盟員][触媒:魔力の石(8)]"+"</html>");
        if (ui.cb_buff[W_MIT].isSelected()) {
        //スキル効果未実装
        }

//騎士の技術
        //*フォーススタン
        ui.cb_buff[K_FSN].setToolTipText("<html>"+ "[消費MP:17][消費HP:--]"
                                         + "<br>"+ "1セル内の対象にダメージを与え、一定確率でスタン状態にする"
                                         + "<br>"+ "更に一定確率で持続時間が長い、強化スタンが発動する"
                                         + "<br>"+ "攻撃が命中したかどうかは関係なく効果が発動する"
                                         + "<br>"+ "フォーススタンのダメージは、STRと武器ダメージの影響を受けます"
                                         + "<br>"+ "[習得レベル:85][持続時間:最大7秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[K_FSN].isSelected()) {
        //スキル効果未実装
        }

        //*アブソルートブレイド
        ui.cb_buff[K_ABE].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "攻撃をした時に、一定確率でアブソルートバリアを破壊して強制的に解除する"
                                         + "<br>"+ "レベル80から、レベル1毎に発動率+1%(最大+8%)"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:85][持続時間:32秒][対象:術者]"+"</html>");
        if (ui.cb_buff[K_ABE].isSelected()) {
        //スキル効果未実装
        }

        //*カウンターバリア 消費MP15/2mins
        ui.cb_buff[K_CBR].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "両手剣装備時 一定確率(20%)で近距離攻撃回避+反撃"
                                         + "<br>"+ "カウンターダメージは武器の([BIG打撃値]+[追加ダメージ]+[強化数])x[2]"
                                         + "<br>"+ "[習得レベル:80][持続時間:2分8秒][対象:術者][触媒:結晶体(100)]"+"</html>");
        if (ui.cb_buff[K_CBR].isSelected()) {
            if (level >= 80 && cls == K && buki.type.equals("両手剣")) {
            // CB効果未実装
            } else {
                ui.cb_buff[K_CBR].setSelected(false);
                ui.cb_buff[K_CBV].setSelected(false);
            }
        }

        //ブローアタック
        //8210行にて処理

        //バウンスアタック
        ui.cb_buff[K_BOK].setToolTipText("<html>"+ "[消費MP:10][消費HP:60]"
                                         + "<br>"+ "近距離命中+6"
                                         + "<br>"+ "[習得レベル:65][持続時間:1分4秒][対象:術者]"+"</html>");
        if (ui.cb_buff[K_BOK].isSelected()) {
            if (level >= 60 && cls == K) {
                buff.HIT_SHORT += 6;
            } else {
                ui.cb_buff[K_BOK].setSelected(false);
            }
        }

        //*ショックスタン
        ui.cb_buff[K_SSN].setToolTipText("<html>"+ "[消費MP:13][消費HP:--]"
                                         + "<br>"+ "1セル内の対象にダメージを与え、一定確率でスタン状態にする"
                                         + "<br>"+ "攻撃が命中したかどうかは関係なく効果が発動する"
                                         + "<br>"+ "[習得レベル:60][持続時間:最大6秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[K_SSN].isSelected()) {
        //スキル効果未実装
        }

        //リダクションアーマー
        ui.cb_buff[K_RAR].setToolTipText("<html>"+ "[消費MP:7][消費HP:50]"
                                         + "<br>"+ "ダメージ低下+1"
                                         + "<br>"+ "レベル50からレベル5毎にダメージ低下+1"
                                         + "<br>"+ "[習得レベル:50][持続時間:5分][対象:術者]"+"</html>");
        if (ui.cb_buff[K_RAR].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.DR += (level - 50) / 5 + 1;
            } else {
                ui.cb_buff[K_RAR].setSelected(false);
            }
        }

        //*カウンターバリア:ベテラン
        ui.cb_buff[K_CBV].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "カウンターバリアの発動率を上げる"
                                         + "<br>"+ "85レベルから1レベル毎に発動確率1%増加"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[K_CBV].isSelected()) {
            if (level >= 85 && cls == K && buki.type.equals("両手剣")) {
                ui.cb_buff[K_CBR].setSelected(true);
                //スキル効果未実装
            } else {
                ui.cb_buff[K_CBR].setSelected(false);
                ui.cb_buff[K_CBV].setSelected(false);
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

        //プライド
        //7216行にて処理

        //ソリッドキャリッジ
        ui.cb_buff[K_SCE].setToolTipText("<html>"+ "[消費MP:10][消費HP:100]"
                                         + "<br>"+ "盾装備時 ER+15"
                                         + "<br>"+ "[習得レベル:55][持続時間:3分12秒][対象:術者]"+"</html>");
        if (ui.cb_buff[K_SCE].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.ER += 15;
            } else {
                ui.cb_buff[K_SCE].setSelected(false);
            }
        }

        //*ショックアタック
        ui.cb_buff[K_SAK].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "3セル内の対象に強力な物理的なダメージと移動速度減少"
                                         + "<br>"+ "移動速度減少時スタン成功確率増加+確率的に帰還不可効果"
                                         + "<br>"+ "個別クールタイム"
                                         + "<br>"+ "[習得レベル:85][持続時間:最大4秒][対象:PC/NPC][触媒:結晶体(25)]"+"</html>");
        if (ui.cb_buff[K_SAK].isSelected()) {
        //スキル効果未実装
        }

        //*レイジングウェポン
        ui.cb_buff[K_RWN].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "両手剣攻撃速度10%向上"
                                         + "<br>"+ "[習得レベル:88][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[K_RWN].isSelected()) {
        //スキル効果未実装
        }

        //*カウンターバリア:マスター
        ui.cb_buff[K_CBM].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "カウンターバリアー発動時のHPの一定量回復"
                                         + "<br>"+ "カウンターバリアー発動を無力化するスキルの発動率を減少"
                                         + "<br>"+ "[習得レベル:86][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[K_CBM].isSelected()) {
        //スキル効果未実装
        }

//精霊魔法
        //グローリーアース
        ui.cb_buff[E_GEH].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "2つの属性系列を使用可能にする"
                                         + "<br>"+ "属性系列に関係する魔法は同時に効果を得る サモンはランダムで召喚される"
                                         + "<br>"+ "PVPダメージ低下+30[発動率5%]"
                                         + "<br>"+ "トリプルアローのエフェクトが特別仕様になります"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[E_GEH].isSelected()) {
        //スキル効果未実装
        }

        //リベレーション
        ui.cb_buff[E_LIN].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "状態異常スキルの時間を減少させる"
                                         + "<br>"+ "[習得レベル:85][持続時間:320秒][対象:術者][触媒:精霊の玉(4)]"+"</html>");
        if (ui.cb_buff[E_LIN].isSelected()) {
        //スキル効果未実装
        }

        //エルヴンストライク
        ui.cb_buff[E_ESE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "6セル内の対象にダメージを与え、一定確率でホールド状態にする"
                                         + "<br>"+ "個別クールタイム(60秒)"
                                         + "<br>"+ "[習得レベル:85][持続時間:5秒以下][対象:PC/NPC][触媒:精霊の玉(1)]"+"</html>");
        if (ui.cb_buff[E_ESE].isSelected()) {
        //スキル効果未実装
        }

        //バーニングショット
        ui.cb_buff[E_BST].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "ダメージを20%増加する 全スキル耐性+3 PvPダメージ低下+10"
                                         + "<br>"+ "スキル使用中の時、術者は[移動不可能][帰還不可能][弓の射程距離減少]"
                                         + "<br>"+ "[習得レベル:90][持続時間:??秒][対象:術者][触媒:精霊の玉(2)]"+"</html>");
        if (ui.cb_buff[E_BST].isSelected()) {
        //スキル効果未実装
        }

        //ソウルバリア:アーマー
        ui.cb_buff[E_SBA].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "ソウルバリアが発動した時に[ダメージ低下+2][PvPダメージ低下+2]の効果を追加"
                                         + "<br>"+ "レベル90から、レベル2毎に効果が2ずつ増加(最大+10)"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[E_SBA].isSelected()) {
        //スキル効果未実装
        }

        //ストライカーゲイル:ショット
        ui.cb_buff[E_SGS].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "ストライカーゲイルに[移動不可能(4秒)][ヒール回復量低下]の効果を追加"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[E_SGS].isSelected()) {
        //スキル効果未実装
        }

        //マジックシールド
        ui.cb_buff[E_MSD].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "一般的なデバフを防ぎ一定確率で効果が消える(伝説級/レア級は不可能)"
                                         + "<br>"+ "個別クールタイム(60秒)"
                                         + "<br>"+ "[習得レベル:85][持続時間:12秒][対象:術者][触媒:精霊の玉(5)]"+"</html>");
        if (ui.cb_buff[E_MSD].isSelected()) {
        //スキル効果未実装
        }

        //ソウルバリア
        ui.cb_buff[E_SBR].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "HPが10以下になると、受けたダメージだけMPを消費して耐える"
                                         + "<br>"+ "発動した後にHPが11以上になるかMPが0になると効果が強制的に消える"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:80][持続時間:10分][対象:術者][触媒:精霊の玉(2)]"+"</html>");
        if (ui.cb_buff[E_SBR].isSelected()) {
        //スキル効果未実装
        }

        //エリアサイレンス
        ui.cb_buff[E_ASE].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                         + "<br>"+ "範囲3セル内の対象を、一定確率で沈黙状態にする"
                                         + "<br>"+ "[習得レベル:75][持続時間:16秒][対象:PC/NPC][触媒:精霊の玉(8)]"+"</html>");
        if (ui.cb_buff[E_ASE].isSelected()) {
        //スキル効果未実装
        }

        //エルヴングラヴィティー
        //7360行にて処理

        //グレーターエレメンタル
        ui.cb_buff[E_GEL].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "選択している系列の大精霊を召喚する"
                                         + "<br>"+ "[習得レベル:75][持続時間:1時間][対象:--][触媒:精霊の玉(4)]"+"</html>");
        if (ui.cb_buff[E_GEL].isSelected()) {
        //スキル効果未実装
        }

        //イレースマジック
        ui.cb_buff[E_EMC].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "6セル内の対象を、一定確率で素のMRを2分の1にする"
                                         + "<br>"+ "魔法攻撃を受けると効果は消える"
                                         + "<br>"+ "[習得レベル:60][持続時間:32秒][対象:PC/NPC][触媒:精霊の玉(1)]"+"</html>");
        if (ui.cb_buff[E_EMC].isSelected()) {
        //スキル効果未実装
        }

        //エレメンタルフォールダウン
        ui.cb_buff[E_EFN].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "10セル内の対象を、一定確率で選択している系列の属性抵抗-50"
                                         + "<br>"+ "[習得レベル:60][持続時間:1分4秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[E_EFN].isSelected()) {
        //スキル効果未実装
        }

        //サモンレッサーエレメンタル
        ui.cb_buff[E_SLE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "選択している系列の精霊を召喚する"
                                         + "<br>"+ "[習得レベル:60][持続時間:1時間][対象:--][触媒:精霊の玉(2)]"+"</html>");
        if (ui.cb_buff[E_SLE].isSelected()) {
        //スキル効果未実装
        }


        //トリプルアロー
        ui.cb_buff[E_TAW].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "10セル内の対象に3連続攻撃をする"
                                         + "<br>"+ "両手弓を装備すると12セル"
                                         + "<br>"+ "[習得レベル:45][持続時間:瞬間][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[E_TAW].isSelected()) {
        //スキル効果未実装
        }

        //ブラッディソウル
        ui.cb_buff[E_BSL].setToolTipText("<html>"+ "[消費MP:--][消費HP:25]"
                                         + "<br>"+ "MPを15回復する"
                                         + "<br>"+ "ON/OFFの設定が可能 ONにすると5秒間隔で自動詠唱する"
                                         + "<br>"+ "[習得レベル:45][持続時間:瞬間][対象:術者]"+"</html>");
        if (ui.cb_buff[E_BSL].isSelected()) {
        //スキル効果未実装
        }

        //エレメンタルプロテクション
        ui.cb_buff[E_EPN].setToolTipText("<html>"+ "[消費MP:6][消費HP:--]"
                                         + "<br>"+ "選択している系列の属性抵抗50"
                                         + "<br>"+ "グローリーアース取得時の2属性は不明"
                                         + "<br>"+ "[習得レベル:45][持続時間:1分4秒][対象:術者]"+"</html>");

        if (ui.cb_buff[E_EPN].isSelected()) {
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
        }

        //レジストエレメント
        ui.cb_buff[E_RET].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "レジストマジックに下記の効果を追加"
                                         + "<br>"+ "MR+5 全属性抵抗+5"
                                         + "<br>"+ "[習得レベル:30][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[E_RET].isSelected()) {
            buff.MR += 5;
            buff.element_resist[FIRE] += 5;
            buff.element_resist[WATER] += 5;
            buff.element_resist[WIND] += 5;
            buff.element_resist[EARTH] += 5;
        }

        //クリアーマインド
        ui.cb_buff[E_CMD].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "STR+1 DEX+1 INT+1"
                                         + "<br>"+ "[習得レベル:30][持続時間:20分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_CMD].isSelected()) {
            buff.ST[STR] += 1;
            buff.ST[DEX] += 1;
            buff.ST[INT] += 1;
        }

        //テレポートトゥマザー
        ui.cb_buff[E_TTM].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "マザーツリーにテレポートする"
                                         + "<br>"+ "テレポート禁止区域では詠唱不可能"
                                         + "<br>"+ "[習得レベル:15][持続時間:瞬間][対象:術者]"+"</html>");
        if (ui.cb_buff[E_TTM].isSelected()) {
        //スキル効果未実装
        }

        //ボディトゥマインド
        ui.cb_buff[E_BTM].setToolTipText("<html>"+ "[消費MP:--][消費HP:8]"
                                         + "<br>"+ "MPを2回復する"
                                         + "<br>"+ "[習得レベル:15][持続時間:瞬間][対象:術者]"+"</html>");
        if (ui.cb_buff[E_BTM].isSelected()) {
        //スキル効果未実装
        }

        //レジストマジック
        ui.cb_buff[E_RMC].setToolTipText("<html>"+ "[消費MP:5][消費HP:--]"
                                         + "<br>"+ "MR+10"
                                         + "<br>"+ "[習得レベル:15][持続時間:20分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_RMC].isSelected()) {
            buff.MR += 10;
        }

        //リターントゥネイチャー
        ui.cb_buff[E_RTN].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "魔法的な手段で召喚、またはテイムされたモンスターの召喚を解除する"
                                         + "<br>"+ "現在は凍結されていて使用できない"
                                         + "<br>"+ "[習得レベル:45][持続時間:瞬間][対象:術者][触媒:精霊の玉(2)]"+"</html>");
        if (ui.cb_buff[E_RTN].isSelected()) {
        //スキル効果未実装
        }

//精霊魔法(火)
        //インフェルノ
        ui.cb_buff[E_INO].setToolTipText("<html>"+ "[消費MP:50][消費HP:70]"
                                         + "<br>"+ "ソード専用スキル"
                                         + "<br>"+ "一定確率(不明)で近距離ダメージを50%軽減しカウンター攻撃"
                                         + "<br>"+ "カウンターダメージは武器の[SMALL打撃値]+[追加ダメージ]+[強化数]x[1~4(ランダム)]"
                                         + "<br>"+ "[習得レベル:80][持続時間:2分8秒][対象:術者][触媒:精霊の玉(5)]"+"</html>");
        if (ui.cb_buff[E_INO].isSelected()) {
            if (level >= 80 && cls == E && buki.type.equals("片手剣")) {
                // インフェルノ効果未実装
            } else {
                ui.cb_buff[E_INO].setSelected(false);
            }
        }

        //ソウルオブフレイム
        //5828行にて処理

        //アディショナルファイアー
        ui.cb_buff[E_AFE].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "重量ゲージが50%を超えてもHPとMPが自然回復する"
                                         + "<br>"+ "[習得レベル:75][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_AFE].isSelected()) {
        //スキル効果未実装
        }

        //エレメンタルファイヤー
        //6241行にて処理

        //バーニングウエポン
        ui.cb_buff[E_BWN].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "火属性の近距離ダメージ+6 近距離命中+6"
                                         + "<br>"+ "[習得レベル:75][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_BWN].isSelected()) {
                buff.ELEM_DMG_SHORT[FIRE] += 6;
                buff.HIT_SHORT += 6;
        }

        //ダンシングブレイズ
        ui.cb_buff[E_DBE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "ダガー/ソード専用スキル"
                                         + "<br>"+ "移動速度と攻撃速度が上昇する[2段加速]x1.3333"
                                         + "<br>"+ "[習得レベル:60][持続時間:8分][対象:術者][触媒:エルブンワッフル(1)]"+"</html>");
        //if (ui.cb_buff[E_DBE].isSelected()) {
        //[2段加速]をONにする
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.3333"を選択する
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.3333");
        //}

        //ファイアーシールド
        ui.cb_buff[E_FSD].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "AC-4"
                                         + "<br>"+ "シールドの上位魔法"
                                         + "<br>"+ "[習得レベル:45][持続時間:16分][対象:術者]"+"</html>");
        //不具合の為、コメントアウトにて修正
        //if (ui.cb_buff[E_FSD].isSelected()) {
        //[AC]をONにする
        //ui.cb_buff[B_AC].setSelected(true);
        //"AC-4"を選択する
        //ui.cb_buff_group[B_AC].setSelectedItem("-4");
        //}

//精霊魔法(水) 
        //ポルートウォーター
        ui.cb_buff[E_PWR].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "5セル内の対象に、一定確率でヒール/ポーションの回復効果を半減"
                                         + "<br>"+ "[習得レベル:80][持続時間:32秒][対象:PC/NPC][触媒:精霊の玉(1)]"+"</html>");
        if (ui.cb_buff[E_PWR].isSelected()) {
        //スキル効果未実装
        }

        //ネイチャーズブレッシング
        ui.cb_buff[E_NBG].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーのHPを回復する"
                                         + "<br>"+ "術者とPTメンバーの間に障害物があると効果が無い"
                                         + "<br>"+ "[習得レベル:75][持続時間:瞬間][対象:PT][触媒:精霊の玉(1)]"+"</html>");
        if (ui.cb_buff[E_NBG].isSelected()) {
        //スキル効果未実装
        }

        //フォーカスウェーブ
        ui.cb_buff[E_FWE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "弓専用スキル"
                                         + "<br>"+ "移動速度と攻撃速度が上昇する[2段加速]x1.3333"
                                         + "<br>"+ "[習得レベル:60][持続時間:8分][対象:術者][触媒:エルブンワッフル(1)]"+"</html>");
        //if (ui.cb_buff[E_FWE].isSelected()) {
        //[2段加速]をONにする
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.1547"を選択する
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.1547");
        //}

        //アクアプロテクター
        ui.cb_buff[E_APR].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "8セル内のプレイヤーに、遠距離回避(ER)+5"
                                         + "<br>"+ "[習得レベル:60][持続時間:16分][対象:術者/PC]"+"</html>");
        if (ui.cb_buff[E_APR].isSelected()) {
            if (ui.cb_buff[D_DEN].isSelected()) {
                ui.cb_buff[E_APR].setSelected(false);
            } else {
                buff.ER += 5;
            }
        }

        //ネイチャーズタッチ
        ui.cb_buff[E_NTH].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "攻撃を受けた時に一定確率でHPが回復する"
                                         + "<br>"+ "他のHPが回復する加護の効果と重複します"
                                         + "<br>"+ "[習得レベル:60][持続時間:5分20秒][対象:術者]"+"</html>");
        if (ui.cb_buff[E_NTH].isSelected()) {
            if (level > 9) {
                if (level < 24) {
                    buff.HPR += level - 9;
                } else {
                    buff.HPR += 15;
                }
            }
        }

        //ウォーターライフ
        ui.cb_buff[E_WLE].setToolTipText("<html>"+ "[消費MP:1][消費HP:--]"
                                         + "<br>"+ "15セル内のプレイヤーに、1回だけ回復魔法の効果を2倍にする"
                                         + "<br>"+ "生存の叫び、一部アーマーの加護にも効果が適用される"
                                         + "<br>"+ "[習得レベル:45][持続時間:1分4秒][対象:PC][触媒:精霊の玉(1)]"+"</html>");
        if (ui.cb_buff[E_WLE].isSelected()) {
        //スキル効果未実装
        }

        //アクアショット
        ui.cb_buff[E_AST].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "遠距離命中+4"
                                         + "<br>"+ "[習得レベル:45][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_AST].isSelected()) {
            buff.HIT_LONG += 4;
        } 

//精霊魔法(風)
        //ストライカーゲイル
        ui.cb_buff[E_SGL].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "6セル内の対象を、一定確率で遠距離回避[ER]を3分の1にする"
                                         + "<br>"+ "[習得レベル:80][持続時間:12秒][対象:PC/NPC][触媒:精霊の玉(2)]"+"</html>");
        if (ui.cb_buff[E_SGL].isSelected()) {
        //スキル効果未実装
        }

        //ハリケーン
        ui.cb_buff[E_HUE].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "弓専用スキル"
                                         + "<br>"+ "移動速度と攻撃速度が上昇する[2段加速]x1.3333"
                                         + "<br>"+ "[習得レベル:75][持続時間:8分][対象:術者][触媒:エルブンワッフル(1)]"+"</html>");
        //if (ui.cb_buff[E_HUE].isSelected()) {
        //[2段加速]をONにする
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.3333"を選択する
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.3333");
        //}

        //サイクロン
        //6380行にて処理

        //ストームショット
        ui.cb_buff[E_SST].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "風属性の遠距離ダメージ+6 遠距離命中+3"
                                         + "<br>"+ "[習得レベル:75][持続時間:16分][対象:術者]"+"</html>");
            if (ui.cb_buff[E_SST].isSelected()) {
                ui.cb_buff[E_SEE].setSelected(false);
            buff.ELEM_DMG_LONG[WIND] += 6;
            buff.HIT_LONG += 3;
        }

        //ストームアイ
        ui.cb_buff[E_SEE].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーに風属性の遠距離ダメージ+3 遠距離命中+2"
                                         + "<br>"+ "[習得レベル:60][持続時間:16分][対象:術者/PTメンバー]"+"</html>");
            if (ui.cb_buff[E_SEE].isSelected()) {
                buff.ELEM_DMG_LONG[WIND] += 3;
                buff.HIT_LONG += 2;
            }

        //イーグルアイ
        //5903行にて処理

//精霊魔法(土)
        //アースバインド
        ui.cb_buff[E_EBD].setToolTipText("<html>"+ "[消費MP:18][消費HP:--]"
                                         + "<br>"+ "6セル内の対象を、一定確率で封鎖して行動不可能・攻撃を受けない状態にする"
                                         + "<br>"+ "封鎖された対象は回復魔法を受け付けない"
                                         + "<br>"+ "封鎖中にカーズパラライズを受けたら、アースバインドとカーズパラライズどちらの効果も解除"
                                         + "<br>"+ "[習得レベル:80][持続時間:8秒][対象:PC/NPC][触媒:精霊の玉(2)]"+"</html>");
        if (ui.cb_buff[E_EBD].isSelected()) {
        //スキル効果未実装
        }

        //エキゾチックバイタライズ
        ui.cb_buff[E_EVE].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "重量ゲージが50%を超えてもHPとMPが自然回復する"
                                         + "<br>"+ "[習得レベル:75][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_EVE].isSelected()) {
        //スキル効果未実装
        }
        //アイアンスキン
        ui.cb_buff[E_ISN].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "AC-10"
                                         + "<br>"+ "シールドの上位魔法"
                                         + "<br>"+ "[習得レベル:75][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_ISN].isSelected()) {
        //[AC]をONにする
        ui.cb_buff[B_AC].setSelected(true);
        //"AC-10"を選択する
        ui.cb_buff_group[B_AC].setSelectedItem("-10");
        }

        //サンドストーム
        ui.cb_buff[E_SSM].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "ダガー/ソード専用スキル"
                                         + "<br>"+ "移動速度と攻撃速度が上昇する[2段加速]x1.3333"
                                         + "<br>"+ "[習得レベル:75][持続時間:8分][対象:術者][触媒:エルブンワッフル(1)]"+"</html>");
        //if (ui.cb_buff[E_SSM].isSelected()) {
        //[2段加速]をONにする
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.3333"を選択する
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.3333");
        //}

        //アースガーディアン
        ui.cb_buff[E_EGN].setToolTipText("<html>"+ "[消費MP:30][消費HP:10]"
                                         + "<br>"+ "DR+2"
                                         + "<br>"+ "レベル80からレベル4毎にダメージ低下が+1ずつ増加"
                                         + "<br>"+ "[習得レベル:60][持続時間:10分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_EGN].isSelected()) {
            buff.DR += 2;
            if (level >= 80 ) {
                buff.DR += (level - 80) / 4 + 1;                 //DR(level - 80) / 4 + 1
            }
        }

        //クエイク
        //6396行にて処理

        //アースウェポン
        ui.cb_buff[E_EWN].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "ダガー/ソード専用スキル"
                                         + "<br>"+ "地属性の近距離ダメージ+2 近距離命中+4"
                                         + "<br>"+ "[習得レベル:45][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_EWN].isSelected()) {
            buff.ELEM_DMG_SHORT[EARTH] += 2;
            buff.HIT_SHORT += 4;
        }

//闇の精霊魔法
        //アベンジャー
        ui.cb_buff[D_AVR].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "1セル内の対象に強力な物理ダメージを与える"
                                         + "<br>"+ "対象のHPが30%以下だと一定確率(不明)で即死させる"
                                         + "<br>"+ "ダメージはSTRと武器ダメージの影響を受けます"
                                         + "<br>"+ "個別クールタイム"
                                         + "<br>"+ "[習得レベル:85][持続時間:瞬間][対象:PC][触媒:ダークストーン(2)]"+"</html>");
        if (ui.cb_buff[D_AVR].isSelected()) {
        //スキル効果未実装
        }

        //シャドウステップ
        ui.cb_buff[D_SHS].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "3セル内の対象に一瞬で接近して物理ダメージを与え一定確率(不明)でホールド状態にする"
                                         + "<br>"+ "個別クールタイム"
                                         + "<br>"+ "[習得レベル:80][持続時間:瞬間][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[D_SHS].isSelected()) {
        //スキル効果未実装
        }

        //アーマーブレイク
        ui.cb_buff[D_ABK].setToolTipText("<html>"+ "[消費MP:50][消費HP:25]"
                                         + "<br>"+ "1セル内の対象に一定確率(不明)で近距離攻撃の被ダメージを増加させる"
                                         + "<br>"+ "術者の攻撃は+58%増加術者以外の攻撃は+20%増加"
                                         + "<br>"+ "キャンセレーションで解除されない カウンターマジック無視"
                                         + "<br>"+ "[習得レベル:80][持続時間:8秒][対象:PC][触媒:ダークストーン(2)]"+"</html>");
        if (ui.cb_buff[D_ABK].isSelected()) {
        //スキル効果未実装
        }

        //ルシファー
        ui.cb_buff[D_LUR].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "被ダメージを10%低下"
                                         + "<br>"+ "イミューントゥハームと重複不可能"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:80][持続時間:30秒][対象:術者][触媒:ダークストーン(2)]"+"</html>");
        if (ui.cb_buff[D_LUR].isSelected()) {
        //スキル効果未実装
        }

        //ムービングアクセレーション:マキシマム
        ui.cb_buff[D_MAM].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "ムービングアクセレーションを詠唱した時に、攻撃速度が上昇する(ワッフル速度x1.1547)"
                                         + "<br>"+ "[習得レベル:85][持続時間:30秒][対象:術者][触媒:ダークストーン(2)]"+"</html>");
        //if (ui.cb_buff[D_MAM].isSelected()) {
        //[2段加速]をONにする
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.1547"を選択する
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.1547");
        //}

        //シャドウアーマー:デスティニー
        ui.cb_buff[D_SAD].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "シャドウアーマーを詠唱した時に、魔法ダメージ低下+5%"
                                         + "<br>"+ "レベル85から、レベル2毎に魔法ダメージ低下+1%(最大+10%)"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者][触媒:ダークストーン(2)]"+"</html>");
        if (ui.cb_buff[D_SAD].isSelected()) {
        //スキル効果未実装
        }

        //ルシファー:デスティニー
        ui.cb_buff[D_LUD].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "ルシファーの持続時間を60秒にする"
                                         + "<br>"+ "レベル85から、レベル2毎にPVPダメージ低下+1%(最大+10%)"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[D_LUD].isSelected()) {
        //スキル効果未実装
        }

        //アーマーブレイク:デスティニー
        ui.cb_buff[D_ABD].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "アーマーブレイクの成功率上昇"
                                         + "<br>"+ "レベル85からレベル1毎に成功率が3%ずつ増加"
                                         + "<br>"+ "アーマーブレイクの消費MPを35消費HPを20に低下"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[D_ABD].isSelected()) {
        //スキル効果未実装
        }

        //ダブルブレイク
        //7938行にて処理

        //ダブルブレイク:デスティニー
        //7943行にて処理

        //アンキャニードッジ
        //7021行にて処理

        //シャドウファング
        ui.cb_buff[D_SFG].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "近距離ダメージ+5"
                                         + "<br>"+ "ホーリーウェポン、エンチャントウェポン、ブレスウェポンの上位魔法"
                                         + "<br>"+ "[習得レベル:60][持続時間:3分12秒][対象:術者][触媒:ダークストーン(1)]"+"</html>");
//        if (ui.cb_buff[D_SFG].isSelected()) {
//        //[キャラ/武器]をONにする
//        ui.cb_buff[BUKI].setSelected(true);
//        //"武器 +5"を選択する
//        ui.cb_buff_group[BUKI].setSelectedItem("武器 +5");
//        }

        //ファイナルバーン
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

        //ドレスイベイジョン
        ui.cb_buff[D_DEN].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "遠距離回避(ER)+18"
                                         + "<br>"+ "パッシブ魔法"
                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[D_DEN].isSelected()) {
            buff.ER += 18;
        }

        //ムービングアクセレーション
        ui.cb_buff[D_MAN].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "移動速度のみ上昇"
                                         + "<br>"+ "[習得レベル:40][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[D_MAN].isSelected()) {
        //スキル効果未実装
        }

        //バーニング スピリッツ
        //7299行にて処理

        //シャドウスリープ
        ui.cb_buff[D_SSP].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "3セル内の対象を一定確率で睡眠状態にする"
                                         + "<br>"+ "[習得レベル:40][持続時間:最大4秒分][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[D_SSP].isSelected()) {
        //スキル効果未実装
        }

        //ベノムレジスト
        ui.cb_buff[D_VRT].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "全ての毒を無効化する"
                                         + "<br>"+ "[習得レベル:40][持続時間:5分20秒][対象:術者]"+"</html>");
        if (ui.cb_buff[D_VRT].isSelected()) {
        //スキル効果未実装
        }

        //ドレスデクスタリティー
        ui.cb_buff[D_DDY].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "DEX+3"
                                         + "<br>"+ "フィジカルエンチャント:DEXと重複不可能"
                                         + "<br>"+ "[習得レベル:40][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[D_DDY].isSelected()) {
        //[DEX]をONにする
        ui.cb_buff[B_DEX].setSelected(true);
        //"DEX +3"を選択する
        ui.cb_buff_group[B_DEX].setSelectedItem("+3");
        }

        //ブラインドハイディング
        ui.cb_buff[D_BHG].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "透明状態になる"
                                         + "<br>"+ "移動以外の行動をすると効果が消える"
                                         + "<br>"+ "帰還不可能の状態では詠唱不可能"
                                         + "<br>"+ "[習得レベル:20][持続時間:32秒][対象:術者]"+"</html>");
        if (ui.cb_buff[D_BHG].isSelected()) {
        //スキル効果未実装
        }

        //エンチャントベノム
        ui.cb_buff[D_EVM].setToolTipText("<html>"+ "[消費MP:10][消費HP:1]"
                                         + "<br>"+ "武器に毒属性を付与し、攻撃した対象を一定確率でダメージ毒状態にする"
                                         + "<br>"+ "[習得レベル:20][持続時間:5分20秒][対象:術者][触媒:ダークストーン(1)]"+"</html>");
        if (ui.cb_buff[D_EVM].isSelected()) {
        //スキル効果未実装
        }

        //シャドウアーマー
        ui.cb_buff[D_SAR].setToolTipText("<html>"+ "[消費MP:12][消費HP:--]"
                                         + "<br>"+ "MR+5"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:20][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[D_SAR].isSelected()) {
            buff.MR += 5;
        }

        //ドレスマイティー
        ui.cb_buff[D_DMY].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "STR+3"
                                         + "<br>"+ "フィジカルエンチャント:STRと重複不可能"
                                         + "<br>"+ "[習得レベル:20][持続時間:16分][対象:術者]"+"</html>");
        if (ui.cb_buff[D_DMY].isSelected()) {
        //[STR]をONにする
        ui.cb_buff[B_STR].setSelected(true);
        //"STR +3"を選択する
        ui.cb_buff_group[B_STR].setSelectedItem("+3");
        }

//竜騎士秘技
        //ハルパス
        ui.cb_buff[R_HAS].setToolTipText("<html>"+ "[消費MP:18][消費HP:--]"
                                         + "<br>"+ "チェーンソード技術"
                                         + "<br>"+ "攻撃をしてきた対象に一定確率(不明)でカウンターダメージを与える"
                                         + "<br>"+ "カウンターダメージは武器の[Small打撃値]x3"
                                         + "<br>"+ "[習得レベル:85][持続時間:2分8秒][対象:術者][触媒:刻印のボーンピース(1)]"+"</html>");
        if (ui.cb_buff[R_HAS].isSelected()) {
        //スキル効果未実装
        }

        //ソリッドノット
        ui.cb_buff[R_SNT].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "着用した武器が損傷しなくなる"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[R_SNT].isSelected()) {
        //スキル効果未実装
        }

        //ランページ
        ui.cb_buff[R_RAE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "スタン・ホールド状態のターゲットに、一定確率で追加ダメージを与える"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[R_RAE].isSelected()) {
        //スキル効果未実装
        }

        //アウラキア
        ui.cb_buff[R_AUA].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "覚醒を2種類まで重複が可能になる"
                                         + "<br>"+ "覚醒スキルの消費MPを5減少させる"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[R_AUA].isSelected()) {
        //スキル効果未実装
        }

        //サンダーグラップ:ブレイブ
        ui.cb_buff[R_TGB].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "サンダーグラップのホールド持続時間が3から6秒に増加"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[R_TGB].isSelected()) {
        //スキル効果未実装
        }

        //フォースレイヤー:ブレイブ
        ui.cb_buff[R_FSB].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "弱点露出に追加効果 一定確率でスタン状態にする"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[R_FSB].isSelected()) {
        //スキル効果未実装
        }

        //リンドビオル
        //7164行にて処理

        //モータルボディ
        ui.cb_buff[R_MBY].setToolTipText("<html>"+ "[消費MP:--][消費HP:40]"
                                         + "<br>"+ "攻撃をしてきた対象に、一定確率でカウンターダメージを与える"
                                         + "<br>"+ "カウンターダメージは[AC]/2 最小は40ダメージ"
                                         + "<br>"+ "[習得レベル:60][持続時間:5分][対象:術者]"+"</html>");
        if (ui.cb_buff[R_MBY].isSelected()) {
        //スキル効果未実装
        }

        //サンダーグラップ
        ui.cb_buff[R_TGP].setToolTipText("<html>"+ "[消費MP:--][消費HP:30]"
                                         + "<br>"+ "5セル内の対象を、一定確率でホールド状態にする"
                                         + "<br>"+ "個別クールタイム"
                                         + "<br>"+ "[習得レベル:60][持続時間:1から4秒][対象:術者]"+"</html>");
        if (ui.cb_buff[R_TGP].isSelected()) {
        //スキル効果未実装
        }

        //デストロイ:ホラー
        ui.cb_buff[R_DHR].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "デストロイにDG-20/STR-2/INT-2の効果を追加"
                                         + "<br>"+ "デストロイ:フィアーを覚えていないと習得する事が出来ない"
                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[R_DHR].isSelected()) {
        //スキル効果未実装
        }

        //アイオブドラゴン
        ui.cb_buff[R_EOD].setToolTipText("<html>"+ "[消費MP:10][消費HP:10]"
                                         + "<br>"+ "15セル内に隠れているPC/NPCを見つける"
                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_EOD].isSelected()) {
        //スキル効果未実装
        }

        //覚醒[ヴァラカス]
        ui.cb_buff[R_VALAKAS].setToolTipText("<html>"+ "[消費MP:50][消費HP:30]"
                                             + "<br>"+ "近距離命中+5 技術耐性+5 恐怖耐性+5 秘技命中+5"
                                             + "<br>"+ "[習得レベル:60][持続時間:10分][対象:術者][触媒:刻印のボーンピース(1)]"+"</html>");
        if (ui.cb_buff[R_VALAKAS].isSelected()) {
            buff.HIT_SHORT += 5;
            buff.ailment[STUN] += 5;
            buff.ailment[SECRET] += 5;
            buff.ailment[HIT_TERROR] += 5;
        }

        //ブラッドラスト
        ui.cb_buff[R_BLT].setToolTipText("<html>"+ "[消費MP:--][消費HP:30]"
                                         + "<br>"+ "移動速度/攻撃速度が上昇する[2段階加速]"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:40][持続時間:5分][対象:術者][触媒:刻印のボーンピース(1)]"+"</html>");
        //if (ui.cb_buff[R_BLT].isSelected()) {
        //[2段加速]をONにする
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.3333"を選択する
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.3333");
        //}

        //フォースレイヤー
        ui.cb_buff[R_FSR].setToolTipText("<html>"+ "[消費MP:--][消費HP:10]"
                                         + "<br>"+ "対象に3連続攻撃をする"
                                         + "<br>"+ "弱点露出の効果が適用される"
                                         + "<br>"+ "[習得レベル:40][持続時間:瞬間][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_FSR].isSelected()) {
        //スキル効果未実装
        }

        //デストロイ:フィアー
        ui.cb_buff[R_DFR].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "デストロイにDG-20の効果を追加"
                                         + "<br>"+ "デストロイを覚えていないと習得する事が出来ない"
                                         + "<br>"+ "[習得レベル:40][持続時間:常時][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_DFR].isSelected()) {
        //スキル効果未実装
        }

        //マグマアロー
        ui.cb_buff[R_MAW].setToolTipText("<html>"+ "[消費MP:5][消費HP:--]"
                                         + "<br>"+ "10セル内の対象に、火属性ダメージを与える"
                                         + "<br>"+ "[習得レベル:40][持続時間:瞬間][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_MAW].isSelected()) {
        //スキル効果未実装
        }

        //覚醒[パプリオン]
        ui.cb_buff[R_FAFURION].setToolTipText("<html>"+ "[消費MP:30][消費HP:20]"
                                              + "<br>"+ "重量ゲージが50％を超えてもHPとMPが自然回復する 遠距離回避ER+10"
                                              + "<br>"+ "重量ゲージの範囲50から82%?"
                                              + "<br>"+ "キャンセレーションで解除されない"
                                              + "<br>"+ "[習得レベル:40][持続時間:10分][対象:術者][触媒:刻印のボーンピース(1)]"+"</html>");
        if (ui.cb_buff[R_FAFURION].isSelected()) {
            buff.ER += 10;
        }

        //ドラゴンスキン
        ui.cb_buff[R_DSN].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "ダメージ低下+5"
                                         + "<br>"+ "レベル80から、レベル2毎に効果が+1ずつ増加(LV80でDR6)"
                                         + "<br>"+ "*リニューアル パッシブに変更"
                                         + "<br>"+ "[習得レベル:20][持続時間:常時][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_DSN].isSelected()) {
            buff.DR += 5;
            if (level >= 80) {
                buff.DR += (int) ((level - 80) / 2) + 1;
            }
        }

        //バーニングスラッシュ
        ui.cb_buff[R_BSH].setToolTipText("<html>"+ "[消費MP:--][消費HP:6]"
                                         + "<br>"+ "詠唱して最初の攻撃をした時に、火属性ダメージ+7を追加"
                                         + "<br>"+ "[習得レベル:20][持続時間:1分][対象:術者]"+"</html>");
        if (ui.cb_buff[R_BSH].isSelected()) {
        //スキル効果未実装
        }

        //デストロイ
        ui.cb_buff[R_DEY].setToolTipText("<html>"+ "[消費MP:10][消費HP:20]"
                                         + "<br>"+ "5セル内の対象に、一定確率でAC+10"
                                         + "<br>"+ "[習得レベル:20][持続時間:16秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_DEY].isSelected()) {
        //スキル効果未実装
        }

        //マグマブレス
        ui.cb_buff[R_MBH].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "5セル内の対象1セル内に、火属性ダメージ25から35を与える"
                                         + "<br>"+ "[習得レベル:20][持続時間:瞬間][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_MBH].isSelected()) {
        //スキル効果未実装
        }

        //覚醒[アンタラス]
        ui.cb_buff[R_ANTHARAS].setToolTipText("<html>"+ "[消費MP:20][消費HP:10]"
                                              + "<br>"+ "AC-3 MR+5%"
                                              + "<br>"+ "キャンセレーションで解除されない"
                                              + "<br>"+ "[習得レベル:20][持続時間:10分][対象:術者][触媒:刻印のボーンピース(1)]"+"</html>");
        if (ui.cb_buff[R_ANTHARAS].isSelected()) {
            buff.AC -= 3;
            buff.MR += 5;
        }

//幻術魔法
        //ポテンシャル
        ui.cb_buff[I_POL].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "装備品や魔法が適用された状態の"
                                         + "<br>"+ "[最大HP][最大MP][MR][SP][DG][ER]を20%上昇させる"
                                         + "<br>"+ "アドバンスドスピリッツと重複する"
                                         + "<br>"+ "[習得レベル:85][持続時間:2分8秒][対象:術者][触媒:属性石(2)]"+"</html>");
        if (ui.cb_buff[I_POL].isSelected()) {
        //スキル効果未実装
        }

        //ボーンブレイク:ラスト
        ui.cb_buff[I_BBL].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "ボーンブレイクのスタン持続時間+1秒"
                                         + "<br>"+ "[習得レベル:85]");
        if (ui.cb_buff[I_BBL].isSelected()) {
        //スキル効果未実装
        }

        //メビウス
        ui.cb_buff[I_MES].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "遠距離ダメージを20%低下"
                                         + "<br>"+ "レベル85から、レベル1毎に[遠距離ダメージ低下]1%増加(最大10%)"
                                         + "<br>"+ "イミューントゥハームと重複する"
                                         + "<br>"+ "個別クールタイム"
                                         + "<br>"+ "[習得レベル:85][持続時間:6秒][対象:術者][触媒:属性石(1)]"+"</html>");
        if (ui.cb_buff[I_MES].isSelected()) {
        //スキル効果未実装
        }

        //インパクト
        ui.cb_buff[I_IMT].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーに"
                                         + "<br>"+ "技術命中+5 精霊命中+5 竜語命中+5 恐怖命中+5"
                                         + "<br>"+ "レベル80からレベル1毎に効果が+1ずつ増加[最大+10]"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:80][持続時間:15秒][対象:PT][触媒:属性石(5)]"+"</html>");
        if (ui.cb_buff[I_IMT].isSelected()) {
            if (level >= 80 && cls == I) {
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

        //ダークホース
        ui.cb_buff[I_DHE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "攻撃速度が上昇する[2段階加速]x1.0800"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        //if (ui.cb_buff[I_DHE].isSelected()) {
        //[2段加速]をONにする
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.0800"を選択する
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.0800");
        //}

        //フォーカススピリッツ
        ui.cb_buff[I_FSZ].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "魔法クリティカル+5%"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:75][持続時間:5分][対象:術者][触媒:属性石(1)]"+"</html>");
        if (ui.cb_buff[I_FSZ].isSelected()) {
            buff.CRI_MAGIC += 5;
        }

        //インサイト
        ui.cb_buff[I_INS].setToolTipText("<html>"+ "[消費MP:60][消費HP:--]"
                                         + "<br>"+ "STR+1 DEX+1 INT+1 CON+1 WIS+1"
                                         + "<br>"+ "[習得レベル:60][持続時間:10分40秒][対象:術者]"+"</html>");
        if (ui.cb_buff[I_INS].isSelected()) {
            buff.ST[STR]++;
            buff.ST[DEX]++;
            buff.ST[CON]++;
            buff.ST[INT]++;
            buff.ST[WIS]++;
        }

        //パニック
        ui.cb_buff[I_PAC].setToolTipText("<html>"+ "[消費MP:30][消費HP:30]"
                                         + "<br>"+ "5セル内の対象にSTR-1/DEX-1/CON-1/INT-1/WIS-1"
                                         + "<br>"+ "[習得レベル:60][持続時間:1分4秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_PAC].isSelected()) {
        //スキル効果未実装
        }

        //リデュースウェイト
        //7370行にて処理

        //イリュージョン[アバター]
        //6606行にて処理

        //キューブ[アバター]
        //6616行にて処理

        //ペイシェンス
        ui.cb_buff[I_PAE].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "DR+2"
                                         + "<br>"+ "レベル80から、レベル4毎に効果が+1ずつ増加"
                                         + "<br>"+ "*リニューアル レベル80から効果が上昇"
                                         + "<br>"+ "[習得レベル:45][持続時間:10分][対象:術者/PC]"+"</html>");
        if (ui.cb_buff[I_PAE].isSelected()) {
            buff.DR += 2;
        }

        //ファンタズム
        ui.cb_buff[I_PHM].setToolTipText("<html>"+ "[消費MP:30][消費HP:25]"
                                         + "<br>"+ "3セル内の対象を30%の確率で睡眠状態にする"
                                         + "<br>"+ "[習得レベル:45][持続時間:最大4秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_PHM].isSelected()) {
        //スキル効果未実装
        }

        //アイズブレイカー
        ui.cb_buff[I_IBR].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "15セル内に隠れているPC/NPCを見つける"
                                         + "<br>"+ "[習得レベル:45][持続時間:瞬間][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_IBR].isSelected()) {
        //スキル効果未実装
        }

        //イリュージョン[ゴーレム]
        ui.cb_buff[I_IGM].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "AC-10"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:45][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[I_IGM].isSelected()) {
            buff.AC -= 10;
        }

        //キューブ[リッチ]
        ui.cb_buff[I_CRH].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーにSP+2"
                                         + "<br>"+ "[習得レベル:45][持続時間:2分8秒][対象:PT][触媒:属性石(3)]"+"</html>");
        if (ui.cb_buff[I_CRH].isSelected()) {
            buff.SP += 2;
        }

        //コンセントレーション
        ui.cb_buff[I_CON].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "5セル内の対象に、MP自然回復+4"
                                         + "<br>"+ "[習得レベル:30][持続時間:10分][対象:術者/PC]"+"</html>");
        if (ui.cb_buff[I_CON].isSelected()) {
            buff.MPR += 2;
        }

        //マインドブレイク
        ui.cb_buff[I_MBK].setToolTipText("<html>"+ "[消費MP:20][消費HP:15]"
                                         + "<br>"+ "5セル内の対象にダメージを与え、MPを5排出させる"
                                         + "<br>"+ "ダメージは[SP]x[3.8]"
                                         + "<br>"+ "[習得レベル:30][持続時間:瞬間][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_MBK].isSelected()) {
        //スキル効果未実装
        }

        //ボーンブレイク
        ui.cb_buff[I_BBK].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "1セル内の対象に10ダメージを与え、30から50%の確率でスタン状態にする"
                                         + "<br>"+ "沈黙状態でも詠唱可能"
                                         + "<br>"+ "[習得レベル:30][持続時間:最大2秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_BBK].isSelected()) {
        //スキル効果未実装
        }

        //イリュージョン[リッチ]
        ui.cb_buff[I_IRH].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "SP+4"
                                         + "<br>"+ "[習得レベル:30][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[I_IRH].isSelected()) {
            buff.SP += 4;
        }

        //キューブ[ゴーレム]
        ui.cb_buff[I_CGM].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーにAC-8"
                                         + "<br>"+ "キャンセレーションで解除されない(術者のみ)"
                                         + "<br>"+ "[習得レベル:30][持続時間:2分8秒][対象:PT][触媒:属性石(5)]"+"</html>");
        if (ui.cb_buff[I_CGM].isSelected()) {
            buff.AC -= 8;
        }

        //ミラーイメージ
        //7384行にて処理

        //コンフュージョン
        ui.cb_buff[I_CFN].setToolTipText("<html>"+ "[消費MP:15][消費HP:10]"
                                         + "<br>"+ "3セル内の対象にダメージを与え、20から30%の確率で沈黙状態にする"
                                         + "<br>"+ "ダメージは「SP]x[2.2]"
                                         + "<br>"+ "[習得レベル:15][持続時間:8秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_CFN].isSelected()) {
        //スキル効果未実装
        }

        //スマッシュエネルギー
        ui.cb_buff[I_SEY].setToolTipText("<html>"+ "[消費MP:5][消費HP:--]"
                                         + "<br>"+ "10セル内の対象に光線系ダメージを与える"
                                         + "<br>"+ "[習得レベル:15][持続時間:瞬間][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_SEY].isSelected()) {
        //スキル効果未実装
        }

        //イリュージョン[オーガ]
        ui.cb_buff[I_IOE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "近距離ダメージ+4 近距離命中+4 遠距離ダメージ+4 遠距離命中+4"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:15][持続時間:2分8秒][対象:術者]"+"</html>");
        if (ui.cb_buff[I_IOE].isSelected()) {
            buff.DMG_SHORT += 4;
            buff.HIT_SHORT += 4;
            buff.DMG_LONG += 4;
            buff.HIT_LONG += 4;
        }

        //キューブ[オーガ]
        ui.cb_buff[I_COE].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーに近距離ダメージ+4 近距離命中+4 遠距離ダメージ+4 遠距離命中+4"
                                         + "<br>"+ "[習得レベル:15][持続時間:2分8秒][対象:PT][触媒:属性石(3)]"+"</html>");
        if (ui.cb_buff[I_COE].isSelected()) {
            buff.DMG_SHORT += 4;
            buff.HIT_SHORT += 4;
            buff.DMG_LONG += 4;
            buff.HIT_LONG += 4;
        }

//戦士技術
        //デモリッション
        ui.cb_buff[S_DEN].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "5セル内の対象を、帰還不可能＋出血状態にする"
                                         + "<br>"+ "デモリッションのダメージは、STRと武器ダメージの影響を受けます"
                                         + "<br>"+ "[習得レベル:85][持続時間:最大4秒][対象:PC][触媒:結晶体(100)]"+"</html>");
        if (ui.cb_buff[S_DEN].isSelected()) {
        //スキル効果未実装
        }

        //バーサーク
        ui.cb_buff[S_BER].setToolTipText("<html>"+ "[消費MP:--][消費HP:100]"
                                         + "<br>"+ "近距離ダメージ+20 全スキル耐性+20"
                                         + "<br>"+ "[習得レベル:85][持続時間:16秒][対象:術者][触媒:結晶体(100)]"+"</html>");
        if (ui.cb_buff[S_BER].isSelected()) {
        //スキル効果未実装
        }

        //デスペラード
        ui.cb_buff[S_DEO].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "1セル内の対象にダメージを与え、一定確率で移動不可、テレポート不可、装備の着脱不可、HP回復効果を悪化"
                                         + "<br>"+ "術者のレベルが上がると回復悪化の効果が上昇する"
                                         + "<br>"+ "*リニューアル スキル命中時にダメージ追加 命中率増加 最小持続時間+1秒"
                                         + "<br>"+ "[習得レベル:80][持続時間:最大4秒][対象:PC/NPC][触媒:結晶体(100)]"+"</html>");
        if (ui.cb_buff[S_DEO].isSelected()) {
        //スキル効果未実装
        }

        //タイタンライジング
        ui.cb_buff[S_TRG].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "タイタン系列発動区間+5%"
                                         + "<br>"+ "レベル80からレベル1毎に効果が1%増加[最大10%]"
                                         + "<br>"+ "標準35%+ライジング(5%+10%)+武器(5%+5%)=最大60%発動区間?"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:80][持続時間:40分][対象:術者][触媒:結晶体(100)]"+"</html>");
        if (ui.cb_buff[S_TRG].isSelected()) {
        //スキル効果未実装
        }

        //パワーグリップ
        ui.cb_buff[S_PGP].setToolTipText("<html>"+ "[消費MP:5][消費HP:--]"
                                         + "<br>"+ "6セル内の対象を、一定確率でホールド状態にする"
                                         + "<br>"+ "[習得レベル:75][持続時間:最大6秒][対象:PC/NPC][触媒:結晶体(20)]"+"</html>");
        if (ui.cb_buff[S_PGP].isSelected()) {
        //スキル効果未実装
        }

        //ギガンティック
        //8073行にて処理

        //トマホーク
        ui.cb_buff[S_TOK].setToolTipText("<html>"+ "[消費MP:5][消費HP:--]"
                                         + "<br>"+ "6セル内の対象に強力な物理ダメージを与える"
                                         + "<br>"+ "個別クールタイム(8秒)"
                                         + "<br>"+ "[習得レベル:45][持続時間:--][対象:PC/NPC][触媒:結晶体(50)]"+"</html>");
        if (ui.cb_buff[S_TOK].isSelected()) {
        //スキル効果未実装
        }

        //ハウル
        ui.cb_buff[S_HOL].setToolTipText("<html>"+ "[消費MP:5][消費HP:--]"
                                         + "<br>"+ "範囲5セル内の対象に、50ダメージを与える"
                                         + "<br>"+ "[習得レベル:30][持続時間:瞬間][対象:PC/NPC][触媒:結晶体(10)]"+"</html>");
        if (ui.cb_buff[S_HOL].isSelected()) {
        //スキル効果未実装
        }

        //タイタンロック
        ui.cb_buff[S_TLK].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "HP40%以下時一定確率(35%)で近距離攻撃を回避してカウンターダメージを与える"
                                         + "<br>"+ "カウンターダメージは武器の[BIG打撃値]+[追加ダメージ]+[強化数]x[2]"
                                         + "<br>"+ "[習得レベル:75][持続時間:常時][対象:術者][触媒:結晶体(10)]"+"</html>");
        if (ui.cb_buff[S_TLK].isSelected()) {
        //スキル効果未実装
        }

        //タイタンマジック
        ui.cb_buff[S_TMC].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "HP40%以下時一定確率(35%)で魔法攻撃を回避してカウンターダメージを与える"
                                         + "<br>"+ "カウンターダメージは武器の[BIG打撃値]+[追加ダメージ]+[強化数]x[2]"
                                         + "<br>"+ "[習得レベル:75][持続時間:常時][対象:術者][触媒:結晶体(10)]"+"</html>");
        if (ui.cb_buff[S_TMC].isSelected()) {
        //スキル効果未実装
        }

        //タイタンブリッツ
        ui.cb_buff[S_TBZ].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "HP40%以下時一定確率(35%)で遠距離攻撃を回避してカウンターダメージを与える"
                                         + "<br>"+ "カウンターダメージは武器の[BIG打撃値]+[追加ダメージ]+[強化数]x[2]"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者][触媒:結晶体(10)]"+"</html>");
        if (ui.cb_buff[S_TBZ].isSelected()) {
        //スキル効果未実装
        }

        //スレイヤー
        ui.cb_buff[S_SLR].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "片手斧を両手に装備して交互に攻撃"
                                         + "<br>"+ "攻撃速度がソードと同じになる"
                                         + "<br>"+ "[習得レベル:15][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[S_SLR].isSelected()) {
        //スキル効果未実装
        }

        //クラッシュ
        //6864行にて処理

        //アーマーガード
        //7471行にて処理

        //フューリー
        //6875行にて処理

        //デスペラード:アブソリュート
        ui.cb_buff[S_DAE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "デスペラードの最大持続時間を増加"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[S_DAE].isSelected()) {
        //スキル効果未実装
        }

//剣士技術
        //ファントム:デス
        ui.cb_buff[F_PPH].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "ファントムに移動不可能、デスヒール、デスポーションの効果を追加"
                                         + "<br>"+ "リーパー、デスのどちらかがランダムで発動する"
                                         + "<br>"+ "ファントム:リーパーを覚えていないと習得する事が出来ない"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PPH].isSelected()) {
        //スキル効果未実装
        }

        //アシュラ
        ui.cb_buff[F_AAA].setToolTipText("<html>"+ "[消費MP:--][消費HP:2,000]"
                                         + "<br>"+ "10秒でMPを400回復"
                                         + "<br>"+ "個別[D]クールタイム(30分)"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者][触媒:結晶体(2,000)]"+"</html>");
        if (ui.cb_buff[F_AAA].isSelected()) {
        //スキル効果未実装
        }

        //ブレード
        ui.cb_buff[F_ABE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "ダガー/ソード/両手剣技術"
                                         + "<br>"+ "5セル内の対象に物理ダメージを与える"
                                         + "<br>"+ "ダメージは着用している武器の影響を受ける"
                                         + "<br>"+ "個別[A]クールタイム()"
                                         + "<br>"+ "[習得レベル:60][持続時間:瞬間][対象:PC/NPC][触媒:結晶体(50)]"+"</html>");
        if (ui.cb_buff[F_ABE].isSelected()) {
        //スキル効果未実装
        }

        //パンテラ
        ui.cb_buff[F_APA].setToolTipText("<html>"+ "[消費MP:22][消費HP:--]"
                                         + "<br>"+ "ソード技術"
                                         + "<br>"+ "3セル内の対象に一瞬で接近して物理ダメージを与え、一定確率でスタン状態にする"
                                         + "<br>"+ "スタン効果は恐怖命中の影響を受ける"
                                         + "<br>"+ "個別[B]クールタイム()"
                                         + "<br>"+ "[習得レベル:75][持続時間:常時][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[F_APA].isSelected()) {
        //スキル効果未実装
        }

        //ジャッジメント
        ui.cb_buff[F_AJT].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "6セル内の対象の全スキル耐性を減少させる"
                                         + "<br>"+ "減少量はSTRの影響を受ける"
                                         + "<br>"+ "個別[C]クールタイム()"
                                         + "<br>"+ "[習得レベル:80][持続時間:8秒][対象:PC]"+"</html>");
        if (ui.cb_buff[F_AJT].isSelected()) {
        //スキル効果未実装
        }

        //ヘルファイア
        ui.cb_buff[F_AHE].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "範囲4セル内の対象に物理ダメージを与える"
                                         + "<br>"+ "ダメージは着用している武器の影響を受ける"
                                         + "<br>"+ "個別[C]クールタイム()"
                                         + "<br>"+ "[習得レベル:70][持続時間:常時][対象:PC/NPC][触媒:結晶体(10)]"+"</html>");
        if (ui.cb_buff[F_AHE].isSelected()) {
        //スキル効果未実装
        }

        //ファントム
        ui.cb_buff[F_APM].setToolTipText("<html>"+ "[消費MP:18][消費HP:--]"
                                         + "<br>"+ "ソード技術"
                                         + "<br>"+ "1セル内の対象を一定確率で装備の着脱不可、帰還不可の状態にする"
                                         + "<br>"+ "個別[C]クールタイム()"
                                         + "<br>"+ "[習得レベル:70][持続時間:常時][対象:PC][触媒:結晶体(100)]"+"</html>");
        if (ui.cb_buff[F_APM].isSelected()) {
        //スキル効果未実装
        }

        //ファントム:リーパー
        ui.cb_buff[F_PPR].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "ファントムに移動不可能の効果を追加"
                                         + "<br>"+ "ファントムを覚えていないと習得する事が出来ない"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PPR].isSelected()) {
        //スキル効果未実装
        }

        //パンテラ:ショック
        ui.cb_buff[F_PPK].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "パンテラの射程を1セル伸ばし、スタン時間を増加する"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PPK].isSelected()) {
        //スキル効果未実装
        }

        //サヴァイヴ
        ui.cb_buff[F_PSE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "HPが45%以下になると、一定確率でHP回復ポーションの回復量が増加する"
                                         + "<br>"+ "CONとHPの%で回復量が変化する"
                                         + "<br>"+ "回復量に応じて結晶体を消費する"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者][触媒:結晶体]"+"</html>");
        if (ui.cb_buff[F_PSE].isSelected()) {
        //スキル効果未実装
        }

        //インフィニティ:ブリッツ
        ui.cb_buff[F_PIZ].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "レベル75からレベル1毎にERが+1ずつ増加[最大+15]"
                                         + "<br>"+ "[習得レベル:75][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PIZ].isSelected()) {
            if (cls == F) {
                if (level >= 89) {
                    buff.ER += 15;                                      //最大ER+15(LV89)
                } else if (level >= 75) {
                    buff.ER += (level - 75) / 1 + 1;                    //ER+((level - 75) / 1 + 1)
                }
            } else {
                ui.cb_buff[F_PIZ].setSelected(false);
            }
        }

        //パラドックス
        ui.cb_buff[F_PPX].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "カウンタースキルの回避を一定確率で貫通して、カウンターダメージを減少させる"
                                         + "<br>"+ "[習得レベル:75][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PPX].isSelected()) {
        //スキル効果未実装
        }

        //インフィニティ:ドッジ
        //7656行にて処理

        //グロース
        ui.cb_buff[F_PGE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "モンスターを倒した時に、一定確率で獲得経験値を2から5倍にする"
                                         + "<br>"+ "レベル85になると効果が無くなります"
                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PGE].isSelected()) {
        //スキル効果未実装
        }

        //インフィニティ:ブラッド
        //8214行にて処理

        //レイジ
        //7183行にて処理

        //インフィニティ:アーマー
        ui.cb_buff[F_PIR].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "レベル45からレベル4毎にダメージ低下が+1ずつ増加[最大+15]"
                                         + "<br>"+ "[習得レベル:45][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PIR].isSelected()) {
            if (cls == F) {
                if (level >= 101) {
                    buff.DR += 15;                                      //最大DR+15(LV101)
                } else if (level >= 45) {
                    buff.DR += (level - 45) / 4 + 1;                    //DR+((level - 45) / 4 + 1)
                }
            } else {
                ui.cb_buff[F_PIR].setSelected(false);
            }
        }

        //フレイム
        ui.cb_buff[F_PFE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "対象に攻撃が命中した時に、一定確率で3秒間HPを減少させる(計算式不明)"
                                         + "<br>"+ "[習得レベル:45][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PGE].isSelected()) {
        //スキル効果未実装
        }

        //ダマスカス
        ui.cb_buff[F_PDS].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "着用した武器が損傷しなくなる"
                                         + "<br>"+ "[習得レベル:45][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PGE].isSelected()) {
        //スキル効果未実装
        }

//槍士技術
        //プレッシャー:デス リコール
        ui.cb_buff[L_PDR].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "プレッシャーにデステレポートの効果を追加"
                                         + "<br>"+ "[習得レベル:85][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[L_PDR].isSelected()) {
        //スキル効果未実装
        }

        //リカバリー
        ui.cb_buff[L_REY].setToolTipText("<html>"+ "[消費MP:50][消費HP:--]"
                                         + "<br>"+ "伝説級を除く[スタン][ホールド][帰還不可能]の効果を消す"
                                         + "<br>"+ "[習得レベル:80][持続時間:瞬間][対象:術者][触媒:結晶体(300)]"+"</html>");
        if (ui.cb_buff[L_REY].isSelected()) {
        //スキル効果未実装
        }

        //クルーエル
        ui.cb_buff[L_KRL].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "[近距離フォーム]3セル内の対象を、目の前に引き寄せてスタン状態にする"
                                         + "<br>"+ "[遠距離フォーム]3セル内の対象を、自身から引き離してスタン状態にする"
                                         + "<br>"+ "NPC相手だと移動させる効果が無くスタンのみ発動"
                                         + "<br>"+ "[習得レベル:80][持続時間:3秒以下][対象:PC/NPC][触媒:結晶体(100)]"+"</html>");
        if (ui.cb_buff[L_KRL].isSelected()) {
        //スキル効果未実装
        }

        //プレッシャー
        ui.cb_buff[L_PRE].setToolTipText("<html>"+ "[消費MP:16][消費HP:--]"
                                         + "<br>"+ "5セル内の対象に、ホールド状態にする"
                                         + "<br>"+ "更に持続時間内に与えたダメージの60%を追加ダメージとして与える"
                                         + "<br>"+ "術者以外のダメージは10%"
                                         + "<br>"+ "[習得レベル:75][持続時間:4秒][対象:PC]"+"</html>");
        if (ui.cb_buff[L_PRE].isSelected()) {
        //スキル効果未実装
        }

        //ヴァンガード
        ui.cb_buff[L_VAD].setToolTipText("<html>"+ "[消費MP:--][消費HP:25]"
                                         + "<br>"+ "[近距離フォーム]移動速度・攻撃速度が大幅に上昇する"
                                         + "<br>"+ "[遠距離フォーム]攻撃速度が大幅に上昇する"
                                         + "<br>"+ "[習得レベル:70][持続時間:4秒][対象:術者][触媒:結晶体(50)]"+"</html>");
        if (ui.cb_buff[L_VAD].isSelected()) {
        //スキル効果未実装
        }

        //フォース ウェーブ
        ui.cb_buff[L_FWE].setToolTipText("<html>"+ "[消費MP:15][消費HP:--]"
                                         + "<br>"+ "[近距離フォーム]周囲1セルにダメージを与える"
                                         + "<br>"+ "[遠距離フォーム]前方5セル内の対象全てにダメージを与える"
                                         + "<br>"+ "[習得レベル:60][持続時間:瞬間][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[L_FWE].isSelected()) {
        //スキル効果未実装
        }

        //オルティネート
        ui.cb_buff[L_ALE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "近距離フォームと遠距離フォームに変更する"
                                         + "<br>"+ "遠距離フォームでは攻撃速度が減少し、対象との距離が遠くなるほどダメージが減少する"
                                         + "<br>"+ "遠距離フォームの攻撃はDEX・遠距離ダメージ・遠距離命中の影響を受けない"
                                         + "<br>"+ "[習得レベル:50][持続時間:瞬間][対象:術者]"+"</html>");
        if (ui.cb_buff[L_ALE].isSelected()) {
        //スキル効果未実装
        }

        //クルーエル:コンビクション
        ui.cb_buff[L_KCN].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "クルーエルの射程を2セル伸ばし、スタン時間を増加する"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[L_KCN].isSelected()) {
        //スキル効果未実装
        }

        //インクリーズ レンジ
        ui.cb_buff[L_IRE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "遠距離フォームの射程を3セル伸ばし、ダメージを20%増加する"
                                         + "<br>"+ "[習得レベル:80][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[L_IRE].isSelected()) {
        //スキル効果未実装
        }

        //メイルストロム
        ui.cb_buff[L_MAM].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "伝説級を除く[スタン][ホールド][帰還不可能]の効果を受けた時に、一定確率で反射して相手に返す"
                                         + "<br>"+ "[習得レベル:75][持続時間:常時][対象:術者][触媒:結晶体(15)]"+"</html>");
        if (ui.cb_buff[L_MAM].isSelected()) {
        //スキル効果未実装
        }

        //ドッジ ブレイク
        ui.cb_buff[L_DBK].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "対象が攻撃を回避した時に、20%の確率で必中する"
                                         + "<br>"+ "レベル80から、レベル3毎に3%ずつ増加［最大35%］"
                                         + "<br>"+ "[習得レベル:75][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[L_DBK].isSelected()) {
        //スキル効果未実装
        }

        //ヴェンジェンス
        ui.cb_buff[L_VEE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "ダメージを受けた時に、一定確率でダメージ低下の効果が発動"
                                         + "<br>"+ "HPが50%以下になると発動率と効果が上昇する"
                                         + "<br>"+ "[習得レベル:70][持続時間:常時][対象:術者][触媒:HP50%以下になると結晶体(5)]"+"</html>");
        if (ui.cb_buff[L_VEE].isSelected()) {
        //スキル効果未実装
        }

        //タクティカル アドバンス
        ui.cb_buff[L_TAE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "DG+5 ER+5 MR+5%"
                                         + "<br>"+ "レベル80から、レベル3毎に+2ずつ増加［最大+15］"
                                         + "<br>"+ "[習得レベル:70][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[L_TAE].isSelected()) {
        //スキル効果未実装
        }

        //デッドリー ストライク
        ui.cb_buff[L_DSE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "一定確率でダメージを2.5倍にする"
                                         + "<br>"+ "[習得レベル:65][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[L_DSE].isSelected()) {
        //スキル効果未実装
        }

        //バーサーカー
        ui.cb_buff[W_BER].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "術者に近距離ダメージ+2 近距離命中+8"
                                         + "<br>"+ "PTメンバーに近距離ダメージ+2 近距離命中+8 AC+10 HP自然回復不可"
                                         + "<br>"+ "[習得レベル:56][持続時間:5分20秒][対象:術者/PTメンバー(15セル)]"+"</html>");
        if (ui.cb_buff[W_BER].isSelected()) {
            switch ((String) ui.cb_buff_group[W_BER].getSelectedItem()) {
                case "術者":
                    ui.cb_buff[W_BER].setToolTipText("近距離ダメージ+2 近距離命中+8");
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 8;
                    break;
                case "PTメンバー":
                    ui.cb_buff[W_BER].setToolTipText("近距離ダメージ+2 近距離命中+8 AC+10 HP自然回復不可");
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 8;
                    buff.HPR -= 255;
                    buff.AC += 10;
                    break;
                default:
                    break;
            }
        }

        //ブレスドアーマー
        ui.cb_buff[W_BAR].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "選択した鎧のAC-3"
                                         + "<br>"+ "ダブルクリックで装備している鎧に自動詠唱する"
                                         + "<br>"+ "[習得レベル:24][持続時間:30分][対象:術者/PTメンバー]"+"</html>");
        if (ui.cb_buff[W_BAR].isSelected()) {
            buff.AC -= 3;
        }

        //エンチャントアキュラシー
        ui.cb_buff[W_EAY].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "近距離命中+5"
                                         + "<br>"+ "[習得レベル:56][持続時間:5分][対象:術者][触媒:魔力の石(1)]"+"</html>");
        if (ui.cb_buff[W_EAY].isSelected()) {
            buff.HIT_SHORT += 5;
        }

        //フリージングアーマー
        ui.cb_buff[W_FAR].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "ER+5"
                                         + "<br>"+ "[習得レベル:56][持続時間:5分][対象:術者][触媒:魔力の石(1)]"+"</html>");
        if (ui.cb_buff[W_FAR].isSelected()) {
            buff.ER += 5;
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

        //エリクサールーン(LV70/80/85/90/91/92/93/94/95)
        int e = ui.elixir_rune.getSelectedIndex();
        int q = ui.elixir_rune_en.getSelectedIndex();
        if (e > 0 && e<6) {
            buff.ST[e - 1]++;
            switch (cls) {
                case P:
                                //LV55
                    buff.DR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "ダメージ低下: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.HIT_SHORT += 2;            //近距離命中+2
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2: //LV80
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
                        case 3: //LV85
                            buff.HIT_SHORT += 2;            //近距離命中+2
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 5;    //技術命中+5
                                                            //PVP魔法ダメージ減少+2%
                                                            //エリクサーブースター効果
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "エリクサーブースター効果"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4: //LV90
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
                        case 5: //LV91
                            buff.HIT_SHORT += 2;            //近距離命中+2
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 11;   //技術命中+11
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +11"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.HIT_SHORT += 2;            //近距離命中+2
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 12;   //技術命中+12
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +12"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.HIT_SHORT += 2;            //近距離命中+2
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 13;   //技術命中+13
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +13"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.HIT_SHORT += 2;            //近距離命中+2
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 14;   //技術命中+14
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +14"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.HIT_SHORT += 2;            //近距離命中+2
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 15;   //技術命中+15
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "ダメージ低下: +3"
                                                          + "<br>"+ "近距離命中: +2"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +15"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            
                            break;
                    }
                    break;
                case K:
                                //LV55
                    buff.HP += 50;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "HP: +50"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2: //LV80
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
                        case 3: //LV85
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 5;    //技術命中+5
                                                            //PVP魔法ダメージ減少+2%
                                                            //エリクサーブースター効果
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "エリクサーブースター効果"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4: //LV90
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
                        case 5: //LV91
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 11;   //技術命中+11
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +11"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 12;   //技術命中+12
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +12"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 13;   //技術命中+13
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +13"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 14;   //技術命中+14
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +14"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_STUN] += 15;   //技術命中+15
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "技術命中: +15"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case E:
                                //LV55
                    buff.MP += 50;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "MP: +50"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2: //LV80
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
                        case 3: //LV85
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 5;  //精霊命中+5
                                                            //PVP魔法ダメージ減少+2%
                                                            //エリクサーブースター効果
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "エリクサーブースター効果"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4: //LV90
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
                        case 5: //LV91
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 11; //精霊命中+11
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +11"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 12; //精霊命中+12
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +12"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 13; //精霊命中+13
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +13"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 14; //精霊命中+14
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +14"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.DMG_SHORT += 1;            //近距離ダメージ+1
                            buff.DMG_LONG += 1;             //遠距離ダメージ+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 15; //精霊命中+15
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "近距離ダメージ: +1"
                                                          + "<br>"+ "遠距離ダメージ: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +15"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case W:
                                //LV55
                    buff.MPR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "MPR: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.SP += 1;                   //SP+1
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2: //LV80
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
                        case 3: //LV85
                            buff.SP += 1;                   //SP+1
                                                            //祝福消耗効率+5%
                            buff.HIT_MAGIC += 5;            //魔法命中+5
                                                            //PVP魔法ダメージ減少+2%
                                                            //エリクサーブースター効果
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "魔法命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "エリクサーブースター効果"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4: //LV90
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
                        case 5: //LV91
                            buff.SP += 1;                   //SP+1
                                                            //祝福消耗効率+5%
                            buff.HIT_MAGIC += 11;           //魔法命中+11
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "魔法命中: +11"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.SP += 1;                   //SP+1
                                                            //祝福消耗効率+5%
                            buff.HIT_MAGIC += 12;           //魔法命中+12
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "魔法命中: +12"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.SP += 1;                   //SP+1
                                                            //祝福消耗効率+5%
                            buff.HIT_MAGIC += 13;           //魔法命中+13
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "魔法命中: +13"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.SP += 1;                   //SP+1
                                                            //祝福消耗効率+5%
                            buff.HIT_MAGIC += 14;           //魔法命中+14
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "魔法命中: +14"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.SP += 1;                   //SP+1
                                                            //祝福消耗効率+5%
                            buff.HIT_MAGIC += 15;           //魔法命中+15
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "魔法命中: +15"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case D:
                                //LV55
                    buff.AC -= 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "AC: -3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.MP += 30;                  //最大MP+30
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2: //LV80
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
                        case 3: //LV85
                            buff.MP += 30;                  //最大MP+30
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 5;  //精霊命中+5
                                                            //PVP魔法ダメージ減少+2%
                                                            //エリクサーブースター効果
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "エリクサーブースター効果"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4: //LV90
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
                        case 5: //LV91
                            buff.MP += 30;                  //最大MP+30
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 11; //精霊命中+11
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +11"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.MP += 30;                  //最大MP+30
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 12; //精霊命中+12
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +12"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.MP += 30;                  //最大MP+30
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 13; //精霊命中+13
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +13"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.MP += 30;                  //最大MP+30
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 14; //精霊命中+14
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +14"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.MP += 30;                  //最大MP+30
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SPIRIT] += 15; //精霊命中+15
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "最大MP: +30"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "精霊命中: +15"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case R:
                                //LV55
                    buff.HIT_SHORT += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "近距離命中: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.DR += 1;                   //ダメージ低下+1
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2: //LV80
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
                        case 3: //LV85
                            buff.DR += 1;                   //ダメージ低下+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 5;  //秘技命中+5
                                                            //PVP魔法ダメージ減少+2%
                                                            //エリクサーブースター効果
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "エリクサーブースター効果"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4: //LV90
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
                        case 5: //LV91
                            buff.DR += 1;                   //ダメージ低下+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 11; //秘技命中+11
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +11"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.DR += 1;                   //ダメージ低下+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 12; //秘技命中+12
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +12"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.DR += 1;                   //ダメージ低下+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 13; //秘技命中+13
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +13"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.DR += 1;                   //ダメージ低下+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 14; //秘技命中+14
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +14"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.DR += 1;                   //ダメージ低下+1
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 15; //秘技命中+15
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "ダメージ低下: +1"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +15"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case I:
                                //LV55
                    buff.r_weight += 0.12;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "所持重量増加: +300"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.HP += 50;                  //最大HP+50
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2: //LV80
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
                        case 3: //LV85
                            buff.HP += 50;                  //最大HP+50
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 5;  //秘技命中+5
                                                            //PVP魔法ダメージ減少+2%
                                                            //エリクサーブースター効果
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "エリクサーブースター効果"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4: //LV90
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
                        case 5: //LV91
                            buff.HP += 50;                  //最大HP+50
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 11; //秘技命中+11
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +11"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.HP += 50;                  //最大HP+50
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 12; //秘技命中+12
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +12"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.HP += 50;                  //最大HP+50
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 13; //秘技命中+13
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +13"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.HP += 50;                  //最大HP+50
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 14; //秘技命中+14
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +14"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.HP += 50;                  //最大HP+50
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_SECRET] += 15; //秘技命中+15
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "所持重量増加: +300"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "秘技命中: +15"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case S:
                                //LV55
                    buff.HP += 50;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "最大HP: +50"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.MR += 5;                   //MR+5%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2: //LV80
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
                        case 3: //LV85
                            buff.MR += 5;                   //MR+5%
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 5;  //恐怖命中+5
                                                            //PVP魔法ダメージ減少+2%
                                                            //エリクサーブースター効果
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "エリクサーブースター効果"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4: //LV90
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
                        case 5: //LV91
                            buff.MR += 5;                   //MR+5%
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 11; //恐怖命中+11
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +11"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.MR += 5;                   //MR+5%
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 12; //恐怖命中+12
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +12"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.MR += 5;                   //MR+5%
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 13; //恐怖命中+13
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +13"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.MR += 5;                   //MR+5%
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 14; //恐怖命中+14
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +14"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.MR += 5;                   //MR+5%
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 15; //恐怖命中+15
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "最大HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +15"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case F:
                                //LV55
                    buff.DR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "DR: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.HIT_SHORT += 3;            //近距離命中+3
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2: //LV80
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
                        case 3: //LV85
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 5;  //恐怖命中+5
                                                            //PVP魔法ダメージ減少+2%
                                                            //エリクサーブースター効果
                            ui.elixir_rune.setToolTipText("<html>"+  "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "エリクサーブースター効果"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4: //LV90
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
                        case 5: //LV91
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 11; //恐怖命中+11
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +11"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 12; //恐怖命中+12
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +12"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 13; //恐怖命中+13
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +13"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 14; //恐怖命中+14
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +14"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 15; //恐怖命中+15
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +15"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case L:
                                //LV55
                    buff.DR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                  + "<br>"+ "DR: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.HIT_SHORT += 3;            //近距離命中+3
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 2: //LV80
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
                        case 3: //LV85
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 5;  //恐怖命中+5
                                                            //PVP魔法ダメージ減少+2%
                                                            //エリクサーブースター効果
                            ui.elixir_rune.setToolTipText("<html>"+  "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +5"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +2%"
                                                          + "<br>"+ "エリクサーブースター効果"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 4: //LV90
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
                        case 5: //LV91
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 11; //恐怖命中+11
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +11"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 12; //恐怖命中+12
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +12"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 13; //恐怖命中+13
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +13"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 14; //恐怖命中+14
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +14"
                                                          + "<br>"+ "PVP魔法ダメージ減少: +3%"
                                                          + "<br>"+ "材質: 鉱石"
                                                          + "<br>"+ "重さ: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.HIT_SHORT += 3;            //近距離命中+3
                                                            //祝福消耗効率+5%
                            buff.ailment[HIT_TERROR] += 15; //恐怖命中+15
                                                            //PVP魔法ダメージ減少+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "ステ: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "近距離命中: +3"
                                                          + "<br>"+ "祝福消耗効率: +5%"
                                                          + "<br>"+ "恐怖命中: +15"
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
        }else if (e == 16){                             //英雄の遺物
                    buff.MEXP += 2;                     //EXP+2%
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //近距離ダメージ+2
                    buff.DMG_LONG += 2;                 //遠距離ダメージ+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_SHORT += 2;                //近距離命中+2
                    buff.HIT_LONG += 2;                 //遠距離命中+2
                    buff.HIT_MAGIC += 2;                //魔法命中+2
                    ui.elixir_rune.setToolTipText("<html>"+ "獲得経験値: +2%"
                                                  + "<br>"+ "AC: -3"
                                                  + "<br>"+ "近距離ダメージ: +2"
                                                  + "<br>"+ "遠距離ダメージ: +2"
                                                  + "<br>"+ "SP: +2"
                                                  + "<br>"+ "近距離命中: +2"
                                                  + "<br>"+ "遠距離命中: +2"
                                                  + "<br>"+ "魔法命中: +2"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 17){                             //強化された英雄の遺物(腕力)
                    buff.MEXP += 10;                    //獲得経験値+10%
                    buff.AC -= 4;                       //AC-4
                    buff.ST[STR] += 1;                  //STR+1
                    buff.DMG_SHORT += 4;                //近距離ダメージ+4
                    buff.HIT_SHORT += 6;                //近距離命中+6
                                                        //祝福消耗効率+5%
                                                        //全耐性+3
                    buff.ailment[STUN] += 3;            //技術耐性+3
                    buff.ailment[SPIRIT] += 3;          //精霊耐性+3
                    buff.ailment[SECRET] += 3;          //秘儀耐性+3
                    buff.ailment[TERROR] += 3;          //恐怖耐性+3
                    ui.elixir_rune.setToolTipText("<html>"+ "獲得経験値: +10%"
                                                  + "<br>"+ "AC: -4"
                                                  + "<br>"+ "STR: +1"
                                                  + "<br>"+ "近距離ダメージ: +4"
                                                  + "<br>"+ "近距離命中: +6"
                                                  + "<br>"+ "祝福消耗効率: +5%"
                                                  + "<br>"+ "技術耐性: +3"
                                                  + "<br>"+ "精霊耐性: +3"
                                                  + "<br>"+ "秘技耐性: +3"
                                                  + "<br>"+ "恐怖耐性: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 18){                             //強化された英雄の遺物(知力)
                    buff.MEXP += 10;                    //獲得経験値+10%
                    buff.AC -= 4;                       //AC-4
                    buff.ST[INT] += 1;                  //INT+1
                    buff.SP += 4;                       //SP+4
                    buff.HIT_MAGIC += 6;                //魔法命中+6
                                                        //祝福消耗効率+5%
                                                        //全耐性+3
                    buff.ailment[STUN] += 3;            //技術耐性+3
                    buff.ailment[SPIRIT] += 3;          //精霊耐性+3
                    buff.ailment[SECRET] += 3;          //秘儀耐性+3
                    buff.ailment[TERROR] += 3;          //恐怖耐性+3
                    ui.elixir_rune.setToolTipText("<html>"+ "獲得経験値: +10%"
                                                  + "<br>"+ "INT: +1"
                                                  + "<br>"+ "SP: +4"
                                                  + "<br>"+ "魔法命中: +6"
                                                  + "<br>"+ "祝福消耗効率: +5%"
                                                  + "<br>"+ "技術耐性: +3"
                                                  + "<br>"+ "精霊耐性: +3"
                                                  + "<br>"+ "秘技耐性: +3"
                                                  + "<br>"+ "恐怖耐性: +3"
                                                  + "<br>"+ "材質: 鉱石"
                                                  + "<br>"+ "重さ: 1"+"</html>");
        }else if (e == 19){                             //強化された英雄の遺物(機敏)
                    buff.MEXP += 10;                    //獲得経験値+10%
                    buff.AC -= 4;                       //AC-4
                    buff.ST[DEX] += 1;                  //DEX+1
                    buff.DMG_LONG += 4;                 //遠距離ダメージ+4
                    buff.HIT_LONG += 6;                 //遠距離命中+6
                                                        //祝福消耗効率+5%
                                                        //全耐性+3
                    buff.ailment[STUN] += 3;            //技術耐性+3
                    buff.ailment[SPIRIT] += 3;          //精霊耐性+3
                    buff.ailment[SECRET] += 3;          //秘儀耐性+3
                    buff.ailment[TERROR] += 3;          //恐怖耐性+3
                    ui.elixir_rune.setToolTipText("<html>"+ "獲得経験値: +10%"
                                                  + "<br>"+ "DEX: +1"
                                                  + "<br>"+ "遠距離ダメージ: +4"
                                                  + "<br>"+ "遠距離命中: +6"
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
            acc *= acc_1;
        }

        ui.cb_buff[ACC2].setToolTipText("<html>"+ "x1.3333:BP イビルブラッド ブラッドラスト 名誉のコイン ダンシングブレイズ フォーカスウェーブ ハリケーン サンドストーム"
                                        + "<br>"+ "x1.1547:EW 濃縮集中ポーション ムービングアクセレーション:マキシマム"
                                        + "<br>"+ "x1.0800:ダークホース"+"</html>");
        if (ui.cb_buff[ACC2].isSelected()) {
            switch (ui.cb_buff_group[ACC2].getSelectedIndex()) {
                case 0:
                    ui.cb_buff[ACC2].setToolTipText("x1.3333:BP イビルブラッド ブラッドラスト 名誉のコイン ダンシングブレイズ フォーカスウェーブ ハリケーン サンドストーム");
                    acc *= acc_2;
                    break;
                case 1:
                    ui.cb_buff[ACC2].setToolTipText("x1.1547:EW 濃縮集中ポーション ムービングアクセレーション:マキシマム");
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

        ui.cb_buff[ACC3].setToolTipText("x1.1250:ドラゴンブラッド 生命のパール 蔵出し秘蔵酒");
        if (ui.cb_buff[ACC3].isSelected()) {
            acc *= acc_3;
        }

        ui.cb_buff[ACC4].setToolTipText("x1.1000:マジックドールの潜在力");
        if (ui.cb_buff[ACC4].isSelected()) {
            acc *= acc_4;
        }

        ui.cb_buff[ACC5].setToolTipText("x1.1000:騎士技術(レイジング ウェポン)");
        if (ui.cb_buff[ACC5].isSelected()) {
            acc *= acc_5;
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
                    break;
                case 1://エンチャントウェポン 近距離ダメージ+2(キャラに対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+2 エンチャントウェポン(キャラに対して)");
                    buff.DMG_SHORT += 2;
                    break;
                case 2://ブレスウェポン 近距離ダメージ+2 近距離命中+2(キャラに対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+2 近距離命中+2 ブレスウェポン(キャラに対して)");
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    break;
                case 3://シャドウファング 近距離ダメージ+5(キャラに対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+5 シャドウファング(キャラに対して)");
                    buff.DMG_SHORT += 5;
                    break;
                case 4://ホーリーウェポン 近距離ダメージ+1 近距離命中+1(武器に対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+1 近距離命中+1 ホーリーウェポン(武器に対して)");
                    buki.magic_enchant = 1;
                    buki2.magic_enchant = 1;
                    buff.HIT_SHORT += 1;
                    break;
                case 5://エンチャントウェポン 近距離ダメージ+2(武器に対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+2 エンチャントウェポン(武器に対して)");
                    buki.magic_enchant = 2;
                    buki2.magic_enchant = 2;
                    break;
                case 6://ブレスウェポン 近距離ダメージ+2 近距離命中+2(武器に対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+2 近距離命中+2 ブレスウェポン(武器に対して)");
                    buki.magic_enchant = 2;
                    buki2.magic_enchant = 2;
                    buff.HIT_SHORT += 2;
                    break;
                case 7://シャドウファング 近距離ダメージ+5(武器に対して)
                    ui.cb_buff[BUKI].setToolTipText("近距離ダメージ+5 シャドウファング(武器に対して)");
                    buki.magic_enchant = 5;
                    buki2.magic_enchant = 5;
                    break;
                default:
                    break;
            }
        }

//君主魔法（プリンス・プリンセス)
        //プライム
        ui.cb_buff[P_PRE].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "画面内の血盟員に強力なバフを付与 技術命中+5(術者のみ)"
                                         + "<br>"+ "近距離ダメージ+3 近距離命中+3 遠距離ダメージ+3 遠距離命中+3 SP+2 魔法命中+2"
                                         + "<br>"+ "レベル85から、レベル5毎にPVPダメージ低下+5(最大+15)"
                                         + "<br>"+ "攻城戦ではバフの効果が3倍になり最大HP+500が追加される"
                                         + "<br>"+ "PVPダメージ低下を追加"
                                         + "<br>"+ "[習得レベル:85][持続時間:20分][対象:血盟員][触媒:結晶体(200)]"+"</html>");
        if (ui.cb_buff[P_PRE].isSelected()) {
            //PVPダメージ低下+5(レベル85から、レベル5毎にPVPダメージ低下+5(最大+15))
            if (level >= 90) {
                buff.PVP_DR += 15;
            } else if (level >= 85) {
                buff.PVP_DR += 10;
            } else if (level >= 80) {
                buff.PVP_DR += 5;
            }
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

        //コールクラン アドバンス
        ui.cb_buff[P_CCA].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "8セル内のPTを組んだ血盟員1人を術者の周囲に召喚する"
                                         + "<br>"+ "対象が状態異常でも召喚可能　壁越し召喚は不可能"
                                         + "<br>"+ "個別クールタイム適用"
                                         + "<br>"+ "[習得レベル:90][持続時間:瞬間][対象:血盟員][触媒:結晶体(200)]"+"</html>");
        if (ui.cb_buff[P_CCA].isSelected()) {
        //スキル効果未実装
        }

        //エンパイア
        ui.cb_buff[P_EME].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "1セル内の対象にダメージを与え、一定確率でスタン状態にする"
                                         + "<br>"+ "ディレイ6秒"
                                         + "<br>"+ "[習得レベル:80][持続時間:最大6秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[P_EME].isSelected()) {
        //スキル効果未実装
        }

        //グレース
        ui.cb_buff[P_GRE].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "18セル内のPTメンバーに全スキル耐性+1"
                                         + "<br>"+ "レベル80からレベル1毎に効果が+1ずつ増加[最大+15]"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "レベル80 技術耐性+1 精霊耐性+1 秘技耐性+1 恐怖耐性+1"
                                         + "<br>"+ "レベル84 技術耐性+5 精霊耐性+5 秘技耐性+5 恐怖耐性+5"
                                         + "<br>"+ "レベル94+ 技術耐性+15 精霊耐性+15 秘技耐性+15 恐怖耐性+15"
                                         + "<br>"+ "持続時間60秒　消費MP30"
                                         + "<br>"+ "[習得レベル:80][持続時間:1分][対象:PTメンバー]"+"</html>");
        if (ui.cb_buff[P_GRE].isSelected()) {
            switch ((String) ui.cb_buff_group[P_GRE].getSelectedItem()) {
                case "君主L80":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+1 精霊耐性+1 秘技耐性+1 恐怖耐性+1");
                    buff.ailment[STUN] += 1;
                    buff.ailment[SPIRIT] += 1;
                    buff.ailment[SECRET] += 1;
                    buff.ailment[TERROR] += 1;
                    break;
                case "君主L81":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+2 精霊耐性+2 秘技耐性+2 恐怖耐性+2");
                    buff.ailment[STUN] += 2;
                    buff.ailment[SPIRIT] += 2;
                    buff.ailment[SECRET] += 2;
                    buff.ailment[TERROR] += 2;
                    break;
                case "君主L82":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+3 精霊耐性+3 秘技耐性+3 恐怖耐性+3");
                    buff.ailment[STUN] += 3;
                    buff.ailment[SPIRIT] += 3;
                    buff.ailment[SECRET] += 3;
                    buff.ailment[TERROR] += 3;
                    break;
                case "君主L83":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+4 精霊耐性+4 秘技耐性+4 恐怖耐性+4");
                    buff.ailment[STUN] += 4;
                    buff.ailment[SPIRIT] += 4;
                    buff.ailment[SECRET] += 4;
                    buff.ailment[TERROR] += 4;
                    break;
                case "君主L84":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+5 精霊耐性+5 秘技耐性+5 恐怖耐性+5");
                    buff.ailment[STUN] += 5;
                    buff.ailment[SPIRIT] += 5;
                    buff.ailment[SECRET] += 5;
                    buff.ailment[TERROR] += 5;
                    break;
                case "君主L85":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+6 精霊耐性+6 秘技耐性+6 恐怖耐性+6");
                    buff.ailment[STUN] += 6;
                    buff.ailment[SPIRIT] += 6;
                    buff.ailment[SECRET] += 6;
                    buff.ailment[TERROR] += 6;
                    break;
                case "君主L86":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+7 精霊耐性+7 秘技耐性+7 恐怖耐性+7");
                    buff.ailment[STUN] += 7;
                    buff.ailment[SPIRIT] += 7;
                    buff.ailment[SECRET] += 7;
                    buff.ailment[TERROR] += 7;
                    break;
                case "君主L87":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+8 精霊耐性+8 秘技耐性+8 恐怖耐性+8");
                    buff.ailment[STUN] += 8;
                    buff.ailment[SPIRIT] += 8;
                    buff.ailment[SECRET] += 8;
                    buff.ailment[TERROR] += 8;
                    break;
                case "君主L88":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+9 精霊耐性+9 秘技耐性+9 恐怖耐性+9");
                    buff.ailment[STUN] += 9;
                    buff.ailment[SPIRIT] += 9;
                    buff.ailment[SECRET] += 9;
                    buff.ailment[TERROR] += 9;
                    break;
                case "君主L89":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+10 精霊耐性+10 秘技耐性+10 恐怖耐性+10");
                    buff.ailment[STUN] += 10;
                    buff.ailment[SPIRIT] += 10;
                    buff.ailment[SECRET] += 10;
                    buff.ailment[TERROR] += 10;
                    break;
                case "君主L90":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+11 精霊耐性+11 秘技耐性+11 恐怖耐性+11");
                    buff.ailment[STUN] += 11;
                    buff.ailment[SPIRIT] += 11;
                    buff.ailment[SECRET] += 11;
                    buff.ailment[TERROR] += 11;
                    break;
                case "君主L91":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+12 精霊耐性+12 秘技耐性+12 恐怖耐性+12");
                    buff.ailment[STUN] += 12;
                    buff.ailment[SPIRIT] += 12;
                    buff.ailment[SECRET] += 12;
                    buff.ailment[TERROR] += 12;
                    break;
                case "君主L92":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+13 精霊耐性+13 秘技耐性+13 恐怖耐性+13");
                    buff.ailment[STUN] += 13;
                    buff.ailment[SPIRIT] += 13;
                    buff.ailment[SECRET] += 13;
                    buff.ailment[TERROR] += 13;
                    break;
                case "君主L93":
                    ui.cb_buff[P_GRE].setToolTipText("技術耐性+14 精霊耐性+14 秘技耐性+14 恐怖耐性+14");
                    buff.ailment[STUN] += 14;
                    buff.ailment[SPIRIT] += 14;
                    buff.ailment[SECRET] += 14;
                    buff.ailment[TERROR] += 14;
                    break;
                case "君主L94+":
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

        //マジェスティ
        ui.cb_buff[P_MAY].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "ダメージ低下+2"
                                         + "<br>"+ "レベル80から、レベル2毎に[ダメージ低下+1]"
                                         + "<br>"+ "[習得レベル:80][持続時間:10分][対象:術者]"+"</html>");
        if (ui.cb_buff[P_MAY].isSelected()) {
            //DR+2(レベル80から2つレベルが上がる毎に+1)
            if (level <= 80) {
                buff.DR += 2;
            } else if (level > 80) {
                buff.DR += 2+(level/2-40);
            }
        }

        //シャイニングアーマー
        ui.cb_buff[P_SAR].setToolTipText("<html>"+ "[消費MP:30][消費HP:50]"
                                         + "<br>"+ "ER+10"
                                         + "<br>"+ "[習得レベル:80][持続時間:10分][対象:術者]"+"</html>");
        if (ui.cb_buff[P_SAR].isSelected()) {
            buff.ER += 10;
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

        //ブレイブメンタル
        //6213行にて処理
        
        //グローイングウェポン
        ui.cb_buff[P_GWN].setToolTipText("<html>"+ "[消費MP:25][消費HP:--]"
                                         + "<br>"+ "近距離ダメージ+5 近距離命中+5"
                                         + "<br>"+ "[習得レベル:60][持続時間:10分40秒][対象:術者]"+"</html>");
        if (ui.cb_buff[P_GWN].isSelected()) {
            buff.HIT_SHORT += 5;
            buff.DMG_SHORT += 5;
        }

        //トゥルーターゲット(未実装)
        ui.cb_buff[P_TTT].setToolTipText("<html>"+ "[消費MP:1][消費HP:--]"
                                         + "<br>"+ "画面内に居る対象を指定して、血盟員/PTメンバーに強調する"
                                         + "<br>"+ "血盟員/PTメンバーは、指定したプレイヤーへのダメージが1%増加"
                                         + "<br>"+ "レベル15毎に[ダメージ+1%]"
                                         + "<br>"+ "沈黙状態でも詠唱可能"
                                         + "<br>"+ "[習得レベル:50][持続時間:16秒][対象:PC/NPC]"+"</html>");
        if (ui.cb_buff[P_TTT].isSelected()) {
        //スキル効果未実装
        }

        //オーラ
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
                    break;
                case 1://ファイヤーシールド 	AC-4	消費MP15 魔法レベル3 継続時間960秒
                    ui.cb_buff[B_AC].setToolTipText("AC-4 ファイヤーシールド");
                    buff.AC += -4;
                    break;
                case 2://四季のポーション 	AC-5      
                    ui.cb_buff[B_AC].setToolTipText("AC-5 四季のポーション");
                    buff.AC += -5;
                    break;
                case 3://アイアンスキン          AC-10	消費MP30 魔法レベル5 継続時間960秒
                    ui.cb_buff[B_AC].setToolTipText("AC-10 アイアンスキン");
                    buff.AC += -10;
                    break;
                default:
                    break;
            }
        }

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
        //STR+1[君主][ナイト][ダークエルフ][ドラゴンナイト][ウォリアー][フェンサー][ランサー]
        //DEX+1[エルフ]
        //INT+1[ウィザード][イリュージョニスト]
        ui.cb_buff[H_RK].setToolTipText("<html>"+ "STR+1[君主][ナイト][ダークエルフ][ドラゴンナイト][ウォリアー][フェンサー][ランサー]"
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
                case L:
                    ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;
                default:
                    break;
            }
        }
        
        //クラス加護
        ui.cb_buff[H_RKT].setToolTipText("<html>"+ "クラス別全サーバー総合1位"
                                         + "<br>"+ "3,600秒ごとに1回の使用が可能"
                                         + "<br>"+ "コスト:結晶1,000個"
                                         + "<br>"+ "HP+200 PVPダメージ減少+10 [600秒]"+"</html>");
        if (ui.cb_buff[H_RKT].isSelected()) {
                    ui.cb_buff[H_RKT].setToolTipText("HP+200 PVPダメージ減少+10 [600秒]");
                    buff.HP += 200;
                    buff.PVP += 10;
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

//各ステータスの上限値
//STR:
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
        if (pure_str >= 55) {
            base_dmg_short += 5;                //近距離ダメージ+5
            base_hit_short += 5;                //近距離命中+5
            cri_short += 2;                     //近距離クリティカル+2%
        }
        if (pure_str >= 60) {
            base_dmg_short += 5;                //近距離ダメージ+5
            base_hit_short += 5;                //近距離命中+5
            cri_short += 2;                     //近距離クリティカル+2%
        }

//DEX:
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
        if (pure_dex >= 55) {
            base_dmg_long += 5;                 //遠距離ダメージ+5
            base_hit_long += 5;                 //遠距離命中+5
            cri_long += 2;                      //遠距離クリティカル+2%
        }
        if (pure_dex >= 60) {
            base_dmg_long += 5;                 //遠距離ダメージ+5
            base_hit_long += 5;                 //遠距離命中+5
            cri_long += 2;                      //遠距離クリティカル+2%
        }

//INT:
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
        if (pure_int >= 55) {
            base_dmg_magic += 5;                //魔法ダメージ+5
            base_hit_magic += 5;                //魔法命中+5
            cri_magic += 2;                     //魔法クリティカル+2%
        }
        if (pure_int >= 60) {
            base_dmg_magic += 5;                //魔法ダメージ+5
            base_hit_magic += 5;                //魔法命中+5
            cri_magic += 2;                     //魔法クリティカル+2%
        }

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
        cri_short += buki.op.CRI_SHORT + buki.op2.CRI_SHORT + buff.CRI_SHORT;
        cri_long += buki.op.CRI_LONG + buki.op2.CRI_LONG + buff.CRI_LONG;
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
            case L:
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

        buki.arrow_hit=0;

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

buki.arrow_elementdmg=0;

        for (Bougu bougu1 : bougu) {
            hit_short += bougu1.op.HIT_SHORT + bougu1.op2.HIT_SHORT;
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
                        magic_main = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), MAIN);
                        magic_sub = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), SUB);
                        break;
        //Hero変身時処理
                    case 16:
                        speed = polymorph.getSpeed(99, ui.cb_morph_type.getSelectedIndex(), W_DA);
                        magic_main = polymorph.getSpeed(99, ui.cb_morph_type.getSelectedIndex(), MAIN);
                        magic_sub = polymorph.getSpeed(99, ui.cb_morph_type.getSelectedIndex(), SUB);
                        break;
                    default:
                        int l = Integer.parseInt((String) ui.cb_morph_level.getSelectedItem());
                        speed = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), W_DA);
                        magic_main = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), MAIN);
                        magic_sub = polymorph.getSpeed(l, ui.cb_morph_type.getSelectedIndex(), SUB);
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
        //Hero変身時処理
                            case 16:
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
                        dmg_big_ave = (1.0 + buki.big) / 2 + buki.arrow_dmg + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
                        dmg_small_ave = (1.0 + buki.small) / 2 + buki.arrow_dmg + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;

                        dmg_big_max = buki.arrow_dmg + buki.big + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
                        dmg_small_max = buki.arrow_dmg + buki.small + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;

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
                //イーグルアイ
//                cri_long += cr * 100;
                ui.cb_buff[E_EEE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                                 + "<br>"+ "弓専用スキル"
                                                 + "<br>"+ "遠距離クリティカル+2%"
                                                 + "<br>"+ "キャンセレーションで解除されない"
                                                 + "<br>"+ "[習得レベル:45][持続時間:2分8秒][対象:術者][触媒:精霊の玉(1)]"+"</html>");
                if (ui.cb_buff[E_EEE].isSelected()) {
                    cri_long += 2;
                }
                dmg_big_ave = (cri_long * 0.01) * dmg_big_max
                        + (1.0 - cri_long * 0.01) * dmg_big_ave;
                dmg_small_ave = (cri_long * 0.01) * dmg_small_max
                        + (1.0 - cri_long * 0.01) * dmg_small_ave;
                break;
            default:

                //エルフ ソウルオブフレイム
                cri_short += cr * 100;
                ui.cb_buff[E_SOF].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                                 + "<br>"+ "装備している武器の最大ダメージで攻撃する"
                                                 + "<br>"+ "武器が損傷しなくなる"
                                                 + "<br>"+ "[習得レベル:80][持続時間:5分20秒][対象:術者][触媒:精霊の玉(5)]"+"</html>");
                if (ui.cb_buff[E_SOF].isSelected()) {
                    cri_short = 100;
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
        //ダブルブレイク:デスティニー
        ui.cb_buff[D_DBD].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "ダブルブレイクの発動率上昇"
                                         + "<br>"+ "80レベルから1レベル毎に発動確率1%増加"
                                         + "<br>"+ "[習得レベル:80][持続時間:3分12秒][対象:術者]"+"</html>");
        if (ui.cb_buff[D_DBK].isSelected()) {
            if (buki_id == W_DB || buki_id == W_C) {
                db2_lv_bonus = 0;
                        if (ui.cb_buff[D_DBD].isSelected()) {
                            if (level >= 80 && cls == D) {
                            db2_lv_bonus =((level - 79) * 0.01);
                            } else {
                            ui.cb_buff[D_DBD].setSelected(false);
                            }
                        }
                db_lv_bonus = ((level - 45) / 5) * 0.01;

                dmg_big_ave *= 2.0 * (db_rate + db_lv_bonus + db2_lv_bonus)
                        + (1.0 - (db_rate + db_lv_bonus + db2_lv_bonus));
                dmg_small_ave *= 2.0 * (db_rate + db_lv_bonus + db2_lv_bonus)
                        + (1.0 - (db_rate + db_lv_bonus + db2_lv_bonus));

                dmg_undead *= 2.0 * (db_rate + db_lv_bonus + db2_lv_bonus)
                        + (1.0 - (db_rate + db_lv_bonus + db2_lv_bonus));
                dmg_cursed *= 2.0 * (db_rate + db_lv_bonus + db2_lv_bonus)
                        + (1.0 - (db_rate + db_lv_bonus + db2_lv_bonus));
            } else {
                //ui.cb_buff[D_DBK].setSelected(false);
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

        //イリュージョン[アバター]
        ui.cb_buff[I_IAR].setToolTipText("<html>"+ "[消費MP:50][消費HP:--]"
                                         + "<br>"+ "近距離ダメージ+10 遠距離ダメージ+10 魔法ダメージ+10"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:60][持続時間:2分8秒][対象:術者]"+"</html>");
        if (ui.cb_buff[I_IAR].isSelected()) {
            dmg_big_ave += 10;
            dmg_small_ave += 10;
        }

        //キューブ[アバター]
        ui.cb_buff[I_CAR].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                         + "<br>"+ "15セル内のPTメンバーに近距離ダメージ+10 遠距離ダメージ+10 魔法ダメージ+10 被ダメージ+5%"
                                         + "<br>"+ "[習得レベル:60][持続時間:2分8秒][対象:PT][触媒:属性石(5)]"+"</html>");
        if (ui.cb_buff[I_CAR].isSelected()) {
            dmg_big_ave += 10;
            dmg_small_ave += 10;
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
                                         + "<br>"+ "近距離攻撃時に一定確率(15→20%?)で追加ダメージを与える"
                                         + "<br>"+ "[レベル]/[2]を与える"
                                         + "<br>"+ "[習得レベル:45][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[S_CRH].isSelected()) {
            ex = level / 2.0;
        }

        //フューリー
        ui.cb_buff[S_FUY].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "クラッシュ発動時に一定確率(10→15%?)でダメージ3倍を与える"
                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[S_FUY].isSelected()) {
            dmg_big_ave = 0.20 * 0.15 * 3.0 * (dmg_big_ave + ex)
                    + (0.20 - (0.20 * 0.15)) * (dmg_big_ave + ex)
                    + (1.0 - 0.20) * dmg_big_ave;

            dmg_small_ave = 0.20 * 0.15 * 3.0 * (dmg_small_ave + ex)
                    + (0.20 - (0.20 * 0.15)) * (dmg_small_ave + ex)
                    + (1.0 - 0.20) * dmg_small_ave;
            ex = 0.0;

            dmg_undead *= (1 - 0.20 * 0.15) + 0.20 * 0.15 * 3.0;
            dmg_cursed *= (1 - 0.20 * 0.15) + 0.20 * 0.15 * 3.0;
        }
        dmg_big_ave += ex * 0.20;
        dmg_small_ave += ex * 0.20;

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

        //バーニング スピリッツ
       ui.cb_buff[D_BSS].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                        + "<br>"+ "一定確率(33%)で近距離ダメージ1.5倍"
                                        + "<br>"+ "パッシブ魔法"
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
            }
        }

       //エレメンタルファイアー
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

        //クエイク
        ui.cb_buff[E_QUE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
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
            }
        }

        //サイクロン
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
            } else {
                ui.cb_buff[E_CYE].setSelected(false);
            }
        }
         
        //ブレイブメンタル
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
            } else {
                ui.cb_buff[P_BML].setSelected(false);
            }
        }

        //レイジ
        ui.cb_buff[F_PRE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "一定確率(暫定18%)で近距離ダメージ(暫定1.5倍)"
                                         + "<br>"+ "[習得レベル:60][持続時間:常時][対象:術者]"+"</html>");
        if (ui.cb_buff[F_PRE].isSelected()) {
            if (!(buki.type.equals("ボウ") || buki.type.equals("ガントレット"))) {
                dmg_big_ave *= 1.5 * re_rate
                        + 1.0 * (1.0 - re_rate);
                dmg_small_ave *= 1.5 * re_rate
                        + 1.0 * (1.0 - re_rate);

                dmg_big_ave -= 0.25 * re_rate;
                dmg_small_ave -= 0.25 * re_rate;

                dmg_undead *= 1.5 * re_rate
                        + 1.0 * (1.0 - re_rate);
                dmg_cursed *= 1.5 * re_rate
                        + 1.0 * (1.0 - re_rate);

                if (dmg_undead != 0) {
                    dmg_undead -= 0.25 * re_rate;
                }
                if (dmg_cursed != 0) {
                    dmg_cursed -= 0.25 * re_rate;
                }
            } else {
                ui.cb_buff[F_PRE].setSelected(false);
            }
        }

        //ブローアタック
        ui.cb_buff[K_BLK].setToolTipText("<html>"+ "[消費MP:10][消費HP:50]"
                                         + "<br>"+ "一定確率で近距離ダメージを1.5倍"
                                         + "<br>"+ "LV75からLV1毎に発動率1%増加"
                                         + "<br>"+ "LV90からLV1毎に追加発動率1%増加"
                                         + "<br>"+ "[近距離武器技術]"
                                         + "<br>"+ "[習得レベル:75][持続時間:5分][対象:術者]"+"</html>");
        if (ui.cb_buff[K_BLK].isSelected()) {
            if (level >= 90) {
            //LV90以上の場合
                bk_lv_bonus =((level - 74) * 0.01)+((level - 89) * 0.01);
            } else if (level >= 75) {
            //LV75以上LV90未満
                bk_lv_bonus =((level - 74) * 0.01);
            }

            if (level >= 75 && cls == K && buki_id == W_D || buki_id == W_LS || buki_id == W_TS || buki_id == W_A|| buki_id == W_L) {
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

                dmg_small_ave += (dmg - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * (dmg_rate / 100.0);
                dmg_big_ave += (dmg - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * (dmg_rate / 100.0);
            }
        }

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
            case L:
                c = 6;
//                d = 3;
                break;
            default:
                break;
        }
        base_ac = 10 - (int) (dex / 3) - (int) (level / c);

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

        //アーマーガード
        ui.cb_buff[S_AGD].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
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

        //アンキャニードッジ
        ui.cb_buff[D_UDE].setToolTipText("<html>"+ "[消費MP:40][消費HP:--]"
                                         + "<br>"+ "近距離回避[DG]+30 AC-100以上だとエフェクトが黄金に変化"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:60][持続時間:16分][対象:術者][触媒:ダークストーン(1)]"+"</html>");
        if (ui.cb_buff[D_UDE].isSelected()) {
            dg += 30;
        }

        //ミラーイメージ
        ui.cb_buff[I_MIE].setToolTipText("<html>"+ "[消費MP:20][消費HP:--]"
                                         + "<br>"+ "近距離回避[DG]+30"
                                         + "<br>"+ "キャンセレーションで解除されない"
                                         + "<br>"+ "[習得レベル:15][持続時間:20分][対象:術者]"+"</html>");
        if (ui.cb_buff[I_MIE].isSelected()) {
            dg += 30;
        }
        //覚醒[リンドビオル]
        ui.cb_buff[R_LINDVIOL].setToolTipText("<html>"+ "[消費MP:40][消費HP:10]"
                                              + "<br>"+ "近距離回避[DG]+10"
                                              + "<br>"+ "キャンセレーションで解除されない"
                                              + "<br>"+ "[習得レベル:80][持続時間:10分][対象:術者][触媒:刻印のボーンピース(1)]"+"</html>");
        if (ui.cb_buff[R_LINDVIOL].isSelected()) {
            dg += 10;
        }

        //インフィニティ:ドッジ
        ui.cb_buff[F_PIE].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
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
        //エルヴングラヴィティー
        ui.cb_buff[E_ELY].setToolTipText("<html>"+ "[消費MP:30][消費HP:--]"
                                         + "<br>"+ "所持重量増加+300"
                                         + "<br>"+ "ディクリースウェイトの上位魔法"
                                         + "<br>"+ "[習得レベル:75][持続時間:30分][対象:術者]"+"</html>");
        if (ui.cb_buff[E_ELY].isSelected()) {
            ui.cb_buff[W_DWT].setSelected(false);
            weight += 300;
        }

        //リデュースウェイト
        ui.cb_buff[I_RWT].setToolTipText("<html>"+ "[消費MP:50][消費HP:--]"
                                         + "<br>"+ "所持重量増加+480"
                                         + "<br>"+ "ディクリースウェイトの上位版なので重複不可能"
                                         + "<br>"+ "[習得レベル:60][持続時間:30分][対象:術者]"+"</html>");
        if (ui.cb_buff[I_RWT].isSelected()) {
            ui.cb_buff[W_DWT].setSelected(false);
            weight += 480;
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

//WIS:
        int tmp = (int) (wis / 5) + (int) (level / 40);
        mpr += tmp;
        if (pure_wis >= 25) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(1));
                mpr++;
            }
            mpr++;                          //MP回復+1
            tmp++;                          //MPポーション回復増加+1
                                            //最大MP+50は8448行目以降で処理
        }
        if (pure_wis >= 35) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(2));
                mpr++;
            }
            mpr++;                          //MP回復+1
            tmp++;                          //MPポーション回復増加+1
                                            //最大MP+100は8448行目以降で処理
        }
        if (pure_wis >= 45) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(5));
                mpr += 3;
            }
            mpr += 3;                       //MP回復+3
            tmp += 3;                       //MPポーション回復増加+3
                                            //最大MP+150は8448行目以降で処理
        }
        if (pure_wis >= 55) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(15));
                mpr += 5;
            }
            mpr += 5;                       //MP回復+5
            tmp += 5;                       //MPポーション回復増加+5
                                            //最大MP+200は8448行目以降で処理
        }
        if (pure_wis >= 60) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(20));
                mpr += 5;
            }
            mpr += 5;                       //MP回復+5
            tmp += 5;                       //MPポーション回復増加+5
                                            //最大MP+200は8448行目以降で処理
        }

        ui.pure_status_bonus[1][16].setText(Integer.toString(tmp));             //MP増加

//CON:
        hpr += (con / 2 + level / 20);
        hp_pot = (int) (minasToZero(con - 10) / 10);

        if (pure_con >= 25) {
            hpr++;                          //HP回復+1
                                            //最大HP+50は8438行目以降で処理
        }
        if (pure_con >= 35) {
            hpr++;                          //HP回復+1
            hp_pot++;                       //HPポーション回復増加+1%
                                            //最大HP+100は8438行目以降で処理
        }
        if (pure_con >= 45) {
            hpr += 3;                       //HP回復+3
            hp_pot += 2;                    //HPポーション回復増加+2%
                                            //最大HP+150は8438行目以降で処理
        }
        if (pure_con >= 55) {
            hpr += 5;                       //HP回復+5
            hp_pot += 4;                    //HPポーション回復増加+4%
                                            //最大HP+200は8438行目以降で処理
        }
        if (pure_con >= 60) {
            hpr += 5;                       //HP回復+5
            hp_pot += 4;                    //HPポーション回復増加+4%
                                            //最大HP+200は8438行目以降で処理
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
            case L:
                hp = 16;
                mp = 2;
                break;
            default:
                break;
        }

//種族が増えた場合配列を1つ増やす必要あり c1とc2の値が不明　mpの量を決定する為の値と思われる
//        double[] c1 = {1.0, 2.0 / 3.0, 1.5, 2.0, 1.5, 0.7, 1.7, 2.0 / 3.0};
//        int[] c2 = {1, 0, 1, 2, 1, 1, 1, 0};
//        double[] c1 = {1.0, 2.0 / 3.0, 1.5, 2.0, 1.5, 0.7, 1.7, 2.0 / 3.0, 2.0 / 3.0};
//        int[] c2 = {1, 0, 1, 2, 1, 1, 1, 0, 0};
        double[] c1 = {1.0, 2.0 / 3.0, 1.5, 2.0, 1.5, 0.7, 1.7, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0};
        int[] c2 = {1, 0, 1, 2, 1, 1, 1, 0, 0, 0};
        
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
        if (con >= 60) {
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
        if (wis >= 60) {
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
            case L:
                eq_hp += _ST[ENCHANT][CON] * 16;
                break;
            default:
                break;
        }

        int hpp = 0;
        int mpp = 0;

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
            }
        }

        //プライド
        ui.cb_buff[K_PRE].setToolTipText("<html>"+ "[消費MP:10][消費HP:100]"
                                         + "<br>"+ "最大HP LV/4% 増加"
                                         + "<br>"+ "[習得レベル:60][持続時間:5分][対象:術者]"+"</html>");
        if (ui.cb_buff[K_PRE].isSelected()) {
            if (ui.cb_buff[S_GIC].isSelected()
                    || ui.cb_buff[W_ADS].isSelected()) {
                ui.cb_buff[K_PRE].setSelected(false);
            } else {
           hpp += (level/4)*0.01 * hp;
            }
        }

        //ギガンティック
        ui.cb_buff[S_GIC].setToolTipText("<html>"+ "[消費MP:10][消費HP:--]"
                                         + "<br>"+ "最大HPを増加する"
                                         + "<br>"+ "[レベル]/[2]%"
                                         + "<br>"+ "[習得レベル:60][持続時間:10分][対象:術者][触媒:結晶体(100)]"+"</html>");
        if (ui.cb_buff[S_GIC].isSelected()) {
            if (ui.cb_buff[W_ADS].isSelected()
                    || ui.cb_buff[K_PRE].isSelected()) {
                ui.cb_buff[S_GIC].setSelected(false);
            } else {
            hpp += (level/2)*0.01 * hp;
            }
        }

        //インフィニティ:ブラッド
        ui.cb_buff[F_PID].setToolTipText("<html>"+ "[消費MP:--][消費HP:--]"
                                         + "<br>"+ "Passive"
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

        ui.lab_cons_mp.setText(Double.toString((int) (cons_mp * 100) / 100.0));
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
            buki_text += " 近距離ダメージ+" + buki.op.DMG_SHORT;
        }
        if (buki.op.DMG_LONG < 0) {
            buki_text += " 近距離ダメージ" + buki.op.DMG_LONG;
        }
        if (buki.op.HIT_SHORT > 0) {
            buki_text += " 近距離命中+" + (buki.op.HIT_SHORT + buki.op2.HIT_SHORT);
        }
        if (buki.op.HIT_SHORT < 0) {
            buki_text += " 近距離命中" + (buki.op.HIT_SHORT + buki.op2.HIT_SHORT);
        }
        if (buki.op.DMG_LONG > 0) {
            buki_text += " 遠距離ダメージ+" + buki.op.DMG_LONG;
        }
        if (buki.op.DMG_LONG < 0) {
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
