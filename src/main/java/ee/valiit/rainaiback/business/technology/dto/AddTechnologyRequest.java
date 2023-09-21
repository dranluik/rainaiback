package ee.valiit.rainaiback.business.technology.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.rainaiback.domain.technology.Technology}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTechnologyRequest implements Serializable {
    private Integer packageTypeId;
    @NotNull
    @Size(max = 255)
    private String technologyName;
}