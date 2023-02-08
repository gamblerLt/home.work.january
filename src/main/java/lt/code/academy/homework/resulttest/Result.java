package lt.code.academy.homework.resulttest;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Result {
    private static final String STUDENT_FILE = "student_file.json";
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Student student = new Student();
        student.setId(1);
        student.setStudentNumber(254);
        student.setName("Algis");
        student.setSurname("Pavardauskas");

        try{
            File file = new File(STUDENT_FILE);
            mapper.writeValue(file, List.of(student));
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
