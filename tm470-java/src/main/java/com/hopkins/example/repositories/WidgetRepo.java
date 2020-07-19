package com.hopkins.example.repositories;

import java.util.List;

import com.hopkins.example.models.Widget;

public interface WidgetRepo {

    int add(Widget widget);

    Widget find(int id);

    boolean delete(int id);

    int count();

    void clear();

    List<Widget> all();
}
