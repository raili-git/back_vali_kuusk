package ee.valiit.back_vali_kuusk.business.registration;


import ee.valiit.back_vali_kuusk.business.login.LoginResponse;
import ee.valiit.back_vali_kuusk.domain.userrole.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegistrationService {
    // TODO: siin ei lähe ühegi repository vastu


    @Resource
    public UserService userService;

    public LoginResponse registerNewUser(RegisterRequest request) {
        userService.controlUsernameExists (request);
        LoginResponse loginResponse = userService.saveNewUser(request);

        // 11/30/2022 peate saama kätte boolean 'userExists'  (UserService->UserRepository)
        // 11/30/2022 valideerida ja visata viga kui kasutajanimi on juba hõivatud
        // TODO: 11/30/2022 mäpime ümber requestist infi entityks (user)
        // TODO: 11/30/2022 kasutades RoleService -> RoleRepository leiate seller Role
        // TODO: 11/30/2022 Lisate role -> user objektile
        // TODO: 11/30/2022 salvestate save() abil useri (UserService -> UserRepository
        // TODO: 11/30/2022 nüüd on user objektil olemas id väärtus
        // TODO: 11/30/2022 Nüüd on vaja luua objekt RegisterResponse klassist ja panna "userId" väljale user.getId()ga külge
        // TODO: 11/30/2022 tagastate registerResponse objekti
        return loginResponse;
    }



}
