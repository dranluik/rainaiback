package ee.valiit.rainaiback.business.technology;

import ee.valiit.rainaiback.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnologiesController {
    @Resource
    private TechnologiesService technologiesService;

    @PostMapping("/technology")
    @Operation(summary = "Lisab uue tehnoloogia kui sellenimelist tehnoloogiat juba ei ole")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega tehnoloogia on juba olemas", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void addNewTechnology(@RequestBody AddTechnologyRequest request){
        technologiesService.addNewTechnology(request);
    }
}
