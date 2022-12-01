package ee.valiit.back_vali_kuusk.domain.userrole.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.type = ?1")
    Role findByType(String type);





}