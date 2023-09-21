package ee.valiit.rainaiback.business.packagetype;

import ee.valiit.rainaiback.business.packagetype.dto.PackageTypeDto;
import ee.valiit.rainaiback.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageTypesController {

    @Resource
    private PackageTypesService packageTypesService;

    @GetMapping("/signup")
    @Operation(summary = "Pakettide saamine. Tagastab packageId, packageName ja packagePrice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Ei leitud ühtegi paketti",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<PackageTypeDto> getPackages(){

        return packageTypesService.getPackages();
    }
}
