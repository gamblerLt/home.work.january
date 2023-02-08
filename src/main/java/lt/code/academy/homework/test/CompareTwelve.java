package lt.code.academy.homework.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompareTwelve {
    private static final String ANSWER_FILE_NAME = "correct_answers.json";
    private static final String STUDENT_FILE_NAME = "student_file.json";

    public static void main(String[] args) throws IOException, ParseException {
        Object ob1 = new JSONParser().parse((new FileReader(ANSWER_FILE_NAME)));
        JSONObject jo1 = new JSONObject();

        Object ob2 = new JSONParser().parse(new FileReader(STUDENT_FILE_NAME));
        JSONObject jo2 = new JSONObject();

        JSONArray ja1 = (JSONArray) jo1.get("values");
        JSONArray ja2 = (JSONArray) jo2.get("values");

        String[] arr1 = new String[ja1.size()];
        for (int i = 0; i < ja1.size(); i++)
            arr1[i] = (String) ja1.get(i);

        String[] arr2 = new String[ja2.size()];
        for (int i = 0; i < ja2.size(); i++)
            arr2[i] = (String) ja2.get(i);

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j]))
                    System.out.println(arr1[i]);
            }
        }
    }
}
