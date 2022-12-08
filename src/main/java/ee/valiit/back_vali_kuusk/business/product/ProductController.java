package ee.valiit.back_vali_kuusk.business.product;

import ee.valiit.back_vali_kuusk.domain.product.county.CountyDto;
import ee.valiit.back_vali_kuusk.domain.product.height.HeightDto;
import ee.valiit.back_vali_kuusk.business.order.ShopResponse;
import ee.valiit.back_vali_kuusk.domain.product.type.TypeDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private TreeService treeService;

    @GetMapping("/type")
    @Operation(summary = "Selle teenusega saad kätte kõik puutüübid")
    public List<TypeDto> getAllTreeTypes() {
        List<TypeDto> result = treeService.getAllTreeTypes();
        return result;
    }

    @GetMapping("/height")
    @Operation(summary = "Selle teenusega saad kätte kõik kõrguste vahemikud")
    public List<HeightDto> getAllTreeHeights() {
        return treeService.getAllTreeHeights();     // see on lühem versioon return'ida
    }

    @GetMapping("/county")
    @Operation (summary = "Selle teenusega saad kätte kõik maakonnad")
    public List<CountyDto> getAllCounties() {
        return treeService.getAllCounties();
    }

    @PostMapping("/new-tree")
    @Operation(summary = "Selle teenusega saab müüja lisada uue puu")
    public void addNewTree(@RequestBody @Valid NewTreeRequest request){

        treeService.addNewTree(request);
    }

    @GetMapping("/trees/by-user")
    @Operation(summary = "Selle teenusega kuvame müüja kõik puud 'userId' järgi")
    public List<ProductResponse> getAllTreesByUserId(@RequestParam Integer userId) {
        List<ProductResponse> productsReponse = treeService.getAllTreesByUserId(userId);
        return productsReponse;
    }

    @GetMapping("/shop")
    @Operation (summary = "Selle teenusega kuvame kõikide müüjate müügis olevad puud")
    public List<ShopResponse> getAllTrees(){
        List<ShopResponse> productsToShopResponse = treeService.getAllTrees();
        return productsToShopResponse;
    }

    @GetMapping("/shop/sorting")
    @Operation (summary = "Selle teenusega filtreerime müügis olevaid puid ostja vaates")
    public List<ShopResponse> getProductsBySortingParameters(@RequestParam Integer typeId, Integer heightId, Integer countyId) {
        List<ShopResponse> productsBySortingParameters = treeService.getProductsBySortingParameters(typeId, heightId, countyId);
        return productsBySortingParameters;

    }

    @PutMapping("/modify-tree")
    @Operation (summary = "Selle teenusega saame muuta müügis oleva puud parameetreid")
    public void changeTreeParameters (@RequestParam Integer productId, @RequestBody UpdateTreeRequest treeUpdate) {
      treeService.changeTreeParameters(productId, treeUpdate);
    }


}
