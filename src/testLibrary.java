import Function.firstFunction;
import Function.secondFunction;
import drawChart.Form.drawChart;


public class testLibrary {

    public static void main(String args[]){
        firstFunction f1 = new firstFunction(-5, 5, 50);
        secondFunction f2 = new secondFunction(-2, 2, 50);
        f1.Tabulation();f2.Tabulation();
        drawChart.draw(f1.getLine(), f2.getLine());
    }
}