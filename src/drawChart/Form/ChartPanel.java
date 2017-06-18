package drawChart.Form;

import Chart.Series.Series;
import Chart.Series.Type.Type;
import Function.Function;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Dmytro Vertepniy on 09.09.2016.
 */
public class ChartPanel extends JPanel {

    private List<Series> series;


    private int L = 50;
    private double Kx, Zx, Ky, Zy, MinX, MaxX, MaxY, MinY;
    private double start;
    private int indexOfMaxArrayX, indexOfMinArrayX, w, h;


    public ChartPanel(List<Series> data){
        setBorder(BorderFactory.createLineBorder(Color.black));
        series = data;
    }



    private void CreateCoefficient(){
        MinX = series.get(0).getMinX();
        MaxX = series.get(0).getMaxX();
        indexOfMaxArrayX = 0;
        indexOfMinArrayX = 0;
        start = 0;
        for (int i = 1; i < series.size(); i++) {
            if(MinX > series.get(i).getMinX()){
                MinX = series.get(i).getMinX();
                indexOfMinArrayX = i;
            }
            if(MaxX < series.get(i).getMaxX()){
                MaxX = series.get(i).getMaxX();
                indexOfMaxArrayX = i;
            }
        }
        if (indexOfMinArrayX != indexOfMaxArrayX){
            if( series.get(indexOfMaxArrayX).getX().get(0)  <  series.get(indexOfMinArrayX).getX().get(0))
                start = series.get(indexOfMaxArrayX).getX().get(0);
            else
                start = series.get(indexOfMinArrayX).getX().get(0);
        }else{
            start = series.get(indexOfMaxArrayX).getX().get(0);
        }

        MinY = series.get(0).getMinY();
        MaxY = series.get(0).getMaxY();

        for (int i = 1; i < series.size(); i++) {
            if(MinY > series.get(i).getMinY()){
                MinY = series.get(i).getMinY();
            }
            if(MaxY < series.get(i).getMaxY()){
                MaxY = series.get(i).getMaxY();
            }
        }

        w = getWidth();
        h = getHeight();

        Kx = (w - 2 * L) / (MaxX - MinX);
        Ky = (h - 2 * L) / (MinY - MaxY);

        Zx = (w * MinX - L * (MinX + MaxX)) / (MinX - MaxX);
        Zy = (h * MaxY - L * (MinY + MaxY)) / (MaxY - MinY);
    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        drawGraph(g);
    }

    private void printLine(Graphics2D g, Series s){
        g.setStroke(new BasicStroke(2.0f));
        for (int i = 0; i <= s.getX().size()-2; i++) {
            g.drawLine((int) (Kx * s.getX().get(i) + Zx), (int) (Ky * s.getY().get(i) + Zy), (int) (Kx * s.getX().get(i+1) + Zx), (int) (Ky * s.getY().get(i+1) + Zy));
        }

    }

    private void printBubble(Graphics2D g, Series s){
        g.setStroke(new BasicStroke(2.0f));
        for (int i = 0; i < s.getX().size(); i++) {
            g.drawOval((int) (Kx * s.getX().get(i) + Zx), (int) (Ky * s.getY().get(i) + Zy), 5, 5);
        }
    }

    private void drawLayaout(Graphics2D g){


        double h = (MaxX - MinX)/10.0;
        System.out.println(MinX + "  " + MaxX + "  " + h);



        g.setStroke(new BasicStroke(1.0f));
        for (double temp = MinX; temp < MaxX; temp += h ) {
            System.out.println(temp);
            g.drawLine((int)(Kx * temp + Zx), L, (int)(Kx * temp + Zx), this.h-L);
            g.drawString(String.format("%.3f", temp), (int)(Kx * temp + Zx), (int)(Ky * MinY + Zy));
        }


        h = (MaxY-MinY)/10.0;
        for (double temp = MinY; temp < MaxY; temp += h) {
            g.drawLine(L, (int) (Ky * temp + Zy), w - L, (int) (Ky * temp + Zy));
            g.drawString(String.format("%.3f", temp), (int)(Kx * MinX + Zx), (int)(Ky * temp + Zy));
        }


    }


    private void drawGraph(java.awt.Graphics g1) {
        Graphics2D g = (Graphics2D) g1;

        CreateCoefficient();

        drawLayaout(g);

        for(Series s: series){
            if(s.getSeriesType() == Type.LINE){
                printLine(g, s);
            }else if(s.getSeriesType() == Type.BUBBLE){
                printBubble(g, s);
            }
        }
    }
}