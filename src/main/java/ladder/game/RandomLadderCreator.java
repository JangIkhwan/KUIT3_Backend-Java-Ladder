package ladder.game;

import ladder.domain.Row;
import ladder.domain.Position;

import java.util.HashSet;
import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    private BasicLadderCreator ladderCreator;

    public RandomLadderCreator(BasicLadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    @Override
    public void drawLine(Position r, Position c) {
        int numberOfRow = ladderCreator.getNumberOfRow();
        int numberOfPerson = ladderCreator.getNumberOfPerson();
        int lineNumber = (int)(numberOfRow * numberOfRow * 0.3);
        Random random = new Random();
        HashSet<Integer> set[] = new HashSet[numberOfRow];
        for(int i = 0; i < numberOfRow; i++){
            set[i] = new HashSet<>();
        }
        for(int i = 0; i < lineNumber; i++){
            int row = random.nextInt(numberOfRow);
            int col = random.nextInt(numberOfPerson);
            if(set[row].contains(col)){
                i--;
                continue;
            }
            try{
                ladderCreator.drawLine(Position.of(row), Position.of(col));
                set[row].add(col);
            }
            catch(IllegalArgumentException e){
                i--;
            }
        }
    }

    @Override
    public Row[] getRows() {
        return ladderCreator.getRows();
    }
}
