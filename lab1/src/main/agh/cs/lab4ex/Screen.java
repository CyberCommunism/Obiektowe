package agh.cs.lab4ex;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class Screen extends JPanel implements Runnable{
    public static final int WIDTH = 400, HEIGHT = 400;

    public static int x=5, y=10;

    private Thread thread;
    private boolean running = false;

    int tick = 0;

    private BodyPart b;
    private ArrayList<BodyPart> snake;

    JButton btn = new JButton("test");


    private int xCoor=0,yCoor=0;

    public Screen(int x,int y){
        this.x=x;
        this.y=y;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));

        //list array of my animals on map

        snake = new ArrayList<BodyPart>();

        start();
    }

    int pion = WIDTH/x;
    int poziom = HEIGHT/y;

    public void tick(){
        if(snake.size()==0){
            b = new BodyPart(xCoor,yCoor,pion,poziom);
            BodyPart c = new BodyPart(3*pion,4*poziom,pion,poziom);
            snake.add(b);
            snake.add(c);
        }
    }
    public void paint(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.BLACK);

        for(int i=0;i<WIDTH;i++){
            g.drawLine(i*pion,0,i*pion,HEIGHT);
        }
        for(int i=0;i< HEIGHT;i++){
            g.drawLine(0,i*poziom,WIDTH,i*poziom);
        }

        for(int i=0;i< snake.size();i++){
            try {
                snake.get(i).draw(g);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void start(){
        running = true;
        thread = new Thread(this, "game loop");
        thread.start();
    }
    public void stop(){

    }
    public void run(){
        while(running){
            tick();
            repaint();
        }
    }
}
