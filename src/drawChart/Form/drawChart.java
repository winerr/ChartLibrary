package drawChart.Form;

import Chart.Series.Series;

import javax.swing.*;
import java.util.List;

/**
 * Created by Dmytro Vertepniy on 11.09.2016.
 */
public class drawChart {


    public static void draw(List<Series> s){
        SwingUtilities.invokeLater(() -> new Chart(s));
    }



}