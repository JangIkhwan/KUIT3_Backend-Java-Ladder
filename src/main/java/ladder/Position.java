package ladder;

public class Position {
    private int position;
    //private int numOfPerson;
    public static Position of(int position){
        return new Position(position);
    }

    private Position(int position){
        validatePosition(position);
        this.position = position;
    }

    public Position prev(){
        return new Position(position - 1);
    }

    public Position next(){
        return new Position(position + 1);
    }

    public void validatePosition(int position){
        //if(position < 0 || position >= numOfPerson)
        //    throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
    }

    public int get(){
        return this.position;
    }
}
