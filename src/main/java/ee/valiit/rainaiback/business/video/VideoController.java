package ee.valiit.rainaiback.business.video;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {

    @Resource
    private VideoService videoService;

    @PostMapping("/video")
    @Operation(summary = "Salvestab andmebaasi uue video objekti.")
    public void addNewVideo(@RequestBody VideoDto videoDto){
        videoService.addNewVideo(videoDto);

    }
    @DeleteMapping("/video")
    @Operation(summary = "Kustutab videoId põhjal video andmebaasist.")
    public void deleteVideo(@RequestParam Integer videoId){
        videoService.deleteVideo(videoId);
    }

    @GetMapping("/video")
    @Operation(summary = "Leiab videod lessonId järgi.")
    public List<VideoDto> findVideos(@RequestParam Integer lessonId){
        return videoService.findVideos(lessonId);
    }
}
