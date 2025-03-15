import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Dodge the Blocks");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(400, 500);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.setVisible(true);

        gamePanel.startGame();
    }
}
