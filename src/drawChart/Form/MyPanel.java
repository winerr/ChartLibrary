package drawChart.Form;

import Function.Function;
import drawChart.Form.ChartType.Line;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Dmytro Vertepniy on 09.09.2016.
 */
class MyPanel extends JPanel {

    private int L = 50;
    private double Kx,Zx,Ky,Zy;
    private Line []line;
    private Random r;
    private Function f;

    public MyPanel(Line ...line){
        setBorder(BorderFactory.createLineBorder(Color.black));
        r = new Random();
        this.line = line;
    }

    public MyPanel(String function, double a, double b) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        f = new Function(function, a, b);
        r = new Random();
        line = new Line[1];
        f.Tabulation();
        this.line[0] = f.getLine();
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
        for (int i = 0; i < line.length; i++) {
            g.setColor(line[i].getColor());
            try {
                for (int j = 0; j <= line[i].getY().length - 2; j++) {
                    g.drawLine((int) (Kx * line[i].getCurrentX(j) + Zx), (int) (Ky * line[i].getCurrentY(j) + Zy), (int) (Kx * line[i].getCurrentX(j+1) + Zx), (int) (Ky * line[i].getCurrentY(j+1) + Zy));
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
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

        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line[i].getX().length; j++) {
                if (line[i].getCurrentX(j) < MinX) {
                    MinX = line[i].getCurrentX(j);
                    indexOfMinArrayX = i;
                }
                if (line[i].getCurrentY(j) > MaxX) {
                    MaxX = line[i].getCurrentX(j);
                    indexOfMaxArrayX = i;
                }
            }
        }

        if (indexOfMinArrayX != indexOfMaxArrayX){
            if( line[indexOfMaxArrayX].getCurrentX(0)  < line[indexOfMinArrayX].getCurrentX(0))
                start = line[indexOfMaxArrayX].getCurrentX(0);
            else
                start = line[indexOfMinArrayX].getCurrentX(0);
        }else{
            start = line[indexOfMaxArrayX].getCurrentX(0);
        }

        int w = getWidth();
        int h = getHeight();

        double MinY = 0;
        double MaxY = 0;

        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line[i].getY().length; j++) {
                if ( line[i].getCurrentY(j) < MinY)
                    MinY = line[i].getCurrentY(j);
                if ( line[i].getCurrentY(j) > MaxY)
                    MaxY = line[i].getCurrentY(j);
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
        for (int i = (int)start; i < line[indexOfMaxArrayX].getCurrentX( line[indexOfMaxArrayX].getX().length-1 ); i++) {
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