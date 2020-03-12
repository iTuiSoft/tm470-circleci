package com.hopkins.example.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Widget {

    private String name;
    private String purpose;
    private int size;
    private int id;

}
