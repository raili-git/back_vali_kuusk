package ee.valiit.back_vali_kuusk.domain.order.orderproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
    @Query("select o from OrderProduct o where o.order.id = ?1")
    List<OrderProduct> findAll(Integer id);


}