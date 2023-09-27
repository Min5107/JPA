package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!~");
        return "hello"; // hello.html 리턴
    }

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("data2", "GoodBye");
        return "index";
    }


}
