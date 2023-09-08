package ee.valiit.rainaiback.business.lesson;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyLessonController {
    @Resource
    private MyLessonService myLessonService;
    //get meetod, sisse tuleb userId
    //läheb kõigepealt user lesson tabelisse
    //sealt otsib listi lessonId-dega, userid ja status disable põhjal
    //siis läheb lessontabelisse, listi lessonid-de ja status active põhjal
    //tagastab kõik kasutaja lessonname (list)
    @GetMapping("/mylessons")
    public List<UserLessonLessonNameDto> findUserLessons(Integer userId){
        return myLessonService.findUserLessons(userId);


    }
}
