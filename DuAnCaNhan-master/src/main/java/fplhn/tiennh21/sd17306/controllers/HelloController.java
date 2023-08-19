package fplhn.tiennh21.sd17306.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    // @RequestMapping(value="hello", method = RequestMethod.GET)
    // @PostMapping
    @GetMapping("hello")
    public String hello(Model model)
    {
        model.addAttribute("name", "FPL HN");
        return "hello";
    }
}
