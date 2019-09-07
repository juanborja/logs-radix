/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import data.Feed;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Radix;
import static utiles.Utiles.NOMBRE_ARCHIVO;

/**
 *
 * @author juan
 */
public class Medicion {
    public static final String ARCHIVO_RADIX = "/home/juan/Documentos/unco/Analisis de algoritmos/AnalisisAlgoritmosMaven/src/main/java/data/radix.txt";
    public static final String ARCHIVO_HEAP = "/home/juan/Documentos/unco/Analisis de algoritmos/AnalisisAlgoritmosMaven/src/main/java/data/heap.txt";
    public static final String ARCHIVO_SELECTION = "/home/juan/Documentos/unco/Analisis de algoritmos/AnalisisAlgoritmosMaven/src/main/java/data/selection.txt";
    public static final String ARCHIVO_N = "/home/juan/Documentos/unco/Analisis de algoritmos/AnalisisAlgoritmosMaven/src/main/java/data/n.txt";
    public static final String ARCHIVO_LOGN = "/home/juan/Documentos/unco/Analisis de algoritmos/AnalisisAlgoritmosMaven/src/main/java/data/logn.txt";
    /*
    Genero datos para graficos y los guardo en archivos
    parametros
    escalas--> Arreglo de enteros con los valores de n con los que quiero hacer la grafica
    metodo --> entero, 0 para radix, 1 para heap, 2 para seleccion default usa el sort de java
    archivo --> nombre del archivo en el que voy a guardar los datos
    */
    public static long[] generar(int[]escalas, int metodo, String archivo){
        long[] valores = new long[escalas.length];
        try {
            
            Arrays.sort(escalas);
            BufferedWriter buff = new BufferedWriter(new FileWriter(archivo));
            buff.write(escalas.length+"\n");
            for (int i=0;i<escalas.length;i++){
                String[] log= Feed.leerArchivoParcial(escalas[i]);
                //System.out.println(Arrays.toString(log));
                long[] logAsLong = Utiles.convertToLong(log);
                long t0 = System.currentTimeMillis();
                switch(metodo){
                    case 0:
                       Radix.ordenarRadix(logAsLong, logAsLong.length);
                       break;
                    case 1:
                        Ordenar.ordenarHeap(logAsLong);
                        break;
                    case 2:
                        Ordenar.ordenarSeleccion(logAsLong);
                        break;
                    default:
                        Arrays.sort(logAsLong);
                        break;
                }
                
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
    
        public static long[] leerEscalas(String archivo){
        long [] ret = new long [20];
        try{
    		BufferedReader buff = new BufferedReader(new FileReader(archivo));
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
    
    public static long[] leerValores(String archivo){
        long [] ret = new long [20];
        try{
    		BufferedReader buff = new BufferedReader(new FileReader(archivo));
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
    // 0 --> genera n, 1 genera n*log n
    public static long[] generarPatron(int metodo,int[]escalas,String archivo, float k){
        long[] valores = new long[escalas.length];
        try {
            
            Arrays.sort(escalas);
            BufferedWriter buff = new BufferedWriter(new FileWriter(archivo));
            buff.write(escalas.length+"\n");
            for (int i=0;i<escalas.length;i++){
                switch(metodo){
                    case 0:
                       valores[i] = (long) ((long)escalas[i]*k);
                       break;
                    case 1:
                        valores[i] = (long) (Math.log(escalas[i])*k);
                        break;
                    case 2:
                        //valores[i] = (long) ((long)i*k);
                        break;
                    default:
                        
                        break;
                }
                
              
                buff.write( escalas[i]+","+valores[i] +"\n");
    		}
    		buff.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return valores;
    }
    
}
