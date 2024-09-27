package ladder.domain;


import static ladder.exceptoin.ExceptionMessage.INVALID_POSITION;

public class Position {
    private int position;
    private Position(int value){
        this.position = value;
    }

    public static Position of(int value){
        validate(value);
        return new Position(value);
    }

    private static void validate(int value) {
        if(value < 0) throw new IllegalArgumentException(INVALID_POSITION.getMessage());
    }

    public Position next(){
        return new Position(this.position + 1);
    }

    public Position prev(){
        return new Position(this.position - 1);
    }

    public int getPosition() {
        return position;
    }

    public boolean isBiggerThan(int i) {
        return position > i;
    }

    public boolean isSmallerThan(int i) {
        return position < i;
    }
}
