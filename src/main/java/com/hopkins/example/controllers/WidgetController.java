package com.hopkins.example.controllers;

import com.hopkins.example.repositories.WidgetRepo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WidgetController {

    private final WidgetRepo widgetRepo;

    public WidgetController(WidgetRepo widgetRepo) {
        this.widgetRepo = widgetRepo;
    }

    @GetMapping(value={"/", ""})
    public String home(Model model) {
        return "home";
    }

}
