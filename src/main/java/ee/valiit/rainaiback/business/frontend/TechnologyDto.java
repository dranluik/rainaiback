package ee.valiit.rainaiback.business.frontend;

import ee.valiit.rainaiback.domain.technology.Technology;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Technology}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDto implements Serializable {
    private Integer packageTypeId;
    @Size(max = 255)
    private String name;
    private String status;
}