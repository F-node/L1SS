package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Buki implements Common {

    int small = 0;
    int big = 0;
    String name = "";
    String type = "";
    double critical_rate = 0;// クロウ クリティカル
    double double_hit_rate = 0;// デュアルブレード ダブルヒット
    double week_point_exposure = 0;// チェーンソード 弱点露出
    boolean two_hands = false;
//    String equip = "";
    String material = "";
    Buff op = new Buff();
    Buff op2 = new Buff();
    int enchant = 0;
    int magic_enchant = 0;
    int max_enchant = 0;
    String arrow_name = "";
    String arrow_material = "";
//    String arrow_type = "";
//    int arrow_small = 0;
//    int arrow_big = 0;
    int arrow_dmg = 0;
    int arrow_elementdmg = 0; 
    int arrow_hit = 0;
    
    int safety = 0;
    boolean element_enchant = false;
    // キーリンク用
    int x, y, z;
    // 魔法武器用
    String magic_name = "";
//    boolean magic_motion = false;
    double magic_rate = 0;
    double magic_rate_plus = 0;
    String magic_element = "";
    double magic_power = 0;
    double magic_delay = 0;
//    int weight = 0;

    private void reset() {
        small = 0;
        big = 0;
        name = "";
        type = "";
        critical_rate = 0;
        double_hit_rate = 0;
        week_point_exposure = 0;
        two_hands = false;
        material = "";
        op = new Buff();
        op2 = new Buff();
        enchant = 0;
        magic_enchant = 0;
        arrow_name = "";
        arrow_material = "";
//        arrow_type = "";
        arrow_dmg = 0;
        arrow_elementdmg = 0;
        arrow_hit = 0;

        safety = 0;
        element_enchant = false;

        magic_name = "";
//        magic_motion = false;
        magic_rate = 0;
        magic_element = "";
        magic_power = 0;
        magic_delay = 0;
        magic_rate_plus = 0;

//        weight = 0;
    }

    void load(BufferedReader reader) {
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
                if (line.startsWith("small=")) {
                    small = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("big=")) {
                    big = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("type=")) {
                    type = line.split("=")[1];
                }
                if (line.startsWith("ダメージダイス=")) {
                    x = Integer.parseInt(line.split("=")[1].split("d")[0]);
                    y = Integer.parseInt(line.split("=")[1].split("d")[1]
                            .split("\\+")[0]);
                    z = Integer.parseInt(line.split("=")[1].split("d")[1]
                            .split("\\+")[1]);
                }
//                if (line.startsWith("equip=")) {
//                    equip = line.split("=")[1];
//                }
                if (line.startsWith("name=")) {
                    name = line.split("=")[1];
                }
                if (line.startsWith("クリティカル=")) {
                    critical_rate = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("ダブルヒット=")) {
                    double_hit_rate = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("安全=")) {
                    safety = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("強化限界=")) {
                    max_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("材質=")) {
                    material = line.split("=")[1];
                }
                if (line.startsWith("両手武器=")) {
                    two_hands = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("属性強化=")) {
                    element_enchant = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("魔法ダメージ=")) {
                    magic_power = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("魔法発動率=")) {
                    magic_rate = Double.parseDouble(line.split("=")[1]);
                }
//                if (line.startsWith("魔法モーション=")) {
//                    magic_motion = Boolean.parseBoolean(line.split("=")[1]);
//                }
                if (line.startsWith("魔法属性=")) {
                    magic_element = line.split("=")[1];
                }
                if (line.startsWith("魔法発動率強化=")) {
                    magic_rate_plus = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("魔法=")) {
                    magic_name = line.split("=")[1];
                }
                if (line.startsWith("魔法ディレイ=")) {
                    magic_delay = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("弱点露出=")) {
                    week_point_exposure = Double
                            .parseDouble(line.split("=")[1]);
                }
//                if (line.startsWith("重さ=")) {
//                    weight = Integer.parseInt(line.split("=")[1]);
//                }
            }
        } catch (IOException | NullPointerException e) {
//            System.err.println(e);

        }
    }

    public void loadArrow(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("name")) {
                    arrow_name = line.split("=")[1];
                }
                if (line.startsWith("追加ダメージ")) {
                    arrow_dmg = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("属性ダメージ")) {
                    arrow_elementdmg = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("遠距離命中")) {
                    arrow_hit = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("材質")) {
                    arrow_material = line.split("=")[1];
                }
            }

        } catch (IOException | NullPointerException e) {
        }
    }

    public void checkEnchant() {
        op2 = new Buff();
        //瞑想のスタッフ
        if (name.equals("瞑想のスタッフ")) {
            op2.MPR += enchant;
        }
        if (name.equals("漆黒の水晶球")) {
            if (enchant >= 9) {
                op2.ST[CHA] += 1;
            }
        }
        //ハロウィン武器*8種類      強化1毎にPVPダメージ+1
        if (name.equals("ハロウィンソード") || name.equals("ハロウィンツーハンドソード") || name.equals("ハロウィンアックス") || name.equals("ハロウィンスタッフ") || name.equals("ハロウィンデュアルブレード") || name.equals("ハロウィンチェーンソード") || name.equals("ハロウィンキーリンク") || name.equals("ハロウィンボウ")) {
            op2.PVP += enchant;                         //PVPダメージ+強化分
        }
        //バフォメットスタッフ      +7以降強化1毎にSP+1(+9まで適用)
        if (name.equals("バフォメットスタッフ")) {
            if (enchant >= 9) {
            op2.SP += 3;                                //SP+3
            } else if (enchant >= 8) {
            op2.SP += 2;                                //SP+2
            } else if (enchant >= 7) {
            op2.SP += 1;                                //SP+1
            }
        }
        //テンペストアックス        +8以降強化1毎に恐怖的中+1(+10強化まで適用)
        if (name.equals("テンペストアックス") || name.equals("テンペストアックス(奈落発動)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_TERROR] += 3;               //恐怖的中+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_TERROR] += 2;               //恐怖的中+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_TERROR] += 1;               //恐怖的中+1
            }
        }
        //殲滅者のチェーンソード      +7以降強化1毎に秘技命中+1(+10強化まで適用)
        if (name.equals("殲滅者のチェーンソード") || name.equals("殲滅者のチェーンソード(殲滅発動)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SECRET] += 4;               //秘技命中+4
            } else if (enchant >= 9) {
            op2.ailment[HIT_SECRET] += 3;               //秘技命中+3
            } else if (enchant >= 8) {
            op2.ailment[HIT_SECRET] += 2;               //秘技命中+2
            } else if (enchant >= 7) {
            op2.ailment[HIT_SECRET] += 1;               //秘技命中+1
            }
        }
        //殺意のキーリンク          +7以降強化1毎に秘技命中+1魔法クリティカル+1(+10強化まで適用)
        if (name.equals("殺意のキーリンク")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SECRET] += 4;               //秘技命中+4
            op2.CRI_MAGIC += 4;                         //魔法クリティカル+4
            } else if (enchant >= 9) {
            op2.ailment[HIT_SECRET] += 3;               //秘技命中+3
            op2.CRI_MAGIC += 3;                         //魔法クリティカル+3
            } else if (enchant >= 8) {
            op2.ailment[HIT_SECRET] += 2;               //秘技命中+2
            op2.CRI_MAGIC += 2;                         //魔法クリティカル+2
            } else if (enchant >= 7) {
            op2.ailment[HIT_SECRET] += 1;               //秘技命中+1
            op2.CRI_MAGIC += 1;                         //魔法クリティカル+1
            }
        }
        //真冥王の執行剣            +1強化毎に[近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+1][技術命中+1]増加
        if (name.equals("真冥王の執行剣")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //近距離追加ダメージ
            op2.CRI_SHORT += enchant;                   //近距離クリティカル
            op2.ailment[HIT_STUN] += enchant;           //技術命中
            }
        }
        //ウィンドブレードソード    +1強化毎に[近距離追加ダメージ+2(既存処理+1)]増加
        if (name.equals("ウィンドブレードソード")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //近距離追加ダメージ
            }
        } 
        //レッドシャドウデュアルブレード    +1強化毎に[近距離追加ダメージ+2(既存処理+1)][精霊命中+1]増加
        if (name.equals("レッドシャドウデュアルブレード")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //近距離追加ダメージ
            op2.ailment[HIT_SPIRIT] += enchant;         //精霊命中
            }
        }
        //ホーリーヘドロンスタッフ  +1強化毎に[近距離追加ダメージ+2(既存処理+1)][SP+1][魔法命中+1]増加
        if (name.equals("ホーリーヘドロンスタッフ")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //近距離追加ダメージ
            op2.SP += enchant;                          //SP 
            op2.HIT_MAGIC += enchant;                   //魔法命中   
            }
        }
        //クロノスの恐怖            +1強化毎に[近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+1%][秘技命中+1]増加
        if (name.equals("クロノスの恐怖")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //近距離追加ダメージ
            op2.CRI_SHORT += enchant;                   //近距離クリティカル
            op2.ailment[HIT_SECRET] += enchant;         //秘技命中
            }
        }
        //ヒュペリオンの絶望        +1強化毎に[近距離追加ダメージ+2(既存処理+1)][SP][魔法クリティカル+1%][秘技命中+1]増加
        if (name.equals("ヒュペリオンの絶望")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //近距離追加ダメージ
            op2.SP += enchant;                          //SP 
            op2.CRI_MAGIC += enchant;                   //魔法クリティカル
            op2.ailment[HIT_SECRET] += enchant;         //秘技命中
            }
        }
        //タイタンの憤怒            +1強化毎に[近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+1%][恐怖命中+1]増加 
        if (name.equals("タイタンの憤怒")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //近距離追加ダメージ
            op2.CRI_SHORT += enchant;                   //近距離クリティカル
            op2.ailment[HIT_TERROR] += enchant;         //恐怖命中
            }
        }
        //ガイアの激怒              +1強化毎に[遠距離追加ダメージ+2(既存処理+1)][遠距離クリティカル+1%][ダメージ低下無視][精霊命中+1]増加 
        if (name.equals("ガイアの激怒")) {
            if (enchant >= 0) {
            op2.DMG_LONG += enchant;                    //遠距離追加ダメージ
            op2.CRI_LONG += enchant;                    //遠距離クリティカル
            op2.DR_IGNORED += enchant;                  //ダメージ低下無視
            op2.ailment[HIT_SPIRIT] += enchant;         //精霊命中
            }
        }
        //死神の剣(REMASTERED)      +1強化毎に[近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+1%][技術命中+1][精霊命中+1][恐怖命中+1]増加 
        if (name.equals("死神の剣(REMASTERED)")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //近距離追加ダメージ
            op2.CRI_SHORT += enchant;                   //近距離クリティカル
            op2.ailment[HIT_STUN] += enchant;           //技術命中
            op2.ailment[HIT_SPIRIT] += enchant;         //精霊命中
            op2.ailment[HIT_TERROR] += enchant;         //恐怖命中
            }
        }
        //強化+10以上はエンチャントによる追加ダメージが+2(既存処理に追加で+1)
        if (enchant >= 10) {
            op2.DMG_SHORT += enchant - 9;               //近距離追加ダメージ
            op2.DMG_LONG += enchant - 9;                //遠距離追加ダメージ
            op2.DMG_MAGIC += enchant - 9;               //魔法追加ダメージ
        }
    }
}
