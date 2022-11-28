package ee.valiit.back_vali_kuusk.business.login;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;


    @GetMapping("/login")
    @Operation (summary = "Logib teenusesse sisse")

    public void login(@RequestParam String username, @RequestParam String password) {
      loginService.login (username,password);

    }

}
