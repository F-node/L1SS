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
            if (line.startsWith("ダメージリダクション=")) {
                DR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("ダメージリダクション無視=")) {
                DR_IGNORED = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("PVP追加ダメージ=")) {
                PVP = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("PVPダメージ減少=")) {
                PVP_DR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("MR=")) {
                MR = Integer.parseInt(line.split("=")[1]);
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
            if (line.startsWith("スタン耐性=")) {
                ailment[STUN] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("暗闇耐性=")) {
                ailment[DARKNESS] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("ホールド耐性=")) {
                ailment[HOLD] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("凍結耐性=")) {
                ailment[FREEZE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("石化耐性=")) {
                ailment[STONE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("睡眠耐性=")) {
                ailment[SLEEP] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("恐怖耐性=")) {
                ailment[TERROR] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("破壊耐性=")) {
                ailment[DESTRUCTION] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("スタン命中=")) {
                ailment[HIT_STUN] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("暗闇命中=")) {
                ailment[HIT_DARKNESS] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("ホールド命中=")) {
                ailment[HIT_HOLD] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("凍結命中=")) {
                ailment[HIT_FREEZE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("石化命中=")) {
                ailment[HIT_STONE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("睡眠命中=")) {
                ailment[HIT_SLEEP] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("恐怖命中=")) {
                ailment[HIT_TERROR] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("破壊命中=")) {
                ailment[HIT_DESTRUCTION] = Integer.parseInt(line.split("=")[1]);
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
