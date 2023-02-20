package lt.code.academy.homework.resulttest;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
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

public class Results {

    private static final String STUDENT_FINAL_FILE = "student_final.json";
    private static final String CORRECT_ANSWERS_FILE_NAME = "correct_answers_file.json";
    private static final String STUDENT_ANSWERS_FILE = "student_answers_file.json";
    private static final String STUDENT_FILE = "student_file.json";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(CORRECT_ANSWERS_FILE_NAME));
            Object obj2 = parser.parse(new FileReader(STUDENT_ANSWERS_FILE));
            Object student = parser.parse(new FileReader(STUDENT_FILE));

            JSONObject jsonObject = (JSONObject) obj;
            JSONObject jsonObject2 = (JSONObject) obj2;
            JSONObject jsonObject3 = (JSONObject) student;

            // Kelias i teisingus atsakymus ir studento atsakymus
            JSONArray correctAnswers = (JSONArray) jsonObject.get("corrAnswers");
            JSONArray studentAnswers = (JSONArray) jsonObject2.get("studentTest");


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
            System.out.println("Studentas " + "teisingai atsakė: " + grade + " % iš visų atsakymų.");
            System.out.println("Pažymys: " + score);

            String textScore = "Studento pažymys: ";
            String textGrade = "  Atsakyta teisingai procentų : ";

            File file = new File(STUDENT_FINAL_FILE);
            mapper.writeValue(file, List.of(student, jsonObject, jsonObject2, textScore, score, textGrade, grade));
            if (!file.exists()) {
                file.createNewFile();

            }

        } catch (JsonGenerationException eg) {
            System.out.println("Json generavimo klaida: " + eg.getMessage());
        } catch (JsonMappingException em) {
            System.out.println("Failo generavimo klaida" + em.getMessage());
        } catch (IOException e) {
            System.out.println("Kita klaida: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
