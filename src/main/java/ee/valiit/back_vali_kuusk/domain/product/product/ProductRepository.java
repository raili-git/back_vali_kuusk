package ee.valiit.back_vali_kuusk.domain.product.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.user.id = ?1")
    List<Product> findTreesBy(Integer id);


}