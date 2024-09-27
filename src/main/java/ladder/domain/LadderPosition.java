package ladder.domain;

public class LadderPosition {
    private Position x;
    private Position y;

    private LadderPosition(Position x, Position y){
        this.x = x;
        this.y = y;
    }

    public static LadderPosition from(Position x, Position y) {
        return new LadderPosition(x, y);
    }

    public boolean yIsSameAs(int position){
        return this.y.getPosition() == position;
    }

    public boolean xIsSameAs(int position){
        return this.x.getPosition() == position;
    }

    public Position getX() {
        return x;
    }

    public Position getY() {
        return y;
    }

}
