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


            objectAn.put("1 answer:", 2);
            objectAn.put("2 answer:", 4);
            objectAn.put("3 answer:", 6);
            objectAn.put("4 answer:", 8);
            objectAn.put("5 answer:", 10);
            objectAn.put("6 answer:", 12);
            objectAn.put("7 answer:", 14);
            objectAn.put("8 answer:", 16);
            objectAn.put("9 answer:", 18);
            objectAn.put("10 answer:", 20);



            try {
                File file = new File(ANSWER_FILE_NAME);
                if (!file.exists()) {
                    file.createNewFile();
                }

                mapper.writeValue(file, List.of(objectAn));


                String correctAnswers = mapper.writeValueAsString(objectAn);


                Map<String, Object> map = mapper.readValue(correctAnswers, new TypeReference<>() {
                });

                System.out.println(map.get("1 answer:"));
                System.out.println(map.get("2 answer:"));
                System.out.println(map.get("3 answer:"));
                System.out.println(map.get("4 answer:"));
                System.out.println(map.get("5 answer:"));
                System.out.println(map.get("6 answer:"));
                System.out.println(map.get("7 answer:"));
                System.out.println(map.get("8 answer:"));
                System.out.println(map.get("9 answer:"));
                System.out.println(map.get("10 answer:"));


            } catch (IOException e) {
                System.out.println("Klaida: " + e.getMessage());
            }
    }
}


