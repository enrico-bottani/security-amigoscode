package com.enricobottani.securityamigoscode.controller.templates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController {
    @GetMapping("/courses")
    public String getCourses() {
        return "courses";
    }
}
