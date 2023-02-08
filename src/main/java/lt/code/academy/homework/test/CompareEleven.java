package lt.code.academy.homework.test;

/*import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class CompareEleven {
    private static final String ANSWER_FILE_NAME = "correct_answers.json";
    private static final String STUDENT_FILE_NAME = "student_file.json";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            // read JSON file 1
            Map<String, Object> map1 = mapper.readValue(new File(ANSWER_FILE_NAME), Map.class);

            // read JSON file 2
            Map<String, Object> map2 = mapper.readValue(new File(STUDENT_FILE_NAME), Map.class);

            // count equal values
            Map<String, Integer> counts = new HashMap<String, Integer>();
            for (String key : map1.keySet()) {
                if (map2.containsKey(key)) {
                    Object value1 = map1.get(key);
                    Object value2 = map2.get(key);

                    if (value1.equals(value2)) {
                        if (counts.containsKey(key)) {
                            int count = counts.get(key);
                            count++;
                            counts.put(key, count);
                        } else {
                            counts.put(key, 1);
                        }
                    }
                }
            }

            // print counts
            for (String key : counts.keySet()) {
                System.out.println(key + ": " + counts.get(key));
            }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
