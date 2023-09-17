package ee.valiit.rainaiback.domain.image;

import ee.valiit.rainaiback.business.image.ImageRequest;
import ee.valiit.rainaiback.business.image.ImageResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {
    @Mapping(source = "imageDescription", target = "description")
    @Mapping(source = "imageData", target = "data")
    Image toImageEntity(ImageRequest imageRequest);

    @Mapping(source = "id", target = "imageId")
    @Mapping(source = "data", target = "imageData")
    @Mapping(source = "description", target = "imageDescription")
    @Mapping(source = "lesson.id", target = "lessonId")
    ImageResponse toImageResponse(Image image);

}