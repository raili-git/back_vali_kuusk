package ee.valiit.back_vali_kuusk.domain.product.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.user.id = ?1 and p.status = ?2")
    List<Product> findTreesBy(Integer userId, String status);


    @Query("select p from Product p where p.type.id = ?1 and p.height.id = ?2 and p.county.id = ?3")
    List<Product> findProductBy(Integer typeId, Integer heightId, Integer countyId);

    @Query("select p from Product p where p.type.id = ?1 and p.height.id = ?2 and p.county.id = ?3 and p.status = ?4")
    List<Product> findByType_IdAndHeight_IdAndCounty_IdAndStatus(Integer typeId, Integer heightId, Integer countyId, String status);


}