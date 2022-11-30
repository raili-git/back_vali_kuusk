package ee.valiit.back_vali_kuusk.domain.userrole.user;

import ee.valiit.back_vali_kuusk.business.login.LoginResponse;
import ee.valiit.back_vali_kuusk.business.registration.RegisterRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.type", target = "roleType")
    LoginResponse toLoginResponse(User user);

    @Mapping(source ="username", target = "username" )
    @Mapping(source = "password", target = "password")
    @Mapping(source = "roleType", target = "role.type")
    User registerRequestToUser (RegisterRequest request);
}


