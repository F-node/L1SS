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
    private final int ER = 4;

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
    private int base_er;
//    private int base_pvp_dr;

    Buff buff;
    boolean md_dmg = false;
    int equip_pattern = 0;
    int ac;
    int dg;
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

        st_data[F][BASE][STR] = 16;
        st_data[F][BASE][DEX] = 13;
        st_data[F][BASE][CON] = 16;
        st_data[F][BASE][INT] = 10;
        st_data[F][BASE][WIS] = 7;
        st_data[F][BASE][CHA] = 9;
        st_data[F][REM][STR] = 4;
        st_data[F][REM][DEX] = 4;
        st_data[F][REM][CON] = 4;
        st_data[F][REM][INT] = 4;
        st_data[F][REM][WIS] = 4;
        st_data[F][REM][CHA] = 4;
        rem_data[F] = 4;

        //�X�e�[�^�X�{�[�i�X
        _C[D_SHORT][STR][P] = 30;
        _C[D_SHORT][STR][K] = 10;
        _C[D_SHORT][STR][E] = 30;
        _C[D_SHORT][STR][W] = 40;
        _C[D_SHORT][STR][D] = 10;
        _C[D_SHORT][STR][R] = 10;
        _C[D_SHORT][STR][I] = 10;
        _C[D_SHORT][STR][F] = 10;

        _C[H_SHORT][STR][P] = 4;
        _C[H_SHORT][STR][K] = 3;
        _C[H_SHORT][STR][E] = 5;
        _C[H_SHORT][STR][W] = 6;
        _C[H_SHORT][STR][D] = 3;
        _C[H_SHORT][STR][R] = 4;
        _C[H_SHORT][STR][I] = 5;
        _C[H_SHORT][STR][F] = 3;

        _C[C_SHORT][STR][P] = 20;
        _C[C_SHORT][STR][K] = 20;
        _C[C_SHORT][STR][E] = 24;
        _C[C_SHORT][STR][W] = 30;
        _C[C_SHORT][STR][D] = 10;
        _C[C_SHORT][STR][R] = 20;
        _C[C_SHORT][STR][I] = 30;
        _C[C_SHORT][STR][F] = 20;

        _C[D_LONG][DEX][P] = 40;
        _C[D_LONG][DEX][K] = 40;
        _C[D_LONG][DEX][E] = 10;
        _C[D_LONG][DEX][W] = 80;
        _C[D_LONG][DEX][D] = 20;
        _C[D_LONG][DEX][R] = 40;
        _C[D_LONG][DEX][I] = 80;
        _C[D_LONG][DEX][F] = 40;

        _C[H_LONG][DEX][P] = 6;
        _C[H_LONG][DEX][K] = 6;
        _C[H_LONG][DEX][E] = 3;
        _C[H_LONG][DEX][W] = 8;
        _C[H_LONG][DEX][D] = 4;
        _C[H_LONG][DEX][R] = 7;
        _C[H_LONG][DEX][I] = 8;
        _C[H_LONG][DEX][F] = 6;

        _C[C_LONG][DEX][P] = 30;
        _C[C_LONG][DEX][K] = 40;
        _C[C_LONG][DEX][E] = 16;
        _C[C_LONG][DEX][W] = 50;
        _C[C_LONG][DEX][D] = 20;
        _C[C_LONG][DEX][R] = 40;
        _C[C_LONG][DEX][I] = 50;
        _C[C_LONG][DEX][F] = 40;

        _C[ER][DEX][P] = 6;
        _C[ER][DEX][K] = 4;
        _C[ER][DEX][E] = 6;
        _C[ER][DEX][W] = 10;
        _C[ER][DEX][D] = 4;
        _C[ER][DEX][R] = 5;
        _C[ER][DEX][I] = 9;
        _C[ER][DEX][F] = 4;

        _C[D_MAGIC][INT][P] = 40;
        _C[D_MAGIC][INT][K] = 40;
        _C[D_MAGIC][INT][E] = 30;
        _C[D_MAGIC][INT][W] = 10;
        _C[D_MAGIC][INT][D] = 40;
        _C[D_MAGIC][INT][R] = 40;
        _C[D_MAGIC][INT][I] = 25;
        _C[D_MAGIC][INT][F] = 40;

        _C[H_MAGIC][INT][P] = 20;
        _C[H_MAGIC][INT][K] = 100;
        _C[H_MAGIC][INT][E] = 16;
        _C[H_MAGIC][INT][W] = 8;
        _C[H_MAGIC][INT][D] = 24;
        _C[H_MAGIC][INT][R] = 18;
        _C[H_MAGIC][INT][I] = 12;
        _C[H_MAGIC][INT][F] = 100;

        _C[C_MAGIC][INT][P] = 80;
        _C[C_MAGIC][INT][K] = 100;
        _C[C_MAGIC][INT][E] = 30;
        _C[C_MAGIC][INT][W] = 2;
        _C[C_MAGIC][INT][D] = 30;
        _C[C_MAGIC][INT][R] = 70;
        _C[C_MAGIC][INT][I] = 20;
        _C[C_MAGIC][INT][F] = 100;

        _C[MB][INT][P] = 0;
        _C[MB][INT][K] = 0;
        _C[MB][INT][E] = 0;
        _C[MB][INT][W] = 1;
        _C[MB][INT][D] = 0;
        _C[MB][INT][R] = 0;
        _C[MB][INT][I] = 1;
        _C[MB][INT][F] = 0;

        _C[HP][CON][P] = 11;
        _C[HP][CON][K] = 16;
        _C[HP][CON][E] = 9;
        _C[HP][CON][W] = 6;
        _C[HP][CON][D] = 10;
        _C[HP][CON][R] = 12;
        _C[HP][CON][I] = 8;
        _C[HP][CON][F] = 16;

        _C[MR][WIS][P] = 10;
        _C[MR][WIS][K] = 0;
        _C[MR][WIS][E] = 25;
        _C[MR][WIS][W] = 15;
        _C[MR][WIS][D] = 10;
        _C[MR][WIS][R] = 18;
        _C[MR][WIS][I] = 20;
        _C[MR][WIS][F] = 0;
    }

    private final UI ui;
    Morph polymorph = new Morph();
    private double acc = 1.0;
    // ��i����(GP GGP ���C�� �E�C�X�L�[)
    double acc_1 = 1.3333;
    // ��i����(BP �C�r���u���b�h �u���b�h���X�g ���_�̃R�C�� �_���V���O�u���C�Y �t�H�[�J�X�E�F�[�u �n���P�[�� �T���h�X�g�[�� �_�[�N�z�[�X)
    double acc_2 = 1.3333;
    // ��i����(EW �Z�k�W���|�[�V����)
    double acc_ew = 1.1547;
    // �O�i����(�h���S���u���b�h ���o���鑠��)
    double acc_3 = 1.125;
    // �L�[���̓f�B���C
    double key_delay = 0.1815;

    double ce_rate = 0.0500;    //�T�C�N�����̊m��5%
    double bk_rate = 0.0500;    //�u���[�A�^�b�N�̊m��5%
    double bs_rate = 0.3333;    //�o�[�j���O�X�s�b�c�̊m��33%
    double db_rate = 0.3333;    //�_�u���u���C�N�̊m��33%
    double ef_rate = 0.4000;    //�G�������^���t�@�C�A�[�̊m��40%
    double qe_rate = 0.4000;    //�N�G�C�N�̊m��40%
    double pb_rate = 0.4000;    //�u���C�u�����^���̊m��40% 

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
                ///LV90�ȏ�̍ő�X�e�[�^�X50/LV90�����̍ő�X�e�[�^�X45�̏���
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
            buff.ER += b.op.ER + b.op2.ER;
        }

        if (bougu[0].name.equals("�G�������V�[���h")) {
            if (cls == E) {
                buff.MR += 5;
            }
        }

        // �Z�b�g����
        int set1 = 0, set2 = 0, set3 = 0;// ���ƃZ�b�g
        int set4 = 0, set5 = 0, set6 = 0;// �򉻃Z�b�g
        int set7 = 0, set8 = 0;// �Ɋ��A�A�C�X�N�C�[���Z�b�g
        int set9 = 0;// �C���҃Z�b�g
        int set10 = 0, set11 = 0, set12 = 0;//�ނ�Z�b�g
        int set13 = 0;//�R���Z�b�g
        int set14 = 0;//DK�Z�b�g
        int set15 = 0;//�Z�}�I�����Z�b�g �Z�}�̃����O+�I�����̃A�~�����b�g

        for (Bougu bougu1 : bougu) {
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
            //  ���L���\�b�h���s�̂��тɒǉ��{�[�i�X���ݐς����͗l�i�{��+2�Œǉ��{�[�i�X��3�{�ɂȂ�j
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
        //�E�B�Y�_���|�[�V����
        if (ui.cb_buff[ITEM_WIZP].isSelected()) {
            if (cls == W || cls == I) {
                buff.SP += 2;
                buff.MPR += 2;
                ui.cb_buff[ITEM_WIZP].setToolTipText("SP+2 MPR+2");
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
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�o���l����+10% �_���[�W�ቺ+1");
                    break;
                case 23:                            //�j�����ꂽ�A�[�X�W���C�A���g
                    buff.AC -= 2;
                    buff.DR += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("AC-2 �o���l����+10% �_���[�W�ቺ+1");
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
        //�ۋ�MD
                case 62:                            //�V�[�_���T�[
                    buff.effect += "HP�� +40,";
                    ui.cb_buff[ITEM_MD].setToolTipText("HP��Ή�+40(32�b)");
                    break;
                case 63:                            //�X�p���g�C
                    ui.cb_buff[ITEM_MD].setToolTipText("���m��(4%)�Ń_���[�W�𖳌���");
                    buff.effect += "���,";
                    break;
                case 64:                            //���~�A
                    buff.MPR += 4;
                    ui.cb_buff[ITEM_MD].setToolTipText("MP���R��+4 �ߋ����U���̎��������@����:�J�[�Y�|�C�Y��");
                    break;
                case 65:                            //�X�m�[�}��(�ۋ�)
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.MPR += 2;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+2 �������_���[�W+2 MP���R��+2");
                    break;
                case 66:                            //�O��������
                    buff.HP += 30;
                    buff.DMG_SHORT += 2;
                    buff.DMG_LONG += 2;
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("HP+30 �ߋ����_���[�W+2 �������_���[�W+2 SP+1");
                    break;
                case 67:                            //�u���[�g
                    buff.r_weight += 0.10;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+250");
                    break;
                case 68:                            //�u���[�g(�w�͂���)
                    buff.r_weight += 0.12;
                    buff.effect += "HP�� +15,";
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+300 HP��Ή�+15(64�b)");
                    break;
                case 69:                            //�u���[�g(����)
                    buff.r_weight += 0.14;
                    buff.effect += "HP�� +15,";
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+350 HP��Ή�+15(64�b)");
                    break;
                case 70:                            //�u���[�g(������)
                    buff.r_weight += 0.16;
                    buff.effect += "HP�� +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+400 HP��Ή�+15(64�b) �ߋ����_���[�W+1");
                    break;
                case 71:                            //�u���[�g(����)
                    buff.r_weight += 0.18;
                    buff.effect += "HP�� +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+450 HP��Ή�+15(64�b) �ߋ����_���[�W+1");
                    break;
                case 72:                            //�u���[�g(ῂ���)
                    buff.r_weight += 0.20;
                    buff.effect += "HP�� +15,";
                    buff.DMG_SHORT++;
                    ui.cb_buff[ACC1].setSelected(true);
                    ui.cb_buff[ITEM_MD].setToolTipText("�펞�w�C�X�g �����d�ʑ���+500 HP��Ή�+15(64�b) �ߋ����_���[�W+1");
                    break;
                case 73:                            //�W���C�A���g
                    buff.r_weight += 0.10;
                    buff.effect += "�_���[�W�ቺ +5,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+5 �����d�ʑ���+250");
                    break;
                case 74:                            //�W���C�A���g(�w�͂���)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.effect += "�_���[�W�ቺ +8,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+8 �����d�ʑ���+250 AC-1");
                    break;
                case 75:                            //�W���C�A���g(����)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.effect += "�_���[�W�ቺ +11,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+11 �����d�ʑ���+250 AC-1");
                    break;
                case 76:                            //�W���C�A���g(������)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "�_���[�W�ቺ +14,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+14 �����d�ʑ���+250 AC-1 MR+5%");
                    break;
                case 77:                            //�W���C�A���g(����)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "�_���[�W�ቺ +17,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+17 �����d�ʑ���+250 AC-1 MR+5%");
                    break;
                case 78:                            //�W���C�A���g(ῂ���)
                    buff.r_weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "�_���[�W�ቺ +20,���@���p�C�A���b�N�^�b�`,";
                    ui.cb_buff[ITEM_MD].setToolTipText("�m���_���[�W�ቺ+20 �����d�ʑ���+250 AC-1 MR+5% �ߋ����U�����Ɉ��m���Ŗ��@����:�o���p�C�A���b�N�^�b�`");
                    break;
                case 79:                            //�p�b�N/�p�I(0�i�K)
                    buff.DMG_SHORT += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+1");
                case 80:                            //�p�b�N/�p�I(1�i�K)
                    buff.DMG_SHORT += 1;
                    buff.DMG_LONG += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+1 �������_���[�W+1");
                    break;
                case 81:                            //�p�b�N/�p�I(2�i�K)
                    buff.DMG_SHORT += 1;
                    buff.DMG_LONG += 1;
                    buff.SP += 1;
                    ui.cb_buff[ITEM_MD].setToolTipText("�ߋ����_���[�W+1 �������_���[�W+1 SP+1");
                    break;
                case 82:                            //�p�b�N/�p�I(3�i�K)
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
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
                    ui.cb_buff[ITEM_COOKING].setToolTipText("<html>"+"��������R+10 �n������R+10 ��������R+10 �Α�����R+10"
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
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+2 �S�N���X�X�L���ϐ�+2 PvPDR+2 �l���o���l+4% 30��");
                    break;
                case 2:                                 //���z�̃o�V���X�N�̗��X�[�v
                    buff.DR += 5;
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+5 �l���o���l+3% 15��20�b");
                    break;
                case 3:                                 //���z�̃V���[�g�P�[�L
                    buff.DR += 3;
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+3 �l���o���l+5% 15��20�b");
                    break;
                case 4:                                 //�����Ȍg�ш���
                    buff.DR += 5;
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+5 �l���o���l+5% 15��20�b");
                    break;
                case 5:                                 //�^�S�����������X�[�v
                    buff.DR += 5;
                    ui.cb_buff[ITEM_DESSERT].setToolTipText("�_���[�W�ቺ+5 �l���o���l+5% 15��20�b");
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
        //���_�N�V�����A�[�}�[ ����MP7/5mins 
        if (ui.cb_buff[K_RA].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.DR += (level - 50) / 5 + 1;
                if (ui.cb_buff[K_RA].getForeground().equals(Color.BLUE)) {
                    cons_mp += (7.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }

            } else {
                ui.cb_buff[K_RA].setSelected(false);
            }
        }
        //�\���b�h�L�����b�W ����MP10/3mins
        if (ui.cb_buff[K_SC].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.ER += 15;
                if (ui.cb_buff[K_SC].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 3;
                }
            } else {
                ui.cb_buff[K_SC].setSelected(false);
            }
        }
        //�J�E���^�[�o���A ����MP15/2mins
        if (ui.cb_buff[K_CB].isSelected()) {
            if (level >= 80 && cls == K
                    && buki.type.equals("���茕")) {
                if (ui.cb_buff[K_CB].getForeground().equals(Color.BLUE)) {
                    cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
                }
                // CB���ʖ�����
            } else {
                ui.cb_buff[K_CB].setSelected(false);
                ui.cb_buff[K_CB2].setSelected(false);
            }
        }
        //�J�E���^�[�o���A:�x�e����
        if (ui.cb_buff[K_CB2].isSelected()) {
            if (level >= 85 && cls == K
                    && buki.type.equals("���茕")) {
                if (ui.cb_buff[K_CB2].getForeground().equals(Color.BLUE)) {
                }
                // CB���ʖ�����
                ui.cb_buff[K_CB].setSelected(true);
            } else {
                ui.cb_buff[K_CB].setSelected(false);
                ui.cb_buff[K_CB2].setSelected(false);
            }
        }
        //�o�E���X�A�^�b�N ����MP10/1mins
        if (ui.cb_buff[K_BA].isSelected()) {
            if (level >= 60 && cls == K) {
                buff.HIT_SHORT += 6;
                if (ui.cb_buff[K_BA].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 1;
                }
            } else {
                ui.cb_buff[K_BA].setSelected(false);
            }
        }
        //���W�X�g�}�W�b�N ����MP5/20mins
        if (ui.cb_buff[E_RM].isSelected()) {
            if (cls == E) {
                buff.MR += 10;
                if (ui.cb_buff[E_RM].getForeground().equals(Color.BLUE)) {
                    cons_mp += (5.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                }
            } else {
                ui.cb_buff[E_RM].setSelected(false);
            }
        }
        //���W�X�g�G�������g �펞
        if (ui.cb_buff[E_RE].isSelected()) {
            if (cls == E) {
                buff.MR += 5;
                buff.element_resist[FIRE] += 5;
                buff.element_resist[WATER] += 5;
                buff.element_resist[WIND] += 5;
                buff.element_resist[EARTH] += 5;
            } else {
                ui.cb_buff[E_RE].setSelected(false);
            }
        }
        //�N���A�[�}�C���h ����MP10/20mins
        if (ui.cb_buff[E_CM].isSelected()) {
            if (cls == E) {
                buff.ST[STR] += 1;
                buff.ST[DEX] += 1;
                buff.ST[INT] += 1;
                if (ui.cb_buff[E_CM].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                }
            } else {
                ui.cb_buff[E_CM].setSelected(false);
            }
        }
        //�o�[�j���O�E�G�|�� ����MP30/16mins
        if (ui.cb_buff[E_BW].isSelected()) {
            if (cls == E) {
                buff.ELEM_DMG_SHORT[FIRE] += 6;
                buff.HIT_SHORT += 6;
                if (ui.cb_buff[E_BW].getForeground().equals(Color.BLUE)) {
                    cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            } else {
                ui.cb_buff[E_BW].setSelected(false);
            }
        }
        //�C���t�F���m ����MP50 HP70/2mins
        if (ui.cb_buff[E_IO].isSelected()) {
            if (level >= 80 && cls == E
                    && buki.type.equals("�Ў茕")) {
                if (ui.cb_buff[E_IO].getForeground().equals(Color.BLUE)) {
                    cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
                }
                // �C���t�F���m���ʖ�����
            } else {
                ui.cb_buff[E_IO].setSelected(false);
            }
        }
        //�A�[�X�E�F�|�� ����MP15/16mins
        if (ui.cb_buff[E_EW].isSelected()) {
            if (cls == E) {
                buff.ELEM_DMG_SHORT[EARTH] += 2;
                buff.HIT_SHORT += 4;
                if (ui.cb_buff[E_EW].getForeground().equals(Color.BLUE)) {
                    cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            } else {
                ui.cb_buff[E_EW].setSelected(false);
            }
        }
        //�A�N�A�V���b�g ����MP15/16mins
        if (ui.cb_buff[E_AS].isSelected()) {
            if (cls == E) {
                buff.HIT_LONG += 4;
                if (ui.cb_buff[E_AS].getForeground().equals(Color.BLUE)) {
                    cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            } else {
                ui.cb_buff[E_AS].setSelected(false);
            }
        }  
        //�l�C�`���[�Y�^�b�` ����MP20/5mins
        if (ui.cb_buff[E_NT].isSelected()) {
            if (level > 9) {
                if (level < 24) {
                    buff.HPR += level - 9;
                } else {
                    buff.HPR += 15;
                }
            }
            if (ui.cb_buff[E_NT].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //�h���X�C�x�C�W���� ����MP15/3mins
        if (ui.cb_buff[D_DE].isSelected()) {
            if (cls == D) {
                buff.ER += 18;

                if (ui.cb_buff[D_DE].getForeground().equals(Color.BLUE)) {
                    cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 3;
                }
            } else {
                ui.cb_buff[D_DE].setSelected(false);
            }
        }
        //�V���h�E�A�[�}�[ ����MP12/16mins
        if (ui.cb_buff[D_SA].isSelected()) {
            if (cls == D) {
                buff.MR += 5;
                if (ui.cb_buff[D_SA].getForeground().equals(Color.BLUE)) {
                    cons_mp += (12.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            } else {
                ui.cb_buff[D_SA].setSelected(false);
            }
        }
        //�t�@�C�i���o�[�� ����MP20 HP50/5mins
        if (ui.cb_buff[D_FB].isSelected()) {
            //HP��70%�ȉ��̎��A�ߋ����N���e�B�J��+5%(���x��80����2���x�����オ�閈��+1%)
            if (level <= 80) {
            buff.CRI_SHORT += 5;
            } else if (level > 80) {
            buff.CRI_SHORT += 5+(level/2-40);
            }
        }
        //�A�N�A�v���e�N�g ����MP30/16mins
        if (ui.cb_buff[E_AP].isSelected()) {
            if (ui.cb_buff[D_DE].isSelected()) {
                ui.cb_buff[E_AP].setSelected(false);
            } else {
                buff.ER += 5;
                if (ui.cb_buff[E_AP].getForeground().equals(Color.BLUE)) {
                    cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            }
        }
        //�X�g�[���V���b�g ����MP30/16mins
        if (ui.cb_buff[E_SS].isSelected()) {
            buff.ELEM_DMG_LONG[WIND] += 6;
            buff.HIT_LONG += 3;
            if (ui.cb_buff[E_SS].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
            }
        }
        //�X�g�[���A�C ����MP40/16mins
        if (ui.cb_buff[E_SE].isSelected()) {
            if (ui.cb_buff[E_SS].isSelected()) {
                ui.cb_buff[E_SE].setSelected(false);
            } else {
                buff.ELEM_DMG_LONG[WIND] += 3;
                buff.HIT_LONG += 2;
                if (ui.cb_buff[E_SE].getForeground().equals(Color.BLUE)) {
                    cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            }
        }
        //�A�[�X�K�[�f�B�A�� ����MP30/10mins
        if (ui.cb_buff[E_EG].isSelected()) {
            buff.DR += 2;
            if (ui.cb_buff[E_EG].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //�o�[�T�[�J�[ ����MP40/5mins
        if (ui.cb_buff[W_BSK].isSelected()) {
            buff.DMG_SHORT += 2;
            buff.HIT_SHORT += 8;
            buff.HPR -= 255;
            buff.AC += 10;
            if (ui.cb_buff[W_BSK].getForeground().equals(Color.BLUE)) {
                cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //�u���X�h�A�[�}�[ ����MP20/30mins
        if (ui.cb_buff[W_BA].isSelected()) {
            buff.AC -= 3;
            if (ui.cb_buff[W_BA].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
            }
        }
        //�G���`�����g�A�L�����V�[ ����MP10/5mins
        if (ui.cb_buff[W_EA].isSelected()) {
            buff.HIT_SHORT += 5;
            if (ui.cb_buff[W_EA].getForeground().equals(Color.BLUE)) {
                cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //�t���[�W���O�A�[�}�[ ����MP20/5mins
        if (ui.cb_buff[W_FA].isSelected()) {
            buff.ER += 5;
            if (ui.cb_buff[W_FA].getForeground().equals(Color.BLUE)) {
                cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //�h���S���X�L�� ����MP0/30mins
        if (ui.cb_buff[R_DS].isSelected()) {
            buff.DR += 5;
            if (level >= 80) {
                buff.DR += (int) ((level - 80) / 2) + 1;
            }
        }
        //�o��[�A���^���X] ����MP20/10mins
        if (ui.cb_buff[R_ANTHARAS].isSelected()) {
            buff.AC -= 3;
            if (ui.cb_buff[R_ANTHARAS].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //�o��[�p�v���I��] ����MP30/10mins
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
        //�o��[���@���J�X] ����MP50/10mins
        if (ui.cb_buff[R_VALAKAS].isSelected()) {
            buff.HIT_SHORT += 5;
            buff.ailment[STUN] += 10;
            if (ui.cb_buff[R_VALAKAS].getForeground().equals(Color.BLUE)) {
                cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //�R���Z���g���[�V���� ����MP30/10mins
        if (ui.cb_buff[I_CON].isSelected()) {
            buff.MPR += 2;
            if (ui.cb_buff[I_CON].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //�y�C�V�F���X ����MP25/10mins
        if (ui.cb_buff[I_PAT].isSelected()) {
            buff.DR += 2;
            if (ui.cb_buff[I_PAT].getForeground().equals(Color.BLUE)) {
                cons_mp += (25.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //�C���T�C�g ����MP60/10mins
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
        //���p[�I�[�K] ����MP20/2mins
        if (ui.cb_buff[I_IO].isSelected()) {
            buff.DMG_SHORT += 4;
            buff.HIT_SHORT += 4;
            if (ui.cb_buff[I_IO].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
            }
        }
        //���p[���b�`] ����MP20/2mins
        if (ui.cb_buff[I_IR].isSelected()) {
            buff.SP += 2;
            if (ui.cb_buff[I_IR].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
            }
        }
        //���p[�_�C�A�S�[����] ����MP40/2mins
        if (ui.cb_buff[I_ID].isSelected()) {
            buff.AC -= 8;
            if (ui.cb_buff[I_ID].getForeground().equals(Color.BLUE)) {
                cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
            }
        }
        //�t�H�[�J�X�X�s���b�c ����MP30/5mins
        if (ui.cb_buff[I_FS].isSelected()) {
            buff.CRI_MAGIC += 5;
            if (ui.cb_buff[I_FS].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //�C���p�N�g ����MP25/0.25mins
        if (ui.cb_buff[I_IT].isSelected()) {
            if (level >= 80 && cls == I) {
                if (ui.cb_buff[I_IT].getForeground().equals(Color.BLUE)) {
                    cons_mp += (25.0 * (1.0 - red_mp * 0.01) - red_mp2) / 0.25;
                }
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
                ui.cb_buff[I_IT].setSelected(false);
            }
        }
        //�N���C
        if (ui.cb_buff[CLAY].isSelected()) {
            buff.HP += 100;
            buff.MP += 50;
            buff.HPR += 3;
            buff.MPR += 3;
            buff.DMG_SHORT += 1;
            buff.DMG_LONG += 1;
            buff.HIT_SHORT += 5;
            buff.element_resist[EARTH] += 30;
            ui.cb_buff[UI.W_DW].setSelected(true);
            ui.cb_buff[CLAY].setToolTipText("<html>"+"HP+100 MP+50 HPR+3 MPR+3"
                    + "<br>"+ "�ߋ����_���[�W+1 �������_���[�W+1 �ߋ�������+5"
                    + "<br>"+ "�n������R+30 �f�B�N���[�X�E�F�C�g"+"</html>");
        }
        //���݂������O
        if (ui.cb_buff[MOMIJI].isSelected()) {
            buff.HP += 200;
            buff.ST[STR]++;
            buff.ST[DEX]++;
            buff.ST[CON]++;
            buff.ST[INT]++;
            buff.ST[WIS]++;
            buff.ST[CHA]++;
            ui.cb_buff[MOMIJI].setToolTipText("HP+200 �S�X�e�[�^�X+1");
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

        //�G���N�T�[���[��(LV70/80/85/90)
        int e = ui.elixir_rune.getSelectedIndex();
        int q = ui.elixir_rune_en.getSelectedIndex();
        if (e > 0 && e<6) {
            buff.ST[e - 1]++;
            switch (cls) {
                case P:
                    buff.DR += 3;
                    ui.elixir_rune.setToolTipText("�X�e+1 �_���[�W�ቺ+3");
                    switch (q) {
                        case 1:
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                            ui.elixir_rune.setToolTipText("�X�e+1 �_���[�W�ቺ+3 �ߋ�������+2");
                            break;
                        case 2:
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("�X�e+1 �_���[�W�ቺ+3 �ߋ�������+2 �j�����Ռ���+5% PVP���@�_���[�W����+1%");
                            break;
                        case 3:
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 5;    //�Z�p����+5
                                                            //PVP���@�_���[�W����+2%
                            ui.elixir_rune.setToolTipText("�X�e+1 �_���[�W�ቺ+3 �ߋ�������+2 �j�����Ռ���+5% �Z�p����+5 PVP���@�_���[�W����+2%");
                            break;
                        case 4:
                            buff.HIT_SHORT += 2;            //�ߋ�������+2
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 10;   //�Z�p����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("�X�e+1 �_���[�W�ቺ+3 �ߋ�������+2 �j�����Ռ���+5% �Z�p����+10 PVP���@�_���[�W����+3%");
                            break;
                        default:
                            
                            break;
                    }
                    break;
                case K:
                    buff.HP += 50;
                    ui.elixir_rune.setToolTipText("�X�e+1 HP+50");
                    switch (q) {
                        case 1:
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            ui.elixir_rune.setToolTipText("�X�e+1 HP+50 �ߋ����_���[�W+1");
                            break;
                        case 2:
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("�X�e+1 HP+50 �ߋ����_���[�W+1 �j�����Ռ���+5% PVP���@�_���[�W����+1%");
                            break;
                        case 3:
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 5;    //�Z�p����+5
                                                            //PVP���@�_���[�W����+2%
                            ui.elixir_rune.setToolTipText("�X�e+1 HP+50 �ߋ����_���[�W+1 �j�����Ռ���+5% �Z�p����+5 PVP���@�_���[�W����+2%");
                            break;
                        case 4:
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_STUN] += 10;   //�Z�p����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("�X�e+1 HP+50 �ߋ����_���[�W+1 �j�����Ռ���+5% �Z�p����+10 PVP���@�_���[�W����+3%");
                            break;
                        default:
                            break;
                    }
                    break;
                case E:
                    buff.MP += 50;
                    ui.elixir_rune.setToolTipText("�X�e+1 MP+50");
                    switch (q) {
                        case 1:
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                            ui.elixir_rune.setToolTipText("�X�e+1 MP+50 �ߋ����_���[�W+1 �������_���[�W+1");
                            break;
                        case 2:
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("�X�e+1 MP+50 �ߋ����_���[�W+1 �������_���[�W+1 �j�����Ռ���+5%");
                            break;
                        case 3:
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 5;  //���얽��+5
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("�X�e+1 MP+50 �ߋ����_���[�W+1 �������_���[�W+1 �j�����Ռ���+5% ���얽��+5");
                            break;
                        case 4:
                            buff.DMG_SHORT += 1;            //�ߋ����_���[�W+1
                            buff.DMG_LONG += 1;             //�������_���[�W+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 10; //���얽��+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("�X�e+1 MP+50 �ߋ����_���[�W+1 �������_���[�W+1 �j�����Ռ���+5% ���얽��+10");
                            break;
                        default:
                            break;
                    }
                    break;
                case W:
                    buff.MPR += 3;
                    ui.elixir_rune.setToolTipText("�X�e+1 MPR+3");
                    switch (q) {
                        case 1:
                            buff.SP += 1;                   //SP+1
                            ui.elixir_rune.setToolTipText("�X�e+1 MPR+3�@SP+1");
                            break;
                        case 2:
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("�X�e+1 MPR+3 SP+1 �j�����Ռ���+5% PVP���@�_���[�W����+1%");
                            break;
                        case 3:
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                            buff.HIT_MAGIC += 5;            //���@����+5
                                                            //PVP���@�_���[�W����+2%
                            ui.elixir_rune.setToolTipText("�X�e+1 MPR+3 SP+1 �j�����Ռ���+5% ���@����+5 PVP���@�_���[�W����+2%");
                            break;
                        case 4:
                            buff.SP += 1;                   //SP+1
                                                            //�j�����Ռ���+5%
                            buff.HIT_MAGIC += 10;           //���@����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("�X�e+1 MPR+3 SP+1 �j�����Ռ���+5% ���@����+10 PVP���@�_���[�W����+3%");
                            break;
                        default:
                            break;
                    }
                    break;
                case D:
                    buff.AC -= 3;
                    ui.elixir_rune.setToolTipText("�X�e+1 AC-3");
                    switch (q) {
                        case 1:
                            buff.MP += 30;                  //�ő�MP+30
                            ui.elixir_rune.setToolTipText("�X�e+1 AC-3 MP+30");
                            break;
                        case 2:
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("�X�e+1 AC-3 MP+30 �j�����Ռ���+5% PVP���@�_���[�W����+1%");
                            break;
                        case 3:
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 5;  //���얽��+5
                                                            //PVP���@�_���[�W����+2%
                            ui.elixir_rune.setToolTipText("�X�e+1 AC-3 MP+30 �j�����Ռ���+5% ���얽��+5 PVP���@�_���[�W����+2%");
                            break;
                        case 4:
                            buff.MP += 30;                  //�ő�MP+30
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SPIRIT] += 10; //���얽��+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("�X�e+1 AC-3 MP+30 �j�����Ռ���+5% ���얽��+10 PVP���@�_���[�W����+3%");
                            break;
                        default:
                            break;
                    }
                    break;
                case R:
                    buff.HIT_SHORT += 3;
                    ui.elixir_rune.setToolTipText("�X�e+1 �ߋ�������+3");
                    switch (q) {
                        case 1:
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                            ui.elixir_rune.setToolTipText("�X�e+1 �ߋ�������+3 �_���[�W�ቺ+1");
                            break;
                        case 2:
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("�X�e+1 �ߋ�������+3 �_���[�W�ቺ+1 �j�����Ռ���+5% PVP���@�_���[�W����+1%");
                            break;
                        case 3:
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 5;  //��Z����+5
                                                            //PVP���@�_���[�W����+2%
                            ui.elixir_rune.setToolTipText("�X�e+1 �ߋ�������+3 �_���[�W�ቺ+1 �j�����Ռ���+5% ��Z����+5 PVP���@�_���[�W����+2%");
                            break;
                        case 4:
                            buff.DR += 1;                   //�_���[�W�ቺ+1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 10; //��Z����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("�X�e+1 �ߋ�������+3 �_���[�W�ቺ+1 �j�����Ռ���+5% ��Z����+10 PVP���@�_���[�W����+3%");
                            break;
                        default:
                            break;
                    }
                    break;
                case I:
                    buff.r_weight += 0.12;
//                    buff.c_weight += 300;
                    ui.elixir_rune.setToolTipText("�X�e+1 �����d�ʑ���+300");
                    switch (q) {
                        case 1:
                            buff.HP += 50;                  //�ő�HP+50
                            ui.elixir_rune.setToolTipText("�X�e+1 �����d�ʑ���+300 HP+50");
                            break;
                        case 2:
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("�X�e+1 �����d�ʑ���+300 HP+50 �j�����Ռ���+5% PVP���@�_���[�W����+1%");
                            break;
                        case 3:
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 5;  //��Z����+5
                                                            //PVP���@�_���[�W����+2%
                            ui.elixir_rune.setToolTipText("�X�e+1 �����d�ʑ���+300 HP+50 �j�����Ռ���+5% ��Z����+5 PVP���@�_���[�W����+2%");
                            break;
                        case 4:
                            buff.HP += 50;                  //�ő�HP+50
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_SECRET] += 10; //��Z����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("�X�e+1 �����d�ʑ���+300 HP+50 �j�����Ռ���+5% ��Z����+10 PVP���@�_���[�W����+3%");
                            break;
                        default:
                            break;
                    }
                    break;
                case F:
                    buff.HP += 50;
                    ui.elixir_rune.setToolTipText("�X�e+1 HP+50");
                    switch (q) {
                        case 1:
                            buff.MR += 5;                   //MR+5%
                            ui.elixir_rune.setToolTipText("�X�e+1 HP+50 MR+5%");
                            break;
                        case 2:
                            buff.MR += 5;                   //MR+5%
                                                            //�j�����Ռ���+5%
                                                            //PVP���@�_���[�W����+1%
                            ui.elixir_rune.setToolTipText("�X�e+1 HP+50 MR+5% �j�����Ռ���+5% PVP���@�_���[�W����+1%");
                            break;
                        case 3:
                            buff.MR += 5;                   //MR+5%1
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 5;  //�Z�p����+5
                                                            //PVP���@�_���[�W����+2%
                            ui.elixir_rune.setToolTipText("�X�e+1 HP+50 MR+5% �j�����Ռ���+5% �Z�p����+5 PVP���@�_���[�W����+2%");
                            break;
                        case 4:
                            buff.MR += 5;                   //MR+5%
                                                            //�j�����Ռ���+5%
                            buff.ailment[HIT_TERROR] += 10; //�Z�p����+10
                                                            //PVP���@�_���[�W����+3%
                            ui.elixir_rune.setToolTipText("�X�e+1 HP+50 MR+5% �j�����Ռ���+5% �Z�p����+10 PVP���@�_���[�W����+3%");
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
                                                        //�l���o���l+2%
                    ui.elixir_rune.setToolTipText("AC-4 DEX+1 �������_���[�W+4 ����������+6 �l���o���l+10%");
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
                                                        //�l���o���l+5%                    
                    ui.elixir_rune.setToolTipText("AC-3 �ߋ����_���[�W+2 �ߋ�������+2 �������_���[�W+2 ����������+ SP+2 ���@����+2 MR+5% ���|�ϐ�+5"
                            + " �l���o���l+5%");
        }else if (e == 8){                              //�h���S���̈╨
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //�ߋ����_���[�W+2
                    buff.HIT_SHORT += 2;                //�ߋ�������+2
                    buff.DMG_LONG += 2;                 //�������_���[�W+2
                    buff.HIT_LONG += 2;                 //����������+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_MAGIC += 2;                //���@����+2
                                                        //�l���o���l+2%
                    ui.elixir_rune.setToolTipText("AC-3 �ߋ����_���[�W+2 �ߋ�������+2 �������_���[�W+2 ����������+2 SP+2 ���@����+2 �l���o���l+2%");
        }else if (e == 9){                              //�������ꂽ�h���S���̈╨(�r��)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[STR] += 1;                  //STR+1
                    buff.DMG_SHORT += 4;                //�ߋ����_���[�W+4
                    buff.HIT_SHORT += 6;                //�ߋ�������+6
                                                        //�l���o���l+10%
                    ui.elixir_rune.setToolTipText("AC-4 STR+1 �ߋ����_���[�W+4 �ߋ�������+6 �l���o���l+10%");
        }else if (e == 10){                             //�������ꂽ�h���S���̈╨(�m��)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[INT] += 1;                  //INT+1
                    buff.SP += 4;                       //SP+4
                    buff.HIT_MAGIC += 6;                //���@����+6
                                                        //�l���o���l+10%
                    ui.elixir_rune.setToolTipText("AC-4 INT+1 SP+4 ���@����+6 �l���o���l+10%");
        }else if (e == 11){                             //�������ꂽ�h���S���̈╨(�@�q)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[DEX] += 1;                  //DEX+1
                    buff.DMG_LONG += 4;                 //�������_���[�W+4
                    buff.HIT_LONG += 6;                 //����������+6
                                                        //�l���o���l+10%          
                    ui.elixir_rune.setToolTipText("AC-4 DEX+1 �������_���[�W+4 ����������+6 �l���o���l+10%");
        }else if (e == 12){                             //�^�f�X�i�C�g�̈╨
                    buff.AC -= 3;                       //AC-3
                    buff.DMG_SHORT += 2;                //�ߋ����_���[�W+2
                    buff.HIT_SHORT += 2;                //�ߋ�������+2
                    buff.DMG_LONG += 2;                 //�������_���[�W+2
                    buff.HIT_LONG += 2;                 //����������+2
                    buff.SP += 2;                       //SP+2
                    buff.HIT_MAGIC += 2;                //���@����+2
                                                        //�l���o���l+2%
                    ui.elixir_rune.setToolTipText("AC-3 �ߋ����_���[�W+2 �ߋ�������+2 �������_���[�W+2 ����������+2 SP+2 ���@����+2 �l���o���l+2%");
        }else if (e == 13){                             //�������ꂽ�^�f�X�i�C�g�̈╨(�r��)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[STR] += 1;                  //STR+1
                    buff.DMG_SHORT += 4;                //�ߋ����_���[�W+4
                    buff.HIT_SHORT += 6;                //�ߋ�������+6
                                                        //�l���o���l+10%
                                                        //�j�����Ռ���+5%
                                                        //�S�ϐ�+3
                    buff.ailment[STUN] += 3;            //�Z�p�ϐ�+3
                    buff.ailment[SPIRIT] += 3;          //����ϐ�+3
                    buff.ailment[SECRET] += 3;          //��V�ϐ�+3
                    buff.ailment[TERROR] += 3;          //���|�ϐ�+3
                    ui.elixir_rune.setToolTipText("AC-4 STR+1 �ߋ����_���[�W+4 �ߋ�������+6 �l���o���l+10% �j�����Ռ���+5% �S�ϐ�+3");
        }else if (e == 14){                             //�������ꂽ�^�f�X�i�C�g�̈╨(�m��)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[INT] += 1;                  //INT+1
                    buff.SP += 4;                       //SP+4
                    buff.HIT_MAGIC += 6;                //���@����+6
                                                        //�l���o���l+10%
                                                        //�j�����Ռ���+5%
                                                        //�S�ϐ�+3
                    buff.ailment[STUN] += 3;            //�Z�p�ϐ�+3
                    buff.ailment[SPIRIT] += 3;          //����ϐ�+3
                    buff.ailment[SECRET] += 3;          //��V�ϐ�+3
                    buff.ailment[TERROR] += 3;          //���|�ϐ�+3
                    ui.elixir_rune.setToolTipText("AC-4 INT+1 SP+4 ���@����+6 �l���o���l+10% �j�����Ռ���+5% �S�ϐ�+3");
        }else if (e == 15){                             //�������ꂽ�^�f�X�i�C�g�̈╨(�@�q)
                    buff.AC -= 4;                       //AC-4
                    buff.ST[DEX] += 1;                  //DEX+1
                    buff.DMG_LONG += 4;                 //�������_���[�W+4
                    buff.HIT_LONG += 6;                 //����������+6
                                                        //�l���o���l+10%          
                                                        //�j�����Ռ���+5%
                                                        //�S�ϐ�+3
                    buff.ailment[STUN] += 3;            //�Z�p�ϐ�+3
                    buff.ailment[SPIRIT] += 3;          //����ϐ�+3
                    buff.ailment[SECRET] += 3;          //��V�ϐ�+3
                    buff.ailment[TERROR] += 3;          //���|�ϐ�+3
                    ui.elixir_rune.setToolTipText("AC-4 DEX+1 �������_���[�W+4 ����������+6 �l���o���l+10% �j�����Ռ���+5% �S�ϐ�+3");
        }
        //�^���X�}��
            switch (ui.cb_pattern_l2.getSelectedIndex()) {
                case 0:
                    break;
                case 1:
                    buff.DMG_SHORT += 1;    //�ߋ����_���[�W+1
                    buff.HIT_SHORT += 1;    //�ߋ�������+1
                    buff.SP += 1;           //SP+1
                    buff.MR += 5;           //MR+5
                    break;
                case 2:
                    buff.DMG_LONG += 1;     //�������_���[�W+1
                    buff.HIT_LONG += 1;     //����������+1
                    buff.SP += 1;           //SP+1
                    buff.MR += 5;           //MR+5
                    break;
                case 3:
                    buff.DMG_SHORT += 1;    //�ߋ����_���[�W+1
                    buff.HIT_SHORT += 1;    //�ߋ�������+1
                    buff.DMG_LONG += 1;     //�������_���[�W+1
                    buff.HIT_LONG += 1;     //����������+1
                    buff.SP += 1;           //SP+1
                    buff.MR += 5;           //MR+5
                    break;
                case 4:
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

        if (ui.cb_buff[B_STR].isSelected()) {
            switch (ui.cb_buff_group[B_STR].getSelectedIndex()) {
                case 0:
                    buff.ST[STR] += 3;
                    if (ui.cb_buff[B_STR].getForeground().equals(Color.BLUE)) {
                        cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                    }
                    break;
                case 1:
                    buff.ST[STR] += 5;
                    if (ui.cb_buff[B_STR].getForeground().equals(Color.BLUE)) {
                        cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 2:
                    buff.ST[STR] += 6;
                    break;
                case 3:
                    buff.ST[STR] += 7;
                    break;
                default:
                    break;
            }
        }
        if (ui.cb_buff[B_DEX].isSelected()) {
            switch (ui.cb_buff_group[B_DEX].getSelectedIndex()) {
                case 0:
                    buff.ST[DEX] += 3;
                    if (ui.cb_buff[B_DEX].getForeground().equals(Color.BLUE)) {
                        cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                    }
                    break;
                case 1:
                    buff.ST[DEX] += 5;
                    if (ui.cb_buff[B_DEX].getForeground().equals(Color.BLUE)) {
                        cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 2:
                    buff.ST[DEX] += 6;
                    break;
                case 3:
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

        if (ui.cb_buff[ACC1].isSelected()) {
            if (ui.cb_buff[ACC1].getForeground().equals(Color.BLUE)) {
                cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
            }
            acc *= acc_1;
        }
        if (ui.cb_buff[ACC2].isSelected()) {
            switch (ui.cb_buff_group[ACC2].getSelectedIndex()) {
                case 0:
                    acc *= acc_2;
                    if (ui.cb_buff[ACC2].getForeground().equals(Color.BLUE)) {
                        if (cls == E) {
                            cons_mp = (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 8;
                        }
                    }
                    break;
                case 1:
                    acc *= acc_ew;
                    break;
                default:
                    break;
            }
        }
        if (ui.cb_buff[ACC3].isSelected()) {
            acc *= acc_3;
        }
        
//2019/11/20Update HW/EW/BW/SF�̎d�l�ύX
//���܂ł͕���ɃG���`�����g���ʂ�������������̓L�����Ɍ��ʂ�����
        buki.magic_enchant = 0;
        buki2.magic_enchant = 0;
        if (ui.cb_buff[BUKI].isSelected()) {
            switch (ui.cb_buff_group[BUKI].getSelectedIndex()) {
                case 0://�z�[���[�E�F�|�� �ߋ����_���[�W+1 �ߋ�������+1
                    //buki.magic_enchant = 1;
                    //buki2.magic_enchant = 1;
                    buff.DMG_SHORT += 1;
                    buff.HIT_SHORT += 1;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 1://�G���`�����g�E�F�|�� �ߋ����_���[�W+2
                    //buki.magic_enchant = 2;
                    //buki2.magic_enchant = 2;
                    buff.DMG_SHORT += 2;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
                    }
                    break;
                case 2://�u���X�E�F�|�� �ߋ����_���[�W+2 �ߋ�������+2
                    //buki.magic_enchant = 2;
                    //buki2.magic_enchant = 2;
                    buff.DMG_SHORT += 2;
                    buff.HIT_SHORT += 2;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                    }
                    break;
                case 3://�V���h�E�t�@���O �ߋ����_���[�W+5
                    //buki.magic_enchant = 5;
                    //buki2.magic_enchant = 5;
                    buff.DMG_SHORT += 5;
                    if (ui.cb_buff[BUKI].getForeground().equals(Color.BLUE)) {
                        cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 3;
                    }
                    break;
                default:
                    break;
            }
        }
//�N�喂�@�i�v�����X�E�v�����Z�X)
        //�O���[�C���O�E�G�|�� ����MP25/10mins
        if (ui.cb_buff[P_G].isSelected()) {
            buff.HIT_SHORT += 5;
            buff.DMG_SHORT += 5;
            if (ui.cb_buff[P_G].getForeground().equals(Color.BLUE)) {
                cons_mp += (25.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //�V���C�j���O�V�[���h ����MP25/2mins
        if (ui.cb_buff[P_S].isSelected()) {
            buff.AC -= 8;
            if (ui.cb_buff[P_S].getForeground().equals(Color.BLUE)) {
                cons_mp += (25.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        //�V���C�j���O�A�[�}�[ ����MP25 HP50/5mins
        if (ui.cb_buff[P_SA].isSelected()) {
            buff.ER += 10;
            if (ui.cb_buff[P_SA].getForeground().equals(Color.BLUE)) {
                cons_mp += (25.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //�}�W�F�X�e�B ����MP20 HP50/5mins
        if (ui.cb_buff[P_M].isSelected()) {
            //DR+2(���x��80����2���x�����オ�閈��+1)
            if (level <= 80) {
            buff.DR += 2;
            } else if (level > 80) {
            buff.DR += 2+(level/2-40);
            }
            if (ui.cb_buff[P_M].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
            }
        }
        //�u���C�u�A�o�^�[ ����MP0/�펞 STR+1 DEX+1 INT+1 MR+10% �Z�p�ϐ�+2 ����ϐ�+2 ��Z�ϐ�+2 ���|�ϐ�+2
        if (ui.cb_buff[P_BA].isSelected()) {
            buff.MR += 10;
            buff.ailment[STUN] += 2;
            buff.ailment[SPIRIT] += 2;
            buff.ailment[SECRET] += 2;
            buff.ailment[TERROR] += 2;
            buff.ST[STR] += 1;
            buff.ST[DEX] += 1;
            buff.ST[INT] += 1;
        }
        //�O���[�X�A�o�^�[ ����MP15/15�b �Z�p�ϐ�+5 ����ϐ�+5 ��Z�ϐ�+5 ���|�ϐ�+5 ���x��80����+1������(�ő�+15)
        if (ui.cb_buff[P_GA].isSelected()) {
            switch ((String) ui.cb_buff_group[P_GA].getSelectedItem()) {
                case "�N��L80":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+5 ����ϐ�+5 ��Z�ϐ�+5 ���|�ϐ�+5");
                    buff.ailment[STUN] += 5;
                    buff.ailment[SPIRIT] += 5;
                    buff.ailment[SECRET] += 5;
                    buff.ailment[TERROR] += 5;
                    break;
                case "�N��L81":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+6 ����ϐ�+6 ��Z�ϐ�+6 ���|�ϐ�+6");
                    buff.ailment[STUN] += 6;
                    buff.ailment[SPIRIT] += 6;
                    buff.ailment[SECRET] += 6;
                    buff.ailment[TERROR] += 6;
                    break;
                case "�N��L82":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+7 ����ϐ�+7 ��Z�ϐ�+7 ���|�ϐ�+7");
                    buff.ailment[STUN] += 7;
                    buff.ailment[SPIRIT] += 7;
                    buff.ailment[SECRET] += 7;
                    buff.ailment[TERROR] += 7;
                    break;
                case "�N��L83":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+8 ����ϐ�+8 ��Z�ϐ�+8 ���|�ϐ�+8");
                    buff.ailment[STUN] += 8;
                    buff.ailment[SPIRIT] += 8;
                    buff.ailment[SECRET] += 8;
                    buff.ailment[TERROR] += 8;
                    break;
                case "�N��L84":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+9 ����ϐ�+9 ��Z�ϐ�+9 ���|�ϐ�+9");
                    buff.ailment[STUN] += 9;
                    buff.ailment[SPIRIT] += 9;
                    buff.ailment[SECRET] += 9;
                    buff.ailment[TERROR] += 9;
                    break;
                case "�N��L85":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+10 ����ϐ�+10 ��Z�ϐ�+10 ���|�ϐ�+10");
                    buff.ailment[STUN] += 10;
                    buff.ailment[SPIRIT] += 10;
                    buff.ailment[SECRET] += 10;
                    buff.ailment[TERROR] += 10;
                    break;
                case "�N��L86":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+11 ����ϐ�+11 ��Z�ϐ�+11 ���|�ϐ�+11");
                    buff.ailment[STUN] += 11;
                    buff.ailment[SPIRIT] += 11;
                    buff.ailment[SECRET] += 11;
                    buff.ailment[TERROR] += 11;
                    break;
                case "�N��L87":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+12 ����ϐ�+12 ��Z�ϐ�+12 ���|�ϐ�+12");
                    buff.ailment[STUN] += 12;
                    buff.ailment[SPIRIT] += 12;
                    buff.ailment[SECRET] += 12;
                    buff.ailment[TERROR] += 12;
                    break;
                case "�N��L88":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+13 ����ϐ�+13 ��Z�ϐ�+13 ���|�ϐ�+13");
                    buff.ailment[STUN] += 13;
                    buff.ailment[SPIRIT] += 13;
                    buff.ailment[SECRET] += 13;
                    buff.ailment[TERROR] += 13;
                    break;
                case "�N��L89":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+14 ����ϐ�+14 ��Z�ϐ�+14 ���|�ϐ�+14");
                    buff.ailment[STUN] += 14;
                    buff.ailment[SPIRIT] += 14;
                    buff.ailment[SECRET] += 14;
                    buff.ailment[TERROR] += 14;
                    break;
                case "�N��L90+":
                    ui.cb_buff[P_GA].setToolTipText("�Z�p�ϐ�+10 ����ϐ�+10 ��Z�ϐ�+10 ���|�ϐ�+10");
                    buff.ailment[STUN] += 10;
                    buff.ailment[SPIRIT] += 10;
                    buff.ailment[SECRET] += 10;
                    buff.ailment[TERROR] += 10;
                    break;
                default:
                    break;
            }
        }
        //AC�X�L��
        if (ui.cb_buff[B_AC].isSelected()) {
            switch (ui.cb_buff_group[B_AC].getSelectedIndex()) {
                case 0://�V�[���h		AC-2	����MP8  ���@���x��1 �p������1800�b
                    buff.AC += -2;
                    if (ui.cb_buff[B_AC].getForeground().equals(Color.BLUE)) {
                        cons_mp += (8.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
                    }
                    break;
                case 1://�t�@�C���[�V�[���h 	AC-4	����MP15 ���@���x��3 �p������960�b
                    buff.AC += -4;
                    if (ui.cb_buff[B_AC].getForeground().equals(Color.BLUE)) {
                        cons_mp += (15.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                    }
                    break;
                case 2://�l�G�̃|�[�V���� 	AC-5      
                    buff.AC += -5;
                    break;
                case 3://�A�C�A���X�L��          AC-10	����MP30 ���@���x��5 �p������960�b
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
        ui.cb_buff[VIP].setToolTipText("<html>"+ "Red      HP+120 MP+120 MR+10 AC-5"
                                       + "<br>"+ "Gold     HP+150 MP+120 MR+10 AC-5"
                                       + "<br>"+ "Platinum HP+150 MP+150 MR+12 AC-5");
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
                    ui.cb_buff[VIP].setToolTipText("HP+150 MP+150 MR+120 AC-5");
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
        if (ui.cb_buff[SEC].isSelected()) {
            buff.AC -= 1;
            buff.MR += 2;
            buff.DR += 1;
            ui.cb_buff[SEC].setToolTipText("AC-1 MR+2% �_���[�W�ቺ+1");
        }
        //�^�S�̂��������j���X�N���[��
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
            ui.cb_buff[MBSC].setToolTipText("<html>"+ "�_���[�W�ቺ+3 �ߋ����_���[�W+2 �������_���[�W+2 �ߋ�������+2 ����������+2"
                    + "<br>"+ "���@����+2 SP+2 �ő�HP+50 HP��+3 �ő�MP+30 MP��+3 �l���o���l+5% 30��"+"</html>");
        }
        //�o�t�R�C�� 
        if (ui.cb_buff[BUFF_COIN].isSelected()) {
            buff.DMG_SHORT += 1;
            buff.DMG_LONG += 1;
            buff.SP += 1;
            ui.cb_buff[BUFF_COIN].setToolTipText("�ߋ����_���[�W+1 �������_���[�W+1 SP+1");
        }
        //���ւ̃R�C�� 
        if (ui.cb_buff[BS_COIN].isSelected()) {
            buff.HP += 20;
            buff.MP += 13;
            buff.AC -= 2;
            buff.DR += 3;
            ui.cb_buff[BS_COIN].setToolTipText("HP+20 MP+13 AC-2 �_���[�W�ቺ+3");
        }
        //����
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
        if (ui.cb_buff[L_HST].isSelected()) {
            switch ((String) ui.cb_buff_group[L_HST].getSelectedItem()) {
                case "1��":
                    ui.cb_buff[L_HST].setToolTipText("EXP20% AC-1");
                    buff.AC -= 1;
                    break;
                case "2��":
                    ui.cb_buff[L_HST].setToolTipText("EXP30% AC-2 DR+1");
                    buff.AC -= 2;
                    buff.DR += 1;
                    break;
                case "3��":
                    ui.cb_buff[L_HST].setToolTipText("EXP40% AC-3 DR+2");
                    buff.AC -= 3;
                    buff.DR += 2;
                    break;
                case "4��":
                    ui.cb_buff[L_HST].setToolTipText("EXP40% AC-4 DR+2");
                    buff.AC -= 4;
                    buff.DR += 2;
                    break;
                case "5��":
                    ui.cb_buff[L_HST].setToolTipText("EXP40% AC-5 DR+2");
                    buff.AC -= 5;
                    buff.DR += 2;
                    break;
                default:
                    break;
            }
        }
        //�����̃{�[�i�X
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
        //STR+1[�N��][�i�C�g][�_�[�N�G���t][�h���S���i�C�g][�E�H���A�[]
        //DEX+1[�G���t]
        //INT+1[�E�B�U�[�h][�C�����[�W���j�X�g]
        if (ui.cb_buff[H_RK].isSelected()) {
            switch (cls) {
                case P:
                    //ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;
                case K:
                    //ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;
                case E:
                    //ui.cb_buff[H_RK].setToolTipText("DEX+1");
                    buff.ST[DEX] += 1;
                    break;
                case W:
                    //ui.cb_buff[H_RK].setToolTipText("INT+1");
                    buff.ST[INT] += 1;
                    break;                   
                case D:
                    //ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;                    
                case R:
                    //ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;
                case I:
                    //ui.cb_buff[H_RK].setToolTipText("INT+1");
                    buff.ST[INT] += 1;
                    break;
                case F:
                    //ui.cb_buff[H_RK].setToolTipText("STR+1");
                    buff.ST[STR] += 1;
                    break;
                default:
                    break;
            }
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

        if (pure_str >= 25) {
            base_dmg_short += 1;
            base_hit_short += 1;
        }
        if (pure_str >= 35) {
            base_dmg_short += 1;
            base_hit_short += 1;
        }
        if (pure_str >= 45) {
            base_dmg_short += 3;
            base_hit_short += 3;
            cri_short += 1;
        }

        if (pure_dex >= 25) {
            base_dmg_long += 1;
            base_hit_long += 1;
        }
        if (pure_dex >= 35) {
            base_dmg_long += 1;
            base_hit_long += 1;
        }
        if (pure_dex >= 45) {
            base_dmg_long += 3;
            base_hit_long += 3;
            cri_long += 1;
        }

        if (pure_int >= 25) {
            base_dmg_magic += 1;
            base_hit_magic += 1;
        }
        if (pure_int >= 35) {
            base_dmg_magic += 1;
            base_hit_magic += 1;
        }
        if (pure_int >= 45) {
            base_dmg_magic += 3;
            base_hit_magic += 3;
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
//        cri_short += buki.op.CRI_SHORT + buki.op2.CRI_SHORT;
        cri_short += buki.op.CRI_SHORT + buki.op2.CRI_SHORT + buff.CRI_SHORT;
//        cri_long += buki.op.CRI_LONG + buki.op2.CRI_LONG;
        cri_long += buki.op.CRI_LONG + buki.op2.CRI_LONG + buff.CRI_LONG;
//        cri_magic += buki.op.CRI_MAGIC + buki.op2.CRI_MAGIC;
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
            case W:                     //�G���t:�}�W�b�N���x���ő�13����14�֕ύX
                ml = level / 4;
                if (ml > 14) {
                    ml = 14;
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
            case F:
                ml = level / 50;
                if (ml > 1) {
                    ml = 1;
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
        
//System.out.print(" ���������� ���v:");
//System.out.print(hit_long);
//System.out.print(" ����������(�):");
//System.out.print(buki.arrow_hit);
//System.out.print(" ����������(���핪):");
//System.out.print(buki.op.HIT_LONG);
//System.out.print(" ����������(���틭����)/2:");
//System.out.print(buki.enchant / 2);
//System.out.print(" ����������(���@�X�L����):");
//System.out.println(buff.HIT_LONG);

buki.arrow_hit=0;

        //������
//        if (buki.type.equals("�{�E")) {
//            if (buki.arrow_name.contains("��")) {
//                switch (buki.arrow_name) {
//                    case "�Η�̃u���b�N�~�X�����A���[":
//                        buff.ELEM_DMG_LONG[FIRE] += 3;
//                       break;
//                   case "����̃u���b�N�~�X�����A���[":
//                       buff.ELEM_DMG_LONG[WATER] += 3;
//                       break;
//                   case "����̃u���b�N�~�X�����A���[":
//                       buff.ELEM_DMG_LONG[WIND] += 3;
//                       break;
//                   case "�n��̃u���b�N�~�X�����A���[":
//                       buff.ELEM_DMG_LONG[EARTH] += 3;
//                       break;
//               }
//            }
//       }
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
        
//System.out.print(" �Α����_���[�W:");
//System.out.print(buff.ELEM_DMG_LONG[FIRE]);
//System.out.print(" �������_���[�W:");
//System.out.print(buff.ELEM_DMG_LONG[WATER]);
//System.out.print(" �������_���[�W:");
//System.out.print(buff.ELEM_DMG_LONG[WIND]);
//System.out.print(" �n�����_���[�W:");
//System.out.println(buff.ELEM_DMG_LONG[EARTH]);

buki.arrow_elementdmg=0;

        for (Bougu bougu1 : bougu) {
            hit_short += bougu1.op.HIT_SHORT + bougu1.op2.HIT_SHORT;
            //hit_long += bougu1.op.HIT_LONG + bougu1.op.HIT_SHORT + bougu1.op2.HIT_LONG + bougu1.op2.HIT_SHORT;
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
        if (cls == F
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

//                    if (ui.cb_sonsyou.isSelected() && !(buki.arrow_name.equals("�K�^�̃A���[") || buki.op.effect.contains("�ђʌ���"))) {
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
//System.out.print(" buki.  big����:");
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
//System.out.print(" buki.small����:");
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
                //�G���t �C�[�O���A�C 2% ����MP20/2mins
//                cri_long += cr * 100;
                if (ui.cb_buff[E_EE].isSelected()) {
                    cri_long += 2;
                    if (ui.cb_buff[E_EE].isSelected()) {
                        if (ui.cb_buff[E_EE].getForeground().equals(Color.BLUE)) {
                            cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
                        }
                    }
                }
                dmg_big_ave = (cri_long * 0.01) * dmg_big_max
                        + (1.0 - cri_long * 0.01) * dmg_big_ave;
                dmg_small_ave = (cri_long * 0.01) * dmg_small_max
                        + (1.0 - cri_long * 0.01) * dmg_small_ave;
                break;
            default:
                //�G���t �\�E���I�u�t���C�� 100% ����MP40/5mins
                cri_short += cr * 100;
                if (ui.cb_buff[E_SF].isSelected()) {
                    cri_short = 100;
                    if (ui.cb_buff[E_SF].isSelected()) {
                        if (ui.cb_buff[E_SF].getForeground().equals(Color.BLUE)) {
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

//        if (buki.magic_motion) {
//            dmg_small_ave *= (1.0 - rate);
//            dmg_big_ave *= (1.0 - rate);
//        }
        //���@���p�C�A���b�N�^�b�`
        if (buff.effect.contains("���@���p�C�A���b�N�^�b�`")) {
            double vt_rate = 0.04;
            double vt_motion = 60.0 / (polymorph.getSpeed(level, ui.cb_morph_type.getSelectedIndex(), buki_id));
            double atk_motion = 60.0 / (speed);

            //VT���[�V�����ɂ��U�����x�̒ቺ
            speed *= (atk_motion) / (atk_motion + vt_motion * vt_rate);
        }
        //�_�u���u���C�N
        if (ui.cb_buff[D_DB].isSelected()) {
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
                ui.cb_buff[D_DB].setSelected(false);
                ui.cb_buff[D_DB2].setSelected(false);
            }
        }
        //�_�u���u���C�N:�f�X�e�B�j�[
        if (ui.cb_buff[D_DB2].isSelected()) {
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
                ui.cb_buff[D_DB].setSelected(false);
            } else {
                ui.cb_buff[D_DB].setSelected(false);
                ui.cb_buff[D_DB2].setSelected(false);
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
        //�A�o�^�[
        if (ui.cb_buff[I_IA].isSelected()) {
            dmg_big_ave += 10;
            dmg_small_ave += 10;
            if (ui.cb_buff[I_IA].getForeground().equals(Color.BLUE)) {
                cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 2;
            }
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
        if (ui.cb_buff[F_CR].isSelected()) {
            ex = level / 2.0;
        }
        //�t���[���[
        if (ui.cb_buff[F_FU].isSelected()) {
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
        //�o�[�j���O�X�s���b�c ����MP20/5mins
        if (ui.cb_buff[D_BS].isSelected()) {
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

                if (ui.cb_buff[D_BS].getForeground().equals(Color.BLUE)) {
                    cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            }
        }
        //�G�������^���t�@�C�A�[ ����MP20/5mins
        if (ui.cb_buff[E_EF].isSelected()) {
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
                if (ui.cb_buff[E_EF].getForeground().equals(Color.BLUE)) {
                    cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            }
        }
        //�N�G�C�N ����MP20/5mins
        if (ui.cb_buff[E_QE].isSelected()) {
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
                if (ui.cb_buff[E_QE].getForeground().equals(Color.BLUE)) {
                    cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            }
        }
        //�T�C�N���� ����MP30/16mins LV75�擾�\ ���m���ŉ������_���[�W1.5�{ LV85����LV1���ɔ�����1%����
        if (ui.cb_buff[E_CE].isSelected()) {
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
                if (ui.cb_buff[E_CE].getForeground().equals(Color.BLUE)) {
                    cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
                }
            } else {
                ui.cb_buff[E_CE].setSelected(false);
            }
        }
         
        //�u���C�u�����^�� ����MP25/10mins
        if (ui.cb_buff[P_B].isSelected()) {
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

                if (ui.cb_buff[P_B].getForeground().equals(Color.BLUE)) {
                    cons_mp += 25.0 / 10;
                }
            } else {
                ui.cb_buff[P_B].setSelected(false);
            }
        }
        //�u���[�A�^�b�N ����MP10/5mins
        if (ui.cb_buff[K_BK].isSelected()) {
            if (level >= 75 && cls == K
                    && buki_id == W_D || buki_id == W_LS || buki_id == W_A|| buki_id == W_L) {
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
                if (ui.cb_buff[K_BK].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            } else {
                ui.cb_buff[K_BK].setSelected(false);
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
                ui.lab_mag_info1.setText("���@�F�Ȃ�");
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
                ui.lab_mag_info1.setText("���@�F" + buki.magic_name);
                break;
            default:
                ui.lab_mag_info1.setText("���@�F"
                        + buki.magic_name);
                if (rate != 0) {
                    ui.lab_mag_info2.setText(
                            "���@�_���[�W " + format_dmg.format(magic / rate) + "  " + format_rate.format(rate));
                } else {
                    ui.lab_mag_info2.setText("");
                }
                break;
        }
        ui.lab_hit_rate.setText("�������F" + format_rate.format(hit_rate));

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
        ui.pure_status_bonus[1][0].setText(Integer.toString(base_dmg_short));
        ui.pure_status_bonus[1][5].setText(Integer.toString(base_dmg_long));
        ui.pure_status_bonus[1][15].setText(Integer.toString(base_dmg_magic));
        ui.pure_status_bonus[1][1].setText(Integer.toString(base_hit_short));
        ui.pure_status_bonus[1][6].setText(Integer.toString(base_hit_long));
        ui.pure_status_bonus[1][16].setText(Integer.toString(base_hit_magic));
        ui.pure_status_bonus[1][2].setText(Integer.toString(cri_short));
        ui.pure_status_bonus[1][7].setText(Integer.toString(cri_long));
        ui.pure_status_bonus[1][17].setText(Integer.toString(cri_magic));
        ui.pure_status_bonus[1][18].setText(Integer.toString(mb));
        ui.pure_status_bonus[1][19].setText((Integer.toString(red_mp)));

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
            case F:
                c = 6;
//                d = 3;
                break;
            default:
                break;
        }
        base_ac = 10 - (int) (dex / 3) - (int) (level / c);
//        LV60����PVP�_���[�W�ቺ
//        if (level >= 60){
//        base_pvp_dr = (int) ((level-60) / d);
//        System.out.println(base_pvp_dr);    //�����l�m�F�p
//        }

        base_er = (int) (dex / 2) + (int) (level / _C[ER][DEX][cls]);

        ui.pure_status_bonus[1][8].setText(Integer.toString(base_ac));
        ui.pure_status_bonus[1][9].setText(Integer.toString(base_er));

        ac = base_ac + buff.AC + equip_ac;
        int er = base_er + buff.ER;
//        int dr = buff.DR;
//        int dri= buff.DR_IGNORED;
        //AC-100�ȏォ��AC-10���Ƃ�ER��+1
        if (ac <= -100){
                er += -ac / 10-10;
        }
        dr = buff.DR;
        dri= buff.DR_IGNORED;    
        pvp_dg= buff.PVP;
        pvp_dgr= buff.PVP_DR;
//        pvp_dgr= base_pvp_dr + buff.PVP_DR;
//        System.out.println(pvp_dgr);    //�����l�m�F�p

        if (ui.cb_buff[F_AG].isSelected()) {
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
        }
        dg = 0;
        //AC-100�ȏォ��AC-10���Ƃ�DG��+1
        if (ac <= -100){
        dg += -ac / 10-10;
        }
        dr += buki.op.DR + buki.op2.DR;
        dri += buki.op.DR_IGNORED + buki.op2.DR_IGNORED; 
        pvp_dg += buki.op.PVP + buki.op2.PVP;
        pvp_dgr += buki.op.PVP_DR + buki.op2.PVP_DR;       
        
        //�A���L���j�[�h�b�W ����MP40/16mins
        if (ui.cb_buff[D_UD].isSelected()) {
            dg += 30;
            if (ui.cb_buff[D_UD].getForeground().equals(Color.BLUE)) {
                cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
            }
        }
        //�~���[�C���[�W ����MP20/20mins
        if (ui.cb_buff[I_MI].isSelected()) {
            dg += 30;
            if (ui.cb_buff[I_MI].getForeground().equals(Color.BLUE)) {
                cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
            }
        }
        //�o��[�����h�r�I��] ����MP40/10mins
        if (ui.cb_buff[R_LINDVIOL].isSelected()) {
            dg += 7;
            if (ui.cb_buff[R_LINDVIOL].getForeground().equals(Color.BLUE)) {
                    cons_mp += (40.0 * (1.0 - red_mp * 0.01) - red_mp2) / 10;
            }
        }
        ui.lab_ac.setText(Integer.toString(ac));
        ui.lab_dg.setText(Integer.toString(dg));
        ui.lab_er.setText(Integer.toString(er));
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

        ui.pure_status_bonus[1][3].setText(Integer.toString(weight));
        ui.pure_status_bonus[1][13].setText(Integer.toString(weight));

        weight *= 1 + r_eq;

        int c_eq = 0;

        for (Bougu bougu1 : bougu) {
            c_eq += bougu1.op.c_weight;
            c_eq += bougu1.op2.c_weight;
        }

        weight += c_eq;
        //�G�������O�����B�e�B�[    ����MP:30/30mins �����d�ʑ���+300
        if (ui.cb_buff[E_EGR].isSelected()) {
            ui.cb_buff[W_DW].setSelected(false);
            weight += 300;
            if (ui.cb_buff[E_EGR].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
            }
        }
        //���f���[�X�E�F�C�g        ����MP:50/30mins �����d�ʑ���+480 
        if (ui.cb_buff[I_RW].isSelected()) {
            ui.cb_buff[W_DW].setSelected(false);
            weight += 480;
            if (ui.cb_buff[I_RW].getForeground().equals(Color.BLUE)) {
                cons_mp += (50.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
            }
        }
        //�f�B�N���[�X�E�F�C�g      ����MP:10/30mins �����d�ʑ���+180
        if (ui.cb_buff[W_DW].isSelected()) {
            weight += 180;
            if (ui.cb_buff[W_DW].getForeground().equals(Color.BLUE)) {
                cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 30;
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
        ui.pure_status_bonus[1][23].setText(Integer.toString(mr));
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
        if (ui.cb_buff[ITEM_BLUE].isSelected()) {
            if (wis >= 10) {
                //mpr += (wis - 10) / 2;
                //ui.pure_status_bonus[1][22].setText(Integer.toString((wis - 10) / 2));
                mpr += (wis - 8) / 2;
                ui.pure_status_bonus[1][22].setText(Integer.toString((wis - 8) / 2));
            } else {
                mpr++;
            }
        }

        int tmp = (int) (wis / 5) + (int) (level / 40);
        mpr += tmp;
        if (pure_wis >= 25) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][22].setText(Integer.toString(1));
                mpr++;
            }
            mpr++;
            tmp++;
        }
        if (pure_wis >= 35) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][22].setText(Integer.toString(2));
                mpr++;
            }
            mpr++;
            tmp++;
        }
        if (pure_wis >= 45) {
            if (ui.cb_buff[ITEM_BLUE].isSelected()) {
                ui.pure_status_bonus[1][22].setText(Integer.toString(5));
                mpr += 3;
            }
            mpr += 3;
            tmp += 3;
        }

        ui.pure_status_bonus[1][21].setText(Integer.toString(tmp));

        hpr += (con / 2 + level / 20);
        hp_pot = (int) (minasToZero(con - 10) / 10);

        if (pure_con >= 25) {
            hpr++;
        }
        if (pure_con >= 35) {
            hpr++;
            hp_pot++;
        }
        if (pure_con >= 45) {
            hpr += 3;
            hp_pot += 2;
        }
        ui.pure_status_bonus[1][11].setText(Integer.toString(hpr));
        ui.pure_status_bonus[1][12].setText(Integer.toString(hp_pot));

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
            case F:
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
            default:
                break;
        }

        double[] c1 = {1.0, 2.0 / 3.0, 1.5, 2.0, 1.5, 0.7, 1.7, 2.0 / 3.0};
        int[] c2 = {1, 0, 1, 2, 1, 1, 1, 0};

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

            ui.pure_status_bonus[1][10].setText(min + " - " + max);
        } else {
            int min = 1 + (int) ((con + 1) / 2) + _C[HP][CON][cls];
            int max = 2 + (int) ((con + 1) / 2) + _C[HP][CON][cls];

            ui.pure_status_bonus[1][10].setText(min + " - " + max);
        }

        {
            int min = (int) ((int) (wis / 5) * c1[cls]) + c2[cls];
            int max = (int) ((int) (wis / 3) * c1[cls]) + c2[cls];

            ui.pure_status_bonus[1][20].setText(min + " - " + max);
        }

        if (con >= 25) {
            hp += 50;
        }
        if (con >= 35) {
            hp += 100;
        }
        if (con >= 45) {
            hp += 150;
        }

        if (wis >= 25) {
            mp += 50;
        }
        if (wis >= 35) {
            mp += 100;
        }
        if (wis >= 45) {
            mp += 150;
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
            case F:
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
        //�A�h�o���X�h�X�s���b�c ����MP20/20mins
        if (ui.cb_buff[W_ADS].isSelected()) {
            if (ui.cb_buff[F_G].isSelected()
                    || ui.cb_buff[K_PD].isSelected()) {
                ui.cb_buff[W_ADS].setSelected(false);
            } else {
            	hpp += 0.2 * hp;
            	mpp += 0.2 * mp;
                if (ui.cb_buff[W_ADS].getForeground().equals(Color.BLUE)) {
                    cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 20;
                }
            }
        }
        //�v���C�h ����MP10/5mins
        if (ui.cb_buff[K_PD].isSelected()) {
            if (ui.cb_buff[F_G].isSelected()
                    || ui.cb_buff[W_ADS].isSelected()) {
                ui.cb_buff[K_PD].setSelected(false);
            } else {
           	hpp += (level/4)*0.01 * hp;
                if (ui.cb_buff[K_PD].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            }
        }
        //�M�K���e�b�N ����MP10/5mins
        if (ui.cb_buff[F_G].isSelected()) {
            if (ui.cb_buff[W_ADS].isSelected()
                    || ui.cb_buff[K_PD].isSelected()) {
                ui.cb_buff[F_G].setSelected(false);
            } else {
            	hpp += (level/2)*0.01 * hp;
                if (ui.cb_buff[F_G].getForeground().equals(Color.BLUE)) {
                    cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
                }
            }
        }
        
        hp = (int) (hp + eq_hp + hpp);
        mp = (int) (mp + eq_mp + mpp);

        ui.lab_hp.setText(Integer.toString((int) hp));
        ui.lab_mp.setText(Integer.toString((int) mp));
        //���[�r���O�A�N�Z���[�V���� ����MP10/16mins
        //if (ui.cb_buff[D_MA].isSelected()) {
        //    if (ui.cb_buff[D_MA].getForeground().equals(Color.BLUE)) {
        //        cons_mp += (10.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
        //    }
        //}
        //�x�m�����W�X�g ����MP20/5mins
        //if (ui.cb_buff[D_VR].isSelected()) {
        //    if (ui.cb_buff[D_MA].getForeground().equals(Color.BLUE)) {
        //        cons_mp += (20.0 * (1.0 - red_mp * 0.01) - red_mp2) / 5;
        //    }
        //}
        //�G�L�]�`�b�N�o�C�^���C�Y ����MP30/16mins
        if (ui.cb_buff[E_EV].isSelected()) {
            if (ui.cb_buff[E_EV].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
            }
        }
        //�A�f�B�V���i���t�@�C�A�[ ����MP30/16mins
        if (ui.cb_buff[E_AF].isSelected()) {
            if (ui.cb_buff[E_AF].getForeground().equals(Color.BLUE)) {
                cons_mp += (30.0 * (1.0 - red_mp * 0.01) - red_mp2) / 16;
            }
        }
        //2018/09/05 Update�ŃE�C���h�E�H�[�N�͍폜
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
        if (ui.cb_buff[I_IA].isSelected()) {
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
            //buki_text += "�_���[�W" + buki.small + "/" + buki.big;
            buki_text += "�_���[�W" + buki.small + "+" + (buki.enchant + (buki.op2.DMG_SHORT + buki.op2.DMG_LONG)/2) + "/" + buki.big + "+" + (buki.enchant + (buki.op2.DMG_SHORT + buki.op2.DMG_LONG)/2);
        }
        if (buki.two_hands) {
            buki_text += " ���蕐��";
        }
        if (buki.op.DMG_SHORT > 0) {
//            buki_text += " �ߋ����ǉ��_���[�W+" + buki.op.DMG_SHORT;
            buki_text += " �ߋ����_���[�W+" + buki.op.DMG_SHORT;
        }
        if (buki.op.DMG_LONG < 0) {
//            buki_text += " �ߋ����ǉ��_���[�W" + buki.op.DMG_LONG;
            buki_text += " �ߋ����_���[�W" + buki.op.DMG_LONG;
        }
        if (buki.op.HIT_SHORT > 0) {
            buki_text += " �ߋ�������+" + (buki.op.HIT_SHORT + buki.op2.HIT_SHORT);
        }
            if (buki.op.HIT_SHORT < 0) {
            buki_text += " �ߋ�������" + (buki.op.HIT_SHORT + buki.op2.HIT_SHORT);
        }
        if (buki.op.DMG_LONG > 0) {
//            buki_text += " �������ǉ��_���[�W+" + buki.op.DMG_LONG;
            buki_text += " �������_���[�W+" + buki.op.DMG_LONG;
        }
        if (buki.op.DMG_LONG < 0) {
//            buki_text += " �������ǉ��_���[�W" + buki.op.DMG_LONG;
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
