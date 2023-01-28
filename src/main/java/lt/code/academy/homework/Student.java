package lt.code.academy.homework;

import java.io.Serializable;

public record Student(String studentNumber, String name, String surname) implements Serializable {

    @Override
    public String toString() {
        return "Studentas{" +
                "Studento numeris:" + studentNumber + '\'' +
                ", Studento vardas: " + name + '\'' +
                ", Studento pavardė:" + surname + '\'' +
                '}';
    }
}

