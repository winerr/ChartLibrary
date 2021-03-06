package Function;


/**
 * Created by Dmytro Vertepniy on 28.09.2016.
 */

public abstract class ElementalFunctionWorker {
    private double a, b, h;
    private int n;
    private Double []x;
    private Double []y;

    public ElementalFunctionWorker(double a, double b, int n){
        this.a = a;
        this.b = b;
        this.n = n;
        x = new Double[n];
        y = new Double[n];
    }

    public void Tabulation(){
        this.h = (b-a)/n;

        x[0] = a;
        y[0] = f(x[0]);

        for (int i = 1; i < n; i++) {
            x[i] = x[i-1] + h;
            y[i] = f(x[i]);
        }

    }

    abstract double f(double x);

    public Double[] getX() {
        return x;
    }

    public Double[] getY() {
        return y;
    }

}
