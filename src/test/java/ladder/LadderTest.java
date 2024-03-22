package ladder;

import ladder.domain.NaturalNumber;
import ladder.domain.Position;
import ladder.game.LadderCreator;
import ladder.game.LadderGame;
import ladder.game.LadderRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    void 사다리_생성_확인() {
        //given
        //int numberOfRows = 3;
        //int numberOfPerson = 5;

        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPerson);
        //Ladder ladder  = new Ladder(NaturalNumber.of(numberOfRows), NaturalNumber.of(numberOfPerson));

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        NaturalNumber numberOfRows = NaturalNumber.of(1);

        //Ladder ladder = new Ladder(NaturalNumber.of(numberOfRows), NaturalNumber.of(numberOfPerson));
        LadderCreator ladderCreator = new LadderCreator(numberOfRows, numberOfPerson);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator);
        //when
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderRunner.run(Position.of(position)));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        int numberOfPerson = 4;
        int numberOfRows = 4;

        Ladder ladder = new Ladder(NaturalNumber.of(numberOfRows), NaturalNumber.of(numberOfPerson));
//        ladder.drawLine(Position.of(1),Position.of(0));
//        ladder.drawLine(Position.of(1),Position.of(2));
//        ladder.drawLine(Position.of(2),Position.of(1));

        ladder.drawLine(1,0);
        ladder.drawLine(1,2);
        ladder.drawLine(2,1);

        //when
        int position = 0;
        int resultPosition = ladder.run(Position.of(position, numberOfPerson));
        //then
        assertEquals(2, resultPosition);

        //when
        position = 1;
        resultPosition = ladder.run(Position.of(position, numberOfPerson));
        //then
        assertEquals(0, resultPosition);

        //when
        position = 2;
        resultPosition = ladder.run(Position.of(position, numberOfPerson));
        //then
        assertEquals(3, resultPosition);

        //when
        position = 3;
        resultPosition = ladder.run(Position.of(position, numberOfPerson));
        //then
        assertEquals(1, resultPosition);



    }
}