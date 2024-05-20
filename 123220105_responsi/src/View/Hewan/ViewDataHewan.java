package View.Hewan;


import Controller.ControllerHewan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Model.Hewan.ModelHewan;

public class ViewDataHewan extends JFrame {
    Integer baris;
    
    ControllerHewan controller;

    
    List<ModelHewan> daftarHewan = new ArrayList<>();

    
    JLabel header = new JLabel("Selamat Datang!");
    JButton tombolTambah = new JButton("Tambah Hewan");
    JButton tombolEdit = new JButton("Edit Hewan");
    JButton tombolHapus = new JButton("Hapus Hewan");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "Kelas", "Jenis Makanan"};

    public ViewDataHewan() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Daftar Hewan");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(552, 540);
        setLocationRelativeTo(null);
        setLayout(null);

        add(header);
        add(scrollPane);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolHapus);

        header.setBounds(20, 8, 440, 24);
        scrollPane.setBounds(20, 36, 512, 320);
        tombolTambah.setBounds(20, 370, 512, 40);
        tombolEdit.setBounds(20, 414, 512, 40);
        tombolHapus.setBounds(20, 456, 512, 40);

        table.setCellSelectionEnabled(false);
        table.setRowSelectionAllowed(true);
        
        controller = new ControllerHewan(this);
        controller.showAllHewan();

     
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                baris = table.getSelectedRow();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputDataHewan();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (baris != null) {
                    
                    ModelHewan pilih = new ModelHewan();
                    
                    Integer id = (int) table.getValueAt(baris, 0);
                    String nama = table.getValueAt(baris, 1).toString();
                    String kelas = table.getValueAt(baris, 2).toString();
                    String jenisMakanan = table.getValueAt(baris, 3).toString();
                    
                    pilih.setId(id);
                    pilih.setNama(nama);
                    pilih.setKelas(kelas);
                    pilih.setJenisMakanan(jenisMakanan);
                    
         
                    dispose();
                    new EditDataHewan(pilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.deleteHewan(baris);
                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
    }

    public JTable getTable() {
        return table;
    }
}
