package drawChart.Form;

import drawChart.Form.ChartType.Bubble;
import drawChart.Form.ChartType.Line;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by dmytro on 25.03.16.
 */





class Chart extends JFrame{


    private JPanel mainPanel;

    public Chart(Line ...line){
        super("Graph");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
        add(new ChartPanel(line));
        pack();
        setVisible(true);
    }


    public Chart(Bubble...bubble){
        super("Graph");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
        add(new ChartPanel(bubble));
        pack();
        setVisible(true);
    }

    public Chart(String function, double a, double b){
        super("Graph");
        setSize(500, 500);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
        add(new ChartPanel(function, a, b));
        pack();
        setVisible(true);
    }
}

