package lt.code.academy.homework.answers;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CorrectAnswersWriter {
    private static final String CORRECT_ANSWERS_FILE_NAME = "correct_answers_file.json";

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Integer> correctAnswers = new ArrayList<>();
        correctAnswers.add(2);
        correctAnswers.add(4);
        correctAnswers.add(6);
        correctAnswers.add(8);
        correctAnswers.add(10);
        correctAnswers.add(12);
        correctAnswers.add(14);
        correctAnswers.add(16);
        correctAnswers.add(18);
        correctAnswers.add(20);

        CorrAnswer corrAnswer = new CorrAnswer();
        corrAnswer.setCorrAnswers(correctAnswers);

        try {

            objectMapper.writeValue(new File(CORRECT_ANSWERS_FILE_NAME), corrAnswer);
            System.out.println("JSON failas sukurtas");

        } catch (JsonGenerationException e) {
            System.out.println("Failo kurimo klaida" + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Object meperio problema" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Kita klaida" + e.getMessage());
        }
    }
}

class CorrAnswer {
    private List<Integer> corrAnswers;

    public List<Integer> getCorrAnswers() {
        return corrAnswers;
    }

    public void setCorrAnswers(List<Integer> corrAnswers) {
        this.corrAnswers = corrAnswers;
    }
}