package ee.valiit.back_vali_kuusk.business.user;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping
public class ProfileController {
    @Resource
    private ProfileService profileService;

    @PostMapping("/profile-info")
    @Operation(summary = " Selle teenusega saab müüja lisada oma kontaktandmed")
    public void addProfileInfo(@RequestBody @Valid ProfileRequest request) {
        profileService.addProfileInfo(request);
    }
}
