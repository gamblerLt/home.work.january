package lt.code.academy.homework.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;

public class ReadAll {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File("allanswers.json"));
            JsonNode correctAnswers = root.path("correctAnswers");
            JsonNode studentAnswers = root.path("studentAnswers");

            System.out.println("Teisingi atsakymai: " + correctAnswers.toString());
            System.out.println("Studento atsakymai: " + studentAnswers.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
