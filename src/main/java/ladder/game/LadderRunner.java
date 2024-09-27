package ladder.game;

import ladder.domain.Row;
import ladder.domain.LadderPosition;
import ladder.domain.Position;

public class LadderRunner {
    private Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position position){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rows.length; i++){
            sb.append("Before\n");
            printLadder(sb, LadderPosition.from(position, Position.of(i)));
            position = rows[i].nextPosition(position);
            sb.append("After\n");
            printLadder(sb, LadderPosition.from(position, Position.of(i)));
        }
        System.out.println(sb.toString());
        return position;
    }

    private void printLadder(StringBuilder sb, LadderPosition starPosition) {
        for(int row = 0; row < rows.length; row++){
            if(starPosition.yIsSameAs(row)) rows[row].appendStarRowString(sb, starPosition);
            else rows[row].appendRowString(sb);
        }
        sb.append("\n");
    }
}
