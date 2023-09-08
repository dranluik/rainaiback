package ee.valiit.rainaiback.business.status;

import lombok.Getter;

@Getter
public enum LessonStatus {
    ADD("A"),
    DELETE("D"),
    LOCKED("L");
    private final String letter;

    LessonStatus(String letter) {
        this.letter = letter;
    }
}
