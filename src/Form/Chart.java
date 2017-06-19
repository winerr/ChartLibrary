package Form;


import Chart.Panel.ChartPanel;
import Chart.Series.Series;
import Chart.Series.Type;
import Function.secondFunction;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Chart.Series.Type.BUBBLE;
import static Chart.Series.Type.LINE;

/**
 * Created by dmytro on 25.03.16.
 */





public class Chart extends JFrame{


    private JPanel Main;
    private JButton ADD;
    private ChartPanel chart;
    //List<Series> s;

    public Chart(List<Series> s){

        super("Graph");

        //this.s = s;
        setSize(500, 500);
        setContentPane(Main);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ADD.addActionListener(e -> {
            test();
//            System.out.println("pressed");
        });



        pack();
        setVisible(true);


    }

    private void test(){
        secondFunction f1 = new secondFunction(-2, 3, 25);
        f1.Tabulation();
        Series s = new Series(BUBBLE);


        s.setX(Arrays.asList(f1.getX()));

        s.setY(Arrays.asList(f1.getY()));

        chart.addSeries(s);

        System.out.println(s.toString());
        //chart.updateUI();
    }

    private void createUIComponents() {
        chart = new ChartPanel();
        // TODO: place custom component creation code here
    }
}

