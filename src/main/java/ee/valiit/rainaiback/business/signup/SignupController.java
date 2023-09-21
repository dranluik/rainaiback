package ee.valiit.rainaiback.business.signup;


import ee.valiit.rainaiback.business.signup.dto.NewUserDto;
import ee.valiit.rainaiback.infrastructure.error.ApiError;
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
    private SignupService signupService;


    @PostMapping("/signup")
    @Operation(summary = "Uue kasutaja ja kontaktinfo lisamine.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Kasutajanimi on juba hõivatud",
            content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void addNewUserAndContact(@RequestBody NewUserDto request){
        signupService.addNewUserAndContact(request);
    }

}
