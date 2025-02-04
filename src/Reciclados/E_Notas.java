package Reciclados;

import Ejercicio_Empresa.Utiles;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class E_Notas {

    // Declarando - Variables globales no retornan
    private Float[] notas;
    private String[] alumnos;

    public Float[] getNotas() {
        return notas;
    }

    public String[] getAlumnos() {
        return alumnos;
    }

    public void crear(Integer nro) {
        this.notas = new Float[nro];
        alumnos = new String[nro];  
    }

    public Float promedio() {
        Float promedio = 0.0f;
        Float cont = 0.0f;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] != null) {
                cont++;
                promedio += notas[i];
            }
        }
        return Utiles.redondear(promedio / cont);
    }

    public Integer verificar() {
        Integer pos = -1;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public Boolean guardar(String alumno, Float nota) {
        int pos = verificar();
        System.out.println("pos " + pos);
        if (pos >= 0) {
            alumnos[pos] = alumno;
            notas[pos] = nota;
            System.out.println("Guardo");
            return true;
        }
        return false;
    }

    public Boolean modificar(String alumno, Float nota, Integer pos) {
        if (pos >= 0) {
            alumnos[pos] = alumno;
            notas[pos] = nota;
            return true;
        }
        return false;
    }

    public Boolean generarFiles() {
        if (notas != null && alumnos != null) {
            String pathNotas = "data" + File.separatorChar + "notas.txt";
            String pathAlumnos = "data" + File.separatorChar + "alumnos.txt";
            try {
                FileWriter fileNotas = new FileWriter(pathNotas); // abrir conexion hacia el archivo
                FileWriter fileAlumnos = new FileWriter(pathAlumnos);
                for (int i = 0; i < notas.length; i++) {
                    if (notas[i] != null) {
                        fileNotas.write(notas[i].toString() + "\n");
                        fileNotas.flush();
                    }
                }
                fileNotas.close(); // cerrar conexion hacia el archivo
                for (int i = 0; i < alumnos.length; i++) {
                    if (alumnos[i] != null) {
                        fileAlumnos.write(alumnos[i] + "\n");
                        fileAlumnos.flush();
                    }
                }
                fileAlumnos.close();
                return true;
            } catch (Exception e) {
                return false;
            }

        }
        return false;
    }

    public Boolean cargarArchivo() {
        String pathNotas = "data" + File.separatorChar + "notas.txt";
        String pathAlumnos = "data" + File.separatorChar + "alumnos.txt";
        try {
            FileReader frn = new FileReader(pathNotas);
            BufferedReader fileNotas = new BufferedReader(frn);
            FileReader fra = new FileReader(pathAlumnos);
            BufferedReader fileAlumnos = new BufferedReader(fra);
            FileReader fra1 = new FileReader(pathAlumnos);
            BufferedReader size = new BufferedReader(fra1);
            crear(Integer.parseInt(String.valueOf(size.lines().count())));
            String linea;
            int cont = 0;
            while((linea = fileNotas.readLine()) != null) {
                notas[cont] = Float.parseFloat(linea);
                cont++;
            }
            frn.close();
            fileNotas.close(); // cerrar conexion hacia el archivo
            cont = 0;
            String linea1;
            while((linea1 = fileAlumnos.readLine()) != null) {
                alumnos[cont] = linea1;
                cont++;
            }
            fra.close();
            fileAlumnos.close();
            
            fra1.close();
            size.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
