
package com.company;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaGUIForm extends JFrame implements ActionListener{

    private JMenuBar MainMenu = new JMenuBar();
    private JMenu File, Edit, Help, General = new JMenu();
    private JMenuItem Save, Exit, Software, Hardware, AboutApp = new JMenuItem();
    private JPanel top, right = new JPanel();
    private JPanel center = new JPanel( new GridLayout(4,3));

    public JavaGUIForm (){
        super("My New GUI");

//    initializing menu items and menus
        File = new JMenu("File");
        Edit = new JMenu("Edit");
        Help = new JMenu("Help");
        General = new JMenu("General");
        Save = new JMenuItem("Save");
        Exit = new JMenuItem("Exit");
        AboutApp = new JMenuItem("About App");
        Software = new JMenuItem("Software");
        Hardware = new JMenuItem("Hardware");
        //    creating jpanels


        //    event handlers
        Save.addActionListener(this);
        Exit.addActionListener(this);

        setVisible(true);
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(MainMenu);
        MainMenu.add(Help);
        MainMenu.add(File);
        MainMenu.add(Edit);
        File.add(Save);
        File.add(Exit);
        Help.add(General);
        General.add(Software);
        General.add(Hardware);
        // JPanel ops
        top.add(new JTextField(25));

        for(int i= 0; i <=9; i++){
            center.add(new JButton("" + i));
        }
        center.add(new JButton("+"));
        center.add(new JButton("="));
        right.add(new JButton("Product(*)"));
        right.add(new JButton("Divide(/)"));

        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(right, BorderLayout.EAST);
    }

//AboutApp.addActionListener(
//        new ActionListener( ){public void actionPerformed(ActionEvent e){
//        System.out.println("No info on the for now");
//    });

    public void actionPerformed(ActionEvent evt){
        if(evt.getSource().equals(Save)){
            JOptionPane.showMessageDialog(this, "Your work has been saved");
        }else if(evt.getActionCommand().equals("Exit")){
            int x = JOptionPane.showConfirmDialog(this, "Are you sure you would like to Exit?");
            if(x==0)
                System.exit(0);
        }
    }



    public static void main(String[] Args){
        new JavaGUIForm();
    }

}

