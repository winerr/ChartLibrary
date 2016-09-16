package drawChart.Form;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by dmytro on 25.03.16.
 */





class Chart extends JFrame{


    private JPanel mainPanel;

    public Chart(double []x, double[]...y){
        super("Graph");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
        add(new MyPanel(x, y));
        pack();
        setVisible(true);
    }
    public Chart(double [][]x, double [][]y){
        super("Graph");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
        add(new MyPanel(x, y));
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
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
        add(new MyPanel(function, a, b));
        pack();
        setVisible(true);
    }
}

