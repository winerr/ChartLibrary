package drawChart.Form;

import javax.swing.*;

/**
 * Created by Dmytro Vertepniy on 11.09.2016.
 */
public class drawChart {
    /**
     * Функция для отбражения графиков с одинаковыми вакторами X
     * @param x векотор зачений по X
     * @param y неопределеный масив векторов значений по Y
     */
    public static void draw(double []x, double[]...y){
        SwingUtilities.invokeLater(() -> new Chart(x, y));
    }

    /**
     * Отображает крафик по заданой функцыи
     * @param function Строковой параметр который задает функцию
     * @param a левая граница
     * @param b правая граница
     */
    public static void draw(String function, double a, double b) {
        SwingUtilities.invokeLater(()->new Chart(function, a, b));
    }

    /**
     * Функция для отбражения графиков с разными вакторами X
     * @param x масив векотор зачений по X
     * @param y масив векотор зачений по Y
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
