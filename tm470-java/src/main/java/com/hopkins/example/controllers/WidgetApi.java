package com.hopkins.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hopkins.example.models.Widget;
import com.hopkins.example.repositories.WidgetRepo;

@Controller
@RequestMapping(value = "/external")
public class WidgetApi {

    private final WidgetRepo widgetRepo;

    public WidgetApi(WidgetRepo widgetRepo) {
        this.widgetRepo = widgetRepo;
    }

    @GetMapping("/widget/{id}")
    public ResponseEntity<Widget> getWidget(@PathVariable int id) {

        if (widgetRepo.find(id) != null) {
            return ResponseEntity.ok(widgetRepo.find(id));
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/widgets/")
    public ResponseEntity<Object> getAllWidgets() {
        return ResponseEntity.ok(widgetRepo.all());
    }

    @PostMapping("/widget/add")
    public ResponseEntity<Object> addWidget(@RequestBody Widget newWidget){
        int newId = widgetRepo.add(newWidget);
        return ResponseEntity.ok(newId);

    }
}
