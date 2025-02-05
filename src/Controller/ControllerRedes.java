/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utiles.Utiles;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
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
    
    public void setDatos(String[][] datos) {
        this.datos = datos;
    }


    public void crear(Integer nro) {
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

    public void mediaTransmisionAlta(String equipo1, String equipo2) { // Sirve para registrar la media entre dos equipos seleciconados
        Float eq1 = 0f;
        Float eq2 = 0f;
        Boolean band1 = false;
        Boolean band2 = false;
        Float media = 0.0f;
        System.out.println("1:" + equipo1 + "2:" + equipo2);
        try {
            for (int i = 0; i < datos.length; i++) {
                if (equipo1.equals(datos[i][1])) {
                    if (datos[i][2] != null) {
                        eq1 = Utiles.transformStringFloat(datos[i][2]);
                    } else {
                        throw new NullPointerException();
                    }
                    band1 = true;
                }
                if (equipo2.equals(datos[i][1])) {
                    if (datos[i][2] != null) {
                        eq2 = Utiles.transformStringFloat(datos[i][2]);
                    } else {
                        throw new NullPointerException();
                    }
                    band2 = true;
                }
                if (band1 && band2) {
                    break;
                }
            }
            if (band1 && band2) {
                media = (eq1 + eq2) / 2;
                JOptionPane.showMessageDialog(null, "La media es: " + media);
            } else {
                JOptionPane.showMessageDialog(null, "Uno o ambos nombres de equipos no fueron encontrados.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese correctamente los nombres de los equipos");
        }
    }

    public Boolean generarFiles() {
        if (datos != null) {
            String pathNotas = "data" + File.separatorChar + "Redes.txt";
            try {
                FileWriter fileNotas = new FileWriter(pathNotas); // abrir conexion hacia el archivo
                for (int i = 0; i < datos.length; i++) {
                    String dato = "";
                    for (int j = 0; j < datos[0].length; j++) {
                        dato += datos[i][j] + "\t";
                    }

                    fileNotas.write(dato.toString() + "\n");
                    fileNotas.flush();
                }
                fileNotas.close(); // cerrar conexion hacia el archivo
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public Boolean cargarArchivo() {
        String pathNotas = "data" + File.separatorChar + "Redes.txt";
        try {
            FileReader frn = new FileReader(pathNotas);
            BufferedReader fileNotas = new BufferedReader(frn);
            FileReader fra1 = new FileReader(pathNotas);
            BufferedReader size = new BufferedReader(fra1);

            crear(Integer.parseInt(String.valueOf(size.lines().count())));

            String linea;
            int cont = 0;
            while ((linea = fileNotas.readLine()) != null) {
                String[] aux = linea.split("\t");
                if (aux[0].equalsIgnoreCase("null")) {
                    datos[cont][0] = null;
                    datos[cont][1] = null;
                    datos[cont][2] = null;
                    datos[cont][3] = null;
                } else {
                    datos[cont][0] = aux[0];
                    datos[cont][1] = aux[1];
                    datos[cont][2] = aux[2];
                    datos[cont][3] = aux[2];
                }
                cont++;
            }
            frn.close();
            fileNotas.close(); // cerrar conexion hacia el archivo

            fra1.close();
            size.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
