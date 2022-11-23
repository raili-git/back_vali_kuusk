package ee.valiit.back_vali_kuusk.domain.product.county;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link County} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountyDto implements Serializable {
    private Integer countyId;
    @Size(max = 255)
    @NotNull
    private String countyName;
}