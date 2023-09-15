package ee.valiit.rainaiback.business.video;

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
public class VideoController {

    @Resource
    private VideoService videoService;

    @PostMapping("/video")
    @Operation(summary = "Video lisamine andmebaasi.")
    public void addNewVideo(@RequestBody VideoDto videoDto){
        videoService.addNewVideo(videoDto);

    }

}
