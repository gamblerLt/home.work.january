package lt.code.academy.homework.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonGrader {

    public static void main(String[] args) {

        String correctAnswersFile = "question.json";
        String studentsAnswersFile = "answer.json";
        String outputFile = "grades.json";

        // Parse both files
        List<String> correctAnswers = parseJsonFile(correctAnswersFile);
        List<String> studentsAnswers = parseJsonFile(studentsAnswersFile);

        // Grade the student's answers
        List<Double> grades = gradeAnswers(correctAnswers, studentsAnswers);

        // Write the grades to a json file
        writeJsonFile(grades, outputFile);

    }

    private static List<String> parseJsonFile(String filename) {

        List<String> answers = new ArrayList<String>();

        // Parse the json file
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(filename));
            JSONArray answersArr = (JSONArray) jsonObj.get("answers");

            for (Object answerObj : answersArr) {
                answers.add((String) answerObj);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return answers;
    }

    private static List<Double> gradeAnswers(List<String> correct, List<String> student) {
        List<Double> grades = new ArrayList<Double>();

        // Grade each answer
        for (int i = 0; i < correct.size(); i++) {
            String correctAnswer = correct.get(i);
            String studentAnswer = student.get(i);

            if (correctAnswer.equals(studentAnswer)) {
                grades.add(1.0);
            } else {
                grades.add(0.0);
            }
        }

        return grades;
    }

    private static void writeJsonFile(List<Double> grades, String filename) {
        JSONArray gradesArr = new JSONArray();

        // Add grades to json array
        for (double grade : grades) {
            gradesArr.add(grade);
        }

        // Add json array to json object
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("grades", gradesArr);

        try {
            // Write to json file
            FileWriter file = new FileWriter(filename);
            file.write(jsonObj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
