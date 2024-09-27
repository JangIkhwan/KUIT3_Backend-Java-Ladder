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

    public void printNode(StringBuilder sb, int i) {
        if(direction == Direction.NONE){
            sb.append(" 0");
        }
        else if(direction == Direction.LEFT){
            sb.append(" -1");
        }
        else if(direction == Direction.RIGHT){
            sb.append(" 1");
        }
    }
}
