package ee.valiit.back_vali_kuusk.domain.userrole.user.address;

import ee.valiit.back_vali_kuusk.domain.product.county.County;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AddressMapper {

    Address toEntity(County county, String street);

}
