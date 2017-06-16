package drawChart.Form.ChartType;

import java.awt.*;

/**
 * Created by Tom on 16.06.2017.
 */
public class Primitives {
    private double []x;
    private double []y;
    private Color color;

    public Primitives(double []x, double []y, Color color){
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

    public int getMaxX(){
        return x.length-1;
    }

    public int getMinX(){
        return 0;
    }

    public int getMaxY(){
        int index = 0;
        double temp = y[0];
        for(int i=1; i<y.length; i++){
            if(temp < y[i]){
                temp = y[i];
                index = i;
            }
        }
        return index;
    }

    public int getMinY(){
        int index = 0;
        double temp = y[0];
        for(int i=1; i<y.length; i++){
            if(temp > y[i]){
                temp = y[i];
                index = i;
            }
        }
        return index;
    }
}
