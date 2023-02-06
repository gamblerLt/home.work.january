package lt.code.academy.homework.answers;

public record Answers(int id, String correctAnswer) {

    @Override
    public String toString() {
        return "Answers{" +
                "id=" + id +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}

