package com.zhang.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @create 2019-01-14 14:16
 **/
public class Demo5 {
    public static void main(String[] args) {

        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

//        javaProgrammers.forEach(
//                javaProgrammer -> javaProgrammer.setAge(javaProgrammer.getAge() + 1)
//        );

//        javaProgrammers.stream().forEach(
//                javaProgrammer -> javaProgrammer.setAge(javaProgrammer.getAge() + 1)
//        );

        javaProgrammers.stream().filter(
                javaProgrammer -> javaProgrammer.getGender().equals("female")
        );

        System.out.println("======================");

        javaProgrammers.forEach(javaProgrammer -> System.out.println(javaProgrammer));


    }
}
