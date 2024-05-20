/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Hewan.ModelHewan;
import Model.Hewan.ModelTableHewan;
import View.Hewan.EditDataHewan;
import View.Hewan.ViewDataHewan;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Hewan.InterfaceDAOHewan;
import View.Hewan.InputDataHewan;


public class ControllerHewan {

    InputDataHewan inputhew;
    EditDataHewan edithew;
    ViewDataHewan viewhew;

    InterfaceDAOHewan daoHewan;

    List<ModelHewan> daftarHewan;

    public ControllerHewan(InputDataHewan inputhew) {
        this.inputhew = inputhew;
        this.daoHewan = new Model.Hewan.DAOHewan();
    }

    public ControllerHewan(EditDataHewan edithew) {
        this.edithew = edithew;
        this.daoHewan = new Model.Hewan.DAOHewan();
    }

    public ControllerHewan(ViewDataHewan viewhew) {
        this.viewhew = viewhew;
        this.daoHewan = new Model.Hewan.DAOHewan();
    }

    public void showAllHewan() {
        daftarHewan = daoHewan.getAll();

        ModelTableHewan table = new ModelTableHewan(daftarHewan);
        
        viewhew.getTable().setModel(table);
    }

    public void insertHewan() {
        try {
            ModelHewan inputHewan = new ModelHewan();

            String nama = inputhew.getInputNama();
            String kelas = inputhew.getInputKelas();
            String jenisMakanan = inputhew.getInputJenisMakanan();

            if ("".equals(nama) || "".equals(kelas) || "".equals(jenisMakanan)) {
                throw new Exception("Nama, Kelas atau JenisMakanan tidak boleh kosong!");
            }

            inputHewan.setNama(nama);
            inputHewan.setKelas(kelas);
            inputHewan.setJenisMakanan(jenisMakanan);

            daoHewan.insert(inputHewan);

            JOptionPane.showMessageDialog(null, "Data Hewan telah ditambahkan");

            inputhew.dispose();
            new ViewDataHewan();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }

    public void editHewan(int id) {
        try {
            ModelHewan editHewan = new ModelHewan();

            String nama = edithew.getInputNama();
            String kelas = edithew.getInputKelas();
            String jenisMakanan = edithew.getInputJenisMakanan();

            if ("".equals(nama) || "".equals(kelas) || "".equals(jenisMakanan)) {
                throw new Exception("Nama, Kelas atau JenisMakanan tidak boleh kosong!");
            }

            editHewan.setNama(nama);
            editHewan.setKelas(kelas);
            editHewan.setJenisMakanan(jenisMakanan);

            daoHewan.update(editHewan);

            JOptionPane.showMessageDialog(null, "Data Hewan Berhasil diedit");

            edithew.dispose();
            new ViewDataHewan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteHewan(Integer baris) {
        Integer id = (int) viewhew.getTable().getValueAt(baris, 0);
        String nama = viewhew.getTable().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Hewan",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoHewan.delete(id);

            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllHewan();
        }
    }

}
