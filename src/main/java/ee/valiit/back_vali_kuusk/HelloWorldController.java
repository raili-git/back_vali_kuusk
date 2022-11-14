package ee.valiit.back_vali_kuusk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello/world")
    public String helloWorld() {
        return "HELLOOOOO WOOORLD!!!!!";
    }
}
