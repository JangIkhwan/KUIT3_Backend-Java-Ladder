package ladder;

import ladder.domain.NaturalNumber;
import ladder.domain.Position;
import ladder.game.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderCreatorTest {
    @Test
    void 랜덤_사다리_생성자_테스트(){
        // given
        NaturalNumber row = NaturalNumber.of(5);
        NaturalNumber person = NaturalNumber.of(5);
        LadderCreator ladderCreator = new RandomLadderCreator(new BasicLadderCreator(row, person));

        //when

        //then
        assertDoesNotThrow(()->ladderCreator.drawLine(Position.of(1), Position.of(1)));
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(Position.of(1));
    }

    @Test
    void 랜덤_사다리_게임_생성_테스트(){
        // given
        NaturalNumber row = NaturalNumber.of(5);
        NaturalNumber person = NaturalNumber.of(5);

        // when
        LadderGame randomLadderGame = LadderGameFactory.createRandomLadderGame(row, person);

        // then
        assertThat(randomLadderGame).isNotNull();
    }

}