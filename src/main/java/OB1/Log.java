/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OB1;

import java.util.Arrays;

/**
 *
 * @author juan
 */
class Log {

    static void ordenarRadix(String[] logRadix) {
        
    }

    static void ordenarSeleccion(String[] logSeleccion) {
        
    }
    
    public static void radixSort(int[]arreglo) {      
        for (int x = Integer.SIZE - 1; x >= 0; x--) {
            int[] auxiliar = new int[arreglo.length];
            int j = 0;

            for (int i = 0; i < arreglo.length; i++) {
                //System.out.println("NUM "+arreglo[i]+" ES "+Integer.toBinaryString(arreglo[i]));
                
                System.out.println("NUM PARSE "+arreglo[i]+" ES "+Integer.toBinaryString(arreglo[i] << x));
                System.out.println("PARA "+(arreglo[i])+" VALE "+(arreglo[i] << x));
                boolean mover = (arreglo[i] << x) >= 0;

                if (x == 0 ? !mover : mover) {
                    auxiliar[j] = arreglo[i];
                    j++;
                } else {
                    arreglo[i - j] = arreglo[i];
                }

            }

            for (int i = j; i < auxiliar.length; i++) {
                auxiliar[i] = arreglo[i - j];
            }

            arreglo = auxiliar;
            
            //System.out.println("========");
        }

        System.out.println("ARREGLO ES " + Arrays.toString(arreglo));
    }
    public static void main (String [] args){
        int []test ={20200112,20191230,20210505,20221106};
        System.err.println(Arrays.toString(test));
        radixSort(test);
        
        System.err.println(Arrays.toString(test));
        
    }
   
    
    
   
}
