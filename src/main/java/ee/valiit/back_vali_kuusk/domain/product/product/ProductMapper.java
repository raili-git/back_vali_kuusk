package ee.valiit.back_vali_kuusk.domain.product.product;

import ee.valiit.back_vali_kuusk.business.product.NewTreeRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "typeId", target = "type.id")
    @Mapping(source = "heightId", target = "height.id")
    @Mapping(source = "productStatus", target = "status")
    @Mapping(source = "productImage", target = "imageData")
    @Mapping(source = "productPrice", target = "price")
    @Mapping(source = "userId", target = "user.id")
//    @Mapping(source = "userContactId", target = "contact.id")
    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "countyId", target = "county.id")
    Product newTreeRequestToProduct(NewTreeRequest newTreeRequest);


}
