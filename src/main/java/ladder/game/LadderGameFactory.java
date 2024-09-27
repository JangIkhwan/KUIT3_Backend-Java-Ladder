package ladder.game;

import ladder.domain.NaturalNumber;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(NaturalNumber numberOfRow, NaturalNumber numberOfPerson){
        BasicLadderCreator ladderCreator = new BasicLadderCreator(numberOfRow, numberOfPerson);
        return new LadderGame(new RandomLadderCreator(ladderCreator));
    }

    public static LadderGame createBasicLadderGame(NaturalNumber numberOfRow, NaturalNumber numberOfPerson){
        BasicLadderCreator ladderCreator = new BasicLadderCreator(numberOfRow, numberOfPerson);
        return new LadderGame(ladderCreator);
    }
}
