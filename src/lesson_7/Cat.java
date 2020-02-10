package lesson_7;

public class Cat {

    private final String name;
    private int appetite;
    boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }
    
    public boolean getSatiety() {
    	return satiety;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if(plate.decreaseFood(appetite)) {
        	satiety = true;
        	System.out.println("Кот " + name + " покушал, теперь он сыт.");
        } else {
        	System.out.println("Кот " + name + " не покушал, ему не хватило еды");
        }
    }
}