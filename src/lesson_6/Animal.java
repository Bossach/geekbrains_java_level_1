package lesson_6;

public abstract class Animal {
    protected int MAX_RUN_DISTANCE;
    protected int MAX_SWIM_DISTANCE;
    protected double MAX_JUMP_HEIGHT;

    private String name;
    private String color;
    private int age;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public boolean run(int distance) {
        System.out.println(this.getClass() + " with name \"" + getName() + "\" trying to run " + distance + " meters.");
        if (distance != 0 && Math.abs(distance) <= MAX_RUN_DISTANCE) {
            System.out.println("Run successful");
            return true;
        } else {
            System.out.println("Run failed");
            return false;
        }
    }

    public boolean swim(int distance) {
        System.out.println(this.getClass() + " with name \"" + getName() + "\" trying to swim " + distance + " meters.");
        if (distance != 0 && Math.abs(distance) <= MAX_SWIM_DISTANCE) {
            System.out.println("Swim successful");
            return true;
        } else {
            System.out.println("Swim failed");
            return false;
        }
    }

    public boolean jump(double height) {
        System.out.println(this.getClass() + " with name \"" + getName() + "\" trying to jump on " + height + " meters.");
        if (height > 0 && height <= MAX_JUMP_HEIGHT) {
            System.out.println("Jump successful");
            return true;
        } else {
            System.out.println("Jump failed");
            return false;
        }
    }
}
