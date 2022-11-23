package ee.valiit.back_vali_kuusk.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Type} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDto implements Serializable {
    private Integer typeId;
    @Size(max = 255)
    @NotNull
    private String typeName;
}