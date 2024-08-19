package com.example.demo.MachineCodingPractice.PizzaDecorator;

public class PizzaMaker {

    public static void main(String[] args) {
        BasePizza veggieDelight = new CheeseTopping(new VeggieDelight());
        System.out.println("Veggie Delight with Cheese Topping price "+ veggieDelight.cost());
        veggieDelight = new MushroomTopping(veggieDelight);
        System.out.println("Veggie Delight with Cheese and Mushroom Topping price "+ veggieDelight.cost());

    }
}
