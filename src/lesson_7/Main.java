package lesson_7;

public class Main {
	public static void main(String[] args) {
		Cat[] cats = new Cat[3];
		cat[0] = new Cat("Барсик", 3);
		cat[1] = new Cat("Пушок", 5);
		cat[2] = new Cat("Вася", 4);
		
		Plate plate = new Plate(10);
		
		for ( Cat cat : cats ) {
			cat.eat(plate);
		}
		
	}
}