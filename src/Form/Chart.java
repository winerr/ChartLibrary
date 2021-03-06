package Form;

import Chart.PresentData;
import Chart.Panel.ChartPanel;
import Chart.Series.Series;
import Chart.Series.Type;
import Function.firstFunction;
import Function.secondFunction;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Chart.Series.Type.BUBBLE;
import static Chart.Series.Type.LINE;
import static java.util.Arrays.asList;

/**
 * Created by dmytro on 25.03.16.
 */

public class Chart extends JFrame{


    private JPanel Main;
    private JButton ADD;
    private ChartPanel chart;
    private JButton AddDots;

    public Chart(){

        super("Graph");

        setSize(500, 500);
        setContentPane(Main);
        createUIComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ADD.addActionListener( e -> {
            //System.out.println(Main.getComponents()[1]);
            chart = (ChartPanel)Main.getComponents()[1];
            test(chart);
        });

        AddDots.addActionListener( e -> {
            chart = (ChartPanel)Main.getComponents()[1];
            drawDots();
        });

        pack();
        setVisible(true);


    }

    private void test(ChartPanel chart){
        secondFunction f1 = new secondFunction(-2, 3, 25);
        f1.Tabulation();
        Series s = new Series(BUBBLE);


        s.setX(asList(f1.getX()));

        s.setY(asList(f1.getY()));

        try {
            chart.addSeries(s);

        }catch (NullPointerException ex){
            System.out.println(ex);
        }
        //PresentData.present(asList(s));

    }

    private void drawDots(){
        firstFunction f1 = new firstFunction(-2, 3, 25);
        f1.Tabulation();
        Series s = new Series(BUBBLE);


        s.setX(asList(f1.getX()));

        s.setY(asList(f1.getY()));


        for(int i=0; i<s.getX().size(); i++){
            chart.addXY(0, s.getX().get(i), s.getY().get(i));
        }
    }

    private void createUIComponents() {
        chart = new ChartPanel();
    }
}

