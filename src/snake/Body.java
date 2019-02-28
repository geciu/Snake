package snake;

import java.awt.*;

public class Body {

    private int xCoor, yCoor, width, height;

    public Body(int xCoor, int yCoor, int titleSize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = titleSize;
        height = titleSize;
    }

    public void tick(){}
    public void draw (Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect(xCoor*width, yCoor*height, width, height);
    }

    public int getxCoor(){
        return xCoor;
    }
    public int setxCoor(){
        this.xCoor = xCoor;
    }
    public int getyCoor(){
        return yCoor;
    }
    public int setyCoor(){
       this.yCoor = yCoor;
    }
}
