/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reciclados;

import Ejercicio_Empresa.Utiles;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author danny
 */ // ARREGLOS BIDIMENSIONALES
public class E_Notas2 {
    private String[][] data;

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }
    
    public void crear(Integer nro) {
        // 0 = nombres  1 = nota  2 = estado
        this.data = new String[nro][3]; // nro: fila | "3": columna
    }
    
    public Float promedio() {
        Float promedio = 0.0f;
        Float cont = 0.0f;
        for (int i = 0; i < data.length; i++) {
            //for (int j = 0; j < data[0].length; j++) { -> para recorrer una estructura de dato
                if (data[i][1] != null) {
                    cont++;
                    promedio += Utiles.transformStringFloat(data[i][1]);
                }
            //}
            
        }
        return Utiles.redondear(promedio / cont);
    }
    
    public Integer verificar() {
        Integer pos = -1;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == null) {
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
    
    public Boolean guardar(String alumno, Float nota) {
        int pos = verificar();
        if (pos >= 0) {
            data[pos][0] = alumno;
            data[pos][1] = nota.toString();
            data[pos][2] = (nota >= 7.0f)?"Aprobado":"Reprobado"; // Operador ternario (condicion)? comparacion1(verdadero):comparacion2(falso)
            return true;
        }
        return false;
    }
    
    public Boolean modificar(String alumno, Float nota, Integer pos) {
        if (pos >= 0) {
            data[pos][0] = alumno;
            data[pos][1] = nota.toString();
            data[pos][2] = (nota >= 7.0f)?"Aprobado":"Reprobado"; // Operador ternario (condicion)? comparacion1(verdadero):comparacion2(falso)
            return true;
        }
        return false;
    }
    
    public Boolean generarFiles() {
        if (data != null) {
            String pathNotas = "data" + File.separatorChar + "nominaAlumnos.txt";
            try {
                FileWriter fileNotas = new FileWriter(pathNotas); // abrir conexion hacia el archivo
                for (int i = 0; i < data.length; i++) {
                    String datos = "";
                    for (int j = 0; j < data[0].length; j++) {                     
                        datos += data[i][j]+"\t";
                    }
                
                    fileNotas.write(datos.toString() + "\n");
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
        String pathNotas = "data" + File.separatorChar + "nominaAlumnos.txt";
        try {
            FileReader frn = new FileReader(pathNotas);
            BufferedReader fileNotas = new BufferedReader(frn);
            FileReader fra1 = new FileReader(pathNotas);
            BufferedReader size = new BufferedReader(fra1);
            
            crear(Integer.parseInt(String.valueOf(size.lines().count())));
            
            String linea;
            int cont = 0;
            while((linea = fileNotas.readLine()) != null) {
                String[] aux = linea.split("\t");
                if (aux[0].equalsIgnoreCase("null")) {
                    data[cont][0] = null;
                    data[cont][1] = null;
                    data[cont][2] = null;
                } else {
                    data[cont][0] = aux[0];
                    data[cont][1] = aux[1];
                    data[cont][2] = aux[2];
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
