import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("🐍 Snake Game - Java OOP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(new GamePanel());
        pack(); // Sizes the window to fit the preferred size of its components
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }
}
