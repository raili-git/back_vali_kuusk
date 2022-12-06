package ee.valiit.back_vali_kuusk.domain.product.product;

import ee.valiit.back_vali_kuusk.business.product.NewTreeRequest;
import ee.valiit.back_vali_kuusk.business.product.ProductResponse;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    @Mapping(constant = "A", target = "status")
    @Mapping(source = "productPrice", target = "price")
    @Mapping(source = "productImage", target = "imageData", qualifiedByName = "productImageToImageData")
    Product newTreeRequestToProduct(NewTreeRequest newTreeRequest);

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "imageData", target = "productImage", qualifiedByName = "byteArrayToString")
    @Mapping(source = "type.name", target = "typeName")
    @Mapping(source = "height.gap", target = "heightGap")
    @Mapping(source = "price", target = "productPrice")
    ProductResponse productToProductResponse (Product product);
    List<ProductResponse> productsToProductRepose(List<Product>products);

    @Named("productImageToImageData")
    static byte[] productImageToImageData(String productImage) {
        return productImage.getBytes(StandardCharsets.UTF_8);
    }

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] pictureDataAsByArray) {
        if (pictureDataAsByArray == null) {
            return null;
        }
        String pictureAsString = new String(pictureDataAsByArray);
        return pictureAsString;
    }

}
