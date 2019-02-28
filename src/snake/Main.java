package snake;

import javax.swing.*;

public class Main {

    public Main(){
        JFrame frame = new JFrame();
        Panel panel = new Panel();


        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SNAKE");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args){

        new Main();
    }
}
