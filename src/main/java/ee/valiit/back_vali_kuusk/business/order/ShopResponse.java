package ee.valiit.back_vali_kuusk.business.order;

import ee.valiit.back_vali_kuusk.domain.product.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Product} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopResponse implements Serializable {
    private Integer productId;
    @Size(max = 255)
    @NotNull
    private String countyName;
    @NotNull
    private String typeName;
    @Size(max = 255)
    @NotNull
    private String heightGap;
    @NotNull
    private String productImage;
    @NotNull
    private Integer productPrice;
}