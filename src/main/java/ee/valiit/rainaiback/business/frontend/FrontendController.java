package ee.valiit.rainaiback.business.frontend;

import ee.valiit.rainaiback.business.lesson.LessonDto;
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

import java.util.List;

@RestController
public class FrontendController {
    @Resource
    private FrontendService frontendService;

    @GetMapping("/frontend")
    @Operation(summary = "Tehnoloogia saamine. Tagastab packageTypeId, name ja status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Ei leitud ühtegi tehnoloogiat",
             content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<TechnologyDto> findAllActiveTechnologies() {
    List<TechnologyDto> technologies = frontendService.findAllActiveTechnologies();
    return technologies;
    }

    @GetMapping("/lesson-names")
    @Operation(summary = "Teema nimede saamine. Tagastab packageTypeId, lessonName ja lessonStatus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Ei leitud ühtegi teema nime",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<LessonDto> getLessonName(@RequestParam Integer technologyId){
        List<LessonDto> lessonNames = frontendService.getLessonName(technologyId);
        return lessonNames;

    }
}
