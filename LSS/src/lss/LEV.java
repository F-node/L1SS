/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
class LEV implements Common ,ActionListener {

    final int size = 100 - 50;      //LV100まで対応
    //final int size = 94 - 50;     LV94までの場合
    JButton button[][] = new JButton[size][6];
    JLabel label[] = new JLabel[size];
    ImageIcon icons[] = new ImageIcon[5];

    private final int inactive = 0;
    private final int unselected = 1;
    private final int selected = 2;
    private final int overflow = 3;
    private final int invalidity = 4;

    int field[] = new int[size];
    boolean isVaild[] = new boolean[size];
    boolean isOverflow[] = new boolean[size];

    int level = 0;

    int w = 19;//18より変更         //ボタン幅18より19へ変更
//    int w = 17;                   LV94までの場合
    int h = 20;

    LEV() {

        BufferedImage icon_1 = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage icon_2 = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage icon_3 = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage icon_4 = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage icon_5 = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);

        Graphics g;
        g = icon_1.getGraphics();
        g.setColor(Color.gray);
        g.fillRect(0, 0, w, h);
        icons[0] = new ImageIcon(icon_1);
        g.dispose();

        g = icon_2.getGraphics();
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, w, h);
        icons[1] = new ImageIcon(icon_2);
        g.dispose();

        g = icon_3.getGraphics();
        g.setColor(Color.green);
        g.fillRect(0, 0, w, h);
        icons[2] = new ImageIcon(icon_3);
        g.dispose();

        g = icon_4.getGraphics();
        g.setColor(Color.red);
        g.fillRect(0, 0, w, h);
        icons[3] = new ImageIcon(icon_4);
        g.dispose();

        g = icon_5.getGraphics();
        g.setColor(Color.blue);
        g.fillRect(0, 0, w, h);
        icons[4] = new ImageIcon(icon_5);
        g.dispose();

        for (JButton[] button1 : button) {
            for (int j = 0; j < button1.length; j++) {
                button1[j] = new JButton(icons[inactive]);
            }
        }
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel(Integer.toString(i + 51));
            field[i] = -1;
        }
    }
    
    void setSelfCheck() {
        for (JButton[] button1 : button) {
            for (JButton button11 : button1) {
                button11.addActionListener(this);
            }
        }
    }

    protected void put(Container target, int x, int y) {
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                button[i][j].setBounds(x + i * w + 30, y + j * h + h, w, h);
                target.add(button[i][j]);
            }
        }
        for (int i = 0; i < label.length; i++) {
            label[i].setBounds(x + i * w + 30, y, w, h);
            target.add(label[i]);
        }
        for (int i = 0; i < 6; i++) {
            JLabel lab = new JLabel(ST_LIST[i]);
            lab.setBounds(x, y + i * h + h, 30, h);
            target.add(lab);
        }
    }

    protected void repaint() {

        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                if (field[i] == -1) {
                    if (level - 50 > i) {
                        button[i][j].setIcon(icons[unselected]);
                    } else {
                        button[i][j].setIcon(icons[inactive]);
                    }
                } else if (field[i] == j) {
                    if (isOverflow[i]) {
                        button[i][j].setIcon(icons[overflow]);
                    } else if (level - 50 > i) {
                        button[i][j].setIcon(icons[selected]);
                    } else {
                        button[i][j].setIcon(icons[invalidity]);
                    }
                } else {
                    if (level - 50 > i) {
                        button[i][j].setIcon(icons[unselected]);
                    } else {
                        button[i][j].setIcon(icons[inactive]);
                    }
                }
                button[i][j].repaint();
            }
        }
    }

    protected int getField(int lev) {
        return field[lev - 51];
    }

    protected boolean isOverflow(int lev) {
        return isOverflow[lev - 51];
    }

    protected void setOverflow(int lev, boolean val) {
        isOverflow[lev - 51] = val;
    }

    protected void setVisible(boolean val) {
        for (int i = 0; i < button.length; i++) {
            label[i].setVisible(val);
            for (JButton item : button[i]) {
                item.setVisible(val);
            }
        }
    }

    protected void addActionListener(ActionListener target) {
        for (JButton[] button1 : button) {
            for (JButton item : button1) {
                item.addActionListener(target);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                if (e.getSource().equals(button[i][j])) {
                    if (field[i] == j) {
                        field[i] = -1;
                    } else {
                        field[i] = j;
                    }
                    break;
                }
            }
        }
        repaint();
    }
}
