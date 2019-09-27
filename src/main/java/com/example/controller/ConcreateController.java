package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianp
 **/
@RestController
@RequestMapping("/")
public class ConcreateController {

    @GetMapping("concreateA/a")
    public String concreateA() {
        return "/concreateA/a success";
    }

    @GetMapping("concreateA/b")
    public String concreateA2b() {
        return "/concreateA/b success";
    }

    @GetMapping("concreateB/a")
    public String concreateB() {
        return "/concreateB/a success";
    }

    @GetMapping("concreateB/b")
    public String concreateB2b() {
        return "/concreateB/b success";
    }

    @GetMapping("concreateC/a")
    public String concreateC() {
        return "/concreateC/a success";
    }

    @GetMapping("concreateC/b")
    public String concreateC2b() {
        return "/concreateC/b success";
    }
}
