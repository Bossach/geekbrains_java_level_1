package lesson_7;

public class Main {
	public static void main(String[] args) {
		Cat[] cats = new Cat[3];
		cats[0] = new Cat("Барсик", 3);
		cats[1] = new Cat("Пушок", 5);
		cats[2] = new Cat("Вася", 4);
		
		Plate plate = new Plate(10);
		
		for ( Cat cat : cats ) {
			cat.eat(plate);
		}
		
	}
}