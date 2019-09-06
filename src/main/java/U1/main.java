/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1;

import U1.Ordena;

/**
 *
 * @author juan
 */
public class main {
    public static void main (String []args){
        int [] arreglo = {1,6,7,2,3,5,6,7,89,23,112,3,23,45,6,76,3};
        Ordena.insercion(arreglo);
        
        for(int a=0; a<arreglo.length;a++){
            System.out.println(arreglo[a]);
        }
    }
    
}
