package ee.valiit.back_vali_kuusk.business.product;

import ee.valiit.back_vali_kuusk.domain.product.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link Product} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTreeRequest implements Serializable {
    private Integer typeId;
    private Integer heightId;

    @NotNull
    private Integer price;
}