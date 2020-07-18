package com.hopkins.example.repositories;

import com.hopkins.example.models.Widget;

public interface WidgetRepo {

    boolean add(Widget widget);

    Widget find(int id);

    boolean delete(int id);

    int count();

    void clear();

}
