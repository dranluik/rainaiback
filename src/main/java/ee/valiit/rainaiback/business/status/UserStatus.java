package ee.valiit.rainaiback.business.status;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIVE("A"),
    DELETED("D");

    private final String letter;

    UserStatus(String letter) {
        this.letter = letter;
    }
}
