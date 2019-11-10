package Assignment8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponent(panel);
        frame.setVisible(true);
    }

    public static void placeComponent(JPanel panel){
        panel.setLayout(null);
        JLabel firstNumber = new JLabel("FIRST NUMBER");
        firstNumber.setBounds(40, 40, 150, 25);
        panel.add(firstNumber);
        JTextField firstNumberText = new JTextField();
        firstNumberText.setBounds(170, 40, 165, 25);
        panel.add(firstNumberText);
        JLabel operation = new JLabel("OPERATION");
        operation.setBounds(40, 100, 100, 25);
        panel.add(operation);
        JComboBox operationChoice = new JComboBox();
        operationChoice.setBounds(170, 100, 165, 25);
        operationChoice.addItem("PLEASE CHOOSE");
        operationChoice.addItem("+");
        operationChoice.addItem("-");
        operationChoice.addItem("*");
        operationChoice.addItem("/");
        panel.add(operationChoice);
        JLabel secondNumber = new JLabel("SECOND NUMBER");
        secondNumber.setBounds(40, 160, 165, 25);
        panel.add(secondNumber);
        JTextField secondNumberText = new JTextField();
        secondNumberText.setBounds(170, 160, 165, 25);
        panel.add(secondNumberText);
        JButton calculate = new JButton("CALCULATE");
        calculate.setBounds(140, 240, 100, 25);
        panel.add(calculate);
        JLabel result = new JLabel("RESULT");
        result.setBounds(40, 300, 100, 25);
        panel.add(result);
        JTextField resultText = new JTextField();
        resultText.setBounds(170, 300, 165, 25);
        panel.add(resultText);
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double firstNumber = Double.valueOf(firstNumberText.getText());
                double secondNumber = Double.valueOf(secondNumberText.getText());
                if(operationChoice.getSelectedItem().equals("+")){
                    resultText.setText(String.valueOf(firstNumber + secondNumber));
                } else if(operationChoice.getSelectedItem().equals("-")){
                    resultText.setText(String.valueOf(firstNumber - secondNumber));
                } else if(operationChoice.getSelectedItem().equals("*")){
                    resultText.setText(String.valueOf(firstNumber * secondNumber));
                } else if(operationChoice.getSelectedItem().equals("/")) {
                    resultText.setText(String.valueOf(firstNumber / secondNumber));
                }
            }
        });
    }

}
