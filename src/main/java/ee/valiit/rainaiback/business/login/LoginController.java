package ee.valiit.rainaiback.business.login;


import ee.valiit.rainaiback.business.login.dto.LoginResponse;
import ee.valiit.rainaiback.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

@Resource
private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Sisse logimine. Tagastab userId, roleName ja packageTypeName",
    description = """
            Süsteemist otsitakse username ja password abil kasutajat, kelle konto on ka aktiivne.
                            Kui vastet ei leita vistakse viga errorCode'ga 111
            """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Vale kasutajanim või parool", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public LoginResponse login (@RequestParam String username, @RequestParam String password){
       return loginService.login(username,password);
    }
}
