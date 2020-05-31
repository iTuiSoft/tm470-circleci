package com.hopkins.example.repositories;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hopkins.example.models.Widget;

public interface WidgetRepo {

    boolean add(Widget widget);

    Widget find(int id);

    boolean delete(int id);

    int count();

    void clear();

    List<Widget> all();
}
