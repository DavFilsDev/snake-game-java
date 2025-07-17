import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    private static final int TILE_SIZE = 20;
    private static final int DELAY = 100;
    private Food food;

    private Timer timer;
    private Snake snake;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        snake = new Snake(WIDTH / TILE_SIZE / 2, HEIGHT / TILE_SIZE / 2);
        food = new Food(TILE_SIZE, WIDTH, HEIGHT);
        timer = new Timer(DELAY, this);
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();

        // Check if snake eats the food
        SnakeSegment head = snake.getBody().getFirst();
        if (head.x == food.getX() && head.y == food.getY()) {
            food.respawn();
        } else {
            snake.trimTail(); // Snake only grows when eating
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSnake(g);
        food.draw(g);
    }


    private void drawSnake(Graphics g) {
        g.setColor(Color.GREEN);
        for (SnakeSegment segment : snake.getBody()) {
            g.fillRect(segment.x * TILE_SIZE, segment.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> snake.setDirection(Direction.UP);
            case KeyEvent.VK_DOWN -> snake.setDirection(Direction.DOWN);
            case KeyEvent.VK_LEFT -> snake.setDirection(Direction.LEFT);
            case KeyEvent.VK_RIGHT -> snake.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
