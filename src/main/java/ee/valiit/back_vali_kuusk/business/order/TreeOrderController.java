package ee.valiit.back_vali_kuusk.business.order;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TreeOrderController {

    @Resource
    private TreeOrderService treeOrderService;

    @GetMapping("/order/id")
    @Operation(summary = " See teenus annab orderId shop vaatesse jõudmisel")
    public OrderResponse getNewOrderId(@RequestParam Integer sessionId) {
        return treeOrderService.getNewOrderId(sessionId);
    }

    @GetMapping("/to-cart")
    @Operation(summary = " See teenus lisab ostu korvi ehk loob rea order_product tabelisse")
    public  void addToCart(@RequestParam Integer orderId, @RequestParam Integer productId) {
        treeOrderService.getOrderId(orderId);
    }

}
