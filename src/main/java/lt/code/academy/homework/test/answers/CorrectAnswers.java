package lt.code.academy.homework.test.answers;

import java.io.Serializable;


public class CorrectAnswers implements Serializable {
    int id;
    int correctAnswer;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

