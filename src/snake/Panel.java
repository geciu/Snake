package snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel implements Runnable{

    private static final long serialVersionUID = 1L;

    public static final int width = 800;
    public static final int height = 800;
    private Thread thread;
    private boolean running;
    private boolean right = true, left = false, up = false, down = false;
    private Body body;
    private ArrayList<Body> snake;

    private int xCoor = 10, yCoor = 10, size = 5;
    private int ticks = 0;

    public Panel(){
        setPreferredSize(new Dimension(width, height));
        snake = new ArrayList<Body>();
        start();
    }

    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void tick(){
        if(snake.size() == 0) {
            body = new Body(xCoor,yCoor,10);
            snake.add(body);
        }
        ticks++;
        if(ticks > 250000) {
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;

            ticks = 0;
            body = new Body(xCoor, yCoor, 10);
            snake.add(body);

            if (snake.size() > size){
                snake.remove(0);
            }
        }
    }

    public void paint(Graphics g){
        g.clearRect(0,0, width, height);
        g.setColor(Color.BLACK);
        g.fillRect(0,0, width, height);
        for(int i = 0; i < width/10; i++){
            g.drawLine(i*10, 0, i*10, height);
        }

        for(int i = 0; i < height/10; i++){
            g.drawLine(0, i*10, height, i*10);
        }
        for(int i =0; i<snake.size(); i++){
            snake.get(i).draw(g);
        }
    }

    @Override
    public void run() {
        while(running){
         tick();
         repaint();
        }
    }
}
