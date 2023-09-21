package ee.valiit.rainaiback.business.lesson;

import ee.valiit.rainaiback.business.lesson.dto.*;
import ee.valiit.rainaiback.business.lesson.dto.ContentLessonDto;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonDto;
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
public class LessonsController {
    @Resource
    private LessonsService lessonsService;





    @PostMapping ("/mylessons")
    @Operation(summary = "Uue teema lisamine.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Teema juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public AddLessonResponse addNewLesson(@RequestBody AddLessonDto request){

        return lessonsService.addNewLessonAndReturnId(request);
    }

    @PutMapping("/mylessons")
    @Operation(summary = "Uuendab vajadusel Lesson entityt lessonname, packagetype ja technology infoga")
    public void updateLesson(@RequestBody ChangeLessonDto request){
        lessonsService.updateLesson(request);
    }

    @GetMapping("/editor")
    @Operation(summary = "Teema nime, packageType ja technology Id ja nime saamine.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Toimetaja ei leidnud vajalikke andmeid",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public EditorLessonDto getLessonInfo(@RequestParam Integer lessonId) {
        return lessonsService.getLessonInfo(lessonId);
    }

    @PutMapping("/editor/content")
    @Operation(summary = "Contenti lisamine andmebaasi.")
    public void updateContent(@RequestBody ContentLessonDto request){
        lessonsService.updateContent(request);
    }

    @GetMapping("editor/content")
    @Operation(summary = "Tagastab lesson contenti editori jaoks.")
    public EditorContentResponse getEditorContent(@RequestParam Integer lessonId){
        return lessonsService.getEditorContent(lessonId);
    }

}
