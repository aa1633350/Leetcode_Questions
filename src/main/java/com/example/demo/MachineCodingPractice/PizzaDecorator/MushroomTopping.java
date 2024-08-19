package com.example.demo.MachineCodingPractice.PizzaDecorator;

public class MushroomTopping extends BasePizzaDecorator {
    BasePizza basePizza;

    public MushroomTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    int cost() {
        return this.basePizza.cost() + 10;
    }
}
