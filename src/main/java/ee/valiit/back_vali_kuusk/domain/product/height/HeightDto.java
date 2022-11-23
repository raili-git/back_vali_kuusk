package ee.valiit.back_vali_kuusk.domain.product.height;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Height} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeightDto implements Serializable {
    private Integer heightId;
    @Size(max = 255)
    @NotNull
    private String heightGap;
}