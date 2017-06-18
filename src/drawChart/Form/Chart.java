package drawChart.Form;

import Chart.Series.Series;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.VolatileImage;
import java.util.List;
//import javax.swing.plaf.nimbus.NimbusLookAndFeel

/**
 * Created by dmytro on 25.03.16.
 */





public class Chart extends JFrame{


    private JPanel Main;
    private JButton ADD;
    private JPanel chart;
    List<Series> s;


    public Chart(List<Series> s){

        super("Graph");

        this.s = s;
        setSize(500, 500);
        setContentPane(Main);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ADD.addActionListener(e -> {
            test();
            System.out.println("pressed");
        });



        pack();
        setVisible(true);


    }

    private void test(){
        s.get(1).getX().add(4.0);
        s.get(1).getX().add(4.0*4.0*4.0);
    }

    private void createUIComponents() {
        chart = new ChartPanel(s);
        // TODO: place custom component creation code here
    }
}

