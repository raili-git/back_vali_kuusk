package ee.valiit.back_vali_kuusk.domain.userrole.user;

import ee.valiit.back_vali_kuusk.business.login.LoginResponse;
import ee.valiit.back_vali_kuusk.business.registration.RegisterRequest;
import ee.valiit.back_vali_kuusk.domain.userrole.role.Role;
import ee.valiit.back_vali_kuusk.domain.userrole.role.RoleService;
import ee.valiit.back_vali_kuusk.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleService roleService;

    @Resource
    private UserMapper userMapper;

    public User getValidUser(String username, String password) {
        Optional<User> userOptional = userRepository.findBy(username, password);
        //kui ei leia, viska viga
        Validation.validateUserCredentials(userOptional);
        User user = userOptional.get();

        return user;

    }


    public void controlUsernameExists(RegisterRequest request) {
        boolean exists = userRepository.existsBy(request.getUsername());
        Validation.validateUsernameAvailable(exists);
    }

    public LoginResponse saveNewUser(RegisterRequest request) {
        User user = userMapper.registerRequestToUser(request); // mäpime DTO entitiks ja paneme selle uude objekti, ehk teeme uue kasutaja rea
        Role role = roleService.getRoleByType("seller"); //userile on vaja anda roll
        user.setRole(role); // anname userile juurde rolli
        userRepository.save(user); //salvestame useri koos username, password ja roleType'ga DB tabelisse
        LoginResponse loginResponse = userMapper.toLoginResponse(user);

        return loginResponse;
    }



}
