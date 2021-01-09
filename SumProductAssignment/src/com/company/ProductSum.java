package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductSum extends JFrame
{
    private JLabel label1, label2, label3;
    private JTextField value1;
    private JTextField value2;
    private JTextField result;
    private JButton sum,product;
    private JPanel ppanel;
    private JPanel spanel;
    private JPanel tpanel;
    private JPanel panel2;
    private JPanel sumpanel;

    private String firstVal,secondVal;
    private int summation,one,two,fproduct;


    public ProductSum()
    {
        setTitle("Sum && Product");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("Value one: ");
        label2 = new JLabel("value two: ");
        label3 = new JLabel("Result:");

        value1 = new JTextField("", 10);
        value1.setEditable(true);

        value2 = new JTextField("", 10);
        value2.setEditable(true);

        result = new JTextField("", 10);
        result.setEditable(false);

        sum =new JButton("Sum");
        add(sum);

        product=new JButton("Product");
        add(product);

        ppanel = new JPanel();
        ppanel.add(label1);
        ppanel.add(value1);

        spanel = new JPanel();
        spanel.add(label2);
        spanel.add(value2);

        tpanel = new JPanel();
        tpanel.add(label3);
        tpanel.add(result);

        sumpanel = new JPanel();
        sumpanel.add(sum);

        panel2= new JPanel();
        panel2.add(product);

        setLayout(new GridLayout(5, 1));

        add(ppanel);
        add(spanel);
        add(tpanel);
        add(sumpanel);
        add(panel2);

        pack();
        setVisible(true);


        sum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstVal = value1.getText();
                secondVal = value2.getText();
                one= Integer.parseInt(firstVal);
                two=Integer.parseInt(secondVal);
                summation= one+two;
                String finalSum = String.valueOf(summation);
                result.setText(finalSum);
            }
        });

        product.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstVal=value1.getText();
                secondVal=value2.getText();
                one=Integer.parseInt(firstVal);
                two=Integer.parseInt(secondVal);
                fproduct=one*two;

                String finalProduct= String.valueOf(fproduct);
                result.setText(finalProduct);

            }
        });
        setSize(600,400);
    }


    public static void main(String[] args)
    {
        new ProductSum();
    }
}