package me.jumen.demospringbootmvc.user;

import org.springframework.web.bind.annotation.*;

@RestController // @ResponseBody를 갖고있음
public class UserController {

    //@ResponseBody를 생략할 수 있다 -> StringMessageConverter
    //@Controller + @ResponseBody가 없는 경우 -> return string을 BeanNameViewResolver string에 해당하는 view를 찾으려고 한다
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user) {
        return user;
    }
}
