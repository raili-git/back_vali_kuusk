package ee.valiit.back_vali_kuusk.business.login;

import ee.valiit.back_vali_kuusk.domain.order.session.Session;
import ee.valiit.back_vali_kuusk.domain.order.session.SessionService;
import ee.valiit.back_vali_kuusk.domain.userrole.user.User;
import ee.valiit.back_vali_kuusk.domain.userrole.user.UserMapper;
import ee.valiit.back_vali_kuusk.domain.userrole.user.UserRepository;
import ee.valiit.back_vali_kuusk.domain.userrole.user.UserService;
import ee.valiit.back_vali_kuusk.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private SessionService sessionService;


    public LoginResponse login(String username, String password) {
        User user = userService.getValidUser(username, password);

        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;

    }


    public SessionResponse getNewSessionHash() {
        String sessionHash = LocalDateTime.now().toString();
        Session session = new Session();
        session.setSessionHash(sessionHash);
        sessionService.addNewSession(session);
        SessionResponse sessionResponse = new SessionResponse();
        sessionResponse.setSessionId(session.getId());
        return sessionResponse;
    }
}

