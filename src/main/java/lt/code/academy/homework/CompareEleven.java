package lt.code.academy.homework;

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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CompareEleven {
    private static final String ANSWER_FILE_NAME = "correct_answers.json";
    private static final String STUDENT_FILE_NAME = "student_file.json";

    public static void main(String[] args) {
        //sukuriu json parser
        JSONParser parser = new JSONParser();

        try {
            Object object1 = parser.parse(new FileReader(ANSWER_FILE_NAME));
            Object object2 = parser.parse(new FileReader(STUDENT_FILE_NAME));


            JSONObject jsonObject = new JSONObject();
            JSONObject jsonObject2 = new JSONObject();

            Map<String, Integer> map1 = new HashMap<String, Integer>();
            Map<String, Integer> map2 = new HashMap<String, Integer>();

            Iterator<String> iterator1 = jsonObject.keySet().iterator();
            while (iterator1.hasNext()) {
                String key1 = iterator1.next();
                Object value1 = jsonObject.get(key1);
                map1.put(key1, (Integer) value1);
            }
            Iterator<String> iterator2 = jsonObject2.keySet().iterator();
            while (iterator2.hasNext()) {
                String key2 = iterator2.next();
                Object value2 = jsonObject2.get(key2);
                map2.put(key2, (Integer) value2);
            }
            for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                String key1 = entry.getKey();
                Integer value1 = entry.getValue();
                if (map2.containsKey(key1)) {
                    Integer value2 = map2.get(key1);
                    if (value1.equals(value2)) {
                        System.out.println("Lygios reiksmes key1:" + key1);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nerastas failas" + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}



