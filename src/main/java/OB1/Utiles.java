/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OB1;

import inout.Feed;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fran_
 */
public class Utiles {
    static final String NOMBRE_ARCHIVO = "/home/juan/Documentos/unco/Analisis de algoritmos/AnalisisAlgoritmosMaven/src/main/java/inout/radix.txt";
    private static long obtenerNumeros(String cad) {
        int longitud = cad.length();
        long resultado=0;
        String aux="";
        char caracAux;
        for(int i=0; i<longitud;i++){
            caracAux= cad.charAt(i);
            if(Character.isDigit(caracAux)){
            aux=aux+caracAux;
            }            
        }
        //aux.trim();
        resultado=Long.parseLong(aux);        
        return resultado;
        }

    static long[] convertToLong(String[] arr) {
        long [] ret = new long [arr.length];
        for (int i=0; i<ret.length;i++){
           ret[i]=obtenerNumeros(arr[i]);
        }
        return ret;
    }

   
    
    static long[] invertido(long[] a) {
	long [] inv = a.clone();
	int l = a.length;
	long temp;
	for (int i=0;i<l/2-1;i++) {
            temp = inv[i];
            inv[i] = inv[l-i-1];
            inv[l-i-1] = temp;
	}
	return inv;
    }
    
    static long[] medirEmpirico(int[]escalas){
        long[] valores = new long[escalas.length];
        try {
            
            Arrays.sort(escalas);
            BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
            buff.write(escalas.length+"\n");
            for (int i=0;i<escalas.length;i++){
                String[] log= Feed.leerArchivoParcial(escalas[i]);
                //System.out.println(Arrays.toString(log));
                long[] logRadix = Utiles.convertToLong(log);
                long t0 = System.currentTimeMillis();
                Log.ordenarRadix(logRadix, logRadix.length);
                long t1 = System.currentTimeMillis();
                valores[i] =t1-t0;
                buff.write( escalas[i]+","+valores[i] +"\n");
    		}
    		buff.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return valores;
    }
    
    public static long[] leerEscalas(){
        long [] ret = new long [20];
        try{
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
                int totales= Integer.parseInt(buff.readLine().trim());
                ret = new long [totales];
    		for (int i = 0; i < totales ; i++){
                    String[] split = buff.readLine().split(",");
                    ret[i] = Integer.parseInt(split[0].trim());
                }
                buff.close();
    	}
    	catch (FileNotFoundException ex) {
    		System.err.println(ex.getMessage() + "\nEl archivo de lectura no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
        return ret;
    }
    
    public static long[] leerValores(){
        long [] ret = new long [20];
        try{
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
                int totales= Integer.parseInt(buff.readLine().trim());
                ret = new long [totales];
    		for (int i = 0; i < totales ; i++){
                    String[] split = buff.readLine().split(",");
                    ret[i] = Integer.parseInt(split[1].trim());
                }
                buff.close();
    	}
    	catch (FileNotFoundException ex) {
    		System.err.println(ex.getMessage() + "\nEl archivo de lectura no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
        return ret;
    }
    
   
}
