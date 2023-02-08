package lt.code.academy.homework.studentanswers;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerStudent {

    private static final String ANSWER_FILE_NAME = "answer.json";
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Answer answer = new Answer();
        answer.setId1(1);
        answer.setStudentAnswer1(1);
        answer.setId2(2);
        answer.setStudentAnswer2(2);
        answer.setId3(3);
        answer.setStudentAnswer3(1);
        answer.setId4(4);
        answer.setStudentAnswer4(2);
        answer.setId5(5);
        answer.setStudentAnswer5(1);
        answer.setId6(6);
        answer.setStudentAnswer6(3);
        answer.setId7(7);
        answer.setStudentAnswer7(2);
        answer.setId8(8);
        answer.setStudentAnswer8(2);
        answer.setId9(9);
        answer.setStudentAnswer9(1);
        answer.setId10(10);
        answer.setStudentAnswer10(3);

        try {
            mapper.writeValue(new File(ANSWER_FILE_NAME), answer);

        } catch (JsonGenerationException e) {
            System.out.println("Failo kurimo klaida" + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Kita klaida" + e.getMessage());
        }

    }
}
