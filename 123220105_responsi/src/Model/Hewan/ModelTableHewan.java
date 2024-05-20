/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Hewan;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModelTableHewan extends AbstractTableModel{
        
    List<ModelHewan> daftarHewan;
    
    String kolom[] = {"ID","Nama","Kelas","Jenis Makanan"};
    
    public ModelTableHewan(List<ModelHewan> daftarHewan){
        this.daftarHewan = daftarHewan;
    }

    @Override
    public int getRowCount() {
        return daftarHewan.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return daftarHewan.get(rowIndex).getId();
            case 1:
                return daftarHewan.get(rowIndex).getNama();
            case 2:
                return daftarHewan.get(rowIndex).getKelas();
            case 3:
                return daftarHewan.get(rowIndex).getJenisMakanan();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return kolom[columnIndex];
    }
    
    
}
