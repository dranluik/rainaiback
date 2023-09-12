package ee.valiit.rainaiback.business.status;

import lombok.Getter;

@Getter
public enum UserLessonStatus {
    READ("R"),
    UNREAD("U");
    private final String letter;

    UserLessonStatus(String letter) {
        this.letter = letter;
    }
}
