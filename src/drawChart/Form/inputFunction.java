package drawChart.Form;

import javax.swing.*;

/**
 * Created by dmytro on 26.03.16.
 */
public class inputFunction extends JFrame {
    private JPanel mainPanel;
    private JLabel label1;
    private JTextField textField1;
    private JButton drawGraphButton;
    private JTextField textField2;
    private JTextField textField3;


    public inputFunction(){
        super("inputFunction");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawGraphButton.addActionListener(e -> draw(textField1.getText(), Double.parseDouble(textField2.getText()), Double.parseDouble(textField3.getText())));
        pack();
        setVisible(true);
    }

    private void draw(String function, double a, double b){
        //System.out.print(function);
        SwingUtilities.invokeLater( () -> new Chart(function, a, b));
    }

}
