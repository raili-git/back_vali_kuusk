package ee.valiit.back_vali_kuusk.business.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link ee.valiit.back_vali_kuusk.domain.userrole.user.User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest implements Serializable {
    @Size(max = 255)
    @NotNull
    private String username;
    @Size(max = 255)
    @NotNull
    private String password;
}