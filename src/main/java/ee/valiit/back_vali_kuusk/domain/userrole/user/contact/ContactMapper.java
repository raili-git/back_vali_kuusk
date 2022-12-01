package ee.valiit.back_vali_kuusk.domain.userrole.user.contact;

import ee.valiit.back_vali_kuusk.business.user.ProfileRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {

    Contact toContact(ProfileRequest profileRequest);

}
