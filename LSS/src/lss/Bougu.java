package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Bougu implements Common {

    Buff op = new Buff();
    Buff op2 = new Buff();
    String name = "";
    String type = "";
//    String material = "";
//    String equip = "";
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
//        material = "";
//        equip = "";
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
            reader.mark(1_000_000);
            reader.reset();
            op.loadOption(reader);
            reader.reset();

            String line;
            while ((line = reader.readLine()) != null) {
//                if (line.startsWith("equip=")) {
//                    equip = line.split("=")[1];
//                }
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
//                if (line.startsWith("�ގ�=")) {
//                    material = line.split("=")[1];
//                }
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
//            System.out.println(e);
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
            text += " �ߋ����_���[�W+" + (op.DMG_SHORT + op2.DMG_SHORT);
        }
        if (op.HIT_SHORT + op2.HIT_SHORT > 0) {
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
            text += " �Z�p�ϐ�+" + (op.ailment[STUN] + op2.ailment[STUN]);
        }
        if (op.ailment[SPIRIT] + op2.ailment[SPIRIT] > 0) {
            text += " ����ϐ�+" + (op.ailment[SPIRIT] + op2.ailment[SPIRIT]);
        }
        if (op.ailment[SECRET] + op2.ailment[SECRET] > 0) {
            text += " ��Z�ϐ�+" + (op.ailment[SECRET] + op2.ailment[SECRET]);
        }
        if (op.ailment[TERROR] + op2.ailment[TERROR] > 0) {
            text += " ���|�ϐ�+" + (op.ailment[TERROR] + op2.ailment[TERROR]);
        }
        if (op.ailment[HIT_STUN] + op2.ailment[HIT_STUN] > 0) {
            text += " �Z�p����+" + (op.ailment[HIT_STUN] + op2.ailment[HIT_STUN]);
        }
        if (op.ailment[HIT_SPIRIT] + op2.ailment[HIT_SPIRIT] > 0) {
            text += " ���얽��+" + (op.ailment[HIT_SPIRIT] + op2.ailment[HIT_SPIRIT]);
        }
        if (op.ailment[HIT_SECRET] + op2.ailment[HIT_SECRET] > 0) {
            text += " ��Z����+" + (op.ailment[HIT_SECRET] + op2.ailment[HIT_SECRET]);
        }
        if (op.ailment[HIT_TERROR] + op2.ailment[HIT_TERROR] > 0) {
            text += " ���|����+" + (op.ailment[HIT_TERROR] + op2.ailment[HIT_TERROR]);
        }
        if (op.DR + op2.DR > 0) {
            text += " �_���[�W�ቺ+" + (op.DR + op2.DR);
        }
        if (op.DR_IGNORED + op2.DR_IGNORED > 0) {
            text += " �_���[�W�ቺ����+" + (op.DR_IGNORED + op2.DR_IGNORED);
        }
        if (op.PVP + op2.PVP > 0) {
            text += " PVP�ǉ��_���[�W+" + (op.PVP + op2.PVP);
        }
        if (op.PVP_DR + op2.PVP_DR > 0) {
            text += " PVP�_���[�W�ቺ+" + (op.PVP_DR + op2.PVP_DR);
        }
        if (op.c_weight + op2.c_weight > 0) {
            text += " �����d�ʑ���+" + (op.c_weight + op2.c_weight);
        }
        if (op.WEIGHT > 0) {
            text += " �d�� " + op.WEIGHT;
        }

        if (!op.effect.isEmpty()) {
            text += " " + op.effect;
        }
        if (!op2.effect.isEmpty()) {
            text += " " + op2.effect;
        }
        return text;
    }

    public void checkEnchant() {

        op2 = new Buff();

//T�V���c
        if (name.equals("�n����T�V���c")) {
            if (enchant >= 10) {
                    op2.MR = 14;
                    op2.DR = 3;
            } else if (enchant >= 9) {
                    op2.MR = 11;
                    op2.DR = 2;
            } else if (enchant >= 8) {
                    op2.MR = 8;
            } else if (enchant >= 7) {
                    op2.MR = 6;
            } else if (enchant >= 6) {
                    op2.MR = 5;
            } else if (enchant >= 5) {
                    op2.MR = 4;
            }
        }
        if (name.equals("�Η���T�V���c")) {
            if (enchant >= 10) {
                    op2.HP = 100;
                    op2.DMG_SHORT = 2;
            } else if (enchant >= 9) {
                    op2.HP = 90;
                    op2.DMG_SHORT = 1;
            } else if (enchant >= 8) {
                    op2.HP = 70;
            } else if (enchant >= 7) {
                    op2.HP = 50;
            } else if (enchant >= 6) {
                    op2.HP = 30;
            } else if (enchant >= 5) {
                    op2.HP = 20;
            }
        }
        if (name.equals("������T�V���c")) {
            if (enchant >= 10) {
                    op2.HP = 100;
                    op2.DMG_LONG = 2;
            } else if (enchant >= 9) {
                    op2.HP = 90;
                    op2.DMG_LONG = 1;
            } else if (enchant >= 8) {
                    op2.HP = 70;
            } else if (enchant >= 7) {
                    op2.HP = 50;
            } else if (enchant >= 6) {
                    op2.HP = 30;
            } else if (enchant >= 5) {
                    op2.HP = 20;
            }
        }
        if (name.equals("������T�V���c")) {
            if (enchant >= 10) {
                    op2.HP = 100;
                    op2.SP = 2;
            } else if (enchant >= 9) {
                    op2.HP = 90;
                    op2.SP = 1;
            } else if (enchant >= 8) {
                    op2.HP = 70;
            } else if (enchant >= 7) {
                    op2.HP = 50;
            } else if (enchant >= 6) {
                    op2.HP = 30;
            } else if (enchant >= 5) {
                    op2.HP = 20;
            }
        }
        if (name.equals("����T�V���c")) {
            if (enchant >= 10) {
                op2.DR = 5;                 //�_���[�W�ቺ+5
                op2.MR = 5;                 //MR+5
                op2.ailment[STUN] = 5;      //�Z�p�ϐ�+5
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
                op2.ailment[TERROR] = 5;    //���|�ϐ�+5
            } else if (enchant >= 9) {
                op2.DR = 4;                 //�_���[�W�ቺ+4
                op2.MR = 4;                 //MR+4
                op2.ailment[STUN] = 4;      //�Z�p�ϐ�+4
                op2.ailment[SPIRIT] = 4;    //����ϐ�+4
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
                op2.ailment[TERROR] = 4;    //���|�ϐ�+4
            } else if (enchant >= 8) {
                op2.DR = 3;                 //�_���[�W�ቺ+3
                op2.MR = 3;                 //MR+3
                op2.ailment[STUN] = 3;      //�Z�p�ϐ�+3
                op2.ailment[SPIRIT] = 3;    //����ϐ�+3
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
                op2.ailment[TERROR] = 3;    //���|�ϐ�+3
            } else if (enchant >= 7) {
                op2.DR = 2;                 //�_���[�W�ቺ+2
                op2.MR = 2;                 //MR+2
                op2.ailment[STUN] = 2;      //�Z�p�ϐ�+2
                op2.ailment[SPIRIT] = 2;    //����ϐ�+2
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
                op2.ailment[TERROR] = 2;    //���|�ϐ�+2
            } else if (enchant >= 6) {
                op2.DR = 1;                 //�_���[�W�ቺ+1
                op2.MR = 1;                 //MR+1
                op2.ailment[STUN] = 1;      //�Z�p�ϐ�+1
                op2.ailment[SPIRIT] = 1;    //����ϐ�+1
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
                op2.ailment[TERROR] = 1;    //���|�ϐ�+1
            }
        }
        if (name.equals("���m�̗�T�V���c")) {             //AC-2 STR+1 �ߋ����_���[�W+1
            if (enchant >= 10) {
                    op2.DMG_SHORT = 1;                   //�ߋ����_���[�W+1(���v2)
                    op2.HIT_SHORT = 7;                   //�ߋ�������+7
                    op2.HP = 100;                        //HP+100
                    op2.PVP = 1;                         //PVP�ǉ��_���[�W+1
                    op2.PVP_DR = 1;                      //PVP�_���[�W�ቺ+1
                    op2.ailment[STUN] = 18;              //�Z�p�ϐ�+18
                    op2.ailment[SPIRIT] = 6;             //����ϐ�+6
                    op2.ailment[SECRET] = 6;             //��Z�ϐ�+6
                    op2.ailment[TERROR] = 6;             //���|�ϐ�+6
            } else if (enchant >= 9) {
                    op2.DMG_SHORT = 1;                   //�ߋ����_���[�W+1(���v2)
                    op2.HIT_SHORT = 5;                   //�ߋ�������+5
                    op2.ailment[STUN] = 15;              //�Z�p�ϐ�+15
                    op2.ailment[SPIRIT] = 4;             //����ϐ�+4
                    op2.ailment[SECRET] = 4;             //��Z�ϐ�+4
                    op2.ailment[TERROR] = 4;             //���|�ϐ�+4
            } else if (enchant >= 8) {
                    op2.HIT_SHORT = 3;                   //�ߋ�������+3
                    op2.ailment[STUN] = 12;              //�Z�p�ϐ�+12
                    op2.ailment[SPIRIT] = 2;             //����ϐ�+2
                    op2.ailment[SECRET] = 2;             //��Z�ϐ�+2
                    op2.ailment[TERROR] = 2;             //���|�ϐ�+2
            } else if (enchant >= 7) {
                    op2.HIT_SHORT = 1;                   //�ߋ�������+1
                    op2.ailment[STUN] = 10;              //�Z�p�ϐ�+10
                    op2.ailment[SPIRIT] = 1;             //����ϐ�+1
                    op2.ailment[SECRET] = 1;             //��Z�ϐ�+1
                    op2.ailment[TERROR] = 1;             //���|�ϐ�+1
            } else if (enchant >= 6) {
                    op2.ailment[STUN] = 9;               //�Z�p�ϐ�+9
            } else if (enchant >= 5) {
                    op2.ailment[STUN] = 8;               //�Z�p�ϐ�+8                  
            }
        }
        if (name.equals("�ˎ�̗�T�V���c")) {             //AC-2 DEX+1 �������_���[�W+1
            if (enchant >= 10) {
                    op2.DMG_LONG = 1;                    //�������_���[�W+1(���v2)
                    op2.HIT_LONG = 7;                    //����������+7
                    op2.HP = 100;                        //HP+100
                    op2.PVP = 1;                         //PVP�ǉ��_���[�W+1
                    op2.PVP_DR = 1;                      //PVP�_���[�W�ቺ+1
                    op2.ailment[STUN] = 18;              //�Z�p�ϐ�+18
                    op2.ailment[SPIRIT] = 6;             //����ϐ�+6
                    op2.ailment[SECRET] = 6;             //��Z�ϐ�+6
                    op2.ailment[TERROR] = 6;             //���|�ϐ�+6
            } else if (enchant >= 9) {
                    op2.DMG_LONG = 1;                    //�������_���[�W+1(���v2)
                    op2.HIT_LONG = 5;                    //����������+5
                    op2.ailment[STUN] = 15;              //�Z�p�ϐ�+15
                    op2.ailment[SPIRIT] = 4;             //����ϐ�+4
                    op2.ailment[SECRET] = 4;             //��Z�ϐ�+4
                    op2.ailment[TERROR] = 4;             //���|�ϐ�+4
            } else if (enchant >= 8) {
                    op2.HIT_LONG = 3;                    //����������+3
                    op2.ailment[STUN] = 12;              //�Z�p�ϐ�+12
                    op2.ailment[SPIRIT] = 2;             //����ϐ�+2
                    op2.ailment[SECRET] = 2;             //��Z�ϐ�+2
                    op2.ailment[TERROR] = 2;             //���|�ϐ�+2
            } else if (enchant >= 7) {
                    op2.HIT_LONG = 1;                    //����������+1
                    op2.ailment[STUN] = 10;              //�Z�p�ϐ�+10
                    op2.ailment[SPIRIT] = 1;             //����ϐ�+1
                    op2.ailment[SECRET] = 1;             //��Z�ϐ�+1
                    op2.ailment[TERROR] = 1;             //���|�ϐ�+1
            } else if (enchant >= 6) {
                    op2.ailment[STUN] = 9;               //�Z�p�ϐ�+9
            } else if (enchant >= 5) {
                    op2.ailment[STUN] = 8;               //�Z�p�ϐ�+8                  
            }
        }
        if (name.equals("���҂̗�T�V���c")) {             //AC-2 INT+1 SP+1
            if (enchant >= 10) {
                    op2.SP = 2;                          //SP+2(���v3)
                    op2.HIT_MAGIC = 5;                   //���@����+5
                    op2.HP = 100;                        //HP+100
                    op2.PVP = 1;                         //PVP�ǉ��_���[�W+1
                    op2.PVP_DR = 1;                      //PVP�_���[�W�ቺ+1
                    op2.ailment[STUN] = 18;              //�Z�p�ϐ�+18
                    op2.ailment[SPIRIT] = 6;             //����ϐ�+6
                    op2.ailment[SECRET] = 6;             //��Z�ϐ�+6
                    op2.ailment[TERROR] = 6;             //���|�ϐ�+6
            } else if (enchant >= 9) {
                    op2.SP = 1;                          //SP+1(���v2)
                    op2.HIT_MAGIC = 4;                   //���@����+4
                    op2.ailment[STUN] = 15;              //�Z�p�ϐ�+15
                    op2.ailment[SPIRIT] = 4;             //����ϐ�+4
                    op2.ailment[SECRET] = 4;             //��Z�ϐ�+4
                    op2.ailment[TERROR] = 4;             //���|�ϐ�+4
            } else if (enchant >= 8) {
                    op2.SP = 1;                          //SP+1(���v2)
                    op2.HIT_MAGIC = 2;                   //���@����+2
                    op2.ailment[STUN] = 12;              //�Z�p�ϐ�+12
                    op2.ailment[SPIRIT] = 2;             //����ϐ�+2
                    op2.ailment[SECRET] = 2;             //��Z�ϐ�+2
                    op2.ailment[TERROR] = 2;             //���|�ϐ�+2
            } else if (enchant >= 7) {
                    op2.SP = 1;                          //SP+1(���v2)
                    op2.ailment[STUN] = 10;              //�Z�p�ϐ�+10
                    op2.ailment[SPIRIT] = 1;             //����ϐ�+1
                    op2.ailment[SECRET] = 1;             //��Z�ϐ�+1
                    op2.ailment[TERROR] = 1;             //���|�ϐ�+1
            } else if (enchant >= 6) {
                    op2.ailment[STUN] = 9;               //�Z�p�ϐ�+9
            } else if (enchant >= 5) {
                    op2.ailment[STUN] = 8;               //�Z�p�ϐ�+8                  
            }
        }
        if (name.equals("���̗�T�V���c")) {             //AC-2 WIS+1 �_���[�W�ቺ+1
            if (enchant >= 10) {
                    op2.DR = 1;                          //�_���[�W�ቺ+1(���v2)
                    op2.MR = 14;                         //MR+14
                    op2.HP = 100;                        //HP+100
                    op2.PVP = 1;                         //PVP�ǉ��_���[�W+1
                    op2.PVP_DR = 1;                      //PVP�_���[�W�ቺ+1
                                                         //EXP+8%
            } else if (enchant >= 9) {
                    op2.DR = 1;                          //�_���[�W�ቺ+1(���v2)
                    op2.MR = 11;                         //MR+11
                                                         //EXP+6%
            } else if (enchant >= 8) {
                    op2.MR = 8;                          //MR+8
                                                         //EXP+4%
            } else if (enchant >= 7) {
                    op2.MR = 5;                          //MR+6
                                                         //EXP+2%
            } else if (enchant >= 6) {
                    op2.MR = 5;                          //MR+5
            } else if (enchant >= 5) {
                    op2.MR = 4;                          //MR+4                 
            }
        }
//�V�[���h&�K�[�_�[
        if (name.equals("�V�A�[�̐S��")) {
            if (enchant >= 9) {
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
            } else if (enchant >= 8) {
                op2.ailment[SPIRIT] = 4;    //����ϐ�+4
            } else if (enchant >= 7) {
                op2.ailment[SPIRIT] = 3;    //����ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[SPIRIT] = 2;    //����ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[SPIRIT] = 1;    //����ϐ�+1
            }
        }
        if (name.equals("�G���@�̃V�[���h")) {
            if (enchant >= 9) {
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
            } else if (enchant >= 8) {
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
            } else if (enchant >= 7) {
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
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
        if (name.equals("�e�C�p�[�K�[�_�[(�r��)")) {
            if (enchant >= 9) {
                op2.HIT_SHORT = 3;           	//�ߋ�������+3
                op2.DMG_SHORT = 3;           	//�ߋ����_���[�W+3
                op2.ST[STR] = 1;           	//STR+1
                op2.PVP = 2;			//PVP+2

            } else if (enchant >= 8) {
                op2.HIT_SHORT = 2;           	//�ߋ�������+2
                op2.DMG_SHORT = 2;           	//�ߋ����_���[�W+2
                op2.ST[STR] = 1;           	//STR+1
                op2.PVP = 1;           		//PVP+1

            } else if (enchant >= 7) {
                op2.HIT_SHORT = 2;           	//�ߋ�������+2
                op2.DMG_SHORT = 1;           	//�ߋ����_���[�W+1
                op2.ST[STR] = 1;           	//STR+1

            } else if (enchant >= 6) {
                op2.HIT_SHORT = 2;           	//�ߋ�������+2
                op2.DMG_SHORT = 1;           	//�ߋ����_���[�W+1

            } else if (enchant >= 5) {
                op2.HIT_SHORT = 1;           	//�ߋ�������+1

            }
        }
        if (name.equals("�e�C�p�[�K�[�_�[(�@�q)")) {
            if (enchant >= 9) {
                op2.HIT_LONG = 3;           	//����������+3
                op2.DMG_LONG = 3;           	//�������_���[�W+3
                op2.ST[DEX] = 1;           	//DEX+1
                op2.PVP = 2;			//PVP+2

            } else if (enchant >= 8) {
                op2.HIT_LONG = 2;           	//����������+2
                op2.DMG_LONG = 2;           	//�������_���[�W+2
                op2.ST[DEX] = 1;           	//DEX+1
                op2.PVP = 1;           		//PVP+1

            } else if (enchant >= 7) {
                op2.HIT_LONG = 2;           	//����������+2
                op2.DMG_LONG = 1;           	//�������_���[�W+1
                op2.ST[DEX] = 1;           	//DEX+1

            } else if (enchant >= 6) {
                op2.HIT_LONG = 2;           	//����������+2
                op2.DMG_LONG = 1;           	//�������_���[�W+1

            } else if (enchant >= 5) {
                op2.HIT_LONG = 1;           	//����������+1

            }
        }
        if (name.equals("�e�C�p�[�K�[�_�[(�m��)")) {
            if (enchant >= 9) {
                op2.MPR = 6;           		//MPR+6
                op2.SP = 3;           		//SP+3
                op2.ST[INT] = 1;           	//INT+1
                op2.PVP = 2;			//PVP+2

            } else if (enchant >= 8) {
                op2.MPR = 4;           		//MPR+4
                op2.SP = 2;           		//SP+2
                op2.ST[INT] = 1;           	//INT+1
                op2.PVP = 1;           		//PVP+1

            } else if (enchant >= 7) {
                op2.MPR = 4;           		//MPR+4
                op2.SP = 1;           		//SP+1
                op2.ST[INT] = 1;           	//INT+1

            } else if (enchant >= 6) {
                op2.MPR = 2;           		//MPR+2
                op2.SP = 1;           		//SP+1

            } else if (enchant >= 5) {
                op2.MPR = 2;           		//MPR+2

            }
        }
        if (name.equals("�N�[�K�[�̃K�[�_�[")) {
            if (enchant >= 9) {
                op2.HIT_SHORT = 5;          //�ߋ�������
                op2.ailment[STUN] = 5;      //�Z�p�ϐ�
                op2.ailment[SPIRIT] = 5;    //����ϐ� 
                op2.ailment[SECRET] = 5;    //��Z�ϐ�
                op2.ailment[TERROR] = 5;    //���|�ϐ�
            } else if (enchant >= 8) {
                op2.HIT_SHORT = 4;          //�ߋ�������
                op2.ailment[STUN] = 4;      //�Z�p�ϐ�
                op2.ailment[SPIRIT] = 4;    //����ϐ� 
                op2.ailment[SECRET] = 4;    //��Z�ϐ�
                op2.ailment[TERROR] = 4;    //���|�ϐ�
            } else if (enchant >= 7) {
                op2.HIT_SHORT = 3;          //�ߋ�������
                op2.ailment[STUN] = 3;      //�Z�p�ϐ�
                op2.ailment[SPIRIT] = 3;    //����ϐ� 
                op2.ailment[SECRET] = 3;    //��Z�ϐ�
                op2.ailment[TERROR] = 3;    //���|�ϐ�
            } else if (enchant >= 6) {
                op2.HIT_SHORT = 2;          //�ߋ�������
                op2.ailment[STUN] = 2;      //�Z�p�ϐ�
                op2.ailment[SPIRIT] = 2;    //����ϐ� 
                op2.ailment[SECRET] = 2;    //��Z�ϐ�
                op2.ailment[TERROR] = 2;    //���|�ϐ�
            } else if (enchant >= 5) {
                op2.HIT_SHORT = 1;          //�ߋ�������
                op2.ailment[STUN] = 1;      //�Z�p�ϐ�
                op2.ailment[SPIRIT] = 1;    //����ϐ� 
                op2.ailment[SECRET] = 1;    //��Z�ϐ�
                op2.ailment[TERROR] = 1;    //���|�ϐ�
            }
        }
        if (name.equals("�E�O�k�X�̃K�[�_�[")) {
            if (enchant >= 9) {
                op2.HIT_LONG = 5;           //����������+5
                op2.ailment[STUN] = 5;      //�Z�p�ϐ�+5
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
                op2.ailment[TERROR] = 5;    //���|�ϐ�+5
            } else if (enchant >= 8) {
                op2.HIT_LONG = 4;           //����������+4
                op2.ailment[STUN] = 4;      //�Z�p�ϐ�+4
                op2.ailment[SPIRIT] = 4;    //����ϐ�+4
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
                op2.ailment[TERROR] = 4;    //���|�ϐ�+4
            } else if (enchant >= 7) {
                op2.HIT_LONG = 3;           //����������+3
                op2.ailment[STUN] = 3;      //�Z�p�ϐ�+3
                op2.ailment[SPIRIT] = 3;    //����ϐ�+3
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
                op2.ailment[TERROR] = 3;    //���|�ϐ�+3
            } else if (enchant >= 6) {
                op2.HIT_LONG = 2;           //����������+2
                op2.ailment[STUN] = 2;      //�Z�p�ϐ�+2
                op2.ailment[SPIRIT] = 2;    //����ϐ�+2
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
                op2.ailment[TERROR] = 2;    //���|�ϐ�+2
            } else if (enchant >= 5) {
                op2.HIT_LONG = 1;           //����������+1
                op2.ailment[STUN] = 1;      //�Z�p�ϐ�+1
                op2.ailment[SPIRIT] = 1;    //����ϐ�+1
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
                op2.ailment[TERROR] = 1;    //���|�ϐ�+1
            }
        }
        if (name.equals("�Η�̃K�[�_�[")) {
            if (enchant >= 11) {
                op2.DMG_SHORT = enchant-6;  //�ߋ����_���[�W+(enchant-6)
                op2.HIT_SHORT = enchant-4;  //�ߋ�������+(enchant-4)
                op2.ailment[STUN] = 5;      //�Z�p�ϐ�+5
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
                op2.ailment[TERROR] = 5;    //���|�ϐ�+5               
            } else if (enchant >= 10) {
                op2.DMG_SHORT = 4;          //�ߋ����_���[�W+4
                op2.HIT_SHORT = 6;          //�ߋ�������+6
                op2.ailment[STUN] = 5;      //�Z�p�ϐ�+5
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
                op2.ailment[TERROR] = 5;    //���|�ϐ�+5
            } else if (enchant >= 9) {
                op2.DMG_SHORT = 3;          //�ߋ����_���[�W+3
                op2.HIT_SHORT = 5;          //�ߋ�������+5
                op2.ailment[STUN] = 4;      //�Z�p�ϐ�+4
                op2.ailment[SPIRIT] = 4;    //����ϐ�+4
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
                op2.ailment[TERROR] = 4;    //���|�ϐ�+4
            } else if (enchant >= 8) {
                op2.DMG_SHORT = 2;          //�ߋ����_���[�W+2
                op2.HIT_SHORT = 4;          //�ߋ�������+4
                op2.ailment[STUN] = 3;      //�Z�p�ϐ�+3
                op2.ailment[SPIRIT] = 3;    //����ϐ�+3
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
                op2.ailment[TERROR] = 3;    //���|�ϐ�+3  
            } else if (enchant >= 7) {
                op2.DMG_SHORT = 1;          //�ߋ����_���[�W+1
                op2.HIT_SHORT = 3;          //�ߋ�������+3
                op2.ailment[STUN] = 2;      //�Z�p�ϐ�+2
                op2.ailment[SPIRIT] = 2;    //����ϐ�+2
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
                op2.ailment[TERROR] = 2;    //���|�ϐ�+2
            } else if (enchant >= 6) {
                op2.HIT_SHORT = 2;          //�ߋ�������+2
                op2.ailment[STUN] = 1;      //�Z�p�ϐ�+1
                op2.ailment[SPIRIT] = 1;    //����ϐ�+1
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
                op2.ailment[TERROR] = 1;    //���|�ϐ�+1
            } else if (enchant >= 5) {
                op2.HIT_SHORT = 1;          //�ߋ�������+1
            }
        }
        if (name.equals("����̃K�[�_�[")) {
            if (enchant >= 11) {
                op2.DMG_LONG = enchant-6;   //�������_���[�W+(enchant-6)
                op2.HIT_LONG = enchant-4;   //����������+(enchant-4)
                op2.ailment[STUN] = 5;      //�Z�p�ϐ�+5
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
                op2.ailment[TERROR] = 5;    //���|�ϐ�+5               
            } else if (enchant >= 10) {
                op2.DMG_LONG = 4;           //�������_���[�W+4
                op2.HIT_LONG = 6;           //����������+6
                op2.ailment[STUN] = 5;      //�Z�p�ϐ�+5
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
                op2.ailment[TERROR] = 5;    //���|�ϐ�+5
            } else if (enchant >= 9) {
                op2.DMG_LONG = 3;           //�������_���[�W+3
                op2.HIT_LONG = 5;           //����������+5
                op2.ailment[STUN] = 4;      //�Z�p�ϐ�+4
                op2.ailment[SPIRIT] = 4;    //����ϐ�+4
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
                op2.ailment[TERROR] = 4;    //���|�ϐ�+4
            } else if (enchant >= 8) {
                op2.DMG_LONG = 2;           //�������_���[�W+2
                op2.HIT_LONG = 4;           //����������+4
                op2.ailment[STUN] = 3;      //�Z�p�ϐ�+3
                op2.ailment[SPIRIT] = 3;    //����ϐ�+3
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
                op2.ailment[TERROR] = 3;    //���|�ϐ�+3
            } else if (enchant >= 7) {
                op2.DMG_LONG = 1;           //�������_���[�W+1
                op2.HIT_LONG = 3;           //����������+3
                op2.ailment[STUN] = 2;      //�Z�p�ϐ�+2
                op2.ailment[SPIRIT] = 2;    //����ϐ�+2
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
                op2.ailment[TERROR] = 2;    //���|�ϐ�+2
            } else if (enchant >= 6) {
                op2.HIT_LONG = 2;           //����������+2
                op2.ailment[STUN] = 1;      //�Z�p�ϐ�+1
                op2.ailment[SPIRIT] = 1;    //����ϐ�+1
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
                op2.ailment[TERROR] = 1;    //���|�ϐ�+1
            } else if (enchant >= 5) {
                op2.HIT_LONG = 1;           //����������+1
            }
        }
        if (name.equals("����̃K�[�_�[")) {
            if (enchant >= 11) {
                op2.SP = enchant-6;         //SP+(enchant-6)
                op2.HIT_MAGIC = enchant-4;  //���@����+(enchant-4)
                op2.ailment[STUN] = 5;      //�Z�p�ϐ�+5
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
                op2.ailment[TERROR] = 5;    //���|�ϐ�+5
            } else if (enchant >= 10) {
                op2.SP = 4;                 //SP+4
                op2.HIT_MAGIC = 6;          //���@����+6
                op2.ailment[STUN] = 5;      //�Z�p�ϐ�+5
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
                op2.ailment[TERROR] = 5;    //���|�ϐ�+5
            } else if (enchant >= 9) {
                op2.SP = 3;                 //SP+3
                op2.HIT_MAGIC = 5;          //���@����+5
                op2.ailment[STUN] = 4;      //�Z�p�ϐ�+4
                op2.ailment[SPIRIT] = 4;    //����ϐ�+4
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
                op2.ailment[TERROR] = 4;    //���|�ϐ�+4
            } else if (enchant >= 8) {
                op2.SP = 2;                 //SP+2
                op2.HIT_MAGIC = 4;          //���@����+4
                op2.ailment[STUN] = 3;      //�Z�p�ϐ�+3
                op2.ailment[SPIRIT] = 3;    //����ϐ�+3
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
                op2.ailment[TERROR] = 3;    //���|�ϐ�+3
            } else if (enchant >= 7) {
                op2.SP = 1;                 //SP+1
                op2.HIT_MAGIC = 3;          //���@����+3
                op2.ailment[STUN] = 2;      //�Z�p�ϐ�+2
                op2.ailment[SPIRIT] = 2;    //����ϐ�+2
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
                op2.ailment[TERROR] = 2;    //���|�ϐ�+2
            } else if (enchant >= 6) {
                op2.HIT_MAGIC = 2;          //���@����+2
                op2.ailment[STUN] = 1;      //�Z�p�ϐ�+1
                op2.ailment[SPIRIT] = 1;    //����ϐ�+1
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
                op2.ailment[TERROR] = 1;    //���|�ϐ�+1
            } else if (enchant >= 5) {
                op2.HIT_MAGIC = 1;          //���@����+1
            }
        }
        if (name.equals("�n��̃K�[�_�[")) {
            if (enchant >= 7) {
                op2.DR = enchant-6;         //�_���[�W�ቺ+(enchant-6)
                op2.MR = enchant-4;         //MR+(enchant-4)
            } else if (enchant >= 6) {
                op2.MR = 2;                 //MR+2
            } else if (enchant >= 5) {
                op2.MR = 1;                 //MR+1
            }
        }
//�w����
        if (name.equals("�}�~�[���[�h�N���E��")) {
            if (enchant >= 9) {
                op2.DMG_LONG = 3;
            } else if (enchant >= 8) {
                op2.DMG_LONG = 2;
            } else if (enchant >= 7) {
                op2.DMG_LONG = 1;
            }
        }
        if (name.equals("�u���b�N�i�C�g�w����")) {
            if (enchant >= 5) {
                op2.MR += 4 * (enchant -4);
            }
        }
        if (name.equals("�喂�p�t�̖X�q")) {
            op2.MP = 10 * enchant;
            if (enchant >= 9) {
                op2.ailment[SPIRIT] = 5;         //����ϐ�+5
            } else if (enchant >= 8) {
                op2.ailment[SPIRIT] = 4;         //����ϐ�+4
            } else if (enchant >= 7) {
                op2.ailment[SPIRIT] = 3;         //����ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[SPIRIT] = 2;         //����ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[SPIRIT] = 1;         //����ϐ�+1
            }
        }
        if (name.equals("�}���{�n�b�g")) {
            if (enchant >= 7) {
                op2.ST[CHA] = 1;
            }
        }
//�u�[�c
        if (name.equals("�r�͂̃u�[�c")) {
            if (enchant >= 9) {
                op2.DR = 1;
                op2.HP = 60;
            } else if (enchant >= 8) {
                op2.HP = 40;
            } else if (enchant >= 7) {
                op2.HP = 20;
            }
        }
        if (name.equals("�@�q�̃u�[�c")) {
            if (enchant >= 9) {
                op2.DR = 1;
                op2.HP = 60;
            } else if (enchant >= 8) {
                op2.HP = 40;
            } else if (enchant >= 7) {
                op2.HP = 20;
            }
        }
        if (name.equals("�m�͂̃u�[�c")) {
            if (enchant >= 9) {
                op2.DR = 1;
                op2.HP = 60;
            } else if (enchant >= 8) {
                op2.HP = 40;
            } else if (enchant >= 7) {
                op2.HP = 20;
            }
        }
        if (name.equals("�m�b�̃u�[�c")) {
            if (enchant >= 9) {
                op2.DR = 1;
                op2.HP = 60;
            } else if (enchant >= 8) {
                op2.HP = 40;
            } else if (enchant >= 7) {
                op2.HP = 20;
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
        if (name.equals("�A�C���X�̃u�[�c")) {
            if (enchant >= 9) {
                op2.ailment[STUN] = 5;      //�Z�p�ϐ�+5
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
                op2.ailment[TERROR] = 5;    //���|�ϐ�+5
            } else if (enchant >= 8) {
                op2.ailment[STUN] = 4;      //�Z�p�ϐ�+4
                op2.ailment[SPIRIT] = 4;    //����ϐ�+4
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
                op2.ailment[TERROR] = 4;    //���|�ϐ�+4
            } else if (enchant >= 7) {
                op2.ailment[STUN] = 3;      //�Z�p�ϐ�+3
                op2.ailment[SPIRIT] = 3;    //����ϐ�+3
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
                op2.ailment[TERROR] = 3;    //���|�ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[STUN] = 2;      //�Z�p�ϐ�+2
                op2.ailment[SPIRIT] = 2;    //����ϐ�+2
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
                op2.ailment[TERROR] = 2;    //���|�ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[STUN] = 1;      //�Z�p�ϐ�+1
                op2.ailment[SPIRIT] = 1;    //����ϐ�+1
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
                op2.ailment[TERROR] = 1;    //���|�ϐ�+1
            }
        }
//�N���[�N
        if (name.equals("�����̃}���g")) {
            if (enchant >= 9) {
                op2.ST[CHA] = 3;
            } else if (enchant >= 8) {
                op2.ST[CHA] = 2;
            } else if (enchant >= 7) {
                op2.ST[CHA] = 1;
            }
        }
        if (name.equals("�t�B�A�o���p�C�A�}���g")) {
            if (enchant >= 9) {
                op2.ailment[TERROR] = 5;    //���|�ϐ�+5
            } else if (enchant >= 8) {
                op2.ailment[TERROR] = 4;    //���|�ϐ�+4
            } else if (enchant >= 7) {
                op2.ailment[TERROR] = 3;    //���|�ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[TERROR] = 2;    //���|�ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[TERROR] = 1;    //���|�ϐ�+1
            }
        }
        if (name.equals("�A���g�N�C�[���S�[���f���E�B���O") || name.equals("�A���g�N�C�[���V���o�[�E�B���O")) {
            if (enchant >= 9) {
                op2.ailment[SPIRIT] = 5;    //����ϐ�+5
            } else if (enchant >= 8) {
                op2.ailment[SPIRIT] = 4;    //����ϐ�+4
            } else if (enchant >= 7) {
                op2.ailment[SPIRIT] = 3;    //����ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[SPIRIT] = 2;    //����ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[SPIRIT] = 1;    //����ϐ�+1
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
//�A�[�}
        if (name.equals("�}���{�R�[�g")) {
            if (enchant >= 7) {
                op2.ST[CHA] = 1;
            }
        }
        if (name.contains("���b�`���[�u")) {
            if (enchant >= 3) {
                op2.SP = enchant - 2;
            }
        }
        if (name.contains("�A���^���X�O�����h")) {
            if (enchant >= 9) {
                op2.DR += enchant - 6;      //�_���[�W�ቺ+(�����l-6)
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
            } else if (enchant >= 8) {
                op2.DR += 2;                //�_���[�W�ቺ+2
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
            } else if (enchant >= 7) {
                op2.DR += 1;                //�_���[�W�ቺ+1
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
            }
        }
        if (name.contains("�p�v���I���n�C�h��") || name.contains("�����h�r�I���X�g�[��")){
            if (enchant >= 9) {
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
            } else if (enchant >= 8) {
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
            } else if (enchant >= 7) {
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
            }
        }
        if (name.equals("���@���J�X�t���C���v���[�g���C��")) {
            if (enchant >= 9) {
                op2.CRI_SHORT = 3;
                op2.DR_IGNORED = 3;
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
            } else if (enchant >= 8) {
                op2.CRI_SHORT = 2;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
            } else if (enchant >= 7) {
                op2.CRI_SHORT = 1;
                op2.DR_IGNORED = 1;
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1   
            }
        }
        if (name.equals("���@���J�X�t���C���X�P�C�����C��")) {
            if (enchant >= 9) {
                op2.CRI_SHORT = 3;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
            } else if (enchant >= 8) {
                op2.CRI_SHORT = 2;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
            } else if (enchant >= 7) {
                op2.CRI_SHORT = 1;
                op2.DR_IGNORED = 1;
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
            }
        }
        if (name.equals("���@���J�X�t���C�����U�[�A�[�}�[")) {
            if (enchant >= 9) {
                op2.CRI_LONG = 3;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
            } else if (enchant >= 8) {
                op2.CRI_LONG = 2;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
            } else if (enchant >= 7) {
                op2.CRI_LONG = 1;
                op2.DR_IGNORED = 1;
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
            }
        }
        if (name.equals("���@���J�X�t���C�����[�u")) {
            if (enchant >= 9) {
                op2.CRI_MAGIC = 3;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 5;    //��Z�ϐ�+5
            } else if (enchant >= 8) {
                op2.CRI_MAGIC = 2;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 4;    //��Z�ϐ�+4
            } else if (enchant >= 7) {
                op2.CRI_MAGIC = 1;
                op2.DR_IGNORED = 1;
                op2.ailment[SECRET] = 3;    //��Z�ϐ�+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //��Z�ϐ�+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //��Z�ϐ�+1
            }
        }
//�O���[�u
        if (name.equals("�P�����͂̃O���[�u")) {
            if (enchant > 4) {
                op2.c_weight += 60 * (enchant - 4);
            }
        }
        if (name.equals("�}�~�[���[�h�̃O���[�u")) {
            if (enchant >= 9) {
                op2.SP = 3;
            } else if (enchant >= 8) {
                op2.SP = 2;
            } else if (enchant >= 7) {
                op2.SP = 1;
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
            //+10�����I�v�V����[�_���[�W�ቺ+1]
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
            //+10�����I�v�V����[�_���[�W�ቺ+1]
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
            //+10�����I�v�V����[�_���[�W�ቺ+1]
            if (enchant >= 10) {
                op2.DR = 1;
            }
        }
//�X�i�b�p�[�����O
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
                            op2.ailment[STUN] += 2;     //�Z�p�ϐ�+2           //�Z�p�ϐ�+9
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
                            op2.ailment[STUN] += 2;     //�Z�p�ϐ�+2           //�Z�p�ϐ�+7
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
                            op2.ailment[STUN] += 5;     //�Z�p�ϐ�+5           //�Z�p�ϐ�+5
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
                            op2.ailment[STUN] += 2;     //�Z�p�ϐ�+2           //�Z�p�ϐ�+9                          
                            op2.HP += 10;               //HP+10                 //HP+50
                            op2.MP += 5;                //MP+5                  //MP+35
                                                                                //MP���R��+1
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2 
                                                                                //�����d�ʑ���+360
                        case 7:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.SP++;                   //SP+1                  //SP+4
                            op2.HIT_MAGIC++;            //���@����+1             //���@����+2
                            op2.ailment[STUN] += 2;     //�Z�p�ϐ�+2           //�Z�p�ϐ�+7
                            op2.HP += 5;                //HP+5                  //HP+40
                            op2.MP += 5;                //MP+5                  //MP+30
                                                                                //MP���R��+1
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //�����d�ʑ���+360
                        case 6:
                                                                                //AC-5 
                            op2.SP++;                   //SP+1                  //SP+3
                            op2.HIT_MAGIC++;            //���@����+1             //���@����+1
                            op2.ailment[STUN] += 5;     //�Z�p�ϐ�+5           //�Z�p�ϐ�+5
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
                            op2.ailment[STUN] += 2;     //�Z�p�ϐ�+2           //�Z�p�ϐ�+9
                            op2.HP += 10;               //HP+10                 //HP+115
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //�����d�ʑ���+360
                        case 7:
                            op2.AC--;                   //AC-1                  //AC-7
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+4
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                            op2.DR++;                   //DR+1                  //DR+2
                                                        //�m���_���[�W�ቺ20 +1% //�m���_���[�W�ቺ20 +2%
                            op2.ailment[STUN] += 2;     //�Z�p�ϐ�+2           //�Z�p�ϐ�+7
                            op2.HP += 10;               //HP+10                 //HP+105
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //�����d�ʑ���+360
                        case 6:
                                                                                //AC-6
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+3
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                            op2.DR++;                   //DR+1                  //DR+1
                                                        //�m���_���[�W�ቺ20 +1% //�m���_���[�W�ቺ20 +1%
                            op2.ailment[STUN] += 5;     //�Z�p�ϐ�+5           //�Z�p�ϐ�+5
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
                            op2.ailment[STUN] += 2;     //�Z�p�ϐ�+2           //�Z�p�ϐ�+9
                                                                                //HP+50
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //�����d�ʑ���+360
                        case 7:
                            op2.AC--;                   //AC-3                  //AC-7
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+4
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                            op2.MR++;                   //MR+1                  //MR+9
                                                        //�m�����@���+2         //�m�����@���+3
                            op2.ailment[STUN] += 2;     //�Z�p�ϐ�+2           //�Z�p�ϐ�+7
                            op2.HP += 5;                //HP+5                  //HP+50
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //�����d�ʑ���+360
                        case 6:
                                                                                //AC-6
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+3
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                            op2.MR++;                   //MR+1                  //MR+8
                                                        //�m�����@���+1         //�m�����@���+1
                            op2.ailment[STUN] += 5;     //�Z�p�ϐ�+5           //�Z�p�ϐ�+5
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
                            op2.ailment[STUN] += 2;     //�Z�p�ϐ�+2           //�Z�p�ϐ�+9
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 7:
                                                                                //AC-5
                            op2.HP += 5;                //HP+5                  //HP+50
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+4
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+4
                            op2.ailment[STUN] += 2;     //�Z�p�ϐ�+2           //�Z�p�ϐ�+9
                            op2.PVP++;                  //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360
                        case 6:
                                                                                //AC-5
                            op2.HP += 5;                //HP+5                  //HP+45
                            op2.DMG_LONG++;             //�������_���[�W+1       //�������_���[�W+3
                            op2.DMG_SHORT++;            //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                            op2.ailment[STUN] += 5;     //�Z�p�ϐ�+5           //�Z�p�ϐ�+5
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
                        op2.ailment[STUN] += 2;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+9
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
                        op2.ailment[STUN] += 2;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+7
                                                                                //HP���R��+2
                                                                                //�����d�ʑ���+360
                    case 6:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+20
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+2
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                        op2.HIT_SHORT++;                //�ߋ�������+1           //�ߋ�������+2
                        op2.HIT_LONG++;                 //����������+1           //����������+2
                        op2.ailment[STUN] += 5;         //�Z�p�ϐ�+5           //�Z�p�ϐ�+5
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
                        op2.ailment[STUN] += 2;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+9
                        op2.HIT_MAGIC++;                //���@����+1             //���@����+2
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                        op2.MP += 15;                   //MP+15                 //MP+30
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360
                    case 7:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+35
                        op2.SP++;                       //SP+1                  //SP+3
                        op2.ailment[STUN] += 2;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+7
                        op2.HIT_MAGIC++;                //���@����+1             //���@����+1
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1                       
                                                                                //MP+15
                                                                                //MP���R��+1
                                                                                //�����d�ʑ���+360                       
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+30
                        op2.SP++;                       //SP+1                  //SP+2
                        op2.ailment[STUN] += 5;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+5                      
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
                        op2.ailment[STUN] += 2;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+9
                        op2.HP += 5;                    //HP+5                  //HP+100
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //�����d�ʑ���+360
                    case 7:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+3
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                        op2.DR++;                       //DR+1                  //DR+1
                                                        //�m���_���[�W�ቺ20 +1% //�m���_���[�W�ቺ20 +1%
                        op2.ailment[STUN] += 2;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+7
                        op2.HP += 5;                    //HP+5                  //HP+95
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //�����d�ʑ���+360
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+2
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                        op2.ailment[STUN] += 5;         //�Z�p�ϐ�+5           //�Z�p�ϐ�+5
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
                        op2.ailment[STUN] += 2;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+9
                        op2.HP += 5;                    //HP+5                  //HP+50
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //�����d�ʑ���+360
                    case 7:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+3
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                                                                                //MR+7
                                                        //�m�����@���+2         //�m�����@���+1
                        op2.ailment[STUN] += 2;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+7
                        op2.HP += 5;                    //HP+5                  //HP+45
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //�����d�ʑ���+360
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+2
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                                                                                //MR+7
                        op2.ailment[STUN] += 5;         //�Z�p�ϐ�+5           //�Z�p�ϐ�+5
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
                        op2.ailment[STUN] += 2;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+9
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+2
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360 
                    case 7:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+45
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+3
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+3
                        op2.ailment[STUN] += 2;         //�Z�p�ϐ�+2           //�Z�p�ϐ�+7
                        op2.PVP++;                      //PVP�ǉ��_���[�W+1      //PVP�ǉ��_���[�W+1
                                                                                //MP���R��+1          //MP+30            //HP���R��+2
                                                                                //�����d�ʑ���+360 
                    case 6:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+40
                        op2.DMG_LONG++;                 //�������_���[�W+1       //�������_���[�W+2
                        op2.DMG_SHORT++;                //�ߋ����_���[�W+1       //�ߋ����_���[�W+2
                        op2.ailment[STUN] += 5;         //�Z�p�ϐ�+5           //�Z�p�ϐ�+5
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
//�Q�[�g��
        if (name.equals("�V���Z�V�X�Q�[�g��")) {
            op2.HP = 5 * enchant;
        }
        //�r�͂̃Q�[�g����+9[�ߋ����_���[�W+1]�ǉ�
        if (name.equals("���j�R�[���̘r�͂̃Q�[�g��")) {
            if (enchant >= 9) {
                op2.DMG_SHORT = 1;
	    }
        } 
        //�@�q�̃Q�[�g����+9[�������_���[�W+1]�ǉ�
        if (name.equals("���j�R�[���̋@�q�̃Q�[�g��")) {
            if (enchant >= 9) {
                op2.DMG_LONG = 1;
	    }
        } 
        //�m�͂̃Q�[�g����+9[SP+1]�ǉ�
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
        //�A���K���X�Q�[�g����+7����[MR]+1����(�X�^�[�gMR+2)
        if (name.equals("�A���K���X�Q�[�g��")) {
            if (enchant >= 9) {
                op2.MR = 4;                 //MR+4
            } else if (enchant >= 8) {
                op2.MR = 3;                 //MR+3
            } else if (enchant >= 7) {
                op2.MR = 2;                 //MR+2
            }
        }
        //�i�C�g�o���h�̃Q�[�g����+5����[�ߋ�������]+1����(�ő�+5)
        if (name.equals("�i�C�g�o���h�̃Q�[�g��")) {
            if (enchant >= 9) {
                op2.HIT_SHORT = 5;          //�ߋ�������+5
            } else if (enchant >= 8) {
                op2.HIT_SHORT = 4;          //�ߋ�������+4
            } else if (enchant >= 7) {
                op2.HIT_SHORT = 3;          //�ߋ�������+3
            } else if (enchant >= 6) {
                op2.HIT_SHORT = 2;          //�ߋ�������+2
            } else if (enchant >= 5) {
                op2.HIT_SHORT = 1;          //�ߋ�������+1
            }
        }
        //�A�C���X�̃Q�[�g����+5����[����������]+1����(�ő�+5)
        if (name.equals("�A�C���X�̃Q�[�g��")) {
            if (enchant >= 9) {
                op2.HIT_LONG = 5;          //����������+5
            } else if (enchant >= 8) {
                op2.HIT_LONG = 4;          //����������+4
            } else if (enchant >= 7) {
                op2.HIT_LONG = 3;          //����������+3
            } else if (enchant >= 6) {
                op2.HIT_LONG = 2;          //����������+2
            } else if (enchant >= 5) {
                op2.HIT_LONG = 1;          //����������+1
            }
        }
        //�o���p�C�A�̃Q�[�g����+5����[���@����]+1����(�ő�+5)
        if (name.equals("�o���p�C�A�̃Q�[�g��")) {
            if (enchant >= 9) {
                op2.HIT_MAGIC = 5;          //���@����+5
            } else if (enchant >= 8) {
                op2.HIT_MAGIC = 4;          //���@����+4
            } else if (enchant >= 7) {
                op2.HIT_MAGIC = 3;          //���@����+3
            } else if (enchant >= 6) {
                op2.HIT_MAGIC = 2;          //���@����+2
            } else if (enchant >= 5) {
                op2.HIT_MAGIC = 1;          //���@����+1
            }
        }
//�����O&�A�~�����b�g&�x���g&���&�C���V�O�j�A
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
                        default:
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
                        default:
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
                        default:
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
                        default:
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
                        default:
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
                        default:
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
                        default:
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
                        default:
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
                        default:
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
                        default:
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
                        default:
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
                    default:
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
                    default:
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
                        op2.PVP_DR=2;        //PVP�_���[�W�ቺ+2
                        break;
                    case 8:
                        op2.HP = 40;
                        op2.MP = 50;
                        op2.DR = 4;
                        op2.PVP_DR=3;        //PVP�_���[�W�ቺ+3                        
                        break;
                    case 9:
                        op2.HP = 50;
                        op2.MP = 60;
                        op2.DR = 5;
                        op2.PVP_DR=4;        //PVP�_���[�W�ቺ+4
                        break;
                    default:
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
                    default:
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
                        op2.effect = "�_���[�W�ቺ+20 2%,";
                        break;
                    case 6:
                        op2.HP = 80;
                        op2.DR = 3;
                        op2.effect = "�_���[�W�ቺ+20 3%,";
                        op2.AC = -7;
                        break;
                    case 7:
                        op2.HP = 90;
                        op2.DR = 4;
                        op2.effect = "�_���[�W�ቺ+20 4%,";
                        op2.HIT_SHORT = 1;      //�ߋ�������+1
                        op2.HIT_LONG = 1;       //����������+1
                        op2.AC = -8;            //AC-8
                        break;
                    case 8:
                        op2.HP = 100;
                        op2.DR = 5;
                        op2.effect = "�_���[�W�ቺ+20 5%,";
                        op2.HIT_SHORT = 3;      //�ߋ�������+3
                        op2.HIT_LONG = 3;       //����������+3
                        op2.AC = -9;            //AC-9
                        break;
                    case 9:
                        op2.HP = 150;
                        op2.DR = 6;
                        op2.effect = "�_���[�W�ቺ+20 6%,";
                        op2.HIT_SHORT = 5;      //�ߋ�������+5
                        op2.HIT_LONG = 5;       //����������+5
                        op2.AC = -10;           //AC-10
                        break;
                    default:
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
                    default:
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
                    default:
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
                    default:
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
                    default:
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
                    default:
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
                    default:
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
                    default:
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
                    default:
                        break;
                }
            }
            if (name.equals("���m�̎��C���V�O�j�A")) {
                switch (enchant) {                          
                    case 5:
                        op2.AC = -3;
                        op2.HP = 30;
                        op2.DR = 1;
                        op2.DMG_SHORT = 1;
                        op2.PVP_DR = 1;
                        op2.effect += "�j�����Ռ��� +5%,";
                        break;
                    case 6:
                        op2.AC = -5;
                        op2.HP = 35;
                        op2.DR = 2;
                        op2.DMG_SHORT = 2;
                        op2.MR = 3;
                        op2.CRI_SHORT = 1;
                        op2.HIT_SHORT = 1;
                        op2.PVP_DR = 2;
                        op2.effect += "�j�����Ռ��� +10%,";
                        break;              
                    case 7:
                        op2.AC = -6;
                        op2.HP = 40;
                        op2.DR = 3;
                        op2.DMG_SHORT = 3;
                        op2.MR = 5;
                        op2.CRI_SHORT = 3;
                        op2.HIT_SHORT = 3;
                        op2.PVP_DR = 3;
                        op2.effect += "�j�����Ռ��� +15%,";
                        break;              
                    case 8:
                        op2.AC = -7;
                        op2.HP = 50;
                        op2.DR = 4;
                        op2.DMG_SHORT = 4;
                        op2.MR = 7;
                        op2.CRI_SHORT = 5;
                        op2.HIT_SHORT = 5;
                        op2.PVP_DR = 5;
                        op2.effect += "�j�����Ռ��� +20%,";
                        break;
                    default:
                        break;
                }
            }
            if (name.equals("�ˎ�̎��C���V�O�j�A")) {
                switch (enchant) {                          
                    case 5:
                        op2.AC = -3;
                        op2.HP = 30;
                        op2.DR = 1;
                        op2.DMG_LONG = 1;
                        op2.PVP_DR = 1;
                        op2.effect += "�j�����Ռ��� +5%,";
                        break;
                    case 6:
                        op2.AC = -5;
                        op2.HP = 35;
                        op2.DR = 2;
                        op2.DMG_LONG = 2;
                        op2.MR = 3;
                        op2.CRI_LONG = 1;
                        op2.HIT_LONG = 1;
                        op2.PVP_DR = 2;
                        op2.effect += "�j�����Ռ��� +10%,";
                        break;              
                    case 7:
                        op2.AC = -6;
                        op2.HP = 40;
                        op2.DR = 3;
                        op2.DMG_LONG = 3;
                        op2.MR = 5;
                        op2.CRI_LONG = 3;
                        op2.HIT_LONG = 3;
                        op2.PVP_DR = 3;
                        op2.effect += "�j�����Ռ��� +15%,";
                        break;              
                    case 8:
                        op2.AC = -7;
                        op2.HP = 50;
                        op2.DR = 4;
                        op2.DMG_LONG = 4;
                        op2.MR = 7;
                        op2.CRI_LONG = 5;
                        op2.HIT_LONG = 5;
                        op2.PVP_DR = 5;
                        op2.effect += "�j�����Ռ��� +20%,";
                        break;
                    default:
                        break;
                }
            }
            if (name.equals("���҂̎��C���V�O�j�A")) {
                switch (enchant) {                          
                    case 5:
                        op2.AC = -3;
                        op2.HP = 30;
                        op2.DR = 1;
                        op2.HIT_SHORT = 1;
                        op2.PVP_DR = 1;
                        op2.effect += "�j�����Ռ��� +5%,";
                        break;
                    case 6:
                        op2.AC = -5;
                        op2.HP = 35;
                        op2.DR = 2;
                        op2.MR = 3;
                        op2.HIT_SHORT = 2;
                        op2.CRI_MAGIC = 1;
                        op2.HIT_MAGIC = 1;
                        op2.PVP_DR = 2;
                        op2.effect += "�j�����Ռ��� +10%,";
                        break;              
                    case 7:
                        op2.AC = -6;
                        op2.HP = 40;
                        op2.DR = 3;
                        op2.MR = 5;
                        op2.HIT_SHORT = 3;
                        op2.CRI_MAGIC = 2;
                        op2.HIT_MAGIC = 3;
                        op2.PVP_DR = 3;
                        op2.effect += "�j�����Ռ��� +15%,";
                        break;              
                    case 8:
                        op2.AC = -7;
                        op2.HP = 50;
                        op2.DR = 4;
                        op2.MR = 7;
                        op2.HIT_SHORT = 4;
                        op2.CRI_MAGIC = 4;
                        op2.HIT_MAGIC = 5;
                        op2.PVP_DR = 5;
                        op2.effect += "�j�����Ռ��� +20%,";
                        break;
                    default:
                        break;
                }
            }
    }
}
