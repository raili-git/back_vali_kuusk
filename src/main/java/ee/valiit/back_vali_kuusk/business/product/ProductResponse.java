package ee.valiit.back_vali_kuusk.business.product;

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
public class ProductResponse implements Serializable {
    private Integer productId;
    private Integer typeId;
    @Size(max = 255)
    @NotNull
    private String typeName;
    private Integer heightId;
    @Size(max = 255)
    @NotNull
    private String heightGap;
    @Size(max = 1)
    @NotNull
    private String productStatus;
    @NotNull
    private byte[] productImage;
    @NotNull
    private Integer productPrice;
}