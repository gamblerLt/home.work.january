package lt.code.academy.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CompareTen {
    private static final String STUDENT_FILE_NAME = "student_file.json";
    private static final String ANSWER_FILE_NAME = "correct_answers.json";

    public static void main(String[] args) {
        CompareTen ten = new CompareTen();
        List<String> answers = List.of();

        try (BufferedReader br = new BufferedReader(new FileReader(ANSWER_FILE_NAME))) {
            answers = br.lines()
                    .sorted()
                    .toList();
        }catch (IOException e) {
            System.out.println("Klaida" + e.getMessage());
        }
        answers.forEach(System.out::println);
    }

    private String showAnswers(String line) {
        String[] items = line.split(":");
        if (items.length < 2) {
            return null;
        }
        return items [0];
    }
}
