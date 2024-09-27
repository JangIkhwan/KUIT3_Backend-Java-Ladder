package ladder.game;

import ladder.domain.Row;
import ladder.domain.NaturalNumber;
import ladder.domain.Position;

public class BasicLadderCreator implements LadderCreator {
    private Row[] rows;
    private int numberOfRow;
    private int numberOfPerson;

    public BasicLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson){
        rows = new Row[numberOfRow.getNumber() + 1];
        for(int i = 0; i < rows.length; i++){
            rows[i] = new Row(numberOfPerson);
        }
        this.numberOfRow = numberOfRow.getNumber();
        this.numberOfPerson = numberOfPerson.getNumber();
    }

    public void drawLine(Position row, Position col){
        rows[row.getPosition()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }
}
