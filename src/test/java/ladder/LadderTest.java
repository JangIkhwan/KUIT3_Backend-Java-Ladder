package ladder;

import ladder.domain.NaturalNumber;
import ladder.domain.Position;
import ladder.game.BasicLadderCreator;
import ladder.game.LadderCreator;
import ladder.game.LadderGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladder = new BasicLadderCreator(numberOfRows, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        NaturalNumber numberOfRows = NaturalNumber.of(1);
        LadderCreator ladder = new BasicLadderCreator(numberOfRows, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladder);

        //when
        Position position = Position.of(3);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderGame.play(position));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfRows = NaturalNumber.of(4);
        LadderCreator ladder = new BasicLadderCreator(numberOfRows, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladder);
        ladder.drawLine(Position.of(1),Position.of(0));
        ladder.drawLine(Position.of(1),Position.of(2));
        ladder.drawLine(Position.of(2), Position.of(1));

        //when
        Position position = Position.of(0);
        Position resultPosition = ladderGame.play(position);
        //then
        assertEquals(2, resultPosition.getPosition());

        //when
        position = Position.of(1);
        resultPosition = ladderGame.play(position);
        //then
        assertEquals(0, resultPosition.getPosition());

        //when
        position = Position.of(2);
        resultPosition = ladderGame.play(position);
        //then
        assertEquals(3, resultPosition.getPosition());

        //when
        position = Position.of(3);
        resultPosition = ladderGame.play(position);
        //then
        assertEquals(1, resultPosition.getPosition());

    }
}