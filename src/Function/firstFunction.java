package Function;

/**
 * Created by Tom on 16.06.2017.
 */
public class firstFunction extends ElementalFunctionWorker {
    public firstFunction(double a, double b, int n) {
        super(a, b, n);
    }

    @Override
    double f(double x) {
        return x*x;
    }
}
