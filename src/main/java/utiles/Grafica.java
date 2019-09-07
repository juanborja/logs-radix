/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author juan
 */
public class Grafica extends JFrame{
    long[]ejex;
    long[]ejey;
    long[]ejex1;
    long[]ejey1;
    long[]ejex2;
    long[]ejey2;
    boolean multiple = false;
    String titulo ="";
    public Grafica(long[]x, long[]y, long[]x1, long[]y1,long[]x2, long[]y2,String t){
        ejex=x.clone();
        ejey=y.clone();
        ejex1=x1.clone();
        ejey1=y1.clone();
        ejex2=x2.clone();
        ejey2=y2.clone();
        titulo = t;
        multiple = true;
        initUI();
    }

    public Grafica(long[]x, long[]y, String t) throws HeadlessException {
        ejex=x.clone();
        ejey=y.clone();
        titulo = t;
        multiple = false;
        initUI();
    }

    private void initUI() {
         XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset() {
         XYSeries series = new XYSeries("Radix");
         XYSeries series1 = new XYSeries("O(n) k=0.0005");
         XYSeries series2 = new XYSeries("O(log n) k=70");
       /* series.add(18, 567);
        series.add(20, 612);
        series.add(25, 800);
        series.add(30, 980);
        series.add(40, 1410);
        series.add(50, 2350);
        series1.add(10, 10);
        series1.add(20, 20);
        series1.add(30, 30);
        series1.add(40, 40);
        series1.add(50, 50);
        series1.add(60, 60);
        series2.add(100, 100);
        series2.add(200, 200);
        series2.add(300, 300);
        series2.add(400, 400);
        series2.add(500, 500);
        series2.add(600, 600);*/
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        for(int i=0; i<ejex.length;i++){
            series.add(ejex[i],ejey[i]);
        }
        if(multiple){
          for(int i=0; i<ejex1.length;i++){
            series1.add(ejex1[i],ejey1[i]);
        }
        for(int i=0; i<ejex2.length;i++){
            series2.add(ejex2[i],ejey2[i]);
        }
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        }
        

        
        
        

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Incremento del tiempo en función de la entrada", 
                "Entrada(n)", 
                "Tiempo (en ms)", 
                dataset, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false 
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        //renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(0.5f));
        //renderer.setSeriesShapesVisible(0, false);
        //plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.GRAY);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.GRAY);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle(titulo,
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }
    
   
    
}
