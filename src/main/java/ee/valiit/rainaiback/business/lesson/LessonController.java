package ee.valiit.rainaiback.business.lesson;

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
public class LessonController {
    @Resource
    private LessonsService lessonsService;

    @GetMapping("/lesson/technology")
    @Operation(summary = "Tehnoloogia saamine. Tagastab packageTypeId, name ja status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Ei leitud ühtegi tehnoloogiat",
             content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<TechnologyDto> findAllActiveTechnologies(@RequestParam Integer packageTypeId) {
    List<TechnologyDto> technologies = lessonsService.findAllActiveTechnologies(packageTypeId);
    return technologies;
    }

    @GetMapping("/lesson/user")
    @Operation(summary = "Teema nimede saamine. Tagastab packageTypeId, lessonName ja lessonStatus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Ei leitud ühtegi teema nime",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<LessonDto> getLessons(@RequestParam Integer userId, @RequestParam Integer packageTypeId, @RequestParam Integer technologyId){
        List<LessonDto> lessons = lessonsService.getLessons(userId, packageTypeId, technologyId);
        return lessons;

    }
    @GetMapping("/lesson/mylessons")
    public void findMyLessons(@RequestParam Integer userId){
        lessonsService.findMyLessons(userId);
    }
}
