package ee.valiit.rainaiback.business.frontend;

import ee.valiit.rainaiback.domain.lesson.LessonDto;
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

    @GetMapping("/frontend")
    public List<LessonDto> getLessonName(){
        List<LessonDto> lessonNames = frontendService.getLessonName();
        return lessonNames;

    }
}
