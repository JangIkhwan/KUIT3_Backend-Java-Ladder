package ladder.game;

import ladder.domain.Row;
import ladder.domain.Position;

public interface LadderCreator {
    void drawLine(Position row, Position col);
    Row[] getRows();
}
