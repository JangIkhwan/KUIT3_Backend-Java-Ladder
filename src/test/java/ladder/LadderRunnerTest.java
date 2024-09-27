package ladder;

import ladder.domain.NaturalNumber;
import ladder.domain.Position;
import ladder.game.BasicLadderCreator;
import ladder.game.LadderCreator;
import ladder.game.LadderRunner;
import org.junit.jupiter.api.Test;

class LadderRunnerTest {
    @Test
    public void 사디리타기_출력_테스트(){
        NaturalNumber rows = NaturalNumber.of(5);
        NaturalNumber persons = NaturalNumber.of(5);
        LadderCreator ladderCreator = new BasicLadderCreator(rows, persons);
        ladderCreator.drawLine(Position.of(1), Position.of(1));
        ladderCreator.drawLine(Position.of(2), Position.of(2));
        ladderCreator.drawLine(Position.of(3), Position.of(3));

        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(Position.of(1));
    }


}
