package lt.code.academy.homework.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {
    public static void main(String[] args) {
        // Read the correct answers from the correctAnswers.json file
        List<String> correctAnswers = readJsonFile("question.json");

        // Read the student answers from the studentAnswers.json file
        List<String> studentAnswers = readJsonFile("answer.json");

        // Calculate the grade
        int grade = 0;
        for (int i = 0; i < correctAnswers.size(); i++) {
            if (correctAnswers.get(i).equals(studentAnswers.get(i))) {
                grade++;
            }
        }

        // Write the grade to the grades.json file
        writeJsonFile(grade);
    }

    private static List<String> readJsonFile(String fileName) {
        List<String> answers = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(fileName);
            Object obj = parser.parse(reader);
            JSONArray answerArray = (JSONArray) obj;
            for (int i = 0; i < answerArray.size(); i++) {
                answers.add((String) answerArray.get(i));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private static void writeJsonFile(int grade) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("grade", grade);
        try (FileWriter writer = new FileWriter("grades.json")) {
            writer.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}