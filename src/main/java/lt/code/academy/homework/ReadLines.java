package lt.code.academy.homework;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;

public class ReadLines {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("questions.json"));
            JSONObject jsonObject = new (JSONObject) obj;

            int id = (id) = jsonObject.get(id);


        }catch (IOException e) {
            System.out.println("Nenuskaiciau: " + e.getMessage());
        }

//public record MenuRec (String studentNumber, String name, String surname) implements Serializable {
//}


    }
}

/*
JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("test.json"));
            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray lines = (JSONArray) jsonObject.get("lines");
            Iterator<String> iterator = lines.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}





+++++

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParseJsonFile {

    public static void main(String[] args) throws IOException, JSONException {

        // Create a BufferedReader to read a json file
        FileReader fileReader = new FileReader("users.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Read file line by line
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            // Parse each line into a JSONObject
            JSONObject jsonObject = new JSONObject(line);

            // Get values from the JSONObject
            String userId = jsonObject.getString("userId");
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");
            String phone = jsonObject.getString("phone");

            // Print values from the JSONObject
            System.out.println("userId: " + userId);
            System.out.println("name: " + name);
            System.out.println("email: " + email);
            System.out.println("phone: " + phone);
            System.out.println("--------------------------------");
        }

        // Close the BufferedReader
        bufferedReader.close();
    }
}
*/