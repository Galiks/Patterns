package com.turchenkov.AbstractFactory;

public class Program {
    public static void main(String[] args) {
        Client hero;
        hero = new Client(new Ork());
        hero.hit();
        hero.run();

        hero = new Client(new Angel());
        hero.run();
        hero.hit();
    }
}

/**
 * Abstract product A
 */
abstract class Weapon {
    abstract void hit();
}

/**
 * Abstract product B
 */
abstract class Movement {
    abstract void move();
}

/**
 * Concrete product A
 */
class Bow extends Weapon {

    @Override
    void hit() {
        System.out.println("FIRE!");
    }
}

/**
 * Concrete product A
 */
class Sword extends Weapon {

    @Override
    void hit() {
        System.out.println("DIE!");
    }
}

/**
 * Concrete product B
 */
class Fly extends Movement {

    @Override
    void move() {
        System.out.println("I believe, I can fly!");
    }
}

/**
 * Concrete product B
 */
class Run extends Movement {

    @Override
    void move() {
        System.out.println("Run Forest Run!");
    }
}

/**
 * Abstract factory
 */
abstract class AbstractFactory {
    abstract Weapon createWeapon();

    abstract Movement createMovement();
}

/**
 * Concrete factory
 */
class Ork extends AbstractFactory {

    @Override
    Weapon createWeapon() {
        return new Sword();
    }

    @Override
    Movement createMovement() {
        return new Run();
    }
}

/**
 * Concrete factory
 */
class Angel extends AbstractFactory {

    @Override
    Weapon createWeapon() {
        return new Bow();
    }

    @Override
    Movement createMovement() {
        return new Fly();
    }
}

/**
 * Client. This class create persons
 */
class Client {
    private Weapon weapon;
    private Movement movement;

    Client(AbstractFactory factory) {
        this.weapon = factory.createWeapon();
        this.movement = factory.createMovement();
    }

    void run() {
        movement.move();
    }

    void hit() {
        weapon.hit();
    }
}