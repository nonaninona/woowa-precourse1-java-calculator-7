package calculator;

public enum ErrorMessage {
    NEGATIVE_NUMBER_INPUT("잘못된 입력 : 음수"),
    TOO_LARGE_OR_CHARACTER_INPUT("잘못된 입력 : 너무 큰 수 또는 문자가 포함된 수"),
    TOO_LARGE_OUTPUT("결과 오류 : 수의 합이 너무 큽니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
