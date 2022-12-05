package ee.valiit.back_vali_kuusk.domain.product.product;

import ee.valiit.back_vali_kuusk.business.product.NewTreeRequest;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    @Mapping(constant = "A", target = "status")
    @Mapping(source = "productPrice", target = "price")
    @Mapping(source = "productImage", target = "imageData", qualifiedByName = "productImageToImageData")
    Product newTreeRequestToProduct(NewTreeRequest newTreeRequest);

    @Named("productImageToImageData")
    static byte[] productImageToImageData(String productImage) {
        return productImage.getBytes(StandardCharsets.UTF_8);
    }

}
