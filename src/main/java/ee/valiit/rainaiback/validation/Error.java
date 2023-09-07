package ee.valiit.rainaiback.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    USERNAME_UNAVAILABLE("Kasutajanimi on juba hõivatud", 222);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }
}
