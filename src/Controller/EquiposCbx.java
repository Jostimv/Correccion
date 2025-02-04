/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JComboBox;

/**
 *
 * @author danny
 */
public class EquiposCbx {
    public static void cargarNroEquipos(JComboBox cbx){
        cbx.removeAllItems(); 
        for (int i = 6; i <= 100; i++) {
            cbx.addItem(i);
        }
    }
}
