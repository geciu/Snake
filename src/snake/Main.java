package snake;

import javax.swing.*;

public class Main {

    public Main(){
        JFrame frame = new JFrame();
        Panel panel = new Panel();


        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SNAKE");
        frame.setLocationRelativeTo(null);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){

        new Main();
    }
}
