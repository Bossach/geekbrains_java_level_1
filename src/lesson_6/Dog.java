package lesson_6;

import java.util.Random;

public class Dog extends Animal {
    public Dog(String name, String color, int age) {
        super(name, color, age);
        Random rand = new Random();
        MAX_RUN_DISTANCE = 500 + (rand.nextInt(200) - 100);
        MAX_SWIM_DISTANCE = 10 + (rand.nextInt(4) - 2);
        MAX_JUMP_HEIGHT = 0.5 + ((rand.nextDouble() * 0.2) - 0.1);
    }
}
