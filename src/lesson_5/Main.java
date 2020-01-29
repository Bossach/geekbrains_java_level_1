package lesson_5;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Создаём сотрудников (при создании автоматически добавляются в статический массив класса)
        new Person("Иванов Иван", "директор", "boss@company.ru", "+79998887766", 75000, 54);
        new Person("Петров Олег", "гл. инженер", "petrov@company.ru", "+79762565244", 55000, 41);
        new Person("Олегов Пётр", "токарь", "workshop@company.ru", "+79034312171", 35000, 31);
        new Person("Кличко Людмила", "повар", "none", "+79264437659", 30000, 45);
        new Person("Бондарчук Станислав", "водитель", "none", "+79851757256", 40000, 26);

        Random rand = new Random();
        //Берём для примера id рандомного сотрудника
        int id = Person.getAllPersons().get(rand.nextInt(Person.getAllPersons().size())).getId();
        System.out.println("Выводим информацию о сотруднике с id " + id + " в консоль:");
        Person a = Person.getPersonById(id); //id сотруднику присваивается при создани
        a.print();
        //^эквивалентный вариант: System.out.println(a);

        System.out.println("выводим сотрудников старше 40 лет:");
        for (Person person : Person.getAllPersons()) {
            if (person.getAge() > 40) {
                System.out.println(person);
            }
        }
    }
}
