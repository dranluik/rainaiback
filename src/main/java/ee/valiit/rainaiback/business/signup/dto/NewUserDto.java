package ee.valiit.rainaiback.business.signup.dto;

import ee.valiit.rainaiback.domain.contact.user.User;
import ee.valiit.rainaiback.domain.contact.Contact;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

/**
 * DTO for {@link User}, {@link Contact}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDto implements Serializable {
    private Integer packageTypeId;
    @NotNull
    @Size(max = 255)
    private String username;
    @NotNull
    @Size(max = 255)
    private String password;
    private String firstName;
    private String lastName;
}