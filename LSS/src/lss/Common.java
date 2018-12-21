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
    final String[] CLASS_LIST2 = {"�N��", "�i�C�g", "�G���t", "�E�B�U�[�h", "�_�[�N�G���t", "�h���S���i�C�g", "�C�����[�W���j�X�g", "�E�H���A�["};
    final int P = 0;
    final int K = 1;
    final int E = 2;
    final int W = 3;
    final int D = 4;
    final int R = 5;
    final int I = 6;
    final int F = 7;

    //final String[] ELEM_LIST = {"��", "��", "��", "�n"};
    final String[] ELEM_LIST = {"�Α���", "������", "������", "�n����"};
    final int FIRE = 0;
    final int WATER = 1;
    final int WIND = 2;
    final int EARTH = 3;

    final String[] BUKI_TYPE_LIST = {"�_�K�[", "�Ў茕", "���茕", "�X�^�b�t", "�݊�",
        "�f���A���u���[�h", "�N���E", "��", "�{�E", "�K���g���b�g", "�L�[�����N", "�`�F�[���\�[�h", "�o��"};
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
    final int L99 = 14;         //Hero�p

    //final String[] EQ_LIST = {"����", "����", "�V�[���h", "�w����", "�O���[�u", "�V���c",
    //    "�A�[�}�[", "�N���[�N", "�u�[�c", "�Q�[�g��", "�x���g", "�C�A�����O", "�C�A�����O", "�A�~�����b�g", "�����O", "�����O",
    //    "�����O", "�����O", "���[��", "���[��","�h����","�G���u����"};
    //�p�l��1�̃A�~�����b�g�A�C�A�����O�̓��͈ʒu�̕ύX�y�у��[���A�h�����A�G���u�����̏���ύX
    final String[] EQ_LIST = {"����", "����", "�V�[���h", "�w����", "�O���[�u", "�V���c",
        "�A�[�}�[", "�N���[�N", "�u�[�c", "�Q�[�g��", "�x���g", "�A�~�����b�g", "�C�A�����O", "�C�A�����O", "�����O", "�����O",
        "�����O", "�����O", "�C���V�O�j�A", "�X�|�[���_�[","���"};
    
    final int RING1 = 14;
    final int RING2 = 15;
    final int RING3 = 16;
    final int RING4 = 17;

    final int EARRING1 = 11;
    final int EARRING2 = 12;

    // �G���`�����g��ID
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
    //final int E_WS = 10;      //�E�B���h�V���b�g
    final int E_AS = 10;        //�A�N�A�V���b�g
    final int E_EF = 11;
    final int E_CM = 12;
    final int E_SE = 13;        //�X�g�[���A�C
    final int E_SS = 14;        //�X�g�[���V���b�g
    final int E_SF = 15;        //�\�E���I�u�t���C��
    final int E_NT = 16;        //�l�C�`���[�Y�^�b�`
    final int E_BW = 17;        //�o�[�j���O�E�F�|��
    //final int E_FW = 18;      //�t�@�C�A�[�E�F�|��
    final int E_EW = 18;        //�A�[�X�E�F�|��
    final int E_RE = 19;
    final int E_RM = 20;
    final int E_AP = 21;        //�A�N�A�v���e�N�^�[
    final int E_EV = 22;        //�G�L�]�`�b�N�o�C�^���C�Y
    final int E_AF = 23;        //�A�f�B�V���i���t�@�C���[
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
    final int DRAGON = 57;      //������(�\��)
    final int KOMA = 58;
    final int P_BA = 59;
    final int E_DB = 60;
    final int E_EG = 61;        //�A�[�X�K�[�f�B�A��
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
    
    //final int E_WW = 81;      //�E�B���h�E�H�[�N
    final int E_QE = 81;        //�N�G�C�N
    
    final int BS_COIN = 82;
    //y_ikeda����ɂ��C�����Q�l��
    final int L_HST = 83;       //�����̉ʎ�
    final int E_EE = 84;        //�C�[�O���A�C
    final int E_CE = 85;        //�T�C�N����(������)
    final int E_IO = 86;        //�C���t�F���m(������)
    final int P_GA = 87;        //�O���[�X�A�o�^�[(������)
    final int K_PD = 88;        //�v���C�h(������)
    final int K_BK = 89;        //�u���[�A�^�b�N(������)
    final int R_LINDVIOL = 90;  //�o��[�����h�r�I��](������)
    final int I_FS = 91;        //�t�H�[�J�X�X�s�b�c(������)
    final int I_IT = 92;        //�C���p�N�g(������)
    final int H_HP = 93;        //�����̃{�[�i�X(������)
    final int H_AC = 94;        //�S�b�̃{�[�i�X(������)
    final int H_PVPDR = 95;     //�����̃{�[�i�X(������)
    final int H_PVP = 96;       //�ÎE�̃{�[�i�X(������) 
    final int H_RK = 97;        //�����J�[�{�[�i�X(������)     

//    final String[] AILMENT_LIST = {"�Ή�", "����", "����", "�È�", "�C��", "�S��", "���|"};
    final String[] AILMENT_LIST = {"�Ή��ϐ�", "�����ϐ�", "�����ϐ�", "�Èőϐ�", "�C��ϐ�", "�S���ϐ�", "���|�ϐ�","�j��ϐ�","�Ή�����", "��������", "��������", "�ÈŖ���", "�C�▽��", "�S������", "���|����","�j�󖽒�"};
    final int STONE = 0;
    final int SLEEP = 1;
    final int FREEZE = 2;
    final int DARKNESS = 3;
    final int STUN = 4;
    final int HOLD = 5;
    final int TERROR = 6;
    final int DESTRUCTION = 7;
    final int HIT_STONE = 8;
    final int HIT_SLEEP = 9;
    final int HIT_FREEZE = 10;
    final int HIT_DARKNESS = 11;
    final int HIT_STUN = 12;
    final int HIT_HOLD = 13;
    final int HIT_TERROR = 14;
    final int HIT_DESTRUCTION = 15;
//    final int DRAGON = 16;
//    final int HIT_DRAGON = 17;
//    final int SPIRIT = 18;
//    final int HIT_SPIRIT = 19;   

    final String[] ENEMY_TYPE_LIST = {"�ʏ�", "����", "�s��"};
    final int NORMAL = 0;
    final int CURSED = 1;
    final int UNDEAD = 2;

    String[] EQ_EN_LIST = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
        "9", "10", "11", "12", "13", "14", "15"};
    String[] EQ_ELEM_LIST = {"������", "�Η�:1�i", "�Η�:2�i", "�Η�:3�i", "�Η�:4�i",
        "�Η�:5�i", "����:1�i", "����:2�i", "����:3�i", "����:4�i", "����:5�i", "����:1�i",
        "����:2�i", "����:3�i", "����:4�i", "����:5�i", "�n��:1�i", "�n��:2�i", "�n��:3�i",
        "�n��:4�i", "�n��:5�i"};

    String[] EQ_TS_LIST = {"0�i�K", "1�i�K", "2�i�K", "3�i�K", "4�i�K", "5�i�K"};
}
