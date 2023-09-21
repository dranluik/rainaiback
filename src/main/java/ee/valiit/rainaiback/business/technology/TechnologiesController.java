package ee.valiit.rainaiback.business.technology;

import ee.valiit.rainaiback.business.technology.dto.TechnologyDto;
import ee.valiit.rainaiback.business.technology.dto.AddTechnologyRequest;
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

    @GetMapping("/lesson/technology")
    @Operation(summary = "Tehnoloogia saamine. Tagastab packageTypeId, name ja status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Ei leitud ühtegi tehnoloogiat",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<TechnologyDto> findAllActiveTechnologies(@RequestParam Integer packageTypeId) {
        List<TechnologyDto> technologies = technologiesService.findAllActiveTechnologies(packageTypeId);
        return technologies;
    }
}
