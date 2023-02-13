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

public class Playground {

    private static final String STUDENT_FINAL_FILE = "student_final.json";
    private static final String COR_FILE = "cor.json";
    private static final String STU_FILE = "stu.json";
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
            Object obj = parser.parse(new FileReader(COR_FILE));
            Object obj2 = parser.parse(new FileReader(STU_FILE));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject jsonObject2 = (JSONObject) obj2;

            // Kelias i teisingus atsakymus ir studento atsakymus
            JSONArray correctAnswers = (JSONArray) jsonObject.get("correctAnswers");
            JSONArray studentAnswers = (JSONArray) jsonObject2.get("studentAnswers");


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
            System.out.println("Studentas" + "teisingai atsakė: " + grade + " % iš visų atsakymų.");


            String textScore = "Jūsų pažymys: ";
            String textGrade = "  Surinkote procentų: ";


            File file = new File(STUDENT_FINAL_FILE);
            mapper.writeValue(file, List.of(student, jsonObject, jsonObject2 ,textScore, score, textGrade, grade));
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
