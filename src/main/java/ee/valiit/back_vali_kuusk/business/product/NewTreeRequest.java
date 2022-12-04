package ee.valiit.back_vali_kuusk.business.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link ee.valiit.back_vali_kuusk.domain.product.product.Product} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewTreeRequest implements Serializable {
    private Integer typeId;
    private Integer heightId;
//    @NotNull
//    private byte[] productImage;
    @NotNull
    private Integer productPrice;
    private Integer userId;
    private Integer userContactId;
    private Integer addressId;
    private Integer countyId;
}