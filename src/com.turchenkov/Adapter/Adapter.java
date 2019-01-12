package com.turchenkov.Adapter;

interface Transport {
    void drive();
}

interface Animal {
    void move();
}

class Driver {
    void travel(Transport transport) {
        transport.drive();
    }
}

class Auto implements Transport {
    @Override
    public void drive() {
        System.out.println("I drive car");
    }
}

class Camel implements Animal {
    @Override
    public void move() {
        System.out.println("I ride camel");
    }
}

class Adapter implements Transport {

    private Camel camel;

    Adapter(Camel camel) {
        this.camel = camel;
    }

    @Override
    public void drive() {
        camel.move();
    }
}

class Program {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Auto auto = new Auto();
        driver.travel(auto);

        Camel camel = new Camel();
        Transport transport = new Adapter(camel);
        driver.travel(transport);
    }
}
