import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.awt.Font;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    private static final int TILE_SIZE = 20;
    private static final int DELAY = 100;
    private Food food;
    private GameState gameState;
    private int score;


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
        gameState = GameState.RUNNING;
        score = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameState == GameState.RUNNING) {
            snake.move();

            SnakeSegment head = snake.getBody().getFirst();

            // Check wall collision
            if (head.x < 0 || head.y < 0 || head.x >= WIDTH / TILE_SIZE || head.y >= HEIGHT / TILE_SIZE) {
                gameState = GameState.GAME_OVER;
                timer.stop();
            }

            // Check self collision
            for (int i = 1; i < snake.getBody().size(); i++) {
                SnakeSegment segment = snake.getBody().get(i);
                if (head.x == segment.x && head.y == segment.y) {
                    gameState = GameState.GAME_OVER;
                    timer.stop();
                    break;
                }
            }

            // Food eaten
            if (head.x == food.getX() && head.y == food.getY()) {
                food.respawn();
            } else {
                snake.trimTail();
            }

            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSnake(g);
        food.draw(g);

        if (gameState == GameState.PAUSED) {
            drawText(g, "PAUSED", Color.YELLOW);
        } else if (gameState == GameState.GAME_OVER) {
            drawText(g, "GAME OVER - Press R to Restart", Color.RED);
        }
    }

    private void drawText(Graphics g, String text, Color color) {
        g.setColor(color);
        g.setFont(new Font("Arial", Font.BOLD, 32));
        FontMetrics fm = g.getFontMetrics();
        int x = (WIDTH - fm.stringWidth(text)) / 2;
        int y = HEIGHT / 2;
        g.drawString(text, x, y);
    }



    private void drawSnake(Graphics g) {
        g.setColor(Color.GREEN);
        for (SnakeSegment segment : snake.getBody()) {
            g.fillRect(segment.x * TILE_SIZE, segment.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameState == GameState.RUNNING) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> snake.setDirection(Direction.UP);
                case KeyEvent.VK_DOWN -> snake.setDirection(Direction.DOWN);
                case KeyEvent.VK_LEFT -> snake.setDirection(Direction.LEFT);
                case KeyEvent.VK_RIGHT -> snake.setDirection(Direction.RIGHT);
                case KeyEvent.VK_P -> pauseGame();
            }
        } else if (gameState == GameState.PAUSED && e.getKeyCode() == KeyEvent.VK_P) {
            resumeGame();
        }

        if (gameState == GameState.GAME_OVER && e.getKeyCode() == KeyEvent.VK_R) {
            restartGame();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    private void pauseGame() {
        gameState = GameState.PAUSED;
        timer.stop();
    }

    private void resumeGame() {
        gameState = GameState.RUNNING;
        timer.start();
    }

    private void restartGame() {
        snake = new Snake(WIDTH / TILE_SIZE / 2, HEIGHT / TILE_SIZE / 2);
        food = new Food(TILE_SIZE, WIDTH, HEIGHT);
        gameState = GameState.RUNNING;
        timer.start();
    }

    private void drawScore(Graphics g) {
        String scoreText = "Score: " + score;

        g.setFont(new Font("Arial", Font.BOLD, 20));

        // Background rectangle for readability
        int padding = 10;
        int textWidth = g.getFontMetrics().stringWidth(scoreText);
        int textHeight = g.getFontMetrics().getHeight();

        g.setColor(Color.BLACK); // background box
        g.fillRect(10 - padding / 2, 10 - padding / 2, textWidth + padding, textHeight + padding);

        g.setColor(Color.GREEN); // text color
        g.drawString(scoreText, 10, 10 + textHeight - 5);
    }

}
