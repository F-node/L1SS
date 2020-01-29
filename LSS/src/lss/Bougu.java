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
                if (line.startsWith("安全=")) {
                    safety = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("強化限界=")) {
                    max_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("type=")) {
                    type = line.split("=")[1];
                }
//                if (line.startsWith("材質=")) {
//                    material = line.split("=")[1];
//                }
                if (line.startsWith("グレード=")) {
                    grade = line.split("=")[1];
                }
                if (line.startsWith("MR強化=")) {
                    mr_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("印章強化=")) {
                    element_enchant = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("特性=")) {
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
            text += " HP自然回復+" + (op.HPR + op2.HPR);
        }
        if (op.HPR + op2.HPR < 0) {
            text += " HP自然回復" + (op.HPR + op2.HPR);
        }
        if (op.MPR + op2.MPR > 0) {
            text += " MP自然回復+" + (op.MPR + op2.MPR);
        }
        if (op.MPR + op2.MPR < 0) {
            text += " MP自然回復" + (op.MPR + op2.MPR);
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
            text += " 近距離ダメージ+" + (op.DMG_SHORT + op2.DMG_SHORT);
        }
        if (op.HIT_SHORT + op2.HIT_SHORT > 0) {
            text += " 近距離命中+" + (op.HIT_SHORT + op2.HIT_SHORT);
        }
        if (op.DMG_LONG + op2.DMG_LONG > 0) {
            text += " 遠距離ダメージ+" + (op.DMG_LONG + op2.DMG_LONG);
        }
        if (op.HIT_LONG + op2.HIT_LONG > 0) {
            text += " 遠距離命中+" + (op.HIT_LONG + op2.HIT_LONG);
        }
        if (op.SP + op2.SP > 0) {
            text += " SP+" + (op.SP + op2.SP);
        }
        if (op.SP < 0) {
            text += " SP" + op.SP;
        }
        if (op.HIT_MAGIC + op2.HIT_MAGIC > 0) {
            text += " 魔法命中+" + (op.HIT_MAGIC + op2.HIT_MAGIC);
        }
        if (op.CRI_SHORT + op2.CRI_SHORT > 0) {
            text += " 近距離クリティカル+" + (op.CRI_SHORT + op2.CRI_SHORT);
        }
        if (op.CRI_LONG + op2.CRI_LONG > 0) {
            text += " 遠距離クリティカル+" + (op.CRI_LONG + op2.CRI_LONG);
        }
        if (op.CRI_MAGIC + op2.CRI_MAGIC > 0) {
            text += " 魔法クリティカル+" + (op.CRI_MAGIC + op2.CRI_MAGIC);
        }
        if (op.element_resist[FIRE] > 0) {
            text += " 火属性MR" + op.element_resist[FIRE];
        }
        if (op.element_resist[WATER] > 0) {
            text += " 水属性MR" + op.element_resist[WATER];
        }
        if (op.element_resist[WIND] > 0) {
            text += " 風属性MR" + op.element_resist[WIND];
        }
        if (op.element_resist[EARTH] > 0) {
            text += " 地属性MR" + op.element_resist[EARTH];
        }
        if (op.MR + op2.MR > 0) {
            text += " MR+" + (op.MR + op2.MR);
        }
        if (mr_enchant > 0) {
            text += " (強化毎にMR+" + mr_enchant + ")";
        }
        if (op.ailment[STUN] + op2.ailment[STUN] > 0) {
            text += " 技術耐性+" + (op.ailment[STUN] + op2.ailment[STUN]);
        }
        if (op.ailment[SPIRIT] + op2.ailment[SPIRIT] > 0) {
            text += " 精霊耐性+" + (op.ailment[SPIRIT] + op2.ailment[SPIRIT]);
        }
        if (op.ailment[SECRET] + op2.ailment[SECRET] > 0) {
            text += " 秘技耐性+" + (op.ailment[SECRET] + op2.ailment[SECRET]);
        }
        if (op.ailment[TERROR] + op2.ailment[TERROR] > 0) {
            text += " 恐怖耐性+" + (op.ailment[TERROR] + op2.ailment[TERROR]);
        }
        if (op.ailment[HIT_STUN] + op2.ailment[HIT_STUN] > 0) {
            text += " 技術命中+" + (op.ailment[HIT_STUN] + op2.ailment[HIT_STUN]);
        }
        if (op.ailment[HIT_SPIRIT] + op2.ailment[HIT_SPIRIT] > 0) {
            text += " 精霊命中+" + (op.ailment[HIT_SPIRIT] + op2.ailment[HIT_SPIRIT]);
        }
        if (op.ailment[HIT_SECRET] + op2.ailment[HIT_SECRET] > 0) {
            text += " 秘技命中+" + (op.ailment[HIT_SECRET] + op2.ailment[HIT_SECRET]);
        }
        if (op.ailment[HIT_TERROR] + op2.ailment[HIT_TERROR] > 0) {
            text += " 恐怖命中+" + (op.ailment[HIT_TERROR] + op2.ailment[HIT_TERROR]);
        }
        if (op.DR + op2.DR > 0) {
            text += " ダメージ低下+" + (op.DR + op2.DR);
        }
        if (op.DR_IGNORED + op2.DR_IGNORED > 0) {
            text += " ダメージ低下無視+" + (op.DR_IGNORED + op2.DR_IGNORED);
        }
        if (op.PVP + op2.PVP > 0) {
            text += " PVP追加ダメージ+" + (op.PVP + op2.PVP);
        }
        if (op.PVP_DR + op2.PVP_DR > 0) {
            text += " PVPダメージ低下+" + (op.PVP_DR + op2.PVP_DR);
        }
        if (op.MHP + op2.MHP > 0) {
            text += " 最大HP+" + (op.MHP + op2.MHP) + "%";
        }
        if (op.MMP + op2.MMP > 0) {
            text += " 最大MP+" + (op.MMP + op2.MMP) + "%";
        }
        if (op.MEXP + op2.MEXP > 0) {
            text += " 獲得経験値+" + (op.MEXP + op2.MEXP) + "%";
        }
        if (op.c_weight + op2.c_weight > 0) {
            text += " 所持重量増加+" + (op.c_weight + op2.c_weight);
        }
        if (op.WEIGHT > 0) {
            text += " 重さ " + op.WEIGHT;
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

//Tシャツ
        if (name.equals("地竜のTシャツ")) {
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
        if (name.equals("火竜のTシャツ")) {
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
        if (name.equals("風竜のTシャツ")) {
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
        if (name.equals("水竜のTシャツ")) {
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
        if (name.equals("裂空のTシャツ")) {
            if (enchant >= 10) {
                op2.DR = 5;                 //ダメージ低下+5
                op2.MR = 5;                 //MR+5
                op2.ailment[STUN] = 5;      //技術耐性+5
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
                op2.ailment[SECRET] = 5;    //秘技耐性+5
                op2.ailment[TERROR] = 5;    //恐怖耐性+5
            } else if (enchant >= 9) {
                op2.DR = 4;                 //ダメージ低下+4
                op2.MR = 4;                 //MR+4
                op2.ailment[STUN] = 4;      //技術耐性+4
                op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                op2.ailment[SECRET] = 4;    //秘技耐性+4
                op2.ailment[TERROR] = 4;    //恐怖耐性+4
            } else if (enchant >= 8) {
                op2.DR = 3;                 //ダメージ低下+3
                op2.MR = 3;                 //MR+3
                op2.ailment[STUN] = 3;      //技術耐性+3
                op2.ailment[SPIRIT] = 3;    //精霊耐性+3
                op2.ailment[SECRET] = 3;    //秘技耐性+3
                op2.ailment[TERROR] = 3;    //恐怖耐性+3
            } else if (enchant >= 7) {
                op2.DR = 2;                 //ダメージ低下+2
                op2.MR = 2;                 //MR+2
                op2.ailment[STUN] = 2;      //技術耐性+2
                op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                op2.ailment[SECRET] = 2;    //秘技耐性+2
                op2.ailment[TERROR] = 2;    //恐怖耐性+2
            } else if (enchant >= 6) {
                op2.DR = 1;                 //ダメージ低下+1
                op2.MR = 1;                 //MR+1
                op2.ailment[STUN] = 1;      //技術耐性+1
                op2.ailment[SPIRIT] = 1;    //精霊耐性+1
                op2.ailment[SECRET] = 1;    //秘技耐性+1
                op2.ailment[TERROR] = 1;    //恐怖耐性+1
            }
        }
        if (name.equals("闘士の竜Tシャツ")) {             //AC-2 STR+1 近距離ダメージ+1
            if (enchant >= 10) {
                    op2.DMG_SHORT = 1;                   //近距離ダメージ+1(合計2)
                    op2.HIT_SHORT = 7;                   //近距離命中+7
                    op2.HP = 100;                        //HP+100
                    op2.PVP = 1;                         //PVP追加ダメージ+1
                    op2.PVP_DR = 1;                      //PVPダメージ低下+1
                    op2.ailment[STUN] = 18;              //技術耐性+18
                    op2.ailment[SPIRIT] = 6;             //精霊耐性+6
                    op2.ailment[SECRET] = 6;             //秘技耐性+6
                    op2.ailment[TERROR] = 6;             //恐怖耐性+6
            } else if (enchant >= 9) {
                    op2.DMG_SHORT = 1;                   //近距離ダメージ+1(合計2)
                    op2.HIT_SHORT = 5;                   //近距離命中+5
                    op2.ailment[STUN] = 15;              //技術耐性+15
                    op2.ailment[SPIRIT] = 4;             //精霊耐性+4
                    op2.ailment[SECRET] = 4;             //秘技耐性+4
                    op2.ailment[TERROR] = 4;             //恐怖耐性+4
            } else if (enchant >= 8) {
                    op2.HIT_SHORT = 3;                   //近距離命中+3
                    op2.ailment[STUN] = 12;              //技術耐性+12
                    op2.ailment[SPIRIT] = 2;             //精霊耐性+2
                    op2.ailment[SECRET] = 2;             //秘技耐性+2
                    op2.ailment[TERROR] = 2;             //恐怖耐性+2
            } else if (enchant >= 7) {
                    op2.HIT_SHORT = 1;                   //近距離命中+1
                    op2.ailment[STUN] = 10;              //技術耐性+10
                    op2.ailment[SPIRIT] = 1;             //精霊耐性+1
                    op2.ailment[SECRET] = 1;             //秘技耐性+1
                    op2.ailment[TERROR] = 1;             //恐怖耐性+1
            } else if (enchant >= 6) {
                    op2.ailment[STUN] = 9;               //技術耐性+9
            } else if (enchant >= 5) {
                    op2.ailment[STUN] = 8;               //技術耐性+8                  
            }
        }
        if (name.equals("射手の竜Tシャツ")) {             //AC-2 DEX+1 遠距離ダメージ+1
            if (enchant >= 10) {
                    op2.DMG_LONG = 1;                    //遠距離ダメージ+1(合計2)
                    op2.HIT_LONG = 7;                    //遠距離命中+7
                    op2.HP = 100;                        //HP+100
                    op2.PVP = 1;                         //PVP追加ダメージ+1
                    op2.PVP_DR = 1;                      //PVPダメージ低下+1
                    op2.ailment[STUN] = 18;              //技術耐性+18
                    op2.ailment[SPIRIT] = 6;             //精霊耐性+6
                    op2.ailment[SECRET] = 6;             //秘技耐性+6
                    op2.ailment[TERROR] = 6;             //恐怖耐性+6
            } else if (enchant >= 9) {
                    op2.DMG_LONG = 1;                    //遠距離ダメージ+1(合計2)
                    op2.HIT_LONG = 5;                    //遠距離命中+5
                    op2.ailment[STUN] = 15;              //技術耐性+15
                    op2.ailment[SPIRIT] = 4;             //精霊耐性+4
                    op2.ailment[SECRET] = 4;             //秘技耐性+4
                    op2.ailment[TERROR] = 4;             //恐怖耐性+4
            } else if (enchant >= 8) {
                    op2.HIT_LONG = 3;                    //遠距離命中+3
                    op2.ailment[STUN] = 12;              //技術耐性+12
                    op2.ailment[SPIRIT] = 2;             //精霊耐性+2
                    op2.ailment[SECRET] = 2;             //秘技耐性+2
                    op2.ailment[TERROR] = 2;             //恐怖耐性+2
            } else if (enchant >= 7) {
                    op2.HIT_LONG = 1;                    //遠距離命中+1
                    op2.ailment[STUN] = 10;              //技術耐性+10
                    op2.ailment[SPIRIT] = 1;             //精霊耐性+1
                    op2.ailment[SECRET] = 1;             //秘技耐性+1
                    op2.ailment[TERROR] = 1;             //恐怖耐性+1
            } else if (enchant >= 6) {
                    op2.ailment[STUN] = 9;               //技術耐性+9
            } else if (enchant >= 5) {
                    op2.ailment[STUN] = 8;               //技術耐性+8                  
            }
        }
        if (name.equals("賢者の竜Tシャツ")) {             //AC-2 INT+1 SP+1
            if (enchant >= 10) {
                    op2.SP = 2;                          //SP+2(合計3)
                    op2.HIT_MAGIC = 5;                   //魔法命中+5
                    op2.HP = 100;                        //HP+100
                    op2.PVP = 1;                         //PVP追加ダメージ+1
                    op2.PVP_DR = 1;                      //PVPダメージ低下+1
                    op2.ailment[STUN] = 18;              //技術耐性+18
                    op2.ailment[SPIRIT] = 6;             //精霊耐性+6
                    op2.ailment[SECRET] = 6;             //秘技耐性+6
                    op2.ailment[TERROR] = 6;             //恐怖耐性+6
            } else if (enchant >= 9) {
                    op2.SP = 1;                          //SP+1(合計2)
                    op2.HIT_MAGIC = 4;                   //魔法命中+4
                    op2.ailment[STUN] = 15;              //技術耐性+15
                    op2.ailment[SPIRIT] = 4;             //精霊耐性+4
                    op2.ailment[SECRET] = 4;             //秘技耐性+4
                    op2.ailment[TERROR] = 4;             //恐怖耐性+4
            } else if (enchant >= 8) {
                    op2.SP = 1;                          //SP+1(合計2)
                    op2.HIT_MAGIC = 2;                   //魔法命中+2
                    op2.ailment[STUN] = 12;              //技術耐性+12
                    op2.ailment[SPIRIT] = 2;             //精霊耐性+2
                    op2.ailment[SECRET] = 2;             //秘技耐性+2
                    op2.ailment[TERROR] = 2;             //恐怖耐性+2
            } else if (enchant >= 7) {
                    op2.SP = 1;                          //SP+1(合計2)
                    op2.ailment[STUN] = 10;              //技術耐性+10
                    op2.ailment[SPIRIT] = 1;             //精霊耐性+1
                    op2.ailment[SECRET] = 1;             //秘技耐性+1
                    op2.ailment[TERROR] = 1;             //恐怖耐性+1
            } else if (enchant >= 6) {
                    op2.ailment[STUN] = 9;               //技術耐性+9
            } else if (enchant >= 5) {
                    op2.ailment[STUN] = 8;               //技術耐性+8                  
            }
        }
        if (name.equals("守護の竜Tシャツ")) {             //AC-2 WIS+1 ダメージ低下+1
            if (enchant >= 10) {
                    op2.DR = 1;                          //ダメージ低下+1(合計2)
                    op2.MR = 14;                         //MR+14
                    op2.HP = 100;                        //HP+100
                    op2.PVP = 1;                         //PVP追加ダメージ+1
                    op2.PVP_DR = 1;                      //PVPダメージ低下+1
                    op2.MEXP = 8;                        //獲得経験値+8%
            } else if (enchant >= 9) {
                    op2.DR = 1;                          //ダメージ低下+1(合計2)
                    op2.MR = 11;                         //MR+11
                    op2.MEXP = 6;                        //獲得経験値+6%
            } else if (enchant >= 8) {
                    op2.MR = 8;                          //MR+8
                    op2.MEXP = 4;                        //獲得経験値+4%
            } else if (enchant >= 7) {
                    op2.MR = 5;                          //MR+6
                    op2.MEXP = 2;                        //獲得経験値+2%
            } else if (enchant >= 6) {
                    op2.MR = 5;                          //MR+5
            } else if (enchant >= 5) {
                    op2.MR = 4;                          //MR+4                 
            }
        }
//シールド&ガーダー
        if (name.equals("シアーの心眼")) {
            if (enchant >= 9) {
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
            } else if (enchant >= 8) {
                op2.ailment[SPIRIT] = 4;    //精霊耐性+4
            } else if (enchant >= 7) {
                op2.ailment[SPIRIT] = 3;    //精霊耐性+3
            } else if (enchant >= 6) {
                op2.ailment[SPIRIT] = 2;    //精霊耐性+2
            } else if (enchant >= 5) {
                op2.ailment[SPIRIT] = 1;    //精霊耐性+1
            }
        }
        if (name.equals("エヴァのシールド")) {
            if (enchant >= 9) {
                op2.ailment[SECRET] = 5;    //秘技耐性+5
            } else if (enchant >= 8) {
                op2.ailment[SECRET] = 4;    //秘技耐性+4
            } else if (enchant >= 7) {
                op2.ailment[SECRET] = 3;    //秘技耐性+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //秘技耐性+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //秘技耐性+1
            }
        }
        if (name.equals("古代弓射手のガーダー")) {
            if (enchant >= 9) {
                op2.DMG_LONG = 3;
            } else if (enchant >= 7) {
                op2.DMG_LONG = 2;
            } else if (enchant >= 5) {
                op2.DMG_LONG = 1;
            }
        }
        if (name.equals("古代闘士のガーダー")) {
            if (enchant >= 9) {
                op2.DMG_SHORT = 3;
            } else if (enchant >= 7) {
                op2.DMG_SHORT = 2;
            } else if (enchant >= 5) {
                op2.DMG_SHORT = 1;
            }
        }
        if (name.equals("体力のガーダー")) {
            if (enchant >= 9) {
                op2.HP = 75;
            } else if (enchant >= 7) {
                op2.HP = 50;
            } else if (enchant >= 5) {
                op2.HP = 25;
            }
        }
        if (name.equals("守護のガーダー")) {
            if (enchant >= 9) {
                op2.DR = 3;
            } else if (enchant >= 7) {
                op2.DR = 2;
            } else if (enchant >= 5) {
                op2.DR = 1;
            }
        }
        if (name.equals("ウィザードのガーダー")) {
            if (enchant >= 9) {
                op2.SP = 3;
            } else if (enchant >= 7) {
                op2.SP = 2;
            } else if (enchant >= 5) {
                op2.SP = 1;
            }
        }
        if (name.equals("テイパーガーダー(腕力)")) {
            if (enchant >= 9) {
                op2.HIT_SHORT = 3;           	//近距離命中+3
                op2.DMG_SHORT = 3;           	//近距離ダメージ+3
                op2.ST[STR] = 1;           	//STR+1
                op2.PVP = 2;			//PVP+2

            } else if (enchant >= 8) {
                op2.HIT_SHORT = 2;           	//近距離命中+2
                op2.DMG_SHORT = 2;           	//近距離ダメージ+2
                op2.ST[STR] = 1;           	//STR+1
                op2.PVP = 1;           		//PVP+1

            } else if (enchant >= 7) {
                op2.HIT_SHORT = 2;           	//近距離命中+2
                op2.DMG_SHORT = 1;           	//近距離ダメージ+1
                op2.ST[STR] = 1;           	//STR+1

            } else if (enchant >= 6) {
                op2.HIT_SHORT = 2;           	//近距離命中+2
                op2.DMG_SHORT = 1;           	//近距離ダメージ+1

            } else if (enchant >= 5) {
                op2.HIT_SHORT = 1;           	//近距離命中+1

            }
        }
        if (name.equals("テイパーガーダー(機敏)")) {
            if (enchant >= 9) {
                op2.HIT_LONG = 3;           	//遠距離命中+3
                op2.DMG_LONG = 3;           	//遠距離ダメージ+3
                op2.ST[DEX] = 1;           	//DEX+1
                op2.PVP = 2;			//PVP+2

            } else if (enchant >= 8) {
                op2.HIT_LONG = 2;           	//遠距離命中+2
                op2.DMG_LONG = 2;           	//遠距離ダメージ+2
                op2.ST[DEX] = 1;           	//DEX+1
                op2.PVP = 1;           		//PVP+1

            } else if (enchant >= 7) {
                op2.HIT_LONG = 2;           	//遠距離命中+2
                op2.DMG_LONG = 1;           	//遠距離ダメージ+1
                op2.ST[DEX] = 1;           	//DEX+1

            } else if (enchant >= 6) {
                op2.HIT_LONG = 2;           	//遠距離命中+2
                op2.DMG_LONG = 1;           	//遠距離ダメージ+1

            } else if (enchant >= 5) {
                op2.HIT_LONG = 1;           	//遠距離命中+1

            }
        }
        if (name.equals("テイパーガーダー(知力)")) {
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
        if (name.equals("クーガーのガーダー")) {
            if (enchant >= 9) {
                op2.HIT_SHORT = 5;          //近距離命中
                op2.ailment[STUN] = 5;      //技術耐性
                op2.ailment[SPIRIT] = 5;    //精霊耐性 
                op2.ailment[SECRET] = 5;    //秘技耐性
                op2.ailment[TERROR] = 5;    //恐怖耐性
            } else if (enchant >= 8) {
                op2.HIT_SHORT = 4;          //近距離命中
                op2.ailment[STUN] = 4;      //技術耐性
                op2.ailment[SPIRIT] = 4;    //精霊耐性 
                op2.ailment[SECRET] = 4;    //秘技耐性
                op2.ailment[TERROR] = 4;    //恐怖耐性
            } else if (enchant >= 7) {
                op2.HIT_SHORT = 3;          //近距離命中
                op2.ailment[STUN] = 3;      //技術耐性
                op2.ailment[SPIRIT] = 3;    //精霊耐性 
                op2.ailment[SECRET] = 3;    //秘技耐性
                op2.ailment[TERROR] = 3;    //恐怖耐性
            } else if (enchant >= 6) {
                op2.HIT_SHORT = 2;          //近距離命中
                op2.ailment[STUN] = 2;      //技術耐性
                op2.ailment[SPIRIT] = 2;    //精霊耐性 
                op2.ailment[SECRET] = 2;    //秘技耐性
                op2.ailment[TERROR] = 2;    //恐怖耐性
            } else if (enchant >= 5) {
                op2.HIT_SHORT = 1;          //近距離命中
                op2.ailment[STUN] = 1;      //技術耐性
                op2.ailment[SPIRIT] = 1;    //精霊耐性 
                op2.ailment[SECRET] = 1;    //秘技耐性
                op2.ailment[TERROR] = 1;    //恐怖耐性
            }
        }
        if (name.equals("ウグヌスのガーダー")) {
            if (enchant >= 9) {
                op2.HIT_LONG = 5;           //遠距離命中+5
                op2.ailment[STUN] = 5;      //技術耐性+5
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
                op2.ailment[SECRET] = 5;    //秘技耐性+5
                op2.ailment[TERROR] = 5;    //恐怖耐性+5
            } else if (enchant >= 8) {
                op2.HIT_LONG = 4;           //遠距離命中+4
                op2.ailment[STUN] = 4;      //技術耐性+4
                op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                op2.ailment[SECRET] = 4;    //秘技耐性+4
                op2.ailment[TERROR] = 4;    //恐怖耐性+4
            } else if (enchant >= 7) {
                op2.HIT_LONG = 3;           //遠距離命中+3
                op2.ailment[STUN] = 3;      //技術耐性+3
                op2.ailment[SPIRIT] = 3;    //精霊耐性+3
                op2.ailment[SECRET] = 3;    //秘技耐性+3
                op2.ailment[TERROR] = 3;    //恐怖耐性+3
            } else if (enchant >= 6) {
                op2.HIT_LONG = 2;           //遠距離命中+2
                op2.ailment[STUN] = 2;      //技術耐性+2
                op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                op2.ailment[SECRET] = 2;    //秘技耐性+2
                op2.ailment[TERROR] = 2;    //恐怖耐性+2
            } else if (enchant >= 5) {
                op2.HIT_LONG = 1;           //遠距離命中+1
                op2.ailment[STUN] = 1;      //技術耐性+1
                op2.ailment[SPIRIT] = 1;    //精霊耐性+1
                op2.ailment[SECRET] = 1;    //秘技耐性+1
                op2.ailment[TERROR] = 1;    //恐怖耐性+1
            }
        }
        if (name.equals("火霊のガーダー")) {
            if (enchant >= 11) {
                op2.DMG_SHORT = enchant-6;  //近距離ダメージ+(enchant-6)
                op2.HIT_SHORT = enchant-4;  //近距離命中+(enchant-4)
                op2.ailment[STUN] = 5;      //技術耐性+5
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
                op2.ailment[SECRET] = 5;    //秘技耐性+5
                op2.ailment[TERROR] = 5;    //恐怖耐性+5               
            } else if (enchant >= 10) {
                op2.DMG_SHORT = 4;          //近距離ダメージ+4
                op2.HIT_SHORT = 6;          //近距離命中+6
                op2.ailment[STUN] = 5;      //技術耐性+5
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
                op2.ailment[SECRET] = 5;    //秘技耐性+5
                op2.ailment[TERROR] = 5;    //恐怖耐性+5
            } else if (enchant >= 9) {
                op2.DMG_SHORT = 3;          //近距離ダメージ+3
                op2.HIT_SHORT = 5;          //近距離命中+5
                op2.ailment[STUN] = 4;      //技術耐性+4
                op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                op2.ailment[SECRET] = 4;    //秘技耐性+4
                op2.ailment[TERROR] = 4;    //恐怖耐性+4
            } else if (enchant >= 8) {
                op2.DMG_SHORT = 2;          //近距離ダメージ+2
                op2.HIT_SHORT = 4;          //近距離命中+4
                op2.ailment[STUN] = 3;      //技術耐性+3
                op2.ailment[SPIRIT] = 3;    //精霊耐性+3
                op2.ailment[SECRET] = 3;    //秘技耐性+3
                op2.ailment[TERROR] = 3;    //恐怖耐性+3  
            } else if (enchant >= 7) {
                op2.DMG_SHORT = 1;          //近距離ダメージ+1
                op2.HIT_SHORT = 3;          //近距離命中+3
                op2.ailment[STUN] = 2;      //技術耐性+2
                op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                op2.ailment[SECRET] = 2;    //秘技耐性+2
                op2.ailment[TERROR] = 2;    //恐怖耐性+2
            } else if (enchant >= 6) {
                op2.HIT_SHORT = 2;          //近距離命中+2
                op2.ailment[STUN] = 1;      //技術耐性+1
                op2.ailment[SPIRIT] = 1;    //精霊耐性+1
                op2.ailment[SECRET] = 1;    //秘技耐性+1
                op2.ailment[TERROR] = 1;    //恐怖耐性+1
            } else if (enchant >= 5) {
                op2.HIT_SHORT = 1;          //近距離命中+1
            }
        }
        if (name.equals("風霊のガーダー")) {
            if (enchant >= 11) {
                op2.DMG_LONG = enchant-6;   //遠距離ダメージ+(enchant-6)
                op2.HIT_LONG = enchant-4;   //遠距離命中+(enchant-4)
                op2.ailment[STUN] = 5;      //技術耐性+5
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
                op2.ailment[SECRET] = 5;    //秘技耐性+5
                op2.ailment[TERROR] = 5;    //恐怖耐性+5               
            } else if (enchant >= 10) {
                op2.DMG_LONG = 4;           //遠距離ダメージ+4
                op2.HIT_LONG = 6;           //遠距離命中+6
                op2.ailment[STUN] = 5;      //技術耐性+5
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
                op2.ailment[SECRET] = 5;    //秘技耐性+5
                op2.ailment[TERROR] = 5;    //恐怖耐性+5
            } else if (enchant >= 9) {
                op2.DMG_LONG = 3;           //遠距離ダメージ+3
                op2.HIT_LONG = 5;           //遠距離命中+5
                op2.ailment[STUN] = 4;      //技術耐性+4
                op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                op2.ailment[SECRET] = 4;    //秘技耐性+4
                op2.ailment[TERROR] = 4;    //恐怖耐性+4
            } else if (enchant >= 8) {
                op2.DMG_LONG = 2;           //遠距離ダメージ+2
                op2.HIT_LONG = 4;           //遠距離命中+4
                op2.ailment[STUN] = 3;      //技術耐性+3
                op2.ailment[SPIRIT] = 3;    //精霊耐性+3
                op2.ailment[SECRET] = 3;    //秘技耐性+3
                op2.ailment[TERROR] = 3;    //恐怖耐性+3
            } else if (enchant >= 7) {
                op2.DMG_LONG = 1;           //遠距離ダメージ+1
                op2.HIT_LONG = 3;           //遠距離命中+3
                op2.ailment[STUN] = 2;      //技術耐性+2
                op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                op2.ailment[SECRET] = 2;    //秘技耐性+2
                op2.ailment[TERROR] = 2;    //恐怖耐性+2
            } else if (enchant >= 6) {
                op2.HIT_LONG = 2;           //遠距離命中+2
                op2.ailment[STUN] = 1;      //技術耐性+1
                op2.ailment[SPIRIT] = 1;    //精霊耐性+1
                op2.ailment[SECRET] = 1;    //秘技耐性+1
                op2.ailment[TERROR] = 1;    //恐怖耐性+1
            } else if (enchant >= 5) {
                op2.HIT_LONG = 1;           //遠距離命中+1
            }
        }
        if (name.equals("水霊のガーダー")) {
            if (enchant >= 11) {
                op2.SP = enchant-6;         //SP+(enchant-6)
                op2.HIT_MAGIC = enchant-4;  //魔法命中+(enchant-4)
                op2.ailment[STUN] = 5;      //技術耐性+5
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
                op2.ailment[SECRET] = 5;    //秘技耐性+5
                op2.ailment[TERROR] = 5;    //恐怖耐性+5
            } else if (enchant >= 10) {
                op2.SP = 4;                 //SP+4
                op2.HIT_MAGIC = 6;          //魔法命中+6
                op2.ailment[STUN] = 5;      //技術耐性+5
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
                op2.ailment[SECRET] = 5;    //秘技耐性+5
                op2.ailment[TERROR] = 5;    //恐怖耐性+5
            } else if (enchant >= 9) {
                op2.SP = 3;                 //SP+3
                op2.HIT_MAGIC = 5;          //魔法命中+5
                op2.ailment[STUN] = 4;      //技術耐性+4
                op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                op2.ailment[SECRET] = 4;    //秘技耐性+4
                op2.ailment[TERROR] = 4;    //恐怖耐性+4
            } else if (enchant >= 8) {
                op2.SP = 2;                 //SP+2
                op2.HIT_MAGIC = 4;          //魔法命中+4
                op2.ailment[STUN] = 3;      //技術耐性+3
                op2.ailment[SPIRIT] = 3;    //精霊耐性+3
                op2.ailment[SECRET] = 3;    //秘技耐性+3
                op2.ailment[TERROR] = 3;    //恐怖耐性+3
            } else if (enchant >= 7) {
                op2.SP = 1;                 //SP+1
                op2.HIT_MAGIC = 3;          //魔法命中+3
                op2.ailment[STUN] = 2;      //技術耐性+2
                op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                op2.ailment[SECRET] = 2;    //秘技耐性+2
                op2.ailment[TERROR] = 2;    //恐怖耐性+2
            } else if (enchant >= 6) {
                op2.HIT_MAGIC = 2;          //魔法命中+2
                op2.ailment[STUN] = 1;      //技術耐性+1
                op2.ailment[SPIRIT] = 1;    //精霊耐性+1
                op2.ailment[SECRET] = 1;    //秘技耐性+1
                op2.ailment[TERROR] = 1;    //恐怖耐性+1
            } else if (enchant >= 5) {
                op2.HIT_MAGIC = 1;          //魔法命中+1
            }
        }
        if (name.equals("地霊のガーダー")) {
            if (enchant >= 7) {
                op2.DR = enchant-6;         //ダメージ低下+(enchant-6)
                op2.MR = enchant-4;         //MR+(enchant-4)
            } else if (enchant >= 6) {
                op2.MR = 2;                 //MR+2
            } else if (enchant >= 5) {
                op2.MR = 1;                 //MR+1
            }
        }
//ヘルム
        if (name.equals("マミーロードクラウン")) {
            if (enchant >= 9) {
                op2.DMG_LONG = 3;
            } else if (enchant >= 8) {
                op2.DMG_LONG = 2;
            } else if (enchant >= 7) {
                op2.DMG_LONG = 1;
            }
        }
        if (name.equals("ブラックナイトヘルム")) {
            if (enchant >= 5) {
                op2.MR += 4 * (enchant -4);
            }
        }
        if (name.equals("大魔術師の帽子")) {
            op2.MP = 10 * enchant;
            if (enchant >= 9) {
                op2.ailment[SPIRIT] = 5;         //精霊耐性+5
            } else if (enchant >= 8) {
                op2.ailment[SPIRIT] = 4;         //精霊耐性+4
            } else if (enchant >= 7) {
                op2.ailment[SPIRIT] = 3;         //精霊耐性+3
            } else if (enchant >= 6) {
                op2.ailment[SPIRIT] = 2;         //精霊耐性+2
            } else if (enchant >= 5) {
                op2.ailment[SPIRIT] = 1;         //精霊耐性+1
            }
        }
        if (name.equals("エルシャベのヘルム")) {
            op2.MP = 10 * enchant;
            if (enchant >= 9) {
                op2.ailment[STUN] = 5;           //技術耐性+5
                op2.ailment[TERROR] = 5;         //恐怖耐性+5
            } else if (enchant >= 8) {
                op2.ailment[STUN] = 4;           //技術耐性+4
                op2.ailment[TERROR] = 4;         //恐怖耐性+4
            } else if (enchant >= 7) {
                op2.ailment[STUN] = 3;           //技術耐性+3
                op2.ailment[TERROR] = 3;         //恐怖耐性+3
            } else if (enchant >= 6) {
                op2.ailment[STUN] = 2;           //技術耐性+2
                op2.ailment[TERROR] = 2;         //恐怖耐性+2
            } else if (enchant >= 5) {
                op2.ailment[STUN] = 1;           //技術耐性+1
                op2.ailment[TERROR] = 1;         //恐怖耐性+1
            }
        }
        if (name.equals("マンボハット")) {
            if (enchant >= 7) {
                op2.ST[CHA] = 1;
            }
        }
//ブーツ
        if (name.equals("腕力のブーツ")) {
            if (enchant >= 9) {
                op2.DR = 1;
                op2.HP = 60;
            } else if (enchant >= 8) {
                op2.HP = 40;
            } else if (enchant >= 7) {
                op2.HP = 20;
            }
        }
        if (name.equals("機敏のブーツ")) {
            if (enchant >= 9) {
                op2.DR = 1;
                op2.HP = 60;
            } else if (enchant >= 8) {
                op2.HP = 40;
            } else if (enchant >= 7) {
                op2.HP = 20;
            }
        }
        if (name.equals("知力のブーツ")) {
            if (enchant >= 9) {
                op2.DR = 1;
                op2.HP = 60;
            } else if (enchant >= 8) {
                op2.HP = 40;
            } else if (enchant >= 7) {
                op2.HP = 20;
            }
        }
        if (name.equals("知恵のブーツ")) {
            if (enchant >= 9) {
                op2.DR = 1;
                op2.HP = 60;
            } else if (enchant >= 8) {
                op2.HP = 40;
            } else if (enchant >= 7) {
                op2.HP = 20;
            }
        }
        if (name.equals("血戦のグリーヴ")) {
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
            //+10強化オプション[最大HP+80]
            if (enchant >= 10) {
                op2.HP = 80;
            }
        }
        if (name.equals("血戦のブーツ")) {
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
            //+10強化オプション[最大HP+80]
            if (enchant >= 10) {
                op2.HP = 80;
            }
        }
        if (name.equals("血戦のバスキン")) {
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
            //+10強化オプション[最大HP+80]
            if (enchant >= 10) {
                op2.HP = 80;
            }
        }
        if (name.equals("アイリスのブーツ")) {
            if (enchant >= 9) {
                op2.ailment[STUN] = 5;      //技術耐性+5
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
                op2.ailment[SECRET] = 5;    //秘技耐性+5
                op2.ailment[TERROR] = 5;    //恐怖耐性+5
            } else if (enchant >= 8) {
                op2.ailment[STUN] = 4;      //技術耐性+4
                op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                op2.ailment[SECRET] = 4;    //秘技耐性+4
                op2.ailment[TERROR] = 4;    //恐怖耐性+4
            } else if (enchant >= 7) {
                op2.ailment[STUN] = 3;      //技術耐性+3
                op2.ailment[SPIRIT] = 3;    //精霊耐性+3
                op2.ailment[SECRET] = 3;    //秘技耐性+3
                op2.ailment[TERROR] = 3;    //恐怖耐性+3
            } else if (enchant >= 6) {
                op2.ailment[STUN] = 2;      //技術耐性+2
                op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                op2.ailment[SECRET] = 2;    //秘技耐性+2
                op2.ailment[TERROR] = 2;    //恐怖耐性+2
            } else if (enchant >= 5) {
                op2.ailment[STUN] = 1;      //技術耐性+1
                op2.ailment[SPIRIT] = 1;    //精霊耐性+1
                op2.ailment[SECRET] = 1;    //秘技耐性+1
                op2.ailment[TERROR] = 1;    //恐怖耐性+1
            }
        }
//クローク
        if (name.equals("漆黒のマント")) {
            if (enchant >= 9) {
                op2.ST[CHA] = 3;
            } else if (enchant >= 8) {
                op2.ST[CHA] = 2;
            } else if (enchant >= 7) {
                op2.ST[CHA] = 1;
            }
        }
        if (name.equals("フィアバンパイアマント")) {
            if (enchant >= 9) {
                op2.ailment[TERROR] = 5;    //恐怖耐性+5
            } else if (enchant >= 8) {
                op2.ailment[TERROR] = 4;    //恐怖耐性+4
            } else if (enchant >= 7) {
                op2.ailment[TERROR] = 3;    //恐怖耐性+3
            } else if (enchant >= 6) {
                op2.ailment[TERROR] = 2;    //恐怖耐性+2
            } else if (enchant >= 5) {
                op2.ailment[TERROR] = 1;    //恐怖耐性+1
            }
        }
        if (name.equals("アントクイーンゴールデンウィング")) {
            if (enchant >= 9) {
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
            } else if (enchant >= 8) {
                op2.ailment[SPIRIT] = 4;    //精霊耐性+4
            } else if (enchant >= 7) {
                op2.ailment[SPIRIT] = 3;    //精霊耐性+3
            } else if (enchant >= 6) {
                op2.ailment[SPIRIT] = 2;    //精霊耐性+2
            } else if (enchant >= 5) {
                op2.ailment[SPIRIT] = 1;    //精霊耐性+1
            }
        }
        if (name.equals("アントクイーンシルバーウィング")) {
            if (enchant >= 9) {
                op2.ailment[SPIRIT] = 5;    //精霊耐性+5
                op2.ER= 5;                  //ER+5
            } else if (enchant >= 8) {
                op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                op2.ER= 4;                  //ER+4
            } else if (enchant >= 7) {
                op2.ailment[SPIRIT] = 3;    //精霊耐性+3
                op2.ER= 3;                  //ER+3
            } else if (enchant >= 6) {
                op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                op2.ER= 2;                  //ER+2
            } else if (enchant >= 5) {
                op2.ailment[SPIRIT] = 1;    //精霊耐性+1
                op2.ER= 1;                  //ER+1
            }
        }
        if (name.equals("血戦のマント")) {
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
            //+10強化オプション[所持重量増加+240]
            if (enchant >= 10) {
                op2.c_weight = 240;
            }
        }
        if (name.equals("血戦のケープ")) {
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
            //+10強化オプション[所持重量増加+240]
            if (enchant >= 10) {
                op2.c_weight = 240;
            }                
        }
        if (name.equals("血戦のクローク")) {
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
            //+10強化オプション[所持重量増加+240]
            if (enchant >= 10) {
                op2.c_weight = 240;
            }
        }
//アーマ
        if (name.equals("マンボコート")) {
            if (enchant >= 7) {
                op2.ST[CHA] = 1;
            }
        }
        if (name.contains("リッチローブ")) {
            if (enchant >= 3) {
                op2.SP = enchant - 2;
            }
        }
        if (name.contains("アンタラスグランド")) {
            if (enchant >= 9) {
                op2.DR += enchant - 6;      //ダメージ低下+(強化値-6)
                op2.ailment[SECRET] = 5;    //秘技耐性+5
            } else if (enchant >= 8) {
                op2.DR += 2;                //ダメージ低下+2
                op2.ailment[SECRET] = 4;    //秘技耐性+4
            } else if (enchant >= 7) {
                op2.DR += 1;                //ダメージ低下+1
                op2.ailment[SECRET] = 3;    //秘技耐性+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //秘技耐性+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //秘技耐性+1
            }
        }
        if (name.contains("パプリオンハイドロ") || name.contains("リンドビオルストーム")){
            if (enchant >= 9) {
                op2.ailment[SECRET] = 5;    //秘技耐性+5
            } else if (enchant >= 8) {
                op2.ailment[SECRET] = 4;    //秘技耐性+4
            } else if (enchant >= 7) {
                op2.ailment[SECRET] = 3;    //秘技耐性+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //秘技耐性+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //秘技耐性+1
            }
        }
        if (name.equals("ヴァラカスフレイムプレートメイル")) {
            if (enchant >= 9) {
                op2.CRI_SHORT = 3;
                op2.DR_IGNORED = 3;
                op2.ailment[SECRET] = 5;    //秘技耐性+5
            } else if (enchant >= 8) {
                op2.CRI_SHORT = 2;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 4;    //秘技耐性+4
            } else if (enchant >= 7) {
                op2.CRI_SHORT = 1;
                op2.DR_IGNORED = 1;
                op2.ailment[SECRET] = 3;    //秘技耐性+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //秘技耐性+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //秘技耐性+1   
            }
        }
        if (name.equals("ヴァラカスフレイムスケイルメイル")) {
            if (enchant >= 9) {
                op2.CRI_SHORT = 3;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 5;    //秘技耐性+5
            } else if (enchant >= 8) {
                op2.CRI_SHORT = 2;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 4;    //秘技耐性+4
            } else if (enchant >= 7) {
                op2.CRI_SHORT = 1;
                op2.DR_IGNORED = 1;
                op2.ailment[SECRET] = 3;    //秘技耐性+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //秘技耐性+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //秘技耐性+1
            }
        }
        if (name.equals("ヴァラカスフレイムレザーアーマー")) {
            if (enchant >= 9) {
                op2.CRI_LONG = 3;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 5;    //秘技耐性+5
            } else if (enchant >= 8) {
                op2.CRI_LONG = 2;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 4;    //秘技耐性+4
            } else if (enchant >= 7) {
                op2.CRI_LONG = 1;
                op2.DR_IGNORED = 1;
                op2.ailment[SECRET] = 3;    //秘技耐性+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //秘技耐性+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //秘技耐性+1
            }
        }
        if (name.equals("ヴァラカスフレイムローブ")) {
            if (enchant >= 9) {
                op2.CRI_MAGIC = 3;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 5;    //秘技耐性+5
            } else if (enchant >= 8) {
                op2.CRI_MAGIC = 2;
                op2.DR_IGNORED = 2;
                op2.ailment[SECRET] = 4;    //秘技耐性+4
            } else if (enchant >= 7) {
                op2.CRI_MAGIC = 1;
                op2.DR_IGNORED = 1;
                op2.ailment[SECRET] = 3;    //秘技耐性+3
            } else if (enchant >= 6) {
                op2.ailment[SECRET] = 2;    //秘技耐性+2
            } else if (enchant >= 5) {
                op2.ailment[SECRET] = 1;    //秘技耐性+1
            }
        }
        if (name.equals("ハルパスプレートメイル") || name.equals("ハルパススケイルメイル") || name.equals("ハルパスローブ")){
            if (enchant >= 9) {
                op2.DR = 5;                 //ダメージ低下+5
            } else if (enchant >= 8) {
                op2.DR = 4;                 //ダメージ低下+4
            } else if (enchant >= 7) {
                op2.DR = 3;                 //ダメージ低下+3
            } else if (enchant >= 6) {
                op2.DR = 2;                 //ダメージ低下+2
            } else if (enchant >= 5) {
                op2.DR = 1;                 //ダメージ低下+1
            }
        }

//グローブ
        if (name.equals("輝く魔力のグローブ")) {
            if (enchant > 4) {
                op2.c_weight += 60 * (enchant - 4);
            }
        }
        if (name.equals("マミーロードのグローブ")) {
            if (enchant >= 9) {
                op2.SP = 3;
            } else if (enchant >= 8) {
                op2.SP = 2;
            } else if (enchant >= 7) {
                op2.SP = 1;
            }
        }
        if (name.equals("激昂のグローブ")) {
            if (enchant >= 7) {
                op2.HIT_SHORT = enchant - 3;
            }
            if (enchant >= 9) {
                op2.HIT_SHORT =6;
            }
        }
        if (name.equals("守護騎士のパワーグローブ")) {
            if (enchant >= 5) {
                op2.HIT_SHORT = enchant - 4;
            }
            if (enchant >= 9) {
                op2.HIT_SHORT =5;
            }
        }
        if (name.equals("守護騎士のブレイサー")) {
            if (enchant >= 5) {
                op2.HIT_LONG = enchant - 4;
            }
            if (enchant >= 9) {
                op2.HIT_LONG =5;
            }
        }
        if (name.equals("血戦のグローブ")) {
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
            //+10強化オプション[ダメージ低下+1]
            if (enchant >= 10) {
                op2.DR = 1;
            }
        }
        if (name.equals("血戦のブレイサー")) {
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
            //+10強化オプション[ダメージ低下+1]
            if (enchant >= 10) {
                op2.DR = 1;
            }
        }
        if (name.equals("血戦のミトン")) {
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
            //+10強化オプション[ダメージ低下+1]
            if (enchant >= 10) {
                op2.DR = 1;
            }
        }
//スナッパーリング
        if (name.contains("スナッパー")) {
            if (name.contains("祝福された")) {
                if (name.contains("勇士")) {
                    switch (enchant) {
                        case 8:
                                                                                //AC-7
                            op2.DMG_LONG++;             //近距離ダメージ+1       //近距離ダメージ+5
                            op2.DMG_SHORT++;            //遠距離ダメージ+1       //遠距離ダメージ+5
                            op2.HIT_SHORT++;            //近距離命中+1           //近距離命中+5
                            op2.HIT_LONG++;             //遠距離命中+1           //遠距離命中+5
                            op2.ailment[STUN] += 2;     //技術耐性+2           //技術耐性+9
                                                                                //HP+30
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                        case 7:
                            op2.AC--;                   //AC-1                  //AC-7
                            op2.DMG_LONG++;             //近距離ダメージ+1       //近距離ダメージ+4
                            op2.DMG_SHORT++;            //遠距離ダメージ+1       //遠距離ダメージ+4
                            op2.HIT_SHORT++;            //近距離命中+1           //近距離命中+4
                            op2.HIT_LONG++;             //遠距離命中+1           //遠距離命中+4
                            op2.ailment[STUN] += 2;     //技術耐性+2           //技術耐性+7
                            op2.HP += 5;                //HP+5                  //HP+30
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                        case 6:
                                                                                //AC-6
                            op2.DMG_LONG++;             //近距離ダメージ+1       //近距離ダメージ+3
                            op2.DMG_SHORT++;            //遠距離ダメージ+1       //遠距離ダメージ+13
                            op2.HIT_SHORT++;            //近距離命中+1           //近距離命中+3
                            op2.HIT_LONG++;             //遠距離命中+1           //遠距離命中+3
                            op2.ailment[STUN] += 5;     //技術耐性+5           //技術耐性+5
                            op2.HP += 5;                //HP+5                  //HP+25
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                        case 5:
                                                                                //AC-6
                            op2.DMG_LONG++;             //近距離ダメージ+1       //近距離ダメージ+2
                            op2.DMG_SHORT++;            //遠距離ダメージ+1       //遠距離ダメージ+2
                            op2.HIT_SHORT++;            //近距離命中+1           //近距離命中+2
                            op2.HIT_LONG++;             //遠距離命中+1           //遠距離命中+2
                            op2.HP += 5;                //HP+5                  //HP+20
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                        case 4:
                            op2.AC--;                   //AC-1                  //AC-6
                            op2.DMG_LONG++;             //近距離ダメージ+1       //近距離ダメージ+1
                            op2.DMG_SHORT++;            //遠距離ダメージ+1       //遠距離ダメージ+1
                            op2.HIT_SHORT++;            //近距離命中+1           //近距離命中+1
                            op2.HIT_LONG++;             //遠距離命中+1           //遠距離命中+1
                            op2.HP += 5;                //HP+5                  //HP+15
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                        case 3:
                            op2.AC -= 4;                //AC-4                  //AC-5
                            op2.HP += 10;               //HP+10                 //HP+10
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                    }
                } else if (name.contains("知恵")) {
                    switch (enchant) {
                        case 8:
                                                                                //AC-6
                            op2.SP++;                   //SP+1                  //SP+5
                            op2.HIT_MAGIC++;            //魔法命中+1             //魔法命中+3                        
                            op2.ailment[STUN] += 2;     //技術耐性+2           //技術耐性+9                          
                            op2.HP += 10;               //HP+10                 //HP+50
                            op2.MP += 5;                //MP+5                  //MP+35
                                                                                //MP自然回復+1
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+2 
                                                                                //所持重量増加+360
                        case 7:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.SP++;                   //SP+1                  //SP+4
                            op2.HIT_MAGIC++;            //魔法命中+1             //魔法命中+2
                            op2.ailment[STUN] += 2;     //技術耐性+2           //技術耐性+7
                            op2.HP += 5;                //HP+5                  //HP+40
                            op2.MP += 5;                //MP+5                  //MP+30
                                                                                //MP自然回復+1
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //所持重量増加+360
                        case 6:
                                                                                //AC-5 
                            op2.SP++;                   //SP+1                  //SP+3
                            op2.HIT_MAGIC++;            //魔法命中+1             //魔法命中+1
                            op2.ailment[STUN] += 5;     //技術耐性+5           //技術耐性+5
                            op2.HP += 5;                //HP+5                  //HP+35
                            op2.MP += 10;               //MP+10                 //MP+25
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360
                        case 5:
                                                                                //AC-5
                            op2.SP++;                   //SP+1                  //SP+2                          
                            op2.HP += 5;                //HP+5                  //HP+30
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360                                                     
                        case 4:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.SP++;                   //SP+1                  //SP+1
                            op2.HP += 5;                //HP+5                  //HP+25
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360
                        case 3:
                            op2.AC -= 3;                //AC-4                  //AC-4
                            op2.HP += 20;               //HP+20                 //HP+20
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360
                    }
                } else if (name.contains("体力")) {
                    switch (enchant) {
                        case 8:
                                                                                //AC-7
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+5
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+5
                            op2.DR++;                   //DR+1                  //DR+3
                                                        //確率ダメージ低下20 +1% //確率ダメージ低下20 +3%
                            op2.ailment[STUN] += 2;     //技術耐性+2           //技術耐性+9
                            op2.HP += 10;               //HP+10                 //HP+115
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //所持重量増加+360
                        case 7:
                            op2.AC--;                   //AC-1                  //AC-7
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+4
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+4
                            op2.DR++;                   //DR+1                  //DR+2
                                                        //確率ダメージ低下20 +1% //確率ダメージ低下20 +2%
                            op2.ailment[STUN] += 2;     //技術耐性+2           //技術耐性+7
                            op2.HP += 10;               //HP+10                 //HP+105
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //所持重量増加+360
                        case 6:
                                                                                //AC-6
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+3
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+3
                            op2.DR++;                   //DR+1                  //DR+1
                                                        //確率ダメージ低下20 +1% //確率ダメージ低下20 +1%
                            op2.ailment[STUN] += 5;     //技術耐性+5           //技術耐性+5
                            op2.HP += 5;                //HP+5                  //HP+95
                                                                                //所持重量増加+360
                        case 5:
                            op2.AC--;                   //AC-1                  //AC-6
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+2
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+2
                            op2.HP += 5;                //HP+5                  //HP+90
                                                                                //所持重量増加+360
                        case 4:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+1
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+1
                            op2.HP += 5;                //HP+5                  //HP+85
                                                                                //所持重量増加+360
                        case 3:
                             op2.AC -= 3;               //AC-3                  //AC-4
                             op2.HP += 30;              //HP+30                 //HP+80
                                                                                //所持重量増加+360
                    }
                } else if (name.contains("魔法抵抗")) {
                    switch (enchant) {
                        case 8:
                                                                                //AC-7
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+5
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+5
                            op2.MR++;                   //MR+1                  //MR+10
                                                        //確率魔法回避+2         //確率魔法回避+5
                            op2.ailment[STUN] += 2;     //技術耐性+2           //技術耐性+9
                                                                                //HP+50
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //所持重量増加+360
                        case 7:
                            op2.AC--;                   //AC-3                  //AC-7
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+4
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+4
                            op2.MR++;                   //MR+1                  //MR+9
                                                        //確率魔法回避+2         //確率魔法回避+3
                            op2.ailment[STUN] += 2;     //技術耐性+2           //技術耐性+7
                            op2.HP += 5;                //HP+5                  //HP+50
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //所持重量増加+360
                        case 6:
                                                                                //AC-6
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+3
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+3
                            op2.MR++;                   //MR+1                  //MR+8
                                                        //確率魔法回避+1         //確率魔法回避+1
                            op2.ailment[STUN] += 5;     //技術耐性+5           //技術耐性+5
                            op2.HP += 5;                //HP+5                  //HP+45
                                                                                //所持重量増加+360
                        case 5:
                            op2.AC--;                   //AC-1                  //AC-6
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+2
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+2
                                                                                //MR+7
                            op2.HP += 5;                //HP+5                  //HP+40
                                                                                //所持重量増加+360
                        case 4:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+1
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+1
                                                                                //MR+7
                            op2.HP += 5;                //HP+5                  //HP+35
                                                                                //所持重量増加+360
                        case 3:
                            op2.AC -= 3;                //AC-3                  //AC-4
                                                                                //MR+7
                            op2.HP += 30;               //HP+30                 //HP+30
                                                                                //所持重量増加+360
                    }
                } else if (name.contains("集中") || name.contains("マナ") || name.contains("回復")) {
                    switch (enchant) {
                        case 8:
                                                                                //AC-5
                                                                                //HP+50
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+5
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+5
                            op2.ailment[STUN] += 2;     //技術耐性+2           //技術耐性+9
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360
                        case 7:
                                                                                //AC-5
                            op2.HP += 5;                //HP+5                  //HP+50
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+4
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+4
                            op2.ailment[STUN] += 2;     //技術耐性+2           //技術耐性+9
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360
                        case 6:
                                                                                //AC-5
                            op2.HP += 5;                //HP+5                  //HP+45
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+3
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+3
                            op2.ailment[STUN] += 5;     //技術耐性+5           //技術耐性+5
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360
                        case 5:
                                                                                //AC-5
                            op2.HP += 5;                //HP+5                  //HP+40
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+2
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+2
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360
                        case 4:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+1
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+1
                            op2.HP += 5;                //HP+5                  //HP+35
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360
                        case 3:
                            op2.AC -= 3;                //AC-3                  //AC-4
                            op2.HP += 30;               //HP+30                 //HP+30
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360
                    }
                }
            } else if (name.contains("勇士")) {
                switch (enchant) {
                    case 8:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+30
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+4
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+4
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+2
                        op2.HIT_SHORT++;                //近距離命中+1           //近距離命中+2
                        op2.HIT_LONG++;                 //遠距離命中+1           //遠距離命中+2
                        op2.ailment[STUN] += 2;         //技術耐性+2           //技術耐性+9
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                    case 7:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+25
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+3
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+3
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+1
                        op2.HIT_SHORT++;                //近距離命中+1           //近距離命中+2
                        op2.HIT_LONG++;                 //遠距離命中+1           //遠距離命中+2
                        op2.ailment[STUN] += 2;         //技術耐性+2           //技術耐性+7
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                    case 6:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+20
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+2
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+2
                        op2.HIT_SHORT++;                //近距離命中+1           //近距離命中+2
                        op2.HIT_LONG++;                 //遠距離命中+1           //遠距離命中+2
                        op2.ailment[STUN] += 5;         //技術耐性+5           //技術耐性+5
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                    case 5:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+15
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+1
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+1
                        op2.HIT_SHORT++;                //近距離命中+1           //近距離命中+1
                        op2.HIT_LONG++;                 //遠距離命中+1           //遠距離命中+1
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                    case 4:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+10
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                    case 3:
                        op2.AC--;                       //AC-1                  //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+5
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                    case 2:
                        op2.AC--;                       //AC-1                  //AC-3
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                    case 1:
                        op2.AC--;                       //AC-1                  //AC-2
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                }
            } else if (name.contains("知恵")) {
                switch (enchant) {
                    case 8:
                        op2.AC--;                       //AC-1                  //AC-6
                        op2.HP += 5;                    //HP+5                  //HP+40
                        op2.SP++;                       //SP+1                  //SP+4
                        op2.ailment[STUN] += 2;         //技術耐性+2           //技術耐性+9
                        op2.HIT_MAGIC++;                //魔法命中+1             //魔法命中+2
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+2
                        op2.MP += 15;                   //MP+15                 //MP+30
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360
                    case 7:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+35
                        op2.SP++;                       //SP+1                  //SP+3
                        op2.ailment[STUN] += 2;         //技術耐性+2           //技術耐性+7
                        op2.HIT_MAGIC++;                //魔法命中+1             //魔法命中+1
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+1                       
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360                       
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+30
                        op2.SP++;                       //SP+1                  //SP+2
                        op2.ailment[STUN] += 5;         //技術耐性+2           //技術耐性+5                      
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360                      
                    case 5:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+25
                        op2.SP++;                       //SP+1                  //SP+1
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360                                              
                    case 4:
                        op2.AC--;                       //AC-1                  //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+20
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360                                              
                    case 3:
                        op2.AC--;                       //AC-1                  //AC-3
                        op2.HP += 5;                    //HP+5                  //HP+15                       
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360                        
                    case 2:
                        op2.AC--;                       //AC-1                  //AC-2
                        op2.HP += 5;                    //HP+5                  //HP+10                      
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360                        
                    case 1:
                                                                                //AC-1
                        op2.HP += 5;                    //HP+5                  //HP+5                       
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360                        
                }
            } else if (name.contains("体力")) {
                switch (enchant) {
                    case 8:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+4
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+4
                        op2.DR++;                       //DR+1                  //DR+2
                                                        //確率ダメージ低下20 +1% //確率ダメージ低下20 +2%
                        op2.ailment[STUN] += 2;         //技術耐性+2           //技術耐性+9
                        op2.HP += 5;                    //HP+5                  //HP+100
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //所持重量増加+360
                    case 7:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+3
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+3
                        op2.DR++;                       //DR+1                  //DR+1
                                                        //確率ダメージ低下20 +1% //確率ダメージ低下20 +1%
                        op2.ailment[STUN] += 2;         //技術耐性+2           //技術耐性+7
                        op2.HP += 5;                    //HP+5                  //HP+95
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //所持重量増加+360
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+2
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+2
                        op2.ailment[STUN] += 5;         //技術耐性+5           //技術耐性+5
                        op2.HP += 5;                    //HP+5                  //HP+90
                                                                                //所持重量増加+360
                    case 5:
                                                                                //AC-4
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+1
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+1
                        op2.HP += 5;                    //HP+5                  //HP+85
                                                                                //所持重量増加+360
                    case 4:
                        op2.AC--;                       //AC-1                  //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+80
                                                                                //所持重量増加+360
                    case 3:
                        op2.AC--;                       //AC-1                  //AC-3
                        op2.HP += 5;                    //HP+5                  //HP+75
                                                                                //所持重量増加+360                        
                    case 2:
                        op2.AC--;                       //AC-1                  //AC-2
                        op2.HP += 5;                    //HP+5                  //HP+70                      
                                                                                //所持重量増加+360                        
                    case 1:
                                                                                //AC-1
                        op2.HP += 15;                    //HP+5                 //HP+65
                                                                                //所持重量増加+360                        
                }
            } else if (name.contains("魔法抵抗")) {
                switch (enchant) {
                    case 8:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+4
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+4
                                                                                //MR+7
                                                        //確率魔法回避+2         //確率魔法回避+3
                        op2.ailment[STUN] += 2;         //技術耐性+2           //技術耐性+9
                        op2.HP += 5;                    //HP+5                  //HP+50
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //所持重量増加+360
                    case 7:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+3
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+3
                                                                                //MR+7
                                                        //確率魔法回避+2         //確率魔法回避+1
                        op2.ailment[STUN] += 2;         //技術耐性+2           //技術耐性+7
                        op2.HP += 5;                    //HP+5                  //HP+45
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //所持重量増加+360
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+2
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+2
                                                                                //MR+7
                        op2.ailment[STUN] += 5;         //技術耐性+5           //技術耐性+5
                        op2.HP += 5;                    //HP+5                  //HP+40
                                                                                //所持重量増加+360
                    case 5:
                                                                                //AC-4
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+1
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+1
                                                                                //MR+7
                        op2.HP += 5;                    //HP+5                  //HP+35
                                                                                //所持重量増加+360
                    case 4:
                        op2.AC--;                       //AC-1                  //AC-4
                                                                                //MR+7
                        op2.HP += 5;                    //HP+5                  //HP+30
                                                                                //所持重量増加+360
                    case 3:
                        op2.AC--;                       //AC-3                  //AC-3
                                                                                //MR+7
                        op2.HP += 5;                    //HP+5                  //HP+25
                                                                                //所持重量増加+360
                    case 2:
                        op2.AC--;                       //AC-1                  //AC-2
                                                                                //MR+7
                        op2.HP += 5;                    //HP+5                  //HP+20                      
                                                                                //所持重量増加+360                        
                    case 1:
                                                                                //AC-1
                                                                                //MR+7
                        op2.HP += 15;                   //HP+5                  //HP+15
                                                                                //所持重量増加+360                        
                }
            } else {
                    switch (enchant) {
                    case 8:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+50
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+4
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+4
                        op2.ailment[STUN] += 2;         //技術耐性+2           //技術耐性+9
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360 
                    case 7:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+45
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+3
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+3
                        op2.ailment[STUN] += 2;         //技術耐性+2           //技術耐性+7
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360 
                    case 6:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+40
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+2
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+2
                        op2.ailment[STUN] += 5;         //技術耐性+5           //技術耐性+5
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360 
                    case 5:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+35
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+1
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+1
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360 
                    case 4:
                        op2.AC--;                       //AC-1                  //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+30
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360 
                    case 3:
                        op2.AC--;                       //AC-1                  //AC-3
                        op2.HP += 5;                    //HP+5                  //HP+25
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360 
                    case 2:
                        op2.AC--;                       //AC-1                  //AC-2
                        op2.HP += 5;                    //HP+5                  //HP+20
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360
                    case 1:
                        op2.HP += 15;                   //HP+5                  //HP+15
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360
                }
            }
        }
//ゲートル
        if (name.equals("シンセシスゲートル") || name.equals("体力のゲートル")){
            op2.HP = 5 * enchant;
        }
        //腕力のゲートルは+9[近距離ダメージ+1]追加
        if (name.equals("ユニコーンの腕力のゲートル")) {
            if (enchant >= 9) {
                op2.DMG_SHORT = 1;
	    }
        } 
        //機敏のゲートルは+9[遠距離ダメージ+1]追加
        if (name.equals("ユニコーンの機敏のゲートル")) {
            if (enchant >= 9) {
                op2.DMG_LONG = 1;
	    }
        } 
        //知力のゲートルは+9[SP+1]追加
        if (name.equals("ユニコーンの知力のゲートル")) {
            if (enchant >= 9) {
                op2.SP = 1;
	    }
        }
        //守護のゲートルは+5から[最大HP]+10増加
        if (name.equals("ユニコーンの守護のゲートル")) {
            if (enchant >= 5) {
                op2.HP = 10;
	    }
        }
        //抵抗のゲートルは+1強化毎に[MR]1%増加(装備のパラメーター[MR強化=]で実装済)
        //if (name.equals("ユニコーンの抵抗のゲートル")) {
        //    op2.MR = 1 * enchant;
        //}
        //アラガンスゲートルは+7から[MR]+1増加(スタートMR+2)
        if (name.equals("アラガンスゲートル")) {
            if (enchant >= 9) {
                op2.MR = 4;                 //MR+4
            } else if (enchant >= 8) {
                op2.MR = 3;                 //MR+3
            } else if (enchant >= 7) {
                op2.MR = 2;                 //MR+2
            }
        }
        //ナイトバルドのゲートルは+5から[近距離命中]+1増加(最大+5)
        if (name.equals("ナイトバルドのゲートル")) {
            if (enchant >= 9) {
                op2.HIT_SHORT = 5;          //近距離命中+5
            } else if (enchant >= 8) {
                op2.HIT_SHORT = 4;          //近距離命中+4
            } else if (enchant >= 7) {
                op2.HIT_SHORT = 3;          //近距離命中+3
            } else if (enchant >= 6) {
                op2.HIT_SHORT = 2;          //近距離命中+2
            } else if (enchant >= 5) {
                op2.HIT_SHORT = 1;          //近距離命中+1
            }
        }
        //アイリスのゲートルは+5から[遠距離命中]+1増加(最大+5)
        if (name.equals("アイリスのゲートル")) {
            if (enchant >= 9) {
                op2.HIT_LONG = 5;          //遠距離命中+5
            } else if (enchant >= 8) {
                op2.HIT_LONG = 4;          //遠距離命中+4
            } else if (enchant >= 7) {
                op2.HIT_LONG = 3;          //遠距離命中+3
            } else if (enchant >= 6) {
                op2.HIT_LONG = 2;          //遠距離命中+2
            } else if (enchant >= 5) {
                op2.HIT_LONG = 1;          //遠距離命中+1
            }
        }
        //バンパイアのゲートルは+5から[魔法命中]+1増加(最大+5)
        if (name.equals("バンパイアのゲートル")) {
            if (enchant >= 9) {
                op2.HIT_MAGIC = 5;          //魔法命中+5
            } else if (enchant >= 8) {
                op2.HIT_MAGIC = 4;          //魔法命中+4
            } else if (enchant >= 7) {
                op2.HIT_MAGIC = 3;          //魔法命中+3
            } else if (enchant >= 6) {
                op2.HIT_MAGIC = 2;          //魔法命中+2
            } else if (enchant >= 5) {
                op2.HIT_MAGIC = 1;          //魔法命中+1
            }
        }
        //ドラゴンスレイヤーゲートル
        if (name.equals("ドラゴンスレイヤーゲートル")) {
            if (enchant >= 9) {
                op2.MR = 10;                //MR+10
                op2.PVP_DR = 5;             //PVPダメージ低下+5
                op2.HP = 150;               //HP+150
            } else if (enchant >= 8) {
                op2.MR = 8;                 //MR+8
                op2.PVP_DR = 4;             //PVPダメージ低下+4
                op2.HP = 100;               //HP+100
            } else if (enchant >= 7) {
                op2.MR = 6;                 //MR+6
                op2.PVP_DR = 3;             //PVPダメージ低下+3
                op2.HP = 50;                //HP+50
            } else if (enchant >= 6) {
                op2.MR = 4;                 //MR+4
                op2.PVP_DR = 2;             //PVPダメージ低下+2
            } else if (enchant >= 5) {
                op2.MR = 2;                 //MR+2
                op2.PVP_DR = 1;             //PVPダメージ低下+1
            }
        }
//スポールダー
        //指揮官のスポールダー/サイハのスポールダー/大魔術師のスポールダー
        if (name.equals("指揮官のスポールダー") || name.equals("サイハのスポールダー") || name.equals("大魔術師のスポールダー")) {
            if (enchant >= 9) {
                op2.PVP_DR = 5;             //PVPダメージ低下+5
                op2.ailment[TERROR] = 5;    //恐怖耐性+5
                op2.HP = 100;               //HP+100
            } else if (enchant >= 8) {
                op2.PVP_DR = 4;             //PVPダメージ低下+4
                op2.ailment[TERROR] = 4;    //恐怖耐性+4
                op2.HP = 80;                //HP+80
            } else if (enchant >= 7) {
                op2.PVP_DR = 3;             //PVPダメージ低下+3
                op2.ailment[TERROR] = 3;    //恐怖耐性+3
                op2.HP = 60;                //HP+60
            } else if (enchant >= 6) {
                op2.PVP_DR = 2;             //PVPダメージ低下+2
                op2.ailment[TERROR] = 2;    //恐怖耐性+2
                op2.HP = 40;                //HP+40
            } else if (enchant >= 5) {
                op2.PVP_DR = 1;             //PVPダメージ低下+1
                op2.ailment[TERROR] = 1;    //恐怖耐性+1
                op2.HP = 20;                //HP+20
            }
        }

//リング&アミュレット&ベルト&紋章&インシグニア&ペンダント
//+1強化するごとにAC-1されない防具・アイテム
        if (type.equals("リング") || type.equals("アミュレット") || type.equals("イアリング") || type.equals("ベルト") || type.equals("紋章") || type.equals("インシグニア") || type.equals("ペンダント")) {

            if (name.equals("回復の紋章")) {
                op2.effect = "ポーション回復量 +" + (enchant * 2 + 2) + "% +" + (enchant * 2 + 2) + ",";
                op2.effect += "回復悪化防御 +" + (enchant * 2 + 2) + "%,";
            }

            switch (name) {
                case "腕力の紋章":          //+0腕力の紋章でSTR=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "ポーション回復量 +2% +2,";
                            op2.effect += "回復悪化防御 +2%,";
                            break;
                        case 2:
                            op2.effect = "ポーション回復量 +4% +4,";
                            op2.effect += "回復悪化防御 +4%,";
                            break;
                        case 3:
                            op2.effect = "ポーション回復量 +6% +6,";
                            op2.effect += "回復悪化防御 +6%,";
                            break;
                        case 4:
                            op2.effect = "ポーション回復量 +8% +8,";
                            op2.effect += "回復悪化防御 +8%,";
                            break;
                        case 5:
                            op2.effect = "ポーション回復量 +9% +9,";
                            op2.effect += "回復悪化防御 +9%,";
                            op2.HIT_SHORT = 1;
                            break;
                        case 6:
                            op2.effect = "ポーション回復量 +10% +10,";
                            op2.effect += "回復悪化防御 +10%,";
                            op2.HIT_SHORT = 1;
                            op2.DMG_SHORT = 1;
                            break;
                        case 7:
                            op2.effect = "ポーション回復量 +11% +11,";
                            op2.effect += "回復悪化防御 +11%,";
                            op2.HIT_SHORT = 2;
                            op2.DMG_SHORT = 2;
                            break;
                        case 8:
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.HIT_SHORT = 3;
                            op2.DMG_SHORT = 3;
                            break;
                        case 9:
                            op2.effect = "ポーション回復量 +13% +13,";
                            op2.effect += "回復悪化防御 +13%,";
                            op2.HIT_SHORT = 4;
                            op2.DMG_SHORT = 4;
                            break;
                        case 10:
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.HIT_SHORT = 5;
                            op2.DMG_SHORT = 5;
                            break;
                        default:
                            break;
                    }
                    break;                   
                case "機敏の紋章":          //+0機敏の紋章でDEX=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "ポーション回復量 +2% +2,";
                            op2.effect += "回復悪化防御 +2%,";
                            break;
                        case 2:
                            op2.effect = "ポーション回復量 +4% +4,";
                            op2.effect += "回復悪化防御 +4%,";
                            break;
                        case 3:
                            op2.effect = "ポーション回復量 +6% +6,";
                            op2.effect += "回復悪化防御 +6%,";
                            break;
                        case 4:
                            op2.effect = "ポーション回復量 +8% +8,";
                            op2.effect += "回復悪化防御 +8%,";
                            break;
                        case 5:
                            op2.effect = "ポーション回復量 +9% +9,";
                            op2.effect += "回復悪化防御 +9%,";
                            op2.HIT_LONG = 1;
                            break;
                        case 6:
                            op2.effect = "ポーション回復量 +10% +10,";
                            op2.effect += "回復悪化防御 +10%,";
                            op2.HIT_LONG = 1;
                            op2.DMG_LONG = 1;
                            break;
                        case 7:
                            op2.effect = "ポーション回復量 +11% +11,";
                            op2.effect += "回復悪化防御 +11%,";
                            op2.HIT_LONG = 2;
                            op2.DMG_LONG = 2;
                            break;
                        case 8:
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.HIT_LONG = 3;
                            op2.DMG_LONG = 3;
                            break;
                        case 9:
                            op2.effect = "ポーション回復量 +13% +13,";
                            op2.effect += "回復悪化防御 +13%,";
                            op2.HIT_LONG = 4;
                            op2.DMG_LONG = 4;
                            break;
                        case 10:
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.HIT_LONG = 5;
                            op2.DMG_LONG = 5;
                            break;
                        default:
                            break;
                    }
                    break;                  
                case "知力の紋章":          //+0知力の紋章でSTR=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "ポーション回復量 +2% +2,";
                            op2.effect += "回復悪化防御 +2%,";
                            break;
                        case 2:
                            op2.effect = "ポーション回復量 +4% +4,";
                            op2.effect += "回復悪化防御 +4%,";
                            break;
                        case 3:
                            op2.effect = "ポーション回復量 +6% +6,";
                            op2.effect += "回復悪化防御 +6%,";
                            break;
                        case 4:
                            op2.effect = "ポーション回復量 +8% +8,";
                            op2.effect += "回復悪化防御 +8%,";
                            break;
                        case 5:
                            op2.effect = "ポーション回復量 +9% +9,";
                            op2.effect += "回復悪化防御 +9%,";
                            op2.HIT_MAGIC = 1;
                            break;
                        case 6:
                            op2.effect = "ポーション回復量 +10% +10,";
                            op2.effect += "回復悪化防御 +10%,";
                            op2.HIT_MAGIC = 1;
                            op2.SP = 1;
                            break;
                        case 7:
                            op2.effect = "ポーション回復量 +11% +11,";
                            op2.effect += "回復悪化防御 +11%,";
                            op2.HIT_MAGIC = 2;
                            op2.SP = 2;
                            break;
                        case 8:
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.HIT_MAGIC = 3;
                            op2.SP = 3;
                            break;
                        case 9:
                            op2.effect = "ポーション回復量 +13% +13,";
                            op2.effect += "回復悪化防御 +13%,";
                            op2.HIT_MAGIC = 4;
                            op2.SP = 4;
                            break;
                        case 10:
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.HIT_MAGIC = 5;
                            op2.SP = 5;
                            break;
                        default:
                            break;
                    }
                    break; 
                case "成長の紋章":          //+0成長の紋章で獲得経験値+1%
                    switch (enchant) {
                        case 0:
                            op2.MEXP += 1;                                       //獲得経験値+1%
                            break;
                        case 1:
                            op2.MEXP += 2;                                       //獲得経験値+2%
                            op2.effect += "ポーション回復量 +2% +2,";
                            op2.effect += "回復悪化防御 +2%,";
                            break;
                        case 2:
                            op2.MEXP += 3;                                       //獲得経験値+3%
                            op2.effect += "ポーション回復量 +4% +4,";
                            op2.effect += "回復悪化防御 +4%,";
                            break;
                        case 3:
                            op2.MEXP += 4;                                       //獲得経験値+4%
                            op2.effect += "ポーション回復量 +6% +6,";
                            op2.effect += "回復悪化防御 +6%,";
                            break;
                        case 4:
                            op2.MEXP += 5;                                       //獲得経験値+5%
                            op2.effect += "ポーション回復量 +8% +8,";
                            op2.effect += "回復悪化防御 +8%,";
                            break;
                        case 5:
                            op2.MEXP += 6;                                       //獲得経験値+6%
                            op2.effect += "ポーション回復量 +9% +9,";
                            op2.effect += "回復悪化防御 +9%,";
                            break;
                        case 6:
                            op2.MEXP += 7;                                       //獲得経験値+7%
                            op2.effect += "ポーション回復量 +10% +10,";
                            op2.effect += "回復悪化防御 +10%,";
                            break;
                        case 7:
                            op2.MEXP += 9;                                       //獲得経験値+9%
                            op2.effect += "ポーション回復量 +11% +11,";
                            op2.effect += "回復悪化防御 +11%,";
                            break;
                        case 8:
                            op2.MEXP += 11;                                      //獲得経験値+11%
                            op2.effect += "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            break;
                        case 9:
                            op2.MEXP += 13;                                      //獲得経験値+13%
                            op2.effect += "ポーション回復量 +13% +13,";
                            op2.effect += "回復悪化防御 +13%,";
                            break;
                        case 10:
                            op2.MEXP += 15;                                      //獲得経験値+15%
                            op2.effect += "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            break;
                        default:
                            break;
                    }
                    break;         
                case "守護の紋章":          //+0守護の紋章でAC=-1
                    switch (enchant) {
                        case 1:
                            op2.MEXP += 1;                                       //獲得経験値+1%
                            break;
                        case 2:
                            op2.MEXP += 2;                                       //獲得経験値+2%
                            break;
                        case 3:
                            op2.MEXP += 3;                                       //獲得経験値+3%
                            break;
                        case 4:
                            op2.MEXP += 4;                                       //獲得経験値+4%
                            op2.MR = 1;
                            break;
                        case 5:
                            op2.MEXP += 5;                                       //獲得経験値+5%
                            op2.MR = 2;
                            break;
                        case 6:
                            op2.MEXP += 6;                                       //獲得経験値+6%
                            op2.MR = 3;
                            break;
                        case 7:
                            op2.MEXP += 7;                                       //獲得経験値+7%
                            op2.MR = 4;
                            break;
                        case 8:
                            op2.MEXP += 8;                                       //獲得経験値+8%
                            op2.MR = 5;
                            break;
                        default:
                            break;
                    } 
                    break;
                case "闘士の紋章":          //+0闘士の紋章でSTR=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "ポーション回復量 +2% +2,";
                            op2.effect += "回復悪化防御 +2%,";
                            break;
                        case 2:
                            op2.effect = "ポーション回復量 +4% +4,";
                            op2.effect += "回復悪化防御 +4%,";
                            break;
                        case 3:
                            op2.effect = "ポーション回復量 +8% +8,";
                            op2.effect += "回復悪化防御 +8%,";
                            break;
                        case 4:
                            op2.effect = "ポーション回復量 +10% +10,";
                            op2.effect += "回復悪化防御 +10%,";
                            op2.HIT_SHORT = 1;
                            break;
                        case 5:
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.DMG_SHORT = 1;
                            op2.HIT_SHORT = 1;
                            break;
                        case 6:
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.DMG_SHORT = 2;
                            op2.HIT_SHORT = 2;
                            break;
                        case 7:
                            op2.effect = "ポーション回復量 +16% +16,";
                            op2.effect += "回復悪化防御 +16%,";
                            op2.DMG_SHORT = 3;
                            op2.HIT_SHORT = 3;
                            break;
                        case 8:
                            op2.effect = "ポーション回復量 +18% +18,";
                            op2.effect += "回復悪化防御 +18%,";
                            op2.DMG_SHORT = 4;
                            op2.HIT_SHORT = 4;
                            break;
                        default:
                            break;
                    }
                    break;
                case "射手の紋章":          //+0射手の紋章でDEX=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "ポーション回復量 +2% +2,";
                            op2.effect += "回復悪化防御 +2%,";
                            break;
                        case 2:
                            op2.effect = "ポーション回復量 +4% +4,";
                            op2.effect += "回復悪化防御 +4%,";
                            break;
                        case 3:
                            op2.effect = "ポーション回復量 +8% +8,";
                            op2.effect += "回復悪化防御 +8%,";
                            break;
                        case 4:
                            op2.effect = "ポーション回復量 +10% +10,";
                            op2.effect += "回復悪化防御 +10%,";
                            op2.HIT_LONG = 1;
                            break;
                        case 5:
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.DMG_LONG= 1;
                            op2.HIT_LONG = 1;
                            break;
                        case 6:
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.DMG_LONG = 2;
                            op2.HIT_LONG = 2;
                            break;
                        case 7:
                            op2.effect = "ポーション回復量 +16% +16,";
                            op2.effect += "回復悪化防御 +16%,";
                            op2.DMG_LONG = 3;
                            op2.HIT_LONG = 3;
                            break;
                        case 8:
                            op2.effect = "ポーション回復量 +18% +18,";
                            op2.effect += "回復悪化防御 +18%,";
                            op2.DMG_LONG = 4;
                            op2.HIT_LONG = 4;
                            break;
                        default:
                            break;
                    }
                    break;
                case "賢者の紋章":          //+0賢者の紋章でINT=1
                    switch (enchant) {
                        case 1:
                            op2.effect = "ポーション回復量 +2% +2,";
                            op2.effect += "回復悪化防御 +2%,";
                            break;
                        case 2:
                            op2.effect = "ポーション回復量 +4% +4,";
                            op2.effect += "回復悪化防御 +4%,";
                            break;
                        case 3:
                            op2.effect = "ポーション回復量 +8% +8,";
                            op2.effect += "回復悪化防御 +8%,";
                            break;
                        case 4:
                            op2.effect = "ポーション回復量 +10% +10,";
                            op2.effect += "回復悪化防御 +10%,";
                            op2.HIT_MAGIC = 1;
                            break;
                        case 5:
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.HIT_MAGIC = 1;
                            op2.SP = 1;
                            break;
                        case 6:
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.HIT_MAGIC = 2;
                            op2.SP = 2;
                            break;
                        case 7:
                            op2.effect = "ポーション回復量 +16% +16,";
                            op2.effect += "回復悪化防御 +16%,";
                            op2.HIT_MAGIC = 3;
                            op2.SP = 3;
                            break;
                        case 8:
                            op2.effect = "ポーション回復量 +18% +18,";
                            op2.effect += "回復悪化防御 +18%,";
                            op2.HIT_MAGIC = 4;
                            op2.SP = 4;
                            break;
                        default:
                            break;
                    }
                    break;
                case "闘士の守護紋章":                      //+5闘士の守護紋章から
                    switch (enchant) {
                        case 5:
                            op2.AC =-2;
                            op2.ST[STR] = 1;
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.effect += "祝福消耗効率 +3%,";                            
                            op2.DMG_SHORT = 1;
                            op2.HIT_SHORT = 2;
                            op2.MR = 4;
                            break;
                        case 6:
                            op2.AC =-2;
                            op2.ST[STR] = 1;
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.effect += "祝福消耗効率 +5%,";
                            op2.DMG_SHORT = 2;
                            op2.HIT_SHORT = 3;
                            op2.MR = 6;
                            break;
                        case 7:
                            op2.AC =-2;
                            op2.ST[STR] = 1;
                            op2.effect = "ポーション回復量 +16% +16,";
                            op2.effect += "回復悪化防御 +16%,";
                            op2.effect += "祝福消耗効率 +7%,";
                            op2.DMG_SHORT = 3;
                            op2.HIT_SHORT = 4;
                            op2.MR = 8;
                            break;
                        case 8:
                            op2.AC =-2;
                            op2.ST[STR] = 1;
                            op2.effect = "ポーション回復量 +18% +18,";
                            op2.effect += "回復悪化防御 +18%,";
                            op2.effect += "祝福消耗効率 +10%,";
                            op2.DMG_SHORT = 4;
                            op2.HIT_SHORT = 5;
                            op2.MR = 10;
                            break;
                        default:
                            break;
                    }
                    break;
                case "射手の守護紋章":                      //+5射手の守護紋章から
                    switch (enchant) {
                            case 5:
                            op2.AC =-2;
                            op2.ST[DEX] = 1;
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.effect += "祝福消耗効率 +3%,";                            
                            op2.DMG_LONG = 1;
                            op2.HIT_LONG = 2;
                            op2.MR = 4;
                            break;
                        case 6:
                            op2.AC =-2;
                            op2.ST[DEX] = 1;
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.effect += "祝福消耗効率 +5%,";
                            op2.DMG_LONG = 2;
                            op2.HIT_LONG = 3;
                            op2.MR = 6;
                            break;
                        case 7:
                            op2.AC =-2;
                            op2.ST[DEX] = 1;
                            op2.effect = "ポーション回復量 +16% +16,";
                            op2.effect += "回復悪化防御 +16%,";
                            op2.effect += "祝福消耗効率 +7%,";
                            op2.DMG_LONG = 3;
                            op2.HIT_LONG = 4;
                            op2.MR = 8;
                            break;
                        case 8:
                            op2.AC =-2;
                            op2.ST[DEX] = 1;
                            op2.effect = "ポーション回復量 +18% +18,";
                            op2.effect += "回復悪化防御 +18%,";
                            op2.effect += "祝福消耗効率 +10%,";
                            op2.DMG_LONG = 4;
                            op2.HIT_LONG = 5;
                            op2.MR = 10;
                            break;
                        default:
                            break;
                    }
                    break;
                case "賢者の守護紋章":                      //+5賢者の守護紋章から
                    switch (enchant) {
                        case 5:
                            op2.AC =-2;
                            op2.ST[INT] = 1;
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.effect += "祝福消耗効率 +3%,";
                            op2.SP = 1;
                            op2.HIT_MAGIC = 2;
                            op2.MR = 6;
                            break;
                        case 6:
                            op2.AC =-2;
                            op2.ST[INT] = 1;
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.effect += "祝福消耗効率 +5%,";
                            op2.SP = 2;
                            op2.HIT_MAGIC = 3;
                            op2.MR = 6;
                            break;
                        case 7:
                            op2.AC =-2;
                            op2.ST[INT] = 1;
                            op2.effect = "ポーション回復量 +16% +16,";
                            op2.effect += "回復悪化防御 +16%,";
                            op2.effect += "祝福消耗効率 +7%,";
                            op2.SP = 3;
                            op2.HIT_MAGIC = 4;
                            op2.MR = 8;
                            break;
                        case 8:
                            op2.AC =-2;
                            op2.ST[INT] = 1;
                            op2.effect = "ポーション回復量 +18% +18,";
                            op2.effect += "回復悪化防御 +18%,";
                            op2.effect += "祝福消耗効率 +10%,";
                            op2.SP = 4;
                            op2.HIT_MAGIC = 5;
                            op2.MR = 10;
                            break;
                        default:
                            break;
                    }
            }

            //シークレットオプション
            if (name.contains("月光の") || name.contains("星の")) {
                if (enchant == 7) {
                    op2.PVP = 1;
                }
                if (enchant == 8) {
                    op2.PVP = 2;
                }
                if (enchant == 9) {
                    op2.PVP = 2;
                }
            }
            //情熱のリング
            if (tokusei.equals("情熱")) {
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
                        op2.PVP = 1;        //PVP追加ダメージ+1
                        break;
                    case 7:
                        op2.HP = 50;
                        op2.DMG_LONG = 3;
                        op2.DMG_SHORT = 3;
                        op2.SP = 1;
                        op2.MR = 3;
                        op2.PVP = 2;        //PVP追加ダメージ+2
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.DMG_LONG = 4;
                        op2.DMG_SHORT = 4;
                        op2.SP = 2;
                        op2.MR = 5;
                        op2.PVP = 3;        //PVP追加ダメージ+3
                        break;
                    case 9:
                        op2.HP = 60;
                        op2.DMG_LONG = 5;
                        op2.DMG_SHORT = 5;
                        op2.SP = 3;
                        op2.MR = 7;
                        op2.PVP = 5;        //PVP追加ダメージ+5
                        break;
                    default:
                        break;
                }
            }
            //誓いのアミュレット
            if (tokusei.equals("誓い")) {
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
                        op2.effect = "ポーション回復量 +3% +0,";
                        op2.effect += "回復悪化防御 +3% (恐怖),";
                        op2.MR = 1;
                        op2.AC -= 1;
                        break;
                    case 6:
                        op2.HP = 40;
                        op2.effect = "ポーション回復量 +5% +3,";
                        op2.effect += "回復悪化防御 +5% (恐怖),";
                        op2.MR = 3;
                        op2.AC -= 2;                      
                        break;
                    case 7:
                        op2.HP = 50;
                        op2.effect = "ポーション回復量 +7% +5,";
                        op2.effect += "回復悪化防御 +7% (恐怖),";
                        op2.MR = 5;
                        op2.AC -= 3;
                        op2.ailment[STUN] += 2;
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.effect = "ポーション回復量 +9% +7,";
                        op2.effect += "回復悪化防御 +9% (恐怖),";
                        op2.MR = 7;
                        op2.AC -= 4;
                        op2.ailment[STUN] += 3;
                        break;
                    case 9:
                        op2.HP = 60;
                        op2.effect = "ポーション回復量 +10% +8,";
                        op2.effect += "回復悪化防御 +10% (恐怖),";
                        op2.MR = 10;
                        op2.AC -= 5;
                        op2.ailment[STUN] += 4;
                        break;
                    default:
                        break;
                }

            }
            //根性のイアリング
            if (tokusei.equals("根性")) {
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
                        op2.effect = "ポーション回復量 +2% +0,";
                        op2.effect += "回復悪化防御 +2% (恐怖),";
                        op2.AC -= 1;
                        break;
                    case 6:
                        op2.HP = 40;
                        op2.effect = "ポーション回復量 +4% +2,";
                        op2.effect += "回復悪化防御 +4% (恐怖),";
                        op2.AC -= 2;                      
                        break;
                    case 7:
                        op2.HP = 50;
                        op2.effect = "ポーション回復量 +6% +4,";
                        op2.effect += "回復悪化防御 +6% (恐怖),";
                        op2.AC -= 3;
                        op2.ailment[STUN] += 2;
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.effect = "ポーション回復量 +8% +6,";
                        op2.effect += "回復悪化防御 +8% (恐怖),";
                        op2.AC -= 4;
                        op2.ailment[STUN] += 3;
                        break;
                    case 9:
                        op2.HP = 60;
                        op2.effect = "ポーション回復量 +9% +7,";
                        op2.effect += "回復悪化防御 +9% (恐怖),";
                        op2.AC -= 5;
                        op2.ailment[STUN] += 4;
                        break;
                    default:
                        break;
                }

            }
            //意地のベルト
            if (tokusei.equals("意地")) {
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
                        op2.PVP_DR=1;        //PVPダメージ低下+1
                        break;
                    case 7:
                        op2.HP = 30;
                        op2.MP = 50;
                        op2.DR = 3;
                        op2.PVP_DR=3;        //PVPダメージ低下+3
                        break;
                    case 8:
                        op2.HP = 40;
                        op2.MP = 50;
                        op2.DR = 4;
                        op2.PVP_DR=5;        //PVPダメージ低下+5
                        break;
                    case 9:
                        op2.HP = 50;
                        op2.MP = 50;
                        op2.DR = 5;
                        op2.PVP_DR=7;        //PVPダメージ低下+7
                        break;
                    default:
                        break;
                }
            }

            if (grade.equals("特級")) {     //各種[10周年記念リング]>>>強化5まで
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
            if (name.contains("ルームティス レッド イアリング")) {
                int e = enchant;
                if (name.contains("祝福された")) {
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
                        op2.effect = "ダメージ低下+20 2%,";
                        break;
                    case 6:
                        op2.HP = 80;
                        op2.DR = 3;
                        op2.effect = "ダメージ低下+20 3%,";
                        op2.AC = -7;
                        break;
                    case 7:
                        op2.HP = 90;
                        op2.DR = 4;
                        op2.effect = "ダメージ低下+20 4%,";
                        op2.HIT_SHORT = 1;      //近距離命中+1
                        op2.HIT_LONG = 1;       //遠距離命中+1
                        op2.AC = -8;            //AC-8
                        break;
                    case 8:
                        op2.HP = 100;
                        op2.DR = 5;
                        op2.effect = "ダメージ低下+20 5%,";
                        op2.HIT_SHORT = 3;      //近距離命中+3
                        op2.HIT_LONG = 3;       //遠距離命中+3
                        op2.AC = -9;            //AC-9
                        break;
                    case 9:
                        op2.HP = 150;
                        op2.DR = 6;
                        op2.effect = "ダメージ低下+20 6%,";
                        op2.HIT_SHORT = 5;      //近距離命中+5
                        op2.HIT_LONG = 5;       //遠距離命中+5
                        op2.AC = -10;           //AC-10
                        break;
                    default:
                        break;
                }
            }
            if (name.contains("ルームティス パープル イアリング")) {
                int e = enchant;
                if (name.contains("祝福された")) {
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
                        op2.HIT_MAGIC = 1;      //魔法命中+1
                        break;
                    case 7:
                        op2.MP = 100;
                        op2.MR = 15;
                        op2.SP = 3;
                        op2.AC = -3;            //AC-3
                        op2.HIT_MAGIC = 3;      //魔法命中+3
                        break;
                    case 8:
                        op2.MP = 130;
                        op2.MR = 20;
                        op2.SP = 4;
                        op2.AC = -4;            //AC-5
                        op2.HIT_MAGIC = 5;      //魔法命中+5
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
                        op2.HIT_MAGIC = 1;      //魔法命中+1
                        break;
                    case 8:
                        op2.MP = 100;
                        op2.MR = 15;
                        op2.SP = 3;
                        op2.AC = -3;            //AC-3
                        op2.HIT_MAGIC = 2;      //魔法命中+2
                        break;
                    default:
                        break;
                }
            }
            }
            if (name.contains("ルームティス ブルー イアリング")) {
                int e = enchant;
                if (name.contains("祝福された")) {
                    e++;
                }
                switch (e) {
                    case 0:
                        op2.effect = "ポーション回復量 +2% +2,";
                        op2.effect += "回復悪化防御 +2% (恐怖),";    //回復悪化防御 +2% (恐怖)
                        break;
                    case 1:
                        op2.effect = "ポーション回復量 +6% +6,";
                        op2.effect += "回復悪化防御 +6% (恐怖),";    //回復悪化防御 +6% (恐怖)
                        break;
                    case 2:
                        op2.effect = "ポーション回復量 +8% +8,";
                        op2.effect += "回復悪化防御 +8% (恐怖),";    //回復悪化防御 +8% (恐怖)
                        break;
                    case 3:
                        op2.effect = "ポーション回復量 +10% +10,";
                        op2.effect += "回復悪化防御 +10% (恐怖),";   //回復悪化防御 +10% (恐怖)
                        break;
                    case 4:
                        op2.effect = "ポーション回復量 +12% +12,";
                        op2.effect += "回復悪化防御 +12% (恐怖),";   //回復悪化防御 +12% (恐怖)
                        break;
                    case 5:
                        op2.AC = -1;
                        op2.effect = "ポーション回復量 +14% +14,";
                        op2.effect += "回復悪化防御 +14% (恐怖),";   //回復悪化防御 +14% (恐怖)
                        break;
                    case 6:
                        op2.AC = -2;
                        op2.effect = "ポーション回復量 +16% +16,";
                        op2.effect += "回復悪化防御 +16% (恐怖),";   //回復悪化防御 +16% (恐怖)
                        break;
                    case 7:
                        op2.AC = -2;
                        op2.effect = "ポーション回復量 +18% +18,";
                        op2.effect += "回復悪化防御 +18% (恐怖),";   //回復悪化防御 +18% (恐怖)
                        break;
                    case 8:
                        op2.AC = -3;
                        op2.effect = "ポーション回復量 +20% +20,";
                        op2.effect += "回復悪化防御 +20% (恐怖),";   //回復悪化防御 +20% (恐怖)
                        break;
                    case 9:
                        op2.AC = -4;
                        op2.effect = "ポーション回復量 +22% +22,";
                        op2.effect += "回復悪化防御 +22% (恐怖),";   //回復悪化防御 +22% (恐怖)
                        break;
                    default:
                        break;
                }
            }
            if (name.contains("ルームティス ブラック イアリング")) {
                int e = enchant;
                if (name.contains("祝福された")) {
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
                        op2.effect = "追加ダメージ +20 2%,";
                        break;
                    case 6:
                        op2.AC = -7;
                        op2.DMG_SHORT = 3;
                        op2.DMG_LONG = 3;
                        op2.effect = "追加ダメージ +20 3%,";
                        break;
                    case 7:
                        op2.AC = -8;
                        op2.DMG_SHORT = 4;
                        op2.DMG_LONG = 4;
                        op2.effect = "追加ダメージ +20 4%,";
                        break;
                    case 8:
                        op2.AC = -9;
                        op2.DMG_SHORT = 5;
                        op2.DMG_LONG = 5;
                        op2.effect = "追加ダメージ +20 5%,";
                        break;
                    case 9:
                        op2.AC = -10;
                        op2.DMG_SHORT = 6;
                        op2.DMG_LONG = 6;
                        op2.effect = "追加ダメージ +20 6%,";
                        break;
                    default:
                        break;
                }
            }
        } else {
            op2.AC += -enchant;
            op2.MR += enchant * mr_enchant;
            }
//インシグニア
            if (name.equals("闘士のインシグニア")) {
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
            if (name.equals("射手のインシグニア")) {
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
            if (name.equals("賢者のインシグニア")) {
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
            if (name.equals("守護のインシグニア")) {
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
            if (name.equals("闘士の守護インシグニア")) {
                switch (enchant) {                          
                    case 5:
                        op2.AC = -3;
                        op2.HP = 30;
                        op2.DR = 1;
                        op2.DMG_SHORT = 1;
                        op2.PVP_DR = 1;
                        op2.effect += "祝福消耗効率 +5%,";
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
                        op2.effect += "祝福消耗効率 +10%,";
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
                        op2.effect += "祝福消耗効率 +15%,";
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
                        op2.effect += "祝福消耗効率 +20%,";
                        break;
                    default:
                        break;
                }
            }
            if (name.equals("射手の守護インシグニア")) {
                switch (enchant) {                          
                    case 5:
                        op2.AC = -3;
                        op2.HP = 30;
                        op2.DR = 1;
                        op2.DMG_LONG = 1;
                        op2.PVP_DR = 1;
                        op2.effect += "祝福消耗効率 +5%,";
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
                        op2.effect += "祝福消耗効率 +10%,";
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
                        op2.effect += "祝福消耗効率 +15%,";
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
                        op2.effect += "祝福消耗効率 +20%,";
                        break;
                    default:
                        break;
                }
            }
            if (name.equals("賢者の守護インシグニア")) {
                switch (enchant) {                          
                    case 5:
                        op2.AC = -3;
                        op2.HP = 30;
                        op2.DR = 1;
                        op2.HIT_SHORT = 1;
                        op2.PVP_DR = 1;
                        op2.effect += "祝福消耗効率 +5%,";
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
                        op2.effect += "祝福消耗効率 +10%,";
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
                        op2.effect += "祝福消耗効率 +15%,";
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
                        op2.effect += "祝福消耗効率 +20%,";
                        break;
                    default:
                        break;
                }
            }
        //ペンダント
            if (name.equals("ルームティス闘士のペンダント")) {
                switch (enchant) {
                    case 1:
                        op2.MHP = 4;                //最大HP+4%
                        op2.MMP = 2;                //最大MP+2%
                        break;
                    case 2:
                        op2.MHP = 6;                //最大HP+6%
                        op2.MMP = 3;                //最大MP+3%
                        op2.MR = 2;                 //MR+2
                        break;
                    case 3:
                        op2.MHP = 8;                //最大HP+8%
                        op2.MMP = 4;                //最大MP+4%
                        op2.MR = 4;                 //MR+4
                        break;               
                    case 4:
                        op2.MHP = 10;               //最大HP+10%
                        op2.MMP = 5;                //最大MP+5%
                        op2.MR = 6;                 //MR+6
                        op2.DMG_SHORT = 1;          //近距離ダメージ+1
                        break;             
                    case 5:
                        op2.MHP = 12;               //最大HP+12%
                        op2.MMP = 6;                //最大MP+6%
                        op2.MR = 10;                //MR+10
                        op2.DMG_SHORT = 2;          //近距離ダメージ+2
                        break;              
                    case 6:
                        op2.MHP = 14;               //最大HP+14%
                        op2.MMP = 7;                //最大MP+7%
                        op2.MR = 12;                //MR+12
                        op2.DMG_SHORT = 3;          //近距離ダメージ+3
                        op2.DG = 2;                 //DG+2
                        op2.ER = 2;                 //ER+2
                        op2.ME = 2;                 //ME+2
                        op2.ailment[STUN] = 2;      //技術耐性+2
                        op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                        op2.ailment[SECRET] = 2;    //秘技耐性+2
                        op2.ailment[TERROR] = 2;    //恐怖耐性+2
                        op2.PVP_DR = 2;             //PVPダメージ低下+2
                        break;              
                    case 7:
                        op2.MHP = 17;               //最大HP+17%
                        op2.MMP = 8;                //最大MP+8%
                        op2.MR = 14;                //MR+14
                        op2.DMG_SHORT = 4;          //近距離ダメージ+4
                        op2.DG = 4;                 //DG+4
                        op2.ER = 4;                 //ER+4
                        op2.ME = 4;                 //ME+4
                        op2.ailment[STUN] = 4;      //技術耐性+4
                        op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                        op2.ailment[SECRET] = 4;    //秘技耐性+4
                        op2.ailment[TERROR] = 4;    //恐怖耐性+4
                        op2.PVP_DR = 4;             //PVPダメージ低下+4
                        break;              
                    case 8:
                        op2.MHP = 20;               //最大HP+20%
                        op2.MMP = 10;               //最大MP+10%
                        op2.MR = 16;                //MR+16
                        op2.DMG_SHORT = 5;          //近距離ダメージ+5
                        op2.DG = 6;                 //DG+6
                        op2.ER = 6;                 //ER+6
                        op2.ME = 6;                 //ME+6
                        op2.ailment[STUN] = 6;      //技術耐性+6
                        op2.ailment[SPIRIT] = 6;    //精霊耐性+6
                        op2.ailment[SECRET] = 6;    //秘技耐性+6
                        op2.ailment[TERROR] = 6;    //恐怖耐性+6
                        op2.PVP_DR = 6;             //PVPダメージ低下+6
                        break;
                    default:
                        break;
                }
            }
            if (name.equals("ルームティス名弓のペンダント")) {
                switch (enchant) {
                    case 1:
                        op2.MHP = 2;                //最大HP+2%
                        op2.MMP = 2;                //最大MP+2%
                        break;
                    case 2:
                        op2.MHP = 3;                //最大HP+3%
                        op2.MMP = 3;                //最大MP+3%
                        op2.MR = 2;                 //MR+2
                        break;
                    case 3:
                        op2.MHP = 5;                //最大HP+5%
                        op2.MMP = 5;                //最大MP+5%
                        op2.MR = 4;                 //MR+4
                        break;               
                    case 4:
                        op2.MHP = 7;                //最大HP+7%
                        op2.MMP = 7;                //最大MP+7%
                        op2.MR = 6;                 //MR+6
                        op2.DMG_LONG = 1;           //遠距離ダメージ+1
                        break;             
                    case 5:
                        op2.MHP = 9;                //最大HP+9%
                        op2.MMP = 9;                //最大MP+9%
                        op2.MR = 10;                //MR+10
                        op2.DMG_LONG = 2;           //遠距離ダメージ+2
                        break;              
                    case 6:
                        op2.MHP = 11;               //最大HP+11%
                        op2.MMP = 11;               //最大MP+11%
                        op2.MR = 12;                //MR+12
                        op2.DMG_LONG = 3;           //遠距離ダメージ+3
                        op2.DG = 2;                 //DG+2
                        op2.ER = 2;                 //ER+2
                        op2.ME = 2;                 //ME+2
                        op2.ailment[STUN] = 2;      //技術耐性+2
                        op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                        op2.ailment[SECRET] = 2;    //秘技耐性+2
                        op2.ailment[TERROR] = 2;    //恐怖耐性+2
                        op2.PVP_DR = 2;             //PVPダメージ低下+2
                        break;              
                    case 7:
                        op2.MHP = 13;               //最大HP+13%
                        op2.MMP = 13;               //最大MP+13%
                        op2.MR = 14;                //MR+14
                        op2.DMG_LONG = 4;           //遠距離ダメージ+4
                        op2.DG = 4;                 //DG+4
                        op2.ER = 4;                 //ER+4
                        op2.ME = 4;                 //ME+4
                        op2.ailment[STUN] = 4;      //技術耐性+4
                        op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                        op2.ailment[SECRET] = 4;    //秘技耐性+4
                        op2.ailment[TERROR] = 4;    //恐怖耐性+4
                        op2.PVP_DR = 4;             //PVPダメージ低下+4
                        break;              
                    case 8:
                        op2.MHP = 15;               //最大HP+15%
                        op2.MMP = 15;               //最大MP+15%
                        op2.MR = 16;                //MR+16
                        op2.DMG_LONG = 5;           //遠距離ダメージ+5
                        op2.DG = 6;                 //DG+6
                        op2.ER = 6;                 //ER+6
                        op2.ME = 6;                 //ME+6
                        op2.ailment[STUN] = 6;      //技術耐性+6
                        op2.ailment[SPIRIT] = 6;    //精霊耐性+6
                        op2.ailment[SECRET] = 6;    //秘技耐性+6
                        op2.ailment[TERROR] = 6;    //恐怖耐性+6
                        op2.PVP_DR = 6;             //PVPダメージ低下+6
                        break;
                    default:
                        break;
                }
            }
            if (name.equals("ルームティス賢者のペンダント")) {
                switch (enchant) {
                    case 1:
                        op2.MHP = 2;                //最大HP+2%
                        op2.MMP = 4;                //最大MP+4%
                        break;
                    case 2:
                        op2.MHP = 3;                //最大HP+3%
                        op2.MMP = 6;                //最大MP+6%
                        op2.MR = 2;                 //MR+2
                        break;
                    case 3:
                        op2.MHP = 4;                //最大HP+4%
                        op2.MMP = 8;                //最大MP+8%
                        op2.MR = 4;                 //MR+4
                        break;               
                    case 4:
                        op2.MHP = 5;                //最大HP+5%
                        op2.MMP = 10;               //最大MP+10%
                        op2.MR = 6;                 //MR+6
                        op2.SP = 1;                 //SP+1
                        break;             
                    case 5:
                        op2.MHP = 6;                //最大HP+6%
                        op2.MMP = 12;               //最大MP+12%
                        op2.MR = 10;                //MR+10
                        op2.SP = 2;                 //SP+2
                        break;              
                    case 6:
                        op2.MHP = 7;                //最大HP+7%
                        op2.MMP = 14;               //最大MP+14%
                        op2.MR = 12;                //MR+12
                        op2.SP = 3;                 //SP+3
                        op2.DG = 2;                 //DG+2
                        op2.ER = 2;                 //ER+2
                       op2.ME = 2;                 //ME+2
                        op2.ailment[STUN] = 2;      //技術耐性+2
                        op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                        op2.ailment[SECRET] = 2;    //秘技耐性+2
                        op2.ailment[TERROR] = 2;    //恐怖耐性+2
                        op2.PVP_DR = 2;             //PVPダメージ低下+2
                        break;              
                    case 7:
                        op2.MHP = 8;                //最大HP+8%
                        op2.MMP = 17;               //最大MP+17%
                        op2.MR = 14;                //MR+14
                        op2.SP = 4;                 //SP+4
                        op2.DG = 4;                 //DG+4
                        op2.ER = 4;                 //ER+4
                        op2.ME = 4;                 //ME+4
                        op2.ailment[STUN] = 4;      //技術耐性+4
                        op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                        op2.ailment[SECRET] = 4;    //秘技耐性+4
                        op2.ailment[TERROR] = 4;    //恐怖耐性+4
                        op2.PVP_DR = 4;             //PVPダメージ低下+4
                        break;              
                    case 8:
                        op2.MHP = 10;               //最大HP+10%
                        op2.MMP = 20;               //最大MP+20%
                        op2.MR = 16;                //MR+16
                        op2.SP = 5;                 //SP+5
                        op2.DG = 6;                 //DG+6
                        op2.ER = 6;                 //ER+6
                        op2.ME = 6;                 //ME+6
                        op2.ailment[STUN] = 6;      //技術耐性+6
                        op2.ailment[SPIRIT] = 6;    //精霊耐性+6
                        op2.ailment[SECRET] = 6;    //秘技耐性+6
                        op2.ailment[TERROR] = 6;    //恐怖耐性+6
                        op2.PVP_DR = 6;             //PVPダメージ低下+6
                        break;
                    default:
                        break;
                }
            }
            if (name.equals("ルームティス狩猟のペンダント")) {
                switch (enchant) {
                    case 1:
                        op2.MHP = 2;                //最大HP+2%
                        op2.MMP = 2;                //最大MP+2%
                        break;
                    case 2:
                        op2.MHP = 3;                //最大HP+3%
                        op2.MMP = 3;                //最大MP+3%
                        op2.MR = 2;                 //MR+2
                        break;
                    case 3:
                        op2.MHP = 4;                //最大HP+4%
                        op2.MMP = 4;                //最大MP+4%
                        op2.MR = 4;                 //MR+4
                        break;               
                    case 4:
                        op2.MHP = 5;                //最大HP+5%
                        op2.MMP = 5;                //最大MP+5%
                        op2.MR = 6;                 //MR+6
                        op2.MEXP = 4;               //獲得経験値+4%
                        break;             
                    case 5:
                        op2.MHP = 6;                //最大HP+6%
                        op2.MMP = 6;                //最大MP+6%
                        op2.MR = 10;                //MR+10
                        op2.MEXP = 8;               //獲得経験値+8%
                        break;              
                    case 6:
                        op2.MHP = 7;                //最大HP+7%
                        op2.MMP = 7;                //最大MP+7%
                        op2.MR = 12;                //MR+12
                        op2.MEXP = 12;              //獲得経験値+12%
                        op2.DG = 2;                 //DG+2
                        op2.ER = 2;                 //ER+2
                        op2.ME = 2;                 //ME+2
                        op2.ailment[STUN] = 2;      //技術耐性+2
                        op2.ailment[SPIRIT] = 2;    //精霊耐性+2
                        op2.ailment[SECRET] = 2;    //秘技耐性+2
                        op2.ailment[TERROR] = 2;    //恐怖耐性+2
                        op2.PVP_DR = 2;             //PVPダメージ低下+2
                        break;              
                    case 7:
                        op2.MHP = 8;                //最大HP+8%
                        op2.MMP = 8;                //最大MP+8%
                        op2.MR = 14;                //MR+14
                        op2.MEXP = 16;              //獲得経験値+16%
                        op2.DG = 4;                 //DG+4
                        op2.ER = 4;                 //ER+4
                        op2.ME = 4;                 //ME+4
                        op2.ailment[STUN] = 4;      //技術耐性+4
                        op2.ailment[SPIRIT] = 4;    //精霊耐性+4
                        op2.ailment[SECRET] = 4;    //秘技耐性+4
                        op2.ailment[TERROR] = 4;    //恐怖耐性+4
                        op2.PVP_DR = 4;             //PVPダメージ低下+4
                        break;              
                    case 8:
                        op2.MHP = 10;               //最大HP+10%
                        op2.MMP = 10;               //最大MP+10%
                        op2.MR = 16;                //MR+16
                        op2.MEXP = 20;              //獲得経験値+20%
                        op2.DG = 6;                 //DG+6
                        op2.ER = 6;                 //ER+6
                        op2.ME = 6;                 //ME+6
                        op2.ailment[STUN] = 6;      //技術耐性+6
                        op2.ailment[SPIRIT] = 6;    //精霊耐性+6
                        op2.ailment[SECRET] = 6;    //秘技耐性+6
                        op2.ailment[TERROR] = 6;    //恐怖耐性+6
                        op2.PVP_DR = 6;             //PVPダメージ低下+6
                        break;
                    default:
                        break;
                }
            }
    }
}
