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

    //6��̃X�e�[�^�X
    final String[] ST_LIST = {"STR", "DEX", "INT", "WIS", "CON", "CHA"};
    final int STR = 0;
    final int DEX = 1;
    final int INT = 2;
    final int WIS = 3;
    final int CON = 4;
    final int CHA = 5;

    //9��̐E��
    final String[] CLASS_LIST = {"P", "K", "E", "W", "D", "R", "I", "S", "F"};
    final String[] CLASS_LIST2 = {"�N��", "�i�C�g", "�G���t", "�E�B�U�[�h", "�_�[�N�G���t", "�h���S���i�C�g", "�C�����[�W���j�X�g", "�E�H���A�[", "�t�F���T�["};
    final int P = 0;
    final int K = 1;
    final int E = 2;
    final int W = 3;
    final int D = 4;
    final int R = 5;
    final int I = 6;
    final int S = 7;
    final int F = 8;

    //4��̑���
    final String[] ELEM_LIST = {"�n", "��", "��", "��"};
    final int EARTH = 0;
    final int FIRE = 1;
    final int WATER = 2;
    final int WIND = 3;

    //13��̕���
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
    final int L99 = 14;             //Hero�p

    //�p�l��1�̃A�~�����b�g/�C�A�����O/�����O/�C���V�O�j�A/�X�|�[���_�[/���/�y���_���g���̏��ƈʒu
    final String[] EQ_LIST = {"����", "����", "�V�[���h", "�w����", "�O���[�u", "�V���c",
        "�A�[�}�[", "�N���[�N", "�u�[�c", "�Q�[�g��", "�x���g", "�A�~�����b�g", "�C�A�����O", "�C�A�����O", "�����O", "�����O",
        "�����O", "�����O", "�C���V�O�j�A", "�X�|�[���_�[", "���", "�y���_���g"};
    
    final int RING1 = 14;
    final int RING2 = 15;
    final int RING3 = 16;
    final int RING4 = 17;

    final int EARRING1 = 11;
    final int EARRING2 = 12;

//�G���`�����g(0����103�܂ł̍��v104��)�@UI.java��217�s�ڂ����킹�ĕύX�K�{
//���ݒ��119�܂ł�120�ŏ���
//��{�G���`�����g
    final int ACC1 = 0;             //1�i����
    final int ACC2 = 1;             //2�i����
    final int ACC3 = 2;             //3�i����
    final int B_STR = 3;            //STR
    final int B_DEX = 4;            //DEX
    final int B_AC = 5;             //AC
    final int BUKI = 6;             //����G���`�����@
    final int SEC = 75;             //�Z�L�����e�B
    final int VIP = 72;             //VIP�G���`�����g

//�N��̖��@ ���v10���
    final int P_PRE = 110;          //PRimE                         �v���C��
//    final int P_EME = X;          //EMpirE                        �G���p�C�A(������)
    final int P_GRE = 87;           //GRacE                         �O���[�X(�O���[�X�A�o�^�[)
    final int P_AUA = 59;           //AUrA                          �I�[��(�u���C�u�A�o�^�[)
    final int P_MAY = 100;          //MAjestY                       �}�W�F�X�e�B
    final int P_SAR = 99;           //Shining ArmoR                 �V���C�j���O�A�[�}�[
    final int P_SSD = 9;            //Shining ShielD                �V���C�j���O�V�[���h
    final int P_BML = 8;            //Brave MentaL                  �u���C�u�����^��
    final int P_GWN = 7;            //Glowing WeapoN                �O���[�C���O�E�F�|��
//    final int P_TTT = X;          //True TargeT                   �g�D���[�^�[�Q�b�g(������)

//�i�C�g�̋Z�p
    //�A�N�e�B�u�X�L��
//    final int K_FSN = X;          //Force StaN                    �t�H�[�X�X�^��(������)
//    final int K_ABE = X;          //Absolute BladE                �A�u�\���[�g�u���C�h(������)
    final int K_CBR = 36;           //Counter BarrieR               �J�E���^�[�o���A(������)
    final int K_BLK = 89;           //BLow attacK                   �u���[�A�^�b�N
    final int K_BOK = 65;           //BOunce attacK                 �o�E���X�A�^�b�N
//    final int K_SSN = X;          //Shock StaN                    �V���b�N�X�^��(������)
    final int K_PRE = 88;           //PRidE                         �v���C�h
    final int K_SCE = 35;           //Solid CarriagE                �\���b�h�L�����b�W
    final int K_RAR = 34;           //Reduction ArmoR               ���_�N�V�����A�[�}�[
    //�p�b�V�u�X�L��
    final int K_CBV = 73;           //Counter Barrier:Veteran       �J�E���^�[�o���A:�x�e����
    final int K_RFE = 111;          //Raging ForcE                  ���C�W���O�t�H�[�X
    final int K_RAV = 112;          //Reduction Armor:Veteran       ���_�N�V�����A�[�}�[:�x�e����

//�G���t�̐��얂�@
    //����
//    final int E_MAE = X;          //MArblE                        �}�[�u��(������)
    final int E_GEH = 113;          //Glory EartH                   �O���[���[�A�[�X(������)
//    final int E_SBR = X;          //Seoul BarrieR                 �\�E���o���A(������)
//    final int E_ASE = X;          //Area SilencE                  �G���A�T�C�����X(������)
    final int E_ELY = 57;           //ELvengravitY                  �G�������O�����B�e�B�[
//    final int E_GEL = X;          //Greater ElementaL             �O���[�^�[�G�������^��(������)
//    final int E_EMC = X;          //Erase MagiC                   �C���[�X�}�W�b�N(������)
//    final int E_EFN = X;          //Elemental FalldowN            �G�������^���t�H�[���_�E��(������)
//    final int E_SLE = X;          //Summon Lesser Elemental       �T�������b�T�[�G�������^��(������)
//    final int E_TAW = X;          //Triple ArroW                  �g���v���A���[(������)
//    final int E_BSL = X;          //Bloody SouL                   �u���b�f�B�\�E��(������)
    final int E_EPN = 114;          //Elemental ProtectioN          �G�������^���v���e�N�V����(������)
    final int E_RET = 19;           //Resist ElemenT                ���W�X�g�G�������g
    final int E_CMD = 12;           //Clear MinD                    �N���A�}�C���h
//    final int E_TTM = X;          //Teleport To Mother            �e���|�[�g�g�D�}�U�[(������)
//    final int E_BTM = X;          //Body To Mind                  �{�f�B�g�D�}�C���h(������)
    final int E_RMC = 20;           //Resist MagiC                  ���W�X�g�}�W�b�N

    //�Όn��
    final int E_INO = 86;           //INfernO                       �C���t�F���m(������)
    final int E_SOF = 15;           //Soul Of Flame                 �\�E���I�u�t���C��
    final int E_AFE = 23;           //Additional FirE               �A�f�B�V���i���t�@�C���[
    final int E_EFE = 11;           //Elemental FirE                �G�������^���t�@�C�A�[
    final int E_BWN = 17;           //Burning WeapoN                �o�[�j���O�E�F�|��
//    final int E_DBE = X;          //Dancing BlazE                 �_���V���O�u���C�Y(��{�G���`�����g��2�i�����Ŏ���)
//    final int E_FSD = X;          //Fire ShielD                   �t�@�C�A�[�V�[���h(��{�G���`�����g��AC�Ŏ���)

    //���n��
//    final int E_PWR = X;          //Pollute WateR                 �|���[�g�E�H�[�^�[(������)
//    final int E_NBG = X;          //Natures BlessinG              �l�C�`���[�Y�u���b�V���O(������)
//    final int E_FWE = X;          //Focus WavE                    �t�H�[�J�X�E�F�[�u(��{�G���`�����g��2�i�����Ŏ���)
    final int E_APR = 21;           //Aqua ProtectoR                �A�N�A�v���e�N�^�[
    final int E_NTH = 16;           //Natures ToucH                 �l�C�`���[�Y�^�b�`
//    final int E_WLE = X;          //Water LifE                    �E�H�[�^�[���C�t(������)
    final int E_AST = 10;           //Aqua ShoT                     �A�N�A�V���b�g

    //���n��
//    final int E_SGL = X;          //Striker GaiL                  �X�g���C�J�[�Q�C��(������)
//    final int E_HUE = X;          //HUrricanE                     �n���P�[��(��{�G���`�����g��2�i�����Ŏ���)
    final int E_CYE = 85;           //CYclonE                       �T�C�N����
    final int E_SST = 14;           //Storm ShoT                    �X�g�[���V���b�g
    final int E_SEE = 13;           //Storm EyE                     �X�g�[���A�C
    final int E_EEE = 84;           //Eagle EyE                     �C�[�O���A�C

    //�n�n��
//    final int E_XX = X;           //Earth BinD                    �A�[�X�o�C���h(������)
    final int E_EVE = 22;           //Exotic VitalizE               �G�L�]�`�b�N�o�C�^���C�Y
//    final int E_XX = X;           //Iron SkiN                     �A�C�A���X�L��(��{�G���`�����g��AC�Ŏ���)
//    final int E_XX = X;           //Sand StorM                    �T���h�X�g�[��(��{�G���`�����g��2�i�����Ŏ���)
    final int E_EGN = 61;           //Earth GuardiaN                �A�[�X�K�[�f�B�A��
    final int E_QUE = 81;           //QUakE                         �N�G�C�N
    final int E_EWN = 18;           //Earth WeapoN                  �A�[�X�E�F�|��

//�E�B�U�[�h�̖��@
    //LV10���@
    final int W_ADS = 24;           //�A�h�o���X�h�X�s���b�c

    //LV9���@

    //LV8���@
    
    //LV7���@
    final int W_FA = 102;           //�t���[�W���O�A�[�}�[
    final int W_BSK = 25;           //�o�[�T�[�J�[
    final int W_EA = 101;           //�G���`�����g�A�L�����V�[

    //LV6���@

    //LV5���@

    //LV4���@

    //LV3���@
    final int W_BA = 27;            //�u���X�h�A�[�}�[

    //LV2���@
    final int W_DW = 26;            //�f�B�N���[�X�E�F�C�g

    //LV1���@

//�_�[�N�G���t�̈ł̐��얂�@
    //LV4���@
//    final int D_XX = X;           //�A�x���W���[(������)
//    final int D_XX = X;           //�V���h�E�X�e�b�v(������)
//    final int D_XX = X;           //�A�[�}�[�u���C�N(������)
//    final int D_XX = X;           //���V�t�@�[(������)
//    final int D_XX = X;           //���V�t�@�[:�f�X�e�B�j�[(������)
    final int D_DB2 = 28;           //�_�u���u���C�N:�f�X�e�B�j�[
//    final int D_XX = X;           //�A�[�}�[�u���C�N:�f�X�e�B�j�[(������)

    //LV3���@
    final int D_DB = 29;            //�_�u���u���C�N
    final int D_UD = 32;            //�A���L���j�[�h�b�W
//    final int D_XX = X;           //�V���h�E�t�@���O(������)
    final int D_FB = 103;           //�t�@�C�i���o�[��
    final int D_DE = 31;            //�h���X�C�x�C�W����
    
    //LV2���@
    final int D_MA = 79;            //���[�r���O�A�N�Z���[�V����(������)
    final int D_BS = 30;            //�o�[�j���O�X�s���b�c
//    final int D_XX = X;           //�V���h�E�X���[�v(������)
    final int D_VR = 80;            //�x�m�����W�X�g(������)

    //LV1���@
//    final int D_XX = X;           //�u���C���h�n�C�f�B���O(������)
//    final int D_XX = X;           //�G���`�����g�x�m��(������)
//    final int D_XX = X;           //�u�����O�X�g�[��(������)
    final int D_SA = 33;            //�V���h�E�A�[�}�[
//    final int D_XX = X;           //�h���X�}�C�e�B�[(������)

//�h���S���i�C�g�̔�Z
    //LV4���@
    final int R_HAS = 116;          //HAlpaS                        �n���p�X
    final int R_LINDVIOL = 90;      //Arousal[LINDVIOL]             �o��[�����h�r�I��]
    final int R_AUA = 117;          //AUrakiA                       �A�E���L�A
//    final int R_TGB = X;          //Thunder Grap:Brave            �T���_�[�O���b�v:�u���C�u
    final int R_FSB = 60;           //Four Slayer:Brave             �t�H�[�X���C���[:�u���C�u(������)

    //LV3���@
    final int R_MBY = 38;           //Mortal BodY                   ���[�^���{�f�B�[
//    final int R_TGP = X;          //Thunder GraP                  �T���_�[�O���b�v
//    final int R_DHR = X;          //Destroy:HorroR                �f�X�g���C:�z���[
//    final int R_EOD = X;          //Eye Of Dragon                 �A�C�I�u�h���S��
    final int R_VALAKAS = 41;       //Arousal[VALAKAS]              �o��[���@���J�X]

    //LV2���@
//    final int R_BLT = X;          //Blood LasT                    �u���b�h���X�g(��{�G���`�����g��2�i�����Ŏ���)
//    final int R_FSR = X;          //Four SlayeR                   �t�H�[�X���C���[
//    final int R_DFR = X;          //Destroy:FeaR                  �f�X�g���C:�t�B�A�[
//    final int R_MAW = X;          //Magma ArroW                   �}�O�}�A���[
    final int R_FAFURION = 40;      //Arousal[FAFURION]             �o��[�p�v���I��](������)

    //LV1���@
    final int R_DSN = 37;           //Dragon SkiN                   �h���S���X�L��
//    final int R_BSH = X;          //Burning SlasH                 �o�[�j���O�X���b�V��
//    final int R_DEY = X;          //DEstroY                       �f�X�g���C
//    final int R_MBH = X;          //Magma BreatH                  �}�O�}�u���X
    final int R_ANTHARAS = 39;      //Arousal[ANTHARAS]             �o��[�A���^���X]

//�C�����[�W���j�X�g�̌��p���@
    //LV5���@
    final int I_POL = 118;          //POtentiaL                     �|�e���V����
//    final int I_MES = X;          //MEviuS                        ���r�E�X
    final int I_IMT = 92;           //IMpacT                        �C���p�N�g
//    final int I_DHE = X;          //Dark HorsE                    �_�[�N�z�[�X(��{�G���`�����g��2�i�����Ŏ���)
    final int I_FSZ = 91;           //Focus SpitZ                   �t�H�[�J�X�X�s�b�c

    //LV4���@             
    final int I_INS = 46;           //INsighT                       �C���T�C�g
//    final int I_PAC = X;          //PAniC                         �p�j�b�N
    final int I_RWT = 62;           //Reduce WeighT                 ���f���[�X�E�F�C�g
    final int I_IAR = 45;           //Illusion[AvataR]              ���p[�A�o�^�[]
//    final int I_CAR = X;          //Cube[AvataR]                  �L���[�u[�A�o�^�[]

    //LV3���@     
    final int I_PAE = 47;           //PAtiencE                      �y�C�V�F���X
//    final int I_PHM = X;          //PHantasM                      �t�@���^�Y��
//    final int I_EBR = X;          //Eyes BreakeR                  �A�C�Y�u���C�J�[
    final int I_IGM = 44;           //Illusion[GoleM]               ���p[�S�[����]
//    final int I_CRH = X;          //Cube[RicH]                    �L���[�u[���b�`]

    //LV2���@ 
    final int I_CON = 48;           //COncentratioN                 �R���Z���g���[�V����
//    final int I_MBK = X;          //Mind BreaK                    �}�C���h�u���C�N
//    final int I_BBK = X;          //Bone BreaK                    �{�[���u���C�N
    final int I_IRH = 43;           //Illusion[RicH]                ���p[���b�`]
//    final int I_CGM = X;          //Cube[GoleM]                   �L���[�u[�S�[����]

    //LV1���@ 
    final int I_MIE = 49;           //Mirror ImagE                  �~���[�C���[�W
//    final int I_CFN = X;          //ConFusioN                     �R���t���[�W����
//    final int I_SEY = X;          //Smash EnergY                  �X�}�b�V���G�l���M�[
    final int I_IOE = 42;           //Illusion[OgrE]                ���p[�I�[�K]
//    final int I_COE = X;          //Cube[OgrE]                    �L���[�u[�I�[�K]

//�E�H���A�[�̋Z�p
    //�A�N�e�B�u�X�L��
//    final int S_DEN = X;          //DEmolitioN                    �f�����b�V����
//    final int S_DEO = X;          //DEsperadO                     �f�X�y���[�h
    final int S_TRG = 115;          //Titan RisinG                  �^�C�^�����C�W���O
//    final int S_PGP = X;          //Power GriP                    �p���[�O���b�v
    final int S_GIC = 76;           //GIgantiC                      �M�K���e�B�b�N
//    final int S_TOK = X;          //TOmahawK                      �g�}�z�[�N
//    final int S_HOL = X;          //HOwL                          �n�E��

    //�p�b�V�u�X�L��
    final int S_TLK = 69;           //Titan Lock                    �^�C�^�����b�N
    final int S_TMC = 70;           //Titan MagiC                   �^�C�^���}�W�b�N
    final int S_TBZ = 71;           //Titan BlitZ                   �^�C�^���u���b�c     
//    final int S_SLR = X;          //SLayeR                        �X���C���[
    final int S_CRH = 67;           //CRasH                         �N���b�V��
    final int S_AGD = 66;           //Armor GuarD                   �A�[�}�[�K�[�h
    final int S_FUY = 68;           //FUrY                          �t���[���[
//    final int S_DAE = X;          //Desperado:AbsolutE            �f�X�y���[�h:�A�u�\�����[�g

//�t�F���T�[�̋Z�p
//  �A�N�e�B�u�X�L��
//    final int F_AAA = XXX;        //AshurA                        �A�V����
//    final int F_ABE = XXX;        //BladE                         �u���[�h
//    final int F_APA = XXX;        //Pantera                       �p���e��
//    final int F_AJT = XXX;        //JudgmenT                      �W���b�W�����g
//    final int F_AHE = XXX;        //HellfirE                      �w���t�@�C�A
//    final int F_APM = XXX;        //PhantoM                       �t�@���g��
//  �p�b�V�u�X�L��
//    final int F_PPH = XXX;        //Phantom:DeatH                 �t�@���g��:�f�X
//    final int F_PPR = XXX;        //Phantom:ReapeR                �t�@���g��:���[�p�[
//    final int F_PPK = XXX;        //Pantera:ShocK                 �p���e��:�V���b�N
//    final int F_PSE = XXX;        //SurvivE                       �T���@�C��
    final int F_PIZ = 104;          //Infinity:BlitZ                �C���t�B�j�e�B:�u���b�c
//    final int F_PPX = XXX;        //ParadoX                       �p���h�b�N�X
    final int F_PIE = 105;          //Infinity:DodgE                �C���t�B�j�e�B:�h�b�W
//    final int F_PGE = XXX;        //GrousE                        �O���E�X
    final int F_PID = 106;          //Infinity:BlooD                �C���t�B�j�e�B:�u���b�h
    final int F_PRE = 107;          //RagE                          ���C�W
    final int F_PIR = 108;          //Infinity:ArmoR                �C���t�B�j�e�B:�A�[�}�[
    final int F_PFE = 109;          //FramE                         �t���C��
//    final int F_PDS = XXX;        //DamascuS                      �_�}�X�J�X

//���̑�
    final int ITEM_BLUE = 50;       //���͉񕜃|�[�V����
    final int ITEM_WIZP = 51;       //�E�B�Y�_���|�[�V����
    final int ITEM_COOKING = 54;    //����
    final int ITEM_DESSERT = 55;    //�f�U�[�g
    final int ITEM_BREEZE = 52;     //�����̗�
    final int ITEM_SEA = 53;        //�[�C�̗�
    final int ITEM_MD = 56;         //�}�W�b�N�h�[��
    final int ITEM_MD_OP = 64;      //�p�b�N/�p�I OP
    final int KOMA = 58;            //�R�}�̃G���`��
    final int ITEM_MAGAN = 98;      //����
    final int CLAY = 77;            //�N���C
    final int MOMIJI = 78;          //���݂������O
    final int BUFF_COIN = 63;       //�o�t�R�C��
    final int BS_COIN = 82;         //���ւ̃R�C��
    final int MBSC = 74;            //�^�S�̂��������j���X�N���[��
    final int L_HST = 83;           //�����̉ʎ�
    final int H_HP = 93;            //�����̃{�[�i�X
    final int H_AC = 94;            //�S�b�̃{�[�i�X
    final int H_PVPDR = 95;         //�����̃{�[�i�X
    final int H_PVP = 96;           //�ÎE�̃{�[�i�X
    final int H_RK = 97;            //�����J�[�{�[�i�X
    
    final String[] AILMENT_LIST = {"�Z�p����", "�Z�p�ϐ�", "���얽��", "����ϐ�", "��Z����","��Z�ϐ�", "���|����", "���|�ϐ�"};
//    final String[] AILMENT_LIST = {"�Z�p", "�Z�p", "����", "����", "��Z","��Z", "���|", "���|"};
    final int HIT_STUN = 0;
    final int STUN = 1;
    final int HIT_SPIRIT = 2;
    final int SPIRIT = 3;
    final int HIT_SECRET = 4;
    final int SECRET = 5;
    final int HIT_TERROR = 6;
    final int TERROR = 7; 

    final String[] ENEMY_TYPE_LIST = {"�ʏ�", "����", "�s��"};
    final int NORMAL = 0;
    final int CURSED = 1;
    final int UNDEAD = 2;

//�����l
    String[] EQ_EN_LIST = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
        "9", "10", "11", "12", "13", "14", "15"};

//��������
    String[] EQ_ELEM_LIST = {"������", "�Η�:1�i", "�Η�:2�i", "�Η�:3�i", "�Η�:4�i",
        "�Η�:5�i", "����:1�i", "����:2�i", "����:3�i", "����:4�i", "����:5�i", "����:1�i",
        "����:2�i", "����:3�i", "����:4�i", "����:5�i", "�n��:1�i", "�n��:2�i", "�n��:3�i",
        "�n��:4�i", "�n��:5�i"};

//T�V���c�̋����l
    String[] EQ_TS_LIST = {"0�i�K", "1�i�K", "2�i�K", "3�i�K", "4�i�K", "5�i�K"};
}
