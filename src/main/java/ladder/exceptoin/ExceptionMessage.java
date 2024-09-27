package ladder.exceptoin;

public enum ExceptionMessage {
    GAMER_NUMBER_REQUIREMENT("게임의 참여자 수는 1명 이상이어야 합니다."),
    FAILED_TO_DRAW_LINE("라인 생성이 불가능한 위치 입니다."),
    INVALID_POSITION("유효하지 않은 위치 입니다."),
    NOT_NATURAL_NUMBER("자연수는 0보다 커야 합니다.");
    String message;

    ExceptionMessage(String value){
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}
