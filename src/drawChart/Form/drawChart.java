package drawChart.Form;

import drawChart.Form.ChartType.Bubble;
import drawChart.Form.ChartType.Line;

import javax.swing.*;

/**
 * Created by Dmytro Vertepniy on 11.09.2016.
 */
public class drawChart {

    public static void draw(String function, double a, double b) {
        SwingUtilities.invokeLater(()->new Chart(function, a, b));
    }

    public static void inputFunction(){
        SwingUtilities.invokeLater(()->new inputFunction());
    }

    public static void draw(Line ... line){
        SwingUtilities.invokeLater(() -> new Chart(line));
    }

    public static void draw(Bubble ... bubble){
        SwingUtilities.invokeLater(() -> new Chart(bubble));
    }

}