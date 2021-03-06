package Function;



import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/**
 * Created by dmytro on 25.03.16.
 */


public class Function extends ElementalFunctionWorker{


    private String function;

    ScriptEngineManager manager;
    ScriptEngine engine;
    Object result;

    public Function(String function, double a, double b) {
        super(a, b, 100);
        this.function = function;
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");
    }

    double f(double x){
        try {
            result = engine.eval("var x=" + x + ";" + "y = " + function);
            String str = result.toString();
            return Double.parseDouble(str);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
