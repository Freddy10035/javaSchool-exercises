package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        final String[] firstNumber = new String[1];
        final String[] secondNumber = new String[1];
        final int[] num1 = new int[1];
        final int[] num2 = new int[1];
        final int[] Sum = new int[1];
        Frame frm = new Frame("MATHS EXERCISE");
        Label lbl = new Label();
        frm.add(lbl);
        frm.setVisible(true);

        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Panel p = new Panel();
        Panel p1 = new Panel();

        Button NumbersSum = new Button("Numbers Sum");
        p.add(NumbersSum);
        p1.add(p);
        frm.add(p1, BorderLayout.CENTER);

        NumbersSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber[0] = JOptionPane.showInputDialog("Enter The First Number");
                secondNumber[0] = JOptionPane.showInputDialog("Enter The Second Number");

                num1[0] = Integer.parseInt(firstNumber[0]);
                num2[0] = Integer.parseInt(secondNumber[0]);
                Sum[0] = num1[0] + num2[0];

                JOptionPane.showMessageDialog(null, "The Sum Of The Two Numbers is " + Sum[0]);
                System.exit(0);
            }
        });

        frm.setSize(400, 200);
    }
}