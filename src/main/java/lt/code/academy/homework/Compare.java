package lt.code.academy.homework;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Compare {
    private static final String ANSWER_FILE_NAME = "correct_answers.json";
    private static final String STUDENT_FILE_NAME = "student_file.json";

    public static void main(String[] args) {

        //sukuriu hashmap objekta i kuri saugosiu json elementus
        Map<String, String> firstJsonMap = new HashMap<>();
        Map<String, String> secondJsonMap = new HashMap<>();

        //skaitau teisingu atsakymu faila
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(ANSWER_FILE_NAME));
            var jsonObject = (JSONObject) obj;
            //reikia issaugoti json objektus i map
            firstJsonMap.put("correctAnswer", (String) jsonObject.get("correctAnswer"));

        }catch (IOException | ParseException e) {
            System.out.println("Klaida" + e.getMessage());
        }
        // skaitau atudento atsakymu faila
        try {
            Object obj = parser.parse(new FileReader(STUDENT_FILE_NAME));
            JSONObject jsonObject = (JSONObject) obj;
            secondJsonMap.put("correctAnswer", (String) jsonObject.get("correctAnswer"));
        }catch (IOException | ParseException e) {
            System.out.println("Klaida" + e.getMessage());
        }
        //palyginimas
        int count = 0;
        for (Map.Entry<String, String> entry : firstJsonMap.entrySet())
        {
            if(secondJsonMap.containsKey(entry.getKey()) &&
            secondJsonMap.get(entry.getKey()).equals(entry.getValue())) {
            }
            count++;
        }
        System.out.println(count);
    }


}
