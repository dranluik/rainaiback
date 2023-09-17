package ee.valiit.rainaiback.business.image;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageController {
    @Resource
    private ImagesService imagesService;

    @PostMapping("/image")
    @Operation(summary = "Salvestab andmebaasi uue image objekti, tagastab ImageResponse")
    public ImageResponse addNewImage(@RequestBody ImageRequest image){
        return imagesService.addNewImage(image);

    }

    @DeleteMapping("/image")
    @Operation(summary = "Kustutab imageId põhjal pildi andmebaasist")
    public void deleteImage(@RequestParam Integer imageId){
        imagesService.deleteImage(imageId);
    }
}
