package ee.valiit.back_vali_kuusk.business.registration;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class RegistrationController {

    @Resource
    private RegistrationService registrationService;

    @PostMapping("/registration")
    @Operation (summary = "...")
    public RegisterResponse registerNewUser(@RequestBody RegisterRequest request){
      return registrationService.registerNewUser(request);
    }

}
