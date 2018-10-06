package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Bougu implements Common {

    Buff op = new Buff();
    Buff op2 = new Buff();
    String name = "";
    String type = "";
    String material = "";
    String equip = "";
    String grade = "";
    int enchant = 0;
    int max_enchant = 0;
    int safety = 0;
    int mr_enchant = 0;
    boolean element_enchant = false;
    String tokusei = "";

    void reset() {

        op = new Buff();
        op2 = new Buff();
        name = "";
        type = "";
        material = "";
        equip = "";
        grade = "";
        enchant = 0;
        safety = 0;
        mr_enchant = 0;
        element_enchant = false;
        tokusei = "";
    }

    public void load(BufferedReader reader) {
        reset();
        if (reader == null) {
            return;
        }
        try {
            reader.mark(1000000);
            reader.reset();
            op.loadOption(reader);
            reader.reset();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("equip=")) {
                    equip = line.split("=")[1];
                }
                if (line.startsWith("name=")) {
                    name = line.split("=")[1];
                }
                if (line.startsWith("���S=")) {
                    safety = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("�������E=")) {
                    max_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("type=")) {
                    type = line.split("=")[1];
                }
                if (line.startsWith("�ގ�=")) {
                    material = line.split("=")[1];
                }
                if (line.startsWith("�O���[�h=")) {
                    grade = line.split("=")[1];
                }
                if (line.startsWith("MR����=")) {
                    mr_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("��͋���=")) {
                    element_enchant = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("����=")) {
                    tokusei = line.split("=")[1];
                }
            }
        } catch (IOException | NullPointerException e) {
            System.out.println(e);
        }
    }

    public String getText() {
        String text = "";
        text += "AC" + (op.AC + op2.AC);
        if (op.HP + op2.HP > 0) {
            text += " HP+" + (op.HP + op2.HP);
        }
        if (op.MP + op2.MP > 0) {
            text += " MP+" + (op.MP + op2.MP);
        }
        if (op.HPR + op2.HPR > 0) {
            text += " HP���R��+" + (op.HPR + op2.HPR);
        }
        if (op.HPR + op2.HPR < 0) {
            text += " HP���R��" + (op.HPR + op2.HPR);
        }
        if (op.MPR + op2.MPR > 0) {
            text += " MP���R��+" + (op.MPR + op2.MPR);
        }
        if (op.MPR + op2.MPR < 0) {
            text += " MP���R��" + (op.MPR + op2.MPR);
        }
        if (op.ST[STR] + op2.ST[STR] > 0) {
            text += " STR+" + (op.ST[STR] + op2.ST[STR]);
        }
        if (op.ST[DEX] + op2.ST[DEX] > 0) {
            text += " DEX+" + (op.ST[DEX] + op2.ST[DEX]);
        }
        if (op.ST[CON] + op2.ST[CON] > 0) {
            text += " CON+" + (op.ST[CON] + op2.ST[CON]);
        }
        if (op.ST[INT] + op2.ST[INT] > 0) {
            text += " INT+" + (op.ST[INT] + op2.ST[INT]);
        }
        if (op.ST[WIS] + op2.ST[WIS] > 0) {
            text += " WIS+" + (op.ST[WIS] + op2.ST[WIS]);
        }
        if (op.ST[CHA] + op2.ST[CHA] > 0) {
            text += " CHA+" + (op.ST[CHA] + op2.ST[CHA]);
        }
        if (op.ST[STR] < 0) {
            text += " STR" + op.ST[STR];
        }
        if (op.ST[DEX] < 0) {
            text += " DEX" + op.ST[DEX];
        }
        if (op.ST[CON] < 0) {
            text += " CON" + op.ST[CON];
        }
        if (op.ST[INT] < 0) {
            text += " INT" + op.ST[INT];
        }
        if (op.ST[WIS] < 0) {
            text += " WIS" + op.ST[WIS];
        }
        if (op.ST[CHA] < 0) {
            text += " CHA" + op.ST[CHA];
        }
        if (op.DMG_SHORT + op2.DMG_SHORT > 0) {
            //text += " �ǉ��Ō�+" + (op.DMG_SHORT + op2.DMG_SHORT);
            text += " �ߋ����_���[�W+" + (op.DMG_SHORT + op2.DMG_SHORT);
        }
        if (op.HIT_SHORT + op2.HIT_SHORT > 0) {
            //text += " �U������+" + (op.HIT_SHORT + op2.HIT_SHORT);
            text += " �ߋ�������+" + (op.HIT_SHORT + op2.HIT_SHORT);
        }
        if (op.DMG_LONG + op2.DMG_LONG > 0) {
            text += " �������_���[�W+" + (op.DMG_LONG + op2.DMG_LONG);
        }
        if (op.HIT_LONG + op2.HIT_LONG > 0) {
            text += " ����������+" + (op.HIT_LONG + op2.HIT_LONG);
        }
        if (op.SP + op2.SP > 0) {
            text += " SP+" + (op.SP + op2.SP);
        }
        if (op.SP < 0) {
            text += " SP" + op.SP;
        }
        if (op.HIT_MAGIC + op2.HIT_MAGIC > 0) {
            text += " ���@����+" + (op.HIT_MAGIC + op2.HIT_MAGIC);
        }
        if (op.CRI_SHORT + op2.CRI_SHORT > 0) {
            text += " �ߋ����N���e�B�J��+" + (op.CRI_SHORT + op2.CRI_SHORT);
        }
        if (op.CRI_LONG + op2.CRI_LONG > 0) {
            text += " �������N���e�B�J��+" + (op.CRI_LONG + op2.CRI_LONG);
        }
        if (op.CRI_MAGIC + op2.CRI_MAGIC > 0) {
            text += " ���@�N���e�B�J��+" + (op.CRI_MAGIC + op2.CRI_MAGIC);
        }
        if (op.element_resist[FIRE] > 0) {
            text += " �Α���MR" + op.element_resist[FIRE];
        }
        if (op.element_resist[WATER] > 0) {
            text += " ������MR" + op.element_resist[WATER];
        }
        if (op.element_resist[WIND] > 0) {
            text += " ������MR" + op.element_resist[WIND];
        }
        if (op.element_resist[EARTH] > 0) {
            text += " �n����MR" + op.element_resist[EARTH];
        }
        if (op.MR + op2.MR > 0) {
            text += " MR+" + (op.MR + op2.MR);
        }
        if (mr_enchant > 0) {
            text += " (��������MR+" + mr_enchant + ")";
        }
        if (op.ailment[STUN] + op2.ailment[STUN] > 0) {
            text += " �X�^���ϐ�+" + (op.ailment[STUN] + op2.ailment[STUN]);
        }
        if (op.ailment[HOLD] + op2.ailment[HOLD] > 0) {
            text += " �z�[���h�ϐ�+" + (op.ailment[HOLD] + op2.ailment[HOLD]);
        }
        if (op.ailment[SLEEP] + op2.ailment[SLEEP] > 0) {
            text += " �����ϐ�+" + (op.ailment[SLEEP] + op2.ailment[SLEEP]);
        }
        if (op.ailment[FREEZE] + op2.ailment[FREEZE] > 0) {
            text += " �����ϐ�+" + (op.ailment[FREEZE] + op2.ailment[FREEZE]);
        }
        if (op.ailment[STONE] + op2.ailment[STONE] > 0) {
            text += " �Ή��ϐ�+" + (op.ailment[STONE] + op2.ailment[STONE]);
        }
        if (op.ailment[DARKNESS] + op2.ailment[DARKNESS] > 0) {
            text += " �Èőϐ�+" + (op.ailment[DARKNESS] + op2.ailment[DARKNESS]);
        }
        if (op.ailment[TERROR] + op2.ailment[TERROR] > 0) {
            text += " ���|�ϐ�+" + (op.ailment[TERROR] + op2.ailment[TERROR]);
        }
        if (op.ailment[DESTRUCTION] + op2.ailment[DESTRUCTION] > 0) {
            text += " �j��ϐ�+" + (op.ailment[DESTRUCTION] + op2.ailment[DESTRUCTION]);
        }
        if (op.ailment[HIT_STUN] + op2.ailment[HIT_STUN] > 0) {
            text += " �X�^������+" + (op.ailment[HIT_STUN] + op2.ailment[HIT_STUN]);
        }
        if (op.ailment[HIT_HOLD] + op2.ailment[HIT_HOLD] > 0) {
            text += " �z�[���h����+" + (op.ailment[HIT_HOLD] + op2.ailment[HIT_HOLD]);
        }
        if (op.ailment[HIT_SLEEP] + op2.ailment[HIT_SLEEP] > 0) {
            text += " ��������+" + (op.ailment[HIT_SLEEP] + op2.ailment[HIT_SLEEP]);
        }
        if (op.ailment[HIT_FREEZE] + op2.ailment[HIT_FREEZE] > 0) {
            text += " ��������+" + (op.ailment[HIT_FREEZE] + op2.ailment[HIT_FREEZE]);
        }
        if (op.ailment[HIT_STONE] + op2.ailment[HIT_STONE] > 0) {
            text += " �Ή�����+" + (op.ailment[HIT_STONE] + op2.ailment[HIT_STONE]);
        }
        if (op.ailment[HIT_DARKNESS] + op2.ailment[HIT_DARKNESS] > 0) {
            text += " �ÈŖ���+" + (op.ailment[HIT_DARKNESS] + op2.ailment[HIT_DARKNESS]);
        }
        if (op.ailment[HIT_TERROR] + op2.ailment[HIT_TERROR] > 0) {
            text += " ���|����+" + (op.ailment[HIT_TERROR] + op2.ailment[HIT_TERROR]);
        }
        if (op.ailment[HIT_DESTRUCTION] + op2.ailment[HIT_DESTRUCTION] > 0) {
            text += " �j�󖽒�+" + (op.ailment[HIT_DESTRUCTION] + op2.ailment[HIT_DESTRUCTION]);
        }
        if (op.DR + op2.DR > 0) {
            text += " �_���[�W���_�N�V����+" + (op.DR + op2.DR);
        }
        if (op.DR_IGNORED + op2.DR_IGNORED > 0) {
            text += " �_���[�W���_�N�V��������+" + (op.DR_IGNORED + op2.DR_IGNORED);
        }
        if (op.PVP + op2.PVP > 0) {
            text += " PVP�ǉ��_���[�W+" + (op.PVP + op2.PVP);
        }
        if (op.PVP_DR + op2.PVP_DR > 0) {
            text += " PVP�_���[�W����+" + (op.PVP_DR + op2.PVP_DR);
        }
        //�����d�ʂ̒ǉ�
        if (op.c_weight + op2.c_weight > 0) {
            text += " �����d�ʑ���+" + (op.c_weight + op2.c_weight);
        }

        if (!op.effect.equals("")) {
            text += " " + op.effect;
        }
        if (!op2.effect.equals("")) {
            text += " " + op2.effect;
        }
        return text;
    }

    public void checkEnchant() {

        op2 = new Buff();

        if (name.contains("�e�C�p�[�K�[�_�[")) {
            if (name.contains("�r��")) {
                switch (enchant) {
                    case 5:
                        op2.HIT_SHORT = 1;
                        break;
                    case 6:
                        op2.HIT_SHORT = 2;
                        op2.DMG_SHORT = 1;
                        break;
                    case 7:
                        op2.HIT_SHORT = 2;
                        op2.DMG_SHORT = 1;
                        op2.ST[STR] = 1;
                        break;
                    case 8:
                        op2.HIT_SHORT = 2;
                        op2.DMG_SHORT = 2;
                        op2.ST[STR] = 1;
                        op2.PVP = 1;
                        break;
                    case 9:
                        op2.HIT_SHORT = 3;
                        op2.DMG_SHORT = 3;
                        op2.ST[STR] = 1;
                        op2.PVP = 2;
                        break;
                }
            }
            if (name.contains("�@�q")) {
                switch (enchant) {
                    case 5:
                        op2.HIT_LONG = 1;
                        break;
                    case 6:
                        op2.HIT_LONG = 2;
                        op2.DMG_LONG = 1;
                        break;
                    case 7:
                        op2.HIT_LONG = 2;
                        op2.DMG_LONG = 1;
                        op2.ST[DEX] = 1;
                        break;
                    case 8:
                        op2.HIT_LONG = 2;
                        op2.DMG_LONG = 2;
                        op2.ST[DEX] = 1;
                        op2.PVP = 1;
                        break;
                    case 9:
                        op2.HIT_LONG = 3;
                        op2.DMG_LONG = 3;
                        op2.ST[DEX] = 1;
                        op2.PVP = 2;
                        break;
                }
            }
            if (name.contains("�m��")) {
                switch (enchant) {
                    case 5:
                        op2.MPR = 2;
                        break;
                    case 6:
                        op2.MPR = 2;
                        op2.SP = 1;
                        break;
                    case 7:
                        op2.MPR = 4;
                        op2.SP = 1;
                        op2.ST[INT] = 1;
                        break;
                    case 8:
                        op2.MPR = 4;
                        op2.SP = 2;
                        op2.ST[INT] = 1;
                        op2.PVP = 1;
                        break;
                    case 9:
                        op2.MPR = 6;
                        op2.SP = 3;
                        op2.ST[INT] = 1;
                        op2.PVP = 2;
                        break;
                }
            }
        }

        if (name.equals("�n����T�V���c")) {
            switch (enchant) {
                case 5:
                    op2.MR = 4;
                    break;
                case 6:
                    op2.MR = 5;
                    break;
                case 7:
                    op2.MR = 6;
                    break;
                case 8:
                    op2.MR = 8;
                    break;
                case 9:
                    op2.MR = 11;
                    op2.DR = 2;
                    break;
                case 10:
                    op2.MR = 14;
                    op2.DR = 3;
            }
        }
        if (name.equals("�Η���T�V���c")) {
            switch (enchant) {
                case 5:
                    op2.HP = 20;
                    break;
                case 6:
                    op2.HP = 30;
                    break;
                case 7:
                    op2.HP = 50;
                    break;
                case 8:
                    op2.HP = 70;
                    break;
                case 9:
                    op2.HP = 90;
                    op2.DMG_SHORT = 1;
                    break;
                case 10:
                    op2.HP = 100;
                    op2.DMG_SHORT = 2;
            }
        }
        if (name.equals("������T�V���c")) {
            switch (enchant) {
                case 5:
                    op2.HP = 20;
                    break;
                case 6:
                    op2.HP = 30;
                    break;
                case 7:
                    op2.HP = 50;
                    break;
                case 8:
                    op2.HP = 70;
                    break;
                case 9:
                    op2.HP = 90;
                    op2.DMG_LONG = 1;
                    break;
                case 10:
                    op2.HP = 100;
                    op2.DMG_LONG = 2;
            }
        }
        if (name.equals("������T�V���c")) {
            switch (enchant) {
                case 5:
                    op2.HP = 20;
                    break;
                case 6:
                    op2.HP = 30;
                    break;
                case 7:
                    op2.HP = 50;
                    break;
                case 8:
                    op2.HP = 70;
                    break;
                case 9:
                    op2.HP = 90;
                    op2.SP = 1;
                    break;
                case 10:
                    op2.HP = 100;
                    op2.SP = 2;
            }
        }

        if (name.equals("�Ñ�|�ˎ�̃K�[�_�[")) {
            if (enchant >= 9) {
                op2.DMG_LONG = 3;
            } else if (enchant >= 7) {
                op2.DMG_LONG = 2;
            } else if (enchant >= 5) {
                op2.DMG_LONG = 1;
            }
        }
        if (name.equals("�Ñ㓬�m�̃K�[�_�[")) {
            if (enchant >= 9) {
                op2.DMG_SHORT = 3;
            } else if (enchant >= 7) {
                op2.DMG_SHORT = 2;
            } else if (enchant >= 5) {
                op2.DMG_SHORT = 1;
            }
        }
        if (name.equals("�̗͂̃K�[�_�[")) {
            if (enchant >= 9) {
                op2.HP = 75;
            } else if (enchant >= 7) {
                op2.HP = 50;
            } else if (enchant >= 5) {
                op2.HP = 25;
            }
        }
        if (name.equals("���̃K�[�_�[")) {
            if (enchant >= 9) {
                op2.DR = 3;
            } else if (enchant >= 7) {
                op2.DR = 2;
            } else if (enchant >= 5) {
                op2.DR = 1;
            }
        }
        if (name.equals("�E�B�U�[�h�̃K�[�_�[")) {
            if (enchant >= 9) {
                op2.SP = 3;
            } else if (enchant >= 7) {
                op2.SP = 2;
            } else if (enchant >= 5) {
                op2.SP = 1;
            }
        }
        if (name.equals("�}�~�[���[�h�N���E��")) {
            if (enchant >= 9) {
                op2.DMG_LONG = 3;
            } else if (enchant >= 8) {
                op2.DMG_LONG = 2;
            } else if (enchant >= 7) {
                op2.DMG_LONG = 1;
            }
        }
        if (name.equals("����T�V���c")) {
            if (enchant > 0) {
                op2.ailment[STUN] += enchant;
            }
        }
        if (name.contains("�A���^���X�O�����h")) {
            if (enchant > 6) {
                op2.DR += enchant - 6;
            }
        }
        if (name.equals("���@���J�X�t���C���v���[�g���C��")) {
            if (enchant >= 9) {
                op2.CRI_SHORT = 3;
                op2.DR_IGNORED = 3;
            } else if (enchant >= 8) {
                op2.CRI_SHORT = 2;
                op2.DR_IGNORED = 2;
            } else if (enchant >= 7) {
                op2.CRI_SHORT = 1;
                op2.DR_IGNORED = 1;
            }
        }
        if (name.equals("���@���J�X�t���C���X�P�C�����C��")) {
            if (enchant >= 9) {
                op2.CRI_SHORT = 3;
                op2.DR_IGNORED = 2;
            } else if (enchant >= 8) {
                op2.CRI_SHORT = 2;
                op2.DR_IGNORED = 2;
            } else if (enchant >= 7) {
                op2.CRI_SHORT = 1;
                op2.DR_IGNORED = 1;
            }
        }
        if (name.equals("���@���J�X�t���C�����U�[�A�[�}�[")) {
            if (enchant >= 9) {
                op2.CRI_LONG = 3;
                op2.DR_IGNORED = 2;
            } else if (enchant >= 8) {
                op2.CRI_LONG = 2;
                op2.DR_IGNORED = 2;
            } else if (enchant >= 7) {
                op2.CRI_LONG = 1;
                op2.DR_IGNORED = 1;
            }
        }
        if (name.equals("���@���J�X�t���C�����[�u")) {
            if (enchant >= 9) {
                op2.CRI_MAGIC = 3;
                op2.DR_IGNORED = 2;
            } else if (enchant >= 8) {
                op2.CRI_MAGIC = 2;
                op2.DR_IGNORED = 2;
            } else if (enchant >= 7) {
                op2.CRI_MAGIC = 1;
                op2.DR_IGNORED = 1;
            }
        }
        if (name.equals("�P�����͂̃O���[�u")) {
            if (enchant > 4) {
                op2.c_weight += 60 * (enchant - 4);
            }
        }
        if (name.contains("�X�i�b�p�[")) {
            if (name.contains("�j�����ꂽ")) {
                if (name.contains("�E�m")) {
                    switch (enchant) {
                        case 8:
                                                                                //AC-7
                            op2.DMG_LONG++;             //�ߋ����_���[�W+1       //�ߋ����_���[�W+5
                            op2.DMG_SHORT++;            //�������_���[�W+1       //�������_���[�W+5
                            op2.HIT_SHORT++;            //�ߋ�������+1           //�ߋ�������+5
                            op2.HIT_LONG++;             //����������+1           //����������+5
                            op2.ailment[STUN] += 2;     //�X�^���ϐ�+2           //�X�^���ϐ�+9
                                                                                //HP+30
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 7:
                            op2.AC--;                   //AC-1                  //AC-7
                            op2.DMG_LONG++;             //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                            op2.DMG_SHORT++;            //�������_���[�W+1       //�������_���[�W+4
                            op2.HIT_SHORT++;            //�ߋ�������+1           //�ߋ�������+4
                            op2.HIT_LONG++;             //����������+1           //����������+4
                            op2.ailment[STUN] += 2;     //�X�^���ϐ�+2           //�X�^���ϐ�+7
                            op2.HP += 5;                //HP+5                  //HP+30
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 6:
                                                                                //AC-6
                            op2.DMG_LONG++;             //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                            op2.DMG_SHORT++;            //�������_���[�W+1       //�������_���[�W+13
                            op2.HIT_SHORT++;            //�ߋ�������+1           //�ߋ�������+3
                            op2.HIT_LONG++;             //����������+1           //����������+3
                            op2.ailment[STUN] += 5;     //�X�^���ϐ�+5           //�X�^���ϐ�+5
                            op2.HP += 5;                //HP+5                  //HP+25
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 5:
                                                                                //AC-6
                            op2.DMG_LONG++;             //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                            op2.DMG_SHORT++;            //�������_���[�W+1       //�������_���[�W+2
                            op2.HIT_SHORT++;            //�ߋ�������+1           //�ߋ�������+2
                            op2.HIT_LONG++;             //����������+1           //����������+2
                            op2.HP += 5;                //HP+5                  //HP+20
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 4:
                            op2.AC--;                   //AC-1                  //AC-6
                            op2.DMG_LONG++;             //�ߋ����_���[�W+1       //�ߋ����_���[�W+1
                            op2.DMG_SHORT++;            //�������_���[�W+1       //�������_���[�W+1
                            op2.HIT_SHORT++;            //�ߋ�������+1           //�ߋ�������+1
                            op2.HIT_LONG++;             //����������+1           //����������+1
                            op2.HP += 5;                //HP+5                  //HP+15
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 3:
                            op2.AC -= 4;                //AC-4                  //AC-5
                            op2.HP += 10;               //HP+10                 //HP+10
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                    }
                } else if (name.contains("�m�b")) {
                    switch (enchant) {
                        case 8:
                                                                                //AC-6
                            op2.SP++;                   //SP+1                  //SP+5
                            op2.HIT_MAGIC++;            //���@����+1             //���@����+3                        
                            op2.ailment[STUN] += 2;     //�X�^���ϐ�+2           //�X�^���ϐ�+9                          
                            op2.HP += 10;               //HP+10                 //HP+50
                            op2.MP += 5;                //MP+5                  //MP+35
                                                                                //MP���R��+1
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2 
                                                                                //�����d�ʑ���+360
                        case 7:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.SP++;                   //SP+1                  //SP+4
                            op2.HIT_MAGIC++;            //���@����+1             //���@����+2
                            op2.ailment[STUN] += 2;     //�X�^���ϐ�+2           //�X�^���ϐ�+7
                            op2.HP += 5;                //HP+5                  //HP+40
                            op2.MP += 5;                //MP+5                  //MP+30
                                                                                //MP���R��+1
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //�����d�ʑ���+360
                        case 6:
                                                                                //AC-5 
                            op2.SP++;                   //SP+1                  //SP+3
                            op2.HIT_MAGIC++;            //���@����+1             //���@����+1
                            op2.ailment[STUN] += 5;     //�X�^���ϐ�+5           //�X�^���ϐ�+5
                            op2.HP += 5;                //HP+5                  //HP+35
                            op2.MP += 10;               //MP+10                 //MP+25
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360
                        case 5:
                                                                                //AC-5
                            op2.SP++;                   //SP+1                  //SP+2                          
                            op2.HP += 5;                //HP+5                  //HP+30
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360                                                     
                        case 4:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.SP++;                   //SP+1                  //SP+1
                            op2.HP += 5;                //HP+5                  //HP+25
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360
                        case 3:
                            op2.AC -= 3;                //AC-4                  //AC-4
                            op2.HP += 20;               //HP+20                 //HP+20
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360
                    }
                } else if (name.contains("�̗�")) {
                    switch (enchant) {
                        case 8:
                                                                                //AC-7
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+5
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+5
                            op2.DR++;                   //DR+1                  //DR+3
                                                        //�m���_���[�W�ቺ20 +1% //�m���_���[�W�ቺ20 +3%
                            op2.ailment[STUN] += 2;     //�X�^���ϐ�+2           //�X�^���ϐ�+9
                            op2.HP += 10;               //HP+10                 //HP+115
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //�����d�ʑ���+360
                        case 7:
                            op2.AC--;                   //AC-1                  //AC-7
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+4
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                            op2.DR++;                   //DR+1                  //DR+2
                                                        //�m���_���[�W�ቺ20 +1% //�m���_���[�W�ቺ20 +2%
                            op2.ailment[STUN] += 2;     //�X�^���ϐ�+2           //�X�^���ϐ�+7
                            op2.HP += 10;               //HP+10                 //HP+105
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //�����d�ʑ���+360
                        case 6:
                                                                                //AC-6
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+3
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                            op2.DR++;                   //DR+1                  //DR+1
                                                        //�m���_���[�W�ቺ20 +1% //�m���_���[�W�ቺ20 +1%
                            op2.ailment[STUN] += 5;     //�X�^���ϐ�+5           //�X�^���ϐ�+5
                            op2.HP += 5;                //HP+5                  //HP+95
                                                                                //�����d�ʑ���+360
                        case 5:
                            op2.AC--;                   //AC-1                  //AC-6
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+2
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                            op2.HP += 5;                //HP+5                  //HP+90
                                                                                //�����d�ʑ���+360
                        case 4:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+1
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+1
                            op2.HP += 5;                //HP+5                  //HP+85
                                                                                //�����d�ʑ���+360
                        case 3:
                             op2.AC -= 3;               //AC-3                  //AC-4
                             op2.HP += 30;              //HP+30                 //HP+80
                                                                                //�����d�ʑ���+360
                    }
                } else if (name.contains("���@��R")) {
                    switch (enchant) {
                        case 8:
                                                                                //AC-7
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+5
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+5
                            op2.MR++;                   //MR+1                  //MR+10
                                                        //�m�����@���+2         //�m�����@���+5
                            op2.ailment[STUN] += 2;     //�X�^���ϐ�+2           //�X�^���ϐ�+9
                                                                                //HP+50
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //�����d�ʑ���+360
                        case 7:
                            op2.AC--;                   //AC-3                  //AC-7
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+4
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                            op2.MR++;                   //MR+1                  //MR+9
                                                        //�m�����@���+2         //�m�����@���+3
                            op2.ailment[STUN] += 2;     //�X�^���ϐ�+2           //�X�^���ϐ�+7
                            op2.HP += 5;                //HP+5                  //HP+50
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //�����d�ʑ���+360
                        case 6:
                                                                                //AC-6
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+3
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                            op2.MR++;                   //MR+1                  //MR+8
                                                        //�m�����@���+1         //�m�����@���+1
                            op2.ailment[STUN] += 5;     //�X�^���ϐ�+5           //�X�^���ϐ�+5
                            op2.HP += 5;                //HP+5                  //HP+45
                                                                                //�����d�ʑ���+360
                        case 5:
                            op2.AC--;                   //AC-1                  //AC-6
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+2
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                                                                                //MR+7
                            op2.HP += 5;                //HP+5                  //HP+40
                                                                                //�����d�ʑ���+360
                        case 4:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+1
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+1
                                                                                //MR+7
                            op2.HP += 5;                //HP+5                  //HP+35
                                                                                //�����d�ʑ���+360
                        case 3:
                            op2.AC -= 3;                //AC-3                  //AC-4
                                                                                //MR+7
                            op2.HP += 30;               //HP+30                 //HP+30
                                                                                //�����d�ʑ���+360
                    }
                } else if (name.contains("�W��") || name.contains("�}�i") || name.contains("��")) {
                    switch (enchant) {
                        case 8:
                                                                                //AC-5
                                                                                //HP+50
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+5
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+5
                            op2.ailment[STUN] += 2;     //�X�^���ϐ�+2           //�X�^���ϐ�+9
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 7:
                                                                                //AC-5
                            op2.HP += 5;                //HP+5                  //HP+50
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+4
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                            op2.ailment[STUN] += 2;     //�X�^���ϐ�+2           //�X�^���ϐ�+9
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 6:
                                                                                //AC-5
                            op2.HP += 5;                //HP+5                  //HP+45
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+3
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                            op2.ailment[STUN] += 5;     //�X�^���ϐ�+5           //�X�^���ϐ�+5
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 5:
                                                                                //AC-5
                            op2.HP += 5;                //HP+5                  //HP+40
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+2
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 4:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+1
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+1
                            op2.HP += 5;                //HP+5                  //HP+35
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 3:
                            op2.AC -= 3;                //AC-3                  //AC-4
                            op2.HP += 30;               //HP+30                 //HP+30
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360
                    }
                }
            } else if (name.contains("�E�m")) {
                switch (enchant) {
                    case 8:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+30
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+4
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                        op2.HIT_SHORT++;                //�ߋ�������+1           //�ߋ�������+2
                        op2.HIT_LONG++;                 //����������+1           //����������+2
                        op2.ailment[STUN] += 2;         //�X�^���ϐ�+2           //�X�^���ϐ�+9
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                    case 7:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+25
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+3
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                        op2.HIT_SHORT++;                //�ߋ�������+1           //�ߋ�������+2
                        op2.HIT_LONG++;                 //����������+1           //����������+2
                        op2.ailment[STUN] += 2;         //�X�^���ϐ�+2           //�X�^���ϐ�+7
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                    case 6:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+20
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+2
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                        op2.HIT_SHORT++;                //�ߋ�������+1           //�ߋ�������+2
                        op2.HIT_LONG++;                 //����������+1           //����������+2
                        op2.ailment[STUN] += 5;         //�X�^���ϐ�+5           //�X�^���ϐ�+5
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                    case 5:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+15
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+1
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+1
                        op2.HIT_SHORT++;                //�ߋ�������+1           //�ߋ�������+1
                        op2.HIT_LONG++;                 //����������+1           //����������+1
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                    case 4:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+10
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                    case 3:
                        op2.AC--;                       //AC-1                  //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+5
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                    case 2:
                        op2.AC--;                       //AC-1                  //AC-3
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                    case 1:
                        op2.AC--;                       //AC-1                  //AC-2
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                }
            } else if (name.contains("�m�b")) {
                switch (enchant) {
                    case 8:
                        op2.AC--;                       //AC-1                  //AC-6
                        op2.HP += 5;                    //HP+5                  //HP+40
                        op2.SP++;                       //SP+1                  //SP+4
                        op2.ailment[STUN] += 2;         //�X�^���ϐ�+2           //�X�^���ϐ�+9
                        op2.HIT_MAGIC++;                //���@����+1             //���@����+2
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                        op2.MP += 15;                   //MP+15                 //MP+30
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360
                    case 7:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+35
                        op2.SP++;                       //SP+1                  //SP+3
                        op2.ailment[STUN] += 2;         //�X�^���ϐ�+2           //�X�^���ϐ�+7
                        op2.HIT_MAGIC++;                //���@����+1             //���@����+1
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1                       
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360                       
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+30
                        op2.SP++;                       //SP+1                  //SP+2
                        op2.ailment[STUN] += 5;         //�X�^���ϐ�+2           //�X�^���ϐ�+5                      
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360                      
                    case 5:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+25
                        op2.SP++;                       //SP+1                  //SP+1
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360                                              
                    case 4:
                        op2.AC--;                       //AC-1                  //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+20
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360                                              
                    case 3:
                        op2.AC--;                       //AC-1                  //AC-3
                        op2.HP += 5;                    //HP+5                  //HP+15                       
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360                        
                    case 2:
                        op2.AC--;                       //AC-1                  //AC-2
                        op2.HP += 5;                    //HP+5                  //HP+10                      
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360                        
                    case 1:
                                                                                //AC-1
                        op2.HP += 5;                    //HP+5                  //HP+5                       
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360                        
                }
            } else if (name.contains("�̗�")) {
                switch (enchant) {
                    case 8:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+4
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                        op2.DR++;                       //DR+1                  //DR+2
                                                        //�m���_���[�W�ቺ20 +1% //�m���_���[�W�ቺ20 +2%
                        op2.ailment[STUN] += 2;         //�X�^���ϐ�+2           //�X�^���ϐ�+9
                        op2.HP += 5;                    //HP+5                  //HP+100
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //�����d�ʑ���+360
                    case 7:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+3
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                        op2.DR++;                       //DR+1                  //DR+1
                                                        //�m���_���[�W�ቺ20 +1% //�m���_���[�W�ቺ20 +1%
                        op2.ailment[STUN] += 2;         //�X�^���ϐ�+2           //�X�^���ϐ�+7
                        op2.HP += 5;                    //HP+5                  //HP+95
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //�����d�ʑ���+360
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+2
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                        op2.ailment[STUN] += 5;         //�X�^���ϐ�+5           //�X�^���ϐ�+5
                        op2.HP += 5;                    //HP+5                  //HP+90
                                                                                //�����d�ʑ���+360
                    case 5:
                                                                                //AC-4
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+1
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+1
                        op2.HP += 5;                    //HP+5                  //HP+85
                                                                                //�����d�ʑ���+360
                    case 4:
                        op2.AC--;                       //AC-1                  //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+80
                                                                                //�����d�ʑ���+360
                    case 3:
                        op2.AC--;                       //AC-1                  //AC-3
                        op2.HP += 5;                    //HP+5                  //HP+75
                                                                                //�����d�ʑ���+360                        
                    case 2:
                        op2.AC--;                       //AC-1                  //AC-2
                        op2.HP += 5;                    //HP+5                  //HP+70                      
                                                                                //�����d�ʑ���+360                        
                    case 1:
                                                                                //AC-1
                        op2.HP += 15;                    //HP+5                 //HP+65
                                                                                //�����d�ʑ���+360                        
                }
            } else if (name.contains("���@��R")) {
                switch (enchant) {
                    case 8:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+4
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                                                                                //MR+7
                                                        //�m�����@���+2         //�m�����@���+3
                        op2.ailment[STUN] += 2;         //�X�^���ϐ�+2           //�X�^���ϐ�+9
                        op2.HP += 5;                    //HP+5                  //HP+50
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //�����d�ʑ���+360
                    case 7:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+3
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                                                                                //MR+7
                                                        //�m�����@���+2         //�m�����@���+1
                        op2.ailment[STUN] += 2;         //�X�^���ϐ�+2           //�X�^���ϐ�+7
                        op2.HP += 5;                    //HP+5                  //HP+45
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //�����d�ʑ���+360
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+2
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                                                                                //MR+7
                        op2.ailment[STUN] += 5;         //�X�^���ϐ�+5           //�X�^���ϐ�+5
                        op2.HP += 5;                    //HP+5                  //HP+40
                                                                                //�����d�ʑ���+360
                    case 5:
                                                                                //AC-4
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+1
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+1
                                                                                //MR+7
                        op2.HP += 5;                    //HP+5                  //HP+35
                                                                                //�����d�ʑ���+360
                    case 4:
                        op2.AC--;                       //AC-1                  //AC-4
                                                                                //MR+7
                        op2.HP += 5;                    //HP+5                  //HP+30
                                                                                //�����d�ʑ���+360
                    case 3:
                        op2.AC--;                       //AC-3                  //AC-3
                                                                                //MR+7
                        op2.HP += 5;                    //HP+5                  //HP+25
                                                                                //�����d�ʑ���+360
                    case 2:
                        op2.AC--;                       //AC-1                  //AC-2
                                                                                //MR+7
                        op2.HP += 5;                    //HP+5                  //HP+20                      
                                                                                //�����d�ʑ���+360                        
                    case 1:
                                                                                //AC-1
                                                                                //MR+7
                        op2.HP += 15;                   //HP+5                  //HP+15
                                                                                //�����d�ʑ���+360                        
                }
            } else {
                    switch (enchant) {
                    case 8:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+50
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+4
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                        op2.ailment[STUN] += 2;         //�X�^���ϐ�+2           //�X�^���ϐ�+9
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360 
                    case 7:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+45
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+3
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                        op2.ailment[STUN] += 2;         //�X�^���ϐ�+2           //�X�^���ϐ�+7
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360 
                    case 6:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+40
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+2
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                        op2.ailment[STUN] += 5;         //�X�^���ϐ�+5           //�X�^���ϐ�+5
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360 
                    case 5:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+35
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+1
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+1
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360 
                    case 4:
                        op2.AC--;                       //AC-1                  //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+30
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360 
                    case 3:
                        op2.AC--;                       //AC-1                  //AC-3
                        op2.HP += 5;                    //HP+5                  //HP+25
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360 
                    case 2:
                        op2.AC--;                       //AC-1                  //AC-2
                        op2.HP += 5;                    //HP+5                  //HP+20
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360
                    case 1:
                        op2.HP += 15;                   //HP+5                  //HP+15
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360
                }
            }
        }

        if (name.equals("����̃}���g")) {
            if (enchant >= 5) {
                op2.AC = -2;
            }
            if (enchant >= 6) {
                op2.MR = 20;
            }
            if (enchant >= 7) {
                op2.HP = 40;
                op2.MP = 40;
            }
            if (enchant >= 8) {
                op2.DR = 1;
            }
            if (enchant >= 9) {
                op2.ST[STR] = 1;
            }
            //+10�����I�v�V����[�����d�ʑ���+240]
            if (enchant >= 10) {
                op2.c_weight = 240;
            }
        }
        if (name.equals("����̃P�[�v")) {
            if (enchant >= 5) {
                op2.AC = -2;
            }
            if (enchant >= 6) {
                op2.MR = 20;
            }
            if (enchant >= 7) {
                op2.DMG_LONG = 1;
            }
            if (enchant >= 8) {
                op2.DR = 1;
            }
            if (enchant >= 9) {
                op2.ST[DEX] = 1;
            }
            //+10�����I�v�V����[�����d�ʑ���+240]
            if (enchant >= 10) {
                op2.c_weight = 240;
            }                
        }
        if (name.equals("����̃N���[�N")) {
            if (enchant >= 5) {
                op2.AC = -2;
            }
            if (enchant >= 6) {
                op2.MR = 20;
            }
            if (enchant >= 7) {
                op2.MPR = 4;
            }
            if (enchant >= 8) {
                op2.DR = 1;
            }
            if (enchant >= 9) {
                op2.ST[INT] = 1;
            }
            //+10�����I�v�V����[�����d�ʑ���+240]
            if (enchant >= 10) {
                op2.c_weight = 240;
            }
        }

        if (name.contains("���b�`���[�u")) {
            if (enchant >= 3) {
                op2.SP = enchant - 2;
            }
        }

        if (name.equals("���V�̃O���[�u")) {
            if (enchant >= 7) {
                op2.HIT_SHORT = enchant - 3;
            }
            if (enchant >= 9) {
                op2.HIT_SHORT =6;
            }
        }
        if (name.equals("���R�m�̃p���[�O���[�u")) {
            if (enchant >= 5) {
                op2.HIT_SHORT = enchant - 4;
            }
            if (enchant >= 9) {
                op2.HIT_SHORT =5;
            }
        }
        if (name.equals("���R�m�̃u���C�T�[")) {
            if (enchant >= 5) {
                op2.HIT_LONG = enchant - 4;
            }
            if (enchant >= 9) {
                op2.HIT_LONG =5;
            }
        }

        if (name.equals("�K�^�̃T�[�N���b�g")) {
            if (enchant > 0) {
                op2.SP = 1;
            }
        }

        if (name.equals("�喂�@�g���̖X�q")) {
            op2.MP = 10 * enchant;
        }

        if (name.equals("�V���Z�V�X�Q�[�g��")) {
            op2.HP = 5 * enchant;
        }

        //�r�͂̃Q�[�g����+9[�ߋ����_���[�W+1]
        if (name.equals("���j�R�[���̘r�͂̃Q�[�g��")) {
            if (enchant >= 9) {
                op2.DMG_SHORT = 1;
	    }
        } 

        //�@�q�̃Q�[�g����+9[�������_���[�W+1]
        if (name.equals("���j�R�[���̋@�q�̃Q�[�g��")) {
            if (enchant >= 9) {
                op2.DMG_LONG = 1;
	    }
        } 

        //�m�͂̃Q�[�g��+9[SP+1] 
        if (name.equals("���j�R�[���̒m�͂̃Q�[�g��")) {
            if (enchant >= 9) {
                op2.SP = 1;
	    }
        }

        //���̃Q�[�g����+5����[�ő�HP]+10����
        if (name.equals("���j�R�[���̎��̃Q�[�g��")) {
            if (enchant >= 5) {
                op2.HP = 10;
	    }
        }        

        //��R�̃Q�[�g����+1��������[MR]1%����(�����̃p�����[�^�[[MR����=]�Ŏ�����)
        //if (name.equals("���j�R�[���̒�R�̃Q�[�g��")) {
        //    op2.MR = 1 * enchant;
        //}
                      
        if (name.equals("����̃O���[�u")) {
            if (enchant >= 5) {
                op2.HP = 30;
            }
            if (enchant >= 6) {
                op2.MR = 2;
            }
            if (enchant >= 7) {
                op2.ST[STR] = 1;
            }
            if (enchant >= 8) {
                op2.MP = 20;
            }
            if (enchant >= 9) {
                op2.DMG_SHORT = 1;
            }
            //+10�����I�v�V����[�_���[�W�y��+1]
            if (enchant >= 10) {
                op2.DR = 1;
            }
        }
        if (name.equals("����̃u���C�T�[")) {
            if (enchant >= 5) {
                op2.HP = 30;
            }
            if (enchant >= 6) {
                op2.MPR = 1;
            }
            if (enchant >= 7) {
                op2.ST[DEX] = 1;
            }
            if (enchant >= 8) {
                op2.MP = 20;
            }
            if (enchant >= 9) {
                op2.DMG_LONG = 1;
            }
            //+10�����I�v�V����[�_���[�W�y��+1]
            if (enchant >= 10) {
                op2.DR = 1;
            }
        }
        if (name.equals("����̃~�g��")) {
            if (enchant >= 5) {
                op2.HP = 30;
            }
            if (enchant >= 6) {
                op2.MPR = 1;
            }
            if (enchant >= 7) {
                op2.ST[WIS] = 1;
            }
            if (enchant >= 8) {
                op2.MP = 20;
            }
            if (enchant >= 9) {
                op2.SP = 1;
            }
            //+10�����I�v�V����[�_���[�W�y��+1]
            if (enchant >= 10) {
                op2.DR = 1;
            }
        }

        if (name.equals("����̃O���[��")) {
            if (enchant >= 5) {
                op2.HP = 25;
            }
            if (enchant >= 6) {
                op2.MP = 20;
            }
            if (enchant >= 7) {
                op2.AC = -2;
            }
            if (enchant >= 8) {
                op2.ST[WIS] = 1;
            }
            if (enchant >= 9) {
                op2.ST[STR] = 1;
            }
            //+10�����I�v�V����[�ő�HP+80]
            if (enchant >= 10) {
                op2.HP = 80;
            }
        }
        if (name.equals("����̃u�[�c")) {
            if (enchant >= 5) {
                op2.HP = 25;
            }
            if (enchant >= 6) {
                op2.MP = 20;
            }
            if (enchant >= 7) {
                op2.AC = -2;
            }
            if (enchant >= 8) {
                op2.ST[WIS] = 1;
            }
            if (enchant >= 9) {
                op2.ST[DEX] = 1;
            }
            //+10�����I�v�V����[�ő�HP+80]
            if (enchant >= 10) {
                op2.HP = 80;
            }
        }
        if (name.equals("����̃o�X�L��")) {
            if (enchant >= 5) {
                op2.HP = 25;
            }
            if (enchant >= 6) {
                op2.MP = 20;
            }
            if (enchant >= 7) {
                op2.AC = -2;
            }
            if (enchant >= 8) {
                op2.ST[WIS] = 1;
            }
            if (enchant >= 9) {
                op2.ST[INT] = 1;
            }
            //+10�����I�v�V����[�ő�HP+80]
            if (enchant >= 10) {
                op2.HP = 80;
            }
        }

        //+1�������邲�Ƃ�AC-1����Ȃ��h��E�A�C�e��
        if (type.equals("�����O") || type.equals("�A�~�����b�g") || type.equals("�C�A�����O") || type.equals("�x���g") || type.equals("���") || type.equals("�C���V�O�j�A")) {

            if (name.equals("�񕜂̖��")) {
                op2.effect = "�|�[�V�����񕜗� +" + (enchant * 2 + 2) + "% +" + (enchant * 2 + 2) + ",";
                op2.effect += "�񕜈����h�� +" + (enchant * 2 + 2) + "%,";
            }

            switch (name) {
                case "�r�̖͂��":          //+0�r�̖͂�͂�STR=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "�|�[�V�����񕜗� +2% +2,";
                            op2.effect += "�񕜈����h�� +2%,";
                            break;
                        case 2:
                            op2.effect = "�|�[�V�����񕜗� +4% +4,";
                            op2.effect += "�񕜈����h�� +4%,";
                            break;
                        case 3:
                            op2.effect = "�|�[�V�����񕜗� +6% +6,";
                            op2.effect += "�񕜈����h�� +6%,";
                            break;
                        case 4:
                            op2.effect = "�|�[�V�����񕜗� +8% +8,";
                            op2.effect += "�񕜈����h�� +8%,";
                            break;
                        case 5:
                            op2.effect = "�|�[�V�����񕜗� +9% +9,";
                            op2.effect += "�񕜈����h�� +9%,";
                            op2.HIT_SHORT = 1;
                            break;
                        case 6:
                            op2.effect = "�|�[�V�����񕜗� +10% +10,";
                            op2.effect += "�񕜈����h�� +10%,";
                            op2.HIT_SHORT = 1;
                            op2.DMG_SHORT = 1;
                            break;
                        case 7:
                            op2.effect = "�|�[�V�����񕜗� +11% +11,";
                            op2.effect += "�񕜈����h�� +11%,";
                            op2.HIT_SHORT = 2;
                            op2.DMG_SHORT = 2;
                            break;
                        case 8:
                            op2.effect = "�|�[�V�����񕜗� +12% +12,";
                            op2.effect += "�񕜈����h�� +12%,";
                            op2.HIT_SHORT = 3;
                            op2.DMG_SHORT = 3;
                            break;
                        case 9:
                            op2.effect = "�|�[�V�����񕜗� +13% +13,";
                            op2.effect += "�񕜈����h�� +13%,";
                            op2.HIT_SHORT = 4;
                            op2.DMG_SHORT = 4;
                            break;
                        case 10:
                            op2.effect = "�|�[�V�����񕜗� +14% +14,";
                            op2.effect += "�񕜈����h�� +14%,";
                            op2.HIT_SHORT = 5;
                            op2.DMG_SHORT = 5;
                            break;
                    }
                    break;                   
                case "�@�q�̖��":          //+0�@�q�̖�͂�DEX=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "�|�[�V�����񕜗� +2% +2,";
                            op2.effect += "�񕜈����h�� +2%,";
                            break;
                        case 2:
                            op2.effect = "�|�[�V�����񕜗� +4% +4,";
                            op2.effect += "�񕜈����h�� +4%,";
                            break;
                        case 3:
                            op2.effect = "�|�[�V�����񕜗� +6% +6,";
                            op2.effect += "�񕜈����h�� +6%,";
                            break;
                        case 4:
                            op2.effect = "�|�[�V�����񕜗� +8% +8,";
                            op2.effect += "�񕜈����h�� +8%,";
                            break;
                        case 5:
                            op2.effect = "�|�[�V�����񕜗� +9% +9,";
                            op2.effect += "�񕜈����h�� +9%,";
                            op2.HIT_LONG = 1;
                            break;
                        case 6:
                            op2.effect = "�|�[�V�����񕜗� +10% +10,";
                            op2.effect += "�񕜈����h�� +10%,";
                            op2.HIT_LONG = 1;
                            op2.DMG_LONG = 1;
                            break;
                        case 7:
                            op2.effect = "�|�[�V�����񕜗� +11% +11,";
                            op2.effect += "�񕜈����h�� +11%,";
                            op2.HIT_LONG = 2;
                            op2.DMG_LONG = 2;
                            break;
                        case 8:
                            op2.effect = "�|�[�V�����񕜗� +12% +12,";
                            op2.effect += "�񕜈����h�� +12%,";
                            op2.HIT_LONG = 3;
                            op2.DMG_LONG = 3;
                            break;
                        case 9:
                            op2.effect = "�|�[�V�����񕜗� +13% +13,";
                            op2.effect += "�񕜈����h�� +13%,";
                            op2.HIT_LONG = 4;
                            op2.DMG_LONG = 4;
                            break;
                        case 10:
                            op2.effect = "�|�[�V�����񕜗� +14% +14,";
                            op2.effect += "�񕜈����h�� +14%,";
                            op2.HIT_LONG = 5;
                            op2.DMG_LONG = 5;
                            break;
                    }
                    break;                  
                case "�m�̖͂��":          //+0�m�̖͂�͂�STR=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "�|�[�V�����񕜗� +2% +2,";
                            op2.effect += "�񕜈����h�� +2%,";
                            break;
                        case 2:
                            op2.effect = "�|�[�V�����񕜗� +4% +4,";
                            op2.effect += "�񕜈����h�� +4%,";
                            break;
                        case 3:
                            op2.effect = "�|�[�V�����񕜗� +6% +6,";
                            op2.effect += "�񕜈����h�� +6%,";
                            break;
                        case 4:
                            op2.effect = "�|�[�V�����񕜗� +8% +8,";
                            op2.effect += "�񕜈����h�� +8%,";
                            break;
                        case 5:
                            op2.effect = "�|�[�V�����񕜗� +9% +9,";
                            op2.effect += "�񕜈����h�� +9%,";
                            op2.HIT_MAGIC = 1;
                            break;
                        case 6:
                            op2.effect = "�|�[�V�����񕜗� +10% +10,";
                            op2.effect += "�񕜈����h�� +10%,";
                            op2.HIT_MAGIC = 1;
                            op2.SP = 1;
                            break;
                        case 7:
                            op2.effect = "�|�[�V�����񕜗� +11% +11,";
                            op2.effect += "�񕜈����h�� +11%,";
                            op2.HIT_MAGIC = 2;
                            op2.SP = 2;
                            break;
                        case 8:
                            op2.effect = "�|�[�V�����񕜗� +12% +12,";
                            op2.effect += "�񕜈����h�� +12%,";
                            op2.HIT_MAGIC = 3;
                            op2.SP = 3;
                            break;
                        case 9:
                            op2.effect = "�|�[�V�����񕜗� +13% +13,";
                            op2.effect += "�񕜈����h�� +13%,";
                            op2.HIT_MAGIC = 4;
                            op2.SP = 4;
                            break;
                        case 10:
                            op2.effect = "�|�[�V�����񕜗� +14% +14,";
                            op2.effect += "�񕜈����h�� +14%,";
                            op2.HIT_MAGIC = 5;
                            op2.SP = 5;
                            break;
                    }
                    break; 
                case "�����̖��":          //+0�����̖�͂�EXP+1%
                    switch (enchant) {
                        case 0:
                            op2.effect = "EXP +1%,";
                            break;
                        case 1:
                            op2.effect = "EXP +2%,";
                            op2.effect += "�|�[�V�����񕜗� +2% +2,";
                            op2.effect += "�񕜈����h�� +2%,";
                            break;
                        case 2:
                            op2.effect = "EXP +3%,";
                            op2.effect += "�|�[�V�����񕜗� +4% +4,";
                            op2.effect += "�񕜈����h�� +4%,";
                            break;
                        case 3:
                            op2.effect = "EXP +4%,";
                            op2.effect += "�|�[�V�����񕜗� +6% +6,";
                            op2.effect += "�񕜈����h�� +6%,";
                            break;
                        case 4:
                            op2.effect = "EXP +5%,";
                            op2.effect += "�|�[�V�����񕜗� +8% +8,";
                            op2.effect += "�񕜈����h�� +8%,";
                            break;
                        case 5:
                            op2.effect = "EXP +6%,";
                            op2.effect += "�|�[�V�����񕜗� +9% +9,";
                            op2.effect += "�񕜈����h�� +9%,";
                            break;
                        case 6:
                            op2.effect = "EXP +7%,";
                            op2.effect += "�|�[�V�����񕜗� +10% +10,";
                            op2.effect += "�񕜈����h�� +10%,";
                            break;
                        case 7:
                            op2.effect = "EXP +9%,";
                            op2.effect += "�|�[�V�����񕜗� +11% +11,";
                            op2.effect += "�񕜈����h�� +11%,";
                            break;
                        case 8:
                            op2.effect = "EXP +11%,";
                            op2.effect += "�|�[�V�����񕜗� +12% +12,";
                            op2.effect += "�񕜈����h�� +12%,";
                            break;
                        case 9:
                            op2.effect = "EXP +13%,";
                            op2.effect += "�|�[�V�����񕜗� +13% +13,";
                            op2.effect += "�񕜈����h�� +13%,";
                            break;
                        case 10:
                            op2.effect = "EXP +15%,";
                            op2.effect += "�|�[�V�����񕜗� +14% +14,";
                            op2.effect += "�񕜈����h�� +14%,";
                            break;
                    }
                    break;         
                case "���̖��":          //+0���̖�͂�AC=-1
                    switch (enchant) {
                        case 1:
                            op2.effect = "�l��EXP +1%,";
                            break;
                        case 2:
                            op2.effect = "�l��EXP +2%,";
                            break;
                        case 3:
                            op2.effect = "�l��EXP +3%,";
                            break;
                        case 4:
                            op2.effect = "�l��EXP +4%,";
                            op2.MR = 1;
                            break;
                        case 5:
                            op2.effect = "�l��EXP +5%,";
                            op2.MR = 2;
                            break;
                        case 6:
                            op2.effect = "�l��EXP +6%,";
                            op2.MR = 3;
                            break;
                        case 7:
                            op2.effect = "�l��EXP +7%,";
                            op2.MR = 4;
                            break;
                        case 8:
                            op2.effect = "�l��EXP +8%,";
                            op2.MR = 5;
                            break;
                    } 
                    break;
                case "���m�̖��":          //+0���m�̖�͂�STR=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "�|�[�V�����񕜗� +2% +2,";
                            op2.effect += "�񕜈����h�� +2%,";
                            break;
                        case 2:
                            op2.effect = "�|�[�V�����񕜗� +4% +4,";
                            op2.effect += "�񕜈����h�� +4%,";
                            break;
                        case 3:
                            op2.effect = "�|�[�V�����񕜗� +8% +8,";
                            op2.effect += "�񕜈����h�� +8%,";
                            break;
                        case 4:
                            op2.effect = "�|�[�V�����񕜗� +10% +10,";
                            op2.effect += "�񕜈����h�� +10%,";
                            break;
                        case 5:
                            op2.effect = "�|�[�V�����񕜗� +12% +12,";
                            op2.effect += "�񕜈����h�� +12%,";
                            op2.DMG_SHORT = 1;
                            op2.HIT_SHORT = 1;
                            break;
                        case 6:
                            op2.effect = "�|�[�V�����񕜗� +14% +14,";
                            op2.effect += "�񕜈����h�� +14%,";
                            op2.DMG_SHORT = 2;
                            op2.HIT_SHORT = 2;
                            break;
                        case 7:
                            op2.effect = "�|�[�V�����񕜗� +16% +16,";
                            op2.effect += "�񕜈����h�� +16%,";
                            op2.DMG_SHORT = 3;
                            op2.HIT_SHORT = 3;
                            break;
                        case 8:
                            op2.effect = "�|�[�V�����񕜗� +18% +18,";
                            op2.effect += "�񕜈����h�� +18%,";
                            op2.DMG_SHORT = 4;
                            op2.HIT_SHORT = 4;
                            break;
                    }
                    break;
                case "�ˎ�̖��":          //+0�ˎ�̖�͂�DEX=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "�|�[�V�����񕜗� +2% +2,";
                            op2.effect += "�񕜈����h�� +2%,";
                            break;
                        case 2:
                            op2.effect = "�|�[�V�����񕜗� +4% +4,";
                            op2.effect += "�񕜈����h�� +4%,";
                            break;
                        case 3:
                            op2.effect = "�|�[�V�����񕜗� +8% +8,";
                            op2.effect += "�񕜈����h�� +8%,";
                            break;
                        case 4:
                            op2.effect = "�|�[�V�����񕜗� +10% +10,";
                            op2.effect += "�񕜈����h�� +10%,";
                            break;
                        case 5:
                            op2.effect = "�|�[�V�����񕜗� +12% +12,";
                            op2.effect += "�񕜈����h�� +12%,";
                            op2.DMG_LONG= 1;
                            op2.HIT_LONG = 1;
                            break;
                        case 6:
                            op2.effect = "�|�[�V�����񕜗� +14% +14,";
                            op2.effect += "�񕜈����h�� +14%,";
                            op2.DMG_LONG = 2;
                            op2.HIT_LONG = 2;
                            break;
                        case 7:
                            op2.effect = "�|�[�V�����񕜗� +16% +16,";
                            op2.effect += "�񕜈����h�� +16%,";
                            op2.DMG_LONG = 3;
                            op2.HIT_LONG = 3;
                            break;
                        case 8:
                            op2.effect = "�|�[�V�����񕜗� +18% +18,";
                            op2.effect += "�񕜈����h�� +18%,";
                            op2.DMG_LONG = 4;
                            op2.HIT_LONG = 4;
                            break;
                    }
                    break;
                case "���҂̖��":          //+0���҂̖�͂�INT=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "�|�[�V�����񕜗� +2% +2,";
                            op2.effect += "�񕜈����h�� +2%,";
                            break;
                        case 2:
                            op2.effect = "�|�[�V�����񕜗� +4% +4,";
                            op2.effect += "�񕜈����h�� +4%,";
                            break;
                        case 3:
                            op2.effect = "�|�[�V�����񕜗� +8% +8,";
                            op2.effect += "�񕜈����h�� +8%,";
                            break;
                        case 4:
                            op2.effect = "�|�[�V�����񕜗� +10% +10,";
                            op2.effect += "�񕜈����h�� +10%,";
                            break;
                        case 5:
                            op2.effect = "�|�[�V�����񕜗� +12% +12,";
                            op2.effect += "�񕜈����h�� +12%,";
                            op2.HIT_MAGIC = 1;
                            op2.SP = 1;
                            break;
                        case 6:
                            op2.effect = "�|�[�V�����񕜗� +14% +14,";
                            op2.effect += "�񕜈����h�� +14%,";
                            op2.HIT_MAGIC = 2;
                            op2.SP = 2;
                            break;
                        case 7:
                            op2.effect = "�|�[�V�����񕜗� +16% +16,";
                            op2.effect += "�񕜈����h�� +16%,";
                            op2.HIT_MAGIC = 3;
                            op2.SP = 3;
                            break;
                        case 8:
                            op2.effect = "�|�[�V�����񕜗� +18% +18,";
                            op2.effect += "�񕜈����h�� +18%,";
                            op2.HIT_MAGIC = 4;
                            op2.SP = 4;
                            break;
                    }
                    break;
                case "���m�̎����":                      //+5���m�̎���͂���
                    switch (enchant) {
                        case 5:
                            op2.AC =-2;
                            op2.ST[STR] = 1;
                            op2.effect = "�|�[�V�����񕜗� +12% +12,";
                            op2.effect += "�񕜈����h�� +12%,";
                            op2.effect += "�j�����Ռ��� +3%,";                            
                            op2.DMG_SHORT = 1;
                            op2.HIT_SHORT = 2;
                            op2.MR = 4;
                            break;
                        case 6:
                            op2.AC =-2;
                            op2.ST[STR] = 1;
                            op2.effect = "�|�[�V�����񕜗� +14% +14,";
                            op2.effect += "�񕜈����h�� +14%,";
                            op2.effect += "�j�����Ռ��� +5%,";
                            op2.DMG_SHORT = 2;
                            op2.HIT_SHORT = 3;
                            op2.MR = 6;
                            break;
                        case 7:
                            op2.AC =-2;
                            op2.ST[STR] = 1;
                            op2.effect = "�|�[�V�����񕜗� +16% +16,";
                            op2.effect += "�񕜈����h�� +16%,";
                            op2.effect += "�j�����Ռ��� +7%,";
                            op2.DMG_SHORT = 3;
                            op2.HIT_SHORT = 4;
                            op2.MR = 8;
                            break;
                        case 8:
                            op2.AC =-2;
                            op2.ST[STR] = 1;
                            op2.effect = "�|�[�V�����񕜗� +18% +18,";
                            op2.effect += "�񕜈����h�� +18%,";
                            op2.effect += "�j�����Ռ��� +10%,";
                            op2.DMG_SHORT = 4;
                            op2.HIT_SHORT = 5;
                            op2.MR = 10;
                            break;
                    }
                    break;
                case "�ˎ�̎����":                      //+5�ˎ�̎���͂���
                    switch (enchant) {
                            case 5:
                            op2.AC =-2;
                            op2.ST[DEX] = 1;
                            op2.effect = "�|�[�V�����񕜗� +12% +12,";
                            op2.effect += "�񕜈����h�� +12%,";
                            op2.effect += "�j�����Ռ��� +3%,";                            
                            op2.DMG_LONG = 1;
                            op2.HIT_LONG = 2;
                            op2.MR = 4;
                            break;
                        case 6:
                            op2.AC =-2;
                            op2.ST[DEX] = 1;
                            op2.effect = "�|�[�V�����񕜗� +14% +14,";
                            op2.effect += "�񕜈����h�� +14%,";
                            op2.effect += "�j�����Ռ��� +5%,";
                            op2.DMG_LONG = 2;
                            op2.HIT_LONG = 3;
                            op2.MR = 6;
                            break;
                        case 7:
                            op2.AC =-2;
                            op2.ST[DEX] = 1;
                            op2.effect = "�|�[�V�����񕜗� +16% +16,";
                            op2.effect += "�񕜈����h�� +16%,";
                            op2.effect += "�j�����Ռ��� +7%,";
                            op2.DMG_LONG = 3;
                            op2.HIT_LONG = 4;
                            op2.MR = 8;
                            break;
                        case 8:
                            op2.AC =-2;
                            op2.ST[DEX] = 1;
                            op2.effect = "�|�[�V�����񕜗� +18% +18,";
                            op2.effect += "�񕜈����h�� +18%,";
                            op2.effect += "�j�����Ռ��� +10%,";
                            op2.DMG_LONG = 4;
                            op2.HIT_LONG = 5;
                            op2.MR = 10;
                            break;
                    }
                    break;
                case "���҂̎����":                      //+5���҂̎���͂���
                    switch (enchant) {
                        case 5:
                            op2.AC =-2;
                            op2.ST[INT] = 1;
                            op2.effect = "�|�[�V�����񕜗� +12% +12,";
                            op2.effect += "�񕜈����h�� +12%,";
                            op2.effect += "�j�����Ռ��� +3%,";
                            op2.SP = 1;
                            op2.HIT_MAGIC = 2;
                            op2.MR = 6;
                            break;
                        case 6:
                            op2.AC =-2;
                            op2.ST[INT] = 1;
                            op2.effect = "�|�[�V�����񕜗� +14% +14,";
                            op2.effect += "�񕜈����h�� +14%,";
                            op2.effect += "�j�����Ռ��� +5%,";
                            op2.SP = 2;
                            op2.HIT_MAGIC = 3;
                            op2.MR = 6;
                            break;
                        case 7:
                            op2.AC =-2;
                            op2.ST[INT] = 1;
                            op2.effect = "�|�[�V�����񕜗� +16% +16,";
                            op2.effect += "�񕜈����h�� +16%,";
                            op2.effect += "�j�����Ռ��� +7%,";
                            op2.SP = 3;
                            op2.HIT_MAGIC = 4;
                            op2.MR = 8;
                            break;
                        case 8:
                            op2.AC =-2;
                            op2.ST[INT] = 1;
                            op2.effect = "�|�[�V�����񕜗� +18% +18,";
                            op2.effect += "�񕜈����h�� +18%,";
                            op2.effect += "�j�����Ռ��� +10%,";
                            op2.SP = 4;
                            op2.HIT_MAGIC = 5;
                            op2.MR = 10;
                            break;
                    }
            }

            //�V�[�N���b�g�I�v�V����
            if (name.contains("������") || name.contains("����")) {
                if (enchant == 7) {
                    op2.PVP = 1;
                }
                if (enchant == 8) {
                    op2.PVP = 2;
                }
            }

            if (tokusei.equals("��M")) {
                switch (enchant) {
                    case 1:
                        op2.HP = 5;
                        break;
                    case 2:
                        op2.HP = 10;
                        break;
                    case 3:
                        op2.HP = 20;
                        break;
                    case 4:
                        op2.HP = 30;
                        break;
                    case 5:
                        op2.HP = 40;
                        op2.DMG_LONG = 1;
                        op2.DMG_SHORT = 1;
                        break;
                    case 6:
                        op2.HP = 40;
                        op2.DMG_LONG = 2;
                        op2.DMG_SHORT = 2;
                        op2.MR = 1;
                        break;
                    case 7:
                        op2.HP = 50;
                        op2.DMG_LONG = 3;
                        op2.DMG_SHORT = 3;
                        op2.SP = 1;
                        op2.MR = 3;
                        op2.PVP = 1;        //PVP�ǉ��_���[�W+1
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.DMG_LONG = 4;
                        op2.DMG_SHORT = 4;
                        op2.PVP = 2;        //PVP�ǉ��_���[�W+2
                        op2.SP = 2;
                        op2.MR = 5;
                        break;
                    case 9:
                        op2.HP = 60;
                        op2.DMG_LONG = 5;
                        op2.DMG_SHORT = 5;
                        op2.PVP = 3;        //PVP�ǉ��_���[�W+3
                        op2.SP = 3;
                        op2.MR = 7;
                        break;
                }
            }

            if (tokusei.equals("����")) {
                switch (enchant) {
                    case 1:
                        op2.HP = 5;
                        break;
                    case 2:
                        op2.HP = 10;
                        break;
                    case 3:
                        op2.HP = 20;
                        break;
                    case 4:
                        op2.HP = 30;
                        break;
                    case 5:
                        op2.HP = 40;
                        op2.effect = "�|�[�V�����񕜗� +2% +0,";
                        op2.effect += "�񕜈����h�� +2% (���|),";
                        op2.AC -= 1;
                        break;
                    case 6:
                        op2.HP = 40;
                        op2.effect = "�|�[�V�����񕜗� +4% +2,";
                        op2.effect += "�񕜈����h�� +4% (���|),";
                        op2.AC -= 2;                      
                        break;
                    case 7:
                        op2.HP = 50;
                        op2.effect = "�|�[�V�����񕜗� +6% +4,";
                        op2.effect += "�񕜈����h�� +6% (���|),";
                        op2.AC -= 3;
                        op2.ailment[STUN] += 2;
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.effect = "�|�[�V�����񕜗� +8% +6,";
                        op2.effect += "�񕜈����h�� +8% (���|),";
                        op2.AC -= 4;
                        op2.ailment[STUN] += 3;
                        break;
                    case 9:
                        op2.HP = 60;
                        op2.effect = "�|�[�V�����񕜗� +9% +7,";
                        op2.effect += "�񕜈����h�� +9% (���|),";
                        op2.AC -= 4;
                        op2.ailment[STUN] += 4;
                        break;
                }

            }

            if (tokusei.equals("�Ӓn")) {
                switch (enchant) {
                    case 1:
                        op2.MP = 5;
                        break;
                    case 2:
                        op2.MP = 10;
                        break;
                    case 3:
                        op2.MP = 20;
                        break;
                    case 4:
                        op2.MP = 30;
                        break;
                    case 5:
                        op2.MP = 40;
                        op2.DR = 1;
                        break;
                    case 6:
                        op2.HP = 20;
                        op2.MP = 40;
                        op2.DR = 2;
                        break;
                    case 7:
                        op2.HP = 30;
                        op2.MP = 50;
                        op2.DR = 3;
                        op2.PVP_DR=2;        //PVP�_���[�W�y��+2
                        break;
                    case 8:
                        op2.HP = 40;
                        op2.MP = 50;
                        op2.DR = 4;
                        op2.PVP_DR=3;        //PVP�_���[�W�y��+3                        
                        break;
                    case 9:
                        op2.HP = 50;
                        op2.MP = 60;
                        op2.DR = 5;
                        op2.PVP_DR=4;        //PVP�_���[�W�y��+4
                        break;
                }
            }

            if (grade.equals("����")) {     //�e��[10���N�L�O�����O]>>>����5�܂�
                switch (enchant) {
                    case 1:
                        op2.HP = 15;
                        break;
                    case 2:
                        op2.HP = 20;
                        op2.AC = -1;
                        break;
                    case 3:
                        op2.HP = 25;
                        op2.AC = -2;
                        break;
                    case 4:
                        op2.HP = 30;
                        op2.AC = -3;
                        break;
                    case 5:
                        op2.HP = 35;
                        op2.AC = -3;
                        op2.DMG_SHORT = 1;
                        op2.DMG_LONG = 1;
                        break;
                    case 6:
                        op2.HP = 40;
                        op2.AC = -3;
                        op2.DMG_SHORT = 2;
                        op2.DMG_LONG = 2;
                        break;
                    case 7:
                        op2.HP = 45;
                        op2.AC = -3;
                        op2.DMG_SHORT = 3;
                        op2.DMG_LONG = 3;
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.AC = -3;
                        op2.DMG_SHORT = 4;
                        op2.DMG_LONG = 4;
                        break;
                }
            }
            if (name.contains("���[���e�B�X ���b�h �C�A�����O")) {
                int e = enchant;
                if (name.contains("�j�����ꂽ")) {
                    e++;
                }
                switch (e) {
                    case 0:
                        op2.HP = 10;
                        break;
                    case 1:
                        op2.HP = 30;
                        break;
                    case 2:
                        op2.HP = 40;
                        break;
                    case 3:
                        op2.HP = 50;
                        op2.DR = 1;
                        break;
                    case 4:
                        op2.HP = 60;
                        op2.DR = 1;
                        break;
                    case 5:
                        op2.HP = 70;
                        op2.DR = 2;
                        op2.effect = "�_���[�W�y��+20 2%,";
                        break;
                    case 6:
                        op2.HP = 80;
                        op2.DR = 3;
                        op2.effect = "�_���[�W�y��+20 3%,";
                        op2.AC = -7;
                        break;
                    case 7:
                        op2.HP = 90;
                        op2.DR = 4;
                        op2.effect = "�_���[�W�y��+20 4%,";
                        op2.HIT_SHORT = 1;      //�ߋ�������+1
                        op2.HIT_LONG = 1;       //����������+1
                        op2.AC = -8;            //AC-8
                        break;
                    case 8:
                        op2.HP = 100;
                        op2.DR = 5;
                        op2.effect = "�_���[�W�y��+20 5%,";
                        op2.HIT_SHORT = 3;      //�ߋ�������+3
                        op2.HIT_LONG = 3;       //����������+3
                        op2.AC = -9;            //AC-9
                        break;
                    case 9:
                        op2.HP = 150;
                        op2.DR = 6;
                        op2.effect = "�_���[�W�y��+20 6%,";
                        op2.HIT_SHORT = 5;      //�ߋ�������+5
                        op2.HIT_LONG = 5;       //����������+5
                        op2.AC = -10;           //AC-10
                        break;
                }
            }
            if (name.contains("���[���e�B�X �p�[�v�� �C�A�����O")) {
                int e = enchant;
                if (name.contains("�j�����ꂽ")) {
                switch (e) {
                    case 3:
                        op2.MP = 40;
                        op2.MR = 8;
                        op2.SP = 1;
                        break;
                    case 4:
                        op2.MP = 55;
                        op2.MR = 9;
                        op2.SP = 2;
                        break;
                    case 5:
                        op2.MP = 60;
                        op2.MR = 10;
                        op2.SP = 2;
                        op2.AC = -1;            //AC-1
                        break;
                    case 6:
                        op2.MP = 75;
                        op2.MR = 12;
                        op2.SP = 3;
                        op2.AC = -2;            //AC-2
                        op2.HIT_MAGIC = 1;      //���@����+1
                        break;
                    case 7:
                        op2.MP = 100;
                        op2.MR = 15;
                        op2.SP = 3;
                        op2.AC = -3;            //AC-3
                        op2.HIT_MAGIC = 3;      //���@����+3
                        break;
                    case 8:
                        op2.MP = 130;
                        op2.MR = 20;
                        op2.SP = 4;
                        op2.AC = -4;            //AC-5
                        op2.HIT_MAGIC = 5;      //���@����+5
                        break;
                }
            }
            else {
		switch (e) {
                    case 0:
                        op2.MP = 5;
                        op2.MR = 2;
                        break;
                    case 1:
                        op2.MP = 15;
                        op2.MR = 5;
                        break;
                    case 2:
                        op2.MP = 20;
                        op2.MR = 6;
                        break;
                    case 3:
                        op2.MP = 35;
                        op2.MR = 7;
                        op2.SP = 1;
                        break;
                    case 4:
                        op2.MP = 40;
                        op2.MR = 8;
                        op2.SP = 1;
                        break;
                    case 5:
                        op2.MP = 55;
                        op2.MR = 9;
                        op2.SP = 2;
                        break;
                    case 6:
                        op2.MP = 60;
                        op2.MR = 10;
                        op2.SP = 2;
                        op2.AC = -1;            //AC-1
                        break;
                    case 7:
                        op2.MP = 75;
                        op2.MR = 12;
                        op2.SP = 3;
                        op2.AC = -2;            //AC-2
                        op2.HIT_MAGIC = 1;      //���@����+1
                        break;
                    case 8:
                        op2.MP = 100;
                        op2.MR = 15;
                        op2.SP = 3;
                        op2.AC = -3;            //AC-3
                        op2.HIT_MAGIC = 2;      //���@����+2
                        break;
                }
            }
            }
            if (name.contains("���[���e�B�X �u���[ �C�A�����O")) {
                int e = enchant;
                if (name.contains("�j�����ꂽ")) {
                    e++;
                }
                switch (e) {
                    case 0:
                        op2.effect = "�|�[�V�����񕜗� +2% +2,";
                        op2.effect += "�񕜈����h�� +2% (���|),";    //�񕜈����h�� +2% (���|)
                        break;
                    case 1:
                        op2.effect = "�|�[�V�����񕜗� +6% +6,";
                        op2.effect += "�񕜈����h�� +6% (���|),";    //�񕜈����h�� +6% (���|)
                        break;
                    case 2:
                        op2.effect = "�|�[�V�����񕜗� +8% +8,";
                        op2.effect += "�񕜈����h�� +8% (���|),";    //�񕜈����h�� +8% (���|)
                        break;
                    case 3:
                        op2.effect = "�|�[�V�����񕜗� +10% +10,";
                        op2.effect += "�񕜈����h�� +10% (���|),";   //�񕜈����h�� +10% (���|)
                        break;
                    case 4:
                        op2.effect = "�|�[�V�����񕜗� +12% +12,";
                        op2.effect += "�񕜈����h�� +12% (���|),";   //�񕜈����h�� +12% (���|)
                        break;
                    case 5:
                        op2.AC = -1;
                        op2.effect = "�|�[�V�����񕜗� +14% +14,";
                        op2.effect += "�񕜈����h�� +14% (���|),";   //�񕜈����h�� +14% (���|)
                        break;
                    case 6:
                        op2.AC = -2;
                        op2.effect = "�|�[�V�����񕜗� +16% +16,";
                        op2.effect += "�񕜈����h�� +16% (���|),";   //�񕜈����h�� +16% (���|)
                        break;
                    case 7:
                        op2.AC = -2;
                        op2.effect = "�|�[�V�����񕜗� +18% +18,";
                        op2.effect += "�񕜈����h�� +18% (���|),";   //�񕜈����h�� +18% (���|)
                        break;
                    case 8:
                        op2.AC = -3;
                        op2.effect = "�|�[�V�����񕜗� +20% +20,";
                        op2.effect += "�񕜈����h�� +20% (���|),";   //�񕜈����h�� +20% (���|)
                        break;
                    case 9:
                        op2.AC = -4;
                        op2.effect = "�|�[�V�����񕜗� +22% +22,";
                        op2.effect += "�񕜈����h�� +22% (���|),";   //�񕜈����h�� +22% (���|)
                        break;
                }
            }
            if (name.contains("���[���e�B�X �u���b�N �C�A�����O")) {
                int e = enchant;
                if (name.contains("�j�����ꂽ")) {
                    e++;
                }
                switch (e) {
                    case 0:
                        op2.AC = -1;
                        break;
                    case 1:
                        op2.AC = -2;
                        break;
                    case 2:
                        op2.AC = -3;
                        break;
                    case 3:
                        op2.AC = -4;
                        op2.DMG_SHORT = 1;
                        op2.DMG_LONG = 1;
                        break;
                    case 4:
                        op2.AC = -5;
                        op2.DMG_SHORT = 1;
                        op2.DMG_LONG = 1;
                        break;
                    case 5:
                        op2.AC = -6;
                        op2.DMG_SHORT = 2;
                        op2.DMG_LONG = 2;
                        op2.effect = "�ǉ��_���[�W +20 2%,";
                        break;
                    case 6:
                        op2.AC = -7;
                        op2.DMG_SHORT = 3;
                        op2.DMG_LONG = 3;
                        op2.effect = "�ǉ��_���[�W +20 3%,";
                        break;
                    case 7:
                        op2.AC = -8;
                        op2.DMG_SHORT = 4;
                        op2.DMG_LONG = 4;
                        op2.effect = "�ǉ��_���[�W +20 4%,";
                        break;
                    case 8:
                        op2.AC = -9;
                        op2.DMG_SHORT = 5;
                        op2.DMG_LONG = 5;
                        op2.effect = "�ǉ��_���[�W +20 5%,";
                        break;
                    case 9:
                        op2.AC = -10;
                        op2.DMG_SHORT = 6;
                        op2.DMG_LONG = 6;
                        op2.effect = "�ǉ��_���[�W +20 6%,";
                        break;
                }
            }
        } else {
            op2.AC += -enchant;
            op2.MR += enchant * mr_enchant;
            }
//�C���V�O�j�A
            if (name.equals("���m�̃C���V�O�j�A")) {
                switch (enchant) {
                    case 1:
                        op2.HP = 5;
                        break;
                    case 2:
                        op2.HP = 10;
                        break;
                    case 3:
                        op2.HP = 15;
                        break;               
                    case 4:
                        op2.HP = 20;
                        op2.AC = -1;
                        break;             
                    case 5:
                        op2.HP = 25;
                        op2.AC = -2;
                        op2.DMG_SHORT = 1;
                        break;              
                    case 6:
                        op2.HP = 30;
                        op2.AC = -3;
                        op2.DMG_SHORT = 2;
                        op2.CRI_SHORT = 1;
                        break;              
                    case 7:
                        op2.HP = 35;
                        op2.AC = -3;
                        op2.DMG_SHORT = 3;
                        op2.CRI_SHORT = 3;
                        break;              
                    case 8:
                        op2.HP = 45;
                        op2.AC = -3;
                        op2.DMG_SHORT = 4;
                        op2.CRI_SHORT = 5;
                        break;
                }
            }
            if (name.equals("�ˎ�̃C���V�O�j�A")) {
                switch (enchant) {
                    case 1:
                        op2.HP = 5;
                        break;
                    case 2:
                        op2.HP = 10;
                        break;
                    case 3:
                        op2.HP = 15;
                        break;               
                    case 4:
                        op2.HP = 20;
                        op2.AC = -1;
                        break;             
                    case 5:
                        op2.HP = 25;
                        op2.AC = -2;
                        op2.DMG_LONG = 1;
                        break;              
                    case 6:
                        op2.HP = 30;
                        op2.AC = -3;
                        op2.DMG_LONG = 2;
                        op2.CRI_LONG = 1;
                        break;              
                    case 7:
                        op2.HP = 35;
                        op2.AC = -3;
                        op2.DMG_LONG = 3;
                        op2.CRI_LONG = 3;
                        break;              
                    case 8:
                        op2.HP = 45;
                        op2.AC = -3;
                        op2.DMG_LONG = 4;
                        op2.CRI_LONG = 5;
                        break;
                }
            }
            if (name.equals("���҂̃C���V�O�j�A")) {
                switch (enchant) {
                    case 1:
                        op2.HP = 5;
                        break;
                    case 2:
                        op2.HP = 10;
                        break;
                    case 3:
                        op2.HP = 15;
                        break;               
                    case 4:
                        op2.HP = 20;
                        op2.AC = -1;
                        break;             
                    case 5:
                        op2.HP = 25;
                        op2.AC = -2;
                        op2.HIT_SHORT = 1;
                        break;              
                    case 6:
                        op2.HP = 30;
                        op2.AC = -3;
                        op2.HIT_SHORT = 2;
                        op2.CRI_MAGIC = 1;
                        break;              
                    case 7:
                        op2.HP = 35;
                        op2.AC = -3;
                        op2.HIT_SHORT = 3;
                        op2.CRI_MAGIC = 2;
                        break;              
                    case 8:
                        op2.HP = 45;
                        op2.AC = -3;
                        op2.HIT_SHORT = 4;
                        op2.CRI_MAGIC = 4;
                        break;
                }
            }
            if (name.equals("���̃C���V�O�j�A")) {
                switch (enchant) {
                    case 1:
                        op2.HP = 5;
                        break;
                    case 2:
                        op2.HP = 10;
                        break;
                    case 3:
                        op2.HP = 15;
                        op2.AC = -1;                      
                        break;               
                    case 4:
                        op2.HP = 20;
                        op2.AC = -2;
                        break;             
                    case 5:
                        op2.HP = 25;
                        op2.AC = -3;
                        op2.DR = 1;
                        break;              
                    case 6:
                        op2.HP = 30;
                        op2.AC = -5;
                        op2.DR = 2;
                        op2.MR = 3;
                        break;              
                    case 7:
                        op2.HP = 35;
                        op2.AC = -6;
                        op2.DR = 3;
                        op2.MR = 5;
                        break;              
                    case 8:
                        op2.HP = 45;
                        op2.AC = -7;
                        op2.DR = 4;
                        op2.MR = 7;
                        break;
                }
            }
            if (name.equals("�J�[�c�̓��m�̎��C���V�O�j�A")) {
                switch (enchant) {                          
                    case 6:
                        op2.AC = -5;
                        op2.HP = 35;
                        op2.DR = 2;
                        op2.DMG_SHORT = 2;
                        op2.MR = 3;
                        op2.CRI_SHORT = 1;
                        op2.HIT_SHORT = 1;
                        break;              
                    case 7:
                        op2.AC = -6;
                        op2.HP = 40;
                        op2.DR = 3;
                        op2.DMG_SHORT = 3;
                        op2.MR = 5;
                        op2.CRI_SHORT = 3;
                        op2.HIT_SHORT = 3;
                        op2.PVP_DR = 1;
                        break;              
                    case 8:
                        op2.AC = -7;
                        op2.HP = 50;
                        op2.DR = 4;
                        op2.DMG_SHORT = 4;
                        op2.MR = 7;
                        op2.CRI_SHORT = 5;
                        op2.HIT_SHORT = 5;
                        op2.PVP_DR = 2;
                        break;
                }
            }
            if (name.equals("�J�[�c�̎ˎ�̎��C���V�O�j�A")) {
                switch (enchant) {                          
                    case 6:
                        op2.AC = -5;
                        op2.HP = 35;
                        op2.DR = 2;
                        op2.DMG_LONG = 2;
                        op2.MR = 3;
                        op2.CRI_LONG = 1;
                        op2.HIT_LONG = 1;
                        break;              
                    case 7:
                        op2.AC = -6;
                        op2.HP = 40;
                        op2.DR = 3;
                        op2.DMG_LONG = 3;
                        op2.MR = 5;
                        op2.CRI_LONG = 3;
                        op2.HIT_LONG = 3;
                        op2.PVP_DR = 1;
                        break;              
                    case 8:
                        op2.AC = -7;
                        op2.HP = 50;
                        op2.DR = 4;
                        op2.DMG_LONG = 4;
                        op2.MR = 7;
                        op2.CRI_LONG = 5;
                        op2.HIT_LONG = 5;
                        op2.PVP_DR = 2;
                        break;
                }
            }
            if (name.equals("�J�[�c�̌��҂̎��C���V�O�j�A")) {
                switch (enchant) {                          
                    case 6:
                        op2.AC = -5;
                        op2.HP = 35;
                        op2.DR = 2;
                        op2.MR = 3;
                        op2.HIT_SHORT = 2;
                        op2.CRI_MAGIC = 1;
                        op2.HIT_MAGIC = 1;
                        break;              
                    case 7:
                        op2.AC = -6;
                        op2.HP = 40;
                        op2.DR = 3;
                        op2.MR = 5;
                        op2.HIT_SHORT = 3;
                        op2.CRI_MAGIC = 2;
                        op2.HIT_MAGIC = 3;
                        op2.PVP_DR = 1;
                        break;              
                    case 8:
                        op2.AC = -7;
                        op2.HP = 50;
                        op2.DR = 4;
                        op2.MR = 7;
                        op2.HIT_SHORT = 4;
                        op2.CRI_MAGIC = 4;
                        op2.HIT_MAGIC = 5;
                        op2.PVP_DR = 2;
                        break;
                }
            }
    }
}
