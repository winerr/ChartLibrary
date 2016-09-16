import drawChart.Form.drawChart;

public class testLibrary {

    private static double f(double x){
        return x+2;
    }
    private static double f_2(double x){
        return x*x;
    }
    private static double f_3(double x){
        return 3*x + 2;
    }

    private static void tab(double a, double b){
        int n = 10;
        double h = (b-a)/n;

        x = new double[n];
        y = new double[n];

        x[0] = a;
        y[0] = f(x[0]);


        for (int i=1; i<x.length; i++){
            x[i] = x[i-1] + h;
            y[i] = f(x[i]);
        }

    }

    private static void tab_2(double a, double b){
        int n = 10;
        double h = (b-a)/n;
        x_2 = new double[n];
        y_2 = new double[n];

        x_2[0] = a;
        y_2[0] = f_2(x_2[0]);


        for (int i=1; i<x.length; i++){
            x_2[i] = x_2[i-1] + h;
            y_2[i] = f_2(x_2[i]);
        }

    }
    private static void tab_3(double a, double b){
        int n = 10;
        double h = (b-a)/n;

        x_3 = new double[n];
        y_3 = new double[n];

        x_3[0] = a;
        y_3[0] = f_3(x_3[0]);


        for (int i=1; i<x.length; i++){
            x_3[i] = x_3[i-1] + h;
            y_3[i] = f_3(x_3[i]);
        }

    }

    static double []x;
    static double []x_2;
    static double []x_3;
    static double []y;
    static double []y_2;
    static double []y_3;

    private static void test(double[]...test_y){
        for (int i = 0; i < test_y.length; i++) {
            for (int j = 0; j < test_y[i].length; j++) {
                System.out.println(x[i] + "  " +test_y[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String args[]){

        tab(-5, 5);
        tab_2(-10, 5);
        tab_3(-5, 10);

        double [][]test_x = new double [3][];
        test_x[0] = x;
        test_x[1] = x_2;
        test_x[2] = x_3;

        double [][]test_y = new double [3][];
        test_y[0] = y;
        test_y[1] = y_2;
        test_y[2] = y_3;

        //drawChart.draw(test_x, test_y);
        //drawChart.draw("x", -1,1);
        drawChart.inputFunction();
    }
}