package lt.code.academy.homework;

import java.io.Serializable;

public record Student(String studentNumber, String name, String surname) implements Serializable {
    public Student {
    }


    @Override
    public String toString() {
        return "Studentas{" +
                "Studento numeris:" + studentNumber + '\'' +
                ", Studento vardas: " + name + '\'' +
                ", Studento pavardė:" + surname + '\'' +
                '}';
    }
}

/*class Record {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }*/