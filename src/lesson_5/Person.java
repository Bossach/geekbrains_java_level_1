package lesson_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Person {
    private static ArrayList<Person> allPersons = new ArrayList<Person>();  //тут хранятся все созданные объекты
    private static int idCounter;  //Нужен чтобы присваивать уникальный id
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    private int id;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.id = idCounter++; //Присваиваем id
        allPersons.add(this);   //Записываем в массив
    }

    public static List<Person> getAllPersons() {
        return new ArrayList<Person>(allPersons);
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public static Person getPersonById(int id) {
        List<Person> list = allPersons.stream().filter(x -> x.id == id).collect(Collectors.toList());
        if (list.size() != 0) {
            /*Думаю не самое изящное решение, если один id окажется у некольких сотрудников, (чего по идее
            никак не должно случиться) то метод вернёт только первого найденного с данным id*/
            return list.get(0);
        }
        return null;
    }

    public static void deletePersonById(int id) {
        Person person = getPersonById(id);
        if (person == null) {
            System.out.println("Invalid id.");
            return;
        }
        System.out.print(person + "\n^Удалить \"" + person.name +
                "\" из списка? (Напишите \"удалить\" для подтверждения): ");
        Scanner scan = new Scanner(System.in);
        if (scan.nextLine().toLowerCase().equals("удалить")) {
            allPersons.remove(person);
            System.out.println("Запись \"" + person.name + "\" удалена.");
            return;
        }
        System.out.println("Удаление отменено.");
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Id" + id + ": " + name + ", " + position + ", e-mail: " + email +
                ", телефон: " + phone + ", з/п: " + salary + ", возраст: " + age;
    }
}
