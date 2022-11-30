package ee.valiit.back_vali_kuusk.domain.userrole.user;

import ee.valiit.back_vali_kuusk.business.registration.RegisterRequest;
import ee.valiit.back_vali_kuusk.infrastructure.exception.BusinessException;
import ee.valiit.back_vali_kuusk.validation.ValiKuuskError;
import ee.valiit.back_vali_kuusk.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

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

    public void saveNewUser(RegisterRequest request) {

    }
}
