import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private Player player;
    private ArrayList<Block> blocks;
    private Random random = new Random();
    private boolean gameOver = false;
    private int score = 0;
    private KeyHandler keyHandler;

    public GamePanel() {
        setFocusable(true);
        setBackground(Color.BLACK);
        player = new Player(175, 400);
        blocks = new ArrayList<>();
        keyHandler = new KeyHandler(player, this);
        addKeyListener(keyHandler);
    }

    public void startGame() {
        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);

        for (Block block : blocks) {
            block.draw(g);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 20);

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", 130, 250);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press ESC to exit", 120, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            player.update();
            keyHandler.update();

            if (random.nextInt(100) < 5) {
                blocks.add(new Block(random.nextInt(350), 0));
            }

            for (Block block : blocks) {
                block.update();
                if (player.getBounds().intersects(block.getBounds())) {
                    gameOver = true;
                    timer.stop();
                }
            }

            // Ha még élünk, növeljük a pontszámot
            if (!gameOver) {
                score++;
            }

            repaint();
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
