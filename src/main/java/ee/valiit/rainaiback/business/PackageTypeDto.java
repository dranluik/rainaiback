package ee.valiit.rainaiback.business;

import ee.valiit.rainaiback.domain.packagetype.PackageType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link PackageType}
 */
@Value
public class PackageTypeDto implements Serializable {
    Integer packageId;
    @NotNull
    @Size(max = 255)
    String packageName;
    @NotNull
    Integer packagePrice;
}