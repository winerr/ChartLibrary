package Chart;

import Chart.Series.Series;
import Form.DataPresent;

import javax.swing.*;
import java.util.List;

/**
 * Created by Tom on 10.07.2017.
 */
public class PresentData {
    public static void present(List<Series> s){ SwingUtilities.invokeLater( () -> new DataPresent(s));}
}
