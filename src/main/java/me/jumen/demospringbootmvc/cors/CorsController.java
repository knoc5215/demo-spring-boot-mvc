package me.jumen.demospringbootmvc.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {

    //    @CrossOrigin(origins = "http://localhost:18080")    // 스키마, 호스트, 포트 -> WebMvcConfigurer 사용해서 global config 가능
    @GetMapping("/cors")
    public String cors() {
        return "cors test";
    }
}
