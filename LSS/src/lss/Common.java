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

    //10��̐E��
    final String[] CLASS_LIST = {"P", "K", "E", "W", "D", "R", "I", "S", "F", "L"};
    final String[] CLASS_LIST2 = {"�N��", "�i�C�g", "�G���t", "�E�B�U�[�h", "�_�[�N�G���t", "�h���S���i�C�g", "�C�����[�W���j�X�g", "�E�H���A�[", "�t�F���T�[", "�����T�["};
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

    //4��̑���
    final String[] ELEM_LIST = {"�n", "��", "��", "��"};
    final int EARTH = 0;
    final int FIRE = 1;
    final int WATER = 2;
    final int WIND = 3;

    //13��̕���
    final String[] BUKI_TYPE_LIST = {"�_�K�[", "�Ў茕", "���茕", "�X�^�b�t", "�݊�",
        "�f���A���u���[�h", "�N���E", "��", "�{�E", "�K���g���b�g", "�L�[�����N", "�`�F�[���\�[�h", "�o��"};
    final int W_D = 0;      //�_�K�[
    final int W_LS = 1;     //�Ў茕
    final int W_TS = 2;     //���茕
    final int W_S = 3;      //�X�^�b�t
    final int W_A = 4;      //�݊�
    final int W_DB = 5;     //�f���A���u���[�h
    final int W_C = 6;      //�N���E
    final int W_L = 7;      //��
    final int W_B = 8;      //�{�E
    final int W_G = 9;      //�K���g���b�g
    final int W_K = 10;     //�L�[�����N
    final int W_CS = 11;    //�`�F�[���\�[�h
    final int W_DA = 12;    //�o��
    
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
    final int L99 = 15;             //Hero�p

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

//�G���`�����g(0����161�܂ł̍��v162��)�@UI.java��223�s�ڂ����킹�ĕύX�K�{
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

//�N�喂�@          ���v11���
    final int P_CCA = 142;          //LV85  Call Clan Advance             [UP�҂�]�R�[���N�����A�h�o���X
    final int P_PRE = 110;          //LV85  PRimE                         �v���C��
    final int P_EME = 143;          //LV80  EMpirE                        �G���p�C�A(������)
    final int P_GRE = 87;           //LV80  GRacE                         �O���[�X
    final int P_AUA = 59;           //LV80  AUrA                          �I�[��
    final int P_MAY = 100;          //LV80  MAjestY                       �}�W�F�X�e�B
    final int P_SAR = 99;           //LV80  Shining ArmoR                 �V���C�j���O�A�[�}�[
    final int P_SSD = 9;            //LV75  Shining ShielD                �V���C�j���O�V�[���h
    final int P_BML = 8;            //LV70  Brave MentaL                  �u���C�u�����^��
    final int P_GWN = 7;            //LV60  Glowing WeapoN                �O���[�C���O�E�F�|��
    final int P_TTT = 144;          //LV50  True TargeT                   �g�D���[�^�[�Q�b�g(������)

//�R�m�̋Z�p        ���v12���
    //�A�N�e�B�u�X�L��
    final int K_FSN = 145;          //LV85  Force StaN                    �t�H�[�X�X�^��(������)
    final int K_ABE = 146;          //LV85  Absolute BladE                �A�u�\���[�g�u���C�h(������)
    final int K_CBR = 36;           //LV80  Counter BarrieR               �J�E���^�[�o���A(������)
    final int K_BLK = 89;           //LV75  BLow attacK                   �u���[�A�^�b�N
    final int K_BOK = 65;           //LV65  BOunce attacK                 �o�E���X�A�^�b�N
    final int K_SSN = 147;          //LV60  Shock StaN                    �V���b�N�X�^��(������)
    final int K_PRE = 88;           //LV60  PRidE                         �v���C�h
    final int K_SCE = 35;           //LV55  Solid CarriagE                �\���b�h�L�����b�W
    final int K_RAR = 34;           //LV50  Reduction ArmoR               ���_�N�V�����A�[�}�[
    //�p�b�V�u�X�L��
    final int K_CBV = 73;           //LV85  Counter Barrier:Veteran       �J�E���^�[�o���A:�x�e����(������)
    final int K_RFE = 111;          //LV80  Raging ForcE                  [UP�҂�]���C�W���O�t�H�[�X
    final int K_RAV = 112;          //LV80  Reduction Armor:Veteran       [UP�҂�]���_�N�V�����A�[�}�[:�x�e����

//�G���t�̐��얂�@  20+7+7+6+7=47  ���v47���
    //����      ���v20���
    final int E_GEH = 113;          //LV85  Glory EartH                   �O���[���[�A�[�X(������)
    final int E_ESE = 148;          //LV85  Elven StrikE                  [UP�҂�]�G���u���X�g���C�N
    final int E_REN = 149;          //LV85  REvalatioN                    [UP�҂�]���o���[�V����
    final int E_MSD = 150;          //LV85  Magic ShielD                  [UP�҂�]�}�W�b�N�V�[���h
    final int E_SBR = 151;          //LV80  Seoul BarrieR                 �\�E���o���A(������)
    final int E_ASE = 152;          //LV75  Area SilencE                  �G���A�T�C�����X(������)
    final int E_ELY = 57;           //LV75  ELvengravitY                  �G�������O�����B�e�B�[
    final int E_GEL = 153;          //LV75  Greater ElementaL             �O���[�^�[�G�������^��(������)
    final int E_EMC = 154;          //LV60  Erase MagiC                   �C���[�X�}�W�b�N(������)
    final int E_EFN = 155;          //LV60  Elemental FalldowN            �G�������^���t�H�[���_�E��(������)
    final int E_SLE = 156;          //LV60  Summon Lesser Elemental       �T�������b�T�[�G�������^��(������)
    final int E_TAW = 157;          //LV45  Triple ArroW                  �g���v���A���[(������)
    final int E_BSL = 158;          //LV45  Bloody SouL                   �u���b�f�B�\�E��(������)
    final int E_EPN = 114;          //LV45  Elemental ProtectioN          �G�������^���v���e�N�V����
    final int E_RET = 19;           //LV30  Resist ElemenT                ���W�X�g�G�������g
    final int E_CMD = 12;           //LV30  Clear MinD                    �N���A�}�C���h
    final int E_TTM = 159;          //LV15  Teleport To Mother            �e���|�[�g�g�D�}�U�[(������)
    final int E_BTM = 160;          //LV15  Body To Mind                  �{�f�B�g�D�}�C���h(������)
    final int E_RMC = 20;           //LV15  Resist MagiC                  ���W�X�g�}�W�b�N
    final int E_RTN = 161;          //LV45  Return To Nature              ���^�[���g�D�l�C�`���[(������) 

    //�Όn��    ���v7���
    final int E_INO = 86;           //LV80  INfernO                       �C���t�F���m(������)
    final int E_SOF = 15;           //LV80  Soul Of Flame                 �\�E���I�u�t���C��
    final int E_AFE = 23;           //LV75  Additional FirE               �A�f�B�V���i���t�@�C���[
    final int E_EFE = 11;           //LV75  Elemental FirE                �G�������^���t�@�C�A�[
    final int E_BWN = 17;           //LV75  Burning WeapoN                �o�[�j���O�E�F�|��
    final int E_DBE = 162;          //LV60  Dancing BlazE                 �_���V���O�u���C�Y(��{�G���`�����g��2�i�����Ŏ���)
    final int E_FSD = 163;          //LV45  Fire ShielD                   �t�@�C�A�[�V�[���h(��{�G���`�����g��AC�Ŏ���)

    //���n��    ���v7���
    final int E_PWR = 164;          //LV80  Pollute WateR                 �|���[�g�E�H�[�^�[(������)
    final int E_NBG = 165;          //LV75  Natures BlessinG              �l�C�`���[�Y�u���b�V���O(������)
    final int E_FWE = 166;          //LV60  Focus WavE                    �t�H�[�J�X�E�F�[�u(��{�G���`�����g��2�i�����Ŏ���)
    final int E_APR = 21;           //LV60  Aqua ProtectoR                �A�N�A�v���e�N�^�[
    final int E_NTH = 16;           //LV60  Natures ToucH                 �l�C�`���[�Y�^�b�`
    final int E_WLE = 167;          //LV45  Water LifE                    �E�H�[�^�[���C�t(������)
    final int E_AST = 10;           //LV45  Aqua ShoT                     �A�N�A�V���b�g

    //���n��    ���v6���
    final int E_SGL = 168;          //LV80  Striker GaiL                  �X�g���C�J�[�Q�C��(������)
    final int E_HUE = 169;          //LV75  HUrricanE                     �n���P�[��(��{�G���`�����g��2�i�����Ŏ���)
    final int E_CYE = 85;           //LV75  CYclonE                       �T�C�N����
    final int E_SST = 14;           //LV75  Storm ShoT                    �X�g�[���V���b�g
    final int E_SEE = 13;           //LV60  Storm EyE                     �X�g�[���A�C
    final int E_EEE = 84;           //LV45  Eagle EyE                     �C�[�O���A�C

    //�n�n��    ���v7���
    final int E_EBD = 170;          //LV80  Earth BinD                    �A�[�X�o�C���h(������)
    final int E_EVE = 22;           //LV75  Exotic VitalizE               �G�L�]�`�b�N�o�C�^���C�Y
    final int E_ISN = 171;          //LV75  Iron SkiN                     �A�C�A���X�L��(��{�G���`�����g��AC�Ŏ���)
    final int E_SSM = 172;          //LV60  Sand StorM                    �T���h�X�g�[��(��{�G���`�����g��2�i�����Ŏ���)
    final int E_EGN = 61;           //LV60  Earth GuardiaN                �A�[�X�K�[�f�B�A��
    final int E_QUE = 81;           //LV45  QUakE                         �N�G�C�N
    final int E_EWN = 18;           //LV45  Earth WeapoN                  �A�[�X�E�F�|��

//�E�B�U�[�h�̖��@  8+2+3=84    ���v84���
    //�p�b�V�u    ���v3���
//    final int W_XX = X;           //LV85  Meister Accuracy              �}�C�X�^�[�A�L�����V�[(������)
//    final int W_XX = X;           //LV85  Meditation: BeyonD            ���f�B�e�[�V����:�r�����h(������)
//    final int W_XX = X;           //LV80  Immun To Harm: Saint          �C�~���[���g�D�n�[��:�Z�C���g(������)

    //LV11���@    ���v2���
//    final int W_XX = X;           //LV85  ETernity                      �G�^�j�e�B(������)
//    final int W_XX = X;           //LV85  Mas Immun To                  �}�X�C�~���[���g�D(������)    

    //LV10���@    ���v8���
//    final int W_XX = X;           //LV80  Death Heel                    �f�X�q�[��(������)
//    final int W_XX = X;           //LV80  Meteor Strike                 ���e�I�X�g���C�N(������)
//    final int W_XX = X;           //LV80  Greater Resurrection          �O���[�^�[���U���N�V����(������)
//    final int W_XX = X;           //LV80  Ice Meteor                    �A�C�X���e�I(������)
//    final int W_XX = X;           //LV80  Disintegrate                  �f�B�X�C���e�O���[�g(������)
//    final int W_XX = X;           //LV80  Absolute barrier              �A�u�\���[�g�o���A(������)
    final int W_ADS = 24;           //LV80  Advanced spirits              �A�h�o���X�h�X�s���b�c
//    final int W_XX = X;           //LV80  Ice spike                     �A�C�X�X�p�C�N(������)

    //LV9���@    ���v8���
//    final int W_XX = X;           //LV72  Lightning storm               ���C�g�j���O�X�g�[��(������)
//    final int W_XX = X;           //LV72  Fog of sleeping               �t�H�O�I�u�X���[�s���O(������)
//    final int W_XX = X;           //LV72  Shape change                  �V�F�C�v�`�F���W(������)
//    final int W_XX = X;           //LV72  Immun To Harm                 �C�~���[���g�D�n�[��(������)
//    final int W_XX = X;           //LV72  Massteleport                  �}�X�e���|�[�g(������)
//    final int W_XX = X;           //LV72  Fire storm                    �t�@�C�A�[�X�g�[��(������)
//    final int W_XX = X;           //LV72  Decay potion                  �f�B�P�C�|�[�V����(������)
//    final int W_XX = X;           //LV72  Counter detection             �J�E���^�[�f�B�e�N�V����(������)

    //LV8���@    ���v8���
//    final int W_FHL = X;          //LV64  Full HeeL                     �t���q�[��(������)
//    final int W_FWL = X;          //LV64  Fire WalL                     �t�@�C�A�[�E�H�[��(������)
//    final int W_BLD = X;          //LV64  BLizzarD                      �u���U�[�h(������)
//    final int W_INY = X;          //LV64  INvisibilitY                  �C���r�W�r���e�B�[(������)
//    final int W_REN = X;          //LV64  REsurrectioN                  ���U���N�V����(������)
//    final int W_EAE = X;          //LV64  EArthquakE                    �A�[�X�N�G�C�N(������)
//    final int W_LSM = X;          //LV64  Life StreaM                   ���C�t�X�g���[��(������)
//    final int W_SIE = X;          //LV64  SIlencE                       �T�C�����X(������)

    //LV7���@    ���v8���
//    final int W_HAL = X;          //LV56  Heel AlL                      �q�[���I�[��(������)
    final int W_FAR = 102;          //LV56  Freezing ArmoR                �t���[�W���O�A�[�}�[
//    final int W_SMR = X;          //LV56  Summon MonsteR                �T���������X�^�[(������)
//    final int W_HWK = X;          //LV56  Holy WalK                     �z�[���[�E�H�[�N(������)
//    final int W_TOO = X;          //LV56  TOrnadO                       �g���l�[�h(������)
//    final int W_GHT = X;          //LV56  Greater HeisT                 �O���[�^�[�w�C�X�g(������)
    final int W_BER = 25;           //LV56  BErserkeR                     �o�[�T�[�J�[
    final int W_EAY = 101;          //LV56  Enchant Accuracy              �G���`�����g�A�L�����V�[

    //LV6���@    ���v8���
//    final int W_CZE = X;          //LV48  Create ZombiE                 �N���G�C�g�]���r(������)
//    final int W_PES = X;          //LV48  Physical Enchant:STR          �t�B�W�J���G���`�����g:STR(������)
//    final int W_HET = X;          //LV48  HEisT                         �w�C�X�g(������)
//    final int W_CAN = X;          //LV48  CAncellatioN                  �L�����Z���[�V����(������)
//    final int W_IRN = X;          //LV48  IRaptioN                      �C���v�V����(������)
//    final int W_SUT = X;          //LV48  SUnbursT                      �T���o�[�X�g(������)
//    final int W_WES = X;          //LV48  WEaknesS                      �E�B�[�N�l�X(������)
//    final int W_BWN = X;          //LV48  Breath WeapoN                 �u���X�E�F�|��(������)

    //LV5���@    ���v8���
//    final int W_CPE = X;          //LV40  Curse ParalyzE                �J�[�Y�p�����C�Y(������)
//    final int W_CLG = X;          //LV40  Call LightninG                �R�[�����C�g�j���O(������)
//    final int W_GHL = X;          //LV40  Greater HeeL                  �O���[�^�[�q�[��(������)
//    final int W_TMR = X;          //LV40  Taming MonsteR                �e�C�~���O�����X�^�[(������)
//    final int W_RCE = X;          //LV40  Remove CursE                  �����[�u�J�[�Y(������)
//    final int W_COC = X;          //LV40  Corn Of Cold                  �R�[���I�u�R�[���h(������)
//    final int W_MDN = X;          //LV40  Mana DraiN                    �}�i�h���C��(������)
//    final int W_DAS = X;          //LV40  DArknesS                      �_�[�N�l�X(������)

    //LV4���@    ���v8���
//    final int W_FIL = X;          //LV32  FIrebalL                      �t�@�C�A�[�{�[��(������)
//    final int W_PED = X;          //LV32  Physical Enchant:DEX          �t�B�W�J���G���`�����g:DEX(������)
//    final int W_WBK = X;          //LV32  Weapon BreaK                  �E�F�|���u���C�N(������)
//    final int W_VTH = X;          //LV32  Vampiric ToucH                �o���p�C�A���b�N�^�b�`(������)
//    final int W_THW = X;          //LV32  THroW                         �X���[(������)
//    final int W_EJL = X;          //LV32  Earth JaiL                    �A�[�X�W�F�C��(������)
//    final int W_CMC = X;          //LV32  Counter MagiC                 �J�E���^�[�}�W�b�N(������)
//    final int W_MEN = X;          //LV32  MEditatioN                    ���f�B�e�[�V����(������)

    //LV3���@    ���v7���
//    final int W_LIG = X;          //LV24  LIghtninG                     ���C�g�j���O(������)
//    final int W_TUD = X;          //LV24  Turn UndeaD                   �^�[���A���f�b�h(������)
//    final int W_EHL = X;          //LV24  Extra HeeL                    �G�L�X�g���q�[��(������)
//    final int W_CBD = X;          //LV24  Curse BlinD                   �J�[�Y�u���C���h(������)
    final int W_BAR = 27;           //LV24  Blessed ArmoR                 �u���X�h�A�[�}�[
//    final int W_FCD = X;          //LV24  Frozen ClouD                  �t���[�Y���N���E�h(������)
//    final int W_WEL = X;          //LV24  Week ElementaL                �E�B�[�N�G�������^��(������)

    //LV2���@    ���v8���
//    final int W_CPN = X;          //LV16  Cure PoisoN                   �L���A�|�C�Y��(������)
//    final int W_CRH = X;          //LV16  Chill ToucH                   �`���^�b�`(������)
//    final int W_CPN = X;          //LV16  Cars PoisoN                   �J�[�Y�|�C�Y��(������)
//    final int W_EWN = X;          //LV16  Enchant WeapoN                �G���`�����g�E�F�|��(������)
//    final int W_DEN = X;          //LV16  DEtectioN                     �f�B�e�N�V����(������)
    final int W_DWT = 26;           //LV16  Decrease WeighT               �f�B�N���[�X�E�F�C�g
//    final int W_FAW = X;          //LV16  Fire ArroW                    �t�@�C�A�[�A���[(������)
//    final int W_STK = X;          //LV16  STarracK                      �X�^���b�N(������)

    //LV1���@    ���v8���
//    final int W_HEL = X;          //LV8   HEaL                          �q�[��(������)
//    final int W_LIT = X;          //LV8   LIghT                         ���C�g(������)
//    final int W_SHD = X;          //LV8   SHielD                        �V�[���h(������)
//    final int W_EBT = X;          //LV8   Energy BolT                   �G�l���M�[�{���g(������)
//    final int W_TET = X;          //LV8   TEleporT                      �e���|�[�g(������)
//    final int W_IDR = X;          //LV8   Ice DaggeR                    �A�C�X�_�K�[(������)
//    final int W_WCR = X;          //LV8   Wind CutteR                   �E�B���h�J�b�^�[(������)
//    final int W_HWS = X;          //LV8   Holy WeaponS                  �z�[���[�E�F�|��(������)

//�ł̐��얂�@  9+5+5+5=24  ���v24���
    //LV4���@    ���v9���
    final int D_AVR = 119;          //LV85  AVengeR                       �A�x���W���[(������)
    final int D_SHS = 120;          //LV80  SHadow Step                   [UP�҂�]�V���h�E�X�e�b�v(������)
    final int D_ABK = 121;          //LV80  Armor BreaK                   �A�[�}�[�u���C�N(������)
    final int D_LUR = 122;          //LV80  LUcifeR                       ���V�t�@�[(������)
    final int D_MAM = 173;          //LV85  Moving Acceleration:Maximum   [UP�҂�]���[�r���O�A�N�Z���[�V����:�}�L�V�}��
    final int D_SAD = 174;          //LV85  Shadow Armor:Destiny          �V���h�E�A�[�}�[:�f�X�e�B�j�[
    final int D_LUD = 123;          //LV85  LUcifer:Destiny               ���V�t�@�[:�f�X�e�B�j�[(������)
    final int D_ABD = 124;          //LV85  Armor Break:Destiny           �A�[�}�[�u���C�N:�f�X�e�B�j�[(������)
    final int D_DBD = 28;           //LV80  Double Break:Destiny          �_�u���u���C�N:�f�X�e�B�j�[

    //LV3���@    ���v5���
    final int D_DBK = 29;           //LV60  Double BreaK                  �_�u���u���C�N
    final int D_UDE = 32;           //LV60  Uncanny DodgE                 �A���L���j�[�h�b�W
    final int D_SFG = 175;          //LV60  Shadow FanG                   �V���h�E�t�@���O(��{�G���`�����g�̃L����/����Ŏ���)
    final int D_FBN = 103;          //LV60  Final BurN                    �t�@�C�i���o�[��
    final int D_DEN = 31;           //LV60  Dress EvasioN                 �h���X�C�x�C�W����

    //LV2���@    ���v5���
    final int D_MAN = 79;           //LV40  Moving AcceleratioN           ���[�r���O�A�N�Z���[�V����(������)
    final int D_BSS = 30;           //LV40  Burning SpiritS               �o�[�j���O�X�s���b�c
    final int D_SSP = 176;          //LV40  Shadow SleeP                  �V���h�E�X���[�v(������)
    final int D_VRT = 80;           //LV40  Venom ResisT                  �x�m�����W�X�g(������)
    final int D_DDY = 177;          //LV40  Dress Dexterity               �h���X�f�N�X�^���e�B�[

    //LV1���@    ���v5���
    final int D_BHG = 178;          //LV20  Blind HidinG                  �u���C���h�n�C�f�B���O(������)
    final int D_EVM = 179;          //LV20  Enchantment VenoM             �G���`�����g�x�m��(������)
    final int D_BRE = 180;          //LV20  BRingstonE                    �u�����O�X�g�[��(������)
    final int D_SAR = 33;           //LV20  Shadow ArmoR                  �V���h�E�A�[�}�[
    final int D_DMY = 181;          //LV20  Dress MightY                  �h���X�}�C�e�B�[

//���R�m�̔�Z    ���v22���
    //LV4���@
    final int R_HAS = 116;          //LV85  HAlpaS                        �n���p�X
    final int R_SNE = 181;          //LV80  Solid NotE                    [UP�҂�]�\���b�h�m�[�g
    final int R_RAE = 182;          //LV80  RAmpagE                       [UP�҂�]�����y�C�W
    final int R_AUA = 117;          //LV80  AUrakiA                       �A�E���L�A
    final int R_TGB = 183;          //LV80  Thunder Grap:Brave            �T���_�[�O���b�v:�u���C�u
    final int R_FSB = 60;           //LV85  Four Slayer:Brave             �t�H�[�X���C���[:�u���C�u(������)
    final int R_LINDVIOL = 90;      //LV80  Arousal[LINDVIOL]             �o��[�����h�r�I��]

    //LV3���@
    final int R_MBY = 38;           //LV60  Mortal BodY                   ���[�^���{�f�B�[
    final int R_TGP = 184;          //LV60  Thunder GraP                  �T���_�[�O���b�v
    final int R_DHR = 185;          //LV60  Destroy:HorroR                �f�X�g���C:�z���[
    final int R_EOD = 186;          //LV60  Eye Of Dragon                 �A�C�I�u�h���S��
    final int R_VALAKAS = 41;       //LV60  Arousal[VALAKAS]              �o��[���@���J�X]

    //LV2���@
    final int R_BLT = 187;          //LV40  Blood LasT                    �u���b�h���X�g(��{�G���`�����g��2�i�����Ŏ���)
    final int R_FSR = 188;          //LV40  Four SlayeR                   �t�H�[�X���C���[
    final int R_DFR = 189;          //LV40  Destroy:FeaR                  �f�X�g���C:�t�B�A�[
    final int R_MAW = 190;          //LV40  Magma ArroW                   �}�O�}�A���[
    final int R_FAFURION = 40;      //LV40  Arousal[FAFURION]             �o��[�p�v���I��](������)

    //LV1���@
    final int R_DSN = 37;           //LV20  Dragon SkiN                   �h���S���X�L��
    final int R_BSH = 191;          //LV20  Burning SlasH                 �o�[�j���O�X���b�V��
    final int R_DEY = 192;          //LV20  DEstroY                       �f�X�g���C
    final int R_MBH = 193;          //LV20  Magma BreatH                  �}�O�}�u���X
    final int R_ANTHARAS = 39;      //LV20  Arousal[ANTHARAS]             �o��[�A���^���X]

//�C�����[�W���j�X�g�̌��p���@    ���v26���
    //LV5���@
    final int I_POL = 118;          //LV85  POtentiaL                     �|�e���V����
    final int I_BBR = 194;          //LV85  Bone BreaK:Raster             �{�[���u���C�N:���X�^
    final int I_MES = 195;          //LV85  MEviuS                        ���r�E�X
    final int I_IMT = 92;           //LV80  IMpacT                        �C���p�N�g
    final int I_DHE = 196;          //LV80  Dark HorsE                    �_�[�N�z�[�X(��{�G���`�����g��2�i�����Ŏ���)
    final int I_FSZ = 91;           //LV75  Focus SpitZ                   �t�H�[�J�X�X�s�b�c

    //LV4���@             
    final int I_INS = 46;           //LV60  INsighT                       �C���T�C�g
    final int I_PAC = 197;          //LV60  PAniC                         �p�j�b�N
    final int I_RWT = 62;           //LV60  Reduce WeighT                 ���f���[�X�E�F�C�g
    final int I_IAR = 45;           //LV60  Illusion[AvataR]              �C�����[�W����[�A�o�^�[]
    final int I_CAR = 198;          //LV60  Cube[AvataR]                  �L���[�u[�A�o�^�[]

    //LV3���@     
    final int I_PAE = 47;           //LV45  PAtiencE                      �y�C�V�F���X
    final int I_PHM = 199;          //LV45  PHantasM                      �t�@���^�Y��
    final int I_IBR = 200;          //LV45  Ices BreakeR                  �A�C�Y�u���C�J�[
    final int I_IGM = 44;           //LV45  Illusion[GoleM]               �C�����[�W����[�S�[����]
    final int I_CRH = 201;          //LV45  Cube[RicH]                    �L���[�u[���b�`]

    //LV2���@ 
    final int I_CON = 48;           //LV30  COncentratioN                 �R���Z���g���[�V����
    final int I_MBK = 202;          //LV30  Mind BreaK                    �}�C���h�u���C�N
    final int I_BBK = 203;          //LV30  Bone BreaK                    �{�[���u���C�N
    final int I_IRH = 43;           //LV30  Illusion[RicH]                �C�����[�W����[���b�`]
    final int I_CGM = 204;          //LV30  Cube[GoleM]                   �L���[�u[�S�[����]

    //LV1���@ 
    final int I_MIE = 49;           //LV15  Mirror ImagE                  �~���[�C���[�W
    final int I_CFN = 205;          //LV15  ConFusioN                     �R���t���[�W����
    final int I_SEY = 206;          //LV15  Smash EnergY                  �X�}�b�V���G�l���M�[
    final int I_IOE = 42;           //LV15  Illusion[OgrE]                �C�����[�W����[�I�[�K]
    final int I_COE = 207;          //LV15  Cube[OgrE]                    �L���[�u[�I�[�K]

//�E�H���A�[�̋Z�p    ���v16���
    //�A�N�e�B�u�X�L��
    final int S_DEN = 208;          //LV85  DEmolitioN                    �f�����b�V����
    final int S_BEK = 209;          //LV85  BErserK                       �o�[�T�[�N
    final int S_DEO = 210;          //LV80  DEsperadO                     �f�X�y���[�h
    final int S_TRG = 115;          //LV80  Titan RisinG                  �^�C�^�����C�W���O
    final int S_PGP = 211;          //LV75  Power GriP                    �p���[�O���b�v
    final int S_GIC = 76;           //LV60  GIgantiC                      �M�K���e�B�b�N
    final int S_TOK = 212;          //LV45  TOmahawK                      �g�}�z�[�N
    final int S_HOL = 213;          //LV30  HOwL                          �n�E��

    //�p�b�V�u�X�L��
    final int S_TLK = 69;           //LV75  Titan Lock                    �^�C�^�����b�N
    final int S_TMC = 70;           //LV75  Titan MagiC                   �^�C�^���}�W�b�N
    final int S_TBZ = 71;           //LV80  Titan BlitZ                   �^�C�^���u���b�c
    final int S_SLR = 214;          //LV15  SLayeR                        �X���C���[
    final int S_CRH = 67;           //LV45  CRasH                         �N���b�V��
    final int S_AGD = 66;           //LV60  Armor GuarD                   �A�[�}�[�K�[�h
    final int S_FUY = 68;           //LV60  FUrY                          �t���[���[
    final int S_DAE = 215;          //LV85  Desperado:AbsolutE            �f�X�y���[�h:�A�u�\�����[�g

//�t�F���T�[�̋Z�p    ���v19���
    //  �A�N�e�B�u�X�L��
    final int F_PPH = 216;          //LV80  Phantom:DeatH                 �t�@���g��:�f�X
    final int F_AAA = 217;          //LV85  AshurA                        �A�V����
    final int F_ABE = 218;          //LV60  BladE                         �u���[�h
    final int F_APA = 219;          //LV75  Pantera                       �p���e��
    final int F_AJT = 220;          //LV80  JudgmenT                      �W���b�W�����g
    final int F_AHE = 221;          //LV70  HellfirE                      �w���t�@�C�A
    final int F_APM = 222;          //LV70  PhantoM                       �t�@���g��

    //  �p�b�V�u�X�L��
    final int F_PPR = 223;          //LV80  Phantom:ReapeR                �t�@���g��:���[�p�[
    final int F_PPK = 224;          //LV80  Pantera:ShocK                 �p���e��:�V���b�N
    final int F_PSE = 225;          //LV70  SurvivE                       �T���@�C��
    final int F_PIZ = 104;          //LV75  Infinity:BlitZ                �C���t�B�j�e�B:�u���b�c
    final int F_PPX = 226;          //LV75  ParadoX                       �p���h�b�N�X
    final int F_PIE = 105;          //LV70  Infinity:DodgE                �C���t�B�j�e�B:�h�b�W
    final int F_PGE = 227;          //LV60  GrousE                        �O���[�X
    final int F_PID = 106;          //LV60  Infinity:BlooD                �C���t�B�j�e�B:�u���b�h
    final int F_PRE = 107;          //LV60  RagE                          ���C�W
    final int F_PIR = 108;          //LV45  Infinity:ArmoR                �C���t�B�j�e�B:�A�[�}�[
    final int F_PFE = 109;          //LV45  FramE                         �t���C��
    final int F_PDS = 125;          //LV45  DamascuS                      �_�}�X�J�X

//�����T�[�̑��p    ���v14���
    //  �A�N�e�B�u�X�L��
    final int L_PDR = 140;          //LV85  Pressure:Death Recall         �v���b�V���[:�f�X���R�[��
    final int L_REY = 130;          //LV75  REcoverY                      ���J�o���[
    final int L_KUU = 132;          //LV80  KUruorU                       �N���I��
    final int L_PRE = 131;          //LV75  PRessurE                      �v���b�V���[
    final int L_VAD = 129;          //LV70  VAnguarD                      ���@���K�[�h
    final int L_FWE = 128;          //LV60  Force WavE                    �t�H�[�X�E�F�[�u
    final int L_ALE = 127;          //LV50  ALternatE                     �I���^�l�[�g

    //  �p�b�V�u�X�L��
    final int L_KCN = 139;          //LV80  Kuruoru:CombinatioN           �N���I��:�R���r�N�V����
    final int L_IRE = 138;          //LV80  Increase RangE                �C���N���[�Y�����W
    final int L_MAM = 137;          //LV75  MAelstroM                     �}�G���X�g���[��
    final int L_DBE = 136;          //LV75  Dodge BrakE                   �h�b�W�u���[�L
    final int L_VEE = 134;          //LV70  VEngeancE                     �x���W�F���X
    final int L_TAE = 135;          //LV70  Tactical AdvancE              �^�N�e�B�J���A�h�o���X
    final int L_DSE = 133;          //LV65  Deadly StrikE                 �f�b�h���[�X�g���C�N

//���̑�
    final int DRAGON_BLESS = 126;   //�h���S���̏j��
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
    final int H_RKT = 141;          //�e�N���X��1��

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
    String[] EQ_ELEM_LIST = {"������", "�n��:1�i", "�n��:2�i", "�n��:3�i", "�n��:4�i",
        "�n��:5�i", "�Η�:1�i", "�Η�:2�i", "�Η�:3�i", "�Η�:4�i", "�Η�:5�i", "����:1�i",
        "����:2�i", "����:3�i", "����:4�i", "����:5�i", "����:1�i", "����:2�i", "����:3�i",
        "����:4�i", "����:5�i"};

//T�V���c�̋����l
    String[] EQ_TS_LIST = {"0�i�K", "1�i�K", "2�i�K", "3�i�K", "4�i�K", "5�i�K"};
}
