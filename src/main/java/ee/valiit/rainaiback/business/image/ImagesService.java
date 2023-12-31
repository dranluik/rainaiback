package ee.valiit.rainaiback.business.image;

import ee.valiit.rainaiback.business.image.dto.ImageRequest;
import ee.valiit.rainaiback.business.image.dto.ImageResponse;
import ee.valiit.rainaiback.domain.image.Image;
import ee.valiit.rainaiback.domain.image.ImageMapper;
import ee.valiit.rainaiback.domain.image.ImageService;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesService {
    @Resource
    private ImageMapper imageMapper;
    @Resource
    private LessonService lessonService;
    @Resource
    private ImageService imageService;


    public void addNewImage(ImageRequest image) {
        Image imageEntity = imageMapper.toImageEntity(image);
        Lesson lesson = lessonService.getLessonBy(image.getLessonId());
        imageEntity.setLesson(lesson);
        imageService.saveImage(imageEntity);




    }

    public void deleteImage(Integer imageId) {
        imageService.deleteImageBy(imageId);
    }

    public List<ImageResponse> findImages(Integer lessonId) {
        List<Image> images = imageService.findImagesBy(lessonId);
        return imageMapper.toImagesResponse(images);

    }
}
