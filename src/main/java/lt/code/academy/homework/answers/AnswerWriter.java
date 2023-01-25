package lt.code.academy.homework.answers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class AnswerWriter {

    private static final String ANSWER_FILE_NAME = "C:\\Users\\Kompiuteris\\Documents\\GitHub\\WurkHome\\home.work.january\\src\\main\\java\\lt\\code\\academy\\homework\\files\\correct_answers.txt";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        AnswerWriter answerWriter = new AnswerWriter();
        answerWriter.readAnswers();

        Answers answerOne = new Answers(2);
        Answers answerTwo = new Answers(4);
        Answers answerThree = new Answers(6);
        Answers answerFour = new Answers(8);
        Answers answerFive = new Answers(10);
        Answers answerSix = new Answers(12);
        Answers answerSeven = new Answers(14);
        Answers answerEight = new Answers(16);
        Answers answerNine = new Answers(18);
        Answers answerTen = new Answers(20);

        File file = null;
        try {
            file = new File(ANSWER_FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Turime problemų su failu: " + ANSWER_FILE_NAME + " " + e.getMessage());
        }

        try {
            mapper.writeValue(file, List.of(answerOne, answerTwo, answerThree, answerFour,
                    answerFive, answerSix, answerSeven, answerEight, answerNine, answerTen));
        } catch (IOException ee) {
            System.out.println("Turime problemų su įrašymu: " + ee.getMessage());
        }

    }

    //sita kelti i kita klase
    private static void readAnswers() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ANSWER_FILE_NAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException eee) {
            System.out.println("Skaitymo iš failo klaida: " + eee.getMessage());

        }
    }
}


