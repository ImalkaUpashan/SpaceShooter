import javax.swing.*;

public class Main{
    public static void main(String[] args){
        JFrame window = new JFrame("Spaceshooter");

        GamePanel game= new GamePanel();
        window.add(game);

        window.setSize(1280,720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}