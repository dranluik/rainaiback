package ee.valiit.rainaiback.business.video;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @Resource
    private VideoService videoService;

    @PostMapping("/video")
    public void addVideo(@RequestParam Integer lessonId){
        videoService.addVideo(lessonId);
    }

}
