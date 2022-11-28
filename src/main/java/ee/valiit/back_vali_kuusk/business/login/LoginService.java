package ee.valiit.back_vali_kuusk.business.login;

import ee.valiit.back_vali_kuusk.domain.userrole.user.User;
import ee.valiit.back_vali_kuusk.domain.userrole.user.UserRepository;
import ee.valiit.back_vali_kuusk.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LoginService {

    @Resource
    private UserRepository userRepository;
    public void login(String username, String password) {
        Optional<User> userOptional = userRepository.findBy(username, password);

        //kui ei leia, viska viga
        if (userOptional.isEmpty()) {
            throw new BusinessException("Sellist kasutajanime või parooli ei leitud","666");
        }

    }


}

