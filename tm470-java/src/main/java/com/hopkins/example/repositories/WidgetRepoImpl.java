package com.hopkins.example.repositories;

import com.hopkins.example.models.Widget;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class WidgetRepoImpl implements WidgetRepo {

    private static List<Widget> widgetList = new ArrayList<>();

    @Override
    public int add(Widget widget) {
            widget.setId(widgetList.size() + 1);
            widgetList.add(widget);
            return widget.getId();
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
    public List<Widget> all() {
        return widgetList;
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
