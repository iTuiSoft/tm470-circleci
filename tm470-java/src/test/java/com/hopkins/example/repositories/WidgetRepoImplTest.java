package com.hopkins.example.repositories;

import com.hopkins.example.models.Widget;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WidgetRepoImplTest {

    private static WidgetRepo widgetRepo;

    @BeforeAll
    static void setUp() {
        widgetRepo = new WidgetRepoImpl();
    }

    @BeforeEach
    void clear(){
        widgetRepo.clear();
    }

    @Test
    void add() {
        //Given
        Widget testWidget = Widget.builder()
            .name("TestWidget1")
            .purpose("Testing adding to the repo")
            .size(20)
            .id(1)
            .build();

        //When
        widgetRepo.add(testWidget);

        //Then
        assertEquals(1, widgetRepo.count());

    }

    @Test
    void find() {
        //Given
        Widget testWidget = Widget.builder()
            .name("TestWidget2")
            .purpose("Testing finding in the repo")
            .size(20)
            .build();

        int testId = widgetRepo.add(testWidget);

        //When
        Widget foundWidget = widgetRepo.find(testId);

        //Then
        assertEquals(testWidget, foundWidget);

    }

    @Test
    void delete() {
        //Given
        Widget testWidget = Widget.builder()
            .name("TestWidget1")
            .purpose("Testing deleting from the repo")
            .size(20)
            .build();

        Widget testWidget2 = Widget.builder()
            .name("TestWidget2")
            .purpose("Testing deleting from the repo")
            .size(20)
            .build();

        widgetRepo.add(testWidget);
        widgetRepo.add(testWidget2);

        //When
        widgetRepo.delete(1);

        //Then
        assertAll(
            () -> assertEquals(1, widgetRepo.count()),
            () -> assertEquals(null, widgetRepo.find(1)),
            () -> assertEquals(testWidget2, widgetRepo.find(2))
        );


    }
}