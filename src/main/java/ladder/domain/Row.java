package ladder.domain;

import static ladder.exceptoin.ExceptionMessage.*;

public class Row {
    private Node[] nodes;
    private final int MININUM_GAMER_NUMBER = 1;

    public Row(NaturalNumber numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        nodes = new Node[numberOfPerson.getNumber()];
        for(int i = 0; i < numberOfPerson.getNumber(); i++){
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        nodes[lineStartPosition.getPosition()] = Node.of(Direction.RIGHT);
        nodes[lineStartPosition.getPosition() + 1] = Node.of(Direction.LEFT);
    }

    private void validateNumberOfPerson(NaturalNumber numberOfPerson) {
        if(numberOfPerson.getNumber() < MININUM_GAMER_NUMBER) {
            throw new IllegalArgumentException(GAMER_NUMBER_REQUIREMENT.getMessage());
        }
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(lineStartPosition.isSmallerThan(0) || lineStartPosition.isBiggerThan(nodes.length - 2) || isLeft(lineStartPosition) || isRight(lineStartPosition)) {
            throw new IllegalArgumentException(FAILED_TO_DRAW_LINE.getMessage());
        }
    }

    private boolean isRight(Position lineStartPosition) {
        return nodes[lineStartPosition.getPosition() + 1].getDirection() == Direction.RIGHT;
    }

    private boolean isLeft(Position lineStartPosition) {
        return nodes[lineStartPosition.getPosition()].getDirection() == Direction.LEFT;
    }

    public Position nextPosition(Position position) {
        if(position.isBiggerThan(nodes.length - 1))
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        return nodes[position.getPosition()].move(position);
    }

    public int getPersonNumber(){
        return nodes.length;
    }

    public Direction getDirection(int col){
        return nodes[col].getDirection();
    }

    public void appendRowString(StringBuilder sb) {
        for(int i = 0; i < nodes.length; i++){
            nodes[i].printNode(sb, i);
        }
        sb.append("\n");
    }

    public void appendStarRowString(StringBuilder sb, LadderPosition starPosition) {
        for(int i = 0; i < nodes.length; i++){
            nodes[i].printNode(sb, i);
            if(starPosition.xIsSameAs(i)){
                sb.append("*");
            }
        }
        sb.append("\n");
    }
}
