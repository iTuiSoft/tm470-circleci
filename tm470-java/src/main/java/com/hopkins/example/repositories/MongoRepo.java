package com.hopkins.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hopkins.example.models.Widget;

public interface MongoRepo extends MongoRepository<Widget, Integer> {
}
