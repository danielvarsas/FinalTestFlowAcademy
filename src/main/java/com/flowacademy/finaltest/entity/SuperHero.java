package com.flowacademy.finaltest.entity;

public class SuperHero {


    String id;
    String name;
    Universe universe; //to make Universe Class
    Team team; //tom make class

    enum Universe {
        MARVEL,
        DC
    }

    enum Kind {
        VILLAIN,
        HERO
    }

}
