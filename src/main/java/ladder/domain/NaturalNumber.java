package ladder.domain;

import static ladder.exceptoin.ExceptionMessage.NOT_NATURAL_NUMBER;

public class NaturalNumber {
    private final int number;

    private NaturalNumber(int number){
        validate(number);

        this.number = number;
    }

    public static NaturalNumber of(int number){
        return new NaturalNumber(number);
    }

    private void validate(int value) {
        if(value <= 0) throw new IllegalArgumentException(NOT_NATURAL_NUMBER.getMessage());
    }

    public int getNumber(){
        return number;
    }
}
