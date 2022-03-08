package com.hanson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黄忠
 */
@RestController
public class HansonController {

    @GetMapping("/test")
    public String test() {
        return "hanson";
    }
}
