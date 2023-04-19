package homework19_04;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /*
    Задача1
Есть класс Person с полями
String name
int age
String address
Используя стримы, написать метод, принимающий список персонов и возвращающий мапу, где возраст является ключом, а список персонов этого возраста значением

Задача2
Используя тот же класс Person, написать метод, принимающий список персонов и возвращающий общий возраст тех, кто старше 17 лет.

Задача 3
Написать метод, принимающий список персонов и возвращающий имена тех, кто является совершеннолетним в Германии (старше 18 лет).
Должна быть возвращена примерно следующая строка: in Germany Jack and John are of legal age (имена по вашему выбору, это пример)
     */
    public static void main(String[] args) {
        List<Person> list = List.of(new Person("Jack",15,"Bark 11"),new Person("Robert",27,"Liep 99"),
               new Person("Marshal",19,"Wins 43"),new Person("Ann",15,"Bucholz 78"),
                new Person("Lili",27,"Stephansplatz 52"));

        System.out.println(gruppingByAge(list));
        // OUTPUT: {19=[Marshal-Wins 43], 27=[Robert-Liep 99, Lili-Stephansplatz 52], 15=[Jack-Bark 11, Ann-Bucholz 78]}
        System.out.println(sumOfAge(list));
        // OUTPUT: 73
        System.out.println(legalAge(list));
        // OUTPUT: in Germany Robert and Marshal and Lili are of legal age

    }
    public static Map<Integer, List<Person>> gruppingByAge(List<Person> input){
       return input.stream().collect(Collectors.groupingBy(s -> s.getAge()));
    }
    public static int sumOfAge(List<Person>input){
       Optional<Integer> reduce = input.stream()
                .map(a -> a.getAge())
                .filter(a -> a > 17)
                .reduce((x, y) -> x + y);
       int result = reduce.get();
       return result;
    }
    public static String legalAge(List<Person> input){
     return   input.stream()
                .filter(a -> a.getAge() >= 18)
                .map(a -> a.getName())
                .collect(Collectors.joining(" and ","in Germany "," are of legal age"));
    }
}
