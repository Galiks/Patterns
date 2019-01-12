package com.turchenkov.FactoryMethod;

public class Program {

    public static void main(String[] args) {
        Developer developer = new WoodDeveloper("MosCOW");
        House house = developer.build();
    }
}

/**
 * Creator
 */
abstract class Developer {
    private String name;

    Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract House build();
}

class PanelDeveloper extends Developer{
    public PanelDeveloper(String name) {
        super(name);
    }

    @Override
    House build() {
        return new PanelHouse();
    }
}

class WoodDeveloper extends Developer{

    WoodDeveloper(String name) {
        super(name);
    }

    @Override
    House build() {
        return new WoodHouse();
    }
}


/**
 * Product
 */
abstract class House {
    House() {
    }
}

class PanelHouse extends House{
    PanelHouse() {
        System.out.println("Panel House");
    }
}

class WoodHouse extends House{
    WoodHouse() {
        System.out.println("Wood House");
    }
}