package ee.valiit.back_vali_kuusk.business.order;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class TreeOrderController {

    @Resource
    private TreeOrderService treeOrderService;

    @GetMapping("/id")
    @Operation(summary = " See teenus annab orderId shop vaatesse jõudmisel")
    public OrderResponse getNewOrderId(@RequestParam Integer sessionId) {
        return treeOrderService.getNewOrderId(sessionId);
    }

    @PostMapping("/to-cart")
    @Operation(summary = " See teenus lisab ostu korvi ehk loob rea order_product tabelisse")
    public void addToCart(@RequestParam Integer orderId, @RequestParam Integer productId) {
        treeOrderService.createNewOrderProduct(orderId, productId);
    }

    @GetMapping("/cart")
    @Operation(summary = "Selle teenusega toome ostukorvi vaatesse valitud puud")
    public List<ShopResponse> getTreesByOrderId(@RequestParam Integer orderId) {
        List<ShopResponse> productsToCartResponse = treeOrderService.getTreeByOrderId(orderId);
        return productsToCartResponse;
    }

    @PatchMapping("/cart/remove")
    @Operation(summary = "Selle teenusega saab ostja eemaldada ostukorvi lisatud puu")
    public void removeTreeFromCart(@RequestParam Integer productId) {
        treeOrderService.changeTreeStatusBackToA(productId);
        treeOrderService.removeTreeFromOrderProduct(productId);
    }

    @GetMapping("/count")
    @Operation(summary = "Selle teenusega näitame ostukorvi ikooni peal ostukorvis olevate puude arvu")
    public long getProductCount(@RequestParam Integer orderId) {
        long count = treeOrderService.getProductCount(orderId);
        return count;
    }

}
