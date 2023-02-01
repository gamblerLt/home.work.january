package lt.code.academy.homework.answers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AnswerWriter {

    private static final String QACA_FILE_NAME = "questions_answers_correct_answers.json";

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Integer> correcAnswer = new ArrayList<>();
        correcAnswer.add(2);
        correcAnswer.add(4);
        correcAnswer.add(6);
        correcAnswer.add(8);
        correcAnswer.add(10);
        correcAnswer.add(12);
        correcAnswer.add(14);
        correcAnswer.add(16);
        correcAnswer.add(18);
        correcAnswer.add(20);

        try {
            File file = new File(QACA_FILE_NAME);
            objectMapper.writeValue(new File(QACA_FILE_NAME), correcAnswer);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
