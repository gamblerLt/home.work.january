package lt.code.academy.homework.answers;

public record Answers (String correctAnswer) {

    @Override
    public String toString() {
        return "Answers{" +
                "correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}

