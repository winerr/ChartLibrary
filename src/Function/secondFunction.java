package Function;

/**
 * Created by Tom on 16.06.2017.
 */
public class secondFunction extends ElementalFunctionWorker {
    public secondFunction(double a, double b, int n) {
        super(a, b, n);
    }

    @Override
    double f(double x) {
        return x*x*x;
    }
}
