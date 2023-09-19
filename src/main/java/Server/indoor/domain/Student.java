package Server.indoor.domain;

import lombok.Getter;

@Getter
public class Student {

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;
}
