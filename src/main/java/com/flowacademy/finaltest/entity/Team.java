package com.flowacademy.finaltest.entity;

public class Team {
    String id;
    String name;
    Universe universe;
    Kind kind;

    enum Kind {
        VILLAIN,
        HERO
    }

    enum Universe {
        MARVEL,
        DC
    }

}
