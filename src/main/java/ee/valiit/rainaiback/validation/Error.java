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
    TECHNOLOGY_NAME_UNAVAILABLE("Sellise nimega tehnoloogia on juba olemas", 777),
    LESSON_NAME_UNAVAILABLE("See teema on juba olemas", 888);


    private final String message;
    private final int errorCode;

    Error(String message, int errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }
}
