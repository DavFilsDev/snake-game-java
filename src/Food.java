import java.awt.*;
import java.util.Random;

public class Food {
    private int x;
    private int y;
    private final int tileSize;
    private final int maxCols;
    private final int maxRows;
    private final Random rand;

    public Food(int tileSize, int panelWidth, int panelHeight) {
        this.tileSize = tileSize;
        this.maxCols = panelWidth / tileSize;
        this.maxRows = panelHeight / tileSize;
        this.rand = new Random();
        respawn();
    }

    public void respawn() {
        x = rand.nextInt(maxCols);
        y = rand.nextInt(maxRows);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x * tileSize, y * tileSize, tileSize, tileSize);
    }
}
