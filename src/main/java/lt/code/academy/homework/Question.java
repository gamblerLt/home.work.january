package lt.code.academy.homework;

public class Question {
    private int id;
    private String question;
    private int correctAnswer;




    public Question(int id, String question, int correctAnswer) {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setAnswer(int answer) {
        this.correctAnswer = answer;
    }

    @Override
    public String toString() {
        return "CreateFile{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}

// 1: Idedu Jackson Dependency i Maven pom.xml
// 2: Sukuriu klase

