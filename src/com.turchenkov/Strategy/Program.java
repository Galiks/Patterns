package com.turchenkov.Strategy;

public class Program {
    public static void main(String[] args) {
        Car car = new Car(new PetrolCar());
        car.setMove(new ElectricCar());
        car.moving();
    }
}

interface Move{
    void move();
}

class PetrolCar implements Move{

    @Override
    public void move() {
        System.out.println("Use petrol");
    }
}

class ElectricCar implements Move{

    @Override
    public void move() {
        System.out.println("Use electricity");
    }
}

class Car{
    private Move move;

    Car(Move move) {
        this.move = move;
        System.out.print("this car ");
        this.move.move();
    }
    
    void moving(){
        move.move();
    }

    public Move getMove() {
        return move;
    }

    void setMove(Move move) {
        this.move = move;
    }
}
