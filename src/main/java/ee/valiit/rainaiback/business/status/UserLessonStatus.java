package ee.valiit.rainaiback.business.status;

import lombok.Getter;

@Getter
public enum UserLessonStatus {
    ENABLE("E"),
    DISABLE("D");
    private final String letter;

    UserLessonStatus(String letter) {
        this.letter = letter;
    }
}
