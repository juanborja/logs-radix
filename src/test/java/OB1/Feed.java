/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OB1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author juan
 */
public class Feed {
    static final String [] USUARIOS = {"carlos", "laura", "pedro","maria","ricardo","sofia", "usuario1", "usuario2", "usuario3"};
    static final int CANTREGISTROS = 100000;
    static final String FECHAINICIO = "2014-09-15 15:03:23";
    static final String FECHAFIN = "2016-09-15 15:03:23";
    static final String NOMBRE_ARCHIVO = "/home/juan/Documentos/unco/Analisis de algoritmos/AnalisisAlgoritmosMaven/src/main/java/inout/log.txt";
    public static String[] leerArchivo(){
    	String [] arreglo = new String[CANTREGISTROS];
    	try{
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
    		for (int i = 0; i < CANTREGISTROS  ; i++)arreglo[i] = buff.readLine();
                buff.close();
    	}
    	catch (FileNotFoundException ex) {
    		System.err.println(ex.getMessage() + "\nEl archivo de lectura no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    	return arreglo;
    }
    
    private static void generarArchivo(){
    	try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
    		Random generador = new Random();
    		for (int i = 0; i < CANTREGISTROS  ; i++){
                        int iusuario= ((int) (Math.random() * USUARIOS.length));
    			String log = generarFechaRandom()+"--"+USUARIOS[iusuario];
    			buff.write( log +"\n");
    		}
    		buff.close();

    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo de lectura no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
    
    private static String generarFechaRandom(){
        int anio = ((int) (Math.random() * 30) + 1)+1990;
        int mes = ((int) (Math.random() * 12) + 1);
        String smes = (mes<10)? "0"+mes:""+mes;
        int dia = ((int) (Math.random() * 31) + 1);
        String sdia = (dia<10)? "0"+dia:""+dia;
        int horas = ((int) (Math.random() * 24));
        String shoras = (horas<10)? "0"+horas:""+horas;
        int minutos = ((int) (Math.random() * 59));
        String sminutos = (minutos<10)? "0"+minutos:""+minutos;
        int segundos = ((int) (Math.random() * 59));
        String ssegundos = (segundos<10)? "0"+segundos:""+segundos;
        
        return (anio+":"+smes+":"+sdia+"-"+shoras+":"+sminutos+":"+ssegundos);
    }
    
    public static void main(String []args){
        generarArchivo();
    }
}
