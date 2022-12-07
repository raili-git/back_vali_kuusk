package ee.valiit.back_vali_kuusk.business.login;


import ee.valiit.back_vali_kuusk.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Resource
    private LoginService loginService;


    @GetMapping("/login")
    @Operation(summary = "Logib teenusesse sisse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tagastab login objekti, kus sees on olemas kasutaja userId"),
            @ApiResponse(responseCode = "403", description = "Valed kasutaja rekvisiidid. Ebaõnnestunud sisselogimine", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        LoginResponse loginResponse = loginService.login(username, password);
        return loginResponse;
    }


    @GetMapping("/session")
    @Operation(summary = "See teenus annab kodulehe 'home' vaatesse saabujale 'sessionId', mida on vaja anonüümse ostu sooritamiseks")
    public SessionResponse getNewSessionHash() {
        return loginService.getNewSessionHash();
    }

}
