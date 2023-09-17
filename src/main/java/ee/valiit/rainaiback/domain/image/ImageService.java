package ee.valiit.rainaiback.domain.image;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Resource
    private ImageRepository imageRepository;
    public void saveImage(Image imageEntity) {
        imageRepository.save(imageEntity);
    }

    public void deleteImageBy(Integer imageId) {
        imageRepository.deleteById(imageId);
    }
}
