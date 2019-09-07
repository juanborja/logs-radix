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
            System.out.println("Que grafico desea generar r:Radix h:Heap s:Sort a:All x:Radix completo");
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
                    //Medicion.generar(escalas, 1, Medicion.ARCHIVO_HEAP);
                    SwingUtilities.invokeLater(() -> {
                    long [] x =Medicion.leerEscalas(Medicion.ARCHIVO_HEAP);
                    long [] y =Medicion.leerValores(Medicion.ARCHIVO_HEAP);
                    Grafica ex = new Grafica(x,y, "Heap sort");
                    ex.setVisible(true);
                });
                break;    
                case 's':
                    /*escalas = new int[1000];
                    inicial =0;
                    for(int i=0;i<escalas.length;i++){           
                        inicial=inicial+100;
                        escalas[i]=inicial;
                    }
                    System.out.println("Graficando, esto pude demorar bastante...");
                    Medicion.generar(escalas, 2, Medicion.ARCHIVO_SELECTION);*/
                    SwingUtilities.invokeLater(() -> {
                    long [] x =Medicion.leerEscalas(Medicion.ARCHIVO_SELECTION);
                    long [] y =Medicion.leerValores(Medicion.ARCHIVO_SELECTION);
                    Grafica ex = new Grafica(x,y, "Selection sort");
                    ex.setVisible(true);
                });
                break;
                case 'a':
                    System.out.println("Graficando, esto pude demorar bastante...");
                    //Medicion.generar(escalas, 2, Medicion.ARCHIVO_SELECTION);
                    SwingUtilities.invokeLater(() -> {
                    long [] x =Medicion.leerEscalas(Medicion.ARCHIVO_RADIX);
                    long [] y =Medicion.leerValores(Medicion.ARCHIVO_RADIX);
                    long [] x1 =Medicion.leerEscalas(Medicion.ARCHIVO_HEAP);
                    long [] y1 =Medicion.leerValores(Medicion.ARCHIVO_HEAP);
                    long [] x2 =Medicion.leerEscalas(Medicion.ARCHIVO_SELECTION);
                    long [] y2 =Medicion.leerValores(Medicion.ARCHIVO_SELECTION);
                    Grafica ex = new Grafica(x,y,x1,y1,x2,y2, "Comparativa empirico");
                    ex.setVisible(true);
                });
                break;
                
                 case 'x':
                    System.out.println("Graficando, esto pude demorar bastante...");
                    //Medicion.generar(escalas, 2, Medicion.ARCHIVO_SELECTION);
                    SwingUtilities.invokeLater(() -> {
                    long [] x =Medicion.leerEscalas(Medicion.ARCHIVO_RADIX);
                    long [] y =Medicion.leerValores(Medicion.ARCHIVO_RADIX);
                    long [] x1 =Medicion.leerEscalas(Medicion.ARCHIVO_N);
                    long [] y1 =Medicion.leerValores(Medicion.ARCHIVO_N);
                    long [] x2 =Medicion.leerEscalas(Medicion.ARCHIVO_LOGN);
                    long [] y2 =Medicion.leerValores(Medicion.ARCHIVO_LOGN);
                    Grafica ex = new Grafica(x,y,x1,y1,x2,y2, "Radix con cotas");
                    ex.setVisible(true);
                });
                break;
                
                default:
                    System.out.println("Opcion invalida");
                break;
                    
            }
            
        }
         int[] escalas = new int[1000];
            int inicial =0;
            for(int i=0;i<escalas.length;i++){           
                inicial=inicial+1000;
                escalas[i]=inicial;
            }
        Medicion.generarPatron(1, escalas, Medicion.ARCHIVO_LOGN, 70);
        Medicion.generarPatron(0, escalas, Medicion.ARCHIVO_N, 0.0005f);
    }
    
}
