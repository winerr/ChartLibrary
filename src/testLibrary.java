import Chart.Series.Series;
import Chart.Series.Type.Type;
import Function.firstFunction;
import Function.secondFunction;
import drawChart.Form.drawChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class testLibrary {

    public static void main(String args[]){
        firstFunction f1 = new firstFunction(-5, 5, 25);
        secondFunction f2 = new secondFunction(-2, 3, 25);
        f1.Tabulation();
        f2.Tabulation();

        List<Series> s = new ArrayList<>();

        s.add(new Series(Type.LINE));
        s.add(new Series(Type.BUBBLE));

        s.get(0).setX(Arrays.asList(f1.getX()));
        s.get(1).setX(Arrays.asList(f2.getX()));

        s.get(0).setY(Arrays.asList(f1.getY()));
        s.get(1).setY(Arrays.asList(f2.getY()));

        drawChart.draw(s);
    }
}
