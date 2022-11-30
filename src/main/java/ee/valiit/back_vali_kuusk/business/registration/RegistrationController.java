package ee.valiit.back_vali_kuusk.business.registration;

import ee.valiit.back_vali_kuusk.business.login.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class RegistrationController {

    @Resource
    private RegistrationService registrationService;

    @PostMapping("/registration")
    @Operation (summary = "Selle teenusega saab registreerida uue kasutaja, kui kasutajanimi on juba kastusel, viskab vea")
    public LoginResponse registerNewUser(@RequestBody RegisterRequest request){
        LoginResponse loginResponse = registrationService.registerNewUser(request);
        return loginResponse;


    }

}
