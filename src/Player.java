import java.awt.*;

public class Player {
    private int x, y, width = 50, height = 50;
    private int speed = 5;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {
        if (x > 0) x -= speed;
    }

    public void moveRight() {
        if (x < 350) x += speed;
    }

    public void update() {}

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
