/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.Feed;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import utiles.Grafica;
import utiles.Medicion;
import utiles.Utiles;

/**
 *
 * @author juan
 */
public class Main {
    public static void main(String [] args){
        System.out.println("Desea volver a generar set de datos Y/n");
        Scanner entrada = new Scanner(System.in);
        char respuesta = entrada.next().charAt(0);
        if (respuesta == 'Y'){
            System.out.println("Generando set de datos...");
            Feed.generarArchivo();
        }
        System.out.println("Desea Generar grafico Y/n");
        entrada = new Scanner(System.in);
        respuesta = entrada.next().charAt(0);
        if (respuesta == 'Y'){
            //Genero escalas para el grafico
            int[] escalas = new int[1000];
            int inicial =0;
            for(int i=0;i<escalas.length;i++){           
                inicial=inicial+1000;
                escalas[i]=inicial;
            }
            System.out.println("Que grafico desea generar r:Radix h:Heap s:Sort");
            entrada = new Scanner(System.in);
            respuesta = entrada.next().charAt(0);
            switch(respuesta){
                case 'r':
                    System.out.println("Graficando, esto pude demorar bastante...");
                    //Medicion.generar(escalas, 0, Medicion.ARCHIVO_RADIX);
                    SwingUtilities.invokeLater(() -> {
                    long [] x =Medicion.leerEscalas(Medicion.ARCHIVO_RADIX);
                    long [] y =Medicion.leerValores(Medicion.ARCHIVO_RADIX);
                    Grafica ex = new Grafica(x,y, "Radix sort");
                    ex.setVisible(true);
                });
                break;
                case 'h':
                    System.out.println("Graficando, esto pude demorar bastante...");
                    Medicion.generar(escalas, 1, Medicion.ARCHIVO_HEAP);
                    SwingUtilities.invokeLater(() -> {
                    long [] x =Medicion.leerEscalas(Medicion.ARCHIVO_HEAP);
                    long [] y =Medicion.leerValores(Medicion.ARCHIVO_HEAP);
                    Grafica ex = new Grafica(x,y, "Heap sort");
                    ex.setVisible(true);
                });
                break;    
                case 's':
                    System.out.println("Graficando, esto pude demorar bastante...");
                    Medicion.generar(escalas, 2, Medicion.ARCHIVO_SELECTION);
                    SwingUtilities.invokeLater(() -> {
                    long [] x =Medicion.leerEscalas(Medicion.ARCHIVO_SELECTION);
                    long [] y =Medicion.leerValores(Medicion.ARCHIVO_SELECTION);
                    Grafica ex = new Grafica(x,y, "Selection sort");
                    ex.setVisible(true);
                });
                break;
                
                default:
                    System.out.println("Opcion invalida");
                break;
                    
            }
            
        }
    }
    
}
