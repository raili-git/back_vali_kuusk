package ee.valiit.back_vali_kuusk.business.photo;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/new-tree/new-photo", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhotoController {

//    @Resource
//    private PhotoService photoService;
//
//    @PostMapping()
//    @Operation (summary = "See teenus salvestab puu pildi andmebaasi kasutades 'productId' järgi")
//  public void addTreePhoto(@RequestBody PhotoDto request) {
//        photoService.addTreePhoto(request);
//    }

}
