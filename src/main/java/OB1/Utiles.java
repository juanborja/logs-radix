/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OB1;

/**
 *
 * @author fran_
 */
public class Utiles {
    private static long obtenerNumeros(String cad) {
        int longitud = cad.length();
        long resultado=0;
        String aux="";
        char caracAux;
        for(int i=0; i<longitud;i++){
            caracAux= cad.charAt(i);
            if(Character.isDigit(caracAux)){
            aux=aux+caracAux;
                System.out.println("Cadena: "+aux);
            //System.out.println("Caracter: "+ caracAux);
            }            
        }
        aux.trim();
        resultado=Long.parseLong(aux);        
        return resultado;
        }
}
