package drawChart.Form;

import Function.Function;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Dmytro Vertepniy on 09.09.2016.
 */
class MyPanel extends JPanel {

    private int L = 50;
    double Kx,Zx,Ky,Zy;
    private double [][]x;
    private double [][]y;
    private double [][][]array;
    Random r;

    Function f;

    public MyPanel(double []x, double[]...y) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        r = new Random();
        this.x = new double[1][];
        this.x[0] = x;
        this.y = y;
    }

    public MyPanel(double [][]x, double [][]y) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        r = new Random();
        this.x = x;
        this.y = y;

    }


    public MyPanel(String function, double a, double b) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        f = new Function(function, a, b);
        r = new Random();
        this.x = new double[1][];
        this.x[0] = f.getX();
        this.y = new double[1][];
        this.y[0] = f.getY();
    }

    public Dimension getPreferredSize() {
        return new Dimension(500,500);
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        drawGraph(g);
    }

    private void printLine(Graphics2D g){

        g.setStroke(new BasicStroke(2.0f));
        if(x.length == 1) {
            for (int i = 0; i < y.length; i++) {
                g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                try {
                    for (int j = 0; j <= y[i].length - 2; j++) {
                        g.drawLine((int) (Kx * x[0][j] + Zx), (int) (Ky * y[i][j] + Zy), (int) (Kx * x[0][j + 1] + Zx), (int) (Ky * y[i][j + 1] + Zy));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e);
                }
            }
        }else{
            for (int i = 0; i < y.length; i++) {
                g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                try {
                    for (int j = 0; j <= y[i].length - 2; j++) {
                        g.drawLine((int) (Kx * x[i][j] + Zx), (int) (Ky * y[i][j] + Zy), (int) (Kx * x[i][j + 1] + Zx), (int) (Ky * y[i][j + 1] + Zy));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e);
                }
            }
        }
    }

    private void drawGraph(java.awt.Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        double MinX = 0;
        double MaxX = 0;
        int indexOfMaxArrayX = 0;
        int indexOfMinArrayX = 0;
        double start = 0;

        if(x.length != 1) {
            for (int i = 0; i < x.length; i++) {
                for (int j = 0; j < x[i].length; j++) {
                    if (x[i][j] < MinX) {
                        MinX = x[i][j];
                        indexOfMinArrayX = i;
                    }
                    if (y[i][j] > MaxX) {
                        MaxX = x[i][j];
                        indexOfMaxArrayX = i;
                    }
                }
            }
        }else{
            MinX = x[0][0];
            MaxX = x[0][x[0].length-1];
        }

        if (indexOfMinArrayX != indexOfMaxArrayX){
            if(x[indexOfMaxArrayX][0] < x[indexOfMinArrayX][0])
                start = x[indexOfMaxArrayX][0];
            else
                start = x[indexOfMinArrayX][0];
        }else{
            start = x[indexOfMaxArrayX][0];
        }




        int w = getWidth();
        int h = getHeight();

        double MinY = 0;
        double MaxY = 0;

        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < y[i].length; j++) {
                if (y[i][j] < MinY)
                    MinY = y[i][j];
                if (y[i][j] > MaxY)
                    MaxY = y[i][j];
            }
        }

        Kx = (w - 2 * L) / (MaxX - MinX);
        Ky = (h - 2 * L) / (MinY - MaxY);

        Zx = (w * MinX - L * (MinX + MaxX)) / (MinX - MaxX);
        Zy = (h * MaxY - L * (MinY + MaxY)) / (MaxY - MinY);

        g.setStroke(new BasicStroke(2.0f));
        g.drawLine(L, (int)(Ky * 0 + Zy), w-L, (int)(Ky * 0 + Zy));
        g.drawLine((int)(Kx * 0 + Zx), L, (int)(Kx * 0 + Zx), h-L);

        g.setStroke(new BasicStroke(1.0f));
        for (int i = (int)start; i < x[indexOfMaxArrayX][x[indexOfMaxArrayX].length-1]; i++) {

            g.drawLine((int)(Kx * i + Zx), L, (int)(Kx * i + Zx), h-L);
            g.drawString(Integer.toString(i), (int)(Kx * i + Zx), (int)(Ky * 0.25 + Zy));
        }

        for (int i = (int)MinY; i < MaxY; i++) {
            g.drawLine(L, (int) (Ky * i + Zy), w - L, (int) (Ky * i + Zy));
            g.drawString(Integer.toString(i), (int)(Kx * 0.2 + Zx), (int)(Ky * i + Zy));
        }

        printLine(g);


    }
}