/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reciclados;

import javax.swing.JComboBox;
/**
 *
 * @author danny
 */
public class UtilesVista { 
    public static void cargarNroAlumnos(JComboBox cbx){
        cbx.removeAllItems(); // borrar lo que tiene el combobox
        for (int i = 1; i <= 60; i++) {
            cbx.addItem(i);
        }
    }
}

