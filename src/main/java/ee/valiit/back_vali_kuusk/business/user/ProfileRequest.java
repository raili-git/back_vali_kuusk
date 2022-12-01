package ee.valiit.back_vali_kuusk.business.user;

import ee.valiit.back_vali_kuusk.domain.userrole.user.contact.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Contact} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest implements Serializable {

    @Size(max = 255)
    @NotNull
    private String phoneNumber;
    @Size(max = 255)
    @NotNull
    private String email;
    @Size(max = 255)
    @NotNull
    private String firstName;
    @Size(max = 255)
    @NotNull
    private String lastName;
    @NotNull
    @Min(1)
    private Integer addressCountyId;
    @Size(max = 255)
    @NotNull
    private String addressStreet;
}