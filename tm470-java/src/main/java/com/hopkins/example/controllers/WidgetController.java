package com.hopkins.example.controllers;

import com.hopkins.example.models.Widget;
import com.hopkins.example.repositories.WidgetRepo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WidgetController {

    private final WidgetRepo widgetRepo;

    public WidgetController(WidgetRepo widgetRepo) {
        this.widgetRepo = widgetRepo;

        Widget widget1 = Widget.builder()
            .name("Widget1")
            .purpose("Bootstrapping the database")
            .size(4)
            .id(1)
            .build();

        Widget widget2 = Widget.builder()
            .name("Widget2")
            .purpose("Bootstrapping the database more")
            .size(2)
            .id(2)
            .build();

        widgetRepo.add(widget1);
        widgetRepo.add(widget2);
    }

    @GetMapping(value={"/", ""})
    public String home() {
        return "home";
    }

    @GetMapping("/widget/{id}")
    public String viewWidget(@PathVariable int id, Model model) {

        if (widgetRepo.find(id) != null) {
            model.addAttribute("widget", widgetRepo.find(id));
            return "widget";
        } else {
            return "404";
        }

    }

    @GetMapping("/widget/add")
    public String addWidget(Model model){
        model.addAttribute("widget", Widget.builder().build());
        return "add";
    }

    @PostMapping("/widget")
    public String saveWidget(@ModelAttribute Widget widget) {
        widgetRepo.add(widget);

        return "redirect:/widget/" + widget.getId();
    }


}
