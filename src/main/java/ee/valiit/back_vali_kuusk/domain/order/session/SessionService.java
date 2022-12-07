package ee.valiit.back_vali_kuusk.domain.order.session;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SessionService {


    @Resource
    private SessionRepository sessionRepository;

    public void addNewSession(Session session) {
        sessionRepository.save(session);
    }

    public Session findBySessionId(int sessionId) {
        return sessionRepository.findById(sessionId).get();
    }
}
