package ee.valiit.rainaiback.business.lesson;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyLessonController {
    @Resource
    private MyLessonService myLessonService;


}
