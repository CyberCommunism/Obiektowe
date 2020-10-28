package agh.cs.lab4ex;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    public MyFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gra w zwierzaki");
        setResizable(false);
        init();
    }
    public void init(){
        setLayout(new GridLayout(1,1,0,0));
        Screen s = new Screen(5,10);
        add(s);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new MyFrame();
    }
}
