package com.turchenkov.Decorator;

abstract class Pizza{
    private String name;
    public abstract int getCost();

    Pizza(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
}

class ItalianPizza extends Pizza{


    ItalianPizza() {
        super(ItalianPizza.class.getSimpleName());
    }

    @Override
    public int getCost() {
        return 10;
    }
}

class BulgerianPizza extends Pizza{
    public BulgerianPizza() {
        super(BulgerianPizza.class.getClass().getName());
    }

    @Override
    public int getCost() {
        return 8;
    }
}

abstract class Decorator extends Pizza{

    Pizza pizza;

    Decorator(String name, Pizza pizza) {
        super(name);
        this.pizza = pizza;
    }
}

class CheesePizza extends Decorator{
    CheesePizza(Pizza pizza) {
        super(pizza.getName() + " with cheese", pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 3;
    }
}

class TomatoPizza extends Decorator{
    TomatoPizza(Pizza pizza) {
        super(pizza.getName() + " with tomato", pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 5;
    }
}


class Program{
    public static void main(String[] args) {
        Pizza italianPizza = new ItalianPizza();
        System.out.println(italianPizza.getName());
        italianPizza = new TomatoPizza(italianPizza);
        System.out.println(italianPizza.getName());
        italianPizza = new CheesePizza(italianPizza);
        System.out.println(italianPizza.getName());
    }
}