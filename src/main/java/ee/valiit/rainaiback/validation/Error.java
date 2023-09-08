package ee.valiit.rainaiback.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    NO_PACKAGE_FOUND("Ei leitud ühtegi paketti", 222),
    USERNAME_UNAVAILABLE("Kasutajanimi on juba hõivatud", 333),
    NO_TECHNOLOGIES_FOUND("Ei leitud ühtegi tehnoloogiat", 444);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }
}
