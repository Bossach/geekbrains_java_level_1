package lesson_6;

import java.util.Random;

public class Cat extends Animal {
    public Cat(String name, String color, int age) {
        super(name, color, age);
        Random rand = new Random();
        MAX_RUN_DISTANCE = 200 + (rand.nextInt(100) - 50);
        MAX_SWIM_DISTANCE = 0;
        MAX_JUMP_HEIGHT = 2 + ((rand.nextDouble() * 0.5) - 0.25);
    }
}
