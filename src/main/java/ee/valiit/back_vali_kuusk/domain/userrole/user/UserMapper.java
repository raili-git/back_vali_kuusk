package ee.valiit.back_vali_kuusk.domain.userrole.user;

import ee.valiit.back_vali_kuusk.business.login.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.type", target = "roleType")
    LoginResponse toLoginResponse(User user);
}


