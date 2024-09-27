package ladder.domain;

public class Node {
    private Direction direction;

    private Node(Direction direction){
        this.direction = direction;
    }

    public static Node of(Direction direction){
        return new Node(direction);
    }

    public Position move(Position position){
        if(isRight()){
            return position.next();
        }
        if(isLeft()){
            return position.prev();
        }
        return position;
    }

    private boolean isLeft() {
        return direction == Direction.LEFT;
    }

    private boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public Direction getDirection() {
        return direction;
    }
}
