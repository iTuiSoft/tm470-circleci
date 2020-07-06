package com.hopkins.example.repositories;

import com.hopkins.example.models.Widget;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class WidgetRepoImpl implements WidgetRepo {

    private static List<Widget> widgetList = new ArrayList<>();

    @Override
    public boolean add(Widget widget) {
        if (widgetList.contains(widget)) {
            return false;
        } else {
            widgetList.add(widget);
            return true;
        }
    }

    @Override
    public Widget find(int id) {
        for (Widget widget:widgetList){
            if (widget.getId() == id) {
                return widget;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        for (Widget widget:widgetList){
            if (widget.getId() == id) {
                widgetList.remove(widget);
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return widgetList.size();
    }

    @Override
    public void clear() {
        widgetList.clear();
    }
}
