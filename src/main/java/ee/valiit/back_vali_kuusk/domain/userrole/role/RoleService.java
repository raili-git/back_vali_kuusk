package ee.valiit.back_vali_kuusk.domain.userrole.role;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {

    @Resource

    private RoleRepository roleRepository;

    public Role getRoleByType (String roleType){
        return roleRepository.findByType (roleType);
    }

}
