package ee.valiit.rainaiback.business.packagetype.dto;

import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

/**
 * DTO for {@link PackageType}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageTypeDto implements Serializable {
    private Integer packageId;
    @NotNull
    @Size(max = 255)
    private String packageName;
    @NotNull
    private Integer packagePrice;
}