package View.Hewan;

import Controller.ControllerHewan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputDataHewan extends JFrame {
    
    ControllerHewan controller;

    JLabel header = new JLabel("Input Hewan");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputKelas = new JLabel("Kelas");
    JLabel labelInputJenisMakanan = new JLabel("Jenis Makanan");
    JTextField inputNama = new JTextField();
    JTextField inputKelas = new JTextField();
    JTextField inputJenisMakanan = new JTextField();
    JButton tombolTambah = new JButton("Tambah Hewan");
    JButton tombolKembali = new JButton("Kembali");

    public InputDataHewan() {
        setTitle("Daftar Mahasiswa");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 440);
        setLocationRelativeTo(null);
        setLayout(null);

       add(header);
        add(labelInputNama);
        add(labelInputKelas);
        add(labelInputJenisMakanan);
        add(inputNama);
        add(inputKelas);
        add(inputJenisMakanan);
        add(tombolTambah);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputKelas.setBounds(20, 96, 440, 24);
        inputKelas.setBounds(18, 120, 440, 36);
        labelInputJenisMakanan.setBounds(20, 160, 440, 24);
        inputJenisMakanan.setBounds(18, 184, 440, 36);
        tombolKembali.setBounds(20, 228, 215, 40);
        tombolTambah.setBounds(240, 228, 215, 40);
        
        controller = new ControllerHewan(this);

        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataHewan();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              controller.insertHewan();
            }
        });
    }


    public String getInputKelas() {
        return inputKelas.getText();
    }
    
    
    public String getInputJenisMakanan() {
        return inputJenisMakanan.getText();
    }

    public String getInputNama() {
            return inputNama.getText();
    }


    
    
}
