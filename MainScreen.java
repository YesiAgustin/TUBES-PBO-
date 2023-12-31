package com.tic.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainScreen  extends JFrame{
    int vip, economi, harga, beli, total, bayar, kembali;
    private JPanel panelMain;
    private JComboBox jurusan;
    private JRadioButton rb_vip;
    private JRadioButton rb_economi;
    private JTextField txt_harga;
    private JButton btn_input;
    private JButton btn_keluar;
    private JButton btn_cetak;
    private JTextField txt_nomor;
    private JTextField txt_nama;
    private JTextField txt_jumlah;
    private JTextField txt_total;
    private JTextField txt_bayar;
    private JTextField txt_kembalian;
    private JTextArea txt_area;

    public MainScreen() {
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        jurusan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jurusan.getSelectedItem().equals("Pilih Jurusan")) {
                    JButton.getDefaultLocale();
                    txt_harga.setText("");
                }
                else if (jurusan.getSelectedItem().equals("Bogor")){
                    vip=80000;
                    economi=40000;
                }
                else if (jurusan.getSelectedItem().equals("Sukabumi")){
                    vip=100000;
                    economi=50000;
                }
                else if (jurusan.getSelectedItem().equals("Bandung")){
                    vip=120000;
                    economi=60000;
                }
                else if (jurusan.getSelectedItem().equals("Malang")){
                    vip=200000;
                    economi=100000;
                }
            }

        });
        rb_vip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rb_vip.isSelected()){
                    txt_harga.setText(String.valueOf(vip));
                }
            }
        });
        rb_economi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rb_economi.isSelected()){
                    txt_harga.setText(String.valueOf(economi));
                }
            }
        });
        txt_jumlah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beli=Integer.parseInt(txt_jumlah.getText());
                harga=Integer.parseInt(txt_harga.getText());
                total=bayar*harga;
                txt_total.setText(String.valueOf(total));
            }
        });
        txt_bayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bayar=Integer.parseInt(txt_bayar.getText());
                kembali=Integer.parseInt(txt_total.getText());
                total=bayar-kembali;
                txt_kembalian.setText(String.valueOf(total));
            }
        });
        txt_jumlah.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                int a, b, c;
                a=Integer.valueOf(txt_harga.getText());
                b=Integer.valueOf(txt_jumlah.getText());
                c=a*b;
                txt_total.setText(""+c);
            }
        });
        txt_bayar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                int a, b, c;
                a=Integer.valueOf(txt_bayar.getText());
                b=Integer.valueOf(txt_total.getText());
                c=a-b;
                txt_kembalian.setText(""+c);
            }
        });
        btn_input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton.getDefaultLocale();
                txt_harga.setText("");
                jurusan.setSelectedItem("Pilih Jurusan");
                txt_nomor.setText("");
                txt_nama.setText("");
                txt_total.setText("");
                txt_jumlah.setText("");
                txt_bayar.setText("");
                txt_kembalian.setText("");
            }
        });
        btn_keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer= JOptionPane.showConfirmDialog(null, "Mau Keluar", "Keluar", JOptionPane.OK_OPTION);
                if (answer==JOptionPane.OK_OPTION){
                    dispose();
                }
            }
        });
        btn_cetak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_cetak.setText((String)jurusan.getSelectedItem());
                txt_area.setText(
                        "Nomor Kursi :"+ txt_nomor.getText()+"\n"+
                                "Nama Penumpang :"+ txt_nama.getText()+"\n"+
                                "Jumlah Beli :"+ txt_jumlah.getText()+"\n"+
                                "Total Bayar :"+ txt_total.getText()+"\n"+
                                "Uang Bayar :"+ txt_bayar.getText()+"\n"+
                                "Uang Kembali :"+ txt_kembalian.getText()+"\n");
            }
        });
    }
    public static void main(String [] args) {
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
    }
}
