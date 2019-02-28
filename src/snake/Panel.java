package snake;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{

    private static final long serialVersionUID = 1L;

    public static final int width = 800;
    public static final int height = 800;

    public Panel(){
        setPreferredSize(new Dimension(width, height));

    }

    public void start(){

    }

    public void stop(){

    }
    public void tick(){

    }
    public void paint(Graphics g){
        for(int i = 0; i < width/10; i++){
            g.drawLine(i*10, 0, i*10, height);
        }
        
        for(int i = 0; i < height/10; i++){
            g.drawLine(i*10, 0, i*10, height);
        }
    }

    @Override
    public void run() {

    }
}
