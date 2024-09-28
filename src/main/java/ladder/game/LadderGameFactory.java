package ladder.game;

import ladder.domain.LadderPosition;
import ladder.domain.NaturalNumber;

import java.util.List;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(NaturalNumber numberOfRow, NaturalNumber numberOfPerson){
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(new BasicLadderCreator(numberOfRow, numberOfPerson));
        randomLadderCreator.createRandomLadder();  // 사다리 랜덤하게 그리기
        return new LadderGame(randomLadderCreator);
    }

    public static LadderGame createBasicLadderGame(NaturalNumber numberOfRow, NaturalNumber numberOfPerson, List<LadderPosition> positionList){
        BasicLadderCreator ladderCreator = new BasicLadderCreator(numberOfRow, numberOfPerson);
        for(LadderPosition position : positionList){
            ladderCreator.drawLine(position.getY(), position.getX()); // 리스트에 담긴 위치에 그리기
        }
        return new LadderGame(ladderCreator);
    }
}
