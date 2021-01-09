package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathsExercise extends JFrame {
    private JButton numbersSumButton;
    String firstNumber, secondNumber;
    int num1, num2, Sum;

    public MathsExercise() {
        setTitle("MATHS EXERCISE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 1));

        numbersSumButton =new JButton("Numbers Sum");
          add(numbersSumButton);

        pack();
        setVisible(true);

        setSize(400,300);

        numbersSumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = JOptionPane.showInputDialog("Enter The First Number");
                secondNumber = JOptionPane.showInputDialog("Enter The Second Number");

                num1 = Integer.parseInt(firstNumber);
                num2 = Integer.parseInt(secondNumber);
                Sum = num1 + num2;

                JOptionPane.showMessageDialog(null,"The Sum Of The Two Numbers is " +Sum);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {

        new MathsExercise();

    }

}
