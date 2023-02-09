package lt.code.academy.homework.resulttest;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Result {
    private static final String STUDENT_FILE = "student_file.json";
    private static final String ALL_ANSWERS_FILE = "allanswers.json";
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        JSONParser parser = new JSONParser();

        Student student = new Student();
        student.setId(1);
        student.setStudentNumber(254);
        student.setName("Algis");
        student.setSurname("Pavardauskas");



        try{
            Object obj = parser.parse(new FileReader(ALL_ANSWERS_FILE));
            JSONObject jsonObject = (JSONObject) obj;

            // Skaičiuoju teisingus studento atsakymus
            JSONArray correctAnswers = (JSONArray) jsonObject.get("correctAnswers");
            JSONArray studentAnswers = (JSONArray) jsonObject.get("studentAnswers");


            System.out.println("Teisingi atsakymai: " + correctAnswers.toString());
            System.out.println("Studento atsakymai: " + studentAnswers.toString());


            // Ivertinimas
            int score = 0;
            for (int i = 0; i < correctAnswers.size(); i++) {
                if (correctAnswers.get(i).equals(studentAnswers.get(i))) {
                    score++;
                }
            }

            // Ivertinimo skaiciavimas
            double grade = (double) score / correctAnswers.size() * 100;
            System.out.println("Studentas"+   "teisingai atsakė: " + grade + "% iš visų atsakymų.");

            File file = new File(STUDENT_FILE);
            mapper.writeValue(file, List.of(student));
            if(!file.exists()) {
                file.createNewFile();


            }

        }catch (JsonGenerationException eg) {
            System.out.println("Json generavimo klaida: " + eg.getMessage());
        }catch (JsonMappingException em) {
            System.out.println("Klaida" + em.getMessage());
        }catch (IOException e) {
            System.out.println("Klaida: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
