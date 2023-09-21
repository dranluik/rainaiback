package ee.valiit.rainaiback.domain.image;

import ee.valiit.rainaiback.business.image.dto.ImageRequest;
import ee.valiit.rainaiback.business.image.dto.ImageResponse;
import ee.valiit.rainaiback.util.ContentConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {
    @Mapping(source = "imageDescription", target = "description")
    @Mapping(source = "imageData", target = "data", qualifiedByName = "getImageDataAsBytes")
    Image toImageEntity(ImageRequest imageRequest);

    @Named("getImageDataAsBytes")
    static byte[] getImageDataAsBytes(String imageData) {
        return ContentConverter.getBytesArrayFromContent(imageData);
    }

    @Mapping(source = "id", target = "imageId")
    @Mapping(source = "data", target = "imageData", qualifiedByName = "getImageDataAsString")
    @Mapping(source = "description", target = "imageDescription")
    ImageResponse toImageResponse(Image image);

    @Named("getImageDataAsString")
    static String getImageDataAsString(byte[] data) {
        return ContentConverter.getContentAsString(data);
    }

    List<ImageResponse> toImagesResponse(List<Image> images);

}