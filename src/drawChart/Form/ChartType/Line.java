package drawChart.Form.ChartType;

import java.awt.*;

/**
 * Created by Dmytro Vertepniy on 28.09.2016.
 */
public class Line {
    private double []x;
    private double []y;
    private Color color;

    public Line(double []x, double []y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;

    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public double[] getY() {
        return y;
    }

    public void setY(double[] y) {
        this.y = y;
    }

    public double getCurrentX(int i){
        return x[i];
    }

    public double getCurrentY(int i){
        return y[i];
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
