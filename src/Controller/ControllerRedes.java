/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utiles.Utiles;
import javax.swing.JTable;
/**
 *
 * @author danny
 */
public class ControllerRedes {
    private String[][] datos;

    public String[][] getDatos() {
        return datos;
    }
    
    public void setDatos(String[][] datos){
        this.datos = datos;
    }
    
    public void crear(Integer nro){
        this.datos = new String[nro][4];
    }
    
    public Integer verificar() {
        Integer pos = -1;
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[0].length; j++) {
                if (datos[i][j] == null) {
                    pos = i;
                    break;
                }
            }    
            if (pos != -1) {
                break;
            }
        }
        return pos;
    }
    
    public Boolean guardar(String ip, String nombreEquipo, Float transAlta, Float transBaja) {
        int pos = verificar();
        if (pos >= 0) {
            datos[pos][0] = ip;
            datos[pos][1] = nombreEquipo;
            datos[pos][2] = transAlta.toString();
            datos[pos][3] = transBaja.toString();
            return true;
        }
        return false;
    }
    
    public Float[][] mediaTransmision(){ // Sirve para registrar la media entre dos equipos seleciconados
        
        return null;
    }
}
