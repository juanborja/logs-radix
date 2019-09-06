/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OB1;

import java.lang.reflect.Array;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author juan
 */
public class LogTest {
    /*Contorlamos que la longitud sea igual, sino no pueden ordenar*/
    @Test
    public void TestLongitud(){
        String[] logAleatorio = Feed.leerArchivo();
        String [] logOrdenado = logAleatorio.clone();
        Log.ordenarRadix(logOrdenado);
        assertEquals(logAleatorio.length,logOrdenado.length);
        
    }
    /*Si ninguno de los dos ordena el test pasa igual. esta bien?*/
    @Test
    public void TestContraSeleccion(){
        String[] logRadix = Feed.leerArchivo();
        String[] logSeleccion = logRadix.clone();
        Log.ordenarRadix(logRadix);
        Log.ordenarSeleccion(logSeleccion);
        assertArrayEquals(logRadix,logSeleccion);
        
    }
    
    @Test
    public void TestJava(){
        String[] logRadix = Feed.leerArchivo();
        String[] logJava = logRadix.clone();
        Log.ordenarRadix(logRadix);
        Arrays.sort(logJava);
        assertArrayEquals(logRadix,logJava);
        
    }
    /*Verifico que cada elemento sea menor al anterior*/
    @Test
    public void TestExa(){
        String[] logRadix = Feed.leerArchivo();
        Log.ordenarRadix(logRadix);        
        for(int i=0;i+1<logRadix.length;i++)assertTrue(logRadix[i].compareTo(logRadix[i+1])>0);     
    }
    
}
