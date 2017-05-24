package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Jbee on 2017. 5. 24..
 */
@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String main() {
        logger.debug("Welcome Github Agent");
        return "index";
    }
}
