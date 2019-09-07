/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import utiles.Utiles;
import main.Radix;
import data.Feed;
import java.lang.reflect.Array;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static utiles.Ordenar.ordenarSeleccion;

/**
 *
 * @author juan
 */
public class RadixTest {
    /*El radix va a oridenar creciente y luego lo voy a invertir. El seleccion va a ordenar decreciente. 
    Asi me aseguro que el test falle primero.*/
    @Test
    public void TestContraSeleccion(){
        String[] log= Feed.leerArchivo();
        long[] logRadix = Utiles.convertToLong(log);
        long[] logSel = logRadix.clone();
        Radix.ordenarRadix(logRadix, logRadix.length);
        ordenarSeleccion(logSel);
        Utiles.invertido(logSel);
        assertArrayEquals(logRadix,logSel);
        
    }
    /*Como sort Java ordena decreceinte y el radix tambien */
    @Test
    public void TestContraJava(){
        String[] log= Feed.leerArchivo();
        long[] logRadix = Utiles.convertToLong(log);
        long[] logJava = logRadix.clone();
        Radix.ordenarRadix(logRadix, logRadix.length);
        Arrays.sort(logJava);        
        assertArrayEquals(logRadix,logJava);
        
    }
    /*Verifico que cada elemento sea menor al anterior*/
    @Test
    public void TestExhaustivo(){
       String[] log= Feed.leerArchivo();
        long[] logRadix = Utiles.convertToLong(log);
        Radix.ordenarRadix(logRadix, logRadix.length);        
        for(int i=1;i<logRadix.length-1;i++){
            assertTrue(logRadix[i]<=logRadix[i+1]);
           
        }
        
             
    }
    
}
