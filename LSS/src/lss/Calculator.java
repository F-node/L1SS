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
    int dg;                                                                     //�ߋ�������
    int er;                                                                     //����������
    int me;                                                                     //�m�����@����
    int mhp;                                                                    //�ő�HP+X%
    int mmp;                                                                    //�ő�MP+X%
    int mexp;                                                                   //�l���o���l+X%
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
        //�N��̏����X�e�[�^�X�Ɗ���U��\�X�e�[�^�X��
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
        //�i�C�g�̏����X�e�[�^�X�Ɗ���U��\�X�e�[�^�X��
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
        //�G���t�̏����X�e�[�^�X�Ɗ���U��\�X�e�[�^�X��
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
        //�E�B�U�[�h�̏����X�e�[�^�X�Ɗ���U��\�X�e�[�^�X��
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
        //�_�[�N�G���t�̏����X�e�[�^�X�Ɗ���U��\�X�e�[�^�X��
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
        //�h���S���i�C�g�̏����X�e�[�^�X�Ɗ���U��\�X�e�[�^�X��
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
        //�C�����[�W���j�X�g�̏����X�e�[�^�X�Ɗ���U��\�X�e�[�^�X��
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
        //�E�H���A�[�̏����X�e�[�^�X�Ɗ���U��\�X�e�[�^�X��
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
        //�t�F���T�[�̏����X�e�[�^�X�Ɗ���U��\�X�e�[�^�X��
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
        //�����T�[�̏����X�e�[�^�X�Ɗ���U��\�X�e�[�^�X��
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

        //�X�e�[�^�X�{�[�i�X
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

        //�e�E�̏���MR�C���p
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
    //1�i����(GP GGP ���C�� �E�C�X�L�[)
    double acc_1 = 1.3333;
    //2�i����(BP �C�r���u���b�h �u���b�h���X�g ���_�̃R�C�� �_���V���O�u���C�Y �t�H�[�J�X�E�F�[�u �n���P�[�� �T���h�X�g�[��)
    double acc_2 = 1.3333;
    //2�i����(EW �Z�k�W���|�[�V���� ���[�r���O�A�N�Z���[�V����:�}�L�V�}��)
    double acc_ew = 1.1547;
    //2�i����(�_�[�N�z�[�X)
    double acc_df = 1.0800;
    //3�i����(�h���S���u���b�h ���o���鑠��)
    double acc_3 = 1.125;
    //4�i����(�}�W�b�N�h�[���̐��ݗ�)
    double acc_4 = 1.100;                                                       //�b�葬�x
    //5�i����(�R�m�Z�p(���C�W���O �E�F�|��))
    double acc_5 = 1.100;                                                       //�b�葬�x
    //�L�[���̓f�B���C
    double key_delay = 0.1815;

    double ce_rate = 0.0500;                                                    //�T�C�N�����̊m��5%
    double bk_rate = 0.0000;                                                    //�u���[�A�^�b�N�̊�{�m��0%
    double bk_lv_bonus = 0.0000;                                                //�u���[�A�^�b�N�̃��x���A�b�v�{�[�i�X0%
    double bs_rate = 0.3333;                                                    //�o�[�j���O �X�s�b�c�̊m��33%
    double db_rate = 0.3333;                                                    //�_�u�� �u���C�N�̊m��33%
    double db_lv_bonus = 0.0000;                                                //�_�u�� �u���C�N�̃��x���A�b�v�{�[�i�X0%
    double db2_lv_bonus = 0.0000;                                               //�_�u�� �u���C�N:�f�X�e�B�j�[�̃��x���A�b�v�{�[�i�X0%
    double ef_rate = 0.4000;                                                    //�G�������^�� �t�@�C�A�[�̊m��40%
    double qe_rate = 0.4000;                                                    //�N�G�C�N�̊m��40%
    double pb_rate = 0.4000;                                                    //�u���C�u �����^���̊m��40%
    double re_rate = 0.1800;                                                    //���C�W�̊m��18%

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
                ui.cb_magic.addItem("�g���v���A���[");
                ui.cb_magic.addItem("�T���o�[�X�g");
                ui.cb_magic.addItem("�R�[���I�u�R�[���h");
                ui.cb_magic.addItem("�C���v�V����");
                ui.cb_magic.addItem("�R�[�����C�g�j���O");
            }
            if (cls == R) {
                ui.cb_magic.addItem("�t�H�[�X���C���[");
            }
            if (cls == W) {
                ui.cb_magic.addItem("�T���o�[�X�g");
                ui.cb_magic.addItem("�R�[���I�u�R�[���h");
                ui.cb_magic.addItem("�C���v�V����");
                ui.cb_magic.addItem("�R�[�����C�g�j���O");
            }
        }

        level = ui.cb_lev.getSelectedIndex() + 1;
        ui.lev.level = level;

        for (int i = 0; i < 6; i++) {
            _ST[LEVEL][i] = 0;
            _ST[ELIXIR][i] = 0;
        }

//�G���N�T�[�̍ő�g�p��(20��)
        for (int i = 0; i < 20; i++) {
            int st = ui.cb_elixir[i].getSelectedIndex() - 1;
            if (st >= 0) {
                if (ui.cb_elixir_level[i].getSelectedIndex() + 1 <= level) {
                    _ST[ELIXIR][st]++;
                }
            }
        }

        //�����X�e�[�^�X�ő�l����
        for (int i = 0; i < ui.lev.size; i++) {
            int st = ui.lev.field[i];
            if (st >= 0) {
                //LV100�ȏ�̍ő�X�e�[�^�X60/LV90�ȏ�̍ő�X�e�[�^�X55/LV90�����̍ő�X�e�[�^�X50�̏���
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

        if (bougu[0].name.equals("�G�������V�[���h")) {
            if (cls == E) {
                buff.MR += 5;
            }
        }

        // �Z�b�g����
        int set1 = 0, set2 = 0, set3 = 0;                                       //���ƃZ�b�g
        int set4 = 0, set5 = 0, set6 = 0;                                       //�򉻃Z�b�g
        int set7 = 0, set8 = 0;                                                 //�Ɋ��A�A�C�X�N�C�[���Z�b�g
        int set9 = 0;                                                           //�C���҃Z�b�g
        int set10 = 0, set11 = 0, set12 = 0;                                    //�ނ�Z�b�g
        int set13 = 0;                                                          //�R���Z�b�g
        int set14 = 0;                                                          //DK�Z�b�g
        int set15 = 0;                                                          //�Z�}�I�����Z�b�g �Z�}�̃����O+�I�����̃A�~�����b�g
        int set16 = 0;                                                          //�{�[���Z�b�g �{�[���w����+�{�[���A�[�}�[+�{�[���V�[���h
        int set17 = 0;                                                          //�A�C�A���Z�b�g �A�C�A���w����+�A�C�A���v���[�g���C��+�A�C�A���O���[�u+�A�C�A���u�[�c+�A�C�A���V�[���h
        int set18 = 0;                                                          //�E�B�U�[�h�Z�b�g �E�B�U�[�h�̖X�q+�E�B�U�[�h�̕�

        for (Bougu bougu1 : bougu) {
            if (bougu1.name.equals("�E�B�U�[�h�̖X�q")
                    || bougu1.name.equals("�E�B�U�[�h�̕�")) {
                set18++;
            }

            if (bougu1.name.equals("�A�C�A���w����")
                    || bougu1.name.equals("�A�C�A���v���[�g���C��")
                    || bougu1.name.equals("�A�C�A���O���[�u")
                    || bougu1.name.equals("�A�C�A���u�[�c")
                    || bougu1.name.equals("�A�C�A���V�[���h")) {
                set17++;
            }

            if (bougu1.name.equals("�{�[���w����")
                    || bougu1.name.equals("�{�[���A�[�}�[")
                    || bougu1.name.equals("�{�[���V�[���h")) {
                set16++;
            }

            if (bougu1.name.equals("�Z�}�̃����O")
                    || bougu1.name.equals("�I�����̃A�~�����b�g")) {
                set15++;
            }

            if (bougu1.name.equals("�f�X�i�C�g�w����")
                    || bougu1.name.equals("�f�X�i�C�g�O���[�u")
                    || bougu1.name.equals("�f�X�i�C�g�A�[�}�[")
                    || bougu1.name.equals("�f�X�i�C�g�u�[�c")) {
                set14++;
            }

            if (bougu1.name.equals("����R���̃��[�u")
                    || bougu1.name.equals("���@�R���̃}���g")
                    || bougu1.name.equals("�ÎE�R���̃O���[�u")
                    || bougu1.name.equals("���b�R���̃u�[�c")) {
                set13++;
            }

            if (bougu1.name.equals("�V���C�j���O�C�A�����O")) {
                set10++;
                set11++;
                set12++;
            }

            if (bougu1.name.equals("���b�h���[���l�b�N���X")) {
                set10 += 2;
            }

            if (bougu1.name.equals("�z���C�g���[���l�b�N���X")) {
                set11 += 2;
            }

            if (bougu1.name.equals("�u���b�N���[���l�b�N���X")) {
                set12 += 2;
            }

            if (bougu1.name.equals("���Ƃ̃C�A�����O")) {
                set1++;
                set2++;
                set3++;
            }

            if (bougu1.name.equals("�򉻂̃C�A�����O")) {
                set4++;
                set5++;
                set6++;
            }

            if (bougu1.name.equals("���Ƃ̖҂��A�~�����b�g")) {
                set1 += 2;
            }

            if (bougu1.name.equals("���Ƃ̌����A�~�����b�g")) {
                set2 += 2;
            }

            if (bougu1.name.equals("���Ƃ̋����A�~�����b�g")) {
                set3 += 2;
            }

            if (bougu1.name.equals("��̃A�~�����b�g")) {
                set4 += 2;
            }

            if (bougu1.name.equals("�Ԏ�̃A�~�����b�g")) {
                set5 += 2;
            }

            if (bougu1.name.equals("�Ύ�̃A�~�����b�g")) {
                set6 += 2;
            }

            if (bougu1.name.contains("�Ɋ�")) {
                set7++;
            }

            if (bougu1.name.contains("�A�C�X�N�C�[��")) {
                set8++;
            }

            if (bougu1.name.contains("�C����")) {
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
            //���L���\�b�h���s�̂��тɒǉ��{�[�i�X���ݐς����͗l(�{��+2�Œǉ��{�[�i�X��3�{�ɂȂ�)
            //ui.cb_morph_level.setSelectedItem("80");
            //ui.cb_morph_type.setSelectedItem("��/������");
        }

        //�Z�}�E�I�����Z�b�g AC-5 STR+1 DEX+1 CON+1 INT+1 WIS+1 CHA+1 �ő�HP+50
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

        //�{�[���Z�b�g AC-5 MR+5 �ő�HP+50
        if (set16 == 3) {
            buff.AC -= 5;
            buff.MR += 5;
            buff.HP += 50;
        }

        //�A�C�A���Z�b�g AC-5 STR+1 MR+10 �ő�HP+50
        if (set17 == 5) {
            buff.AC -= 5;
            buff.ST[STR] += 1;
            buff.MR += 10;
            buff.HP += 50;
        }

        //�E�B�U�[�h�Z�b�g AC-3 MR+8 MPR+8 �ő�MP+50
        if (set18 == 2) {
            buff.AC -= 3;
            buff.MP += 8;
            buff.MPR += 8;
            buff.HP += 50;
        }

        //�E�B�Y�_���|�[�V����
        ui.cb_buff[ITEM_WIZP].setToolTipText("SP+2 MPR+2");
        if (ui.cb_buff[ITEM_WIZP].isSelected()) {
            if (cls == W || cls == I) {
                buff.SP += 2;
                buff.MPR += 2;
            } else {
                ui.cb_buff[ITEM_WIZP].setSelected(false);
            }
        }

        // �}�W�b�N�h�[��
        if (ui.cb_buff[ITEM_MD].isSelected()) {
            switch (ui.cb_buff_group[ITEM_MD].getSelectedIndex()) {
        //LV1 MD
                case 0:                             //�J�J�V
                    buff.HP += 50;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ő�HP+50");
                    break;
                case 1:                             //�E�F�A�E���t
                    buff.effect += "����U��(�N���X�^�V�A��/�E�F�A�E���t),";
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����U������3%�̊m���Œǉ��_���[�W+15");
                    break;
                case 2:                             //�N���X�^�V�A��
                    buff.effect += "����U��(�N���X�^�V�A��/�E�F�A�E���t),";
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����U������3%�̊m���Œǉ��_���[�W+15");
                    break;
                case 3:                             //�X�g�[���S�[����
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�_���[�W�ቺ+1")
                    ;break;
                case 4:                             //�C�G�e�B
                    buff.AC -= 3;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-3");
                    break;
                case 5:                             //�o�O�x�A�[
                    buff.r_weight += 0.20;
                    ui.cb_buff[ITEM_MD].setToolTipText("�����d�ʑ���+500");
                    break;
        //LV2 MD
                case 6:                             //�����@�S�[����
                    buff.DMG_SHORT += 1;
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+1 �_���[�W�ቺ+1");
                    break;
                case 7:                             //�X�m�[�}��
                    buff.DMG_SHORT += 1;
                    buff.HIT_SHORT += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+1 �ߋ�������+1");
                    break;
                case 8:                             //�R�J�g���X
                    buff.DMG_LONG++;
                    buff.HIT_LONG++;
                    ui.cb_buff[ITEM_MD].setToolTipText("�������_���[�W+1 ����������+1");
                    break;
                case 9:                             //�T�L���o�X
                    buff.effect += "MP�� +15,";
                    ui.cb_buff[ITEM_MD].setToolTipText("MP��Ή�+15(64�b)");
                    break;
                case 10:                            //�G���_�[
                    buff.effect += "MP�� +15,";
                    ui.cb_buff[ITEM_MD].setToolTipText("MP��Ή�+15(64�b)");
                    break;
                case 11:                            //�}�[���C�h
                    ui.cb_buff[ITEM_MD].setToolTipText("�o���l����+3%");
                    break;
        //LV3 MD
                case 12:                            //�_�C�A�S�[����
                    buff.DR += 2;
                    ui.cb_buff[ITEM_MD].setToolTipText("�_���[�W�ቺ+2");
                    break;
                case 13:                            //�j�����ꂽ�_�C�A�S�[����
                    buff.AC -= 2;
                    buff.DR += 2;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 �_���[�W�ቺ+2");
                    break;
                case 14:                            //�h���C�N
                    buff.DMG_LONG += 2;
                    buff.effect += "MP�� +6,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�������_���[�W+2 64�b����MP��6��");
                    break;
                case 15:                            //�j�����ꂽ�h���C�N
                    buff.AC -= 2;
                    buff.DMG_LONG += 2;
                    buff.effect += "MP�� +6,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 �������_���[�W+2 64�b����MP��6��");
                    break;
                case 16:                            //�L���O�o�O�x�A�[
                    buff.ailment[STUN] += 8;
                    buff.effect += "MP�� +10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�X�^���ϐ�+8 64�b����MP��10��");
                    break;
                case 17:                            //�j�����ꂽ�L���O�o�O�x�A�[
                    buff.AC -= 2;
                    buff.ailment[STUN] += 8;
                    buff.effect += "MP�� +10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 �X�^���ϐ�+8 64�b����MP��10��");
                    break;
                case 18:                            //�T�L���o�X�N�C�[��
                    buff.effect += "MP�� +15,";
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("SP+1 64�b����MP��15��");
                    break;
                case 19:                            //�j�����ꂽ�T�L���o�X�N�C�[��
                    buff.AC -= 2;
                    buff.effect += "MP�� +15,";
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 SP+1 64�b����MP��15��");
                    break;
                case 20:                            //�u���b�N�G���_�[
                    buff.effect += "MP�� +15,";
                    buff.effect += "�R�[�����C�g�j���O,";
                    ui.cb_buff[ITEM_MD].setToolTipText("64�b����MP��15�� ���@����(�R�[�����C�g�j���O)");
                    break;
                case 21:                            //�j�����ꂽ�u���b�N�G���_�[
                    buff.AC -= 2;
                    buff.effect += "MP�� +15,";
                    buff.effect += "�R�[�����C�g�j���O,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 64�b����MP��15�� ���@����(�R�[�����C�g�j���O)");
                    break;
                case 22:                            //�A�[�X�W���C�A���g
                    buff.MEXP += 10;                //�l���o���l+10%
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�l���o���l+10% �_���[�W�ቺ+1");
                    break;
                case 23:                            //�j�����ꂽ�A�[�X�W���C�A���g
                    buff.AC -= 2;
                    buff.MEXP += 10;                //�l���o���l+10%
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 �l���o���l+10% �_���[�W�ቺ+1");
                    break;
        //LV4 MD
                case 24:                            //�T�C�N���v�X
                    buff.AC -= 1;
                    buff.DMG_SHORT += 6;
                    buff.DMG_LONG += 6;
                    buff.SP += 4;
                    buff.effect += "�A�[�X�W�F�C��,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-1 �ߋ����_���[�W+6 �������_���[�W+6 SP+4 ���@����(�A�[�X�W�F�C��)");
                    break;
                case 25:                            //�j�����ꂽ�T�C�N���v�X
                    buff.AC -= 3;
                    buff.PVP += 2;
                    buff.DMG_SHORT += 6;
                    buff.DMG_LONG += 6;
                    buff.SP += 4;
                    buff.effect += "�A�[�X�W�F�C��,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-3 PVP�ǉ��_���[�W+2 �ߋ����_���[�W+6 �������_���[�W+6 SP+4 ���@����(�A�[�X�W�F�C��)");
                    break;
                case 26:                            //�i�C�g�o���h
                    buff.AC -= 2;
                    buff.DMG_SHORT += 4;
                    buff.HIT_SHORT += 2;
                    buff.DR += 2;
                    buff.HP += 120;
                    buff.effect += "MP�� +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 �ő�HP+120 �ߋ����_���[�W+4 �ߋ�������+2 �_���[�W�ቺ+2 64�b����MP��8��");
                    break;
                case 27:                            //�j�����ꂽ�i�C�g�o���h
                    buff.AC -= 4;
                    buff.PVP += 2;
                    buff.DMG_SHORT += 4;
                    buff.HIT_SHORT += 2;
                    buff.DR += 2;
                    buff.HP += 120;
                    buff.effect += "MP�� +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP�ǉ��_���[�W+2 �ő�HP+120 �ߋ����_���[�W+4 �ߋ�������+2 �_���[�W�ቺ+2 64�b����MP��8��");
                    break;
                case 28:                            //�A�C���X
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    buff.DR += 3;
                    buff.effect += "�t�H�[�X���C���[�_���[�W+10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+2 �ߋ�������+2 �_���[�W�ቺ+3 �t�H�[�X���C���[�ǉ��_���[�W+10");
                    break;
                case 29:                            //�j�����ꂽ�A�C���X
                    buff.AC -= 2;
                    buff.PVP += 2;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    buff.DR += 3;
                    buff.effect += "�t�H�[�X���C���[�_���[�W+10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 PVP�ǉ��_���[�W+2 �ߋ����_���[�W+2 �ߋ�������+2 �_���[�W�ቺ+3 �t�H�[�X���C���[�ǉ��_���[�W+10");
                    break;
                case 30:                            //�o���p�C�A
                    buff.AC -= 2;
                    buff.HP += 80;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    buff.DR += 2;
                    buff.ailment[HIT_TERROR] += 3;
                    buff.ailment[STUN] += 5;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 �ő�HP+80 �ߋ����_���[�W+2 �ߋ�������+2 �_���[�W�ቺ+2 ���|����+3 �Z�p�ϐ�+5");
                    break;
                case 31:                            //�j�����ꂽ�o���p�C�A
                    buff.AC -= 4;
                    buff.PVP += 2;
                    buff.HP += 80;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    buff.DR += 2;
                    buff.ailment[HIT_TERROR] += 3;
                    buff.ailment[STUN] += 5;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP�ǉ��_���[�W+2  �ő�HP+80 �ߋ����_���[�W+2 �ߋ�������+2 �_���[�W�ቺ+2 ���|����+3 �Z�p�ϐ�+5");
                    break;
                case 32:                            //�V�A�[
                    buff.AC -= 2;
                    buff.HP += 80;
                    buff.DMG_LONG += 4;
                    buff.HIT_LONG += 2;
                    buff.DR += 2;
                    buff.effect += "MP�� +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 �ő�HP+80 �������_���[�W+4 ����������+2 �_���[�W�ቺ+2 64�b����MP��12��");
                    break;
                case 33:                            //�j�����ꂽ�V�A�[
                    buff.AC -= 4;
                    buff.PVP += 2;
                    buff.HP += 80;
                    buff.DMG_LONG += 4;
                    buff.HIT_LONG += 2;
                    buff.DR += 2;
                    buff.effect += "MP�� +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP�ǉ��_���[�W+2  �ő�HP+80 �������_���[�W+4 ����������+2 �_���[�W�ቺ+2 64�b����MP��12��");
                    break;
                case 34:                            //���b�`
                    buff.AC -= 2;
                    buff.HP += 40;
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.effect += "MP�� +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 �ő�HP+40 SP+2 �_���[�W�ቺ+2 MP��Ή�+16(64�b)");
                    break;
                case 35:                            //�j�����ꂽ���b�`
                    buff.AC -= 4;
                    buff.PVP += 2;
                    buff.HP += 40;
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.effect += "MP�� +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP�ǉ��_���[�W+2 �ő�HP+40 SP+2 �_���[�W�ቺ+2 MP��Ή�+16(64�b)");
                    break;
        //LV5 MD
                case 36:                            //�f�X�i�C�g
                    buff.AC -= 2;
                    buff.DMG_SHORT += 8;
                    buff.DMG_LONG += 8;
                    buff.SP += 5;
                    buff.effect += "�w���t�@�C�A�[,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 �ߋ����_���[�W+8 �������_���[�W+8 SP+5 ���@����(�w���t�@�C�A)");
                    break;
                case 37:                            //�j�����ꂽ�f�X�i�C�g
                    buff.AC -= 4;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.DMG_SHORT += 8;
                    buff.DMG_LONG += 8;
                    buff.SP += 5;
                    buff.effect += "�w���t�@�C�A�[,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP�ǉ��_���[�W+2 PVP�_���[�W�ቺ+4 �ߋ����_���[�W+8 �������_���[�W+8 SP+5 ���@����(�w���t�@�C�A)");
                    break;
                case 38:                            //�f�[����
                    buff.AC -= 4;
                    buff.DMG_SHORT += 6;
                    buff.HIT_SHORT += 4;
                    buff.DR += 4;
                    buff.HP += 120;
                    buff.effect += "MP�� +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 �ő�HP+120 �ߋ����_���[�W+6 �ߋ�������+4 �_���[�W�ቺ+4 64�b����MP��8��");
                    break;
                case 39:                            //�j�����ꂽ�f�[����
                    buff.AC -= 6;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.DMG_SHORT += 6;
                    buff.HIT_SHORT += 4;
                    buff.DR += 4;
                    buff.HP += 120;
                    buff.effect += "MP�� +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-6 PVP�ǉ��_���[�W+2 PVP�_���[�W�ቺ+4  �ő�HP+120 �ߋ����_���[�W+6 �ߋ�������+4 �_���[�W�ቺ+4 64�b����MP��8��");
                    break;
                case 40:                            //�o�����J
                    buff.HP += 120;
                    buff.DMG_SHORT += 6;
                    buff.HIT_SHORT += 6;
                    buff.DR += 2;
                    buff.ailment[HIT_SPIRIT] += 10;
                    buff.effect += "MP�� +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�ő�HP+120 �ߋ����_���[�W+6 �ߋ�������+6 �_���[�W�ቺ+2 ���얽��+10 64�b����MP��12��");
                    break;
                case 41:                            //�j�����ꂽ�o�����J
                    buff.AC -= 2;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.HP += 120;
                    buff.DMG_SHORT += 6;
                    buff.HIT_SHORT += 6;
                    buff.DR += 2;
                    buff.ailment[HIT_SPIRIT] += 10;
                    buff.effect += "MP�� +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 PVP�ǉ��_���[�W+2 PVP�_���[�W�ቺ+4 �ő�HP+120 �ߋ����_���[�W+6 �ߋ�������+6 �_���[�W�ቺ+2 ���얽��+10 64�b����MP��12��");
                    break;
                case 42:                            //�J�[�c
                    buff.AC -= 3;
                    buff.DMG_SHORT += 4;
                    buff.HIT_SHORT += 4;
                    buff.HP += 120;
                    buff.DR += 3;
                    buff.effect += "�t�H�[�X���C���[�_���[�W+10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-3 �ߋ����_���[�W+4 �ߋ�������+4 �ő�HP+120 �_���[�W�ቺ+3 �t�H�[�X���C���[�ǉ��_���[�W+10");
                    break;
                case 43:                            //�j�����ꂽ�J�[�c
                    buff.AC -= 5;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.DMG_SHORT += 4;
                    buff.HIT_SHORT += 4;
                    buff.HP += 120;
                    buff.DR += 3;
                    buff.effect += "�t�H�[�X���C���[�_���[�W+10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-5 PVP�ǉ��_���[�W+2 PVP�_���[�W�ቺ+4 �ߋ����_���[�W+4 �ߋ�������+4 �ő�HP+120 AC-3 �_���[�W�ቺ+3 �t�H�[�X���C���[�ǉ��_���[�W+10");
                    break;
                case 44:                            //�o�t�H���b�g
                    buff.AC -= 4;
                    buff.HP += 120;
                    buff.DMG_SHORT += 3;
                    buff.HIT_SHORT += 3;
                    buff.DR += 4;
                    buff.ailment[HIT_TERROR] += 5;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 �ߋ����_���[�W+3 �ߋ�������+3 �ő�HP+120 �_���[�W�ቺ+4 ���|����+5");
                    break;
                case 45:                            //�j�����ꂽ�o�t�H���b�g
                    buff.AC -= 6;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.HP += 120;
                    buff.DMG_SHORT += 3;
                    buff.HIT_SHORT += 3;
                    buff.DR += 4;
                    buff.ailment[HIT_TERROR] += 5;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-6 PVP�ǉ��_���[�W+2 PVP�_���[�W�ቺ+4 �ߋ����_���[�W+3 �ߋ�������+3 �ő�HP+120 �_���[�W�ቺ+4 ���|����+5");
                    break;
                case 46:                            //�}�~�[���[�h
                    buff.AC -= 4;
                    buff.DMG_LONG += 6;
                    buff.HIT_LONG += 4;
                    buff.DR += 4;
                    buff.HP += 80;
                    buff.effect += "MP�� +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 �ő�HP+80 �������_���[�W+6 ����������+4 �_���[�W�ቺ+4 64�b����MP��12��");
                    break;
                case 47:                            //�j�����ꂽ�}�~�[���[�h
                    buff.AC -= 6;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.DMG_LONG += 6;
                    buff.HIT_LONG += 4;
                    buff.DR += 4;
                    buff.HP += 80;
                    buff.effect += "MP�� +12,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-6 PVP�ǉ��_���[�W+2 PVP�_���[�W�ቺ+4  �ő�HP+80 �������_���[�W+6 ����������+4 �_���[�W�ቺ+4 64�b����MP��12��");
                    break;
                case 48:                            //�A�C�X�N�C�[��
                    buff.HP += 80;
                    buff.SP += 1;
                    buff.DMG_LONG += 4;
                    buff.HIT_LONG += 8;
                    buff.DR += 2;
                    buff.effect += "�U�������m���Ŗ��@����,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�ő�HP+80 �������_���[�W+4 ����������+8 �_���[�W�ቺ+2 ���@����");
                    break;
                case 49:                            //�j�����ꂽ�A�C�X�N�C�[��
                    buff.AC -= 2;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.HP += 80;
                    buff.SP += 1;
                    buff.DMG_LONG += 4;
                    buff.HIT_LONG += 8;
                    buff.DR += 2;
                    buff.effect += "�U�������m���Ŗ��@����,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 PVP�ǉ��_���[�W+2 PVP�_���[�W�ቺ+4 �ő�HP+80 �������_���[�W+4 ����������+8 �_���[�W�ቺ+2 ���@����");
                    break;
                case 50:                            //��
                    buff.SP += 5;
                    buff.HIT_MAGIC += 5;                    
                    buff.effect += "MP�� +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("SP+5 ���@����+5 64�b����MP��16��");
                    break;
                case 51:                            //�j�����ꂽ��
                    buff.AC -= 2;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.SP += 5;
                    buff.HIT_MAGIC += 5;                    
                    buff.effect += "MP�� +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 PVP�ǉ��_���[�W+2 PVP�_���[�W�ቺ+4 SP+5 ���@����+5 64�b����MP��16��");
                    break;
                case 52:                            //�o���p�I
                    buff.AC -= 4;
                    buff.SP += 3;
                    buff.DR += 4;
                    buff.HP += 40;
                    buff.effect += "MP�� +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 �ő�HP+40 SP+3�_���[�W�ቺ+4 64�b����MP��16��");
                    break;
                case 53:                            //�j�����ꂽ�o���p�I
                    buff.AC -= 6;
                    buff.PVP += 2;
                    buff.PVP_DR += 4;
                    buff.SP += 3;
                    buff.DR += 4;
                    buff.HP += 40;
                    buff.effect += "MP�� +16,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-6 PVP�ǉ��_���[�W+2 PVP�_���[�W�ቺ+4 �ő�HP+40 SP+3�_���[�W�ቺ+4 64�b����MP��16��");
                    break;
        //LV5 �h���S��MD
                case 54:                            //�A���^���X
                    buff.AC -= 9;
                    buff.PVP += 4;
                    buff.PVP_DR += 2;
                    buff.HP += 120;
                    buff.DR += 7;
                    buff.effect += "MP�� +15,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-9 PVP�ǉ��_���[�W+4 PVP�_���[�W�ቺ+2 �ő�HP+120 �_���[�W�ቺ+7 64�b����MP��15�� �j�����Ռ���+7%");
                    break;
                case 55:                            //�p�v���I��
                    buff.AC -= 3;
                    buff.PVP += 4;
                    buff.PVP_DR += 2;
                    buff.DR += 1;
                    buff.SP += 7;
                    buff.HIT_MAGIC += 7;
                    buff.effect += "MP�� +10,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-3 PVP�ǉ��_���[�W+4 PVP�_���[�W�ቺ+2 �_���[�W�ቺ+1 SP+7 ���@����+7 64�b����MP��10�� �j�����Ռ���+7%");
                    break;
                case 56:                            //�����h�r�I��
                    buff.AC -= 4;
                    buff.PVP += 4;
                    buff.PVP_DR += 2;
                    buff.DR += 2;
                    buff.DMG_LONG += 7;
                    buff.HIT_LONG += 7;
                    buff.effect += "MP�� +5,";
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-4 PVP�ǉ��_���[�W+4 PVP�_���[�W�ቺ+2 �_���[�W�ቺ+2 �������_���[�W+7 ����������+7 64�b����MP��5�� �j�����Ռ���+7%");
                    break;
                case 57:                            //���@���J�X
                    buff.AC -= 5;
                    buff.PVP += 4;
                    buff.PVP_DR += 2;
                    buff.DR += 3;
                    buff.DMG_SHORT += 7;
                    buff.HIT_SHORT += 7;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-5 PVP�ǉ��_���[�W+4 PVP�_���[�W�ቺ+2 �_���[�W�ቺ+3 �ߋ����_���[�W+7 �ߋ�������+7 �j�����Ռ���+7%");
                    break;
        //LV6 MD
                case 58:                            //�n���p�X
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
                                                    //MP��Ή�+10
                    buff.AC -= 5;
                                                    //EXP+25%
                                                    //�j�����Ռ���+10%
                                                    //4�i����
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+10 �ߋ�������+10 �_���[�W����+8 �X�L�������F�S��+10 �X�L���ϐ��F�S��+10 MP��Ή�+10 �ǉ��h���+5 EXP+25% �j�����Ռ���+10% 4�i����");
                    break;
                case 59:                            //�A�E���L�A
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
                                                    //MP��Ή�+20
                    buff.HP += 300;
                    buff.AC -= 5;
                                                    //EXP+25%
                                                    //�j�����Ռ���+10%
                                                    //4�i����
                    ui.cb_buff[ITEM_MD].setToolTipText("SP+7 ���@����+10 �_���[�W����+8 �X�L�������F�S��+10 �X�L���ϐ��F�S��+10 MP��Ή�+20 �ő�HP+300 �ǉ��h���+5 EXP+25% �j�����Ռ���+10% 4�i����");
                    break;
                case 60:                            //�x�q���X
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
                                                    //MP��Ή�+15
                    buff.HP += 200;
                    buff.MP += 100;
                    buff.AC -= 5;
                                                    //EXP+25%
                                                    //�j�����Ռ���+10%
                                                    //4�i����
                    ui.cb_buff[ITEM_MD].setToolTipText("�������_���[�W+10 ����������+10 �_���[�W����+8 �X�L�������F�S��+10 �X�L���ϐ��F�S��+10 MP��Ή�+15 �ő�HP+200 �ő�MP+100 �ǉ��h���+5 EXP+25% �j�����Ռ���+10% 4�i����");
                    break;
//�ۋ�MD
                case 61:                            //�V�[�_���T�[
                    buff.effect += "HP�� +40,";
                    ui.cb_buff[ITEM_MD].setToolTipText("HP��Ή�+40(32�b)");
                    break;
                case 62:                            //�X�p���g�C
                    ui.cb_buff[ITEM_MD].setToolTipText("���m��(4%)�Ń_���[�W�𖳌���");
                    buff.effect += "���,";
                    break;
                case 63:                            //���~�A
                    buff.MPR += 4;
                    ui.cb_buff[ITEM_MD].setToolTipText("MP���R��+4 �ߋ����U���̎��������@����:�J�[�Y�|�C�Y��");
                    break;
                case 64:                            //�X�m�[�}��(�ۋ�)
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.MPR += 2;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+2 �������_���[�W+2 MP���R��+2");
                    break;
                case 65:                            //�O��������
                    buff.HP += 30;
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("HP+30 �ߋ����_���[�W+2 �������_���[�W+2 SP+1");
                    break;
                case 66:                            //�u���[�g
                    buff.r_weight += 0.10;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+250");
                    break;
                case 67:                            //�u���[�g(�w�͂���)
                    buff.r_weight += 0.12;
                    buff.effect += "HP�� +15,";
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+300 HP��Ή�+15(64�b)");
                    break;
                case 68:                            //�u���[�g(����)
                    buff.r_weight += 0.14;
                    buff.effect += "HP�� +15,";
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+350 HP��Ή�+15(64�b)");
                    break;
                case 69:                            //�u���[�g(������)
                    buff.r_weight += 0.16;
                    buff.effect += "HP�� +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+400 HP��Ή�+15(64�b) �ߋ����_���[�W+1");
                    break;
                case 70:                            //�u���[�g(����)
                    buff.r_weight += 0.18;
                    buff.effect += "HP�� +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+450 HP��Ή�+15(64�b) �ߋ����_���[�W+1");
                    break;
                case 71:                            //�u���[�g(ῂ���)
                    buff.r_weight += 0.20;
                    buff.effect += "HP�� +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+500 HP��Ή�+15(64�b) �ߋ����_���[�W+1");
                    break;
                case 72:                            //�W���C�A���g
                    buff.r_weight += 0.10;
                    buff.effect += "�_���[�W�ቺ +5,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+5 �����d�ʑ���+250");
                    break;
                case 73:                            //�W���C�A���g(�w�͂���)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.effect += "�_���[�W�ቺ +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+8 �����d�ʑ���+250 AC-1");
                    break;
                case 74:                            //�W���C�A���g(����)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.effect += "�_���[�W�ቺ +11,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+11 �����d�ʑ���+250 AC-1");
                    break;
                case 75:                            //�W���C�A���g(������)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "�_���[�W�ቺ +14,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+14 �����d�ʑ���+250 AC-1 MR+5%");
                    break;
                case 76:                            //�W���C�A���g(����)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "�_���[�W�ቺ +17,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+17 �����d�ʑ���+250 AC-1 MR+5%");
                    break;
                case 77:                            //�W���C�A���g(ῂ���)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "�_���[�W�ቺ +20,���@���p�C�A���b�N�^�b�`,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+20 �����d�ʑ���+250 AC-1 MR+5% �ߋ����U�����Ɉ��m���Ŗ��@����:�o���p�C�A���b�N�^�b�`");
                    break;
                case 78:                            //�p�b�N/�p�I(0�i�K)
                    buff.DMG_SHORT += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+1");
                case 79:                            //�p�b�N/�p�I(1�i�K)
                    buff.DMG_SHORT += 1;
                    buff.DMG_LONG += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+1 �������_���[�W+1");
                    break;
                case 80:                            //�p�b�N/�p�I(2�i�K)
                    buff.DMG_SHORT += 1;
                    buff.DMG_LONG += 1;
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+1 �������_���[�W+1 SP+1");
                    break;
                case 81:                            //�p�b�N/�p�I(3�i�K)
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.SP += 1;
                    buff.effect += "����U��(�p�b�N/�p�I),";
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+2 �������_���[�W+2 SP+1 ���@����:���ꔚ�����@");
                    break;
                default:
                    break;
            }
        }
//�}�W�b�N�h�[�� �p�b�N/�p�I�̃I�v�V����
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
                case 2:                                 //AC-5 �_���[�W�ቺ+2
                    buff.AC -= 5;
                    buff.DR += 2;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("AC-5 �_���[�W�ቺ+2");
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
                case 9:                                 //MP��Ή�+1(64�b)
                    buff.effect += "MP�� +1,";
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("MP��Ή�+1(64�b)AC-2");
                    break;
                case 10:                                //MP��Ή�+3(64�b)
                    buff.effect += "MP�� +3,";
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("MP��Ή�+3(64�b)");
                    break;
                case 11:                                //MP��Ή�+7(64�b)
                    buff.effect += "MP�� +7,";
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("MP��Ή�+7(64�b)");
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
                case 15:                                //�ߋ�������+1 ����������+1
                    buff.HIT_SHORT += 1;
                    buff.HIT_LONG += 1;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("�ߋ�������+1 ����������+1");
                    break;
                case 16:                                //�ߋ�������+2 ����������+2
                    buff.HIT_SHORT += 2;
                    buff.HIT_LONG += 2;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("�ߋ�������+2 ����������+2");
                    break;
                case 17:                                //�ߋ�������+4 ����������+4
                    buff.HIT_SHORT += 4;
                    buff.HIT_LONG += 4;
                    ui.cb_buff[ITEM_MD_OP].setToolTipText("�ߋ�������+4 ����������+4");
                    break;
                default:
                    break;
            }
        }

//�}�W�b�N�h�[���̐��ݗ�
        if (ui.cb_buff[ITEM_MD_OP2].isSelected()) {
            switch (ui.cb_buff_group[ITEM_MD_OP2].getSelectedIndex()) {
//���
                case 0:                                 //�ߋ����N���e�B�J��+1%
                    buff.CRI_SHORT += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ����N���e�B�J��+1%");
                    break;
                case 1:                                 //�������N���e�B�J��+1%
                    buff.CRI_LONG += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�������N���e�B�J��+1%");
                    break;
                case 2:                                 //���@�N���e�B�J��+1%
                    buff.CRI_MAGIC += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���@�N���e�B�J��+1%");
                    break;
                case 3:                                 //�ߋ����_���[�W+1
                    buff.DMG_SHORT += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ����_���[�W+1");
                    break;
                case 4:                                 //�������_���[�W+1
                    buff.DMG_LONG += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�������_���[�W+1");
                    break;
                case 5:                                 //�ߋ�������+1
                    buff.HIT_SHORT += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ�������+1");
                    break;
                case 6:                                 //����������+1
                    buff.HIT_LONG += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("����������+1");
                    break;
                case 7:                                 //�_���[�W����+1
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�_���[�W����+1");
                    break;
                case 8:                                 //AC-1
                    buff.AC -= 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("AC-1");
                    break;
                case 9:                                 //MR+3%
                    buff.MR += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MR+3%");
                    break;
                case 10:                                //�ő�HP+30
                    buff.HP += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ő�HP+30");
                    break;
                case 11:                                //�ő�MP+20
                    buff.MP += 20;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ő�MP+20");
                    break;
                case 12:                                //PVP�ǉ��_���[�W+1
                    buff.PVP += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP�ǉ��_���[�W+1");
                    break;
                case 13:                                //PVP�_���[�W����+1
                    buff.PVP_DR += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP�_���[�W����+1");
                    break;
                case 14:                                //�΂̑�����R+10
                    buff.element_resist[FIRE] += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�΂̑�����R+10");
                    break;
                case 15:                                //�n�̑�����R+10
                    buff.element_resist[EARTH] += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�n�̑�����R+10");
                    break;
                case 16:                                //���̑�����R+10
                    buff.element_resist[WATER] += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���̑�����R+10");
                    break;
                case 17:                                //���̑�����R+10
                    buff.element_resist[WIND] += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���̑�����R+10");
                    break;
                case 18:                                //�����d�ʑ���+100(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�����d�ʑ���+100(������)");
                    break;
//����
                case 19:                                 //�ߋ����N���e�B�J��+3%
                    buff.CRI_SHORT += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ����N���e�B�J��+3%");
                    break;
                case 20:                                //�������N���e�B�J��+3%
                    buff.CRI_LONG += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�������N���e�B�J��+3%");
                    break;
                case 21:                                //���@�N���e�B�J��+3%
                    buff.CRI_MAGIC += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���@�N���e�B�J��+3%");
                    break;
                case 22:                                //�ߋ����_���[�W+2
                    buff.DMG_SHORT += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ����_���[�W+2");
                    break;
                case 23:                                //�������_���[�W+2
                    buff.DMG_LONG += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�������_���[�W+2");
                    break;
                case 24:                                //�ߋ�������+2
                    buff.HIT_SHORT += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ�������+2");
                    break;
                case 25:                                //����������+2
                    buff.HIT_LONG += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("����������+2");
                    break;
                case 26:                                 //�_���[�W����+2
                    buff.DR += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�_���[�W����+2");
                    break;
                case 27:                                 //AC-2
                    buff.AC -= 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("AC-2");
                    break;
                case 28:                                 //MR+6%
                    buff.MR += 6;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MR+6%");
                    break;
                case 29:                                //�ő�HP+60
                    buff.HP += 60;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ő�HP+60");
                    break;
                case 30:                                //�ő�MP+40
                    buff.MP += 40;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ő�MP+40");
                    break;
                case 31:                                //�ߋ������(DG)+3
                    buff.DG += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ������(DG)+3");
                    break;
                case 32:                                //HP��Ή�+30(32�b)(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("HP��Ή�+30(32�b)(������)");
                    break;
                case 33:                                //MP��Ή�+10(64�b)(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MP��Ή�+10(64�b)(������)");
                    break;
                case 34:                                //���������(ER)+3
                    buff.ER += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���������(ER)+3");
                    break;
                case 35:                                //PVP�ǉ��_���[�W+2
                    buff.PVP += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP�ǉ��_���[�W+2");
                    break;
                case 36:                                //PVP�_���[�W����+2
                    buff.PVP_DR += 2;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP�_���[�W����+2");
                    break;
                case 37:                                //PVP���@�_���[�W����+2(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP���@�_���[�W����+2(������)");
                    break;
                case 38:                                //�Z�p�ϐ�+3
                    buff.ailment[STUN] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�Z�p�ϐ�+3");
                    break;
                case 39:                                //����ϐ�+3
                    buff.ailment[SPIRIT] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("����ϐ�+3");
                    break;
                case 40:                                //��Z�ϐ�+3
                    buff.ailment[SECRET] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("��Z�ϐ�+3");
                    break;
                case 41:                                //���|�ϐ�+3
                    buff.ailment[TERROR] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���|�ϐ�+3");
                    break;
                case 42:                                //�΂̑�����R+20
                    buff.element_resist[FIRE] += 20;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�΂̑�����R+20");
                    break;
                case 43:                                //�n�̑�����R+20
                    buff.element_resist[EARTH] += 20;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�n�̑�����R+20");
                    break;
                case 44:                                //���̑�����R+20
                    buff.element_resist[WATER] += 20;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���̑�����R+20");
                    break;
                case 45:                                //���̑�����R+20
                    buff.element_resist[WIND] += 20;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���̑�����R+20");
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
                case 51:                                //�����d�ʑ���+200(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�����d�ʑ���+200(������)");
                    break;
//��
                case 52:                                 //�ߋ����N���e�B�J��+5%
                    buff.CRI_SHORT += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ����N���e�B�J��+5%");
                    break;
                case 53:                                //�������N���e�B�J��+5%
                    buff.CRI_LONG += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�������N���e�B�J��+5%");
                    break;
                case 54:                                //���@�N���e�B�J��+5%
                    buff.CRI_MAGIC += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���@�N���e�B�J��+5%");
                    break;
                case 55:                                //�ߋ����_���[�W+3
                    buff.DMG_SHORT += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ����_���[�W+3");
                    break;
                case 56:                                //�������_���[�W+3
                    buff.DMG_LONG += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�������_���[�W+3");
                    break;
                case 57:                                //�ߋ�������+3
                    buff.HIT_SHORT += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ�������+3");
                    break;
                case 58:                                //����������+3
                    buff.HIT_LONG += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("����������+3");
                    break;
                case 59:                                 //SP+3
                    buff.SP += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("SP+3");
                    break;
                case 60:                                 //���@����+3
                    buff.HIT_MAGIC += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���@����+3");
                    break;
                case 61:                                 //�_���[�W����+3
                    buff.DR += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�_���[�W����+3");
                    break;
                case 62:                                 //AC-3
                    buff.AC -= 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("AC-3");
                    break;
                case 63:                                 //MR+10%
                    buff.MR += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MR+10%");
                    break;
                case 64:                                //�ő�HP+150
                    buff.HP += 150;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ő�HP+150");
                    break;
                case 65:                                //�ő�MP+100
                    buff.MP += 100;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ő�MP+100");
                    break;
                case 66:                                //�ߋ������(DG)+5
                    buff.DG += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ������(DG)+5");
                    break;
                case 67:                                //HP��Ή�+50(32�b)(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("HP��Ή�+50(32�b)(������)");
                    break;
                case 68:                                //MP��Ή�+12(64�b)(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MP��Ή�+12(64�b)(������)");
                    break;
                case 69:                                //���������(ER)+5
                    buff.ER += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���������(ER)+5");
                    break;
                case 70:                                //PVP�ǉ��_���[�W+3
                    buff.PVP += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP�ǉ��_���[�W+3");
                    break;
                case 71:                                //PVP�_���[�W����+3
                    buff.PVP_DR += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP�_���[�W����+3");
                    break;
                case 72:                                //PVP���@�_���[�W����+5(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP���@�_���[�W����+5(������)");
                    break;
                case 73:                                //�Z�p�ϐ�+5
                    buff.ailment[STUN] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�Z�p�ϐ�+5");
                    break;
                case 74:                                //����ϐ�+5
                    buff.ailment[SPIRIT] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("����ϐ�+5");
                    break;
                case 75:                                //��Z�ϐ�+5
                    buff.ailment[SECRET] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("��Z�ϐ�+5");
                    break;
                case 76:                                //���|�ϐ�+5
                    buff.ailment[TERROR] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���|�ϐ�+5");
                    break;
                case 77:                                //�Z�p����+3
                    buff.ailment[HIT_STUN] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�Z�p����+3");
                    break;
                case 78:                                //���얽��+3
                    buff.ailment[HIT_SPIRIT] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���얽��+3");
                    break;
                case 79:                                //��Z����+3
                    buff.ailment[HIT_SECRET] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("��Z����+3");
                    break;
                case 80:                                //���|����+3
                    buff.ailment[HIT_TERROR] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���|����+3");
                    break;
                case 81:                                //�΂̑�����R+30
                    buff.element_resist[FIRE] += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�΂̑�����R+30");
                    break;
                case 82:                                //�n�̑�����R+30
                    buff.element_resist[EARTH] += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�n�̑�����R+30");
                    break;
                case 83:                                //���̑�����R+30
                    buff.element_resist[WATER] += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���̑�����R+30");
                    break;
                case 84:                                //���̑�����R+30
                    buff.element_resist[WIND] += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���̑�����R+30");
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
                case 90:                                //�����d�ʑ���+300(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�����d�ʑ���+300(������)");
                    break;
                case 91:                                //1�i����(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("1�i����(������)");
                    break;
//�p�Y
                case 92:                                //�ߋ����_���[�W+5
                    buff.DMG_SHORT += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ����_���[�W+5");
                    break;
                case 93:                                //�������_���[�W+5
                    buff.DMG_LONG += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�������_���[�W+5");
                    break;
                case 94:                                //�ߋ�������+5
                    buff.HIT_SHORT += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ�������+5");
                    break;
                case 95:                                //����������+5
                    buff.HIT_LONG += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("����������+5");
                    break;
                case 96:                                 //SP+5
                    buff.SP += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("SP+5");
                    break;
                case 97:                                 //���@����+5
                    buff.HIT_MAGIC += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���@����+5");
                    break;
                case 98:                                 //�_���[�W����+5
                    buff.DR += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�_���[�W����+5");
                    break;
                case 99:                                 //AC-5
                    buff.AC -= 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("AC-5");
                    break;
                case 100:                                 //MR+15%
                    buff.MR += 15;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MR+15%");
                    break;
                case 101:                                //�ő�HP+300
                    buff.HP += 300;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ő�HP+300");
                    break;
                case 102:                                //�ő�MP+200
                    buff.MP += 200;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ő�MP+200");
                    break;
                case 103:                                //�ߋ������(DG)+10
                    buff.DG += 10;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�ߋ������(DG)+10");
                    break;
                case 104:                                //HP��Ή�+150(32�b)(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("HP��Ή�+150(32�b)(������)");
                    break;
                case 105:                                //MP��Ή�+30(64�b)(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MP��Ή�+30(64�b)(������)");
                    break;
                case 106:                                //���������(ER)+12
                    buff.ER += 12;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���������(ER)+12");
                    break;
                case 107:                                //PVP�ǉ��_���[�W+7
                    buff.PVP += 7;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP�ǉ��_���[�W+7");
                    break;
                case 108:                                //PVP�_���[�W����+7
                    buff.PVP_DR += 7;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP�_���[�W����+7");
                    break;
                case 109:                                //PVP���@�_���[�W����+10(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP���@�_���[�W����+10(������)");
                    break;
                case 110:                                //PVP�_���[�W��������+10(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP�_���[�W��������+10(������)");
                    break;
                case 111:                                //�Z�p�ϐ�+8
                    buff.ailment[STUN] += 8;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�Z�p�ϐ�+8");
                    break;
                case 112:                                //����ϐ�+8
                    buff.ailment[SPIRIT] += 8;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("����ϐ�+8");
                    break;
                case 113:                                //��Z�ϐ�+8
                    buff.ailment[SECRET] += 8;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("��Z�ϐ�+8");
                    break;
                case 114:                                //���|�ϐ�+8
                    buff.ailment[TERROR] += 8;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���|�ϐ�+8");
                    break;
                case 115:                                //�S�Ă̑ϐ�+3
                    buff.ailment[STUN] += 3;
                    buff.ailment[SPIRIT] += 3;
                    buff.ailment[SECRET] += 3;
                    buff.ailment[TERROR] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�S�Ă̑ϐ�+3");
                    break;
                case 116:                                //�Z�p����+5
                    buff.ailment[HIT_STUN] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�Z�p����+5");
                    break;
                case 117:                                //���얽��+5
                    buff.ailment[HIT_SPIRIT] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���얽��+5");
                    break;
                case 118:                                //��Z����+5
                    buff.ailment[HIT_SECRET] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("��Z����+5");
                    break;
                case 119:                                //���|����+5
                    buff.ailment[HIT_TERROR] += 5;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���|����+5");
                    break;
                case 120:                                //���ׂẴX�L������+3
                    buff.ailment[HIT_STUN] += 3;
                    buff.ailment[HIT_SPIRIT] += 3;
                    buff.ailment[HIT_SECRET] += 3;
                    buff.ailment[HIT_TERROR] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���ׂẴX�L������+3");
                    break;
                case 121:                                //���ׂĂ̑�����R+30
                    buff.element_resist[FIRE] += 30;
                    buff.element_resist[EARTH] += 30;
                    buff.element_resist[WATER] += 30;
                    buff.element_resist[WIND] += 30;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���ׂĂ̑�����R+30");
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
                case 127:                                 //���ׂẴX�e�[�^�X+1(CHA�ȊO)
                    buff.ST[STR] += 1;
                    buff.ST[DEX] += 1;
                    buff.ST[CON] += 1;
                    buff.ST[WIS] += 1;
                    buff.ST[INT] += 1;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���ׂẴX�e�[�^�X+1(CHA�ȊO)");
                    break;
                case 128:                                 //MP�z��(����)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MP�z��(����)");
                    break;
                case 129:                                //�����d�ʑ���+500(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�����d�ʑ���+500(������)");
                    break;
//�`��
                case 130:                                //PVP�_���[�W��������+40(������)
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("PVP�_���[�W��������+40(������)");
                    break;
                case 131:                                //�C�~���[�����ʌ���-30%(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�C�~���[�����ʌ���-30%(������)");
                    break;
                case 132:                                 //���ׂẴX�e�[�^�X+3(CHA�ȊO)
                    buff.ST[STR] += 3;
                    buff.ST[DEX] += 3;
                    buff.ST[CON] += 3;
                    buff.ST[WIS] += 3;
                    buff.ST[INT] += 3;
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("���ׂẴX�e�[�^�X+3(CHA�ȊO)");
                    break;
                case 133:                                //HP�z��(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("HP�z��(������)");
                    break;
                case 134:                                //MP�z��(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("MP�z��(������)");
                    break;
                case 135:                                //�\�E�� �I�u �t���C��(�}�W�b�N�h�[��)����(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�\�E�� �I�u �t���C��(�}�W�b�N�h�[��)����(������)");
                    break;
                case 136:                                //�W���b�W�����g(�}�W�b�N�h�[��)����(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�W���b�W�����g(�}�W�b�N�h�[��)����(������)");
                    break;
                case 137:                                //�f�B�P�C�|�[�V����(�}�W�b�N�h�[��)����(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�f�B�P�C�|�[�V����(�}�W�b�N�h�[��)����(������)");
                    break;
                case 138:                                //4�i�K����(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("4�i�K����(������)");
                    break;
                case 139:                                //1�i�K/3�i�K����(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("1�i�K/3�i�K����(������)");
                    break;
                case 140:                                //�����d�ʑ���+500(������)
                    //������
                    ui.cb_buff[ITEM_MD_OP2].setToolTipText("�����d�ʑ���+500(������)");
                    break;
                default:
                    break;
            }
        }

        //�[�C�̗�
        if (ui.cb_buff[ITEM_SEA].isSelected()) {
            switch (ui.cb_buff_group[ITEM_SEA].getSelectedIndex()) {
                case 0:                                 //�h���S���̐�
                    buff.DMG_SHORT += 3;
                    buff.DMG_LONG += 3;
                    buff.HIT_SHORT += 3;
                    buff.HIT_LONG += 3;
                    buff.SP += 3;
                    ui.cb_buff[ITEM_SEA].setToolTipText("�ߋ����_���[�W+3 �������_���[�W+3 �ߋ�������+3 ����������+3 SP+3");
                    break;
                case 1:                                 //���{�̃|�[�V����
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.HIT_SHORT += 2;
                    buff.HIT_LONG += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("�ߋ����_���[�W+2 �������_���[�W+2 �ߋ�������+2 ����������+2");
                    break;
                case 2:                                 //�W���̃|�[�V����
                    buff.SP += 3;
                    ui.cb_buff[ITEM_SEA].setToolTipText("SP+3");
                    break;
                case 3:                                 //�r�͂̃|�[�V����
                    buff.ST[STR] += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("STR+2");
                    break;
                case 4:                                 //�@�q�̃|�[�V����
                    buff.ST[DEX] += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("DEX+2");
                    break;
                case 5:                                 //�̗͂̃|�[�V����
                    buff.ST[CON] += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("CON+2");
                    break;
                case 6:                                 //�m�͂̃|�[�V����
                    buff.ST[INT] += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("INT+2");
                    break;
                case 7:                                 //���_�̃|�[�V����
                    buff.ST[WIS] += 2;
                    ui.cb_buff[ITEM_SEA].setToolTipText("WIS+2");
                    break;
                case 8:                                 //���m�̐퓬�����X�N���[��
                    buff.DMG_SHORT += 3;
                    buff.HIT_SHORT += 5;
                    buff.PVP_DR += 3;
                    ui.cb_buff[ITEM_SEA].setToolTipText("�ߋ����_���[�W+3 �ߋ�������+5 PVP�_���[�W�ቺ+3");
                    break;
                case 9:                                 //�ˎ�̐퓬�����X�N���[��
                    buff.DMG_LONG += 3;
                    buff.HIT_LONG += 5;
                    buff.PVP_DR += 3;
                    ui.cb_buff[ITEM_SEA].setToolTipText("�������_���[�W+3 ����������+5 PVP�_���[�W�ቺ+3");
                    break;
                case 10:                                //���҂̐퓬�����X�N���[��
                    buff.SP += 3;
                    buff.HIT_MAGIC += 5;
                    buff.PVP_DR += 3;
                    ui.cb_buff[ITEM_SEA].setToolTipText("SP+3 ���@����+5 PVP�_���[�W�ቺ+3");
                    break;
                default:
                    break;
            }
        }
        //�����̗�
        if (ui.cb_buff[ITEM_BREEZE].isSelected()) {
            switch (ui.cb_buff_group[ITEM_BREEZE].getSelectedIndex()) {
                case 0:                                 //�����̃|�[�V����
                    buff.HPR += 10;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("HPR+10");
                    break;
                case 1:                                 //�ґz�̃|�[�V����
                    buff.MPR += 10;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("MPR+10");
                    break;
                case 2:                                 //�����̃|�[�V����
                    buff.HP += 120;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("HP+120");
                    break;
                case 3:                                 //���@�̃|�[�V����
                    buff.MP += 80;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("MP+80");
                    break;
                case 4:                                 //���@��R�̃|�[�V����
                    buff.MR += 10;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("MR+10");
                    break;
                case 5:                                 //�p�m�̃|�[�V����
                    buff.MP += 60;
                    buff.MPR += 4;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("MP+60 MPR+4");
                    break;
                case 6:                                 //���m�̃|�[�V����
                    buff.HP += 100;
                    buff.HPR += 8;
                    ui.cb_buff[ITEM_BREEZE].setToolTipText("HP+100 HPR+8");
                    break;
                default:
                    break;
            }
        }

        // ����
        if (ui.cb_buff[ITEM_COOKING].isSelected()) {
            switch (ui.cb_buff_group[ITEM_COOKING].getSelectedIndex()) {
                case 10:                                 //�p�^���V�̎��ʒ��Ă�
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.HPR += 2;
                    buff.MPR += 3;
                    buff.MR += 10;
                    buff.MEXP += 10;                                       //�l���o���l+10%
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.element_resist[WATER] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 SP+2 �l���o���l+10% �_���[�W�ቺ+2 15��"+"</html>");
                    break;
                case 9:                                 //�p�^���V�̃T�[�����J�i�b�y
                    buff.DR += 2;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.DMG_LONG += 2;
                    buff.HIT_LONG += 1;
                    buff.MEXP += 10;                                       //�l���o���l+10%
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.element_resist[WATER] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+2 �������_���[�W+2 ����������+1 �l���o���l+10% �_���[�W�ቺ+2 15��"+"</html>");
                    break;
                case 8:                                 //�p�^���V�̘a���X�e�[�L
                    buff.DR += 2;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 1;
                    buff.MEXP += 10;                                       //�l���o���l+10%
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.element_resist[WATER] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+2 �ߋ����_���[�W+2 �ߋ�������+1 �l���o���l+10% �_���[�W�ቺ+2 15��"+"</html>");
                    break;
                case 7:                                 //�^�S��������������
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "�ߋ����_���[�W+2 �ߋ�������+2 �������_���[�W+2 ����������+2"
                                                            + "<br>"+ "MR+15 HPR+3 MPR+4 SP+2 �_���[�W�ቺ+5 15��20�b"+"</html>");
                    break;
                case 6:                                 //�����Ȗ˗���
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "�ߋ����_���[�W+2 �ߋ�������+2 �������_���[�W+2 ����������+2"
                                                            + "<br>"+ "MR+15 HPR+3 MPR+4 SP+2 �_���[�W�ቺ+5 15��20�b"+"</html>");
                    break;
                case 5:                                 //�j�����ꂽ�������ʒ��Ă�
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.HPR += 2;
                    buff.MPR += 3;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WATER] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    buff.ailment[HIT_STUN] += 3;            //�Z�p����+3
                    buff.ailment[HIT_SPIRIT] += 3;          //���얽��+3
                    buff.ailment[HIT_SECRET] += 3;          //��Z����+3
                    buff.ailment[HIT_TERROR] += 3;          //���|����+3
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 SP+2 �_���[�W�ቺ+2 �S�N���X�X�L������+3 30��"+"</html>");
                    break;
                case 4:                                 //�������ʒ��Ă�
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.HPR += 2;
                    buff.MPR += 3;
                    buff.MR += 10;
                    buff.element_resist[FIRE] += 10;
                    buff.element_resist[WATER] += 10;
                    buff.element_resist[WIND] += 10;
                    buff.element_resist[EARTH] += 10;
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 SP+2 �_���[�W�ቺ+2 30��"+"</html>");
                    break;
                case 3:                                 //�j�����ꂽ�f�������̎ϕt
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
                    buff.ailment[HIT_STUN] += 3;            //�Z�p����+3
                    buff.ailment[HIT_SPIRIT] += 3;          //���얽��+3
                    buff.ailment[HIT_SECRET] += 3;          //��Z����+3
                    buff.ailment[HIT_TERROR] += 3;          //���|����+3
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 �������_���[�W+2 ����������+1 �_���[�W�ቺ+2 �S�N���X�X�L������+3 30��"+"</html>");
                    break;
                case 2:                                 //�f�������̎ϕt
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 �������_���[�W+2 ����������+1 �_���[�W�ቺ+2 30��"+"</html>");
                    break;
                case 1:                                 //�j�����ꂽ�͋����a���X�e�[�L
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
                    buff.ailment[HIT_STUN] += 3;            //�Z�p����+3
                    buff.ailment[HIT_SPIRIT] += 3;          //���얽��+3
                    buff.ailment[HIT_SECRET] += 3;          //��Z����+3
                    buff.ailment[HIT_TERROR] += 3;          //���|����+3
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 �ߋ����_���[�W+2 �ߋ�������+1 �_���[�W�ቺ+2 �S�N���X�X�L������+3 30��"+"</html>");
                    break;
                case 0:                                 //�͋����a���X�e�[�L
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+ "��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
                                                            + "<br>"+ "MR+10 HPR+2 MPR+3 �ߋ����_���[�W+2 �ߋ�������+1 �_���[�W�ቺ+2 30��"+"</html>");
                    break;
                default:
                    break;

            }
        }
        // �f�U�[�g
        if (ui.cb_buff[ITEM_DESSERT].isSelected()) {
            switch (ui.cb_buff_group[ITEM_DESSERT].getSelectedIndex()) {
                case 0:                                 //�C���̌{�X�[�v
                    buff.MEXP += 4;                     //�l���o���l+4%
                    buff.DR += 2;
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+2 �l���o���l+4% 30��");
                    break;
                case 1:                                 //�j�����ꂽ�C���̌{�X�[�v
                    buff.DR += 2;
                    buff.ailment[STUN] += 2;            //�Z�p�ϐ�+2
                    buff.ailment[SPIRIT] += 2;          //����ϐ�+2
                    buff.ailment[SECRET] += 2;          //��Z�ϐ�+2
                    buff.ailment[TERROR] += 2;          //���|�ϐ�+2
                    buff.PVP_DR += 2;                   //PvPDR+2
                    buff.MEXP += 4;                     //�l���o���l+4%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+2 �S�N���X�X�L���ϐ�+2 PvPDR+2 �l���o���l+4% 30��");
                    break;
                case 2:                                 //���z�̃o�V���X�N�̗��X�[�v
                    buff.DR += 5;
                    buff.MEXP += 3;                     //�l���o���l+3%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+5 �l���o���l+3% 15��20�b");
                    break;
                case 3:                                 //���z�̃V���[�g�P�[�L
                    buff.DR += 5;
                    buff.MEXP += 10;                    //�l���o���l+10%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+5 �l���o���l+10% 15��20�b");
                    break;
                case 4:                                 //�����Ȍg�ш���
                    buff.DR += 5;
                    buff.MEXP += 5;                     //�l���o���l+5%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+5 �l���o���l+5% 15��20�b");
                    break;
                case 5:                                 //�^�S�����������X�[�v
                    buff.DR += 5;
                    buff.MEXP += 5;                     //�l���o���l+5%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+5 �l���o���l+5% 15��20�b");
                    break;
                case 6:                                 //�p�^���V�̃L�m�R�X�[�v
                    buff.DR += 2;
                    buff.MEXP += 10;                    //�l���o���l+10%
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+2 �l���o���l+10% 15��");
                    break;
                default:
                    break;
            }
        }
            //�R�}�G���`��
            if (ui.cb_buff[KOMA].isSelected()) {
            switch (ui.cb_buff_group[KOMA].getSelectedIndex()) {
                case 0:
                    buff.ST[STR] += 5;
                    buff.ST[DEX] += 5;
                    buff.ST[CON] += 1;
                    buff.HIT_SHORT += 3;
                    buff.AC -= 3;
                    ui.cb_buff[KOMA].setToolTipText("STR+5 DEX+5 CON+1 �ߋ�������+3 AC-3");
                    break;
                case 1:
                    buff.ST[STR] += 5;
                    buff.ST[DEX] += 5;
                    buff.ST[CON] += 3;
                    buff.HIT_SHORT += 5;
                    buff.AC -= 8;
                    buff.SP += 1;
                    ui.cb_buff[KOMA].setToolTipText("STR+5 DEX+5 CON+3 �ߋ�������+5 AC-8 SP+1");
                    break;
                default:
                    break;
            }
        }

        cons_mp = 0;

//�E�B�U�[�h�̖��@
        //�C���r�W�r���e�B
        ui.cb_buff[W_INY].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "�p�҂ɓ������ʂ��K�p�����"
                                         + "<br>"+ "�ړ��ƕ⏕���@�ȊO�̍s��������ƁA���ʂ��؂��"
                                         + "<br>"+ "�N�[���^�C��:4�b"
                                         + "<br>"+ "�A�ҕs�\�̏�Ԃł͉r���s�\"
                                         + "<br>"+ "[�K�����x��:64][��������:���������܂�][�Ώ�:�p��][�G�}:���͂̐�(1]"+"</html>");
        if (ui.cb_buff[W_INY].isSelected()) {
        //�X�L�����ʖ�����
        }
        
        //�C�~���[���g�D�n�[��:�Z�C���g
        ui.cb_buff[W_IHS].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "�����Ɏg�p�������A�C�~���[���g�D�n�[���̎������Ԃ�60�b�ɂ���"
                                         + "<br>"+ "���x��82����A���x��2����PvP�_���[�W�ቺ+1%����"
                                         + "<br>"+ "���x��91����A���x��1����PvP�_���[�W�ቺ+1%����(�ő�+10%)"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[W_IHS].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�G�^�j�e�B
        ui.cb_buff[W_ETY].setToolTipText("<html>"+ "[����MP:80][����HP:--]"
                                         + "<br>"+ "10�Z�����̑ΏۂɁA���͂ȃ_���[�W�ƒǉ����@�_���[�W"
                                         + "<br>"+ "�X�Ɉ��m����[�A�ҕs�\]�ɂ���"
                                         + "<br>"+ "�ŏ��̃_���[�W�́A�J�E���^�[�}�W�b�N�Ŗh�����Ƃ��o���Ȃ�"
                                         + "<br>"+ "7�Z������A�A�ҕs�\�̌��ʂ͋����������قǐ����m�����ቺ����)"
                                         + "<br>"+ "[�K�����x��:85][��������:�ő�4�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[W_ETY].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���f�B�e�[�V����:�r�����h
        ui.cb_buff[W_MBD].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "���f�B�e�[�V�����̌��ʂ��ړ��Ɛ퓬���ł���������"
                                         + "<br>"+ "*WIZ���u�[�g MP�񕜃|�[�V�����g�p���ɂ͍ő�MP��2%�ǉ���"
                                         + "<br>"+ "[�K�����x��:85][��������:--][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[W_MBD].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�}�X �C�~���[�� �g�D �n�[��
        ui.cb_buff[W_MIT].setToolTipText("<html>"+ "[����MP:120][����HP:--]"
                                         + "<br>"+ "8�Z�����ɋ���PT�̌������ɁA�C�~���[���g�D�n�[���̌���"
                                         + "<br>"+ "�p�҂ƌ������̊Ԃɏ�Q��������ƌ��ʂ�����"
                                         + "<br>"+ "�C�~���[���g�D�n�[���F�Z�C���g���K�����Ă���Əp�҂̓Z�C���g�A�������͒ʏ�̌���"
                                         + "<br>"+ "*��̉� 15�Z������8�Z����"
                                         + "<br>"+ "[�K�����x��:85][��������:�ő�32�b][�Ώ�:������][�G�}:���͂̐�(8)]"+"</html>");
        if (ui.cb_buff[W_MIT].isSelected()) {
        //�X�L�����ʖ�����
        }

//�R�m�̋Z�p
        //*�t�H�[�X�X�^��
        ui.cb_buff[K_FSN].setToolTipText("<html>"+ "[����MP:17][����HP:--]"
                                         + "<br>"+ "1�Z�����̑ΏۂɃ_���[�W��^���A���m���ŃX�^����Ԃɂ���"
                                         + "<br>"+ "�X�Ɉ��m���Ŏ������Ԃ������A�����X�^������������"
                                         + "<br>"+ "�U���������������ǂ����͊֌W�Ȃ����ʂ���������"
                                         + "<br>"+ "�t�H�[�X�X�^���̃_���[�W�́ASTR�ƕ���_���[�W�̉e�����󂯂܂�"
                                         + "<br>"+ "[�K�����x��:85][��������:�ő�7�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[K_FSN].isSelected()) {
        //�X�L�����ʖ�����
        }

        //*�A�u�\���[�g�u���C�h
        ui.cb_buff[K_ABE].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "�U�����������ɁA���m���ŃA�u�\���[�g�o���A��j�󂵂ċ����I�ɉ�������"
                                         + "<br>"+ "���x��80����A���x��1���ɔ�����+1%(�ő�+8%)"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:85][��������:32�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_ABE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //*�J�E���^�[�o���A ����MP15/2mins
        ui.cb_buff[K_CBR].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "���茕������ ���m��(20%)�ŋߋ����U�����+����"
                                         + "<br>"+ "�J�E���^�[�_���[�W�͕����([BIG�Ō��l]+[�ǉ��_���[�W]+[������])x[2]"
                                         + "<br>"+ "[�K�����x��:80][��������:2��8�b][�Ώ�:�p��][�G�}:������(100)]"+"</html>");
        if (ui.cb_buff[K_CBR].isSelected()) {
            if (level >= 80 && cls == K && buki.type.equals("���茕")) {
            // CB���ʖ�����
            } else {
                ui.cb_buff[K_CBR].setSelected(false);
                ui.cb_buff[K_CBV].setSelected(false);
            }
        }

        //�u���[�A�^�b�N
        //8210�s�ɂď���

        //�o�E���X�A�^�b�N
        ui.cb_buff[K_BOK].setToolTipText("<html>"+ "[����MP:10][����HP:60]"
                                         + "<br>"+ "�ߋ�������+6"
                                         + "<br>"+ "[�K�����x��:65][��������:1��4�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_BOK].isSelected()) {
            if (level >= 60 && cls == K) {
                buff.HIT_SHORT += 6;
            } else {
                ui.cb_buff[K_BOK].setSelected(false);
            }
        }

        //*�V���b�N�X�^��
        ui.cb_buff[K_SSN].setToolTipText("<html>"+ "[����MP:13][����HP:--]"
                                         + "<br>"+ "1�Z�����̑ΏۂɃ_���[�W��^���A���m���ŃX�^����Ԃɂ���"
                                         + "<br>"+ "�U���������������ǂ����͊֌W�Ȃ����ʂ���������"
                                         + "<br>"+ "[�K�����x��:60][��������:�ő�6�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[K_SSN].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���_�N�V�����A�[�}�[
        ui.cb_buff[K_RAR].setToolTipText("<html>"+ "[����MP:7][����HP:50]"
                                         + "<br>"+ "�_���[�W�ቺ+1"
                                         + "<br>"+ "���x��50���烌�x��5���Ƀ_���[�W�ቺ+1"
                                         + "<br>"+ "[�K�����x��:50][��������:5��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_RAR].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.DR += (level - 50) / 5 + 1;
            } else {
                ui.cb_buff[K_RAR].setSelected(false);
            }
        }

        //*�J�E���^�[�o���A:�x�e����
        ui.cb_buff[K_CBV].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�J�E���^�[�o���A�̔��������グ��"
                                         + "<br>"+ "85���x������1���x�����ɔ����m��1%����"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_CBV].isSelected()) {
            if (level >= 85 && cls == K && buki.type.equals("���茕")) {
                ui.cb_buff[K_CBR].setSelected(true);
                //�X�L�����ʖ�����
            } else {
                ui.cb_buff[K_CBR].setSelected(false);
                ui.cb_buff[K_CBV].setSelected(false);
            }
        }

        //���C�W���O�t�H�[�X
        ui.cb_buff[K_RFE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "���x��80���烌�x��3���ɋZ�p������+1������"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_RFE].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.ailment[HIT_STUN] += (level - 80) / 3 + 1;                 //�Z�p����(level - 80) / 3 + 1
            } else {
                ui.cb_buff[K_RFE].setSelected(false);
            }
        }

        //���_�N�V�����A�[�}�[:�x�e����
        ui.cb_buff[K_RAV].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "���_�N�V�����A�[�}�[�ɋ��|�ϐ�+3��ǉ�"
                                         + "<br>"+ "���_�N�V�����A�[�}�[���o���Ă��Ȃ��ƏK�����鎖���o���Ȃ�"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_RAV].isSelected()) {
            if (level >= 80 && cls == K) {
                ui.cb_buff[K_RAR].setSelected(true);
                buff.ailment[TERROR] += 3;                                      //���|�ϐ�+3
            } else {
                ui.cb_buff[K_RAV].setSelected(false);
            }
        }

        //�v���C�h
        //7216�s�ɂď���

        //�\���b�h�L�����b�W
        ui.cb_buff[K_SCE].setToolTipText("<html>"+ "[����MP:10][����HP:100]"
                                         + "<br>"+ "�������� ER+15"
                                         + "<br>"+ "[�K�����x��:55][��������:3��12�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_SCE].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.ER += 15;
            } else {
                ui.cb_buff[K_SCE].setSelected(false);
            }
        }

        //*�V���b�N�A�^�b�N
        ui.cb_buff[K_SAK].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "3�Z�����̑Ώۂɋ��͂ȕ����I�ȃ_���[�W�ƈړ����x����"
                                         + "<br>"+ "�ړ����x�������X�^�������m������+�m���I�ɋA�ҕs����"
                                         + "<br>"+ "�ʃN�[���^�C��"
                                         + "<br>"+ "[�K�����x��:85][��������:�ő�4�b][�Ώ�:PC/NPC][�G�}:������(25)]"+"</html>");
        if (ui.cb_buff[K_SAK].isSelected()) {
        //�X�L�����ʖ�����
        }

        //*���C�W���O�E�F�|��
        ui.cb_buff[K_RWN].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "���茕�U�����x10%����"
                                         + "<br>"+ "[�K�����x��:88][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_RWN].isSelected()) {
        //�X�L�����ʖ�����
        }

        //*�J�E���^�[�o���A:�}�X�^�[
        ui.cb_buff[K_CBM].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�J�E���^�[�o���A�[��������HP�̈��ʉ�"
                                         + "<br>"+ "�J�E���^�[�o���A�[�����𖳗͉�����X�L���̔�����������"
                                         + "<br>"+ "[�K�����x��:86][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_CBM].isSelected()) {
        //�X�L�����ʖ�����
        }

//���얂�@
        //�O���[���[�A�[�X
        ui.cb_buff[E_GEH].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "2�̑����n����g�p�\�ɂ���"
                                         + "<br>"+ "�����n��Ɋ֌W���閂�@�͓����Ɍ��ʂ𓾂� �T�����̓����_���ŏ��������"
                                         + "<br>"+ "PVP�_���[�W�ቺ+30[������5%]"
                                         + "<br>"+ "�g���v���A���[�̃G�t�F�N�g�����ʎd�l�ɂȂ�܂�"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_GEH].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���x���[�V����
        ui.cb_buff[E_LIN].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "��Ԉُ�X�L���̎��Ԃ�����������"
                                         + "<br>"+ "[�K�����x��:85][��������:320�b][�Ώ�:�p��][�G�}:����̋�(4)]"+"</html>");
        if (ui.cb_buff[E_LIN].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�G�������X�g���C�N
        ui.cb_buff[E_ESE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "6�Z�����̑ΏۂɃ_���[�W��^���A���m���Ńz�[���h��Ԃɂ���"
                                         + "<br>"+ "�ʃN�[���^�C��(60�b)"
                                         + "<br>"+ "[�K�����x��:85][��������:5�b�ȉ�][�Ώ�:PC/NPC][�G�}:����̋�(1)]"+"</html>");
        if (ui.cb_buff[E_ESE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�o�[�j���O�V���b�g
        ui.cb_buff[E_BST].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�_���[�W��20%�������� �S�X�L���ϐ�+3 PvP�_���[�W�ቺ+10"
                                         + "<br>"+ "�X�L���g�p���̎��A�p�҂�[�ړ��s�\][�A�ҕs�\][�|�̎˒���������]"
                                         + "<br>"+ "[�K�����x��:90][��������:??�b][�Ώ�:�p��][�G�}:����̋�(2)]"+"</html>");
        if (ui.cb_buff[E_BST].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�\�E���o���A:�A�[�}�[
        ui.cb_buff[E_SBA].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�\�E���o���A��������������[�_���[�W�ቺ+2][PvP�_���[�W�ቺ+2]�̌��ʂ�ǉ�"
                                         + "<br>"+ "���x��90����A���x��2���Ɍ��ʂ�2������(�ő�+10)"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_SBA].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�X�g���C�J�[�Q�C��:�V���b�g
        ui.cb_buff[E_SGS].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�X�g���C�J�[�Q�C����[�ړ��s�\(4�b)][�q�[���񕜗ʒቺ]�̌��ʂ�ǉ�"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_SGS].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�}�W�b�N�V�[���h
        ui.cb_buff[E_MSD].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "��ʓI�ȃf�o�t��h�����m���Ō��ʂ�������(�`����/���A���͕s�\)"
                                         + "<br>"+ "�ʃN�[���^�C��(60�b)"
                                         + "<br>"+ "[�K�����x��:85][��������:12�b][�Ώ�:�p��][�G�}:����̋�(5)]"+"</html>");
        if (ui.cb_buff[E_MSD].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�\�E���o���A
        ui.cb_buff[E_SBR].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "HP��10�ȉ��ɂȂ�ƁA�󂯂��_���[�W����MP������đς���"
                                         + "<br>"+ "�����������HP��11�ȏ�ɂȂ邩MP��0�ɂȂ�ƌ��ʂ������I�ɏ�����"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:80][��������:10��][�Ώ�:�p��][�G�}:����̋�(2)]"+"</html>");
        if (ui.cb_buff[E_SBR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�G���A�T�C�����X
        ui.cb_buff[E_ASE].setToolTipText("<html>"+ "[����MP:40][����HP:--]"
                                         + "<br>"+ "�͈�3�Z�����̑Ώۂ��A���m���Œ��ُ�Ԃɂ���"
                                         + "<br>"+ "[�K�����x��:75][��������:16�b][�Ώ�:PC/NPC][�G�}:����̋�(8)]"+"</html>");
        if (ui.cb_buff[E_ASE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�G�������O�����B�e�B�[
        //7360�s�ɂď���

        //�O���[�^�[�G�������^��
        ui.cb_buff[E_GEL].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�I�����Ă���n��̑吸�����������"
                                         + "<br>"+ "[�K�����x��:75][��������:1����][�Ώ�:--][�G�}:����̋�(4)]"+"</html>");
        if (ui.cb_buff[E_GEL].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�C���[�X�}�W�b�N
        ui.cb_buff[E_EMC].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "6�Z�����̑Ώۂ��A���m���őf��MR��2����1�ɂ���"
                                         + "<br>"+ "���@�U�����󂯂�ƌ��ʂ͏�����"
                                         + "<br>"+ "[�K�����x��:60][��������:32�b][�Ώ�:PC/NPC][�G�}:����̋�(1)]"+"</html>");
        if (ui.cb_buff[E_EMC].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�G�������^���t�H�[���_�E��
        ui.cb_buff[E_EFN].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "10�Z�����̑Ώۂ��A���m���őI�����Ă���n��̑�����R-50"
                                         + "<br>"+ "[�K�����x��:60][��������:1��4�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[E_EFN].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�T�������b�T�[�G�������^��
        ui.cb_buff[E_SLE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�I�����Ă���n��̐������������"
                                         + "<br>"+ "[�K�����x��:60][��������:1����][�Ώ�:--][�G�}:����̋�(2)]"+"</html>");
        if (ui.cb_buff[E_SLE].isSelected()) {
        //�X�L�����ʖ�����
        }


        //�g���v���A���[
        ui.cb_buff[E_TAW].setToolTipText("<html>"+ "[����MP:25][����HP:--]"
                                         + "<br>"+ "10�Z�����̑Ώۂ�3�A���U��������"
                                         + "<br>"+ "����|�𑕔������12�Z��"
                                         + "<br>"+ "[�K�����x��:45][��������:�u��][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[E_TAW].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�u���b�f�B�\�E��
        ui.cb_buff[E_BSL].setToolTipText("<html>"+ "[����MP:--][����HP:25]"
                                         + "<br>"+ "MP��15�񕜂���"
                                         + "<br>"+ "ON/OFF�̐ݒ肪�\ ON�ɂ����5�b�Ԋu�Ŏ����r������"
                                         + "<br>"+ "[�K�����x��:45][��������:�u��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_BSL].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�G�������^���v���e�N�V����
        ui.cb_buff[E_EPN].setToolTipText("<html>"+ "[����MP:6][����HP:--]"
                                         + "<br>"+ "�I�����Ă���n��̑�����R50"
                                         + "<br>"+ "�O���[���[�A�[�X�擾����2�����͕s��"
                                         + "<br>"+ "[�K�����x��:45][��������:1��4�b][�Ώ�:�p��]"+"</html>");

        if (ui.cb_buff[E_EPN].isSelected()) {
                switch ((String) ui.cb_buff_group[E_EPN].getSelectedItem()) {
                case "�΃G���t":
                    ui.cb_buff[E_EPN].setToolTipText("�Α�����R50");
                    buff.element_resist[FIRE] += 50;
                    break;
                case "���G���t":
                    ui.cb_buff[E_EPN].setToolTipText("��������R50");
                    buff.element_resist[WATER] += 50;
                    break;
                case "���G���t":
                    ui.cb_buff[E_EPN].setToolTipText("��������R50");
                    buff.element_resist[WIND] += 50;
                    break;
                case "�n�G���t":
                    ui.cb_buff[E_EPN].setToolTipText("�n������R50");
                    buff.element_resist[EARTH] += 50;
                    break;
                case "��*���G���t":
                    ui.cb_buff[E_EPN].setToolTipText("�Α�����R50 ��������R50");
                    buff.element_resist[FIRE] += 50;
                    buff.element_resist[WATER] += 50;
                    break;
                case "��*���G���t":
                    ui.cb_buff[E_EPN].setToolTipText("�Α�����R50 ��������R50");
                    buff.element_resist[FIRE] += 50;
                    buff.element_resist[WIND] += 50;
                    break;
                case "��*�n�G���t":
                    ui.cb_buff[E_EPN].setToolTipText("�Α�����R50 �n������R50");
                    buff.element_resist[FIRE] += 50;
                    buff.element_resist[EARTH] += 50;
                    break;
                case "��*���G���t":
                    ui.cb_buff[E_EPN].setToolTipText("��������R50 ��������R50");
                    buff.element_resist[WATER] += 50;
                    buff.element_resist[WIND] += 50;
                    break;
                case "��*�n�G���t":
                    ui.cb_buff[E_EPN].setToolTipText("��������R50 �n������R50");
                    buff.element_resist[WATER] += 50;
                    buff.element_resist[EARTH] += 50;
                    break;
                case "��*�n�G���t":
                    ui.cb_buff[E_EPN].setToolTipText("��������R50 �n������R50");
                    buff.element_resist[WIND] += 50;
                    buff.element_resist[EARTH] += 50;
                    break;
                default:
                    break;
                }
        }

        //���W�X�g�G�������g
        ui.cb_buff[E_RET].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "���W�X�g�}�W�b�N�ɉ��L�̌��ʂ�ǉ�"
                                         + "<br>"+ "MR+5 �S������R+5"
                                         + "<br>"+ "[�K�����x��:30][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_RET].isSelected()) {
            buff.MR += 5;
            buff.element_resist[FIRE] += 5;
            buff.element_resist[WATER] += 5;
            buff.element_resist[WIND] += 5;
            buff.element_resist[EARTH] += 5;
        }

        //�N���A�[�}�C���h
        ui.cb_buff[E_CMD].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "STR+1 DEX+1 INT+1"
                                         + "<br>"+ "[�K�����x��:30][��������:20��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_CMD].isSelected()) {
            buff.ST[STR] += 1;
            buff.ST[DEX] += 1;
            buff.ST[INT] += 1;
        }

        //�e���|�[�g�g�D�}�U�[
        ui.cb_buff[E_TTM].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "�}�U�[�c���[�Ƀe���|�[�g����"
                                         + "<br>"+ "�e���|�[�g�֎~���ł͉r���s�\"
                                         + "<br>"+ "[�K�����x��:15][��������:�u��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_TTM].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�{�f�B�g�D�}�C���h
        ui.cb_buff[E_BTM].setToolTipText("<html>"+ "[����MP:--][����HP:8]"
                                         + "<br>"+ "MP��2�񕜂���"
                                         + "<br>"+ "[�K�����x��:15][��������:�u��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_BTM].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���W�X�g�}�W�b�N
        ui.cb_buff[E_RMC].setToolTipText("<html>"+ "[����MP:5][����HP:--]"
                                         + "<br>"+ "MR+10"
                                         + "<br>"+ "[�K�����x��:15][��������:20��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_RMC].isSelected()) {
            buff.MR += 10;
        }

        //���^�[���g�D�l�C�`���[
        ui.cb_buff[E_RTN].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "���@�I�Ȏ�i�ŏ����A�܂��̓e�C�����ꂽ�����X�^�[�̏�������������"
                                         + "<br>"+ "���݂͓�������Ă��Ďg�p�ł��Ȃ�"
                                         + "<br>"+ "[�K�����x��:45][��������:�u��][�Ώ�:�p��][�G�}:����̋�(2)]"+"</html>");
        if (ui.cb_buff[E_RTN].isSelected()) {
        //�X�L�����ʖ�����
        }

//���얂�@(��)
        //�C���t�F���m
        ui.cb_buff[E_INO].setToolTipText("<html>"+ "[����MP:50][����HP:70]"
                                         + "<br>"+ "�\�[�h��p�X�L��"
                                         + "<br>"+ "���m��(�s��)�ŋߋ����_���[�W��50%�y�����J�E���^�[�U��"
                                         + "<br>"+ "�J�E���^�[�_���[�W�͕����[SMALL�Ō��l]+[�ǉ��_���[�W]+[������]x[1~4(�����_��)]"
                                         + "<br>"+ "[�K�����x��:80][��������:2��8�b][�Ώ�:�p��][�G�}:����̋�(5)]"+"</html>");
        if (ui.cb_buff[E_INO].isSelected()) {
            if (level >= 80 && cls == E && buki.type.equals("�Ў茕")) {
                // �C���t�F���m���ʖ�����
            } else {
                ui.cb_buff[E_INO].setSelected(false);
            }
        }

        //�\�E���I�u�t���C��
        //5828�s�ɂď���

        //�A�f�B�V���i���t�@�C�A�[
        ui.cb_buff[E_AFE].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "�d�ʃQ�[�W��50%�𒴂��Ă�HP��MP�����R�񕜂���"
                                         + "<br>"+ "[�K�����x��:75][��������:16��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_AFE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�G�������^���t�@�C���[
        //6241�s�ɂď���

        //�o�[�j���O�E�G�|��
        ui.cb_buff[E_BWN].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "�Α����̋ߋ����_���[�W+6 �ߋ�������+6"
                                         + "<br>"+ "[�K�����x��:75][��������:16��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_BWN].isSelected()) {
                buff.ELEM_DMG_SHORT[FIRE] += 6;
                buff.HIT_SHORT += 6;
        }

        //�_���V���O�u���C�Y
        ui.cb_buff[E_DBE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�_�K�[/�\�[�h��p�X�L��"
                                         + "<br>"+ "�ړ����x�ƍU�����x���㏸����[2�i����]x1.3333"
                                         + "<br>"+ "[�K�����x��:60][��������:8��][�Ώ�:�p��][�G�}:�G���u�����b�t��(1)]"+"</html>");
        //if (ui.cb_buff[E_DBE].isSelected()) {
        //[2�i����]��ON�ɂ���
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.3333"��I������
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.3333");
        //}

        //�t�@�C�A�[�V�[���h
        ui.cb_buff[E_FSD].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "AC-4"
                                         + "<br>"+ "�V�[���h�̏�ʖ��@"
                                         + "<br>"+ "[�K�����x��:45][��������:16��][�Ώ�:�p��]"+"</html>");
        //�s��ׁ̈A�R�����g�A�E�g�ɂďC��
        //if (ui.cb_buff[E_FSD].isSelected()) {
        //[AC]��ON�ɂ���
        //ui.cb_buff[B_AC].setSelected(true);
        //"AC-4"��I������
        //ui.cb_buff_group[B_AC].setSelectedItem("-4");
        //}

//���얂�@(��) 
        //�|���[�g�E�H�[�^�[
        ui.cb_buff[E_PWR].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "5�Z�����̑ΏۂɁA���m���Ńq�[��/�|�[�V�����̉񕜌��ʂ𔼌�"
                                         + "<br>"+ "[�K�����x��:80][��������:32�b][�Ώ�:PC/NPC][�G�}:����̋�(1)]"+"</html>");
        if (ui.cb_buff[E_PWR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�l�C�`���[�Y�u���b�V���O
        ui.cb_buff[E_NBG].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "15�Z������PT�����o�[��HP���񕜂���"
                                         + "<br>"+ "�p�҂�PT�����o�[�̊Ԃɏ�Q��������ƌ��ʂ�����"
                                         + "<br>"+ "[�K�����x��:75][��������:�u��][�Ώ�:PT][�G�}:����̋�(1)]"+"</html>");
        if (ui.cb_buff[E_NBG].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�t�H�[�J�X�E�F�[�u
        ui.cb_buff[E_FWE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�|��p�X�L��"
                                         + "<br>"+ "�ړ����x�ƍU�����x���㏸����[2�i����]x1.3333"
                                         + "<br>"+ "[�K�����x��:60][��������:8��][�Ώ�:�p��][�G�}:�G���u�����b�t��(1)]"+"</html>");
        //if (ui.cb_buff[E_FWE].isSelected()) {
        //[2�i����]��ON�ɂ���
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.1547"��I������
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.1547");
        //}

        //�A�N�A�v���e�N�^�[
        ui.cb_buff[E_APR].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "8�Z�����̃v���C���[�ɁA���������(ER)+5"
                                         + "<br>"+ "[�K�����x��:60][��������:16��][�Ώ�:�p��/PC]"+"</html>");
        if (ui.cb_buff[E_APR].isSelected()) {
            if (ui.cb_buff[D_DEN].isSelected()) {
                ui.cb_buff[E_APR].setSelected(false);
            } else {
                buff.ER += 5;
            }
        }

        //�l�C�`���[�Y�^�b�`
        ui.cb_buff[E_NTH].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�U�����󂯂����Ɉ��m����HP���񕜂���"
                                         + "<br>"+ "����HP���񕜂������̌��ʂƏd�����܂�"
                                         + "<br>"+ "[�K�����x��:60][��������:5��20�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_NTH].isSelected()) {
            if (level > 9) {
                if (level < 24) {
                    buff.HPR += level - 9;
                } else {
                    buff.HPR += 15;
                }
            }
        }

        //�E�H�[�^�[���C�t
        ui.cb_buff[E_WLE].setToolTipText("<html>"+ "[����MP:1][����HP:--]"
                                         + "<br>"+ "15�Z�����̃v���C���[�ɁA1�񂾂��񕜖��@�̌��ʂ�2�{�ɂ���"
                                         + "<br>"+ "�����̋��сA�ꕔ�A�[�}�[�̉���ɂ����ʂ��K�p�����"
                                         + "<br>"+ "[�K�����x��:45][��������:1��4�b][�Ώ�:PC][�G�}:����̋�(1)]"+"</html>");
        if (ui.cb_buff[E_WLE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�A�N�A�V���b�g
        ui.cb_buff[E_AST].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "����������+4"
                                         + "<br>"+ "[�K�����x��:45][��������:16��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_AST].isSelected()) {
            buff.HIT_LONG += 4;
        } 

//���얂�@(��)
        //�X�g���C�J�[�Q�C��
        ui.cb_buff[E_SGL].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "6�Z�����̑Ώۂ��A���m���ŉ��������[ER]��3����1�ɂ���"
                                         + "<br>"+ "[�K�����x��:80][��������:12�b][�Ώ�:PC/NPC][�G�}:����̋�(2)]"+"</html>");
        if (ui.cb_buff[E_SGL].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�n���P�[��
        ui.cb_buff[E_HUE].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "�|��p�X�L��"
                                         + "<br>"+ "�ړ����x�ƍU�����x���㏸����[2�i����]x1.3333"
                                         + "<br>"+ "[�K�����x��:75][��������:8��][�Ώ�:�p��][�G�}:�G���u�����b�t��(1)]"+"</html>");
        //if (ui.cb_buff[E_HUE].isSelected()) {
        //[2�i����]��ON�ɂ���
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.3333"��I������
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.3333");
        //}

        //�T�C�N����
        //6380�s�ɂď���

        //�X�g�[���V���b�g
        ui.cb_buff[E_SST].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "�������̉������_���[�W+6 ����������+3"
                                         + "<br>"+ "[�K�����x��:75][��������:16��][�Ώ�:�p��]"+"</html>");
            if (ui.cb_buff[E_SST].isSelected()) {
                ui.cb_buff[E_SEE].setSelected(false);
            buff.ELEM_DMG_LONG[WIND] += 6;
            buff.HIT_LONG += 3;
        }

        //�X�g�[���A�C
        ui.cb_buff[E_SEE].setToolTipText("<html>"+ "[����MP:40][����HP:--]"
                                         + "<br>"+ "15�Z������PT�����o�[�ɕ������̉������_���[�W+3 ����������+2"
                                         + "<br>"+ "[�K�����x��:60][��������:16��][�Ώ�:�p��/PT�����o�[]"+"</html>");
            if (ui.cb_buff[E_SEE].isSelected()) {
                buff.ELEM_DMG_LONG[WIND] += 3;
                buff.HIT_LONG += 2;
            }

        //�C�[�O���A�C
        //5903�s�ɂď���

//���얂�@(�y)
        //�A�[�X�o�C���h
        ui.cb_buff[E_EBD].setToolTipText("<html>"+ "[����MP:18][����HP:--]"
                                         + "<br>"+ "6�Z�����̑Ώۂ��A���m���ŕ������čs���s�\�E�U�����󂯂Ȃ���Ԃɂ���"
                                         + "<br>"+ "�������ꂽ�Ώۂ͉񕜖��@���󂯕t���Ȃ�"
                                         + "<br>"+ "�������ɃJ�[�Y�p�����C�Y���󂯂���A�A�[�X�o�C���h�ƃJ�[�Y�p�����C�Y�ǂ���̌��ʂ�����"
                                         + "<br>"+ "[�K�����x��:80][��������:8�b][�Ώ�:PC/NPC][�G�}:����̋�(2)]"+"</html>");
        if (ui.cb_buff[E_EBD].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�G�L�]�`�b�N�o�C�^���C�Y
        ui.cb_buff[E_EVE].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "�d�ʃQ�[�W��50%�𒴂��Ă�HP��MP�����R�񕜂���"
                                         + "<br>"+ "[�K�����x��:75][��������:16��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_EVE].isSelected()) {
        //�X�L�����ʖ�����
        }
        //�A�C�A���X�L��
        ui.cb_buff[E_ISN].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "AC-10"
                                         + "<br>"+ "�V�[���h�̏�ʖ��@"
                                         + "<br>"+ "[�K�����x��:75][��������:16��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_ISN].isSelected()) {
        //[AC]��ON�ɂ���
        ui.cb_buff[B_AC].setSelected(true);
        //"AC-10"��I������
        ui.cb_buff_group[B_AC].setSelectedItem("-10");
        }

        //�T���h�X�g�[��
        ui.cb_buff[E_SSM].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�_�K�[/�\�[�h��p�X�L��"
                                         + "<br>"+ "�ړ����x�ƍU�����x���㏸����[2�i����]x1.3333"
                                         + "<br>"+ "[�K�����x��:75][��������:8��][�Ώ�:�p��][�G�}:�G���u�����b�t��(1)]"+"</html>");
        //if (ui.cb_buff[E_SSM].isSelected()) {
        //[2�i����]��ON�ɂ���
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.3333"��I������
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.3333");
        //}

        //�A�[�X�K�[�f�B�A��
        ui.cb_buff[E_EGN].setToolTipText("<html>"+ "[����MP:30][����HP:10]"
                                         + "<br>"+ "DR+2"
                                         + "<br>"+ "���x��80���烌�x��4���Ƀ_���[�W�ቺ��+1������"
                                         + "<br>"+ "[�K�����x��:60][��������:10��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_EGN].isSelected()) {
            buff.DR += 2;
            if (level >= 80 ) {
                buff.DR += (level - 80) / 4 + 1;                 //DR(level - 80) / 4 + 1
            }
        }

        //�N�G�C�N
        //6396�s�ɂď���

        //�A�[�X�E�F�|��
        ui.cb_buff[E_EWN].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "�_�K�[/�\�[�h��p�X�L��"
                                         + "<br>"+ "�n�����̋ߋ����_���[�W+2 �ߋ�������+4"
                                         + "<br>"+ "[�K�����x��:45][��������:16��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_EWN].isSelected()) {
            buff.ELEM_DMG_SHORT[EARTH] += 2;
            buff.HIT_SHORT += 4;
        }

//�ł̐��얂�@
        //�A�x���W���[
        ui.cb_buff[D_AVR].setToolTipText("<html>"+ "[����MP:25][����HP:--]"
                                         + "<br>"+ "1�Z�����̑Ώۂɋ��͂ȕ����_���[�W��^����"
                                         + "<br>"+ "�Ώۂ�HP��30%�ȉ����ƈ��m��(�s��)�ő���������"
                                         + "<br>"+ "�_���[�W��STR�ƕ���_���[�W�̉e�����󂯂܂�"
                                         + "<br>"+ "�ʃN�[���^�C��"
                                         + "<br>"+ "[�K�����x��:85][��������:�u��][�Ώ�:PC][�G�}:�_�[�N�X�g�[��(2)]"+"</html>");
        if (ui.cb_buff[D_AVR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�V���h�E�X�e�b�v
        ui.cb_buff[D_SHS].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "3�Z�����̑ΏۂɈ�u�Őڋ߂��ĕ����_���[�W��^�����m��(�s��)�Ńz�[���h��Ԃɂ���"
                                         + "<br>"+ "�ʃN�[���^�C��"
                                         + "<br>"+ "[�K�����x��:80][��������:�u��][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[D_SHS].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�A�[�}�[�u���C�N
        ui.cb_buff[D_ABK].setToolTipText("<html>"+ "[����MP:50][����HP:25]"
                                         + "<br>"+ "1�Z�����̑ΏۂɈ��m��(�s��)�ŋߋ����U���̔�_���[�W�𑝉�������"
                                         + "<br>"+ "�p�҂̍U����+58%�����p�҈ȊO�̍U����+20%����"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ� �J�E���^�[�}�W�b�N����"
                                         + "<br>"+ "[�K�����x��:80][��������:8�b][�Ώ�:PC][�G�}:�_�[�N�X�g�[��(2)]"+"</html>");
        if (ui.cb_buff[D_ABK].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���V�t�@�[
        ui.cb_buff[D_LUR].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "��_���[�W��10%�ቺ"
                                         + "<br>"+ "�C�~���[���g�D�n�[���Əd���s�\"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:80][��������:30�b][�Ώ�:�p��][�G�}:�_�[�N�X�g�[��(2)]"+"</html>");
        if (ui.cb_buff[D_LUR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���[�r���O�A�N�Z���[�V����:�}�L�V�}��
        ui.cb_buff[D_MAM].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "���[�r���O�A�N�Z���[�V�������r���������ɁA�U�����x���㏸����(���b�t�����xx1.1547)"
                                         + "<br>"+ "[�K�����x��:85][��������:30�b][�Ώ�:�p��][�G�}:�_�[�N�X�g�[��(2)]"+"</html>");
        //if (ui.cb_buff[D_MAM].isSelected()) {
        //[2�i����]��ON�ɂ���
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.1547"��I������
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.1547");
        //}

        //�V���h�E�A�[�}�[:�f�X�e�B�j�[
        ui.cb_buff[D_SAD].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�V���h�E�A�[�}�[���r���������ɁA���@�_���[�W�ቺ+5%"
                                         + "<br>"+ "���x��85����A���x��2���ɖ��@�_���[�W�ቺ+1%(�ő�+10%)"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��][�G�}:�_�[�N�X�g�[��(2)]"+"</html>");
        if (ui.cb_buff[D_SAD].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���V�t�@�[:�f�X�e�B�j�[
        ui.cb_buff[D_LUD].setToolTipText("<html>"+ "[����MP:25][����HP:--]"
                                         + "<br>"+ "���V�t�@�[�̎������Ԃ�60�b�ɂ���"
                                         + "<br>"+ "���x��85����A���x��2����PVP�_���[�W�ቺ+1%(�ő�+10%)"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[D_LUD].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�A�[�}�[�u���C�N:�f�X�e�B�j�[
        ui.cb_buff[D_ABD].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�A�[�}�[�u���C�N�̐������㏸"
                                         + "<br>"+ "���x��85���烌�x��1���ɐ�������3%������"
                                         + "<br>"+ "�A�[�}�[�u���C�N�̏���MP��35����HP��20�ɒቺ"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[D_ABD].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�_�u���u���C�N
        //7938�s�ɂď���

        //�_�u���u���C�N:�f�X�e�B�j�[
        //7943�s�ɂď���

        //�A���L���j�[�h�b�W
        //7021�s�ɂď���

        //�V���h�E�t�@���O
        ui.cb_buff[D_SFG].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�ߋ����_���[�W+5"
                                         + "<br>"+ "�z�[���[�E�F�|���A�G���`�����g�E�F�|���A�u���X�E�F�|���̏�ʖ��@"
                                         + "<br>"+ "[�K�����x��:60][��������:3��12�b][�Ώ�:�p��][�G�}:�_�[�N�X�g�[��(1)]"+"</html>");
//        if (ui.cb_buff[D_SFG].isSelected()) {
//        //[�L����/����]��ON�ɂ���
//        ui.cb_buff[BUKI].setSelected(true);
//        //"���� +5"��I������
//        ui.cb_buff_group[BUKI].setSelectedItem("���� +5");
//        }

        //�t�@�C�i���o�[��
        ui.cb_buff[D_FBN].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "HP��70���ȉ��ɂȂ�Ƌߋ����N���e�B�J����+5%����"
                                         + "<br>"+ "���x��80����2���x�����オ�閈��+1%"
                                         + "<br>"+ "[�K�����x��:60][��������:�펞][�Ώ�:�p��/PC]"+"</html>");
        if (ui.cb_buff[D_FBN].isSelected()) {
            //HP��70%�ȉ��̎��A�ߋ����N���e�B�J��+5%(���x��80����2���x�����オ�閈��+1%)
            if (level < 80) {
                buff.CRI_SHORT += 5;
            } else if (level >= 80) {
                buff.CRI_SHORT += 5 + ((level - 80) / 2 + 1);
            }
        }

        //�h���X�C�x�C�W����
        ui.cb_buff[D_DEN].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "���������(ER)+18"
                                         + "<br>"+ "�p�b�V�u���@"
                                         + "<br>"+ "[�K�����x��:60][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[D_DEN].isSelected()) {
            buff.ER += 18;
        }

        //���[�r���O�A�N�Z���[�V����
        ui.cb_buff[D_MAN].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "�ړ����x�̂ݏ㏸"
                                         + "<br>"+ "[�K�����x��:40][��������:16��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[D_MAN].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�o�[�j���O �X�s���b�c
        //7299�s�ɂď���

        //�V���h�E�X���[�v
        ui.cb_buff[D_SSP].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "3�Z�����̑Ώۂ����m���Ő�����Ԃɂ���"
                                         + "<br>"+ "[�K�����x��:40][��������:�ő�4�b��][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[D_SSP].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�x�m�����W�X�g
        ui.cb_buff[D_VRT].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�S�Ă̓ł𖳌�������"
                                         + "<br>"+ "[�K�����x��:40][��������:5��20�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[D_VRT].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�h���X�f�N�X�^���e�B�[
        ui.cb_buff[D_DDY].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "DEX+3"
                                         + "<br>"+ "�t�B�W�J���G���`�����g:DEX�Əd���s�\"
                                         + "<br>"+ "[�K�����x��:40][��������:16��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[D_DDY].isSelected()) {
        //[DEX]��ON�ɂ���
        ui.cb_buff[B_DEX].setSelected(true);
        //"DEX +3"��I������
        ui.cb_buff_group[B_DEX].setSelectedItem("+3");
        }

        //�u���C���h�n�C�f�B���O
        ui.cb_buff[D_BHG].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "������ԂɂȂ�"
                                         + "<br>"+ "�ړ��ȊO�̍s��������ƌ��ʂ�������"
                                         + "<br>"+ "�A�ҕs�\�̏�Ԃł͉r���s�\"
                                         + "<br>"+ "[�K�����x��:20][��������:32�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[D_BHG].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�G���`�����g�x�m��
        ui.cb_buff[D_EVM].setToolTipText("<html>"+ "[����MP:10][����HP:1]"
                                         + "<br>"+ "����ɓő�����t�^���A�U�������Ώۂ����m���Ń_���[�W�ŏ�Ԃɂ���"
                                         + "<br>"+ "[�K�����x��:20][��������:5��20�b][�Ώ�:�p��][�G�}:�_�[�N�X�g�[��(1)]"+"</html>");
        if (ui.cb_buff[D_EVM].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�V���h�E�A�[�}�[
        ui.cb_buff[D_SAR].setToolTipText("<html>"+ "[����MP:12][����HP:--]"
                                         + "<br>"+ "MR+5"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:20][��������:16��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[D_SAR].isSelected()) {
            buff.MR += 5;
        }

        //�h���X�}�C�e�B�[
        ui.cb_buff[D_DMY].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "STR+3"
                                         + "<br>"+ "�t�B�W�J���G���`�����g:STR�Əd���s�\"
                                         + "<br>"+ "[�K�����x��:20][��������:16��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[D_DMY].isSelected()) {
        //[STR]��ON�ɂ���
        ui.cb_buff[B_STR].setSelected(true);
        //"STR +3"��I������
        ui.cb_buff_group[B_STR].setSelectedItem("+3");
        }

//���R�m��Z
        //�n���p�X
        ui.cb_buff[R_HAS].setToolTipText("<html>"+ "[����MP:18][����HP:--]"
                                         + "<br>"+ "�`�F�[���\�[�h�Z�p"
                                         + "<br>"+ "�U�������Ă����ΏۂɈ��m��(�s��)�ŃJ�E���^�[�_���[�W��^����"
                                         + "<br>"+ "�J�E���^�[�_���[�W�͕����[Small�Ō��l]x3"
                                         + "<br>"+ "[�K�����x��:85][��������:2��8�b][�Ώ�:�p��][�G�}:����̃{�[���s�[�X(1)]"+"</html>");
        if (ui.cb_buff[R_HAS].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�\���b�h�m�b�g
        ui.cb_buff[R_SNT].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "���p�������킪�������Ȃ��Ȃ�"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[R_SNT].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�����y�[�W
        ui.cb_buff[R_RAE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�X�^���E�z�[���h��Ԃ̃^�[�Q�b�g�ɁA���m���Œǉ��_���[�W��^����"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[R_RAE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�A�E���L�A
        ui.cb_buff[R_AUA].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�o����2��ނ܂ŏd�����\�ɂȂ�"
                                         + "<br>"+ "�o���X�L���̏���MP��5����������"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[R_AUA].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�T���_�[�O���b�v:�u���C�u
        ui.cb_buff[R_TGB].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�T���_�[�O���b�v�̃z�[���h�������Ԃ�3����6�b�ɑ���"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[R_TGB].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�t�H�[�X���C���[:�u���C�u
        ui.cb_buff[R_FSB].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "��_�I�o�ɒǉ����� ���m���ŃX�^����Ԃɂ���"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[R_FSB].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�����h�r�I��
        //7164�s�ɂď���

        //���[�^���{�f�B
        ui.cb_buff[R_MBY].setToolTipText("<html>"+ "[����MP:--][����HP:40]"
                                         + "<br>"+ "�U�������Ă����ΏۂɁA���m���ŃJ�E���^�[�_���[�W��^����"
                                         + "<br>"+ "�J�E���^�[�_���[�W��[AC]/2 �ŏ���40�_���[�W"
                                         + "<br>"+ "[�K�����x��:60][��������:5��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[R_MBY].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�T���_�[�O���b�v
        ui.cb_buff[R_TGP].setToolTipText("<html>"+ "[����MP:--][����HP:30]"
                                         + "<br>"+ "5�Z�����̑Ώۂ��A���m���Ńz�[���h��Ԃɂ���"
                                         + "<br>"+ "�ʃN�[���^�C��"
                                         + "<br>"+ "[�K�����x��:60][��������:1����4�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[R_TGP].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�f�X�g���C:�z���[
        ui.cb_buff[R_DHR].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�f�X�g���C��DG-20/STR-2/INT-2�̌��ʂ�ǉ�"
                                         + "<br>"+ "�f�X�g���C:�t�B�A�[���o���Ă��Ȃ��ƏK�����鎖���o���Ȃ�"
                                         + "<br>"+ "[�K�����x��:60][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[R_DHR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�A�C�I�u�h���S��
        ui.cb_buff[R_EOD].setToolTipText("<html>"+ "[����MP:10][����HP:10]"
                                         + "<br>"+ "15�Z�����ɉB��Ă���PC/NPC��������"
                                         + "<br>"+ "[�K�����x��:60][��������:�펞][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_EOD].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�o��[���@���J�X]
        ui.cb_buff[R_VALAKAS].setToolTipText("<html>"+ "[����MP:50][����HP:30]"
                                             + "<br>"+ "�ߋ�������+5 �Z�p�ϐ�+5 ���|�ϐ�+5 ��Z����+5"
                                             + "<br>"+ "[�K�����x��:60][��������:10��][�Ώ�:�p��][�G�}:����̃{�[���s�[�X(1)]"+"</html>");
        if (ui.cb_buff[R_VALAKAS].isSelected()) {
            buff.HIT_SHORT += 5;
            buff.ailment[STUN] += 5;
            buff.ailment[SECRET] += 5;
            buff.ailment[HIT_TERROR] += 5;
        }

        //�u���b�h���X�g
        ui.cb_buff[R_BLT].setToolTipText("<html>"+ "[����MP:--][����HP:30]"
                                         + "<br>"+ "�ړ����x/�U�����x���㏸����[2�i�K����]"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:40][��������:5��][�Ώ�:�p��][�G�}:����̃{�[���s�[�X(1)]"+"</html>");
        //if (ui.cb_buff[R_BLT].isSelected()) {
        //[2�i����]��ON�ɂ���
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.3333"��I������
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.3333");
        //}

        //�t�H�[�X���C���[
        ui.cb_buff[R_FSR].setToolTipText("<html>"+ "[����MP:--][����HP:10]"
                                         + "<br>"+ "�Ώۂ�3�A���U��������"
                                         + "<br>"+ "��_�I�o�̌��ʂ��K�p�����"
                                         + "<br>"+ "[�K�����x��:40][��������:�u��][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_FSR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�f�X�g���C:�t�B�A�[
        ui.cb_buff[R_DFR].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�f�X�g���C��DG-20�̌��ʂ�ǉ�"
                                         + "<br>"+ "�f�X�g���C���o���Ă��Ȃ��ƏK�����鎖���o���Ȃ�"
                                         + "<br>"+ "[�K�����x��:40][��������:�펞][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_DFR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�}�O�}�A���[
        ui.cb_buff[R_MAW].setToolTipText("<html>"+ "[����MP:5][����HP:--]"
                                         + "<br>"+ "10�Z�����̑ΏۂɁA�Α����_���[�W��^����"
                                         + "<br>"+ "[�K�����x��:40][��������:�u��][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_MAW].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�o��[�p�v���I��]
        ui.cb_buff[R_FAFURION].setToolTipText("<html>"+ "[����MP:30][����HP:20]"
                                              + "<br>"+ "�d�ʃQ�[�W��50���𒴂��Ă�HP��MP�����R�񕜂��� ���������ER+10"
                                              + "<br>"+ "�d�ʃQ�[�W�͈̔�50����82%?"
                                              + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                              + "<br>"+ "[�K�����x��:40][��������:10��][�Ώ�:�p��][�G�}:����̃{�[���s�[�X(1)]"+"</html>");
        if (ui.cb_buff[R_FAFURION].isSelected()) {
            buff.ER += 10;
        }

        //�h���S���X�L��
        ui.cb_buff[R_DSN].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�_���[�W�ቺ+5"
                                         + "<br>"+ "���x��80����A���x��2���Ɍ��ʂ�+1������(LV80��DR6)"
                                         + "<br>"+ "*���j���[�A�� �p�b�V�u�ɕύX"
                                         + "<br>"+ "[�K�����x��:20][��������:�펞][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_DSN].isSelected()) {
            buff.DR += 5;
            if (level >= 80) {
                buff.DR += (int) ((level - 80) / 2) + 1;
            }
        }

        //�o�[�j���O�X���b�V��
        ui.cb_buff[R_BSH].setToolTipText("<html>"+ "[����MP:--][����HP:6]"
                                         + "<br>"+ "�r�����čŏ��̍U�����������ɁA�Α����_���[�W+7��ǉ�"
                                         + "<br>"+ "[�K�����x��:20][��������:1��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[R_BSH].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�f�X�g���C
        ui.cb_buff[R_DEY].setToolTipText("<html>"+ "[����MP:10][����HP:20]"
                                         + "<br>"+ "5�Z�����̑ΏۂɁA���m����AC+10"
                                         + "<br>"+ "[�K�����x��:20][��������:16�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_DEY].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�}�O�}�u���X
        ui.cb_buff[R_MBH].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "5�Z�����̑Ώ�1�Z�����ɁA�Α����_���[�W25����35��^����"
                                         + "<br>"+ "[�K�����x��:20][��������:�u��][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[R_MBH].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�o��[�A���^���X]
        ui.cb_buff[R_ANTHARAS].setToolTipText("<html>"+ "[����MP:20][����HP:10]"
                                              + "<br>"+ "AC-3 MR+5%"
                                              + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                              + "<br>"+ "[�K�����x��:20][��������:10��][�Ώ�:�p��][�G�}:����̃{�[���s�[�X(1)]"+"</html>");
        if (ui.cb_buff[R_ANTHARAS].isSelected()) {
            buff.AC -= 3;
            buff.MR += 5;
        }

//���p���@
        //�|�e���V����
        ui.cb_buff[I_POL].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "�����i�▂�@���K�p���ꂽ��Ԃ�"
                                         + "<br>"+ "[�ő�HP][�ő�MP][MR][SP][DG][ER]��20%�㏸������"
                                         + "<br>"+ "�A�h�o���X�h�X�s���b�c�Əd������"
                                         + "<br>"+ "[�K�����x��:85][��������:2��8�b][�Ώ�:�p��][�G�}:������(2)]"+"</html>");
        if (ui.cb_buff[I_POL].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�{�[���u���C�N:���X�g
        ui.cb_buff[I_BBL].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�{�[���u���C�N�̃X�^����������+1�b"
                                         + "<br>"+ "[�K�����x��:85]");
        if (ui.cb_buff[I_BBL].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���r�E�X
        ui.cb_buff[I_MES].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "�������_���[�W��20%�ቺ"
                                         + "<br>"+ "���x��85����A���x��1����[�������_���[�W�ቺ]1%����(�ő�10%)"
                                         + "<br>"+ "�C�~���[���g�D�n�[���Əd������"
                                         + "<br>"+ "�ʃN�[���^�C��"
                                         + "<br>"+ "[�K�����x��:85][��������:6�b][�Ώ�:�p��][�G�}:������(1)]"+"</html>");
        if (ui.cb_buff[I_MES].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�C���p�N�g
        ui.cb_buff[I_IMT].setToolTipText("<html>"+ "[����MP:40][����HP:--]"
                                         + "<br>"+ "15�Z������PT�����o�[��"
                                         + "<br>"+ "�Z�p����+5 ���얽��+5 ���ꖽ��+5 ���|����+5"
                                         + "<br>"+ "���x��80���烌�x��1���Ɍ��ʂ�+1������[�ő�+10]"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:80][��������:15�b][�Ώ�:PT][�G�}:������(5)]"+"</html>");
        if (ui.cb_buff[I_IMT].isSelected()) {
            if (level >= 80 && cls == I) {
            	if (level >= 85) {
                    buff.ailment[HIT_STUN] += 10;                       //�Z�p����+10
                    buff.ailment[HIT_SPIRIT] += 10;                     //���얽��+10
                    buff.ailment[HIT_SECRET] += 10;                     //��Z����+10
                    buff.ailment[HIT_TERROR] += 10;                     //���|����+10
                } else if (level >= 80) {
                    buff.ailment[HIT_STUN] += 5 + (level - 80);         //�Z�p����+(level - 75)
                    buff.ailment[HIT_SPIRIT] += 5 + (level - 80);       //���얽��+(level - 75)
                    buff.ailment[HIT_SECRET] += 5 + (level - 80);       //��Z����+(level - 75)
                    buff.ailment[HIT_TERROR] += 5 + (level - 80);       //���|����+(level - 75)
                }
            } else {
                ui.cb_buff[I_IMT].setSelected(false);
            }
        }

        //�_�[�N�z�[�X
        ui.cb_buff[I_DHE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�U�����x���㏸����[2�i�K����]x1.0800"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        //if (ui.cb_buff[I_DHE].isSelected()) {
        //[2�i����]��ON�ɂ���
        //ui.cb_buff[ACC2].setSelected(true);
        //"x1.0800"��I������
        //ui.cb_buff_group[ACC2].setSelectedItem("x1.0800");
        //}

        //�t�H�[�J�X�X�s���b�c
        ui.cb_buff[I_FSZ].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "���@�N���e�B�J��+5%"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:75][��������:5��][�Ώ�:�p��][�G�}:������(1)]"+"</html>");
        if (ui.cb_buff[I_FSZ].isSelected()) {
            buff.CRI_MAGIC += 5;
        }

        //�C���T�C�g
        ui.cb_buff[I_INS].setToolTipText("<html>"+ "[����MP:60][����HP:--]"
                                         + "<br>"+ "STR+1 DEX+1 INT+1 CON+1 WIS+1"
                                         + "<br>"+ "[�K�����x��:60][��������:10��40�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[I_INS].isSelected()) {
            buff.ST[STR]++;
            buff.ST[DEX]++;
            buff.ST[CON]++;
            buff.ST[INT]++;
            buff.ST[WIS]++;
        }

        //�p�j�b�N
        ui.cb_buff[I_PAC].setToolTipText("<html>"+ "[����MP:30][����HP:30]"
                                         + "<br>"+ "5�Z�����̑Ώۂ�STR-1/DEX-1/CON-1/INT-1/WIS-1"
                                         + "<br>"+ "[�K�����x��:60][��������:1��4�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_PAC].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���f���[�X�E�F�C�g
        //7370�s�ɂď���

        //�C�����[�W����[�A�o�^�[]
        //6606�s�ɂď���

        //�L���[�u[�A�o�^�[]
        //6616�s�ɂď���

        //�y�C�V�F���X
        ui.cb_buff[I_PAE].setToolTipText("<html>"+ "[����MP:25][����HP:--]"
                                         + "<br>"+ "DR+2"
                                         + "<br>"+ "���x��80����A���x��4���Ɍ��ʂ�+1������"
                                         + "<br>"+ "*���j���[�A�� ���x��80������ʂ��㏸"
                                         + "<br>"+ "[�K�����x��:45][��������:10��][�Ώ�:�p��/PC]"+"</html>");
        if (ui.cb_buff[I_PAE].isSelected()) {
            buff.DR += 2;
        }

        //�t�@���^�Y��
        ui.cb_buff[I_PHM].setToolTipText("<html>"+ "[����MP:30][����HP:25]"
                                         + "<br>"+ "3�Z�����̑Ώۂ�30%�̊m���Ő�����Ԃɂ���"
                                         + "<br>"+ "[�K�����x��:45][��������:�ő�4�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_PHM].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�A�C�Y�u���C�J�[
        ui.cb_buff[I_IBR].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "15�Z�����ɉB��Ă���PC/NPC��������"
                                         + "<br>"+ "[�K�����x��:45][��������:�u��][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_IBR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�C�����[�W����[�S�[����]
        ui.cb_buff[I_IGM].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "AC-10"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:45][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[I_IGM].isSelected()) {
            buff.AC -= 10;
        }

        //�L���[�u[���b�`]
        ui.cb_buff[I_CRH].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "15�Z������PT�����o�[��SP+2"
                                         + "<br>"+ "[�K�����x��:45][��������:2��8�b][�Ώ�:PT][�G�}:������(3)]"+"</html>");
        if (ui.cb_buff[I_CRH].isSelected()) {
            buff.SP += 2;
        }

        //�R���Z���g���[�V����
        ui.cb_buff[I_CON].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "5�Z�����̑ΏۂɁAMP���R��+4"
                                         + "<br>"+ "[�K�����x��:30][��������:10��][�Ώ�:�p��/PC]"+"</html>");
        if (ui.cb_buff[I_CON].isSelected()) {
            buff.MPR += 2;
        }

        //�}�C���h�u���C�N
        ui.cb_buff[I_MBK].setToolTipText("<html>"+ "[����MP:20][����HP:15]"
                                         + "<br>"+ "5�Z�����̑ΏۂɃ_���[�W��^���AMP��5�r�o������"
                                         + "<br>"+ "�_���[�W��[SP]x[3.8]"
                                         + "<br>"+ "[�K�����x��:30][��������:�u��][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_MBK].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�{�[���u���C�N
        ui.cb_buff[I_BBK].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "1�Z�����̑Ώۂ�10�_���[�W��^���A30����50%�̊m���ŃX�^����Ԃɂ���"
                                         + "<br>"+ "���ُ�Ԃł��r���\"
                                         + "<br>"+ "[�K�����x��:30][��������:�ő�2�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_BBK].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�C�����[�W����[���b�`]
        ui.cb_buff[I_IRH].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "SP+4"
                                         + "<br>"+ "[�K�����x��:30][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[I_IRH].isSelected()) {
            buff.SP += 4;
        }

        //�L���[�u[�S�[����]
        ui.cb_buff[I_CGM].setToolTipText("<html>"+ "[����MP:40][����HP:--]"
                                         + "<br>"+ "15�Z������PT�����o�[��AC-8"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�(�p�҂̂�)"
                                         + "<br>"+ "[�K�����x��:30][��������:2��8�b][�Ώ�:PT][�G�}:������(5)]"+"</html>");
        if (ui.cb_buff[I_CGM].isSelected()) {
            buff.AC -= 8;
        }

        //�~���[�C���[�W
        //7384�s�ɂď���

        //�R���t���[�W����
        ui.cb_buff[I_CFN].setToolTipText("<html>"+ "[����MP:15][����HP:10]"
                                         + "<br>"+ "3�Z�����̑ΏۂɃ_���[�W��^���A20����30%�̊m���Œ��ُ�Ԃɂ���"
                                         + "<br>"+ "�_���[�W�́uSP]x[2.2]"
                                         + "<br>"+ "[�K�����x��:15][��������:8�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_CFN].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�X�}�b�V���G�l���M�[
        ui.cb_buff[I_SEY].setToolTipText("<html>"+ "[����MP:5][����HP:--]"
                                         + "<br>"+ "10�Z�����̑ΏۂɌ����n�_���[�W��^����"
                                         + "<br>"+ "[�K�����x��:15][��������:�u��][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[I_SEY].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�C�����[�W����[�I�[�K]
        ui.cb_buff[I_IOE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�ߋ����_���[�W+4 �ߋ�������+4 �������_���[�W+4 ����������+4"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:15][��������:2��8�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[I_IOE].isSelected()) {
            buff.DMG_SHORT += 4;
            buff.HIT_SHORT += 4;
            buff.DMG_LONG += 4;
            buff.HIT_LONG += 4;
        }

        //�L���[�u[�I�[�K]
        ui.cb_buff[I_COE].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "15�Z������PT�����o�[�ɋߋ����_���[�W+4 �ߋ�������+4 �������_���[�W+4 ����������+4"
                                         + "<br>"+ "[�K�����x��:15][��������:2��8�b][�Ώ�:PT][�G�}:������(3)]"+"</html>");
        if (ui.cb_buff[I_COE].isSelected()) {
            buff.DMG_SHORT += 4;
            buff.HIT_SHORT += 4;
            buff.DMG_LONG += 4;
            buff.HIT_LONG += 4;
        }

//��m�Z�p
        //�f�����b�V����
        ui.cb_buff[S_DEN].setToolTipText("<html>"+ "[����MP:25][����HP:--]"
                                         + "<br>"+ "5�Z�����̑Ώۂ��A�A�ҕs�\�{�o����Ԃɂ���"
                                         + "<br>"+ "�f�����b�V�����̃_���[�W�́ASTR�ƕ���_���[�W�̉e�����󂯂܂�"
                                         + "<br>"+ "[�K�����x��:85][��������:�ő�4�b][�Ώ�:PC][�G�}:������(100)]"+"</html>");
        if (ui.cb_buff[S_DEN].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�o�[�T�[�N
        ui.cb_buff[S_BER].setToolTipText("<html>"+ "[����MP:--][����HP:100]"
                                         + "<br>"+ "�ߋ����_���[�W+20 �S�X�L���ϐ�+20"
                                         + "<br>"+ "[�K�����x��:85][��������:16�b][�Ώ�:�p��][�G�}:������(100)]"+"</html>");
        if (ui.cb_buff[S_BER].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�f�X�y���[�h
        ui.cb_buff[S_DEO].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "1�Z�����̑ΏۂɃ_���[�W��^���A���m���ňړ��s�A�e���|�[�g�s�A�����̒��E�s�AHP�񕜌��ʂ�����"
                                         + "<br>"+ "�p�҂̃��x�����オ��Ɖ񕜈����̌��ʂ��㏸����"
                                         + "<br>"+ "*���j���[�A�� �X�L���������Ƀ_���[�W�ǉ� ���������� �ŏ���������+1�b"
                                         + "<br>"+ "[�K�����x��:80][��������:�ő�4�b][�Ώ�:PC/NPC][�G�}:������(100)]"+"</html>");
        if (ui.cb_buff[S_DEO].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�^�C�^�����C�W���O
        ui.cb_buff[S_TRG].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "�^�C�^���n�񔭓����+5%"
                                         + "<br>"+ "���x��80���烌�x��1���Ɍ��ʂ�1%����[�ő�10%]"
                                         + "<br>"+ "�W��35%+���C�W���O(5%+10%)+����(5%+5%)=�ő�60%�������?"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:80][��������:40��][�Ώ�:�p��][�G�}:������(100)]"+"</html>");
        if (ui.cb_buff[S_TRG].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�p���[�O���b�v
        ui.cb_buff[S_PGP].setToolTipText("<html>"+ "[����MP:5][����HP:--]"
                                         + "<br>"+ "6�Z�����̑Ώۂ��A���m���Ńz�[���h��Ԃɂ���"
                                         + "<br>"+ "[�K�����x��:75][��������:�ő�6�b][�Ώ�:PC/NPC][�G�}:������(20)]"+"</html>");
        if (ui.cb_buff[S_PGP].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�M�K���e�B�b�N
        //8073�s�ɂď���

        //�g�}�z�[�N
        ui.cb_buff[S_TOK].setToolTipText("<html>"+ "[����MP:5][����HP:--]"
                                         + "<br>"+ "6�Z�����̑Ώۂɋ��͂ȕ����_���[�W��^����"
                                         + "<br>"+ "�ʃN�[���^�C��(8�b)"
                                         + "<br>"+ "[�K�����x��:45][��������:--][�Ώ�:PC/NPC][�G�}:������(50)]"+"</html>");
        if (ui.cb_buff[S_TOK].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�n�E��
        ui.cb_buff[S_HOL].setToolTipText("<html>"+ "[����MP:5][����HP:--]"
                                         + "<br>"+ "�͈�5�Z�����̑ΏۂɁA50�_���[�W��^����"
                                         + "<br>"+ "[�K�����x��:30][��������:�u��][�Ώ�:PC/NPC][�G�}:������(10)]"+"</html>");
        if (ui.cb_buff[S_HOL].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�^�C�^�����b�N
        ui.cb_buff[S_TLK].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "HP40%�ȉ������m��(35%)�ŋߋ����U����������ăJ�E���^�[�_���[�W��^����"
                                         + "<br>"+ "�J�E���^�[�_���[�W�͕����[BIG�Ō��l]+[�ǉ��_���[�W]+[������]x[2]"
                                         + "<br>"+ "[�K�����x��:75][��������:�펞][�Ώ�:�p��][�G�}:������(10)]"+"</html>");
        if (ui.cb_buff[S_TLK].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�^�C�^���}�W�b�N
        ui.cb_buff[S_TMC].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "HP40%�ȉ������m��(35%)�Ŗ��@�U����������ăJ�E���^�[�_���[�W��^����"
                                         + "<br>"+ "�J�E���^�[�_���[�W�͕����[BIG�Ō��l]+[�ǉ��_���[�W]+[������]x[2]"
                                         + "<br>"+ "[�K�����x��:75][��������:�펞][�Ώ�:�p��][�G�}:������(10)]"+"</html>");
        if (ui.cb_buff[S_TMC].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�^�C�^���u���b�c
        ui.cb_buff[S_TBZ].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "HP40%�ȉ������m��(35%)�ŉ������U����������ăJ�E���^�[�_���[�W��^����"
                                         + "<br>"+ "�J�E���^�[�_���[�W�͕����[BIG�Ō��l]+[�ǉ��_���[�W]+[������]x[2]"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��][�G�}:������(10)]"+"</html>");
        if (ui.cb_buff[S_TBZ].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�X���C���[
        ui.cb_buff[S_SLR].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�Ў蕀�𗼎�ɑ������Č��݂ɍU��"
                                         + "<br>"+ "�U�����x���\�[�h�Ɠ����ɂȂ�"
                                         + "<br>"+ "[�K�����x��:15][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[S_SLR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�N���b�V��
        //6864�s�ɂď���

        //�A�[�}�[�K�[�h
        //7471�s�ɂď���

        //�t���[���[
        //6875�s�ɂď���

        //�f�X�y���[�h:�A�u�\�����[�g
        ui.cb_buff[S_DAE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�f�X�y���[�h�̍ő厝�����Ԃ𑝉�"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[S_DAE].isSelected()) {
        //�X�L�����ʖ�����
        }

//���m�Z�p
        //�t�@���g��:�f�X
        ui.cb_buff[F_PPH].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�t�@���g���Ɉړ��s�\�A�f�X�q�[���A�f�X�|�[�V�����̌��ʂ�ǉ�"
                                         + "<br>"+ "���[�p�[�A�f�X�̂ǂ��炩�������_���Ŕ�������"
                                         + "<br>"+ "�t�@���g��:���[�p�[���o���Ă��Ȃ��ƏK�����鎖���o���Ȃ�"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PPH].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�A�V����
        ui.cb_buff[F_AAA].setToolTipText("<html>"+ "[����MP:--][����HP:2,000]"
                                         + "<br>"+ "10�b��MP��400��"
                                         + "<br>"+ "��[D]�N�[���^�C��(30��)"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��][�G�}:������(2,000)]"+"</html>");
        if (ui.cb_buff[F_AAA].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�u���[�h
        ui.cb_buff[F_ABE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�_�K�[/�\�[�h/���茕�Z�p"
                                         + "<br>"+ "5�Z�����̑Ώۂɕ����_���[�W��^����"
                                         + "<br>"+ "�_���[�W�͒��p���Ă��镐��̉e�����󂯂�"
                                         + "<br>"+ "��[A]�N�[���^�C��()"
                                         + "<br>"+ "[�K�����x��:60][��������:�u��][�Ώ�:PC/NPC][�G�}:������(50)]"+"</html>");
        if (ui.cb_buff[F_ABE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�p���e��
        ui.cb_buff[F_APA].setToolTipText("<html>"+ "[����MP:22][����HP:--]"
                                         + "<br>"+ "�\�[�h�Z�p"
                                         + "<br>"+ "3�Z�����̑ΏۂɈ�u�Őڋ߂��ĕ����_���[�W��^���A���m���ŃX�^����Ԃɂ���"
                                         + "<br>"+ "�X�^�����ʂ͋��|�����̉e�����󂯂�"
                                         + "<br>"+ "��[B]�N�[���^�C��()"
                                         + "<br>"+ "[�K�����x��:75][��������:�펞][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[F_APA].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�W���b�W�����g
        ui.cb_buff[F_AJT].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "6�Z�����̑Ώۂ̑S�X�L���ϐ�������������"
                                         + "<br>"+ "�����ʂ�STR�̉e�����󂯂�"
                                         + "<br>"+ "��[C]�N�[���^�C��()"
                                         + "<br>"+ "[�K�����x��:80][��������:8�b][�Ώ�:PC]"+"</html>");
        if (ui.cb_buff[F_AJT].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�w���t�@�C�A
        ui.cb_buff[F_AHE].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "�͈�4�Z�����̑Ώۂɕ����_���[�W��^����"
                                         + "<br>"+ "�_���[�W�͒��p���Ă��镐��̉e�����󂯂�"
                                         + "<br>"+ "��[C]�N�[���^�C��()"
                                         + "<br>"+ "[�K�����x��:70][��������:�펞][�Ώ�:PC/NPC][�G�}:������(10)]"+"</html>");
        if (ui.cb_buff[F_AHE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�t�@���g��
        ui.cb_buff[F_APM].setToolTipText("<html>"+ "[����MP:18][����HP:--]"
                                         + "<br>"+ "�\�[�h�Z�p"
                                         + "<br>"+ "1�Z�����̑Ώۂ����m���ő����̒��E�s�A�A�ҕs�̏�Ԃɂ���"
                                         + "<br>"+ "��[C]�N�[���^�C��()"
                                         + "<br>"+ "[�K�����x��:70][��������:�펞][�Ώ�:PC][�G�}:������(100)]"+"</html>");
        if (ui.cb_buff[F_APM].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�t�@���g��:���[�p�[
        ui.cb_buff[F_PPR].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�t�@���g���Ɉړ��s�\�̌��ʂ�ǉ�"
                                         + "<br>"+ "�t�@���g�����o���Ă��Ȃ��ƏK�����鎖���o���Ȃ�"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PPR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�p���e��:�V���b�N
        ui.cb_buff[F_PPK].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�p���e���̎˒���1�Z���L�΂��A�X�^�����Ԃ𑝉�����"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PPK].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�T���@�C��
        ui.cb_buff[F_PSE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "HP��45%�ȉ��ɂȂ�ƁA���m����HP�񕜃|�[�V�����̉񕜗ʂ���������"
                                         + "<br>"+ "CON��HP��%�ŉ񕜗ʂ��ω�����"
                                         + "<br>"+ "�񕜗ʂɉ����Č����̂������"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��][�G�}:������]"+"</html>");
        if (ui.cb_buff[F_PSE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�C���t�B�j�e�B:�u���b�c
        ui.cb_buff[F_PIZ].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "���x��75���烌�x��1����ER��+1������[�ő�+15]"
                                         + "<br>"+ "[�K�����x��:75][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PIZ].isSelected()) {
            if (cls == F) {
                if (level >= 89) {
                    buff.ER += 15;                                      //�ő�ER+15(LV89)
                } else if (level >= 75) {
                    buff.ER += (level - 75) / 1 + 1;                    //ER+((level - 75) / 1 + 1)
                }
            } else {
                ui.cb_buff[F_PIZ].setSelected(false);
            }
        }

        //�p���h�b�N�X
        ui.cb_buff[F_PPX].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�J�E���^�[�X�L���̉�������m���Ŋђʂ��āA�J�E���^�[�_���[�W������������"
                                         + "<br>"+ "[�K�����x��:75][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PPX].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�C���t�B�j�e�B:�h�b�W
        //7656�s�ɂď���

        //�O���[�X
        ui.cb_buff[F_PGE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�����X�^�[��|�������ɁA���m���Ŋl���o���l��2����5�{�ɂ���"
                                         + "<br>"+ "���x��85�ɂȂ�ƌ��ʂ������Ȃ�܂�"
                                         + "<br>"+ "[�K�����x��:60][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PGE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�C���t�B�j�e�B:�u���b�h
        //8214�s�ɂď���

        //���C�W
        //7183�s�ɂď���

        //�C���t�B�j�e�B:�A�[�}�[
        ui.cb_buff[F_PIR].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "���x��45���烌�x��4���Ƀ_���[�W�ቺ��+1������[�ő�+15]"
                                         + "<br>"+ "[�K�����x��:45][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PIR].isSelected()) {
            if (cls == F) {
                if (level >= 101) {
                    buff.DR += 15;                                      //�ő�DR+15(LV101)
                } else if (level >= 45) {
                    buff.DR += (level - 45) / 4 + 1;                    //DR+((level - 45) / 4 + 1)
                }
            } else {
                ui.cb_buff[F_PIR].setSelected(false);
            }
        }

        //�t���C��
        ui.cb_buff[F_PFE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�ΏۂɍU���������������ɁA���m����3�b��HP������������(�v�Z���s��)"
                                         + "<br>"+ "[�K�����x��:45][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PGE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�_�}�X�J�X
        ui.cb_buff[F_PDS].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "���p�������킪�������Ȃ��Ȃ�"
                                         + "<br>"+ "[�K�����x��:45][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PGE].isSelected()) {
        //�X�L�����ʖ�����
        }

//���m�Z�p
        //�v���b�V���[:�f�X ���R�[��
        ui.cb_buff[L_PDR].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�v���b�V���[�Ƀf�X�e���|�[�g�̌��ʂ�ǉ�"
                                         + "<br>"+ "[�K�����x��:85][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[L_PDR].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���J�o���[
        ui.cb_buff[L_REY].setToolTipText("<html>"+ "[����MP:50][����HP:--]"
                                         + "<br>"+ "�`����������[�X�^��][�z�[���h][�A�ҕs�\]�̌��ʂ�����"
                                         + "<br>"+ "[�K�����x��:80][��������:�u��][�Ώ�:�p��][�G�}:������(300)]"+"</html>");
        if (ui.cb_buff[L_REY].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�N���[�G��
        ui.cb_buff[L_KRL].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "[�ߋ����t�H�[��]3�Z�����̑Ώۂ��A�ڂ̑O�Ɉ����񂹂ăX�^����Ԃɂ���"
                                         + "<br>"+ "[�������t�H�[��]3�Z�����̑Ώۂ��A���g������������ăX�^����Ԃɂ���"
                                         + "<br>"+ "NPC���肾�ƈړ���������ʂ������X�^���̂ݔ���"
                                         + "<br>"+ "[�K�����x��:80][��������:3�b�ȉ�][�Ώ�:PC/NPC][�G�}:������(100)]"+"</html>");
        if (ui.cb_buff[L_KRL].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�v���b�V���[
        ui.cb_buff[L_PRE].setToolTipText("<html>"+ "[����MP:16][����HP:--]"
                                         + "<br>"+ "5�Z�����̑ΏۂɁA�z�[���h��Ԃɂ���"
                                         + "<br>"+ "�X�Ɏ������ԓ��ɗ^�����_���[�W��60%��ǉ��_���[�W�Ƃ��ė^����"
                                         + "<br>"+ "�p�҈ȊO�̃_���[�W��10%"
                                         + "<br>"+ "[�K�����x��:75][��������:4�b][�Ώ�:PC]"+"</html>");
        if (ui.cb_buff[L_PRE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���@���K�[�h
        ui.cb_buff[L_VAD].setToolTipText("<html>"+ "[����MP:--][����HP:25]"
                                         + "<br>"+ "[�ߋ����t�H�[��]�ړ����x�E�U�����x���啝�ɏ㏸����"
                                         + "<br>"+ "[�������t�H�[��]�U�����x���啝�ɏ㏸����"
                                         + "<br>"+ "[�K�����x��:70][��������:4�b][�Ώ�:�p��][�G�}:������(50)]"+"</html>");
        if (ui.cb_buff[L_VAD].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�t�H�[�X �E�F�[�u
        ui.cb_buff[L_FWE].setToolTipText("<html>"+ "[����MP:15][����HP:--]"
                                         + "<br>"+ "[�ߋ����t�H�[��]����1�Z���Ƀ_���[�W��^����"
                                         + "<br>"+ "[�������t�H�[��]�O��5�Z�����̑ΏۑS�ĂɃ_���[�W��^����"
                                         + "<br>"+ "[�K�����x��:60][��������:�u��][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[L_FWE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�I���e�B�l�[�g
        ui.cb_buff[L_ALE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�ߋ����t�H�[���Ɖ������t�H�[���ɕύX����"
                                         + "<br>"+ "�������t�H�[���ł͍U�����x���������A�ΏۂƂ̋����������Ȃ�قǃ_���[�W����������"
                                         + "<br>"+ "�������t�H�[���̍U����DEX�E�������_���[�W�E�����������̉e�����󂯂Ȃ�"
                                         + "<br>"+ "[�K�����x��:50][��������:�u��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[L_ALE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�N���[�G��:�R���r�N�V����
        ui.cb_buff[L_KCN].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�N���[�G���̎˒���2�Z���L�΂��A�X�^�����Ԃ𑝉�����"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[L_KCN].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�C���N���[�Y �����W
        ui.cb_buff[L_IRE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�������t�H�[���̎˒���3�Z���L�΂��A�_���[�W��20%��������"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[L_IRE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���C���X�g����
        ui.cb_buff[L_MAM].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�`����������[�X�^��][�z�[���h][�A�ҕs�\]�̌��ʂ��󂯂����ɁA���m���Ŕ��˂��đ���ɕԂ�"
                                         + "<br>"+ "[�K�����x��:75][��������:�펞][�Ώ�:�p��][�G�}:������(15)]"+"</html>");
        if (ui.cb_buff[L_MAM].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�h�b�W �u���C�N
        ui.cb_buff[L_DBK].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�Ώۂ��U��������������ɁA20%�̊m���ŕK������"
                                         + "<br>"+ "���x��80����A���x��3����3%�������m�ő�35%�n"
                                         + "<br>"+ "[�K�����x��:75][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[L_DBK].isSelected()) {
        //�X�L�����ʖ�����
        }

        //���F���W�F���X
        ui.cb_buff[L_VEE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�_���[�W���󂯂����ɁA���m���Ń_���[�W�ቺ�̌��ʂ�����"
                                         + "<br>"+ "HP��50%�ȉ��ɂȂ�Ɣ������ƌ��ʂ��㏸����"
                                         + "<br>"+ "[�K�����x��:70][��������:�펞][�Ώ�:�p��][�G�}:HP50%�ȉ��ɂȂ�ƌ�����(5)]"+"</html>");
        if (ui.cb_buff[L_VEE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�^�N�e�B�J�� �A�h�o���X
        ui.cb_buff[L_TAE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "DG+5 ER+5 MR+5%"
                                         + "<br>"+ "���x��80����A���x��3����+2�������m�ő�+15�n"
                                         + "<br>"+ "[�K�����x��:70][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[L_TAE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�f�b�h���[ �X�g���C�N
        ui.cb_buff[L_DSE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "���m���Ń_���[�W��2.5�{�ɂ���"
                                         + "<br>"+ "[�K�����x��:65][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[L_DSE].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�o�[�T�[�J�[
        ui.cb_buff[W_BER].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�p�҂ɋߋ����_���[�W+2 �ߋ�������+8"
                                         + "<br>"+ "PT�����o�[�ɋߋ����_���[�W+2 �ߋ�������+8 AC+10 HP���R�񕜕s��"
                                         + "<br>"+ "[�K�����x��:56][��������:5��20�b][�Ώ�:�p��/PT�����o�[(15�Z��)]"+"</html>");
        if (ui.cb_buff[W_BER].isSelected()) {
            switch ((String) ui.cb_buff_group[W_BER].getSelectedItem()) {
                case "�p��":
                    ui.cb_buff[W_BER].setToolTipText("�ߋ����_���[�W+2 �ߋ�������+8");
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 8;
                    break;
                case "PT�����o�[":
                    ui.cb_buff[W_BER].setToolTipText("�ߋ����_���[�W+2 �ߋ�������+8 AC+10 HP���R�񕜕s��");
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 8;
                    buff.HPR -= 255;
                    buff.AC += 10;
                    break;
                default:
                    break;
            }
        }

        //�u���X�h�A�[�}�[
        ui.cb_buff[W_BAR].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�I�������Z��AC-3"
                                         + "<br>"+ "�_�u���N���b�N�ő������Ă���Z�Ɏ����r������"
                                         + "<br>"+ "[�K�����x��:24][��������:30��][�Ώ�:�p��/PT�����o�[]"+"</html>");
        if (ui.cb_buff[W_BAR].isSelected()) {
            buff.AC -= 3;
        }

        //�G���`�����g�A�L�����V�[
        ui.cb_buff[W_EAY].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "�ߋ�������+5"
                                         + "<br>"+ "[�K�����x��:56][��������:5��][�Ώ�:�p��][�G�}:���͂̐�(1)]"+"</html>");
        if (ui.cb_buff[W_EAY].isSelected()) {
            buff.HIT_SHORT += 5;
        }

        //�t���[�W���O�A�[�}�[
        ui.cb_buff[W_FAR].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "ER+5"
                                         + "<br>"+ "[�K�����x��:56][��������:5��][�Ώ�:�p��][�G�}:���͂̐�(1)]"+"</html>");
        if (ui.cb_buff[W_FAR].isSelected()) {
            buff.ER += 5;
        }

        //�h���S���̏j��1�Ɖ���1(�����d�ʑ���+500�͕ʂŏ���)2�����̔���Ŏ������Ă���:6165�s�ڎQ��
        ui.cb_buff[DRAGON_BLESS].setToolTipText("<html>"+ "�h���S���̏j��:"
                                                + "<br>"+ "�_���[�W����+4"
                                                + "<br>"+ "�S�Ă̑ϐ�+5"
                                                + "<br>"+ "PVP�_���[�W�ቺ+5"
                                                + "<br>"+ "�����d�ʑ���+500"
                                                + "<br>"
                                                + "<br>"+ "�h���S���̉���:"
                                                + "<br>"+ "<�_���[�W����+2"
                                                + "<br>"+ "�����d�ʑ���+100"+"</html>");

        if (ui.cb_buff[DRAGON_BLESS].isSelected()) {
            switch ((String) ui.cb_buff_group[DRAGON_BLESS].getSelectedItem()) {
                case "�j��":
                    ui.cb_buff[DRAGON_BLESS].setToolTipText("<html>"+ "�h���S���̏j��:"
                                                            + "<br>"+ "�_���[�W����+4"
                                                            + "<br>"+ "�S�Ă̑ϐ�+5"
                                                            + "<br>"+ "PVP�_���[�W�ቺ+5"
                                                            + "<br>"+ "�����d�ʑ���+500"+"</html>");
                    buff.DR += 4;                               //�_���[�W����+4
                    buff.ailment[STUN] += 5;                    //�Z�p�ϐ�+5
                    buff.ailment[SPIRIT] += 5;                  //����ϐ�+5
                    buff.ailment[SECRET] += 5;                  //��Z�ϐ�+5
                    buff.ailment[TERROR] += 5;                  //���|�ϐ�+5
                    buff.PVP_DR += 5;                           //PVP�_���[�W�ቺ+5
                    break;
                case "����":
                    ui.cb_buff[DRAGON_BLESS].setToolTipText("<html>"+ "�h���S���̉���:"
                                                            + "<br>"+ "�_���[�W����+2"
                                                            + "<br>"+ "�����d�ʑ���+100"+"</html>");
                    buff.DR += 2;                               //�_���[�W����+2
                    break;
                default:
                    break;
            }
        }

        //�N���C
        ui.cb_buff[CLAY].setToolTipText("<html>"+ "HP+100 MP+50 HPR+3 MPR+3"
                                        + "<br>"+ "�ߋ����_���[�W+1 �������_���[�W+1 �ߋ�������+5"
                                        + "<br>"+ "�n������R+30 �f�B�N���[�X�E�F�C�g"+"</html>");
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
        //���݂������O
        ui.cb_buff[MOMIJI].setToolTipText("HP+200 �S�X�e�[�^�X+1");
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

        //�G���N�T�[���[��(LV70/80/85/90/91/92/93/94/95)
        int e = ui.elixir_rune.getSelectedIndex();
        int q = ui.elixir_rune_en.getSelectedIndex();
        if (e > 0 && e<6) {
            buff.ST[e - 1]++;
            switch (cls) {
                case P:
                                //LV55
                    buff.DR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                  + "<br>"+ "�_���[�W�ቺ: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�_���[�W�ቺ: +3"
                                                          + "<br>"+ "�ߋ�������: +2"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 2: //LV80
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�_���[�W�ቺ: +3"
                                                          + "<br>"+ "�ߋ�������: +2"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "PVP���@�_���[�W����: +1%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 3: //LV85
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 5;    //�Z�p����+5
                                                            //PVP���@�_���[�W����+2%
                                                            //�G���N�T�[�u�[�X�^�[����
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�_���[�W�ቺ: +3"
                                                          + "<br>"+ "�ߋ�������: +2"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +5"
                                                          + "<br>"+ "PVP���@�_���[�W����: +2%"
                                                          + "<br>"+ "�G���N�T�[�u�[�X�^�[����"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 4: //LV90
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 10;   //�Z�p����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�_���[�W�ቺ: +3"
                                                          + "<br>"+ "�ߋ�������: +2"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +10"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 5: //LV91
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 11;   //�Z�p����+11
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�_���[�W�ቺ: +3"
                                                          + "<br>"+ "�ߋ�������: +2"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +11"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 12;   //�Z�p����+12
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�_���[�W�ቺ: +3"
                                                          + "<br>"+ "�ߋ�������: +2"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +12"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 13;   //�Z�p����+13
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�_���[�W�ቺ: +3"
                                                          + "<br>"+ "�ߋ�������: +2"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +13"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 14;   //�Z�p����+14
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�_���[�W�ቺ: +3"
                                                          + "<br>"+ "�ߋ�������: +2"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +14"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 15;   //�Z�p����+15
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�_���[�W�ቺ: +3"
                                                          + "<br>"+ "�ߋ�������: +2"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +15"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        default:
                            
                            break;
                    }
                    break;
                case K:
                                //LV55
                    buff.HP += 50;
                    ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                  + "<br>"+ "HP: +50"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 2: //LV80
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "PVP���@�_���[�W����: +1%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 3: //LV85
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 5;    //�Z�p����+5
                                                            //PVP���@�_���[�W����+2%
                                                            //�G���N�T�[�u�[�X�^�[����
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +5"
                                                          + "<br>"+ "PVP���@�_���[�W����: +2%"
                                                          + "<br>"+ "�G���N�T�[�u�[�X�^�[����"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 4: //LV90
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 10;   //�Z�p����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +10"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 5: //LV91
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 11;   //�Z�p����+11
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +11"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 12;   //�Z�p����+12
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +12"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 13;   //�Z�p����+13
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +13"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 14;   //�Z�p����+14
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +14"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 15;   //�Z�p����+15
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "HP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "�Z�p����: +15"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case E:
                                //LV55
                    buff.MP += 50;
                    ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                  + "<br>"+ "MP: +50"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�������_���[�W: +1"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 2: //LV80
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�������_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "PVP���@�_���[�W����: +1%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 3: //LV85
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 5;  //���얽��+5
                                                            //PVP���@�_���[�W����+2%
                                                            //�G���N�T�[�u�[�X�^�[����
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�������_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +5"
                                                          + "<br>"+ "PVP���@�_���[�W����: +2%"
                                                          + "<br>"+ "�G���N�T�[�u�[�X�^�[����"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 4: //LV90
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 10; //���얽��+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�������_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +10"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 5: //LV91
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 11; //���얽��+11
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�������_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +11"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 12; //���얽��+12
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�������_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +12"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 13; //���얽��+13
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�������_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +13"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 14; //���얽��+14
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�������_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +14"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 15; //���얽��+15
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MP: +50"
                                                          + "<br>"+ "�ߋ����_���[�W: +1"
                                                          + "<br>"+ "�������_���[�W: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +15"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case W:
                                //LV55
                    buff.MPR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                  + "<br>"+ "MPR: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.SP += 1;                   //SP+1
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 2: //LV80
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "PVP���@�_���[�W����: +1%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 3: //LV85
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                            buff.HIT_MAGIC += 5;            //���@����+5
                                                            //PVP���@�_���[�W����+2%
                                                            //�G���N�T�[�u�[�X�^�[����
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���@����: +5"
                                                          + "<br>"+ "PVP���@�_���[�W����: +2%"
                                                          + "<br>"+ "�G���N�T�[�u�[�X�^�[����"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 4: //LV90
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                            buff.HIT_MAGIC += 10;           //���@����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���@����: +10"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 5: //LV91
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                            buff.HIT_MAGIC += 11;           //���@����+11
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���@����: +11"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                            buff.HIT_MAGIC += 12;           //���@����+12
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���@����: +12"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                            buff.HIT_MAGIC += 13;           //���@����+13
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���@����: +13"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                            buff.HIT_MAGIC += 14;           //���@����+14
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���@����: +14"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                            buff.HIT_MAGIC += 15;           //���@����+15
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "MPR: +3"
                                                          + "<br>"+ "SP: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���@����: +15"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case D:
                                //LV55
                    buff.AC -= 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                  + "<br>"+ "AC: -3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.MP += 30;                  //�ő�MP+30
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "�ő�MP: +30"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 2: //LV80
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "�ő�MP: +30"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "PVP���@�_���[�W����: +1%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 3: //LV85
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 5;  //���얽��+5
                                                            //PVP���@�_���[�W����+2%
                                                            //�G���N�T�[�u�[�X�^�[����
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "�ő�MP: +30"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +5"
                                                          + "<br>"+ "PVP���@�_���[�W����: +2%"
                                                          + "<br>"+ "�G���N�T�[�u�[�X�^�[����"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 4: //LV90
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 10; //���얽��+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "�ő�MP: +30"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +10"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 5: //LV91
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 11; //���얽��+11
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "�ő�MP: +30"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +11"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 12; //���얽��+12
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "�ő�MP: +30"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +12"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 13; //���얽��+13
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "�ő�MP: +30"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +13"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 14; //���얽��+14
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "�ő�MP: +30"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +14"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 15; //���얽��+15
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "AC: -3"
                                                          + "<br>"+ "�ő�MP: +30"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���얽��: +15"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case R:
                                //LV55
                    buff.HIT_SHORT += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                  + "<br>"+ "�ߋ�������: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�_���[�W�ቺ: +1"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 2: //LV80
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�_���[�W�ቺ: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "PVP���@�_���[�W����: +1%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 3: //LV85
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 5;  //��Z����+5
                                                            //PVP���@�_���[�W����+2%
                                                            //�G���N�T�[�u�[�X�^�[����
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�_���[�W�ቺ: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +5"
                                                          + "<br>"+ "PVP���@�_���[�W����: +2%"
                                                          + "<br>"+ "�G���N�T�[�u�[�X�^�[����"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 4: //LV90
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 10; //��Z����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�_���[�W�ቺ: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +10"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 5: //LV91
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 11; //��Z����+11
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�_���[�W�ቺ: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +11"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 12; //��Z����+12
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�_���[�W�ቺ: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +12"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 13; //��Z����+13
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�_���[�W�ቺ: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +13"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 14; //��Z����+14
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�_���[�W�ቺ: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +14"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 15; //��Z����+15
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�_���[�W�ቺ: +1"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +15"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case I:
                                //LV55
                    buff.r_weight += 0.12;
                    ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                  + "<br>"+ "�����d�ʑ���: +300"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.HP += 50;                  //�ő�HP+50
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�����d�ʑ���: +300"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 2: //LV80
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�����d�ʑ���: +300"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "PVP���@�_���[�W����: +1%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 3: //LV85
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 5;  //��Z����+5
                                                            //PVP���@�_���[�W����+2%
                                                            //�G���N�T�[�u�[�X�^�[����
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�����d�ʑ���: +300"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +5"
                                                          + "<br>"+ "PVP���@�_���[�W����: +2%"
                                                          + "<br>"+ "�G���N�T�[�u�[�X�^�[����"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 4: //LV90
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 10; //��Z����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�����d�ʑ���: +300"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +10"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 5: //LV91
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 11; //��Z����+11
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�����d�ʑ���: +300"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +11"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 12; //��Z����+12
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�����d�ʑ���: +300"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +12"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 13; //��Z����+13
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�����d�ʑ���: +300"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +13"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 14; //��Z����+14
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�����d�ʑ���: +300"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +14"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 15; //��Z����+15
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�����d�ʑ���: +300"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "��Z����: +15"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case S:
                                //LV55
                    buff.HP += 50;
                    ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                  + "<br>"+ "�ő�HP: +50"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.MR += 5;                   //MR+5%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 2: //LV80
                            buff.MR += 5;                   //MR+5%
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "PVP���@�_���[�W����: +1%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 3: //LV85
                            buff.MR += 5;                   //MR+5%
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 5;  //���|����+5
                                                            //PVP���@�_���[�W����+2%
                                                            //�G���N�T�[�u�[�X�^�[����
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +5"
                                                          + "<br>"+ "PVP���@�_���[�W����: +2%"
                                                          + "<br>"+ "�G���N�T�[�u�[�X�^�[����"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 4: //LV90
                            buff.MR += 5;                   //MR+5%
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 10; //���|����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +10"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 5: //LV91
                            buff.MR += 5;                   //MR+5%
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 11; //���|����+11
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +11"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.MR += 5;                   //MR+5%
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 12; //���|����+12
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +12"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.MR += 5;                   //MR+5%
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 13; //���|����+13
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +13"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.MR += 5;                   //MR+5%
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 14; //���|����+14
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +14"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.MR += 5;                   //MR+5%
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 15; //���|����+15
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "�ő�HP: +50"
                                                          + "<br>"+ "MR: +5%"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +15"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case F:
                                //LV55
                    buff.DR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                  + "<br>"+ "DR: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 2: //LV80
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "PVP���@�_���[�W����: +1%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 3: //LV85
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 5;  //���|����+5
                                                            //PVP���@�_���[�W����+2%
                                                            //�G���N�T�[�u�[�X�^�[����
                            ui.elixir_rune.setToolTipText("<html>"+  "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +5"
                                                          + "<br>"+ "PVP���@�_���[�W����: +2%"
                                                          + "<br>"+ "�G���N�T�[�u�[�X�^�[����"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 4: //LV90
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 10; //���|����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +10"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 5: //LV91
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 11; //���|����+11
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +11"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 12; //���|����+12
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +12"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 13; //���|����+13
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +13"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 14; //���|����+14
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +14"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 15; //���|����+15
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +15"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                case L:
                                //LV55
                    buff.DR += 3;
                    ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                  + "<br>"+ "DR: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
                    switch (q) {
                        case 1: //LV70
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 2: //LV80
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "PVP���@�_���[�W����: +1%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 3: //LV85
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 5;  //���|����+5
                                                            //PVP���@�_���[�W����+2%
                                                            //�G���N�T�[�u�[�X�^�[����
                            ui.elixir_rune.setToolTipText("<html>"+  "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +5"
                                                          + "<br>"+ "PVP���@�_���[�W����: +2%"
                                                          + "<br>"+ "�G���N�T�[�u�[�X�^�[����"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 4: //LV90
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 10; //���|����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +10"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 5: //LV91
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 11; //���|����+11
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +11"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 6: //LV92
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 12; //���|����+12
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +12"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 7: //LV93
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 13; //���|����+13
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +13"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 8: //LV94
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 14; //���|����+14
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +14"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        case 9: //LV95
                            buff.HIT_SHORT += 3;            //�ߋ�������+3
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 15; //���|����+15
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("<html>"+ "�X�e: +1"
                                                          + "<br>"+ "DR: +3"
                                                          + "<br>"+ "�ߋ�������: +3"
                                                          + "<br>"+ "�j�����Ռ���: +5%"
                                                          + "<br>"+ "���|����: +15"
                                                          + "<br>"+ "PVP���@�_���[�W����: +3%"
                                                          + "<br>"+ "�ގ�: �z��"
                                                          + "<br>"+ "�d��: 1"+"</html>");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

        }else if (e == 0){                              //���g�p
                    ui.elixir_rune.setToolTipText("");
        }else if (e == 6){                              //�A���J�̈╨
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //�ߋ����_���[�W+2
                    buff.HIT_SHORT += 2;                //�ߋ�������+2
                    buff.DMG_LONG += 2;                 //�������_���[�W+2
                    buff.HIT_LONG += 2;                 //����������+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_MAGIC += 2;                //���@����+2
                    buff.MR += 5;                       //MR+5%
                    buff.MEXP += 2;                     //�l���o���l+2%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -3"
                                                  + "<br>"+ "�ߋ����_���[�W: +2"
                                                  + "<br>"+ "�ߋ�������: +2"
                                                  + "<br>"+ "�������_���[�W: +2"
                                                  + "<br>"+ "����������: +2"
                                                  + "<br>"+ "SP: +2"
                                                  + "<br>"+ "���@����: +2"
                                                  + "<br>"+ "MR: +5%"
                                                  + "<br>"+ "�l���o���l: +2%"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 7){                              //�������ꂽ�A���J�̈╨
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //�ߋ����_���[�W+2
                    buff.HIT_SHORT += 2;                //�ߋ�������+2
                    buff.DMG_LONG += 2;                 //�������_���[�W+2
                    buff.HIT_LONG += 2;                 //����������+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_MAGIC += 2;                //���@����+2
                    buff.MR += 5;                       //MR+5%
                    buff.ailment[TERROR] += 5;          //���|�ϐ�+5
                    buff.MEXP += 5;                     //�l���o���l+5%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -3"
                                                  + "<br>"+ "�ߋ����_���[�W: +2"
                                                  + "<br>"+ "�ߋ�������: +2"
                                                  + "<br>"+ "�������_���[�W: +2"
                                                  + "<br>"+ "����������: +2"
                                                  + "<br>"+ "SP: +2"
                                                  + "<br>"+ "���@����: +2"
                                                  + "<br>"+ "MR: +5%"
                                                  + "<br>"+ "���|�ϐ�: +5"
                                                  + "<br>"+ "�l���o���l: +5%"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 8){                              //�h���S���̈╨
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //�ߋ����_���[�W+2
                    buff.HIT_SHORT += 2;                //�ߋ�������+2
                    buff.DMG_LONG += 2;                 //�������_���[�W+2
                    buff.HIT_LONG += 2;                 //����������+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_MAGIC += 2;                //���@����+2
                    buff.MEXP += 2;                     //�l���o���l+2%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -3"
                                                  + "<br>"+ "�ߋ����_���[�W: +2"
                                                  + "<br>"+ "�ߋ�������: +2"
                                                  + "<br>"+ "�������_���[�W: +2"
                                                  + "<br>"+ "����������: +2"
                                                  + "<br>"+ "SP: +2"
                                                  + "<br>"+ "���@����: +2"
                                                  + "<br>"+ "�l���o���l: +2%"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 9){                              //�������ꂽ�h���S���̈╨(�r��)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[STR] += 1;                  //STR+1
                    buff.DMG_SHORT += 4;                //�ߋ����_���[�W+4
                    buff.HIT_SHORT += 6;                //�ߋ�������+6
                    buff.MEXP += 10;                    //�l���o���l+10%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "STR: +1"
                                                  + "<br>"+ "�ߋ����_���[�W: +4"
                                                  + "<br>"+ "�ߋ�������: +6"
                                                  + "<br>"+ "�l���o���l: +10%"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 10){                             //�������ꂽ�h���S���̈╨(�m��)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[INT] += 1;                  //INT+1
                    buff.SP += 4;                       //SP+4
                    buff.HIT_MAGIC += 6;                //���@����+6
                    buff.MEXP += 10;                    //�l���o���l+10%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "INT: +1"
                                                  + "<br>"+ "SP: +4"
                                                  + "<br>"+ "���@����: +6"
                                                  + "<br>"+ "�l���o���l: +10%"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 11){                             //�������ꂽ�h���S���̈╨(�@�q)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[DEX] += 1;                  //DEX+1
                    buff.DMG_LONG += 4;                 //�������_���[�W+4
                    buff.HIT_LONG += 6;                 //����������+6
                    buff.MEXP += 10;                    //�l���o���l+10%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "DEX: +1"
                                                  + "<br>"+ "�������_���[�W: +4"
                                                  + "<br>"+ "����������: +6"
                                                  + "<br>"+ "�l���o���l: +10%"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 12){                             //�^�f�X�i�C�g�̈╨
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //�ߋ����_���[�W+2
                    buff.HIT_SHORT += 2;                //�ߋ�������+2
                    buff.DMG_LONG += 2;                 //�������_���[�W+2
                    buff.HIT_LONG += 2;                 //����������+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_MAGIC += 2;                //���@����+2
                    buff.MEXP += 2;                     //�l���o���l+2%
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -3"
                                                  + "<br>"+ "�ߋ����_���[�W: +2"
                                                  + "<br>"+ "�ߋ�������: +2"
                                                  + "<br>"+ "�������_���[�W: +2"
                                                  + "<br>"+ "����������: +2"
                                                  + "<br>"+ "SP: +2"
                                                  + "<br>"+ "���@����: +2"
                                                  + "<br>"+ "�l���o���l: +2%"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 13){                             //�������ꂽ�^�f�X�i�C�g�̈╨(�r��)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[STR] += 1;                  //STR+1
                    buff.DMG_SHORT += 4;                //�ߋ����_���[�W+4
                    buff.HIT_SHORT += 6;                //�ߋ�������+6
                    buff.MEXP += 10;                    //�l���o���l+10%
                                                        //�j�����Ռ���+5%
                                                        //�S�ϐ�+3
                    buff.ailment[STUN] += 3;            //�Z�p�ϐ�+3
                    buff.ailment[SPIRIT] += 3;          //����ϐ�+3
                    buff.ailment[SECRET] += 3;          //��Z�ϐ�+3
                    buff.ailment[TERROR] += 3;          //���|�ϐ�+3
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "STR: +1"
                                                  + "<br>"+ "�ߋ����_���[�W: +4"
                                                  + "<br>"+ "�ߋ�������: +6"
                                                  + "<br>"+ "�l���o���l: +10%"
                                                  + "<br>"+ "�j�����Ռ���: +5%"
                                                  + "<br>"+ "�Z�p�ϐ�: +3"
                                                  + "<br>"+ "����ϐ�: +3"
                                                  + "<br>"+ "��Z�ϐ�: +3"
                                                  + "<br>"+ "���|�ϐ�: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 14){                             //�������ꂽ�^�f�X�i�C�g�̈╨(�m��)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[INT] += 1;                  //INT+1
                    buff.SP += 4;                       //SP+4
                    buff.HIT_MAGIC += 6;                //���@����+6
                    buff.MEXP += 10;                    //�l���o���l+10%
                                                        //�j�����Ռ���+5%
                                                        //�S�ϐ�+3
                    buff.ailment[STUN] += 3;            //�Z�p�ϐ�+3
                    buff.ailment[SPIRIT] += 3;          //����ϐ�+3
                    buff.ailment[SECRET] += 3;          //��Z�ϐ�+3
                    buff.ailment[TERROR] += 3;          //���|�ϐ�+3
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "INT: +1"
                                                  + "<br>"+ "SP: +4"
                                                  + "<br>"+ "���@����: +6"
                                                  + "<br>"+ "�l���o���l: +10%"
                                                  + "<br>"+ "�j�����Ռ���: +5%"
                                                  + "<br>"+ "�Z�p�ϐ�: +3"
                                                  + "<br>"+ "����ϐ�: +3"
                                                  + "<br>"+ "��Z�ϐ�: +3"
                                                  + "<br>"+ "���|�ϐ�: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 15){                             //�������ꂽ�^�f�X�i�C�g�̈╨(�@�q)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[DEX] += 1;                  //DEX+1
                    buff.DMG_LONG += 4;                 //�������_���[�W+4
                    buff.HIT_LONG += 6;                 //����������+6
                    buff.MEXP += 10;                    //�l���o���l+10%
                                                        //�j�����Ռ���+5%
                                                        //�S�ϐ�+3
                    buff.ailment[STUN] += 3;            //�Z�p�ϐ�+3
                    buff.ailment[SPIRIT] += 3;          //����ϐ�+3
                    buff.ailment[SECRET] += 3;          //��V�ϐ�+3
                    buff.ailment[TERROR] += 3;          //���|�ϐ�+3
                    ui.elixir_rune.setToolTipText("<html>"+ "AC: -4"
                                                  + "<br>"+ "DEX: +1"
                                                  + "<br>"+ "�������_���[�W: +4"
                                                  + "<br>"+ "����������: +6"
                                                  + "<br>"+ "�l���o���l: +10%"
                                                  + "<br>"+ "�j�����Ռ���: +5%"
                                                  + "<br>"+ "�Z�p�ϐ�: +3"
                                                  + "<br>"+ "����ϐ�: +3"
                                                  + "<br>"+ "��Z�ϐ�: +3"
                                                  + "<br>"+ "���|�ϐ�: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 16){                             //�p�Y�̈╨
                    buff.MEXP += 2;                     //EXP+2%
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //�ߋ����_���[�W+2
                    buff.DMG_LONG += 2;                 //�������_���[�W+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_SHORT += 2;                //�ߋ�������+2
                    buff.HIT_LONG += 2;                 //����������+2
                    buff.HIT_MAGIC += 2;                //���@����+2
                    ui.elixir_rune.setToolTipText("<html>"+ "�l���o���l: +2%"
                                                  + "<br>"+ "AC: -3"
                                                  + "<br>"+ "�ߋ����_���[�W: +2"
                                                  + "<br>"+ "�������_���[�W: +2"
                                                  + "<br>"+ "SP: +2"
                                                  + "<br>"+ "�ߋ�������: +2"
                                                  + "<br>"+ "����������: +2"
                                                  + "<br>"+ "���@����: +2"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 17){                             //�������ꂽ�p�Y�̈╨(�r��)
                    buff.MEXP += 10;                    //�l���o���l+10%
                    buff.AC -= 4;                       //AC-4
                    buff.ST[STR] += 1;                  //STR+1
                    buff.DMG_SHORT += 4;                //�ߋ����_���[�W+4
                    buff.HIT_SHORT += 6;                //�ߋ�������+6
                                                        //�j�����Ռ���+5%
                                                        //�S�ϐ�+3
                    buff.ailment[STUN] += 3;            //�Z�p�ϐ�+3
                    buff.ailment[SPIRIT] += 3;          //����ϐ�+3
                    buff.ailment[SECRET] += 3;          //��V�ϐ�+3
                    buff.ailment[TERROR] += 3;          //���|�ϐ�+3
                    ui.elixir_rune.setToolTipText("<html>"+ "�l���o���l: +10%"
                                                  + "<br>"+ "AC: -4"
                                                  + "<br>"+ "STR: +1"
                                                  + "<br>"+ "�ߋ����_���[�W: +4"
                                                  + "<br>"+ "�ߋ�������: +6"
                                                  + "<br>"+ "�j�����Ռ���: +5%"
                                                  + "<br>"+ "�Z�p�ϐ�: +3"
                                                  + "<br>"+ "����ϐ�: +3"
                                                  + "<br>"+ "��Z�ϐ�: +3"
                                                  + "<br>"+ "���|�ϐ�: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 18){                             //�������ꂽ�p�Y�̈╨(�m��)
                    buff.MEXP += 10;                    //�l���o���l+10%
                    buff.AC -= 4;                       //AC-4
                    buff.ST[INT] += 1;                  //INT+1
                    buff.SP += 4;                       //SP+4
                    buff.HIT_MAGIC += 6;                //���@����+6
                                                        //�j�����Ռ���+5%
                                                        //�S�ϐ�+3
                    buff.ailment[STUN] += 3;            //�Z�p�ϐ�+3
                    buff.ailment[SPIRIT] += 3;          //����ϐ�+3
                    buff.ailment[SECRET] += 3;          //��V�ϐ�+3
                    buff.ailment[TERROR] += 3;          //���|�ϐ�+3
                    ui.elixir_rune.setToolTipText("<html>"+ "�l���o���l: +10%"
                                                  + "<br>"+ "INT: +1"
                                                  + "<br>"+ "SP: +4"
                                                  + "<br>"+ "���@����: +6"
                                                  + "<br>"+ "�j�����Ռ���: +5%"
                                                  + "<br>"+ "�Z�p�ϐ�: +3"
                                                  + "<br>"+ "����ϐ�: +3"
                                                  + "<br>"+ "��Z�ϐ�: +3"
                                                  + "<br>"+ "���|�ϐ�: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }else if (e == 19){                             //�������ꂽ�p�Y�̈╨(�@�q)
                    buff.MEXP += 10;                    //�l���o���l+10%
                    buff.AC -= 4;                       //AC-4
                    buff.ST[DEX] += 1;                  //DEX+1
                    buff.DMG_LONG += 4;                 //�������_���[�W+4
                    buff.HIT_LONG += 6;                 //����������+6
                                                        //�j�����Ռ���+5%
                                                        //�S�ϐ�+3
                    buff.ailment[STUN] += 3;            //�Z�p�ϐ�+3
                    buff.ailment[SPIRIT] += 3;          //����ϐ�+3
                    buff.ailment[SECRET] += 3;          //��V�ϐ�+3
                    buff.ailment[TERROR] += 3;          //���|�ϐ�+3
                    ui.elixir_rune.setToolTipText("<html>"+ "�l���o���l: +10%"
                                                  + "<br>"+ "DEX: +1"
                                                  + "<br>"+ "�������_���[�W: +4"
                                                  + "<br>"+ "����������: +6"
                                                  + "<br>"+ "�j�����Ռ���: +5%"
                                                  + "<br>"+ "�Z�p�ϐ�: +3"
                                                  + "<br>"+ "����ϐ�: +3"
                                                  + "<br>"+ "��Z�ϐ�: +3"
                                                  + "<br>"+ "���|�ϐ�: +3"
                                                  + "<br>"+ "�ގ�: �z��"
                                                  + "<br>"+ "�d��: 1"+"</html>");
        }

        //�^���X�}��
            switch (ui.cb_pattern_l2.getSelectedIndex()) {
                case 0:
                    break;
                case 1:                                 //�l��(�ߋ���)
                    buff.DMG_SHORT += 1;    //�ߋ����_���[�W+1
                    buff.HIT_SHORT += 1;    //�ߋ�������+1
                    buff.SP += 1;           //SP+1
                    buff.MR += 5;           //MR+5
                    break;
                case 2:                                 //�l��(������)
                    buff.DMG_LONG += 1;     //�������_���[�W+1
                    buff.HIT_LONG += 1;     //����������+1
                    buff.SP += 1;           //SP+1
                    buff.MR += 5;           //MR+5
                    break;
                case 3:                                 //�Z��(�ߋ���/������)
                    buff.DMG_SHORT += 1;    //�ߋ����_���[�W+1
                    buff.HIT_SHORT += 1;    //�ߋ�������+1
                    buff.DMG_LONG += 1;     //�������_���[�W+1
                    buff.HIT_LONG += 1;     //����������+1
                    buff.SP += 1;           //SP+1
                    buff.MR += 5;           //MR+5
                    break;
                case 4:                                 //�ۉ�̓��̃^���X�}��
                    break;
                default:
                    break;
            }

            //�I���^�[�X�g�[��
        if (ui.cb_pattern_r2.getSelectedIndex() >= 6 && ui.cb_pattern_r2.getSelectedIndex() <= 8) {

            ui.cb_alterstone_en.setEnabled(true);
            if (ui.cb_alterstone_en.getSelectedIndex() >= 3) {
                ui.cb_alterstone_op[0].setEnabled(true);
                switch (ui.cb_alterstone_op[0].getSelectedIndex()) {
                    case 1:
                        buff.DMG_SHORT += 1;        //�ߋ����_���[�W +1
                        break;
                    case 2:
                        buff.DMG_LONG += 1;         //�������_���[�W +1
                        break;
                    case 3:
                        buff.HIT_SHORT += 2;        //�ߋ������� +2
                        break;
                    case 4:
                        buff.HIT_LONG += 2;         //���������� +2
                        break;
                    case 5:
                        buff.SP += 1;               //SP +1
                        break;
                    case 6:
                        buff.CRI_MAGIC += 1;        //���@�N���e�B�J�� +1
                        break;
                    case 7:
                                                    //���@���Ռ���+2
                        break;
                    case 8:
                                                    //�ꌂ�K�E(1%�m���Œǉ��_���[�W50) 3216�s�Œǉ�����
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
                        buff.DMG_SHORT += 1;        //�ߋ����_���[�W +1
                        break;
                    case 2:
                        buff.DMG_LONG += 1;         //�������_���[�W +1
                        break;
                    case 3:
                        buff.HIT_SHORT += 2;        //�ߋ������� +2
                        break;
                    case 4:
                        buff.HIT_LONG += 2;         //���������� +2
                        break;
                    case 5:
                        buff.SP += 1;               //SP +1
                        break;
                    case 6:
                        buff.CRI_MAGIC += 1;        //���@�N���e�B�J�� +1
                        break;
                    case 7:
                                                    //���@���Ռ���+2
                        break;
                    case 8:
                                                    //�ꌂ�K�E(1%�m���Œǉ��_���[�W50) 3216�s�Œǉ�����
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
                        buff.DMG_SHORT += 1;        //�ߋ����_���[�W +1
                        break;
                    case 2:
                        buff.DMG_LONG += 1;         //�������_���[�W +1
                        break;
                    case 3:
                        buff.HIT_SHORT += 2;        //�ߋ������� +2
                        break;
                    case 4:
                        buff.HIT_LONG += 2;         //���������� +2
                        break;
                    case 5:
                        buff.SP += 1;               //SP +1
                        break;
                    case 6:
                        buff.CRI_MAGIC += 1;        //���@�N���e�B�J�� +1
                        break;
                    case 7:
                                                    //���@���Ռ���+2
                        break;
                    case 8:
                                                    //�ꌂ�K�E(1%�m���Œǉ��_���[�W50) 3216�s�Œǉ�����
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
                //�I���^�[�X�g�[�� �E��
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
                    //�I���^�[�X�g�[��6�i�K
                    case 6:
                        buff.HP += 60;
                        buff.MP += 40;
                        buff.ST[STR] += 1;
                        buff.HIT_SHORT += 1;
                        buff.DMG_SHORT += 1;
                        buff.MR += 5;
                        buff.DR += 1;
                        break;     
                    //�I���^�[�X�g�[��7�i�K
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
                //�I���^�[�X�g�[�� ���e
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
                    //�I���^�[�X�g�[��6�i�K
                    case 6:   
                        buff.HP += 50;
                        buff.MP += 50;
                        buff.ST[DEX] += 1;
                        buff.HIT_LONG += 1;
                        buff.DMG_LONG += 1;
                        buff.MR += 5;
                        buff.DR += 1;
                        break;
                    //�I���^�[�X�g�[��7�i�K
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
                //�I���^�[�X�g�[�� �b�q
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
                    //�I���^�[�X�g�[��6�i�K
                    case 6:
                        buff.HP += 40;
                        buff.MP += 60;
                        buff.ST[INT] += 1;
                        buff.MPR += 1;
                        buff.SP += 1;
                        buff.MR += 5;
                        buff.DR += 1;
                        break;
                    //�I���^�[�X�g�[��7�i�K
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
        ui.cb_buff[B_STR].setToolTipText("<html>"+ "STR+3 �h���X�}�C�e�B"
                                         + "<br>"+ "STR+5 �t�B�W�J���G���`�����g"
                                         + "<br>"+ "STR+6 ����̃|�[�V����"
                                         + "<br>"+ "STR+6(DEX+6) �t���[���̃|�[�V����"
                                         + "<br>"+ "STR+6(DEX+6 AC-5) �l�G�̃|�[�V����"
                                         + "<br>"+ "STR+7 �̑�ȗE�҂̃X�N���[��"
                                         + "<br>"+ "STR+7(DEX+7) �N���X�}�X�L�����f�B�["+"</html>");
        if (ui.cb_buff[B_STR].isSelected()) {
            switch (ui.cb_buff_group[B_STR].getSelectedIndex()) {
                case 0:
                    ui.cb_buff[B_STR].setToolTipText("STR+3 �h���X�}�C�e�B");
                    buff.ST[STR] += 3;
                    if (ui.cb_buff[B_STR].getForeground().equals(Color.BLUE)) {
                        cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                    }
                    break;
                case 1:
                    ui.cb_buff[B_STR].setToolTipText("STR+5 �t�B�W�J���G���`�����g");
                    buff.ST[STR] += 5;
                    if (ui.cb_buff[B_STR].getForeground().equals(Color.BLUE)) {
                        cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 2:
                    ui.cb_buff[B_STR].setToolTipText("<html>"+ "STR+6 ����̃|�[�V����"
                                                     + "<br>"+ "STR+6(DEX+6) �t���[���̃|�[�V����"
                                                     + "<br>"+ "STR+6(DEX+6 AC-5) �l�G�̃|�[�V����"+"</html>");
                    buff.ST[STR] += 6;
                    break;
                case 3:
                    ui.cb_buff[B_STR].setToolTipText("<html>"+ "STR+7 �̑�ȗE�҂̃X�N���[��"
                                                     + "<br>"+ "STR+7(DEX+7) �N���X�}�X�L�����f�B�["+"</html>");
                    buff.ST[STR] += 7;
                    break;
                default:
                    break;
            }
        }

        //DEX
        ui.cb_buff[B_DEX].setToolTipText("<html>"+ "DEX+3 �h���X�f�N�X�^���e�B�["
                                         + "<br>"+ "DEX+5 �t�B�W�J���G���`�����g"
                                         + "<br>"+ "DEX+6 �˔\�̃|�[�V����"
                                         + "<br>"+ "DEX+6(STR+6) �t���[���̃|�[�V����"
                                         + "<br>"+ "DEX+6(STR+6 AC-5) �l�G�̃|�[�V����"
                                         + "<br>"+ "DEX+7 �̑�Ȗ��|�̃X�N���[��"
                                         + "<br>"+ "DEX+7(STR+7) �N���X�}�X�L�����f�B�["+"</html>");
        if (ui.cb_buff[B_DEX].isSelected()) {
            switch (ui.cb_buff_group[B_DEX].getSelectedIndex()) {
                case 0:
                    ui.cb_buff[B_DEX].setToolTipText("DEX+3 �h���X�f�N�X�^���e�B�[");
                    buff.ST[DEX] += 3;
                    if (ui.cb_buff[B_DEX].getForeground().equals(Color.BLUE)) {
                        cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                    }
                    break;
                case 1:
                    ui.cb_buff[B_DEX].setToolTipText("DEX+5 �t�B�W�J���G���`�����g");
                    buff.ST[DEX] += 5;
                    if (ui.cb_buff[B_DEX].getForeground().equals(Color.BLUE)) {
                        cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 2:
                    ui.cb_buff[B_DEX].setToolTipText("<html>"+ "DEX+6 �˔\�̃|�[�V����"
                                                     + "<br>"+ "DEX+6(STR+6) �t���[���̃|�[�V����"
                                                     + "<br>"+ "DEX+6(STR+6 AC-5) �l�G�̃|�[�V����"+"</html>");
                    buff.ST[DEX] += 6;
                    break;
                case 3:
                    ui.cb_buff[B_DEX].setToolTipText("<html>"+ "DEX+7 �̑�Ȗ��|�̃X�N���[��"
                                                     + "<br>"+ "DEX+7(STR+7) �N���X�}�X�L�����f�B�["+"</html>");
                    buff.ST[DEX] += 7;
                    break;
                default:
                    break;
            }
        }

        acc = 1.0;

        //�����ɂ�鋭���w�C�X�g����
        if (buki.op.effect.contains("�w�C�X�g")) {
            ui.cb_buff[ACC1].setSelected(true);
        }
        for (Bougu bougu1 : bougu) {
            if (bougu1.op.effect.contains("�w�C�X�g")) {
                ui.cb_buff[ACC1].setSelected(true);
                break;
            }
        }

        //POT�ɂ��w�C�X�g����
        ui.cb_buff[ACC1].setToolTipText("x1.3333:GP GGP ���C�� �E�C�X�L�[");
        if (ui.cb_buff[ACC1].isSelected()) {
            acc *= acc_1;
        }

        ui.cb_buff[ACC2].setToolTipText("<html>"+ "x1.3333:BP �C�r���u���b�h �u���b�h���X�g ���_�̃R�C�� �_���V���O�u���C�Y �t�H�[�J�X�E�F�[�u �n���P�[�� �T���h�X�g�[��"
                                        + "<br>"+ "x1.1547:EW �Z�k�W���|�[�V���� ���[�r���O�A�N�Z���[�V����:�}�L�V�}��"
                                        + "<br>"+ "x1.0800:�_�[�N�z�[�X"+"</html>");
        if (ui.cb_buff[ACC2].isSelected()) {
            switch (ui.cb_buff_group[ACC2].getSelectedIndex()) {
                case 0:
                    ui.cb_buff[ACC2].setToolTipText("x1.3333:BP �C�r���u���b�h �u���b�h���X�g ���_�̃R�C�� �_���V���O�u���C�Y �t�H�[�J�X�E�F�[�u �n���P�[�� �T���h�X�g�[��");
                    acc *= acc_2;
                    break;
                case 1:
                    ui.cb_buff[ACC2].setToolTipText("x1.1547:EW �Z�k�W���|�[�V���� ���[�r���O�A�N�Z���[�V����:�}�L�V�}��");
                    acc *= acc_ew;
                    break;
                case 2:
                    ui.cb_buff[ACC2].setToolTipText("x1.0800:�_�[�N�z�[�X");
                    acc *= acc_df;
                    break;
                default:
                    break;
            }
        }

        ui.cb_buff[ACC3].setToolTipText("x1.1250:�h���S���u���b�h �����̃p�[�� ���o���鑠��");
        if (ui.cb_buff[ACC3].isSelected()) {
            acc *= acc_3;
        }

        ui.cb_buff[ACC4].setToolTipText("x1.1000:�}�W�b�N�h�[���̐��ݗ�");
        if (ui.cb_buff[ACC4].isSelected()) {
            acc *= acc_4;
        }

        ui.cb_buff[ACC5].setToolTipText("x1.1000:�R�m�Z�p(���C�W���O �E�F�|��)");
        if (ui.cb_buff[ACC5].isSelected()) {
            acc *= acc_5;
        }

//2019/11/20Update HW/EW/BW/SF�̎d�l�ύX
//���܂ł͕���ɃG���`�����g���ʂ�������������̓L�����Ɍ��ʂ�����
//2019/12/25�ɋ��v�Z���@�ł̃_���[�W�v�Z���ł���悤�ɍ��ڒǉ�
        buki.magic_enchant = 0;
        buki2.magic_enchant = 0;
        ui.cb_buff[BUKI].setToolTipText("<html>"+ "�ߋ����_���[�W+1 �ߋ�������+1 �z�[���[�E�F�|��"
                                        + "<br>"+ "�ߋ����_���[�W+2 �G���`�����g�E�F�|��"
                                        + "<br>"+ "�ߋ����_���[�W+2 �ߋ�������+2 �u���X�E�F�|��"
                                        + "<br>"+ "�ߋ����_���[�W+5 �V���h�E�t�@���O"+"</html>");
        if (ui.cb_buff[BUKI].isSelected()) {
            switch (ui.cb_buff_group[BUKI].getSelectedIndex()) {
                case 0://�z�[���[�E�F�|�� �ߋ����_���[�W+1 �ߋ�������+1(�L�����ɑ΂���)
                    ui.cb_buff[BUKI].setToolTipText("�ߋ����_���[�W+1 �ߋ�������+1 �z�[���[�E�F�|��(�L�����ɑ΂���)");
                    buff.DMG_SHORT += 1;
                    buff.HIT_SHORT += 1;
                    break;
                case 1://�G���`�����g�E�F�|�� �ߋ����_���[�W+2(�L�����ɑ΂���)
                    ui.cb_buff[BUKI].setToolTipText("�ߋ����_���[�W+2 �G���`�����g�E�F�|��(�L�����ɑ΂���)");
                    buff.DMG_SHORT += 2;
                    break;
                case 2://�u���X�E�F�|�� �ߋ����_���[�W+2 �ߋ�������+2(�L�����ɑ΂���)
                    ui.cb_buff[BUKI].setToolTipText("�ߋ����_���[�W+2 �ߋ�������+2 �u���X�E�F�|��(�L�����ɑ΂���)");
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    break;
                case 3://�V���h�E�t�@���O �ߋ����_���[�W+5(�L�����ɑ΂���)
                    ui.cb_buff[BUKI].setToolTipText("�ߋ����_���[�W+5 �V���h�E�t�@���O(�L�����ɑ΂���)");
                    buff.DMG_SHORT += 5;
                    break;
                case 4://�z�[���[�E�F�|�� �ߋ����_���[�W+1 �ߋ�������+1(����ɑ΂���)
                    ui.cb_buff[BUKI].setToolTipText("�ߋ����_���[�W+1 �ߋ�������+1 �z�[���[�E�F�|��(����ɑ΂���)");
                    buki.magic_enchant = 1;
                    buki2.magic_enchant = 1;
                    buff.HIT_SHORT += 1;
                    break;
                case 5://�G���`�����g�E�F�|�� �ߋ����_���[�W+2(����ɑ΂���)
                    ui.cb_buff[BUKI].setToolTipText("�ߋ����_���[�W+2 �G���`�����g�E�F�|��(����ɑ΂���)");
                    buki.magic_enchant = 2;
                    buki2.magic_enchant = 2;
                    break;
                case 6://�u���X�E�F�|�� �ߋ����_���[�W+2 �ߋ�������+2(����ɑ΂���)
                    ui.cb_buff[BUKI].setToolTipText("�ߋ����_���[�W+2 �ߋ�������+2 �u���X�E�F�|��(����ɑ΂���)");
                    buki.magic_enchant = 2;
                    buki2.magic_enchant = 2;
                    buff.HIT_SHORT += 2;
                    break;
                case 7://�V���h�E�t�@���O �ߋ����_���[�W+5(����ɑ΂���)
                    ui.cb_buff[BUKI].setToolTipText("�ߋ����_���[�W+5 �V���h�E�t�@���O(����ɑ΂���)");
                    buki.magic_enchant = 5;
                    buki2.magic_enchant = 5;
                    break;
                default:
                    break;
            }
        }

//�N�喂�@�i�v�����X�E�v�����Z�X)
        //�v���C��
        ui.cb_buff[P_PRE].setToolTipText("<html>"+ "[����MP:25][����HP:--]"
                                         + "<br>"+ "��ʓ��̌������ɋ��͂ȃo�t��t�^ �Z�p����+5(�p�҂̂�)"
                                         + "<br>"+ "�ߋ����_���[�W+3 �ߋ�������+3 �������_���[�W+3 ����������+3 SP+2 ���@����+2"
                                         + "<br>"+ "���x��85����A���x��5����PVP�_���[�W�ቺ+5(�ő�+15)"
                                         + "<br>"+ "�U���ł̓o�t�̌��ʂ�3�{�ɂȂ�ő�HP+500���ǉ������"
                                         + "<br>"+ "PVP�_���[�W�ቺ��ǉ�"
                                         + "<br>"+ "[�K�����x��:85][��������:20��][�Ώ�:������][�G�}:������(200)]"+"</html>");
        if (ui.cb_buff[P_PRE].isSelected()) {
            //PVP�_���[�W�ቺ+5(���x��85����A���x��5����PVP�_���[�W�ቺ+5(�ő�+15))
            if (level >= 90) {
                buff.PVP_DR += 15;
            } else if (level >= 85) {
                buff.PVP_DR += 10;
            } else if (level >= 80) {
                buff.PVP_DR += 5;
            }
            switch ((String) ui.cb_buff_group[P_PRE].getSelectedItem()) {
                case "�p��":
                    ui.cb_buff[P_PRE].setToolTipText("�ߋ����_���[�W+3 �ߋ�������+3 �������_���[�W+3 ����������+3 SP+2 ���@����+2 �Z�p����+5");
                    buff.ailment[STUN] += 5;
                    buff.DMG_SHORT += 3;
                    buff.HIT_SHORT += 3;
                    buff.DMG_LONG += 3;
                    buff.HIT_LONG += 3;
                    buff.SP += 2;
                    buff.HIT_MAGIC += 2;
                    break;
                case "������":
                    ui.cb_buff[P_PRE].setToolTipText("�ߋ����_���[�W+3 �ߋ�������+3 �������_���[�W+3 ����������+3 SP+2 ���@����+2");
                    buff.DMG_SHORT += 3;
                    buff.HIT_SHORT += 3;
                    buff.DMG_LONG += 3;
                    buff.HIT_LONG += 3;
                    buff.SP += 2;
                    buff.HIT_MAGIC += 2;
                    break;
                case "�p��(�U���)":
                    ui.cb_buff[P_PRE].setToolTipText("�ߋ����_���[�W+9 �ߋ�������+9 �������_���[�W+9 ����������+9 SP+6 ���@����+6 HP+500 �Z�p����+15");
                    buff.ailment[STUN] += 15;
                    buff.DMG_SHORT += 9;
                    buff.HIT_SHORT += 9;
                    buff.DMG_LONG += 9;
                    buff.HIT_LONG += 9;
                    buff.SP += 6;
                    buff.HIT_MAGIC += 6;
                    buff.HP += 500;
                    break;
                case "������(�U���)":
                    ui.cb_buff[P_PRE].setToolTipText("�ߋ����_���[�W+9 �ߋ�������+9 �������_���[�W+9 ����������+9 SP+6 ���@����+6 HP+500");
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

        //�R�[���N���� �A�h�o���X
        ui.cb_buff[P_CCA].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "8�Z������PT��g�񂾌�����1�l���p�҂̎��͂ɏ�������"
                                         + "<br>"+ "�Ώۂ���Ԉُ�ł������\�@�ǉz�������͕s�\"
                                         + "<br>"+ "�ʃN�[���^�C���K�p"
                                         + "<br>"+ "[�K�����x��:90][��������:�u��][�Ώ�:������][�G�}:������(200)]"+"</html>");
        if (ui.cb_buff[P_CCA].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�G���p�C�A
        ui.cb_buff[P_EME].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "1�Z�����̑ΏۂɃ_���[�W��^���A���m���ŃX�^����Ԃɂ���"
                                         + "<br>"+ "�f�B���C6�b"
                                         + "<br>"+ "[�K�����x��:80][��������:�ő�6�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[P_EME].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�O���[�X
        ui.cb_buff[P_GRE].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "18�Z������PT�����o�[�ɑS�X�L���ϐ�+1"
                                         + "<br>"+ "���x��80���烌�x��1���Ɍ��ʂ�+1������[�ő�+15]"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "���x��80 �Z�p�ϐ�+1 ����ϐ�+1 ��Z�ϐ�+1 ���|�ϐ�+1"
                                         + "<br>"+ "���x��84 �Z�p�ϐ�+5 ����ϐ�+5 ��Z�ϐ�+5 ���|�ϐ�+5"
                                         + "<br>"+ "���x��94+ �Z�p�ϐ�+15 ����ϐ�+15 ��Z�ϐ�+15 ���|�ϐ�+15"
                                         + "<br>"+ "��������60�b�@����MP30"
                                         + "<br>"+ "[�K�����x��:80][��������:1��][�Ώ�:PT�����o�[]"+"</html>");
        if (ui.cb_buff[P_GRE].isSelected()) {
            switch ((String) ui.cb_buff_group[P_GRE].getSelectedItem()) {
                case "�N��L80":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+1 ����ϐ�+1 ��Z�ϐ�+1 ���|�ϐ�+1");
                    buff.ailment[STUN] += 1;
                    buff.ailment[SPIRIT] += 1;
                    buff.ailment[SECRET] += 1;
                    buff.ailment[TERROR] += 1;
                    break;
                case "�N��L81":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+2 ����ϐ�+2 ��Z�ϐ�+2 ���|�ϐ�+2");
                    buff.ailment[STUN] += 2;
                    buff.ailment[SPIRIT] += 2;
                    buff.ailment[SECRET] += 2;
                    buff.ailment[TERROR] += 2;
                    break;
                case "�N��L82":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+3 ����ϐ�+3 ��Z�ϐ�+3 ���|�ϐ�+3");
                    buff.ailment[STUN] += 3;
                    buff.ailment[SPIRIT] += 3;
                    buff.ailment[SECRET] += 3;
                    buff.ailment[TERROR] += 3;
                    break;
                case "�N��L83":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+4 ����ϐ�+4 ��Z�ϐ�+4 ���|�ϐ�+4");
                    buff.ailment[STUN] += 4;
                    buff.ailment[SPIRIT] += 4;
                    buff.ailment[SECRET] += 4;
                    buff.ailment[TERROR] += 4;
                    break;
                case "�N��L84":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+5 ����ϐ�+5 ��Z�ϐ�+5 ���|�ϐ�+5");
                    buff.ailment[STUN] += 5;
                    buff.ailment[SPIRIT] += 5;
                    buff.ailment[SECRET] += 5;
                    buff.ailment[TERROR] += 5;
                    break;
                case "�N��L85":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+6 ����ϐ�+6 ��Z�ϐ�+6 ���|�ϐ�+6");
                    buff.ailment[STUN] += 6;
                    buff.ailment[SPIRIT] += 6;
                    buff.ailment[SECRET] += 6;
                    buff.ailment[TERROR] += 6;
                    break;
                case "�N��L86":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+7 ����ϐ�+7 ��Z�ϐ�+7 ���|�ϐ�+7");
                    buff.ailment[STUN] += 7;
                    buff.ailment[SPIRIT] += 7;
                    buff.ailment[SECRET] += 7;
                    buff.ailment[TERROR] += 7;
                    break;
                case "�N��L87":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+8 ����ϐ�+8 ��Z�ϐ�+8 ���|�ϐ�+8");
                    buff.ailment[STUN] += 8;
                    buff.ailment[SPIRIT] += 8;
                    buff.ailment[SECRET] += 8;
                    buff.ailment[TERROR] += 8;
                    break;
                case "�N��L88":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+9 ����ϐ�+9 ��Z�ϐ�+9 ���|�ϐ�+9");
                    buff.ailment[STUN] += 9;
                    buff.ailment[SPIRIT] += 9;
                    buff.ailment[SECRET] += 9;
                    buff.ailment[TERROR] += 9;
                    break;
                case "�N��L89":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+10 ����ϐ�+10 ��Z�ϐ�+10 ���|�ϐ�+10");
                    buff.ailment[STUN] += 10;
                    buff.ailment[SPIRIT] += 10;
                    buff.ailment[SECRET] += 10;
                    buff.ailment[TERROR] += 10;
                    break;
                case "�N��L90":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+11 ����ϐ�+11 ��Z�ϐ�+11 ���|�ϐ�+11");
                    buff.ailment[STUN] += 11;
                    buff.ailment[SPIRIT] += 11;
                    buff.ailment[SECRET] += 11;
                    buff.ailment[TERROR] += 11;
                    break;
                case "�N��L91":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+12 ����ϐ�+12 ��Z�ϐ�+12 ���|�ϐ�+12");
                    buff.ailment[STUN] += 12;
                    buff.ailment[SPIRIT] += 12;
                    buff.ailment[SECRET] += 12;
                    buff.ailment[TERROR] += 12;
                    break;
                case "�N��L92":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+13 ����ϐ�+13 ��Z�ϐ�+13 ���|�ϐ�+13");
                    buff.ailment[STUN] += 13;
                    buff.ailment[SPIRIT] += 13;
                    buff.ailment[SECRET] += 13;
                    buff.ailment[TERROR] += 13;
                    break;
                case "�N��L93":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+14 ����ϐ�+14 ��Z�ϐ�+14 ���|�ϐ�+14");
                    buff.ailment[STUN] += 14;
                    buff.ailment[SPIRIT] += 14;
                    buff.ailment[SECRET] += 14;
                    buff.ailment[TERROR] += 14;
                    break;
                case "�N��L94+":
                    ui.cb_buff[P_GRE].setToolTipText("�Z�p�ϐ�+15 ����ϐ�+15 ��Z�ϐ�+15 ���|�ϐ�+15");
                    buff.ailment[STUN] += 10;
                    buff.ailment[SPIRIT] += 10;
                    buff.ailment[SECRET] += 10;
                    buff.ailment[TERROR] += 10;
                    break;
                default:
                    break;
            }
        }

        //�}�W�F�X�e�B
        ui.cb_buff[P_MAY].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "�_���[�W�ቺ+2"
                                         + "<br>"+ "���x��80����A���x��2����[�_���[�W�ቺ+1]"
                                         + "<br>"+ "[�K�����x��:80][��������:10��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[P_MAY].isSelected()) {
            //DR+2(���x��80����2���x�����オ�閈��+1)
            if (level <= 80) {
                buff.DR += 2;
            } else if (level > 80) {
                buff.DR += 2+(level/2-40);
            }
        }

        //�V���C�j���O�A�[�}�[
        ui.cb_buff[P_SAR].setToolTipText("<html>"+ "[����MP:30][����HP:50]"
                                         + "<br>"+ "ER+10"
                                         + "<br>"+ "[�K�����x��:80][��������:10��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[P_SAR].isSelected()) {
            buff.ER += 10;
        }

        //�V���C�j���O�V�[���h
        ui.cb_buff[P_SSD].setToolTipText("<html>"+ "[����MP:25][����HP:--]"
                                         + "<br>"+ "�p�҂�AC-8/PT�����o�[�ɂ�AC-4"
                                         + "<br>"+ "[�K�����x��:75][��������:10��40�b][�Ώ�:�p��/PT�����o�[]"+"</html>");
        if (ui.cb_buff[P_SSD].isSelected()) {
            switch ((String) ui.cb_buff_group[P_SSD].getSelectedItem()) {
                case "�p��":
                    ui.cb_buff[P_SSD].setToolTipText("AC-8");
                    buff.AC -= 8;
                    break;
                case "PT�����o�[":
                    ui.cb_buff[P_SSD].setToolTipText("AC-4");
                    buff.AC -= 4;
                    break;
                default:
                    break;
            }
        }

        //�u���C�u�����^��
        //6213�s�ɂď���
        
        //�O���[�C���O�E�F�|��
        ui.cb_buff[P_GWN].setToolTipText("<html>"+ "[����MP:25][����HP:--]"
                                         + "<br>"+ "�ߋ����_���[�W+5 �ߋ�������+5"
                                         + "<br>"+ "[�K�����x��:60][��������:10��40�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[P_GWN].isSelected()) {
            buff.HIT_SHORT += 5;
            buff.DMG_SHORT += 5;
        }

        //�g�D���[�^�[�Q�b�g(������)
        ui.cb_buff[P_TTT].setToolTipText("<html>"+ "[����MP:1][����HP:--]"
                                         + "<br>"+ "��ʓ��ɋ���Ώۂ��w�肵�āA������/PT�����o�[�ɋ�������"
                                         + "<br>"+ "������/PT�����o�[�́A�w�肵���v���C���[�ւ̃_���[�W��1%����"
                                         + "<br>"+ "���x��15����[�_���[�W+1%]"
                                         + "<br>"+ "���ُ�Ԃł��r���\"
                                         + "<br>"+ "[�K�����x��:50][��������:16�b][�Ώ�:PC/NPC]"+"</html>");
        if (ui.cb_buff[P_TTT].isSelected()) {
        //�X�L�����ʖ�����
        }

        //�I�[��
        ui.cb_buff[P_AUA].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�p�҂�18�Z������PT�����o�[�ɏ펞���ʂ���������"
                                         + "<br>"+ "STR+1 DEX+1 INT+1 MR+10 �Z�p�ϐ�+2 ����ϐ�+2 ����ϐ�+2 ���|�ϐ�+2"
                                         + "<br>"+ "[�K�����x��:80][��������:�펞][�Ώ�:�p��/PT�����o�[]"+"</html>");
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

        //AC�X�L��
        ui.cb_buff[B_AC].setToolTipText("<html>"+ "AC-2 �V�[���h"
                                        + "<br>"+ "AC-4 �t�@�C���[�V�[���h"
                                        + "<br>"+ "AC-5 �l�G�̃|�[�V����"
                                        + "<br>"+ "AC-10 �A�C�A���X�L��"+"</html>");
        if (ui.cb_buff[B_AC].isSelected()) {
            switch (ui.cb_buff_group[B_AC].getSelectedIndex()) {
                case 0://�V�[���h		AC-2	����MP8  ���@���x��1 �p������1800�b
                    ui.cb_buff[B_AC].setToolTipText("AC-2 �V�[���h");
                    buff.AC += -2;
                    break;
                case 1://�t�@�C���[�V�[���h 	AC-4	����MP15 ���@���x��3 �p������960�b
                    ui.cb_buff[B_AC].setToolTipText("AC-4 �t�@�C���[�V�[���h");
                    buff.AC += -4;
                    break;
                case 2://�l�G�̃|�[�V���� 	AC-5      
                    ui.cb_buff[B_AC].setToolTipText("AC-5 �l�G�̃|�[�V����");
                    buff.AC += -5;
                    break;
                case 3://�A�C�A���X�L��          AC-10	����MP30 ���@���x��5 �p������960�b
                    ui.cb_buff[B_AC].setToolTipText("AC-10 �A�C�A���X�L��");
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
        //�Z�L�����e�B
        ui.cb_buff[SEC].setToolTipText("AC-1 MR+2% �_���[�W�ቺ+1");
            if (ui.cb_buff[SEC].isSelected()) {
            buff.AC -= 1;
            buff.MR += 2;
            buff.DR += 1;
        }
        //�^�S�̂��������j���X�N���[��
        ui.cb_buff[MBSC].setToolTipText("<html>"+ "�_���[�W�ቺ+3 �ߋ����_���[�W+2 �������_���[�W+2 �ߋ�������+2 ����������+2"
                                        + "<br>"+ "���@����+2 SP+2 �ő�HP+50 HP��+3 �ő�MP+30 MP��+3 �l���o���l+5% 30��"+"</html>");
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
            buff.MEXP += 5;                     //�l���o���l+5%
        }
        //�o�t�R�C�� 
        ui.cb_buff[BUFF_COIN].setToolTipText("�ߋ����_���[�W+1 �������_���[�W+1 SP+1");
            if (ui.cb_buff[BUFF_COIN].isSelected()) {
            buff.DMG_SHORT += 1;
            buff.DMG_LONG += 1;
            buff.SP += 1;
        }
        //���ւ̃R�C�� 
        ui.cb_buff[BS_COIN].setToolTipText("HP+20 MP+13 AC-2 �_���[�W�ቺ+3");
            if (ui.cb_buff[BS_COIN].isSelected()) {
            buff.HP += 20;
            buff.MP += 13;
            buff.AC -= 2;
            buff.DR += 3;
        }
        //����
        ui.cb_buff[ITEM_MAGAN].setToolTipText("<html>"+ "�n���̖��� ��Z�ϐ�+5"
                                              + "<br>"+ "�����̖��� ����ϐ�+5"
                                              + "<br>"+ "�����̖��� ���|�ϐ�+5"
                                              + "<br>"+ "�Η��̖��� �Z�p�ϐ�+5"
                                              + "<br>"+ "�a���̖��� ����ϐ�+5 ��Z�ϐ�+5"
                                              + "<br>"+ "�`��̖��� ����ϐ�+5 ��Z�ϐ�+5 ���|�ϐ�+5"
                                              + "<br>"+ "�����̖��� �Z�p�ϐ�+5 ����ϐ�+5 ��Z�ϐ�+5 ���|�ϐ�+5 �Z�p����+3 ���얽��+3 ��Z����+3 ���|����+3"
                                              + "<br>"+ "�O���������̖��� �ߋ����_���[�W+2 �������_���[�W+2 SP+1");
        if (ui.cb_buff[ITEM_MAGAN].isSelected()) {
            switch (ui.cb_buff_group[ITEM_MAGAN].getSelectedIndex()) {
                case 0://�n���̖���
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("��Z�ϐ�+5");
                    buff.ailment[SECRET] += 5;
                    break;
                case 1://�����̖���
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("����ϐ�+5");
                    buff.ailment[SPIRIT] += 5;
                    break;
                case 2://�����̖��� 
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("���|�ϐ�+5"); 
                    buff.ailment[TERROR] += 5;
                    break;
                case 3://�Η��̖���
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("�Z�p�ϐ�+5");
                    buff.ailment[STUN] += 5;
                    break;
                case 4://�a���̖���
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("����ϐ�+5 ��Z�ϐ�+5");
                    buff.ailment[SPIRIT] += 5;
                    buff.ailment[SECRET] += 5;
                    break;
                case 5://�`��̖���
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("����ϐ�+5 ��Z�ϐ�+5 ���|�ϐ�+5");
                    buff.ailment[SPIRIT] += 5;
                    buff.ailment[SECRET] += 5;
                    buff.ailment[TERROR] += 5;
                    break;
                case 6://�����̖���
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("�Z�p�ϐ�+5 ����ϐ�+5 ��Z�ϐ�+5 ���|�ϐ�+5 �Z�p����+3 ���얽��+3 ��Z����+3 ���|����+3");
                    buff.ailment[STUN] += 5;
                    buff.ailment[SPIRIT] += 5;
                    buff.ailment[SECRET] += 5;
                    buff.ailment[TERROR] += 5;
                    buff.ailment[HIT_STUN] += 3;
                    buff.ailment[HIT_SPIRIT] += 3;
                    buff.ailment[HIT_SECRET] += 3;
                    buff.ailment[HIT_TERROR] += 3;
                    break;
                case 7://�O���������̖���
                    ui.cb_buff[ITEM_MAGAN].setToolTipText("�ߋ����_���[�W+2 �������_���[�W+2 SP+1");
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.SP += 1;
                    break;
                default:
                    break;
            }
        }
        //�����̉ʎ� y_ikeda����ɂ��C�����Q�l��
        ui.cb_buff[L_HST].setToolTipText("<html>"+ "1�� �l���o���l+20% AC-1"
                                         + "<br>"+ "2�� �l���o���l+30% AC-2 DR+1"
                                         + "<br>"+ "3�� �l���o���l+40% AC-3 DR+2"
                                         + "<br>"+ "4�� �l���o���l+40% AC-4 DR+2"
                                         + "<br>"+ "5�� �l���o���l+40% AC-5 DR+2"+"</html>");
        if (ui.cb_buff[L_HST].isSelected()) {
            switch ((String) ui.cb_buff_group[L_HST].getSelectedItem()) {
                case "1��":
                    ui.cb_buff[L_HST].setToolTipText("�l���o���l+20% AC-1");
                    buff.MEXP += 20;                                       //�l���o���l+20%
                    buff.AC -= 1;
                    break;
                case "2��":
                    ui.cb_buff[L_HST].setToolTipText("�l���o���l+30% AC-2 DR+1");
                    buff.MEXP += 30;                                       //�l���o���l+30%
                    buff.AC -= 2;
                    buff.DR += 1;
                    break;
                case "3��":
                    ui.cb_buff[L_HST].setToolTipText("�l���o���l+40% AC-3 DR+2");
                    buff.MEXP += 40;                                       //�l���o���l+40%
                    buff.AC -= 3;
                    buff.DR += 2;
                    break;
                case "4��":
                    ui.cb_buff[L_HST].setToolTipText("�l���o���l+40% AC-4 DR+2");
                    buff.MEXP += 40;                                       //�l���o���l+40%
                    buff.AC -= 4;
                    buff.DR += 2;
                    break;
                case "5��":
                    ui.cb_buff[L_HST].setToolTipText("�l���o���l+40% AC-5 DR+2");
                    buff.MEXP += 40;                                       //�l���o���l+40%
                    buff.AC -= 5;
                    buff.DR += 2;
                    break;
                default:
                    break;
            }
        }
        //�����̃{�[�i�X
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
        //�S�b�̃{�[�i�X
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
        //�����̃{�[�i�X
        ui.cb_buff[H_PVPDR].setToolTipText("<html>"+ "PVP�_���[�W�ቺ+1"
                                           + "<br>"+ "PVP�_���[�W�ቺ+2"+"</html>");
        if (ui.cb_buff[H_PVPDR].isSelected()) {
            switch ((String) ui.cb_buff_group[H_PVPDR].getSelectedItem()) {
                case "PVP DR+1":
                    ui.cb_buff[H_PVPDR].setToolTipText("PVP�_���[�W�ቺ+1");
                    buff.PVP_DR += 1;
                    break;
                case "PVP DR+2":
                    ui.cb_buff[H_PVPDR].setToolTipText("PVP�_���[�W�ቺ+2");
                    buff.PVP_DR += 2;
                    break;
                default:
                    break;
            }
        }
        //�ÎE�̃{�[�i�X
        ui.cb_buff[H_PVP].setToolTipText("<html>"+ "PVP�_���[�W+1"
                                         + "<br>"+ "PVP�_���[�W+2"+"</html>");
        if (ui.cb_buff[H_PVP].isSelected()) {
            switch ((String) ui.cb_buff_group[H_PVP].getSelectedItem()) {
                case "PVP �_��+1":
                    ui.cb_buff[H_PVP].setToolTipText("PVP�_���[�W+1");
                    buff.PVP += 1;
                    break;
                case "PVP �_��+2":
                    ui.cb_buff[H_PVP].setToolTipText("PVP�_���[�W+2");
                    buff.PVP += 2;
                    break;
                default:
                    break;
            }
        }
        //�����J�[�{�[�i�X
        //STR+1[�N��][�i�C�g][�_�[�N�G���t][�h���S���i�C�g][�E�H���A�[][�t�F���T�[][�����T�[]
        //DEX+1[�G���t]
        //INT+1[�E�B�U�[�h][�C�����[�W���j�X�g]
        ui.cb_buff[H_RK].setToolTipText("<html>"+ "STR+1[�N��][�i�C�g][�_�[�N�G���t][�h���S���i�C�g][�E�H���A�[][�t�F���T�[][�����T�[]"
                                        + "<br>"+ "DEX+1[�G���t]"
                                        + "<br>"+ "INT+1[�E�B�U�[�h][�C�����[�W���j�X�g]"+"</html>");
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
        
        //�N���X����
        ui.cb_buff[H_RKT].setToolTipText("<html>"+ "�N���X�ʑS�T�[�o�[����1��"
                                         + "<br>"+ "3,600�b���Ƃ�1��̎g�p���\"
                                         + "<br>"+ "�R�X�g:����1,000��"
                                         + "<br>"+ "HP+200 PVP�_���[�W����+10 [600�b]"+"</html>");
        if (ui.cb_buff[H_RKT].isSelected()) {
                    ui.cb_buff[H_RKT].setToolTipText("HP+200 PVP�_���[�W����+10 [600�b]");
                    buff.HP += 200;
                    buff.PVP += 10;
        }

//�d�ʃy�i���e�B
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

        //�ǉ��_���[�W
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

//�e�X�e�[�^�X�̏���l
//STR:
        if (pure_str >= 25) {
            base_dmg_short += 1;                //�ߋ����_���[�W+1
            base_hit_short += 1;                //�ߋ�������+1
        }
        if (pure_str >= 35) {
            base_dmg_short += 1;                //�ߋ����_���[�W+1
            base_hit_short += 1;                //�ߋ�������+1
        }
        if (pure_str >= 45) {
            base_dmg_short += 3;                //�ߋ����_���[�W+3
            base_hit_short += 3;                //�ߋ�������+3
            cri_short += 1;                     //�ߋ����N���e�B�J��+1%
        }
        if (pure_str >= 55) {
            base_dmg_short += 5;                //�ߋ����_���[�W+5
            base_hit_short += 5;                //�ߋ�������+5
            cri_short += 2;                     //�ߋ����N���e�B�J��+2%
        }
        if (pure_str >= 60) {
            base_dmg_short += 5;                //�ߋ����_���[�W+5
            base_hit_short += 5;                //�ߋ�������+5
            cri_short += 2;                     //�ߋ����N���e�B�J��+2%
        }

//DEX:
        if (pure_dex >= 25) {
            base_dmg_long += 1;                 //�������_���[�W+1
            base_hit_long += 1;                 //����������+1
        }
        if (pure_dex >= 35) {
            base_dmg_long += 1;                 //�������_���[�W+1
            base_hit_long += 1;                 //����������+1
        }
        if (pure_dex >= 45) {
            base_dmg_long += 3;                 //�������_���[�W+3
            base_hit_long += 3;                 //����������+3
            cri_long += 1;                      //�������N���e�B�J��+1%
        }
        if (pure_dex >= 55) {
            base_dmg_long += 5;                 //�������_���[�W+5
            base_hit_long += 5;                 //����������+5
            cri_long += 2;                      //�������N���e�B�J��+2%
        }
        if (pure_dex >= 60) {
            base_dmg_long += 5;                 //�������_���[�W+5
            base_hit_long += 5;                 //����������+5
            cri_long += 2;                      //�������N���e�B�J��+2%
        }

//INT:
        if (pure_int >= 25) {
            base_dmg_magic += 1;                //���@�_���[�W+1
            base_hit_magic += 1;                //���@����+1
        }
        if (pure_int >= 35) {
            base_dmg_magic += 1;                //���@�_���[�W+1
            base_hit_magic += 1;                //���@����+1
        }
        if (pure_int >= 45) {
            base_dmg_magic += 3;                //���@�_���[�W+3
            base_hit_magic += 3;                //���@����+3
            cri_magic += 1;                     //���@�N���e�B�J��+1%
        }
        if (pure_int >= 55) {
            base_dmg_magic += 5;                //���@�_���[�W+5
            base_hit_magic += 5;                //���@����+5
            cri_magic += 2;                     //���@�N���e�B�J��+2%
        }
        if (pure_int >= 60) {
            base_dmg_magic += 5;                //���@�_���[�W+5
            base_hit_magic += 5;                //���@����+5
            cri_magic += 2;                     //���@�N���e�B�J��+2%
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

        //�X�y���p���[�X�V
        int_beta = sp + st_int;
        
        spr = sp + ml + mb;
        
        //�}�W�b�N���x���X�V
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
            case E:                     //�G���t:�}�W�b�N���x���ő�6����7�֕ύX
                ml = level / 8;
                if (ml > 7) {
                    ml = 7;
                }
                break;
            case W:                     //�E�B�U�[�h:�}�W�b�N���x���ő�13����15�֕ύX
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

        if (buki.type.equals("�L�[�����N")) {
            dmg_short = 0;
            for (int i = 0; i < 4; i++) {
                buff.ELEM_DMG_SHORT[i] = 0;
            }
        }

        //�����v�Z
        // STR,DEX,�N���X,�x�[�X�X�e�[�^�X,���x��
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
                case "�N���E":
                    cr = Double.parseDouble(ui.tf_buki_sp_rate.getText());
                    break;
                case "�f���A���u���[�h":
                    wh = Double.parseDouble(ui.tf_buki_sp_rate.getText());
                    break;
                case "�`�F�[���\�[�h":
                    we = Double.parseDouble(ui.tf_buki_sp_rate.getText());
                    break;
                default:
                    break;
            }
        }

        // ����I�v�V����,���틭����,�G���`�����g
        hit_short += buki.op.HIT_SHORT + buki.enchant / 2 + buff.HIT_SHORT;
        //hit_long += buki.op.HIT_LONG + buki.enchant / 2 + buff.HIT_LONG + buff.HIT_SHORT;
        hit_long += buki.arrow_hit + buki.op.HIT_LONG + buki.enchant / 2 + buff.HIT_LONG;

        buki.arrow_hit=0;

        //�G�������^�� �o�g�� �A���[
        if (buki.type.equals("�{�E")) {
            if (buki.arrow_name.contains("�Α�����")) {
                buff.ELEM_DMG_LONG[FIRE] += buki.arrow_elementdmg;
            }else if(buki.arrow_name.contains("��������")) {
                buff.ELEM_DMG_LONG[WATER] += buki.arrow_elementdmg;
            }else if(buki.arrow_name.contains("��������")) {
                buff.ELEM_DMG_LONG[WIND] += buki.arrow_elementdmg;
            }else if(buki.arrow_name.contains("�n������")) {
                buff.ELEM_DMG_LONG[EARTH] += buki.arrow_elementdmg;
            }
        }

buki.arrow_elementdmg=0;

        for (Bougu bougu1 : bougu) {
            hit_short += bougu1.op.HIT_SHORT + bougu1.op2.HIT_SHORT;
            hit_long += bougu1.op.HIT_LONG + bougu1.op2.HIT_LONG;
        }

        //�����_���[�W
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
        //���x���ɂ�鎩���U�����x��Hero�ϐg���x�̕ύX
        if (ui.cb_speed_auto.isSelected()) {

            if (ui.cb_eq[1].getSelectedIndex() > 0) {
                switch (ui.cb_morph_level.getSelectedIndex()) {
                    case 0:
                        speed = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), W_DA);
                        magic_main = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), MAIN);
                        magic_sub = polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), SUB);
                        break;
        //Hero�ϐg������
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
        //Hero�ϐg������
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

            if (buki.material.equals("�V���o�[")
                    || buki.material.equals("�~�X����")
                    || buki.material.equals("�I���n���R��")) {
//�A���f�b�h�ǉ��_���[�W(����2��)
//���d�l�@1����20�_���[�W ����10.5/2
//          dmg_undead += (1.0 + 20.0) / 2.0 / 2.0;
//�V�d�l�@1����40�_���[�W ����20.5/2
            dmg_undead += (1.0 + 40.0) / 2.0 / 2.0;
            }
            if (ui.tb_blessed1.isSelected()) {
                dmg_cursed += ((1.0 + 3.0) / 2.0 + 3.0) / 2.0;
            }

            dmg_big_ave2 = (1.0 + buki2.big) / 2 + buki2.op.DMG_SHORT + buki2.op2.DMG_SHORT + buki2.enchant + buki2.magic_enchant;
            dmg_small_ave2 = (1.0 + buki2.small) / 2 + buki2.op.DMG_SHORT + buki2.op2.DMG_SHORT + buki2.enchant + buki2.magic_enchant;

            dmg_big_max2 = buki2.big + buki2.op.DMG_SHORT + buki2.op2.DMG_SHORT + buki2.enchant + buki2.magic_enchant;
            dmg_small_max2 = buki2.small + buki2.op.DMG_SHORT + buki2.op2.DMG_SHORT + buki2.enchant + buki2.magic_enchant;

            if (buki2.material.equals("�V���o�[")
                    || buki2.material.equals("�~�X����")
                    || buki2.material.equals("�I���n���R��")) {
//�A���f�b�h�ǉ��_���[�W(����1��)
//���d�l�@1����20�_���[�W ����10.5/2
//          dmg_undead += (1.0 + 20.0) / 2.0 / 2.0;
//�V�d�l�@1����40�_���[�W ����20.5/2
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
                case "�{�E":
                case "�K���g���b�g":
                        dmg_big_ave = (1.0 + buki.big) / 2 + buki.arrow_dmg + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
                        dmg_small_ave = (1.0 + buki.small) / 2 + buki.arrow_dmg + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;

                        dmg_big_max = buki.arrow_dmg + buki.big + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;
                        dmg_small_max = buki.arrow_dmg + buki.small + buki.op.DMG_LONG + buki.op2.DMG_LONG + buki.enchant;

                    if (buki.arrow_material.equals("�V���o�[")
                            || buki.arrow_material.equals("�~�X����")
                            || buki.arrow_material.equals("�I���n���R��")) {
//�A���f�b�h�ǉ��_���[�W
//���d�l�@1����20�_���[�W ����10.5
//                      dmg_undead = (1.0 + 20.0) / 2.0;
//�V�d�l�@1����40�_���[�W ����20.5
                        dmg_undead = (1.0 + 40.0) / 2.0;
                    }
                    break;
                case "�L�[�����N":
                    dmg_big_ave = buki.x * (1.0 + buki.y) / 2 + buki.z;
                    dmg_small_ave = buki.x * (1.0 + buki.y) / 2 + buki.z;
                    break;
                default:
                    dmg_big_ave = (1.0 + buki.big) / 2 + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;
                    dmg_small_ave = (1.0 + buki.small) / 2 + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;

                    dmg_big_max = buki.big + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;
                    dmg_small_max = buki.small + buki.op.DMG_SHORT + buki.op2.DMG_SHORT + buki.enchant + buki.magic_enchant;

                    if (buki.material.equals("�V���o�[")
                            || buki.material.equals("�~�X����")
                            || buki.material.equals("�I���n���R��")) {
//�A���f�b�h�ǉ��_���[�W
//1����20�_���[�W ����10.5
//                      dmg_undead = (1.0 + 20.0) / 2.0;
//1����40�_���[�W ����20.5
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

        //�N���e�B�J������
        ui.cb_buff[E_EEE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�������N���e�B�J��+2%"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:45][��������:2��8�b][�Ώ�:�p��][�G�}:����̋�(1)]"+"</html>");
        switch (buki.type) {
            case "�L�[�����N":
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
            case "�{�E":
                //�C�[�O���A�C
//                cri_long += cr * 100;
                ui.cb_buff[E_EEE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                                 + "<br>"+ "�|��p�X�L��"
                                                 + "<br>"+ "�������N���e�B�J��+2%"
                                                 + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                                 + "<br>"+ "[�K�����x��:45][��������:2��8�b][�Ώ�:�p��][�G�}:����̋�(1)]"+"</html>");
                if (ui.cb_buff[E_EEE].isSelected()) {
                    cri_long += 2;
                }
                dmg_big_ave = (cri_long * 0.01) * dmg_big_max
                        + (1.0 - cri_long * 0.01) * dmg_big_ave;
                dmg_small_ave = (cri_long * 0.01) * dmg_small_max
                        + (1.0 - cri_long * 0.01) * dmg_small_ave;
                break;
            default:

                //�G���t �\�E���I�u�t���C��
                cri_short += cr * 100;
                ui.cb_buff[E_SOF].setToolTipText("<html>"+ "[����MP:40][����HP:--]"
                                                 + "<br>"+ "�������Ă��镐��̍ő�_���[�W�ōU������"
                                                 + "<br>"+ "���킪�������Ȃ��Ȃ�"
                                                 + "<br>"+ "[�K�����x��:80][��������:5��20�b][�Ώ�:�p��][�G�}:����̋�(5)]"+"</html>");
                if (ui.cb_buff[E_SOF].isSelected()) {
                    cri_short = 100;
                }
                dmg_big_ave = (cri_short * 0.01) * dmg_big_max
                        + (1.0 - cri_short * 0.01) * dmg_big_ave;
                dmg_small_ave = (cri_short * 0.01) * dmg_small_max
                        + (1.0 - cri_short * 0.01) * dmg_small_ave;
                break;
        }

        if (buki.type.equals("�f���A���u���[�h")) {
            if (buki.name.contains("���K") && ui.cb_mag_auto.isSelected()) {
                ui.tf_buki_sp_rate.setText(Double.toString(((int) ((wh + buki.enchant * 0.01) * 100)) / 100.0));
                dmg_big_ave *= 2.0 * (wh + buki.enchant * 0.01)
                        + (1.0 - (wh + buki.enchant * 0.01));
                dmg_small_ave *= 2.0 * (wh + buki.enchant * 0.01)
                        + (1.0 - (wh + buki.enchant * 0.01));

                //�_�u���q�b�g�ɋ����+�����������悹��
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

                //�_�u���q�b�g�ɋ����+�����������悹��
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
            case "�{�E":
            case "�K���g���b�g":
                hit = HitRateCalculator.calc(ui.cb_mode_pc.getSelectedIndex() == 0, hit_long, 10 - ui.cb_target_ac.getSelectedIndex(), ui.cb_target_dg.getSelectedIndex() == 0, ui.cb_target_dg.getSelectedIndex() == 2);
                break;
            case "�L�[�����N":
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
                case "�T���o�[�X�g":
                    double base_delay = 0.5;
                    motion_delay = 60.0 / (magic_sub * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("�T���o�[�X�g", "��", 88.0);
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
                case "�R�[���I�u�R�[���h":
                    base_delay = 0.1;
                    motion_delay = 60.0 / (magic_main * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("�R�[���I�u�R�[���h", "��", 62.0);
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
                case "�C���v�V����":
                    base_delay = 0.1;
                    motion_delay = 60.0 / (magic_main * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("�C���v�V����", "�n", 79.0);
                    mag_dmg_min = mag_dmg * 60.0 / mag_delay;
                    if (st_int >= 17) {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 15 + " /min");
//                        syouhi_mp = 15;
                    } else {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * (int) (20 * (1.0 - red_mp / 100.0)) + " /min");
                    }
                    break;
                case "�R�[�����C�g�j���O":
                    base_delay = 0.0;
                    motion_delay = 60.0 / (magic_sub * acc);
                    mag_delay = key_delay * (int) ((base_delay + motion_delay) / key_delay + 1);
                    hit *= (mag_delay - motion_delay) / mag_delay;
                    mag_dmg = getMagicDamage("�R�[�����C�g�j���O", "��", 62.5);
                    mag_dmg_min = mag_dmg * 60.0 / mag_delay;
                    if (st_int >= 16) {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * 14 + " /min");
//                        syouhi_mp = 14;
                    } else {
//                        ui.mp_syouhi.setText((int) (60.0 / mag_delay) * (int) (18 * (1.0 - red_mp / 100.0)) + " /min");
                    }
                    break;
                case "�g���v���A���[":
                    if (buki.type.equals("�{�E")) {
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

        if (buki.magic_name.equals("HP�z��")) {
            drain_small = ((dmg_small_ave + dmg_element1) / 8 + 1) - 0.5;
            drain_big = ((dmg_big_ave + dmg_element1) / 8 + 1) - 0.5;
            ui.lab_mag_info2
                    .setText("���@�_���[�W "
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

        //���@���p�C�A���b�N�^�b�`
        if (buff.effect.contains("���@���p�C�A���b�N�^�b�`")) {
            double vt_rate = 0.04;
            double vt_motion = 60.0 / (polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), buki_id));
            double atk_motion = 60.0 / (speed);

            //VT���[�V�����ɂ��U�����x�̒ቺ
            speed *= (atk_motion) / (atk_motion + vt_motion * vt_rate);
        }

        //�_�u���u���C�N
        ui.cb_buff[D_DBK].setToolTipText("<html>"+ "[����MP:12][����HP:--]"
                                         + "<br>"+ "���m��(33%)�Ńf���A���u���[�h�ƃN���E�̃_���[�W��2�{�ɂ���"
                                         + "<br>"+ "���x��45���烌�x��5���ɔ�������1%����"
                                         + "<br>"+ "[�K�����x��:60][��������:3��12�b][�Ώ�:�p��][�G�}:�_�[�N�X�g�[��(1)]"+"</html>");
        //�_�u���u���C�N:�f�X�e�B�j�[
        ui.cb_buff[D_DBD].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�_�u���u���C�N�̔������㏸"
                                         + "<br>"+ "80���x������1���x�����ɔ����m��1%����"
                                         + "<br>"+ "[�K�����x��:80][��������:3��12�b][�Ώ�:�p��]"+"</html>");
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
        //���푮��
        if (buki_id == W_DA) {
            dmg_big_ave += (dmg_element1 + dmg_element2) / 2;
            dmg_small_ave += (dmg_element1 + dmg_element2) / 2;

        } else {
            dmg_big_ave += dmg_element1;
            dmg_small_ave += dmg_element1;
        }

        //�C�����[�W����[�A�o�^�[]
        ui.cb_buff[I_IAR].setToolTipText("<html>"+ "[����MP:50][����HP:--]"
                                         + "<br>"+ "�ߋ����_���[�W+10 �������_���[�W+10 ���@�_���[�W+10"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:60][��������:2��8�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[I_IAR].isSelected()) {
            dmg_big_ave += 10;
            dmg_small_ave += 10;
        }

        //�L���[�u[�A�o�^�[]
        ui.cb_buff[I_CAR].setToolTipText("<html>"+ "[����MP:40][����HP:--]"
                                         + "<br>"+ "15�Z������PT�����o�[�ɋߋ����_���[�W+10 �������_���[�W+10 ���@�_���[�W+10 ��_���[�W+5%"
                                         + "<br>"+ "[�K�����x��:60][��������:2��8�b][�Ώ�:PT][�G�}:������(5)]"+"</html>");
        if (ui.cb_buff[I_CAR].isSelected()) {
            dmg_big_ave += 10;
            dmg_small_ave += 10;
        }

        //PVP
        if (ui.cb_mode_pc.getSelectedIndex() == 1) {
            dmg_small_ave += buff.PVP;
        }

        //�o�t����
        switch (buki.type) {
            case "�K���g���b�g":
            case "�{�E":
                dmg_big_ave += dmg_long;
                dmg_small_ave += dmg_long;
                break;
            case "�L�[�����N":
                break;
            default:
                dmg_big_ave += dmg_short;
                dmg_small_ave += dmg_short;
                break;

        }

        //�_�����_
        dmg_big_ave -= Integer.parseInt((String) ui.cb_target_dr.getSelectedItem());
        dmg_small_ave -= Integer.parseInt((String) ui.cb_target_dr.getSelectedItem());

        //�N���b�V��
        double ex = 0.0;
        ui.cb_buff[S_CRH].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "�ߋ����U�����Ɉ��m��(15��20%?)�Œǉ��_���[�W��^����"
                                         + "<br>"+ "[���x��]/[2]��^����"
                                         + "<br>"+ "[�K�����x��:45][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[S_CRH].isSelected()) {
            ex = level / 2.0;
        }

        //�t���[���[
        ui.cb_buff[S_FUY].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�N���b�V���������Ɉ��m��(10��15%?)�Ń_���[�W3�{��^����"
                                         + "<br>"+ "[�K�����x��:60][��������:�펞][�Ώ�:�p��]"+"</html>");
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

        if (buff.effect.contains("����U��(�N���X�^�V�A��/�E�F�A�E���t)")) {
            if (!(buki.type.equals("�{�E") || buki.type.equals("�K���g���b�g") || buki.type
                    .equals(("�L�[�����N")))) {
                dmg_big_ave += 0.03 * 15;
                dmg_small_ave += 0.03 * 15;
            }
        }

        //�I���^�[�X�g�[�� �ꌂ�K�E(1%�m���Œǉ��_���[�W50)�ǉ���
        if (ui.cb_pattern_r2.getSelectedIndex() >= 6 && ui.cb_pattern_r2.getSelectedIndex() <= 8) {
            if (ui.cb_alterstone_op[0].getSelectedIndex() == 8
                    || ui.cb_alterstone_op[1].getSelectedIndex() == 8
                    || ui.cb_alterstone_op[2].getSelectedIndex() == 8) {
                dmg_big_ave += 0.01 * 50;
                dmg_small_ave += 0.01 * 50;
            }
        }

        //�o�[�j���O �X�s���b�c
       ui.cb_buff[D_BSS].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                        + "<br>"+ "���m��(33%)�ŋߋ����_���[�W1.5�{"
                                        + "<br>"+ "�p�b�V�u���@"
                                        + "<br>"+ "[�K�����x��:40][��������:�펞][�Ώ�:�p��]"+"</html>");
       if (ui.cb_buff[D_BSS].isSelected()) {
            if (!(buki.type.equals("�{�E") || buki.type.equals("�K���g���b�g"))) {
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

       //�G�������^���t�@�C�A�[
        ui.cb_buff[E_EFE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "���m��(40%)�ŋߋ����_���[�W1.5�{�ɂ���"
                                         + "<br>"+ "[�K�����x��:75][��������:5��20�b][�Ώ�:�p��][�G�}:����̋�(1)]"+"</html>");
        if (ui.cb_buff[E_EFE].isSelected()) {
            if (!(buki.type.equals("�{�E") || buki.type.equals("�K���g���b�g"))) {
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

        //�N�G�C�N
        ui.cb_buff[E_QUE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "���m��(40%)�ŋߋ����_���[�W1.5�{�ɂ���"
                                         + "<br>"+ "[�K�����x��:45][��������:5��20�b][�Ώ�:�p��][�G�}:����̋�(1)]"+"</html>");
        if (ui.cb_buff[E_QUE].isSelected()) {
            if (!(buki.type.equals("�{�E") || buki.type.equals("�K���g���b�g"))) {
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

        //�T�C�N����
        ui.cb_buff[E_CYE].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "���m��(5%)�ŉ������_���[�W1.5�{�ɂ���"
                                         + "<br>"+ "LV85����LV1���ɔ�����1%����"
                                         + "<br>"+ "[�K�����x��:75][��������:16��][�Ώ�:�p��][�G�}:����̋�(2)]"+"</html>");
        if (ui.cb_buff[E_CYE].isSelected()) {
            if (level >= 75 && cls == E ) {
                double ce_lv_bonus =0;
                //LV85����̃{�[�i�X����
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
         
        //�u���C�u�����^��
        ui.cb_buff[P_BML].setToolTipText("<html>"+ "[����MP:25][����HP:--]"
                                         + "<br>"+ "���m��(40%)�ŋߋ����_���[�W1.5�{"
                                         + "<br>"+ "[�K�����x��:70][��������:10��40�b][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[P_BML].isSelected()) {
            if (!(buki.type.equals("�{�E") || buki.type.equals("�K���g���b�g"))) {
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

        //���C�W
        ui.cb_buff[F_PRE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "���m��(�b��18%)�ŋߋ����_���[�W(�b��1.5�{)"
                                         + "<br>"+ "[�K�����x��:60][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PRE].isSelected()) {
            if (!(buki.type.equals("�{�E") || buki.type.equals("�K���g���b�g"))) {
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

        //�u���[�A�^�b�N
        ui.cb_buff[K_BLK].setToolTipText("<html>"+ "[����MP:10][����HP:50]"
                                         + "<br>"+ "���m���ŋߋ����_���[�W��1.5�{"
                                         + "<br>"+ "LV75����LV1���ɔ�����1%����"
                                         + "<br>"+ "LV90����LV1���ɒǉ�������1%����"
                                         + "<br>"+ "[�ߋ�������Z�p]"
                                         + "<br>"+ "[�K�����x��:75][��������:5��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_BLK].isSelected()) {
            if (level >= 90) {
            //LV90�ȏ�̏ꍇ
                bk_lv_bonus =((level - 74) * 0.01)+((level - 89) * 0.01);
            } else if (level >= 75) {
            //LV75�ȏ�LV90����
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

        if (buff.effect.contains("����U��(�p�b�N/�p�I)")) {
            dmg_big_ave += (75 - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * 0.05;
            dmg_small_ave += (75 - Integer.parseInt((String) ui.cb_target_dr.getSelectedItem())) * 0.05;
        }
        int dmg_rate = 0;
        int dmg = 0;
        for (String split : buff.effect.split(",")) {
            if (split.contains("�ǉ��_���[�W")) {
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
        // ��_�I�o
        double week = 0;
        double fsdmg = 0;
        if (cls == R
                && ui.cb_magic.getSelectedItem()
                != null) {
            if (ui.cb_magic.getSelectedItem().equals("�t�H�[�X���C���[")) {
                double week_rate = we;
                double t = 60.0 / (polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), MAIN) * acc) + 2.0;
                t = key_delay * ((int) (t / key_delay) + 1.0);
                if (speed != 0.0) {
                    speed = FSCalclator.calc(t, speed * acc);
                }

                double n = speed * t / 60;

                if (buff.effect.contains("�t�H�[�X���C���[�_���[�W+10")) {
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
            case "��":
                double ATK = 0;
                switch ((String) ui.cb_e_type.getSelectedItem()) {
                    case "�ʏ�":
                        ATK = dmg_small_ave * hit * speed + mag_dmg_min + week;
                        break;
                    case "����":
                        ATK = (dmg_small_ave + dmg_cursed) * hit * speed + mag_dmg_min + week;
                        break;
                    case "�s��":
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

                    ui.lab_time.setText(Integer.toString((MIN)) + "�� " + Integer.toString((S)) + "�b");
                }
                break;
            case "��":
                ATK = 0;
                switch ((String) ui.cb_e_type.getSelectedItem()) {
                    case "�ʏ�":
                        ATK = dmg_big_ave * hit * speed + mag_dmg_min + week;
                        break;
                    case "����":
                        ATK = (dmg_big_ave + dmg_cursed) * hit * speed + mag_dmg_min + week;
                        break;
                    case "�s��":
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

                    ui.lab_time.setText(Integer.toString((MIN)) + "�� " + Integer.toString((S)) + "�b");
                }
                break;
        }

        switch (buki.magic_name) {
            case "":
                ui.lab_mag_info1.setText("���@:�Ȃ�");
                ui.lab_mag_info2.setText("");
                ui.tf_mag_rate.setEnabled(false);
                ui.tf_mag_delay.setEnabled(false);
                ui.tf_mag_power.setEnabled(false);

                ui.tf_mag_rate.setText("0.00");
                ui.tf_mag_delay.setText("0.0");
                ui.tf_mag_power.setText("0.0");
                break;
            case "HP�z��":
                ui.lab_mag_rate.setEnabled(true);
                ui.lab_mag_info1.setText("���@:" + buki.magic_name);
                break;
            default:
                ui.lab_mag_info1.setText("���@:"
                        + buki.magic_name);
                if (rate != 0) {
                    ui.lab_mag_info2.setText(
                            "���@�_���[�W " + format_dmg.format(magic / rate) + "  " + format_rate.format(rate));
                } else {
                    ui.lab_mag_info2.setText("");
                }
                break;
        }
        ui.lab_hit_rate.setText("������:" + format_rate.format(hit_rate));

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
                "��{�_���[�W(��) : " + base_dmg_short);
        ui.lab_dmg_long.setText(
                "��{�_���[�W(��) : " + base_dmg_long);
        ui.lab_dmg_mag.setText(
                "��{�_���[�W(��) : " + base_dmg_magic);

        //��
        ui.lab_hit_short.setText("����(��) : " + hit_short);
        ui.lab_hit_long.setText("����(��) : " + hit_long);

//        ui.lab_hit_short.setText("����(��) : " + hit_short);
//        ui.lab_ac_short.setText("(�ő喽��AC : " + Integer.toString(19 - hit_short) + ")");
//        ui.lab_hit_long.setText("����(��) : " + hit_long);
//        ui.lab_ac_long.setText("(�ő喽��AC : " + Integer.toString(19 - hit_long) + ")");
        ui.lab_hit_mag.setText("����(��) : " + hit_magic);

        ui.lab_cri_short.setText("�N���e�B�J��(��) : " + cri_short);
        ui.lab_cri_long.setText("�N���e�B�J��(��) : " + cri_long);
        ui.lab_cri_mag.setText("�N���e�B�J��(��) : " + cri_magic);
        ui.lab_pvp_dg.setText("PVP�ǉ��_���[�W : " + pvp_dg);
        ui.lab_pvp_dgr.setText("PVP�_���[�W�ቺ : " + pvp_dgr);
        
//        ui.lab_sp.setText("SP " + sp);
//        ui.lab_ml.setText("ML " + ml);
//        ui.lab_mb.setText("MB " + mb);
//        ui.lab_mag_dmg.setText("���@�_���[�W " + base_dmg_magic);
        ui.pure_status_bonus[1][0].setText(Integer.toString(base_dmg_short));   //�ߋ����_���[�W
        ui.pure_status_bonus[1][1].setText(Integer.toString(base_hit_short));   //�ߋ�������
        ui.pure_status_bonus[1][2].setText(Integer.toString(cri_short));        //�ߋ����N���e�B�J��

        ui.pure_status_bonus[1][5].setText(Integer.toString(base_dmg_long));    //�������_���[�W
        ui.pure_status_bonus[1][6].setText(Integer.toString(base_hit_long));    //����������
        ui.pure_status_bonus[1][7].setText(Integer.toString(cri_long));         //�������N���e�B�J��

        ui.pure_status_bonus[1][10].setText(Integer.toString(base_dmg_magic));  //���@�_���[�W
        ui.pure_status_bonus[1][11].setText(Integer.toString(base_hit_magic));  //���@����
        ui.pure_status_bonus[1][12].setText(Integer.toString(cri_magic));       //���@�N���e�B�J��
        ui.pure_status_bonus[1][13].setText(Integer.toString(mb));              //MB
        ui.pure_status_bonus[1][14].setText((Integer.toString(red_mp)));        //MP�����

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

//ER�̌v�Z��
        base_er = (int) (dex / 2) + (int) (level / _C[ER][DEX][cls]);

        ui.pure_status_bonus[1][8].setText(Integer.toString(base_ac));          //AC
        ui.pure_status_bonus[1][9].setText(Integer.toString(base_er));          //ER

        ac = base_ac + buff.AC + equip_ac;
        dg = base_dg + buff.DG;
        er = base_er + buff.ER;
        me = base_me + buff.ME;
//        int dr = buff.DR;
//        int dri= buff.DR_IGNORED;
        //AC-100�ȏォ��AC-10���Ƃ�ER��+1
        if (ac <= -100){
                er += -ac / 10-10;
        }
        dr = buff.DR;
        dri= buff.DR_IGNORED;    
        pvp_dg = buff.PVP;
        pvp_dgr = buff.PVP_DR;
        mhp = buff.MHP;                                                         //�ő�HP+X%(BUFF��)
        mmp = buff.MMP;                                                         //�ő�MP+X%(BUFF��)
        mexp = buff.MEXP;                                                       //�l���o���l+X%(BUFF��)

        //�A�[�}�[�K�[�h
        ui.cb_buff[S_AGD].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "�_���[�W�ቺ+[AC]/[10]"
                                         + "<br>"+ "[�K�����x��:60][��������:�펞][�Ώ�:�p��]"+"</html>");
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
            mhp += bougu1.op.MHP;                                               //�ő�HP+X%(�h�)
            mhp += bougu1.op2.MHP;                                              //�ő�HP+X%(�h�)
            mmp += bougu1.op.MMP;                                               //�ő�MP+X%(�h�)
            mmp += bougu1.op2.MMP;                                              //�ő�MP+X%(�h�)
            mexp += bougu1.op.MEXP;                                             //�l���o���l+X%(�h�)
            mexp += bougu1.op2.MEXP;                                            //�l���o���l+X%(�h�)
        }
//        dg = 0;
        //AC-100�ȏォ��AC-10���Ƃ�DG��+1
        if (ac <= -100){
        dg += -ac / 10-10;
        }
        dr += buki.op.DR + buki.op2.DR;
        dri += buki.op.DR_IGNORED + buki.op2.DR_IGNORED; 
        pvp_dg += buki.op.PVP + buki.op2.PVP;
        pvp_dgr += buki.op.PVP_DR + buki.op2.PVP_DR; 
        mhp += buki.op.MHP + buki.op2.MHP;                                      //�ő�HP+X%(���핪)
        mmp += buki.op.MMP + buki.op2.MMP;                                      //�ő�MP+X%(���핪)
        mexp += buki.op.MEXP + buki.op2.MEXP;                                   //�l���o���l+X%(���핪)

        //�A���L���j�[�h�b�W
        ui.cb_buff[D_UDE].setToolTipText("<html>"+ "[����MP:40][����HP:--]"
                                         + "<br>"+ "�ߋ������[DG]+30 AC-100�ȏゾ�ƃG�t�F�N�g�������ɕω�"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:60][��������:16��][�Ώ�:�p��][�G�}:�_�[�N�X�g�[��(1)]"+"</html>");
        if (ui.cb_buff[D_UDE].isSelected()) {
            dg += 30;
        }

        //�~���[�C���[�W
        ui.cb_buff[I_MIE].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�ߋ������[DG]+30"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "[�K�����x��:15][��������:20��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[I_MIE].isSelected()) {
            dg += 30;
        }
        //�o��[�����h�r�I��]
        ui.cb_buff[R_LINDVIOL].setToolTipText("<html>"+ "[����MP:40][����HP:10]"
                                              + "<br>"+ "�ߋ������[DG]+10"
                                              + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                              + "<br>"+ "[�K�����x��:80][��������:10��][�Ώ�:�p��][�G�}:����̃{�[���s�[�X(1)]"+"</html>");
        if (ui.cb_buff[R_LINDVIOL].isSelected()) {
            dg += 10;
        }

        //�C���t�B�j�e�B:�h�b�W
        ui.cb_buff[F_PIE].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "DG+5"
                                         + "<br>"+ "���x��70���烌�x��2����DG��+1������[�ő�+20]"
                                         + "<br>"+ "[�K�����x��:70][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PIE].isSelected()) {
            if (cls == F) {            	
		if (level >= 89) {
                    dg += 20;                                                   //�ő�DG+20(LV89)
        	} else if (level >= 70) {
                    dg += 5 + ((level - 70) / 2 + 1);                           //��{DG+5 + ((level - 70) / 2 + 1)
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

        ui.pure_status_bonus[1][3].setText(Integer.toString(weight));           //�ő及���d��
        ui.pure_status_bonus[1][23].setText(Integer.toString(weight));          //�ő及���d��

        weight *= 1 + r_eq;

        int c_eq = 0;

        for (Bougu bougu1 : bougu) {
            c_eq += bougu1.op.c_weight;
            c_eq += bougu1.op2.c_weight;
        }

        weight += c_eq;
        //�G�������O�����B�e�B�[
        ui.cb_buff[E_ELY].setToolTipText("<html>"+ "[����MP:30][����HP:--]"
                                         + "<br>"+ "�����d�ʑ���+300"
                                         + "<br>"+ "�f�B�N���[�X�E�F�C�g�̏�ʖ��@"
                                         + "<br>"+ "[�K�����x��:75][��������:30��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[E_ELY].isSelected()) {
            ui.cb_buff[W_DWT].setSelected(false);
            weight += 300;
        }

        //���f���[�X�E�F�C�g
        ui.cb_buff[I_RWT].setToolTipText("<html>"+ "[����MP:50][����HP:--]"
                                         + "<br>"+ "�����d�ʑ���+480"
                                         + "<br>"+ "�f�B�N���[�X�E�F�C�g�̏�ʔłȂ̂ŏd���s�\"
                                         + "<br>"+ "[�K�����x��:60][��������:30��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[I_RWT].isSelected()) {
            ui.cb_buff[W_DWT].setSelected(false);
            weight += 480;
        }

        //�f�B�N���[�X�E�F�C�g      ����MP:10/30mins �����d�ʑ���+180
        ui.cb_buff[W_DWT].setToolTipText("<html>"+ "[����MP:10][����HP:50]"
                                         + "<br>"+ "�����d�ʑ���+180"
                                         + "<br>"+ "[�K�����x��:80][��������:30��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[W_DWT].isSelected()) {
            weight += 180;
            if (ui.cb_buff[W_DWT].getForeground().equals(Color.BLUE)) {
                cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
            }
        }
        //�h���S���̏j��2�Ɖ���2(�d�ʂ݂̂̏���)2�����̔���Ŏ������Ă���
        if (ui.cb_buff[DRAGON_BLESS].isSelected()) {
            switch ((String) ui.cb_buff_group[DRAGON_BLESS].getSelectedItem()) {
                case "�j��":
                    weight += 500;                              //�����d�ʑ���+500
                    break;
                case "����":
                    weight += 100;                              //�����d�ʑ���+100
                    break;
                default:
                    break;
            }
        }
        
        //�����\�ȏd�ʂ̏����5400���疳�����ɕύX
        //if (weight > 5400) {
        //    weight = 5400;
        //}

        ui.tf_weight2.setText(Integer.toString(weight));
        //�d�ʕ\��
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

        //���͉񕜃|�[�V����(���͉񕜃|�[�V����/�Ñ�̖��͉񕜃|�[�V����/�_��̔Z�k�}�i�|�[�V����)
        ui.cb_buff[ITEM_BLUE].setToolTipText("<html>"+ "���͉񕜃|�[�V����"
                                             + "<br>"+ "�Ñ�̖��͉񕜃|�[�V����"
                                             + "<br>"+ "�_��̔Z�k�}�i�|�[�V����"+"</html>");
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
            mpr++;                          //MP��+1
            tmp++;                          //MP�|�[�V�����񕜑���+1
                                            //�ő�MP+50��8448�s�ڈȍ~�ŏ���
        }
        if (pure_wis >= 35) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(2));
                mpr++;
            }
            mpr++;                          //MP��+1
            tmp++;                          //MP�|�[�V�����񕜑���+1
                                            //�ő�MP+100��8448�s�ڈȍ~�ŏ���
        }
        if (pure_wis >= 45) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(5));
                mpr += 3;
            }
            mpr += 3;                       //MP��+3
            tmp += 3;                       //MP�|�[�V�����񕜑���+3
                                            //�ő�MP+150��8448�s�ڈȍ~�ŏ���
        }
        if (pure_wis >= 55) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(15));
                mpr += 5;
            }
            mpr += 5;                       //MP��+5
            tmp += 5;                       //MP�|�[�V�����񕜑���+5
                                            //�ő�MP+200��8448�s�ڈȍ~�ŏ���
        }
        if (pure_wis >= 60) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][17].setText(Integer.toString(20));
                mpr += 5;
            }
            mpr += 5;                       //MP��+5
            tmp += 5;                       //MP�|�[�V�����񕜑���+5
                                            //�ő�MP+200��8448�s�ڈȍ~�ŏ���
        }

        ui.pure_status_bonus[1][16].setText(Integer.toString(tmp));             //MP����

//CON:
        hpr += (con / 2 + level / 20);
        hp_pot = (int) (minasToZero(con - 10) / 10);

        if (pure_con >= 25) {
            hpr++;                          //HP��+1
                                            //�ő�HP+50��8438�s�ڈȍ~�ŏ���
        }
        if (pure_con >= 35) {
            hpr++;                          //HP��+1
            hp_pot++;                       //HP�|�[�V�����񕜑���+1%
                                            //�ő�HP+100��8438�s�ڈȍ~�ŏ���
        }
        if (pure_con >= 45) {
            hpr += 3;                       //HP��+3
            hp_pot += 2;                    //HP�|�[�V�����񕜑���+2%
                                            //�ő�HP+150��8438�s�ڈȍ~�ŏ���
        }
        if (pure_con >= 55) {
            hpr += 5;                       //HP��+5
            hp_pot += 4;                    //HP�|�[�V�����񕜑���+4%
                                            //�ő�HP+200��8438�s�ڈȍ~�ŏ���
        }
        if (pure_con >= 60) {
            hpr += 5;                       //HP��+5
            hp_pot += 4;                    //HP�|�[�V�����񕜑���+4%
                                            //�ő�HP+200��8438�s�ڈȍ~�ŏ���
        }

        ui.pure_status_bonus[1][21].setText(Integer.toString(hpr));             //HP����
        ui.pure_status_bonus[1][22].setText(Integer.toString(hp_pot));          //HP�|�[�V����

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
            if (split.contains("HP��")) {
                hpr2 += Integer.parseInt(split.split(" ")[1]);
            }
            if (split.contains("MP��")) {
                mpr2 += Integer.parseInt(split.split(" ")[1]);
            }
        }

        if (hpr2 > 0) {
            ui.lab_hpr.setText(hpr + "  (64�b�� " + hpr2 + ")");
        } else {
            ui.lab_hpr.setText(Integer.toString(hpr));
        }
        if (mpr2 > 0) {
            ui.lab_mpr.setText(mpr + "  (64�b�� " + mpr2 + ")");
        } else {
            ui.lab_mpr.setText(Integer.toString(mpr));
        }

        int pot_rate = hp_pot;
        int pot = 0;
        for (String split : buff.effect.split(",")) {
            if (split.contains("�|�[�V�����񕜗�")) {
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

//�푰���������ꍇ�z���1���₷�K�v���� c1��c2�̒l���s���@mp�̗ʂ����肷��ׂ̒l�Ǝv����
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

            ui.pure_status_bonus[1][20].setText(min + " - " + max);             //HP����
        } else {
            int min = 1 + (int) ((con + 1) / 2) + _C[HP][CON][cls];
            int max = 2 + (int) ((con + 1) / 2) + _C[HP][CON][cls];

            ui.pure_status_bonus[1][20].setText(min + " - " + max);             //HP����
        }

        {
            int min = (int) ((int) (wis / 5) * c1[cls]) + c2[cls];
            int max = (int) ((int) (wis / 3) * c1[cls]) + c2[cls];

            ui.pure_status_bonus[1][15].setText(min + " - " + max);             //MP����
        }

//CON�X�e�[�^�X�ɂ��HP��������
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

//WIS�X�e�[�^�X�ɂ��MP��������
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

        //�y���_���g���̑����ɂ��ő�HP+X%/�ő�MP+X%�̏���
        hpp += mhp *0.01 * hp;
        mpp += mmp *0.01 * mp;

        //�A�h�o���X�h�X�s���b�c ����MP20/20mins
        ui.cb_buff[W_ADS].setToolTipText("<html>"+ "[����MP:20][����HP:--]"
                                         + "<br>"+ "�ő�HP/MP+20%"
                                         + "<br>"+ "�L�����Z���[�V�����ŉ�������Ȃ�"
                                         + "<br>"+ "���X�^�[�g����ƌ��ʂ�������"
                                         + "<br>"+ "[�K�����x��:80][��������:20��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[W_ADS].isSelected()) {
            if (ui.cb_buff[S_GIC].isSelected()
                    || ui.cb_buff[K_PRE].isSelected()) {
                ui.cb_buff[W_ADS].setSelected(false);
            } else {
            hpp += 0.2 * hp;
            mpp += 0.2 * mp;
            }
        }

        //�v���C�h
        ui.cb_buff[K_PRE].setToolTipText("<html>"+ "[����MP:10][����HP:100]"
                                         + "<br>"+ "�ő�HP LV/4% ����"
                                         + "<br>"+ "[�K�����x��:60][��������:5��][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[K_PRE].isSelected()) {
            if (ui.cb_buff[S_GIC].isSelected()
                    || ui.cb_buff[W_ADS].isSelected()) {
                ui.cb_buff[K_PRE].setSelected(false);
            } else {
           hpp += (level/4)*0.01 * hp;
            }
        }

        //�M�K���e�B�b�N
        ui.cb_buff[S_GIC].setToolTipText("<html>"+ "[����MP:10][����HP:--]"
                                         + "<br>"+ "�ő�HP�𑝉�����"
                                         + "<br>"+ "[���x��]/[2]%"
                                         + "<br>"+ "[�K�����x��:60][��������:10��][�Ώ�:�p��][�G�}:������(100)]"+"</html>");
        if (ui.cb_buff[S_GIC].isSelected()) {
            if (ui.cb_buff[W_ADS].isSelected()
                    || ui.cb_buff[K_PRE].isSelected()) {
                ui.cb_buff[S_GIC].setSelected(false);
            } else {
            hpp += (level/2)*0.01 * hp;
            }
        }

        //�C���t�B�j�e�B:�u���b�h
        ui.cb_buff[F_PID].setToolTipText("<html>"+ "[����MP:--][����HP:--]"
                                         + "<br>"+ "Passive"
                                         + "<br>"+ "���x��60���烌�x��3���ɍő�HP��+50������[�ő�+650]"
                                         + "<br>"+ "[�K�����x��:60][��������:�펞][�Ώ�:�p��]"+"</html>");
        if (ui.cb_buff[F_PID].isSelected()) {
            if (cls == F) {            	
                if (level >= 89) {
                hpp += 650;                                                 //�ő�HP+15(LV89)
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

        //�l���o���l
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
        if (magic_name.equals("�}�C���h�u���C�N")) {
            return (sp + ml + mb) * 3.8;
        }
        if (magic_name.equals("HP�z��")) {
            // �ʓr�v�Z
            return 0;
        }
        if (magic_name.equals("���[�����C�g�C���v�V����")) {
            return 7;
        }
        if (magic_name.equals("�T���o�[�X�g") || magic_name.equals("�R�[�����C�g�j���O")
                || magic_name.equals("�C���v�V����")
                || magic_name.equals("�R�[���I�u�R�[���h")
                || magic_name.equals("�`���^�b�`")
                || magic_name.equals("���@���p�C�A���b�N�^�b�`")
                || magic_name.equals("�t�@�C�A�[�A���[") || magic_name.equals("�A�C�X�_�K�[")
                || magic_name.equals("�E�C���h�J�b�^�[") || magic_name.equals("�X���^�b�N")
                || magic_name.equals("�G�l���M�[�{���g")) {
            cri = (double) cri_magic / 100;
        } else {
            cri = 0;
        }

        double r_element = 0;
        if (magic_element.equals("��")) {
            r_element = ui.s_target_res[FIRE].getValue();
        }
        if (magic_element.equals("��")) {
            r_element = ui.s_target_res[WATER].getValue();
        }
        if (magic_element.equals("��")) {
            r_element = ui.s_target_res[WIND].getValue();
        }
        if (magic_element.equals("�n")) {
            r_element = ui.s_target_res[EARTH].getValue();
        }

        double a = 1 + 3.0 / 32.0 * (int_beta - 12) - r_element / 100.0;
        double b;
        if (magic_name.equals("�G���u���A���[")) {
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
            buki_text += "�_���[�W" + buki.small + "/" + buki.big;
        }
        if ((buki.enchant + buki.op2.DMG_SHORT + buki.op2.DMG_LONG) > 0) {
            if (buki.op2.DMG_LONG > buki.op2.DMG_SHORT) {  
                buki_text += "�_���[�W" + buki.small + "+" + (buki.enchant + buki.op2.DMG_LONG) + "/" + buki.big + "+" + (buki.enchant + buki.op2.DMG_LONG);      
            } else {
                buki_text += "�_���[�W" + buki.small + "+" + (buki.enchant + buki.op2.DMG_SHORT) + "/" + buki.big + "+" + (buki.enchant + buki.op2.DMG_SHORT);
        }
        }
        if (buki.two_hands) {
            buki_text += " ���蕐��";
        }
        if (buki.op.DMG_SHORT > 0) {
            buki_text += " �ߋ����_���[�W+" + buki.op.DMG_SHORT;
        }
        if (buki.op.DMG_LONG < 0) {
            buki_text += " �ߋ����_���[�W" + buki.op.DMG_LONG;
        }
        if (buki.op.HIT_SHORT > 0) {
            buki_text += " �ߋ�������+" + (buki.op.HIT_SHORT + buki.op2.HIT_SHORT);
        }
        if (buki.op.HIT_SHORT < 0) {
            buki_text += " �ߋ�������" + (buki.op.HIT_SHORT + buki.op2.HIT_SHORT);
        }
        if (buki.op.DMG_LONG > 0) {
            buki_text += " �������_���[�W+" + buki.op.DMG_LONG;
        }
        if (buki.op.DMG_LONG < 0) {
            buki_text += " �������_���[�W" + buki.op.DMG_LONG;
        }
        if (buki.op.HIT_LONG > 0) {
            buki_text += " ����������+" + (buki.op.HIT_LONG + buki.op2.HIT_LONG);
        }
        if (buki.op.HIT_LONG < 0) {
            buki_text += " ����������" + (buki.op.HIT_LONG + buki.op2.HIT_LONG);
        }
        if (buki.op.HIT_MAGIC > 0) {
            buki_text += " ���@����+" + (buki.op.HIT_MAGIC + buki.op2.HIT_MAGIC);
        }
        if (buki.op.HIT_MAGIC < 0) {
            buki_text += " ���@����" + (buki.op.HIT_MAGIC + buki.op2.HIT_MAGIC);
        }
        if (buki.op.CRI_SHORT + buki.op2.CRI_SHORT > 0) {
            buki_text += " �ߋ����N���e�B�J��+" + (buki.op.CRI_SHORT + buki.op2.CRI_SHORT);
        }
        if (buki.op.CRI_LONG + buki.op2.CRI_LONG > 0) {
            buki_text += " �������N���e�B�J��+" + (buki.op.CRI_LONG + buki.op2.CRI_LONG);
        }
        if (buki.op.CRI_MAGIC + buki.op2.CRI_MAGIC > 0) {
            buki_text += " ���@�N���e�B�J��+" + (buki.op.CRI_MAGIC + buki.op2.CRI_MAGIC);
        }
        if (buki.op.ailment[HIT_STUN] + buki.op2.ailment[HIT_STUN] > 0) {
            buki_text += " �Z�p����+" + (buki.op.ailment[HIT_STUN] + buki.op2.ailment[HIT_STUN]);
        }
        if (buki.op.ailment[HIT_SPIRIT] + buki.op2.ailment[HIT_SPIRIT] > 0) {
            buki_text += " ���얽��+" + (buki.op.ailment[HIT_SPIRIT] + buki.op2.ailment[HIT_SPIRIT]);
        }
        if (buki.op.ailment[HIT_SECRET] + buki.op2.ailment[HIT_SECRET] > 0) {
            buki_text += " ��Z����+" + (buki.op.ailment[HIT_SECRET] + buki.op2.ailment[HIT_SECRET]);
        }
        if (buki.op.ailment[HIT_TERROR] + buki.op2.ailment[HIT_TERROR] > 0) {
            buki_text += " ���|����+" + (buki.op.ailment[HIT_TERROR] + buki.op2.ailment[HIT_TERROR]);
        }
        if (buki.op.HP > 0) {
            buki_text += " HP+" + buki.op.HP;
        }
        if (buki.op.HPR > 0) {
            buki_text += " HP���R��+" + buki.op.HPR;
        }
        if (buki.op.MP > 0) {
            buki_text += " MP+" + buki.op.MP;
        }
        if (buki.op.MPR > 0) {
            buki_text += " MP���R��+" + buki.op.MPR;
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
            buki_text += " �ގ�:" + buki.material;
        }
        if (buki.op.PVP > 0) {
            buki_text += " PVP�ǉ��_���[�W " + (buki.op.PVP + buki.op2.PVP);
        }
        if (buki.op.PVP_DR > 0) {
            buki_text += " PVP�_���[�W�ቺ " + (buki.op.PVP_DR + buki.op2.PVP_DR);
        }
        if (buki.op.DR > 0) {
            buki_text += " �_���[�W�ቺ " + (buki.op.DR + buki.op2.DR);
        }
        if (buki.op.DR_IGNORED > 0) {
            buki_text += " �_���[�W�ቺ���� " + (buki.op.DR_IGNORED + buki.op2.DR_IGNORED);
        }
        if (buki.op.WEIGHT > 0) {
            buki_text += " �d�� " + buki.op.WEIGHT;
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
