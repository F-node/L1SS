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
    String equip = "";
    String material = "";
    Buff op = new Buff();
    Buff op2 = new Buff();
    int enchant = 0;
    int magic_enchant = 0;
    int max_enchant = 0;
    String arrow_name = "";
    String arrow_material = "";
    String arrow_type = "";
    int arrow_small = 0;
    int arrow_big = 0;
    int arrow_dmg = 0;
    int arrow_elementdmg = 0; 
    int arrow_hit = 0;
    
    int safety = 0;
    boolean element_enchant = false;
    // キーリンク用
    int x, y, z;
    // 魔法武器用
    String magic_name = "";
    boolean magic_motion = false;
    double magic_rate = 0;
    double magic_rate_plus = 0;
    String magic_element = "";
    double magic_power = 0;
    double magic_delay = 0;

    int weight = 0;

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
        arrow_type = "";
//        arrow_small = 0;
//        arrow_big = 0;
        arrow_dmg = 0;
        arrow_elementdmg = 0;
        arrow_hit = 0;

        safety = 0;
        element_enchant = false;

        magic_name = "";
        magic_motion = false;
        magic_rate = 0;
        magic_element = "";
        magic_power = 0;
        magic_delay = 0;
        magic_rate_plus = 0;

        weight = 0;
    }

    void load(BufferedReader reader) {
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
                if (line.startsWith("equip=")) {
                    equip = line.split("=")[1];
                }
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
                if (line.startsWith("魔法モーション")) {
                    magic_motion = Boolean.parseBoolean(line.split("=")[1]);
                }
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
                if (line.startsWith("重さ=")) {
                    weight = Integer.parseInt(line.split("=")[1]);
                }
            }
        } catch (IOException | NullPointerException e) {
            System.err.println(e);

        }
    }

    public void loadArrow(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("name")) {
                    arrow_name = line.split("=")[1];
                }
//                if (line.startsWith("small")) {
//                    arrow_small = Integer.parseInt(line.split("=")[1]);
//                }
//                if (line.startsWith("big")) {
//                    arrow_big = Integer.parseInt(line.split("=")[1]);
//                }
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
        if (name.equals("瞑想のスタッフ")) {
            op2.MPR += enchant;
        }
        //真冥王の執行剣    エンチャントによる追加打撃が+2 +1強化毎に[近距離クリティカル][スタン命中]+1増加
        if (name.equals("真冥王の執行剣")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //追加ダメージ
            op2.CRI_SHORT += enchant;                   //近距離クリティカル
            op2.ailment[HIT_STUN] += enchant;           //スタン命中
            }
        }
        //ウィンドブレードソード    エンチャントによる追加打撃が+2
        if (name.equals("ウィンドブレードソード")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //追加ダメージ
            }
        } 
        //レッドシャドウデュアルブレード    エンチャントによる追加打撃が+2 +1強化毎に[破壊命中]+1増加
        if (name.equals("レッドシャドウデュアルブレード")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //追加ダメージ
            op2.ailment[HIT_DESTRUCTION] += enchant;    //破壊命中
            }
        }
        //ホーリーヘドロンスタッフ    エンチャントによる追加打撃が+2 +1強化毎に[SP][魔法命中]+1増加
        if (name.equals("ホーリーヘドロンスタッフ")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //追加ダメージ
            op2.SP += enchant;                          //SP 
            op2.HIT_MAGIC += enchant;                   //魔法命中   
            }
        }
        //クロノスの恐怖    エンチャントによる追加打撃が+2 +1強化毎に[近距離クリティカル]+1%増加 
        if (name.equals("クロノスの恐怖")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //追加ダメージ
            op2.CRI_SHORT += enchant;                   //近距離クリティカル
            }
        }
        //ヒュペリオンの絶望    エンチャントによる追加打撃が+2 +1強化毎に[SP][魔法クリティカル][スタン命中]+1増加
        if (name.equals("ヒュペリオンの絶望")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //追加ダメージ
            op2.SP += enchant;                          //SP 
            op2.CRI_MAGIC += enchant;                   //魔法クリティカル
            op2.ailment[HIT_STUN] += enchant;           //スタン命中
            }
        }
        //タイタンの憤怒    エンチャントによる追加打撃が+2 +1強化毎に[近距離クリティカル][恐怖命中]+1増加 
        if (name.equals("タイタンの憤怒")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //追加ダメージ
            op2.CRI_SHORT += enchant;                   //近距離クリティカル
            op2.ailment[HIT_TERROR] += enchant;         //恐怖命中
            }
        }
        //ガイアの激怒    エンチャントによる追加打撃が+2 +1強化毎に[遠距離クリティカル][ダメージ軽減無視]+1増加 
        if (name.equals("ガイアの激怒")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;    //追加ダメージ
            op2.CRI_LONG += enchant;     //遠距離クリティカル
            op2.dr_ignored += enchant;   //ダメージリダクション無視
            }
        }
        //強化+10以上はエンチャントによる追加打撃が+2(既存処理に追加で+1)
        if (enchant >= 10) {
            op2.DMG_SHORT = enchant - 9;
            op2.DMG_LONG = enchant - 9;
            op2.DMG_MAGIC = enchant - 9;
        }
    }
}
