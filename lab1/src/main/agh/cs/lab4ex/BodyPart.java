package agh.cs.lab4ex;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import java.io.IOException;

public class BodyPart {
    public int xCoor,yCoor,width,height;
    public BodyPart(int xCoor, int yCoor, int xSize,int ySize){
        this.xCoor=xCoor;
        this.yCoor=yCoor;
        this.height=ySize;
        this.width=xSize;
    }
    public void tick(){

    }
    public void draw(Graphics g) throws IOException {
        g.setColor(Color.GREEN);
        g.fillRect(xCoor,yCoor,width,height);
        BufferedImage image = ImageIO.read(new File("C:\\Users\\rootKAM\\Documents\\projekty javy\\lab1\\src\\main\\agh\\cs\\imgs\\frog.png"));
        g.drawImage(image,xCoor,yCoor,Math.min(width,height),Math.min(width,height),null);
    }
}
