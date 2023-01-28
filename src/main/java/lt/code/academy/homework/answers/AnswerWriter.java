package lt.code.academy.homework.answers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONObject;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnswerWriter {

    private static final String ANSWER_FILE_NAME = "correct_answers.json";

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        JSONObject objectAn = new JSONObject();


        objectAn.put("1 correct answer:", 2);
        objectAn.put("2 correct answer:", 4);
        objectAn.put("3 correct answer:", 6);
        objectAn.put("4 correct answer:", 8);
        objectAn.put("5 correct answer:", 10);
        objectAn.put("6 correct answer:", 12);
        objectAn.put("7 correct answer:", 14);
        objectAn.put("8 correct answer:", 16);
        objectAn.put("9 correct answer:", 18);
        objectAn.put("10 correct answer:", 20);



        try {
            File file = new File(ANSWER_FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            mapper.writeValue(file, List.of(objectAn));


            //JSONObject objectAnswer = new JSONObject();

            String correctAnswers = mapper.writeValueAsString(objectAn);

           /* List<JSONObject> objects = mapper.readValue(file, new TypeReference<>() {
            });
           System.out.println(objects);*/

            Map<String, Object> map = mapper.readValue(correctAnswers, new TypeReference<>() {
            });
            System.out.println(map.get("1 correct answer:"));
            System.out.println(map.get("2 correct answer:"));
            System.out.println(map.get("3 correct answer:"));
            System.out.println(map.get("4 correct answer:"));
            System.out.println(map.get("5 correct answer:"));
            System.out.println(map.get("6 correct answer:"));
            System.out.println(map.get("7 correct answer:"));
            System.out.println(map.get("8 correct answer:"));
            System.out.println(map.get("9 correct answer:"));
            System.out.println(map.get("10 correct answer:"));

        } catch (IOException e) {
            System.out.println("Klaida: " + e.getMessage());
        }


    }

}


