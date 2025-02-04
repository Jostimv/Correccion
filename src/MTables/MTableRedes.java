/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MTables;

import Controller.ControllerRedes;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danny
 */
public class MTableRedes extends AbstractTableModel {
    private ControllerRedes redes;

    public ControllerRedes getRedes() {
        return redes;
    }

    public void setRedes(ControllerRedes redes) {
        this.redes = redes;
    }
    
    @Override
    public int getRowCount() {
        return redes.getDatos().length;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1){
            case 0: return redes.getDatos()[i][0];
            case 1: return redes.getDatos()[i][1];
            case 2: return redes.getDatos()[i][2];
            case 3: return redes.getDatos()[i][3];
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int i){
        switch(i){
            case 0: return "IP";
            case 1: return "NOMBRE DEL EQUIPO";
            case 2: return "TRANSMISION ALTA";
            case 3: return "TRANSMISION BAJA";
            default: return null;
        }
    }
    
}
