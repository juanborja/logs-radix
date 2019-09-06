/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1;

/**
 *
 * @author juan
 */
public class Ordena {
  
    public static void burbuja(int[] a) {
        int i, j, aux;
        for (i = 0; i < a.length - 1; i++) {
            for (j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    aux = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = aux;
                }
            }
        }
    }
    
    public static void burbujaMejorado(int[] a){
        /* int i, j, aux;
        for (i = 0; i < a.length - 1; i++) {
            for (j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    aux = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = aux;
                }
            }
        }*/
    }
    
    public static void seleccion(int[] a){
        for(int i=0; i< a.length -1; i++){
           for (int j=i+1;j<a.length;j++){
               if(a[j]<a[i]){
                   int aux = a[j];
                   a[j] = a[i];
                   a[i] = aux;
               }
           }
            
        }        
        
    }
    
    public static void insercion(int[] a){
        for (int i =1; i<a.length; i++ ){
            int j = i-1;
            int key = a[i];
            while(j>=0 && a[j]>key){
                a[j+1]=a[j];
                j--;
                
            }
            a[j+1]=key;
        }
    }
    
    public static void quicksort(int[] a){
        
    }
            
}
