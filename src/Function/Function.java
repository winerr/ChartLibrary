package Function;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/**
 * Created by dmytro on 25.03.16.
 */


public class Function{


    double a,b;
    int N;
    String function;
    double[]x;
    double[]y;

    ScriptEngineManager manager;
    ScriptEngine engine;
    Object result;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }



    public Function(String function, double a, double b, int N) {
        this.function = function;
        this.a = a;
        this.b = b;
        this.N = N;
        x = new double[N];
        y = new double[N];
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");
        tab();
    }

    public Function(String function, double a, double b) {
        this.function = function;
        this.a = a;
        this.b = b;
        N = 100;
        x = new double[N];
        y = new double[N];
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");
        tab();

    }

    public Function(String function) {
        this.function = function;
        this.a = 0;
        this.b = 1;
        N = 100;
        x = new double[N];
        y = new double[N];
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");
        tab();
    }

    private void tab(){
        double h = (b-a)/N;
        x[0] = a;
        for(int i = 0; i < N-1; i++){
            y[i] = f(x[i]);
            x[i+1] = x[i] + h;
        }
        y[y.length-1]=f(x[x.length-1]);
    }

    private double f(double x){
        try {
            Object result = engine.eval("var x=" + x + "; " + "y = " + function + "; if(y==Infinity){0}else{y}");
            String str = result.toString();
            return Double.parseDouble(str);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }


}
