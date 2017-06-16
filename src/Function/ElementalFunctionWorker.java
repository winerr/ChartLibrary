package Function;

import drawChart.Form.ChartType.Bubble;
import drawChart.Form.ChartType.Line;

import java.awt.*;

/**
 * Created by Dmytro Vertepniy on 28.09.2016.
 */

public abstract class ElementalFunctionWorker {
    private double a, b, h;
    private int n;
    private double []x;
    private double []y;
    private Bubble line;

    public ElementalFunctionWorker(double a, double b, int n){
        this.a = a;
        this.b = b;
        this.n = n;
        x = new double[n];
        y = new double[n];
    }

    public void Tabulation(){
        this.h = (b-a)/n;

        x[0] = a;
        y[0] = f(x[0]);

        for (int i = 1; i < n; i++) {
            x[i] = x[i-1] + h;
            y[i] = f(x[i]);
        }

        line = new Bubble(x, y, new Color(255, 0, 0));

    }

    abstract double f(double x);

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    public Bubble getLine() {
        return line;
    }
}
