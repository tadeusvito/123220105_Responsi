/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123220105_responsi;

import View.Hewan.ViewDataHewan;
import View.Pegawai.ViewDataPegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Menu extends JFrame implements ActionListener{
    
    JLabel judul = new JLabel();
    JLabel judul2 = new JLabel("Silahkan pilih menu untuk melanjutkan");
    
    JButton pilihHewan = new JButton("Hewan");
    JButton pilihPegawai = new JButton("Pegawai");
    JButton pilihLogout = new JButton("Logout");
    public Menu(String username) {
        setVisible(true);
        setSize(480,520);
        setTitle("Halaman Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(judul);
        judul.setText("Selamat Datang, " + username);
        judul.setBounds(50, 20, 300, 30);
        judul.setFont(judul.getFont().deriveFont(20f));
        
        add(judul2);
        judul2.setBounds(50, 40, 400, 30);
        
        add(pilihHewan);
        pilihHewan.setBounds(150, 100, 150, 30);
        pilihHewan.addActionListener(this);
        
        add(pilihPegawai);
        pilihPegawai.setBounds(150, 150, 150, 30);
        pilihPegawai.addActionListener(this);
        
        add(pilihLogout);
        pilihLogout.setBounds(150, 200, 150, 30);
        pilihLogout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pilihHewan){
            new ViewDataHewan();
            this.dispose();
        }else if(e.getSource() == pilihPegawai){
            new ViewDataPegawai();
            this.dispose();
        }else if(e.getSource() == pilihLogout){
            exit(0);
        }
        
    }
    
}

