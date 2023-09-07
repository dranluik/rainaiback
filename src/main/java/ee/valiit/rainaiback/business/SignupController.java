package ee.valiit.rainaiback.business;


import ee.valiit.rainaiback.infrastructure.error.ApiError;
import ee.valiit.rainaiback.validation.Error;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SignupController {
    @Resource
    private SignupService signUpService;

    @GetMapping("/signup")
    @Operation(summary = "Pakettide saamine. Tagastab packageId, packageName ja packagePrice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Ei leitud ühtegi paketti",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<PackageTypeDto> getPackages(){

        return signUpService.getPackages();
    }

    @PostMapping("/signup")
    @Operation(summary = "Uue kasutaja ja kontaktinfo lisamine.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Kasutajanimi on juba hõivatud",
            content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void addNewUserAndContact(@RequestBody NewUserDto request){
        signUpService.addNewUserAndContact(request);
    }

}
