package Form;

import Chart.Panel.ChartPanel;
import Chart.Series.Series;

import javax.swing.*;
import java.util.List;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by Tom on 10.07.2017.
 */
public class DataPresent extends JFrame {

    private JPanel Main;

    public DataPresent(List<Series> s){

        super("Data");

        setSize(500, 500);
        setContentPane(new ChartPanel(s));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setVisible(true);


    }
}
