package lt.code.academy.homework;

import java.io.Serializable;

public record LoginStudentRec(String studentNumber, String name, String surname, String password) implements Serializable {
}
