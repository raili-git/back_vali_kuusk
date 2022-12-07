package ee.valiit.back_vali_kuusk.domain.order.delivery;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeliveryService {

    @Resource
    private DeliveryRepository deliveryRepository;

    public Delivery findByDeliveryId(int deliveryId) {
        return deliveryRepository.findById(deliveryId).get();
    }
}
