package lt.code.academy.homework.answers;

import java.util.List;

public record Answers(int correctAnswer) {
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}

