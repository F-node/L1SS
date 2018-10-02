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
                if (line.startsWith("安全=")) {
                    safety = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("強化限界=")) {
                    max_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("type=")) {
                    type = line.split("=")[1];
                }
                if (line.startsWith("材質=")) {
                    material = line.split("=")[1];
                }
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
            //text += " 追加打撃+" + (op.DMG_SHORT + op2.DMG_SHORT);
            text += " 近距離ダメージ+" + (op.DMG_SHORT + op2.DMG_SHORT);
        }
        if (op.HIT_SHORT + op2.HIT_SHORT > 0) {
            //text += " 攻撃成功+" + (op.HIT_SHORT + op2.HIT_SHORT);
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
        if (op.DR + op2.DR > 0) {
            //text += " ダメージ低下" + (op.DR + op2.DR);
            text += " DR" + (op.DR + op2.DR);
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
            text += " スタン耐性+" + (op.ailment[STUN] + op2.ailment[STUN]);
        }
        if (op.ailment[HOLD] + op2.ailment[HOLD] > 0) {
            text += " ホールド耐性+" + (op.ailment[HOLD] + op2.ailment[HOLD]);
        }
        if (op.ailment[SLEEP] + op2.ailment[SLEEP] > 0) {
            text += " 睡眠耐性+" + (op.ailment[SLEEP] + op2.ailment[SLEEP]);
        }
        if (op.ailment[FREEZE] + op2.ailment[FREEZE] > 0) {
            text += " 凍結耐性+" + (op.ailment[FREEZE] + op2.ailment[FREEZE]);
        }
        if (op.ailment[STONE] + op2.ailment[STONE] > 0) {
            text += " 石化耐性+" + (op.ailment[STONE] + op2.ailment[STONE]);
        }
        if (op.ailment[DARKNESS] + op2.ailment[DARKNESS] > 0) {
            text += " 暗闇耐性+" + (op.ailment[DARKNESS] + op2.ailment[DARKNESS]);
        }
        if (op.ailment[TERROR] + op2.ailment[TERROR] > 0) {
            text += " 恐怖耐性+" + (op.ailment[TERROR] + op2.ailment[TERROR]);
        }
        if (op.ailment[DESTRUCTION] + op2.ailment[DESTRUCTION] > 0) {
            text += " 破壊耐性+" + (op.ailment[DESTRUCTION] + op2.ailment[DESTRUCTION]);
        }
        if (op.ailment[HIT_STUN] + op2.ailment[HIT_STUN] > 0) {
            text += " スタン命中+" + (op.ailment[HIT_STUN] + op2.ailment[HIT_STUN]);
        }
        if (op.ailment[HIT_HOLD] + op2.ailment[HIT_HOLD] > 0) {
            text += " ホールド命中+" + (op.ailment[HIT_HOLD] + op2.ailment[HIT_HOLD]);
        }
        if (op.ailment[HIT_SLEEP] + op2.ailment[HIT_SLEEP] > 0) {
            text += " 睡眠命中+" + (op.ailment[HIT_SLEEP] + op2.ailment[HIT_SLEEP]);
        }
        if (op.ailment[HIT_FREEZE] + op2.ailment[HIT_FREEZE] > 0) {
            text += " 凍結命中+" + (op.ailment[HIT_FREEZE] + op2.ailment[HIT_FREEZE]);
        }
        if (op.ailment[HIT_STONE] + op2.ailment[HIT_STONE] > 0) {
            text += " 石化命中+" + (op.ailment[HIT_STONE] + op2.ailment[HIT_STONE]);
        }
        if (op.ailment[HIT_DARKNESS] + op2.ailment[HIT_DARKNESS] > 0) {
            text += " 暗闇命中+" + (op.ailment[HIT_DARKNESS] + op2.ailment[HIT_DARKNESS]);
        }
        if (op.ailment[HIT_TERROR] + op2.ailment[HIT_TERROR] > 0) {
            text += " 恐怖命中+" + (op.ailment[HIT_TERROR] + op2.ailment[HIT_TERROR]);
        }
        if (op.ailment[HIT_DESTRUCTION] + op2.ailment[HIT_DESTRUCTION] > 0) {
            text += " 破壊命中+" + (op.ailment[HIT_DESTRUCTION] + op2.ailment[HIT_DESTRUCTION]);
        }
        if (op.PVP + op2.PVP > 0) {
            //text += " PVPダメージ+" + (op.PVP + op2.PVP);
            text += " PVP追加ダメージ+" + (op.PVP + op2.PVP);
        }
        if (op.PVPDR + op2.PVPDR > 0) {
            text += " PVPダメージ減少+" + (op.PVPDR + op2.PVPDR);
        }
        //所持重量の追加
        if (op.c_weight + op2.c_weight > 0) {
            text += " 所持重量増加+" + (op.c_weight + op2.c_weight);
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

        if (name.contains("テイパーガーダー")) {
            if (name.contains("腕力")) {
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
            if (name.contains("機敏")) {
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
            if (name.contains("知力")) {
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

        if (name.equals("地竜のTシャツ")) {
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
        if (name.equals("火竜のTシャツ")) {
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
        if (name.equals("風竜のTシャツ")) {
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
        if (name.equals("水竜のTシャツ")) {
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

        if (name.contains("アンタラスグランド")) {
            if (enchant > 6) {
                op2.DR += enchant - 6;
            }
        }
        if (name.equals("ヴァラカスフレイムプレートメイル")) {
            if (enchant >= 9) {
                op2.CRI_SHORT = 3;
            } else if (enchant >= 8) {
                op2.CRI_SHORT = 2;
            } else if (enchant >= 7) {
                op2.CRI_SHORT = 1;
            }
        }
        if (name.equals("ヴァラカスフレイムスケイルメイル")) {
            if (enchant >= 9) {
                op2.CRI_SHORT = 3;
            } else if (enchant >= 8) {
                op2.CRI_SHORT = 2;
            } else if (enchant >= 7) {
                op2.CRI_SHORT = 1;
            }
        }
        if (name.equals("ヴァラカスフレイムレザーアーマー")) {
            if (enchant >= 9) {
                op2.CRI_LONG = 3;
            } else if (enchant >= 8) {
                op2.CRI_LONG = 2;
            } else if (enchant >= 7) {
                op2.CRI_LONG = 1;
            }
        }
        if (name.equals("ヴァラカスフレイムローブ")) {
            if (enchant >= 9) {
                op2.CRI_MAGIC = 3;
            } else if (enchant >= 8) {
                op2.CRI_MAGIC = 2;
            } else if (enchant >= 7) {
                op2.CRI_MAGIC = 1;
            }
        }
        if (name.equals("輝く魔力のグローブ")) {
            if (enchant > 4) {
                op2.c_weight += 60 * (enchant - 4);
            }
        }
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
                            op2.ailment[STUN] += 2;     //スタン耐性+2           //スタン耐性+9
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
                            op2.ailment[STUN] += 2;     //スタン耐性+2           //スタン耐性+7
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
                            op2.ailment[STUN] += 5;     //スタン耐性+5           //スタン耐性+5
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
                            op2.ailment[STUN] += 2;     //スタン耐性+2           //スタン耐性+9                          
                            op2.HP += 10;               //HP+10                 //HP+50
                            op2.MP += 5;                //MP+5                  //MP+35
                                                                                //MP自然回復+1
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+2 
                                                                                //所持重量増加+360
                        case 7:
                            op2.AC--;                   //AC-1                  //AC-5
                            op2.SP++;                   //SP+1                  //SP+4
                            op2.HIT_MAGIC++;            //魔法命中+1             //魔法命中+2
                            op2.ailment[STUN] += 2;     //スタン耐性+2           //スタン耐性+7
                            op2.HP += 5;                //HP+5                  //HP+40
                            op2.MP += 5;                //MP+5                  //MP+30
                                                                                //MP自然回復+1
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //所持重量増加+360
                        case 6:
                                                                                //AC-5 
                            op2.SP++;                   //SP+1                  //SP+3
                            op2.HIT_MAGIC++;            //魔法命中+1             //魔法命中+1
                            op2.ailment[STUN] += 5;     //スタン耐性+5           //スタン耐性+5
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
                            op2.ailment[STUN] += 2;     //スタン耐性+2           //スタン耐性+9
                            op2.HP += 10;               //HP+10                 //HP+115
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //所持重量増加+360
                        case 7:
                            op2.AC--;                   //AC-1                  //AC-7
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+4
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+4
                            op2.DR++;                   //DR+1                  //DR+2
                                                        //確率ダメージ低下20 +1% //確率ダメージ低下20 +2%
                            op2.ailment[STUN] += 2;     //スタン耐性+2           //スタン耐性+7
                            op2.HP += 10;               //HP+10                 //HP+105
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //所持重量増加+360
                        case 6:
                                                                                //AC-6
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+3
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+3
                            op2.DR++;                   //DR+1                  //DR+1
                                                        //確率ダメージ低下20 +1% //確率ダメージ低下20 +1%
                            op2.ailment[STUN] += 5;     //スタン耐性+5           //スタン耐性+5
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
                            op2.ailment[STUN] += 2;     //スタン耐性+2           //スタン耐性+9
                                                                                //HP+50
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //所持重量増加+360
                        case 7:
                            op2.AC--;                   //AC-3                  //AC-7
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+4
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+4
                            op2.MR++;                   //MR+1                  //MR+9
                                                        //確率魔法回避+2         //確率魔法回避+3
                            op2.ailment[STUN] += 2;     //スタン耐性+2           //スタン耐性+7
                            op2.HP += 5;                //HP+5                  //HP+50
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //所持重量増加+360
                        case 6:
                                                                                //AC-6
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+3
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+3
                            op2.MR++;                   //MR+1                  //MR+8
                                                        //確率魔法回避+1         //確率魔法回避+1
                            op2.ailment[STUN] += 5;     //スタン耐性+5           //スタン耐性+5
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
                            op2.ailment[STUN] += 2;     //スタン耐性+2           //スタン耐性+9
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360
                        case 7:
                                                                                //AC-5
                            op2.HP += 5;                //HP+5                  //HP+50
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+4
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+4
                            op2.ailment[STUN] += 2;     //スタン耐性+2           //スタン耐性+9
                            op2.PVP++;                  //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360
                        case 6:
                                                                                //AC-5
                            op2.HP += 5;                //HP+5                  //HP+45
                            op2.DMG_LONG++;             //遠距離ダメージ+1       //遠距離ダメージ+3
                            op2.DMG_SHORT++;            //近距離ダメージ+1       //近距離ダメージ+3
                            op2.ailment[STUN] += 5;     //スタン耐性+5           //スタン耐性+5
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
                        op2.ailment[STUN] += 2;         //スタン耐性+2           //スタン耐性+9
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
                        op2.ailment[STUN] += 2;         //スタン耐性+2           //スタン耐性+7
                                                                                //HP自然回復+2
                                                                                //所持重量増加+360
                    case 6:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+20
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+2
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+2
                        op2.HIT_SHORT++;                //近距離命中+1           //近距離命中+2
                        op2.HIT_LONG++;                 //遠距離命中+1           //遠距離命中+2
                        op2.ailment[STUN] += 5;         //スタン耐性+5           //スタン耐性+5
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
                        op2.ailment[STUN] += 2;         //スタン耐性+2           //スタン耐性+9
                        op2.HIT_MAGIC++;                //魔法命中+1             //魔法命中+2
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+2
                        op2.MP += 15;                   //MP+15                 //MP+30
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360
                    case 7:
                                                                                //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+35
                        op2.SP++;                       //SP+1                  //SP+3
                        op2.ailment[STUN] += 2;         //スタン耐性+2           //スタン耐性+7
                        op2.HIT_MAGIC++;                //魔法命中+1             //魔法命中+1
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+1                       
                                                                                //MP+15
                                                                                //MP自然回復+1
                                                                                //所持重量増加+360                       
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.HP += 5;                    //HP+5                  //HP+30
                        op2.SP++;                       //SP+1                  //SP+2
                        op2.ailment[STUN] += 5;         //スタン耐性+2           //スタン耐性+5                      
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
                        op2.ailment[STUN] += 2;         //スタン耐性+2           //スタン耐性+9
                        op2.HP += 5;                    //HP+5                  //HP+100
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //所持重量増加+360
                    case 7:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+3
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+3
                        op2.DR++;                       //DR+1                  //DR+1
                                                        //確率ダメージ低下20 +1% //確率ダメージ低下20 +1%
                        op2.ailment[STUN] += 2;         //スタン耐性+2           //スタン耐性+7
                        op2.HP += 5;                    //HP+5                  //HP+95
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //所持重量増加+360
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+2
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+2
                        op2.ailment[STUN] += 5;         //スタン耐性+5           //スタン耐性+5
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
                        op2.ailment[STUN] += 2;         //スタン耐性+2           //スタン耐性+9
                        op2.HP += 5;                    //HP+5                  //HP+50
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //所持重量増加+360
                    case 7:
                                                                                //AC-5
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+3
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+3
                                                                                //MR+7
                                                        //確率魔法回避+2         //確率魔法回避+1
                        op2.ailment[STUN] += 2;         //スタン耐性+2           //スタン耐性+7
                        op2.HP += 5;                    //HP+5                  //HP+45
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //所持重量増加+360
                    case 6:
                        op2.AC--;                       //AC-1                  //AC-5
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+2
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+2
                                                                                //MR+7
                        op2.ailment[STUN] += 5;         //スタン耐性+5           //スタン耐性+5
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
                        op2.ailment[STUN] += 2;         //スタン耐性+2           //スタン耐性+9
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+2
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360 
                    case 7:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+45
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+3
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+3
                        op2.ailment[STUN] += 2;         //スタン耐性+2           //スタン耐性+7
                        op2.PVP++;                      //PVP追加ダメージ+1      //PVP追加ダメージ+1
                                                                                //MP自然回復+1          //MP+30            //HP自然回復+2
                                                                                //所持重量増加+360 
                    case 6:
                                                                                //AC-4
                        op2.HP += 5;                    //HP+5                  //HP+40
                        op2.DMG_LONG++;                 //遠距離ダメージ+1       //遠距離ダメージ+2
                        op2.DMG_SHORT++;                //近距離ダメージ+1       //近距離ダメージ+2
                        op2.ailment[STUN] += 5;         //スタン耐性+5           //スタン耐性+5
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

        if (name.contains("リッチローブ")) {
            if (enchant >= 3) {
                op2.SP = enchant - 2;
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

        if (name.equals("幸運のサークレット")) {
            if (enchant > 0) {
                op2.SP = 1;
            }
        }

        if (name.equals("大魔法使いの帽子")) {
            op2.MP = 10 * enchant;
        }

        if (name.equals("シンセシスゲートル")) {
            op2.HP = 5 * enchant;
        }

        //腕力のゲートルは+9[近距離ダメージ+1]
        if (name.equals("ユニコーンの腕力のゲートル")) {
            if (enchant >= 9) {
                op2.DMG_SHORT = 1;
	    }
        } 

        //機敏のゲートルは+9[遠距離ダメージ+1]
        if (name.equals("ユニコーンの機敏のゲートル")) {
            if (enchant >= 9) {
                op2.DMG_LONG = 1;
	    }
        } 

        //知力のゲートル+9[SP+1] 
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
            //+10強化オプション[ダメージ軽減+1]
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
            //+10強化オプション[ダメージ軽減+1]
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
            //+10強化オプション[ダメージ軽減+1]
            if (enchant >= 10) {
                op2.DR = 1;
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

        //+1強化するごとにAC-1されない防具・アイテム
        if (type.equals("リング") || type.equals("アミュレット") || type.equals("イアリング") || type.equals("ベルト") || type.equals("紋章") || type.equals("インシグニア")) {

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
                    }
                    break; 
                case "成長の紋章":          //+0成長の紋章でEXP+1%
                    switch (enchant) {
                        case 0:
                            op2.effect = "EXP +1%,";
                            break;
                        case 1:
                            op2.effect = "EXP +2%,";
                            op2.effect += "ポーション回復量 +2% +2,";
                            op2.effect += "回復悪化防御 +2%,";
                            break;
                        case 2:
                            op2.effect = "EXP +3%,";
                            op2.effect += "ポーション回復量 +4% +4,";
                            op2.effect += "回復悪化防御 +4%,";
                            break;
                        case 3:
                            op2.effect = "EXP +4%,";
                            op2.effect += "ポーション回復量 +6% +6,";
                            op2.effect += "回復悪化防御 +6%,";
                            break;
                        case 4:
                            op2.effect = "EXP +5%,";
                            op2.effect += "ポーション回復量 +8% +8,";
                            op2.effect += "回復悪化防御 +8%,";
                            break;
                        case 5:
                            op2.effect = "EXP +6%,";
                            op2.effect += "ポーション回復量 +9% +9,";
                            op2.effect += "回復悪化防御 +9%,";
                            break;
                        case 6:
                            op2.effect = "EXP +7%,";
                            op2.effect += "ポーション回復量 +10% +10,";
                            op2.effect += "回復悪化防御 +10%,";
                            break;
                        case 7:
                            op2.effect = "EXP +9%,";
                            op2.effect += "ポーション回復量 +11% +11,";
                            op2.effect += "回復悪化防御 +11%,";
                            break;
                        case 8:
                            op2.effect = "EXP +11%,";
                            op2.effect += "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            break;
                        case 9:
                            op2.effect = "EXP +13%,";
                            op2.effect += "ポーション回復量 +13% +13,";
                            op2.effect += "回復悪化防御 +13%,";
                            break;
                        case 10:
                            op2.effect = "EXP +15%,";
                            op2.effect += "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            break;
                    }
                    break;         
                case "守護の紋章":          //+0守護の紋章でAC=-1
                    switch (enchant) {
                        case 1:
                            op2.effect = "獲得EXP +1%,";
                            break;
                        case 2:
                            op2.effect = "獲得EXP +2%,";
                            break;
                        case 3:
                            op2.effect = "獲得EXP +3%,";
                            break;
                        case 4:
                            op2.effect = "獲得EXP +4%,";
                            op2.MR = 1;
                            break;
                        case 5:
                            op2.effect = "獲得EXP +5%,";
                            op2.MR = 2;
                            break;
                        case 6:
                            op2.effect = "獲得EXP +6%,";
                            op2.MR = 3;
                            break;
                        case 7:
                            op2.effect = "獲得EXP +7%,";
                            op2.MR = 4;
                            break;
                        case 8:
                            op2.effect = "獲得EXP +8%,";
                            op2.MR = 5;
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
                    }
                    break;
                case "闘士の守護紋章":                      //+5闘士の守護紋章から
                    switch (enchant) {
                        case 5:
                            op2.ST[STR] = 1;
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.effect += "祝福消耗効率 +3%,";                            
                            op2.DMG_SHORT = 1;
                            op2.HIT_SHORT = 2;
                            op2.MR = 4;
                            break;
                        case 6:
                            op2.ST[STR] = 1;
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.effect += "祝福消耗効率 +5%,";
                            op2.DMG_SHORT = 2;
                            op2.HIT_SHORT = 3;
                            op2.MR = 6;
                            break;
                        case 7:
                            op2.ST[STR] = 1;
                            op2.effect = "ポーション回復量 +16% +16,";
                            op2.effect += "回復悪化防御 +16%,";
                            op2.effect += "祝福消耗効率 +7%,";
                            op2.DMG_SHORT = 3;
                            op2.HIT_SHORT = 4;
                            op2.MR = 8;
                            break;
                        case 8:
                            op2.ST[STR] = 1;
                            op2.effect = "ポーション回復量 +18% +18,";
                            op2.effect += "回復悪化防御 +18%,";
                            op2.effect += "祝福消耗効率 +10%,";
                            op2.DMG_SHORT = 4;
                            op2.HIT_SHORT = 5;
                            op2.MR = 10;
                            break;
                    }
                    break;
                case "射手の守護紋章":                      //+5射手の守護紋章から
                    switch (enchant) {
                            case 5:
                            op2.ST[DEX] = 1;
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.effect += "祝福消耗効率 +3%,";                            
                            op2.DMG_LONG = 1;
                            op2.HIT_LONG = 2;
                            op2.MR = 4;
                            break;
                        case 6:
                            op2.ST[DEX] = 1;
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.effect += "祝福消耗効率 +5%,";
                            op2.DMG_LONG = 2;
                            op2.HIT_LONG = 3;
                            op2.MR = 6;
                            break;
                        case 7:
                            op2.ST[DEX] = 1;
                            op2.effect = "ポーション回復量 +16% +16,";
                            op2.effect += "回復悪化防御 +16%,";
                            op2.effect += "祝福消耗効率 +7%,";
                            op2.DMG_LONG = 3;
                            op2.HIT_LONG = 4;
                            op2.MR = 8;
                            break;
                        case 8:
                            op2.ST[DEX] = 1;
                            op2.effect = "ポーション回復量 +18% +18,";
                            op2.effect += "回復悪化防御 +18%,";
                            op2.effect += "祝福消耗効率 +10%,";
                            op2.DMG_LONG = 4;
                            op2.HIT_LONG = 5;
                            op2.MR = 10;
                            break;
                    }
                    break;
                case "賢者の守護紋章":                      //+5賢者の守護紋章から
                    switch (enchant) {
                        case 5:
                            op2.ST[INT] = 1;
                            op2.effect = "ポーション回復量 +12% +12,";
                            op2.effect += "回復悪化防御 +12%,";
                            op2.effect += "祝福消耗効率 +3%,";
                            op2.SP = 1;
                            op2.HIT_MAGIC = 2;
                            op2.MR = 6;
                            break;
                        case 6:
                            op2.ST[INT] = 1;
                            op2.effect = "ポーション回復量 +14% +14,";
                            op2.effect += "回復悪化防御 +14%,";
                            op2.effect += "祝福消耗効率 +5%,";
                            op2.SP = 2;
                            op2.HIT_MAGIC = 3;
                            op2.MR = 6;
                            break;
                        case 7:
                            op2.ST[INT] = 1;
                            op2.effect = "ポーション回復量 +16% +16,";
                            op2.effect += "回復悪化防御 +16%,";
                            op2.effect += "祝福消耗効率 +7%,";
                            op2.SP = 3;
                            op2.HIT_MAGIC = 4;
                            op2.MR = 8;
                            break;
                        case 8:
                            op2.ST[INT] = 1;
                            op2.effect = "ポーション回復量 +18% +18,";
                            op2.effect += "回復悪化防御 +18%,";
                            op2.effect += "祝福消耗効率 +10%,";
                            op2.SP = 4;
                            op2.HIT_MAGIC = 5;
                            op2.MR = 10;
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
            }

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
                        break;
                    case 7:
                        op2.HP = 50;
                        op2.DMG_LONG = 3;
                        op2.DMG_SHORT = 3;
                        op2.SP = 1;
                        op2.MR = 3;
                        op2.PVP = 1;        //PVP追加ダメージ+1
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.DMG_LONG = 4;
                        op2.DMG_SHORT = 4;
                        op2.PVP = 2;        //PVP追加ダメージ+2
                        op2.SP = 2;
                        op2.MR = 5;
                        break;
                    case 9:
                        op2.HP = 60;
                        op2.DMG_LONG = 5;
                        op2.DMG_SHORT = 5;
                        op2.PVP = 3;        //PVP追加ダメージ+3
                        op2.SP = 3;
                        op2.MR = 7;
                        break;
                }
            }

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
                        op2.AC -= 4;
                        op2.ailment[STUN] += 4;
                        break;
                }

            }

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
                        break;
                    case 7:
                        op2.HP = 30;
                        op2.MP = 50;
                        op2.DR = 3;
                        op2.PVPDR=2;        //PVPダメージ軽減+2
                        break;
                    case 8:
                        op2.HP = 40;
                        op2.MP = 50;
                        op2.DR = 4;
                        op2.PVPDR=3;        //PVPダメージ軽減+3                        
                        break;
                    case 9:
                        op2.HP = 50;
                        op2.MP = 60;
                        op2.DR = 5;
                        op2.PVPDR=4;        //PVPダメージ軽減+4
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
                        op2.effect = "ダメージ軽減+20 2%,";
                        break;
                    case 6:
                        op2.HP = 80;
                        op2.DR = 3;
                        op2.effect = "ダメージ軽減+20 3%,";
                        op2.AC = -7;
                        break;
                    case 7:
                        op2.HP = 90;
                        op2.DR = 4;
                        op2.effect = "ダメージ軽減+20 4%,";
                        op2.HIT_SHORT = 1;      //近距離命中+1
                        op2.HIT_LONG = 1;       //遠距離命中+1
                        op2.AC = -8;            //AC-8
                        break;
                    case 8:
                        op2.HP = 100;
                        op2.DR = 5;
                        op2.effect = "ダメージ軽減+20 5%,";
                        op2.HIT_SHORT = 3;      //近距離命中+3
                        op2.HIT_LONG = 3;       //遠距離命中+3
                        op2.AC = -9;            //AC-9
                        break;
                    case 9:
                        op2.HP = 150;
                        op2.DR = 6;
                        op2.effect = "ダメージ軽減+20 6%,";
                        op2.HIT_SHORT = 5;      //近距離命中+5
                        op2.HIT_LONG = 5;       //遠距離命中+5
                        op2.AC = -10;           //AC-10
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
                }
            }
    }
}
