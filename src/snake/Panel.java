package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Panel extends JPanel implements Runnable, KeyListener {

    private static final long serialVersionUID = 1L;

    public static final int width = 800;
    public static final int height = 800;
    private Thread thread;
    private boolean running;
    private boolean right = true, left = false, up = false, down = false;

    private Body body;
    private ArrayList<Body> snake;

    private Apple apple;
    private ArrayList<Apple> apples;

    private Random r;

    private int xCoor = 10, yCoor = 10, size = 15;
    private int ticks = 0;

    public Panel() {
        setFocusable(true);

        setPreferredSize(new Dimension(width, height));
        addKeyListener(this);

        snake = new ArrayList<Body>();
        apples = new ArrayList<Apple>();

        r = new Random();

        start();
    }

    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        if (snake.size() == 0) {
            body = new Body(xCoor, yCoor, 10);
            snake.add(body);
        }
        ticks++;
        if (ticks > 250000) {
            if (right) xCoor++;
            if (left) xCoor--;
            if (up) yCoor--;
            if (down) yCoor++;

            ticks = 0;
            body = new Body(xCoor, yCoor, 10);
            snake.add(body);

            if (snake.size() > size) {
                snake.remove(0);
            }
        }

        if(apples.size() == 0){
            int xCoor = r.nextInt(79);
            int yCoor = r.nextInt(79);

            apple = new Apple(xCoor, yCoor, 10);
            apples.add(apple);
        }

        for (int i = 0; i < apples.size(); i++) {
            if(xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()) {
                size++;
                apples.remove(i);
                i++;
            }
        }
//body collision
        for (int i = 0; i < snake.size(); i++) {
            if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()){
                if(i != snake.size()-1) {
                    System.out.println("Game Over!");
                    stop();
                }
            }
        }
//koniec gry bo kolizja z granica // border collision
        if(xCoor < 0 || xCoor > 79 || yCoor < 0 || yCoor > 79){
            System.out.println("Game Over!");
            stop();
        }

    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        for (int i = 0; i < width / 10; i++) {
            g.drawLine(i * 10, 0, i * 10, height);
        }

        for (int i = 0; i < height / 10; i++) {
            g.drawLine(0, i * 10, height, i * 10);
        }
        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).draw(g);
        }
        for (int i = 0; i < apples.size(); i++) {
            apples.get(i).draw(g);
        }

    }

    @Override
    public void run() {
        while (running) {
            tick();
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT && !left) {
            right = true;
            up = false;
            down = false;
        }

        if (key == KeyEvent.VK_LEFT && !right) {
            left = true;
            up = false;
            down = false;
        }

        if (key == KeyEvent.VK_UP && !down) {
            up = true;
            left = false;
            right = false;
        }

        if (key == KeyEvent.VK_DOWN && !up) {
            down = true;
            left = false;
            right = false;
        }
    }

        @Override
        public void keyReleased (KeyEvent e){

        }
    }
