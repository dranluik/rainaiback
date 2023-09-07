package ee.valiit.rainaiback.infrastructure;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private Integer errorCode;
}
