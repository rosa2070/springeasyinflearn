package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // localhost:8080으로 들어오면 home.html이 호출됨
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
