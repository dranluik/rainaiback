package ee.valiit.rainaiback.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    NO_PACKAGE_FOUND("Ei leitud ühtegi paketti", 222),
    USERNAME_UNAVAILABLE("Kasutajanimi on juba hõivatud", 333),
    NO_TECHNOLOGIES_FOUND("Ei leitud ühtegi tehnoloogiat", 444),
    NO_LESSON_NAMES_FOUND("Ei leitud ühtegi teema nime", 555),
    NO_USER_LESSONS_FOUND("Ei leitud ühtegi kasutaja teemat", 666),
    USER_LESSON_UNAVAILABLE("Kasutajal on see teema juba lisatud", 777);


    private final String message;
    private final int errorCode;

    Error(String message, int errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }
}
