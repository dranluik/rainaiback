package ee.valiit.rainaiback.business.image;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageController {
    @Resource
    private ImagesService imagesService;

    @PostMapping("/image")
    @Operation(summary = "Salvestab andmebaasi uue image objekti")
    public void addNewImage(@RequestBody ImageRequest image){
        imagesService.addNewImage(image);

    }

    @DeleteMapping("/image")
    @Operation(summary = "Kustutab imageId põhjal pildi andmebaasist")
    public void deleteImage(@RequestParam Integer imageId){
        imagesService.deleteImage(imageId);
    }

    @GetMapping("/image")
    @Operation(summary = "Tagastab listi imageid ning imageData ja descriptioni stringina, võtab sisse lessonId")
    public List<ImageResponse> findImages(@RequestParam Integer lessonId){
        return imagesService.findImages(lessonId);
    }
}
