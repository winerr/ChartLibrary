package drawChart.Form;

import javax.swing.*;

/**
 * Created by Dmytro Vertepniy on 11.09.2016.
 */
public class drawChart {
    /**
     * ������� ��� ���������� �������� � ����������� ��������� X
     * @param x ������� ������� �� X
     * @param y ������������� ����� �������� �������� �� Y
     */
    public static void draw(double []x, double[]...y){
        SwingUtilities.invokeLater(() -> new Chart(x, y));
    }

    /**
     * ���������� ������ �� ������� �������
     * @param function ��������� �������� ������� ������ �������
     * @param a ����� �������
     * @param b ������ �������
     */
    public static void draw(String function, double a, double b) {
        SwingUtilities.invokeLater(()->new Chart(function, a, b));
    }

    /**
     * ������� ��� ���������� �������� � ������� ��������� X
     * @param x ����� ������� ������� �� X
     * @param y ����� ������� ������� �� Y
     */
    public static void draw(double [][]x, double [][]y) {
        SwingUtilities.invokeLater(()->new Chart(x, y));
    }

    /**
     * 
     */
    public static void inputFunction(){
        SwingUtilities.invokeLater(()->new inputFunction());
    }



}
