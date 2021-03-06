package Chart.Series;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by winer on 6/18/2017.
 */
public class Series {
    private Type seriesType;
    private List<Double> X;
    private List<Double> Y;

    public Series(Type t){
        this.seriesType = t;
        this.X = new ArrayList<>();
        this.Y = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Series{" +
                "seriesType=" + seriesType +
                ", X=" + X +
                ", Y=" + Y +
                '}';
    }

    public void AddXY(double X, double Y){
        this.X.add(X);
        this.Y.add(Y);
    }

    public List<Double> getX() {
        return X;
    }

    public void setX(List<Double> x) {
        X = x;
    }

    public List<Double> getY() {
        return Y;
    }

    public void setY(List<Double> y) {
        Y = y;
    }

    public double getMinX(){
        double min = Collections.min(X);
        return min;
    }

    public double getMinY(){
        double min = Collections.min(Y);
        return min;
    }

    public Type getSeriesType() {
        return seriesType;
    }

    public double getMaxX(){
        double max = Collections.max(X);
        return max;
    }

    public double getMaxY(){
        double max = Collections.max(Y);
        return max;
    }
}
