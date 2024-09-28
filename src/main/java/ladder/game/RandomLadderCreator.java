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

    public void createRandomLadder(){
        int numberOfRow = ladderCreator.getNumberOfRow();
        int numberOfPerson = ladderCreator.getNumberOfPerson();
        int lineNumber = getLineNumber(numberOfRow);
        Random random = new Random();
//        HashSet<Integer>[] set = getHashSets(numberOfRow); //
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < lineNumber; i++){
            int row = random.nextInt(numberOfRow);
            int col = random.nextInt(numberOfPerson);
            String number = "(" + row + "," + col + ")";
//            if(set[row].contains(col)){ // 객체의 주소가 같은지 비교
            if(set.contains(number)){
                i--;
                continue;
            }
            try{
                drawLine(Position.of(row), Position.of(col));
//                set[row].add(col);
                set.add(number);
            }
            catch(IllegalArgumentException e){
                i--;
            }
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        ladderCreator.drawLine(row, col);
    }

    private static HashSet<Integer>[] getHashSets(int numberOfRow) {
        HashSet<Integer> set[] = new HashSet[numberOfRow];
        for(int i = 0; i < numberOfRow; i++){
            set[i] = new HashSet<>();
        }
        return set;
    }

    private static int getLineNumber(int numberOfRow) {
        return (int) (numberOfRow * numberOfRow * 0.3);
    }

    @Override
    public Row[] getRows() {
        return ladderCreator.getRows();
    }
}
