package com.hopkins.example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.hopkins.example.models.Widget;

import lombok.AllArgsConstructor;

@Repository
@Profile("prod")
@AllArgsConstructor
public class WidgetRepoMongo implements WidgetRepo {

    private MongoRepo mongoRepository;

    @Override
    public int add(Widget widget) {
            widget.setId((int) (mongoRepository.count() + 1));
            mongoRepository.save(widget);
            return widget.getId();

    }

    @Override
    public Widget find(int id) {
        Optional<Widget> result =  mongoRepository.findById(id);
        return result.get();
    }

    @Override
    public boolean delete(int id) {
        if (mongoRepository.existsById(id)) {
            mongoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Widget> all() {
        return mongoRepository.findAll();
    }

    @Override
    public int count() {
        return (int) mongoRepository.count();
    }

    @Override
    public void clear() {
        mongoRepository.deleteAll();
    }
}
