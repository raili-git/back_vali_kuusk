package ee.valiit.back_vali_kuusk.product;

import ee.valiit.back_vali_kuusk.domain.product.TypeDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ProductController {

    @Resource
    private ProductService productService;


    @GetMapping("/type")
    @Operation(summary = "Selle teenusega saad kätte kõik puutüübid")
    public List<TypeDto> getAllTreeTypes() {
        List<TypeDto> result = productService.getAllTreeTypes();
        return result;
    }


}
