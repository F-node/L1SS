package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Buff implements Common {

    int AC;
    int ST[] = new int[ST_LIST.length];
    int[] element_resist = new int[ELEM_LIST.length];
    int[] ELEM_DMG_SHORT = new int[ELEM_LIST.length];
    int[] ELEM_DMG_LONG = new int[ELEM_LIST.length];
    int HP;
    int MP;
    int HPR;
    int MPR;
    int DMG_SHORT;
    int DMG_LONG;
    int DMG_MAGIC;
    int HIT_SHORT;
    int HIT_LONG;
    int HIT_MAGIC;
    int CRI_SHORT;
    int CRI_LONG;
    int CRI_MAGIC;
    int SP;
    int DR;
    int MR;
    int ER;
    double r_weight;
    int c_weight;
    String effect = "";

    int PVP;
    int PVP_DR;
    int DR_IGNORED;
    int WEIGHT;

    int[] ailment = new int[AILMENT_LIST.length];

    public void loadOption(BufferedReader reader) throws IOException {
        reader.reset();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("AC=")) {
                AC = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("STR=")) {
                ST[STR] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("DEX=")) {
                ST[DEX] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("CON=")) {
                ST[CON] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("INT=")) {
                ST[INT] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("WIS=")) {
                ST[WIS] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("CHA=")) {
                ST[CHA] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("FIRE=")) {
                element_resist[FIRE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("EARTH=")) {
                element_resist[EARTH] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("WIND=")) {
                element_resist[WIND] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("WATER=")) {
                element_resist[WATER] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("HP=")) {
                HP = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("MP=")) {
                MP = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("HPR=")) {
                HPR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("MPR=")) {
                MPR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("近距離追加ダメージ=")) {
                DMG_SHORT = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("遠距離追加ダメージ=")) {
                DMG_LONG = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("近距離命中=")) {
                HIT_SHORT = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("遠距離命中=")) {
                HIT_LONG = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("魔法命中=")) {
                HIT_MAGIC = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("SP=")) {
                SP = Integer.parseInt(line.split("=")[1]);
            }
            //if (line.startsWith("ダメージ低下=")) {
            if (line.startsWith("ダメージリダクション=")) {
                DR = Integer.parseInt(line.split("=")[1]);
            }
            //if (line.startsWith("ダメージ低下無視=")) {           
            if (line.startsWith("ダメージリダクション無視=")) {
                DR_IGNORED = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("PVP追加ダメージ=")) {
                PVP = Integer.parseInt(line.split("=")[1]);
            }
            //if (line.startsWith("PVPダメージ低下=")) {
            if (line.startsWith("PVPダメージ減少=")) {
                PVP_DR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("MR=")) {
                MR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("重さ=")) {
                WEIGHT = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("重量軽減=")) {
                r_weight = Double.parseDouble(line.split("=")[1]);
            }
            if (line.startsWith("所持重量=")) {
                c_weight = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("特殊=")) {
                effect = line.split("=")[1];
            }
            if (line.startsWith("技術耐性=")) {
                ailment[STUN] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("精霊耐性=")) {
                ailment[SPIRIT] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("秘技耐性=")) {
                ailment[SECRET] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("恐怖耐性=")) {
                ailment[TERROR] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("技術命中=")) {
                ailment[HIT_STUN] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("精霊命中=")) {
                ailment[HIT_SPIRIT] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("秘技命中=")) {
                ailment[HIT_SECRET] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("恐怖命中=")) {
                ailment[HIT_TERROR] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("近距離クリティカル=")) {
               CRI_SHORT = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("遠距離クリティカル=")) {
               CRI_LONG = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("魔法クリティカル=")) {
               CRI_MAGIC = Integer.parseInt(line.split("=")[1]);
            }

        }
    }
}
