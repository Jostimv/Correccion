/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reciclados;

import Reciclados.E_Notas2;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danny
 */
public class MTableNotasMatrices extends AbstractTableModel { // Abstractos: metodos sin cuerpo
    private E_Notas2 e_notas;

    public E_Notas2 getE_notas() {
        return e_notas;
    }

    public void setE_notas(E_Notas2 e_notas) {
        this.e_notas = e_notas;
    }
    
    
    @Override // Sobre escritura de metodos
    public int getRowCount() { // Obtener num de filas
        return e_notas.getData().length;
    /**
     * Metodo que devuelve numero de filas
     * @return Int nro de flas
     */
    }

    @Override
    public int getColumnCount() { // Obtener num de columnas
        return 4;//1+e_notas.getData()[0].length;
    /**
     * Metodo que devuelve numero de columnas
     * @return Int nro de columnas
     */
    }

    @Override
    public Object getValueAt(int i, int i1) { // Obtener valor | srg0: fila | arg1: columna
        switch(i1){
            case 0: return (i+1);
            case 1: return e_notas.getData()[i][0];
            case 2: return e_notas.getData()[i][1];
            case 3: return e_notas.getData()[i][2];
            
            default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0: return "Nro";
            case 1: return "Alumnos";
            case 2: return "Notas";
            case 3: return "Estado";
            default: return null;
        }
    }
    
    
    
}
