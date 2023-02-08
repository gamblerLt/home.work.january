package lt.code.academy.homework.test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class CompareTwo {
    private static String ANSWER_FILE_NAME = "correct_answers.json";
    private static String STUDENT_FILE_NAME = "student_file.json";

   public static void main(String[] args) {

       JSONParser parser = new JSONParser();

       try {
           // Read JSON file 1
           Object obj1 = parser.parse(new FileReader(ANSWER_FILE_NAME));
           JSONObject jsonObj1 = (JSONObject) obj1;

           // Read JSON file 2
           Object obj2 = parser.parse(new FileReader(STUDENT_FILE_NAME));
           JSONObject jsonObj2 = (JSONObject) obj2;

           // Count equals
           int countEquals = 0;
           for (Object key : jsonObj1.keySet()) {
               // Check if key is present in JSON2
               if (jsonObj2.containsKey(key)) {
                   // Check if value is equal
                   if (jsonObj1.get(key).equals(jsonObj2.get(key))) {
                       countEquals++;
                   }
               }
           }

           System.out.println("Number of equal keys: " + countEquals);

       } catch (IOException | ParseException e) {
           e.printStackTrace();
       }

    }
}
