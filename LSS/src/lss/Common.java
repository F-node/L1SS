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

    //6種のステータス
    final String[] ST_LIST = {"STR", "DEX", "INT", "WIS", "CON", "CHA"};
    final int STR = 0;
    final int DEX = 1;
    final int INT = 2;
    final int WIS = 3;
    final int CON = 4;
    final int CHA = 5;

    //9種の職業
    final String[] CLASS_LIST = {"P", "K", "E", "W", "D", "R", "I", "S", "F"};
    final String[] CLASS_LIST2 = {"君主", "ナイト", "エルフ", "ウィザード", "ダークエルフ", "ドラゴンナイト", "イリュージョニスト", "ウォリアー", "フェンサー"};
    final int P = 0;
    final int K = 1;
    final int E = 2;
    final int W = 3;
    final int D = 4;
    final int R = 5;
    final int I = 6;
    final int S = 7;
    final int F = 8;

    //4種の属性
    final String[] ELEM_LIST = {"地", "火", "水", "風"};
    final int EARTH = 0;
    final int FIRE = 1;
    final int WATER = 2;
    final int WIND = 3;

    //13種の武器
    final String[] BUKI_TYPE_LIST = {"ダガー", "片手剣", "両手剣", "スタッフ", "鈍器",
        "デュアルブレード", "クロウ", "槍", "ボウ", "ガントレット", "キーリンク", "チェーンソード", "双斧"};
    final int W_D = 0;
    final int W_LS = 1;
    final int W_TS = 2;
    final int W_S = 3;
    final int W_A = 4;
    final int W_DB = 5;
    final int W_C = 6;
    final int W_L = 7;
    final int W_B = 8;
    final int W_G = 9;
    final int W_K = 10;
    final int W_CS = 11;
    final int W_DA = 12;
    
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
    final int L99 = 14;             //Hero用

    //パネル1のアミュレット/イアリング/リング/インシグニア/スポールダー/紋章/ペンダント等の順と位置
    final String[] EQ_LIST = {"武器", "武器", "シールド", "ヘルム", "グローブ", "シャツ",
        "アーマー", "クローク", "ブーツ", "ゲートル", "ベルト", "アミュレット", "イアリング", "イアリング", "リング", "リング",
        "リング", "リング", "インシグニア", "スポールダー", "紋章", "ペンダント"};
    
    final int RING1 = 14;
    final int RING2 = 15;
    final int RING3 = 16;
    final int RING4 = 17;

    final int EARRING1 = 11;
    final int EARRING2 = 12;

//エンチャント(0から103までの合計104個分)　UI.javaの217行目も合わせて変更必須
//仮設定で119までの130個で処理
//基本エンチャント
    final int ACC1 = 0;             //1段加速
    final int ACC2 = 1;             //2段加速
    final int ACC3 = 2;             //3段加速
    final int B_STR = 3;            //STR
    final int B_DEX = 4;            //DEX
    final int B_AC = 5;             //AC
    final int BUKI = 6;             //武器エンチャ魔法
    final int SEC = 75;             //セキュリティ
    final int VIP = 72;             //VIPエンチャント

//君主の魔法 合計10種類
    final int P_PRE = 110;          //PRimE                         プライム
//    final int P_EME = X;          //EMpirE                        エンパイア(未実装)
    final int P_GRE = 87;           //GRacE                         グレース(グレースアバター)
    final int P_AUA = 59;           //AUrA                          オーラ(ブレイブアバター)
    final int P_MAY = 100;          //MAjestY                       マジェスティ
    final int P_SAR = 99;           //Shining ArmoR                 シャイニングアーマー
    final int P_SSD = 9;            //Shining ShielD                シャイニングシールド
    final int P_BML = 8;            //Brave MentaL                  ブレイブメンタル
    final int P_GWN = 7;            //Glowing WeapoN                グローイングウェポン
//    final int P_TTT = X;          //True TargeT                   トゥルーターゲット(未実装)

//ナイトの技術
    //アクティブスキル
//    final int K_FSN = X;          //Force StaN                    フォーススタン(未実装)
//    final int K_ABE = X;          //Absolute BladE                アブソルートブレイド(未実装)
    final int K_CBR = 36;           //Counter BarrieR               カウンターバリア(未実装)
    final int K_BLK = 89;           //BLow attacK                   ブローアタック
    final int K_BOK = 65;           //BOunce attacK                 バウンスアタック
//    final int K_SSN = X;          //Shock StaN                    ショックスタン(未実装)
    final int K_PRE = 88;           //PRidE                         プライド
    final int K_SCE = 35;           //Solid CarriagE                ソリッドキャリッジ
    final int K_RAR = 34;           //Reduction ArmoR               リダクションアーマー
    //パッシブスキル
    final int K_CBV = 73;           //Counter Barrier:Veteran       カウンターバリア:ベテラン
    final int K_RFE = 111;          //Raging ForcE                  レイジングフォース
    final int K_RAV = 112;          //Reduction Armor:Veteran       リダクションアーマー:ベテラン

//エルフの精霊魔法
    //共通
//    final int E_MAE = X;          //MArblE                        マーブル(未実装)
    final int E_GEH = 113;          //Glory EartH                   グローリーアース(未実装)
//    final int E_SBR = X;          //Seoul BarrieR                 ソウルバリア(未実装)
//    final int E_ASE = X;          //Area SilencE                  エリアサイレンス(未実装)
    final int E_ELY = 57;           //ELvengravitY                  エルヴングラヴィティー
//    final int E_GEL = X;          //Greater ElementaL             グレーターエレメンタル(未実装)
//    final int E_EMC = X;          //Erase MagiC                   イレースマジック(未実装)
//    final int E_EFN = X;          //Elemental FalldowN            エレメンタルフォールダウン(未実装)
//    final int E_SLE = X;          //Summon Lesser Elemental       サモンレッサーエレメンタル(未実装)
//    final int E_TAW = X;          //Triple ArroW                  トリプルアロー(未実装)
//    final int E_BSL = X;          //Bloody SouL                   ブラッディソウル(未実装)
    final int E_EPN = 114;          //Elemental ProtectioN          エレメンタルプロテクション(未実装)
    final int E_RET = 19;           //Resist ElemenT                レジストエレメント
    final int E_CMD = 12;           //Clear MinD                    クリアマインド
//    final int E_TTM = X;          //Teleport To Mother            テレポートトゥマザー(未実装)
//    final int E_BTM = X;          //Body To Mind                  ボディトゥマインド(未実装)
    final int E_RMC = 20;           //Resist MagiC                  レジストマジック

    //火系列
    final int E_INO = 86;           //INfernO                       インフェルノ(未実装)
    final int E_SOF = 15;           //Soul Of Flame                 ソウルオブフレイム
    final int E_AFE = 23;           //Additional FirE               アディショナルファイヤー
    final int E_EFE = 11;           //Elemental FirE                エレメンタルファイアー
    final int E_BWN = 17;           //Burning WeapoN                バーニングウェポン
//    final int E_DBE = X;          //Dancing BlazE                 ダンシングブレイズ(基本エンチャントの2段加速で実装)
//    final int E_FSD = X;          //Fire ShielD                   ファイアーシールド(基本エンチャントのACで実装)

    //水系列
//    final int E_PWR = X;          //Pollute WateR                 ポルートウォーター(未実装)
//    final int E_NBG = X;          //Natures BlessinG              ネイチャーズブレッシング(未実装)
//    final int E_FWE = X;          //Focus WavE                    フォーカスウェーブ(基本エンチャントの2段加速で実装)
    final int E_APR = 21;           //Aqua ProtectoR                アクアプロテクター
    final int E_NTH = 16;           //Natures ToucH                 ネイチャーズタッチ
//    final int E_WLE = X;          //Water LifE                    ウォーターライフ(未実装)
    final int E_AST = 10;           //Aqua ShoT                     アクアショット

    //風系列
//    final int E_SGL = X;          //Striker GaiL                  ストライカーゲイル(未実装)
//    final int E_HUE = X;          //HUrricanE                     ハリケーン(基本エンチャントの2段加速で実装)
    final int E_CYE = 85;           //CYclonE                       サイクロン
    final int E_SST = 14;           //Storm ShoT                    ストームショット
    final int E_SEE = 13;           //Storm EyE                     ストームアイ
    final int E_EEE = 84;           //Eagle EyE                     イーグルアイ

    //地系列
//    final int E_XX = X;           //Earth BinD                    アースバインド(未実装)
    final int E_EVE = 22;           //Exotic VitalizE               エキゾチックバイタライズ
//    final int E_XX = X;           //Iron SkiN                     アイアンスキン(基本エンチャントのACで実装)
//    final int E_XX = X;           //Sand StorM                    サンドストーム(基本エンチャントの2段加速で実装)
    final int E_EGN = 61;           //Earth GuardiaN                アースガーディアン
    final int E_QUE = 81;           //QUakE                         クエイク
    final int E_EWN = 18;           //Earth WeapoN                  アースウェポン

//ウィザードの魔法
    //LV11魔法
//    final int W_XX = X;           //Eternity                      エタニティ(未実装)
//    final int W_XX = X;           //Meister Accuracy              マイスターアキュラシー(未実装)
//    final int W_XX = x;           //Immun To Harm: Saint          イミューントゥハーム:セイント(未実装)

    //LV10魔法
//    final int W_XX = X;           //Death heel                    デスヒール(未実装)
//    final int W_XX = X;           //Meteor strike                 メテオストライク(未実装)
//    final int W_XX = X;           //Greater Resurrection          グレーターリザレクション(未実装)
//    final int W_XX = X;           //Ice Meteor                    アイスメテオ(未実装)
//    final int W_XX = X;           //Disintegrate                  ディスインテグレート(未実装)
//    final int W_XX = X;           //Absolute barrier              アブソルートバリア(未実装)
    final int W_ADS = 24;           //Advanced spirits              アドバンスドスピリッツ
//    final int W_XX = X;           //Ice spike                     アイススパイク(未実装)

    //LV9魔法
//    final int W_XX = X;           //Lightning stormライトニングストーム(未実装)
//    final int W_XX = X;           //Fog of sleepingフォグオブスリーピング(未実装)
//    final int W_XX = X;           //Shape changeシェイプチェンジ(未実装)
//    final int W_XX = X;           //Immun To Harmイミューントゥハーム(未実装)
//    final int W_XX = X;           //Massteleportマステレポート(未実装)
//    final int W_XX = X;           //Fire stormファイアーストーム(未実装)
//    final int W_XX = X;           //Decay potionディケイポーション(未実装)
//    final int W_XX = X;           //Counter detectionカウンターディテクション(未実装)

    //LV8魔法
//    final int W_FHL = X;          //Full HeeL                     フルヒール(未実装)
//    final int W_FWL = X;          //Fire WalL                     ファイアーウォール(未実装)
//    final int W_BLD = X;          //BLizzarD                      ブリザード(未実装)
//    final int W_INY = X;          //INvisibilitY                  インビジビリティー(未実装)
//    final int W_REN = X;          //REsurrectioN                  リザレクション(未実装)
//    final int W_EAE = X;          //EArthquakE                    アースクエイク(未実装)
//    final int W_LSM = X;          //Life StreaM                   ライフストリーム(未実装)
//    final int W_SIE = X;          //SIlencE                       サイレンス(未実装)

    //LV7魔法
//    final int W_HAL = X;          //Heel AlL                      ヒールオール(未実装)
    final int W_FAR = 102;          //Freezing ArmoR                フリージングアーマー
//    final int W_SMR = X;          //Summon MonsteR                サモンモンスター(未実装)
//    final int W_HWK = X;          //Holy WalK                     ホーリーウォーク(未実装)
//    final int W_TOO = X;          //TOrnadO                       トルネード(未実装)
//    final int W_GHT = X;          //Greater HeisT                 グレーターヘイスト(未実装)
    final int W_BER = 25;           //BErserkeR                     バーサーカー
    final int W_EAY = 101;          //Enchant Accuracy              エンチャントアキュラシー

    //LV6魔法
//    final int W_CZE = X;          //Create ZombiE                 クリエイトゾンビ(未実装)
//    final int W_PES = X;          //Physical Enchant:STR          フィジカルエンチャント:STR(未実装)
//    final int W_HET = X;          //HEisT                         ヘイスト(未実装)
//    final int W_CAN = X;          //CAncellatioN                  キャンセレーション(未実装)
//    final int W_IRN = X;          //IRaptioN                      イラプション(未実装)
//    final int W_SUT = X;          //SUnbursT                      サンバースト(未実装)
//    final int W_WES = X;          //WEaknesS                      ウィークネス(未実装)
//    final int W_BWN = X;          //Breath WeapoN                 ブレスウェポン(未実装)

    //LV5魔法
//    final int W_CPE = X;          //Curse ParalyzE                カーズパラライズ(未実装)
//    final int W_CLG = X;          //Call LightninG                コールライトニング(未実装)
//    final int W_GHL = X;          //Greater HeeL                  グレーターヒール(未実装)
//    final int W_TMR = X;          //Taming MonsteR                テイミングモンスター(未実装)
//    final int W_RCE = X;          //Remove CursE                  リムーブカーズ(未実装)
//    final int W_COC = X;          //Corn Of Cold                  コーンオブコールド(未実装)
//    final int W_MDN = X;          //Mana DraiN                    マナドレイン(未実装)
//    final int W_DAS = X;          //DArknesS                      ダークネス(未実装)

    //LV4魔法
//    final int W_FIL = X;          //FIrebalL                      ファイアーボール(未実装)
//    final int W_PED = X;          //Physical Enchant:DEX          フィジカルエンチャント:DEX(未実装)
//    final int W_WBK = X;          //Weapon BreaK                  ウェポンブレイク(未実装)
//    final int W_VTH = X;          //Vampiric ToucH                バンパイアリックタッチ(未実装)
//    final int W_THW = X;          //THroW                         スロー(未実装)
//    final int W_EJL = X;          //Earth JaiL                    アースジェイル(未実装)
//    final int W_CMC = X;          //Counter MagiC                 カウンターマジック(未実装)
//    final int W_MEN = X;          //MEditatioN                    メディテーション(未実装)

    //LV3魔法
//    final int W_LIG = X;          //LIghtninG                     ライトニング(未実装)
//    final int W_TUD = X;          //Turn UndeaD                   ターンアンデッド(未実装)
//    final int W_EHL = X;          //Extra HeeL                    エキストラヒール(未実装)
//    final int W_CBD = X;          //Curse BlinD                   カーズブラインド(未実装)
    final int W_BAR = 27;           //Blessed ArmoR                 ブレスドアーマー
//    final int W_FCD = X;          //Frozen ClouD                  フローズンクラウド(未実装)
//    final int W_WEL = X;          //Week ElementaL                ウィークエレメンタル(未実装)

    //LV2魔法
//    final int W_CPN = X;          //Cure PoisoN                   キュアポイズン(未実装)
//    final int W_CRH = X;          //Chill ToucH                   チルタッチ(未実装)
//    final int W_CPN = X;          //Cars PoisoN                   カーズポイズン(未実装)
//    final int W_EWN = X;          //Enchant WeapoN                エンチャントウェポン(未実装)
//    final int W_DEN = X;          //DEtectioN                     ディテクション(未実装)
    final int W_DWT = 26;           //Decrease WeighT               ディクリースウェイト
//    final int W_FAW = X;          //Fire ArroW                    ファイアーアロー(未実装)
//    final int W_STK = X;          //STarracK                      スタラック(未実装)

    //LV1魔法
//    final int W_HEL = X;          //HEaL                          ヒール(未実装)
//    final int W_LIT = X;          //LIghT                         ライト(未実装)
//    final int W_SHD = X;          //SHielD                        シールド(未実装)
//    final int W_EBT = X;          //Energy BolT                   エネルギーボルト(未実装)
//    final int W_TET = X;          //TEleporT                      テレポート(未実装)
//    final int W_IDR = X;          //Ice DaggeR                    アイスダガー(未実装)
//    final int W_WCR = X;          //Wind CutteR                   ウィンドカッター(未実装)
//    final int W_HWS = X;          //Holy WeaponS                  ホーリーウェポン(未実装)
    
//ダークエルフの闇の精霊魔法
    //LV4魔法
    final int D_AVR = 119;          //AVengeR                       アベンジャー(未実装)
    final int D_SHS = 120;          //SHadow Step                   シャドウステップ(未実装)
    final int D_ABK = 121;          //Armor BreaK                   アーマーブレイク(未実装)
    final int D_LUR = 122;          //LUcifeR                       ルシファー(未実装)
    final int D_LUD = 123;          //LUcifer:Destiny               ルシファー:デスティニー(未実装)
    final int D_DBD = 28;           //Double Break:Destiny          ダブルブレイク:デスティニー
    final int D_ABD = 124;          //Armor Break:Destiny           アーマーブレイク:デスティニー(未実装)

    //LV3魔法
    final int D_DBK = 29;           //Double BreaK                  ダブルブレイク
    final int D_UDE = 32;           //Uncanny DodgE                 アンキャニードッジ
//    final int D_SFG = X;          //Shadow FanG                   シャドウファング(基本エンチャントのキャラ/武器で実装)
    final int D_FBN = 103;          //Final BurN                    ファイナルバーン
    final int D_DEN = 31;           //Dress EvasioN                 ドレスイベイジョン

    //LV2魔法
    final int D_MAN = 79;           //Moving AcceleratioN           ムービングアクセレーション(未実装)
    final int D_BSS = 30;           //Burning SpiritS               バーニングスピリッツ
//    final int D_SSP = X;          //Shadow SleeP                  シャドウスリープ(未実装)
    final int D_VRT = 80;           //Venom ResisT                  ベノムレジスト(未実装)

    //LV1魔法
//    final int D_BHG = X;          //Blind HidinG                  ブラインドハイディング(未実装)
//    final int D_EVM = X;          //Enchantment VenoM             エンチャントベノム(未実装)
//    final int D_BRE = X;          //BRingstonE                    ブリングストーン(未実装)
    final int D_SAR = 33;           //Shadow ArmoR                  シャドウアーマー
//    final int D_DMY = X;          //Dress MightY                  ドレスマイティー(未実装)

//ドラゴンナイトの秘技
    //LV4魔法
    final int R_HAS = 116;          //HAlpaS                        ハルパス
    final int R_LINDVIOL = 90;      //Arousal[LINDVIOL]             覚醒[リンドビオル]
    final int R_AUA = 117;          //AUrakiA                       アウラキア
//    final int R_TGB = X;          //Thunder Grap:Brave            サンダーグラップ:ブレイブ
    final int R_FSB = 60;           //Four Slayer:Brave             フォースレイヤー:ブレイブ(未実装)

    //LV3魔法
    final int R_MBY = 38;           //Mortal BodY                   モータルボディー
//    final int R_TGP = X;          //Thunder GraP                  サンダーグラップ
//    final int R_DHR = X;          //Destroy:HorroR                デストロイ:ホラー
//    final int R_EOD = X;          //Eye Of Dragon                 アイオブドラゴン
    final int R_VALAKAS = 41;       //Arousal[VALAKAS]              覚醒[ヴァラカス]

    //LV2魔法
//    final int R_BLT = X;          //Blood LasT                    ブラッドラスト(基本エンチャントの2段加速で実装)
//    final int R_FSR = X;          //Four SlayeR                   フォースレイヤー
//    final int R_DFR = X;          //Destroy:FeaR                  デストロイ:フィアー
//    final int R_MAW = X;          //Magma ArroW                   マグマアロー
    final int R_FAFURION = 40;      //Arousal[FAFURION]             覚醒[パプリオン](未実装)

    //LV1魔法
    final int R_DSN = 37;           //Dragon SkiN                   ドラゴンスキン
//    final int R_BSH = X;          //Burning SlasH                 バーニングスラッシュ
//    final int R_DEY = X;          //DEstroY                       デストロイ
//    final int R_MBH = X;          //Magma BreatH                  マグマブレス
    final int R_ANTHARAS = 39;      //Arousal[ANTHARAS]             覚醒[アンタラス]

//イリュージョニストの幻術魔法
    //LV5魔法
    final int I_POL = 118;          //POtentiaL                     ポテンシャル
//    final int I_MES = X;          //MEviuS                        メビウス
    final int I_IMT = 92;           //IMpacT                        インパクト
//    final int I_DHE = X;          //Dark HorsE                    ダークホース(基本エンチャントの2段加速で実装)
    final int I_FSZ = 91;           //Focus SpitZ                   フォーカススピッツ

    //LV4魔法             
    final int I_INS = 46;           //INsighT                       インサイト
//    final int I_PAC = X;          //PAniC                         パニック
    final int I_RWT = 62;           //Reduce WeighT                 リデュースウェイト
    final int I_IAR = 45;           //Illusion[AvataR]              幻術[アバター]
//    final int I_CAR = X;          //Cube[AvataR]                  キューブ[アバター]

    //LV3魔法     
    final int I_PAE = 47;           //PAtiencE                      ペイシェンス
//    final int I_PHM = X;          //PHantasM                      ファンタズム
//    final int I_EBR = X;          //Eyes BreakeR                  アイズブレイカー
    final int I_IGM = 44;           //Illusion[GoleM]               幻術[ゴーレム]
//    final int I_CRH = X;          //Cube[RicH]                    キューブ[リッチ]

    //LV2魔法 
    final int I_CON = 48;           //COncentratioN                 コンセントレーション
//    final int I_MBK = X;          //Mind BreaK                    マインドブレイク
//    final int I_BBK = X;          //Bone BreaK                    ボーンブレイク
    final int I_IRH = 43;           //Illusion[RicH]                幻術[リッチ]
//    final int I_CGM = X;          //Cube[GoleM]                   キューブ[ゴーレム]

    //LV1魔法 
    final int I_MIE = 49;           //Mirror ImagE                  ミラーイメージ
//    final int I_CFN = X;          //ConFusioN                     コンフュージョン
//    final int I_SEY = X;          //Smash EnergY                  スマッシュエネルギー
    final int I_IOE = 42;           //Illusion[OgrE]                幻術[オーガ]
//    final int I_COE = X;          //Cube[OgrE]                    キューブ[オーガ]

//ウォリアーの技術
    //アクティブスキル
//    final int S_DEN = X;          //DEmolitioN                    デモリッション
//    final int S_DEO = X;          //DEsperadO                     デスペラード
    final int S_TRG = 115;          //Titan RisinG                  タイタンライジング
//    final int S_PGP = X;          //Power GriP                    パワーグリップ
    final int S_GIC = 76;           //GIgantiC                      ギガンティック
//    final int S_TOK = X;          //TOmahawK                      トマホーク
//    final int S_HOL = X;          //HOwL                          ハウル

    //パッシブスキル
    final int S_TLK = 69;           //Titan Lock                    タイタンロック
    final int S_TMC = 70;           //Titan MagiC                   タイタンマジック
    final int S_TBZ = 71;           //Titan BlitZ                   タイタンブリッツ     
//    final int S_SLR = X;          //SLayeR                        スレイヤー
    final int S_CRH = 67;           //CRasH                         クラッシュ
    final int S_AGD = 66;           //Armor GuarD                   アーマーガード
    final int S_FUY = 68;           //FUrY                          フューリー
//    final int S_DAE = X;          //Desperado:AbsolutE            デスペラード:アブソリュート

//フェンサーの技術
//  アクティブスキル
//    final int F_AAA = XXX;        //AshurA                        アシュラ
//    final int F_ABE = XXX;        //BladE                         ブレード
//    final int F_APA = XXX;        //Pantera                       パンテラ
//    final int F_AJT = XXX;        //JudgmenT                      ジャッジメント
//    final int F_AHE = XXX;        //HellfirE                      ヘルファイア
//    final int F_APM = XXX;        //PhantoM                       ファントム
//  パッシブスキル
//    final int F_PPH = XXX;        //Phantom:DeatH                 ファントム:デス
//    final int F_PPR = XXX;        //Phantom:ReapeR                ファントム:リーパー
//    final int F_PPK = XXX;        //Pantera:ShocK                 パンテラ:ショック
//    final int F_PSE = XXX;        //SurvivE                       サヴァイヴ
    final int F_PIZ = 104;          //Infinity:BlitZ                インフィニティ:ブリッツ
//    final int F_PPX = XXX;        //ParadoX                       パラドックス
    final int F_PIE = 105;          //Infinity:DodgE                インフィニティ:ドッジ
//    final int F_PGE = XXX;        //GrousE                        グロウス
    final int F_PID = 106;          //Infinity:BlooD                インフィニティ:ブラッド
    final int F_PRE = 107;          //RagE                          レイジ
    final int F_PIR = 108;          //Infinity:ArmoR                インフィニティ:アーマー
    final int F_PFE = 109;          //FramE                         フレイム
    final int F_PDS = 125;          //DamascuS                      ダマスカス

//その他
    final int DRAGON_BLESS = 126;   //ドラゴンの祝福
    final int ITEM_BLUE = 50;       //魔力回復ポーション
    final int ITEM_WIZP = 51;       //ウィズダムポーション
    final int ITEM_COOKING = 54;    //料理
    final int ITEM_DESSERT = 55;    //デザート
    final int ITEM_BREEZE = 52;     //潮風の力
    final int ITEM_SEA = 53;        //深海の力
    final int ITEM_MD = 56;         //マジックドール
    final int ITEM_MD_OP = 64;      //パック/パオ OP
    final int KOMA = 58;            //コマのエンチャ
    final int ITEM_MAGAN = 98;      //魔眼
    final int CLAY = 77;            //クレイ
    final int MOMIJI = 78;          //もみじリング
    final int BUFF_COIN = 63;       //バフコイン
    final int BS_COIN = 82;         //黒蛇のコイン
    final int MBSC = 74;            //真心のこもった祝福スクロール
    final int L_HST = 83;           //成長の果実
    final int H_HP = 93;            //生命のボーナス
    final int H_AC = 94;            //鉄甲のボーナス
    final int H_PVPDR = 95;         //生存のボーナス
    final int H_PVP = 96;           //暗殺のボーナス
    final int H_RK = 97;            //ランカーボーナス
    
    final String[] AILMENT_LIST = {"技術命中", "技術耐性", "精霊命中", "精霊耐性", "秘技命中","秘技耐性", "恐怖命中", "恐怖耐性"};
//    final String[] AILMENT_LIST = {"技術", "技術", "精霊", "精霊", "秘技","秘技", "恐怖", "恐怖"};
    final int HIT_STUN = 0;
    final int STUN = 1;
    final int HIT_SPIRIT = 2;
    final int SPIRIT = 3;
    final int HIT_SECRET = 4;
    final int SECRET = 5;
    final int HIT_TERROR = 6;
    final int TERROR = 7; 

    final String[] ENEMY_TYPE_LIST = {"通常", "悪魔", "不死"};
    final int NORMAL = 0;
    final int CURSED = 1;
    final int UNDEAD = 2;

//強化値
    String[] EQ_EN_LIST = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
        "9", "10", "11", "12", "13", "14", "15"};

//属性強化
    String[] EQ_ELEM_LIST = {"無属性", "地霊:1段", "地霊:2段", "地霊:3段", "地霊:4段",
        "地霊:5段", "火霊:1段", "火霊:2段", "火霊:3段", "火霊:4段", "火霊:5段", "水霊:1段",
        "水霊:2段", "水霊:3段", "水霊:4段", "水霊:5段", "風霊:1段", "風霊:2段", "風霊:3段",
        "風霊:4段", "風霊:5段"};

//Tシャツの強化値
    String[] EQ_TS_LIST = {"0段階", "1段階", "2段階", "3段階", "4段階", "5段階"};
}
