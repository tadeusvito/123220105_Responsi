package View.Hewan;

import Controller.ControllerHewan;
import Model.Hewan.ModelHewan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditDataHewan extends JFrame {
    
    ControllerHewan controller;
    
    JLabel header = new JLabel("Edit Hewan");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputKelas = new JLabel("Kelas");
    JLabel labelInputJenisMakanan = new JLabel("Jenis Makanan");
    JTextField inputNama = new JTextField();
    JTextField inputKelas = new JTextField();
    JTextField inputJenisMakanan = new JTextField();
    JButton tombolEdit = new JButton("Edit Hewan");
    JButton tombolKembali = new JButton("Kembali");

    public EditDataHewan(ModelHewan hewan) {
        setTitle("Edit Hewan");
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
        add(tombolEdit);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputKelas.setBounds(20, 96, 440, 24);
        inputKelas.setBounds(18, 120, 440, 36);
        labelInputJenisMakanan.setBounds(20, 160, 440, 24);
        inputJenisMakanan.setBounds(18, 184, 440, 36);
        tombolKembali.setBounds(20, 228, 215, 40);
        tombolEdit.setBounds(240, 228, 215, 40);
        
        inputNama.setText(hewan.getNama());
        inputKelas.setText(hewan.getKelas());
        inputJenisMakanan.setText(hewan.getJenisMakanan());

        controller = new ControllerHewan(this);
       
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataHewan();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               controller.editHewan(hewan.getId());
            }
        });
    }

    public String getInputNama() {
        return inputNama.getText();
    }

    public String getInputKelas() {
        return inputKelas.getText();
    }
    
    public String getInputJenisMakanan() {
        return inputJenisMakanan.getText();
    }
    
    
}
