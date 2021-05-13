/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author user
 */
public class Updater extends JDialog implements ActionListener, WindowListener {

    JCheckBox cb = new JCheckBox();
    JLabel lab = new JLabel();
    boolean update_data = false;
    boolean update_app = false;

    String app_ver;
    String data_ver;

    String curr_app_ver;
    String curr_data_ver;

    JButton no = new JButton("いいえ");
    JButton yes = new JButton("はい");
    JButton ok = new JButton();

    void init() {

        lab.setHorizontalAlignment(SwingConstants.CENTER);
        lab.setBounds(0, 0, 400, 30);
        add(lab);

        yes.setBounds(50, 30, 100, 30);
        add(yes);
        yes.addActionListener(this);
        yes.setActionCommand("yes");

        no.setBounds(250, 30, 100, 30);
        add(no);
        no.addActionListener(this);
        no.setActionCommand("no");

        ok.setBounds(150, 30, 100, 30);
        add(ok);
        ok.addActionListener(this);
        ok.setActionCommand("ok");
        ok.setVisible(false);

        cb.addActionListener(this);
        cb.setActionCommand("nocheck");

        cb.setBounds(220, 60, 180, 30);
        add(cb);
    }

    void check_update() {
        try {
            BufferedReader reader;
            File v = new File("./version.txt");

            if (!v.exists()) {
                v.createNewFile();
                update_version("0.0.0", "0.0.0");
            }
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("./version.txt")));
            curr_app_ver = reader.readLine();
            curr_data_ver = reader.readLine();
            reader.close();

//            URL url = new URL("https://github.com/F-node/L1SS/raw/master/LSS/version.txt");
            URL url = new URL("https://github.com/TrickMasterJP/L1SS_2018/raw/master/LSS/version.txt");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.connect();
            reader = new BufferedReader(new InputStreamReader(http.getInputStream()));

            app_ver = reader.readLine();
            data_ver = reader.readLine();

            reader.close();

            File app = new File("./bin/LSS.jar");
            File data = new File("./data/E.zip");

            if (!app.exists() || !data.exists()) {
                lab.setText("起動に必要なファイルが見つかりません。ダウンロードしますか？");
                setSize(400, 100);
                cb.setVisible(false);
                update_app = true;
                update_data = true;
            } else {
                if (app_ver.compareTo(curr_app_ver) > 0) {
                    update_app = true;
                    lab.setText("更新があります。ダウンロードしますか？");
                    cb.setText("起動時に更新の確認しない");
                    setSize(400, 120);
                }
                if (data_ver.compareTo(curr_data_ver) > 0) {
                    update_data = true;
                    lab.setText("更新があります。ダウンロードしますか？");
                    cb.setText("起動時に更新の確認しない");
                    setSize(400, 120);
                }
            }
            if (update_app || update_data) {
                setVisible(true);
            } else {
                Launcher.launch();
            }

        } catch (IOException ex) {
        }
    }

    void download_app() throws IOException {
//        URL url = new URL("https://github.com/F-node/L1SS/raw/master/LSS/dist/LSS.jar");
        URL url = new URL("https://github.com/TrickMasterJP/L1SS_2018/raw/master/LSS/dist/LSS.jar");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();

        try (InputStream input = http.getInputStream()) {
            
            File data_foloder = new File("./bin");
            if (!data_foloder.exists()) {
                data_foloder.mkdir();
            }
            
            File app = new File("./bin/LSS.jar");
            if (app.exists()) {
                File backup = new File("./bin/LSS_" + curr_app_ver + ".jar");
                app.renameTo(backup);

                app = new File("./bin/LSS.jar");
                app.createNewFile();
            }
            try (OutputStream output = new FileOutputStream(app, false)) {
                int b;
                while ((b = input.read()) != -1) {
                    output.write(b);
                }
            }
        }
        http.disconnect();
    }

    void download_data() throws IOException {
//        URL url = new URL("https://github.com/F-node/L1SS/raw/master/LSS/data/E.zip");
        URL url = new URL("https://github.com/TrickMasterJP/L1SS_2018/raw/master/LSS/data/E.zip");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();

        try (InputStream input = http.getInputStream()) {
            File data_foloder = new File("./data");
            if (!data_foloder.exists()) {
                data_foloder.mkdir();
            }

            File data = new File("./data/E.zip");
            if (data.exists()) {
                File backup = new File("./data/E_" + curr_app_ver + ".zip");
                data.renameTo(backup);

                data = new File("./data/E.zip");
                data.createNewFile();
            }
            if (!data.exists()) {
                data.createNewFile();
            }
            try (OutputStream output = new FileOutputStream(data, false)) {
                int b;
                while ((b = input.read()) != -1) {
                    output.write(b);
                }
            }
        }
        http.disconnect();
    }

    void update_version(String app_ver, String data_ver) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("./version.txt"))) {
                writer.write(app_ver);
                writer.newLine();
                writer.write(data_ver);
                writer.flush();
            }
        } catch (IOException ex) {

        }
    }

    boolean failed = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "yes":
                setVisible(false);
                cb.setVisible(false);
                boolean error = false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
                if (update_app) {
                    try {
                        download_app();
                    } catch (IOException ex) {
                        error = true;
                    }
                }
                if (update_data) {
                    try {
                        download_data();
                    } catch (IOException ex) {
                        error = true;
                    }
                }
                if (!error) {
                    update_version(app_ver, data_ver);

                    setSize(200, 100);
                    lab.setSize(200, 30);
                    ok.setLocation(50, 30);
                    yes.setVisible(false);
                    no.setVisible(false);
                    ok.setVisible(true);
                    lab.setText("ダウンロード完了しました");
                    ok.setText("起動");
                    setVisible(true);
                    failed = false;
                } else {
                    setSize(200, 100);
                    lab.setSize(200, 30);
                    ok.setLocation(50, 30);
                    yes.setVisible(false);
                    no.setVisible(false);
                    ok.setVisible(true);
                    lab.setText("ダウンロードに失敗しました");
                    ok.setText("終了");
                    setVisible(true);
                    failed = true;
                }
                break;
            case "no":
                Launcher.launch();
                break;
            case "ok":
                if (failed) {
                    System.exit(0);
                }
                Launcher.launch();
                break;
            case "nocheck":
                File f = new File("./auto_update.txt");

                if (cb.isSelected()) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
                        writer.write("no");
                    } catch (IOException ex) {
                    }
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
                        writer.write("yes");
                    } catch (IOException ex) {
                    }

                }
                break;
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
