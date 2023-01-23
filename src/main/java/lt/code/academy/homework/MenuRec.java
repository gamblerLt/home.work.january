package lt.code.academy.homework;

import java.io.Serializable;

public record MenuRec (String studentNumber, String name, String surname) implements Serializable {
}

