package ee.valiit.back_vali_kuusk.domain.userrole.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Role} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {
    private Integer roleId;
    @Size(max = 50)
    @NotNull
    private String roleType;
}