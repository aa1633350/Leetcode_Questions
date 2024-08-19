package com.example.demo.MachineCodingPractice.PizzaDecorator;

public class CheeseTopping extends BasePizzaDecorator{

    BasePizza basePizza;

    public CheeseTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    int cost() {
        return this.basePizza.cost() + 20;
    }
}
