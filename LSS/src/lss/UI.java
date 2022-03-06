/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author user
 */
public class UI extends JFrame implements Common, ActionListener, ChangeListener {

    Calculator calc = new Calculator(this);

    String version = "";
    JTabbedPane tabpane;
    JPanel panels[] = new JPanel[7];

    File f_save_path = new File("./save");

    //UI�p�[�c
    //����
    JLabel[] lab_st = new JLabel[ST_LIST.length];
    JLabel[] lab_st_sum = new JLabel[ST_LIST.length];
    JLabel[] lab_st_base = new JLabel[ST_LIST.length];
    JLabel[] lab_st_lev = new JLabel[ST_LIST.length];
    JLabel[] lab_st_add = new JLabel[ST_LIST.length];
    JLabel lab_rem;

    JButton[] bt_down = new JButton[ST_LIST.length];
    JButton[] bt_up = new JButton[ST_LIST.length];

    JComboBox cb_lev;
    JComboBox cb_cls;

    JButton bt_save;
    JButton bt_load;
    JButton bt_ow;

    JLabel lab_ac;
    JLabel lab_dg;
    JLabel lab_er;
    JLabel lab_me;
    JLabel lab_sp;
    JLabel lab_ml;
    JLabel lab_mb;
    JLabel lab_spr;

    JLabel lab_dr;
    JLabel lab_dri;
    JLabel lab_mr;
    JLabel lab_pvp_dg;
    JLabel lab_pvp_dgr;

    JLabel lab_pot1;
    JLabel lab_pot2;

    JLabel lab_dmg_short, lab_dmg_long, lab_dmg_mag;
    JLabel lab_hit_short, lab_hit_long, lab_hit_mag;
    JLabel lab_cri_short, lab_cri_long, lab_cri_mag;   
    JLabel lab_ac_short, lab_ac_long;
    JLabel lab_dmg_normal;
    JLabel lab_dmg_cursed;
    JLabel lab_dmg_undead;
    JLabel lab_mag_info1;
    JLabel lab_mag_info2;
    JLabel lab_hit_rate;

    JLabel lab_hp;
    JLabel lab_mp;
    JLabel lab_mexp;

    JLabel lab_hpr;
    JLabel lab_mpr;
    JLabel lab_cons_mp;
    JLabel lab_pot;

    //���ʃp�[�c����
    ArrayList<JComponent> commons = new ArrayList<>();

    //�p�l��1
    JComboBox cb_eq_ch;
    JButton bt_copy;
    JButton bt_paste;
    JButton bt_reset;

    WideComboBox[] cb_eq = new WideComboBox[EQ_LIST.length];    //������
    JComboBox[] cb_eq_en = new JComboBox[EQ_LIST.length];       //�����������l

    JComboBox cb_elem_1;
    JComboBox cb_elem_2;
    JComboBox cb_ts_elem;
    JToggleButton tb_ts_sp;
    JToggleButton tb_blessed1;
    JToggleButton tb_blessed2;
    JComboBox cb_arrow;
    
    JComboBox elixir_rune_en;   //�G���N�T�[���[�����x��
    WideComboBox elixir_rune;   //�G���N�T�[���[��

    WideComboBox cb_pattern_l;  //����
    WideComboBox cb_pattern_r;  //�E��
    WideComboBox cb_pattern_c;  //�w��
    WideComboBox cb_pattern_l2; //���r
    WideComboBox cb_pattern_r2; //�E�r

    JComboBox cb_alterstone_en;
    JComboBox[] cb_alterstone_op = new JComboBox[3];

    JTextField tf_weight;
    JTextField tf_weight2;
//    JCheckBox cb_weight_auto;
    JComboBox cb_weight;
    JTextField tf_speed;
    JTextField tf_acc;
    JTextField tf_magic_speed_main;
    JTextField tf_magic_speed_sub;
    JCheckBox cb_speed_auto;

    JComboBox cb_morph_type;
    JComboBox cb_morph_level;

    JTextField tf_buki_sp_rate;
    JLabel lab_sp_sub;
    JTextField tf_mag_rate;
    JTextField tf_mag_delay;
    JTextField tf_mag_power;
    JLabel lab_sp_rate;
    JLabel lab_mag_rate;
    JLabel lab_mag_delay;
    JLabel lab_mag_power;
    JCheckBox cb_mag_auto;
    JComboBox cb_magic;

    JLabel[] lab_elem = new JLabel[ELEM_LIST.length];
    JLabel[] lab_ailment = new JLabel[AILMENT_LIST.length];

    //�p�l��2
    //pure_status_bonus[0][0]����[0][24]�܂ł̓o�^��[1][0]����[1][24]�܂ł̓o�^
    //JLabel[][] pure_status_bonus = new JLabel[2][25];
    JLabel[][] pure_status_bonus = new JLabel[2][30];

    JComboBox[] cb_elixir = new JComboBox[20];              //�G���N�T�̍ő�MAX20��
    JComboBox[] cb_elixir_level = new JComboBox[20];        //�G���N�T�[��LV
    LEV lev = new LEV();

    //�p�l��3
    //�X�L��320��   0����319�Ōv320��
    JCheckBox[] cb_buff = new JCheckBox[320];
    JComboBox[] cb_buff_group = new JComboBox[320];

    //�p�l��5
    JComboBox cb_npc_level;
    JSlider[] s_target_res = new JSlider[ELEM_LIST.length];
    JLabel[] lab_target_resist = new JLabel[ELEM_LIST.length];
    JComboBox cb_target_dr;
    JSlider s_target_mr;
    JLabel lab_target_mr;
    JComboBox cb_target_ac;
    JComboBox cb_mode_pc;
    JComboBox cb_target_dg;
    JCheckBox cb_sonsyou;
    JCheckBox cb_hittyuu;
    JComboBox cb_res;
    JTextField tf_res_name;
    JButton bt_save_res;
    JButton bt_load_res;
    JButton bt_ow_res;
    JButton bt_del_res;
    JLabel lab_default;

    JTextField tf_e_hp;
    JTextField tf_e_hpr;
    JComboBox cb_e_type;
    JComboBox cb_e_size;
    JLabel lab_time;

    ZipFile eq_files;
    ArrayList<ZipEntry>[] eq_entrys = new ArrayList[EQ_LIST.length];

    {
        for (int i = 0; i < eq_entrys.length; i++) {
            eq_entrys[i] = new ArrayList<>();
        }
    }

    //�\�L�̏C��(y_ikeda����̏C�����)
    //ArrayList<ZipEntry> arrow_entrys = new ArrayList();
    //ArrayList<ZipEntry> sting_entrys = new ArrayList();
    ArrayList<ZipEntry> arrow_entrys = new ArrayList<>();
    ArrayList<ZipEntry> sting_entrys = new ArrayList<>();

    File file;

    void init() {

        boolean error = false;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("./version.txt")));
            version = reader.readLine();
        } catch (IOException ex) {
            error = true;
        }

        setTitle("Lineage Status Simulator ver " + version);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //������ʐݒ�@setSize(800, 600); >>> setSize(800, 640);
        //setSize(1000, 640); ��10*����5��ǉ�
        setSize(1010, 645);
        setResizable(false);

        ToolTipManager.sharedInstance().setInitialDelay(100);       //�����l:750   ���̃A�N�V�����C�x���g���g���K�[�����܂ł̏����x������
        ToolTipManager.sharedInstance().setDismissDelay(6_000);     //�����l:4000  ���������x������
//        System.out.println(ToolTipManager.sharedInstance().getDismissDelay());    //�����l�m�F�p

        tabpane = new JTabbedPane();

        panels[0] = new JPanel();
        panels[1] = new JPanel();
        panels[2] = new JPanel();
        panels[3] = new JPanel();
        panels[4] = new JPanel();
        panels[5] = new JPanel();
        panels[6] = new JPanel();

        panels[0].setLayout(null);
        panels[1].setLayout(null);
        panels[2].setLayout(null);
        panels[3].setLayout(null);
        panels[4].setLayout(null);
        panels[5].setLayout(null);
        panels[6].setLayout(null);
        

        tabpane.add("����/�X�e�[�^�X", panels[0]);                  //�p�l��0�̖��O
        tabpane.add("���x��/�G���N�T�[", panels[1]);                //�p�l��1�̖��O
        tabpane.add("�G���`�����g", panels[2]);                     //�p�l��2�̖��O
        tabpane.add("�X�L��1", panels[3]);                         //�p�l��3�̖��O
        tabpane.add("�X�L��2", panels[4]);                         //�p�l��4�̖��O
        tabpane.add("�X�L��3", panels[5]);                         //�p�l��5�̖��O
        tabpane.add("�ϐ��ݒ�", panels[6]);                        //�p�l��6�̖��O

        add(tabpane);

        //----------
        //����
        //----------
        JLabel lab_tmp;

        bt_ow = new JButton("�㏑��");
        bt_ow.setBounds(450+110, 0, 100, 20);
        panels[0].add(bt_ow);
        commons.add(bt_ow);
        bt_ow.addActionListener(this);
        bt_ow.setActionCommand("ow");
        bt_ow.setEnabled(false);

        bt_save = new JButton("�ۑ�");
        bt_save.setBounds(550+110, 0, 100, 20);
        panels[0].add(bt_save);
        commons.add(bt_save);
        bt_save.addActionListener(this);
        bt_save.setActionCommand("save");

        bt_load = new JButton("�Ǎ�");
        bt_load.setBounds(650+110, 0, 100, 20);
        panels[0].add(bt_load);
        commons.add(bt_load);
        bt_load.addActionListener(this);
        bt_load.setActionCommand("load");

        cb_cls = new WideComboBox(CLASS_LIST2);
        cb_cls.setBounds(0, 0, 100, 20);
        cb_cls.addActionListener(this);
        cb_cls.setActionCommand("reset");
        panels[0].add(cb_cls);
        commons.add(cb_cls);

        lab_tmp = new JLabel("���x��");
        lab_tmp.setBounds(120, 0, 30, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        lab_tmp = new JLabel("-");
        lab_tmp.setBounds(55, 40, 20, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        lab_tmp = new JLabel("+");
        lab_tmp.setBounds(75, 40, 40, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        //String lev_list[] = new String[92];                                       //�����ݒ�ő�LV92 >>>96 �܂ŕ\��
        String lev_list[] = new String[100];                                        //����LV100�Ή�
        for (int i = 0; i < lev_list.length; i++) {
            lev_list[i] = Integer.toString(i + 1);
        }
        cb_lev = new WideComboBox(lev_list);
        cb_lev.addActionListener(this);
        cb_lev.setBounds(160, 0, 50, 20);
        panels[0].add(cb_lev);
        commons.add(cb_lev);

        for (int i = 0; i < ST_LIST.length; i++) {

            lab_st[i] = new JLabel(ST_LIST[i]);
            lab_st[i].setBounds(0, 60 + i * 20, 30, 20);
            panels[0].add(lab_st[i]);
            commons.add(lab_st[i]);

            bt_down[i] = new JButton();
            bt_down[i].setBounds(50, 60 + i * 20, 20, 20);
            bt_down[i].setActionCommand(ST_LIST[i] + "/down");
            bt_down[i].addActionListener(this);
            panels[0].add(bt_down[i]);
            commons.add(bt_down[i]);

            bt_up[i] = new JButton();
            bt_up[i].setBounds(70, 60 + i * 20, 20, 20);
            bt_up[i].setActionCommand(ST_LIST[i] + "/up");
            bt_up[i].addActionListener(this);
            panels[0].add(bt_up[i]);
            commons.add(bt_up[i]);

            lab_st_sum[i] = new JLabel("0", SwingConstants.CENTER);
            lab_st_sum[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lab_st_sum[i].setBounds(30, 60 + 20 * i, 20, 20);
            lab_st_base[i] = new JLabel("0", SwingConstants.CENTER);
            lab_st_base[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lab_st_base[i].setBounds(100, 60 + 20 * i, 20, 20);
            lab_st_add[i] = new JLabel("0", SwingConstants.CENTER);
            lab_st_add[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lab_st_add[i].setBounds(160, 60 + 20 * i, 20, 20);
            lab_st_lev[i] = new JLabel("0", SwingConstants.CENTER);
            lab_st_lev[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lab_st_lev[i].setBounds(130, 60 + 20 * i, 20, 20);

            panels[0].add(lab_st_sum[i]);
            panels[0].add(lab_st_base[i]);
            panels[0].add(lab_st_add[i]);
            panels[0].add(lab_st_lev[i]);
            commons.add(lab_st_sum[i]);
            commons.add(lab_st_base[i]);
            commons.add(lab_st_add[i]);
            commons.add(lab_st_lev[i]);
        }

        lab_tmp = new JLabel("REM");
        lab_tmp.setBounds(0, 60 + 120, 30, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        lab_rem = new JLabel("", JLabel.CENTER);
        lab_rem.setBounds(30, 60 + 120, 20, 20);
        panels[0].add(lab_rem);
        commons.add(lab_rem);

        lab_tmp = new JLabel("����", JLabel.CENTER);
        lab_tmp.setBounds(100, 40, 30, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("LV", JLabel.CENTER);
        lab_tmp.setBounds(130, 40, 30, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("�ǉ�", JLabel.CENTER);
        lab_tmp.setBounds(160, 40, 30, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("���v", JLabel.CENTER);
        lab_tmp.setBounds(20, 40, 30, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        lab_tmp = new JLabel("HP");
        lab_tmp.setBounds(200 + 25, 40, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("MP");
        lab_tmp.setBounds(210 + 60 + 25, 40, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("�l���o���l:");
        lab_tmp.setBounds(455 + 25, 40+60, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_hp = new JLabel();
        lab_hp.setBounds(230 + 25, 40, 70, 20);
        lab_mp = new JLabel();
        lab_mp.setBounds(300 + 25, 40, 70, 20);
        lab_mexp = new JLabel();
        lab_mexp.setBounds(545 + 25, 40+60, 70, 20);

        lab_tmp = new JLabel("AC");
        lab_tmp.setBounds(200 + 25, 40 + 20, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("MR");
        lab_tmp.setBounds(270 + 25, 40 + 20, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("DR");
        lab_tmp.setBounds(340 + 25, 40 + 20, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("DR��");
        lab_tmp.setBounds(340 + 25, 20 + 20, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_ac = new JLabel();
        lab_mr = new JLabel();
        lab_dr = new JLabel();
        lab_dri = new JLabel();
        lab_ac.setBounds(200 + 30 + 25, 40 + 20, 200, 20);
        lab_mr.setBounds(210 + 90 + 25, 40 + 20, 200, 20);
        lab_dr.setBounds(220 + 150 + 25, 40 + 20, 200, 20);
        lab_dri.setBounds(220 + 150 + 25, 20+ 20, 200, 20);
        panels[0].add(lab_ac);
        commons.add(lab_ac);
        panels[0].add(lab_mr);
        commons.add(lab_mr);
        panels[0].add(lab_dr);
        commons.add(lab_dr);
        panels[0].add(lab_dri);
        commons.add(lab_dri);

        lab_tmp = new JLabel("DG");
        lab_tmp.setBounds(200 + 25, 40 + 40, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("ER");
        lab_tmp.setBounds(270 + 25, 40 + 40, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("ME");
        lab_tmp.setBounds(340 + 25, 40 + 40, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("��");
        lab_tmp.setBounds(270 + 25, 40 + 80, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("ML");
        lab_tmp.setBounds(340 + 25, 40 + 60, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("MB");
        lab_tmp.setBounds(340 + 25, 40 + 80, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("SP");
        lab_tmp.setBounds(340 + 25, 40 + 100, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_dg = new JLabel();
        lab_er = new JLabel();
        lab_me = new JLabel();

        lab_sp = new JLabel();
        lab_ml = new JLabel();
        lab_mb = new JLabel();
        lab_spr = new JLabel();

        lab_dg.setBounds(200 + 30 + 25, 40 + 40, 200, 20);
        lab_er.setBounds(210 + 90 + 25, 40 + 40, 200, 20);
        lab_me.setBounds(210 + 160 + 25, 40 + 40, 200, 20);
        
        lab_sp.setBounds(210 + 90 + 25, 40 + 80, 200, 20);
        lab_ml.setBounds(220 + 150 + 25, 40 + 60, 200, 20);
        lab_mb.setBounds(220 + 150 + 25, 40 + 80, 200, 20);
        lab_spr.setBounds(220 + 150 + 25, 40 + 100, 200, 20);

        panels[0].add(lab_dg);
        commons.add(lab_dg);
        panels[0].add(lab_er);
        commons.add(lab_er);
        panels[0].add(lab_me);
        commons.add(lab_me);

        panels[0].add(lab_sp);
        commons.add(lab_sp);
        panels[0].add(lab_ml);
        commons.add(lab_ml);
        panels[0].add(lab_mb);
        commons.add(lab_mb);
        panels[0].add(lab_spr);
        commons.add(lab_spr);

        lab_tmp = new JLabel("HPR");
        lab_tmp.setBounds(200 + 25, 40 + 60, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("MPR");
        lab_tmp.setBounds(270 + 25, 40 + 60, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        panels[0].add(lab_hp);
        panels[0].add(lab_mp);
        panels[0].add(lab_mexp);
        commons.add(lab_hp);
        commons.add(lab_mp);
        commons.add(lab_mexp);

        lab_hpr = new JLabel();
        lab_mpr = new JLabel();
        lab_hpr.setBounds(200 + 30 + 25, 40 + 60, 200, 20);
        lab_mpr.setBounds(270 + 30 + 25, 40 + 60, 200, 20);
        panels[0].add(lab_hpr);
        panels[0].add(lab_mpr);
        commons.add(lab_hpr);
        commons.add(lab_mpr);

        lab_tmp = new JLabel("MP����");
        lab_tmp.setBounds(200 + 25, 40 + 100, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_cons_mp = new JLabel();
        lab_cons_mp.setBounds(200 + 50 + 25, 40 + 100, 200, 20);
        panels[0].add(lab_cons_mp);
        commons.add(lab_cons_mp);

        lab_pot = new JLabel("�|�[�V�����񕜗�");
        lab_pot.setBounds(200 + 25, 40 + 120, 200, 20);
        panels[0].add(lab_pot);
        commons.add(lab_pot);

        lab_pot1 = new JLabel();
        lab_pot1.setBounds(200 + 25 + 100, 40 + 120, 100, 20);
        panels[0].add(lab_pot1);
        commons.add(lab_pot1);

        lab_pot2 = new JLabel();
        lab_pot2.setBounds(200 + 25 + 130, 40 + 120, 100, 20);
        panels[0].add(lab_pot2);
        commons.add(lab_pot2);

        lab_dmg_short = new JLabel();
        lab_dmg_long = new JLabel();
        lab_dmg_mag = new JLabel();
        lab_hit_short = new JLabel();
        lab_hit_long = new JLabel();
        lab_hit_mag = new JLabel();
        lab_cri_short = new JLabel();
        lab_cri_long = new JLabel();
        lab_cri_mag = new JLabel();
        lab_pvp_dg = new JLabel();
        lab_pvp_dgr = new JLabel();
        lab_ac_short = new JLabel();
        lab_ac_long = new JLabel();
        lab_dmg_short.setBounds(480, 20 + 20, 150, 20);
        lab_dmg_long.setBounds(480, 20 + 20 + 20, 150, 20);
        lab_dmg_mag.setBounds(480, 20 + 40 + 20, 150, 20);
        lab_hit_short.setBounds(630, 20 + 20, 250, 20);
        lab_hit_long.setBounds(630, 20 + 20 + 20, 250, 20);
        lab_hit_mag.setBounds(630, 20 + 40 + 20, 150, 20);
        lab_cri_short.setBounds(760, 20 + 20, 250, 20);
        lab_cri_long.setBounds(760, 20 + 20 + 20, 250, 20);
        lab_cri_mag.setBounds(760, 20 + 40 + 20, 150, 20);
        lab_pvp_dg.setBounds(630, 20 + 60 + 20, 200, 20);
        lab_pvp_dgr.setBounds(760, 20 + 60 + 20, 200, 20);
        lab_ac_short.setBounds(705, 20 + 20, 150, 20);
        lab_ac_long.setBounds(705, 20 + 20 + 20, 150, 20);
        panels[0].add(lab_dmg_short);
        panels[0].add(lab_dmg_long);
        panels[0].add(lab_dmg_mag);
        panels[0].add(lab_hit_short);
        panels[0].add(lab_hit_long);
        panels[0].add(lab_hit_mag);
        panels[0].add(lab_cri_short);
        panels[0].add(lab_cri_long);
        panels[0].add(lab_cri_mag);
        panels[0].add(lab_pvp_dg);
        panels[0].add(lab_pvp_dgr);
        panels[0].add(lab_ac_short);
        panels[0].add(lab_ac_long);
        commons.add(lab_dmg_short);
        commons.add(lab_dmg_long);
        commons.add(lab_dmg_mag);
        commons.add(lab_hit_short);
        commons.add(lab_hit_long);
        commons.add(lab_hit_mag);
        commons.add(lab_cri_short);
        commons.add(lab_cri_long);
        commons.add(lab_cri_mag);
        commons.add(lab_pvp_dg);
        commons.add(lab_pvp_dgr);
        commons.add(lab_ac_long);
        commons.add(lab_ac_short);

        //���ԃ_���[�W
        lab_tmp = new JLabel("�Βʏ�");
        lab_tmp.setBounds(480, 50 + 60 + 10, 50, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("�Έ���");
        lab_tmp.setBounds(480, 50 + 60 + 20 + 10, 50, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("�Εs��");
        lab_tmp.setBounds(480, 50 + 60 + 40 + 10, 50, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        //���@�E������
        lab_hit_rate = new JLabel();
        lab_mag_info1 = new JLabel();
        lab_mag_info2 = new JLabel();
        lab_hit_rate.setBounds(430 + 200, 70 + 40 + 10, 200, 20);
        lab_mag_info1.setBounds(430 + 200, 70 + 60 + 10, 300, 20);
        lab_mag_info2.setBounds(430 + 200, 70 + 80 + 10, 300, 20);
        panels[0].add(lab_hit_rate);
        panels[0].add(lab_mag_info1);
        panels[0].add(lab_mag_info2);
        commons.add(lab_hit_rate);
        commons.add(lab_mag_info1);
        commons.add(lab_mag_info2);

        //�Βʏ� �Έ��� �Εs���̃_���[�W
        lab_dmg_normal = new JLabel();
        lab_dmg_cursed = new JLabel();
        lab_dmg_undead = new JLabel();
        lab_dmg_normal.setBounds(480 + 50, 70 + 40 + 10, 400, 20);
        lab_dmg_cursed.setBounds(480 + 50, 70 + 60 + 10, 150, 20);
        lab_dmg_undead.setBounds(480 + 50, 70 + 80 + 10, 150, 20);
        panels[0].add(lab_dmg_normal);
        panels[0].add(lab_dmg_cursed);
        panels[0].add(lab_dmg_undead);
        commons.add(lab_dmg_normal);
        commons.add(lab_dmg_cursed);
        commons.add(lab_dmg_undead);

        //----------
        //�p�l��0
        //----------
        for (int i = 0, cnt = 1; i < EQ_LIST.length; i++, cnt++) {

            cb_eq_en[i] = new JComboBox();
            cb_eq_en[i].setBounds(200 * (cnt % 2), 220 + (cnt - ((cnt + 1) / 2)) * 20, 50, 20);
            panels[0].add(cb_eq_en[i]);
            cb_eq_en[i].addActionListener(this);

            cb_eq[i] = new WideComboBox();
            cb_eq[i].setBounds(50 + 200 * (cnt % 2), 220 + (cnt - ((cnt + 1) / 2)) * 20, 150, 20);
            panels[0].add(cb_eq[i]);
            cb_eq[i].addActionListener(this);

            //���X�g19����21�֊g��(�X�|�[���_�[�A�C���V�O�j�A��)2�ǉ��@+�y���_���g��22�� +�����O2�ǉ���24��
            if (i >= 24) {
                cb_eq[i].setEnabled(false);
                cb_eq_en[i].setEnabled(false);
            }
            if (i == 19) {
                cnt++;
            }
            if (i == 4) {
                cnt++;
            }
            if (i == 2) {
                cnt++;
            }
            if (i == 0) {
                cnt++;
            }

        }
        String buki_elem_list[] = {"������", "�n��:1�i", "�n��:2�i", "�n��:3�i", "�n��:4�i",
            "�n��:5�i", "�Η�:1�i", "�Η�:2�i", "�Η�:3�i", "�Η�:4�i", "�Η�:5�i", "����:1�i",
            "����:2�i", "����:3�i", "����:4�i", "����:5�i", "����:1�i", "����:2�i", "����:3�i",
            "����:4�i", "����:5�i"};

        cb_elem_1 = new JComboBox(buki_elem_list);
        cb_elem_1.setBounds(50, 220, 75, 20);
        cb_elem_1.addActionListener(this);
        panels[0].add(cb_elem_1);

        cb_elem_2 = new JComboBox(buki_elem_list);
        cb_elem_2.setBounds(50, 220 + 20, 75, 20);
        cb_elem_2.addActionListener(this);
        panels[0].add(cb_elem_2);

        String ts_ele_list[] = {"0�i�K", "1�i�K", "2�i�K", "3�i�K", "4�i�K", "5�i�K"};

        cb_ts_elem = new JComboBox(ts_ele_list);
        cb_ts_elem.setBounds(50, 220 + 80, 75, 20);
        cb_ts_elem.addActionListener(this);
        panels[0].add(cb_ts_elem);

        tb_ts_sp = new JToggleButton("����");
        tb_ts_sp.setBounds(50 + 75, 220 + 80, 75, 20);
        panels[0].add(tb_ts_sp);
        tb_ts_sp.setEnabled(false);
        tb_ts_sp.addActionListener(this);

        tb_blessed1 = new JToggleButton("�j��");
        tb_blessed1.setBounds(125, 220, 75, 20);
        tb_blessed1.addActionListener(this);
        panels[0].add(tb_blessed1);

        tb_blessed2 = new JToggleButton("�j��");
        tb_blessed2.setBounds(125, 220 + 20, 75, 20);
        tb_blessed2.addActionListener(this);
        panels[0].add(tb_blessed2);

        cb_arrow = new JComboBox();
        cb_arrow.addActionListener(this);
        cb_arrow.setActionCommand("�A���[");
        cb_arrow.setBounds(250, 220 + 40, 150, 20);
        panels[0].add(cb_arrow);

        tb_blessed2.setEnabled(false);
        cb_elem_2.setEnabled(false);
        cb_eq[1].setEnabled(false);
        cb_eq_en[1].setEnabled(false);

        //�G���N�T�[���[�����x��
        String[] elixir_rune_en_list = {"L55", "L70", "L80", "L85", "L90", "L91", "L92", "L93", "L94", "L95"};
        elixir_rune_en = new JComboBox(elixir_rune_en_list);
        elixir_rune_en.setBounds(0, 460, 50, 20);
        elixir_rune_en.addActionListener(this);
        panels[0].add(elixir_rune_en);

        //�G���N�T�[���[��
        String elixir_rune_list[] = {"�G���N�T�[���[��", "�͂̃G���N�T�[���[��", "�@�q�̃G���N�T�[���[��", "�m�͂̃G���N�T�[���[��", "�m�b�̃G���N�T�[���[��", "�̗͂̃G���N�T�[���[��"
                ,"�A���J�̈╨","�������ꂽ�A���J�̈╨"
                ,"�h���S���̈╨","�������ꂽ�h���S���̈╨(�r��)","�������ꂽ�h���S���̈╨(�m��)","�������ꂽ�h���S���̈╨(�@�q)"
                ,"�^�f�X�i�C�g�̈╨","�������ꂽ�^�f�X�i�C�g�̈╨(�r��)","�������ꂽ�^�f�X�i�C�g�̈╨(�m��)","�������ꂽ�^�f�X�i�C�g�̈╨(�@�q)"
                ,"�p�Y�̈╨","�������ꂽ�p�Y�̈╨(�r��)","�������ꂽ�p�Y�̈╨(�m��)","�������ꂽ�p�Y�̈╨��(�@�q)"};
        elixir_rune = new WideComboBox(elixir_rune_list);
        elixir_rune.setBounds(50, 460, 150, 20);
        elixir_rune.addActionListener(this);
        panels[0].add(elixir_rune);

        String left_list[] = {"���r", "�r�̖͂�l", "�@�q�̖�l", "�̗̖͂�l", "�m�̖͂�l", "���_�̖�l",
            "���̖͂�l", "�r�̖͂�lII", "�@�q�̖�lII", "�m�̖͂�lII", "���m�̖�l", "�p�m�̖�l",
            "���m�̖�lII", "�p�m�̖�lII", "�|�m�̖�lII"};
        String right_list[] = {"�E�r", "�����̖�l", "���@�̖�l", "�h��̖�l", "�h��̖�lII", "�ω΂̖�l",
            "�ϐ��̖�l", "�ϕ��̖�l", "�ϒn�̖�l", "������R�̖�l", "�����̖h���l", "���̖͂h���l", "�㋉�h��̖�l", "�̑�Ȃ�҂̈╨"};
        String center_list[] = {"�w��", "�F��̖�l", "�F��̖�lII", "�F��̖�lIII", "�F��̖�lIV", "�F��̖�lV"};
        String left2_list[] = {"����", "�l��(�ߋ���)", "�l��(������)", "�Z��(��/������)", "�ۉ�̓��̃^���X�}��"};
        String right2_list[] = {"�E��", "����̌아(�̗�)", "����̌아(����)", "��m�����̌아", "�ˎ肽���̌아", "�p�t�����̌아", "�E�҂̃I���^�[�X�g�[��", "���e�̃I���^�[�X�g�[��", "�b�q�̃I���^�[�X�g�[��"};
        cb_pattern_l = new WideComboBox(left_list);
        cb_pattern_r = new WideComboBox(right_list);
        cb_pattern_c = new WideComboBox(center_list);
        cb_pattern_l2 = new WideComboBox(left2_list);
        cb_pattern_r2 = new WideComboBox(right2_list);
        cb_pattern_l.setBounds(280, 400 + 120, 115, 20);
        cb_pattern_r.setBounds(50, 400 + 120, 115, 20);
        cb_pattern_c.setBounds(165, 400 + 130, 115, 20);
        cb_pattern_l2.setBounds(280, 400 + 140, 115, 20);
        cb_pattern_r2.setBounds(50, 400 + 140, 115, 20);
        cb_pattern_l.addActionListener(this);
        cb_pattern_r.addActionListener(this);
        cb_pattern_c.addActionListener(this);
        cb_pattern_l2.addActionListener(this);
        cb_pattern_r2.addActionListener(this);
        panels[0].add(cb_pattern_l);
        panels[0].add(cb_pattern_r);
        panels[0].add(cb_pattern_c);
        panels[0].add(cb_pattern_l2);
        panels[0].add(cb_pattern_r2);

        //�I���^�[�X�g�[��
        String[] en_list = {"", "+1", "+2", "+3", "+4", "+5", "+6", "+7"};
        cb_alterstone_en = new JComboBox(en_list);
        cb_alterstone_en.setBounds(0, 400 + 160, 50, 20);
        cb_alterstone_en.addActionListener(this);
        panels[0].add(cb_alterstone_en);

        //�I���^�[�X�g�[���I�v�V����
        String[] alterstone_op_list = {"", "�ߋ����_���[�W +1", "�������_���[�W +1","�ߋ������� +2",
            "���������� +2", "SP +1", "���@�N���e�B�J�� +1", "���@���Ռ����{2", "�ꌂ�K�E(1%�m���Œǉ��_���[�W50)"};
        for (int i = 0; i < cb_alterstone_op.length; i++) {
            cb_alterstone_op[i] = new WideComboBox(alterstone_op_list);
            cb_alterstone_op[i].setBounds(50 + 115 * i, 400 + 160, 115, 20);
            cb_alterstone_op[i].addActionListener(this);
            panels[0].add(cb_alterstone_op[i]);
        }

        String ch_list[] = {"�p�^�[��1", "�p�^�[��2", "�p�^�[��3"};
        cb_eq_ch = new JComboBox(ch_list);
        cb_eq_ch.addActionListener(mem);
        cb_eq_ch.setActionCommand("ch");
        cb_eq_ch.setBounds(50, 200, 110, 20);
        panels[0].add(cb_eq_ch);

        bt_copy = new JButton("Copy");
        bt_copy.addActionListener(mem);
        bt_copy.setActionCommand("copy");
        bt_copy.setBounds(160, 200, 80, 20);
        panels[0].add(bt_copy);

        bt_paste = new JButton("Paste");
        bt_paste.addActionListener(mem);
        bt_paste.setActionCommand("paste");
        bt_paste.setBounds(240, 200, 80, 20);
        panels[0].add(bt_paste);

        bt_reset = new JButton("Reset");
        bt_reset.addActionListener(mem);
        bt_reset.setActionCommand("reset");
        bt_reset.setBounds(320, 200, 80, 20);
        panels[0].add(bt_reset);

        JLabel polymorph_label = new JLabel("�ϐg");
        polymorph_label.setBounds(420+60, 200, 100, 20);
        panels[0].add(polymorph_label);
        cb_morph_type = new JComboBox();
        cb_morph_type.addItem("��/������");
        cb_morph_type.addItem("���@����");
        cb_morph_type.setBounds(420+60 + 80, 200, 80, 20);
        cb_morph_type.addActionListener(this);
        panels[0].add(cb_morph_type);

        JLabel polymorph_level_label = new JLabel("�ϐg���x��");
        polymorph_level_label.setBounds(420+60 + 200, 200, 100, 20);
        panels[0].add(polymorph_level_label);
        cb_morph_level = new JComboBox();
        cb_morph_level.addItem("����");     //0
        cb_morph_level.addItem("1");        //1
        cb_morph_level.addItem("15");       //2
        cb_morph_level.addItem("30");       //3
        cb_morph_level.addItem("45");       //4
        cb_morph_level.addItem("50");       //5
        cb_morph_level.addItem("52");       //6
        cb_morph_level.addItem("55");       //7
        cb_morph_level.addItem("60");       //8
        cb_morph_level.addItem("65");       //9
        cb_morph_level.addItem("70");       //10
        cb_morph_level.addItem("75");       //11
        cb_morph_level.addItem("80");       //12
        cb_morph_level.addItem("82");       //13
        cb_morph_level.addItem("84");       //14
        cb_morph_level.addItem("90");       //15
        cb_morph_level.addItem("Hero");     //�����_�ł�16

        cb_morph_level.setBounds(420+60 + 280, 200, 80, 20);
        cb_morph_level.addActionListener(this);
        panels[0].add(cb_morph_level);

        lab_tmp = new JLabel("�U�����x");
        lab_tmp.setBounds(420+60, 200 + 20, 200, 20);
        panels[0].add(lab_tmp);
        tf_speed = new JTextField();
        tf_speed.setBounds(500+60, 200 + 20, 80, 20);
        tf_speed.addActionListener(this);
        panels[0].add(tf_speed);

        lab_tmp = new JLabel("�{��");
        lab_tmp.setBounds(420+60, 200 + 40, 200, 20);
        panels[0].add(lab_tmp);
        tf_acc = new JTextField();
        tf_acc.setBounds(500+60, 200 + 40, 80, 20);
        tf_acc.addActionListener(this);
        panels[0].add(tf_acc);

        lab_tmp = new JLabel("�U��");
        lab_tmp.setBounds(620+60, 200 + 20, 200, 20);
        panels[0].add(lab_tmp);
        tf_magic_speed_main = new JTextField();
        tf_magic_speed_main.setBounds(700+60, 200 + 20, 80, 20);
        tf_magic_speed_main.addActionListener(this);
        panels[0].add(tf_magic_speed_main);

        lab_tmp = new JLabel("�▂");
        lab_tmp.setBounds(620+60, 200 + 40, 200, 20);
        panels[0].add(lab_tmp);
        tf_magic_speed_sub = new JTextField();
        tf_magic_speed_sub.setBounds(700+60, 200 + 40, 80, 20);
        tf_magic_speed_sub.addActionListener(this);
        panels[0].add(tf_magic_speed_sub);

        cb_speed_auto = new JCheckBox("��������");
        cb_speed_auto.setSelected(true);
        cb_speed_auto.setBounds(420+60 + 280, 200 + 60, 80, 20);
        panels[0].add(cb_speed_auto);
        cb_speed_auto.addActionListener(this);

        lab_sp_rate = new JLabel("�������");
        lab_sp_sub = new JLabel("");
        lab_mag_rate = new JLabel("���@������");
        lab_mag_delay = new JLabel("���@�f�B���C");
        lab_mag_power = new JLabel("���@�З�");
        tf_buki_sp_rate = new JTextField("0");
        tf_mag_rate = new JTextField("0.0");
        tf_mag_delay = new JTextField("0.0");
        tf_mag_power = new JTextField("0.0");
        tf_buki_sp_rate.setText("0.0");
        tf_mag_rate.setText("0.0");
        tf_mag_delay.setText("0.0");
        tf_mag_power.setText("0.0");
        lab_sp_rate.setBounds(420+60, 300, 100, 20);
        lab_sp_sub.setBounds(420+60 + 160, 300, 40, 20);
        lab_mag_rate.setBounds(420+60, 300 + 20, 100, 20);
        lab_mag_delay.setBounds(420+60 + 200, 300, 100, 20);
        lab_mag_power.setBounds(420+60 + 200, 300 + 20, 100, 20);
        tf_buki_sp_rate.setBounds(420+60 + 80, 300, 80, 20);
        tf_mag_rate.setBounds(420+60 + 80, 300 + 20, 80, 20);
        tf_mag_delay.setBounds(420+60 + 280, 300, 80, 20);
        tf_mag_power.setBounds(420+60 + 280, 300 + 20, 80, 20);
        panels[0].add(lab_sp_rate);
        panels[0].add(tf_buki_sp_rate);
        panels[0].add(lab_sp_sub);
        panels[0].add(lab_mag_rate);
        panels[0].add(tf_mag_rate);
        panels[0].add(lab_mag_delay);
        panels[0].add(tf_mag_delay);
        panels[0].add(lab_mag_power);
        panels[0].add(tf_mag_power);
        tf_buki_sp_rate.addActionListener(this);
        tf_mag_rate.addActionListener(this);
        tf_mag_delay.addActionListener(this);
        tf_mag_power.addActionListener(this);

        cb_mag_auto = new JCheckBox("��������");
        cb_mag_auto.setSelected(true);
        cb_mag_auto.setBounds(420+60 + 280, 300 + 40, 80, 20);
        panels[0].add(cb_mag_auto);
        cb_mag_auto.addActionListener(this);

        lab_tmp = new JLabel("���@�g�p");
        lab_tmp.setBounds(420+60, 380, 80, 20);
        cb_magic = new WideComboBox();
        cb_magic.addItem("");
        cb_magic.setSelectedIndex(0);
        cb_magic.addActionListener(this);
        cb_magic.setBounds(420+60 + 80, 380, 80, 20);
        panels[0].add(lab_tmp);
        panels[0].add(cb_magic);

        lab_tmp = new JLabel("�d��");
        lab_tmp.setBounds(420+60, 380 + 20, 150, 20);
        panels[0].add(lab_tmp);
        lab_tmp = new JLabel("�����\��");
        lab_tmp.setBounds(620+60, 380 + 10, 80, 20);
        panels[0].add(lab_tmp);
        tf_weight = new JTextField();
        tf_weight.setBounds(700+60, 380, 80, 20);
        tf_weight.setHorizontalAlignment(SwingConstants.CENTER);
        tf_weight.setEditable(false);
        panels[0].add(tf_weight);
        tf_weight2 = new JTextField();
        tf_weight2.setBounds(700+60, 380 + 20, 80, 20);
        tf_weight2.setHorizontalAlignment(SwingConstants.CENTER);
        tf_weight2.setEditable(false);
        panels[0].add(tf_weight2);

        String[] w_list = {"33 %", "50 %", "66 %", "82 %"};
        cb_weight = new JComboBox(w_list);
        cb_weight.setBounds(500+60, 380 + 20, 80, 20);
        cb_weight.addActionListener(this);
        panels[0].add(cb_weight);

//        cb_weight_auto = new JCheckBox("��������");
//        cb_weight_auto.setSelected(true);
//        cb_weight_auto.setBounds(420 + 280, 380 + 25 + 20, 80, 25);
//        panels[0].add(cb_weight_auto);
//        cb_weight_auto.addActionListener(this);
        lab_tmp = new JLabel("������R");
        lab_tmp.setBounds(420+60, 520, 100, 20);
        panels[0].add(lab_tmp);
        
        lab_tmp = new JLabel("����/�ϐ�");
        lab_tmp.setBounds(420+60, 440, 100, 20);
        panels[0].add(lab_tmp);

        //���������Ƒ����ϐ��̕\��
        for (int i = 0, cnt = 0; i < ELEM_LIST.length; i++, cnt++) {
            lab_elem[i] = new JLabel();
            //��100����120�֕ύX
            lab_elem[i].setBounds(420+60 + 80 + 120 * (cnt % 2), 520 + 20 * (cnt / 2), 100, 20);
            panels[0].add(lab_elem[i]);
        }
        //�Z�p/����/��Z/���|�����ƋZ�p/����/��Z/���|�ϐ��̕\��
//        for (int i = 0; i < AILMENT_LIST.length; i++) {
//            lab_ailment[i] = new JLabel();
//            lab_ailment[i].setBounds(420 + 60 + 80 * (i % 4), 460 + 20 + 20 * (i / 4), 100, 20);
//            panels[0].add(lab_ailment[i]);
//        }

        for (int i = 0, cnt = 0; i < AILMENT_LIST.length; i++, cnt++) {
            lab_ailment[i] = new JLabel();
            //��100����120�֕ύX
            lab_ailment[i].setBounds(420+60 + 80 + 120 * (cnt % 2), 440 + 20 * (cnt / 2), 100, 20);
            panels[0].add(lab_ailment[i]);

        //�\���ʒu��1�E�ɂ��炷�ꍇ�Ɏg�p
        //            if (i == 3) {
        //                cnt++;
        //            }

        }
            
        //----------
        //�p�l��1
        //----------
        for (int i = 0; i < ST_LIST.length; i++) {
        //�����ݒ肾��CHA���܂߂ĕ\�� (ST_LIST.length -1)�ɂ��邱�Ƃɂ��for�����X�e-1�񕪂̕\���ƂȂ�CHA�͕\������Ȃ�
        //for (int i = 0; i < (ST_LIST.length -1); i++) {
            JLabel lab4 = new JLabel(ST_LIST[i], SwingConstants.CENTER);
            lab4.setBounds(30 + 150 * i, 195, 100, 20);
            panels[1].add(lab4);
        }
        //pure_status_bonus[0][0]����[0][24]�܂ł̓o�^�@192�s�ōő吔�w��
        pure_status_bonus[0][0] = new JLabel("�ߋ����_���[�W");
        pure_status_bonus[0][1] = new JLabel("�ߋ�������");
        pure_status_bonus[0][2] = new JLabel("�ߋ����N���e�B�J��");
        pure_status_bonus[0][3] = new JLabel("�ő及���d��");
        pure_status_bonus[0][4] = new JLabel("");

        pure_status_bonus[0][5] = new JLabel("�������_���[�W");
        pure_status_bonus[0][6] = new JLabel("����������");
        pure_status_bonus[0][7] = new JLabel("�������N���e�B�J��");
        pure_status_bonus[0][8] = new JLabel("�����h���(AC)");
        pure_status_bonus[0][9] = new JLabel("����������(ER)");

        pure_status_bonus[0][10] = new JLabel("���@�_���[�W");
        pure_status_bonus[0][11] = new JLabel("���@����");
        pure_status_bonus[0][12] = new JLabel("���@�N���e�B�J��");
        pure_status_bonus[0][13] = new JLabel("���@�{�[�i�X(MB)");
        pure_status_bonus[0][14] = new JLabel("MP�����");

        pure_status_bonus[0][15] = new JLabel("LV�A�b�v��MP����");
        pure_status_bonus[0][16] = new JLabel("MP��(Tick)");
        pure_status_bonus[0][17] = new JLabel("MP�|�[�V������");
        pure_status_bonus[0][18] = new JLabel("���@�h���(MR)");
        pure_status_bonus[0][19] = new JLabel("");

        pure_status_bonus[0][20] = new JLabel("LV�A�b�v��HP����");
        pure_status_bonus[0][21] = new JLabel("HP��(Tick)");
        pure_status_bonus[0][22] = new JLabel("HP�|�[�V������");
        pure_status_bonus[0][23] = new JLabel("�ő及���d��");
        pure_status_bonus[0][24] = new JLabel("");

        pure_status_bonus[0][25] = new JLabel("");
        pure_status_bonus[0][26] = new JLabel("");
        pure_status_bonus[0][27] = new JLabel("");
        pure_status_bonus[0][28] = new JLabel("");
        pure_status_bonus[0][29] = new JLabel("");

        for (int i = 0; i < pure_status_bonus[0].length; i++) {

            pure_status_bonus[1][i] = new JLabel("0");
            pure_status_bonus[0][i].setBounds(30 + 150 * (i / 5), 220 + 20 * (i % 5), 100, 20);
            pure_status_bonus[1][i].setBounds(130 + 150 * (i / 5), 220 + 20 * (i % 5), 50, 20);
            if (pure_status_bonus[0][i].getText().isEmpty()) {
                continue;
            }
            panels[1].add(pure_status_bonus[0][i]);
            panels[1].add(pure_status_bonus[1][i]);
        }

        lev.put(panels[1], 0, 330);
        lev.addActionListener(this);
        lev.setSelfCheck();

//�G���N�T�[
        lab_tmp = new JLabel("�G���N�T�[");
        lab_tmp.setBounds(30, 480, 100, 20);
        panels[1].add(lab_tmp);

        String elixir_list[] = {"---", "STR", "DEX", "INT", "WIS", "CON", "CHA"};
        //for (int i = 0; i < 10; i++) {                                                //�ő�10�܂Ŏg�p
        for (int i = 0; i < 20; i++) {                                                  //�ő�20�܂Ŏg�p
            if (i >= 17) {
                cb_elixir[i] = new JComboBox(elixir_list);
                cb_elixir_level[i] = new JComboBox(lev_list);
                cb_elixir[i].setBounds(30 +60 * i-300, 540, 60, 20);
                cb_elixir[i].addActionListener(this);
                cb_elixir_level[i].setBounds(30 + 60 * i-300, 560, 60, 20);
                cb_elixir_level[i].setSelectedItem(Integer.toString(100));              //50���x������3���x���P��
                cb_elixir_level[i].addActionListener(this);
                }
            else if (i >= 10) {
                cb_elixir[i] = new JComboBox(elixir_list);
                cb_elixir_level[i] = new JComboBox(lev_list);
                cb_elixir[i].setBounds(30 +60 * i-300, 540, 60, 20);
                cb_elixir[i].addActionListener(this);
                cb_elixir_level[i].setBounds(30 + 60 * i-300, 560, 60, 20);
                cb_elixir_level[i].setSelectedItem(Integer.toString(50 + 3 * i));       //50���x������3���x���P��
                cb_elixir_level[i].addActionListener(this);
                }
            else {
                cb_elixir[i] = new JComboBox(elixir_list);
                cb_elixir_level[i] = new JComboBox(lev_list);
                cb_elixir[i].setBounds(30 +60 * i, 500, 60, 20);
                cb_elixir[i].addActionListener(this);
                cb_elixir_level[i].setBounds(30 + 60 * i, 520, 60, 20);
                //cb_elixir_level[i].setSelectedItem(Integer.toString(50 + 5 * i));     //50���x������5���x���P��
                cb_elixir_level[i].setSelectedItem(Integer.toString(50 + 3 * i));       //50���x������3���x���P��
                cb_elixir_level[i].addActionListener(this);
                }
            panels[1].add(cb_elixir[i]);
            panels[1].add(cb_elixir_level[i]);
        }
        //----------
        //�p�l��2
        //----------
        int row = 0;
        int col = 0;

        lab_tmp = new JLabel("��{");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        //1�i���� 
        cb_buff[ACC1] = new JCheckBox("1�i����");
        cb_buff[ACC1].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ACC1].addActionListener(this);
        panels[2].add(cb_buff[ACC1]);

        //2�i����
        String list_acc2[] = {"x1.3333", "x1.1547", "x1.0800"};
        cb_buff_group[ACC2] = new WideComboBox(list_acc2);
        cb_buff_group[ACC2].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[ACC2].addActionListener(this);
        panels[2].add(cb_buff_group[ACC2]);
        cb_buff[ACC2] = new JCheckBox("2�i����");
        cb_buff[ACC2].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ACC2].addActionListener(this);
        panels[2].add(cb_buff[ACC2]);

        //3�i����
        cb_buff[ACC3] = new JCheckBox("3�i����");
        cb_buff[ACC3].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ACC3].addActionListener(this);
        panels[2].add(cb_buff[ACC3]);

        //4�i����
        cb_buff[ACC4] = new JCheckBox("4�i����");
        cb_buff[ACC4].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ACC4].addActionListener(this);
        panels[2].add(cb_buff[ACC4]);

        //5�i����
        cb_buff[ACC5] = new JCheckBox("5�i����");
        cb_buff[ACC5].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ACC5].addActionListener(this);
        panels[2].add(cb_buff[ACC5]);

        //STR
        String list_str[] = {"+3", "+5", "+6", "+7"};
        cb_buff_group[B_STR] = new WideComboBox(list_str);
        cb_buff_group[B_STR].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[B_STR].setSelectedIndex(1);                               //2�Ԗڂ�"+5"���W���őI�������
        cb_buff_group[B_STR].addActionListener(this);
        panels[2].add(cb_buff_group[B_STR]);
        cb_buff[B_STR] = new JCheckBox("STR");
        cb_buff[B_STR].setBounds(0, 20 * col++, 100, 20);
        cb_buff[B_STR].addActionListener(this);
        panels[2].add(cb_buff[B_STR]);

        //DEX
        String list_dex[] = {"+3", "+5", "+6", "+7"};
        cb_buff_group[B_DEX] = new WideComboBox(list_dex);
        cb_buff_group[B_DEX].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[B_DEX].setSelectedIndex(1);                               //2�Ԗڂ�"+5"���W���őI�������
        cb_buff_group[B_DEX].addActionListener(this);
        panels[2].add(cb_buff_group[B_DEX]);
        cb_buff[B_DEX] = new JCheckBox("DEX");
        cb_buff[B_DEX].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[B_DEX].addActionListener(this);
        panels[2].add(cb_buff[B_DEX]);

        //AC
        String list_ac[] = {"-2", "-4", "-5", "-10"};
        cb_buff_group[B_AC] = new WideComboBox(list_ac);
        cb_buff_group[B_AC].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[B_AC].addActionListener(this);
        panels[2].add(cb_buff_group[B_AC]);
        cb_buff[B_AC] = new JCheckBox("AC");
        cb_buff[B_AC].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[B_AC].addActionListener(this);
        panels[2].add(cb_buff[B_AC]);

        //�ǉ��_���[�W���@
        String list_buki[] = {"�L���� +1 HIT+1", "�L���� +2", "�L���� +2 HIT+2", "�L���� +5", "���� +1 HIT+1", "���� +2", "���� +2 HIT+2", "���� +5"};
        cb_buff_group[BUKI] = new WideComboBox(list_buki);
        cb_buff_group[BUKI].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[BUKI].setSelectedIndex(2);
        cb_buff_group[BUKI].addActionListener(this);
        panels[2].add(cb_buff_group[BUKI]);
        cb_buff[BUKI] = new JCheckBox("�L����/����");
        cb_buff[BUKI].setBounds(0, 20 * col++, 100, 20);
        cb_buff[BUKI].addActionListener(this);
        panels[2].add(cb_buff[BUKI]);

        //�Z�L�����e�B�T�[�r�X�ǉ��I�v�V����
        cb_buff[SEC] = new JCheckBox("�Z�L�����e�B");
        cb_buff[SEC].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[SEC].addActionListener(this);
        panels[2].add(cb_buff[SEC]);

        //VIP�J�[�h
        String list_vip[] = {"Red", "Gold", "Platinum"};
        cb_buff_group[VIP] = new WideComboBox(list_vip);
        cb_buff_group[VIP].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[VIP].addActionListener(this);
        panels[2].add(cb_buff_group[VIP]);
        cb_buff[VIP] = new JCheckBox("VIP");
        cb_buff[VIP].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[VIP].addActionListener(this);
        panels[2].add(cb_buff[VIP]);

        //�h���S���̏j��
        String list_DRAGON_BLESS[] = {"�j��", "����"};
        cb_buff_group[DRAGON_BLESS] = new WideComboBox(list_DRAGON_BLESS);
        cb_buff_group[DRAGON_BLESS].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[DRAGON_BLESS].addActionListener(this);
        panels[2].add(cb_buff_group[DRAGON_BLESS]);
        cb_buff[DRAGON_BLESS] = new JCheckBox("�h���S����");
        cb_buff[DRAGON_BLESS].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[DRAGON_BLESS].addActionListener(this);
        panels[2].add(cb_buff[DRAGON_BLESS]);

        col = 0;
        row = 1;

        lab_tmp = new JLabel("���̑�");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        //���͉񕜃|�[�V����(���͉񕜃|�[�V����/�Ñ�̖��͉񕜃|�[�V����/�_��̔Z�k�}�i�|�[�V����)
        cb_buff[ITEM_BLUE] = new JCheckBox("���͉񕜃|�[�V����");
        cb_buff[ITEM_BLUE].setBounds(200 * row, 20 * col++, 200, 20); 
        cb_buff[ITEM_BLUE].addActionListener(this);
        panels[2].add(cb_buff[ITEM_BLUE]);

        cb_buff[ITEM_WIZP] = new JCheckBox("�E�B�Y�_���|�[�V����");
        cb_buff[ITEM_WIZP].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[ITEM_WIZP].addActionListener(this);
        panels[2].add(cb_buff[ITEM_WIZP]);

        String list_cooking[] = {"�͋����a���X�e�[�L", "�j�����ꂽ�͋����a���X�e�[�L", "�f�������̎ϕt", "�j�����ꂽ�f�������̎ϕt","�������ʒ��Ă�", "�j�����ꂽ�������ʒ��Ă�","�����Ȗ˗���", "�^�S��������������", "�p�^���V�̘a���X�e�[�L", "�p�^���V�̃T�[�����J�i�b�y", "�p�^���V�̎��ʒ��Ă�"};
        cb_buff_group[ITEM_COOKING] = new WideComboBox(list_cooking);
        cb_buff_group[ITEM_COOKING].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[ITEM_COOKING].addActionListener(this);
        panels[2].add(cb_buff_group[ITEM_COOKING]);
        cb_buff[ITEM_COOKING] = new JCheckBox("����");
        cb_buff[ITEM_COOKING].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ITEM_COOKING].addActionListener(this);
        panels[2].add(cb_buff[ITEM_COOKING]);

        String list_dessert[] = {"�C���̌{�X�[�v", "�j�����ꂽ�C���̌{�X�[�v", "���z�̃o�V���X�N�̗��X�[�v", "���z�̃V���[�g�P�[�L", "�����Ȍg�ш���", "�^�S�����������X�[�v", "�p�^���V�̃L�m�R�X�[�v"};
        cb_buff_group[ITEM_DESSERT] = new WideComboBox(list_dessert);
        cb_buff_group[ITEM_DESSERT].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[ITEM_DESSERT].addActionListener(this);
        panels[2].add(cb_buff_group[ITEM_DESSERT]);
        cb_buff[ITEM_DESSERT] = new JCheckBox("�X�[�v");
        cb_buff[ITEM_DESSERT].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ITEM_DESSERT].addActionListener(this);
        panels[2].add(cb_buff[ITEM_DESSERT]);

        String list_breeze[] = {"�����̃|�[�V����", "�ґz�̃|�[�V����", "�����̃|�[�V����", "���@�̃|�[�V����",
            "���@��R�̃|�[�V����", "�p�m�̃|�[�V����", "���m�̃|�[�V����"};
        cb_buff_group[ITEM_BREEZE] = new WideComboBox(list_breeze);
        cb_buff_group[ITEM_BREEZE].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[ITEM_BREEZE].addActionListener(this);
        panels[2].add(cb_buff_group[ITEM_BREEZE]);
        cb_buff[ITEM_BREEZE] = new JCheckBox("�����̗�");
        cb_buff[ITEM_BREEZE].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ITEM_BREEZE].addActionListener(this);
        panels[2].add(cb_buff[ITEM_BREEZE]);

        String list_sea[] = {"�h���S���̐�", "���{�̃|�[�V����", "�W���̃|�[�V����", "�r�͂̃|�[�V����",
            "�@�q�̃|�[�V����", "�̗͂̃|�[�V����", "�m�͂̃|�[�V����", "���_�̃|�[�V����", "���m�̐퓬�����X�N���[��", "�ˎ�̐퓬�����X�N���[��", "���҂̐퓬�����X�N���[��"};
        cb_buff_group[ITEM_SEA] = new WideComboBox(list_sea);
        cb_buff_group[ITEM_SEA].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[ITEM_SEA].addActionListener(this);
        panels[2].add(cb_buff_group[ITEM_SEA]);
        cb_buff[ITEM_SEA] = new JCheckBox("�[�C�̗�");
        cb_buff[ITEM_SEA].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ITEM_SEA].addActionListener(this);
        panels[2].add(cb_buff[ITEM_SEA]);

        String list_md[] = {"�J�J�V", "�E�F�A�E���t", "�N���X�^�V�A��", "�X�g�[���S�[����", "�C�G�e�B", "�o�O�x�A�[",
            "�����@�S�[����", "�X�m�[�}��", "�R�J�g���X", "�T�L���o�X", "�G���_�[", "�}�[���C�h",
            "�_�C�A�S�[����","�j�����ꂽ�_�C�A�S�[����", "�h���C�N", "�j�����ꂽ�h���C�N", "�L���O�o�O�x�A�[", "�j�����ꂽ�L���O�o�O�x�A�[",
            "�T�L���o�X�N�C�[��", "�j�����ꂽ�T�L���o�X�N�C�[��", "�u���b�N�G���_�[", "�j�����ꂽ�u���b�N�G���_�[", "�A�[�X�W���C�A���g", "�j�����ꂽ�A�[�X�W���C�A���g",
            "�T�C�N���v�X", "�j�����ꂽ�T�C�N���v�X", "�i�C�g�o���h", "�j�����ꂽ�i�C�g�o���h", "�A�C���X", "�j�����ꂽ�A�C���X", "�o���p�C�A", "�j�����ꂽ�o���p�C�A", "�V�A�[", "�j�����ꂽ�V�A�[", "���b�`", "�j�����ꂽ���b�`",
            "�f�X�i�C�g", "�j�����ꂽ�f�X�i�C�g", "�f�[����", "�j�����ꂽ�f�[����", "�o�����J", "�j�����ꂽ�o�����J", "�J�[�c", "�j�����ꂽ�J�[�c", "�o�t�H���b�g", "�j�����ꂽ�o�t�H���b�g", "�}�~�[���[�h", "�j�����ꂽ�}�~�[���[�h",
            "�A�C�X�N�C�[��", "�j�����ꂽ�A�C�X�N�C�[��", "��", "�j�����ꂽ��", "�o���p�I", "�j�����ꂽ�o���p�I", 
            "�A���^���X", "�p�v���I��", "�����h�r�I��", "���@���J�X",
            "�n���p�X","�A�E���L�A","�x�q���X",
            "�V�[�_���T�[", "�X�p���g�C", "���~�A", "�X�m�[�}��(�ۋ�)", "�O��������",
            "�u���[�g", "�u���[�g(�w�͂���)", "�u���[�g(����)", "�u���[�g(������)", "�u���[�g(����)",
            "�u���[�g(ῂ���)", "�W���C�A���g", "�W���C�A���g(�w�͂���)", "�W���C�A���g(����)",
            "�W���C�A���g(������)", "�W���C�A���g(����)", "�W���C�A���g(ῂ���)",
            "�p�b�N/�p�I(0�i�K)", "�p�b�N/�p�I(1�i�K)", "�p�b�N/�p�I(2�i�K)", "�p�b�N/�p�I(3�i�K)"};
        cb_buff_group[ITEM_MD] = new WideComboBox(list_md);
        cb_buff_group[ITEM_MD].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[ITEM_MD].addActionListener(this);
        panels[2].add(cb_buff_group[ITEM_MD]);
        cb_buff[ITEM_MD] = new JCheckBox("�}�W�b�N�h�[��");
        cb_buff[ITEM_MD].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ITEM_MD].addActionListener(this);
        panels[2].add(cb_buff[ITEM_MD]);

        String list_md_op[] = {"AC-2", "AC-4", "AC-5/DR+2",
            "AC-1/MR+1", "AC-3/MR+5", "AC-5/MR+10",
            "MPR+1(����)", "MPR+3(����)", "MPR+7(����)",
            "MPR+1(�񓯊�)", "MPR+3(�񓯊�)", "MPR+7(�񓯊�)",
            "HP+10/MP+10", "HP+35/MP+35", "HP+60/MP+60",
            "�ߋ�������+1/����������+1", "�ߋ�������+2/����������+2", "�ߋ�������+4/����������+4"};
        cb_buff_group[ITEM_MD_OP] = new WideComboBox(list_md_op);
        cb_buff_group[ITEM_MD_OP].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[ITEM_MD_OP].addActionListener(this);
        panels[2].add(cb_buff_group[ITEM_MD_OP]);
        cb_buff[ITEM_MD_OP] = new JCheckBox("�p�b�N/�p�I OP");
        cb_buff[ITEM_MD_OP].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ITEM_MD_OP].addActionListener(this);
        panels[2].add(cb_buff[ITEM_MD_OP]);

        String list_md_op2[] = {
//���
            "�ߋ����N���e�B�J��+1%", "�������N���e�B�J��+1%", "���@�N���e�B�J��+1%", "�ߋ����_���[�W+1", "�������_���[�W+1",
            "�ߋ�������+1", "����������+1", "�_���[�W����+1", "AC-1", "MR+3%",
            "�ő�HP+30", "�ő�MP+20", "PVP�ǉ��_���[�W+1", "PVP�_���[�W����+1", "�΂̑�����R+10",
            "�n�̑�����R+10", "���̑�����R+10", "���̑�����R+10", "�����d�ʑ���+100(������)",
//����
            "�ߋ����N���e�B�J��+3%", "�������N���e�B�J��+3%", "���@�N���e�B�J��+3%","�ߋ����_���[�W+2", "�������_���[�W+2",
            "�ߋ�������+2", "����������+2", "�_���[�W����+2", "AC-2", "MR+6%",
            "�ő�HP+60", "�ő�MP+40", "�ߋ������(DG)+3", "HP��Ή�+30(32�b)(������)", "MP��Ή�+10(64�b)(������)",
            "���������(ER)+3", "PVP�ǉ��_���[�W+2", "PVP�_���[�W����+2", "PVP���@�_���[�W����+2%(������)", "�Z�p�ϐ�+3",
            "����ϐ�+3", "��Z�ϐ�+3", "���|�ϐ�+3", "�΂̑�����R+20", "�n�̑�����R+20",
            "���̑�����R+20", "���̑�����R+20", "STR+1", "DEX+1", "CON+1",
            "WIS+1", "INT+1", "�����d�ʑ���+200(������)",
//��
            "�ߋ����N���e�B�J��+5%", "�������N���e�B�J��+5%", "���@�N���e�B�J��+5%","�ߋ����_���[�W+3", "�������_���[�W+3",
            "�ߋ�������+3", "����������+3", "SP+3", "���@����+3", "�_���[�W����+3",
            "AC-3","MR+10%", "�ő�HP+150", "�ő�MP+100", "�ߋ������(DG)+5",
            "HP��Ή�+50(32�b)(������)", "MP��Ή�+12(64�b)(������)", "���������(ER)+5","PVP�ǉ��_���[�W+3", "PVP�_���[�W����+3",
            "PVP���@�_���[�W����+5%(������)", "�Z�p�ϐ�+5", "����ϐ�+5", "��Z�ϐ�+5", "���|�ϐ�+5",
            "�Z�p����+3", "���얽��+3", "��Z����+3", "���|����+3", "�΂̑�����R+30",
            "�n�̑�����R+30", "���̑�����R+30", "���̑�����R+30", "STR+2", "DEX+2",
            "CON+2", "WIS+2", "INT+2", "�����d�ʑ���+300(������)", "1�i����",
//�p�Y
            "�ߋ����_���[�W+5", "�������_���[�W+5", "�ߋ�������+5", "����������+5", "SP+5",
            "���@����+5", "�_���[�W����+5", "AC-5", "MR+15%", "�ő�HP+300",
            "�ő�MP+200", "�ߋ������(DG)+10", "HP��Ή�+150(32�b)", "MP��Ή�+30(64�b)", "���������(ER)+12",
            "PVP�ǉ��_���[�W+7", "PVP�_���[�W����+7", "PVP���@�_���[�W����+10%(������)", "PVP�_���[�W��������+10(������)", "�Z�p�ϐ�+8",
            "����ϐ�+8", "��Z�ϐ�+8", "���|�ϐ�+8", "�S�Ă̑ϐ�+3", "�Z�p����+5",
            "���얽��+5", "��Z����+5", "���|����+5", "���ׂẴX�L������+3", "���ׂĂ̑�����R+30",
            "STR+3", "DEX+3", "CON+3", "WIS+3", "INT+3",
            "���ׂẴX�e�[�^�X+1(CHA�ȊO)", "MP�z��(����)(������)", "�����d�ʑ���+500(������)",
//�`��
            "PVP�_���[�W��������+40(������)", "�C�~���[�����ʌ���-30%(������)", "���ׂẴX�e�[�^�X+3(CHA�ȊO)", "HP�z��(������)", "MP�z��(������)",
            "�\�E�� �I�u �t���C��(�}�W�b�N�h�[��)����(������)", "�W���b�W�����g(�}�W�b�N�h�[��)����(������)", "�f�B�P�C�|�[�V����(�}�W�b�N�h�[��)����(������)", "4�i�K����(������)", "1�i�K/3�i�K����(������)", "�����d�ʑ���+500(������)"};

        cb_buff_group[ITEM_MD_OP2] = new WideComboBox(list_md_op2);
        cb_buff_group[ITEM_MD_OP2].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[ITEM_MD_OP2].addActionListener(this);
        panels[2].add(cb_buff_group[ITEM_MD_OP2]);
        cb_buff[ITEM_MD_OP2] = new JCheckBox("MD�̐��ݗ�");
        cb_buff[ITEM_MD_OP2].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ITEM_MD_OP2].addActionListener(this);
        panels[2].add(cb_buff[ITEM_MD_OP2]);

        String list_koma[] = {"����3��", "����5��"};
        cb_buff_group[KOMA] = new WideComboBox(list_koma);
        cb_buff_group[KOMA].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[KOMA].addActionListener(this);
        panels[2].add(cb_buff_group[KOMA]);
        cb_buff[KOMA] = new JCheckBox("�R�}�̃G���`��");
        cb_buff[KOMA].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[KOMA].addActionListener(this);
        panels[2].add(cb_buff[KOMA]);

        String list_magan[] = {"�n���̖���","�����̖���","�����̖���","�Η��̖���","�a���̖���","�`��̖���","�����̖���", "�O���������̖���"};
        cb_buff_group[ITEM_MAGAN] = new WideComboBox(list_magan);
        cb_buff_group[ITEM_MAGAN].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[ITEM_MAGAN].addActionListener(this);
        panels[2].add(cb_buff_group[ITEM_MAGAN]);
        cb_buff[ITEM_MAGAN] = new JCheckBox("����");
        cb_buff[ITEM_MAGAN].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[ITEM_MAGAN].addActionListener(this);
        panels[2].add(cb_buff[ITEM_MAGAN]);

        cb_buff[MOMIJI] = new JCheckBox("���݂������O");
        cb_buff[MOMIJI].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[MOMIJI].addActionListener(this);
        panels[2].add(cb_buff[MOMIJI]);

        cb_buff[CLAY] = new JCheckBox("�N���C");
        cb_buff[CLAY].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[CLAY].addActionListener(this);
        panels[2].add(cb_buff[CLAY]);

        cb_buff[BUFF_COIN] = new JCheckBox("�o�t�R�C��");
        cb_buff[BUFF_COIN].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[BUFF_COIN].addActionListener(this);
        panels[2].add(cb_buff[BUFF_COIN]);

        cb_buff[BS_COIN] = new JCheckBox("���ւ̃R�C��");
        cb_buff[BS_COIN].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[BS_COIN].addActionListener(this);
        panels[2].add(cb_buff[BS_COIN]);

        cb_buff[MBSC] = new JCheckBox("�^�S�̂��������j���X�N���[��");
        cb_buff[MBSC].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[MBSC].addActionListener(this);
        panels[2].add(cb_buff[MBSC]);

        String list_hst[] = {"1��", "2��", "3��", "4��", "5��"};
        cb_buff_group[L_HST] = new WideComboBox(list_hst);
        cb_buff_group[L_HST].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[L_HST].addActionListener(this);
        panels[2].add(cb_buff_group[L_HST]);
        cb_buff[L_HST] = new JCheckBox("�����̉ʎ�");
        cb_buff[L_HST].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[L_HST].addActionListener(this);
        panels[2].add(cb_buff[L_HST]);

        String list_H_HP[] = {"HP+50", "HP+100", "HP+200"};
        cb_buff_group[H_HP] = new WideComboBox(list_H_HP);
        cb_buff_group[H_HP].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[H_HP].addActionListener(this);
        panels[2].add(cb_buff_group[H_HP]);
        cb_buff[H_HP] = new JCheckBox("�����̃{�[�i�X");
        cb_buff[H_HP].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[H_HP].addActionListener(this);
        panels[2].add(cb_buff[H_HP]);

        String list_H_AC[] = {"AC-1", "AC-2", "AC-3"};
        cb_buff_group[H_AC] = new WideComboBox(list_H_AC);
        cb_buff_group[H_AC].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[H_AC].addActionListener(this);
        panels[2].add(cb_buff_group[H_AC]);
        cb_buff[H_AC] = new JCheckBox("�S�b�̃{�[�i�X");
        cb_buff[H_AC].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[H_AC].addActionListener(this);
        panels[2].add(cb_buff[H_AC]);

        String list_H_PVPDR[] = {"PVP DR+1", "PVP DR+2"};
        cb_buff_group[H_PVPDR] = new WideComboBox(list_H_PVPDR);
        cb_buff_group[H_PVPDR].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[H_PVPDR].addActionListener(this);
        panels[2].add(cb_buff_group[H_PVPDR]);
        cb_buff[H_PVPDR] = new JCheckBox("�����̃{�[�i�X");
        cb_buff[H_PVPDR].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[H_PVPDR].addActionListener(this);
        panels[2].add(cb_buff[H_PVPDR]);

        String list_H_PVP[] = {"PVP �_��+1", "PVP �_��+2"};
        cb_buff_group[H_PVP] = new WideComboBox(list_H_PVP);
        cb_buff_group[H_PVP].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[H_PVP].addActionListener(this);
        panels[2].add(cb_buff_group[H_PVP]);
        cb_buff[H_PVP] = new JCheckBox("�ÎE�̃{�[�i�X");
        cb_buff[H_PVP].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[H_PVP].addActionListener(this);
        panels[2].add(cb_buff[H_PVP]);

        cb_buff[H_RK] = new JCheckBox("�����J�[�{�[�i�X");
        cb_buff[H_RK].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[H_RK].addActionListener(this);
        panels[2].add(cb_buff[H_RK]);

        cb_buff[H_RKT] = new JCheckBox("�N���X����");
        cb_buff[H_RKT].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[H_RKT].addActionListener(this);
        panels[2].add(cb_buff[H_RKT]);

        //----------
        //�p�l��3
        //----------
        col = 0;
        row = 0;

        lab_tmp = new JLabel("�N�喂�@");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[3].add(lab_tmp);

        //*�g�D���[�^�[�Q�b�g
        cb_buff[P_TTT] = new JCheckBox("*�g�D���[�^�[�Q�b�g");
        cb_buff[P_TTT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[P_TTT].addActionListener(this);
        cb_buff[P_TTT].setEnabled(false);
        panels[3].add(cb_buff[P_TTT]);

        //�O���[�C���O �E�F�|��
        cb_buff[P_GWN] = new JCheckBox("�O���[�C���O �E�F�|��");
        cb_buff[P_GWN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[P_GWN].addActionListener(this);
        panels[3].add(cb_buff[P_GWN]);

        //�V���C�j���O �V�[���h
        String list_P_SSD[] = {"�p��", "PT�����o�["};
        cb_buff_group[P_SSD] = new WideComboBox(list_P_SSD);
        cb_buff_group[P_SSD].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[P_SSD].addActionListener(this);
        panels[3].add(cb_buff_group[P_SSD]);
        cb_buff[P_SSD] = new JCheckBox("�V���C�j���O �V�[���h");
        cb_buff[P_SSD].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[P_SSD].addActionListener(this);
        panels[3].add(cb_buff[P_SSD]);

        //�V���C�j���O �A�[�}�[
        cb_buff[P_SAR] = new JCheckBox("�V���C�j���O �A�[�}�[");
        cb_buff[P_SAR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[P_SAR].addActionListener(this);
        panels[3].add(cb_buff[P_SAR]);

        //�u���C�u �����^��
        cb_buff[P_BML] = new JCheckBox("�u���C�u �����^��");
        cb_buff[P_BML].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[P_BML].addActionListener(this);
        panels[3].add(cb_buff[P_BML]);

        //�}�W�F�X�e�B
        cb_buff[P_MAY] = new JCheckBox("�}�W�F�X�e�B");
        cb_buff[P_MAY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[P_MAY].addActionListener(this);
        panels[3].add(cb_buff[P_MAY]);

        //�O���[�X
        String list_P_GRE[] = {"�N��L80", "�N��L81", "�N��L82", "�N��L83", "�N��L84", "�N��L85","�N��L86","�N��L87","�N��L88","�N��L89","�N��L90","�N��L91","�N��L92","�N��L93","�N��L94+"};
        cb_buff_group[P_GRE] = new WideComboBox(list_P_GRE);
        cb_buff_group[P_GRE].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[P_GRE].addActionListener(this);
        panels[3].add(cb_buff_group[P_GRE]);
        cb_buff[P_GRE] = new JCheckBox("�O���[�X");
        cb_buff[P_GRE].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[P_GRE].addActionListener(this);
        panels[3].add(cb_buff[P_GRE]);

        //*�G���p�C�A
        cb_buff[P_EME] = new JCheckBox("*�G���p�C�A");
        cb_buff[P_EME].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[P_EME].addActionListener(this);
        cb_buff[P_EME].setEnabled(false);
        panels[3].add(cb_buff[P_EME]);

        //�v���C��
        String list_P_PRE[] = {"�p��", "������", "�p��(�U���)", "������(�U���)"};
        cb_buff_group[P_PRE] = new WideComboBox(list_P_PRE);
        cb_buff_group[P_PRE].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[P_PRE].addActionListener(this);
        panels[3].add(cb_buff_group[P_PRE]);
        cb_buff[P_PRE] = new JCheckBox("�v���C��");
        cb_buff[P_PRE].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[P_PRE].addActionListener(this);
        panels[3].add(cb_buff[P_PRE]);

        //*�R�[���N���� �A�h�o���X
        cb_buff[P_CCA] = new JCheckBox("*�R�[���N���� �A�h�o���X");
        cb_buff[P_CCA].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[P_CCA].addActionListener(this);
        cb_buff[P_CCA].setEnabled(false);
        panels[3].add(cb_buff[P_CCA]);

        col++;

        lab_tmp = new JLabel("�p�b�V�u�X�L��");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[3].add(lab_tmp);

        //�I�[��
        cb_buff[P_AUA] = new JCheckBox("�I�[��");
        cb_buff[P_AUA].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[P_AUA].addActionListener(this);
        panels[3].add(cb_buff[P_AUA]);

        col = 0;
        row = 1;

        lab_tmp = new JLabel("�R�m�̋Z�p");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[3].add(lab_tmp);

        //*�V���b�N �X�^��
        cb_buff[K_SSN] = new JCheckBox("*�V���b�N �X�^��");
        cb_buff[K_SSN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_SSN].addActionListener(this);
        cb_buff[K_SSN].setEnabled(false);
        panels[3].add(cb_buff[K_SSN]);

        //���_�N�V�����A�[�}�[
        cb_buff[K_RAR] = new JCheckBox("���_�N�V�����A�[�}�[");
        cb_buff[K_RAR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_RAR].addActionListener(this);
        panels[3].add(cb_buff[K_RAR]);

       //�o�E���X�A�^�b�N
        cb_buff[K_BOK] = new JCheckBox("�o�E���X�A�^�b�N");
        cb_buff[K_BOK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_BOK].addActionListener(this);
        panels[3].add(cb_buff[K_BOK]);

        //�u���[ �A�^�b�N
        cb_buff[K_BLK] = new JCheckBox("�u���[ �A�^�b�N");
        cb_buff[K_BLK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_BLK].addActionListener(this);
        panels[3].add(cb_buff[K_BLK]);

        //*�J�E���^�[�o���A
        cb_buff[K_CBR] = new JCheckBox("*�J�E���^�[�o���A");
        cb_buff[K_CBR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_CBR].addActionListener(this);
        cb_buff[K_CBR].setEnabled(false);
        panels[3].add(cb_buff[K_CBR]);

        //*�A�u�\���[�g �u���C�h
        cb_buff[K_ABE] = new JCheckBox("*�A�u�\���[�g �u���C�h");
        cb_buff[K_ABE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_ABE].addActionListener(this);
        cb_buff[K_ABE].setEnabled(false);
        panels[3].add(cb_buff[K_ABE]);

        //*�t�H�[�X �X�^��
        cb_buff[K_FSN] = new JCheckBox("*�t�H�[�X �X�^��");
        cb_buff[K_FSN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_FSN].addActionListener(this);
        cb_buff[K_FSN].setEnabled(false);
        panels[3].add(cb_buff[K_FSN]);

        col++;

        lab_tmp = new JLabel("�p�b�V�u�X�L��");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[3].add(lab_tmp);

        //*�J�E���^�[ �o���A:�x�e����
        cb_buff[K_CBV] = new JCheckBox("*�J�E���^�[ �o���A:�x�e����");
        cb_buff[K_CBV].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_CBV].addActionListener(this);
        cb_buff[K_CBV].setEnabled(false);
        panels[3].add(cb_buff[K_CBV]);

        //���_�N�V���� �A�[�}�[:�x�e����
        cb_buff[K_RAV] = new JCheckBox("���_�N�V���� �A�[�}�[:�x�e����");
        cb_buff[K_RAV].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_RAV].addActionListener(this);
        panels[3].add(cb_buff[K_RAV]);

        //���C�W���O �t�H�[�X
        cb_buff[K_RFE] = new JCheckBox("���C�W���O �t�H�[�X");
        cb_buff[K_RFE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_RFE].addActionListener(this);
        panels[3].add(cb_buff[K_RFE]);

        //�\���b�h�L�����b�W
        cb_buff[K_SCE] = new JCheckBox("�\���b�h�L�����b�W");
        cb_buff[K_SCE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_SCE].addActionListener(this);
        panels[3].add(cb_buff[K_SCE]);

        //�v���C�h
        cb_buff[K_PRE] = new JCheckBox("�v���C�h");
        cb_buff[K_PRE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_PRE].addActionListener(this);
        panels[3].add(cb_buff[K_PRE]);

        col++;

        //*�V���b�N �A�^�b�N
        cb_buff[K_SAK] = new JCheckBox("*[UP��]�V���b�N �A�^�b�N");
        cb_buff[K_SAK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_SAK].addActionListener(this);
        cb_buff[K_SAK].setEnabled(false);
        panels[3].add(cb_buff[K_SAK]);

        //*���C�W���O �E�F�|��
        cb_buff[K_RWN] = new JCheckBox("*[UP��]���C�W���O �E�F�|��");
        cb_buff[K_RWN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_RWN].addActionListener(this);
        cb_buff[K_RWN].setEnabled(false);
        panels[3].add(cb_buff[K_RWN]);

        //*�J�E���^�[�o���A:�}�X�^�[
        cb_buff[K_CBM] = new JCheckBox("*[UP��]�J�E���^�[�o���A:�}�X�^�[");
        cb_buff[K_CBM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[K_CBM].addActionListener(this);
        cb_buff[K_CBM].setEnabled(false);
        panels[3].add(cb_buff[K_CBM]);

        col = 0;
        row = 2;

        lab_tmp = new JLabel("���얂�@(����)");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[3].add(lab_tmp);

        //���W�X�g �}�W�b�N
        cb_buff[E_RMC] = new JCheckBox("���W�X�g �}�W�b�N");
        cb_buff[E_RMC].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_RMC].addActionListener(this);
        panels[3].add(cb_buff[E_RMC]);

        //*�{�f�B �g�D �}�C���h
        cb_buff[E_BTM] = new JCheckBox("*�{�f�B �g�D �}�C���h");
        cb_buff[E_BTM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_BTM].addActionListener(this);
        cb_buff[E_BTM].setEnabled(false);
        panels[3].add(cb_buff[E_BTM]);

        //*�e���|�[�g �g�D �}�U�[
        cb_buff[E_TTM] = new JCheckBox("*�e���|�[�g �g�D �}�U�[");
        cb_buff[E_TTM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_TTM].addActionListener(this);
        cb_buff[E_TTM].setEnabled(false);
        panels[3].add(cb_buff[E_TTM]);

        //*�g���v�� �A���[
        cb_buff[E_TAW] = new JCheckBox("*�g���v�� �A���[");
        cb_buff[E_TAW].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_TAW].addActionListener(this);
        cb_buff[E_TAW].setEnabled(false);
        panels[3].add(cb_buff[E_TAW]);

        //�N���A�[ �}�C���h
        cb_buff[E_CMD] = new JCheckBox("�N���A�[ �}�C���h");
        cb_buff[E_CMD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_CMD].addActionListener(this);
        panels[3].add(cb_buff[E_CMD]);

        //*���^�[�� �g�D �l�C�`���[
        cb_buff[E_RTN] = new JCheckBox("*���^�[�� �g�D �l�C�`���[");
        cb_buff[E_RTN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_RTN].addActionListener(this);
        cb_buff[E_RTN].setEnabled(false);
        panels[3].add(cb_buff[E_RTN]);

        //�G�������^�� �v���e�N�V����
        String list_E_EPN[] = {"�΃G���t", "���G���t", "���G���t", "�n�G���t", "��*���G���t", "��*���G���t", "��*�n�G���t", "��*���G���t", "��*�n�G���t", "��*�n�G���t"};
        cb_buff_group[E_EPN] = new WideComboBox(list_E_EPN);
        cb_buff_group[E_EPN].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[E_EPN].addActionListener(this);
        panels[3].add(cb_buff_group[E_EPN]);
        cb_buff[E_EPN] = new JCheckBox("�G�������^�� �v���e�N�V����");
        cb_buff[E_EPN].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[E_EPN].addActionListener(this);
        panels[3].add(cb_buff[E_EPN]);

        //*�G�������^�� �t�H�[���_�E��
        cb_buff[E_EFN] = new JCheckBox("*�G�������^�� �t�H�[���_�E��");
        cb_buff[E_EFN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_EFN].addActionListener(this);
        cb_buff[E_EFN].setEnabled(false);
        panels[3].add(cb_buff[E_EFN]);

        //*�C���[�X �}�W�b�N
        cb_buff[E_EMC] = new JCheckBox("*�C���[�X �}�W�b�N");
        cb_buff[E_EMC].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_EMC].addActionListener(this);
        cb_buff[E_EMC].setEnabled(false);
        panels[3].add(cb_buff[E_EMC]);

        //*�T���� ���b�T�[�G�������^��
        cb_buff[E_SLE] = new JCheckBox("*�T���� ���b�T�[�G�������^��");
        cb_buff[E_SLE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_SLE].addActionListener(this);
        cb_buff[E_SLE].setEnabled(false);
        panels[3].add(cb_buff[E_SLE]);

        //�G������ �O�����B�e�B�[
        cb_buff[E_ELY] = new JCheckBox("�G������ �O�����B�e�B�[");
        cb_buff[E_ELY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_ELY].addActionListener(this);
        panels[3].add(cb_buff[E_ELY]);

        //*�G���A �T�C�����X
        cb_buff[E_ASE] = new JCheckBox("*�G���A �T�C�����X");
        cb_buff[E_ASE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_ASE].addActionListener(this);
        cb_buff[E_ASE].setEnabled(false);
        panels[3].add(cb_buff[E_ASE]);

        //*�O���[�^�[ �G�������^��
        cb_buff[E_GEL] = new JCheckBox("*�O���[�^�[ �G�������^��");
        cb_buff[E_GEL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_GEL].addActionListener(this);
        cb_buff[E_GEL].setEnabled(false);
        panels[3].add(cb_buff[E_GEL]);

        //*�\�E�� �o���A
        cb_buff[E_SBR] = new JCheckBox("*�\�E�� �o���A");
        cb_buff[E_SBR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_SBR].addActionListener(this);
        cb_buff[E_SBR].setEnabled(false);
        panels[3].add(cb_buff[E_SBR]);

        //�}�W�b�N�V�[���h
        cb_buff[E_MSD] = new JCheckBox("*�}�W�b�N�V�[���h");
        cb_buff[E_MSD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_MSD].addActionListener(this);
        cb_buff[E_MSD].setEnabled(false);
        panels[3].add(cb_buff[E_MSD]);

        //���x���[�V����
        cb_buff[E_LIN] = new JCheckBox("*���x���[�V����");
        cb_buff[E_LIN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_LIN].addActionListener(this);
        cb_buff[E_LIN].setEnabled(false);
        panels[3].add(cb_buff[E_LIN]);

        //�G�������X�g���C�N
        cb_buff[E_ESE] = new JCheckBox("*�G�������X�g���C�N");
        cb_buff[E_ESE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_ESE].addActionListener(this);
        cb_buff[E_ESE].setEnabled(false);
        panels[3].add(cb_buff[E_ESE]);

        col++;

        lab_tmp = new JLabel("�p�b�V�u�X�L��");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[3].add(lab_tmp);

        //���W�X�g �G�������g
        cb_buff[E_RET] = new JCheckBox("���W�X�g �G�������g");
        cb_buff[E_RET].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_RET].addActionListener(this);
        panels[3].add(cb_buff[E_RET]);

        //*�O���[���[�A�[�X
        cb_buff[E_GEH] = new JCheckBox("*�O���[���[�A�[�X");
        cb_buff[E_GEH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_GEH].addActionListener(this);
        cb_buff[E_GEH].setEnabled(false);
        panels[3].add(cb_buff[E_GEH]);

        //*�u���b�f�B�\�E��
        cb_buff[E_BSL] = new JCheckBox("*�u���b�f�B�\�E��");
        cb_buff[E_BSL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_BSL].addActionListener(this);
        cb_buff[E_BSL].setEnabled(false);
        panels[3].add(cb_buff[E_BSL]);

        col++;

        //*�o�[�j���O�V���b�g
        cb_buff[E_BST] = new JCheckBox("*[UP��]�o�[�j���O�V���b�g");
        cb_buff[E_BST].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_BST].addActionListener(this);
        cb_buff[E_BST].setEnabled(false);
        panels[3].add(cb_buff[E_BST]);

        //*�\�E���o���A:�A�[�}�[
        cb_buff[E_SBA] = new JCheckBox("*[UP��]�\�E���o���A:�A�[�}�[");
        cb_buff[E_SBA].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_SBA].addActionListener(this);
        cb_buff[E_SBA].setEnabled(false);
        panels[3].add(cb_buff[E_SBA]);

        //*�X�g���C�J�[�Q�C��:�V���b�g
        cb_buff[E_SGS] = new JCheckBox("*[UP��]�X�g���C�J�[�Q�C��:�V���b�g");
        cb_buff[E_SGS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_SGS].addActionListener(this);
        cb_buff[E_SGS].setEnabled(false);
        panels[3].add(cb_buff[E_SGS]);

        col = 0;
        row = 3;

        lab_tmp = new JLabel("���얂�@(��)");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[3].add(lab_tmp);

        //*�t�@�C�A�[ �V�[���h
        cb_buff[E_FSD] = new JCheckBox("*�t�@�C�A�[ �V�[���h");
        cb_buff[E_FSD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_FSD].addActionListener(this);
        cb_buff[E_FSD].setEnabled(false);
        panels[3].add(cb_buff[E_FSD]);

        //*�_���V���O �u���C�Y
        cb_buff[E_DBE] = new JCheckBox("*�_���V���O �u���C�Y");
        cb_buff[E_DBE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_DBE].addActionListener(this);
        cb_buff[E_DBE].setEnabled(false);
        panels[3].add(cb_buff[E_DBE]);

        //�o�[�j���O �E�G�|��
        cb_buff[E_BWN] = new JCheckBox("�o�[�j���O �E�G�|��");
        cb_buff[E_BWN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_BWN].addActionListener(this);
        panels[3].add(cb_buff[E_BWN]);

        //�G�������^�� �t�@�C�A�[
        cb_buff[E_EFE] = new JCheckBox("�G�������^�� �t�@�C�A�[");
        cb_buff[E_EFE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_EFE].addActionListener(this);
        panels[3].add(cb_buff[E_EFE]);

        //�\�E�� �I�u �t���C��
        cb_buff[E_SOF] = new JCheckBox("�\�E�� �I�u �t���C��");
        cb_buff[E_SOF].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_SOF].addActionListener(this);
        panels[3].add(cb_buff[E_SOF]);

        //�A�f�B�V���i�� �t�@�C�A�[
        cb_buff[E_AFE] = new JCheckBox("�A�f�B�V���i�� �t�@�C�A�[");
        cb_buff[E_AFE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_AFE].addActionListener(this);
        panels[3].add(cb_buff[E_AFE]);

        //*�C���t�F���m
        cb_buff[E_INO] = new JCheckBox("*�C���t�F���m");
        cb_buff[E_INO].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_INO].addActionListener(this);
        cb_buff[E_INO].setEnabled(false);
        panels[3].add(cb_buff[E_INO]);

        col++;

        lab_tmp = new JLabel("���얂�@(��)");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[3].add(lab_tmp);

        //�A�N�A �V���b�g
        cb_buff[E_AST] = new JCheckBox("�A�N�A �V���b�g");
        cb_buff[E_AST].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_AST].addActionListener(this);
        panels[3].add(cb_buff[E_AST]);

        //*�E�H�[�^�[ ���C�t
        cb_buff[E_WLE] = new JCheckBox("*�E�H�[�^�[ ���C�t");
        cb_buff[E_WLE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_WLE].addActionListener(this);
        cb_buff[E_WLE].setEnabled(false);
        panels[3].add(cb_buff[E_WLE]);

        //*�l�C�`���[�Y �^�b�`
        cb_buff[E_NTH] = new JCheckBox("*�l�C�`���[�Y �^�b�`");
        cb_buff[E_NTH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_NTH].addActionListener(this);
        cb_buff[E_NTH].setEnabled(false);
        panels[3].add(cb_buff[E_NTH]);

        //�A�N�A �v���e�N�^�[
        cb_buff[E_APR] = new JCheckBox("�A�N�A �v���e�N�^�[");
        cb_buff[E_APR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_APR].addActionListener(this);
        panels[3].add(cb_buff[E_APR]);

        //*�t�H�[�J�X �E�F�[�u
        cb_buff[E_FWE] = new JCheckBox("*�t�H�[�J�X �E�F�[�u");
        cb_buff[E_FWE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_FWE].addActionListener(this);
        cb_buff[E_FWE].setEnabled(false);
        panels[3].add(cb_buff[E_FWE]);

        //*�l�C�`���[�Y �u���b�V���O
        cb_buff[E_NBG] = new JCheckBox("*�l�C�`���[�Y �u���b�V���O");
        cb_buff[E_NBG].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_NBG].addActionListener(this);
        cb_buff[E_NBG].setEnabled(false);
        panels[3].add(cb_buff[E_NBG]);

        //*�|���[�g �E�H�[�^�[
        cb_buff[E_PWR] = new JCheckBox("*�|���[�g �E�H�[�^�[");
        cb_buff[E_PWR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_PWR].addActionListener(this);
        cb_buff[E_PWR].setEnabled(false);
        panels[3].add(cb_buff[E_PWR]);

        col = 0;
        row = 4;

        lab_tmp = new JLabel("���얂�@(��)");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[3].add(lab_tmp);

        //�C�[�O�� �A�C
        cb_buff[E_EEE] = new JCheckBox("�C�[�O�� �A�C");
        cb_buff[E_EEE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_EEE].addActionListener(this);
        panels[3].add(cb_buff[E_EEE]);

        //�X�g�[�� �A�C
        cb_buff[E_SEE] = new JCheckBox("�X�g�[�� �A�C");
        cb_buff[E_SEE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_SEE].addActionListener(this);
        panels[3].add(cb_buff[E_SEE]);

        //�X�g�[�� �V���b�g
        cb_buff[E_SST] = new JCheckBox("�X�g�[�� �V���b�g");
        cb_buff[E_SST].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_SST].addActionListener(this);
        panels[3].add(cb_buff[E_SST]);

        //�T�C�N����
        cb_buff[E_CYE] = new JCheckBox("�T�C�N����");
        cb_buff[E_CYE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_CYE].addActionListener(this);
        panels[3].add(cb_buff[E_CYE]);

        //*�X�g���C�J�[ �Q�C��
        cb_buff[E_SGL] = new JCheckBox("*�X�g���C�J�[ �Q�C��");
        cb_buff[E_SGL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_SGL].addActionListener(this);
        cb_buff[E_SGL].setEnabled(false);
        panels[3].add(cb_buff[E_SGL]);

        //*�n���P�[��
        cb_buff[E_HUE] = new JCheckBox("*�n���P�[��");
        cb_buff[E_HUE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_HUE].addActionListener(this);
        cb_buff[E_HUE].setEnabled(false);
        panels[3].add(cb_buff[E_HUE]);

        col++;

        lab_tmp = new JLabel("���얂�@(�n)");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[3].add(lab_tmp);

        //�A�[�X �E�F�|��
        cb_buff[E_EWN] = new JCheckBox("�A�[�X �E�F�|��");
        cb_buff[E_EWN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_EWN].addActionListener(this);
        panels[3].add(cb_buff[E_EWN]);

        //�N�G�C�N
        cb_buff[E_QUE] = new JCheckBox("�N�G�C�N");
        cb_buff[E_QUE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_QUE].addActionListener(this);
        panels[3].add(cb_buff[E_QUE]);

        //*�A�[�X �o�C���h
        cb_buff[E_EBD] = new JCheckBox("*�A�[�X �o�C���h");
        cb_buff[E_EBD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_EBD].addActionListener(this);
        cb_buff[E_EBD].setEnabled(false);
        panels[3].add(cb_buff[E_EBD]);

        //�A�[�X �K�[�f�B�A��
        cb_buff[E_EGN] = new JCheckBox("�A�[�X �K�[�f�B�A��");
        cb_buff[E_EGN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_EGN].addActionListener(this);
        panels[3].add(cb_buff[E_EGN]);

        //*�T���h �X�g�[��
        cb_buff[E_SSM] = new JCheckBox("*�T���h �X�g�[��");
        cb_buff[E_SSM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_SSM].addActionListener(this);
        cb_buff[E_SSM].setEnabled(false);
        panels[3].add(cb_buff[E_SSM]);

        //�A�C�A�� �X�L��
        cb_buff[E_ISN] = new JCheckBox("�A�C�A�� �X�L��");
        cb_buff[E_ISN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_ISN].addActionListener(this);
        panels[3].add(cb_buff[E_ISN]);

        //*�G�L�]�`�b�N �o�C�^���C�Y
        cb_buff[E_EVE] = new JCheckBox("*�G�L�]�`�b�N �o�C�^���C�Y");
        cb_buff[E_EVE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[E_EVE].addActionListener(this);
        cb_buff[E_EVE].setEnabled(false);
        panels[3].add(cb_buff[E_EVE]);

        //----------
        //�p�l��4
        //----------
        col = 0;
        row = 0;

        lab_tmp = new JLabel("��ʖ��@");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[4].add(lab_tmp);

        //*�q�[��
        cb_buff[W_HEL] = new JCheckBox("*�q�[��");
        cb_buff[W_HEL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_HEL].addActionListener(this);
        cb_buff[W_HEL].setEnabled(false);
        panels[4].add(cb_buff[W_HEL]);

        //*���C�g
        cb_buff[W_LIT] = new JCheckBox("*���C�g");
        cb_buff[W_LIT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_LIT].addActionListener(this);
        cb_buff[W_LIT].setEnabled(false);
        panels[4].add(cb_buff[W_LIT]);

        //*�V�[���h
        cb_buff[W_SHD] = new JCheckBox("*�V�[���h");
        cb_buff[W_SHD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_SHD].addActionListener(this);
        cb_buff[W_SHD].setEnabled(false);
        panels[4].add(cb_buff[W_SHD]);

        //*�G�l���M�[ �{���g
        cb_buff[W_EBT] = new JCheckBox("*�G�l���M�[ �{���g");
        cb_buff[W_EBT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_EBT].addActionListener(this);
        cb_buff[W_EBT].setEnabled(false);
        panels[4].add(cb_buff[W_EBT]);

        //*�e���|�[�g
        cb_buff[W_TET] = new JCheckBox("*�e���|�[�g");
        cb_buff[W_TET].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_TET].addActionListener(this);
        cb_buff[W_TET].setEnabled(false);
        panels[4].add(cb_buff[W_TET]);

        //*�A�C�X �_�K�[
        cb_buff[W_IDR] = new JCheckBox("*�A�C�X �_�K�[");
        cb_buff[W_IDR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_IDR].addActionListener(this);
        cb_buff[W_IDR].setEnabled(false);
        panels[4].add(cb_buff[W_IDR]);

        //*�E�B���h �J�b�^�[
        cb_buff[W_WCR] = new JCheckBox("*�E�B���h �J�b�^�[");
        cb_buff[W_WCR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_WCR].addActionListener(this);
        cb_buff[W_WCR].setEnabled(false);
        panels[4].add(cb_buff[W_WCR]);

        //*�z�[���[ �E�F�|��
        cb_buff[W_HWS] = new JCheckBox("*�z�[���[ �E�F�|��");
        cb_buff[W_HWS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_HWS].addActionListener(this);
        cb_buff[W_HWS].setEnabled(false);
        panels[4].add(cb_buff[W_HWS]);

        col++;

        //*�L���A �|�C�Y��
        cb_buff[W_CUP] = new JCheckBox("*�L���A �|�C�Y��");
        cb_buff[W_CUP].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_CUP].addActionListener(this);
        cb_buff[W_CUP].setEnabled(false);
        panels[4].add(cb_buff[W_CUP]);

        //*�`�� �^�b�`
        cb_buff[W_CRH] = new JCheckBox("*�`�� �^�b�`");
        cb_buff[W_CRH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_CRH].addActionListener(this);
        cb_buff[W_CRH].setEnabled(false);
        panels[4].add(cb_buff[W_CRH]);

        //*�J�[�Y �|�C�Y��
        cb_buff[W_CAP] = new JCheckBox("*�J�[�Y �|�C�Y��");
        cb_buff[W_CAP].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_CAP].addActionListener(this);
        cb_buff[W_CAP].setEnabled(false);
        panels[4].add(cb_buff[W_CAP]);

        //*�G���`�����g �E�F�|��
        cb_buff[W_EWN] = new JCheckBox("*�G���`�����g �E�F�|��");
        cb_buff[W_EWN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_EWN].addActionListener(this);
        cb_buff[W_EWN].setEnabled(false);
        panels[4].add(cb_buff[W_EWN]);

        //*�f�B�e�N�V����
        cb_buff[W_DEN] = new JCheckBox("*�f�B�e�N�V����");
        cb_buff[W_DEN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_DEN].addActionListener(this);
        cb_buff[W_DEN].setEnabled(false);
        panels[4].add(cb_buff[W_DEN]);

        //�f�B�N���[�X �E�F�C�g
        cb_buff[W_DWT] = new JCheckBox("�f�B�N���[�X �E�F�C�g");
        cb_buff[W_DWT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_DWT].addActionListener(this);
        panels[4].add(cb_buff[W_DWT]);

        //*�t�@�C�A�[ �A���[
        cb_buff[W_FAW] = new JCheckBox("*�t�@�C�A�[ �A���[");
        cb_buff[W_FAW].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_FAW].addActionListener(this);
        cb_buff[W_FAW].setEnabled(false);
        panels[4].add(cb_buff[W_FAW]);

        //*�X�^���b�N
        cb_buff[W_STK] = new JCheckBox("*�X�^���b�N");
        cb_buff[W_STK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_STK].addActionListener(this);
        cb_buff[W_STK].setEnabled(false);
        panels[4].add(cb_buff[W_STK]);

        col++;

        //*���C�g�j���O
        cb_buff[W_LIG] = new JCheckBox("*���C�g�j���O");
        cb_buff[W_LIG].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_LIG].addActionListener(this);
        cb_buff[W_LIG].setEnabled(false);
        panels[4].add(cb_buff[W_LIG]);

        //*�^�[�� �A���f�b�h
        cb_buff[W_TUD] = new JCheckBox("*�^�[�� �A���f�b�h");
        cb_buff[W_TUD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_TUD].addActionListener(this);
        cb_buff[W_TUD].setEnabled(false);
        panels[4].add(cb_buff[W_TUD]);

        //*�G�L�X�g�� �q�[��
        cb_buff[W_EHL] = new JCheckBox("*�G�L�X�g�� �q�[��");
        cb_buff[W_EHL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_EHL].addActionListener(this);
        cb_buff[W_EHL].setEnabled(false);
        panels[4].add(cb_buff[W_EHL]);

        //*�J�[�Y �u���C���h
        cb_buff[W_CBD] = new JCheckBox("*�J�[�Y �u���C���h");
        cb_buff[W_CBD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_CBD].addActionListener(this);
        cb_buff[W_CBD].setEnabled(false);
        panels[4].add(cb_buff[W_CBD]);

        //�u���X�h �A�[�}�[
        cb_buff[W_BAR] = new JCheckBox("�u���X�h �A�[�}�[");
        cb_buff[W_BAR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_BAR].addActionListener(this);
        panels[4].add(cb_buff[W_BAR]);

        //*�t���[�Y�� �N���E�h
        cb_buff[W_FCD] = new JCheckBox("*�t���[�Y�� �N���E�h");
        cb_buff[W_FCD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_FCD].addActionListener(this);
        cb_buff[W_FCD].setEnabled(false);
        panels[4].add(cb_buff[W_FCD]);

        //*�E�B�[�N �G�������^��
        cb_buff[W_WEL] = new JCheckBox("*�E�B�[�N �G�������^��");
        cb_buff[W_WEL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_WEL].addActionListener(this);
        cb_buff[W_WEL].setEnabled(false);
        panels[4].add(cb_buff[W_WEL]);

        col++;

        //*�t�@�C�A�[ �{�[��
        cb_buff[W_FIL] = new JCheckBox("*�t�@�C�A�[ �{�[��");
        cb_buff[W_FIL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_FIL].addActionListener(this);
        cb_buff[W_FIL].setEnabled(false);
        panels[4].add(cb_buff[W_FIL]);

        //*�t�B�W�J�� �G���`�����g:DEX
        cb_buff[W_PED] = new JCheckBox("*�t�B�W�J�� �G���`�����g:DEX");
        cb_buff[W_PED].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_PED].addActionListener(this);
        cb_buff[W_PED].setEnabled(false);
        panels[4].add(cb_buff[W_PED]);

        col = 0;
        row = 1;

        //*�E�F�|�� �u���C�N
        cb_buff[W_WBK] = new JCheckBox("*�E�F�|�� �u���C�N");
        cb_buff[W_WBK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_WBK].addActionListener(this);
        cb_buff[W_WBK].setEnabled(false);
        panels[4].add(cb_buff[W_WBK]);

        //*�o���p�C�A���b�N �^�b�`
        cb_buff[W_VTH] = new JCheckBox("*�o���p�C�A���b�N �^�b�`");
        cb_buff[W_VTH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_VTH].addActionListener(this);
        cb_buff[W_VTH].setEnabled(false);
        panels[4].add(cb_buff[W_VTH]);

        //*�X���[
        cb_buff[W_THW] = new JCheckBox("*�X���[");
        cb_buff[W_THW].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_THW].addActionListener(this);
        cb_buff[W_THW].setEnabled(false);
        panels[4].add(cb_buff[W_THW]);

        //*�A�[�X �W�F�C��
        cb_buff[W_EJL] = new JCheckBox("*�A�[�X �W�F�C��");
        cb_buff[W_EJL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_EJL].addActionListener(this);
        cb_buff[W_EJL].setEnabled(false);
        panels[4].add(cb_buff[W_EJL]);

        //*�J�E���^�[ �}�W�b�N
        cb_buff[W_CMC] = new JCheckBox("*�J�E���^�[ �}�W�b�N");
        cb_buff[W_CMC].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_CMC].addActionListener(this);
        cb_buff[W_CMC].setEnabled(false);
        panels[4].add(cb_buff[W_CMC]);

        //*���f�B�e�[�V����
        cb_buff[W_MEN] = new JCheckBox("*���f�B�e�[�V����");
        cb_buff[W_MEN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_MEN].addActionListener(this);
        cb_buff[W_MEN].setEnabled(false);
        panels[4].add(cb_buff[W_MEN]);

        col++;

        //*�J�[�Y �p�����C�Y
        cb_buff[W_CPE] = new JCheckBox("*�J�[�Y �p�����C�Y");
        cb_buff[W_CPE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_CPE].addActionListener(this);
        cb_buff[W_CPE].setEnabled(false);
        panels[4].add(cb_buff[W_CPE]);


        //*�R�[�� ���C�g�j���O
        cb_buff[W_CLG] = new JCheckBox("*�R�[�� ���C�g�j���O");
        cb_buff[W_CLG].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_CLG].addActionListener(this);
        cb_buff[W_CLG].setEnabled(false);
        panels[4].add(cb_buff[W_CLG]);


        //*�O���[�^�[ �q�[��
        cb_buff[W_GHL] = new JCheckBox("*�O���[�^�[ �q�[��");
        cb_buff[W_GHL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_GHL].addActionListener(this);
        cb_buff[W_GHL].setEnabled(false);
        panels[4].add(cb_buff[W_GHL]);


        //*�e�C�~���O �����X�^�[
        cb_buff[W_TMR] = new JCheckBox("*�e�C�~���O �����X�^�[");
        cb_buff[W_TMR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_TMR].addActionListener(this);
        cb_buff[W_TMR].setEnabled(false);
        panels[4].add(cb_buff[W_TMR]);


        //*�����[�u �J�[�Y
        cb_buff[W_RCE] = new JCheckBox("*�����[�u �J�[�Y");
        cb_buff[W_RCE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_RCE].addActionListener(this);
        cb_buff[W_RCE].setEnabled(false);
        panels[4].add(cb_buff[W_RCE]);


        //*�R�[�� �I�u �R�[���h
        cb_buff[W_COC] = new JCheckBox("*�R�[�� �I�u �R�[���h");
        cb_buff[W_COC].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_COC].addActionListener(this);
        cb_buff[W_COC].setEnabled(false);
        panels[4].add(cb_buff[W_COC]);


        //*�}�i �h���C��
        cb_buff[W_MDN] = new JCheckBox("*�}�i �h���C��");
        cb_buff[W_MDN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_MDN].addActionListener(this);
        cb_buff[W_MDN].setEnabled(false);
        panels[4].add(cb_buff[W_MDN]);


        //*�_�[�N�l�X
        cb_buff[W_DAS] = new JCheckBox("*�_�[�N�l�X");
        cb_buff[W_DAS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_DAS].addActionListener(this);
        cb_buff[W_DAS].setEnabled(false);
        panels[4].add(cb_buff[W_DAS]);

        col++;

        //*�N���G�C�g �]���r
        cb_buff[W_CZE] = new JCheckBox("*�N���G�C�g �]���r");
        cb_buff[W_CZE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_CZE].addActionListener(this);
        cb_buff[W_CZE].setEnabled(false);
        panels[4].add(cb_buff[W_CZE]);

        //*�t�B�W�J�� �G���`�����g:STR
        cb_buff[W_PES] = new JCheckBox("*�t�B�W�J�� �G���`�����g:STR");
        cb_buff[W_PES].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_PES].addActionListener(this);
        cb_buff[W_PES].setEnabled(false);
        panels[4].add(cb_buff[W_PES]);

        //*�w�C�X�g
        cb_buff[W_HET] = new JCheckBox("*�w�C�X�g");
        cb_buff[W_HET].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_HET].addActionListener(this);
        cb_buff[W_HET].setEnabled(false);
        panels[4].add(cb_buff[W_HET]);

        //*�L�����Z���[�V����
        cb_buff[W_CAN] = new JCheckBox("*�L�����Z���[�V����");
        cb_buff[W_CAN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_CAN].addActionListener(this);
        cb_buff[W_CAN].setEnabled(false);
        panels[4].add(cb_buff[W_CAN]);

        //*�C���v�V����
        cb_buff[W_IRN] = new JCheckBox("*�C���v�V����");
        cb_buff[W_IRN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_IRN].addActionListener(this);
        cb_buff[W_IRN].setEnabled(false);
        panels[4].add(cb_buff[W_IRN]);

        //*�T�� �o�[�X�g
        cb_buff[W_SUT] = new JCheckBox("*�T�� �o�[�X�g");
        cb_buff[W_SUT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_SUT].addActionListener(this);
        cb_buff[W_SUT].setEnabled(false);
        panels[4].add(cb_buff[W_SUT]);

        //*�E�B�[�N�l�X
        cb_buff[W_WES] = new JCheckBox("*�E�B�[�N�l�X");
        cb_buff[W_WES].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_WES].addActionListener(this);
        cb_buff[W_WES].setEnabled(false);
        panels[4].add(cb_buff[W_WES]);

        //*�u���X �E�F�|��
        cb_buff[W_BWN] = new JCheckBox("*�u���X �E�F�|��");
        cb_buff[W_BWN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_BWN].addActionListener(this);
        cb_buff[W_BWN].setEnabled(false);
        panels[4].add(cb_buff[W_BWN]);

        col++;

        //*�q�[�� �I�[��
        cb_buff[W_HAL] = new JCheckBox("*�q�[�� �I�[��");
        cb_buff[W_HAL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_HAL].addActionListener(this);
        cb_buff[W_HAL].setEnabled(false);
        panels[4].add(cb_buff[W_HAL]);

        //�t���[�W���O �A�[�}�[
        cb_buff[W_FAR] = new JCheckBox("�t���[�W���O �A�[�}�[");
        cb_buff[W_FAR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_FAR].addActionListener(this);
        panels[4].add(cb_buff[W_FAR]);

        //*�T���� �����X�^�[
        cb_buff[W_SMR] = new JCheckBox("*�T���� �����X�^�[");
        cb_buff[W_SMR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_SMR].addActionListener(this);
        cb_buff[W_SMR].setEnabled(false);
        panels[4].add(cb_buff[W_SMR]);

        //*�z�[���[ �E�H�[�N
        cb_buff[W_HWK] = new JCheckBox("*�z�[���[ �E�H�[�N");
        cb_buff[W_HWK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_HWK].addActionListener(this);
        cb_buff[W_HWK].setEnabled(false);
        panels[4].add(cb_buff[W_HWK]);

        col = 0;
        row = 2;

        //*�g���l�[�h
        cb_buff[W_TOO] = new JCheckBox("*�g���l�[�h");
        cb_buff[W_TOO].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_TOO].addActionListener(this);
        cb_buff[W_TOO].setEnabled(false);
        panels[4].add(cb_buff[W_TOO]);

        //*�O���[�^�[ �w�C�X�g
        cb_buff[W_GHT] = new JCheckBox("*�O���[�^�[ �w�C�X�g");
        cb_buff[W_GHT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_GHT].addActionListener(this);
        cb_buff[W_GHT].setEnabled(false);
        panels[4].add(cb_buff[W_GHT]);

        //�o�[�T�[�J�[
        String list_W_BER[] = {"�p��", "PT�����o�["};
        cb_buff_group[W_BER] = new WideComboBox(list_W_BER);
        cb_buff_group[W_BER].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff_group[W_BER].addActionListener(this);
        panels[4].add(cb_buff_group[W_BER]);
        cb_buff[W_BER] = new JCheckBox("�o�[�T�[�J�[");
        cb_buff[W_BER].setBounds(200 * row, 20 * col++, 100, 20);
        cb_buff[W_BER].addActionListener(this);
        panels[4].add(cb_buff[W_BER]);

        //�G���`�����g�A�L�����V�[
        cb_buff[W_EAY] = new JCheckBox("�G���`�����g�A�L�����V�[");
        cb_buff[W_EAY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_EAY].addActionListener(this);
        panels[4].add(cb_buff[W_EAY]);

        col++;

        //*�t�� �q�[��
        cb_buff[W_FHL] = new JCheckBox("*�t�� �q�[��");
        cb_buff[W_FHL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_FHL].addActionListener(this);
        cb_buff[W_FHL].setEnabled(false);
        panels[4].add(cb_buff[W_FHL]);

        //*�t�@�C�A�[ �E�H�[��
        cb_buff[W_FWL] = new JCheckBox("*�t�@�C�A�[ �E�H�[��");
        cb_buff[W_FWL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_FWL].addActionListener(this);
        cb_buff[W_FWL].setEnabled(false);
        panels[4].add(cb_buff[W_FWL]);

        //*�u���U�[�h
        cb_buff[W_BLD] = new JCheckBox("*�u���U�[�h");
        cb_buff[W_BLD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_BLD].addActionListener(this);
        cb_buff[W_BLD].setEnabled(false);
        panels[4].add(cb_buff[W_BLD]);

        //*�C���r�W�r���e�B�[
        cb_buff[W_INY] = new JCheckBox("*�C���r�W�r���e�B�[");
        cb_buff[W_INY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_INY].addActionListener(this);
        cb_buff[W_INY].setEnabled(false);
        panels[4].add(cb_buff[W_INY]);

        //*���U���N�V����
        cb_buff[W_REN] = new JCheckBox("*���U���N�V����");
        cb_buff[W_REN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_REN].addActionListener(this);
        cb_buff[W_REN].setEnabled(false);
        panels[4].add(cb_buff[W_REN]);

        //*�A�[�X �N�G�C�N
        cb_buff[W_EAE] = new JCheckBox("*�A�[�X �N�G�C�N");
        cb_buff[W_EAE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_EAE].addActionListener(this);
        cb_buff[W_EAE].setEnabled(false);
        panels[4].add(cb_buff[W_EAE]);

        //*���C�t �X�g���[��
        cb_buff[W_LSM] = new JCheckBox("*���C�t �X�g���[��");
        cb_buff[W_LSM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_LSM].addActionListener(this);
        cb_buff[W_LSM].setEnabled(false);
        panels[4].add(cb_buff[W_LSM]);

        //*�T�C�����X
        cb_buff[W_SIE] = new JCheckBox("*�T�C�����X");
        cb_buff[W_SIE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_SIE].addActionListener(this);
        cb_buff[W_SIE].setEnabled(false);
        panels[4].add(cb_buff[W_SIE]);

        col++;

        //*���C�g�j���O �X�g�[��
        cb_buff[W_LIM] = new JCheckBox("*���C�g�j���O �X�g�[��");
        cb_buff[W_LIM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_LIM].addActionListener(this);
        cb_buff[W_LIM].setEnabled(false);
        panels[4].add(cb_buff[W_LIM]);

        //*�t�H�O �I�u �X���[�s���O
        cb_buff[W_FOS] = new JCheckBox("*�t�H�O �I�u �X���[�s���O");
        cb_buff[W_FOS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_FOS].addActionListener(this);
        cb_buff[W_FOS].setEnabled(false);
        panels[4].add(cb_buff[W_FOS]);

        //*�V�F�C�v �`�F���W
        cb_buff[W_SCE] = new JCheckBox("*�V�F�C�v �`�F���W");
        cb_buff[W_SCE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_SCE].addActionListener(this);
        cb_buff[W_SCE].setEnabled(false);
        panels[4].add(cb_buff[W_SCE]);

        //*�C�~���[�� �g�D �n�[��
        cb_buff[W_ITH] = new JCheckBox("*�C�~���[�� �g�D �n�[��");
        cb_buff[W_ITH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_ITH].addActionListener(this);
        cb_buff[W_ITH].setEnabled(false);
        panels[4].add(cb_buff[W_ITH]);

        //*�}�X �e���|�[�g
        cb_buff[W_MTT] = new JCheckBox("*�}�X �e���|�[�g");
        cb_buff[W_MTT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_MTT].addActionListener(this);
        cb_buff[W_MTT].setEnabled(false);
        panels[4].add(cb_buff[W_MTT]);

        //*�t�@�C�A�[ �X�g�[��
        cb_buff[W_FSM] = new JCheckBox("*�t�@�C�A�[ �X�g�[��");
        cb_buff[W_FSM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_FSM].addActionListener(this);
        cb_buff[W_FSM].setEnabled(false);
        panels[4].add(cb_buff[W_FSM]);

        //*�f�B�P�C�|�[�V����
        cb_buff[W_DPN] = new JCheckBox("*�f�B�P�C�|�[�V����");
        cb_buff[W_DPN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_DPN].addActionListener(this);
        cb_buff[W_DPN].setEnabled(false);
        panels[4].add(cb_buff[W_DPN]);

        //*�J�E���^�[ �f�B�e�N�V����
        cb_buff[W_CDN] = new JCheckBox("*�J�E���^�[ �f�B�e�N�V����");
        cb_buff[W_CDN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_CDN].addActionListener(this);
        cb_buff[W_CDN].setEnabled(false);
        panels[4].add(cb_buff[W_CDN]);

        col++;

        //*�f�X �q�[��
        cb_buff[W_DHL] = new JCheckBox("*�f�X �q�[��");
        cb_buff[W_DHL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_DHL].addActionListener(this);
        cb_buff[W_DHL].setEnabled(false);
        panels[4].add(cb_buff[W_DHL]);


        //*���e�I �X�g���C�N
        cb_buff[W_MSE] = new JCheckBox("*���e�I �X�g���C�N");
        cb_buff[W_MSE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_MSE].addActionListener(this);
        cb_buff[W_MSE].setEnabled(false);
        panels[4].add(cb_buff[W_MSE]);


        //*�O���[�^�[ ���U���N�V����
        cb_buff[W_GRN] = new JCheckBox("*�O���[�^�[ ���U���N�V����");
        cb_buff[W_GRN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_GRN].addActionListener(this);
        cb_buff[W_GRN].setEnabled(false);
        panels[4].add(cb_buff[W_GRN]);


        //*�A�C�X ���e�I
        cb_buff[W_IMR] = new JCheckBox("*�A�C�X ���e�I");
        cb_buff[W_IMR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_IMR].addActionListener(this);
        cb_buff[W_IMR].setEnabled(false);
        panels[4].add(cb_buff[W_IMR]);


        //*�f�B�X�C���e�O���[�g
        cb_buff[W_DIE] = new JCheckBox("*�f�B�X�C���e�O���[�g");
        cb_buff[W_DIE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_DIE].addActionListener(this);
        cb_buff[W_DIE].setEnabled(false);
        panels[4].add(cb_buff[W_DIE]);


        //*�A�u�\���[�g �o���A
        cb_buff[W_ABR] = new JCheckBox("*�A�u�\���[�g �o���A");
        cb_buff[W_ABR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_ABR].addActionListener(this);
        cb_buff[W_ABR].setEnabled(false);
        panels[4].add(cb_buff[W_ABR]);

        col = 0;
        row = 3;

        //�A�h�o���X�h �X�s���b�c
        cb_buff[W_ADS] = new JCheckBox("�A�h�o���X�h �X�s���b�c");
        cb_buff[W_ADS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_ADS].addActionListener(this);
        panels[4].add(cb_buff[W_ADS]);


        //*�A�C�X �X�p�C�N
        cb_buff[W_ISE] = new JCheckBox("*�A�C�X �X�p�C�N");
        cb_buff[W_ISE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_ISE].addActionListener(this);
        cb_buff[W_ISE].setEnabled(false);
        panels[4].add(cb_buff[W_ISE]);

        col++;

        //*�G�^�j�e�B
        cb_buff[W_ETY] = new JCheckBox("*�G�^�j�e�B");
        cb_buff[W_ETY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_ETY].addActionListener(this);
        cb_buff[W_ETY].setEnabled(false);
        panels[4].add(cb_buff[W_ETY]);

        //*�}�X �C�~���[�� �g�D �n�[��
        cb_buff[W_MIT] = new JCheckBox("*�}�X �C�~���[�� �g�D �n�[��");
        cb_buff[W_MIT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_MIT].addActionListener(this);
        cb_buff[W_MIT].setEnabled(false);
        panels[4].add(cb_buff[W_MIT]);

        //*�f�B�o�C���v���e�N�V����
        cb_buff[W_DPR] = new JCheckBox("*�f�B�o�C���v���e�N�V����");
        cb_buff[W_DPR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_DPR].addActionListener(this);
        cb_buff[W_DPR].setEnabled(false);
        panels[4].add(cb_buff[W_DPR]);

        col++;

        lab_tmp = new JLabel("�p�b�V�u�X�L��");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[4].add(lab_tmp);

        //*�C�~���[�� �g�D �n�[��:�Z�C���g
        cb_buff[W_IHS] = new JCheckBox("*�C�~���[�� �g�D �n�[��:�Z�C���g");
        cb_buff[W_IHS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_IHS].addActionListener(this);
        cb_buff[W_IHS].setEnabled(false);
        panels[4].add(cb_buff[W_IHS]);

        //*�}�C�X�^�[ �A�L�����V�[
        cb_buff[W_MAY] = new JCheckBox("*�}�C�X�^�[ �A�L�����V�[");
        cb_buff[W_MAY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_MAY].addActionListener(this);
        cb_buff[W_MAY].setEnabled(false);
        panels[4].add(cb_buff[W_MAY]);

        //*���f�B�e�[�V����:�r�����h
        cb_buff[W_MBD] = new JCheckBox("*���f�B�e�[�V����:�r�����h");
        cb_buff[W_MBD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_MBD].addActionListener(this);
        cb_buff[W_MBD].setEnabled(false);
        panels[4].add(cb_buff[W_MBD]);

        //*�f�B�X�C���e�O���[�g:�l���V�X
        cb_buff[W_DNS] = new JCheckBox("*�f�B�X�C���e�O���[�g:�l���V�X");
        cb_buff[W_DNS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_DNS].addActionListener(this);
        cb_buff[W_DNS].setEnabled(false);
        panels[4].add(cb_buff[W_DNS]);

        //*�z�[���[�E�H�[�N:�G�{�����[�V����
        cb_buff[W_HWE] = new JCheckBox("*�z�[���[�E�H�[�N:�G�{�����[�V����");
        cb_buff[W_HWE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_HWE].addActionListener(this);
        cb_buff[W_HWE].setEnabled(false);
        panels[4].add(cb_buff[W_HWE]);

        //*�G�[�e���A���T�[�N��
        cb_buff[W_ERC] = new JCheckBox("*�G�[�e���A���T�[�N��");
        cb_buff[W_ERC].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_ERC].addActionListener(this);
        cb_buff[W_ERC].setEnabled(false);
        panels[4].add(cb_buff[W_ERC]);

        //*�O���[�^�[�T���������X�^�[
        cb_buff[W_GSM] = new JCheckBox("*�O���[�^�[�T���������X�^�[");
        cb_buff[W_GSM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[W_GSM].addActionListener(this);
        cb_buff[W_GSM].setEnabled(false);
        panels[4].add(cb_buff[W_GSM]);

        col = 0;
        row = 4;

        lab_tmp = new JLabel("�ł̐��얂�@");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[4].add(lab_tmp);

        //*�u���C���h �n�C�f�B���O
        cb_buff[D_BHG] = new JCheckBox("*�u���C���h �n�C�f�B���O");
        cb_buff[D_BHG].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_BHG].addActionListener(this);
        cb_buff[D_BHG].setEnabled(false);
        panels[4].add(cb_buff[D_BHG]);

        //*�G���`�����g �x�m��
        cb_buff[D_EVM] = new JCheckBox("*�G���`�����g �x�m��");
        cb_buff[D_EVM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_EVM].addActionListener(this);
        cb_buff[D_EVM].setEnabled(false);
        panels[4].add(cb_buff[D_EVM]);

        //�V���h�E �A�[�}�[
        cb_buff[D_SAR] = new JCheckBox("�V���h�E �A�[�}�[");
        cb_buff[D_SAR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_SAR].addActionListener(this);
        panels[4].add(cb_buff[D_SAR]);

        //�h���X �}�C�e�B�[
        cb_buff[D_DMY] = new JCheckBox("�h���X �}�C�e�B�[");
        cb_buff[D_DMY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_DMY].addActionListener(this);
        panels[4].add(cb_buff[D_DMY]);

        //*���[�r���O �A�N�Z���[�V����
        cb_buff[D_MAN] = new JCheckBox("*���[�r���O �A�N�Z���[�V����");
        cb_buff[D_MAN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_MAN].addActionListener(this);
        cb_buff[D_MAN].setEnabled(false);
        panels[4].add(cb_buff[D_MAN]);

        //*�V���h�E �X���[�v
        cb_buff[D_SSP] = new JCheckBox("*�V���h�E �X���[�v");
        cb_buff[D_SSP].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_SSP].addActionListener(this);
        cb_buff[D_SSP].setEnabled(false);
        panels[4].add(cb_buff[D_SSP]);

        //*�x�m�� ���W�X�g
        cb_buff[D_VRT] = new JCheckBox("*�x�m�� ���W�X�g");
        cb_buff[D_VRT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_VRT].addActionListener(this);
        cb_buff[D_VRT].setEnabled(false);
        panels[4].add(cb_buff[D_VRT]);

        //�h���X �f�N�X�^���e�B�[
        cb_buff[D_DDY] = new JCheckBox("�h���X �f�N�X�^���e�B�[");
        cb_buff[D_DDY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_DDY].addActionListener(this);
        panels[4].add(cb_buff[D_DDY]);

        //�_�u�� �u���C�N
        cb_buff[D_DBK] = new JCheckBox("�_�u�� �u���C�N");
        cb_buff[D_DBK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_DBK].addActionListener(this);
        panels[4].add(cb_buff[D_DBK]);

        //�A���L���j�[ �h�b�W
        cb_buff[D_UDE] = new JCheckBox("�A���L���j�[ �h�b�W");
        cb_buff[D_UDE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_UDE].addActionListener(this);
        panels[4].add(cb_buff[D_UDE]);

        //*�V���h�E �t�@���O
        cb_buff[D_SFG] = new JCheckBox("*�V���h�E �t�@���O");
        cb_buff[D_SFG].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_SFG].addActionListener(this);
        cb_buff[D_SFG].setEnabled(false);
        panels[4].add(cb_buff[D_SFG]);

        //*�A�[�}�[ �u���C�N
        cb_buff[D_ABK] = new JCheckBox("*�A�[�}�[ �u���C�N");
        cb_buff[D_ABK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_ABK].addActionListener(this);
        cb_buff[D_ABK].setEnabled(false);
        panels[4].add(cb_buff[D_ABK]);

        //*���V�t�@�[
        cb_buff[D_LUR] = new JCheckBox("*���V�t�@�[");
        cb_buff[D_LUR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_LUR].addActionListener(this);
        cb_buff[D_LUR].setEnabled(false);
        panels[4].add(cb_buff[D_LUR]);

        //*�A�x���W���[
        cb_buff[D_AVR] = new JCheckBox("*�A�x���W���[");
        cb_buff[D_AVR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_AVR].addActionListener(this);
        cb_buff[D_AVR].setEnabled(false);
        panels[4].add(cb_buff[D_AVR]);

        //*�V���h�E �X�e�b�v
        cb_buff[D_SHS] = new JCheckBox("*�V���h�E �X�e�b�v");
        cb_buff[D_SHS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_SHS].addActionListener(this);
        cb_buff[D_SHS].setEnabled(false);
        panels[4].add(cb_buff[D_SHS]);

        col++;

        lab_tmp = new JLabel("�p�b�V�u�X�L��");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[4].add(lab_tmp);

        //*�A�[�}�[�u���C�N:�f�X�e�B�j�[
        cb_buff[D_ABD] = new JCheckBox("*�A�[�}�[�u���C�N:�f�X�e�B�j�[");
        cb_buff[D_ABD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_ABD].addActionListener(this);
        cb_buff[D_ABD].setEnabled(false);
        panels[4].add(cb_buff[D_ABD]);

        //�_�u�� �u���C�N:�f�X�e�B�j�[
        cb_buff[D_DBD] = new JCheckBox("�_�u�� �u���C�N:�f�X�e�B�j�[");
        cb_buff[D_DBD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_DBD].addActionListener(this);
        panels[4].add(cb_buff[D_DBD]);

        //*�t�@�C�i�� �o�[��
        cb_buff[D_FBN] = new JCheckBox("*�t�@�C�i�� �o�[��");
        cb_buff[D_FBN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_FBN].addActionListener(this);
        cb_buff[D_FBN].setEnabled(false);
        panels[4].add(cb_buff[D_FBN]);

        //�o�[�j���O �X�s���b�c
        cb_buff[D_BSS] = new JCheckBox("�o�[�j���O �X�s���b�c");
        cb_buff[D_BSS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_BSS].addActionListener(this);
        panels[4].add(cb_buff[D_BSS]);

        //�h���X�C�x�C�W����
        cb_buff[D_DEN] = new JCheckBox("�h���X�C�x�C�W����");
        cb_buff[D_DEN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_DEN].addActionListener(this);
        panels[4].add(cb_buff[D_DEN]);

       //*���V�t�@�[:�f�X�e�B�j�[
        cb_buff[D_LUD] = new JCheckBox("*���V�t�@�[:�f�X�e�B�j�[");
        cb_buff[D_LUD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_LUD].addActionListener(this);
        cb_buff[D_LUD].setEnabled(false);
        panels[4].add(cb_buff[D_LUD]);

        //*�V���h�E �A�[�}�[:�f�X�e�B�j�[
        cb_buff[D_SAD] = new JCheckBox("*�V���h�E �A�[�}�[:�f�X�e�B�j�[");
        cb_buff[D_SAD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_SAD].addActionListener(this);
        cb_buff[D_SAD].setEnabled(false);
        panels[4].add(cb_buff[D_SAD]);

        //*���[�r���O �A�N�Z���[�V����:�}�L�V�}��
        cb_buff[D_MAM] = new JCheckBox("*���[�r���O �A�N�Z���[�V����:�}�L�V�}��");
        cb_buff[D_MAM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[D_MAM].addActionListener(this);
        cb_buff[D_MAM].setEnabled(false);
        panels[4].add(cb_buff[D_MAM]);

        //----------
        //�p�l��5
        //----------
        col = 0;
        row = 0;

        lab_tmp = new JLabel("���R�m�̔�Z");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[5].add(lab_tmp);

        //*�o�[�j���O �X���b�V��
        cb_buff[R_BSH] = new JCheckBox("*�o�[�j���O �X���b�V��");
        cb_buff[R_BSH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_BSH].addActionListener(this);
        cb_buff[R_BSH].setEnabled(false);
        panels[5].add(cb_buff[R_BSH]);

        //*�f�X�g���C
        cb_buff[R_DEY] = new JCheckBox("*�f�X�g���C");
        cb_buff[R_DEY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_DEY].addActionListener(this);
        cb_buff[R_DEY].setEnabled(false);
        panels[5].add(cb_buff[R_DEY]);

        //*�}�O�} �u���X
        cb_buff[R_MBH] = new JCheckBox("*�}�O�} �u���X");
        cb_buff[R_MBH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_MBH].addActionListener(this);
        cb_buff[R_MBH].setEnabled(false);
        panels[5].add(cb_buff[R_MBH]);

        //�o��[�A���^���X]
        cb_buff[R_ANTHARAS] = new JCheckBox("�o��[�A���^���X]");
        cb_buff[R_ANTHARAS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_ANTHARAS].addActionListener(this);
        panels[5].add(cb_buff[R_ANTHARAS]);

        //*�u���b�h���X�g
        cb_buff[R_BLT] = new JCheckBox("*�u���b�h���X�g");
        cb_buff[R_BLT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_BLT].addActionListener(this);
        cb_buff[R_BLT].setEnabled(false);
        panels[5].add(cb_buff[R_BLT]);

        //*�t�H�[ �X���C���[
        cb_buff[R_FSR] = new JCheckBox("*�t�H�[ �X���C���[");
        cb_buff[R_FSR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_FSR].addActionListener(this);
        cb_buff[R_FSR].setEnabled(false);
        panels[5].add(cb_buff[R_FSR]);

        //*�}�O�} �A���[
        cb_buff[R_MAW] = new JCheckBox("*�}�O�} �A���[");
        cb_buff[R_MAW].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_MAW].addActionListener(this);
        cb_buff[R_MAW].setEnabled(false);
        panels[5].add(cb_buff[R_MAW]);

        //�o��[�p�v���I��]
        cb_buff[R_FAFURION] = new JCheckBox("�o��[�p�v���I��]");
        cb_buff[R_FAFURION].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_FAFURION].addActionListener(this);
        panels[5].add(cb_buff[R_FAFURION]);

        //*���[�^�� �{�f�B�[
        cb_buff[R_MBY] = new JCheckBox("*���[�^�� �{�f�B�[");
        cb_buff[R_MBY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_MBY].addActionListener(this);
        cb_buff[R_MBY].setEnabled(false);
        panels[5].add(cb_buff[R_MBY]);

        //*�T���_�[ �O���b�v
        cb_buff[R_TGP] = new JCheckBox("*�T���_�[ �O���b�v");
        cb_buff[R_TGP].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_TGP].addActionListener(this);
        cb_buff[R_TGP].setEnabled(false);
        panels[5].add(cb_buff[R_TGP]);

        //*�A�C �I�u �h���S��
        cb_buff[R_EOD] = new JCheckBox("*�A�C �I�u �h���S��");
        cb_buff[R_EOD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_EOD].addActionListener(this);
        cb_buff[R_EOD].setEnabled(false);
        panels[5].add(cb_buff[R_EOD]);

        //�o��[���@���J�X]
        cb_buff[R_VALAKAS] = new JCheckBox("�o��[���@���J�X]");
        cb_buff[R_VALAKAS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_VALAKAS].addActionListener(this);
        panels[5].add(cb_buff[R_VALAKAS]);

        //�o��[�����h�r�I��]
        cb_buff[R_LINDVIOL] = new JCheckBox("�o��[�����h�r�I��]");
        cb_buff[R_LINDVIOL].setBounds(200 * row, 20 * col++, 180, 20);
        cb_buff[R_LINDVIOL].addActionListener(this);
        panels[5].add(cb_buff[R_LINDVIOL]);

        //*�n���p�X
        cb_buff[R_HAS] = new JCheckBox("*�n���p�X");
        cb_buff[R_HAS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_HAS].addActionListener(this);
        cb_buff[R_HAS].setEnabled(false);
        panels[5].add(cb_buff[R_HAS]);

        col++;

        lab_tmp = new JLabel("�p�b�V�u�X�L��");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[5].add(lab_tmp);

        //*�T���_�[ �O���b�v:�u���C�u
        cb_buff[R_TGB] = new JCheckBox("*�T���_�[ �O���b�v:�u���C�u");
        cb_buff[R_TGB].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_TGB].addActionListener(this);
        cb_buff[R_TGB].setEnabled(false);
        panels[5].add(cb_buff[R_TGB]);

        //*�t�H�[ �X���C���[:�u���C�u
        cb_buff[R_FSB] = new JCheckBox("*�t�H�[ �X���C���[:�u���C�u");
        cb_buff[R_FSB].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_FSB].addActionListener(this);
        cb_buff[R_FSB].setEnabled(false);
        panels[5].add(cb_buff[R_FSB]);
        //�A�E���L�A
        cb_buff[R_AUA] = new JCheckBox("�A�E���L�A");
        cb_buff[R_AUA].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_AUA].addActionListener(this);
        panels[5].add(cb_buff[R_AUA]);

        //*�f�X�g���C:�t�B�A�[
        cb_buff[R_DFR] = new JCheckBox("*�f�X�g���C:�t�B�A�[");
        cb_buff[R_DFR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_DFR].addActionListener(this);
        cb_buff[R_DFR].setEnabled(false);
        panels[5].add(cb_buff[R_DFR]);

        //*�f�X�g���C:�z���[
        cb_buff[R_DHR] = new JCheckBox("*�f�X�g���C:�z���[");
        cb_buff[R_DHR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_DHR].addActionListener(this);
        cb_buff[R_DHR].setEnabled(false);
        panels[5].add(cb_buff[R_DHR]);

        //�h���S�� �X�L��
        cb_buff[R_DSN] = new JCheckBox("�h���S�� �X�L��");
        cb_buff[R_DSN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_DSN].addActionListener(this);
        panels[5].add(cb_buff[R_DSN]);

        //*�\���b�h �m�b�g
        cb_buff[R_SNT] = new JCheckBox("*�\���b�h �m�b�g");
        cb_buff[R_SNT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_SNT].addActionListener(this);
        cb_buff[R_SNT].setEnabled(false);
        panels[5].add(cb_buff[R_SNT]);

        //*�����y�[�W
        cb_buff[R_RAE] = new JCheckBox("*�����y�[�W");
        cb_buff[R_RAE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[R_RAE].addActionListener(this);
        cb_buff[R_RAE].setEnabled(false);
        panels[5].add(cb_buff[R_RAE]);

        col = 0;
        row = 1;

        lab_tmp = new JLabel("���p���@");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[5].add(lab_tmp);

        //�~���[�C���[�W
        cb_buff[I_MIE] = new JCheckBox("�~���[�C���[�W");
        cb_buff[I_MIE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_MIE] .addActionListener(this);
        panels[5].add(cb_buff[I_MIE] );

        //*�R���t���[�W����
        cb_buff[I_CFN] = new JCheckBox("*�R���t���[�W����");
        cb_buff[I_CFN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_CFN] .addActionListener(this);
        cb_buff[I_CFN].setEnabled(false);
        panels[5].add(cb_buff[I_CFN] );

        //*�X�}�b�V�� �G�l���M�[
        cb_buff[I_SEY] = new JCheckBox("*�X�}�b�V�� �G�l���M�[");
        cb_buff[I_SEY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_SEY] .addActionListener(this);
        cb_buff[I_SEY].setEnabled(false);
        panels[5].add(cb_buff[I_SEY] );

        //�C�����[�W����[�I�[�K]
        cb_buff[I_IOE] = new JCheckBox("�C�����[�W����[�I�[�K]");
        cb_buff[I_IOE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_IOE].addActionListener(this);
        panels[5].add(cb_buff[I_IOE]);

        //�L���[�u[�I�[�K]
        cb_buff[I_COE] = new JCheckBox("�L���[�u[�I�[�K]");
        cb_buff[I_COE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_COE].addActionListener(this);
        panels[5].add(cb_buff[I_COE]);

        //�R���Z���g���[�V����
        cb_buff[I_CON] = new JCheckBox("�R���Z���g���[�V����");
        cb_buff[I_CON].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_CON].addActionListener(this);
        panels[5].add(cb_buff[I_CON]);

        //*�}�C���h �u���C�N
        cb_buff[I_MBK] = new JCheckBox("*�}�C���h �u���C�N");
        cb_buff[I_MBK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_MBK].addActionListener(this);
        cb_buff[I_MBK].setEnabled(false);
        panels[5].add(cb_buff[I_MBK]);

        //*�{�[�� �u���C�N
        cb_buff[I_BBK] = new JCheckBox("*�{�[�� �u���C�N");
        cb_buff[I_BBK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_BBK].addActionListener(this);
        cb_buff[I_BBK].setEnabled(false);
        panels[5].add(cb_buff[I_BBK]);

        //�L���[�u[�S�[����]
        cb_buff[I_CGM] = new JCheckBox("�L���[�u[�S�[����]");
        cb_buff[I_CGM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_CGM].addActionListener(this);
        panels[5].add(cb_buff[I_CGM]);

        //�y�C�V�F���X
        cb_buff[I_PAE] = new JCheckBox("�y�C�V�F���X");
        cb_buff[I_PAE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_PAE].addActionListener(this);
        panels[5].add(cb_buff[I_PAE]);

        //*�t�@���^�Y��
        cb_buff[I_PHM] = new JCheckBox("*�t�@���^�Y��");
        cb_buff[I_PHM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_PHM].addActionListener(this);
        cb_buff[I_PHM].setEnabled(false);
        panels[5].add(cb_buff[I_PHM]);

        //*�A�C�Y �u���C�J�[
        cb_buff[I_IBR] = new JCheckBox("*�A�C�Y �u���C�J�[");
        cb_buff[I_IBR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_IBR].addActionListener(this);
        cb_buff[I_IBR].setEnabled(false);
        panels[5].add(cb_buff[I_IBR]);

        //�L���[�u[���b�`]
        cb_buff[I_CRH] = new JCheckBox("�L���[�u[���b�`]");
        cb_buff[I_CRH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_CRH].addActionListener(this);
        panels[5].add(cb_buff[I_CRH]);

        //�C���T�C�g
        cb_buff[I_INS] = new JCheckBox("�C���T�C�g");
        cb_buff[I_INS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_INS].addActionListener(this);
        panels[5].add(cb_buff[I_INS]);

        //*�p�j�b�N
        cb_buff[I_PAC] = new JCheckBox("*�p�j�b�N");
        cb_buff[I_PAC].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_PAC].addActionListener(this);
        cb_buff[I_PAC].setEnabled(false);
        panels[5].add(cb_buff[I_PAC]);

        //���f���[�X �E�F�C�g
        cb_buff[I_RWT] = new JCheckBox("���f���[�X �E�F�C�g");
        cb_buff[I_RWT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_RWT].addActionListener(this);
        panels[5].add(cb_buff[I_RWT]);

        //�C�����[�W����[�A�o�^�[]
        cb_buff[I_IAR] = new JCheckBox("�C�����[�W����[�A�o�^�[]");
        cb_buff[I_IAR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_IAR].addActionListener(this);
        panels[5].add(cb_buff[I_IAR]);

        //�L���[�u[�A�o�^�[]
        cb_buff[I_CAR] = new JCheckBox("�L���[�u[�A�o�^�[]");
        cb_buff[I_CAR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_CAR].addActionListener(this);
        panels[5].add(cb_buff[I_CAR]);

        //�C���p�N�g
        cb_buff[I_IMT] = new JCheckBox("�C���p�N�g");
        cb_buff[I_IMT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_IMT].addActionListener(this);
        panels[5].add(cb_buff[I_IMT]);

        //�t�H�[�J�X �X�s���b�c
        cb_buff[I_FSZ] = new JCheckBox("�t�H�[�J�X �X�s���b�c");
        cb_buff[I_FSZ].setBounds(200 * row, 20 * col++, 180, 20);
        cb_buff[I_FSZ].addActionListener(this);
        panels[5].add(cb_buff[I_FSZ]);

        //*���r�E�X
        cb_buff[I_MES] = new JCheckBox("*���r�E�X");
        cb_buff[I_MES].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_MES].addActionListener(this);
        cb_buff[I_MES].setEnabled(false);
        panels[5].add(cb_buff[I_MES]);

        //*�|�e���V����
        cb_buff[I_POL] = new JCheckBox("*�|�e���V����");
        cb_buff[I_POL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_POL].addActionListener(this);
        cb_buff[I_POL].setEnabled(false);
        panels[5].add(cb_buff[I_POL]);

        col++;

        lab_tmp = new JLabel("�p�b�V�u�X�L��");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[5].add(lab_tmp);

        //*�_�[�N�z�[�X
        cb_buff[I_DHE] = new JCheckBox("*�_�[�N�z�[�X");
        cb_buff[I_DHE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_DHE].addActionListener(this);
        cb_buff[I_DHE].setEnabled(false);
        panels[5].add(cb_buff[I_DHE]);

        //�C�����[�W����[���b�`]
        cb_buff[I_IRH] = new JCheckBox("�C�����[�W����[���b�`]");
        cb_buff[I_IRH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_IRH].addActionListener(this);
        panels[5].add(cb_buff[I_IRH]);

        //�C�����[�W����[�S�[����]
        cb_buff[I_IGM] = new JCheckBox("�C�����[�W����[�S�[����]");
        cb_buff[I_IGM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_IGM].addActionListener(this);
        panels[5].add(cb_buff[I_IGM]);

        //*�{�[�� �u���C�N:���X�g
        cb_buff[I_BBL] = new JCheckBox("*�{�[�� �u���C�N:���X�g");
        cb_buff[I_BBL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[I_BBL].addActionListener(this);
        cb_buff[I_BBL].setEnabled(false);
        panels[5].add(cb_buff[I_BBL]);

        col = 0;
        row = 2;

        lab_tmp = new JLabel("��m�Z�p");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[5].add(lab_tmp);

        //*�n�E��
        cb_buff[S_HOL] = new JCheckBox("*�n�E��");
        cb_buff[S_HOL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_HOL].addActionListener(this);
        cb_buff[S_HOL].setEnabled(false);
        panels[5].add(cb_buff[S_HOL]);

        //�M�K���e�B�b�N
        cb_buff[S_GIC] = new JCheckBox("�M�K���e�B�b�N");
        cb_buff[S_GIC].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_GIC].addActionListener(this);
        panels[5].add(cb_buff[S_GIC]);

        //*�p���[�O���b�v
        cb_buff[S_PGP] = new JCheckBox("*�p���[�O���b�v");
        cb_buff[S_PGP].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_PGP].addActionListener(this);
        cb_buff[S_PGP].setEnabled(false);
        panels[5].add(cb_buff[S_PGP]);

        //*�g�}�z�[�N
        cb_buff[S_TOK] = new JCheckBox("*�g�}�z�[�N");
        cb_buff[S_TOK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_TOK].addActionListener(this);
        cb_buff[S_TOK].setEnabled(false);
        panels[5].add(cb_buff[S_TOK]);

        //*�f�X�y���[�h
        cb_buff[S_DEO] = new JCheckBox("*�f�X�y���[�h");
        cb_buff[S_DEO].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_DEO].addActionListener(this);
        cb_buff[S_DEO].setEnabled(false);
        panels[5].add(cb_buff[S_DEO]);

        //*�^�C�^�����C�W���O
        cb_buff[S_TRG] = new JCheckBox("*�^�C�^�����C�W���O");
        cb_buff[S_TRG].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_TRG].addActionListener(this);
        cb_buff[S_TRG].setEnabled(false);
        panels[5].add(cb_buff[S_TRG]);

        //*�f�����b�V����
        cb_buff[S_DEN] = new JCheckBox("*�f�����b�V����");
        cb_buff[S_DEN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_DEN].addActionListener(this);
        cb_buff[S_DEN].setEnabled(false);
        panels[5].add(cb_buff[S_DEN]);

        //*�o�[�T�[�N
        cb_buff[S_BER] = new JCheckBox("*�o�[�T�[�N");
        cb_buff[S_BER].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_BER].addActionListener(this);
        cb_buff[S_BER].setEnabled(false);
        panels[5].add(cb_buff[S_BER]);

        col++;

        lab_tmp = new JLabel("�p�b�V�u�X�L��");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[5].add(lab_tmp);

        //�t���[���[
        cb_buff[S_FUY] = new JCheckBox("�t���[���[");
        cb_buff[S_FUY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_FUY].addActionListener(this);
        panels[5].add(cb_buff[S_FUY]);

        //*�X���C���[
        cb_buff[S_SLR] = new JCheckBox("*�X���C���[");
        cb_buff[S_SLR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_SLR].addActionListener(this);
        cb_buff[S_SLR].setEnabled(false);
        panels[5].add(cb_buff[S_SLR]);

        //�N���b�V��
        cb_buff[S_CRH] = new JCheckBox("�N���b�V��");
        cb_buff[S_CRH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_CRH].addActionListener(this);
        panels[5].add(cb_buff[S_CRH]);

        //�A�[�}�[�K�[�h
        cb_buff[S_AGD] = new JCheckBox("�A�[�}�[�K�[�h");
        cb_buff[S_AGD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_AGD].addActionListener(this);
        panels[5].add(cb_buff[S_AGD]);

        //*�^�C�^�����b�N
        cb_buff[S_TLK] = new JCheckBox("*�^�C�^�����b�N");
        cb_buff[S_TLK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_TLK].addActionListener(this);
        cb_buff[S_TLK].setEnabled(false);
        panels[5].add(cb_buff[S_TLK]);

        //*�^�C�^���}�W�b�N
        cb_buff[S_TMC] = new JCheckBox("*�^�C�^���}�W�b�N");
        cb_buff[S_TMC].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_TMC].addActionListener(this);
        cb_buff[S_TMC].setEnabled(false);
        panels[5].add(cb_buff[S_TMC]);

        //*�^�C�^���u���b�c
        cb_buff[S_TBZ] = new JCheckBox("*�^�C�^���u���b�c");
        cb_buff[S_TBZ].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_TBZ].addActionListener(this);
        cb_buff[S_TBZ].setEnabled(false);
        panels[5].add(cb_buff[S_TBZ]);

        //*�f�X�y���[�h:�A�u�\�����[�g
        cb_buff[S_DAE] = new JCheckBox("*�f�X�y���[�h:�A�u�\�����[�g");
        cb_buff[S_DAE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[S_DAE].addActionListener(this);
        cb_buff[S_DAE].setEnabled(false);
        panels[5].add(cb_buff[S_DAE]);

        col = 0;
        row = 3;

        lab_tmp = new JLabel("���m�Z�p");
        lab_tmp.setBounds(200 * row, 20 * col++, 100, 20);
        panels[5].add(lab_tmp);

        //�A�N�e�B�u�X�L��
        //*�u���[�h
        cb_buff[F_ABE] = new JCheckBox("*�u���[�h");
        cb_buff[F_ABE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_ABE].addActionListener(this);
        cb_buff[F_ABE].setEnabled(false);
        panels[5].add(cb_buff[F_ABE]);

        //*�t�@���g��
        cb_buff[F_APM] = new JCheckBox("*�t�@���g��");
        cb_buff[F_APM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_APM].addActionListener(this);
        cb_buff[F_APM].setEnabled(false);
        panels[5].add(cb_buff[F_APM]);

        //*�W���b�W�����g
        cb_buff[F_AJT] = new JCheckBox("*�W���b�W�����g");
        cb_buff[F_AJT].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_AJT].addActionListener(this);
        cb_buff[F_AJT].setEnabled(false);
        panels[5].add(cb_buff[F_AJT]);

        //*�w���t�@�C�A
        cb_buff[F_AHE] = new JCheckBox("*�w���t�@�C�A");
        cb_buff[F_AHE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_AHE].addActionListener(this);
        cb_buff[F_AHE].setEnabled(false);
        panels[5].add(cb_buff[F_AHE]);

        //*�p���e��
        cb_buff[F_APA] = new JCheckBox("*�p���e��");
        cb_buff[F_APA].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_APA].addActionListener(this);
        cb_buff[F_APA].setEnabled(false);
        panels[5].add(cb_buff[F_APA]);

        //*�A�V����
        cb_buff[F_AAA] = new JCheckBox("*�A�V����");
        cb_buff[F_AAA].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_AAA].addActionListener(this);
        cb_buff[F_AAA].setEnabled(false);
        panels[5].add(cb_buff[F_AAA]);

        col++;

        lab_tmp = new JLabel("�p�b�V�u�X�L��");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[5].add(lab_tmp);

        //*�_�}�X�J�X
        cb_buff[F_PDS] = new JCheckBox("*�_�}�X�J�X");
        cb_buff[F_PDS].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PDS].addActionListener(this);
        cb_buff[F_PDS].setEnabled(false);
        panels[5].add(cb_buff[F_PDS]);

        //*�t���C��
        cb_buff[F_PFE] = new JCheckBox("*�t���C��");
        cb_buff[F_PFE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PFE].addActionListener(this);
        cb_buff[F_PFE].setEnabled(false);
        panels[5].add(cb_buff[F_PFE]);

        //���C�W
        cb_buff[F_PRE] = new JCheckBox("���C�W");
        cb_buff[F_PRE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PRE].addActionListener(this);
        panels[5].add(cb_buff[F_PRE]);

        //*�T���@�C��
        cb_buff[F_PSE] = new JCheckBox("*�T���@�C��");
        cb_buff[F_PSE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PSE].addActionListener(this);
        cb_buff[F_PSE].setEnabled(false);
        panels[5].add(cb_buff[F_PSE]);

        //�C���t�B�j�e�B:�A�[�}�[
        cb_buff[F_PIR] = new JCheckBox("�C���t�B�j�e�B:�A�[�}�[");
        cb_buff[F_PIR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PIR].addActionListener(this);
        panels[5].add(cb_buff[F_PIR]);

        //�C���t�B�j�e�B:�h�b�W
        cb_buff[F_PIE] = new JCheckBox("�C���t�B�j�e�B:�h�b�W");
        cb_buff[F_PIE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PIE].addActionListener(this);
        panels[5].add(cb_buff[F_PIE]);

        //�C���t�B�j�e�B:�u���b�h
        cb_buff[F_PID] = new JCheckBox("�C���t�B�j�e�B:�u���b�h");
        cb_buff[F_PID].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PID].addActionListener(this);
        panels[5].add(cb_buff[F_PID]);

        //�C���t�B�j�e�B:�u���b�c
        cb_buff[F_PIZ] = new JCheckBox("�C���t�B�j�e�B:�u���b�c");
        cb_buff[F_PIZ].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PIZ].addActionListener(this);
        panels[5].add(cb_buff[F_PIZ]);

        //*�p���h�b�N�X
        cb_buff[F_PPX] = new JCheckBox("*�p���h�b�N�X");
        cb_buff[F_PPX].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PPX].addActionListener(this);
        cb_buff[F_PPX].setEnabled(false);
        panels[5].add(cb_buff[F_PPX]);

        //*�t�@���g��:���[�p�[
        cb_buff[F_PPR] = new JCheckBox("*�t�@���g��:���[�p�[");
        cb_buff[F_PPR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PPR].addActionListener(this);
        cb_buff[F_PPR].setEnabled(false);
        panels[5].add(cb_buff[F_PPR]);

        //*�t�@���g��:�f�X
        cb_buff[F_PPH] = new JCheckBox("*�t�@���g��:�f�X");
        cb_buff[F_PPH].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PPH].addActionListener(this);
        cb_buff[F_PPH].setEnabled(false);
        panels[5].add(cb_buff[F_PPH]);

        //*�p���e��:�V���b�N
        cb_buff[F_PPK] = new JCheckBox("*�p���e��:�V���b�N");
        cb_buff[F_PPK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PPK].addActionListener(this);
        cb_buff[F_PPK].setEnabled(false);
        panels[5].add(cb_buff[F_PPK]);

        //*�O���[�X
        cb_buff[F_PGE] = new JCheckBox("*�O���[�X");
        cb_buff[F_PGE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[F_PGE].addActionListener(this);
        cb_buff[F_PGE].setEnabled(false);
        panels[5].add(cb_buff[F_PGE]);

        col = 0;
        row = 4;

        lab_tmp = new JLabel("���m�Z�p");
        lab_tmp.setBounds(200 * row, 20 * col++, 100, 20);
        panels[5].add(lab_tmp);

        //*�I���e�B�l�[�g
        cb_buff[L_ALE] = new JCheckBox("*�I���e�B�l�[�g");
        cb_buff[L_ALE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_ALE].addActionListener(this);
        cb_buff[L_ALE].setEnabled(false);
        panels[5].add(cb_buff[L_ALE]);

        //*�t�H�[�X �E�F�[�u
        cb_buff[L_FWE] = new JCheckBox("*�t�H�[�X �E�F�[�u");
        cb_buff[L_FWE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_FWE].addActionListener(this);
        cb_buff[L_FWE].setEnabled(false);
        panels[5].add(cb_buff[L_FWE]);

        //*���@���K�[�h
        cb_buff[L_VAD] = new JCheckBox("*���@���K�[�h");
        cb_buff[L_VAD].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_VAD].addActionListener(this);
        cb_buff[L_VAD].setEnabled(false);
        panels[5].add(cb_buff[L_VAD]);

        //*���J�o���[
        cb_buff[L_REY] = new JCheckBox("*���J�o���[");
        cb_buff[L_REY].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_REY].addActionListener(this);
        cb_buff[L_REY].setEnabled(false);
        panels[5].add(cb_buff[L_REY]);

        //*�v���b�V���[
        cb_buff[L_PRE] = new JCheckBox("*�v���b�V���[");
        cb_buff[L_PRE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_PRE].addActionListener(this);
        cb_buff[L_PRE].setEnabled(false);
        panels[5].add(cb_buff[L_PRE]);

        //*�N���[�G��
        cb_buff[L_KRL] = new JCheckBox("*�N���[�G��");
        cb_buff[L_KRL].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_KRL].addActionListener(this);
        cb_buff[L_KRL].setEnabled(false);
        panels[5].add(cb_buff[L_KRL]);

        col++;

        lab_tmp = new JLabel("�p�b�V�u�X�L��");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[5].add(lab_tmp);

        //*�N���[�G��:�R���r�N�V����
        cb_buff[L_KCN] = new JCheckBox("*�N���[�G��:�R���r�N�V����");
        cb_buff[L_KCN].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_KCN].addActionListener(this);
        cb_buff[L_KCN].setEnabled(false);
        panels[5].add(cb_buff[L_KCN]);

        //*�v���b�V���[:�f�X ���R�[��
        cb_buff[L_PDR] = new JCheckBox("*�v���b�V���[:�f�X ���R�[��");
        cb_buff[L_PDR].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_PDR].addActionListener(this);
        cb_buff[L_PDR].setEnabled(false);
        panels[5].add(cb_buff[L_PDR]);

        //*�h�b�W �u���C�N
        cb_buff[L_DBK] = new JCheckBox("*�h�b�W �u���C�N");
        cb_buff[L_DBK].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_DBK].addActionListener(this);
        cb_buff[L_DBK].setEnabled(false);
        panels[5].add(cb_buff[L_DBK]);

        //*���C���X�g����
        cb_buff[L_MAM] = new JCheckBox("*���C���X�g����");
        cb_buff[L_MAM].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_MAM].addActionListener(this);
        cb_buff[L_MAM].setEnabled(false);
        panels[5].add(cb_buff[L_MAM]);

        //*�f�b�h���[ �X�g���C�N
        cb_buff[L_DSE] = new JCheckBox("*�f�b�h���[ �X�g���C�N");
        cb_buff[L_DSE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_DSE].addActionListener(this);
        cb_buff[L_DSE].setEnabled(false);
        panels[5].add(cb_buff[L_DSE]);

        //*���F���W�F���X
        cb_buff[L_VEE] = new JCheckBox("*���F���W�F���X");
        cb_buff[L_VEE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_VEE].addActionListener(this);
        cb_buff[L_VEE].setEnabled(false);
        panels[5].add(cb_buff[L_VEE]);

        //*�^�N�e�B�J�� �A�h�o���X
        cb_buff[L_TAE] = new JCheckBox("*�^�N�e�B�J�� �A�h�o���X");
        cb_buff[L_TAE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_TAE].addActionListener(this);
        cb_buff[L_TAE].setEnabled(false);
        panels[5].add(cb_buff[L_TAE]);

        //*�C���N���[�Y �����W
        cb_buff[L_IRE] = new JCheckBox("*�C���N���[�Y �����W");
        cb_buff[L_IRE].setBounds(200 * row, 20 * col++, 200, 20);
        cb_buff[L_IRE].addActionListener(this);
        cb_buff[L_IRE].setEnabled(false);
        panels[5].add(cb_buff[L_IRE]);

//        MP mp = new MP();

//        for (JCheckBox buff : cb_buff) {
//           if (buff != null) {
//                panels[2].add(buff);
//                buff.addMouseListener(mp);
//                buff.addActionListener(this);
//            }
//        }

//        for (JComboBox buff_group : cb_buff_group) {
//            if (buff_group != null) {
//                panels[2].add(buff_group);
//                buff_group.addActionListener(this);
//            }
//        }

        //----------
        //�p�l��6
        //----------
        lab_tmp = new JLabel("�ϐ�", SwingConstants.CENTER);
        lab_tmp.setBounds(0, 0, 200, 25);
        panels[6].add(lab_tmp);
        for (int i = 0; i < ELEM_LIST.length; i++) {
            JLabel lab = new JLabel(ELEM_LIST[i], SwingConstants.CENTER);
            lab.setBounds(0, 25 + i * 25, 100, 25);
            panels[6].add(lab);
            s_target_res[i] = new JSlider(-100, 100, 0);
            s_target_res[i].setBounds(100, 25 + i * 25, 100, 25);
            s_target_res[i].addChangeListener(this);
            panels[6].add(s_target_res[i]);
            lab_target_resist[i] = new JLabel("0", SwingConstants.CENTER);
            lab_target_resist[i].setBounds(200, 25 + i * 25, 100, 25);
            panels[6].add(lab_target_resist[i]);
        }

        lab_tmp = new JLabel("MR", SwingConstants.CENTER);
        lab_tmp.setBounds(0, 125, 100, 25);
        panels[6].add(lab_tmp);
        s_target_mr = new JSlider(0, 200, 100);
        s_target_mr.setBounds(100, 125, 100, 25);
        s_target_mr.addChangeListener(this);
        panels[6].add(s_target_mr);
        lab_target_mr = new JLabel("100", SwingConstants.CENTER);
        lab_target_mr.setBounds(200, 125, 100, 25);
        panels[6].add(lab_target_mr);

        lab_tmp = new JLabel("�Ώ�", SwingConstants.CENTER);
        lab_tmp.setBounds(0, 175, 100, 25);
        panels[6].add(lab_tmp);
        String mode_list[] = {"NPC", "PC"};
        cb_mode_pc = new JComboBox(mode_list);
        cb_mode_pc.setBounds(100, 175, 100, 25);
        panels[6].add(cb_mode_pc);

        lab_tmp = new JLabel("AC", SwingConstants.CENTER);
        lab_tmp.setBounds(0, 200, 100, 25);
        panels[6].add(lab_tmp);
        String target_ac_list[] = new String[256];
        for (int i = 0; i < target_ac_list.length; i++) {
            target_ac_list[i] = Integer.toString(10 - i);
        }
        cb_target_ac = new JComboBox(target_ac_list);
        cb_target_ac.setBounds(100, 200, 100, 25);
        panels[6].add(cb_target_ac);
        cb_hittyuu = new JCheckBox("�K��");
        cb_hittyuu.addActionListener(this);
        cb_hittyuu.setBounds(220, 200, 100, 25);
        panels[6].add(cb_hittyuu);

        String[] dr_list = new String[61];
        for (int i = 0; i <= 60; i++) {
        //    dr_list[i] = Integer.toString(i - 30);
            dr_list[i] = Integer.toString(i);
        }

        cb_target_dr = new JComboBox(dr_list);
        //cb_target_dr.setSelectedIndex(30);
        cb_target_dr.setSelectedIndex(0);                   //����DR�̒l
        lab_tmp = new JLabel("DR", SwingConstants.CENTER);
        cb_target_dr.addActionListener(this);
        cb_target_dr.setBounds(100, 225, 100, 25);
        lab_tmp.setBounds(0, 225, 100, 25);
        panels[6].add(cb_target_dr);
        panels[6].add(lab_tmp);

        lab_tmp = new JLabel("DG", SwingConstants.CENTER);
        lab_tmp.setBounds(0, 250, 100, 25);
        panels[6].add(lab_tmp);
        String dg_list[] = {"+50", "0", "-50"};
        cb_target_dg = new JComboBox(dg_list);
        cb_target_dg.setSelectedIndex(1);
        cb_target_dg.addActionListener(this);

        cb_target_dg.setBounds(100, 250, 100, 25);
        panels[6].add(cb_target_dg);

        cb_sonsyou = new JCheckBox("����");
        cb_sonsyou.addActionListener(this);
        cb_sonsyou.setBounds(220, 175, 100, 25);
        panels[6].add(cb_sonsyou);

        lab_tmp = new JLabel("�V�K�ݒ�", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 25, 100, 25);
        panels[6].add(lab_tmp);
        tf_res_name = new JTextField("");
        tf_res_name.setBounds(520, 25, 100, 25);
        panels[6].add(tf_res_name);
        bt_save_res = new JButton("�쐬");
        bt_save_res.setActionCommand("save_res");
        bt_save_res.addActionListener(this);
        bt_save_res.setBounds(620, 25, 100, 25);
        panels[6].add(bt_save_res);

        lab_tmp = new JLabel("�ݒ胊�X�g", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 50, 100, 25);
        panels[6].add(lab_tmp);
        cb_res = new JComboBox();
        cb_res.setBounds(520, 50, 100, 25);
        panels[6].add(cb_res);
        bt_load_res = new JButton("�ǂݍ���");
        bt_load_res.setActionCommand("load_res");
        bt_load_res.addActionListener(this);
        bt_load_res.setBounds(620, 50, 100, 25);
        panels[6].add(bt_load_res);
        bt_ow_res = new JButton("�㏑��");
        bt_ow_res.setActionCommand("ow_res");
        bt_ow_res.addActionListener(this);
        bt_ow_res.setBounds(620, 75, 100, 25);
        panels[6].add(bt_ow_res);
        bt_del_res = new JButton("�폜");
        bt_del_res.setActionCommand("del_res");
        bt_del_res.addActionListener(this);
        bt_del_res.setBounds(620, 100, 100, 25);
        panels[6].add(bt_del_res);

        lab_tmp = new JLabel("�N����", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 125, 100, 25);
        panels[6].add(lab_tmp);
        JButton bt_default = new JButton("�ύX");
        bt_default.setBounds(620, 125, 100, 25);
        bt_default.addActionListener(this);
        bt_default.setActionCommand("change_default");
        panels[6].add(bt_default);
        lab_default = new JLabel();
        lab_default.setHorizontalAlignment(SwingConstants.CENTER);
        lab_default.setBounds(520, 125, 100, 25);
        panels[6].add(lab_default);

        refresh();

        lab_tmp = new JLabel("�ȈՌv�Z�@", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 250, 200, 25);
        panels[6].add(lab_tmp);

        lab_tmp = new JLabel("HP", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 300, 100, 25);
        panels[6].add(lab_tmp);
        tf_e_hp = new JTextField("4000");
        tf_e_hp.setBounds(520, 300, 100, 25);
        tf_e_hp.addActionListener(this);
        panels[6].add(tf_e_hp);

        lab_tmp = new JLabel("HPR [/5sec]", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 325, 100, 25);
        panels[6].add(lab_tmp);
        tf_e_hpr = new JTextField("250");
        tf_e_hpr.setBounds(520, 325, 100, 25);
        tf_e_hpr.addActionListener(this);
        panels[6].add(tf_e_hpr);

        lab_tmp = new JLabel("�^�C�v", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 350, 100, 25);
        panels[6].add(lab_tmp);
        String[] type_list = {"�ʏ�", "����", "�s��"};
        cb_e_type = new JComboBox(type_list);
        cb_e_type.setBounds(520, 350, 100, 25);
        cb_e_type.addActionListener(this);
        panels[6].add(cb_e_type);

        lab_tmp = new JLabel("�T�C�Y", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 375, 100, 25);
        panels[6].add(lab_tmp);
        String[] size_list = {"��", "��"};
        cb_e_size = new JComboBox(size_list);
        cb_e_size.setBounds(520, 375, 100, 25);
        cb_e_size.addActionListener(this);
        panels[6].add(cb_e_size);

        lab_tmp = new JLabel("�퓬����(����)", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 425, 100, 25);
        panels[6].add(lab_tmp);
        lab_time = new JLabel();
        lab_time.setBounds(520, 425, 100, 25);
        panels[6].add(lab_time);

        try {
            try (BufferedReader br = new BufferedReader(new FileReader("./res/default"))) {
                lab_default.setText(br.readLine());
                pre_load_res();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

//        String[] kago_list = {"�Ȃ�", "����", "�n���E�B��"};
//        cb_kago = new JComboBox(kago_list);
//        JLabel kagolab = new JLabel("����", SwingConstants.CENTER);
//        kagolab.setBounds(0, 350, 100, 25);
//        kago.setBounds(100, 350, 100, 25);
//        panel4.add(kago);
//        panel4.add(kagolab);
//        kago.addActionListener(data);
//
//        i2h = new JToggleButton("I2H");
//        i2h.setBounds(100, 375, 100, 25);
//        panel4.add(i2h);
//        i2h.addActionListener(data);
//
//        ab = new JToggleButton("AB");
//        ab.setBounds(100, 400, 100, 25);
//        panel4.add(ab);
//        ab.addActionListener(data);
//
//        JLabel speedlab = new JLabel("�U�����x", SwingConstants.CENTER);
//        speedlab.setBounds(0, 425, 100, 25);
//        panel4.add(speedlab);
//        enemy_speed = new JFormattedTextField(60.0);
//        enemy_speed.setBounds(100, 425, 100, 25);
//        enemy_speed.addActionListener(data);
//        panel4.add(enemy_speed);
//
//        cb = new JToggleButton("CB");
//        cb.setBounds(100, 450, 100, 25);
//        cb.addActionListener(data);
//        panel4.add(cb);
//
//        hangyaku = new JToggleButton("���t�҂̏�");
//        String[] en = {"+0", "+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9"};
//        hangyaku_enchant = new JComboBox(en);
//        hangyaku.setBounds(100, 475, 100, 25);
//        hangyaku_enchant.setBounds(200, 475, 100, 25);
//        panel4.add(hangyaku);
//        panel4.add(hangyaku_enchant);
        tabpane.addChangeListener(this);
        init_mem();
        calc.update();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("change_default")) {
            try {
                lab_default.setText((String) cb_res.getSelectedItem());
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./res/default"))) {
                    bw.write((String) cb_res.getSelectedItem());
                    bw.flush();
                }
            } catch (IOException ex) {
            }
            return;
        }

        if (e.getActionCommand().equals("ow_res")) {
            ow_res();
        }

        if (e.getActionCommand().equals("save_res")) {
            String s = (String) cb_res.getSelectedItem();
            save_res();
            refresh();
            cb_res.setSelectedItem(s);
            return;
        }
        if (e.getActionCommand().equals("load_res")) {
            load_res();
            return;
        }

        if (e.getActionCommand().equals("del_res")) {
            del_res();
            refresh();
            return;
        }

        if (e.getActionCommand().equals("ow")) {
            mem.copy_to_mem(curr);

            File f = file;
            if (f != null) {
                int ret = JOptionPane.showConfirmDialog(this, f.getName() + "���㏑�����܂�", "�m�F", JOptionPane.YES_NO_OPTION);
                if (ret == JOptionPane.NO_OPTION) {
                    return;
                }
                try {
                    try (FileOutputStream fos = new FileOutputStream(f)) {
                        StreamResult result = new StreamResult(fos);

                        TransformerFactory transFactory = TransformerFactory.newInstance();
                        Transformer transformer = transFactory.newTransformer();

                        transformer.setOutputProperty("encoding", "UTF-8");
                        transformer.setOutputProperty("indent", "yes");

                        DOMSource source = new DOMSource(createDocument());
                        transformer.transform(source, result);
                    }
                } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException ex) {

                }
            }
            return;
        }

        if (e.getActionCommand().equals("save")) {
            mem.copy_to_mem(curr);

            JFileChooser fc;
            if (f_save_path == null) {
                fc = new JFileChooser();
            } else {
                fc = new JFileChooser(f_save_path);
            }
            fc.setFileFilter(new FileNameExtensionFilter("*.xml", "xml"));

            int ret = fc.showSaveDialog(this);

            File f = null;
            if (ret == JFileChooser.APPROVE_OPTION) {
                f = fc.getSelectedFile();
            }
            if (f != null) {
                if (f.exists()) {
                    int c = JOptionPane.showConfirmDialog(this, f.getName() + "���㏑�����܂�", "�m�F", JOptionPane.YES_NO_OPTION);
                    if (c == JOptionPane.NO_OPTION) {
                        return;
                    }
                }

                file = f;
                setTitle(file.getPath());

                if (!f.getName().endsWith(".xml")) {
                    f = new File(fc.getSelectedFile().getPath() + ".xml");
                }
                try {
                    try (FileOutputStream fos = new FileOutputStream(f)) {
                        StreamResult result = new StreamResult(fos);

                        TransformerFactory transFactory = TransformerFactory.newInstance();
                        Transformer transformer = transFactory.newTransformer();

                        transformer.setOutputProperty("encoding", "UTF-8");
                        transformer.setOutputProperty("indent", "yes");

                        DOMSource source = new DOMSource(createDocument());
                        transformer.transform(source, result);
                    }
                } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException ex) {

                }
            }
            bt_ow.setEnabled(file != null);

            return;
        }
        if (e.getActionCommand().equals("load")) {
            JFileChooser fc;
            if (f_save_path == null) {
                fc = new JFileChooser();
            } else {
                fc = new JFileChooser(f_save_path);
            }
            fc.setFileFilter(new FileNameExtensionFilter("*.xml", "xml"));

            int ret = fc.showOpenDialog(this);
            File f = null;
            if (ret == JFileChooser.APPROVE_OPTION) {
                f = fc.getSelectedFile();
            }
            if (f != null) {
                init_mem();
                try {
                    if (f.getName().endsWith(".xml")) {
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        Document document = builder.parse(f);
                        loadDocument(document);

                        file = f;
                        setTitle(file.getPath());
                    }
                } catch (IOException | NumberFormatException | ParserConfigurationException | SAXException ex) {
                }
            }
            bt_ow.setEnabled(file != null);
            return;
        }

        if (isLoading) {
            return;
        }

        if (e.getActionCommand().equals("�A���[")) {
            switch (calc.buki.type) {
                case "�{�E":
                    try {
                        if (cb_arrow.getSelectedIndex() == -1) {
                            InputStream is = eq_files.getInputStream(arrow_entrys.get(0));
                            InputStreamReader isr = new InputStreamReader(is);
                            try (BufferedReader br = new BufferedReader(isr)) {
                                calc.buki.loadArrow(br);
                            }
                        } else {
                            InputStream is = eq_files.getInputStream(arrow_entrys.get(cb_arrow.getSelectedIndex()));
                            InputStreamReader isr = new InputStreamReader(is);
                            try (BufferedReader br = new BufferedReader(isr)) {
                                calc.buki.loadArrow(br);
                            }
                        }
                    } catch (IOException ex) {
//                        System.out.println(ex);
                    }
                    break;
                case "�K���g���b�g":
                    try {
                        if (cb_arrow.getSelectedIndex() == -1) {
                            InputStream is = eq_files.getInputStream(sting_entrys.get(0));
                            InputStreamReader isr = new InputStreamReader(is);
                            try (BufferedReader br = new BufferedReader(isr)) {
                                calc.buki.loadArrow(br);
                            }
                        } else {
                            InputStream is = eq_files.getInputStream(sting_entrys.get(cb_arrow.getSelectedIndex()));
                            InputStreamReader isr = new InputStreamReader(is);
                            try (BufferedReader br = new BufferedReader(isr)) {
                                calc.buki.loadArrow(br);
                            }
                        }
                    } catch (IOException ex) {
//                        System.out.println(ex);
                    }
                    break;
                default:
                    break;
            }
        }

        //�����̓ǂݍ���
        for (int i = 0; i < EQ_LIST.length; i++) {
            if (e.getSource().equals(cb_eq[i])) {
                try {
                    if (cb_eq[i].getSelectedIndex() >= 0) {
                        InputStream is = eq_files.getInputStream(eq_entrys[i].get(cb_eq[i].getSelectedIndex()));
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        switch (i) {
                            case 0:
                                calc.buki.load(br);
                                br.close();

                                switch (calc.buki.type) {
                                    case "�N���E":
                                        tf_buki_sp_rate.setEnabled(true);
                                        tf_buki_sp_rate.setText(Double.toString(calc.buki.critical_rate));
                                        break;
                                    case "�f���A���u���[�h":
                                        tf_buki_sp_rate.setEnabled(true);
                                        tf_buki_sp_rate.setText(Double
                                                .toString(calc.buki.double_hit_rate));
                                        break;
                                    case "�`�F�[���\�[�h":
                                        tf_buki_sp_rate.setEnabled(true);
                                        tf_buki_sp_rate.setText(Double
                                                .toString(calc.buki.week_point_exposure));
                                        break;
                                    default:
                                        if (cb_cls.getSelectedIndex() == S && !calc.buki.two_hands && calc.buki.type.equals("�݊�")) {
                                            tb_blessed2.setEnabled(true);
                                            cb_eq[1].setEnabled(true);
                                            cb_eq_en[1].setEnabled(true);
                                        } else {
                                            tb_blessed2.setEnabled(false);
                                            cb_eq[1].setEnabled(false);
                                            cb_eq_en[1].setEnabled(false);
                                            cb_eq[1].setSelectedIndex(0);
                                            cb_eq_en[1].setSelectedIndex(0);
                                        }
                                        tf_buki_sp_rate.setEnabled(false);
                                        tf_buki_sp_rate.setText("0.0");
                                        break;
                                }

                                //���@�f�B���C
                                if (calc.buki.magic_name.isEmpty()) {
                                    tf_mag_delay.setEnabled(false);
                                    tf_mag_delay.setText("0.0");
                                    tf_mag_power.setEnabled(false);
                                    tf_mag_delay.setText("0.0");
                                } else {
                                    tf_mag_delay.setEnabled(true);
                                    tf_mag_delay.setText(Double.toString(calc.buki.magic_delay));
                                    tf_mag_power.setEnabled(true);
                                    tf_mag_power.setText(Double.toString(calc.buki.magic_power));
                                }

                                cb_eq_en[i].removeAllItems();
                                for (int n = 0; n <= calc.buki.max_enchant; n++) {
                                    cb_eq_en[i].addItem(n);
                                }
                                // ���[�h���Ɉ��S���܂ŋ���
                                if (calc.buki.safety != 0) {
                                    cb_eq_en[i].setSelectedIndex(calc.buki.safety + 1);
                                }
                                calc.buki.checkEnchant();

                                if (calc.buki.element_enchant) {
                                    cb_elem_1.setEnabled(true);
                                } else {
                                    cb_elem_1.setSelectedIndex(0);
                                    cb_elem_1.setEnabled(false);
                                }

                                //���蕐��͏�����������
                                if (calc.buki.two_hands) {
                                    if (calc.bougu[0].type.equals("�V�[���h")) {
                                        cb_eq[1].setSelectedIndex(0);
                                    }
                                }
                                try {
                                    cb_arrow.removeAllItems();
                                    switch (calc.buki.type) {
                                        case "�{�E":
                                            for (ZipEntry arrow : arrow_entrys) {
                                                InputStream is2 = eq_files.getInputStream(arrow);
                                                InputStreamReader isr2 = new InputStreamReader(is2);
                                                BufferedReader br2 = new BufferedReader(isr2);

                                                String line;
                                                String name = "";
                                                while ((line = br2.readLine()) != null) {
                                                    if (line.startsWith("name=")) {
                                                        name = line.split("=")[1];
                                                    }
                                                }
                                                cb_arrow.addItem(name);
                                            }
                                            break;
                                        case "�K���g���b�g":
                                            for (ZipEntry sting : sting_entrys) {
                                                InputStream is2 = eq_files.getInputStream(sting);
                                                InputStreamReader isr2 = new InputStreamReader(is2);
                                                BufferedReader br2 = new BufferedReader(isr2);

                                                String line;
                                                String name = "";
                                                while ((line = br.readLine()) != null) {
                                                    if (line.startsWith("name=")) {
                                                        name = line.split("=")[1];
                                                    }
                                                }
                                                cb_arrow.addItem(name);
                                            }
                                    }

                                } catch (IOException ex) {
//                                    System.out.println(ex);
                                }
                                break;
                            case 1:
                                calc.buki2.load(br);
                                br.close();

                                cb_eq_en[i].removeAllItems();
                                for (int n = 0; n <= calc.buki2.max_enchant; n++) {
                                    cb_eq_en[i].addItem(n);
                                }
                                // ���[�h���Ɉ��S���܂ŋ���
                                if (calc.buki2.safety != 0) {
                                    cb_eq_en[i].setSelectedIndex(calc.buki2.safety + 1);
                                }
                                calc.buki2.checkEnchant();

                                if (calc.buki2.element_enchant) {
                                    cb_elem_2.setEnabled(true);
                                } else {
                                    cb_elem_2.setSelectedIndex(0);
                                    cb_elem_2.setEnabled(false);
                                }
                                break;
                            default:
                                calc.bougu[i - 2].load(br);
                                br.close();
                                cb_eq_en[i].removeAllItems();
                                for (int n = 0; n <= calc.bougu[i - 2].max_enchant; n++) {
                                    cb_eq_en[i].addItem(n);
                                }
                                // ���S��0�ȊO�̑��������[�h���Ɉ��S��+1�܂ŋ���
                                if (calc.bougu[i - 2].safety != 0) {
                                    cb_eq_en[i]
                                            .setSelectedIndex(calc.bougu[i - 2].safety + 1);
                                }
                                calc.bougu[i - 2].checkEnchant();
                                if (EQ_LIST[i].equals("�V���c")) {
                                    cb_ts_elem.setSelectedIndex(0);

                                    if (calc.bougu[i - 2].element_enchant) {
                                        cb_ts_elem.setEnabled(true);
                                        tb_ts_sp.setEnabled(false);
                                        tb_ts_sp.setSelected(false);
                                    } else if (calc.bougu[i - 2].name.contains("�̖��@��R")
                                            || calc.bougu[i - 2].name.contains("�̃X�^���ϐ�")
                                            || calc.bougu[i - 2].name.contains("�̃z�[���h�ϐ�")) {
                                        tb_ts_sp.setEnabled(true);
                                        cb_ts_elem.setSelectedIndex(0);
                                        cb_ts_elem.setEnabled(false);
                                    } else {
                                        cb_ts_elem.setSelectedIndex(0);
                                        cb_ts_elem.setEnabled(false);
                                        tb_ts_sp.setEnabled(false);
                                        tb_ts_sp.setSelected(false);
                                    }
                                }
                                if (calc.buki.two_hands) {
                                    if (calc.bougu[0].type.equals("�V�[���h")) {
                                        cb_eq[2].setSelectedIndex(0);
                                        cb_eq_en[2].setSelectedIndex(0);
                                    }
                                }
                                if (cb_eq[1].getSelectedIndex() > 0) {
                                    cb_eq[2].setSelectedIndex(0);
                                    cb_eq[2].setSelectedIndex(0);
                                }
                        }
                    }

                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (e.getActionCommand().equals("reset")) {
            init_mem();
            return;
        }

        if (e.getActionCommand().contains("up")) {
            switch (e.getActionCommand().split("/")[0]) {
                case "STR":
                    calc.addRem(STR);
                    break;
                case "DEX":
                    calc.addRem(DEX);
                    break;
                case "CON":
                    calc.addRem(CON);
                    break;
                case "WIS":
                    calc.addRem(WIS);
                    break;
                case "INT":
                    calc.addRem(INT);
                    break;
                case "CHA":
                    calc.addRem(CHA);
                    break;
                default:
                    break;
            }
        }
        if (e.getActionCommand().contains("down")) {
            switch (e.getActionCommand().split("/")[0]) {
                case "STR":
                    calc.removeRem(STR);
                    break;
                case "DEX":
                    calc.removeRem(DEX);
                    break;
                case "CON":
                    calc.removeRem(CON);
                    break;
                case "WIS":
                    calc.removeRem(WIS);
                    break;
                case "INT":
                    calc.removeRem(INT);
                    break;
                case "CHA":
                    calc.removeRem(CHA);
                    break;
                default:
                    break;
            }
        }

        calc.buki.enchant = cb_eq_en[0].getSelectedIndex();
        calc.buki2.enchant = cb_eq_en[1].getSelectedIndex();
        calc.buki.checkEnchant();
        calc.buki2.checkEnchant();
        for (int i = 2; i < EQ_LIST.length; i++) {
            calc.bougu[i - 2].enchant = cb_eq_en[i].getSelectedIndex();
            calc.bougu[i - 2].checkEnchant();
        }
        for (int i = 0; i < ELEM_LIST.length; i++) {
            calc.bougu[3].op.element_resist[i] = cb_ts_elem.getSelectedIndex() * 2;
        }
        calc.update();
    }

    final void refresh() {
        File res = new File("./res");
        if (!res.exists()) {
            res.mkdir();
        }

        File list[] = res.listFiles((File dir, String name1) -> name1.endsWith(".txt"));
        cb_res.removeAllItems();
        for (File f : list) {
            cb_res.addItem(f.getName().split(".txt")[0]);
        }
    }

    final void del_res() {
        File res = new File("./res/" + (String) cb_res.getSelectedItem() + ".txt");
        res.delete();
    }

    final void ow_res() {
        try {
            File res = new File("./res/" + (String) cb_res.getSelectedItem() + ".txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(res))) {
                for (int i = 0; i < ELEM_LIST.length; i++) {
                    writer.write(Integer.toString(s_target_res[i].getValue()));
                    writer.newLine();
                }
                writer.write(Integer.toString(s_target_mr.getValue()));
                writer.newLine();
                writer.write(Integer.toString(cb_mode_pc.getSelectedIndex()));
                writer.newLine();
                writer.write(Integer.toString(cb_target_ac.getSelectedIndex()));
                writer.newLine();
                writer.write(Integer.toString(cb_target_dr.getSelectedIndex()));
                writer.newLine();
                writer.write(Integer.toString(cb_target_dg.getSelectedIndex()));
                writer.newLine();
                writer.write(Boolean.toString(cb_sonsyou.isSelected()));
                writer.newLine();
                writer.write(Boolean.toString(cb_hittyuu.isSelected()));
                writer.newLine();
                writer.write(tf_e_hp.getText());
                writer.newLine();
                writer.write(tf_e_hpr.getText());
                writer.newLine();
                writer.write((String) cb_e_type.getSelectedItem());
                writer.newLine();
                writer.write((String) cb_e_size.getSelectedItem());
                writer.flush();
            }
        } catch (IOException ex) {
        }
    }

    final void pre_load_res() {

        try {
            File res = new File("./res/" + lab_default.getText() + ".txt");
            try (BufferedReader reader = new BufferedReader(new FileReader(res))) {
                for (int i = 0; i < ELEM_LIST.length; i++) {
                    s_target_res[i].setValue(Integer.parseInt(reader.readLine()));
                }
                s_target_mr.setValue(Integer.parseInt(reader.readLine()));
                cb_mode_pc.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_ac.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_dr.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_dg.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_sonsyou.setSelected(Boolean.parseBoolean(reader.readLine()));
                cb_hittyuu.setSelected(Boolean.parseBoolean(reader.readLine()));

                tf_e_hp.setText(reader.readLine());
                tf_e_hpr.setText(reader.readLine());
                cb_e_type.setSelectedItem(reader.readLine());
                cb_e_size.setSelectedItem(reader.readLine());
            }
        } catch (IOException | NumberFormatException ex) {
        }
//            System.out.println(ex);  
    }

    final void load_res() {
        try {
            File res = new File("./res/" + (String) cb_res.getSelectedItem() + ".txt");
            try (BufferedReader reader = new BufferedReader(new FileReader(res))) {
                for (int i = 0; i < ELEM_LIST.length; i++) {
                    s_target_res[i].setValue(Integer.parseInt(reader.readLine()));
                }
                s_target_mr.setValue(Integer.parseInt(reader.readLine()));
                cb_mode_pc.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_ac.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_dr.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_dg.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_sonsyou.setSelected(Boolean.parseBoolean(reader.readLine()));
                cb_hittyuu.setSelected(Boolean.parseBoolean(reader.readLine()));

                tf_e_hp.setText(reader.readLine());
                tf_e_hpr.setText(reader.readLine());
                cb_e_type.setSelectedItem(reader.readLine());
                cb_e_size.setSelectedItem(reader.readLine());
            }
        } catch (IOException ex) {
        }
    }

    final void save_res() {
        if (!"".equals(tf_res_name.getText())) {
            try {
                File res = new File("./res/" + tf_res_name.getText() + ".txt");
                if (!res.exists()) {
                    res.createNewFile();
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(res))) {
                    for (int i = 0; i < ELEM_LIST.length; i++) {
                        writer.write(Integer.toString(s_target_res[i].getValue()));
                        writer.newLine();
                    }
                    writer.write(Integer.toString(s_target_mr.getValue()));
                    writer.newLine();
                    writer.write(Integer.toString(cb_mode_pc.getSelectedIndex()));
                    writer.newLine();
                    writer.write(Integer.toString(cb_target_ac.getSelectedIndex()));
                    writer.newLine();
                    writer.write(Integer.toString(cb_target_dr.getSelectedIndex()));
                    writer.newLine();
                    writer.write(Integer.toString(cb_target_dg.getSelectedIndex()));
                    writer.newLine();
                    writer.write(Boolean.toString(cb_sonsyou.isSelected()));
                    writer.newLine();
                    writer.write(Boolean.toString(cb_hittyuu.isSelected()));
                    writer.newLine();
                    writer.write(tf_e_hp.getText());
                    writer.newLine();
                    writer.write(tf_e_hpr.getText());
                    writer.newLine();
                    writer.write((String) cb_e_type.getSelectedItem());
                    writer.newLine();
                    writer.write((String) cb_e_size.getSelectedItem());
                    writer.flush();
                }
            } catch (IOException ex) {
            }
            tf_res_name.setText("");
        }
    }

    boolean isLoading = false;

    final void loadEquip() {
        isLoading = true;
        try {
            Charset S_JIS = Charset.forName("Shift_JIS");
            eq_files = new ZipFile("./data/E.zip", S_JIS);
            arrow_entrys.clear();

            for (int i = 0; i < EQ_LIST.length; i++) {
                cb_eq[i].removeAllItems();
                eq_entrys[i].clear();

                String eq = "";
                Enumeration enumeration = eq_files.entries();
                while (enumeration.hasMoreElements()) {
                    ZipEntry entry = (ZipEntry) enumeration.nextElement();

                    if (entry.getName().startsWith("E/�A���[/a") && i == 0) {
                        arrow_entrys.add(entry);
                    }
                    if (entry.getName().startsWith("E/�A���[/s") && i == 0) {
                        sting_entrys.add(entry);
                    }

                    if (entry.getName().startsWith("E/" + EQ_LIST[i])) {
                        try (InputStream is = eq_files.getInputStream(entry); InputStreamReader ir = new InputStreamReader(is); BufferedReader br = new BufferedReader(ir)) {

                            String line;
                            while ((line = br.readLine()) != null) {
                                if (line.startsWith("����=")) {
                                    eq = line;
                                }
                            }
                            if (eq.contains(CLASS_LIST[cb_cls.getSelectedIndex()]) || eq.contains("ALL")) {
                                eq_entrys[i].add(entry);
                            }
                        }
                    }
                }

                try {
                    for (int j = 0; j < eq_entrys[i].size(); j++) {

                        InputStream is = eq_files.getInputStream(eq_entrys[i].get(j));
                        InputStreamReader ir = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(ir);
                        String line;
                        String name = "";
                        while ((line = br.readLine()) != null) {
                            if (line.startsWith("name=")) {
                                name = line.split("=")[1];
                            }
                        }
                        cb_eq[i].addItem(name);

                    }
                } catch (IOException e) {
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(UI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        isLoading = false;

    }

    class Memory implements ActionListener {

        String[][] EQ;//������
        int[][] EN;//�����G���`��
        boolean[] BL1;//�j��1
        boolean[] BL2;//�j��2
        int[] ELEM1;//���푮��1
        int[] ELEM2;//���푮��2
        int[] TS_ELEM;//TS���
        String[] ARROW;//��
        double[] SP_R;//����������
        double[] MAG_R;//���@������
        double[] MAG_D;//���@�f�B���C
        double[] MAG_P;//���@�З�
        boolean[] TS_SP;//����TS

        final int CH = 3;

        private Memory() {
            this.EQ = new String[EQ_LIST.length][CH];
            this.EN = new int[EQ_LIST.length][CH];
            this.BL1 = new boolean[CH];
            this.ELEM1 = new int[CH];
            this.BL2 = new boolean[CH];
            this.ELEM2 = new int[CH];
            this.TS_ELEM = new int[CH];
            this.ARROW = new String[CH];
            this.SP_R = new double[CH];
            this.MAG_R = new double[CH];
            this.MAG_D = new double[CH];
            this.MAG_P = new double[CH];
            this.TS_SP = new boolean[CH];
            for (int n = 0; n < CH; n++) {
                for (int i = 0; i < EQ_LIST.length; i++) {
                    this.EQ[i][n] = EQ_LIST[i];
                    this.EN[i][n] = 0;
                }
                this.BL1[n] = false;
                this.ELEM1[n] = 0;
                this.BL2[n] = false;
                this.ELEM2[n] = 0;
                this.TS_ELEM[n] = 0;
                this.ARROW[n] = "";
                this.SP_R[n] = 0;
                this.MAG_R[n] = -1;
                this.MAG_D[n] = 0;
                this.MAG_P[n] = 0;
                this.TS_SP[n] = false;
            }
        }

        void clear() {
            for (int n = 0; n < CH; n++) {
                for (int i = 0; i < EQ_LIST.length; i++) {
                    this.EQ[i][n] = EQ_LIST[i];
                    this.EN[i][n] = 0;
                }
                this.BL1[n] = false;
                this.ELEM1[n] = 0;
                this.BL2[n] = false;
                this.ELEM2[n] = 0;
                this.TS_ELEM[n] = 0;
                this.ARROW[n] = "";
                this.SP_R[n] = 0;
                this.MAG_R[n] = -1;
                this.MAG_D[n] = 0;
                this.MAG_P[n] = 0;
                this.TS_SP[n] = false;
            }
        }

        void copy_to_mem(int channel) {
            for (int i = 0; i < EQ_LIST.length; i++) {
                if (cb_eq[i].getSelectedItem() != null) {
                    this.EQ[i][channel] = cb_eq[i].getSelectedItem().toString();
                }
                this.EN[i][channel] = cb_eq_en[i].getSelectedIndex();
            }
            this.BL1[channel] = tb_blessed1.isSelected();
            this.ELEM1[channel] = cb_elem_1.getSelectedIndex();
            this.BL2[channel] = tb_blessed2.isSelected();
            this.ELEM2[channel] = cb_elem_2.getSelectedIndex();
            this.TS_ELEM[channel] = cb_ts_elem.getSelectedIndex();
            if (cb_arrow.getSelectedItem() != null) {
                this.ARROW[channel] = cb_arrow.getSelectedItem().toString();
            }
            this.SP_R[channel] = Double.parseDouble(tf_buki_sp_rate.getText());
            this.MAG_R[channel] = Double.parseDouble(tf_mag_rate.getText());
            this.MAG_D[channel] = Double.parseDouble(tf_mag_delay.getText());
            this.MAG_P[channel] = Double.parseDouble(tf_mag_power.getText());
            this.TS_SP[channel] = tb_ts_sp.isSelected();
        }

        private void load_from_mem(int channel) {
            for (int i = 0; i < EQ_LIST.length; i++) {
                cb_eq[i].setSelectedIndex(0);
                cb_eq[i].setSelectedItem(this.EQ[i][channel]);
                cb_eq_en[i].setSelectedIndex(this.EN[i][channel]);
            }
            tb_blessed1.setSelected(this.BL1[channel]);
            cb_elem_1.setSelectedIndex(this.ELEM1[channel]);
            tb_blessed2.setSelected(this.BL2[channel]);
            cb_elem_2.setSelectedIndex(this.ELEM2[channel]);
            cb_ts_elem.setSelectedIndex(this.TS_ELEM[channel]);
            cb_arrow.setSelectedItem(this.ARROW[channel]);
            tf_buki_sp_rate.setText(Double.toString(this.SP_R[channel]));
            tf_mag_rate.setText(Double.toString(this.MAG_R[channel]));
            tf_mag_delay.setText(Double.toString(this.MAG_D[channel]));
            tf_mag_power.setText(Double.toString(this.MAG_P[channel]));
            tb_ts_sp.setSelected(TS_SP[channel]);

            if (calc.buki.element_enchant) {
                cb_elem_1.setEnabled(true);
            } else {
                cb_elem_1.setSelectedIndex(0);
                cb_elem_1.setEnabled(false);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("copy")) {
                copy = cb_eq_ch.getSelectedIndex();
            }
            if (e.getActionCommand().equals("paste")) {
                mem.load_from_mem(copy);
            }
            //���Z�b�g�{�^�����������̓���
            if (e.getActionCommand().equals("reset")) {

                for (int i = 0; i < EQ_LIST.length; i++) {
                    cb_eq[i].setSelectedIndex(0);
                    cb_eq_en[i].setSelectedIndex(0);
                }

                cb_elem_1.setSelectedIndex(0);
                cb_ts_elem.setSelectedIndex(0);

                tb_blessed1.setSelected(false);
                cb_arrow.setSelectedIndex(-1);
            }
            if (e.getActionCommand().equals("ch")) {
                mem.copy_to_mem(curr);
                mem.load_from_mem(cb_eq_ch.getSelectedIndex());
                curr = cb_eq_ch.getSelectedIndex();
                calc.update();
            }
        }
    }
    Memory mem = new Memory();
    int copy = 0;
    int curr = 0;

    private void init_mem() {
        loadEquip();
        mem.clear();
        mem.load_from_mem(cb_eq_ch.getSelectedIndex());
        calc.update();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(tabpane)) {
            int tab_id = tabpane.getSelectedIndex();

            if (tab_id == 0 || tab_id == 1) {
                JPanel p = panels[tab_id];
                commons.stream().forEach((c) -> {
                    p.add(c);
                });
            }

            calc.update();
        }

        if (e.getSource().equals(s_target_mr)) {
            lab_target_mr.setText(Integer.toString(s_target_mr.getValue()));
        }
        for (int i = 0; i < ELEM_LIST.length; i++) {
            if (e.getSource().equals(s_target_res[i])) {
                lab_target_resist[i].setText(Integer.toString(s_target_res[i].getValue()));
            }
        }
    }

//�L�����N�^�[�f�[�^�[�ۑ�
    private Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("root");
        document.appendChild(root);

        Element e_class = document.createElement("�N���X");
        root.appendChild(e_class);
        e_class.setTextContent(cb_cls.getSelectedItem().toString());

        Element e_lev = document.createElement("���x��");
        root.appendChild(e_lev);
        e_lev.setTextContent(cb_lev.getSelectedItem().toString());

        Element e_status = document.createElement("�X�e�[�^�X");
        root.appendChild(e_status);

        String st[] = {"---", "STR", "DEX", "INT", "WIS", "CON", "CHA"};

        Element e_base = document.createElement("base");
        e_status.appendChild(e_base);
        for (int i = 0; i < 6; i++) {
            Element e_base_data = document.createElement("data");
            e_base_data.setAttribute("val", st[i + 1]);
            e_base_data.setAttribute("num", Integer.toString(calc.getST_REM(i)));
            e_base.appendChild(e_base_data);
        }

        Element e_level = document.createElement("level");
        e_status.appendChild(e_level);
        for (int i = 0; i < lev.size; i++) {
            Element e_rem_level_data = document.createElement("data");
            e_rem_level_data.setAttribute("lev", Integer.toString(i + 51));
            e_rem_level_data.setAttribute("val", st[lev.field[i] + 1]);
            e_level.appendChild(e_rem_level_data);
        }

        Element e_elixir = document.createElement("elixir");
        e_status.appendChild(e_elixir);
        for (int i = 0; i < cb_elixir.length; i++) {
            Element e_elixir_data = document.createElement("data");
            e_elixir_data.setAttribute("lev", cb_elixir_level[i].getSelectedItem().toString());
            e_elixir_data.setAttribute("val", cb_elixir[i].getSelectedItem().toString());
            e_elixir.appendChild(e_elixir_data);
        }

        Element e_polymorph = document.createElement("�ϐg");
        root.appendChild(e_polymorph);
        e_polymorph.setTextContent(cb_morph_type.getSelectedItem().toString());

        Element e_polymorph_level = document.createElement("�ϐg���x��");
        root.appendChild(e_polymorph_level);
        e_polymorph_level.setTextContent(cb_morph_level.getSelectedItem().toString());

        Element e_morph_manually = document.createElement("�ϐg�ݒ�");
        e_morph_manually.setTextContent(Boolean.toString(cb_speed_auto.isSelected()));
        root.appendChild(e_morph_manually);

        Element e_buki_manually = document.createElement("����ݒ�");
        e_buki_manually.setTextContent(Boolean.toString(cb_mag_auto.isSelected()));
        root.appendChild(e_buki_manually);

        if (!cb_speed_auto.isSelected()) {
            e_morph_manually.setAttribute("���x", tf_speed.getText());
            e_morph_manually.setAttribute("����", tf_acc.getText());
            e_morph_manually.setAttribute("�U��", tf_magic_speed_main.getText());
            e_morph_manually.setAttribute("�▂", tf_magic_speed_sub.getText());
        }

        Element e_enchant = document.createElement("�G���`�����g");
        root.appendChild(e_enchant);
        for (int i = 0; i < cb_buff.length; i++) {
            if (cb_buff[i] != null) {
                Element e_enchant_data = document.createElement("data");
                e_enchant_data.setAttribute("id", Integer.toString(i));
                e_enchant_data.setAttribute("val", Boolean.toString(cb_buff[i].isSelected()));
                e_enchant_data.setAttribute("cons", Boolean.toString(cb_buff[i].getForeground().equals(Color.BLUE)));
                if (cb_buff_group[i] != null) {
                    e_enchant_data.setAttribute("select", Integer.toString(cb_buff_group[i].getSelectedIndex()));
                }
                e_enchant.appendChild(e_enchant_data);
            }
        }

        Element pattern = document.createElement("���l");
        root.appendChild(pattern);
        Element e_pattern_l = document.createElement("����");
        pattern.appendChild(e_pattern_l);
        e_pattern_l.setTextContent(cb_pattern_l.getSelectedItem().toString());
        Element e_pattern_r = document.createElement("�E��");
        pattern.appendChild(e_pattern_r);
        e_pattern_r.setTextContent(cb_pattern_r.getSelectedItem().toString());
        Element e_pattern_c = document.createElement("�w��");
        pattern.appendChild(e_pattern_c);
        e_pattern_c.setTextContent(cb_pattern_c.getSelectedItem().toString());
        Element e_pattern_l2 = document.createElement("���r");
        pattern.appendChild(e_pattern_l2);
        e_pattern_l2.setTextContent(cb_pattern_l2.getSelectedItem().toString());
        Element e_pattern_r2 = document.createElement("�E�r");
        pattern.appendChild(e_pattern_r2);
        e_pattern_r2.setTextContent(cb_pattern_r2.getSelectedItem().toString());

        Element e_elixir_rune = document.createElement("�G���N�T�[���[��");
        e_elixir_rune.setAttribute("enchant", (String) elixir_rune_en.getSelectedItem());
        e_elixir_rune.setAttribute("id", (String) elixir_rune.getSelectedItem());
        root.appendChild(e_elixir_rune);

        Element e_alterstone = document.createElement("�I���^�[�X�g�[��");
        e_alterstone.setAttribute("enchant", (String) cb_alterstone_en.getSelectedItem());
        e_alterstone.setAttribute("op1", (String) cb_alterstone_op[0].getSelectedItem());
        e_alterstone.setAttribute("op2", (String) cb_alterstone_op[1].getSelectedItem());
        e_alterstone.setAttribute("op3", (String) cb_alterstone_op[2].getSelectedItem());
        root.appendChild(e_alterstone);

        for (int i = 0; i < cb_eq_ch.getItemCount(); i++) {
            Element e_equip = document.createElement("����");
            e_equip.setAttribute("id", Integer.toString(i));
            root.appendChild(e_equip);
            for (int j = 0; j < EQ_LIST.length; j++) {
                Element e_equip_data = document.createElement(EQ_LIST[j]);
                e_equip_data.setAttribute("id", Integer.toString(j));
                e_equip_data.setAttribute("enchant", Integer.toString(mem.EN[j][i]));
                if (EQ_LIST[j].equals("����")) {
                    if (j == 0) {
                        e_equip_data.setAttribute("element", Integer.toString(mem.ELEM1[i]));
                        e_equip_data.setAttribute("blessed", Boolean.toString(mem.BL1[i]));
                        e_equip_data.setAttribute("sp_rate", Double.toString(mem.SP_R[i]));
                        e_equip_data.setAttribute("mag_rate", Double.toString(mem.MAG_R[i]));
                        e_equip_data.setAttribute("mag_power", Double.toString(mem.MAG_P[i]));
                        e_equip_data.setAttribute("mag_delay", Double.toString(mem.MAG_D[i]));
                    }
                    if (j == 1) {
                        e_equip_data.setAttribute("element", Integer.toString(mem.ELEM2[i]));
                        e_equip_data.setAttribute("blessed", Boolean.toString(mem.BL2[i]));
                    }

                }
                if (EQ_LIST[j].equals("�V���c")) {
                    e_equip_data.setAttribute("element", Integer.toString(mem.TS_ELEM[i]));
                    e_equip_data.setAttribute("tokusei", Boolean.toString(mem.TS_SP[i]));
                }
                e_equip_data.setTextContent(mem.EQ[j][i] != null ? mem.EQ[j][i] : "");
                e_equip.appendChild(e_equip_data);
            }
            Element e_arrow = document.createElement("�A���[");
            e_arrow.setTextContent(mem.ARROW[i]);
            e_equip.appendChild(e_arrow);
        }

        Element e_magic = document.createElement("���@�g�p");
        e_magic.setTextContent(cb_magic.getSelectedItem().toString());
        root.appendChild(e_magic);

        Element e_weight = document.createElement("�d��");
        e_weight.setTextContent(cb_weight.getSelectedItem().toString());
        root.appendChild(e_weight);

        return document;
    }

//�L�����N�^�[�f�[�^�[�Ǎ�
    private void loadDocument(Document document) {
        calc.rem_reset();
        cb_cls.setSelectedItem(document.getDocumentElement().getElementsByTagName("�N���X").item(0).getTextContent());
        cb_lev.setSelectedItem(document.getDocumentElement().getElementsByTagName("���x��").item(0).getTextContent());

        Node n_base = document.getDocumentElement().getElementsByTagName("base").item(0);
        for (int i = 0; i < n_base.getChildNodes().getLength(); i++) {
            Node item = n_base.getChildNodes().item(i);
            if (item.hasAttributes()) {
                for (int j = 0; j < Integer.parseInt(item.getAttributes().getNamedItem("num").getNodeValue()); j++) {
                    switch (item.getAttributes().getNamedItem("val").getNodeValue()) {
                        case "STR":
                            calc.addRem(STR);
                            break;
                        case "DEX":
                            calc.addRem(DEX);
                            break;
                        case "INT":
                            calc.addRem(INT);
                            break;
                        case "WIS":
                            calc.addRem(WIS);
                            break;
                        case "CON":
                            calc.addRem(CON);
                            break;
                        case "CHA":
                            calc.addRem(CHA);
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        Node n_level = document.getDocumentElement().getElementsByTagName("level").item(0);
        for (int i = 0; i < n_level.getChildNodes().getLength(); i++) {
            Node item = n_level.getChildNodes().item(i);
            if (item.hasAttributes()) {
                String st[] = {"---", "STR", "DEX", "INT", "WIS", "CON", "CHA"};
                for (int j = 0; j < 7; j++) {
                    if (item.getAttributes().getNamedItem("val").getNodeValue().equals(st[j])) {
                        lev.field[Integer.parseInt(item.getAttributes().getNamedItem("lev").getNodeValue()) - 51] = j - 1;
                    }
                }
            }
        }
        calc.update();
        lev.repaint();

        Node n_elixir = document.getDocumentElement().getElementsByTagName("elixir").item(0);
        for (int i = 0, index = 0; i < n_elixir.getChildNodes().getLength() && index < cb_elixir.length; i++) {
            Node item = n_elixir.getChildNodes().item(i);
            if (item.hasAttributes()) {
                cb_elixir[index].setSelectedItem(item.getAttributes().getNamedItem("val").getNodeValue());
                cb_elixir_level[index].setSelectedItem(item.getAttributes().getNamedItem("lev").getNodeValue());
                index++;
            }
        }

        cb_morph_type.setSelectedItem(document.getDocumentElement().getElementsByTagName("�ϐg").item(0).getTextContent());
        cb_morph_level.setSelectedItem(document.getDocumentElement().getElementsByTagName("�ϐg���x��").item(0).getTextContent());

        Node n_morph_manually = document.getDocumentElement().getElementsByTagName("�ϐg�ݒ�").item(0);
        cb_speed_auto.setSelected(Boolean.parseBoolean(n_morph_manually.getTextContent()));

        Node n_buki_manually = document.getDocumentElement().getElementsByTagName("����ݒ�").item(0);
        cb_mag_auto.setSelected(Boolean.parseBoolean(n_buki_manually.getTextContent()));

        if (!cb_speed_auto.isSelected()) {
            tf_speed.setText(n_morph_manually.getAttributes().getNamedItem("���x").getNodeValue());
            tf_acc.setText(n_morph_manually.getAttributes().getNamedItem("����").getNodeValue());
            tf_magic_speed_main.setText(n_morph_manually.getAttributes().getNamedItem("�U��").getNodeValue());
            tf_magic_speed_sub.setText(n_morph_manually.getAttributes().getNamedItem("�▂").getNodeValue());
        }

        Node n_enchant = document.getDocumentElement().getElementsByTagName("�G���`�����g").item(0);
        for (int i = 0; i < n_enchant.getChildNodes().getLength(); i++) {
            Node item = n_enchant.getChildNodes().item(i);
            if (item.hasAttributes()) {
                int id = Integer.parseInt(item.getAttributes().getNamedItem("id").getNodeValue());
                cb_buff[id].setSelected(Boolean.parseBoolean(item.getAttributes().getNamedItem("val").getNodeValue()));
                try {
                    if (Boolean.parseBoolean(item.getAttributes().getNamedItem("cons").getNodeValue())) {
                        cb_buff[id].setForeground(Color.BLUE);
                    }
                } catch (NullPointerException e) {
                }
                if (cb_buff_group[id] != null && item.getAttributes().getNamedItem("select") != null) {
                    cb_buff_group[id].setSelectedIndex(Integer.parseInt(item.getAttributes().getNamedItem("select").getNodeValue()));
                }
            }
        }

        Node pattern = document.getDocumentElement().getElementsByTagName("���l").item(0);

        for (int i = 0; i < pattern.getChildNodes().getLength(); i++) {
            switch (pattern.getChildNodes().item(i).getNodeName()) {
                case "����":
                    cb_pattern_l.setSelectedItem(pattern.getChildNodes().item(i).getTextContent());
                    break;
                case "�E��":
                    cb_pattern_r.setSelectedItem(pattern.getChildNodes().item(i).getTextContent());
                    break;
                case "�w��":
                    cb_pattern_c.setSelectedItem(pattern.getChildNodes().item(i).getTextContent());
                    break;
                case "���r":
                    cb_pattern_l2.setSelectedItem(pattern.getChildNodes().item(i).getTextContent());
                    break;
                case "�E�r":
                    cb_pattern_r2.setSelectedItem(pattern.getChildNodes().item(i).getTextContent());
                    break;
                default:
                    break;
            }
        }

        if (document.getDocumentElement().getElementsByTagName("�G���N�T�[���[��").getLength() == 1) {
            Node en_elixir_rune = document.getDocumentElement().getElementsByTagName("�G���N�T�[���[��").item(0);
            elixir_rune_en.setSelectedItem(en_elixir_rune.getAttributes().getNamedItem("enchant").getNodeValue());
            elixir_rune.setSelectedItem(en_elixir_rune.getAttributes().getNamedItem("id").getNodeValue());
        }

        if (document.getDocumentElement().getElementsByTagName("�I���^�[�X�g�[��").getLength() == 1) {
            Node alterstone = document.getDocumentElement().getElementsByTagName("�I���^�[�X�g�[��").item(0);
            cb_alterstone_en.setSelectedItem(alterstone.getAttributes().getNamedItem("enchant").getNodeValue());
            cb_alterstone_op[0].setSelectedItem(alterstone.getAttributes().getNamedItem("op1").getNodeValue());
            cb_alterstone_op[1].setSelectedItem(alterstone.getAttributes().getNamedItem("op2").getNodeValue());
            cb_alterstone_op[2].setSelectedItem(alterstone.getAttributes().getNamedItem("op3").getNodeValue());
        }

        for (int i = 0; i < cb_eq_ch.getItemCount(); i++) {
            Node n_equip = document.getDocumentElement().getElementsByTagName("����").item(i);
            int cn = Integer.parseInt(n_equip.getAttributes().getNamedItem("id").getNodeValue());

            for (int j = 0; j < n_equip.getChildNodes().getLength(); j++) {
                Node item = n_equip.getChildNodes().item(j);
                if (item.hasAttributes()) {
                    int id = Integer.parseInt(item.getAttributes().getNamedItem("id").getNodeValue());
                    mem.EQ[id][cn] = item.getTextContent();
                    mem.EN[id][cn] = Integer.parseInt(item.getAttributes().getNamedItem("enchant").getNodeValue());
                    if (EQ_LIST[id].equals("����")) {
                        if (id == 0) {
                            mem.ELEM1[cn] = Integer.parseInt(item.getAttributes().getNamedItem("element").getNodeValue());
                            mem.BL1[cn] = Boolean.parseBoolean(item.getAttributes().getNamedItem("blessed").getNodeValue());
                            mem.SP_R[cn] = Double.parseDouble(item.getAttributes().getNamedItem("sp_rate").getNodeValue());
                            mem.MAG_R[cn] = Double.parseDouble(item.getAttributes().getNamedItem("mag_rate").getNodeValue());
                            mem.MAG_P[cn] = Double.parseDouble(item.getAttributes().getNamedItem("mag_power").getNodeValue());
                            mem.MAG_D[cn] = Double.parseDouble(item.getAttributes().getNamedItem("mag_delay").getNodeValue());
                        }
                        if (id == 1) {
                            mem.ELEM2[cn] = Integer.parseInt(item.getAttributes().getNamedItem("element").getNodeValue());
                            mem.BL2[cn] = Boolean.parseBoolean(item.getAttributes().getNamedItem("blessed").getNodeValue());
                        }
                    }
                    if (EQ_LIST[id].equals("�V���c")) {
                        mem.TS_ELEM[cn] = Integer.parseInt(item.getAttributes().getNamedItem("element").getNodeValue());
                        if (item.getAttributes().getNamedItem("tokusei") != null) {
                            mem.TS_SP[cn] = Boolean.parseBoolean(item.getAttributes().getNamedItem("tokusei").getNodeValue());
                        }
                    }
                }
                if (item.getNodeName().equals("�A���[")) {
                    mem.ARROW[cn] = item.getTextContent();
                }
            }
        }

        if (document.getDocumentElement().getElementsByTagName("���@�g�p").getLength() == 1) {
            Node magic = document.getDocumentElement().getElementsByTagName("���@�g�p").item(0);
            cb_magic.setSelectedItem(magic.getTextContent());
        }

        if (document.getDocumentElement().getElementsByTagName("�d��").getLength() == 1) {
            cb_weight.setSelectedItem(document.getDocumentElement().getElementsByTagName("�d��").item(0).getTextContent());
        }

        mem.load_from_mem(cb_eq_ch.getSelectedIndex());

        calc.update();
    }

    private class MP implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                JCheckBox cb = (JCheckBox) e.getSource();
                if (cb.getForeground().equals(Color.BLUE)) {
                    cb.setForeground(Color.BLACK);
                } else {
                    cb.setForeground(Color.BLUE);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}
