package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Buki implements Common {

    int small = 0;                      //小さなモンスターダメージ
    int big = 0;                        //大きなモンスターダメージ
    String name = "";                   //武器の名前
    String type = "";                   //武器の種類
    double critical_rate = 0;           //クロウ クリティカル
    double double_hit_rate = 0;         //デュアルブレード ダブルヒット
    double week_point_exposure = 0;     //チェーンソード 弱点露出
    boolean two_hands = false;          //両手剣(true)両手剣以外(false)
//    String equip = "";
    String material = "";               //材質
    Buff op = new Buff();               //武器1のオプション
    Buff op2 = new Buff();              //武器2のオプション
    int enchant = 0;                    //強化値
    int magic_enchant = 0;              //武器に対して効果のある追加魔法ダメージ
    int max_enchant = 0;                //最高可能強化値
    int safety = 0;                     //安全強化値
    boolean element_enchant = false;    //属性強化数
    boolean damage_resistance = false;  //損傷耐性
    // キーリンク用
    int x, y, z;                        //キーリンク用ダメージダイス
    // 魔法武器用
    String magic_name = "";             //魔法武器の魔法の名前
//    boolean magic_motion = false;       //魔法モーションの有無
    double magic_rate = 0;              //魔法発動率
    double magic_rate_plus = 0;         //強化+1毎の魔法発動率
    String magic_element = "";          //魔法属性
    double magic_power = 0;             //魔法基本ダメージ
    double magic_delay = 0;             //魔法ディレイ
//    int buki_weight = 0;                //武器の重さ

    //矢の設定情報
    String arrow_name = "";             //矢の名前
    int arrow_elementdmg = 0;           //武器属性ダメージ
    int arrow_dmg = 0;                  //遠距離ダメージ
    int arrow_hit = 0;                  //遠距離命中
    String arrow_material = "";         //材質
//    int arrow_weight = 0;               //矢の重さ

    private void reset() {
        //武器の初期設定
        small = 0;                      //小さなモンスターダメージ
        big = 0;                        //大きなモンスターダメージ
        name = "";                      //武器の名前
        type = "";                      //武器の種類
        critical_rate = 0;              //クロウ クリティカル
        double_hit_rate = 0;            //デュアルブレード ダブルヒット
        week_point_exposure = 0;        //チェーンソード 弱点露出
        two_hands = false;              //両手剣(true)両手剣以外(false)
//        equip = "";
        material = "";                  //材質
        op = new Buff();                //武器1のオプション
        op2 = new Buff();               //武器2のオプション
        enchant = 0;                    //強化値
        magic_enchant = 0;              //武器に対して効果のある追加魔法ダメージ
        max_enchant = 0;                //最高可能強化値
        safety = 0;                     //安全強化値
        element_enchant = false;        //属性強化数
        damage_resistance = false;      //損傷耐性
        magic_name = "";                //魔法武器の魔法の名前
//        magic_motion = false;           //魔法モーションの有無
        magic_rate = 0;                 //魔法発動率
        magic_rate_plus = 0;            //強化+1毎の魔法発動率
        magic_element = "";             //魔法属性
        magic_power = 0;                //魔法基本ダメージ
        magic_delay = 0;                //魔法ディレイ
//        buki_weight = 0;                //武器の重さ

        //矢の初期設定
        arrow_name = "";                //矢の名前
        arrow_elementdmg = 0;           //武器属性ダメージ
        arrow_dmg = 0;                  //遠距離ダメージ
        arrow_hit = 0;                  //遠距離命中
        arrow_material = "";            //材質
//        arrow_weight = 0;               //矢の重さ
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
                if (line.startsWith("損傷耐性=")) {
                    damage_resistance = Boolean.parseBoolean(line.split("=")[1]);
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
//                    buki_weight = Integer.parseInt(line.split("=")[1]);
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
                if (line.startsWith("属性ダメージ")) {
                    arrow_elementdmg = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("追加ダメージ")) {
                    arrow_dmg = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("遠距離命中")) {
                    arrow_hit = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("材質")) {
                    arrow_material = line.split("=")[1];
                }
//                if (line.startsWith("重さ=")) {
//                    arrow_weight = Integer.parseInt(line.split("=")[1]);
//                }
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
        //漆黒の水晶球
        if (name.equals("漆黒の水晶球")) {
            if (enchant >= 9) {
                op2.ST[CHA] += 1;
            }
        }

        //ハロウィン武器*8種類                                                   強化1毎にPVPダメージ+1
        if (name.equals("ハロウィンソード") || name.equals("ハロウィンツーハンドソード") || name.equals("ハロウィンアックス") || name.equals("ハロウィンスタッフ") || name.equals("ハロウィンデュアルブレード") || name.equals("ハロウィンチェーンソード") || name.equals("ハロウィンキーリンク") || name.equals("ハロウィンボウ")) {
            op2.PVP += enchant;                                                 //PVPダメージ+強化分
        }

        //バフォメットスタッフ                                                   +7以降強化1毎にSP+1(+9まで適用)
        if (name.equals("バフォメットスタッフ")) {
            if (enchant >= 9) {
            op2.SP += 3;                                                        //SP+3
            } else if (enchant >= 8) {
            op2.SP += 2;                                                        //SP+2
            } else if (enchant >= 7) {
            op2.SP += 1;                                                        //SP+1
            }
        }

        //テンペストアックス                                                     +8以降強化1毎に恐怖的中+1(+10強化まで適用)
        if (name.equals("テンペストアックス") || name.equals("テンペストアックス(奈落発動)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_TERROR] += 3;                                       //恐怖的中+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_TERROR] += 2;                                       //恐怖的中+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_TERROR] += 1;                                       //恐怖的中+1
            }
        }

        //殲滅者のチェーンソード                                                 +7以降強化1毎に秘技命中+1(+10強化まで適用)
        if (name.equals("殲滅者のチェーンソード") || name.equals("殲滅者のチェーンソード(殲滅発動)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SECRET] += 4;                                       //秘技命中+4
            } else if (enchant >= 9) {
            op2.ailment[HIT_SECRET] += 3;                                       //秘技命中+3
            } else if (enchant >= 8) {
            op2.ailment[HIT_SECRET] += 2;                                       //秘技命中+2
            } else if (enchant >= 7) {
            op2.ailment[HIT_SECRET] += 1;                                       //秘技命中+1
            }
        }

        //震怒のクロウ                                                           +8以降強化1毎に精霊命中+1(+10強化まで適用)
        if (name.equals("震怒のクロウ")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SPIRIT] += 3;                                       //精霊命中+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_SPIRIT] += 2;                                       //精霊命中+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_SPIRIT] += 1;                                       //精霊命中+1
            }
        }

        //殺意のキーリンク                                                       +7以降強化1毎に秘技命中+1魔法クリティカル+1(+10強化まで適用)
        if (name.equals("殺意のキーリンク")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SECRET] += 4;                                       //秘技命中+4
            op2.CRI_MAGIC += 4;                                                 //魔法クリティカル+4
            } else if (enchant >= 9) {
            op2.ailment[HIT_SECRET] += 3;                                       //秘技命中+3
            op2.CRI_MAGIC += 3;                                                 //魔法クリティカル+3
            } else if (enchant >= 8) {
            op2.ailment[HIT_SECRET] += 2;                                       //秘技命中+2
            op2.CRI_MAGIC += 2;                                                 //魔法クリティカル+2
            } else if (enchant >= 7) {
            op2.ailment[HIT_SECRET] += 1;                                       //秘技命中+1
            op2.CRI_MAGIC += 1;                                                 //魔法クリティカル+1
            }
        }

        //指揮官のスピアー                                                       +7から恐怖命中+1 +8からPVPダメージ+1(+10強化まで適用)
        if (name.equals("指揮官のスピアー")) {
            if (enchant >= 10) {
            op2.ailment[HIT_TERROR] += 4;                                       //恐怖命中+4
            op2.CRI_MAGIC += 3;                                                 //PVPダメージ+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_TERROR] += 3;                                       //恐怖命中+3
            op2.CRI_MAGIC += 2;                                                 //PVPダメージ+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_TERROR] += 2;                                       //恐怖命中+2
            op2.CRI_MAGIC += 1;                                                 //PVPダメージ+1
            } else if (enchant >= 7) {
            op2.ailment[HIT_TERROR] += 1;                                       //恐怖命中+1
            }
        }

        //ヴァラカスのソード                                                     +8以降強化1毎に技術/精霊/恐怖命中+1(最大+3)(+10強化まで適用)
        if (name.equals("ヴァラカスのソード") || name.equals("ヴァラカスのソード(ヴァラカスの魂発動)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_STUN] += 3;                                         //技術命中+3
            op2.ailment[HIT_SPIRIT] += 3;                                       //精霊命中+3
            op2.ailment[HIT_TERROR] += 3;                                       //恐怖命中+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_STUN] += 2;                                         //技術命中+2
            op2.ailment[HIT_SPIRIT] += 2;                                       //精霊命中+2
            op2.ailment[HIT_TERROR] += 2;                                       //恐怖命中+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_STUN] += 1;                                         //技術命中+1
            op2.ailment[HIT_SPIRIT] += 1;                                       //精霊命中+1
            op2.ailment[HIT_TERROR] += 1;                                       //恐怖命中+1
            }
        }

        //ヴァラカスの両手剣                                                     +8以降強化1毎に技術命中+1(最大+3)(+10強化まで適用)
        if (name.equals("ヴァラカスの両手剣") || name.equals("ヴァラカスの両手剣(ヴァラカスの魂発動)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_STUN] += 3;                                         //技術命中+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_STUN] += 2;                                         //技術命中+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_STUN] += 1;                                         //技術命中+1
            }
        }

        //パプリオンのロングボウ                                                 +8以降強化1毎に精霊命中+1/ダメージリダクション無視+1(最大+3)(+10強化まで適用)
        if (name.equals("パプリオンのロングボウ") || name.equals("パプリオンのロングボウ(パプリオンの魂発動)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SPIRIT] += 3;                                       //精霊命中+3
            op2.DR_IGNORED += 3;                                                //ダメージリダクション無視+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_SPIRIT] += 2;                                       //精霊命中+2
            op2.DR_IGNORED += 2;                                                //ダメージリダクション無視+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_SPIRIT] += 1;                                       //精霊命中+1
            op2.DR_IGNORED += 1;                                                //ダメージリダクション無視+1
            }
        }

        //パプリオンのデュアルブレード                                            +8以降強化1毎に精霊命中+1(最大+3)(+10強化まで適用)
        //ダブルヒット発動確率増加は未実装
        if (name.equals("パプリオンのデュアルブレード") || name.equals("パプリオンのデュアルブレード(パプリオンの魂発動)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SPIRIT] += 3;                                       //精霊命中+3
                                                                                //ダブルヒット発動確率増加+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_SPIRIT] += 2;                                       //精霊命中+2
                                                                                //ダブルヒット発動確率増加+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_SPIRIT] += 1;                                       //精霊命中+1
                                                                                //ダブルヒット発動確率増加+1
            }
        }

        //アンタラスのアックス                                                   +8以降強化1毎に恐怖命中+1(最大+3)(+10強化まで適用)
        if (name.equals("アンタラスのアックス") || name.equals("アンタラスのアックス(アンタラスの魂発動)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_TERROR] += 3;                                       //恐怖命中+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_TERROR] += 2;                                       //恐怖命中+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_TERROR] += 1;                                       //恐怖命中+1
            }
        }

        //アンタラスのスタッフ                                                   +8以降強化1毎にSP+1/魔法命中+1(最大+3)(+10強化まで適用)
        if (name.equals("アンタラスのスタッフ") || name.equals("アンタラスのスタッフ(アンタラスの魂発動)")) {
            if (enchant >= 10) {
            op2.SP                  += 3;                                       //SP+3
            op2.HIT_MAGIC           += 3;                                       //魔法命中+3
            } else if (enchant >= 9) {
            op2.SP                  += 2;                                       //SP+2
            op2.HIT_MAGIC           += 2;                                       //魔法命中+2
            } else if (enchant >= 8) {
            op2.SP                  += 1;                                       //SP+1
            op2.HIT_MAGIC           += 1;                                       //魔法命中+1
            }
        }

        //リンドビオルのチェーンソード                                            +8以降強化1毎に秘技命中+1(最大+3)(+10強化まで適用)
        //弱点露出確率増加は未実装
        if (name.equals("リンドビオルのチェーンソード") || name.equals("リンドビオルのチェーンソード(リンドビオルの魂発動)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SECRET] += 3;                                       //秘技命中+3
                                                                                //弱点露出確率増加+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_SECRET] += 2;                                       //秘技命中+2
                                                                                //弱点露出確率増加+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_SECRET] += 1;                                       //秘技命中+1
                                                                                //弱点露出確率増加+1
            }
        }

        //リンドビオルのキーリンク                                               +8以降強化1毎にSP+1/秘技命中+1(最大+3)(+10強化まで適用)
        if (name.equals("リンドビオルのキーリンク") || name.equals("リンドビオルのキーリンク(リンドビオルの魂発動)")) {
            if (enchant >= 10) {
            op2.SP                  += 3;                                       //SP+3
            op2.ailment[HIT_SECRET] += 3;                                       //秘技命中+3
            } else if (enchant >= 9) {
            op2.SP                  += 2;                                       //SP+2
            op2.ailment[HIT_SECRET] += 2;                                       //秘技命中+2
            } else if (enchant >= 8) {
            op2.SP                  += 1;                                       //SP+1
            op2.ailment[HIT_SECRET] += 1;                                       //秘技命中+1
            }
        }

        //真冥王の執行剣                                                         +1強化毎に[近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+1][技術命中+1]増加
        if (name.equals("真冥王の執行剣")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            op2.CRI_SHORT += enchant;                                           //近距離クリティカル
            op2.ailment[HIT_STUN] += enchant;                                   //技術命中
            }
        }

        //ウィンドブレードソード                                                 +1強化毎に[近距離追加ダメージ+2(既存処理+1)]増加
        if (name.equals("ウィンドブレードソード")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            }
        } 

        //レッドシャドウデュアルブレード                                          +1強化毎に[近距離追加ダメージ+2(既存処理+1)][精霊命中+1]増加
        if (name.equals("レッドシャドウデュアルブレード")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            op2.ailment[HIT_SPIRIT] += enchant;                                 //精霊命中
            }
        }

        //ホーリーヘドロンスタッフ                                                +1強化毎に[近距離追加ダメージ+2(既存処理+1)][SP+1][魔法命中+1]増加
        if (name.equals("ホーリーヘドロンスタッフ")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            op2.SP += enchant;                                                  //SP
            op2.HIT_MAGIC += enchant;                                           //魔法命中
            }
        }

        //クロノスの恐怖                                                         +1強化毎に[近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+1%][秘技命中+1]増加
        if (name.equals("クロノスの恐怖")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            op2.CRI_SHORT += enchant;                                           //近距離クリティカル
            op2.ailment[HIT_SECRET] += enchant;                                 //秘技命中
            }
        }

        //ヒュペリオンの絶望                                                     +1強化毎に[近距離追加ダメージ+2(既存処理+1)][SP][魔法クリティカル+1%][秘技命中+1]増加
        if (name.equals("ヒュペリオンの絶望")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            op2.SP += enchant;                                                  //SP
            op2.CRI_MAGIC += enchant;                                           //魔法クリティカル
            op2.ailment[HIT_SECRET] += enchant;                                 //秘技命中
            }
        }

        //タイタンの憤怒                                                         +1強化毎に[近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+1%][恐怖命中+1]増加
        if (name.equals("タイタンの憤怒")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            op2.CRI_SHORT += enchant;                                           //近距離クリティカル
            op2.ailment[HIT_TERROR] += enchant;                                 //恐怖命中
            }
        }

        //ガイアの激怒                                                           +1強化毎に[遠距離追加ダメージ+2(既存処理+1)][遠距離クリティカル+1%][ダメージ低下無視][精霊命中+1]増加
        if (name.equals("ガイアの激怒")) {
            if (enchant >= 0) {
            op2.DMG_LONG += enchant;                                            //遠距離追加ダメージ
            op2.CRI_LONG += enchant;                                            //遠距離クリティカル
            op2.DR_IGNORED += enchant;                                          //ダメージ低下無視
            op2.ailment[HIT_SPIRIT] += enchant;                                 //精霊命中
            }
        }

        //死神の剣                                                               +1強化毎に[近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+1%][技術命中+1][精霊命中+1][恐怖命中+1]増加
        if (name.equals("死神の剣") || name.equals("死神の剣(ウェポンアタック発動)")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            op2.CRI_SHORT += enchant;                                           //近距離クリティカル
            op2.ailment[HIT_STUN] += enchant;                                   //技術命中
            op2.ailment[HIT_SPIRIT] += enchant;                                 //精霊命中
            op2.ailment[HIT_TERROR] += enchant;                                 //恐怖命中
            }
        }

        //支配者の処刑                                                           +1強化毎に[近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+1%][恐怖命中+1]増加
        if (name.equals("支配者の処刑") || name.equals("支配者の処刑(支配者の処刑発動)")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            op2.CRI_SHORT += enchant;                                           //近距離クリティカル
            op2.ailment[HIT_TERROR] += enchant;                                 //恐怖命中
            }
        }

        //アインハザードの閃光                                                   +1強化毎に[武器ダメージイミューン無視+5][近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+2%][技術命中+1][精霊命中+1][恐怖命中+1]増加
        //アインハザードの閃光(対モンスター範囲魔法)とアインハザードの一撃(対人魔法+2秒ホールド)は未実装 INT&SPに魔法ダメージは依存しない
        if (name.equals("アインハザードの閃光")) {
            if (enchant >= 0) {
                                                                                //イミューン無視武器ダメージ+5x強化数(未実装)
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            op2.CRI_SHORT += (enchant*2);                                       //近距離クリティカル+2x強化数
            op2.ailment[HIT_STUN] += enchant;                                   //技術命中
            op2.ailment[HIT_SPIRIT] += enchant;                                 //精霊命中
            op2.ailment[HIT_TERROR] += enchant;                                 //恐怖命中
            }
        }

        //グランカインの審判                                                     +1強化毎に[武器ダメージイミューン無視+5][近距離追加ダメージ+2(既存処理+1)][近距離クリティカル+2%][技術命中+1]増加
        //グランカインの咆哮(対モンスター範囲魔法)とグランカインの審判(対人魔法+2秒ホールド)は未実装 INT&SPに魔法ダメージは依存しない
        if (name.equals("グランカインの審判")) {
            if (enchant >= 0) {
                                                                                //イミューン無視武器ダメージ+5x強化数(未実装)
            op2.DMG_SHORT += enchant;                                           //近距離追加ダメージ
            op2.CRI_SHORT += (enchant*2);                                       //近距離クリティカル+2x強化数
            op2.ailment[HIT_STUN] += enchant;                                   //技術命中
            }
        }

        //強化+10以上はエンチャントによる追加ダメージが+2(既存処理に追加で+1)
        if (enchant >= 10) {
            op2.DMG_SHORT += enchant - 9;                                       //近距離追加ダメージ
            op2.DMG_LONG += enchant - 9;                                        //遠距離追加ダメージ
        //    op2.DMG_MAGIC += enchant - 9;                                     //魔法追加ダメージ
        }
    }
}
