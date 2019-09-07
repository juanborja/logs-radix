/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OB1;

import inout.Feed;
import java.util.Arrays;

/**
 *
 * @author juan
 */
class Log {

   

    static void ordenarSeleccion(long[] logSeleccion) {
        
    }
    
     static long getMax(long arr[], int n) { 
        long mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    static void countSort(long arr[], int n, int exp) { 
        long output[] = new long[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) {
            int aux =(int) ((arr[i]/exp)%10);
            //System.out.println(arr[i]+" - "+exp+" - "+aux);
            count[ aux ]++; 
        }
            
            
            
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            int aux = (int)((arr[i]/exp)%10);
            output[(int)count[aux ] - 1] = arr[i];
            int aux2 = (int)((arr[i]/exp)%10);
            count[ aux2 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    static void ordenarRadix(long arr[], int n) { 
        // Find the maximum number to know number of digits 
        long m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
    
    public static void main (String [] args){
        /*String[] log= Feed.leerArchivo();
        long[] logRadix = Utiles.convertToLong(log);
        long[] logJava = logRadix.clone();
        Log.ordenarRadix(logRadix, logRadix.length);
        Arrays.sort(logJava);     
        System.err.println(Arrays.toString(log));
        System.err.println(Arrays.toString(logRadix));
        System.err.println(Arrays.toString(logJava));*/
        int[] escalas = new int[1000];
        int inicial =0;
        for(int i=0;i<escalas.length;i++){           
            inicial=inicial+1000;
            escalas[i]=inicial;
        }
        long [] valores=Utiles.medirEmpirico(escalas);
        System.out.println(Arrays.toString(escalas));
        System.out.println(Arrays.toString(valores));
        
    }
}
