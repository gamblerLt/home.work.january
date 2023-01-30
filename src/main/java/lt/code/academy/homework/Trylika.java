package lt.code.academy.homework;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Trylika {
    private static final String ANSWER_FILE_NAME = "correct_answers.json";
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject =  (JSONObject) jsonParser.parse(new FileReader(ANSWER_FILE_NAME));
            String firstAnswer = (String) jsonObject.get("1 answer:");

            System.out.println(firstAnswer);
        } catch (ParseException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
