package lesson_6;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Иван", "жёлтый", 5);
        Dog dog = new Dog("Мухтар", "рыжий", 8);

        cat.run(200);
        dog.jump(0.5);
        cat.swim(5);
    }
}
