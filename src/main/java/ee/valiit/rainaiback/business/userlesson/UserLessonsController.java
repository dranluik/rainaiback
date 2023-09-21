package ee.valiit.rainaiback.business.userlesson;

import ee.valiit.rainaiback.business.lesson.dto.LessonDto;
import ee.valiit.rainaiback.business.lesson.dto.UserLessonLessonNameDto;
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
public class UserLessonsController {
    @Resource
    private UserLessonsService userLessonsService;


    @GetMapping("/lessons/user")
    @Operation(summary = "Teema nimede saamine. Tagastab lessonName ja isSelected")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Ei leitud ühtegi teema nime",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<LessonDto> getLessons(@RequestParam Integer userId, @RequestParam Integer packageTypeId, @RequestParam Integer technologyId){
        return userLessonsService.getLessons(userId, packageTypeId, technologyId);
    }


    @GetMapping("/lesson/myLessons")
    @Operation(summary = "Minu teema nimede saamine. Tagastad lessonName")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Kasutaja pole ühtegi teemat oma teemaks veel valinud",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<UserLessonLessonNameDto> findMyLessons(@RequestParam Integer userId){
        return userLessonsService.findMyLessons(userId);
    }

    @PostMapping("/lesson/user")
    @Operation(summary = "Teema lisamine kasutaja teemade hulka.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Kasutajal on see teema juba lisatud",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void addNewUserLesson(@RequestBody UserLessonDto request){
        userLessonsService.addNewUserLesson(request);
    }

    @DeleteMapping("/lesson/user")
    @Operation(summary = "Teema eemaldamine kasutaja teemade hulgast", description = "Kustutab täielikult tabelist valitud rea ära")
    public void deleteUserLesson(@RequestParam Integer userId, @RequestParam Integer lessonId){
        userLessonsService.deleteUserLesson(userId,lessonId);
    }
}
