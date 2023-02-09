package lt.code.academy.homework.test;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Grader {
    public static void main(String[] args) {
        // Read the JSON file
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("allanswers.json"));
            JSONObject jsonObject = (JSONObject) obj;

            // Skaičiuoju teisingus studento atsakymus
            JSONArray correctAnswers = (JSONArray) jsonObject.get("correctAnswers");
            JSONArray studentAnswers = (JSONArray) jsonObject.get("studentAnswers");

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
