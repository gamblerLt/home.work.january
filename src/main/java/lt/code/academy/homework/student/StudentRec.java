package lt.code.academy.homework.student;

import java.io.Serializable;

public record StudentRec(String stNumb, String stName, String stSurname) implements Serializable {

    @Override
    public String toString() {
        return "StudentRec{" +
                "Studento numeris='" + stNumb + '\'' +
                ", Vardas='" + stName + '\'' +
                ", Pavarde='" + stSurname + '\'' +
                '}';
    }
}
