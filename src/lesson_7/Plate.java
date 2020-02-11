package lesson_7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println(this);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
    
    public void addFood(int food) {
    	this.food += food;
    }

    public boolean decreaseFood(int n) {
    	if (this.food >= n) {
        	this.food -= n;
        	return true;
    	} else {
    		return false;
    	}
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}