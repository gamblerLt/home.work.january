package lt.code.academy.homework.student;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMain {
    private static final String STUDENT_REC_FILE = "student_file.json";
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Map<Integer, Integer> studentAnswers = new HashMap<>();
        studentAnswers.put(1, 2);
        studentAnswers.put(2, 4);
        studentAnswers.put(3, 6);
        studentAnswers.put(4, 5);
        studentAnswers.put(5, 10);
        studentAnswers.put(6, 7);
        studentAnswers.put(7, 14);
        studentAnswers.put(8, 9);
        studentAnswers.put(9, 18);
        studentAnswers.put(10, 11);
        studentAnswers.put(11, 22);
        studentAnswers.put(12, 15);
        studentAnswers.put(13, 26);
        studentAnswers.put(14, 41);
        studentAnswers.put(15, 30);

        Student student = new Student();
        student.setId(1);
        student.setStudentNumber(254);
        student.setName("Algis");
        student.setSurname("Pavardauskas");

        try{
            File file = new File(STUDENT_REC_FILE);
            mapper.writeValue(file, List.of(student, studentAnswers));
            if(!file.exists()) {
                file.createNewFile();


            }
            /*StudentMain readValue = mapper.readValue(file, StudentMain.class);
            System.out.println(readValue);
*/
        }catch (JsonGenerationException eg) {
            System.out.println("Json generavimo klaida: " + eg.getMessage());
        }catch (JsonMappingException em) {
            System.out.println("Klaida" + em.getMessage());
        }catch (IOException e) {
            System.out.println("Klaida: " + e.getMessage());
        }

    }

}
