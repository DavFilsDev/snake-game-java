import java.util.LinkedList;

public class Snake {
    private LinkedList<SnakeSegment> body;
    private Direction direction;

    public Snake(int startX, int startY) {
        body = new LinkedList<>();
        body.add(new SnakeSegment(startX, startY));
        direction = Direction.RIGHT;
    }

    public void move() {
        SnakeSegment head = body.getFirst();
        int x = head.x;
        int y = head.y;

        switch (direction) {
            case UP -> y -= 1;
            case DOWN -> y += 1;
            case LEFT -> x -= 1;
            case RIGHT -> x += 1;
        }

        body.addFirst(new SnakeSegment(x, y)); // Add new head
        body.removeLast(); // Remove tail
    }

    public void setDirection(Direction newDirection) {
        // Prevent reverse direction
        if ((this.direction == Direction.UP && newDirection != Direction.DOWN) ||
                (this.direction == Direction.DOWN && newDirection != Direction.UP) ||
                (this.direction == Direction.LEFT && newDirection != Direction.RIGHT) ||
                (this.direction == Direction.RIGHT && newDirection != Direction.LEFT)) {
            this.direction = newDirection;
        }
    }

    public LinkedList<SnakeSegment> getBody() {
        return body;
    }

    public Direction getDirection() {
        return direction;
    }
}
