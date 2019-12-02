package com.tutorials.hp.recyclerpagination.mRecycler;

public class NameModel {

    private String name;
    private String surname;

    public NameModel() {
    }
    //pardon :D ^^ olsutur  cons oluşturdum ^^hah tamam

    public NameModel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
